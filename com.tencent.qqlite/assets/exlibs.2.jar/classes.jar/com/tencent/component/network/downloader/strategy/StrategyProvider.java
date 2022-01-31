package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.module.common.a;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.a.e;
import com.tencent.component.network.utils.a.e.a;
import com.tencent.component.network.utils.a.e.b;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class StrategyProvider
{
  private static e.a a = new e.a((byte)0);
  private static HttpClient b = null;
  public static IPConfigStrategy backupIPConfigStrategy;
  private static final ThreadLocal<e.b> c = new b();
  public static IPConfigStrategy directIPConfigStrategy;
  public static PortConfigStrategy portConfigStrategy;
  
  private static HttpClient a()
  {
    if (b != null) {
      return b;
    }
    try
    {
      HttpClient localHttpClient = e.a(a);
      b = localHttpClient;
      ((AbstractHttpClient)localHttpClient).setReuseStrategy(new DownloadConnectionReuseStrategy());
      return b;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static ExecuteResult exeHttpRequest$59c56e0f(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt, RequestProcessor paramRequestProcessor, HttpRequest paramHttpRequest, com.tencent.component.network.downloader.DownloadResult paramDownloadResult, Const paramConst)
  {
    // Byte code:
    //   0: new 6	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult
    //   3: dup
    //   4: invokespecial 62	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:<init>	()V
    //   7: astore 9
    //   9: aload_0
    //   10: aload_1
    //   11: iload_2
    //   12: invokestatic 66	com/tencent/component/network/downloader/strategy/StrategyProvider:generateStrategyInfo	(Ljava/lang/String;Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyLib;I)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +23 -> 40
    //   20: aload 9
    //   22: aconst_null
    //   23: putfield 70	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:request	Lorg/apache/http/client/methods/HttpGet;
    //   26: aload 9
    //   28: aconst_null
    //   29: putfield 74	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:response	Lorg/apache/http/HttpResponse;
    //   32: aload 9
    //   34: aload_1
    //   35: putfield 78	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:strategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   38: aconst_null
    //   39: areturn
    //   40: getstatic 40	com/tencent/component/network/downloader/strategy/StrategyProvider:c	Ljava/lang/ThreadLocal;
    //   43: invokevirtual 84	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   46: checkcast 86	com/tencent/component/network/utils/a/e$b
    //   49: astore 10
    //   51: aload 10
    //   53: aload_1
    //   54: getfield 92	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:allowProxy	Z
    //   57: putfield 94	com/tencent/component/network/utils/a/e$b:a	Z
    //   60: aload 10
    //   62: aload_1
    //   63: getfield 97	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:useConfigApn	Z
    //   66: putfield 99	com/tencent/component/network/utils/a/e$b:b	Z
    //   69: aload_1
    //   70: ifnull +419 -> 489
    //   73: aload_1
    //   74: invokevirtual 103	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   77: ifnull +412 -> 489
    //   80: aload_1
    //   81: invokevirtual 103	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   84: getfield 108	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   87: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +399 -> 489
    //   93: aload_1
    //   94: invokevirtual 103	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   97: getfield 108	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   100: astore 4
    //   102: aload_0
    //   103: invokestatic 120	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;)I
    //   106: istore_2
    //   107: iload_2
    //   108: ifle +258 -> 366
    //   111: aload_1
    //   112: invokevirtual 103	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   115: iload_2
    //   116: putfield 123	com/tencent/component/network/downloader/common/IPInfo:b	I
    //   119: iload_2
    //   120: istore 7
    //   122: iload_2
    //   123: invokestatic 126	com/tencent/component/network/downloader/impl/ipc/Const:a	(I)Z
    //   126: ifne +7 -> 133
    //   129: bipush 80
    //   131: istore 7
    //   133: new 128	java/lang/StringBuilder
    //   136: dup
    //   137: aload 4
    //   139: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: ldc 139
    //   147: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload 7
    //   152: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore 4
    //   160: aload_0
    //   161: aload_0
    //   162: invokestatic 153	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;)Ljava/lang/String;
    //   165: aload 4
    //   167: invokevirtual 157	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: astore 8
    //   172: ldc 159
    //   174: new 128	java/lang/StringBuilder
    //   177: dup
    //   178: ldc 161
    //   180: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_1
    //   184: invokevirtual 162	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   187: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 164
    //   192: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 4
    //   197: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 166
    //   202: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 168
    //   211: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokestatic 174	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   217: invokevirtual 178	java/lang/Thread:getId	()J
    //   220: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 184	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 8
    //   231: astore 4
    //   233: aload 6
    //   235: ifnull +16 -> 251
    //   238: aload 6
    //   240: aload_1
    //   241: invokevirtual 162	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   244: putfield 187	com/tencent/component/network/downloader/impl/ipc/Const:l	Ljava/lang/String;
    //   247: aload 8
    //   249: astore 4
    //   251: invokestatic 190	com/tencent/component/network/downloader/impl/ipc/Const:a	()Landroid/content/Context;
    //   254: aload_0
    //   255: aload_0
    //   256: invokestatic 192	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   259: aload 4
    //   261: aload 10
    //   263: invokestatic 195	com/tencent/component/network/utils/a/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/a/e$b;)Lorg/apache/http/client/methods/HttpGet;
    //   266: astore 8
    //   268: aload_3
    //   269: ifnull +19 -> 288
    //   272: aload_1
    //   273: astore 6
    //   275: aload 8
    //   277: astore 4
    //   279: aload_3
    //   280: aload_0
    //   281: aload 8
    //   283: invokeinterface 199 3 0
    //   288: aload_1
    //   289: astore 6
    //   291: aload 8
    //   293: astore 4
    //   295: aload 8
    //   297: iconst_0
    //   298: invokestatic 202	com/tencent/component/network/utils/a/e:a	(Lorg/apache/http/HttpRequest;Z)V
    //   301: aload_1
    //   302: astore 6
    //   304: aload 8
    //   306: astore 4
    //   308: invokestatic 205	com/tencent/component/network/utils/a/e:a	()Lorg/apache/http/protocol/HttpContext;
    //   311: astore_0
    //   312: aload_1
    //   313: astore 6
    //   315: aload 8
    //   317: astore 4
    //   319: aload 9
    //   321: aload_0
    //   322: putfield 209	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:context	Lorg/apache/http/protocol/HttpContext;
    //   325: aload_1
    //   326: astore 6
    //   328: aload 8
    //   330: astore 4
    //   332: invokestatic 211	com/tencent/component/network/downloader/strategy/StrategyProvider:a	()Lorg/apache/http/client/HttpClient;
    //   335: aload 8
    //   337: aload_0
    //   338: invokeinterface 217 3 0
    //   343: astore_0
    //   344: aload 9
    //   346: aload 8
    //   348: putfield 70	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:request	Lorg/apache/http/client/methods/HttpGet;
    //   351: aload 9
    //   353: aload_0
    //   354: putfield 74	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:response	Lorg/apache/http/HttpResponse;
    //   357: aload 9
    //   359: aload_1
    //   360: putfield 78	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:strategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   363: aload 9
    //   365: areturn
    //   366: aload_1
    //   367: invokevirtual 103	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   370: getfield 123	com/tencent/component/network/downloader/common/IPInfo:b	I
    //   373: istore_2
    //   374: goto -255 -> 119
    //   377: astore_3
    //   378: aconst_null
    //   379: astore_1
    //   380: aconst_null
    //   381: astore_0
    //   382: aload 5
    //   384: ifnull +18 -> 402
    //   387: aload_1
    //   388: astore 6
    //   390: aload_0
    //   391: astore 4
    //   393: aload 5
    //   395: invokevirtual 223	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   398: aload_3
    //   399: invokevirtual 229	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   402: aload_1
    //   403: astore 6
    //   405: aload_0
    //   406: astore 4
    //   408: aload 9
    //   410: aload_3
    //   411: putfield 233	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:exception	Ljava/lang/Throwable;
    //   414: aload 9
    //   416: aload_0
    //   417: putfield 70	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:request	Lorg/apache/http/client/methods/HttpGet;
    //   420: aload 9
    //   422: aconst_null
    //   423: putfield 74	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:response	Lorg/apache/http/HttpResponse;
    //   426: aload 9
    //   428: aload_1
    //   429: putfield 78	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:strategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   432: goto -69 -> 363
    //   435: astore_0
    //   436: aconst_null
    //   437: astore_1
    //   438: aconst_null
    //   439: astore 4
    //   441: aload 9
    //   443: aload 4
    //   445: putfield 70	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:request	Lorg/apache/http/client/methods/HttpGet;
    //   448: aload 9
    //   450: aconst_null
    //   451: putfield 74	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:response	Lorg/apache/http/HttpResponse;
    //   454: aload 9
    //   456: aload_1
    //   457: putfield 78	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:strategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   460: aload_0
    //   461: athrow
    //   462: astore_0
    //   463: aconst_null
    //   464: astore 4
    //   466: goto -25 -> 441
    //   469: astore_0
    //   470: aload 6
    //   472: astore_1
    //   473: goto -32 -> 441
    //   476: astore_3
    //   477: aconst_null
    //   478: astore_0
    //   479: goto -97 -> 382
    //   482: astore_3
    //   483: aload 8
    //   485: astore_0
    //   486: goto -104 -> 382
    //   489: aload_0
    //   490: astore 4
    //   492: goto -241 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	paramString	String
    //   0	495	1	paramStrategyLib	DownloadGlobalStrategy.StrategyLib
    //   0	495	2	paramInt	int
    //   0	495	3	paramRequestProcessor	RequestProcessor
    //   0	495	4	paramHttpRequest	HttpRequest
    //   0	495	5	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   0	495	6	paramConst	Const
    //   120	31	7	i	int
    //   170	314	8	localObject	Object
    //   7	448	9	localExecuteResult	ExecuteResult
    //   49	213	10	localb	e.b
    // Exception table:
    //   from	to	target	type
    //   9	16	377	java/lang/Throwable
    //   9	16	435	finally
    //   40	69	462	finally
    //   73	107	462	finally
    //   111	119	462	finally
    //   122	129	462	finally
    //   133	229	462	finally
    //   238	247	462	finally
    //   251	268	462	finally
    //   366	374	462	finally
    //   279	288	469	finally
    //   295	301	469	finally
    //   308	312	469	finally
    //   319	325	469	finally
    //   332	344	469	finally
    //   393	402	469	finally
    //   408	414	469	finally
    //   40	69	476	java/lang/Throwable
    //   73	107	476	java/lang/Throwable
    //   111	119	476	java/lang/Throwable
    //   122	129	476	java/lang/Throwable
    //   133	229	476	java/lang/Throwable
    //   238	247	476	java/lang/Throwable
    //   251	268	476	java/lang/Throwable
    //   366	374	476	java/lang/Throwable
    //   279	288	482	java/lang/Throwable
    //   295	301	482	java/lang/Throwable
    //   308	312	482	java/lang/Throwable
    //   319	325	482	java/lang/Throwable
    //   332	344	482	java/lang/Throwable
  }
  
  public static DownloadGlobalStrategy.StrategyInfo generateStrategyInfo(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt)
  {
    int i = 80;
    if ((TextUtils.isEmpty(paramString)) || (paramStrategyLib == null) || (paramInt < 0)) {
      return null;
    }
    Object localObject = paramStrategyLib.getOldStrategyInfo();
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo = paramStrategyLib.getStrategyInfo(paramInt);
    paramStrategyLib.setOldStrategyInfo(localStrategyInfo);
    Const.c("StrategyProvider", "downloader strategy: " + localStrategyInfo.toString() + " currAttempCount:" + paramInt + " best:" + paramStrategyLib.getBestId() + " url:" + paramString + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
    String str = Const.b(paramString);
    paramInt = paramStrategyLib.getPort();
    if (!Const.a(paramInt))
    {
      paramStrategyLib.setPort(80);
      paramInt = i;
    }
    for (;;)
    {
      if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == localStrategyInfo.id)
      {
        i = paramInt;
        if (localObject != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == ((DownloadGlobalStrategy.StrategyInfo)localObject).id)
          {
            if ((portConfigStrategy == null) || (!portConfigStrategy.supportExtraPort(str))) {
              break label387;
            }
            i = portConfigStrategy.changePort(str, paramInt);
            if ((i == paramInt) || (!Const.a(i)))
            {
              Const.c("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              return null;
            }
          }
        }
        paramString = paramStrategyLib.getBackupIP();
        if ((backupIPConfigStrategy == null) || (backupIPConfigStrategy.isIPValid(paramString, str))) {
          break label1160;
        }
        paramStrategyLib.setBackupIP(null);
        paramString = backupIPConfigStrategy.resolveIP(str);
        if (!TextUtils.isEmpty(paramString)) {
          paramStrategyLib.setBackupIP(paramString);
        }
      }
      label387:
      label1157:
      label1160:
      for (;;)
      {
        if ((paramString == null) || (paramString.equals(paramStrategyLib.getDirectIP())) || (paramString.equals(paramStrategyLib.getDnsIP())))
        {
          Const.c("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return null;
          Const.c("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return null;
          Const.c("StrategyProvider", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
          return null;
        }
        paramStrategyLib = localStrategyInfo.clone();
        paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
        return paramStrategyLib;
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == localStrategyInfo.id)
        {
          i = paramInt;
          if (localObject != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == ((DownloadGlobalStrategy.StrategyInfo)localObject).id)
            {
              if ((portConfigStrategy == null) || (!portConfigStrategy.supportExtraPort(str))) {
                break label654;
              }
              i = portConfigStrategy.changePort(str, paramInt);
              if ((i == paramInt) || (!Const.a(i)))
              {
                Const.c("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return null;
              }
            }
          }
          paramString = a.a().a(str);
          if ((paramString == null) || (paramString.equals(paramStrategyLib.getBackupIP())) || (paramString.equals(paramStrategyLib.getDirectIP())))
          {
            Const.c("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return null;
            label654:
            Const.c("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            return null;
          }
          paramStrategyLib.setDnsIP(paramString);
          paramStrategyLib = localStrategyInfo.clone();
          paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
        if (DownloadGlobalStrategy.Strategy_DomainDirect.id == localStrategyInfo.id)
        {
          i = paramInt;
          if (localObject != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DomainDirect.id == ((DownloadGlobalStrategy.StrategyInfo)localObject).id)
            {
              if ((portConfigStrategy == null) || (!portConfigStrategy.supportExtraPort(str))) {
                break label946;
              }
              i = portConfigStrategy.changePort(str, paramInt);
              if ((i == paramInt) || (!Const.a(i)))
              {
                Const.c("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return null;
              }
            }
          }
          localObject = paramStrategyLib.getDirectIP();
          paramString = (String)localObject;
          if (directIPConfigStrategy == null) {
            break label1157;
          }
          paramString = (String)localObject;
          if (directIPConfigStrategy.isIPValid((String)localObject, str)) {
            break label1157;
          }
          localObject = directIPConfigStrategy.resolveIP(str);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label1073;
          }
          paramStrategyLib.setDirectIP((String)localObject);
          paramString = (String)localObject;
        }
        for (;;)
        {
          if ((paramString == null) || (paramString.equals(paramStrategyLib.getBackupIP())) || (paramString.equals(paramStrategyLib.getDnsIP())))
          {
            Const.c("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return null;
            label946:
            Const.c("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            return null;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id != localStrategyInfo.id)
            {
              i = paramInt;
              if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != localStrategyInfo.id) {
                break;
              }
            }
            paramString = Const.a();
            if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo.id) {}
            for (boolean bool = true; NetworkUtils.getProxy(paramString, bool) == null; bool = false)
            {
              Const.c("StrategyProvider", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
              return null;
            }
            return localStrategyInfo;
            label1073:
            Const.c("StrategyProvider", "downloader strategy: resolve ip failed! threadId:" + Thread.currentThread().getId());
            paramString = (String)localObject;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == localStrategyInfo.id) {
              break label1157;
            }
            paramString = (String)localObject;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo.id) {
              break label1157;
            }
            return null;
          }
          paramStrategyLib = localStrategyInfo.clone();
          paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
      }
    }
  }
  
  public static DownloadGlobalStrategy.StrategyLib provideStrategyLib(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = Const.b(paramString);
    return DownloadGlobalStrategy.getInstance(Const.a()).getStrategyLib(paramString, str);
  }
  
  public static class ExecuteResult
  {
    public HttpContext context;
    public Throwable exception;
    public HttpGet request;
    public HttpResponse response;
    public DownloadGlobalStrategy.StrategyInfo strategyInfo;
  }
  
  public static abstract interface RequestProcessor
  {
    public abstract void prepareRequest(String paramString, HttpRequest paramHttpRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.StrategyProvider
 * JD-Core Version:    0.7.0.1
 */