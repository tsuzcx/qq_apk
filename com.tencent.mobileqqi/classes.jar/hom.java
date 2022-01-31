import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import java.io.File;

public class hom
  implements Runnable
{
  public hom(UpdateManager paramUpdateManager, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists())
      {
        long l = localFile.length();
        DownloadManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, l);
        return;
      }
      LogUtility.c(UpdateManager.jdField_a_of_type_JavaLangString, "patchNewApk report file not exists");
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(UpdateManager.jdField_a_of_type_JavaLangString, "patchNewApk report>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hom
 * JD-Core Version:    0.7.0.1
 */