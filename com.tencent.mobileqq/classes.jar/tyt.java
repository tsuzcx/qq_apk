import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class tyt
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = ((TextView)paramView).getText();
    localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
    paramView = (TextView)paramView;
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramView.getTotalPaddingLeft();
      int n = paramView.getTotalPaddingTop();
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      paramMotionEvent = paramView.getLayout();
      j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
      paramMotionEvent = (ClickableSpan[])((Spannable)localObject).getSpans(j, j, ClickableSpan.class);
      if (paramMotionEvent.length != 0)
      {
        if (i == 1) {
          paramMotionEvent[0].onClick(paramView);
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyt
 * JD-Core Version:    0.7.0.1
 */