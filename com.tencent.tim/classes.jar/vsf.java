import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

public class vsf
  extends AccountObserver
{
  public vsf(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void onRegisterCommitSmsCodeResp(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp isSuccess=" + paramBoolean + ",code=" + paramInt);
    }
    if (this.this$0.isFinishing()) {}
    label234:
    label241:
    do
    {
      return;
      this.this$0.gV();
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        QQAppInterface localQQAppInterface = this.this$0.app;
        String str2 = Integer.toString(paramInt);
        if (TextUtils.isEmpty(this.this$0.aLv))
        {
          str1 = "2";
          if (paramArrayOfByte != null) {
            break label234;
          }
          localObject = "";
          anot.a(localQQAppInterface, "new_reg", "msg_page", "next_clk", "", 1, "", str2, str1, (String)localObject, "", "", "", "", "");
          if ((paramBoolean) && (paramInt == 0)) {
            break label241;
          }
          paramString1 = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            paramString1 = this.this$0.getString(2131717096);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Login_Optimize_RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp error=" + paramString1);
          }
          this.this$0.cq(paramString1, 1);
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
          continue;
          String str1 = "1";
          continue;
          Object localObject = paramArrayOfByte;
        }
        if (!TextUtils.isEmpty(paramString1)) {
          RegisterVerifyCodeActivity.a(this.this$0, paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          RegisterVerifyCodeActivity.b(this.this$0, paramString2);
        }
        if (!TextUtils.isEmpty(paramString3)) {
          RegisterVerifyCodeActivity.c(this.this$0, paramString3);
        }
        this.this$0.bRp();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Login_Optimize_RegisterVerifyCodeActivity", 2, "onRegisterCommitSmsCodeResp code=" + paramInt + " ,uin=" + paramString1 + " ,nick=" + paramString2 + " ,faceUrl=" + paramString3);
  }
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterSendResendSmsreqResp");
    }
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.gV();
    if (!paramBoolean) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        localObject = paramArrayOfByte;
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          localObject = this.this$0.getString(2131717096);
        }
        this.this$0.cq((String)localObject, 1);
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
          RegisterVerifyCodeActivity.a(this.this$0, paramInt1);
        }
      }
    }
    if (paramInt1 == 0)
    {
      RegisterVerifyCodeActivity.a(this.this$0, 60);
      RegisterVerifyCodeActivity.a(this.this$0, RegisterVerifyCodeActivity.c(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsf
 * JD-Core Version:    0.7.0.1
 */