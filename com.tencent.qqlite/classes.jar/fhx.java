import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK_V2;
import oicq.wlogin_sdk.tools.util;

class fhx
  implements Runnable
{
  fhx(fhw paramfhw, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentOpenBaseTicketUtils.a();
    for (;;)
    {
      boolean bool3;
      try
      {
        Object localObject = this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, this.jdField_a_of_type_Fhw.jdField_a_of_type_AndroidOsBundle);
        DownloadManager.a().e((DownloadInfo)localObject);
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0))
        {
          localObject = new StringBuilder();
          this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.uin = (this.jdField_a_of_type_JavaLangString + "&identity=" + util.buf_to_string(this.jdField_a_of_type_ArrayOfByte));
          this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.d = this.jdField_a_of_type_Fhw.jdField_a_of_type_Long;
        }
        LogUtility.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.SNGAppId + " apkId=" + this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.taskApkId + " taskAppId=" + this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.taskAppId + " packageName=" + this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.taskPackageName + " version=" + this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.taskVersion + " uin=" + this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.uin + " via=" + this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.via);
        LogUtility.c("TIME-STATISTIC", "downloadSdk.startToDownloadTaskList");
        this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c();
        if (this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2)
        {
          ((TMQQDownloaderOpenSDK)this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a).startToDownloadTaskList(this.jdField_a_of_type_Fhw.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, this.jdField_a_of_type_Fhw.jdField_a_of_type_Boolean, this.jdField_a_of_type_Fhw.b);
          return;
        }
        int i = this.jdField_a_of_type_Fhw.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.j);
        int j = this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_Fhw.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.jdField_a_of_type_Fhw.jdField_a_of_type_Boolean;
        bool3 = this.jdField_a_of_type_Fhw.b;
        if (i == 3)
        {
          bool1 = false;
          ((TMQQDownloaderOpenSDK_V2)this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a).startToDownloadTaskList(this.jdField_a_of_type_Fhw.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Fhw.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, bool1, bool2, j);
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
 * Qualified Name:     fhx
 * JD-Core Version:    0.7.0.1
 */