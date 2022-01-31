import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;

final class yur
  implements AdIPCManager.Handler
{
  public yur()
  {
    AdIPCManager.INSTANCE.register("PRELOAD_INTERSTITIAL_OTHER_TO_MAIN", this);
  }
  
  public AdIPCManager.Result receive(AdIPCManager.Params paramParams)
  {
    yxs.b("GdtInterstitialPreDownloader", "receive");
    if (!AdProcessManager.INSTANCE.isOnMainProcess().booleanValue()) {
      return null;
    }
    yuo.a(yuo.a());
    paramParams = new AdIPCManager.Result();
    paramParams.success = true;
    return paramParams;
  }
  
  public AdIPCManager.Result send(AdIPCManager.Params paramParams)
  {
    yxs.b("GdtInterstitialPreDownloader", "send");
    return AdIPCManager.INSTANCE.send("PRELOAD_INTERSTITIAL_OTHER_TO_MAIN", paramParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yur
 * JD-Core Version:    0.7.0.1
 */