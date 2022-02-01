package com.tencent.qqmini.sdk.widget;

import android.app.Activity;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;

public class CapsuleButtonClickListener
  implements CapsuleButton.CapsuleBtnClickListener
{
  static final String TAG = "CapsuleButton";
  protected IMiniAppContext mMiniAppContext;
  protected ShareProxy mShareProxy;
  
  public CapsuleButtonClickListener(IMiniAppContext paramIMiniAppContext)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    this.mShareProxy = ((ShareProxy)ProxyManager.get(ShareProxy.class));
  }
  
  public void onCloseClick()
  {
    QMLog.i("CapsuleButton", "on close click");
    MiniLoadingAdManager.getInstance().preloadLoadingAd(this.mMiniAppContext.getContext(), this.mMiniAppContext.getMiniAppInfo());
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (!localActivity.moveTaskToBack(false))
      {
        QMLog.e("CapsuleButton", "moveTaskToBack failed, finish the activity.");
        localActivity.finish();
      }
      this.mMiniAppContext.performAction(AppStateEvent.obtain(60));
    }
    if (this.mMiniAppContext.getMiniAppInfo() != null) {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(this.mMiniAppContext);
    }
  }
  
  public void onMoreClick()
  {
    QMLog.i("CapsuleButton", "on more click");
    ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
    if (localShareState != null)
    {
      localShareState.launchFrom = 0;
      localShareState.stagingJsonParams = null;
    }
    this.mShareProxy.showSharePanel(this.mMiniAppContext);
    if (this.mMiniAppContext.getMiniAppInfo() != null) {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonMoreClick(this.mMiniAppContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.CapsuleButtonClickListener
 * JD-Core Version:    0.7.0.1
 */