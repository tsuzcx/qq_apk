import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class vrz
  extends WtloginObserver
{
  public vrz(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("RegisterQQNumberActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("RegisterQQNumberActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (paramInt2 == 0) {
      return;
    }
    RegisterQQNumberActivity.a(this.this$0);
    paramString = new Intent(this.this$0, LoginActivity.class);
    paramString.putExtra("uin", RegisterQQNumberActivity.a(this.this$0));
    paramString.putExtra("tab_index", MainFragment.bIk);
    paramString.addFlags(131072);
    this.this$0.startActivity(paramString);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vrz
 * JD-Core Version:    0.7.0.1
 */