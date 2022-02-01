package wf7;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.wifisdk.TMSDKCustomConfig;
import com.tencent.wifisdk.TMSDKCustomConfig.IThreadPoolManager;
import com.tencent.wifisdk.TMSDKWifiManager;
import com.tencent.wifisdk.services.common.api.IThreadPool;
import com.tencent.wifisdk.services.common.api.e;
import com.tencent.wifisdk.services.common.api.f;

public class fq
{
  private static final String TAG = "fq";
  private static gd rb;
  private static gc rc;
  private static fx rd;
  private static gb re;
  private static fy rf;
  private static fw rg;
  private static ga rh;
  private static ax ri;
  private static Handler rj;
  private static Context rk;
  private static boolean rl = false;
  private static boolean rm = false;
  private static e rn;
  
  public static void G(boolean paramBoolean)
  {
    dg.i(paramBoolean);
  }
  
  public static void H(boolean paramBoolean)
  {
    rm = paramBoolean;
  }
  
  public static Context cr()
  {
    return rk.getApplicationContext();
  }
  
  private static void ej()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    cr().registerReceiver(new fq.2(), localIntentFilter);
  }
  
  public static e ek()
  {
    return rn;
  }
  
  private static void el()
  {
    rh = new ga(hi.f(cr(), "wificore"));
    bz.av().a(rk, new fq.4());
  }
  
  public static gd em()
  {
    return rb;
  }
  
  public static gb en()
  {
    return re;
  }
  
  public static fw eo()
  {
    return rg;
  }
  
  public static String ep()
  {
    String str = fm.dL().dN();
    if ((!TextUtils.isEmpty(str)) && (URLUtil.isNetworkUrl(str))) {
      return str;
    }
    return "https://tools.3g.qq.com/j/sdk102769";
  }
  
  public static boolean eq()
  {
    return rm;
  }
  
  public static Looper getSubThreadLooper()
  {
    return rb.getSubThreadLooper();
  }
  
  public static boolean isInitialized()
  {
    return rl;
  }
  
  public static boolean p(Context paramContext)
  {
    try
    {
      boolean bool = isInitialized();
      if (bool) {
        return true;
      }
      if (paramContext == null) {
        return false;
      }
      rk = paramContext.getApplicationContext();
      rj = new Handler(Looper.getMainLooper());
      r(paramContext);
      el();
      fs.ez();
      q(paramContext);
      rl = true;
      return true;
    }
    finally {}
  }
  
  private static void q(Context paramContext)
  {
    em().a(new fq.1(paramContext), "init-async");
  }
  
  private static void r(Context paramContext)
  {
    rd = new fx();
    rn = new ga(hi.f(paramContext, "common"));
    Object localObject = TMSDKWifiManager.getCustomConfig().getCustomThreadPool();
    if (localObject != null) {
      localObject = new fq.3((TMSDKCustomConfig.IThreadPoolManager)localObject);
    } else {
      localObject = (IThreadPool)f.ax(1);
    }
    rb = new gd((IThreadPool)localObject);
    fd.a(dg.bI(), rk, new gf(), new gg(rb), true, false, null);
    fd.x(false);
    rc = new gc(fd.dD());
    ri = rc;
    localObject = new ga(hi.f(cr(), "rpt_ac"));
    ga localga = new ga(hi.f(cr(), "rpt_uni"));
    re = new gb(hf.a(rb, rc, (e)localObject, localga));
    rc.a(re);
    localObject = new ga(hi.f(cr(), "conch_cache"));
    rg = new fw(gh.a(rb, rc, (e)localObject));
    rf = new fy(hd.a(rb));
    gv.n(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fq
 * JD-Core Version:    0.7.0.1
 */