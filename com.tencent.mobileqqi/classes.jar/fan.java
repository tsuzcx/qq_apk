import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.VoiceNotifyConfigHelper;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class fan
  implements Runnable
{
  public fan(ConfigHandler paramConfigHandler, String paramString, long paramLong) {}
  
  public void run()
  {
    File localFile = new File(VoiceNotifyConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a.getApplication()));
    int i = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a, this.jdField_a_of_type_JavaLangString, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceNotify", 2, "handleUpdateVoiceNotifyActions download " + this.jdField_a_of_type_JavaLangString + " result " + i + ", file " + localFile.getPath());
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a.getPreferences().edit().putLong("k_voice_notify2_file_version", this.jdField_a_of_type_Long).commit();
      VoiceNotifyConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a.getApplication());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fan
 * JD-Core Version:    0.7.0.1
 */