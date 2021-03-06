package com.tencent.mobileqq.vpng.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import aqxw;
import aqxx;
import aqxz;
import aqya;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.io.File;

public class VPNGImageView
  extends FrameLayout
  implements TextureView.SurfaceTextureListener, aqxw
{
  protected int mAlign = 1;
  protected LiveRoomGiftCallback mCallback;
  protected int mHeight;
  protected boolean mIsLoop;
  protected ImageView mPreImageView;
  protected TextureView mTextureView;
  protected aqxx mVPNGRenderer;
  protected String mVideoPath;
  protected int mWidth;
  
  public VPNGImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VPNGImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mTextureView = new TextureView(getContext());
    this.mPreImageView = new ImageView(getContext());
    addView(this.mTextureView, -1, -1);
    addView(this.mPreImageView, -1, -1);
  }
  
  public int getRenderHeight()
  {
    return this.mHeight;
  }
  
  public int getRenderWidth()
  {
    return this.mWidth;
  }
  
  public aqxx getVPNGRenderer()
  {
    return this.mVPNGRenderer;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mVPNGRenderer != null)
    {
      aqxz.a().a(this.mVPNGRenderer);
      this.mVPNGRenderer = null;
    }
  }
  
  public void onDrawBegin()
  {
    post(new VPNGImageView.1(this));
  }
  
  public void onPause()
  {
    if (this.mVPNGRenderer != null) {
      this.mVPNGRenderer.pauseVideo();
    }
  }
  
  public void onRelease()
  {
    if (this.mVPNGRenderer != null) {
      this.mVPNGRenderer.release();
    }
  }
  
  public void onResume()
  {
    if (this.mVPNGRenderer != null) {
      this.mVPNGRenderer.resumeVideo();
    }
  }
  
  public void onSetRenderer(aqxx paramaqxx)
  {
    this.mVPNGRenderer = paramaqxx;
    if ((isActivated()) && (getVisibility() == 0))
    {
      this.mVPNGRenderer.bAH();
      this.mVPNGRenderer.play();
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.mVPNGRenderer == null)
    {
      this.mVPNGRenderer = aqxz.a().a(this, this.mWidth, this.mHeight);
      if (this.mVPNGRenderer != null)
      {
        this.mVPNGRenderer.a(this.mVideoPath, this.mAlign, this.mCallback);
        this.mVPNGRenderer.setLooping(this.mIsLoop);
      }
    }
    if (this.mVPNGRenderer != null)
    {
      this.mVPNGRenderer.kr(paramInt1, paramInt2);
      this.mVPNGRenderer.f(paramSurfaceTexture);
      this.mVPNGRenderer.play();
    }
    this.mTextureView.setAlpha(0.0F);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mVPNGRenderer.stopRender();
    if (this.mCallback != null) {
      this.mCallback.onCall(9, "");
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mVPNGRenderer.kr(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setImage(String paramString, BitmapFactory.Options paramOptions)
  {
    paramOptions = BitmapFactory.decodeFile(paramString, paramOptions).copy(Bitmap.Config.ARGB_8888, true);
    this.mWidth = paramOptions.getWidth();
    this.mHeight = paramOptions.getHeight();
    String str = paramString + ".vpng";
    if ((!new File(str).exists()) && (aqya.ca(paramString, str))) {
      setVideo(str, true);
    }
    this.mPreImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mPreImageView.setImageBitmap(paramOptions);
    this.mPreImageView.setVisibility(0);
  }
  
  public void setVideo(String paramString, boolean paramBoolean)
  {
    setVideo(paramString, paramBoolean, 0, null);
  }
  
  public void setVideo(String paramString, boolean paramBoolean, int paramInt, LiveRoomGiftCallback paramLiveRoomGiftCallback)
  {
    if (this.mVPNGRenderer != null) {}
    for (int i = 1;; i = 0)
    {
      if (this.mVPNGRenderer == null) {
        this.mVPNGRenderer = aqxz.a().a(this, this.mWidth, this.mHeight);
      }
      if (this.mVPNGRenderer != null)
      {
        this.mVPNGRenderer.a(paramString, paramInt, paramLiveRoomGiftCallback);
        this.mVPNGRenderer.setLooping(paramBoolean);
        if (i != 0)
        {
          this.mVPNGRenderer.setRefresh(true);
          this.mVPNGRenderer.play();
        }
      }
      this.mVideoPath = paramString;
      this.mIsLoop = paramBoolean;
      this.mAlign = paramInt;
      this.mCallback = paramLiveRoomGiftCallback;
      this.mTextureView.setOpaque(false);
      this.mTextureView.setSurfaceTextureListener(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.view.VPNGImageView
 * JD-Core Version:    0.7.0.1
 */