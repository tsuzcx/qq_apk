import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;

class xfq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private xfq(xfh paramxfh) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_Xfo.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xfq
 * JD-Core Version:    0.7.0.1
 */