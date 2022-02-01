package com.tencent.mobileqq.ocr.view.gesture.animation;

import akpb;
import android.os.Build.VERSION;
import android.view.View;

public abstract class AnimationEngine
  implements Runnable
{
  private final akpb a;
  private final View view;
  
  public AnimationEngine(View paramView)
  {
    this.view = paramView;
    if (akpb.ass()) {}
    for (paramView = new akpb();; paramView = null)
    {
      this.a = paramView;
      return;
    }
  }
  
  private void dCx()
  {
    this.view.removeCallbacks(this);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.view.postOnAnimationDelayed(this, 10L);
      return;
    }
    this.view.postDelayed(this, 10L);
  }
  
  public abstract boolean Aj();
  
  public final void run()
  {
    boolean bool = Aj();
    if (this.a != null)
    {
      this.a.dCy();
      if (!bool) {
        this.a.stop();
      }
    }
    if (bool) {
      dCx();
    }
  }
  
  public void start(int paramInt)
  {
    if (this.a != null) {
      this.a.start(paramInt);
    }
    dCx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine
 * JD-Core Version:    0.7.0.1
 */