import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class eql
  extends ContactBindObserver
{
  eql(eqk parameqk) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.a.a.d();
    this.a.a.b.unRegistObserver(this);
    if (paramBoolean)
    {
      this.a.a.setResult(-1);
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eql
 * JD-Core Version:    0.7.0.1
 */