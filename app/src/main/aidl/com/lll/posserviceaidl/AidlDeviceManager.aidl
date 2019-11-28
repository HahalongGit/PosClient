// AidlDeviceManager.aidl
package com.lll.posserviceaidl;

// Declare any non-default types here with import statements

interface AidlDeviceManager {
    /**
     *
     * getDevice
     * return IBinder
     */
    IBinder getDevice(int deviceType);

    /**
     * destoryDeivce
     *
     */
    void destoryDeivce(int deviceType);

    /**
     * destoryDeivce
     *
     */
    String getVersion();
}
