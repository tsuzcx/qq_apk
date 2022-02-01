import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class vsd
  extends AccountObserver
{
  public vsd(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    RegisterSendUpSms.c(this.this$0, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterSendUpSms", 2, "onRegisterQuerySmsStatResp isSuccess=" + paramBoolean + ", code=" + paramInt1 + ", uin=" + paramString1 + ", nick=" + paramString2 + ", faceUrl=" + paramString3 + ", errmsg=" + paramString4);
    }
    if (paramInt1 == 4) {}
    for (;;)
    {
      RegisterSendUpSms.a(this.this$0, 0);
      return;
      RegisterSendUpSms.a(this.this$0).setEnabled(true);
      if (paramInt1 == 0)
      {
        RegisterSendUpSms.a(this.this$0).setText(acfp.m(2131713853));
        RegisterSendUpSms.a(this.this$0, paramString1);
        RegisterSendUpSms.b(this.this$0, paramString2);
        RegisterSendUpSms.c(this.this$0, paramString3);
        RegisterSendUpSms.a(this.this$0);
        continue;
      }
      paramString1 = paramString4;
      if (paramInt1 == -1) {}
      try
      {
        paramString1 = new String(paramArrayOfByte, "utf-8");
        paramArrayOfByte = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramArrayOfByte = this.this$0.getString(2131717105);
        }
        QQToast.a(this.this$0, paramArrayOfByte.trim(), 0).show(this.this$0.getTitleBarHeight());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsd
 * JD-Core Version:    0.7.0.1
 */