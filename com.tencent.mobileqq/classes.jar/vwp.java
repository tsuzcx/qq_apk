import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.controller.QidianHandler.NavigationMenuConfig;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class vwp
  extends QidianBusinessObserver
{
  public vwp(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void a(boolean paramBoolean, QidianHandler.NavigationMenuConfig paramNavigationMenuConfig)
  {
    boolean bool = true;
    if ((paramBoolean) && (paramNavigationMenuConfig != null)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(paramNavigationMenuConfig.jdField_a_of_type_Long)))) {
        if (paramNavigationMenuConfig.jdField_a_of_type_Int == 1)
        {
          localQidianPubAccountBigDataHandler = (QidianPubAccountBigDataHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105);
          localPubAccountNavigationMenu = localQidianPubAccountBigDataHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          localBusinessCmrTmpChatPie = this.a;
          if (paramNavigationMenuConfig.jdField_b_of_type_Int == 0)
          {
            paramBoolean = bool;
            BusinessCmrTmpChatPie.b(localBusinessCmrTmpChatPie, paramBoolean);
            if ((localPubAccountNavigationMenu != null) && (paramNavigationMenuConfig.jdField_b_of_type_Int == localPubAccountNavigationMenu.version)) {
              break label152;
            }
            localQidianPubAccountBigDataHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramNavigationMenuConfig.jdField_b_of_type_Long);
          }
        }
      }
    }
    label152:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          PubAccountNavigationMenu localPubAccountNavigationMenu;
          for (;;)
          {
            QidianPubAccountBigDataHandler localQidianPubAccountBigDataHandler;
            BusinessCmrTmpChatPie localBusinessCmrTmpChatPie;
            return;
            paramBoolean = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
          }
          if (BusinessCmrTmpChatPie.a(this.a) == 0)
          {
            this.a.a(localPubAccountNavigationMenu);
            return;
          }
          BusinessCmrTmpChatPie.c(this.a);
          return;
        } while (!QLog.isColorLevel());
        QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response no need show");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response not the same aio");
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response error");
  }
  
  protected void a(boolean paramBoolean, PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if (paramBoolean) {
      if ((!BusinessCmrTmpChatPie.b(this.a)) && (BusinessCmrTmpChatPie.a(this.a) != 0)) {
        BusinessCmrTmpChatPie.c(this.a);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.a.a(paramPubAccountNavigationMenu);
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetNatigation response error");
  }
  
  protected void b(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramHashMap.uin))
      {
        if ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramHashMap.nickname;
          this.a.d.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
        this.a.p();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo not current uin");
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo fail");
  }
  
  protected void c(boolean paramBoolean, HashMap paramHashMap)
  {
    super.c(paramBoolean, paramHashMap);
    if ((paramBoolean) && (paramHashMap != null)) {}
    try
    {
      int i = Integer.parseInt(String.valueOf(paramHashMap.get("result")));
      String.valueOf(paramHashMap.get("master_uin"));
      long l1;
      QidianHandler localQidianHandler;
      long l2;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (i == 1))
      {
        l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        paramHashMap = ((QidianPubAccountBigDataHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        localQidianHandler = (QidianHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
        l2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        if (paramHashMap == null) {
          break label148;
        }
      }
      label148:
      for (i = paramHashMap.version;; i = 0)
      {
        localQidianHandler.a(l1, l2, i);
        return;
      }
      return;
    }
    catch (Exception paramHashMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwp
 * JD-Core Version:    0.7.0.1
 */