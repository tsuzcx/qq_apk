import android.content.DialogInterface.OnClickListener;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK_V2;
import oicq.wlogin_sdk.tools.util;

class ffa
  implements Runnable
{
  ffa(fez paramfez, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenBaseTicketUtils.a();
    if (this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam != null) {
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0)) {
            localStringBuilder = new StringBuilder();
          }
        }
        catch (Exception localException2)
        {
          StringBuilder localStringBuilder;
          String str;
          Object localObject;
          localException2.printStackTrace();
          continue;
          ((TMQQDownloaderOpenSDK_V2)this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).startToAuthorized(this.jdField_a_of_type_Fez.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, "2");
          continue;
        }
        try
        {
          str = util.buf_to_string(this.jdField_a_of_type_ArrayOfByte);
          this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.uin = (this.jdField_a_of_type_JavaLangString + "&identity=" + str);
          this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.d = this.jdField_a_of_type_Fez.jdField_a_of_type_Long;
          this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c();
          if (this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2)
          {
            ((TMQQDownloaderOpenSDK)this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).startToAuthorized(this.jdField_a_of_type_Fez.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, "2");
            this.jdField_a_of_type_Fez.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam = null;
            if (this.jdField_a_of_type_Fez.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
              this.jdField_a_of_type_Fez.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
            }
            return;
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject = null;
        }
      }
    }
    LogUtility.e("MyAppApi", "startToAuthorizedDirect->onGetA1 lastAuthorizeParam = null, needCarryQQIdentity = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ffa
 * JD-Core Version:    0.7.0.1
 */