package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import woc;
import wpa;

public class FriendShipAnimDirector$4
  implements Runnable
{
  public FriendShipAnimDirector$4(woc paramwoc) {}
  
  public void run()
  {
    if (woc.a(this.this$0) != null) {
      woc.a(this.this$0).xz(woc.a(this.this$0) + "icon_close.png");
    }
    if ((woc.a(this.this$0) == null) || (woc.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.setVisibility(0);
      woc.a(this.this$0, new ImageView(this.this$0.m()));
      woc.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.m());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(woc.a(this.this$0), localLayoutParams);
      woc.a(this.this$0).setImageDrawable(woc.a(this.this$0));
      woc.a(this.this$0).eV(localView);
      woc.a(this.this$0).a(localFriendShipLayout);
    }
    if (woc.a(this.this$0).isAnimating()) {
      woc.a(this.this$0).cancelAnimation();
    }
    if (woc.a(this.this$0).isAnimating()) {
      woc.a(this.this$0).cancelAnimation();
    }
    woc.a(this.this$0).playAnimation();
    woc.a(this.this$0).playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector.4
 * JD-Core Version:    0.7.0.1
 */