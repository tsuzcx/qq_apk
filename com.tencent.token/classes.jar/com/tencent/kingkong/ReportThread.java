package com.tencent.kingkong;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ReportThread
  extends Thread
{
  private static final boolean ENABLE_RSA_ENCRYPT = true;
  public static final String KEY_EXTRAINFO = "KEY_EXTRAINFO";
  public static final String KEY_INDEX = "KEY_INDEX";
  public static final String KEY_SUBINDEX = "KEY_SUBINDEX";
  public static final String KEY_TYPE = "KEY_TYPE";
  public static final String LOG_TAG = "KingKongReportThread";
  public static final int MSG_CONSOLE = 0;
  public static final int MSG_WEBVIEW = 1;
  public ReportHandler mHandler = null;
  public Object mLock = new Object();
  public Looper mLooper = null;
  
  private static String RsaEncrypt(String paramString)
  {
    try
    {
      String str2 = Utils.getRandomString(16);
      String str1 = EncryptUtilsForQQ.RsaEncryptData(new String(str2));
      paramString = new String(EncryptUtilsForQQ.DesEncrypt(str2, paramString));
      paramString = "paramStr=" + URLEncoder.encode(paramString, "UTF-8") + "&key=" + URLEncoder.encode(str1, "UTF-8") + "&visibility=2";
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String addDeviceInfoToUrl(String paramString)
  {
    StringBuilder localStringBuilder1;
    int i;
    label552:
    label579:
    label606:
    label633:
    try
    {
      localStringBuilder1 = Utils.obtainStringBuild();
      localStringBuilder1.append(paramString);
    }
    finally {}
    try
    {
      paramString = Build.HARDWARE;
      if (paramString != null) {
        localStringBuilder1.append("&hardware=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = Build.BRAND;
      if (paramString != null) {
        localStringBuilder1.append("&pb=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      i = Build.VERSION.SDK_INT;
      if (i != -1) {
        localStringBuilder1.append("&ps=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      paramString = DataReport.getAppVersion();
      if (paramString != null) {
        localStringBuilder1.append("&av=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getPackageName();
      if (paramString != null) {
        localStringBuilder1.append("&pn=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getAccelerometerName();
      if (paramString != null) {
        localStringBuilder1.append("&amn=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getAccelerometerVendor();
      if (paramString != null) {
        localStringBuilder1.append("&amv=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getAccessSubtype();
      if (paramString != null) {
        localStringBuilder1.append("&nm=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      i = DataReport.getBatteryLevel();
      if (i != -1) {
        localStringBuilder1.append("&bl=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      i = DataReport.getBatteryTemp();
      if (i != -1) {
        localStringBuilder1.append("&bt=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      i = DataReport.getBatteryVoltage();
      if (i != -1) {
        localStringBuilder1.append("&bv=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      paramString = DataReport.getCarrier();
      if (paramString != null) {
        localStringBuilder1.append("&cr=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getCellInfo();
      if (paramString != null) {
        localStringBuilder1.append("&cl=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getGravityName();
      if (paramString != null) {
        localStringBuilder1.append("&gn=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getGravityVendor();
      if (paramString != null) {
        localStringBuilder1.append("&gv=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getImsi();
      if (paramString != null) {
        localStringBuilder1.append("&imsi=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getIpAddr();
      if (paramString != null) {
        localStringBuilder1.append("&ip_addr=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getResolution();
      if (paramString != null) {
        localStringBuilder1.append("&re=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getRomTotal();
      if (paramString != null) {
        localStringBuilder1.append("&rt=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.getSDCardTotal();
      if (paramString != null) {
        localStringBuilder1.append("&st=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      localStringBuilder2 = localStringBuilder1.append("&root=");
      if (!DataReport.isRoot()) {
        break label1024;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ams=");
      if (!DataReport.isAccelerometerSupported()) {
        break label1060;
      }
      paramString = "1";
    }
    catch (Exception paramString)
    {
      break label1014;
    }
    catch (NoClassDefFoundError paramString)
    {
      break label1014;
    }
    catch (NoSuchMethodError paramString)
    {
      break label1014;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label660:
      label688:
      label716:
      label744:
      label1014:
      break label1014;
      label772:
      label800:
      paramString = "0";
      label1024:
      break label552;
      paramString = "0";
      break label579;
      paramString = "0";
      break label606;
      paramString = "0";
      break label633;
      paramString = "0";
      break label660;
      paramString = "0";
      break label688;
      paramString = "0";
      break label716;
      paramString = "0";
      break label744;
      paramString = "0";
      break label772;
      paramString = "0";
      break label800;
    }
    localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
    StringBuilder localStringBuilder2 = localStringBuilder1.append("&btls=");
    if (DataReport.isBlueToothLeSupported())
    {
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&bts=");
      if (!DataReport.isBlueToothSupported()) {
        break label1074;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gls=");
      if (!DataReport.isGpsLocationSupported()) {
        break label1081;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gs=");
      if (!DataReport.isGravitySupported()) {
        break label1088;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gss=");
      if (!DataReport.isGyroscopeSupported()) {
        break label1095;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ns=");
      if (!DataReport.isNfcSupported()) {
        break label1102;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&pe=");
      if (!DataReport.isProxyEnabled()) {
        break label1109;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ts=");
      if (!DataReport.isTelephonySupported()) {
        break label1116;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&uas=");
      if (!DataReport.isUsbAccessorySupported()) {
        break label1123;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ws=");
      if (DataReport.isWifiSupported()) {}
      for (paramString = "1";; paramString = "0")
      {
        localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
        paramString = DataReport.getQQUin();
        if (paramString != null) {
          localStringBuilder1.append("&qu=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.getAndroidID();
        if (paramString != null) {
          localStringBuilder1.append("&android_id=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = Build.MODEL;
        if (paramString != null) {
          localStringBuilder1.append("&pm=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = Build.VERSION.RELEASE;
        if (paramString != null) {
          localStringBuilder1.append("&pr=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.getLocalMacAddress();
        if (paramString != null) {
          localStringBuilder1.append("&mac=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.getDeviceId();
        if (paramString != null) {
          localStringBuilder1.append("&device_id=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.getNetworkType();
        if (paramString != null) {
          localStringBuilder1.append("&nt=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = localStringBuilder1.toString();
        return paramString;
        paramString = "0";
        break;
      }
    }
  }
  
  public void report(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.mHandler == null) {
      return;
    }
    synchronized (this.mLock)
    {
      if (this.mHandler != null)
      {
        Message localMessage = this.mHandler.obtainMessage();
        Bundle localBundle = new Bundle();
        localBundle.putInt("KEY_TYPE", paramInt1);
        localBundle.putInt("KEY_INDEX", paramInt2);
        localBundle.putInt("KEY_SUBINDEX", paramInt3);
        localBundle.putString("KEY_EXTRAINFO", paramString);
        localMessage.setData(localBundle);
        this.mHandler.sendMessage(localMessage);
      }
      return;
    }
  }
  
  public void run()
  {
    Looper.prepare();
    this.mHandler = new ReportHandler();
    this.mLooper = Looper.myLooper();
    Process.setThreadPriority(11);
    Common.Log.d("KingKongReportThread", "ReportThread " + Process.myTid() + " priority : " + Process.getThreadPriority(Process.myTid()));
    Looper.loop();
  }
  
  public void stopThread()
  {
    if (this.mLooper != null) {
      synchronized (this.mLock)
      {
        if (this.mLooper != null)
        {
          this.mLooper.quit();
          this.mHandler.removeCallbacksAndMessages(null);
          this.mHandler = null;
          this.mLooper = null;
        }
        return;
      }
    }
  }
  
  static class ReportHandler
    extends Handler
  {
    /* Error */
    public void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 24	android/os/Message:getData	()Landroid/os/Bundle;
      //   4: astore_1
      //   5: aload_1
      //   6: ldc 26
      //   8: invokevirtual 32	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   11: istore_2
      //   12: aload_1
      //   13: ldc 34
      //   15: invokevirtual 32	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   18: istore_3
      //   19: aload_1
      //   20: ldc 36
      //   22: invokevirtual 32	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   25: istore 4
      //   27: aload_1
      //   28: ldc 38
      //   30: invokevirtual 42	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   33: astore 5
      //   35: getstatic 48	com/tencent/kingkong/Constant:REPORT_CGI_URL	Ljava/lang/String;
      //   38: astore_1
      //   39: new 50	java/lang/StringBuilder
      //   42: dup
      //   43: ldc 52
      //   45: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   48: iload_2
      //   49: invokestatic 61	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   52: ldc 63
      //   54: invokestatic 69	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   57: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   60: ldc 75
      //   62: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   65: iload_3
      //   66: invokestatic 61	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   69: ldc 63
      //   71: invokestatic 69	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   74: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: ldc 77
      //   79: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   82: iload 4
      //   84: invokestatic 61	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   87: ldc 63
      //   89: invokestatic 69	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   92: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   95: aload 5
      //   97: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   103: invokestatic 84	com/tencent/kingkong/ReportThread:addDeviceInfoToUrl	(Ljava/lang/String;)Ljava/lang/String;
      //   106: astore 5
      //   108: aload 5
      //   110: invokestatic 87	com/tencent/kingkong/ReportThread:access$0	(Ljava/lang/String;)Ljava/lang/String;
      //   113: astore 6
      //   115: ldc 89
      //   117: new 50	java/lang/StringBuilder
      //   120: dup
      //   121: ldc 91
      //   123: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   126: aload 5
      //   128: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   134: invokestatic 97	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   137: ldc 89
      //   139: new 50	java/lang/StringBuilder
      //   142: dup
      //   143: ldc 99
      //   145: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   148: aload 6
      //   150: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   153: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   156: invokestatic 97	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   159: new 50	java/lang/StringBuilder
      //   162: dup
      //   163: aload_1
      //   164: invokestatic 102	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   167: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   170: ldc 104
      //   172: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   175: aload 6
      //   177: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   183: astore 5
      //   185: ldc 89
      //   187: aload 5
      //   189: invokestatic 97	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   192: aconst_null
      //   193: astore_1
      //   194: aconst_null
      //   195: astore 7
      //   197: aconst_null
      //   198: astore 8
      //   200: aconst_null
      //   201: astore 9
      //   203: aload 8
      //   205: astore 6
      //   207: new 106	java/net/URL
      //   210: dup
      //   211: aload 5
      //   213: invokespecial 107	java/net/URL:<init>	(Ljava/lang/String;)V
      //   216: invokevirtual 111	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   219: checkcast 113	java/net/HttpURLConnection
      //   222: astore 5
      //   224: aload 5
      //   226: astore 7
      //   228: aload 5
      //   230: astore_1
      //   231: aload 8
      //   233: astore 6
      //   235: new 115	java/io/InputStreamReader
      //   238: dup
      //   239: aload 5
      //   241: invokevirtual 119	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   244: invokespecial 122	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   247: astore 8
      //   249: new 124	java/io/BufferedReader
      //   252: dup
      //   253: aload 8
      //   255: invokespecial 127	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   258: astore_1
      //   259: aload_1
      //   260: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   263: astore 6
      //   265: aload 6
      //   267: ifnonnull -8 -> 259
      //   270: aload 5
      //   272: ifnull +8 -> 280
      //   275: aload 5
      //   277: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
      //   280: aload 8
      //   282: ifnull +316 -> 598
      //   285: aload 8
      //   287: invokevirtual 136	java/io/InputStreamReader:close	()V
      //   290: ldc 89
      //   292: ldc 138
      //   294: invokestatic 97	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   297: return
      //   298: astore_1
      //   299: ldc 140
      //   301: new 50	java/lang/StringBuilder
      //   304: dup
      //   305: ldc 142
      //   307: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   310: aload_1
      //   311: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   314: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   317: invokestatic 97	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   320: return
      //   321: astore_1
      //   322: aload 9
      //   324: astore 8
      //   326: aload_1
      //   327: astore 9
      //   329: aload 7
      //   331: astore 5
      //   333: aload 5
      //   335: astore_1
      //   336: aload 8
      //   338: astore 6
      //   340: new 147	java/io/StringWriter
      //   343: dup
      //   344: invokespecial 148	java/io/StringWriter:<init>	()V
      //   347: astore 7
      //   349: aload 5
      //   351: astore_1
      //   352: aload 8
      //   354: astore 6
      //   356: aload 9
      //   358: new 150	java/io/PrintWriter
      //   361: dup
      //   362: aload 7
      //   364: invokespecial 153	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   367: invokevirtual 157	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
      //   370: aload 5
      //   372: astore_1
      //   373: aload 8
      //   375: astore 6
      //   377: ldc 89
      //   379: new 50	java/lang/StringBuilder
      //   382: dup
      //   383: ldc 159
      //   385: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   388: aload 7
      //   390: invokevirtual 160	java/io/StringWriter:toString	()Ljava/lang/String;
      //   393: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   396: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   399: invokestatic 97	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   402: aload 5
      //   404: ifnull +8 -> 412
      //   407: aload 5
      //   409: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
      //   412: aload 8
      //   414: ifnull -124 -> 290
      //   417: aload 8
      //   419: invokevirtual 136	java/io/InputStreamReader:close	()V
      //   422: goto -132 -> 290
      //   425: astore_1
      //   426: new 147	java/io/StringWriter
      //   429: dup
      //   430: invokespecial 148	java/io/StringWriter:<init>	()V
      //   433: astore 5
      //   435: aload_1
      //   436: new 150	java/io/PrintWriter
      //   439: dup
      //   440: aload 5
      //   442: invokespecial 153	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   445: invokevirtual 157	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
      //   448: ldc 89
      //   450: new 50	java/lang/StringBuilder
      //   453: dup
      //   454: ldc 162
      //   456: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   459: aload 5
      //   461: invokevirtual 160	java/io/StringWriter:toString	()Ljava/lang/String;
      //   464: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   467: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   470: invokestatic 97	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   473: goto -183 -> 290
      //   476: astore 5
      //   478: aload_1
      //   479: ifnull +7 -> 486
      //   482: aload_1
      //   483: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
      //   486: aload 6
      //   488: ifnull +8 -> 496
      //   491: aload 6
      //   493: invokevirtual 136	java/io/InputStreamReader:close	()V
      //   496: aload 5
      //   498: athrow
      //   499: astore_1
      //   500: new 147	java/io/StringWriter
      //   503: dup
      //   504: invokespecial 148	java/io/StringWriter:<init>	()V
      //   507: astore 6
      //   509: aload_1
      //   510: new 150	java/io/PrintWriter
      //   513: dup
      //   514: aload 6
      //   516: invokespecial 153	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   519: invokevirtual 157	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
      //   522: ldc 89
      //   524: new 50	java/lang/StringBuilder
      //   527: dup
      //   528: ldc 162
      //   530: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   533: aload 6
      //   535: invokevirtual 160	java/io/StringWriter:toString	()Ljava/lang/String;
      //   538: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   541: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   544: invokestatic 97	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   547: goto -51 -> 496
      //   550: astore_1
      //   551: new 147	java/io/StringWriter
      //   554: dup
      //   555: invokespecial 148	java/io/StringWriter:<init>	()V
      //   558: astore 5
      //   560: aload_1
      //   561: new 150	java/io/PrintWriter
      //   564: dup
      //   565: aload 5
      //   567: invokespecial 153	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   570: invokevirtual 157	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
      //   573: ldc 89
      //   575: new 50	java/lang/StringBuilder
      //   578: dup
      //   579: ldc 162
      //   581: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   584: aload 5
      //   586: invokevirtual 160	java/io/StringWriter:toString	()Ljava/lang/String;
      //   589: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   592: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   595: invokestatic 97	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   598: goto -308 -> 290
      //   601: astore 7
      //   603: aload 8
      //   605: astore 6
      //   607: aload 5
      //   609: astore_1
      //   610: aload 7
      //   612: astore 5
      //   614: goto -136 -> 478
      //   617: astore 9
      //   619: goto -286 -> 333
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	622	0	this	ReportHandler
      //   0	622	1	paramMessage	Message
      //   11	38	2	i	int
      //   18	48	3	j	int
      //   25	58	4	k	int
      //   33	427	5	localObject1	Object
      //   476	21	5	localObject2	Object
      //   558	55	5	localObject3	Object
      //   113	493	6	localObject4	Object
      //   195	194	7	localObject5	Object
      //   601	10	7	localObject6	Object
      //   198	406	8	localObject7	Object
      //   201	156	9	localMessage	Message
      //   617	1	9	localThrowable	java.lang.Throwable
      // Exception table:
      //   from	to	target	type
      //   39	159	298	java/lang/Exception
      //   207	224	321	java/lang/Throwable
      //   235	249	321	java/lang/Throwable
      //   417	422	425	java/lang/Throwable
      //   207	224	476	finally
      //   235	249	476	finally
      //   340	349	476	finally
      //   356	370	476	finally
      //   377	402	476	finally
      //   491	496	499	java/lang/Throwable
      //   285	290	550	java/lang/Throwable
      //   249	259	601	finally
      //   259	265	601	finally
      //   249	259	617	java/lang/Throwable
      //   259	265	617	java/lang/Throwable
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.ReportThread
 * JD-Core Version:    0.7.0.1
 */