import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout.a;

public class akku
  implements GestureDetector.OnGestureListener
{
  public akku(OverCoverFrameLayout paramOverCoverFrameLayout) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) <= this.b.csM) {}
    while ((this.b.a != null) && (this.b.a.Ne())) {
      return false;
    }
    if (paramFloat2 < 0.0F) {
      this.b.arS();
    }
    for (;;)
    {
      return true;
      this.b.arT();
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) <= this.b.dnu) {}
    while ((this.b.a != null) && (this.b.a.Ne())) {
      return false;
    }
    if (paramFloat2 > 0.0F) {
      this.b.arS();
    }
    for (;;)
    {
      return true;
      this.b.arT();
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akku
 * JD-Core Version:    0.7.0.1
 */