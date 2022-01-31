import android.view.View;
import android.view.View.OnFocusChangeListener;

class vmj
  implements View.OnFocusChangeListener
{
  vmj(vmg paramvmg) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    ved.b("EditTextDialog", "onFocusChange:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmj
 * JD-Core Version:    0.7.0.1
 */