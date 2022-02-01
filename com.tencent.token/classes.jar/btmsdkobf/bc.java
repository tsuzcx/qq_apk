package btmsdkobf;

import android.content.Context;
import com.tmsdk.base.AbsTMSBaseConfig;
import com.tmsdk.base.TMSDKBaseContext;
import tmsdk.common.tcc.b;

public class bc
{
  static Context fp;
  static AbsTMSBaseConfig fq;
  
  public static boolean checkLicence()
  {
    try
    {
      boolean bool = bh.B().z();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  public static String getChannel()
  {
    return bh.B().getChannel();
  }
  
  public static boolean init(Context paramContext, AbsTMSBaseConfig paramAbsTMSBaseConfig)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init, aContext:[");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("]aTMSConfig:[");
      localStringBuilder.append(paramAbsTMSBaseConfig);
      localStringBuilder.append("]");
      eg.e("TMSDKBaseContextInner", localStringBuilder.toString());
      if ((paramContext != null) && (paramAbsTMSBaseConfig != null))
      {
        fp = paramContext.getApplicationContext();
        fq = paramAbsTMSBaseConfig;
        if (!q())
        {
          eg.g("TMSDKBaseContextInner", "checkNoProguard false");
          return false;
        }
        if ((!fq.isJavaTCC()) && (!b.cO()))
        {
          eg.g("TMSDKBaseContextInner", "loadLibraryIfNot false");
          return false;
        }
        if ((fq.isCheckLicence()) && (!checkLicence()))
        {
          eg.g("TMSDKBaseContextInner", "checkLisence false");
          return false;
        }
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
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public static boolean m()
  {
    return ec.cS().getBoolean("auto_conn", true);
  }
  
  public static Context n()
  {
    Context localContext = fp;
    if (localContext != null) {
      return localContext.getApplicationContext();
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
      label21:
      break label21;
    }
    eg.g("TMSDKBaseContextInner", "is re proguard");
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