package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.NetworkFlowStatistics;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.a.e.b;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public abstract class a
  implements NetworkManager.NetStatusListener, ThreadPool.Job<DownloadResult>
{
  private static volatile int F = 0;
  protected static final ThreadLocal<e.b> i;
  private static final BytesBufferPool p = new BytesBufferPool(4, 8192);
  private static final Object x;
  private static volatile long y;
  private ReportHandler A;
  private ReportHandler B;
  private com.tencent.component.network.module.cache.a.b C;
  private Downloader.NetworkFlowStatistics D;
  private Map<String, String> E;
  protected final Context a;
  protected int b = 1;
  protected int c = 0;
  protected long d;
  protected DownloadGlobalStrategy.StrategyLib e = null;
  protected DownloadGlobalStrategy.StrategyInfo f = null;
  protected DownloadGlobalStrategy.StrategyInfo g = null;
  protected HttpGet h = null;
  protected HttpClient j;
  protected ResumeTransfer k;
  protected IPConfigStrategy l;
  protected IPConfigStrategy m;
  protected PortConfigStrategy n;
  protected long o = 0L;
  private final String q;
  private final String r;
  private PriorityThreadPool.Priority s;
  private String t;
  private long u = -1L;
  private boolean v = true;
  private List<ReportHandler.DownloadReportObject> w = new ArrayList();
  private a z;
  
  static
  {
    i = new b();
    x = new Object();
    y = System.currentTimeMillis();
  }
  
  public a(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean)
  {
    AssertUtil.assertTrue(Const.a(paramString1));
    this.a = paramContext;
    this.q = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.r = paramString2;
      this.j = paramHttpClient;
      if (!paramBoolean) {
        break label119;
      }
    }
    label119:
    for (paramContext = PriorityThreadPool.Priority.HIGH;; paramContext = PriorityThreadPool.Priority.NORMAL)
    {
      this.s = paramContext;
      return;
      paramString2 = paramString1;
      break;
    }
  }
  
  private DownloadResult a(ThreadPool.JobContext paramJobContext)
  {
    DownloadResult localDownloadResult = new DownloadResult(this.q);
    if (paramJobContext.isCancelled()) {
      return localDownloadResult;
    }
    if (this.z != null) {}
    for (String str = this.z.a(this.q); !TextUtils.isEmpty(str); str = null)
    {
      Const.c("downloader", "find cache entry:" + str + " url:" + this.q);
      localDownloadResult.setPath(str);
      localDownloadResult.getStatus().setSucceed();
      return localDownloadResult;
    }
    paramJobContext.setMode(2);
    for (;;)
    {
      try
      {
        a();
        NetworkManager.registNetStatusListener(this);
        a(paramJobContext, localDownloadResult);
        if (!NetworkUtils.isNetworkAvailable(this.a))
        {
          this.v = false;
          localDownloadResult.getStatus().setFailed(6);
        }
        b(paramJobContext);
        F -= 1;
        if (!localDownloadResult.getStatus().isSucceed()) {
          continue;
        }
        DownloadGlobalStrategy.getInstance(this.a).report(this.a, this.q, this.t, this.g, localDownloadResult.getStatus().isSucceed());
        if (localDownloadResult.getStatus().isSucceed()) {
          com.tencent.component.network.module.a.b.a().a(localDownloadResult.getContent().size, localDownloadResult.getProcess().startTime, localDownloadResult.getProcess().endTime);
        }
      }
      catch (Throwable paramJobContext)
      {
        Const.d("downloader", "exception when execute DownloadTask. ", paramJobContext);
        NetworkManager.unregistNetStatusListener(this);
        continue;
      }
      finally
      {
        NetworkManager.unregistNetStatusListener(this);
      }
      return localDownloadResult;
      if ((this.e != null) && (this.e.getBestStrategy() != null)) {
        DownloadGlobalStrategy.getInstance(this.a).report(this.a, this.q, this.t, this.e.getBestStrategy(), localDownloadResult.getStatus().isSucceed());
      }
    }
  }
  
  private void a(String paramString, long paramLong, float paramFloat)
  {
    if (this.z == null) {
      return;
    }
    this.z.a(paramString, paramLong, paramFloat);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new File(paramString);
        if (b.a(paramString, true))
        {
          this.C.c(paramString.getName());
          if (paramLong <= 0L) {
            return true;
          }
          while (!paramString.exists()) {
            paramString = paramString.getParentFile();
          }
          paramString = new StatFs(paramString.getAbsolutePath());
          long l1 = paramString.getAvailableBlocks();
          int i1 = paramString.getBlockSize();
          if (i1 * l1 > paramLong) {
            return true;
          }
        }
      }
      catch (IOException paramString) {}
    }
    return false;
  }
  
  private boolean a(HttpResponse paramHttpResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext)
  {
    Object localObject = paramHttpResponse.getEntity();
    this.d = ((HttpEntity)localObject).getContentLength();
    paramDownloadResult.getContent().length = this.d;
    Header localHeader = ((HttpEntity)localObject).getContentType();
    if (localHeader != null) {
      paramDownloadResult.getContent().type = localHeader.getValue();
    }
    localObject = ((HttpEntity)localObject).getContentEncoding();
    if (localObject != null) {
      paramDownloadResult.getContent().encoding = ((Header)localObject).getValue();
    }
    localObject = paramHttpResponse.getAllHeaders();
    int i2;
    int i1;
    if (localObject != null)
    {
      i2 = localObject.length;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i2)
      {
        label114:
        localObject = paramHttpResponse.getFirstHeader("Size");
        if (localObject == null) {
          break label215;
        }
      }
      try
      {
        this.u = Integer.parseInt(((Header)localObject).getValue());
        for (paramDownloadResult.getContent().realsize = this.u;; paramDownloadResult.getContent().realsize = -1L)
        {
          label156:
          if (!paramJobContext.isCancelled()) {
            break label235;
          }
          return false;
          if ("Client-Ip".equalsIgnoreCase(localObject[i1].getName()))
          {
            paramDownloadResult.getContent().clientip = localObject[i1].getValue();
            break label114;
          }
          i1 += 1;
          break;
          label215:
          this.u = -1L;
        }
        label235:
        localObject = paramHttpResponse.headerIterator("Cache-Control");
        label251:
        if ((localObject == null) || (!((HeaderIterator)localObject).hasNext()))
        {
          if (paramJobContext.isCancelled()) {
            break label334;
          }
          if (this.z != null) {
            break label336;
          }
        }
        label261:
        label334:
        label336:
        for (boolean bool = true;; bool = this.z.a(paramDownloadResult, paramHttpResponse))
        {
          if (bool) {
            break label352;
          }
          paramDownloadResult.getStatus().setFailed(5);
          return false;
          localHeader = ((HeaderIterator)localObject).nextHeader();
          if ((localHeader == null) || (!"no-cache".equalsIgnoreCase(localHeader.getValue()))) {
            break label251;
          }
          paramDownloadResult.getContent().noCache = true;
          break label261;
          break;
        }
        label352:
        if ((this.k != null) && (!this.k.handleResponse(this.q, this.t, paramHttpResponse)))
        {
          Const.d("downloader", "download 断线续传 response not valid.");
          this.k.onDownloadResult(this.q, true);
          return false;
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        break label156;
      }
    }
  }
  
  public static int b()
  {
    return F;
  }
  
  private void b(ThreadPool.JobContext paramJobContext)
  {
    if (this.A == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.w.iterator();
      while (localIterator.hasNext())
      {
        ReportHandler.DownloadReportObject localDownloadReportObject = (ReportHandler.DownloadReportObject)localIterator.next();
        if (((this.v) && (!paramJobContext.isCancelled())) || ((localDownloadReportObject.retCode == 0) && (this.A != null))) {
          this.A.uploadReport(localDownloadReportObject);
        }
      }
    }
  }
  
  public static void c()
  {
    F += 1;
  }
  
  protected void a()
  {
    if (this.t == null) {
      this.t = Const.b(this.q);
    }
  }
  
  public final void a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt <= 0) {
      i1 = 1;
    }
    this.b = i1;
  }
  
  protected final void a(DownloadResult paramDownloadResult, Const paramConst)
  {
    if (this.B != null) {
      this.B.handleReport$7905c7a2(paramDownloadResult, paramConst);
    }
    if (this.A != null)
    {
      paramDownloadResult = this.A.obtainReportObj$3f852cae(paramDownloadResult, paramConst);
      this.w.add(paramDownloadResult);
    }
  }
  
  public final void a(a parama, IPConfigStrategy paramIPConfigStrategy1, IPConfigStrategy paramIPConfigStrategy2, PortConfigStrategy paramPortConfigStrategy, ResumeTransfer paramResumeTransfer, ReportHandler paramReportHandler1, ReportHandler paramReportHandler2, Downloader.NetworkFlowStatistics paramNetworkFlowStatistics, com.tencent.component.network.module.cache.a.b paramb)
  {
    this.z = parama;
    this.k = paramResumeTransfer;
    this.A = paramReportHandler1;
    this.B = paramReportHandler2;
    this.C = paramb;
    this.D = paramNetworkFlowStatistics;
    this.l = paramIPConfigStrategy1;
    this.m = paramIPConfigStrategy2;
    this.n = paramPortConfigStrategy;
  }
  
  public abstract void a(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult);
  
  protected final void a(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if (this.z == null) {
      return;
    }
    Iterator localIterator;
    if ((this.E != null) && (paramHttpRequest != null)) {
      localIterator = this.E.entrySet().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.z.a(paramString1, paramString2, paramHttpRequest);
        return;
      }
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        paramHttpRequest.addHeader(str, (String)localObject);
      }
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.E = paramMap;
  }
  
  /* Error */
  protected final boolean a(HttpResponse paramHttpResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext, int paramInt)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: invokespecial 527	com/tencent/component/network/downloader/impl/a:a	(Lorg/apache/http/HttpResponse;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;)Z
    //   7: ifne +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   15: lstore 14
    //   17: iload 4
    //   19: sipush 206
    //   22: if_icmpne +153 -> 175
    //   25: aload_0
    //   26: getfield 428	com/tencent/component/network/downloader/impl/a:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   29: ifnull +136 -> 165
    //   32: aload_0
    //   33: getfield 428	com/tencent/component/network/downloader/impl/a:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   36: aload_0
    //   37: getfield 141	com/tencent/component/network/downloader/impl/a:q	Ljava/lang/String;
    //   40: invokeinterface 530 2 0
    //   45: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifne +117 -> 165
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 428	com/tencent/component/network/downloader/impl/a:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   56: aload_0
    //   57: getfield 141	com/tencent/component/network/downloader/impl/a:q	Ljava/lang/String;
    //   60: invokeinterface 530 2 0
    //   65: invokevirtual 203	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   68: iconst_1
    //   69: istore 20
    //   71: aconst_null
    //   72: astore 22
    //   74: getstatic 80	com/tencent/component/network/downloader/impl/a:p	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   77: invokevirtual 534	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   80: astore 23
    //   82: lconst_0
    //   83: lstore 10
    //   85: aload_0
    //   86: getfield 353	com/tencent/component/network/downloader/impl/a:d	J
    //   89: lstore 16
    //   91: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   94: lstore 12
    //   96: new 306	java/io/File
    //   99: dup
    //   100: aload_2
    //   101: invokevirtual 537	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   104: invokespecial 307	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore 24
    //   109: aload 24
    //   111: iconst_0
    //   112: invokestatic 310	com/tencent/component/network/downloader/impl/a$b:a	(Ljava/io/File;Z)Z
    //   115: pop
    //   116: aload_3
    //   117: invokeinterface 175 1 0
    //   122: istore 21
    //   124: iload 21
    //   126: ifeq +282 -> 408
    //   129: getstatic 80	com/tencent/component/network/downloader/impl/a:p	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   132: aload 23
    //   134: invokevirtual 541	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   137: aload_0
    //   138: getfield 487	com/tencent/component/network/downloader/impl/a:D	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   141: ifnull +22 -> 163
    //   144: aload_0
    //   145: getfield 487	com/tencent/component/network/downloader/impl/a:D	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   148: invokestatic 544	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   151: lconst_0
    //   152: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   155: lload 12
    //   157: lsub
    //   158: invokeinterface 550 6 0
    //   163: iconst_0
    //   164: ireturn
    //   165: ldc 182
    //   167: ldc_w 552
    //   170: invokestatic 438	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: iconst_0
    //   174: ireturn
    //   175: aload_0
    //   176: getfield 428	com/tencent/component/network/downloader/impl/a:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   179: ifnull +44 -> 223
    //   182: aload_0
    //   183: getfield 428	com/tencent/component/network/downloader/impl/a:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   186: aload_0
    //   187: getfield 141	com/tencent/component/network/downloader/impl/a:q	Ljava/lang/String;
    //   190: invokeinterface 530 2 0
    //   195: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +25 -> 223
    //   201: iload 4
    //   203: sipush 200
    //   206: if_icmpne +17 -> 223
    //   209: aload_0
    //   210: getfield 428	com/tencent/component/network/downloader/impl/a:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   213: aload_0
    //   214: getfield 141	com/tencent/component/network/downloader/impl/a:q	Ljava/lang/String;
    //   217: iconst_1
    //   218: invokeinterface 442 3 0
    //   223: aload_0
    //   224: getfield 177	com/tencent/component/network/downloader/impl/a:z	Lcom/tencent/component/network/downloader/impl/a$a;
    //   227: ifnull +118 -> 345
    //   230: aload_0
    //   231: getfield 177	com/tencent/component/network/downloader/impl/a:z	Lcom/tencent/component/network/downloader/impl/a$a;
    //   234: aload_0
    //   235: getfield 141	com/tencent/component/network/downloader/impl/a:q	Ljava/lang/String;
    //   238: invokeinterface 553 2 0
    //   243: astore 23
    //   245: aload 23
    //   247: astore 22
    //   249: aload 23
    //   251: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifeq +21 -> 275
    //   257: aload_0
    //   258: getfield 141	com/tencent/component/network/downloader/impl/a:q	Ljava/lang/String;
    //   261: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   264: ifeq +87 -> 351
    //   267: invokestatic 559	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   270: invokevirtual 560	java/util/UUID:toString	()Ljava/lang/String;
    //   273: astore 22
    //   275: aload_0
    //   276: getfield 312	com/tencent/component/network/downloader/impl/a:C	Lcom/tencent/component/network/module/cache/a/b;
    //   279: aload 22
    //   281: invokevirtual 561	com/tencent/component/network/module/cache/a/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   284: astore 23
    //   286: aload_0
    //   287: getfield 312	com/tencent/component/network/downloader/impl/a:C	Lcom/tencent/component/network/module/cache/a/b;
    //   290: aload 22
    //   292: iconst_0
    //   293: invokevirtual 564	com/tencent/component/network/module/cache/a/b:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   296: astore 22
    //   298: aload_0
    //   299: aload 23
    //   301: aload_0
    //   302: getfield 353	com/tencent/component/network/downloader/impl/a:d	J
    //   305: invokespecial 566	com/tencent/component/network/downloader/impl/a:a	(Ljava/lang/String;J)Z
    //   308: ifeq +58 -> 366
    //   311: aload_2
    //   312: aload 23
    //   314: invokevirtual 203	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   317: iload 4
    //   319: sipush 200
    //   322: if_icmpne +17 -> 339
    //   325: new 306	java/io/File
    //   328: dup
    //   329: aload_2
    //   330: invokevirtual 537	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   333: invokespecial 307	java/io/File:<init>	(Ljava/lang/String;)V
    //   336: invokestatic 572	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   339: iconst_0
    //   340: istore 20
    //   342: goto -271 -> 71
    //   345: aconst_null
    //   346: astore 23
    //   348: goto -103 -> 245
    //   351: aload_0
    //   352: getfield 141	com/tencent/component/network/downloader/impl/a:q	Ljava/lang/String;
    //   355: invokevirtual 575	java/lang/String:hashCode	()I
    //   358: invokestatic 579	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   361: astore 22
    //   363: goto -88 -> 275
    //   366: aload 23
    //   368: aload 22
    //   370: invokestatic 583	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   373: ifne +25 -> 398
    //   376: aload_0
    //   377: aload 22
    //   379: aload_0
    //   380: getfield 353	com/tencent/component/network/downloader/impl/a:d	J
    //   383: invokespecial 566	com/tencent/component/network/downloader/impl/a:a	(Ljava/lang/String;J)Z
    //   386: ifeq +12 -> 398
    //   389: aload_2
    //   390: aload 22
    //   392: invokevirtual 203	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   395: goto -78 -> 317
    //   398: aload_2
    //   399: invokevirtual 207	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   402: iconst_2
    //   403: invokevirtual 237	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   406: iconst_0
    //   407: ireturn
    //   408: aload_1
    //   409: invokeinterface 346 1 0
    //   414: invokeinterface 586 1 0
    //   419: astore_1
    //   420: new 588	java/io/FileOutputStream
    //   423: dup
    //   424: aload 24
    //   426: iload 20
    //   428: invokespecial 591	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   431: astore 22
    //   433: lload 10
    //   435: lstore 6
    //   437: lload 12
    //   439: lstore 8
    //   441: aload 24
    //   443: invokevirtual 593	java/io/File:length	()J
    //   446: lstore 18
    //   448: iconst_0
    //   449: istore 4
    //   451: lload 10
    //   453: lstore 6
    //   455: lload 12
    //   457: lstore 8
    //   459: aload_1
    //   460: aload 23
    //   462: getfield 599	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   465: iload 4
    //   467: sipush 8192
    //   470: iload 4
    //   472: isub
    //   473: invokevirtual 605	java/io/InputStream:read	([BII)I
    //   476: istore 5
    //   478: iload 5
    //   480: ifgt +167 -> 647
    //   483: iload 5
    //   485: ifgt +29 -> 514
    //   488: iload 4
    //   490: ifle +24 -> 514
    //   493: lload 10
    //   495: lstore 6
    //   497: lload 12
    //   499: lstore 8
    //   501: aload 22
    //   503: aload 23
    //   505: getfield 599	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   508: iconst_0
    //   509: iload 4
    //   511: invokevirtual 611	java/io/OutputStream:write	([BII)V
    //   514: lload 10
    //   516: lstore 6
    //   518: lload 12
    //   520: lstore 8
    //   522: aload_0
    //   523: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   526: lload 14
    //   528: lsub
    //   529: putfield 126	com/tencent/component/network/downloader/impl/a:o	J
    //   532: lload 16
    //   534: lconst_0
    //   535: lcmp
    //   536: ifgt +25 -> 561
    //   539: lload 10
    //   541: lstore 6
    //   543: lload 12
    //   545: lstore 8
    //   547: aload_0
    //   548: aload_0
    //   549: getfield 149	com/tencent/component/network/downloader/impl/a:r	Ljava/lang/String;
    //   552: lload 16
    //   554: lload 18
    //   556: ladd
    //   557: fconst_1
    //   558: invokespecial 612	com/tencent/component/network/downloader/impl/a:a	(Ljava/lang/String;JF)V
    //   561: lload 10
    //   563: lstore 6
    //   565: lload 12
    //   567: lstore 8
    //   569: aload_2
    //   570: invokevirtual 264	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   573: lload 10
    //   575: putfield 269	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   578: aload_1
    //   579: ifnull +7 -> 586
    //   582: aload_1
    //   583: invokevirtual 615	java/io/InputStream:close	()V
    //   586: aload 22
    //   588: invokevirtual 616	java/io/OutputStream:close	()V
    //   591: getstatic 80	com/tencent/component/network/downloader/impl/a:p	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   594: aload 23
    //   596: invokevirtual 541	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   599: aload_0
    //   600: getfield 487	com/tencent/component/network/downloader/impl/a:D	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   603: ifnull +23 -> 626
    //   606: aload_0
    //   607: getfield 487	com/tencent/component/network/downloader/impl/a:D	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   610: invokestatic 544	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   613: lload 10
    //   615: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   618: lload 12
    //   620: lsub
    //   621: invokeinterface 550 6 0
    //   626: aload_0
    //   627: getfield 109	com/tencent/component/network/downloader/impl/a:u	J
    //   630: lconst_0
    //   631: lcmp
    //   632: iflt +212 -> 844
    //   635: aload_0
    //   636: getfield 109	com/tencent/component/network/downloader/impl/a:u	J
    //   639: lload 10
    //   641: lcmp
    //   642: ifeq +202 -> 844
    //   645: iconst_0
    //   646: ireturn
    //   647: iload 5
    //   649: iload 4
    //   651: iadd
    //   652: sipush 8192
    //   655: if_icmpne +112 -> 767
    //   658: lload 10
    //   660: lstore 6
    //   662: lload 12
    //   664: lstore 8
    //   666: aload 22
    //   668: aload 23
    //   670: getfield 599	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   673: iconst_0
    //   674: iload 4
    //   676: iload 5
    //   678: iadd
    //   679: invokevirtual 611	java/io/OutputStream:write	([BII)V
    //   682: iconst_0
    //   683: istore 4
    //   685: lload 10
    //   687: iload 5
    //   689: i2l
    //   690: ladd
    //   691: lstore 10
    //   693: lload 10
    //   695: lstore 6
    //   697: lload 12
    //   699: lstore 8
    //   701: aload_2
    //   702: invokevirtual 264	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   705: lload 10
    //   707: putfield 269	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   710: lload 16
    //   712: lconst_0
    //   713: lcmp
    //   714: ifle +37 -> 751
    //   717: lload 10
    //   719: lstore 6
    //   721: lload 12
    //   723: lstore 8
    //   725: aload_0
    //   726: aload_0
    //   727: getfield 149	com/tencent/component/network/downloader/impl/a:r	Ljava/lang/String;
    //   730: lload 16
    //   732: lload 18
    //   734: ladd
    //   735: lload 10
    //   737: lload 18
    //   739: ladd
    //   740: l2f
    //   741: lload 16
    //   743: lload 18
    //   745: ladd
    //   746: l2f
    //   747: fdiv
    //   748: invokespecial 612	com/tencent/component/network/downloader/impl/a:a	(Ljava/lang/String;JF)V
    //   751: lload 10
    //   753: lstore 6
    //   755: lload 12
    //   757: lstore 8
    //   759: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   762: lstore 12
    //   764: goto -313 -> 451
    //   767: iload 4
    //   769: iload 5
    //   771: iadd
    //   772: istore 4
    //   774: goto -89 -> 685
    //   777: astore_3
    //   778: aconst_null
    //   779: astore_1
    //   780: lload 12
    //   782: lstore 8
    //   784: lload 10
    //   786: lstore 6
    //   788: aload 22
    //   790: astore_2
    //   791: aload_2
    //   792: ifnull +7 -> 799
    //   795: aload_2
    //   796: invokevirtual 615	java/io/InputStream:close	()V
    //   799: aload_1
    //   800: ifnull +7 -> 807
    //   803: aload_1
    //   804: invokevirtual 616	java/io/OutputStream:close	()V
    //   807: getstatic 80	com/tencent/component/network/downloader/impl/a:p	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   810: aload 23
    //   812: invokevirtual 541	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   815: aload_0
    //   816: getfield 487	com/tencent/component/network/downloader/impl/a:D	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   819: ifnull +23 -> 842
    //   822: aload_0
    //   823: getfield 487	com/tencent/component/network/downloader/impl/a:D	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   826: invokestatic 544	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   829: lload 6
    //   831: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   834: lload 8
    //   836: lsub
    //   837: invokeinterface 550 6 0
    //   842: aload_3
    //   843: athrow
    //   844: iconst_1
    //   845: ireturn
    //   846: astore_3
    //   847: aload_1
    //   848: astore_2
    //   849: aconst_null
    //   850: astore_1
    //   851: lload 10
    //   853: lstore 6
    //   855: lload 12
    //   857: lstore 8
    //   859: goto -68 -> 791
    //   862: astore_3
    //   863: aload 22
    //   865: astore_2
    //   866: aload_1
    //   867: astore 22
    //   869: aload_2
    //   870: astore_1
    //   871: aload 22
    //   873: astore_2
    //   874: goto -83 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	877	0	this	a
    //   0	877	1	paramHttpResponse	HttpResponse
    //   0	877	2	paramDownloadResult	DownloadResult
    //   0	877	3	paramJobContext	ThreadPool.JobContext
    //   0	877	4	paramInt	int
    //   476	296	5	i1	int
    //   435	419	6	l1	long
    //   439	419	8	l2	long
    //   83	769	10	l3	long
    //   94	762	12	l4	long
    //   15	512	14	l5	long
    //   89	653	16	l6	long
    //   446	298	18	l7	long
    //   69	358	20	bool1	boolean
    //   122	3	21	bool2	boolean
    //   72	800	22	localObject1	Object
    //   80	731	23	localObject2	Object
    //   107	335	24	localFile	File
    // Exception table:
    //   from	to	target	type
    //   96	124	777	finally
    //   408	420	777	finally
    //   420	433	846	finally
    //   441	448	862	finally
    //   459	478	862	finally
    //   501	514	862	finally
    //   522	532	862	finally
    //   547	561	862	finally
    //   569	578	862	finally
    //   666	682	862	finally
    //   701	710	862	finally
    //   725	751	862	finally
    //   759	764	862	finally
  }
  
  protected final void b(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if (this.z == null) {
      return;
    }
    this.z.b(paramString1, paramString2, paramHttpRequest);
  }
  
  protected final boolean d()
  {
    int i1 = this.c + 1;
    this.c = i1;
    return i1 < this.b;
  }
  
  protected final int e()
  {
    return this.c;
  }
  
  protected final int f()
  {
    return this.b;
  }
  
  protected final long g()
  {
    return this.d;
  }
  
  public final void h()
  {
    Const.c("downloader", "downloader abort:" + this.q);
    this.v = false;
    if (this.h != null) {}
    try
    {
      this.h.abort();
      return;
    }
    catch (Exception localException)
    {
      Const.c("downloader", "", localException);
    }
  }
  
  public final PriorityThreadPool.Priority i()
  {
    return this.s;
  }
  
  public final String j()
  {
    return this.q;
  }
  
  public final String k()
  {
    if (this.t == null) {
      this.t = Const.b(this.q);
    }
    return this.t;
  }
  
  public final String l()
  {
    return this.r;
  }
  
  /* Error */
  protected final void m()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 151	com/tencent/component/network/downloader/impl/a:j	Lorg/apache/http/client/HttpClient;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   11: getstatic 97	com/tencent/component/network/downloader/impl/a:y	J
    //   14: lsub
    //   15: lstore_1
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: iflt +11 -> 30
    //   22: lload_1
    //   23: ldc2_w 632
    //   26: lcmp
    //   27: iflt -20 -> 7
    //   30: getstatic 89	com/tencent/component/network/downloader/impl/a:x	Ljava/lang/Object;
    //   33: astore_3
    //   34: aload_3
    //   35: monitorenter
    //   36: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   39: getstatic 97	com/tencent/component/network/downloader/impl/a:y	J
    //   42: lsub
    //   43: lstore_1
    //   44: lload_1
    //   45: lconst_0
    //   46: lcmp
    //   47: iflt +21 -> 68
    //   50: lload_1
    //   51: ldc2_w 632
    //   54: lcmp
    //   55: ifge +13 -> 68
    //   58: aload_3
    //   59: monitorexit
    //   60: return
    //   61: astore 4
    //   63: aload_3
    //   64: monitorexit
    //   65: aload 4
    //   67: athrow
    //   68: aload_0
    //   69: getfield 151	com/tencent/component/network/downloader/impl/a:j	Lorg/apache/http/client/HttpClient;
    //   72: invokeinterface 639 1 0
    //   77: astore 4
    //   79: aload 4
    //   81: ifnull +42 -> 123
    //   84: aload 4
    //   86: instanceof 641
    //   89: ifeq +34 -> 123
    //   92: aload 4
    //   94: checkcast 641	com/tencent/component/network/utils/a/g
    //   97: astore 4
    //   99: aload 4
    //   101: ifnull +8 -> 109
    //   104: aload 4
    //   106: invokevirtual 644	com/tencent/component/network/utils/a/g:closeExpiredConnections	()V
    //   109: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   112: putstatic 97	com/tencent/component/network/downloader/impl/a:y	J
    //   115: ldc 182
    //   117: ldc_w 646
    //   120: invokestatic 648	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_3
    //   124: monitorexit
    //   125: return
    //   126: astore 4
    //   128: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   131: putstatic 97	com/tencent/component/network/downloader/impl/a:y	J
    //   134: ldc 182
    //   136: ldc_w 646
    //   139: invokestatic 648	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: goto -19 -> 123
    //   145: astore 4
    //   147: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   150: putstatic 97	com/tencent/component/network/downloader/impl/a:y	J
    //   153: ldc 182
    //   155: ldc_w 646
    //   158: invokestatic 648	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 4
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	a
    //   15	36	1	l1	long
    //   33	91	3	localObject1	Object
    //   61	5	4	localObject2	Object
    //   77	28	4	localObject3	Object
    //   126	1	4	localException	Exception
    //   145	17	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	61	finally
    //   58	60	61	finally
    //   68	79	61	finally
    //   84	99	61	finally
    //   109	123	61	finally
    //   123	125	61	finally
    //   128	142	61	finally
    //   147	164	61	finally
    //   104	109	126	java/lang/Exception
    //   104	109	145	finally
  }
  
  protected final int n()
  {
    if (this.z != null) {
      return this.z.a();
    }
    return 1;
  }
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    this.v = false;
  }
  
  public static abstract interface a
  {
    public abstract int a();
    
    public abstract String a(String paramString);
    
    public abstract void a(String paramString, long paramLong, float paramFloat);
    
    public abstract void a(String paramString1, String paramString2, HttpRequest paramHttpRequest);
    
    public abstract boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse);
    
    public abstract String b(String paramString);
    
    public abstract void b(String paramString1, String paramString2, HttpRequest paramHttpRequest);
  }
  
  static final class b
  {
    private static final Random a = new Random();
    
    public static int a(Object... paramVarArgs)
    {
      int j = 17;
      int i = 0;
      for (;;)
      {
        if (i >= 2) {
          return j * 31 + a.nextInt();
        }
        Object localObject = paramVarArgs[i];
        int k = j;
        if (localObject != null) {
          k = j * 31 + localObject.hashCode();
        }
        i += 1;
        j = k;
      }
    }
    
    public static String a()
    {
      return null;
    }
    
    /* Error */
    public static boolean a(File paramFile, boolean paramBoolean)
      throws IOException
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: ldc 2
      //   4: monitorenter
      //   5: aload_0
      //   6: invokevirtual 37	java/io/File:getParentFile	()Ljava/io/File;
      //   9: astore 4
      //   11: aload 4
      //   13: invokevirtual 41	java/io/File:exists	()Z
      //   16: ifeq +16 -> 32
      //   19: aload 4
      //   21: invokevirtual 44	java/io/File:isFile	()Z
      //   24: ifeq +8 -> 32
      //   27: aload 4
      //   29: invokestatic 50	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
      //   32: aload 4
      //   34: invokevirtual 41	java/io/File:exists	()Z
      //   37: ifne +20 -> 57
      //   40: aload 4
      //   42: invokevirtual 53	java/io/File:mkdirs	()Z
      //   45: istore_3
      //   46: iload_3
      //   47: ifne +10 -> 57
      //   50: iload_2
      //   51: istore_1
      //   52: ldc 2
      //   54: monitorexit
      //   55: iload_1
      //   56: ireturn
      //   57: iload_1
      //   58: ifeq +14 -> 72
      //   61: aload_0
      //   62: invokevirtual 41	java/io/File:exists	()Z
      //   65: ifeq +7 -> 72
      //   68: aload_0
      //   69: invokestatic 50	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
      //   72: aload_0
      //   73: invokevirtual 41	java/io/File:exists	()Z
      //   76: ifne +14 -> 90
      //   79: aload_0
      //   80: invokevirtual 56	java/io/File:createNewFile	()Z
      //   83: istore_3
      //   84: iload_2
      //   85: istore_1
      //   86: iload_3
      //   87: ifeq -35 -> 52
      //   90: iconst_1
      //   91: istore_1
      //   92: goto -40 -> 52
      //   95: astore_0
      //   96: ldc 2
      //   98: monitorexit
      //   99: aload_0
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	paramFile	File
      //   0	101	1	paramBoolean	boolean
      //   1	84	2	bool1	boolean
      //   45	42	3	bool2	boolean
      //   9	32	4	localFile	File
      // Exception table:
      //   from	to	target	type
      //   5	32	95	finally
      //   32	46	95	finally
      //   61	72	95	finally
      //   72	84	95	finally
    }
    
    public static String b()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.a
 * JD-Core Version:    0.7.0.1
 */