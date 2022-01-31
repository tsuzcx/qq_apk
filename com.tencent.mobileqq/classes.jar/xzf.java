import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.PstnObserver;

public class xzf
  extends PstnObserver
{
  public xzf(PhoneContactSelectActivity paramPhoneContactSelectActivity) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.a.a != null)
    {
      this.a.app.removeObserver(this.a.a);
      this.a.a = null;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzf
 * JD-Core Version:    0.7.0.1
 */