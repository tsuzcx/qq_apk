import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class wvn
  extends ContactBindObserver
{
  public wvn(SettingActivity2 paramSettingActivity2) {}
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    if (this.a.c != null)
    {
      this.a.app.unRegistObserver(this.a.c);
      this.a.c = null;
    }
    this.a.b();
    if (paramBoolean)
    {
      if (this.a.c != null)
      {
        this.a.app.unRegistObserver(this.a.c);
        this.a.c = null;
      }
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvn
 * JD-Core Version:    0.7.0.1
 */