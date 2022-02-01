package com.tencent.component.network.downloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

public class RangeDownloadManager
{
  private static final int DEFAULT_RANGE_NUMBER = 4;
  private static final int MAX_THREAD_NUM_LIMIT = 4;
  private List<RangeDownloadCallable> allRangeRequests = new ArrayList();
  private long contentLength;
  private long durationMillisForHeadPhase;
  private long durationMillisForRangeReceivePhase;
  private final int numberOfRangeTasks;
  private final OkHttpClient okHttpClient;
  private ProgressHandler progressHandler;
  private List<RangeDownloadReport> rangeDownloadReports = new ArrayList();
  private long totalFileSize = 0L;
  
  public RangeDownloadManager(OkHttpClient paramOkHttpClient, int paramInt)
  {
    this.okHttpClient = paramOkHttpClient;
    if (paramInt > 0) {}
    for (;;)
    {
      this.numberOfRangeTasks = paramInt;
      return;
      paramInt = 4;
    }
  }
  
  private Response buildResponse(List<RangeDownloadResult> paramList)
  {
    Object localObject3 = null;
    if (paramList == null) {
      return null;
    }
    this.totalFileSize = 0L;
    Iterator localIterator = paramList.iterator();
    paramList = null;
    Object localObject1 = null;
    Object localObject2 = null;
    while (localIterator.hasNext())
    {
      RangeDownloadResult localRangeDownloadResult = (RangeDownloadResult)localIterator.next();
      Object localObject6 = localObject3;
      List<RangeDownloadResult> localList = paramList;
      Object localObject4 = localObject1;
      Object localObject5 = localObject2;
      if (localRangeDownloadResult != null)
      {
        this.rangeDownloadReports.add(localRangeDownloadResult.getRangeDownloadReport());
        localObject6 = localObject3;
        localList = paramList;
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (localRangeDownloadResult.response != null)
        {
          if (localRangeDownloadResult.response.request() != null) {
            localObject2 = localRangeDownloadResult.response.request();
          }
          if (localRangeDownloadResult.response.protocol() != null) {
            localObject1 = localRangeDownloadResult.response.protocol();
          }
          if (localRangeDownloadResult.response.message() != null) {
            paramList = localRangeDownloadResult.response.message();
          }
          if (localRangeDownloadResult.response.priorResponse() != null) {
            localObject3 = localRangeDownloadResult.response.priorResponse();
          }
          localObject6 = localObject3;
          localList = paramList;
          localObject4 = localObject1;
          localObject5 = localObject2;
          if (localRangeDownloadResult.responseDataLength > 0L)
          {
            this.totalFileSize += localRangeDownloadResult.responseDataLength;
            localObject5 = localObject2;
            localObject4 = localObject1;
            localList = paramList;
            localObject6 = localObject3;
          }
        }
      }
      localObject2 = localObject5;
      localObject1 = localObject4;
      paramList = localList;
      localObject3 = localObject6;
    }
    return new Response.Builder().request((Request)localObject2).protocol((Protocol)localObject1).message(paramList).priorResponse((Response)localObject3).code(200).build();
  }
  
  private List<RangeDownloadResult> executeAsync()
    throws Exception
  {
    int i = 4;
    ArrayList localArrayList = new ArrayList();
    if (this.numberOfRangeTasks > 4) {}
    ExecutorService localExecutorService;
    for (;;)
    {
      localExecutorService = Executors.newFixedThreadPool(i);
      Iterator localIterator = localExecutorService.invokeAll(this.allRangeRequests).iterator();
      while (localIterator.hasNext())
      {
        Future localFuture = (Future)localIterator.next();
        if (localFuture != null) {
          localArrayList.add((RangeDownloadResult)localFuture.get());
        }
      }
      i = this.numberOfRangeTasks;
    }
    localExecutorService.shutdown();
    localExecutorService.awaitTermination(1L, TimeUnit.SECONDS);
    return localArrayList;
  }
  
  private List<RangeDownloadResult> executeSingle()
    throws Exception
  {
    if (this.allRangeRequests.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(((RangeDownloadCallable)this.allRangeRequests.get(0)).call());
      return localArrayList;
    }
    return null;
  }
  
  private long getContentLength(Request.Builder paramBuilder, String paramString)
  {
    long l2 = getContentLength();
    long l1 = l2;
    if (l2 <= 0L)
    {
      long l3 = System.currentTimeMillis();
      paramBuilder = requestHeader(paramBuilder, paramString);
      l1 = l2;
      if (paramBuilder != null)
      {
        l1 = l2;
        if (paramBuilder.isSuccessful())
        {
          paramString = paramBuilder.header("Accept-Ranges", null);
          l1 = l2;
          if (!TextUtils.isEmpty(paramString))
          {
            l1 = l2;
            if (!paramString.equalsIgnoreCase("none"))
            {
              l1 = Long.parseLong(paramBuilder.header("Content-Length", "0"));
              setContentLength(l1);
            }
          }
        }
      }
      QDLog.i("downloader_RANGE", "getContentLength header costTime:" + (System.currentTimeMillis() - l3) + ", contentLength:" + l1 + ", rangeTaskNum:" + this.numberOfRangeTasks);
    }
    return l1;
  }
  
