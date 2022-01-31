import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class uhk
  implements Runnable
{
  uhk(uhj paramuhj, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Uhj.a.app != null)
    {
      localObject = (FriendsManager)this.jdField_a_of_type_Uhj.a.app.getManager(50);
      if (localObject != null)
      {
        localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_Uhj.a.runOnUiThread(new uhl(this, (Card)localObject));
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
 * Qualified Name:     uhk
 * JD-Core Version:    0.7.0.1
 */