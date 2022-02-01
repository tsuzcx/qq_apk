import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

public class hnk
  implements Runnable
{
  public hnk(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c).mSavePath;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        long l = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, l);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
      }
    }
    StaticAnalyz.a("300", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hnk
 * JD-Core Version:    0.7.0.1
 */