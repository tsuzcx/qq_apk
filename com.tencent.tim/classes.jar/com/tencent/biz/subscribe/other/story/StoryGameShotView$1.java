package com.tencent.biz.subscribe.other.story;

import android.content.Context;
import com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView;

class StoryGameShotView$1
  extends GLTextureView
{
  StoryGameShotView$1(StoryGameShotView paramStoryGameShotView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setAlpha(float paramFloat)
  {
    if ((paramFloat == 1.0F) && (isPause())) {
      return;
    }
    super.setAlpha(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.StoryGameShotView.1
 * JD-Core Version:    0.7.0.1
 */