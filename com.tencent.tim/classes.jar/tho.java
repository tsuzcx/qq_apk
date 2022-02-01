import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdABTest;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForInterstitial;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public final class tho
{
  private static volatile tho jdField_a_of_type_Tho;
  private volatile thi jdField_a_of_type_Thi;
  private thp jdField_a_of_type_Thp = new thp();
  private GdtAppReceiver b = new GdtAppReceiver();
  private volatile boolean initialized;
  private Map<String, WeakReference<GdtInterstitialFragment>> map = new HashMap();
  
  private tho(thi paramthi)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialManager.1(this), 0);
    this.jdField_a_of_type_Thi = paramthi;
  }
  
  public static tho a()
  {
    if (jdField_a_of_type_Tho == null) {}
    try
    {
      if (jdField_a_of_type_Tho == null)
      {
        thi localthi = new thi();
        localthi.appName = "com.tencent.tangram.interstitial";
        localthi.appView = "Index";
        localthi.minVersion = "1.0.0.1";
        jdField_a_of_type_Tho = new tho(localthi);
      }
      return jdField_a_of_type_Tho;
    }
    finally {}
  }
  
  public GdtAppReceiver a()
  {
    return this.b;
  }
  
  public WeakReference<GdtInterstitialFragment> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.map.containsKey(paramString)) {
      return null;
    }
    return (WeakReference)this.map.get(paramString);
  }
  
  public thi a()
  {
    return this.jdField_a_of_type_Thi;
  }
  
  public thp a()
  {
    return this.jdField_a_of_type_Thp;
  }
  
  public boolean a(String paramString, WeakReference<GdtInterstitialFragment> paramWeakReference)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialManager", String.format("register %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
      return bool;
      if (this.map.containsKey(paramString)) {
        bool = false;
      } else if (paramWeakReference != null)
      {
        if (paramWeakReference.get() == null)
        {
          bool = false;
        }
        else
        {
          this.map.put(paramString, paramWeakReference);
          bool = true;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public boolean aF(Context paramContext)
  {
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext == null) {}
    for (boolean bool = false;; bool = paramContext.settingsForInterstitial.enablePreDownload)
    {
      tkw.i("GdtInterstitialManager", String.format("isPreDownloadEnabled %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  public boolean aG(Context paramContext)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    boolean bool;
    if (localObject == null) {
      bool = false;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialManager", String.format("canShowOnMainProcess %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject == null)
      {
        bool = false;
      }
      else
      {
        localObject = ((AppRuntime)localObject).getAccount();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          bool = false;
        }
        else
        {
          paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
          if (paramContext == null) {
            bool = false;
          } else {
            bool = AdABTest.isABTestByUIN((String)localObject, paramContext.settingsForInterstitial.abTestForProcess);
          }
        }
      }
    }
  }
  
  public void init()
  {
    tkw.i("GdtInterstitialManager", String.format("init %b", new Object[] { Boolean.valueOf(this.initialized) }));
    if (this.initialized) {
      return;
    }
    synchronized (jdField_a_of_type_Tho)
    {
      if (this.initialized) {
        return;
      }
    }
    this.initialized = true;
    AdIPCManager.INSTANCE.register("ipc_interstitial_close", new thm.a());
    AdIPCManager.INSTANCE.register("ipc_interstitial_predownload", new thr.a());
  }
  
  public long o(Context paramContext)
  {
    long l = 10000L;
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext == null) {}
    for (;;)
    {
      tkw.i("GdtInterstitialManager", String.format("getTimeoutMillis %d", new Object[] { Long.valueOf(l) }));
      return l;
      if (paramContext.settingsForInterstitial.timeoutMillis > 0) {
        l = paramContext.settingsForInterstitial.timeoutMillis;
      }
    }
  }
  
  public boolean unregister(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialManager", String.format("unregister %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
      return bool;
      if (!this.map.containsKey(paramString))
      {
        bool = false;
      }
      else
      {
        this.map.remove(paramString);
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tho
 * JD-Core Version:    0.7.0.1
 */