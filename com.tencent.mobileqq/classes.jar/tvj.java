import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import java.util.ArrayList;
import mqq.observer.AccountObserver;

public class tvj
  extends AccountObserver
{
  public tvj(TroopInfoActivity paramTroopInfoActivity, TroopAvatarManger paramTroopAvatarManger, ArrayList paramArrayList) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    super.onUpdateSKey(paramString1, paramString2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.c) {
      return;
    }
    if (paramString1 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.runOnUiThread(new tvk(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity));
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.app, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.troopcode, paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.app.getCurrentAccountUin(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvj
 * JD-Core Version:    0.7.0.1
 */