import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.6.1;

public class yue
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  yue(yud paramyud) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.6.1(this, paramAppPathInfo, paramInt, paramString), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yue
 * JD-Core Version:    0.7.0.1
 */