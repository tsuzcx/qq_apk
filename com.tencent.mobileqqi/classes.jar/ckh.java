import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;

public class ckh
  implements Runnable
{
  public ckh(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_AndroidOsHandler == null)) {}
    label116:
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l != 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label116;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l = 0;
        DBUtils.a(this.a.b.a(), "troop_notification_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.j > 0) {
          break;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ckh
 * JD-Core Version:    0.7.0.1
 */