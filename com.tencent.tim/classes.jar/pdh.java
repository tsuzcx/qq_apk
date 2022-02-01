import android.text.Layout;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class pdh
  extends BaseMovementMethod
{
  private static pdh a;
  
  public static pdh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new pdh();
      }
      return a;
    }
    finally {}
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      paramMotionEvent = paramTextView.getLayout();
      j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
      paramSpannable = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (paramSpannable.length != 0)
      {
        paramSpannable = paramSpannable[0];
        if (i == 1) {
          paramSpannable.onClick(paramTextView);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdh
 * JD-Core Version:    0.7.0.1
 */