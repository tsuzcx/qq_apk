package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationSet;

class UnlimitedBladeWorks$6
  implements Runnable
{
  UnlimitedBladeWorks$6(UnlimitedBladeWorks paramUnlimitedBladeWorks, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.C.isDestroyed())) || (this.C.isFinishing())) {}
    View localView;
    AnimationSet localAnimationSet;
    do
    {
      return;
      localView = ((ViewGroup)this.C.getWindow().getDecorView()).getChildAt(0).findViewById(2131362332);
      localAnimationSet = UnlimitedBladeWorks.a(this.this$0, this.bWu);
    } while (localView == null);
    localView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.6
 * JD-Core Version:    0.7.0.1
 */