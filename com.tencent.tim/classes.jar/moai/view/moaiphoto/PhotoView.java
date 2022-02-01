package moai.view.moaiphoto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class PhotoView
  extends ImageView
  implements IPhotoView
{
  private PhotoViewAttacher mAttacher;
  private ImageView.ScaleType mPendingScaleType;
  
  public PhotoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    init();
  }
  
  public boolean canZoom()
  {
    return this.mAttacher.canZoom();
  }
  
  public void getDisplayMatrix(Matrix paramMatrix)
  {
    this.mAttacher.getDisplayMatrix(paramMatrix);
  }
  
  public RectF getDisplayRect()
  {
    return this.mAttacher.getDisplayRect();
  }
  
  public IPhotoView getIPhotoViewImplementation()
  {
    return this.mAttacher;
  }
  
  public Matrix getImageMatrix()
  {
    return this.mAttacher.getImageMatrix();
  }
  
  public float getMaximumScale()
  {
    return this.mAttacher.getMaximumScale();
  }
  
  public float getMediumScale()
  {
    return this.mAttacher.getMediumScale();
  }
  
  public float getMinimumScale()
  {
    return this.mAttacher.getMinimumScale();
  }
  
  public float getScale()
  {
    return this.mAttacher.getScale();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.mAttacher.getScaleType();
  }
  
  public Bitmap getVisibleRectangleBitmap()
  {
    return this.mAttacher.getVisibleRectangleBitmap();
  }
  
  protected void init()
  {
    if ((this.mAttacher == null) || (this.mAttacher.getImageView() == null)) {
      this.mAttacher = new PhotoViewAttacher(this);
    }
    if (this.mPendingScaleType != null)
    {
      setScaleType(this.mPendingScaleType);
      this.mPendingScaleType = null;
    }
  }
  
  protected void onAttachedToWindow()
  {
    init();
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    this.mAttacher.cleanup();
    this.mAttacher = null;
    super.onDetachedFromWindow();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.mAttacher.setAllowParentInterceptOnEdge(paramBoolean);
  }
  
  public boolean setDisplayMatrix(Matrix paramMatrix)
  {
    return this.mAttacher.setDisplayMatrix(paramMatrix);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mAttacher != null) && (bool)) {
      this.mAttacher.update();
    }
    return bool;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.mAttacher != null) {
      this.mAttacher.update();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (this.mAttacher != null) {
      this.mAttacher.update();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.mAttacher != null) {
      this.mAttacher.update();
    }
  }
  
  public void setMaximumScale(float paramFloat)
  {
    this.mAttacher.setMaximumScale(paramFloat);
  }
  
  public void setMediumScale(float paramFloat)
  {
    this.mAttacher.setMediumScale(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat)
  {
    this.mAttacher.setMinimumScale(paramFloat);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.mAttacher.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.mAttacher.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener paramOnMatrixChangedListener)
  {
    this.mAttacher.setOnMatrixChangeListener(paramOnMatrixChangedListener);
  }
  
  public void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener paramOnPhotoTapListener)
  {
    this.mAttacher.setOnPhotoTapListener(paramOnPhotoTapListener);
  }
  
  public void setOnScaleChangeListener(PhotoViewAttacher.OnScaleChangeListener paramOnScaleChangeListener)
  {
    this.mAttacher.setOnScaleChangeListener(paramOnScaleChangeListener);
  }
  
  public void setOnSingleFlingListener(PhotoViewAttacher.OnSingleFlingListener paramOnSingleFlingListener)
  {
    this.mAttacher.setOnSingleFlingListener(paramOnSingleFlingListener);
  }
  
  public void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener paramOnViewTapListener)
  {
    this.mAttacher.setOnViewTapListener(paramOnViewTapListener);
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.mAttacher.setRotationBy(paramFloat);
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.mAttacher.setRotationTo(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.mAttacher.setScale(paramFloat);
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.mAttacher.setScale(paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }
  
  public void setScale(float paramFloat, boolean paramBoolean)
  {
    this.mAttacher.setScale(paramFloat, paramBoolean);
  }
  
  public void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mAttacher.setScaleLevels(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.mAttacher != null)
    {
      this.mAttacher.setScaleType(paramScaleType);
      return;
    }
    this.mPendingScaleType = paramScaleType;
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.mAttacher.setZoomTransitionDuration(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.mAttacher.setZoomable(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.PhotoView
 * JD-Core Version:    0.7.0.1
 */