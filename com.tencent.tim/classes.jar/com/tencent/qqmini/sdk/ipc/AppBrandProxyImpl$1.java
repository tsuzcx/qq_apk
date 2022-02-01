package com.tencent.qqmini.sdk.ipc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class AppBrandProxyImpl$1
  implements Handler.Callback
{
  AppBrandProxyImpl$1(AppBrandProxyImpl paramAppBrandProxyImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage.getData().setClassLoader(AppBrandProxyImpl.access$000(this.this$0).getClassLoader());
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramMessage.getData().getParcelable("KEY_APPINFO");
    ResultReceiver localResultReceiver = (ResultReceiver)paramMessage.getData().getParcelable("receiver");
    AppBrandProxyImpl.access$100(this.this$0, i, paramMessage.getData(), localMiniAppInfo, localResultReceiver);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */