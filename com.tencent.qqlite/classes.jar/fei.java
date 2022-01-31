import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

public class fei
  implements Runnable
{
  public fei(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k = localTMAssistantDownloadTaskInfo.mSavePath;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      }
      StaticAnalyz.a("300", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fei
 * JD-Core Version:    0.7.0.1
 */