package btmsdkobf;

import android.content.Context;
import com.tmsdk.base.AbsTMSBaseConfig;
import com.tmsdk.base.TMSDKBaseContext;
import tmsdk.common.tcc.b;

public class bc
{
  static Context fp = null;
  static AbsTMSBaseConfig fq = null;
  
  public static boolean checkLicence()
  {
    try
    {
      boolean bool = bh.B().z();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static String getChannel()
  {
    return bh.B().getChannel();
  }
  
  public static boolean init(Context paramContext, AbsTMSBaseConfig paramAbsTMSBaseConfig)
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      try
      {
        eg.e("TMSDKBaseContextInner", "init, aContext:[" + paramContext + "]aTMSConfig:[" + paramAbsTMSBaseConfig + "]");
        bool1 = bool2;
        if (paramContext != null)
        {
          if (paramAbsTMSBaseConfig == null) {
            bool1 = bool2;
          }
        }
        else {
          return bool1;
        }
        fp = paramContext.getApplicationContext();
        fq = paramAbsTMSBaseConfig;
        if (!q())
        {
          eg.g("TMSDKBaseContextInner", "checkNoProguard false");
          bool1 = bool2;
          continue;
        }
        if (fq.isJavaTCC()) {
          break label122;
        }
      }
      finally {}
      if (!b.cO())
      {
        eg.g("TMSDKBaseContextInner", "loadLibraryIfNot false");
        bool1 = bool2;
      }
      else
      {
        label122:
        if ((fq.isCheckLicence()) && (!checkLicence()))
        {
          eg.g("TMSDKBaseContextInner", "checkLisence false");
          bool1 = bool2;
        }
        else
        {
          bx.ar().as();
          bx.ar().at();
          bn.M();
          bj.F();
          if (bq.Q().Y().booleanValue()) {
            bq.Q().S();
          }
          if (m())
          {
            bx.ar().au();
            bx.ar().av();
            bn.L();
            TMSDKBaseContext.aroundWifiReport();
            TMSDKBaseContext.wifiConnectRetReport();
          }
          eg.e("TMSDKBaseContextInner", "init, true");
          bool1 = true;
        }
      }
    }
  }
  
  public static boolean m()
  {
    return ec.cS().getBoolean("auto_conn", true);
  }
  
  public static Context n()
  {
    if (fp != null) {
      return fp.getApplicationContext();
    }
    eg.g("TMSDKBaseContextInner", "sContext == null");
    return null;
  }
  
  public static AbsTMSBaseConfig o()
  {
    return fq;
  }
  
  public static boolean p()
  {
    return o().getTCPServerAdd().compareToIgnoreCase("mazutest.3g.com.qq.com") == 0;
  }
  
  static boolean q()
  {
    try
    {
      Class.forName("com.qq.taf.jce.JceStruct");
      Class.forName("com.qq.taf.jce.JceInputStream");
      eg.e("TMSDKBaseContextInner", "check proguard ok");
      return true;
    }
    catch (Throwable localThrowable)
    {
      eg.g("TMSDKBaseContextInner", "is re proguard");
    }
    return false;
  }
  
  public static void setAutoConnectionSwitch(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {
      fp = paramContext.getApplicationContext();
    }
    ec.cS().putBoolean("auto_conn", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bc
 * JD-Core Version:    0.7.0.1
 */