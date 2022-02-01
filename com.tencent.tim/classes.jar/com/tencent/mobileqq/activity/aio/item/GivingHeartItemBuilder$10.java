package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationSet;
import com.tencent.qphone.base.util.QLog;
import xbu;
import xbw;

public class GivingHeartItemBuilder$10
  implements Runnable
{
  public GivingHeartItemBuilder$10(xbu paramxbu, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.C.isDestroyed())) || (this.C.isFinishing())) {
      return;
    }
    View localView = ((ViewGroup)this.C.getWindow().getDecorView()).getChildAt(0).findViewById(2131362332);
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "start to shake");
    }
    if (this.bgU) {}
    for (AnimationSet localAnimationSet = xbu.a(this.this$0, this.bgV);; localAnimationSet = xbu.a(this.this$0.mContext, this.bgV))
    {
      localAnimationSet.setAnimationListener(new xbw(this));
      if (localView == null) {
        break;
      }
      localView.startAnimation(localAnimationSet);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */