package moai.view.moaiphoto;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;

public abstract interface IPhotoView
{
  public static final float DEFAULT_MAX_SCALE = 3.0F;
  public static final float DEFAULT_MID_SCALE = 1.75F;
  public static final float DEFAULT_MIN_SCALE = 0.6F;
  public static final float DEFAULT_RESET_SCALE = 1.0F;
  public static final int DEFAULT_ZOOM_DURATION = 200;
  
  public abstract boolean canZoom();
  
  public abstract void getDisplayMatrix(Matrix paramMatrix);
  
  public abstract RectF getDisplayRect();
  
  public abstract IPhotoView getIPhotoViewImplementation();
  
  public abstract float getMaximumScale();
  
  public abstract float getMediumScale();
  
  public abstract float getMinimumScale();
  
  public abstract float getScale();
  
  public abstract ImageView.ScaleType getScaleType();
  
  public abstract Bitmap getVisibleRectangleBitmap();
  
  public abstract void setAllowParentInterceptOnEdge(boolean paramBoolean);
  
  public abstract boolean setDisplayMatrix(Matrix paramMatrix);
  
  public abstract void setMaximumScale(float paramFloat);
  
  public abstract void setMediumScale(float paramFloat);
  
  public abstract void setMinimumScale(float paramFloat);
  
  public abstract void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener);
  
  public abstract void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener);
  
  public abstract void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener paramOnMatrixChangedListener);
  
  public abstract void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener paramOnPhotoTapListener);
  
  public abstract void setOnScaleChangeListener(PhotoViewAttacher.OnScaleChangeListener paramOnScaleChangeListener);
  
  public abstract void setOnSingleFlingListener(PhotoViewAttacher.OnSingleFlingListener paramOnSingleFlingListener);
  
  public abstract void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener paramOnViewTapListener);
  
  public abstract void setRotationBy(float paramFloat);
  
  public abstract void setRotationTo(float paramFloat);
  
  public abstract void setScale(float paramFloat);
  
  public abstract void setScale(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean);
  
  public abstract void setScale(float paramFloat, boolean paramBoolean);
  
  public abstract void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void setScaleType(ImageView.ScaleType paramScaleType);
  
  public abstract void setZoomTransitionDuration(int paramInt);
  
  public abstract void setZoomable(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.IPhotoView
 * JD-Core Version:    0.7.0.1
 */