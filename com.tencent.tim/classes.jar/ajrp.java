import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.OldBigDataChannelManager.1.1;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class ajrp
  extends AccountObserver
{
  ajrp(ajro paramajro) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.getFileThreadHandler().post(new OldBigDataChannelManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrp
 * JD-Core Version:    0.7.0.1
 */