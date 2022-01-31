import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;

public class hnh
  implements ITMAssistantDownloadSDKClientListener
{
  public hnh(DownloadManager paramDownloadManager) {}
  
  public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString, long paramLong1, long paramLong2)
  {
    ThreadManager.b().post(new hnj(this, paramLong1, paramLong2, paramString));
  }
  
  public void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ThreadManager.b().post(new hni(this, paramTMAssistantDownloadSDKClient, paramInt1, paramString1, paramInt2, paramString2));
  }
  
  public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient)
  {
    LogUtility.e(DownloadManager.a, "OnDwonloadSDKServiceInvalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hnh
 * JD-Core Version:    0.7.0.1
 */