import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class zou
  implements Runnable
{
  public zou(TroopManager paramTroopManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(this.jdField_a_of_type_JavaLangString, this.b);
    ThreadManager.getUIHandler().post(new zov(this, localTroopMemberInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zou
 * JD-Core Version:    0.7.0.1
 */