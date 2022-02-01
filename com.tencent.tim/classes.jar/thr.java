import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.1;
import java.lang.ref.WeakReference;

public final class thr
{
  private static volatile thr jdField_a_of_type_Thr;
  private volatile long Em = -2147483648L;
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new ths(this);
  private thj.a jdField_a_of_type_Thj$a = new tht(this);
  private volatile thj jdField_a_of_type_Thj;
  
  public static thr a()
  {
    if (jdField_a_of_type_Thr == null) {}
    try
    {
      if (jdField_a_of_type_Thr == null) {
        jdField_a_of_type_Thr = new thr();
      }
      return jdField_a_of_type_Thr;
    }
    finally {}
  }
  
  public void bCX()
  {
    tkw.i("GdtInterstitialPreDownloader", "preDownloadImpl");
    if (this.jdField_a_of_type_Thj == null) {
      synchronized (jdField_a_of_type_Thr)
      {
        if (this.jdField_a_of_type_Thj == null)
        {
          this.Em = System.currentTimeMillis();
          this.jdField_a_of_type_Thj = new thj(new WeakReference(this.jdField_a_of_type_Thj$a), tho.a().a(), -2147483648L);
        }
        return;
      }
    }
  }
  
  public void cV(Context paramContext)
  {
    paramContext = new WeakReference(paramContext);
    AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialPreDownloader.1(this, paramContext), 4, 300000L);
  }
  
  public void cW(Context paramContext)
  {
    tkw.i("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    if (tho.a().aG(paramContext)) {}
    for (paramContext = AdProcessManager.INSTANCE.getMainProcessName();; paramContext = AdProcessManager.INSTANCE.getWebProcessName())
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("IPC_ACTION", "ipc_interstitial_predownload");
      localBundle.putString("IPC_TO_PROCESS_NAME", paramContext);
      AdIPCManager.INSTANCE.send(BaseApplicationImpl.getContext(), new AdIPCManager.Params(localBundle), new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback));
      return;
    }
  }
  
  public int getStatus()
  {
    if (this.jdField_a_of_type_Thj != null) {
      return this.jdField_a_of_type_Thj.getStatus();
    }
    return -2147483648;
  }
  
  static final class a
    implements AdIPCManager.Handler
  {
    public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
    {
      String str2 = null;
      AdIPCManager.Result localResult = new AdIPCManager.Result();
      if (paramParams == null) {
        if (paramParams == null) {
          break label91;
        }
      }
      label91:
      for (String str1 = paramParams.getAction();; str1 = null)
      {
        if (paramParams != null) {
          str2 = paramParams.getToProcessName();
        }
        tkw.i("GdtInterstitialPreDownloader", String.format("IPCHandlerForPreDownload.handle action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(localResult.success) }));
        return localResult;
        if (!paramParams.isValid()) {
          break;
        }
        thr.a().bCX();
        localResult.success = true;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thr
 * JD-Core Version:    0.7.0.1
 */