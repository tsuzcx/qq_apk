import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class uqq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  
  uqq(uqp paramuqp) {}
  
  public void onGlobalLayout()
  {
    uqp.a(this.jdField_a_of_type_Uqp).getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
    if (i != this.jdField_a_of_type_Int)
    {
      int j = uqp.a(this.jdField_a_of_type_Uqp).getRootView().getHeight();
      if (j - i <= j / 4) {
        break label79;
      }
      this.jdField_a_of_type_Boolean = true;
      uqp.a(this.jdField_a_of_type_Uqp);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label79:
      if (this.jdField_a_of_type_Boolean) {
        uqp.b(this.jdField_a_of_type_Uqp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqq
 * JD-Core Version:    0.7.0.1
 */