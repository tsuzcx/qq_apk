import android.os.Handler;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class wqf
  extends ContactBindObserver
{
  public wqf(BindNumberActivity paramBindNumberActivity) {}
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      BindNumberActivity.a(this.a).sendEmptyMessage(3);
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindNumberActivity.a(this.a));
      BindNumberActivity.a(this.a, null);
      return;
      this.a.b();
      this.a.b(2131434438);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqf
 * JD-Core Version:    0.7.0.1
 */