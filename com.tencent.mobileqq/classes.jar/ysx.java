import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;

class ysx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private ysx(yso paramyso) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_Ysv.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysx
 * JD-Core Version:    0.7.0.1
 */