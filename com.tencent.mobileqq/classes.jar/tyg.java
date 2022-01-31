import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class tyg
  implements Runnable
{
  public tyg(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    Object localObject1 = ContactUtils.l(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "mTroopInfoData.troopOwnerNick = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick);
      }
      return;
      Object localObject2 = null;
      Object localObject3 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if (localObject3 == null)
      {
        localObject3 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject3).friendnick)) {
            break label237;
          }
          localObject1 = ((TroopMemberInfo)localObject3).friendnick;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label295;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        break;
        label237:
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).troopnick))
        {
          localObject1 = ((TroopMemberInfo)localObject3).troopnick;
          continue;
          if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).nick))
          {
            localObject1 = ((TroopMemberCardInfo)localObject3).nick;
          }
          else
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).name)) {
              localObject1 = ((TroopMemberCardInfo)localObject3).name;
            }
          }
        }
      }
      label295:
      if ((!this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null))
      {
        this.a.b = true;
        this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tyg
 * JD-Core Version:    0.7.0.1
 */