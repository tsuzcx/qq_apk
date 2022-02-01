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
  private static final String TAG = fq.class.getSimpleName();
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
  
  /* Error */
  public static boolean p(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 192	wf7/fq:isInitialized	()Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +8 -> 18
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: aload_0
    //   19: ifnonnull +8 -> 27
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -11 -> 13
    //   27: aload_0
    //   28: invokevirtual 66	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   31: putstatic 61	wf7/fq:rk	Landroid/content/Context;
    //   34: new 194	android/os/Handler
    //   37: dup
    //   38: invokestatic 199	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   41: invokespecial 202	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   44: putstatic 204	wf7/fq:rj	Landroid/os/Handler;
    //   47: aload_0
    //   48: invokestatic 208	wf7/fq:r	(Landroid/content/Context;)V
    //   51: invokestatic 210	wf7/fq:el	()V
    //   54: invokestatic 216	wf7/fs:ez	()Lwf7/fs;
    //   57: pop
    //   58: aload_0
    //   59: invokestatic 219	wf7/fq:q	(Landroid/content/Context;)V
    //   62: iconst_1
    //   63: putstatic 43	wf7/fq:rl	Z
    //   66: goto -53 -> 13
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramContext	Context
    //   1	23	1	bool1	boolean
    //   8	2	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	9	69	finally
    //   27	66	69	finally
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
    if (localObject != null) {}
    for (localObject = new fq.3((TMSDKCustomConfig.IThreadPoolManager)localObject);; localObject = (IThreadPool)f.ax(1))
    {
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
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.fq
 * JD-Core Version:    0.7.0.1
 */