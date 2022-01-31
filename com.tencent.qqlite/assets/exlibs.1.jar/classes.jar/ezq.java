import android.graphics.RectF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.AlbumImageProxy;
import com.tencent.mobileqq.widget.AlbumWorkSpace;
import com.tencent.mobileqq.widget.ImageViewTouche;

public class ezq
  extends GestureDetector.SimpleOnGestureListener
{
  private ezq(AlbumImageProxy paramAlbumImageProxy) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AlbumImageProxy localAlbumImageProxy = this.a;
    if (localAlbumImageProxy.getScale() > 2.0F) {
      localAlbumImageProxy.zoomTo(1.0F);
    }
    for (;;)
    {
      return true;
      localAlbumImageProxy.zoomToPoint(3.0F, paramMotionEvent.getX(), paramMotionEvent.getY());
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    paramMotionEvent1 = this.a;
    if (2 == paramMotionEvent2.getAction())
    {
      float f;
      int i;
      int k;
      int m;
      if (paramMotionEvent1.getScale() > 1.0F)
      {
        paramMotionEvent1.postTranslateCenter(-paramFloat1, -paramFloat2);
        paramFloat2 = this.a.getShownRect().right;
        f = this.a.getShownRect().left;
        i = ((AlbumWorkSpace)paramMotionEvent1.getParent()).getScrollX();
        int j = paramMotionEvent1.getLeft();
        k = paramMotionEvent1.getRight();
        m = this.a.getWidth();
        if (paramFloat1 <= 0.0F) {
          break label138;
        }
        if (j - i < 0) {
          break label110;
        }
      }
      label110:
      while (k - i <= m)
      {
        return false;
        if ((paramFloat2 >= m) && (f <= 0.0F)) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      label138:
      if ((paramFloat2 >= m) && (f <= 0.0F)) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    super.onSingleTapConfirmed(paramMotionEvent);
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    super.onSingleTapUp(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ezq
 * JD-Core Version:    0.7.0.1
 */