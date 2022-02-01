import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import com.tencent.mobileqq.multicard.MultiCardRootLayout.a;
import java.lang.ref.WeakReference;

public class ajki
  extends GestureDetector.SimpleOnGestureListener
{
  public ajki(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((MultiCardRootLayout.a(this.c)) && (MultiCardRootLayout.a(this.c) != null))
    {
      MultiCardRootLayout.a locala = (MultiCardRootLayout.a)MultiCardRootLayout.a(this.c).get();
      if (locala != null) {
        locala.a(this.c);
      }
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajki
 * JD-Core Version:    0.7.0.1
 */