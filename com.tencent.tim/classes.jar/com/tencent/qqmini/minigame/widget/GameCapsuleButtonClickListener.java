package com.tencent.qqmini.minigame.widget;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.manager.GameCloseManager;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NavigateBackUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.ui.InternalMiniActivity;
import com.tencent.qqmini.sdk.widget.CapsuleButtonClickListener;

public class GameCapsuleButtonClickListener
  extends CapsuleButtonClickListener
{
  private static final String TAG = "GameCapsuleButton";
  
  public GameCapsuleButtonClickListener(IMiniAppContext paramIMiniAppContext)
  {
    super(paramIMiniAppContext);
  }
  
  private void doClose()
  {
    Object localObject = this.mMiniAppContext.getAttachedActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!(localObject instanceof InternalMiniActivity)) {
        break label132;
      }
      ((Activity)localObject).finish();
    }
    for (;;)
    {
      this.mMiniAppContext.performAction(AppStateEvent.obtain(60));
      if (this.mMiniAppContext.isMiniGame())
      {
        localObject = this.mMiniAppContext.getMiniAppInfo();
        if ((localObject != null) && (((MiniAppInfo)localObject).launchParam != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.fromMiniAppId))) {
          NavigateBackUtils.writeTagAppid(((MiniAppInfo)localObject).launchParam.fromMiniAppId);
        }
      }
      if (this.mMiniAppContext.getMiniAppInfo() != null) {
        ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(this.mMiniAppContext);
      }
      return;
      label132:
      int i = 0;
      try
      {
        boolean bool = ((Activity)localObject).moveTaskToBack(true);
        i = bool;
      }
      catch (Throwable localThrowable)
      {
        label142:
        break label142;
      }
      if (i == 0)
      {
        QMLog.e("GameCapsuleButton", "moveTaskToBack failed, finish the activity.");
        ((Activity)localObject).finish();
      }
    }
  }
  
  public void onCloseClick()
  {
    QMLog.i("GameCapsuleButton", "on close click");
    MiniLoadingAdManager.getInstance().preloadLoadingAd(this.mMiniAppContext.getContext(), this.mMiniAppContext.getMiniAppInfo());
    if ((!GameCloseManager.showAlertViewForBattleGame(this.mMiniAppContext, new GameCapsuleButtonClickListener.1(this))) && (!GameCloseManager.showPullDownGuideDialog(this.mMiniAppContext, new GameCapsuleButtonClickListener.2(this)))) {
      doClose();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.widget.GameCapsuleButtonClickListener
 * JD-Core Version:    0.7.0.1
 */