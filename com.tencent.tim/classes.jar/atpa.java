import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.filemanager.activity.MPFileVerifyPwdView;

public class atpa
  implements TextWatcher
{
  public atpa(MPFileVerifyPwdView paramMPFileVerifyPwdView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = MPFileVerifyPwdView.a(this.this$0).getText().toString();
    if ((!TextUtils.isEmpty(paramEditable)) && (paramEditable.length() >= 16)) {
      auds.JD(BaseApplicationImpl.getContext().getString(2131696044));
    }
    while (TextUtils.isEmpty(paramEditable)) {
      return;
    }
    MPFileVerifyPwdView.b(this.this$0).setEnabled(true);
    MPFileVerifyPwdView.b(this.this$0).setTextColor(this.this$0.getResources().getColor(2131165781));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpa
 * JD-Core Version:    0.7.0.1
 */