  private ProgressHandler getProgressHandler(ProgressListener paramProgressListener, long paramLong)
  {
    if (this.progressHandler == null) {
      this.progressHandler = new ProgressHandler(GlobalHandlerThread.getInstance(null).getLooper(), paramProgressListener, paramLong);
    }
    return this.progressHandler;
  }
  
  private Request getRequest(Request.Builder paramBuilder, String paramString, long paramLong1, long paramLong2)
  {
    paramString = paramBuilder.get().url(paramString);
    StringBuilder localStringBuilder = new StringBuilder().append("bytes=").append(paramLong1).append('-');
    if (paramLong2 == -1L) {}
    for (paramBuilder = "";; paramBuilder = Long.valueOf(paramLong2))
    {
      paramString.header("Range", paramBuilder);
      paramString.header("Connection", "keep-alive");
      return paramString.build();
    }
  }
  
  private Response requestHeader(Request.Builder paramBuilder, String paramString)
  {
    paramBuilder = paramBuilder.url(paramString).header("Connection", "keep-alive").head().build();
    try
    {
      paramBuilder = this.okHttpClient.newCall(paramBuilder).execute();
      return paramBuilder;
    }
    catch (IOException paramBuilder)
    {
      QDLog.e("downloader_RANGE", "requestHeader exception", paramBuilder);
    }
    return null;
  }
  
  public void cancel() {}
  
