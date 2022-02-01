import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ygx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  
  ygx(ygw paramygw) {}
  
  public void onGlobalLayout()
  {
    ygw.a(this.jdField_a_of_type_Ygw).getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
    if (i != this.jdField_a_of_type_Int)
    {
      int j = ygw.a(this.jdField_a_of_type_Ygw).getRootView().getHeight();
      if (j - i <= j / 4) {
        break label79;
      }
      this.jdField_a_of_type_Boolean = true;
      ygw.a(this.jdField_a_of_type_Ygw);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label79:
      if (this.jdField_a_of_type_Boolean) {
        ygw.b(this.jdField_a_of_type_Ygw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygx
 * JD-Core Version:    0.7.0.1
 */