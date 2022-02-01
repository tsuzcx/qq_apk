package moai.view.moaiphoto;

import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.widget.ImageView;

public class DefaultOnDoubleTapListener
  implements GestureDetector.OnDoubleTapListener
{
  private PhotoViewAttacher photoViewAttacher;
  
  public DefaultOnDoubleTapListener(PhotoViewAttacher paramPhotoViewAttacher)
  {
    setPhotoViewAttacher(paramPhotoViewAttacher);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.photoViewAttacher == null) {
      return false;
    }
    try
    {
      float f1 = this.photoViewAttacher.getScale();
      float f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      if (f1 < 1.0F)
      {
        this.photoViewAttacher.setScale(1.0F, f2, f3, true);
        return true;
      }
      if (f1 < this.photoViewAttacher.getMediumScale())
      {
        this.photoViewAttacher.setScale(this.photoViewAttacher.getMediumScale(), f2, f3, true);
        return true;
      }
      if ((f1 >= this.photoViewAttacher.getMediumScale()) && (f1 < this.photoViewAttacher.getMaximumScale()))
      {
        this.photoViewAttacher.setScale(this.photoViewAttacher.getMaximumScale(), f2, f3, true);
        return true;
      }
      this.photoViewAttacher.setScale(1.0F, f2, f3, true);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent) {}
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.photoViewAttacher == null) {}
    ImageView localImageView;
    do
    {
      return false;
      localImageView = this.photoViewAttacher.getImageView();
      if (this.photoViewAttacher.getOnPhotoTapListener() != null)
      {
        RectF localRectF = this.photoViewAttacher.getDisplayRect();
        if (localRectF != null)
        {
          float f2 = paramMotionEvent.getX();
          float f1 = paramMotionEvent.getY();
          if (localRectF.contains(f2, f1))
          {
            f2 = (f2 - localRectF.left) / localRectF.width();
            f1 = (f1 - localRectF.top) / localRectF.height();
            this.photoViewAttacher.getOnPhotoTapListener().onPhotoTap(localImageView, f2, f1);
            return true;
          }
          this.photoViewAttacher.getOnPhotoTapListener().onOutsidePhotoTap();
        }
      }
    } while (this.photoViewAttacher.getOnViewTapListener() == null);
    this.photoViewAttacher.getOnViewTapListener().onViewTap(localImageView, paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
  
  public void setPhotoViewAttacher(PhotoViewAttacher paramPhotoViewAttacher)
  {
    this.photoViewAttacher = paramPhotoViewAttacher;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.DefaultOnDoubleTapListener
 * JD-Core Version:    0.7.0.1
 */