import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;

class xbh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private xbh(xay paramxay) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_Xbf.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbh
 * JD-Core Version:    0.7.0.1
 */