import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.callbackInMainThread;
import mqq.os.MqqHandler;

public class zlr
  implements Runnable
{
  public zlr(TroopManager paramTroopManager, String paramString, TroopManager.callbackInMainThread paramcallbackInMainThread) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new zls(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zlr
 * JD-Core Version:    0.7.0.1
 */