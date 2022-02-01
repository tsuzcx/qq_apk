package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.utils.QUAUtil;

@MiniKeep
public class GetShareState
  implements Action<ShareState>
{
  public static ShareState obtain(IMiniAppContext paramIMiniAppContext)
  {
    if (paramIMiniAppContext == null) {
      return null;
    }
    ShareState localShareState = (ShareState)paramIMiniAppContext.performAction(new GetShareState());
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    if (((localMiniAppInfo != null) && (localMiniAppInfo.verType != 3)) || (QUAUtil.isDemoApp()))
    {
      localShareState.showDebug = true;
      localShareState.showMonitor = true;
    }
    if (shouldHideWechatChannels())
    {
      localShareState.withShareWeChatFriend = false;
      localShareState.withShareWeChatMoment = false;
    }
    if (shouldHideQzoneChannel()) {
      localShareState.withShareQzone = false;
    }
    if ((localMiniAppInfo != null) && (localMiniAppInfo.isSpecialMiniApp()))
    {
      localShareState.withShareQQ = false;
      localShareState.withShareQzone = false;
      localShareState.withShareWeChatFriend = false;
      localShareState.withShareWeChatMoment = false;
      localShareState.withShareOthers = false;
    }
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp())) {
      localShareState.isShareInMiniProcess = true;
    }
    localShareState.isOrientationLandscape = paramIMiniAppContext.isOrientationLandscape();
    return localShareState;
  }
  
  private static boolean shouldHideQzoneChannel()
  {
    return (QUAUtil.isQQSpeedApp()) || (QUAUtil.isTimApp());
  }
  
  private static boolean shouldHideWechatChannels()
  {
    if (WnsConfig.getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1) {}
    while (QUAUtil.isQQSpeedApp()) {
      return true;
    }
    return false;
  }
  
  public ShareState perform(BaseRuntime paramBaseRuntime)
  {
    return paramBaseRuntime.getShareState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.GetShareState
 * JD-Core Version:    0.7.0.1
 */