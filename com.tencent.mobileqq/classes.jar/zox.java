import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.callbackInMainThread;
import mqq.os.MqqHandler;

public class zox
  implements Runnable
{
  public zox(TroopManager paramTroopManager, String paramString, TroopManager.callbackInMainThread paramcallbackInMainThread) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new zoy(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zox
 * JD-Core Version:    0.7.0.1
 */