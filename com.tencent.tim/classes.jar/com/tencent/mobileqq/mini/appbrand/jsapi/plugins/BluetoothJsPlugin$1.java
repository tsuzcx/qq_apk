package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.qphone.base.util.QLog;

class BluetoothJsPlugin$1
  implements MiniAppController.ActivityResultListener
{
  BluetoothJsPlugin$1(BluetoothJsPlugin paramBluetoothJsPlugin, String paramString, int paramInt) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    QLog.d("[mini] BluetoothJsPlugin", 2, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent);
    if (paramInt1 == 6)
    {
      BluetoothJsPlugin.access$202(this.this$0, false);
      if ((paramInt2 != -1) || (!BluetoothJsPlugin.access$300(this.this$0).isEnabled())) {
        break label121;
      }
      this.this$0.jsPluginEngine.callbackJsEventOK(this.this$0.jsPluginEngine.getServiceRuntime(), this.val$eventName, null, this.val$callbackId);
    }
    for (;;)
    {
      MiniAppController.getInstance().removeActivityResultListener(this);
      bool = true;
      return bool;
      label121:
      this.this$0.jsPluginEngine.callbackJsEventFail(this.this$0.jsPluginEngine.getServiceRuntime(), this.val$eventName, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BluetoothJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */