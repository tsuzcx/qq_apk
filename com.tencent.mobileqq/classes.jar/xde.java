import com.tencent.mobileqq.activity.qwallet.GoldConfigObserver;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.ConfigListener;
import java.util.Map;
import mqq.app.AppRuntime;

class xde
  implements QWalletConfigManager.ConfigListener
{
  xde(xdd paramxdd) {}
  
  public void a(String paramString, Map paramMap)
  {
    this.a.a.notifyObservers(GoldConfigObserver.class, 7, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xde
 * JD-Core Version:    0.7.0.1
 */