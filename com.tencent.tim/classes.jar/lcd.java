import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class lcd
  implements Manager
{
  private AppInterface app;
  
  public lcd(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicManager", 1, "[ReadInJoyLogicManager] constructed.");
    this.app = paramAppInterface;
    initialize();
  }
  
  public void aEL()
  {
    lbz.a().mX(false);
  }
  
  public lbz b()
  {
    return lbz.a();
  }
  
  public void initialize()
  {
    kyi.aIg();
    lbz.a().c(this.app);
  }
  
  public void onDestroy()
  {
    aEL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcd
 * JD-Core Version:    0.7.0.1
 */