import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;

public class ajjk
  extends GestureDetector.SimpleOnGestureListener
{
  public ajjk(MultiCardCustomLayout paramMultiCardCustomLayout) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (MultiCardCustomLayout.a(this.a) != null) {
      MultiCardCustomLayout.a(this.a).onLongClick(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjk
 * JD-Core Version:    0.7.0.1
 */