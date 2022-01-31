package com.tencent.mm.sdk.platformtools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class NetStatusUtil
{
  public static final int CMNET = 6;
  public static final int CMWAP = 5;
  public static final int CTNET = 8;
  public static final int CTWAP = 7;
  public static final int LTE = 10;
  public static final int MOBILE = 9;
  public static final int NET_3G = 4;
  public static final int NON_NETWORK = -1;
  public static final int NO_SIM_OPERATOR = 0;
  public static final int POLICY_NONE = 0;
  public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
  public static final int TBACKGROUND_DATA_LIMITED = 2;
  public static final int TBACKGROUND_NOT_LIMITED = 0;
  public static final int TBACKGROUND_PROCESS_LIMITED = 1;
  public static final int TBACKGROUND_WIFI_LIMITED = 3;
  public static final int UNINET = 1;
  public static final int UNIWAP = 2;
  public static final int WAP_3G = 3;
  public static final int WIFI = 0;
  
  private static Intent a(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      List localList = localPackageManager.getInstalledPackages(0);
      if ((localList != null) && (localList.size() > 0))
      {
        Log.e("MicroMsg.NetStatusUtil", "package  size" + localList.size());
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break label314;
          }
          try
          {
            Log.e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo)localList.get(i)).packageName);
            Object localObject1 = new Intent();
            ((Intent)localObject1).setPackage(((PackageInfo)localList.get(i)).packageName);
            Object localObject2 = localPackageManager.queryIntentActivities((Intent)localObject1, 0);
            if (localObject2 != null) {
              j = ((List)localObject2).size();
            }
            for (;;)
            {
              if (j > 0) {
                try
                {
                  Log.e("MicroMsg.NetStatusUtil", "activityName count " + j);
                  int k = 0;
                  for (;;)
                  {
                    if (k >= j) {
                      break label292;
                    }
                    localObject1 = ((ResolveInfo)((List)localObject2).get(k)).activityInfo;
                    if (((ActivityInfo)localObject1).name.contains(paramString))
                    {
                      localObject2 = new Intent("/");
                      ((Intent)localObject2).setComponent(new ComponentName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name));
                      ((Intent)localObject2).setAction("android.intent.action.VIEW");
                      paramContext.startActivity((Intent)localObject2);
                      return localObject2;
                      j = 0;
                      break;
                    }
                    k += 1;
                  }
                  i += 1;
                }
                catch (Exception localException1)
                {
                  localException1.printStackTrace();
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              label292:
              localException2.printStackTrace();
            }
          }
        }
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean checkFromXml(int paramInt)
  {
    try
    {
      runRootCommand();
      NodeList localNodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(new File("/data/system/netpolicy.xml"))).getDocumentElement().getElementsByTagName("uid-policy");
      int i = 0;
      while (i < localNodeList.getLength())
      {
        Object localObject = (Element)localNodeList.item(i);
        String str = ((Element)localObject).getAttribute("uid");
        localObject = ((Element)localObject).getAttribute("policy");
        Log.e("MicroMsg.NetStatusUtil", "uid is " + str + "  policy is " + (String)localObject);
        if (str.equals(Integer.toString(paramInt)))
        {
          if (Integer.parseInt((String)localObject) == 1) {
            return true;
          }
          int j = Integer.parseInt((String)localObject);
          if (j == 0) {
            return false;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void dumpNetStatus(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      Log.e("MicroMsg.NetStatusUtil", "isAvailable " + paramContext.isAvailable());
      Log.e("MicroMsg.NetStatusUtil", "isConnected " + paramContext.isConnected());
      Log.e("MicroMsg.NetStatusUtil", "isRoaming " + paramContext.isRoaming());
      Log.e("MicroMsg.NetStatusUtil", "isFailover " + paramContext.isFailover());
      Log.e("MicroMsg.NetStatusUtil", "getSubtypeName " + paramContext.getSubtypeName());
      Log.e("MicroMsg.NetStatusUtil", "getExtraInfo " + paramContext.getExtraInfo());
      Log.e("MicroMsg.NetStatusUtil", "activeNetInfo " + paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Object localObject = Class.forName("android.app.ActivityManagerNative");
        localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
        i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
        if (i == 0) {
          return 1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    try
    {
      i = getWifiSleeepPolicy(paramContext);
      if (i != 2)
      {
        int j = getNetType(paramContext);
        if (j == 0) {}
      }
      else
      {
        return 0;
      }
      if ((i == 1) || (i == 0)) {
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    if ((paramContext == null) || (paramContext.length() < 5)) {
      return 0;
    }
    paramContext = paramContext.substring(0, 5);
    Log.d("MicroMsg.NetStatusUtil", "getISPCode MCC_MNC=%s", new Object[] { paramContext });
    return Integer.valueOf(paramContext).intValue();
  }
  
  public static String getISPName(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "";
    }
    Log.d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", new Object[] { paramContext.getSimOperatorName() });
    if (paramContext.getSimOperatorName().length() <= 100) {
      return paramContext.getSimOperatorName();
    }
    return paramContext.getSimOperatorName().substring(0, 100);
  }
  
  public static int getNetType(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return -1;
    }
    if (paramContext.getType() == 1) {
      return 0;
    }
    Log.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet")) {
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap")) {
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap")) {
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet")) {
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap")) {
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet")) {
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap")) {
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet")) {
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE")) {
        return 10;
      }
    }
    return 9;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "NON_NETWORK";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return "NON_NETWORK";
    }
    if (paramContext.getType() == 1) {
      return "WIFI";
    }
    Log.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
    if (paramContext.getExtraInfo() != null) {
      return paramContext.getExtraInfo();
    }
    return "MOBILE";
  }
  
  public static int getWifiSleeepPolicy(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
  }
  
  public static int guessNetSpeed(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return 102400;
      }
      int i = paramContext.getSubtype();
      switch (i)
      {
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    return 102400;
    return 4096;
    return 8192;
    return 102400;
  }
  
  public static boolean is2G(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8);
  }
  
  public static boolean is2G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      if (paramContext.getSubtype() != 2)
      {
        int i = paramContext.getSubtype();
        if (i != 1) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean is3G(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4);
  }
  
  public static boolean is3G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      if (paramContext.getSubtype() >= 5)
      {
        int i = paramContext.getSubtype();
        if (i < 13) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean is4G(int paramInt)
  {
    return paramInt == 10;
  }
  
  public static boolean is4G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      int i = paramContext.getSubtype();
      if (i >= 13) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    try
    {
      boolean bool = paramContext.isConnected();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isImmediatelyDestroyActivities(Context paramContext)
  {
    boolean bool = false;
    if (Settings.System.getInt(paramContext.getContentResolver(), "always_finish_activities", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(int paramInt)
  {
    return (is3G(paramInt)) || (is2G(paramInt)) || (is4G(paramInt));
  }
  
  public static boolean isMobile(Context paramContext)
  {
    int i = getNetType(paramContext);
    return (is3G(i)) || (is2G(i)) || (is4G(i));
  }
  
  public static boolean isRestrictBacground(Context paramContext)
  {
    int i = paramContext.getApplicationInfo().uid;
    try
    {
      Object localObject = Class.forName("android.net.NetworkPolicyManager");
      paramContext = ((Class)localObject).getMethod("getSystemService", new Class[] { Context.class }).invoke(localObject, new Object[] { paramContext });
      localObject = ((Class)localObject).getDeclaredField("mService");
      ((Field)localObject).setAccessible(true);
      paramContext = ((Field)localObject).get(paramContext);
      int j = ((Integer)paramContext.getClass().getMethod("getUidPolicy", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(i) })).intValue();
      Log.e("MicroMsg.NetStatusUtil", "policy is " + j);
      if (j == 1) {
        return true;
      }
      if (j == 0) {
        return false;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return checkFromXml(i);
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    return isWap(getNetType(paramContext));
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    return isWifi(getNetType(paramContext));
  }
  
  /* Error */
  public static boolean runRootCommand()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 477	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   7: ldc_w 479
    //   10: invokevirtual 483	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   13: astore_0
    //   14: new 485	java/io/DataOutputStream
    //   17: dup
    //   18: aload_0
    //   19: invokevirtual 491	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   22: invokespecial 494	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_1
    //   26: aload_1
    //   27: ldc_w 496
    //   30: invokevirtual 499	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 502	java/io/DataOutputStream:flush	()V
    //   37: aload_0
    //   38: invokevirtual 505	java/lang/Process:waitFor	()I
    //   41: pop
    //   42: aload_1
    //   43: invokevirtual 508	java/io/DataOutputStream:close	()V
    //   46: aload_0
    //   47: ifnull +7 -> 54
    //   50: aload_0
    //   51: invokevirtual 511	java/lang/Process:destroy	()V
    //   54: iconst_1
    //   55: ireturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   61: goto -7 -> 54
    //   64: astore_0
    //   65: aconst_null
    //   66: astore_1
    //   67: ldc 65
    //   69: new 67	java/lang/StringBuilder
    //   72: dup
    //   73: ldc_w 513
    //   76: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_0
    //   80: invokevirtual 516	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   83: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 508	java/io/DataOutputStream:close	()V
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 511	java/lang/Process:destroy	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   115: goto -7 -> 108
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_3
    //   121: aload_1
    //   122: astore_2
    //   123: aload_3
    //   124: astore_1
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 508	java/io/DataOutputStream:close	()V
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 511	java/lang/Process:destroy	()V
    //   141: aload_0
    //   142: athrow
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   148: goto -7 -> 141
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_1
    //   154: aload_0
    //   155: astore_2
    //   156: aload_3
    //   157: astore_0
    //   158: goto -33 -> 125
    //   161: astore_3
    //   162: aload_0
    //   163: astore_2
    //   164: aload_3
    //   165: astore_0
    //   166: goto -41 -> 125
    //   169: astore_0
    //   170: goto -45 -> 125
    //   173: astore_3
    //   174: aconst_null
    //   175: astore_1
    //   176: aload_0
    //   177: astore_2
    //   178: aload_3
    //   179: astore_0
    //   180: goto -113 -> 67
    //   183: astore_3
    //   184: aload_0
    //   185: astore_2
    //   186: aload_3
    //   187: astore_0
    //   188: goto -121 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	38	0	localProcess	java.lang.Process
    //   56	2	0	localException1	Exception
    //   64	16	0	localException2	Exception
    //   110	2	0	localException3	Exception
    //   118	37	0	localObject1	Object
    //   157	9	0	localObject2	Object
    //   169	8	0	localObject3	Object
    //   179	9	0	localObject4	Object
    //   1	129	1	localObject5	Object
    //   143	2	1	localException4	Exception
    //   153	23	1	localObject6	Object
    //   3	183	2	localObject7	Object
    //   120	4	3	localObject8	Object
    //   151	6	3	localObject9	Object
    //   161	4	3	localObject10	Object
    //   173	6	3	localException5	Exception
    //   183	4	3	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   42	46	56	java/lang/Exception
    //   50	54	56	java/lang/Exception
    //   4	14	64	java/lang/Exception
    //   96	100	110	java/lang/Exception
    //   104	108	110	java/lang/Exception
    //   4	14	118	finally
    //   129	133	143	java/lang/Exception
    //   137	141	143	java/lang/Exception
    //   14	26	151	finally
    //   26	42	161	finally
    //   67	92	169	finally
    //   14	26	173	java/lang/Exception
    //   26	42	183	java/lang/Exception
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 2: 
      try
      {
        Intent localIntent1 = new Intent("/");
        localIntent1.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
        localIntent1.setAction("android.intent.action.VIEW");
        paramContext.startActivity(localIntent1);
        return;
      }
      catch (Exception localException1)
      {
        try
        {
          Intent localIntent2 = new Intent("/");
          localIntent2.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
          localIntent2.setAction("android.intent.action.VIEW");
          paramContext.startActivity(localIntent2);
          return;
        }
        catch (Exception localException2)
        {
          a(paramContext, "ManageAccountsSettings");
          return;
        }
      }
    case 1: 
      try
      {
        Intent localIntent3 = new Intent("/");
        localIntent3.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
        localIntent3.setAction("android.intent.action.VIEW");
        paramContext.startActivity(localIntent3);
        return;
      }
      catch (Exception localException3)
      {
        a(paramContext, "DevelopmentSettings");
        return;
      }
    }
    try
    {
      Intent localIntent4 = new Intent();
      localIntent4.setAction("android.settings.WIFI_IP_SETTINGS");
      paramContext.startActivity(localIntent4);
      return;
    }
    catch (Exception localException4)
    {
      a(paramContext, "AdvancedSettings");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.NetStatusUtil
 * JD-Core Version:    0.7.0.1
 */