import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class ges
  implements Runnable
{
  public ges(ProfileCardCheckUpdate paramProfileCardCheckUpdate, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate start downloadProfileCardFile url=" + this.jdField_a_of_type_JavaLangString + ",version=" + this.b);
    }
    Object localObject2;
    Object localObject3;
    int j;
    int i;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a.getPreferences();
      localObject1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a.getApplication());
      localObject2 = new File((String)localObject1 + ".tmp");
      localSharedPreferences.edit().putBoolean("is_template_list_loaded", false).commit();
      localObject3 = new DownloadInfo(this.jdField_a_of_type_JavaLangString, (File)localObject2, 0);
      j = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a, (DownloadInfo)localObject3, null, null, "param_XGSummaryCardDownloadFlow", "param_WIFISummaryCardDownloadFlow");
      if (j == 0)
      {
        i = 1;
        localSharedPreferences.edit().putBoolean("is_template_list_loaded", true).commit();
        if (i == 0) {
          break label556;
        }
        if (((File)localObject2).exists())
        {
          localObject3 = new FileInputStream((File)localObject2);
          localByteArrayOutputStream = new ByteArrayOutputStream();
          byte[] arrayOfByte = new byte[4096];
          for (;;)
          {
            i = ((InputStream)localObject3).read(arrayOfByte, 0, 4096);
            if (i == -1) {
              break;
            }
            localByteArrayOutputStream.write(arrayOfByte, 0, i);
          }
        }
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    do
    {
      do
      {
        i = 0;
        break;
        localObject3 = new String(localByteArrayOutputStream.toByteArray(), "utf-8");
      } while ((localObject3 == null) || (((String)localObject3).length() <= 0));
      localObject3 = new JSONObject((String)localObject3);
      if (!((JSONObject)localObject3).has("template")) {
        break label521;
      }
    } while (((JSONObject)localObject3).optJSONArray("template").length() <= 0);
    FileUtils.c((String)localObject1 + ".tmp", (String)localObject1);
    ((File)localObject2).delete();
    Object localObject1 = new File((String)localObject1).getParentFile().listFiles();
    if ((localObject1 != null) && (localObject1.length > 0)) {
      i = 0;
    }
    for (;;)
    {
      if (i < localObject1.length)
      {
        localObject2 = localObject1[i].getName();
        if ((((String)localObject2).startsWith("qvip_profile_template.json")) && (!((String)localObject2).endsWith("6.0.3")))
        {
          FileUtils.d((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "delete old file=" + (String)localObject2);
          }
        }
      }
      else
      {
        localException.edit().putString("cardTemplateVersion", this.b).commit();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate update template list file success version=" + this.b);
        return;
        label521:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate download file content error,url=" + this.jdField_a_of_type_JavaLangString);
        return;
        label556:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate download error resultCode=" + j + ",url=" + this.jdField_a_of_type_JavaLangString);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ges
 * JD-Core Version:    0.7.0.1
 */