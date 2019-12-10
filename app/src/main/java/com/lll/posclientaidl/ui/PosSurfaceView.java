package com.lll.posclientaidl.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * TODO:describe what the class or interface does.
 * <p>
 * https://tech.youzan.com/surfaceview-sourcecode/ 参考
 *
 * @author runningDigua
 * @date 2019/12/4
 */
public class PosSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, Runnable {

    private SurfaceHolder mSurfaceHolder;

    private Canvas mCanvas;

    private Thread mThread;

    private boolean isFlag;

    public PosSurfaceView(Context context) {
        this(context, null);
    }

    public PosSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PosSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mSurfaceHolder = getHolder();
        mCanvas = mSurfaceHolder.lockCanvas();
        mSurfaceHolder.addCallback(this);

    }

    //Callback2
    @Override
    public void surfaceRedrawNeeded(SurfaceHolder holder) {

    }

    //Callback2
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // 处理surfaceView的回调
        mThread = new Thread(this);
        isFlag = true;
        mThread.start();
    }

    //Callback2
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    //Callback2
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isFlag = false;
        mSurfaceHolder.removeCallback(this);
    }

    //创建线程运行
    @Override
    public void run() {
        while (isFlag) {
            synchronized (mSurfaceHolder) {
                try {
                    //在线程中绘制
                    Thread.sleep(1000);
//                    mCanvas.drawPath();
                    //绘制完成，显示出来
                    mSurfaceHolder.unlockCanvasAndPost(mCanvas);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
