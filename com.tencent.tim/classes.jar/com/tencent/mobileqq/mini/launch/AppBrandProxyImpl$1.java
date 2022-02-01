package com.tencent.mobileqq.mini.launch;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class AppBrandProxyImpl$1
  implements ServiceConnection
{
  AppBrandProxyImpl$1(AppBrandProxyImpl paramAppBrandProxyImpl) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppBrandProxyImpl.access$002(this.this$0, IAppBrandService.Stub.asInterface(paramIBinder));
    QLog.w("miniapp-process_AppBrandProxy", 1, "onServiceConnected:" + AppBrandProxyImpl.access$000(this.this$0));
    AppBrandProxyImpl.access$102(this.this$0, false);
    AppBrandProxyImpl.access$200(this.this$0);
    AppBrandProxyImpl.access$300(this.this$0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppBrandProxyImpl.access$002(this.this$0, null);
    QLog.w("miniapp-process_AppBrandProxy", 1, "onServiceDisconnected.");
    AppBrandProxyImpl.access$102(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */