import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import mqq.observer.SubAccountObserver;

public class zql
  extends SubAccountObserver
{
  public zql(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubAccountManager paramSubAccountManager) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor.a == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor.a.getAccount())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.a(paramString2, paramString3, true);
    SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor.a, (byte)1, paramString2);
    SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor.a, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zql
 * JD-Core Version:    0.7.0.1
 */