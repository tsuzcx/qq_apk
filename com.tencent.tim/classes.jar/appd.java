import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class appd
  extends ArrowKeyMovementMethod
{
  private static appd a;
  
  public static MovementMethod getInstance()
  {
    if (a == null) {
      a = new appd();
    }
    return a;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (paramTextView.getTag(2131374473) != null)
      {
        appe localappe = (appe)paramTextView.getTag(2131374473);
        Drawable localDrawable = localappe.getDrawable();
        if ((localDrawable != null) && (new Rect(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight()).contains(i, j)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("zivonchen", 2, "我擦呢,命中------------------");
          }
          localappe.Q(paramTextView);
          return true;
        }
      }
    }
    return Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appd
 * JD-Core Version:    0.7.0.1
 */