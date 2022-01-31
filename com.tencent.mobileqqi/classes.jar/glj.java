import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountAssistantCache;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountDBOperation;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;

public class glj
  extends SubAccountObserver
{
  public glj(SubAccountDataControll paramSubAccountDataControll, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    int i = j;
    if (paramString3 != null)
    {
      i = j;
      if (paramString3.length() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3);
        i = 1;
      }
    }
    paramString1 = SubAccountDataControll.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramString1 != null) {
      SubAccountDataControll.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll).a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      if (i == 0) {
        SubAccountDataControll.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll).c();
      }
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.O, 7000);
      j = SubAccountDataControll.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int k = j - i;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initSubAccountAllData setReaded subaccount,old:" + i + " target:" + j + " increase:" + k);
      }
      if (k != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.O, 7000, k);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.O);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime == 9223372036854775804L) {
          SubAccountDataControll.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll).c("");
        } else {
          SubAccountDataControll.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll).c(TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime * 1000L, true, SubAccountAssistantCache.a));
        }
      }
      else {
        SubAccountDataControll.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll).c("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     glj
 * JD-Core Version:    0.7.0.1
 */