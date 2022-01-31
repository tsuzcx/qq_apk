import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import java.util.Map;

public class afa
  extends FriendListObserver
{
  public afa(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l != 0L) {
        this.a.a(l);
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        long l = 0L;
      }
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
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131363419, 1500);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c))) {
      return;
    }
    this.a.u();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afa
 * JD-Core Version:    0.7.0.1
 */