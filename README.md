# PosClient
pos机客户端aidl规范demo

### 采用Zxing 实现自定义扫码的功能
## 扫码实现原理 
* 1.视觉上处理
 <br/>扫码是如何实现的？自定义界面实现一个扫码框，添加扫码滑动动画，实现用户视觉上的扫码效果。

 <br/>
 
 **ScanBoxView类绘制扫码效果**
 
 ``` java
 
   @Override
    protected void onDraw(Canvas canvas) {
        if (mFramingRect == null) {
            return;
        }
        // 画遮罩层
        drawMask(canvas);
        // 画边框线
        drawBorderLine(canvas);

        // 画四个直角的线
        drawCornerLine(canvas);
        // 画扫描线
        drawScanLine(canvas);
        // 画提示文本
        drawTipText(canvas);
        // 移动扫描线的位置
        moveScanLine();
    }
```
 
* 2.逻辑上处理
<br/>调用相机Camera 来获取相机预览的数据，相机预览成功后再回调方法onPreviewFrame(byte[] data, Camera camera);
中返回data数据，这个就是预览的图片。有了这个数据需要对相机预览的结果进行解码，不同的厂商会实现不同的解码库，这个解码
库也是导致扫码快慢的原因。自己可以实现扫码的UI界面，绘制扫码View，最后调用Camera相机，采用第三方解码库的方式来实现扫码功能。
<br/>

**获取Camera 预览的数据然后处理**

``` java 
   @Override
    public void onPreviewFrame(byte[] data, Camera camera) {//Camera类回调
        try {
            Rect scanBoxRect = mScanBoxView.getScanBoxRect();
            int scanBoxSize = mScanBoxView.getScanBoxSizeExpand();
            int expandTop = mScanBoxView.getExpandTop();
            // 获取预览图大小
            Camera.Parameters parameters = mCamera.getParameters();
            Camera.Size size = parameters.getPreviewSize();
            int left;
            int top;
            int rowWidth = size.width;
            int rowHeight = size.height;

            /////////////////////////////
            if (iScanner != null) {
                try {
                    String result = iScanner.decode(data, rowWidth, rowHeight);// 第三方解码库解码
                    Log.e("TAG", "onPreviewFrame-decode-result:" + result);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            ///////////////////////////////
            ...... // 其他处理
    }
```

* 3.本demo的作用
<br/> 这个demo是在定义POS及规范的基础上了解扫码的实现原理，添加了Zxing的扫码和解码library.其中ScanBoxView类实现了扫码框View。
ScanView类和BarCoderView实现相机处理的逻辑，拿扫相机预览数据。最后调用解码库解码。解码库最终是采用C或者C++来实现的。
<br/> 如果在这个项目中直接运行查看扫码效果，需要解除czxing library依赖，同时修改ScanView

* 4.如果自己实现扫码界面，使用其他解码库写一个扫码功能，可参考ScanView、BarCoderView、ScanBoxView等几个类。和czxing这个library无关。
**_由于ScanView 类中引入了其解码的库，需要修改注释掉相关解码的类BarcodeReader_**

#### ScanView 构造方法中创建了 BarcodeReader 需要处理
 ``` java
 public ScanView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScanBoxView.setScanBoxClickListener(this);
        reader = BarcodeReader.getInstance(); // 解码相关
    }
``` 
### czxing 库中的一些处理
<br/>
czxing 库中采用openCV库对图片进行了初步的预处理，根据光线的明暗判断是否要打开闪关灯的开关，绘制闪关灯，在调用

``` java 
  // ScanView类中的调用
  
    @Override
    public void startScan() {
        reader.setReadCodeListener(this);
        super.startScan();
        reader.prepareRead();//调用底层C++的处理，比如判断灯光，从而设置isDark
        isStop = false;
    }
  // 调用 C++ 层
  public void prepareRead() {
        NativeSdk.getInstance().prepareRead(_nativePtr);
    }
``` 
``` C++
// jni 调用
  JNIEXPORT void JNICALL
Java_me_devilsen_czxing_code_NativeSdk_prepareRead(JNIEnv *env, jobject thiz, jlong objPtr) {
    auto imageScheduler = reinterpret_cast<ImageScheduler *>(objPtr);
    imageScheduler->prepare();
}

// JavaCallHelper 中获取 java代码方法 onBrightnessCallback() 
JavaCallHelper::JavaCallHelper(JavaVM *_javaVM, JNIEnv *_env, jobject &_jobj) : javaVM(_javaVM),
                                                                                env(_env) {
    jSdkObject = env->NewGlobalRef(_jobj);

    jclass jSdkClass = env->GetObjectClass(jSdkObject);
    if (jSdkClass == nullptr) {
        LOGE("Unable to find class");
        return;
    }

    jmid_on_result = env->GetMethodID(jSdkClass, "onDecodeCallback", "(Ljava/lang/String;I[F)V");
    jmid_on_focus = env->GetMethodID(jSdkClass, "onFocusCallback", "()V");
    jmid_on_brightness = env->GetMethodID(jSdkClass, "onBrightnessCallback", "(Z)V");// 获取java方法

    if (jmid_on_result == nullptr) {
        LOGE("jmid_on_result is null");
    }
}

// 最后调用到 ImageScheduler中处理亮度 isDark 
bool ImageScheduler::analysisBrightness(const Mat &gray) {
    LOGE("start analysisBrightness...");

    // 平均亮度
    Scalar scalar = mean(gray);
    cameraLight = scalar.val[0];
    LOGE("平均亮度 %lf", cameraLight);
    // 判断在时间范围 AMBIENT_BRIGHTNESS_WAIT_SCAN_TIME * lightSize 内是不是亮度过暗
    bool isDark = cameraLight < DEFAULT_MIN_LIGHT;
    javaCallHelper->onBrightness(isDark);// 调用方法

    return isDark;
}
 

 
