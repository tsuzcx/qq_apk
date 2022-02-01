import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import mqq.observer.WtloginObserver;

class alua
  extends WtloginObserver
{
  alua(altz paramaltz) {}
  
  public void OnRegGetSMSVerifyLoginAccount(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(altz.TAG, 2, "OnRegGetSMSVerifyLoginAccount ret=" + paramInt + " uin=" + paramLong);
    }
    if (this.b.a.isFinishing()) {
      return;
    }
    if (paramArrayOfByte3 != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte3, "utf-8");
        QQAppInterface localQQAppInterface = this.b.app;
        String str = Integer.toString(paramInt);
        if (paramArrayOfByte1 != null) {
          break label208;
        }
        paramArrayOfByte3 = "";
        anot.a(localQQAppInterface, "new_reg", "setting_page_no", "result", "", 1, "", str, "", paramArrayOfByte3, "", "", "", "", "");
        this.b.a.gV();
        if (paramInt != 0) {
          break label469;
        }
        altz.a(this.b, Long.valueOf(paramLong).toString());
        altz.a(this.b, paramArrayOfByte2);
        if (!TextUtils.isEmpty(altz.a(this.b))) {
          break;
        }
        this.b.a.J(2131717096, 1);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
      }
      paramArrayOfByte1 = null;
      continue;
      label208:
      paramArrayOfByte3 = paramArrayOfByte1;
    }
    if ((altz.a(this.b) == null) || (altz.a(this.b).length == 0))
    {
      this.b.a.J(2131717096, 1);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(altz.TAG, 4, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccount ret: %s, uin: %s, sign: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), MD5.toMD5(altz.a(this.b)) }));
    }
    paramArrayOfByte1 = new Intent(this.b.a, RegisterQQNumberActivity.class);
    paramArrayOfByte1.putExtra("phonenum", this.b.a.phoneNum);
    paramArrayOfByte1.putExtra("invite_code", this.b.a.aLv);
    paramArrayOfByte1.putExtra("key", this.b.a.countryCode);
    paramArrayOfByte1.putExtra("key_register_is_phone_num_registered", this.b.a.aRQ);
    paramArrayOfByte1.putExtra("uin", altz.a(this.b));
    paramArrayOfByte1.putExtra("key_register_sign", altz.a(this.b));
    paramArrayOfByte1.putExtra("key_register_from_send_sms", altz.a(this.b));
    paramArrayOfByte1.putExtra("key_register_chose_bind_phone", true);
    this.b.a.startActivity(paramArrayOfByte1);
    this.b.a.finish();
    return;
    label469:
    if (TextUtils.isEmpty(paramArrayOfByte1))
    {
      this.b.a.J(2131717096, 1);
      return;
    }
    this.b.a.cq(paramArrayOfByte1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alua
 * JD-Core Version:    0.7.0.1
 */