import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class arwo
{
  protected static Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  protected static final String TAG = arwo.class.getName();
  
  public static String K(Context paramContext)
  {
    return AppNetConnInfo.getCurrentAPN();
  }
  
  public static String bE(Context paramContext)
  {
    int i = by(paramContext);
    if (i == 2) {
      paramContext = "wifi";
    }
    String str;
    do
    {
      return paramContext;
      if (i == 1) {
        return "cmwap";
      }
      if (i == 4) {
        return "cmnet";
      }
      if (i == 16) {
        return "uniwap";
      }
      if (i == 8) {
        return "uninet";
      }
      if (i == 64) {
        return "wap";
      }
      if (i == 32) {
        return "net";
      }
      if (i == 512) {
        return "ctwap";
      }
      if (i == 256) {
        return "ctnet";
      }
      if (i == 2048) {
        return "3gnet";
      }
      if (i == 1024) {
        return "3gwap";
      }
      str = K(paramContext);
      if (str == null) {
        break;
      }
      paramContext = str;
    } while (str.length() != 0);
    return "none";
  }
  
  /* Error */
  public static String bF(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 85	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 28	arwo:PREFERRED_APN_URI	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokestatic 91	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +17 -> 35
    //   21: aload_0
    //   22: ifnull +9 -> 31
    //   25: aload_0
    //   26: invokeinterface 96 1 0
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: aload_0
    //   36: invokeinterface 100 1 0
    //   41: pop
    //   42: aload_0
    //   43: aload_0
    //   44: ldc 102
    //   46: invokeinterface 106 2 0
    //   51: invokeinterface 110 2 0
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_0
    //   60: ifnull -27 -> 33
    //   63: aload_0
    //   64: invokeinterface 96 1 0
    //   69: aload_2
    //   70: areturn
    //   71: astore_2
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   80: aload_0
    //   81: ifnull +9 -> 90
    //   84: aload_0
    //   85: invokeinterface 96 1 0
    //   90: ldc 115
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: ifnull +9 -> 106
    //   100: aload_0
    //   101: invokeinterface 96 1 0
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: goto -13 -> 96
    //   112: astore_1
    //   113: goto -17 -> 96
    //   116: astore_1
    //   117: goto -41 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   1	76	1	localObject1	Object
    //   93	14	1	localObject2	Object
    //   108	1	1	localObject3	Object
    //   112	1	1	localObject4	Object
    //   116	1	1	localException1	Exception
    //   56	14	2	str	String
    //   71	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	71	java/lang/Exception
    //   2	17	93	finally
    //   35	57	108	finally
    //   76	80	112	finally
    //   35	57	116	java/lang/Exception
  }
  
  /* Error */
  public static String bG(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 85	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 28	arwo:PREFERRED_APN_URI	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokestatic 91	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +17 -> 35
    //   21: aload_0
    //   22: ifnull +9 -> 31
    //   25: aload_0
    //   26: invokeinterface 96 1 0
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_2
    //   34: areturn
    //   35: aload_0
    //   36: invokeinterface 100 1 0
    //   41: pop
    //   42: aload_0
    //   43: invokeinterface 119 1 0
    //   48: ifeq +29 -> 77
    //   51: aload_0
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: invokeinterface 96 1 0
    //   61: ldc 121
    //   63: astore_2
    //   64: aload_0
    //   65: ifnull -32 -> 33
    //   68: aload_0
    //   69: invokeinterface 96 1 0
    //   74: ldc 121
    //   76: areturn
    //   77: aload_0
    //   78: aload_0
    //   79: ldc 123
    //   81: invokeinterface 106 2 0
    //   86: invokeinterface 110 2 0
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_2
    //   95: ifnonnull +6 -> 101
    //   98: ldc 121
    //   100: astore_1
    //   101: aload_1
    //   102: astore_2
    //   103: aload_0
    //   104: ifnull -71 -> 33
    //   107: aload_0
    //   108: invokeinterface 96 1 0
    //   113: aload_1
    //   114: areturn
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: aload_2
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   124: aload_0
    //   125: ifnull +9 -> 134
    //   128: aload_0
    //   129: invokeinterface 96 1 0
    //   134: ldc 121
    //   136: areturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: ifnull +9 -> 150
    //   144: aload_0
    //   145: invokeinterface 96 1 0
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: goto -13 -> 140
    //   156: astore_1
    //   157: goto -17 -> 140
    //   160: astore_1
    //   161: goto -41 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramContext	Context
    //   1	120	1	localObject1	Object
    //   137	14	1	localObject2	Object
    //   152	1	1	localObject3	Object
    //   156	1	1	localObject4	Object
    //   160	1	1	localException1	Exception
    //   32	71	2	localObject5	Object
    //   115	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	115	java/lang/Exception
    //   2	17	137	finally
    //   35	51	152	finally
    //   55	61	152	finally
    //   77	92	152	finally
    //   120	124	156	finally
    //   35	51	160	java/lang/Exception
    //   55	61	160	java/lang/Exception
    //   77	92	160	java/lang/Exception
  }
  
  public static String bH(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "MOBILE";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext != null) {
      return paramContext.getTypeName();
    }
    return "MOBILE";
  }
  
  /* Error */
  public static int bx(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 85	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 28	arwo:PREFERRED_APN_URI	Landroid/net/Uri;
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokestatic 91	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +17 -> 33
    //   19: aload_3
    //   20: ifnull +9 -> 29
    //   23: aload_3
    //   24: invokeinterface 96 1 0
    //   29: iconst_m1
    //   30: istore_1
    //   31: iload_1
    //   32: ireturn
    //   33: aload_3
    //   34: astore_0
    //   35: aload_3
    //   36: invokeinterface 100 1 0
    //   41: pop
    //   42: aload_3
    //   43: astore_0
    //   44: aload_3
    //   45: aload_3
    //   46: ldc 123
    //   48: invokeinterface 106 2 0
    //   53: invokeinterface 148 2 0
    //   58: istore_2
    //   59: iload_2
    //   60: istore_1
    //   61: aload_3
    //   62: ifnull -31 -> 31
    //   65: aload_3
    //   66: invokeinterface 96 1 0
    //   71: iload_2
    //   72: ireturn
    //   73: astore 4
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_3
    //   78: astore_0
    //   79: aload 4
    //   81: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   84: aload_3
    //   85: ifnull +9 -> 94
    //   88: aload_3
    //   89: invokeinterface 96 1 0
    //   94: iconst_m1
    //   95: ireturn
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_0
    //   99: aload_0
    //   100: ifnull +9 -> 109
    //   103: aload_0
    //   104: invokeinterface 96 1 0
    //   109: aload_3
    //   110: athrow
    //   111: astore_3
    //   112: goto -13 -> 99
    //   115: astore 4
    //   117: goto -40 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   30	31	1	i	int
    //   58	14	2	j	int
    //   14	75	3	localCursor	android.database.Cursor
    //   96	14	3	localObject1	Object
    //   111	1	3	localObject2	Object
    //   73	7	4	localException1	Exception
    //   115	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	73	java/lang/Exception
    //   0	15	96	finally
    //   35	42	111	finally
    //   44	59	111	finally
    //   79	84	111	finally
    //   35	42	115	java/lang/Exception
    //   44	59	115	java/lang/Exception
  }
  
  public static int by(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return 128;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return 128;
      }
      if (((NetworkInfo)localObject).getTypeName().toUpperCase().equals("WIFI")) {
        return 2;
      }
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      if (((String)localObject).startsWith("cmwap")) {
        return 1;
      }
      if ((((String)localObject).startsWith("cmnet")) || (((String)localObject).startsWith("epc.tmobile.com"))) {
        break label232;
      }
      if (((String)localObject).startsWith("uniwap")) {
        return 16;
      }
      if (((String)localObject).startsWith("uninet")) {
        return 8;
      }
      if (((String)localObject).startsWith("wap")) {
        return 64;
      }
      if (((String)localObject).startsWith("net")) {
        return 32;
      }
      if (((String)localObject).startsWith("ctwap")) {
        return 512;
      }
      if (((String)localObject).startsWith("ctnet")) {
        return 256;
      }
      if (((String)localObject).startsWith("3gwap")) {
        return 1024;
      }
      if (((String)localObject).startsWith("3gnet")) {
        return 2048;
      }
      if (((String)localObject).startsWith("#777"))
      {
        paramContext = bF(paramContext);
        if (paramContext != null)
        {
          int i = paramContext.length();
          if (i > 0) {
            return 512;
          }
        }
        return 256;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 128;
    label232:
    return 4;
  }
  
  public static boolean cq(Context paramContext)
  {
    int i = by(paramContext);
    return (i == 1) || (i == 16) || (i == 64) || (i == 512) || (i == 1024);
  }
  
  public static boolean cr(Context paramContext)
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  public static boolean cs(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return true;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          boolean bool = paramContext[i].isConnectedOrConnecting();
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      arwt.e(TAG, "checkNetWork Exception", paramContext);
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwo
 * JD-Core Version:    0.7.0.1
 */