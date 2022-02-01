package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import android.net.Network;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class TPListenerManager
{
  private static final int DEFAULT_UPDATE_PLAYER_INFO_INTERVAL = 1000;
  private static final String FILE_NAME = "TPListenerManager";
  private static final int MSG_CALLBACK_MSG_REPORT = 3000;
  private static final int MSG_CONFIG_URL = 2011;
  private static final int MSG_CURRENT_CDN_URL = 5;
  private static final int MSG_CURRENT_CDN_URL_INFO = 6;
  private static final int MSG_DOWNLOAD_PROTOCOL = 9;
  private static final int MSG_DOWNLOAD_STATUS = 8;
  private static final int MSG_ERROR = 4;
  private static final int MSG_FINISH = 3;
  private static final int MSG_MULTI_NETWORK = 2012;
  private static final int MSG_NOTIFY_FLV_PRELOAD_STATUS = 2009;
  private static final int MSG_NOTIFY_HTTP_HEADER = 2006;
  private static final int MSG_NOTIFY_LOSE_PACKAGE_CEHCK = 2004;
  private static final int MSG_NOTIFY_M3U8_CONTENT = 2007;
  private static final int MSG_NOTIFY_PLAYER_SWITCH_DEFINITION = 2003;
  private static final int MSG_NOTIFY_SOCKET_FD = 2008;
  private static final int MSG_PCDN_TS_FAILED = 3003;
  private static final int MSG_PLAY_VIDEO_NOT_FOUND = 101;
  private static final int MSG_PREPARE_FINISH = 50;
  private static final int MSG_PROGRESS = 2;
  private static final int MSG_PROXY_CANCEL_READ_DATA = 202;
  private static final int MSG_PROXY_GET_CONTENT_TYPE = 205;
  private static final int MSG_PROXY_GET_DATA_FILE_PATH = 204;
  private static final int MSG_PROXY_GET_DATA_TOTAL_SIZE = 203;
  private static final int MSG_PROXY_READ_DATA = 201;
  private static final int MSG_PROXY_START_READ_DATA = 200;
  private static final int MSG_QUIC_DOWNLOAD_STATUS = 3001;
  private static final int MSG_REPORT_QUIC_QUALITY = 3002;
  private static final int MSG_REPORT_URL = 2010;
  private static final int MSG_URL_EXPIRED = 7;
  private static final Object OFFLINE_LISTENER_MAP_MUTEX = new Object();
  private static final Object PLAY_LISTENER_MAP_MUTEX = new Object();
  private static final Object PRELOAD_LISTENER_MAP_MUTEX = new Object();
  private static final String THREAD_NAME = "TVKDL-Listener";
  private ITPDownloadListener mITPDownloadListener = null;
  private Handler mMsgHandler;
  private HandlerThread mMsgHandlerThread;
  private Network mNetwork = null;
  private Map<Integer, ITPOfflineDownloadListener> mOfflineDownloadListenerMap = new HashMap();
  private Map<Integer, ITPPlayListener> mPlayListenerMap = new HashMap();
  private Map<Integer, ITPPreLoadListener> mPreLoadListenerMap = new HashMap();
  private Runnable updatePlayerInfo = new TPListenerManager.1(this);
  private int updatePlayerInfoINterval = 1000;
  
  private void dispatchCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    Object localObject = getPlaylistener(paramInt2);
    if (localObject != null) {
      dispatchPlayMessage((ITPPlayListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    }
    do
    {
      return;
      localObject = getPreLoadListener(paramInt2);
      if (localObject != null)
      {
        dispatchPreLoadMessage((ITPPreLoadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
        return;
      }
      localObject = getOfflineDownloadListener(paramInt2);
      if (localObject != null)
      {
        dispatchOfflineDownloadMessage((ITPOfflineDownloadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
        return;
      }
    } while (this.mITPDownloadListener == null);
    switch (paramInt1)
    {
    case 3001: 
    default: 
      return;
    case 3000: 
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      this.mITPDownloadListener.onDownloadInfoReportUpdate(paramObject1);
      return;
    }
    paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
    this.mITPDownloadListener.onQuicQualityReportUpdate(paramObject1);
  }
  
  private void dispatchOfflineDownloadMessage(ITPOfflineDownloadListener paramITPOfflineDownloadListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (paramITPOfflineDownloadListener == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      paramITPOfflineDownloadListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
      return;
    case 3: 
      paramITPOfflineDownloadListener.onDownloadFinish();
      return;
    case 4: 
      paramITPOfflineDownloadListener.onDownloadError(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), TPDLProxyUtils.byteArrayToString((byte[])paramObject3));
      return;
    case 5: 
      paramITPOfflineDownloadListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      return;
    case 6: 
      paramITPOfflineDownloadListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
      return;
    case 7: 
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      long l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
      paramObject2 = new HashMap();
      if (!TextUtils.isEmpty(paramObject1))
      {
        paramObject2.put("exttag", paramObject1);
        paramObject2.put("randnum", String.valueOf(l));
      }
      paramITPOfflineDownloadListener.onDownloadCdnUrlExpired(paramObject2);
      return;
    case 8: 
      paramITPOfflineDownloadListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
      return;
    }
    paramITPOfflineDownloadListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
  }
  
  private void dispatchPlayMessage(ITPPlayListener paramITPPlayListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (paramITPPlayListener == null) {
      return;
    }
    long l;
    switch (paramInt1)
    {
    case 4: 
    default: 
      return;
    case 2: 
      paramITPPlayListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
      return;
    case 3: 
      paramITPPlayListener.onDownloadFinish();
      return;
    case 5: 
      paramITPPlayListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      return;
    case 6: 
      paramITPPlayListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
      return;
    case 7: 
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
      paramObject2 = new HashMap();
      if (!TextUtils.isEmpty(paramObject1))
      {
        paramObject2.put("exttag", paramObject1);
        paramObject2.put("randnum", String.valueOf(l));
      }
      paramITPPlayListener.onDownloadCdnUrlExpired(paramObject2);
      return;
    case 8: 
      paramITPPlayListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
      return;
    case 9: 
      paramITPPlayListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
      return;
    case 101: 
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
      paramObject2 = new HashMap();
      if (!TextUtils.isEmpty(paramObject1))
      {
        paramObject2.put("exttag", paramObject1);
        paramObject2.put("randnum", String.valueOf(l));
      }
      paramITPPlayListener.onPlayCallback(1, paramObject2, null, null, null);
      return;
    case 2003: 
      paramITPPlayListener.onPlayCallback(2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), Integer.valueOf(TPDLProxyUtils.objectToInt(paramObject3, 0)), null);
      return;
    case 2004: 
      paramInt1 = TPDLProxyUtils.objectToInt(paramObject2, 0);
      TVKThreadUtil.getScheduledExecutorServiceInstance().execute(new TPListenerManager.3(this, paramInt1));
      return;
    case 2006: 
      paramITPPlayListener.onPlayCallback(3, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), null, null, null);
      return;
    case 2007: 
      paramITPPlayListener.onPlayCallback(4, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), null, null, null);
      return;
    case 2009: 
      paramInt1 = TPDLProxyUtils.objectToInt(paramObject1, 0);
      if (paramObject2 == null) {}
      for (paramObject1 = null;; paramObject1 = (byte[])paramObject2)
      {
        paramITPPlayListener.onPlayCallback(5, Integer.valueOf(paramInt1), paramObject1, TPDLProxyUtils.byteArrayToString((byte[])paramObject3), Integer.valueOf(TPDLProxyUtils.objectToInt(paramObject4, 0)));
        return;
      }
    case 3001: 
      paramITPPlayListener.onQuicDownloadStatusUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      return;
    case 2012: 
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      paramITPPlayListener.onPlayCallback(7, paramObject1, null, null, null);
      TPDLProxyLog.i("TPListenerManager", 0, "tpdlnative", "MSG_MULTI_NETWORK: " + paramObject1);
      return;
    }
    paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
    TPDLProxyLog.i("TPListenerManager", 0, "tpdlnative", "onPcdnDownloadFailed: " + paramObject1);
    paramITPPlayListener.onPcdnDownloadFailed(paramObject1);
  }
  
  private void dispatchPreLoadMessage(ITPPreLoadListener paramITPPreLoadListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (paramITPPreLoadListener == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      paramITPPreLoadListener.onPrepareDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
      return;
    case 50: 
      paramITPPreLoadListener.onPrepareOK();
      return;
    case 4: 
      paramITPPreLoadListener.onPrepareError(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), TPDLProxyUtils.byteArrayToString((byte[])paramObject3));
      return;
    }
    paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
    TPDLProxyLog.i("TPListenerManager", 0, "tpdlnative", "onPcdnDownloadFailed: " + paramObject1);
    paramITPPreLoadListener.onPcdnDownloadFailed(paramObject1);
  }
  
  public static TPListenerManager getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  public ITPOfflineDownloadListener getOfflineDownloadListener(int paramInt)
  {
    synchronized (OFFLINE_LISTENER_MAP_MUTEX)
    {
      ITPOfflineDownloadListener localITPOfflineDownloadListener = (ITPOfflineDownloadListener)this.mOfflineDownloadListenerMap.get(Integer.valueOf(paramInt));
      return localITPOfflineDownloadListener;
    }
  }
  
  public ITPPlayListener getPlaylistener(int paramInt)
  {
    synchronized (PLAY_LISTENER_MAP_MUTEX)
    {
      ITPPlayListener localITPPlayListener = (ITPPlayListener)this.mPlayListenerMap.get(Integer.valueOf(paramInt));
      return localITPPlayListener;
    }
  }
  
  public ITPPreLoadListener getPreLoadListener(int paramInt)
  {
    synchronized (PRELOAD_LISTENER_MAP_MUTEX)
    {
      ITPPreLoadListener localITPPreLoadListener = (ITPPreLoadListener)this.mPreLoadListenerMap.get(Integer.valueOf(paramInt));
      return localITPPreLoadListener;
    }
  }
  
  /* Error */
  public void handleCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 2008
    //   5: iload_1
    //   6: if_icmpne +247 -> 253
    //   9: aload_0
    //   10: getfield 113	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:mNetwork	Landroid/net/Network;
    //   13: ifnonnull +18 -> 31
    //   16: ldc 14
    //   18: iconst_0
    //   19: ldc_w 298
    //   22: ldc_w 348
    //   25: invokestatic 351	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_3
    //   32: checkcast 177	[B
    //   35: checkcast 177	[B
    //   38: invokestatic 183	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyUtils:byteArrayToString	([B)Ljava/lang/String;
    //   41: astore_3
    //   42: aload_3
    //   43: invokestatic 355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   46: istore_1
    //   47: new 357	java/io/FileDescriptor
    //   50: dup
    //   51: invokespecial 358	java/io/FileDescriptor:<init>	()V
    //   54: astore 4
    //   56: ldc_w 357
    //   59: ldc_w 360
    //   62: invokevirtual 366	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   65: astore 5
    //   67: aload 5
    //   69: iconst_1
    //   70: invokevirtual 372	java/lang/reflect/Field:setAccessible	(Z)V
    //   73: aload 5
    //   75: aload 4
    //   77: iload_1
    //   78: invokevirtual 376	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   81: ldc 14
    //   83: iconst_0
    //   84: ldc_w 298
    //   87: new 300	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 378
    //   97: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload_1
    //   101: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 317	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   110: getstatic 386	android/os/Build$VERSION:SDK_INT	I
    //   113: bipush 23
    //   115: if_icmplt +41 -> 156
    //   118: aload_0
    //   119: getfield 113	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:mNetwork	Landroid/net/Network;
    //   122: aload 4
    //   124: invokevirtual 392	android/net/Network:bindSocket	(Ljava/io/FileDescriptor;)V
    //   127: ldc 14
    //   129: iconst_0
    //   130: ldc_w 298
    //   133: new 300	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 394
    //   143: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload_1
    //   147: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 317	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   156: ldc 14
    //   158: iconst_0
    //   159: ldc_w 298
    //   162: new 300	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 396
    //   172: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload_1
    //   176: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: ldc_w 398
    //   182: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_3
    //   186: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 317	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   195: goto -167 -> 28
    //   198: astore_3
    //   199: aload_0
    //   200: monitorexit
    //   201: aload_3
    //   202: athrow
    //   203: astore 4
    //   205: invokestatic 403	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   208: ldc_w 405
    //   211: ldc_w 407
    //   214: invokevirtual 410	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:setUserData	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: ldc 14
    //   219: iconst_0
    //   220: ldc_w 298
    //   223: new 300	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 412
    //   233: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 4
    //   238: invokevirtual 413	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 317	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   250: goto -94 -> 156
    //   253: iload_1
    //   254: sipush 2011
    //   257: if_icmpne +25 -> 282
    //   260: aload_3
    //   261: checkcast 177	[B
    //   264: checkcast 177	[B
    //   267: invokestatic 183	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyUtils:byteArrayToString	([B)Ljava/lang/String;
    //   270: astore_3
    //   271: invokestatic 418	com/tencent/thumbplayer/core/downloadproxy/utils/TPCGIRequester:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/utils/TPCGIRequester;
    //   274: aload_3
    //   275: iload_1
    //   276: invokevirtual 422	com/tencent/thumbplayer/core/downloadproxy/utils/TPCGIRequester:addRequestItem	(Ljava/lang/String;I)V
    //   279: goto -251 -> 28
    //   282: aload_0
    //   283: getfield 145	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:mMsgHandler	Landroid/os/Handler;
    //   286: new 424	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$2
    //   289: dup
    //   290: aload_0
    //   291: iload_1
    //   292: iload_2
    //   293: aload_3
    //   294: aload 4
    //   296: aload 5
    //   298: aload 6
    //   300: aload 7
    //   302: invokespecial 426	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$2:<init>	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;IILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   305: invokevirtual 432	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   308: pop
    //   309: goto -281 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	TPListenerManager
    //   0	312	1	paramInt1	int
    //   0	312	2	paramInt2	int
    //   0	312	3	paramObject1	Object
    //   0	312	4	paramObject2	Object
    //   0	312	5	paramObject3	Object
    //   0	312	6	paramObject4	Object
    //   0	312	7	paramObject5	Object
    // Exception table:
    //   from	to	target	type
    //   9	28	198	finally
    //   31	47	198	finally
    //   47	156	198	finally
    //   156	195	198	finally
    //   205	250	198	finally
    //   260	279	198	finally
    //   282	309	198	finally
    //   47	156	203	java/lang/Throwable
  }
  
  public int handleIntCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    int j = 0;
    paramObject4 = getPlaylistener(paramInt2);
    int i = j;
    if (paramObject4 != null)
    {
      if (paramInt1 != 200) {
        break label63;
      }
      i = paramObject4.onStartReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToLong(paramObject2, 0L), TPDLProxyUtils.objectToLong(paramObject3, -1L));
    }
    label63:
    do
    {
      return i;
      if (paramInt1 == 202) {
        return paramObject4.onStopReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToInt(paramObject2, 0));
      }
      i = j;
    } while (paramInt1 != 201);
    return paramObject4.onReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToLong(paramObject2, 0L), TPDLProxyUtils.objectToInt(paramObject3, 0));
  }
  
  public String handleStringCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    paramObject3 = "";
    paramObject4 = getPlaylistener(paramInt2);
    paramObject2 = paramObject3;
    if (paramObject4 != null)
    {
      if (paramInt1 != 205) {
        break label51;
      }
      paramObject2 = paramObject4.getContentType(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
    }
    label51:
    do
    {
      return paramObject2;
      if (paramInt1 == 203) {
        return String.valueOf(paramObject4.getDataTotalSize(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1)));
      }
      paramObject2 = paramObject3;
    } while (paramInt1 != 204);
    return paramObject4.getDataFilePath(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
  }
  
  public void initHandler()
  {
    if (this.mMsgHandlerThread == null)
    {
      this.mMsgHandlerThread = new HandlerThread("TVKDL-Listener");
      this.mMsgHandlerThread.start();
      this.mMsgHandler = new Handler(this.mMsgHandlerThread.getLooper());
      this.mMsgHandler.postDelayed(this.updatePlayerInfo, this.updatePlayerInfoINterval);
    }
  }
  
  public void removeAllPlayListener()
  {
    synchronized (PLAY_LISTENER_MAP_MUTEX)
    {
      this.mPlayListenerMap.clear();
      return;
    }
  }
  
  public void removeAllPreLoadListener()
  {
    synchronized (PRELOAD_LISTENER_MAP_MUTEX)
    {
      this.mPreLoadListenerMap.clear();
      return;
    }
  }
  
  public void removeOfflineDownloadListener(int paramInt)
  {
    if (paramInt > 0) {
      synchronized (OFFLINE_LISTENER_MAP_MUTEX)
      {
        this.mOfflineDownloadListenerMap.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
  
  public void removePlayListener(int paramInt)
  {
    if (paramInt > 0) {
      synchronized (PLAY_LISTENER_MAP_MUTEX)
      {
        this.mPlayListenerMap.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
  
  public void removePreLoadListener(int paramInt)
  {
    if (paramInt > 0) {
      synchronized (PRELOAD_LISTENER_MAP_MUTEX)
      {
        this.mPreLoadListenerMap.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
  
  public void setDownloadListener(ITPDownloadListener paramITPDownloadListener)
  {
    this.mITPDownloadListener = paramITPDownloadListener;
  }
  
  public void setITPDownloadListener(ITPDownloadListener paramITPDownloadListener)
  {
    this.mITPDownloadListener = paramITPDownloadListener;
  }
  
  public void setNetwork(Network paramNetwork)
  {
    TPDLProxyLog.i("TPListenerManager", 0, "tpdlnative", "cellular_network, set network");
    this.mNetwork = paramNetwork;
  }
  
  public void setOfflineDownloadListener(int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    if ((paramInt > 0) && (paramITPOfflineDownloadListener != null)) {
      synchronized (OFFLINE_LISTENER_MAP_MUTEX)
      {
        this.mOfflineDownloadListenerMap.put(Integer.valueOf(paramInt), paramITPOfflineDownloadListener);
        return;
      }
    }
  }
  
  public void setPlayListener(int paramInt, ITPPlayListener paramITPPlayListener)
  {
    if ((paramInt > 0) && (paramITPPlayListener != null)) {
      synchronized (PLAY_LISTENER_MAP_MUTEX)
      {
        this.mPlayListenerMap.put(Integer.valueOf(paramInt), paramITPPlayListener);
        return;
      }
    }
  }
  
  public void setPreLoadListener(int paramInt, ITPPreLoadListener paramITPPreLoadListener)
  {
    if ((paramInt > 0) && (paramITPPreLoadListener != null)) {
      synchronized (PRELOAD_LISTENER_MAP_MUTEX)
      {
        this.mPreLoadListenerMap.put(Integer.valueOf(paramInt), paramITPPreLoadListener);
        return;
      }
    }
  }
  
  public void setUpdatePlayerInfoInterval(int paramInt)
  {
    this.updatePlayerInfoINterval = paramInt;
  }
  
  static class SingletonHolder
  {
    private static final TPListenerManager INSTANCE = new TPListenerManager(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager
 * JD-Core Version:    0.7.0.1
 */