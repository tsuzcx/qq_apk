package com.tencent.qqmail.utilities.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMAdvertiseView;

final class AdvertiseAnimUtil$1
  extends AnimatorListenerAdapter
{
  AdvertiseAnimUtil$1(PtrListView paramPtrListView, QMAdvertiseView paramQMAdvertiseView, Activity paramActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    AdvertiseAnimUtil.duringAnimation = false;
    this.val$contentView.setEnabled(true);
    AdvertiseAnimUtil.advertiseViewForeground = true;
    JSApiUitil.excuteJavaScript(this.val$advertiseView.getWebView(), JSApiUitil.handleStartAnimation());
    this.val$contentView.ariseUpListViewContent();
    QMUIKit.disableOrientationChange(this.val$activity);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    AdvertiseAnimUtil.duringAnimation = true;
    this.val$contentView.setEnabled(false);
    this.val$advertiseView.reloadHtml();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil.1
 * JD-Core Version:    0.7.0.1
 */