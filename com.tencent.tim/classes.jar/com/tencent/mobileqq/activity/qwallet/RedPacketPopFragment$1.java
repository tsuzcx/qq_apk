package com.tencent.mobileqq.activity.qwallet;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.OvershootInterpolator;

class RedPacketPopFragment$1
  implements Runnable
{
  RedPacketPopFragment$1(RedPacketPopFragment paramRedPacketPopFragment) {}
  
  public void run()
  {
    this.this$0.za.setAlpha(0.3F);
    this.this$0.za.animate().alpha(1.0F).setDuration(200L);
    this.this$0.zb.setAlpha(0.3F);
    this.this$0.zb.setVisibility(0);
    this.this$0.zb.setPivotX(this.this$0.zb.getWidth() / 2);
    this.this$0.zb.setPivotY(this.this$0.zb.getHeight() / 2);
    this.this$0.zb.setScaleX(0.5F);
    this.this$0.zb.setScaleY(0.5F);
    this.this$0.zb.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(300L).setInterpolator(new OvershootInterpolator(1.6F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketPopFragment.1
 * JD-Core Version:    0.7.0.1
 */