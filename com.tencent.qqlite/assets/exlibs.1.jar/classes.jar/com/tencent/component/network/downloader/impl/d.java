package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.FutureListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class d
  implements FutureListener<DownloadResult>
{
  d(c paramc, a parama) {}
  
  public final void onFutureBegin(Future<DownloadResult> arg1)
  {
    c.a(c.b() + 1);
    for (;;)
    {
      Iterator localIterator;
      int i;
      synchronized (c.a(this.a).a(this.b.j()))
      {
        synchronized (c.b(this.a))
        {
          WeakReference localWeakReference = new WeakReference(this.b);
          Object localObject4 = (List)c.c(this.a).get(this.b.j());
          if (localObject4 == null)
          {
            localObject4 = new ArrayList();
            ((List)localObject4).add(localWeakReference);
            c.c(this.a).put(this.b.j(), localObject4);
            return;
          }
          localIterator = ((List)localObject4).iterator();
          if (!localIterator.hasNext())
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            ((List)localObject4).add(localWeakReference);
          }
        }
      }
      Object localObject5 = (WeakReference)localIterator.next();
      if (localObject5 != null)
      {
        localObject5 = (a)((WeakReference)localObject5).get();
        a locala = this.b;
        if (localObject5 == locala) {
          i = 0;
        }
      }
    }
  }
  
  /* Error */
  public final void onFutureDone(Future<DownloadResult> paramFuture)
  {
    // Byte code:
    //   0: ldc 99
    //   2: new 101	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 103
    //   8: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   15: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   18: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 118	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: invokestatic 28	com/tencent/component/network/downloader/impl/c:b	()I
    //   30: iconst_1
    //   31: isub
    //   32: invokestatic 31	com/tencent/component/network/downloader/impl/c:a	(I)V
    //   35: aload_0
    //   36: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   39: invokevirtual 121	com/tencent/component/network/downloader/impl/a:l	()Ljava/lang/String;
    //   42: astore 14
    //   44: aload_0
    //   45: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   48: invokestatic 125	com/tencent/component/network/downloader/impl/c:d	(Lcom/tencent/component/network/downloader/impl/c;)Ljava/util/HashMap;
    //   51: astore 11
    //   53: aload 11
    //   55: monitorenter
    //   56: aload_0
    //   57: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   60: invokestatic 125	com/tencent/component/network/downloader/impl/c:d	(Lcom/tencent/component/network/downloader/impl/c;)Ljava/util/HashMap;
    //   63: aload 14
    //   65: invokevirtual 130	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: pop
    //   69: aload 11
    //   71: monitorexit
    //   72: aload_1
    //   73: invokeinterface 133 1 0
    //   78: checkcast 135	com/tencent/component/network/downloader/DownloadResult
    //   81: astore 13
    //   83: aload_0
    //   84: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   87: invokestatic 34	com/tencent/component/network/downloader/impl/c:a	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/impl/c$a;
    //   90: aload_0
    //   91: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   94: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   97: invokevirtual 45	com/tencent/component/network/downloader/impl/c$a:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   100: astore 12
    //   102: aload 12
    //   104: monitorenter
    //   105: aload_0
    //   106: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   109: invokestatic 48	com/tencent/component/network/downloader/impl/c:b	(Lcom/tencent/component/network/downloader/impl/c;)Ljava/lang/Object;
    //   112: astore 15
    //   114: aload 15
    //   116: monitorenter
    //   117: aload_0
    //   118: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   121: invokestatic 57	com/tencent/component/network/downloader/impl/c:c	(Lcom/tencent/component/network/downloader/impl/c;)Ljava/util/Map;
    //   124: aload_0
    //   125: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   128: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   131: invokeinterface 138 2 0
    //   136: ifeq +99 -> 235
    //   139: aload_0
    //   140: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   143: invokestatic 57	com/tencent/component/network/downloader/impl/c:c	(Lcom/tencent/component/network/downloader/impl/c;)Ljava/util/Map;
    //   146: aload_0
    //   147: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   150: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   153: invokeinterface 63 2 0
    //   158: checkcast 65	java/util/List
    //   161: astore 16
    //   163: aload 16
    //   165: ifnull +70 -> 235
    //   168: aload 16
    //   170: invokeinterface 80 1 0
    //   175: astore 17
    //   177: aload 17
    //   179: invokeinterface 86 1 0
    //   184: ifne +216 -> 400
    //   187: aconst_null
    //   188: astore 11
    //   190: aload 11
    //   192: ifnull +43 -> 235
    //   195: aload 16
    //   197: aload 11
    //   199: invokeinterface 140 2 0
    //   204: pop
    //   205: aload 16
    //   207: invokeinterface 143 1 0
    //   212: ifgt +23 -> 235
    //   215: aload_0
    //   216: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   219: invokestatic 57	com/tencent/component/network/downloader/impl/c:c	(Lcom/tencent/component/network/downloader/impl/c;)Ljava/util/Map;
    //   222: aload_0
    //   223: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   226: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   229: invokeinterface 144 2 0
    //   234: pop
    //   235: aload 15
    //   237: monitorexit
    //   238: aload 13
    //   240: ifnull +342 -> 582
    //   243: aload 13
    //   245: invokevirtual 148	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   248: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult$Status:isRetrying	()Z
    //   251: ifeq +331 -> 582
    //   254: ldc 99
    //   256: new 101	java/lang/StringBuilder
    //   259: dup
    //   260: ldc 155
    //   262: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   265: aload_0
    //   266: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   269: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   272: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 157
    //   277: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 118	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload 13
    //   288: ifnull +85 -> 373
    //   291: aload_0
    //   292: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   295: invokestatic 161	com/tencent/component/network/downloader/impl/c:e	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   298: ifnull +28 -> 326
    //   301: aload_0
    //   302: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   305: invokestatic 161	com/tencent/component/network/downloader/impl/c:e	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   308: aload 13
    //   310: invokevirtual 164	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   313: aload 13
    //   315: invokevirtual 148	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   318: invokevirtual 167	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   321: invokeinterface 173 3 0
    //   326: aload 13
    //   328: invokevirtual 148	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   331: invokevirtual 167	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   334: ifne +13 -> 347
    //   337: aload_0
    //   338: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   341: invokestatic 161	com/tencent/component/network/downloader/impl/c:e	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   344: ifnonnull +29 -> 373
    //   347: aload 13
    //   349: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   352: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   355: ifne +18 -> 373
    //   358: new 184	java/io/File
    //   361: dup
    //   362: aload 13
    //   364: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   367: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   370: invokestatic 191	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   373: aload_0
    //   374: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   377: invokestatic 34	com/tencent/component/network/downloader/impl/c:a	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/impl/c$a;
    //   380: aload_0
    //   381: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   384: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   387: invokevirtual 193	com/tencent/component/network/downloader/impl/c$a:b	(Ljava/lang/String;)V
    //   390: aload 12
    //   392: monitorexit
    //   393: return
    //   394: astore_1
    //   395: aload 11
    //   397: monitorexit
    //   398: aload_1
    //   399: athrow
    //   400: aload 17
    //   402: invokeinterface 90 1 0
    //   407: checkcast 50	java/lang/ref/WeakReference
    //   410: astore 11
    //   412: aload 11
    //   414: ifnull -237 -> 177
    //   417: aload 11
    //   419: invokevirtual 92	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   422: checkcast 36	com/tencent/component/network/downloader/impl/a
    //   425: astore 18
    //   427: aload_0
    //   428: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   431: astore 19
    //   433: aload 18
    //   435: aload 19
    //   437: if_acmpne -260 -> 177
    //   440: goto -250 -> 190
    //   443: astore_1
    //   444: aload 15
    //   446: monitorexit
    //   447: aload_1
    //   448: athrow
    //   449: astore_1
    //   450: aload 13
    //   452: ifnull +85 -> 537
    //   455: aload_0
    //   456: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   459: invokestatic 161	com/tencent/component/network/downloader/impl/c:e	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   462: ifnull +28 -> 490
    //   465: aload_0
    //   466: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   469: invokestatic 161	com/tencent/component/network/downloader/impl/c:e	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   472: aload 13
    //   474: invokevirtual 164	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   477: aload 13
    //   479: invokevirtual 148	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   482: invokevirtual 167	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   485: invokeinterface 173 3 0
    //   490: aload 13
    //   492: invokevirtual 148	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   495: invokevirtual 167	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   498: ifne +13 -> 511
    //   501: aload_0
    //   502: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   505: invokestatic 161	com/tencent/component/network/downloader/impl/c:e	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   508: ifnonnull +29 -> 537
    //   511: aload 13
    //   513: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   516: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   519: ifne +18 -> 537
    //   522: new 184	java/io/File
    //   525: dup
    //   526: aload 13
    //   528: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   531: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   534: invokestatic 191	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   537: aload_0
    //   538: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   541: invokestatic 34	com/tencent/component/network/downloader/impl/c:a	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/impl/c$a;
    //   544: aload_0
    //   545: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   548: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   551: invokevirtual 193	com/tencent/component/network/downloader/impl/c$a:b	(Ljava/lang/String;)V
    //   554: aload_1
    //   555: athrow
    //   556: astore_1
    //   557: aload 12
    //   559: monitorexit
    //   560: aload_1
    //   561: athrow
    //   562: astore_1
    //   563: aload_0
    //   564: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   567: invokestatic 34	com/tencent/component/network/downloader/impl/c:a	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/impl/c$a;
    //   570: aload_0
    //   571: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   574: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   577: invokevirtual 193	com/tencent/component/network/downloader/impl/c$a:b	(Ljava/lang/String;)V
    //   580: aload_1
    //   581: athrow
    //   582: aload_1
    //   583: invokeinterface 196 1 0
    //   588: ifne -302 -> 286
    //   591: aload_0
    //   592: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   595: aload 14
    //   597: invokestatic 199	com/tencent/component/network/downloader/impl/c:a	(Lcom/tencent/component/network/downloader/impl/c;Ljava/lang/String;)Ljava/util/Collection;
    //   600: astore_1
    //   601: aload 13
    //   603: ifnull +14 -> 617
    //   606: aload 13
    //   608: invokevirtual 148	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   611: invokevirtual 167	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   614: ifne +123 -> 737
    //   617: aload_0
    //   618: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   621: astore 11
    //   623: aload_1
    //   624: aload 13
    //   626: invokestatic 202	com/tencent/component/network/downloader/impl/c:a	(Ljava/util/Collection;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   629: aload 13
    //   631: ifnull +85 -> 716
    //   634: aload_0
    //   635: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   638: invokestatic 161	com/tencent/component/network/downloader/impl/c:e	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   641: ifnull +28 -> 669
    //   644: aload_0
    //   645: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   648: invokestatic 161	com/tencent/component/network/downloader/impl/c:e	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   651: aload 13
    //   653: invokevirtual 164	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   656: aload 13
    //   658: invokevirtual 148	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   661: invokevirtual 167	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   664: invokeinterface 173 3 0
    //   669: aload 13
    //   671: invokevirtual 148	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   674: invokevirtual 167	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   677: ifne +13 -> 690
    //   680: aload_0
    //   681: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   684: invokestatic 161	com/tencent/component/network/downloader/impl/c:e	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   687: ifnonnull +29 -> 716
    //   690: aload 13
    //   692: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   695: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   698: ifne +18 -> 716
    //   701: new 184	java/io/File
    //   704: dup
    //   705: aload 13
    //   707: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   710: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   713: invokestatic 191	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   716: aload_0
    //   717: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   720: invokestatic 34	com/tencent/component/network/downloader/impl/c:a	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/impl/c$a;
    //   723: aload_0
    //   724: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   727: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   730: invokevirtual 193	com/tencent/component/network/downloader/impl/c$a:b	(Ljava/lang/String;)V
    //   733: aload 12
    //   735: monitorexit
    //   736: return
    //   737: iconst_0
    //   738: istore_2
    //   739: aload_1
    //   740: ifnull +32 -> 772
    //   743: new 67	java/util/ArrayList
    //   746: dup
    //   747: invokespecial 68	java/util/ArrayList:<init>	()V
    //   750: astore 11
    //   752: aload_1
    //   753: invokeinterface 205 1 0
    //   758: astore 14
    //   760: iconst_0
    //   761: istore_2
    //   762: aload 14
    //   764: invokeinterface 86 1 0
    //   769: ifne +38 -> 807
    //   772: aload_0
    //   773: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   776: astore 11
    //   778: aload_1
    //   779: aload 13
    //   781: invokestatic 207	com/tencent/component/network/downloader/impl/c:b	(Ljava/util/Collection;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   784: iload_2
    //   785: ifeq -156 -> 629
    //   788: aload_0
    //   789: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   792: aload_0
    //   793: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   796: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   799: aload 13
    //   801: invokevirtual 210	com/tencent/component/network/downloader/impl/c:a	(Ljava/lang/String;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   804: goto -175 -> 629
    //   807: aload 14
    //   809: invokeinterface 90 1 0
    //   814: checkcast 212	com/tencent/component/network/downloader/DownloadRequest
    //   817: astore 15
    //   819: aload 15
    //   821: ifnull -59 -> 762
    //   824: aload 15
    //   826: invokevirtual 215	com/tencent/component/network/downloader/DownloadRequest:shouldCacheEntry	()Z
    //   829: ifeq +360 -> 1189
    //   832: iconst_1
    //   833: istore_2
    //   834: aload 15
    //   836: invokevirtual 219	com/tencent/component/network/downloader/DownloadRequest:getPaths	()[Ljava/lang/String;
    //   839: astore 16
    //   841: aload 16
    //   843: ifnull +281 -> 1124
    //   846: iconst_0
    //   847: istore 4
    //   849: aload 16
    //   851: arraylength
    //   852: istore 5
    //   854: iconst_0
    //   855: istore_3
    //   856: goto +336 -> 1192
    //   859: iload_3
    //   860: ifne +286 -> 1146
    //   863: aload 16
    //   865: arraylength
    //   866: istore 4
    //   868: iconst_0
    //   869: istore_3
    //   870: goto +334 -> 1204
    //   873: aload 11
    //   875: aload 16
    //   877: iload_3
    //   878: aaload
    //   879: invokeinterface 222 2 0
    //   884: ifeq +329 -> 1213
    //   887: iconst_1
    //   888: istore_3
    //   889: goto -30 -> 859
    //   892: aload 16
    //   894: iload_3
    //   895: aaload
    //   896: astore 17
    //   898: aload 17
    //   900: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   903: ifne +317 -> 1220
    //   906: aload_0
    //   907: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   910: aload 13
    //   912: aload 15
    //   914: invokestatic 225	com/tencent/component/network/downloader/impl/c:a	(Lcom/tencent/component/network/downloader/impl/c;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadRequest;)Z
    //   917: ifne +303 -> 1220
    //   920: aload 13
    //   922: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   925: ifnull +295 -> 1220
    //   928: aload 11
    //   930: aload 17
    //   932: invokeinterface 222 2 0
    //   937: istore 6
    //   939: iload 6
    //   941: ifne +279 -> 1220
    //   944: new 184	java/io/File
    //   947: dup
    //   948: aload 13
    //   950: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   953: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   956: astore 18
    //   958: new 184	java/io/File
    //   961: dup
    //   962: aload 17
    //   964: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   967: astore 19
    //   969: aload 18
    //   971: aload 19
    //   973: invokestatic 229	com/tencent/component/network/utils/FileUtils:copyFiles	(Ljava/io/File;Ljava/io/File;)Z
    //   976: istore 6
    //   978: aload 18
    //   980: invokevirtual 233	java/io/File:length	()J
    //   983: lstore 7
    //   985: aload 19
    //   987: invokevirtual 233	java/io/File:length	()J
    //   990: lstore 9
    //   992: ldc 99
    //   994: new 101	java/lang/StringBuilder
    //   997: dup
    //   998: ldc 235
    //   1000: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1003: aload 13
    //   1005: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1008: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: ldc 237
    //   1013: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: aload 17
    //   1018: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: ldc 239
    //   1023: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: aload_0
    //   1027: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   1030: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   1033: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: ldc 241
    //   1038: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: iload 6
    //   1043: invokevirtual 244	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1046: ldc 246
    //   1048: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: lload 7
    //   1053: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1056: ldc 251
    //   1058: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: lload 9
    //   1063: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1066: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: invokestatic 253	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1072: iload 6
    //   1074: ifeq +146 -> 1220
    //   1077: aload 11
    //   1079: aload 17
    //   1081: invokeinterface 72 2 0
    //   1086: pop
    //   1087: goto -325 -> 762
    //   1090: astore 17
    //   1092: ldc 99
    //   1094: new 101	java/lang/StringBuilder
    //   1097: dup
    //   1098: ldc 255
    //   1100: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1103: aload_0
    //   1104: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   1107: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   1110: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1116: aload 17
    //   1118: invokestatic 258	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1121: goto +99 -> 1220
    //   1124: aload 15
    //   1126: getfield 262	com/tencent/component/network/downloader/DownloadRequest:outputStream	Ljava/io/OutputStream;
    //   1129: ifnull +17 -> 1146
    //   1132: aload 13
    //   1134: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1137: aload 15
    //   1139: getfield 262	com/tencent/component/network/downloader/DownloadRequest:outputStream	Ljava/io/OutputStream;
    //   1142: invokestatic 266	com/tencent/component/network/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/io/OutputStream;)Z
    //   1145: pop
    //   1146: goto -384 -> 762
    //   1149: astore_1
    //   1150: aload_0
    //   1151: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   1154: invokestatic 34	com/tencent/component/network/downloader/impl/c:a	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/impl/c$a;
    //   1157: aload_0
    //   1158: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   1161: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   1164: invokevirtual 193	com/tencent/component/network/downloader/impl/c$a:b	(Ljava/lang/String;)V
    //   1167: aload_1
    //   1168: athrow
    //   1169: astore_1
    //   1170: aload_0
    //   1171: getfield 15	com/tencent/component/network/downloader/impl/d:a	Lcom/tencent/component/network/downloader/impl/c;
    //   1174: invokestatic 34	com/tencent/component/network/downloader/impl/c:a	(Lcom/tencent/component/network/downloader/impl/c;)Lcom/tencent/component/network/downloader/impl/c$a;
    //   1177: aload_0
    //   1178: getfield 17	com/tencent/component/network/downloader/impl/d:b	Lcom/tencent/component/network/downloader/impl/a;
    //   1181: invokevirtual 40	com/tencent/component/network/downloader/impl/a:j	()Ljava/lang/String;
    //   1184: invokevirtual 193	com/tencent/component/network/downloader/impl/c$a:b	(Ljava/lang/String;)V
    //   1187: aload_1
    //   1188: athrow
    //   1189: goto -355 -> 834
    //   1192: iload_3
    //   1193: iload 5
    //   1195: if_icmplt -322 -> 873
    //   1198: iload 4
    //   1200: istore_3
    //   1201: goto -342 -> 859
    //   1204: iload_3
    //   1205: iload 4
    //   1207: if_icmplt -315 -> 892
    //   1210: goto -448 -> 762
    //   1213: iload_3
    //   1214: iconst_1
    //   1215: iadd
    //   1216: istore_3
    //   1217: goto -25 -> 1192
    //   1220: iload_3
    //   1221: iconst_1
    //   1222: iadd
    //   1223: istore_3
    //   1224: goto -20 -> 1204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1227	0	this	d
    //   0	1227	1	paramFuture	Future<DownloadResult>
    //   738	96	2	i	int
    //   855	369	3	j	int
    //   847	361	4	k	int
    //   852	344	5	m	int
    //   937	136	6	bool	boolean
    //   983	69	7	l1	long
    //   990	72	9	l2	long
    //   51	1027	11	localObject1	Object
    //   100	634	12	localObject2	Object
    //   81	1052	13	localDownloadResult	DownloadResult
    //   42	766	14	localObject3	Object
    //   161	732	16	localObject5	Object
    //   175	905	17	localIterator	Iterator
    //   1090	27	17	localThrowable	java.lang.Throwable
    //   425	554	18	localObject6	Object
    //   431	555	19	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   56	72	394	finally
    //   117	163	443	finally
    //   168	177	443	finally
    //   177	187	443	finally
    //   195	235	443	finally
    //   235	238	443	finally
    //   400	412	443	finally
    //   417	433	443	finally
    //   105	117	449	finally
    //   243	286	449	finally
    //   444	449	449	finally
    //   582	601	449	finally
    //   606	617	449	finally
    //   617	629	449	finally
    //   743	760	449	finally
    //   762	772	449	finally
    //   772	784	449	finally
    //   788	804	449	finally
    //   807	819	449	finally
    //   824	832	449	finally
    //   834	841	449	finally
    //   849	854	449	finally
    //   863	868	449	finally
    //   873	887	449	finally
    //   898	939	449	finally
    //   944	1072	449	finally
    //   1077	1087	449	finally
    //   1092	1121	449	finally
    //   1124	1146	449	finally
    //   373	393	556	finally
    //   537	556	556	finally
    //   563	582	556	finally
    //   716	736	556	finally
    //   1150	1169	556	finally
    //   1170	1189	556	finally
    //   291	326	562	finally
    //   326	347	562	finally
    //   347	373	562	finally
    //   944	1072	1090	java/lang/Throwable
    //   1077	1087	1090	java/lang/Throwable
    //   455	490	1149	finally
    //   490	511	1149	finally
    //   511	537	1149	finally
    //   634	669	1169	finally
    //   669	690	1169	finally
    //   690	716	1169	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.d
 * JD-Core Version:    0.7.0.1
 */