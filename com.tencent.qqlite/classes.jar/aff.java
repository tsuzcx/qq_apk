import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import mqq.observer.AccountObserver;

public class aff
  extends AccountObserver
{
  public aff(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
    if (paramString1 == null) {
      while (i > 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b - 1);
        i -= 1;
      }
    }
    TroopUtils.a(paramString1, this.a.app.a(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.d, this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aff
 * JD-Core Version:    0.7.0.1
 */