import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class trd
  extends SubAccountBindObserver
{
  public trd(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      paramSubAccountBackProtocData = paramSubAccountBackProtocData.c();
      if ((paramSubAccountBackProtocData != null) && (!paramSubAccountBackProtocData.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    paramSubAccountBackProtocData = (SubAccountControll)this.a.app.getManager(61);
    SubAccountUgActivity.a(this.a, paramSubAccountBackProtocData, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramSubAccountBackProtocData == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramSubAccountBackProtocData.c)))) {}
    do
    {
      return;
      this.a.c();
      if (this.a.b)
      {
        this.a.b = false;
        if (paramBoolean)
        {
          this.a.a();
          this.a.c(this.a.getString(2131436357));
          return;
        }
        this.a.b(this.a.getString(2131436328));
        return;
      }
    } while (!paramBoolean);
    paramSubAccountBackProtocData = (SubAccountControll)this.a.app.getManager(61);
    Pair localPair = paramSubAccountBackProtocData.a(this.a.jdField_a_of_type_JavaLangString, 1);
    paramSubAccountBackProtocData.a(this.a.app, this.a, localPair, new tre(this, paramSubAccountBackProtocData, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trd
 * JD-Core Version:    0.7.0.1
 */