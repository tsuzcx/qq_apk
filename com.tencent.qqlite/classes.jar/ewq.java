import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class ewq
  implements Runnable
{
  public ewq(String paramString, File paramFile) {}
  
  public void run()
  {
    boolean bool = HttpDownloadUtil.a(null, EmosmUtils.insertMtype("VIP_other", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "downloadAllIfNotExists, " + this.jdField_a_of_type_JavaLangString + ",ret=" + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ewq
 * JD-Core Version:    0.7.0.1
 */