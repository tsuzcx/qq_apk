package com.tencent.mobileqq.mini.push;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;

public class ClearCacheAction
  implements PushAction
{
  public static final String KEY_APPID = "appid";
  public static final String TAG = "ClearCacheAction";
  
  public void exec(MiniAppControlInfo paramMiniAppControlInfo)
  {
    if (paramMiniAppControlInfo.data.containsKey("appid"))
    {
      paramMiniAppControlInfo = (String)paramMiniAppControlInfo.data.get("appid");
      QLog.d("ClearCacheAction", 1, "ClearCacheAction: appid:" + paramMiniAppControlInfo);
      MiniCacheFreeManager.freeCache(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramMiniAppControlInfo, true, new ClearCacheAction.1(this, paramMiniAppControlInfo));
      return;
    }
    QLog.d("ClearCacheAction", 1, "ClearCacheAction:");
    MiniCacheFreeManager.freeCache(true, new ClearCacheAction.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.ClearCacheAction
 * JD-Core Version:    0.7.0.1
 */