import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class ans
  extends OpenIdObserver
{
  public ans(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((this.a.isFinishing()) || (this.a.d)) {}
    do
    {
      return;
      ForwardRecentActivity.a(this.a).d();
      if (this.a.a != null) {
        this.a.a.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardRecentActivity", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(this.a.w)) {
          this.a.a();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ForwardRecentActivity", 2, "openIdObserver fail");
      }
    } while ((!this.a.b) || (this.a.f != 11));
    ForwardRecentActivity.a(this.a).a("-1010", -1, "", this.a.getString(2131362373));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ans
 * JD-Core Version:    0.7.0.1
 */