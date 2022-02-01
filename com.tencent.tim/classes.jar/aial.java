import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87a.RspBody;

final class aial
  extends aklm
{
  aial(Activity paramActivity, String paramString, Runnable paramRunnable) {}
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("FaceLoginHelper", 1, new Object[] { "cmd : ", paramString1, " code : ", Integer.valueOf(paramInt), " message : ", paramString2 });
    if (paramInt == 89) {
      QQToast.a(this.val$context, this.val$context.getString(2131701217), 0).show();
    }
    for (;;)
    {
      if (this.gF != null) {
        this.gF.run();
      }
      return;
      QQToast.a(this.val$context, paramString2, 0).show();
    }
  }
  
  public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody)
  {
    Intent localIntent = new Intent(this.val$context, AuthDevVerifyCodeActivity.class);
    localIntent.putExtra("k_from", "f_SetFaceData");
    if (this.aLS == null) {}
    for (paramRspBody = "";; paramRspBody = this.aLS)
    {
      localIntent.putExtra("phone_num", paramRspBody);
      this.val$context.startActivityForResult(localIntent, 11);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aial
 * JD-Core Version:    0.7.0.1
 */