  public boolean createEmptyFile(String paramString)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = getContentLength();
    if (l2 <= 0L) {
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramString, "rw");
      localRandomAccessFile.setLength(l2);
      localRandomAccessFile.close();
      QDLog.e("downloader_RANGE", "createFileWithSize fileSize: " + paramString.length() + ", cost time: " + (SystemClock.uptimeMillis() - l1));
      return true;
    }
    catch (Exception paramString)
    {
      QDLog.e("downloader_RANGE", "createFileWithSize exception", paramString);
    }
    return false;
  }
  
  public Response execute()
    throws Exception
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = null;
    if (this.numberOfRangeTasks == 1) {
      localObject = executeSingle();
    }
    for (;;)
    {
      localObject = buildResponse((List)localObject);
      this.durationMillisForRangeReceivePhase = (SystemClock.uptimeMillis() - l);
      return localObject;
      if (this.numberOfRangeTasks > 1) {
        localObject = executeAsync();
      }
    }
  }
  
  public long getContentLength()
  {
    return this.contentLength;
  }
  
  public long getDurationMillisForHeadPhase()
  {
    return this.durationMillisForHeadPhase;
  }
  
  public long getDurationMillisForRangeReceivePhase()
  {
    return this.durationMillisForRangeReceivePhase;
  }
  
  public int getNumberOfRangeTasks()
  {
    return this.numberOfRangeTasks;
  }
  
  public List<RangeDownloadReport> getRangeDownloadReports()
  {
    return this.rangeDownloadReports;
  }
  
  public long getTotalFileSize()
  {
    return this.totalFileSize;
  }
  
  public void setContentLength(long paramLong)
  {
    this.contentLength = paramLong;
  }
  
  public boolean tryBuildAllRangeRequests(String paramString1, String paramString2, Request.Builder paramBuilder, String paramString3, ProgressListener paramProgressListener)
  {
    if (paramBuilder == null) {
      paramBuilder = new Request.Builder();
    }
    for (;;)
    {
      long l3 = System.currentTimeMillis();
      long l4 = getContentLength(paramBuilder, paramString2);
      if (l4 > 0L)
      {
        long l5 = l4 / this.numberOfRangeTasks + 1L;
        int i = 0;
        if (i < this.numberOfRangeTasks)
        {
          long l6 = i * l5;
          long l2 = l6 + (l5 - 1L);
          long l1 = l2;
          if (l2 >= l4) {
            l1 = -1L;
          }
          paramString2 = this.allRangeRequests;
          OkHttpClient localOkHttpClient = this.okHttpClient;
          Request localRequest = getRequest(paramBuilder, paramString1, l6, l1);
          if (l1 == -1L) {}
          for (l1 = l4 - l6;; l1 = l1 - l6 + 1L)
          {
            paramString2.add(new RangeDownloadCallable(localOkHttpClient, localRequest, paramString3, l6, l1, i, getProgressHandler(paramProgressListener, l4)));
            i += 1;
            break;
          }
        }
        this.durationMillisForHeadPhase = (System.currentTimeMillis() - l3);
        return true;
      }
      QDLog.e("downloader_RANGE", "tryBuildAllRangeRequests fail, url:" + paramString1 + ", requestUrl:" + paramString2);
      return false;
    }
  }
  
  static class ProgressHandler
    extends Handler
  {
    private long contentLength = 0L;
    private WeakReference<RangeDownloadManager.ProgressListener> progressListenerWeakReference;
    private long totalByteReceive = 0L;
    
    public ProgressHandler(Looper paramLooper, RangeDownloadManager.ProgressListener paramProgressListener, long paramLong)
    {
      super();
      this.progressListenerWeakReference = new WeakReference(paramProgressListener);
      this.contentLength = paramLong;
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      int i = ((Integer)paramMessage.obj).intValue();
      if ((i > 0) && (this.contentLength > 0L))
      {
        long l = this.totalByteReceive;
        this.totalByteReceive = (i + l);
        if ((this.progressListenerWeakReference != null) && (this.progressListenerWeakReference.get() != null)) {
          ((RangeDownloadManager.ProgressListener)this.progressListenerWeakReference.get()).onReceive(1.0F * (float)this.totalByteReceive / (float)this.contentLength);
        }
      }
    }
  }
  
  public static abstract interface ProgressListener
  {
    public abstract void onReceive(float paramFloat);
  }
  
  static class RangeDownloadCallable
    implements Callable<RangeDownloadManager.RangeDownloadResult>
  {
    private long contentLength;
    private final int index;
    private final OkHttpClient okHttpClient;
    private RangeDownloadManager.ProgressHandler progressHandler;
    private final Request request;
    private String savePath;
    private final long startPos;
    
    RangeDownloadCallable(OkHttpClient paramOkHttpClient, Request paramRequest, String paramString, long paramLong1, long paramLong2, int paramInt, RangeDownloadManager.ProgressHandler paramProgressHandler)
    {
      this.okHttpClient = paramOkHttpClient;
      this.request = paramRequest;
      this.savePath = paramString;
      this.index = paramInt;
      this.startPos = paramLong1;
      this.contentLength = paramLong2;
      this.progressHandler = paramProgressHandler;
    }
    
    public RangeDownloadManager.RangeDownloadResult call()
      throws Exception
    {
      long l4 = System.currentTimeMillis();
      Object localObject1 = new RangeDownloadReport();
      Response localResponse = this.okHttpClient.newCall(this.request).execute();
      long l5 = System.currentTimeMillis();
      long l3 = l5 - l4;
      ((RangeDownloadReport)localObject1).setTimeCostHeader(l3);
      long l1 = 0L;
      if ((localResponse != null) && (localResponse.isSuccessful()) && (localResponse.body() != null))
      {
        Object localObject2 = localResponse.header("content-length");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.contentLength = Long.parseLong((String)localObject2);
        }
        localObject2 = localResponse.body().byteStream();
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.savePath, "rw");
        byte[] arrayOfByte = new byte[8192];
        int j = 0;
        int i = 0;
        for (;;)
        {
          int k = ((InputStream)localObject2).read(arrayOfByte, i, 8192 - i);
          if (k == -1) {
            break;
          }
          int n = k + i;
          if ((n < 8192) && (n + l1 < this.contentLength))
          {
            i += k;
          }
          else
          {
            k = 0;
            localRandomAccessFile.seek(this.startPos + l1);
            localRandomAccessFile.write(arrayOfByte, 0, n);
            l2 = l1 + n;
            int m = j + 1;
            i = k;
            j = m;
            l1 = l2;
            if (this.progressHandler != null)
            {
              Message localMessage = Message.obtain();
              localMessage.obj = Integer.valueOf(n);
              this.progressHandler.sendMessage(localMessage);
              i = k;
              j = m;
              l1 = l2;
            }
          }
        }
        QDLog.d("downloader_RANGE", "range task id:" + this.index + ", round:" + j);
        ((InputStream)localObject2).close();
        localRandomAccessFile.close();
        long l2 = System.currentTimeMillis();
        l5 = l2 - l5;
        l2 -= l4;
        ((RangeDownloadReport)localObject1).setTimeCostData(l5);
        ((RangeDownloadReport)localObject1).setTimeCost(l2);
        ((RangeDownloadReport)localObject1).setRangeId(this.index);
        ((RangeDownloadReport)localObject1).setContentLength(l1);
        QDLog.e("downloader_RANGE", "range task id:" + this.index + " header costTime:" + l3 + ", data costtime:" + l5 + ", totalCostTime:" + l2 + ", byte count:" + l1);
        return new RangeDownloadManager.RangeDownloadResult(this.index, localResponse, l1, (RangeDownloadReport)localObject1);
      }
      localObject1 = null;
      if (localResponse != null) {
        localObject1 = localResponse.message();
      }
      throw new Exception((String)localObject1);
    }
  }
  
  static class RangeDownloadResult
  {
    private final int index;
    private final RangeDownloadReport rangeDownloadReport;
    private final Response response;
    private final long responseDataLength;
    
    RangeDownloadResult(int paramInt, Response paramResponse, long paramLong, RangeDownloadReport paramRangeDownloadReport)
    {
      this.index = paramInt;
      this.response = paramResponse;
      this.responseDataLength = paramLong;
      this.rangeDownloadReport = paramRangeDownloadReport;
    }
    
    public int getIndex()
    {
      return this.index;
    }
    
    public RangeDownloadReport getRangeDownloadReport()
    {
      return this.rangeDownloadReport;
    }
    
    public Response getResponse()
    {
      return this.response;
    }
    
    public long getResponseDataLength()
    {
      return this.responseDataLength;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager
 * JD-Core Version:    0.7.0.1
 */