import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class yis
  implements Runnable
{
  public yis(TroopListAdapter2 paramTroopListAdapter2, TroopManager paramTroopManager, String paramString, TroopListAdapter2.TroopListItem paramTroopListItem, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopListAdapter2", 2, "itemTag.troopInfo.troopcode == null, queryDB");
    }
    ThreadManager.getUIHandler().post(new yit(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yis
 * JD-Core Version:    0.7.0.1
 */