package com.tencent.biz.subscribe.other.story;

import com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView;

class StoryGameShotView$6
  implements Runnable
{
  StoryGameShotView$6(StoryGameShotView paramStoryGameShotView) {}
  
  public void run()
  {
    if (StoryGameShotView.e(this.this$0) != null)
    {
      this.this$0.c(StoryGameShotView.f(this.this$0));
      StoryGameShotView.b(this.this$0, null);
      if ((StoryGameShotView.a(this.this$0) instanceof GLTextureView)) {
        ((GLTextureView)StoryGameShotView.b(this.this$0)).onPause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.StoryGameShotView.6
 * JD-Core Version:    0.7.0.1
 */