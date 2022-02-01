package com.tencent.thumbplayer.datatransport.resourceloader;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class TPAssetResourceLoader
  implements ITPAssetResourceLoader
{
  private static final int MSG_ON_START_READ_DATA = 256;
  private static final int MSG_ON_STOP_READ_DATA = 257;
  private static String TAG = "TPAssetResourceLoader";
  private static final String mCacheDir = "resourceLoader";
  private String mBusinessFilePath = "";
  private EventHandler mCallbackForResourceLoaderHandler;
  private TPAssetResourceLoadingContentInformationRequest mContentInformation;
  private String mContentType = "";
  private Context mContext;
  private String mDataCacheFilePath = "";
  private long mDataTotalSize = 0L;
  private String mFileSuffix = ".mp4";
  private HandlerThread mHandlerThread;
  private ArrayList<TPAssetResourceLoadingRequest> mLoadingRequests;
  private int mRequestNum = 0;
  private ITPAssetResourceLoaderListener mTPAssetResourceLoaderListener;
  private HandlerThread mWriteDataThread;
  
  public TPAssetResourceLoader(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mLoadingRequests = new ArrayList();
    paramContext = paramLooper;
    if (paramLooper == null)
    {
      this.mHandlerThread = new HandlerThread("TPAssetResourceLoader-callbackThread");
      this.mHandlerThread.start();
      paramContext = this.mHandlerThread.getLooper();
    }
    this.mCallbackForResourceLoaderHandler = new EventHandler(paramContext);
    this.mWriteDataThread = new HandlerThread("TPAssetResourceLoader-dataWriteThread");
    this.mWriteDataThread.start();
  }
  
  private void addRequest(TPAssetResourceLoadingRequest paramTPAssetResourceLoadingRequest)
  {
    try
    {
      if (this.mLoadingRequests != null) {
        this.mLoadingRequests.add(paramTPAssetResourceLoadingRequest);
      }
      return;
    }
    finally
    {
      paramTPAssetResourceLoadingRequest = finally;
      throw paramTPAssetResourceLoadingRequest;
    }
  }
  
  private void clearRequestList()
  {
    try
    {
      if (this.mLoadingRequests != null)
      {
        Iterator localIterator = this.mLoadingRequests.iterator();
        while (localIterator.hasNext())
        {
          ITPAssetResourceLoadingRequest localITPAssetResourceLoadingRequest = (ITPAssetResourceLoadingRequest)localIterator.next();
          ((TPAssetResourceLoadingRequest)localITPAssetResourceLoadingRequest).cancelRequest();
          this.mTPAssetResourceLoaderListener.didCancelLoadingRequest(localITPAssetResourceLoadingRequest);
        }
        this.mLoadingRequests.clear();
      }
    }
    finally {}
  }
  
  private String getBusinessFilePath()
  {
    return this.mBusinessFilePath;
  }
  
  private String getDataCacheFilePath(Context paramContext, int paramInt)
  {
    if (TextUtils.isEmpty(this.mDataCacheFilePath))
    {
      String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      paramContext = TPDLFileSystem.getExternalCacheFile(paramContext, "resourceLoader", str + "-" + paramInt + this.mFileSuffix);
      TPDLIOUtil.createFile(paramContext);
      this.mDataCacheFilePath = paramContext.getAbsolutePath();
    }
    return this.mDataCacheFilePath;
  }
  
  /* Error */
  private int getDataReadyLength(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 77	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoader:mLoadingRequests	Ljava/util/ArrayList;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnonnull +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: iconst_0
    //   20: istore 4
    //   22: iconst_0
    //   23: istore_3
    //   24: iload 4
    //   26: aload_0
    //   27: getfield 77	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoader:mLoadingRequests	Ljava/util/ArrayList;
    //   30: invokevirtual 232	java/util/ArrayList:size	()I
    //   33: if_icmpge +33 -> 66
    //   36: iload_3
    //   37: aload_0
    //   38: getfield 77	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoader:mLoadingRequests	Ljava/util/ArrayList;
    //   41: iload 4
    //   43: invokevirtual 236	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   46: checkcast 161	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingRequest
    //   49: lload_1
    //   50: invokevirtual 238	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingRequest:getDataReadyLength	(J)I
    //   53: invokestatic 244	java/lang/Math:max	(II)I
    //   56: istore_3
    //   57: iload 4
    //   59: iconst_1
    //   60: iadd
    //   61: istore 4
    //   63: goto -39 -> 24
    //   66: goto -51 -> 15
    //   69: astore 5
    //   71: aload_0
    //   72: monitorexit
    //   73: aload 5
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	TPAssetResourceLoader
    //   0	76	1	paramLong	long
    //   1	56	3	i	int
    //   20	42	4	j	int
    //   8	3	5	localArrayList	ArrayList
    //   69	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	10	69	finally
    //   24	57	69	finally
  }
  
  /* Error */
  private TPAssetResourceLoadingRequest getLoadingRequestWithNum(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoader:mLoadingRequests	Ljava/util/ArrayList;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +11 -> 21
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: monitorexit
    //   18: aload 4
    //   20: areturn
    //   21: iconst_0
    //   22: istore_2
    //   23: iload_2
    //   24: aload_0
    //   25: getfield 77	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoader:mLoadingRequests	Ljava/util/ArrayList;
    //   28: invokevirtual 232	java/util/ArrayList:size	()I
    //   31: if_icmpge +37 -> 68
    //   34: aload_0
    //   35: getfield 77	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoader:mLoadingRequests	Ljava/util/ArrayList;
    //   38: iload_2
    //   39: invokevirtual 236	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   42: checkcast 161	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingRequest
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 250	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingRequest:getLoadingDataRequest	()Lcom/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest;
    //   52: invokevirtual 255	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:getRequestNum	()I
    //   55: istore_3
    //   56: iload_3
    //   57: iload_1
    //   58: if_icmpeq -42 -> 16
    //   61: iload_2
    //   62: iconst_1
    //   63: iadd
    //   64: istore_2
    //   65: goto -42 -> 23
    //   68: aconst_null
    //   69: astore 4
    //   71: goto -55 -> 16
    //   74: astore 4
    //   76: aload_0
    //   77: monitorexit
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	TPAssetResourceLoader
    //   0	81	1	paramInt	int
    //   22	43	2	i	int
    //   55	4	3	j	int
    //   6	64	4	localObject1	Object
    //   74	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	74	finally
    //   23	56	74	finally
  }
  
  private long getRequestLength(long paramLong1, long paramLong2)
  {
    if (paramLong2 > 0L) {
      return paramLong2 - paramLong1;
    }
    paramLong2 = this.mDataTotalSize;
    if (paramLong2 <= 0L) {
      return 536870912L;
    }
    return paramLong2 - paramLong1;
  }
  
  private void handleResourceLoaderCallback(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (this.mCallbackForResourceLoaderHandler != null)
    {
      Message localMessage = this.mCallbackForResourceLoaderHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.mCallbackForResourceLoaderHandler.sendMessage(localMessage);
    }
  }
  
  private void handleStopReadData(int paramInt)
  {
    TPAssetResourceLoadingRequest localTPAssetResourceLoadingRequest = getLoadingRequestWithNum(paramInt);
    if (localTPAssetResourceLoadingRequest == null)
    {
      TPLogUtil.e(TAG, "TPAssetLoader can't find the request " + paramInt + " with current loading requests");
      return;
    }
    localTPAssetResourceLoadingRequest.cancelRequest();
    TPLogUtil.i(TAG, "handleStopReadData, cancel the loading request with id " + paramInt);
    removeRequest(localTPAssetResourceLoadingRequest);
    this.mTPAssetResourceLoaderListener.didCancelLoadingRequest(localTPAssetResourceLoadingRequest);
  }
  
  private void removeRequest(TPAssetResourceLoadingRequest paramTPAssetResourceLoadingRequest)
  {
    try
    {
      if (this.mLoadingRequests != null) {
        this.mLoadingRequests.remove(paramTPAssetResourceLoadingRequest);
      }
      return;
    }
    finally
    {
      paramTPAssetResourceLoadingRequest = finally;
      throw paramTPAssetResourceLoadingRequest;
    }
  }
  
  public void fillInContentInformation()
  {
    if (this.mTPAssetResourceLoaderListener == null)
    {
      TPLogUtil.e(TAG, "listener not set");
      return;
    }
    this.mContentInformation = new TPAssetResourceLoadingContentInformationRequest();
    this.mTPAssetResourceLoaderListener.fillInContentInformation(this.mContentInformation);
    this.mContentType = this.mContentInformation.contentType;
    this.mDataTotalSize = this.mContentInformation.dataTotalSize;
    this.mBusinessFilePath = this.mContentInformation.dataFilePath;
    TPLogUtil.i(TAG, "proxy start, mDataTotalSize: " + this.mDataTotalSize + " businessPath:" + this.mBusinessFilePath);
  }
  
  public String getContentType(int paramInt, String paramString)
  {
    return this.mContentType;
  }
  
  public String getDataFilePath(int paramInt, String paramString)
  {
    paramString = getBusinessFilePath();
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return getDataCacheFilePath(this.mContext, paramInt);
  }
  
  public long getDataTotalSize(int paramInt, String paramString)
  {
    return this.mDataTotalSize;
  }
  
  public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    TPLogUtil.d(TAG, "read data, offset:" + paramLong1 + ", length:" + paramLong2);
    int i = (int)Math.min(getDataReadyLength(paramLong1), paramLong2);
    if (i <= 0) {
      return -1;
    }
    TPLogUtil.d(TAG, "on read data, fileId: " + paramInt + " readOffset: " + paramLong1 + " readLength:" + paramLong2 + " readyLength:" + i);
    return i;
  }
  
  public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    if (this.mTPAssetResourceLoaderListener == null)
    {
      TPLogUtil.e(TAG, "listener not set");
      return 0;
    }
    TPLogUtil.i(TAG, "onStartReadData, fileId:" + paramInt + ", fileKey:" + paramString + ", requestStart:" + paramLong1 + ", requestEnd:" + paramLong2);
    int i = this.mRequestNum + 1;
    StartReadDataParams localStartReadDataParams = new StartReadDataParams(null);
    localStartReadDataParams.requestStart = paramLong1;
    localStartReadDataParams.requestEnd = paramLong2;
    localStartReadDataParams.fileKey = paramString;
    handleResourceLoaderCallback(256, paramInt, i, localStartReadDataParams);
    this.mRequestNum = i;
    return this.mRequestNum;
  }
  
  public int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    if (this.mTPAssetResourceLoaderListener == null)
    {
      TPLogUtil.e(TAG, "listener not set");
      return 0;
    }
    handleResourceLoaderCallback(257, paramInt2, 0, null);
    return 0;
  }
  
  public void release()
  {
    TPLogUtil.i(TAG, "release start");
    reset();
    if (this.mCallbackForResourceLoaderHandler != null)
    {
      this.mCallbackForResourceLoaderHandler.removeCallbacksAndMessages(null);
      this.mCallbackForResourceLoaderHandler = null;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mWriteDataThread != null)
    {
      this.mWriteDataThread.quit();
      this.mWriteDataThread = null;
    }
    this.mLoadingRequests = null;
  }
  
  public void reset()
  {
    TPLogUtil.i(TAG, "reset start");
    clearRequestList();
    this.mDataTotalSize = 0L;
    this.mContentType = "";
    this.mBusinessFilePath = "";
    if (!TextUtils.isEmpty(this.mDataCacheFilePath)) {}
    try
    {
      new File(this.mDataCacheFilePath).deleteOnExit();
      this.mDataCacheFilePath = "";
      if (this.mCallbackForResourceLoaderHandler != null) {
        this.mCallbackForResourceLoaderHandler.removeCallbacksAndMessages(null);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPLogUtil.e(TAG, "reset, delete cache file has exception:" + localException.toString());
      }
    }
  }
  
  public void setTPAssetResourceLoaderListener(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener)
  {
    this.mTPAssetResourceLoaderListener = paramITPAssetResourceLoaderListener;
  }
  
  class EventHandler
    extends Handler
  {
    EventHandler(Looper paramLooper)
    {
      super();
    }
    
    private boolean handleIsRequestToEnd(long paramLong1, long paramLong2)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (TPAssetResourceLoader.this.mDataTotalSize > 0L)
      {
        bool1 = bool2;
        if (paramLong2 + paramLong1 >= TPAssetResourceLoader.this.mDataTotalSize) {
          bool1 = true;
        }
      }
      if (bool1) {
        TPAssetResourceLoader.this.clearRequestList();
      }
      return bool1;
    }
    
    private void handleRequestToLoad(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
    {
      TPAssetResourceLoadingRequest localTPAssetResourceLoadingRequest = new TPAssetResourceLoadingRequest(paramLong1, paramLong2, paramInt2, handleIsRequestToEnd(paramLong1, paramLong2));
      localTPAssetResourceLoadingRequest.setDataWriteThreadLooper(TPAssetResourceLoader.this.mWriteDataThread.getLooper());
      localTPAssetResourceLoadingRequest.setDataWritePath(TPAssetResourceLoader.this.getDataFilePath(paramInt1, paramString));
      localTPAssetResourceLoadingRequest.setContentInformation(TPAssetResourceLoader.this.mContentInformation);
      if (TPAssetResourceLoader.this.mTPAssetResourceLoaderListener.shouldWaitForLoadingOfRequestedResource(localTPAssetResourceLoadingRequest))
      {
        TPAssetResourceLoader.this.addRequest(localTPAssetResourceLoadingRequest);
        TPLogUtil.i(TPAssetResourceLoader.TAG, "add to mLoadingRequests, requestId: " + paramInt2);
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      TPLogUtil.d(TPAssetResourceLoader.TAG, "mCallbackForResourceLoaderHandler msg : " + paramMessage.what);
      if (TPAssetResourceLoader.this.mTPAssetResourceLoaderListener == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 256: 
        TPLogUtil.i(TPAssetResourceLoader.TAG, "start read data");
        Object localObject = (TPAssetResourceLoader.StartReadDataParams)paramMessage.obj;
        long l1 = ((TPAssetResourceLoader.StartReadDataParams)localObject).requestStart;
        long l2 = ((TPAssetResourceLoader.StartReadDataParams)localObject).requestEnd;
        localObject = ((TPAssetResourceLoader.StartReadDataParams)localObject).fileKey;
        int i = paramMessage.arg1;
        int j = paramMessage.arg2;
        TPLogUtil.i(TPAssetResourceLoader.TAG, "start read data, requestStart: " + l1 + " requestEnd:" + l2 + " requestId:" + j);
        l2 = TPAssetResourceLoader.this.getRequestLength(l1, l2);
        if (l2 <= 0L)
        {
          TPLogUtil.e(TPAssetResourceLoader.TAG, "requestLength invalid, check requestStart and requestEnd");
          return;
        }
        handleRequestToLoad(l1, l2, (String)localObject, i, j);
        return;
      }
      TPLogUtil.i(TPAssetResourceLoader.TAG, "stop read data");
      TPAssetResourceLoader.this.handleStopReadData(paramMessage.arg1);
    }
  }
  
  static class StartReadDataParams
  {
    String fileKey;
    long requestEnd;
    long requestStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoader
 * JD-Core Version:    0.7.0.1
 */