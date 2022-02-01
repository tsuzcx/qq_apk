import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class amij
  extends LinkMovementMethod
{
  private static amij jdField_a_of_type_Amij;
  amii jdField_a_of_type_Amii;
  boolean cCL;
  
  public static MovementMethod getInstance()
  {
    if (jdField_a_of_type_Amij == null) {
      jdField_a_of_type_Amij = new amij();
    }
    return jdField_a_of_type_Amij;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0) || (i == 3))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (amii[])paramSpannable.getSpans(j, j, amii.class);
      if (QLog.isColorLevel()) {
        QLog.i("StateColorMovementMethod", 2, String.format("onTouch action[%d] links=[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(localObject.length) }));
      }
      if (localObject.length != 0)
      {
        this.cCL = false;
        paramSpannable = localObject[0];
        if (i == 1)
        {
          if (this.jdField_a_of_type_Amii != null)
          {
            this.jdField_a_of_type_Amii.M(paramTextView, false);
            this.jdField_a_of_type_Amii = null;
          }
          paramSpannable.onClick(paramTextView);
        }
        for (;;)
        {
          return true;
          if (i == 0)
          {
            paramSpannable.M(paramTextView, true);
            this.jdField_a_of_type_Amii = paramSpannable;
          }
          else if ((i == 3) && (this.jdField_a_of_type_Amii != null))
          {
            this.jdField_a_of_type_Amii.M(paramTextView, false);
            this.jdField_a_of_type_Amii = null;
          }
        }
      }
      if (i != 1) {
        break label312;
      }
      if (this.cCL)
      {
        this.cCL = false;
        paramTextView.performClick();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Amii != null)
      {
        this.jdField_a_of_type_Amii.M(paramTextView, false);
        this.jdField_a_of_type_Amii = null;
      }
      return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      label312:
      if (i == 0) {
        this.cCL = true;
      } else if (i == 3) {
        this.cCL = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amij
 * JD-Core Version:    0.7.0.1
 */