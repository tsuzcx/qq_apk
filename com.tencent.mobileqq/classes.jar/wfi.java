import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class wfi
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  
  wfi(wfh paramwfh) {}
  
  public void onGlobalLayout()
  {
    wfh.a(this.jdField_a_of_type_Wfh).getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
    if (i != this.jdField_a_of_type_Int)
    {
      int j = wfh.a(this.jdField_a_of_type_Wfh).getRootView().getHeight();
      if (j - i <= j / 4) {
        break label79;
      }
      this.jdField_a_of_type_Boolean = true;
      wfh.a(this.jdField_a_of_type_Wfh);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label79:
      if (this.jdField_a_of_type_Boolean) {
        wfh.b(this.jdField_a_of_type_Wfh);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfi
 * JD-Core Version:    0.7.0.1
 */