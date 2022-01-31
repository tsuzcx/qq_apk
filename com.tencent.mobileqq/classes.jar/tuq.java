import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class tuq
  implements Runnable
{
  public tuq(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.troopinfo", 2, "init mTroopInfoData == null");
      }
      return;
    }
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
    {
      localObject1 = ContactUtils.l(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
    }
    else
    {
      label109:
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 2)) {
          break label603;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      }
    }
    label498:
    while (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
    {
      this.a.app.d(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
      }
      localObject1 = GroupCatalogTool.a(BaseApplication.getContext()).a(this.a, Long.toString(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
      if (localObject1 != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = ((GroupCatalogBean)localObject1).a();
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.f(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a == null)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
      str = null;
      Object localObject2 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if (localObject2 == null)
      {
        localObject2 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
        localObject1 = str;
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick)) {
            break label498;
          }
          localObject1 = ((TroopMemberInfo)localObject2).friendnick;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label562;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        break;
        localObject1 = str;
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick))
        {
          localObject1 = ((TroopMemberInfo)localObject2).troopnick;
          continue;
          if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject2).nick))
          {
            localObject1 = ((TroopMemberCardInfo)localObject2).nick;
          }
          else
          {
            localObject1 = str;
            if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject2).name)) {
              localObject1 = ((TroopMemberCardInfo)localObject2).name;
            }
          }
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        break label109;
      }
      this.a.b = true;
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      break label109;
    }
    label562:
    label603:
    Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
    String str = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {}
    for (boolean bool = true;; bool = false)
    {
      ((TroopHandler)localObject1).b(str, bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tuq
 * JD-Core Version:    0.7.0.1
 */