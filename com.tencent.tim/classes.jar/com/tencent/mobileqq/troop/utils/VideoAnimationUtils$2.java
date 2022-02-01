package com.tencent.mobileqq.troop.utils;

import anyo.a;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;

public final class VideoAnimationUtils$2
  implements Runnable
{
  public VideoAnimationUtils$2(WeakReference paramWeakReference, String paramString, anyo.a parama) {}
  
  public void run()
  {
    SpriteVideoView localSpriteVideoView = (SpriteVideoView)this.ik.get();
    if (localSpriteVideoView != null) {
      localSpriteVideoView.a(this.aTM, this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2
 * JD-Core Version:    0.7.0.1
 */