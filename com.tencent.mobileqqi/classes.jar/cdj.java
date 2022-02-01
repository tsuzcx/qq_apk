import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import java.util.Map;

public class cdj
  extends FriendListObserver
{
  public cdj(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      l = i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        long l = 0L;
      }
    }
    if (l != 0L) {
      this.a.a(l);
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f == this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g) {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g;
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562192, 1500);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c))) {
      return;
    }
    this.a.v();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cdj
 * JD-Core Version:    0.7.0.1
 */