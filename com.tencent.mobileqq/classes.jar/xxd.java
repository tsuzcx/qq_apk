import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class xxd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  
  xxd(xxc paramxxc) {}
  
  public void onGlobalLayout()
  {
    xxc.a(this.jdField_a_of_type_Xxc).getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
    if (i != this.jdField_a_of_type_Int)
    {
      int j = xxc.a(this.jdField_a_of_type_Xxc).getRootView().getHeight();
      if (j - i <= j / 4) {
        break label79;
      }
      this.jdField_a_of_type_Boolean = true;
      xxc.a(this.jdField_a_of_type_Xxc);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label79:
      if (this.jdField_a_of_type_Boolean) {
        xxc.b(this.jdField_a_of_type_Xxc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxd
 * JD-Core Version:    0.7.0.1
 */