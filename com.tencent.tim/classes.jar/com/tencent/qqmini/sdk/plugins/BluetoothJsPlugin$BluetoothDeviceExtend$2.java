package com.tencent.qqmini.sdk.plugins;

import android.bluetooth.BluetoothGatt;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class BluetoothJsPlugin$BluetoothDeviceExtend$2
  implements Runnable
{
  BluetoothJsPlugin$BluetoothDeviceExtend$2(BluetoothJsPlugin.BluetoothDeviceExtend paramBluetoothDeviceExtend, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (!this.this$1.gatt.discoverServices()) {
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BluetoothJsPlugin.BluetoothDeviceExtend.2
 * JD-Core Version:    0.7.0.1
 */