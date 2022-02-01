package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ShareResource;
import java.util.List;

class DanceScoreFilter$3
  implements Animation.AnimationListener
{
  DanceScoreFilter$3(DanceScoreFilter paramDanceScoreFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceScoreFilter.access$602(this.this$0, true);
    DanceScoreFilter.access$702(this.this$0, SystemClock.elapsedRealtime());
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    int i = ResourceManager.getInstance().getDancePostures().size() * 50;
    int j = this.this$0.mDanceManager.mGamePlayOutData.mScore;
    if (j < i * 0.2F)
    {
      DanceScoreFilter.access$400(this.this$0).setImageRes(DanceScoreFilter.access$300(this.this$0).mShareResource.levelC);
      DanceScoreFilter.access$502(this.this$0, "C");
      return;
    }
    if (j < i * 0.3F)
    {
      DanceScoreFilter.access$400(this.this$0).setImageRes(DanceScoreFilter.access$300(this.this$0).mShareResource.levelB);
      DanceScoreFilter.access$502(this.this$0, "B");
      return;
    }
    if (j < i * 0.4F)
    {
      DanceScoreFilter.access$400(this.this$0).setImageRes(DanceScoreFilter.access$300(this.this$0).mShareResource.levelA);
      DanceScoreFilter.access$502(this.this$0, "A");
      return;
    }
    DanceScoreFilter.access$400(this.this$0).setImageRes(DanceScoreFilter.access$300(this.this$0).mShareResource.levelS);
    DanceScoreFilter.access$502(this.this$0, "S");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceScoreFilter.3
 * JD-Core Version:    0.7.0.1
 */