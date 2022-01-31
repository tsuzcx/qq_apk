import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.AccountObserver;

public class fhb
  extends AccountObserver
{
  public fhb(FriendsManager paramFriendsManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.b(new fhc(this, paramString2, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fhb
 * JD-Core Version:    0.7.0.1
 */