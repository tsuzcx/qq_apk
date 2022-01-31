package com.tencent.smtt.secure;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class ReportThread
  extends Thread
{
  public static final String KEY_INDEX = "KEY_INDEX";
  public static final String KEY_TYPE = "KEY_TYPE";
  public static final String KEY_VALUE = "KEY_VALUE";
  public static final int MSG_CONSOLE = 0;
  public static final int MSG_WEBVIEW = 1;
  private ReportHandler mHandler = null;
  private Object mLock = new Object();
  private Looper mLooper = null;
  
  public void report(int paramInt1, int paramInt2, int paramInt3)
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
        localBundle.putInt("KEY_VALUE", paramInt3);
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
      //   1: invokevirtual 22	android/os/Message:getData	()Landroid/os/Bundle;
      //   4: astore_1
      //   5: aload_1
      //   6: ldc 24
      //   8: invokevirtual 30	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   11: istore_2
      //   12: aload_1
      //   13: ldc 32
      //   15: invokevirtual 30	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   18: istore_3
      //   19: aload_1
      //   20: ldc 34
      //   22: invokevirtual 30	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   25: istore 4
      //   27: new 36	java/lang/StringBuilder
      //   30: dup
      //   31: invokespecial 37	java/lang/StringBuilder:<init>	()V
      //   34: getstatic 43	android/os/Build:MODEL	Ljava/lang/String;
      //   37: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: ldc 49
      //   42: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: getstatic 52	android/os/Build:BRAND	Ljava/lang/String;
      //   48: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   54: astore_1
      //   55: aload_1
      //   56: astore 6
      //   58: aload_1
      //   59: invokevirtual 62	java/lang/String:length	()I
      //   62: bipush 30
      //   64: if_icmple +12 -> 76
      //   67: aload_1
      //   68: iconst_0
      //   69: bipush 30
      //   71: invokevirtual 66	java/lang/String:substring	(II)Ljava/lang/String;
      //   74: astore 6
      //   76: getstatic 72	android/os/Build$VERSION:SDK_INT	I
      //   79: istore 5
      //   81: aconst_null
      //   82: astore_1
      //   83: aconst_null
      //   84: astore 8
      //   86: aconst_null
      //   87: astore 9
      //   89: aconst_null
      //   90: astore 10
      //   92: aload 9
      //   94: astore 7
      //   96: new 74	java/net/URL
      //   99: dup
      //   100: new 36	java/lang/StringBuilder
      //   103: dup
      //   104: invokespecial 37	java/lang/StringBuilder:<init>	()V
      //   107: ldc 76
      //   109: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: invokestatic 81	com/tencent/smtt/secure/UpdateManager:getSDKVersionCode	()I
      //   115: invokestatic 85	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   118: ldc 87
      //   120: invokestatic 93	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   123: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   126: ldc 95
      //   128: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: iload_2
      //   132: invokestatic 85	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   135: ldc 87
      //   137: invokestatic 93	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   140: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: ldc 97
      //   145: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   148: iload_3
      //   149: invokestatic 85	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   152: ldc 87
      //   154: invokestatic 93	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   157: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   160: ldc 99
      //   162: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   165: iload 4
      //   167: invokestatic 85	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   170: ldc 87
      //   172: invokestatic 93	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   175: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: ldc 101
      //   180: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   183: aload 6
      //   185: ldc 87
      //   187: invokestatic 93	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   190: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   193: ldc 103
      //   195: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   198: iload 5
      //   200: invokestatic 85	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   203: ldc 87
      //   205: invokestatic 93	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   208: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   211: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   214: invokespecial 106	java/net/URL:<init>	(Ljava/lang/String;)V
      //   217: invokevirtual 110	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   220: checkcast 112	java/net/HttpURLConnection
      //   223: astore 6
      //   225: aload 6
      //   227: astore 8
      //   229: aload 6
      //   231: astore_1
      //   232: aload 9
      //   234: astore 7
      //   236: new 114	java/io/InputStreamReader
      //   239: dup
      //   240: aload 6
      //   242: invokevirtual 118	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   245: invokespecial 121	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   248: astore 9
      //   250: new 123	java/io/BufferedReader
      //   253: dup
      //   254: aload 9
      //   256: invokespecial 126	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   259: astore_1
      //   260: aload_1
      //   261: invokevirtual 129	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   264: astore 7
      //   266: aload 7
      //   268: ifnonnull -8 -> 260
      //   271: aload 6
      //   273: ifnull +8 -> 281
      //   276: aload 6
      //   278: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
      //   281: aload 9
      //   283: ifnull +316 -> 599
      //   286: aload 9
      //   288: invokevirtual 135	java/io/InputStreamReader:close	()V
      //   291: return
      //   292: astore_1
      //   293: new 137	java/io/StringWriter
      //   296: dup
      //   297: invokespecial 138	java/io/StringWriter:<init>	()V
      //   300: astore 6
      //   302: aload_1
      //   303: new 140	java/io/PrintWriter
      //   306: dup
      //   307: aload 6
      //   309: invokespecial 143	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   312: invokevirtual 147	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
      //   315: ldc 149
      //   317: new 36	java/lang/StringBuilder
      //   320: dup
      //   321: invokespecial 37	java/lang/StringBuilder:<init>	()V
      //   324: ldc 151
      //   326: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   329: aload 6
      //   331: invokevirtual 152	java/io/StringWriter:toString	()Ljava/lang/String;
      //   334: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   337: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   340: invokestatic 158	com/tencent/smtt/sdk/QbSdkLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   343: return
      //   344: astore_1
      //   345: aload 10
      //   347: astore 9
      //   349: aload_1
      //   350: astore 10
      //   352: aload 8
      //   354: astore 6
      //   356: aload 6
      //   358: astore_1
      //   359: aload 9
      //   361: astore 7
      //   363: new 137	java/io/StringWriter
      //   366: dup
      //   367: invokespecial 138	java/io/StringWriter:<init>	()V
      //   370: astore 8
      //   372: aload 6
      //   374: astore_1
      //   375: aload 9
      //   377: astore 7
      //   379: aload 10
      //   381: new 140	java/io/PrintWriter
      //   384: dup
      //   385: aload 8
      //   387: invokespecial 143	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   390: invokevirtual 147	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
      //   393: aload 6
      //   395: astore_1
      //   396: aload 9
      //   398: astore 7
      //   400: ldc 149
      //   402: new 36	java/lang/StringBuilder
      //   405: dup
      //   406: invokespecial 37	java/lang/StringBuilder:<init>	()V
      //   409: ldc 160
      //   411: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   414: aload 8
      //   416: invokevirtual 152	java/io/StringWriter:toString	()Ljava/lang/String;
      //   419: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   422: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   425: invokestatic 158	com/tencent/smtt/sdk/QbSdkLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   428: aload 6
      //   430: ifnull +8 -> 438
      //   433: aload 6
      //   435: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
      //   438: aload 9
      //   440: ifnull -149 -> 291
      //   443: aload 9
      //   445: invokevirtual 135	java/io/InputStreamReader:close	()V
      //   448: return
      //   449: astore_1
      //   450: new 137	java/io/StringWriter
      //   453: dup
      //   454: invokespecial 138	java/io/StringWriter:<init>	()V
      //   457: astore 6
      //   459: aload_1
      //   460: new 140	java/io/PrintWriter
      //   463: dup
      //   464: aload 6
      //   466: invokespecial 143	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   469: invokevirtual 147	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
      //   472: ldc 149
      //   474: new 36	java/lang/StringBuilder
      //   477: dup
      //   478: invokespecial 37	java/lang/StringBuilder:<init>	()V
      //   481: ldc 151
      //   483: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   486: aload 6
      //   488: invokevirtual 152	java/io/StringWriter:toString	()Ljava/lang/String;
      //   491: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   494: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   497: invokestatic 158	com/tencent/smtt/sdk/QbSdkLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   500: return
      //   501: astore 6
      //   503: aload_1
      //   504: ifnull +7 -> 511
      //   507: aload_1
      //   508: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
      //   511: aload 7
      //   513: ifnull +8 -> 521
      //   516: aload 7
      //   518: invokevirtual 135	java/io/InputStreamReader:close	()V
      //   521: aload 6
      //   523: athrow
      //   524: astore_1
      //   525: new 137	java/io/StringWriter
      //   528: dup
      //   529: invokespecial 138	java/io/StringWriter:<init>	()V
      //   532: astore 7
      //   534: aload_1
      //   535: new 140	java/io/PrintWriter
      //   538: dup
      //   539: aload 7
      //   541: invokespecial 143	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   544: invokevirtual 147	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
      //   547: ldc 149
      //   549: new 36	java/lang/StringBuilder
      //   552: dup
      //   553: invokespecial 37	java/lang/StringBuilder:<init>	()V
      //   556: ldc 151
      //   558: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   561: aload 7
      //   563: invokevirtual 152	java/io/StringWriter:toString	()Ljava/lang/String;
      //   566: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   569: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   572: invokestatic 158	com/tencent/smtt/sdk/QbSdkLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   575: goto -54 -> 521
      //   578: astore 8
      //   580: aload 9
      //   582: astore 7
      //   584: aload 6
      //   586: astore_1
      //   587: aload 8
      //   589: astore 6
      //   591: goto -88 -> 503
      //   594: astore 10
      //   596: goto -240 -> 356
      //   599: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	600	0	this	ReportHandler
      //   0	600	1	paramMessage	Message
      //   11	121	2	i	int
      //   18	131	3	j	int
      //   25	141	4	k	int
      //   79	120	5	m	int
      //   56	431	6	localObject1	Object
      //   501	84	6	localObject2	Object
      //   589	1	6	localObject3	Object
      //   94	489	7	localObject4	Object
      //   84	331	8	localObject5	Object
      //   578	10	8	localObject6	Object
      //   87	494	9	localObject7	Object
      //   90	290	10	localMessage	Message
      //   594	1	10	localThrowable	java.lang.Throwable
      // Exception table:
      //   from	to	target	type
      //   286	291	292	java/lang/Throwable
      //   96	225	344	java/lang/Throwable
      //   236	250	344	java/lang/Throwable
      //   443	448	449	java/lang/Throwable
      //   96	225	501	finally
      //   236	250	501	finally
      //   363	372	501	finally
      //   379	393	501	finally
      //   400	428	501	finally
      //   516	521	524	java/lang/Throwable
      //   250	260	578	finally
      //   260	266	578	finally
      //   250	260	594	java/lang/Throwable
      //   260	266	594	java/lang/Throwable
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.secure.ReportThread
 * JD-Core Version:    0.7.0.1
 */