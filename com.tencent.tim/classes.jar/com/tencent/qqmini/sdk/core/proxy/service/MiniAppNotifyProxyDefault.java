package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

@ProxyService(proxy=IMiniAppNotifyProxy.class)
public class MiniAppNotifyProxyDefault
  implements IMiniAppNotifyProxy
{
  public void report(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    QMLog.d("IMiniAppNotifyProxy", "appid:" + paramString1 + " scene:" + paramInt + " via:" + paramString2 + " event:" + paramString3 + " timestamp:" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MiniAppNotifyProxyDefault
 * JD-Core Version:    0.7.0.1
 */