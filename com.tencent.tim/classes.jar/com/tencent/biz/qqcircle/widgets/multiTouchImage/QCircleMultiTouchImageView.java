package com.tencent.biz.qqcircle.widgets.multiTouchImage;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;
import piz;
import pjb;
import pjc;
import pjd;
import pje;
import pjf;
import pjg;
import pjh;

public class QCircleMultiTouchImageView
  extends URLImageView
{
  private PhotoViewAttacher a;
  private ImageView.ScaleType b;
  
  public QCircleMultiTouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleMultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleMultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.a = new PhotoViewAttacher(this);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.b != null)
    {
      setScaleType(this.b);
      this.b = null;
    }
  }
  
  public void blg()
  {
    if (this.a != null) {
      this.a.update();
    }
  }
  
  public void blh()
  {
    if (this.a != null) {
      this.a.reset();
    }
  }
  
  public Matrix getImageMatrix()
  {
    return this.a.getImageMatrix();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.a.getScaleType();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.a.setAllowParentInterceptOnEdge(paramBoolean);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      this.a.update();
    }
    return bool;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.a != null) {
      this.a.update();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (this.a != null) {
      this.a.update();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.a != null) {
      this.a.update();
    }
  }
  
  public void setMaximumScale(float paramFloat)
  {
    this.a.setMaximumScale(paramFloat);
  }
  
  public void setMediumScale(float paramFloat)
  {
    this.a.setMediumScale(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat)
  {
    this.a.setMinimumScale(paramFloat);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnDoubleTabListener(piz parampiz)
  {
    this.a.setOnDoubleTabListener(parampiz);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.a.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.a.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(pjb parampjb)
  {
    this.a.setOnMatrixChangeListener(parampjb);
  }
  
  public void setOnOutsidePhotoTapListener(pjc parampjc)
  {
    this.a.setOnOutsidePhotoTapListener(parampjc);
  }
  
  public void setOnPhotoTapListener(pjd parampjd)
  {
    this.a.setOnPhotoTapListener(parampjd);
  }
  
  public void setOnScaleChangeListener(pje parampje)
  {
    this.a.setOnScaleChangeListener(parampje);
  }
  
  public void setOnSingleFlingListener(pjf parampjf)
  {
    this.a.setOnSingleFlingListener(parampjf);
  }
  
  public void setOnViewDragListener(pjg parampjg)
  {
    this.a.setOnViewDragListener(parampjg);
  }
  
  public void setOnViewTapListener(pjh parampjh)
  {
    this.a.setOnViewTapListener(parampjh);
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.a.setRotationBy(paramFloat);
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.a.setRotationTo(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.a.setScale(paramFloat);
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.a.setScale(paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }
  
  public void setScale(float paramFloat, boolean paramBoolean)
  {
    this.a.setScale(paramFloat, paramBoolean);
  }
  
  public void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a.setScaleLevels(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.a == null)
    {
      this.b = paramScaleType;
      return;
    }
    this.a.setScaleType(paramScaleType);
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.a.setZoomTransitionDuration(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.a.setZoomable(paramBoolean);
  }
  
  public boolean v(float paramFloat1, float paramFloat2)
  {
    if (this.a != null) {
      return this.a.w(paramFloat1, paramFloat2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.multiTouchImage.QCircleMultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */