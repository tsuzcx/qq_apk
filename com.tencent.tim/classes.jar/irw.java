import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class irw
  extends LinkMovementMethod
{
  private static irw a;
  public int asR = -10864125;
  public int asS = -7447805;
  
  static int a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView = paramTextView.getTag(paramInt1);
    if ((paramTextView instanceof Integer)) {
      paramInt2 = ((Integer)paramTextView).intValue();
    }
    return paramInt2;
  }
  
  public static MovementMethod getInstance()
  {
    if (a == null) {
      a = new irw();
    }
    return a;
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
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (localObject.length != 0)
      {
        if (i == 1)
        {
          i = a(paramTextView, 2131379218, this.asS);
          localObject[0].onClick(paramTextView);
          paramSpannable.setSpan(new ForegroundColorSpan(i), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
        }
        for (;;)
        {
          return true;
          if (i == 0)
          {
            paramSpannable.setSpan(new ForegroundColorSpan(a(paramTextView, 2131379217, this.asR)), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]));
          }
        }
      }
      Selection.removeSelection(paramSpannable);
    }
    return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irw
 * JD-Core Version:    0.7.0.1
 */