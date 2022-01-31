import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aim
  extends WtloginObserver
{
  public aim(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
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
      label92:
      DevlockQuickLoginActivity.a(this.a);
      if (DevlockQuickLoginActivity.a(this.a)) {
        return;
      }
      if (paramInt == 0)
      {
        QQToast.a(this.a.getApplicationContext(), 2, 2131364233, 0).b(DevlockQuickLoginActivity.a(this.a));
        DevlockQuickLoginActivity.b(this.a);
        DevlockQuickLoginActivity.a(this.a, 0, 2130968593);
        return;
      }
      if (paramInt == 21)
      {
        paramString = this.a.getString(2131364238);
        paramArrayOfByte1 = this.a.getString(2131364121);
        this.a.a(null, paramString, paramArrayOfByte1, new ain(this));
        return;
      }
      paramString = DevlockQuickLoginActivity.a(this.a, 2131364234);
      QQToast.a(this.a.getApplicationContext(), 1, paramString, 0).b(DevlockQuickLoginActivity.b(this.a));
      return;
    }
    catch (Exception paramString)
    {
      break label92;
    }
  }
  
  public void OnException(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "OnException e=" + paramString);
    }
    DevlockQuickLoginActivity.a(this.a);
    QQToast.a(DevlockQuickLoginActivity.b(this.a), 1, this.a.getString(2131364237), 0).b(DevlockQuickLoginActivity.d(this.a));
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "OnVerifyCode userAccount=" + paramString + " ret=" + paramInt);
    }
    if (DevlockQuickLoginActivity.b(this.a))
    {
      DevlockQuickLoginActivity.a(this.a);
      return;
    }
    if (paramInt == 0)
    {
      this.a.b();
      return;
    }
    DevlockQuickLoginActivity.a(this.a);
    if (paramInt == 21)
    {
      paramString = this.a.getString(2131364238);
      paramArrayOfByte1 = this.a.getString(2131364121);
      this.a.a(null, paramString, paramArrayOfByte1, new aio(this));
      return;
    }
    paramString = this.a.getString(2131364234);
    QQToast.a(DevlockQuickLoginActivity.a(this.a), 1, paramString, 0).b(DevlockQuickLoginActivity.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aim
 * JD-Core Version:    0.7.0.1
 */