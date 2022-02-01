package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

public class CustomImgView
  extends FrameLayout
{
  public ImageView Hi;
  public ImageView Hj;
  
  public CustomImgView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CustomImgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CustomImgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.Hi = new URLImageView(getContext());
    this.Hi.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.Hi, localLayoutParams);
    this.Hj = new ImageView(getContext());
    this.Hj.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.Hj, localLayoutParams);
    this.Hj.setDuplicateParentStateEnabled(true);
  }
  
  public Drawable getDrawable()
  {
    return this.Hi.getDrawable();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.Hj.setImageDrawable(paramDrawable);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.Hi.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.Hi.setImageDrawable(paramDrawable);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    this.Hi.setScaleType(paramScaleType);
    this.Hj.setScaleType(paramScaleType);
  }
  
  public void setURLDrawableListener(URLDrawableDownListener paramURLDrawableDownListener)
  {
    if ((this.Hi != null) && ((this.Hi instanceof URLImageView))) {
      ((URLImageView)this.Hi).setURLDrawableDownListener(paramURLDrawableDownListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.CustomImgView
 * JD-Core Version:    0.7.0.1
 */