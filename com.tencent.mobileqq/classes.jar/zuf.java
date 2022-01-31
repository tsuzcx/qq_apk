import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindHandler;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;

public class zuf
  extends SubAccountObserver
{
  public zuf(SubAccountBindHandler paramSubAccountBindHandler, SubAccountBackProtocData paramSubAccountBackProtocData, SubAccountManager paramSubAccountManager, boolean paramBoolean) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramString3 == null) || (paramString2 == null) || (paramString1 == null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("handlerGetBindSubAccount() onGetKeyBack key is null or ? happen 0 ? =>");
        if (paramString3 != null) {
          break label107;
        }
        bool1 = true;
        paramString3 = localStringBuilder.append(bool1);
        if (paramString2 != null) {
          break label113;
        }
      }
      label107:
      label113:
      for (bool1 = true;; bool1 = false)
      {
        paramString2 = paramString3.append(bool1);
        bool1 = bool2;
        if (paramString1 == null) {
          bool1 = true;
        }
        QLog.e("SUB_ACCOUNT", 2, bool1);
        this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a(2, true, this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData);
        return;
        bool1 = false;
        break;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.b != null) && (paramString2.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c)) && (paramString1.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.b.getAccount())))
    {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.a(paramString2, paramString3, this.jdField_a_of_type_Boolean);
      SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.b, (byte)1, paramString2);
      this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.b = true;
      this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a(2, true, this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder().append("handlerGetBindSubAccount() onGetKeyBack error happen 1 ? =>app:");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.b == null) {
        bool1 = true;
      }
      QLog.d("SUB_ACCOUNT", 2, bool1 + " subUin:" + paramString2.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c) + " mainAccount:" + paramString1.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.b.getAccount()));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a(2, true, this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zuf
 * JD-Core Version:    0.7.0.1
 */