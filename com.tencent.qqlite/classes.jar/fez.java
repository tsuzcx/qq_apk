import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

public class fez
  implements Runnable
{
  public fez(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h) != null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h).mSavePath;
        UpdateManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fez
 * JD-Core Version:    0.7.0.1
 */