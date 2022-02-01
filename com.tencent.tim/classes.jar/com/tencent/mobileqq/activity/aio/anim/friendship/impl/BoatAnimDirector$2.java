package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import woa;

public class BoatAnimDirector$2
  implements Runnable
{
  public BoatAnimDirector$2(woa paramwoa) {}
  
  public void run()
  {
    if (this.this$0.so != null)
    {
      this.this$0.so.setBackgroundColor(-1442840576);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(300L);
      this.this$0.so.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.BoatAnimDirector.2
 * JD-Core Version:    0.7.0.1
 */