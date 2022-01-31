import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.QLog;

public class fcy
  extends OpenIdObserver
{
  public fcy(BindGroupActivity paramBindGroupActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onGetOpenId, isSuccess: " + paramBoolean + " data: " + paramOpenID.toString());
    }
    if ((this.a.isFinishing()) || (this.a.c)) {}
    do
    {
      return;
      this.a.b.hide();
      if (this.a.a != null) {
        this.a.a.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "openIdObserver success");
        }
        this.a.f = paramOpenID.openID;
        if (!paramOpenID.openID.equals(this.a.e))
        {
          this.a.d();
          return;
        }
        this.a.c();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupActivity", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fcy
 * JD-Core Version:    0.7.0.1
 */