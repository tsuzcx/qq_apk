package com.tencent.av.widget.stageview;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import arih;
import jmj;
import jmk;

public class StageEffectView$5$1
  implements Runnable
{
  public StageEffectView$5$1(jmj paramjmj) {}
  
  public void run()
  {
    arih localarih = new arih(-90.0F, 0.0F, this.a.ik, this.a.il, 200.0F, false);
    localarih.setDuration(500L);
    localarih.setInterpolator(new DecelerateInterpolator());
    this.a.gZ.startAnimation(localarih);
    localarih.setAnimationListener(new jmk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.5.1
 * JD-Core Version:    0.7.0.1
 */