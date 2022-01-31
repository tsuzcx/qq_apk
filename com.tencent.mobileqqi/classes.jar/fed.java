import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.AccountObserver;

public class fed
  extends AccountObserver
{
  public fed(CircleManager paramCircleManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    CircleManager.a(this.a).a(new fee(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fed
 * JD-Core Version:    0.7.0.1
 */