import android.content.Intent;
import android.util.Base64;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.activity.QQIdentiferLegacyActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class uhs
  extends aklm
{
  public uhs(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void dg(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.this$0, QQIdentiferLegacyActivity.class);
    localIntent.putExtra("platformAppId", 101810106);
    localIntent.putExtra("srcAppId", 101810106);
    localIntent.putExtra("srcOpenId", paramString1);
    localIntent.putExtra("key", paramString2);
    localIntent.putExtra("method", "setFaceData");
    localIntent.putExtra("serviceType", 2);
    this.this$0.startActivityForResult(localIntent, 21);
    AuthDevVerifyCodeActivity.a(this.this$0).setClickable(false);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("Q.devlock.AuthDevVerifyCodeActivity", 1, "set face data onRecvVerifyCode error, code : " + this.this$0.countryCode + " ");
    if (paramInt != -1) {}
    for (;;)
    {
      this.this$0.cq(paramString2, 1);
      return;
      paramString2 = this.this$0.getString(2131717096);
    }
  }
  
  public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.gV();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "Set face data onRecvVerifyCode");
    }
    AuthDevVerifyCodeActivity.b(this.this$0).setVisibility(0);
    int i = 60;
    if (paramRspBody.uint32_resend_interval.get() > 0) {
      i = paramRspBody.uint32_resend_interval.get();
    }
    AuthDevVerifyCodeActivity.a(this.this$0, i);
  }
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onVerifyClose ret = ");
    }
    if (this.this$0.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onVerifyClose activity is finishing.");
      }
      return;
    }
    this.this$0.gV();
    AuthDevVerifyCodeActivity.a(this.this$0);
    paramRspBody = Base64.encodeToString(paramRspBody.toByteArray(), 11);
    aneg.a(101810106, this.this$0.getCurrentAccountUin(), "sms", paramRspBody, AuthDevVerifyCodeActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhs
 * JD-Core Version:    0.7.0.1
 */