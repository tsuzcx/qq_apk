import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.AccountObserver;

public class ezp
  extends AccountObserver
{
  public ezp(CircleManager paramCircleManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    CircleManager.a(this.a).a(new ezq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezp
 * JD-Core Version:    0.7.0.1
 */