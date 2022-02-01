import android.os.Handler;
import com.tencent.mobileqq.activity.phone.BindNumberBusinessActivity;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ekh
  extends ContactBindObserver
{
  public ekh(BindNumberBusinessActivity paramBindNumberBusinessActivity) {}
  
  protected void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    BindNumberBusinessActivity localBindNumberBusinessActivity = this.a;
    if (paramBoolean)
    {
      ((PhoneContactManager)this.a.b.getManager(10)).b();
      this.a.a.sendEmptyMessage(4);
      MyBusinessActivity.c(true);
      if (QLog.isColorLevel()) {
        QLog.d("BindNumberBusinessActivity", 2, "rebind successed");
      }
    }
    for (;;)
    {
      this.a.d();
      this.a.b.unRegistObserver(BindNumberBusinessActivity.a(this.a));
      BindNumberBusinessActivity.a(this.a, null);
      return;
      QQToast.a(localBindNumberBusinessActivity, this.a.getString(2131558956), 2000).b(localBindNumberBusinessActivity.d());
      if (QLog.isColorLevel()) {
        QLog.d("BindNumberBusinessActivity", 2, "rebind failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ekh
 * JD-Core Version:    0.7.0.1
 */