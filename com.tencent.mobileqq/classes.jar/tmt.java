import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.WtloginObserver;

public class tmt
  extends WtloginObserver
{
  public tmt(RegisterPersonalInfoActivity paramRegisterPersonalInfoActivity) {}
  
  public void OnRegGetSMSVerifyLoginAccount(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPersonalInfoActivity", 2, "OnRegGetSMSVerifyLoginAccount ret=" + paramInt + " uin=" + paramLong);
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c();
    if (paramInt == 0)
    {
      RegisterPersonalInfoActivity.a(this.a, Long.valueOf(paramLong).toString());
      RegisterPersonalInfoActivity.a(this.a, paramArrayOfByte2);
      if (TextUtils.isEmpty(RegisterPersonalInfoActivity.a(this.a)))
      {
        this.a.a(2131434198, 1);
        return;
      }
      if ((RegisterPersonalInfoActivity.a(this.a) == null) || (RegisterPersonalInfoActivity.a(this.a).length == 0))
      {
        this.a.a(2131434198, 1);
        return;
      }
      paramArrayOfByte1 = new Intent(this.a, RegisterQQNumberActivity.class);
      paramArrayOfByte1.putExtra("phonenum", this.a.a);
      paramArrayOfByte1.putExtra("key", this.a.jdField_b_of_type_JavaLangString);
      paramArrayOfByte1.putExtra("key_register_is_phone_num_registered", this.a.jdField_b_of_type_Boolean);
      paramArrayOfByte1.putExtra("uin", RegisterPersonalInfoActivity.a(this.a));
      paramArrayOfByte1.putExtra("key_register_sign", RegisterPersonalInfoActivity.a(this.a));
      paramArrayOfByte1.putExtra("key_register_from_send_sms", RegisterPersonalInfoActivity.a(this.a));
      paramArrayOfByte1.putExtra("key_register_chose_bind_phone", true);
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
        this.a.a(2131434198, 1);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
      }
      paramArrayOfByte1 = null;
    }
    this.a.a(paramArrayOfByte1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmt
 * JD-Core Version:    0.7.0.1
 */