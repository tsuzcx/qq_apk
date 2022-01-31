import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.AccountObserver;

public class ctc
  extends AccountObserver
{
  public ctc(FriendsManager paramFriendsManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.b(new ctd(this, paramString2, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ctc
 * JD-Core Version:    0.7.0.1
 */