import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;

class uzw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private uzw(uzn paramuzn) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_Uzu.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzw
 * JD-Core Version:    0.7.0.1
 */