import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.b;

public class vth
  implements TextWatcher
{
  public vth(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (SelectedAndSearchBar.a(this.this$0) != null) {
      SelectedAndSearchBar.a(this.this$0).afterTextChanged(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vth
 * JD-Core Version:    0.7.0.1
 */