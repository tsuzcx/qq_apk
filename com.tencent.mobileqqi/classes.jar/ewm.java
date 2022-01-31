import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ewm
  implements Runnable
{
  ewm(ewl paramewl) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame", 2, "read troop members from database after updating data from server");
      }
      this.a.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences("last_update_time" + this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putLong("key_last_update_time" + this.a.a.b, System.currentTimeMillis()).commit();
      this.a.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      Object localObject = TroopMemberListInnerFrame.a(this.a.a, this.a.a.b);
      localObject = this.a.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, localObject);
      this.a.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewm
 * JD-Core Version:    0.7.0.1
 */