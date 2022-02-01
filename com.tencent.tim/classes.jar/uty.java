import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class uty
  extends WtloginObserver
{
  public uty(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("DevlockQuickLoginActivity", 2, "OnCloseCode userAccount=" + paramString + " ret=" + paramInt + " time=" + paramLong);
      if (paramArrayOfByte2 == null) {}
    }
    try
    {
      paramString = new String(paramArrayOfByte2, "utf-8");
      QLog.d("DevlockQuickLoginActivity", 2, "OnCloseCode errMsg=" + paramString);
      this.this$0.bwV();
      if (DevlockQuickLoginActivity.a(this.this$0)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      if (paramInt == 0)
      {
        QQToast.a(this.this$0.getApplicationContext(), 2, 2131693238, 0).show(DevlockQuickLoginActivity.a(this.this$0));
        DevlockQuickLoginActivity.a(this.this$0);
        DevlockQuickLoginActivity.a(this.this$0, 0, 2130772013);
        return;
      }
      if (paramInt == 21)
      {
        paramString = this.this$0.getString(2131693235);
        paramArrayOfByte1 = this.this$0.getString(2131720564);
        this.this$0.a(null, paramString, paramArrayOfByte1, new utz(this));
        return;
      }
      paramString = DevlockQuickLoginActivity.a(this.this$0, 2131693236);
      QQToast.a(this.this$0.getApplicationContext(), 1, paramString, 0).show(DevlockQuickLoginActivity.b(this.this$0));
    }
  }
  
  public void OnException(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "OnException e=" + paramString);
    }
    this.this$0.bwV();
    QQToast.a(DevlockQuickLoginActivity.b(this.this$0), 1, this.this$0.getString(2131693237), 0).show(DevlockQuickLoginActivity.d(this.this$0));
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "OnVerifyCode userAccount=" + paramString + " ret=" + paramInt);
    }
    if (DevlockQuickLoginActivity.b(this.this$0))
    {
      this.this$0.bwV();
      return;
    }
    if (paramInt == 0)
    {
      this.this$0.bMW();
      return;
    }
    this.this$0.bwV();
    if (paramInt == 21)
    {
      paramString = this.this$0.getString(2131693235);
      paramArrayOfByte1 = this.this$0.getString(2131720564);
      this.this$0.a(null, paramString, paramArrayOfByte1, new uua(this));
      return;
    }
    paramString = this.this$0.getString(2131693236);
    QQToast.a(DevlockQuickLoginActivity.a(this.this$0), 1, paramString, 0).show(DevlockQuickLoginActivity.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uty
 * JD-Core Version:    0.7.0.1
 */