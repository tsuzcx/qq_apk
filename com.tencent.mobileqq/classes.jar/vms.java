import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;

class vms
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private vms(vmj paramvmj) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_Vmq.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vms
 * JD-Core Version:    0.7.0.1
 */