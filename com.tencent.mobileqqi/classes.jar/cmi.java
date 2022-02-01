import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class cmi
  extends OpenIdObserver
{
  public cmi(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((this.a.isFinishing()) || (this.a.c)) {}
    do
    {
      return;
      ForwardRecentActivity.a(this.a).e();
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardRecentActivity", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(this.a.v)) {
          this.a.a();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ForwardRecentActivity", 2, "openIdObserver fail");
      }
    } while ((!this.a.jdField_a_of_type_Boolean) || (this.a.f != 11));
    ForwardRecentActivity.a(this.a).a("-1010", -1, "", this.a.getString(2131560461));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmi
 * JD-Core Version:    0.7.0.1
 */