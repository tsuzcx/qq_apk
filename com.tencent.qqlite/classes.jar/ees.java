import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.MobileQQService;

public class ees
  extends FriendListObserver
{
  public ees(MobileQQService paramMobileQQService) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    String str = MobileQQService.a(this.a).a();
    if ((paramBoolean) && (str != null) && (str.equals(paramString))) {
      MobileQQService.a(this.a).a(MobileQQService.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ees
 * JD-Core Version:    0.7.0.1
 */