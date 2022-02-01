import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import java.lang.ref.WeakReference;

public final class thm
{
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new thn(this);
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  private boolean aOX;
  private boolean aOY;
  private boolean closed;
  
  public thm(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = paramGdtInterstitialParams;
    tlo.a().a(paramContext, null);
    if (tho.a().aF(paramContext)) {
      thr.a().cW(paramContext);
    }
  }
  
  private GdtInterstitialParams a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  }
  
  public void bj(Activity paramActivity)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialAd", String.format("close %b", new Object[] { Boolean.valueOf(bool) }));
      return;
      if (this.aOX)
      {
        if (this.closed)
        {
          bool = false;
        }
        else if (a() == null)
        {
          bool = false;
        }
        else
        {
          this.closed = true;
          if (tho.a().aG(paramActivity)) {}
          for (String str = AdProcessManager.INSTANCE.getMainProcessName();; str = AdProcessManager.INSTANCE.getWebProcessName())
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("IPC_ACTION", "ipc_interstitial_close");
            localBundle.putString("IPC_TO_PROCESS_NAME", str);
            localBundle.putString("TRACE_ID", a().getTraceId());
            AdIPCManager.INSTANCE.send(paramActivity, new AdIPCManager.Params(localBundle), new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback));
            bool = true;
            break;
          }
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public boolean iD()
  {
    if ((!this.aOX) && (a() != null)) {
      return a().iD();
    }
    return false;
  }
  
  public void onClose(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    tkw.i("GdtInterstitialAd", "onClose");
    if ((paramIntent != null) || ((GdtInterstitialStatus)paramIntent.getParcelableExtra("interstitialStatus") == null)) {}
    while (this.aOY) {
      return;
    }
    try
    {
      if (this.aOY) {
        return;
      }
    }
    finally {}
    this.aOY = true;
  }
  
  public boolean show(Activity paramActivity)
  {
    int i;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      i = 1;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialAd", String.format("show %d", new Object[] { Integer.valueOf(i) }));
      if (i != 0) {
        break;
      }
      return true;
      if (!iD())
      {
        i = 1;
      }
      else
      {
        int j = GdtInterstitialFragment.a(paramActivity, a());
        i = j;
        if (j == 0)
        {
          this.aOX = true;
          i = 0;
        }
      }
    }
    return false;
  }
  
  public static final class a
    implements AdIPCManager.Handler
  {
    public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
    {
      String str2 = null;
      AdIPCManager.Result localResult = new AdIPCManager.Result();
      if (paramParams == null) {
        if (paramParams == null) {
          break label179;
        }
      }
      label179:
      for (String str1 = paramParams.getAction();; str1 = null)
      {
        if (paramParams != null) {
          str2 = paramParams.getToProcessName();
        }
        tkw.i("GdtInterstitialAd", String.format("IPCHandlerForClose.handle action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(localResult.success) }));
        return localResult;
        if ((!paramParams.isValid()) || (paramParams.bundle == null)) {
          break;
        }
        str1 = paramParams.bundle.getString("TRACE_ID");
        if (paramParams.bundle == null) {
          break;
        }
        WeakReference localWeakReference = tho.a().a(str1);
        if ((localWeakReference == null) || (localWeakReference.get() == null)) {
          break;
        }
        thp.c(BaseApplicationImpl.getContext(), ((GdtInterstitialFragment)localWeakReference.get()).a(), ((GdtInterstitialFragment)localWeakReference.get()).a());
        localResult.success = true;
        AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialAd.IPCHandlerForClose.1(this, str1), 0, 2000L);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thm
 * JD-Core Version:    0.7.0.1
 */