package com.tencent.biz.subscribe.other.story;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.View;
import anyo.a;
import apuo;
import axov;
import ayci;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.c;
import mqq.os.MqqHandler;
import sfi;
import sfj;

public class StoryGameShotView
  extends SpriteVideoView
  implements anyo.a, VideoSprite.c
{
  private AnimatorSet L;
  private ObjectAnimator aN;
  private boolean mIsSupportAlpha;
  private int mState;
  
  public StoryGameShotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void O(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    do
    {
      return;
      if ((this.HA instanceof GLSurfaceView))
      {
        ((GLSurfaceView)this.HA).queueEvent(paramRunnable);
        return;
      }
    } while (!(this.HA instanceof GLTextureView));
    ((GLTextureView)this.HA).queueEvent(paramRunnable);
  }
  
  public GLTextureView a(Context paramContext)
  {
    return new StoryGameShotView.1(this, paramContext);
  }
  
  public VideoSprite a()
  {
    StoryGameShotView.4 local4 = new StoryGameShotView.4(this, this, getContext(), this.mIsSupportAlpha);
    local4.setOnPlayedListener(this);
    local4.isFullScreen = true;
    local4.cKM = true;
    return local4;
  }
  
  public void a(String paramString, anyo.a parama)
  {
    if ((this.HA instanceof GLTextureView)) {
      ((GLTextureView)this.HA).onResume();
    }
    O(new StoryGameShotView.5(this, paramString, parama));
  }
  
  public void byj()
  {
    setState(2);
  }
  
  public void byk()
  {
    ThreadManager.getUIHandler().post(new StoryGameShotView.7(this));
  }
  
  public void init(boolean paramBoolean)
  {
    this.mIsSupportAlpha = paramBoolean;
  }
  
  public void reset()
  {
    if (this.mState == 0) {}
    do
    {
      do
      {
        do
        {
          return;
          setBackgroundResource(2130847685);
          setAlpha(1.0F);
          if (this.mState != 2) {
            break;
          }
        } while (this.L == null);
        this.L.cancel();
        return;
        if (this.mState != 3) {
          break;
        }
      } while (this.aN == null);
      this.aN.cancel();
      return;
    } while (this.mState != 1);
    stop();
  }
  
  public void setState(int paramInt)
  {
    if (this.mState == paramInt) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      reset();
      apuo.a(((ayci)axov.a(17)).a(), "story_game_new_shot.mp4", "https://pub.idqqimg.com/pc/misc/files/20181025/aaa4f23ab6714b13b2b3cfbdef609931.mp4", this, this);
      this.mState = paramInt;
      return;
    case 2: 
      reset();
      setBackgroundResource(2130847685);
      if (this.L == null)
      {
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.5F, 1.0F });
        localObjectAnimator.setDuration(1000L);
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localValueAnimator.setDuration(500L);
        this.L = new AnimatorSet();
        this.L.addListener(new sfi(this));
        this.L.playSequentially(new Animator[] { localObjectAnimator, localValueAnimator });
      }
      this.L.start();
      this.mState = paramInt;
      return;
    }
    reset();
    if (getAlpha() != 1.0F)
    {
      if (this.aN == null)
      {
        this.aN = ObjectAnimator.ofFloat(this, "alpha", new float[] { getAlpha(), 1.0F });
        this.aN.setDuration(200L);
        this.aN.addListener(new sfj(this));
      }
      this.aN.start();
      this.mState = paramInt;
      return;
    }
    this.mState = 0;
  }
  
  public void setVisibility(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      this.mState = 0;
      stop();
    }
  }
  
  public void stop()
  {
    O(new StoryGameShotView.6(this));
    this.HA.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.StoryGameShotView
 * JD-Core Version:    0.7.0.1
 */