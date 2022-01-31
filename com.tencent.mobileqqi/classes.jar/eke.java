import android.os.Handler;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class eke
  extends ContactBindObserver
{
  public eke(BindNumberActivity paramBindNumberActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    BindNumberActivity localBindNumberActivity = this.a;
    if (paramBoolean)
    {
      this.a.a.b();
      BindNumberActivity.a(this.a).sendEmptyMessage(3);
    }
    for (;;)
    {
      this.a.b.unRegistObserver(BindNumberActivity.a(this.a));
      BindNumberActivity.a(this.a, null);
      return;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eke
 * JD-Core Version:    0.7.0.1
 */