import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

public class vsa
  extends akwl
{
  public vsa(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  protected void ao(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onUploadContact  isSuccess = " + paramBoolean);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "RegisterQQNumberActivity onGetBindUinWithPhone isSuccess = " + paramBoolean1 + "; isBindOk = " + paramBoolean2 + ";hadbind = " + paramBoolean3 + ";uin =" + paramString);
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        RegisterQQNumberActivity.a(this.this$0, true);
        RegisterQQNumberActivity.b(this.this$0);
        return;
      }
      if ((paramBoolean3) && (!TextUtils.isEmpty(paramString)))
      {
        RegisterQQNumberActivity.a(this.this$0);
        Intent localIntent = new Intent(this.this$0, VerifyPhoneNumActivity.class);
        localIntent.putExtra("phonenum", this.this$0.phoneNum);
        localIntent.putExtra("key", this.this$0.countryCode);
        localIntent.putExtra("uin", RegisterQQNumberActivity.a(this.this$0));
        localIntent.putExtra("key_register_sign", RegisterQQNumberActivity.a(this.this$0));
        localIntent.putExtra("key_register_binduin", paramString);
        this.this$0.startActivity(localIntent);
        this.this$0.finish();
        return;
      }
      RegisterQQNumberActivity.b(this.this$0);
      return;
    }
    RegisterQQNumberActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsa
 * JD-Core Version:    0.7.0.1
 */