import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.2;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.3;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.4;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.5;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.6;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.7;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class arcn
{
  private static arcn a;
  public static final Object fE = new Object();
  final arci b = new arci(new arco(this));
  public boolean cYQ;
  public int eew;
  public int eex = 0;
  
  public static arcn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new arcn();
      }
      return a;
    }
    finally {}
  }
  
  public static void eht()
  {
    long l = System.currentTimeMillis();
    if (WebViewPluginEngine.e == null) {
      ThreadManager.postImmediately(new SwiftWebAccelerator.7(l), null, false);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("WebLog_SwiftWebAccelerator", 2, "preCreateWebViewPluginEngine preload success");
  }
  
  public int C(Bundle paramBundle)
  {
    this.eew |= 0x1;
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    }
    for (boolean bool = BaseApplicationImpl.sApplication.getSharedPreferences("sp_x5_config_" + (String)localObject, 4).getBoolean("key_x5_init_sub_thread", true);; bool = true)
    {
      long l = System.currentTimeMillis();
      QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment start! " + bool);
      if (bool)
      {
        ThreadManager.postImmediately(new SwiftWebAccelerator.3(this, l, paramBundle), null, false);
        return -1;
      }
      arcn.a.init();
      arbz.ave = System.currentTimeMillis() - l;
      QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment on main thread, cost " + arbz.ave + "ms.");
      return 1;
    }
  }
  
  public int D(Bundle paramBundle)
  {
    this.eew |= 0x2;
    long l = System.currentTimeMillis();
    SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication).Th(true);
    arbz.avf = System.currentTimeMillis() - l;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_CreateWebView:create webview cost " + arbz.avf + "ms.");
    return 1;
  }
  
  public int E(Bundle paramBundle)
  {
    this.eew |= 0x4;
    long l = System.currentTimeMillis();
    Object localObject = (String)WebAccelerateHelper.getInstance().getWebViewFeatureConfigs().get("preloadUrl");
    paramBundle = (Bundle)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (!((String)localObject).startsWith("http:"))
      {
        paramBundle = (Bundle)localObject;
        if (!((String)localObject).startsWith("https:")) {}
      }
      else
      {
        paramBundle = (Bundle)localObject;
        if (((String)localObject).startsWith("http:"))
        {
          localObject = ((String)localObject).replace("http:", "https:");
          paramBundle = (Bundle)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("WebLog_SwiftWebAccelerator", 2, "WarnUpWebView replace https");
            paramBundle = (Bundle)localObject;
          }
        }
        localObject = SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication);
        Intent localIntent = new Intent();
        localIntent.putExtra("ignoreLoginWeb", true);
        ((SwiftReuseTouchWebView)localObject).setIntent(localIntent);
        ((SwiftReuseTouchWebView)localObject).loadUrlOriginal(paramBundle);
        new Handler(Looper.getMainLooper()).postDelayed(new SwiftWebAccelerator.4(this, (SwiftReuseTouchWebView)localObject), 300L);
      }
    }
    arbz.avh = System.currentTimeMillis() - l;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "tendocpreload doMainStep_WarnUpWebView:load " + paramBundle + ", cost " + arbz.avh + "ms.");
    return 1;
  }
  
  public int F(Bundle paramBundle)
  {
    this.eew |= 0x10;
    long l = System.currentTimeMillis();
    Object localObject2 = (String)WebAccelerateHelper.getInstance().getWebViewFeatureConfigs().get("preloadUrl");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (!((String)localObject2).startsWith("http:"))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("https:")) {}
      }
      else
      {
        paramBundle = (Bundle)localObject2;
        if (((String)localObject2).startsWith("http:"))
        {
          localObject1 = ((String)localObject2).replace("http:", "https:");
          paramBundle = (Bundle)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("WebLog_SwiftWebAccelerator", 2, "SetCookie replace https");
            paramBundle = (Bundle)localObject1;
          }
        }
        localObject2 = SwiftBrowserCookieMonster.a(paramBundle);
        localObject1 = paramBundle;
        if (localObject2 != null)
        {
          ((SwiftBrowserCookieMonster)localObject2).a(paramBundle, null, null, null);
          localObject1 = paramBundle;
        }
      }
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_SetCookie:pre set cookie(" + (String)localObject1 + "), cost " + (System.currentTimeMillis() - l) + "ms.");
    return 1;
  }
  
  public int G(Bundle paramBundle)
  {
    this.eew |= 0x8;
    long l = System.currentTimeMillis();
    if (WebAccelerateHelper.preloadBrowserView == null)
    {
      WebAccelerateHelper.preInflaterBrowserView();
      arbz.avi = System.currentTimeMillis() - l;
      QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_CreateBrowserView, cost = " + arbz.avi + "ms.");
      return 1;
    }
    return 0;
  }
  
  public int MA()
  {
    return this.eex;
  }
  
  public void dD(Bundle paramBundle)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (!this.cYQ)
      {
        Bundle localBundle = paramBundle;
        if (paramBundle == null) {
          localBundle = new Bundle();
        }
        this.eex = localBundle.getInt("_accelerator_mode_", 0);
        this.b.cancel();
        this.b.av(localBundle);
        QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule restart and new mode is " + this.eex + ".");
        return;
      }
      QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule say no because is in real world now.");
      return;
    }
    new Handler(Looper.getMainLooper()).post(new SwiftWebAccelerator.2(this, paramBundle));
  }
  
  public void dE(Bundle paramBundle)
  {
    this.eew |= 0x400;
    ThreadManager.postImmediately(new SwiftWebAccelerator.5(this, System.currentTimeMillis(), paramBundle), null, false);
  }
  
  public void dF(Bundle paramBundle)
  {
    this.eew |= 0x800;
    ThreadManager.postImmediately(new SwiftWebAccelerator.6(this, System.currentTimeMillis()), null, false);
  }
  
  public void dG(Bundle paramBundle)
  {
    this.eew |= 0x1000;
    eht();
  }
  
  public void ehs()
  {
    if (!this.cYQ)
    {
      QLog.i("WebLog_SwiftWebAccelerator", 1, "switch 2 RealWorld and cancel state machine schedule.");
      this.cYQ = true;
      this.b.cancel();
    }
  }
  
  public static class a
  {
    public static long avr;
    static final AtomicBoolean ey = new AtomicBoolean(false);
    
    public static boolean PN()
    {
      return ey.get();
    }
    
    public static boolean init()
    {
      if (ey.compareAndSet(false, true))
      {
        long l = System.currentTimeMillis();
        HashMap localHashMap = new HashMap();
        localHashMap.put("use_speedy_classloader", Boolean.valueOf(true));
        localHashMap.put("use_dexloader_service", Boolean.valueOf(false));
        QbSdk.initTbsSettings(localHashMap);
        WebAccelerator.initTbsEnvironment(BaseApplicationImpl.sApplication.getApplicationContext(), 2);
        arbz.auK = SystemClock.elapsedRealtime();
        avr = System.currentTimeMillis() - l;
        QLog.d("WebLog_SwiftWebAccelerator", 1, "WebAccelerator.initTbsEnvironment, cost=" + (System.currentTimeMillis() - l));
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcn
 * JD-Core Version:    0.7.0.1
 */