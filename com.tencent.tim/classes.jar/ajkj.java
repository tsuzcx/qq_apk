import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import com.tencent.mobileqq.multicard.MultiCardRootLayout.a;
import com.tencent.widget.FitSystemWindowsRelativeLayout.a;
import java.lang.ref.WeakReference;

public class ajkj
  implements FitSystemWindowsRelativeLayout.a
{
  public ajkj(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (MultiCardRootLayout.a(this.c) != null)
    {
      MultiCardRootLayout.a locala = (MultiCardRootLayout.a)MultiCardRootLayout.a(this.c).get();
      if ((locala != null) && (locala.kt(i))) {
        return true;
      }
    }
    if (MultiCardRootLayout.a(this.c) != null) {
      MultiCardRootLayout.a(this.c).onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajkj
 * JD-Core Version:    0.7.0.1
 */