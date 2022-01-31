import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;

class vmo
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private vmo(vmg paramvmg) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom();
    if (this.a.c < 0)
    {
      this.a.c = i;
      this.a.jdField_a_of_type_Vmn.a();
    }
    do
    {
      do
      {
        return;
      } while (this.a.c - i <= this.a.b);
      this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      this.a.c = i;
      this.a.jdField_a_of_type_AndroidViewViewGroup.requestLayout();
    } while (this.a.jdField_a_of_type_Vmn == null);
    this.a.jdField_a_of_type_Vmn.a(true, null);
    this.a.jdField_a_of_type_Vmn.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmo
 * JD-Core Version:    0.7.0.1
 */