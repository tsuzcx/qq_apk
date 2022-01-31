import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.File;

public class esy
  implements Runnable
{
  public esy(AntiFraudConfigFileUtil paramAntiFraudConfigFileUtil, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    String str1 = AntiFraudConfigFileUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil, this.jdField_a_of_type_JavaLangString);
    File localFile = new File(str1);
    Object localObject = localFile.getParent();
    localObject = new File((String)localObject + "/download" + this.jdField_a_of_type_JavaLangString + ".xml");
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (HttpDownloadUtil.a(null, MsfSdkUtils.insertMtype("QPSingle", this.b), (File)localObject))
    {
      String str2 = SecUtil.a(((File)localObject).getAbsolutePath());
      if (this.c.equalsIgnoreCase(str2)) {}
    }
    else
    {
      return;
    }
    if (((File)localObject).renameTo(localFile))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil.a(this.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
      AntiFraudConfigFileUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil, str1);
      return;
    }
    ((File)localObject).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     esy
 * JD-Core Version:    0.7.0.1
 */