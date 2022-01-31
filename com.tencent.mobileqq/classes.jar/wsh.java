import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class wsh
  extends ContactBindObserver
{
  wsh(wsg paramwsg) {}
  
  protected void c(boolean paramBoolean)
  {
    this.a.a.a.b();
    this.a.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      this.a.a.a.a.a(true, true);
      this.a.a.a.setResult(4002);
      this.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsh
 * JD-Core Version:    0.7.0.1
 */