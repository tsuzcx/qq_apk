import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;

public class hrr
  implements Runnable
{
  public hrr(DownloadManager paramDownloadManager, String paramString) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hrr
 * JD-Core Version:    0.7.0.1
 */