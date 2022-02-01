package com.tencent.qqmail.view;

import android.widget.ImageView;
import com.nineoldandroids.animation.Animator;

class WaveViewHolder$2
  extends WaveViewHolder.AnimatorAdapter
{
  WaveViewHolder$2(WaveViewHolder paramWaveViewHolder)
  {
    super(paramWaveViewHolder);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WaveViewHolder.access$100(this.this$0);
    if (WaveViewHolder.access$200(this.this$0) != null) {
      WaveViewHolder.access$200(this.this$0).onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.waveView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.WaveViewHolder.2
 * JD-Core Version:    0.7.0.1
 */