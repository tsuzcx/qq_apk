import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class vef
  implements View.OnTouchListener
{
  Spannable a;
  
  public vef(Spannable paramSpannable)
  {
    this.a = paramSpannable;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (!(paramView instanceof TextView)) {
      return false;
    }
    paramView = (TextView)paramView;
    if ((i != 1) && (i != 0)) {
      return false;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int m = paramView.getTotalPaddingLeft();
    int n = paramView.getTotalPaddingTop();
    int i1 = paramView.getScrollX();
    int i2 = paramView.getScrollY();
    paramMotionEvent = paramView.getLayout();
    j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
    paramMotionEvent = (ClickableSpan[])this.a.getSpans(j, j, ClickableSpan.class);
    if (paramMotionEvent.length == 0)
    {
      Selection.removeSelection(this.a);
      paramView.performClick();
      return false;
    }
    if (i == 1) {
      paramMotionEvent[0].onClick(paramView);
    }
    for (;;)
    {
      return true;
      Selection.setSelection(this.a, this.a.getSpanStart(paramMotionEvent[0]), this.a.getSpanEnd(paramMotionEvent[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vef
 * JD-Core Version:    0.7.0.1
 */