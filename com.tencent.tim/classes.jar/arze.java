import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadManager.5.1;
import com.tencent.open.downloadnew.DownloadManager.5.2;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import mqq.os.MqqHandler;

public class arze
  implements ITMAssistantDownloadClientListener
{
  arze(aryy paramaryy) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManager.5.2(this, paramLong1, paramLong2, paramString));
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManager.5.1(this, paramTMAssistantDownloadClient, paramInt1, paramString1, paramInt2, paramString2));
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    arwt.e("DownloadManager_", "OnDwonloadSDKServiceInvalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arze
 * JD-Core Version:    0.7.0.1
 */