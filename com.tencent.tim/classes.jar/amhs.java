import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class amhs
  extends BaseMovementMethod
{
  public final String TAG = "CommentMovementMethod";
  private ClickableSpan[] a;
  private BackgroundColorSpan c;
  private boolean cCG = true;
  private int dBU;
  private int dBV;
  
  public amhs(int paramInt1, int paramInt2)
  {
    this.dBV = paramInt1;
    this.dBU = paramInt2;
  }
  
  private void Pi(boolean paramBoolean)
  {
    this.cCG = paramBoolean;
  }
  
  public boolean avQ()
  {
    return this.cCG;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramTextView.getTotalPaddingLeft();
      int m = paramTextView.getTotalPaddingTop();
      int n = paramTextView.getScrollX();
      int i1 = paramTextView.getScrollY();
      Layout localLayout = paramTextView.getLayout();
      i = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(j - m + i1), i - k + n);
      this.a = ((ClickableSpan[])paramSpannable.getSpans(i, i, ClickableSpan.class));
      if (this.a.length > 0)
      {
        Pi(false);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.a[0]), paramSpannable.getSpanEnd(this.a[0]));
        this.c = new BackgroundColorSpan(this.dBV);
        paramSpannable.setSpan(this.c, paramSpannable.getSpanStart(this.a[0]), paramSpannable.getSpanEnd(this.a[0]), 33);
      }
    }
    for (;;)
    {
      return Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      Pi(true);
      paramTextView.setBackgroundColor(this.dBU);
      continue;
      if (i == 1)
      {
        if (this.a.length > 0)
        {
          this.a[0].onClick(paramTextView);
          if (this.c != null) {
            paramSpannable.removeSpan(this.c);
          }
        }
        Selection.removeSelection(paramSpannable);
        paramTextView.setBackgroundResource(2131167595);
      }
      else if (i != 2)
      {
        if (this.c != null) {
          paramSpannable.removeSpan(this.c);
        }
        paramTextView.setBackgroundResource(2131167595);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhs
 * JD-Core Version:    0.7.0.1
 */