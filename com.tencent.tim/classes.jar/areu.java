import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;

public class areu
  extends LinkMovementMethod
{
  private static MovementMethod b;
  private static Field x;
  
  public static MovementMethod getInstance()
  {
    if (b == null) {
      b = new areu();
    }
    return b;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() == 1) {}
    try
    {
      if (x == null) {
        x = View.class.getDeclaredField("mHasPerformedLongPress");
      }
      x.setAccessible(true);
      boolean bool = x.getBoolean(paramTextView);
      if (bool) {
        return true;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     areu
 * JD-Core Version:    0.7.0.1
 */