package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import wog;
import wpc;

public class LottieAnimDirector$5
  implements Runnable
{
  public LottieAnimDirector$5(wog paramwog) {}
  
  public void run()
  {
    if (wog.a(this.this$0) != null) {
      wog.a(this.this$0).xz(wog.a(this.this$0) + "icon_close.png");
    }
    if ((wog.a(this.this$0) == null) || (wog.a(this.this$0).isAnimating())) {
      return;
    }
    FriendShipLayout localFriendShipLayout = this.this$0.a();
    if (localFriendShipLayout != null)
    {
      if (localFriendShipLayout.getChildCount() > 0) {
        localFriendShipLayout.removeAllViews();
      }
      this.this$0.setVisibility(0);
      wog.a(this.this$0, new ImageView(this.this$0.m()));
      wog.a(this.this$0).setScaleType(ImageView.ScaleType.CENTER_CROP);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 81;
      View localView = new View(this.this$0.m());
      localView.setBackgroundColor(-16777216);
      localFriendShipLayout.addView(localView, localLayoutParams);
      localFriendShipLayout.addView(wog.a(this.this$0), localLayoutParams);
      wog.a(this.this$0).setImageDrawable(wog.a(this.this$0));
      wog.a(this.this$0).eV(localView);
      wog.a(this.this$0).a(localFriendShipLayout);
    }
    if (wog.a(this.this$0).isAnimating()) {
      wog.a(this.this$0).cancelAnimation();
    }
    if (wog.a(this.this$0).isAnimating()) {
      wog.a(this.this$0).cancelAnimation();
    }
    wog.a(this.this$0).playAnimation();
    wog.a(this.this$0).playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5
 * JD-Core Version:    0.7.0.1
 */