import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;

final class yuo
  implements AdIPCManager.Handler
{
  public yuo()
  {
    AdIPCManager.INSTANCE.register("PRELOAD_INTERSTITIAL_OTHER_TO_MAIN", this);
  }
  
  public AdIPCManager.Result receive(AdIPCManager.Params paramParams)
  {
    yxp.b("GdtInterstitialPreDownloader", "receive");
    if (!AdProcessManager.INSTANCE.isOnMainProcess().booleanValue()) {
      return null;
    }
    yul.a(yul.a());
    paramParams = new AdIPCManager.Result();
    paramParams.success = true;
    return paramParams;
  }
  
  public AdIPCManager.Result send(AdIPCManager.Params paramParams)
  {
    yxp.b("GdtInterstitialPreDownloader", "send");
    return AdIPCManager.INSTANCE.send("PRELOAD_INTERSTITIAL_OTHER_TO_MAIN", paramParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuo
 * JD-Core Version:    0.7.0.1
 */