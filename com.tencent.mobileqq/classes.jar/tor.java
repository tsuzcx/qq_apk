import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView;

class tor
  extends GestureDetector.SimpleOnGestureListener
{
  private tor(toi paramtoi) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.a = true;
    toi.b(this.a);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((!(toi.a(this.a).getTag() instanceof top)) || (((toi.a(this.a).getTag() instanceof top)) && (!toi.a(this.a).a(toi.a(this.a)).booleanValue()))) {
      toi.c(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tor
 * JD-Core Version:    0.7.0.1
 */