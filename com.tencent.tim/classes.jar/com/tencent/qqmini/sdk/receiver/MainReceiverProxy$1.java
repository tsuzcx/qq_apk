package com.tencent.qqmini.sdk.receiver;

import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader.OnAppRuntimeLoadListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class MainReceiverProxy$1
  implements BaseRuntimeLoader.OnAppRuntimeLoadListener
{
  MainReceiverProxy$1(MainReceiverProxy paramMainReceiverProxy, MiniAppInfo paramMiniAppInfo) {}
  
  public void onResult(int paramInt, String paramString, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    QMLog.w("minisdk-start", "预加载Runtime完成 " + this.val$appInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.receiver.MainReceiverProxy.1
 * JD-Core Version:    0.7.0.1
 */