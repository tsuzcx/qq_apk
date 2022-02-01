import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.hiboom.HiBoomTextView.d;

public class ahxx
  extends GestureDetector.SimpleOnGestureListener
{
  public ahxx(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$d != null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$d.R(this.this$0);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    ahxp localahxp = ahxo.a().b(this.this$0.dbW, this.this$0.EP, this.this$0.jdField_a_of_type_Ahxo$a);
    if (this.this$0.aou())
    {
      localahxp.KE(true);
      this.this$0.invalidate();
      return true;
    }
    if (HiBoomTextView.a(this.this$0)) {
      this.this$0.refresh();
    }
    for (;;)
    {
      return super.onSingleTapConfirmed(paramMotionEvent);
      if (localahxp.mType == 3)
      {
        this.this$0.KI(true);
      }
      else if (localahxp.mType == 4)
      {
        this.this$0.ciS = true;
        this.this$0.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxx
 * JD-Core Version:    0.7.0.1
 */