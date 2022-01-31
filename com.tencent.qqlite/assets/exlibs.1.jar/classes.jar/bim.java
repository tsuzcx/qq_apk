import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

public class bim
  extends AccountObserver
{
  public bim(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void onRegisterCommitSmsCodeResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp");
    }
    if (this.a.isFinishing()) {}
    do
    {
      return;
      this.a.g();
      if ((!paramBoolean) || (paramInt != 0)) {
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
          Object localObject = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            localObject = this.a.getString(2131363283);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp error=" + (String)localObject);
          }
          this.a.a((String)localObject, 1);
          return;
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte.printStackTrace();
            paramArrayOfByte = null;
          }
        }
      }
      if (paramInt == 0) {
        this.a.c();
      }
    } while (!QLog.isColorLevel());
    QLog.d("RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp code = " + paramInt);
  }
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterSendResendSmsreqResp");
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.g();
    if (!paramBoolean) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        localObject = paramArrayOfByte;
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          localObject = this.a.getString(2131363283);
        }
        this.a.a((String)localObject, 1);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
      }
    }
    if (paramArrayOfByte != null) {}
    try
    {
      localObject = new String(paramArrayOfByte, "utf-8");
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterSendResendSmsreqResp code = " + paramInt1 + ";strMsg = " + (String)localObject + ";next_chk_time =" + paramInt2 + ";total_time_over =" + paramInt3);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        if (paramInt1 == 5)
        {
          paramInt1 = paramInt2;
          if (paramInt2 <= 60) {
            paramInt1 = 60;
          }
          RegisterVerifyCodeActivity.a(this.a, paramInt1);
        }
      }
    }
    if (paramInt1 == 0)
    {
      RegisterVerifyCodeActivity.a(this.a, 60);
      RegisterVerifyCodeActivity.a(this.a, RegisterVerifyCodeActivity.c(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bim
 * JD-Core Version:    0.7.0.1
 */