package com.tencent.qqmail.utilities.animation;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMAdvertiseView;
import com.tencent.qqmail.view.QMBaseView;

final class AdvertiseAnimUtil$2
  implements Animation.AnimationListener
{
  AdvertiseAnimUtil$2(PtrListView paramPtrListView, QMAdvertiseView paramQMAdvertiseView, QMBaseView paramQMBaseView, Activity paramActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$advertiseView.clearAnimation();
    this.val$advertiseView.setVisibility(8);
    AdvertiseAnimUtil.duringAnimation = false;
    this.val$contentView.setEnabled(true);
    this.val$baseView.destroyAdvertiseViewInFuture();
    QMUIKit.enableOrientationChange(this.val$activity);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AdvertiseAnimUtil.duringAnimation = true;
    this.val$contentView.setEnabled(false);
    AdvertiseAnimUtil.advertiseViewForeground = false;
    this.val$contentView.ariseUpListViewContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil.2
 * JD-Core Version:    0.7.0.1
 */