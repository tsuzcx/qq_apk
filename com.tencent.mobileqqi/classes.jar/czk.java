import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class czk
  extends ContactBindObserver
{
  czk(czj paramczj) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    PermisionPrivacyActivity.c(this.a.a.a.a);
    this.a.a.a.a.b.unRegistObserver(this);
    if (paramBoolean)
    {
      this.a.a.a.a.setResult(-1);
      this.a.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czk
 * JD-Core Version:    0.7.0.1
 */