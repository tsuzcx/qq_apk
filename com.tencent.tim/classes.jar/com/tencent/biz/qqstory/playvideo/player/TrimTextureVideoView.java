package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Build;
import android.util.AttributeSet;
import qlm;
import qmc;
import qmc.f;
import ram;
import rex;

public class TrimTextureVideoView
  extends TextureVideoView
  implements MediaPlayer.OnSeekCompleteListener, qmc.f
{
  public static int bmZ;
  private a jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView$a;
  private qmc.f jdField_a_of_type_Qmc$f;
  protected boolean aDZ = true;
  protected boolean aEa = true;
  protected int bna;
  protected int bnb;
  protected int bnc;
  protected int bnd;
  protected Runnable ds = new TrimTextureVideoView.1(this);
  protected Runnable dt = new TrimTextureVideoView.2(this);
  protected boolean mAttached;
  protected int mCurrentPosition;
  protected int mEndTime;
  protected int mLastCurrentPosition;
  protected boolean mMuteAudio;
  public int mSeq;
  protected int mStartTime;
  
  public TrimTextureVideoView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void boQ()
  {
    if (Build.MODEL.toUpperCase().equals("PIXEL 2 XL")) {
      this.aEa = false;
    }
  }
  
  private void init()
  {
    int i = bmZ + 1;
    bmZ = i;
    this.mSeq = i;
    setOnErrorListener(new qlm(this));
    boQ();
    super.setOnSeekCompleteListener(this);
  }
  
  protected qmc a()
  {
    if (this.aEa) {
      return new com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer();
    }
    return super.a();
  }
  
  @TargetApi(14)
  public void boR()
  {
    if (this.mEndTime != 0)
    {
      removeCallbacks(this.dt);
      postDelayed(this.dt, this.mEndTime - this.mStartTime);
    }
  }
  
  public void c(qmc paramqmc)
  {
    this.aDZ = true;
    if ((this.mStartTime != 0) && (this.mEndTime != 0))
    {
      int i = super.getCurrentPosition();
      if (i < this.mEndTime)
      {
        ram.b(this.TAG, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.mStartTime), Integer.valueOf(i));
        this.bna = i;
      }
    }
    if (this.jdField_a_of_type_Qmc$f != null) {
      this.jdField_a_of_type_Qmc$f.c(paramqmc);
    }
    boR();
  }
  
  public int getStartTime()
  {
    return this.mStartTime;
  }
  
  @TargetApi(14)
  public boolean i(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.aEa) && (com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.JZ())) {}
    for (int i = 0 + paramInt1;; i = 0)
    {
      float f1;
      float f2;
      if (((paramInt1 % 180 > 0) && (paramInt2 < paramInt3)) || ((paramInt1 % 180 == 0) && (paramInt2 > paramInt3)))
      {
        setRotation(i + 90);
        f1 = 1.0F / rex.a(getResources());
        f2 = Math.min(paramInt3, paramInt2) * 1.0F / Math.max(paramInt3, paramInt2);
        setScaleX(Math.max(f1, f2));
        setScaleY(Math.max(f1, f2));
        ram.a(this.TAG, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
        return true;
      }
      if (i != 0)
      {
        setRotation(i);
        f1 = 1.0F / rex.a(getResources());
        f2 = Math.min(paramInt3, paramInt2) * 1.0F / Math.max(paramInt3, paramInt2);
        setScaleX(Math.max(f1, f2));
        setScaleY(Math.max(f1, f2));
        ram.a(this.TAG, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate! but return false", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
        return false;
      }
      ram.a(this.TAG, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return false;
    }
  }
  
  @TargetApi(14)
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mAttached = true;
    ram.b(this.TAG, "[%d]onAttachedToWindow! schedule!", Integer.valueOf(this.mSeq));
    post(this.ds);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mAttached = false;
    ram.b(this.TAG, "[%d]onDetachedFromWindow! cancel schedule!", Integer.valueOf(this.mSeq));
    removeCallbacks(this.ds);
  }
  
  @Deprecated
  public void onSeekComplete(android.media.MediaPlayer paramMediaPlayer)
  {
    if ((this.mStartTime != 0) && (this.mEndTime != 0))
    {
      int i = super.getCurrentPosition();
      if (i < this.mEndTime)
      {
        ram.b(this.TAG, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.mStartTime), Integer.valueOf(i));
        this.bna = i;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ram.a(this.TAG, "onSizeChanged(%d, %d, %d, %d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4));
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    sK(this.mMuteAudio);
  }
  
  @TargetApi(14)
  public void pausePlay()
  {
    ram.b(this.TAG, "[%d]pausePlay()", Integer.valueOf(this.mSeq));
    this.mCurrentPosition = super.getCurrentPosition();
    removeCallbacks(this.dt);
    super.pause();
  }
  
  public int sJ()
  {
    return this.bna;
  }
  
  public void sJ(boolean paramBoolean)
  {
    ram.b(this.TAG, "[%d]resumePlay(%b)", Integer.valueOf(this.mSeq), Boolean.valueOf(paramBoolean));
    if ((paramBoolean) || (!super.isPlaying()))
    {
      this.mCurrentPosition = this.mStartTime;
      super.seekTo(this.mCurrentPosition);
      this.aDZ = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView$a != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView$a.boS();
      }
    }
    super.start();
  }
  
  public int sK()
  {
    return this.mEndTime;
  }
  
  public void sK(boolean paramBoolean)
  {
    this.mMuteAudio = paramBoolean;
    if (this.jdField_a_of_type_Qmc == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qmc.setVolume(0.0F, 0.0F);
      return;
    }
    this.jdField_a_of_type_Qmc.setVolume(1.0F, 1.0F);
  }
  
  public void setOnRecyclePlayListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView$a = parama;
  }
  
  public void setOnSeekCompleteListener(qmc.f paramf)
  {
    this.jdField_a_of_type_Qmc$f = paramf;
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    int j = getDuration();
    int k = Math.max(paramInt2 - paramInt1, 1000);
    int i = paramInt1;
    paramInt1 = paramInt2;
    if (paramInt2 > j)
    {
      i = j - k;
      paramInt1 = j;
    }
    ram.a(this.TAG, "[%d]setPlayRange(%d, %d)", Integer.valueOf(this.mSeq), Integer.valueOf(i), Integer.valueOf(paramInt1));
    if ((isPlaying()) && ((i != this.mStartTime) || (paramInt1 != this.mEndTime)))
    {
      super.seekTo(this.mStartTime);
      this.aDZ = false;
    }
    this.mStartTime = i;
    this.bna = i;
    this.mEndTime = paramInt1;
  }
  
  public void stopPlay()
  {
    this.mAttached = false;
    removeCallbacks(this.ds);
    removeCallbacks(this.dt);
    ram.b(this.TAG, "[%d]stopPlay! cancel schedule!", Integer.valueOf(this.mSeq));
  }
  
  public void stopPlayback()
  {
    ram.b(this.TAG, "[%d]stopPlayback()", Integer.valueOf(this.mSeq));
    super.stopPlayback();
  }
  
  public static abstract interface a
  {
    public abstract void boS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView
 * JD-Core Version:    0.7.0.1
 */