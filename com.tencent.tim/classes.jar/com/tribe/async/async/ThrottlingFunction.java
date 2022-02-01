package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.log.SLog;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

public class ThrottlingFunction<IN>
  extends StreamFunction<IN, IN>
{
  private static final String TAG = "async.boss.ThrottlingFunction";
  private Map<IN, Future> mFutures = new ConcurrentHashMap();
  private int mJobType;
  private final int mMaxSimultaneousRequests;
  private int mNumCurrentRequests;
  private final ConcurrentLinkedQueue<IN> mPendingRequests;
  private String mTAG;
  
  public ThrottlingFunction(int paramInt1, int paramInt2)
  {
    this("ThrottlingFunction", paramInt1, paramInt2);
  }
  
  public ThrottlingFunction(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    this.mTAG = paramString;
    this.mPendingRequests = new ConcurrentLinkedQueue();
    this.mMaxSimultaneousRequests = paramInt1;
    this.mJobType = paramInt2;
    this.mNumCurrentRequests = 0;
  }
  
  private void onRequestFinished()
  {
    try
    {
      Object localObject1 = this.mPendingRequests.poll();
      if (localObject1 == null) {
        this.mNumCurrentRequests -= 1;
      }
      if (localObject1 != null) {
        produceResultsInternal(localObject1);
      }
      return;
    }
    finally {}
  }
  
  private void produceResultsInternal(@NonNull IN paramIN)
  {
    SLog.d("async.boss.ThrottlingFunction", "process " + paramIN + ", size = " + this.mNumCurrentRequests);
    new ThreadOffJob(this.mTAG, null).setJobType(this.mJobType);
    Worker localWorker = Bosses.get().prepareWorker(new ThreadOffJob(this.mTAG, null), this.mJobType, new InnerCallFutureListener(null), paramIN);
    this.mFutures.put(paramIN, localWorker);
    Bosses.get().getJobController().getDefaultHandler().handleExecute(Bosses.get().getExecutors(), localWorker);
  }
  
  /* Error */
  public void call(IN paramIN)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tribe/async/async/ThrottlingFunction:mNumCurrentRequests	I
    //   6: aload_0
    //   7: getfield 55	com/tribe/async/async/ThrottlingFunction:mMaxSimultaneousRequests	I
    //   10: if_icmplt +26 -> 36
    //   13: aload_0
    //   14: getfield 53	com/tribe/async/async/ThrottlingFunction:mPendingRequests	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   17: aload_1
    //   18: invokevirtual 167	java/util/concurrent/ConcurrentLinkedQueue:add	(Ljava/lang/Object;)Z
    //   21: pop
    //   22: iconst_1
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ifne +8 -> 35
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 85	com/tribe/async/async/ThrottlingFunction:produceResultsInternal	(Ljava/lang/Object;)V
    //   35: return
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 59	com/tribe/async/async/ThrottlingFunction:mNumCurrentRequests	I
    //   41: iconst_1
    //   42: iadd
    //   43: putfield 59	com/tribe/async/async/ThrottlingFunction:mNumCurrentRequests	I
    //   46: iconst_0
    //   47: istore_2
    //   48: goto -24 -> 24
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ThrottlingFunction
    //   0	56	1	paramIN	IN
    //   23	25	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	22	51	finally
    //   24	26	51	finally
    //   36	46	51	finally
    //   52	54	51	finally
  }
  
  public void error(Error paramError)
  {
    ThreadOffErrJob localThreadOffErrJob = new ThreadOffErrJob(this.mTAG, null);
    localThreadOffErrJob.setJobType(this.mJobType);
    Bosses.get().postJob(localThreadOffErrJob, paramError);
  }
  
  public void onCancel()
  {
    Iterator localIterator = this.mFutures.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((Future)((Map.Entry)localIterator.next()).getValue()).cancel(true);
    }
    try
    {
      this.mFutures.clear();
      this.mPendingRequests.clear();
      this.mNumCurrentRequests = 0;
      return;
    }
    finally {}
  }
  
  class InnerCallFutureListener
    extends FutureListener.SimpleFutureListener<Void, IN>
  {
    private InnerCallFutureListener() {}
    
    public void onFutureDone(@Nullable IN paramIN)
    {
      ThrottlingFunction.this.onRequestFinished();
    }
  }
  
  class ThreadOffErrJob
    extends Job<Error, Void, Error>
  {
    private ThreadOffErrJob(String paramString)
    {
      super();
    }
    
    protected Error doInBackground(@NonNull JobContext paramJobContext, @Nullable Error... paramVarArgs)
    {
      AssertUtils.checkNotNull(paramVarArgs);
      if (paramVarArgs.length > 0) {}
      for (boolean bool = true;; bool = false)
      {
        AssertUtils.assertTrue(bool);
        paramJobContext = paramVarArgs[0];
        ThrottlingFunction.this.notifyError(paramJobContext);
        return paramJobContext;
      }
    }
  }
  
  class ThreadOffJob
    extends Job<IN, Void, IN>
  {
    private ThreadOffJob(String paramString)
    {
      super();
    }
    
    protected IN doInBackground(@NonNull JobContext paramJobContext, @Nullable IN... paramVarArgs)
    {
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
      {
        ThrottlingFunction.this.notifyResult(null);
        return null;
      }
      ThrottlingFunction.this.notifyResult(paramVarArgs[0]);
      return paramVarArgs[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.async.ThrottlingFunction
 * JD-Core Version:    0.7.0.1
 */