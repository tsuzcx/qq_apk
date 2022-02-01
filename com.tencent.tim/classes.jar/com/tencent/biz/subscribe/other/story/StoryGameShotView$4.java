package com.tencent.biz.subscribe.other.story;

import android.content.Context;
import anzc;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import java.io.File;

class StoryGameShotView$4
  extends VideoSprite
{
  StoryGameShotView$4(StoryGameShotView paramStoryGameShotView, SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramContext, paramBoolean);
  }
  
  public void eC(int paramInt1, int paramInt2)
  {
    if (StoryGameShotView.a(this.this$0) == 0) {
      StoryGameShotView.b(this.this$0, paramInt2);
    }
    super.eC(paramInt1, StoryGameShotView.b(this.this$0));
  }
  
  public String nw()
  {
    return anzc.D(this.b.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShaderVideoForStory.glsl");
  }
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.StoryGameShotView.4
 * JD-Core Version:    0.7.0.1
 */