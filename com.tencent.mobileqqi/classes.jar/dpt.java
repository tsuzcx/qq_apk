import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import mqq.observer.AccountObserver;

public class dpt
  extends AccountObserver
{
  public dpt(TroopInfoActivity paramTroopInfoActivity) {}
  
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
    TroopUtils.a(paramString1, this.a.b.a(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.d, this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpt
 * JD-Core Version:    0.7.0.1
 */