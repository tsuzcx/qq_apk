import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.app.LBSObserver;

public class cbv
  extends LBSObserver
{
  public cbv(AddContactsView paramAddContactsView) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if (paramBoolean) {
      this.a.a = paramLBSInfo.a();
    }
    if ((this.a.a == null) || (this.a.a.length != 4)) {
      this.a.a = new String[] { "-1", "-1", "-1", "-1" };
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbv
 * JD-Core Version:    0.7.0.1
 */