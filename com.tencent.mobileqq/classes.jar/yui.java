import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForInterstitial;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class yui
{
  private static volatile yui jdField_a_of_type_Yui;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
  private Map<String, WeakReference<GdtInterstitialFragment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile yuc jdField_a_of_type_Yuc;
  
  private yui(yuc paramyuc)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialManager.1(this), 0);
    this.jdField_a_of_type_Yuc = paramyuc;
  }
  
  public static yui a()
  {
    if (jdField_a_of_type_Yui == null) {}
    try
    {
      if (jdField_a_of_type_Yui == null)
      {
        yuc localyuc = new yuc();
        localyuc.a = "com.tencent.tangram.render";
        localyuc.b = "Index";
        localyuc.c = "1.0.49.5";
        jdField_a_of_type_Yui = new yui(localyuc);
      }
      return jdField_a_of_type_Yui;
    }
    finally {}
  }
  
  public long a(Context paramContext)
  {
    long l = 10000L;
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext == null) {}
    for (;;)
    {
      yxp.b("GdtInterstitialManager", String.format("getTimeoutMillis %d", new Object[] { Long.valueOf(l) }));
      return l;
      if (paramContext.settingsForInterstitial.timeoutMillis > 0) {
        l = paramContext.settingsForInterstitial.timeoutMillis;
      }
    }
  }
  
  public GdtAppReceiver a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  }
  
  public WeakReference<GdtInterstitialFragment> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return null;
    }
    return (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public yuc a()
  {
    return this.jdField_a_of_type_Yuc;
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext == null) {}
    for (boolean bool = false;; bool = paramContext.settingsForInterstitial.enablePreDownload)
    {
      yxp.b("GdtInterstitialManager", String.format("isPreDownloadEnabled %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      yxp.b("GdtInterstitialManager", String.format("unregister %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
      return bool;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        bool = false;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        bool = true;
      }
    }
  }
  
  public boolean a(String paramString, WeakReference<GdtInterstitialFragment> paramWeakReference)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      yxp.b("GdtInterstitialManager", String.format("register %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
      return bool;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        bool = false;
      } else if (paramWeakReference != null)
      {
        if (paramWeakReference.get() == null)
        {
          bool = false;
        }
        else
        {
          this.jdField_a_of_type_JavaUtilMap.put(paramString, paramWeakReference);
          bool = true;
        }
      }
      else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yui
 * JD-Core Version:    0.7.0.1
 */