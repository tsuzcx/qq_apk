import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;

public class ujc
  implements Runnable
{
  public ujc(PlusPanel paramPlusPanel, TroopAppMgr paramTroopAppMgr, TroopAIOAppInfo paramTroopAIOAppInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAIOAppInfo.appid, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujc
 * JD-Core Version:    0.7.0.1
 */