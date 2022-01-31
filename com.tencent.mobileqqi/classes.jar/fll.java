import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindHandler;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;

public class fll
  extends SubAccountObserver
{
  public fll(SubAccountBindHandler paramSubAccountBindHandler, SubAccountBackProtocData paramSubAccountBackProtocData, String paramString) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramString3 == null) || (paramString2 == null) || (paramString1 == null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("handlerGetBindSubAccount: onGetKeyBack key is null or ? happen 0 ? =>");
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
        QLog.e("Q.subaccount.SubAccountBindHandler", 2, bool1);
        this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a(2, true, this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData);
        return;
        bool1 = false;
        break;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a != null) && (paramString2.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (paramString1.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a.getAccount())))
    {
      SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a, paramString2, paramString3);
      long l = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount status = " + l);
      }
      SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a, (byte)1, Long.parseLong(paramString2), HexUtil.a(paramString3), (int)l);
      this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.b = true;
      this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a(2, true, this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("handlerGetBindSubAccount: onGetKeyBack error happen 1 ? =>");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a == null) {
        bool1 = true;
      }
      QLog.e("Q.subaccount.SubAccountBindHandler", 2, bool1 + paramString2.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindHandler.a(2, true, this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fll
 * JD-Core Version:    0.7.0.1
 */