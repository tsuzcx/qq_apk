import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class zbn
  implements Runnable
{
  zbn(zbm paramzbm) {}
  
  public void run()
  {
    try
    {
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        Card localCard = this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard;
        Object localObject;
        String str;
        if (localCard.strLocationCodes != null)
        {
          localObject = localCard.strLocationCodes.split("-");
          if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "parse location codes: " + localCard.strLocationCodes);
          }
          str = this.a.a.a((String[])localObject);
          localObject = str;
          if (str.equals("不限")) {
            localObject = "";
          }
          localCard.strLocationDesc = ((String)localObject);
        }
        if (localCard.strHometownCodes != null)
        {
          localObject = localCard.strHometownCodes.split("-");
          if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "parse hometown codes: " + localCard.strHometownCodes);
          }
          str = this.a.a.a((String[])localObject);
          localObject = str;
          if (str.equals("不限")) {
            localObject = "";
          }
          localCard.strHometownDesc = ((String)localObject);
        }
        ((FriendsManager)ConditionSearchManager.a(this.a.a).getManager(50)).a(localCard);
        ((CardHandler)ConditionSearchManager.a(this.a.a).a(2)).a(43, true, localCard);
      }
      this.a.a.d = false;
      this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard = null;
      this.a.a.b(this.a.a.jdField_a_of_type_JavaLangObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConditionSearch.Manager", 1, "pendCardParseRequest fail!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zbn
 * JD-Core Version:    0.7.0.1
 */