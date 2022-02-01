package com.tencent.qqmini.sdk.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppBrandProxyImpl$2
  implements ServiceConnection
{
  AppBrandProxyImpl$2(AppBrandProxyImpl paramAppBrandProxyImpl) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppBrandProxyImpl.access$202(this.this$0, IAppMainService.Stub.asInterface(paramIBinder));
    QMLog.w("minisdk-start_AppBrandProxy", "onServiceConnected:" + AppBrandProxyImpl.access$200(this.this$0));
    AppBrandProxyImpl.access$302(this.this$0, false);
    AppBrandProxyImpl.access$400(this.this$0);
    AppBrandProxyImpl.access$500(this.this$0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppBrandProxyImpl.access$202(this.this$0, null);
    QMLog.w("minisdk-start_AppBrandProxy", "onServiceDisconnected.");
    AppBrandProxyImpl.access$302(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */