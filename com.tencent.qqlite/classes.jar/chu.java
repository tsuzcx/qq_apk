import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class chu
  extends ContactBindObserver
{
  chu(cht paramcht) {}
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.a.a.d();
    this.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      this.a.a.setResult(-1);
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chu
 * JD-Core Version:    0.7.0.1
 */