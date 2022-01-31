import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK_V2;

class ffk
  implements Runnable
{
  ffk(ffh paramffh) {}
  
  public void run()
  {
    boolean bool2 = false;
    LogUtility.c("TIME-STATISTIC", "onGetA1Fail");
    DownloadInfo localDownloadInfo = this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, this.a.jdField_a_of_type_AndroidOsBundle);
    DownloadManager.a().e(localDownloadInfo);
    for (;;)
    {
      boolean bool3;
      try
      {
        LogUtility.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.SNGAppId + " apkId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.taskApkId + " taskAppId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.taskAppId + " packageName=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.taskPackageName + " version=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.taskVersion + " uin=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.uin + " via=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.via);
        LogUtility.c("TIME-STATISTIC", "downloadSdk.startToAppDetail");
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c();
        if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2)
        {
          ((TMQQDownloaderOpenSDK)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a).startToAppDetail(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, this.a.jdField_a_of_type_Boolean, this.a.b);
          return;
        }
        int i = this.a.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.j);
        int j = this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.a.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.a.jdField_a_of_type_Boolean;
        bool3 = this.a.b;
        if (i == 3)
        {
          bool1 = false;
          ((TMQQDownloaderOpenSDK_V2)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a).startToAppDetail(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.b("MyAppApi", "startToAppDetail err", localException);
        return;
      }
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ffk
 * JD-Core Version:    0.7.0.1
 */