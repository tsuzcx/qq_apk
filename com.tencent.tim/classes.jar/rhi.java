import android.view.View;
import android.view.View.OnFocusChangeListener;

class rhi
  implements View.OnFocusChangeListener
{
  rhi(rhf paramrhf) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    ram.d("EditTextDialog", "onFocusChange:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhi
 * JD-Core Version:    0.7.0.1
 */