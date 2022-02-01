package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ProxyService(proxy=DownloaderProxy.class)
public class DownloaderProxyDefault
  extends DownloaderProxy
{
  public static final int ERR_ABORTED = -3;
  public static final int ERR_INVALID_URL = -1;
  public static final int ERR_IO_ISSUES = -2;
  public static final int ERR_UNKOWN = -100;
  public static final int ERR_UNREASONABLE_REDIRECT_COUNT = -4;
  private static final String TAG = "DefaultDownloader";
  private static AtomicInteger uniqueTaskID = new AtomicInteger(1);
  public ConcurrentHashMap<Integer, DownloadTask> taskMap = new ConcurrentHashMap();
  
  public void abort(String paramString)
  {
    Object localObject = null;
    Iterator localIterator = this.taskMap.values().iterator();
    if (localIterator.hasNext())
    {
      DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
      if (!localDownloadTask.mUrl.equals(paramString)) {
        break label78;
      }
      localObject = localDownloadTask;
    }
    label78:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        localObject.mAbort = true;
        this.taskMap.remove(Integer.valueOf(localObject.mTaskId));
      }
      return;
    }
  }
  
  public boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    paramString1 = new DownloadTask(uniqueTaskID.getAndIncrement(), paramString1, paramMap, paramString2, paramInt, paramDownloadListener);
    this.taskMap.put(Integer.valueOf(paramString1.mTaskId), paramString1);
    ThreadManager.executeOnNetworkIOThreadPool(paramString1);
    return true;
  }
  
  public void preConnectDownloadHost() {}
  
  public class DownloadTask
    implements Runnable
  {
    public volatile boolean mAbort;
    public String mFilePath;
    public Map<String, String> mHeader;
    public DownloaderProxy.DownloadListener mListener;
    public int mTaskId;
    public int mTimeout;
    public String mUrl;
    private int redirectCount = 0;
    
    public DownloadTask(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
    {
      this.mTaskId = paramString1;
      this.mUrl = paramMap;
      this.mHeader = paramString2;
      this.mFilePath = paramInt;
      this.mTimeout = paramDownloadListener;
      Object localObject;
      this.mListener = localObject;
      this.mAbort = false;
    }
    
    private HttpURLConnection getRealConnection(String paramString)
    {
      HttpURLConnection localHttpURLConnection;
      int i;
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        localHttpURLConnection.setConnectTimeout(this.mTimeout * 1000);
        localHttpURLConnection.setRequestMethod("GET");
        if (this.mHeader != null)
        {
          paramString = this.mHeader.keySet().iterator();
          while (paramString.hasNext())
          {
            String str = (String)paramString.next();
            localHttpURLConnection.setRequestProperty(str, (String)this.mHeader.get(str));
          }
        }
        if (i == 302) {
          break label210;
        }
      }
      catch (MalformedURLException paramString)
      {
        throw new DownloadException(-1, paramString.getMessage());
        i = localHttpURLConnection.getResponseCode();
        if (this.mAbort)
        {
          QMLog.i("DefaultDownloader", this.mUrl + " aborted");
          throw new DownloadException(-3, "aborted by outside");
        }
      }
      catch (Throwable paramString)
      {
        QMLog.e("DefaultDownloader", "unknown err", paramString);
        throw new DownloadException(-100, paramString.getMessage());
      }
      paramString = localHttpURLConnection;
      if (i == 301)
      {
        label210:
        this.redirectCount += 1;
        localHttpURLConnection.disconnect();
        if (this.redirectCount > 30)
        {
          QMLog.e("DefaultDownloader", "url: " + this.mUrl + "server redirects connection to many times");
          throw new DownloadException(-4, "url: " + this.mUrl + "server redirects connection to many times");
        }
        paramString = getRealConnection(localHttpURLConnection.getHeaderField("Location"));
      }
      return paramString;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: new 179	java/io/File
      //   3: dup
      //   4: aload_0
      //   5: getfield 45	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mFilePath	Ljava/lang/String;
      //   8: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
      //   11: astore 7
      //   13: aload 7
      //   15: invokevirtual 183	java/io/File:exists	()Z
      //   18: ifeq +9 -> 27
      //   21: aload 7
      //   23: invokevirtual 186	java/io/File:delete	()Z
      //   26: pop
      //   27: aload 7
      //   29: invokevirtual 190	java/io/File:getParentFile	()Ljava/io/File;
      //   32: invokevirtual 183	java/io/File:exists	()Z
      //   35: ifne +12 -> 47
      //   38: aload 7
      //   40: invokevirtual 190	java/io/File:getParentFile	()Ljava/io/File;
      //   43: invokevirtual 193	java/io/File:mkdirs	()Z
      //   46: pop
      //   47: aload 7
      //   49: invokevirtual 196	java/io/File:createNewFile	()Z
      //   52: pop
      //   53: aload_0
      //   54: aload_0
      //   55: getfield 41	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mUrl	Ljava/lang/String;
      //   58: invokespecial 174	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:getRealConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
      //   61: astore 5
      //   63: aload 5
      //   65: ifnonnull +14 -> 79
      //   68: return
      //   69: astore 4
      //   71: aload 4
      //   73: invokevirtual 199	java/io/IOException:printStackTrace	()V
      //   76: goto -23 -> 53
      //   79: aload 5
      //   81: invokevirtual 129	java/net/HttpURLConnection:getResponseCode	()I
      //   84: istore_1
      //   85: iload_1
      //   86: sipush 200
      //   89: if_icmplt +185 -> 274
      //   92: iload_1
      //   93: sipush 300
      //   96: if_icmpge +178 -> 274
      //   99: new 11	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream
      //   102: dup
      //   103: aload_0
      //   104: aload 5
      //   106: invokevirtual 203	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   109: invokespecial 206	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream:<init>	(Lcom/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask;Ljava/io/InputStream;)V
      //   112: astore 4
      //   114: aload 4
      //   116: checkcast 11	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream
      //   119: astore 6
      //   121: aload_0
      //   122: getfield 49	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
      //   125: iload_1
      //   126: aload 5
      //   128: invokevirtual 210	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
      //   131: invokeinterface 216 3 0
      //   136: aload 5
      //   138: invokevirtual 219	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
      //   141: astore 8
      //   143: aload 8
      //   145: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   148: ifne +320 -> 468
      //   151: aload 8
      //   153: ldc 227
      //   155: invokevirtual 230	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   158: ifeq +310 -> 468
      //   161: new 232	java/util/zip/GZIPInputStream
      //   164: dup
      //   165: aload 6
      //   167: invokespecial 235	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   170: astore 4
      //   172: aload 5
      //   174: invokevirtual 238	java/net/HttpURLConnection:getContentLength	()I
      //   177: istore_2
      //   178: new 240	java/io/FileOutputStream
      //   181: dup
      //   182: aload 7
      //   184: invokespecial 243	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   187: astore 7
      //   189: sipush 4096
      //   192: newarray byte
      //   194: astore 8
      //   196: aload 4
      //   198: aload 8
      //   200: invokevirtual 249	java/io/InputStream:read	([B)I
      //   203: istore_3
      //   204: iload_3
      //   205: iconst_m1
      //   206: if_icmpeq +185 -> 391
      //   209: aload_0
      //   210: getfield 51	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mAbort	Z
      //   213: ifeq +113 -> 326
      //   216: aload 4
      //   218: invokevirtual 252	java/io/InputStream:close	()V
      //   221: aload 7
      //   223: invokevirtual 255	java/io/OutputStream:close	()V
      //   226: return
      //   227: astore 4
      //   229: ldc 131
      //   231: ldc_w 257
      //   234: aload 4
      //   236: invokestatic 156	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   239: aload_0
      //   240: getfield 32	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:this$0	Lcom/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault;
      //   243: getfield 261	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault:taskMap	Ljava/util/concurrent/ConcurrentHashMap;
      //   246: aload_0
      //   247: getfield 39	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mTaskId	I
      //   250: invokestatic 267	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   253: invokevirtual 272	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   256: pop
      //   257: aload_0
      //   258: getfield 49	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
      //   261: bipush 254
      //   263: aload 4
      //   265: invokevirtual 273	java/io/IOException:getMessage	()Ljava/lang/String;
      //   268: invokeinterface 276 3 0
      //   273: return
      //   274: new 118	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   277: dup
      //   278: iload_1
      //   279: ldc_w 278
      //   282: invokespecial 125	com/tencent/qqmini/sdk/core/proxy/service/DownloadException:<init>	(ILjava/lang/String;)V
      //   285: athrow
      //   286: astore 4
      //   288: aload_0
      //   289: getfield 32	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:this$0	Lcom/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault;
      //   292: getfield 261	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault:taskMap	Ljava/util/concurrent/ConcurrentHashMap;
      //   295: aload_0
      //   296: getfield 39	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mTaskId	I
      //   299: invokestatic 267	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   302: invokevirtual 272	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   305: pop
      //   306: aload_0
      //   307: getfield 49	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
      //   310: aload 4
      //   312: invokevirtual 281	com/tencent/qqmini/sdk/core/proxy/service/DownloadException:getCode	()I
      //   315: aload 4
      //   317: invokevirtual 282	com/tencent/qqmini/sdk/core/proxy/service/DownloadException:getMessage	()Ljava/lang/String;
      //   320: invokeinterface 276 3 0
      //   325: return
      //   326: aload 7
      //   328: aload 8
      //   330: iconst_0
      //   331: iload_3
      //   332: invokevirtual 286	java/io/OutputStream:write	([BII)V
      //   335: iload_2
      //   336: iconst_m1
      //   337: if_icmpeq +34 -> 371
      //   340: aload_0
      //   341: getfield 49	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
      //   344: aload 6
      //   346: invokevirtual 289	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream:getPosition	()I
      //   349: i2f
      //   350: fconst_1
      //   351: fmul
      //   352: iload_2
      //   353: i2f
      //   354: fdiv
      //   355: aload 6
      //   357: invokevirtual 289	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream:getPosition	()I
      //   360: i2l
      //   361: iload_2
      //   362: i2l
      //   363: invokeinterface 293 6 0
      //   368: goto -172 -> 196
      //   371: aload_0
      //   372: getfield 49	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
      //   375: fconst_0
      //   376: aload 6
      //   378: invokevirtual 289	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask$PositionFixedInputStream:getPosition	()I
      //   381: i2l
      //   382: lconst_0
      //   383: invokeinterface 293 6 0
      //   388: goto -192 -> 196
      //   391: aload 4
      //   393: invokevirtual 252	java/io/InputStream:close	()V
      //   396: aload 7
      //   398: invokevirtual 255	java/io/OutputStream:close	()V
      //   401: aload 5
      //   403: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
      //   406: aload_0
      //   407: getfield 32	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:this$0	Lcom/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault;
      //   410: getfield 261	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault:taskMap	Ljava/util/concurrent/ConcurrentHashMap;
      //   413: aload_0
      //   414: getfield 39	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mTaskId	I
      //   417: invokestatic 267	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   420: invokevirtual 272	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   423: pop
      //   424: aload_0
      //   425: getfield 49	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mListener	Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;
      //   428: iload_1
      //   429: aload_0
      //   430: getfield 45	com/tencent/qqmini/sdk/core/proxy/service/DownloaderProxyDefault$DownloadTask:mFilePath	Ljava/lang/String;
      //   433: new 295	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult
      //   436: dup
      //   437: ldc_w 297
      //   440: ldc2_w 298
      //   443: iconst_1
      //   444: ldc_w 297
      //   447: iconst_1
      //   448: lconst_0
      //   449: lconst_0
      //   450: lconst_0
      //   451: lconst_0
      //   452: lconst_0
      //   453: lconst_0
      //   454: aload 5
      //   456: invokevirtual 210	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
      //   459: invokespecial 302	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult:<init>	(Ljava/lang/String;JZLjava/lang/String;ZJJJJJJLjava/util/Map;)V
      //   462: invokeinterface 306 4 0
      //   467: return
      //   468: goto -296 -> 172
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	471	0	this	DownloadTask
      //   84	345	1	i	int
      //   177	185	2	j	int
      //   203	129	3	k	int
      //   69	3	4	localIOException1	IOException
      //   112	105	4	localObject1	Object
      //   227	37	4	localIOException2	IOException
      //   286	106	4	localDownloadException	DownloadException
      //   61	394	5	localHttpURLConnection	HttpURLConnection
      //   119	258	6	localPositionFixedInputStream	PositionFixedInputStream
      //   11	386	7	localObject2	Object
      //   141	188	8	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   27	47	69	java/io/IOException
      //   47	53	69	java/io/IOException
      //   53	63	227	java/io/IOException
      //   79	85	227	java/io/IOException
      //   99	172	227	java/io/IOException
      //   172	196	227	java/io/IOException
      //   196	204	227	java/io/IOException
      //   209	226	227	java/io/IOException
      //   274	286	227	java/io/IOException
      //   326	335	227	java/io/IOException
      //   340	368	227	java/io/IOException
      //   371	388	227	java/io/IOException
      //   391	467	227	java/io/IOException
      //   53	63	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   79	85	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   99	172	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   172	196	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   196	204	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   209	226	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   274	286	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   326	335	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   340	368	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   371	388	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
      //   391	467	286	com/tencent/qqmini/sdk/core/proxy/service/DownloadException
    }
    
    class PositionFixedInputStream
      extends InputStream
    {
      private int markPosition = -1;
      private int position = 0;
      private InputStream proxiedStream;
      
      public PositionFixedInputStream(InputStream paramInputStream)
      {
        this.proxiedStream = paramInputStream;
      }
      
      public int available()
        throws IOException
      {
        return this.proxiedStream.available();
      }
      
      public void close()
        throws IOException
      {
        this.proxiedStream.close();
      }
      
      public int getPosition()
      {
        return this.position;
      }
      
      public void mark(int paramInt)
      {
        try
        {
          this.markPosition = paramInt;
          this.proxiedStream.mark(paramInt);
          return;
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
      }
      
      public boolean markSupported()
      {
        return this.proxiedStream.markSupported();
      }
      
      public int read()
        throws IOException
      {
        this.position += 1;
        return this.proxiedStream.read();
      }
      
      public int read(byte[] paramArrayOfByte)
        throws IOException
      {
        this.position += paramArrayOfByte.length;
        return this.proxiedStream.read(paramArrayOfByte);
      }
      
      public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
        throws IOException
      {
        this.position += paramInt2;
        return this.proxiedStream.read(paramArrayOfByte, paramInt1, paramInt2);
      }
      
      public void reset()
        throws IOException
      {
        try
        {
          this.position = this.markPosition;
          this.proxiedStream.reset();
          return;
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
      }
      
      public long skip(long paramLong)
        throws IOException
      {
        return this.proxiedStream.skip(paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault
 * JD-Core Version:    0.7.0.1
 */