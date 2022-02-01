package com.tencent.mm.sdk.platformtools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
  
  /* Error */
  private static Intent a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 51	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore 5
    //   6: aload 5
    //   8: iconst_0
    //   9: invokevirtual 57	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   12: astore 6
    //   14: aload 6
    //   16: ifnull +319 -> 335
    //   19: aload 6
    //   21: invokeinterface 63 1 0
    //   26: ifle +309 -> 335
    //   29: new 65	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 67
    //   35: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore 7
    //   40: aload 7
    //   42: aload 6
    //   44: invokeinterface 63 1 0
    //   49: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 76
    //   55: aload 7
    //   57: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: iconst_0
    //   64: istore_2
    //   65: aload 6
    //   67: invokeinterface 63 1 0
    //   72: istore_3
    //   73: iload_2
    //   74: iload_3
    //   75: if_icmpge +260 -> 335
    //   78: new 65	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 88
    //   84: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: astore 7
    //   89: aload 7
    //   91: aload 6
    //   93: iload_2
    //   94: invokeinterface 92 2 0
    //   99: checkcast 94	android/content/pm/PackageInfo
    //   102: getfield 98	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   105: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: ldc 76
    //   111: aload 7
    //   113: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: new 103	android/content/Intent
    //   122: dup
    //   123: invokespecial 104	android/content/Intent:<init>	()V
    //   126: astore 7
    //   128: aload 7
    //   130: aload 6
    //   132: iload_2
    //   133: invokeinterface 92 2 0
    //   138: checkcast 94	android/content/pm/PackageInfo
    //   141: getfield 98	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   144: invokevirtual 108	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   147: pop
    //   148: aload 5
    //   150: aload 7
    //   152: iconst_0
    //   153: invokevirtual 112	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   156: astore 7
    //   158: aload 7
    //   160: ifnull +14 -> 174
    //   163: aload 7
    //   165: invokeinterface 63 1 0
    //   170: istore_3
    //   171: goto +5 -> 176
    //   174: iconst_0
    //   175: istore_3
    //   176: iload_3
    //   177: ifle +146 -> 323
    //   180: new 65	java/lang/StringBuilder
    //   183: dup
    //   184: ldc 114
    //   186: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: astore 8
    //   191: aload 8
    //   193: iload_3
    //   194: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: ldc 76
    //   200: aload 8
    //   202: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: iconst_0
    //   209: istore 4
    //   211: iload 4
    //   213: iload_3
    //   214: if_icmpge +109 -> 323
    //   217: aload 7
    //   219: iload 4
    //   221: invokeinterface 92 2 0
    //   226: checkcast 116	android/content/pm/ResolveInfo
    //   229: getfield 120	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   232: astore 8
    //   234: aload 8
    //   236: getfield 125	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   239: aload_1
    //   240: invokevirtual 131	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   243: ifeq +54 -> 297
    //   246: new 103	android/content/Intent
    //   249: dup
    //   250: ldc 133
    //   252: invokespecial 134	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   255: astore 7
    //   257: aload 7
    //   259: new 136	android/content/ComponentName
    //   262: dup
    //   263: aload 8
    //   265: getfield 137	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   268: aload 8
    //   270: getfield 125	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   273: invokespecial 139	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: invokevirtual 143	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   279: pop
    //   280: aload 7
    //   282: ldc 145
    //   284: invokevirtual 148	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   287: pop
    //   288: aload_0
    //   289: aload 7
    //   291: invokevirtual 152	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   294: aload 7
    //   296: areturn
    //   297: iload 4
    //   299: iconst_1
    //   300: iadd
    //   301: istore 4
    //   303: goto -92 -> 211
    //   306: astore 7
    //   308: aload 7
    //   310: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   313: goto +10 -> 323
    //   316: astore 7
    //   318: aload 7
    //   320: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   323: iload_2
    //   324: iconst_1
    //   325: iadd
    //   326: istore_2
    //   327: goto -262 -> 65
    //   330: astore_0
    //   331: aload_0
    //   332: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   335: aconst_null
    //   336: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramContext	Context
    //   0	337	1	paramString	String
    //   64	263	2	i	int
    //   72	143	3	j	int
    //   209	93	4	k	int
    //   4	145	5	localPackageManager	android.content.pm.PackageManager
    //   12	119	6	localList	java.util.List
    //   38	257	7	localObject1	Object
    //   306	3	7	localException1	Exception
    //   316	3	7	localException2	Exception
    //   189	80	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   180	208	306	java/lang/Exception
    //   217	294	306	java/lang/Exception
    //   78	158	316	java/lang/Exception
    //   163	171	316	java/lang/Exception
    //   308	313	316	java/lang/Exception
    //   0	14	330	java/lang/Exception
    //   19	63	330	java/lang/Exception
    //   65	73	330	java/lang/Exception
    //   318	323	330	java/lang/Exception
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
        StringBuilder localStringBuilder = new StringBuilder("uid is ");
        localStringBuilder.append(str);
        localStringBuilder.append("  policy is ");
        localStringBuilder.append((String)localObject);
        Log.e("MicroMsg.NetStatusUtil", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder("isAvailable ");
      localStringBuilder.append(paramContext.isAvailable());
      Log.e("MicroMsg.NetStatusUtil", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("isConnected ");
      localStringBuilder.append(paramContext.isConnected());
      Log.e("MicroMsg.NetStatusUtil", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("isRoaming ");
      localStringBuilder.append(paramContext.isRoaming());
      Log.e("MicroMsg.NetStatusUtil", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("isFailover ");
      localStringBuilder.append(paramContext.isFailover());
      Log.e("MicroMsg.NetStatusUtil", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("getSubtypeName ");
      localStringBuilder.append(paramContext.getSubtypeName());
      Log.e("MicroMsg.NetStatusUtil", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("getExtraInfo ");
      localStringBuilder.append(paramContext.getExtraInfo());
      Log.e("MicroMsg.NetStatusUtil", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("activeNetInfo ");
      localStringBuilder.append(paramContext.toString());
      Log.e("MicroMsg.NetStatusUtil", localStringBuilder.toString());
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
        if (j != 0) {
          return 0;
        }
        if ((i == 1) || (i == 0)) {
          return 3;
        }
      }
      else
      {
        return 0;
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
    if (paramContext != null)
    {
      if (paramContext.length() < 5) {
        return 0;
      }
      paramContext = paramContext.substring(0, 5);
      Log.d("MicroMsg.NetStatusUtil", "getISPCode MCC_MNC=%s", new Object[] { paramContext });
      return Integer.valueOf(paramContext).intValue();
    }
    return 0;
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
      default: 
        return 102400;
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
        return 102400;
      case 2: 
        return 8192;
      }
      return 4096;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 102400;
  }
  
  public static boolean is2G(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 5) && (paramInt != 6) && (paramInt != 7)) {
      return paramInt == 8;
    }
    return true;
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
    catch (Exception paramContext)
    {
      label20:
      break label20;
    }
    return false;
  }
  
  public static boolean isImmediatelyDestroyActivities(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "always_finish_activities", 0) != 0;
  }
  
  public static boolean isLimited(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1)) {
      return paramInt == 3;
    }
    return true;
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
      paramContext = new StringBuilder("policy is ");
      paramContext.append(j);
      Log.e("MicroMsg.NetStatusUtil", paramContext.toString());
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
    //   0: invokestatic 477	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: ldc_w 479
    //   6: invokevirtual 483	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   9: astore_0
    //   10: new 485	java/io/DataOutputStream
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 491	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   18: invokespecial 494	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore 5
    //   23: aload_0
    //   24: astore_1
    //   25: aload 5
    //   27: astore 4
    //   29: aload 5
    //   31: ldc_w 496
    //   34: invokevirtual 499	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: astore_1
    //   39: aload 5
    //   41: astore 4
    //   43: aload 5
    //   45: invokevirtual 502	java/io/DataOutputStream:flush	()V
    //   48: aload_0
    //   49: astore_1
    //   50: aload 5
    //   52: astore 4
    //   54: aload_0
    //   55: invokevirtual 505	java/lang/Process:waitFor	()I
    //   58: pop
    //   59: aload 5
    //   61: invokevirtual 508	java/io/DataOutputStream:close	()V
    //   64: aload_0
    //   65: ifnull +15 -> 80
    //   68: aload_0
    //   69: invokevirtual 511	java/lang/Process:destroy	()V
    //   72: goto +8 -> 80
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_2
    //   83: aload_0
    //   84: astore_3
    //   85: aload 5
    //   87: astore_0
    //   88: goto +35 -> 123
    //   91: astore_1
    //   92: aconst_null
    //   93: astore 4
    //   95: goto +108 -> 203
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_0
    //   102: astore_3
    //   103: aload_1
    //   104: astore_0
    //   105: goto +18 -> 123
    //   108: astore_1
    //   109: aconst_null
    //   110: astore 4
    //   112: aload 4
    //   114: astore_0
    //   115: goto +88 -> 203
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_0
    //   122: astore_3
    //   123: aload_3
    //   124: astore_1
    //   125: aload_0
    //   126: astore 4
    //   128: new 65	java/lang/StringBuilder
    //   131: dup
    //   132: ldc_w 513
    //   135: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: astore 5
    //   140: aload_3
    //   141: astore_1
    //   142: aload_0
    //   143: astore 4
    //   145: aload 5
    //   147: aload_2
    //   148: invokevirtual 516	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   151: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_3
    //   156: astore_1
    //   157: aload_0
    //   158: astore 4
    //   160: ldc 76
    //   162: aload 5
    //   164: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_0
    //   171: ifnull +10 -> 181
    //   174: aload_0
    //   175: invokevirtual 508	java/io/DataOutputStream:close	()V
    //   178: goto +3 -> 181
    //   181: aload_3
    //   182: ifnull +14 -> 196
    //   185: aload_3
    //   186: invokevirtual 511	java/lang/Process:destroy	()V
    //   189: goto +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_2
    //   199: aload_1
    //   200: astore_0
    //   201: aload_2
    //   202: astore_1
    //   203: aload 4
    //   205: ifnull +11 -> 216
    //   208: aload 4
    //   210: invokevirtual 508	java/io/DataOutputStream:close	()V
    //   213: goto +3 -> 216
    //   216: aload_0
    //   217: ifnull +14 -> 231
    //   220: aload_0
    //   221: invokevirtual 511	java/lang/Process:destroy	()V
    //   224: goto +7 -> 231
    //   227: aload_0
    //   228: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   231: aload_1
    //   232: athrow
    //   233: astore_0
    //   234: goto -42 -> 192
    //   237: astore_0
    //   238: goto -11 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	60	0	localProcess1	java.lang.Process
    //   75	9	0	localException1	Exception
    //   87	141	0	localObject1	Object
    //   233	1	0	localException2	Exception
    //   237	1	0	localException3	Exception
    //   24	26	1	localProcess2	java.lang.Process
    //   91	1	1	localObject2	Object
    //   100	4	1	localObject3	Object
    //   108	1	1	localObject4	Object
    //   124	108	1	localObject5	Object
    //   82	1	2	localException4	Exception
    //   98	1	2	localException5	Exception
    //   118	30	2	localException6	Exception
    //   198	4	2	localObject6	Object
    //   84	102	3	localObject7	Object
    //   27	182	4	localObject8	Object
    //   21	142	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   59	64	75	java/lang/Exception
    //   68	72	75	java/lang/Exception
    //   29	37	82	java/lang/Exception
    //   43	48	82	java/lang/Exception
    //   54	59	82	java/lang/Exception
    //   10	23	91	finally
    //   10	23	98	java/lang/Exception
    //   0	10	108	finally
    //   0	10	118	java/lang/Exception
    //   29	37	198	finally
    //   43	48	198	finally
    //   54	59	198	finally
    //   128	140	198	finally
    //   145	155	198	finally
    //   160	170	198	finally
    //   174	178	233	java/lang/Exception
    //   185	189	233	java/lang/Exception
    //   208	213	237	java/lang/Exception
    //   220	224	237	java/lang/Exception
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    try
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("android.settings.WIFI_IP_SETTINGS");
      paramContext.startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException1)
    {
      Object localObject;
      label55:
      break label55;
    }
    a(paramContext, "AdvancedSettings");
    return;
    label146:
    label198:
    try
    {
      localObject = new Intent("/");
      ((Intent)localObject).setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      paramContext.startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException2)
    {
      label105:
      break label105;
    }
    try
    {
      localObject = new Intent("/");
      ((Intent)localObject).setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      paramContext.startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException3)
    {
      break label146;
    }
    for (localObject = "ManageAccountsSettings";; localObject = "DevelopmentSettings")
    {
      a(paramContext, (String)localObject);
      return;
      try
      {
        localObject = new Intent("/");
        ((Intent)localObject).setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        paramContext.startActivity((Intent)localObject);
        return;
      }
      catch (Exception localException4)
      {
        break label198;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.NetStatusUtil
 * JD-Core Version:    0.7.0.1
 */