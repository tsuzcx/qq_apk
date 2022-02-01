import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

public class wfn
  extends akwl
{
  public wfn(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  protected void aX(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 2, "VerifyPhoneNumActivity onReBindMblWTLogin isSuccess = " + paramBoolean1 + "; resultOk = " + paramBoolean2);
    }
    this.this$0.gV();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        VerifyPhoneNumActivity.a(this.this$0, true);
        VerifyPhoneNumActivity.c(this.this$0);
        return;
      }
      VerifyPhoneNumActivity.c(this.this$0);
      return;
    }
    VerifyPhoneNumActivity.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wfn
 * JD-Core Version:    0.7.0.1
 */