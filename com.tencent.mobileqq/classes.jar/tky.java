import QQService.EVIPSPEC;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;

public class tky
  implements Runnable
{
  public tky(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label438;
        }
        Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "updateLevelAndVip card info: bSuperVipOpen=" + this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen + ",bQQVipOpen=" + this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.bQQVipOpen + ",VipLevel=" + this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipLevel + ",QQLevel=" + this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel + ",gameId = " + this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingGameId + ",gameLoginTime = " + this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingLoginTime);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localObject1 != null))
        {
          localObject1 = ((FriendsManager)localObject1).c(this.jdField_a_of_type_JavaLangString);
          if (localObject1 != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard;
            if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
              break label439;
            }
            b = 1;
            ((Card)localObject2).bQQVipOpen = b;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard;
            if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
              break label444;
            }
            b = 1;
            ((Card)localObject2).bSuperVipOpen = b;
            this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_QQVIP);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen == 1)
            {
              i = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
              ((Card)localObject2).iQQVipLevel = i;
              this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard);
              this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new tkz(this));
              return;
            }
            int i = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
            continue;
          }
          QLog.d("QQSettingRedesign", 1, "updateLevelAndVip f= null");
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label438;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      Object localObject2 = new StringBuilder().append("updateLevelAndVip error card ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
      for (String str = "not null";; str = "null")
      {
        QLog.d("QQSettingRedesign", 2, str);
        return;
      }
      label438:
      return;
      label439:
      byte b = 0;
      continue;
      label444:
      b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tky
 * JD-Core Version:    0.7.0.1
 */