import android.os.Handler;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

public class fys
  implements ITMAssistantDownloadSDKClientListener
{
  public fys(UniformDownloaderAppBabySdk paramUniformDownloaderAppBabySdk) {}
  
  public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString, long paramLong1, long paramLong2)
  {
    UniformDownloaderAppBabySdk.b(this.a);
    if (!UniformDownloaderAppBabySdk.a(this.a).post(new fyt(this, paramString, paramLong1, paramLong2))) {
      QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. thread error!!");
    }
  }
  
  public void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int i = 0;
    int j = 0;
    Object localObject2 = null;
    QLog.i(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[" + paramInt1 + "] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
    String str = "";
    Object localObject1;
    if ((paramTMAssistantDownloadSDKClient != null) && (4 == paramInt1))
    {
      try
      {
        localObject1 = paramTMAssistantDownloadSDKClient.getDownloadTaskState(paramString1);
        i = 0;
        paramTMAssistantDownloadSDKClient = str;
      }
      catch (Exception paramTMAssistantDownloadSDKClient)
      {
        do
        {
          for (;;)
          {
            paramTMAssistantDownloadSDKClient.printStackTrace();
            paramTMAssistantDownloadSDKClient = UniformDownloader.a(22);
            localObject1 = null;
            j = 22;
            i = 1;
            continue;
            localObject1 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
          }
        } while (UniformDownloaderAppBabySdk.a(this.a).post(new fyv(this, paramString1, paramInt1, paramInt2, paramString2, (String)localObject1)));
        QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. thread error!!");
        return;
      }
      if (localObject1 == null) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      UniformDownloaderAppBabySdk.b(this.a);
      if (i != 0)
      {
        if (!UniformDownloaderAppBabySdk.a(this.a).post(new fyu(this, paramString1, j, paramTMAssistantDownloadSDKClient))) {
          QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. haveErr and thread error!!");
        }
        return;
      }
      localObject1 = null;
      paramTMAssistantDownloadSDKClient = "";
      j = 0;
    }
  }
  
  public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient)
  {
    QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] ABSdkdownload service invalid ");
    UniformDownloaderAppBabySdk.b(this.a);
    if (!UniformDownloaderAppBabySdk.a(this.a).post(new fyw(this))) {
      QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] OnDwonloadSDKServiceInvalid. thread error!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fys
 * JD-Core Version:    0.7.0.1
 */