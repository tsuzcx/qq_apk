package com.tencent.mobileqq.trooppiceffects.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import aptj;
import apzb;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;

public class VideoPicView
  extends FrameLayout
  implements apzb
{
  protected SpriteVideoView d;
  protected ImageView mImageView;
  protected String mPath;
  
  public VideoPicView(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, -1, -1);
  }
  
  public VideoPicView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.mPath = aptj.fN(paramInt1);
    this.mImageView = new ImageView(getContext());
    this.d = new SpriteVideoView(getContext(), true);
    this.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.d.setLooping(true);
    addView(this.mImageView, -1, -1);
    addView(this.d, paramInt2, paramInt3);
  }
  
  public View getView()
  {
    return this;
  }
  
  public void onDestroy()
  {
    this.d.dTU();
  }
  
  public void play()
  {
    this.d.a(this.mPath, null);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.VideoPicView
 * JD-Core Version:    0.7.0.1
 */