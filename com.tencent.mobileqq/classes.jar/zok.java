import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class zok
  implements Runnable
{
  public zok(MessageRoamManager paramMessageRoamManager) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
      String str = Base64.encodeToString(this.a.jdField_a_of_type_ArrayOfByte, 0);
      localSharedPreferences.edit().putString("vip_message_roam_passwordmd5" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zok
 * JD-Core Version:    0.7.0.1
 */