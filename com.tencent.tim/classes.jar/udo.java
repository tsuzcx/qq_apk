import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AddAccountActivity;

public class udo
  implements TextWatcher
{
  public udo(AddAccountActivity paramAddAccountActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0) {
      if (this.this$0.pj != null) {
        this.this$0.pj.setVisibility(0);
      }
    }
    while ((this.this$0.pj == null) || (!this.this$0.pj.isShown())) {
      return;
    }
    this.this$0.pj.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udo
 * JD-Core Version:    0.7.0.1
 */