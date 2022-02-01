package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.util.AttributeSet;
import anyo.a;

public class SpriteVideoView
  extends SpriteGLView
{
  public VideoSprite a;
  public int cpP;
  
  public SpriteVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(true);
  }
  
  public SpriteVideoView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 1);
    init(paramBoolean);
  }
  
  public void a(String paramString, int paramInt, anyo.a parama)
  {
    this.a.ga(paramString, paramInt);
    this.a.a(parama);
  }
  
  public void a(String paramString, anyo.a parama)
  {
    this.a.Go(paramString);
    this.a.a(parama);
  }
  
  protected void init(boolean paramBoolean)
  {
    this.a = new SpriteVideoView.1(this, this, getContext(), paramBoolean);
    this.a.isFullScreen = true;
    this.a.cKM = true;
    b(this.a);
  }
  
  public void setCenterCrop(boolean paramBoolean)
  {
    this.a.cKN = paramBoolean;
  }
  
  public void setFilePath(String paramString)
  {
    this.a.setFilePath(paramString);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.a.setLooping(paramBoolean);
  }
  
  public void setOnPlayedListener(VideoSprite.c paramc)
  {
    this.a.setOnPlayedListener(paramc);
  }
  
  public void setOnProgressChangedListener(VideoSprite.d paramd)
  {
    this.a.setOnProgressChangedListener(paramd);
  }
  
  public void stop()
  {
    this.a.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView
 * JD-Core Version:    0.7.0.1
 */