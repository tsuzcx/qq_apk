package com.tencent.thumbplayer.core.downloadproxy.utils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class TPCGIRequester
{
  private static final String FILE_NAME = "TPCGIRequester";
  private static final int MAX_RETRY_TIMES = 3;
  private static final int MSG_CONFIG_URL = 2011;
  private static final int MSG_REPORT_URL = 2010;
  private static final int RETRY_INTERVAL = 3000;
  private static final int TIMEOUT = 3000;
  private static volatile ExecutorService mCustomExecutor = null;
  private static TPCGIRequester mRequester = null;
  private LinkedBlockingQueue<TPRequestItem> mRequestQueue = new LinkedBlockingQueue();
  private LinkedBlockingQueue<TPRequestItem> mRetryQueue = new LinkedBlockingQueue();
  private TimerTask mTimerTask = new TPCGIRequester.1(this);
  
  private TPCGIRequester()
  {
    new Timer(true).scheduleAtFixedRate(this.mTimerTask, 0L, 1000L);
    process();
  }
  
  private void addNotifyReqQueue(TPRequestItem paramTPRequestItem)
  {
    try
    {
      this.mRequestQueue.put(paramTPRequestItem);
      return;
    }
    catch (Throwable paramTPRequestItem)
    {
      TPDLProxyLog.e("TPCGIRequester", 0, "tpdlnative", "RequestQueue add failed:" + paramTPRequestItem.toString());
    }
  }
  
  private void addRetryRequestItem(TPRequestItem paramTPRequestItem)
  {
    try
    {
      if (paramTPRequestItem.getRequestTimes() <= 3) {
        this.mRetryQueue.put(paramTPRequestItem);
      }
      return;
    }
    catch (Throwable paramTPRequestItem)
    {
      TPDLProxyLog.e("TPCGIRequester", 0, "tpdlnative", "retry queue add failed" + paramTPRequestItem.toString());
    }
  }
  
  public static TPCGIRequester getInstance()
  {
    if (mRequester == null) {}
    try
    {
      if (mRequester == null) {
        mRequester = new TPCGIRequester();
      }
      return mRequester;
    }
    finally {}
  }
  
  /* Error */
  private boolean handleRequestItem(TPRequestItem paramTPRequestItem)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_1
    //   7: invokevirtual 127	com/tencent/thumbplayer/core/downloadproxy/utils/TPRequestItem:getUrl	()Ljava/lang/String;
    //   10: astore 7
    //   12: new 129	java/net/URL
    //   15: dup
    //   16: aload 7
    //   18: invokespecial 132	java/net/URL:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 136	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: checkcast 138	java/net/HttpURLConnection
    //   27: astore 7
    //   29: iload 4
    //   31: istore_3
    //   32: aload 7
    //   34: ldc 140
    //   36: invokevirtual 143	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   39: iload 4
    //   41: istore_3
    //   42: aload 7
    //   44: sipush 3000
    //   47: invokevirtual 147	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   50: iload 4
    //   52: istore_3
    //   53: aload 7
    //   55: invokevirtual 150	java/net/HttpURLConnection:connect	()V
    //   58: iload 4
    //   60: istore_3
    //   61: aload 7
    //   63: invokevirtual 153	java/net/HttpURLConnection:getResponseCode	()I
    //   66: istore_2
    //   67: iload_2
    //   68: sipush 200
    //   71: if_icmpeq +14 -> 85
    //   74: iload 5
    //   76: istore 4
    //   78: iload_2
    //   79: sipush 206
    //   82: if_icmpne +226 -> 308
    //   85: iconst_1
    //   86: istore 6
    //   88: iconst_1
    //   89: istore 5
    //   91: iload 5
    //   93: istore_3
    //   94: iload 6
    //   96: istore 4
    //   98: aload_1
    //   99: invokevirtual 156	com/tencent/thumbplayer/core/downloadproxy/utils/TPRequestItem:getRequestType	()I
    //   102: sipush 2011
    //   105: if_icmpne +203 -> 308
    //   108: iload 5
    //   110: istore_3
    //   111: new 158	java/lang/StringBuffer
    //   114: dup
    //   115: invokespecial 159	java/lang/StringBuffer:<init>	()V
    //   118: astore_1
    //   119: iload 5
    //   121: istore_3
    //   122: new 161	java/io/BufferedReader
    //   125: dup
    //   126: new 163	java/io/InputStreamReader
    //   129: dup
    //   130: aload 7
    //   132: invokevirtual 167	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   135: ldc 169
    //   137: invokespecial 172	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   140: invokespecial 175	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   143: astore 8
    //   145: iload 5
    //   147: istore_3
    //   148: aload 8
    //   150: invokevirtual 178	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   153: astore 9
    //   155: aload 9
    //   157: ifnull +76 -> 233
    //   160: iload 5
    //   162: istore_3
    //   163: aload_1
    //   164: aload 9
    //   166: invokevirtual 181	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   169: pop
    //   170: iload 5
    //   172: istore_3
    //   173: aload_1
    //   174: ldc 183
    //   176: invokevirtual 181	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   179: pop
    //   180: goto -35 -> 145
    //   183: astore 8
    //   185: aload 7
    //   187: astore_1
    //   188: aload 8
    //   190: astore 7
    //   192: ldc 8
    //   194: iconst_0
    //   195: ldc 93
    //   197: new 95	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   204: ldc 185
    //   206: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 7
    //   211: invokevirtual 106	java/lang/Throwable:toString	()Ljava/lang/String;
    //   214: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 113	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   231: iload_3
    //   232: ireturn
    //   233: iload 5
    //   235: istore_3
    //   236: aload 8
    //   238: invokevirtual 191	java/io/BufferedReader:close	()V
    //   241: iload 5
    //   243: istore_3
    //   244: new 193	org/json/JSONObject
    //   247: dup
    //   248: aload_1
    //   249: invokevirtual 194	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   252: ldc 196
    //   254: ldc 198
    //   256: invokevirtual 204	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   259: invokespecial 205	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   262: astore_1
    //   263: iload 5
    //   265: istore_3
    //   266: iload 6
    //   268: istore 4
    //   270: aload_1
    //   271: ldc 207
    //   273: invokevirtual 211	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   276: ifne +32 -> 308
    //   279: iload 5
    //   281: istore_3
    //   282: aload_1
    //   283: ldc 213
    //   285: invokevirtual 217	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   288: invokevirtual 218	org/json/JSONObject:toString	()Ljava/lang/String;
    //   291: astore_1
    //   292: iload 5
    //   294: istore_3
    //   295: invokestatic 223	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   298: ldc 225
    //   300: aload_1
    //   301: invokevirtual 229	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:setUserData	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: iload 6
    //   306: istore 4
    //   308: aload 7
    //   310: ifnull +52 -> 362
    //   313: aload 7
    //   315: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   318: iload 4
    //   320: ireturn
    //   321: astore 7
    //   323: aconst_null
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +7 -> 333
    //   329: aload_1
    //   330: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   333: aload 7
    //   335: athrow
    //   336: astore 8
    //   338: aload 7
    //   340: astore_1
    //   341: aload 8
    //   343: astore 7
    //   345: goto -20 -> 325
    //   348: astore 7
    //   350: goto -25 -> 325
    //   353: astore 7
    //   355: iconst_0
    //   356: istore_3
    //   357: aconst_null
    //   358: astore_1
    //   359: goto -167 -> 192
    //   362: iload 4
    //   364: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	TPCGIRequester
    //   0	365	1	paramTPRequestItem	TPRequestItem
    //   66	17	2	i	int
    //   31	326	3	bool1	boolean
    //   4	359	4	bool2	boolean
    //   1	292	5	bool3	boolean
    //   86	219	6	bool4	boolean
    //   10	304	7	localObject1	Object
    //   321	18	7	localObject2	Object
    //   343	1	7	localObject3	Object
    //   348	1	7	localObject4	Object
    //   353	1	7	localThrowable1	Throwable
    //   143	6	8	localBufferedReader	java.io.BufferedReader
    //   183	54	8	localThrowable2	Throwable
    //   336	6	8	localObject5	Object
    //   153	12	9	str	String
    // Exception table:
    //   from	to	target	type
    //   32	39	183	java/lang/Throwable
    //   42	50	183	java/lang/Throwable
    //   53	58	183	java/lang/Throwable
    //   61	67	183	java/lang/Throwable
    //   98	108	183	java/lang/Throwable
    //   111	119	183	java/lang/Throwable
    //   122	145	183	java/lang/Throwable
    //   148	155	183	java/lang/Throwable
    //   163	170	183	java/lang/Throwable
    //   173	180	183	java/lang/Throwable
    //   236	241	183	java/lang/Throwable
    //   244	263	183	java/lang/Throwable
    //   270	279	183	java/lang/Throwable
    //   282	292	183	java/lang/Throwable
    //   295	304	183	java/lang/Throwable
    //   12	29	321	finally
    //   32	39	336	finally
    //   42	50	336	finally
    //   53	58	336	finally
    //   61	67	336	finally
    //   98	108	336	finally
    //   111	119	336	finally
    //   122	145	336	finally
    //   148	155	336	finally
    //   163	170	336	finally
    //   173	180	336	finally
    //   236	241	336	finally
    //   244	263	336	finally
    //   270	279	336	finally
    //   282	292	336	finally
    //   295	304	336	finally
    //   192	223	348	finally
    //   12	29	353	java/lang/Throwable
  }
  
  private static ExecutorService obtainThreadExcutor()
  {
    if (mCustomExecutor == null) {}
    try
    {
      if (mCustomExecutor == null) {
        mCustomExecutor = Executors.newSingleThreadExecutor();
      }
      return mCustomExecutor;
    }
    finally {}
  }
  
  private void process()
  {
    obtainThreadExcutor().execute(new TPCGIRequester.2(this));
  }
  
  public void addRequestItem(String paramString, int paramInt)
  {
    if (paramString.isEmpty())
    {
      TPDLProxyLog.e("TPCGIRequester", 0, "tpdlnative", "request url null");
      return;
    }
    addNotifyReqQueue(new TPRequestItem(paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPCGIRequester
 * JD-Core Version:    0.7.0.1
 */