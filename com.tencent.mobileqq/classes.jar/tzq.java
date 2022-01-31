import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class tzq
  implements Runnable
{
  tzq(tzp paramtzp, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Tzp.a.app != null)
    {
      localObject = (FriendsManager)this.jdField_a_of_type_Tzp.a.app.getManager(50);
      if (localObject != null)
      {
        localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_Tzp.a.runOnUiThread(new tzr(this, (Card)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.d("Q.systemmsg.TroopRequestActivity", 2, "onUpdateFriendInfo app is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tzq
 * JD-Core Version:    0.7.0.1
 */