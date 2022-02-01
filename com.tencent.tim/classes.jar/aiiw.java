import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class aiiw
  extends WebViewPlugin
{
  public static boolean ckt;
  public static PowerManager.WakeLock wakeLock;
  private String bNW = "";
  private int[] lF;
  
  public aiiw()
  {
    this.mPluginNameSpace = "device";
  }
  
  private int FD()
  {
    return aqgz.getCpuNumber();
  }
  
  public static void a(boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (wakeLock == null) {
        wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(10, "VasWakeLock");
      }
      wakeLock.acquire();
      ckt = true;
    }
    do
    {
      return;
      if ((wakeLock != null) && (wakeLock.isHeld())) {
        wakeLock.release();
      }
    } while (paramBoolean2);
    ckt = false;
  }
  
  /* Error */
  public String getCpuName()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 75	java/io/FileReader
    //   6: dup
    //   7: ldc 77
    //   9: invokespecial 80	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: new 82	java/io/BufferedReader
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 5
    //   23: aload 5
    //   25: astore 4
    //   27: aload_2
    //   28: astore_3
    //   29: aload 5
    //   31: invokevirtual 88	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: ldc 90
    //   36: iconst_2
    //   37: invokevirtual 96	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   40: astore 6
    //   42: iconst_0
    //   43: istore_1
    //   44: aload 5
    //   46: astore 4
    //   48: aload_2
    //   49: astore_3
    //   50: iload_1
    //   51: aload 6
    //   53: arraylength
    //   54: if_icmpge +10 -> 64
    //   57: iload_1
    //   58: iconst_1
    //   59: iadd
    //   60: istore_1
    //   61: goto -17 -> 44
    //   64: aload 6
    //   66: iconst_1
    //   67: aaload
    //   68: astore_3
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 99	java/io/FileReader:close	()V
    //   77: aload_3
    //   78: astore_2
    //   79: aload 5
    //   81: ifnull +10 -> 91
    //   84: aload 5
    //   86: invokevirtual 100	java/io/BufferedReader:close	()V
    //   89: aload_3
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   98: goto -21 -> 77
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   106: aload_3
    //   107: areturn
    //   108: astore 6
    //   110: aconst_null
    //   111: astore 5
    //   113: aconst_null
    //   114: astore_2
    //   115: aload 5
    //   117: astore 4
    //   119: aload_2
    //   120: astore_3
    //   121: aload 6
    //   123: invokevirtual 104	java/io/FileNotFoundException:printStackTrace	()V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 99	java/io/FileReader:close	()V
    //   134: aload 7
    //   136: astore_2
    //   137: aload 5
    //   139: ifnull -48 -> 91
    //   142: aload 5
    //   144: invokevirtual 100	java/io/BufferedReader:close	()V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_2
    //   157: aload_2
    //   158: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   161: goto -27 -> 134
    //   164: astore 6
    //   166: aconst_null
    //   167: astore 5
    //   169: aconst_null
    //   170: astore_2
    //   171: aload 5
    //   173: astore 4
    //   175: aload_2
    //   176: astore_3
    //   177: aload 6
    //   179: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 99	java/io/FileReader:close	()V
    //   190: aload 7
    //   192: astore_2
    //   193: aload 5
    //   195: ifnull -104 -> 91
    //   198: aload 5
    //   200: invokevirtual 100	java/io/BufferedReader:close	()V
    //   203: aconst_null
    //   204: areturn
    //   205: astore_2
    //   206: aload_2
    //   207: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   210: aconst_null
    //   211: areturn
    //   212: astore_2
    //   213: aload_2
    //   214: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   217: goto -27 -> 190
    //   220: astore 5
    //   222: aconst_null
    //   223: astore 4
    //   225: aconst_null
    //   226: astore_2
    //   227: aload_2
    //   228: ifnull +7 -> 235
    //   231: aload_2
    //   232: invokevirtual 99	java/io/FileReader:close	()V
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 100	java/io/BufferedReader:close	()V
    //   245: aload 5
    //   247: athrow
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   253: goto -18 -> 235
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   261: goto -16 -> 245
    //   264: astore 5
    //   266: aconst_null
    //   267: astore 4
    //   269: goto -42 -> 227
    //   272: astore 5
    //   274: aload_3
    //   275: astore_2
    //   276: goto -49 -> 227
    //   279: astore 6
    //   281: aconst_null
    //   282: astore 5
    //   284: goto -113 -> 171
    //   287: astore 6
    //   289: goto -118 -> 171
    //   292: astore 6
    //   294: aconst_null
    //   295: astore 5
    //   297: goto -182 -> 115
    //   300: astore 6
    //   302: goto -187 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	aiiw
    //   43	18	1	i	int
    //   12	80	2	localObject1	Object
    //   93	2	2	localIOException1	IOException
    //   101	2	2	localIOException2	IOException
    //   114	23	2	localObject2	Object
    //   149	2	2	localIOException3	IOException
    //   156	2	2	localIOException4	IOException
    //   170	23	2	localObject3	Object
    //   205	2	2	localIOException5	IOException
    //   212	2	2	localIOException6	IOException
    //   226	6	2	localObject4	Object
    //   248	2	2	localIOException7	IOException
    //   256	2	2	localIOException8	IOException
    //   275	1	2	localObject5	Object
    //   28	247	3	localObject6	Object
    //   25	243	4	localBufferedReader1	java.io.BufferedReader
    //   21	178	5	localBufferedReader2	java.io.BufferedReader
    //   220	26	5	localObject7	Object
    //   264	1	5	localObject8	Object
    //   272	1	5	localObject9	Object
    //   282	14	5	localObject10	Object
    //   40	25	6	arrayOfString	String[]
    //   108	14	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   164	14	6	localIOException9	IOException
    //   279	1	6	localIOException10	IOException
    //   287	1	6	localIOException11	IOException
    //   292	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   300	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	190	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   73	77	93	java/io/IOException
    //   84	89	101	java/io/IOException
    //   3	13	108	java/io/FileNotFoundException
    //   142	147	149	java/io/IOException
    //   130	134	156	java/io/IOException
    //   3	13	164	java/io/IOException
    //   198	203	205	java/io/IOException
    //   186	190	212	java/io/IOException
    //   3	13	220	finally
    //   231	235	248	java/io/IOException
    //   240	245	256	java/io/IOException
    //   13	23	264	finally
    //   29	42	272	finally
    //   50	57	272	finally
    //   121	126	272	finally
    //   177	182	272	finally
    //   13	23	279	java/io/IOException
    //   29	42	287	java/io/IOException
    //   50	57	287	java/io/IOException
    //   13	23	292	java/io/FileNotFoundException
    //   29	42	300	java/io/FileNotFoundException
    //   50	57	300	java/io/FileNotFoundException
  }
  
  public String getMaxCpuFreq()
  {
    return String.valueOf(aqgz.getCpuMaxFreq());
  }
  
  public String getMinCpuFreq()
  {
    String str1 = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        str1 = str1 + new String(arrayOfByte);
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        String str2 = "N/A";
      }
    }
    return str1.trim();
  }
  
  /* Error */
  public long getTotalMem()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: lconst_0
    //   9: lstore_1
    //   10: new 82	java/io/BufferedReader
    //   13: dup
    //   14: new 75	java/io/FileReader
    //   17: dup
    //   18: ldc 161
    //   20: invokespecial 80	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   23: bipush 8
    //   25: invokespecial 164	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore 4
    //   30: aload 4
    //   32: astore_3
    //   33: aload 4
    //   35: invokevirtual 88	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 7
    //   40: aload 5
    //   42: astore_3
    //   43: aload 7
    //   45: ifnull +6 -> 51
    //   48: aload 7
    //   50: astore_3
    //   51: aload_3
    //   52: astore 5
    //   54: aload 4
    //   56: ifnull +11 -> 67
    //   59: aload 4
    //   61: invokevirtual 100	java/io/BufferedReader:close	()V
    //   64: aload_3
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +32 -> 101
    //   72: aload 5
    //   74: aload 5
    //   76: bipush 58
    //   78: invokevirtual 168	java/lang/String:indexOf	(I)I
    //   81: iconst_1
    //   82: iadd
    //   83: aload 5
    //   85: bipush 107
    //   87: invokevirtual 168	java/lang/String:indexOf	(I)I
    //   90: invokevirtual 172	java/lang/String:substring	(II)Ljava/lang/String;
    //   93: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   96: invokestatic 178	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: i2l
    //   100: lstore_1
    //   101: lload_1
    //   102: lreturn
    //   103: astore 4
    //   105: aload 4
    //   107: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   110: aload_3
    //   111: astore 5
    //   113: goto -46 -> 67
    //   116: astore 5
    //   118: aconst_null
    //   119: astore 4
    //   121: aload 4
    //   123: astore_3
    //   124: aload 5
    //   126: invokevirtual 104	java/io/FileNotFoundException:printStackTrace	()V
    //   129: aload 6
    //   131: astore 5
    //   133: aload 4
    //   135: ifnull -68 -> 67
    //   138: aload 4
    //   140: invokevirtual 100	java/io/BufferedReader:close	()V
    //   143: aload 6
    //   145: astore 5
    //   147: goto -80 -> 67
    //   150: astore_3
    //   151: aload_3
    //   152: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   155: aload 6
    //   157: astore 5
    //   159: goto -92 -> 67
    //   162: astore 5
    //   164: aconst_null
    //   165: astore 4
    //   167: aload 4
    //   169: astore_3
    //   170: aload 5
    //   172: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   175: aload 6
    //   177: astore 5
    //   179: aload 4
    //   181: ifnull -114 -> 67
    //   184: aload 4
    //   186: invokevirtual 100	java/io/BufferedReader:close	()V
    //   189: aload 6
    //   191: astore 5
    //   193: goto -126 -> 67
    //   196: astore_3
    //   197: aload_3
    //   198: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   201: aload 6
    //   203: astore 5
    //   205: goto -138 -> 67
    //   208: astore 5
    //   210: aload_3
    //   211: astore 4
    //   213: aload 5
    //   215: astore_3
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 100	java/io/BufferedReader:close	()V
    //   226: aload_3
    //   227: athrow
    //   228: astore 4
    //   230: aload 4
    //   232: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   235: goto -9 -> 226
    //   238: astore 5
    //   240: aload_3
    //   241: astore 4
    //   243: aload 5
    //   245: astore_3
    //   246: goto -30 -> 216
    //   249: astore 5
    //   251: goto -84 -> 167
    //   254: astore 5
    //   256: goto -135 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	aiiw
    //   9	93	1	l	long
    //   4	120	3	localObject1	Object
    //   150	2	3	localIOException1	IOException
    //   169	1	3	localObject2	Object
    //   196	15	3	localIOException2	IOException
    //   215	31	3	localObject3	Object
    //   28	32	4	localBufferedReader	java.io.BufferedReader
    //   103	3	4	localIOException3	IOException
    //   119	103	4	localIOException4	IOException
    //   228	3	4	localIOException5	IOException
    //   241	1	4	localObject4	Object
    //   6	106	5	localObject5	Object
    //   116	9	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   131	27	5	localObject6	Object
    //   162	9	5	localIOException6	IOException
    //   177	27	5	localObject7	Object
    //   208	6	5	localObject8	Object
    //   238	6	5	localObject9	Object
    //   249	1	5	localIOException7	IOException
    //   254	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	201	6	localObject10	Object
    //   38	11	7	str	String
    // Exception table:
    //   from	to	target	type
    //   59	64	103	java/io/IOException
    //   10	30	116	java/io/FileNotFoundException
    //   138	143	150	java/io/IOException
    //   10	30	162	java/io/IOException
    //   184	189	196	java/io/IOException
    //   10	30	208	finally
    //   221	226	228	java/io/IOException
    //   33	40	238	finally
    //   124	129	238	finally
    //   170	175	238	finally
    //   33	40	249	java/io/IOException
    //   33	40	254	java/io/FileNotFoundException
  }
  
  public long gk()
  {
    ActivityManager localActivityManager = (ActivityManager)this.mRuntime.getActivity().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem / 1024L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceApiPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"device".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceApiPlugin", 2, "handleJsRequest JSON = " + paramString2.toString());
    }
    int i;
    try
    {
      if (paramString2.has("callback"))
      {
        paramJsBridgeListener = paramString2.getString("callback");
      }
      else
      {
        i = paramString1.indexOf("#");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          break label958;
        }
        paramJsBridgeListener = paramString1.substring(i + 1);
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceApiPlugin", 2, "Failed to parse callbackid,json=" + paramString2);
      }
      paramJsBridgeListener = null;
    }
    if ("setScreenStatus".equals(paramString3)) {}
    for (;;)
    {
      try
      {
        if (!paramString2.has("status")) {
          break label946;
        }
        i = paramString2.getInt("status");
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("DeviceApiPlugin", 2, "Failed to setScreenStatus:" + paramString1.getMessage());
        callJs(paramJsBridgeListener, new String[] { "{'result':-1,'message':" + paramString1.getMessage() + "}" });
        break label972;
      }
      a(bool, this.mRuntime.getActivity().getApplicationContext(), false);
      if (ckt)
      {
        paramString1 = "{'result':1,'message':'light'}";
        callJs(paramJsBridgeListener, new String[] { paramString1 });
      }
      else
      {
        paramString1 = "{'result':0,'message':'dim'}";
        continue;
        if ("getWebpDecoderVersion".equals(paramString3))
        {
          paramString1 = new JSONObject();
          try
          {
            paramString1.put("result", -1);
            if (this.lF != null)
            {
              paramString1.put("result", 0);
              paramString1.put("type", this.bNW);
              paramString1.put("version", String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.lF[0]), Integer.valueOf(this.lF[1]), Integer.valueOf(this.lF[2]) }));
            }
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else
        {
          if ("canInstallThirdPartyApp".equals(paramString3))
          {
            paramString1 = this.mRuntime.getActivity();
            if (paramString1 != null) {
              i = Settings.Secure.getInt(paramString1.getContentResolver(), "install_non_market_apps", 0);
            }
            for (paramString1 = "{'result':" + i + "}";; paramString1 = "{'result':-1,'message':'Context is null!'}")
            {
              callJs(paramJsBridgeListener, new String[] { paramString1 });
              break;
            }
          }
          if ("getCPUInfo".equals(paramString3)) {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("maxFreq", getMaxCpuFreq());
              paramString1.put("minFreq", getMinCpuFreq());
              paramString1.put("curFreq", wT());
              paramString1.put("CPUName", getCpuName());
              paramString1 = paramString1.toString();
              QLog.i("DeviceApiPlugin", 2, "getCPUInfo : " + paramString1);
              callJs(paramJsBridgeListener, new String[] { paramString1 });
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          if ("getMemInfo".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("idleMem", gk());
              paramString1.put("totalMem", getTotalMem());
              paramString1 = paramString1.toString();
              QLog.i("DeviceApiPlugin", 2, "getMemInfo : " + paramString1);
              callJs(paramJsBridgeListener, new String[] { paramString1 });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if ("getCPUCoreNum".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("count", FD());
              paramString1 = paramString1.toString();
              QLog.i("DeviceApiPlugin", 2, "getCPUCoreNum : " + paramString1);
              callJs(paramJsBridgeListener, new String[] { paramString1 });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.w("DeviceApiPlugin", 2, "NOT support method " + paramString3 + " yet!!");
            }
            return false;
            label946:
            i = 0;
            break label960;
            if (paramJsBridgeListener != null) {
              break;
            }
            return false;
            label958:
            return false;
            label960:
            if (i != 1) {
              break label974;
            }
            bool = true;
            continue;
          }
        }
      }
      label972:
      return true;
      label974:
      boolean bool = false;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    if (ckt) {
      a(false, null, false);
    }
    if ((wakeLock != null) && (wakeLock.isHeld())) {
      wakeLock.release();
    }
    wakeLock = null;
    super.onDestroy();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if ((paramCustomWebView != null) && (paramCustomWebView.getX5WebViewExtension() != null))
    {
      this.lF = new int[] { 0, 3, 0, 0 };
      this.bNW = "QQBrowser";
    }
    do
    {
      return;
      this.lF = WebpSoLoader.getDecoderVersion();
    } while (this.lF == null);
    if (WebpSoLoader.oU != null)
    {
      this.bNW = "Hook";
      return;
    }
    this.bNW = "System";
  }
  
  /* Error */
  public String wT()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: ldc 158
    //   12: astore 6
    //   14: new 75	java/io/FileReader
    //   17: dup
    //   18: ldc_w 435
    //   21: invokespecial 80	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload 4
    //   27: astore_3
    //   28: aload_1
    //   29: astore 4
    //   31: new 82	java/io/BufferedReader
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 88	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_3
    //   45: aload_1
    //   46: invokevirtual 99	java/io/FileReader:close	()V
    //   49: aload_2
    //   50: invokevirtual 100	java/io/BufferedReader:close	()V
    //   53: aload_3
    //   54: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   57: astore_3
    //   58: aload_1
    //   59: ifnull +7 -> 66
    //   62: aload_1
    //   63: invokevirtual 99	java/io/FileReader:close	()V
    //   66: aload_3
    //   67: astore 4
    //   69: aload_2
    //   70: ifnull +10 -> 80
    //   73: aload_2
    //   74: invokevirtual 100	java/io/BufferedReader:close	()V
    //   77: aload_3
    //   78: astore 4
    //   80: aload 4
    //   82: areturn
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   88: goto -22 -> 66
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   96: aload_3
    //   97: areturn
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_3
    //   102: invokevirtual 104	java/io/FileNotFoundException:printStackTrace	()V
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 99	java/io/FileReader:close	()V
    //   113: aload 6
    //   115: astore 4
    //   117: aload_1
    //   118: ifnull -38 -> 80
    //   121: aload_1
    //   122: invokevirtual 100	java/io/BufferedReader:close	()V
    //   125: ldc 158
    //   127: areturn
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   133: ldc 158
    //   135: areturn
    //   136: astore_2
    //   137: aload_2
    //   138: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   141: goto -28 -> 113
    //   144: astore 5
    //   146: aconst_null
    //   147: astore_1
    //   148: aload 7
    //   150: astore_2
    //   151: aload_2
    //   152: astore_3
    //   153: aload_1
    //   154: astore 4
    //   156: aload 5
    //   158: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 99	java/io/FileReader:close	()V
    //   169: aload 6
    //   171: astore 4
    //   173: aload_2
    //   174: ifnull -94 -> 80
    //   177: aload_2
    //   178: invokevirtual 100	java/io/BufferedReader:close	()V
    //   181: ldc 158
    //   183: areturn
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   189: ldc 158
    //   191: areturn
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   197: goto -28 -> 169
    //   200: astore_2
    //   201: aconst_null
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 99	java/io/FileReader:close	()V
    //   211: aload_3
    //   212: ifnull +7 -> 219
    //   215: aload_3
    //   216: invokevirtual 100	java/io/BufferedReader:close	()V
    //   219: aload_2
    //   220: athrow
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   226: goto -15 -> 211
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   234: goto -15 -> 219
    //   237: astore_2
    //   238: aload 4
    //   240: astore_1
    //   241: goto -38 -> 203
    //   244: astore 4
    //   246: aload_2
    //   247: astore_3
    //   248: aload 4
    //   250: astore_2
    //   251: goto -48 -> 203
    //   254: astore_3
    //   255: aload_2
    //   256: astore 4
    //   258: aload_3
    //   259: astore_2
    //   260: aload_1
    //   261: astore_3
    //   262: aload 4
    //   264: astore_1
    //   265: goto -62 -> 203
    //   268: astore 5
    //   270: aload 7
    //   272: astore_2
    //   273: goto -122 -> 151
    //   276: astore 5
    //   278: goto -127 -> 151
    //   281: astore_3
    //   282: aconst_null
    //   283: astore 4
    //   285: aload_1
    //   286: astore_2
    //   287: aload 4
    //   289: astore_1
    //   290: goto -189 -> 101
    //   293: astore_3
    //   294: aload_1
    //   295: astore 4
    //   297: aload_2
    //   298: astore_1
    //   299: aload 4
    //   301: astore_2
    //   302: goto -201 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	aiiw
    //   24	39	1	localFileReader	java.io.FileReader
    //   83	2	1	localIOException1	IOException
    //   91	2	1	localIOException2	IOException
    //   100	22	1	localObject1	Object
    //   128	2	1	localIOException3	IOException
    //   147	19	1	localObject2	Object
    //   184	2	1	localIOException4	IOException
    //   192	2	1	localIOException5	IOException
    //   202	6	1	localObject3	Object
    //   221	2	1	localIOException6	IOException
    //   229	2	1	localIOException7	IOException
    //   240	59	1	localObject4	Object
    //   9	101	2	localBufferedReader	java.io.BufferedReader
    //   136	2	2	localIOException8	IOException
    //   150	28	2	localObject5	Object
    //   200	20	2	localObject6	Object
    //   237	10	2	localObject7	Object
    //   250	52	2	localObject8	Object
    //   4	93	3	localObject9	Object
    //   98	4	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   152	96	3	localObject10	Object
    //   254	5	3	localObject11	Object
    //   261	1	3	localObject12	Object
    //   281	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   293	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   6	233	4	localObject13	Object
    //   244	5	4	localObject14	Object
    //   256	44	4	localObject15	Object
    //   144	13	5	localIOException9	IOException
    //   268	1	5	localIOException10	IOException
    //   276	1	5	localIOException11	IOException
    //   12	158	6	str	String
    //   1	270	7	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   62	66	83	java/io/IOException
    //   73	77	91	java/io/IOException
    //   14	25	98	java/io/FileNotFoundException
    //   121	125	128	java/io/IOException
    //   109	113	136	java/io/IOException
    //   14	25	144	java/io/IOException
    //   177	181	184	java/io/IOException
    //   165	169	192	java/io/IOException
    //   14	25	200	finally
    //   207	211	221	java/io/IOException
    //   215	219	229	java/io/IOException
    //   31	40	237	finally
    //   156	161	237	finally
    //   40	58	244	finally
    //   101	105	254	finally
    //   31	40	268	java/io/IOException
    //   40	58	276	java/io/IOException
    //   31	40	281	java/io/FileNotFoundException
    //   40	58	293	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiiw
 * JD-Core Version:    0.7.0.1
 */