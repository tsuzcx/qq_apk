import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class zlo
  implements Runnable
{
  public zlo(TroopManager paramTroopManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(this.jdField_a_of_type_JavaLangString, this.b);
    ThreadManager.getUIHandler().post(new zlp(this, localTroopMemberInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zlo
 * JD-Core Version:    0.7.0.1
 */