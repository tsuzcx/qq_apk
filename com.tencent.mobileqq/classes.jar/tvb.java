import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class tvb
  extends AccountObserver
{
  public tvb(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    RegisterSendUpSms.c(this.a, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterSendUpSms", 2, "onRegisterQuerySmsStatResp isSuccess=" + paramBoolean + ", code=" + paramInt1 + ", uin=" + paramString1 + ", nick=" + paramString2 + ", faceUrl=" + paramString3 + ", errmsg=" + paramString4);
    }
    if (paramInt1 == 4) {}
    for (;;)
    {
      RegisterSendUpSms.a(this.a, 0);
      return;
      RegisterSendUpSms.a(this.a).setEnabled(true);
      if (paramInt1 == 0)
      {
        RegisterSendUpSms.a(this.a).setText("验证成功");
        RegisterSendUpSms.a(this.a, paramString1);
        RegisterSendUpSms.b(this.a, paramString2);
        RegisterSendUpSms.c(this.a, paramString3);
        RegisterSendUpSms.a(this.a);
        continue;
      }
      paramString1 = paramString4;
      if (paramInt1 == -1) {}
      try
      {
        paramString1 = new String(paramArrayOfByte, "utf-8");
        QQToast.a(this.a, paramString1.trim(), 0).b(this.a.getTitleBarHeight());
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramString1 = paramString4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvb
 * JD-Core Version:    0.7.0.1
 */