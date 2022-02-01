import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;

class thn
  implements AdIPCManager.Callback
{
  thn(thm paramthm) {}
  
  public void onCallback(AdIPCManager.Params paramParams, AdIPCManager.Result paramResult)
  {
    if (paramResult != null) {}
    for (boolean bool = paramResult.success;; bool = false)
    {
      tkw.i("GdtInterstitialAd", String.format("close.onCallback %b", new Object[] { Boolean.valueOf(bool) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thn
 * JD-Core Version:    0.7.0.1
 */