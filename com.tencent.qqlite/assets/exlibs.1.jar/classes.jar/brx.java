import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class brx
  extends ContactBindObserver
{
  public brx(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 2, "onUploadContact  isSuccess = " + paramBoolean);
    }
    VerifyPhoneNumActivity.b(this.a);
    VerifyPhoneNumActivity.e(this.a);
    VerifyPhoneNumActivity.b(this.a);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 2, "VerifyPhoneNumActivity onReBindMblWTLogin isSuccess = " + paramBoolean1 + "; resultOk = " + paramBoolean2);
    }
    this.a.c();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        VerifyPhoneNumActivity.a(this.a, true);
        VerifyPhoneNumActivity.d(this.a);
        return;
      }
      VerifyPhoneNumActivity.d(this.a);
      return;
    }
    VerifyPhoneNumActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     brx
 * JD-Core Version:    0.7.0.1
 */