import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EUCountryUtils;
import java.io.UnsupportedEncodingException;
import mqq.observer.WtloginObserver;

public class dfh
  extends WtloginObserver
{
  public dfh(RegisterPersonalInfoActivity paramRegisterPersonalInfoActivity) {}
  
  public void OnRegGetSMSVerifyLoginAccount(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPersonalInfoActivity", 2, "OnRegGetSMSVerifyLoginAccount ret=" + paramInt + " uin=" + paramLong);
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.g();
    if (paramInt == 0)
    {
      RegisterPersonalInfoActivity.a(this.a, Long.valueOf(paramLong).toString());
      RegisterPersonalInfoActivity.a(this.a, paramArrayOfByte2);
      if (TextUtils.isEmpty(RegisterPersonalInfoActivity.a(this.a)))
      {
        this.a.a(2131561658, 1);
        return;
      }
      if ((RegisterPersonalInfoActivity.a(this.a) == null) || (RegisterPersonalInfoActivity.a(this.a).length == 0))
      {
        this.a.a(2131561658, 1);
        return;
      }
      if (this.a.g > 0) {
        EUCountryUtils.c(RegisterPersonalInfoActivity.a(this.a), this.a.g);
      }
      PrivacyDeclareHelper.a(RegisterPersonalInfoActivity.a(this.a), this.a.c);
      paramArrayOfByte1 = new Intent(this.a, RegisterQQNumberActivity.class);
      paramArrayOfByte1.putExtra("phonenum", this.a.c);
      paramArrayOfByte1.putExtra("key", this.a.d);
      paramArrayOfByte1.putExtra("uin", RegisterPersonalInfoActivity.a(this.a));
      paramArrayOfByte1.putExtra("key_register_now_account", this.a.e);
      paramArrayOfByte1.putExtra("key_register_sign", RegisterPersonalInfoActivity.a(this.a));
      this.a.startActivity(paramArrayOfByte1);
      this.a.finish();
      return;
    }
    if (paramArrayOfByte3 != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte3, "utf-8");
        if (!TextUtils.isEmpty(paramArrayOfByte1)) {
          break;
        }
        this.a.a(2131561658, 1);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
      }
      paramArrayOfByte1 = null;
    }
    this.a.a(LocaleString.p(this.a, paramArrayOfByte1), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dfh
 * JD-Core Version:    0.7.0.1
 */