import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.qphone.base.util.BaseApplication;

public class agcn
  implements TextWatcher
{
  public agcn(MPFileVerifyPwdView paramMPFileVerifyPwdView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = MPFileVerifyPwdView.a(this.this$0).getText().toString();
    if ((!TextUtils.isEmpty(paramEditable)) && (paramEditable.length() >= 16)) {
      ahao.JD(BaseApplicationImpl.getContext().getString(2131696044));
    }
    while (TextUtils.isEmpty(paramEditable)) {
      return;
    }
    MPFileVerifyPwdView.b(this.this$0).setEnabled(true);
    MPFileVerifyPwdView.b(this.this$0).setTextColor(Color.parseColor("#00a5e0"));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agcn
 * JD-Core Version:    0.7.0.1
 */