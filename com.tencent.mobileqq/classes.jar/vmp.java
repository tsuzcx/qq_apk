import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;

class vmp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private vmp(vmg paramvmg) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_Vmn.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmp
 * JD-Core Version:    0.7.0.1
 */