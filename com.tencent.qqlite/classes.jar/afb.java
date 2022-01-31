import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class afb
  extends Thread
{
  public afb(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.h = DBUtils.a(this.a.app.a(), "troop_photo_message", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "从群空间返回，更新群空间未读计数， troopuin = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c + ", unreadmsgnum = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.h + ", newphotonum = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afb
 * JD-Core Version:    0.7.0.1
 */