import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

class uhx
  extends akwl
{
  uhx(uhv paramuhv) {}
  
  protected void ao(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onUploadContact  isSuccess = " + paramBoolean);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "RegisterQQNumberActivity onGetBindUinWithPhone isSuccess = " + paramBoolean1 + "; isBindOk = " + paramBoolean2 + ";hadbind = " + paramBoolean3 + ";uin =" + paramString);
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        uhv.a(this.this$0, true);
        uhv.b(this.this$0);
      }
      do
      {
        return;
        if ((!paramBoolean3) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        uhv.a(this.this$0);
      } while (uhv.a(this.this$0) == null);
      Intent localIntent = new Intent(uhv.a(this.this$0), VerifyPhoneNumActivity.class);
      localIntent.putExtra("phonenum", this.this$0.phoneNum);
      localIntent.putExtra("key", this.this$0.countryCode);
      localIntent.putExtra("uin", uhv.a(this.this$0));
      localIntent.putExtra("key_register_sign", uhv.a(this.this$0));
      localIntent.putExtra("key_register_binduin", paramString);
      uhv.a(this.this$0).startActivity(localIntent);
      uhv.a(this.this$0).finish();
      return;
      uhv.b(this.this$0);
      return;
    }
    uhv.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhx
 * JD-Core Version:    0.7.0.1
 */