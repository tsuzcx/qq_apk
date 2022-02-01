import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;

class yzb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private yzb(yys paramyys) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_Yyz.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzb
 * JD-Core Version:    0.7.0.1
 */