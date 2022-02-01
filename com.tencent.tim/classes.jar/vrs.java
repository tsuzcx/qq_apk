import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;

public class vrs
  implements TextWatcher
{
  public vrs(RegisterPersonalInfoActivity paramRegisterPersonalInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramEditable.toString())) {
        RegisterPersonalInfoActivity.a(this.this$0).setEnabled(false);
      }
      while (RegisterPersonalInfoActivity.a(this.this$0) != null)
      {
        RegisterPersonalInfoActivity.a(this.this$0).SX(RegisterPersonalInfoActivity.a(this.this$0).isEnabled());
        return;
        RegisterPersonalInfoActivity.a(this.this$0).setEnabled(true);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vrs
 * JD-Core Version:    0.7.0.1
 */