import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;

public class tpr
  implements TextWatcher
{
  public tpr(RegisterPersonalInfoActivity paramRegisterPersonalInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    if (TextUtils.isEmpty(paramEditable.toString()))
    {
      RegisterPersonalInfoActivity.a(this.a).setEnabled(false);
      return;
    }
    RegisterPersonalInfoActivity.a(this.a).setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tpr
 * JD-Core Version:    0.7.0.1
 */