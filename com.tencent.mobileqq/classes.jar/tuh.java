import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class tuh
  extends MessageObserver
{
  public tuh(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + "  errorMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if ((paramSubAccountBackProtocData == null) || (paramString == null) || (paramString.length() < 5)) {}
    SubAccountControll localSubAccountControll;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localSubAccountControll = (SubAccountControll)this.a.app.getManager(61);
        if (paramSubAccountBackProtocData.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localSubAccountControll, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localSubAccountControll.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tuh
 * JD-Core Version:    0.7.0.1
 */