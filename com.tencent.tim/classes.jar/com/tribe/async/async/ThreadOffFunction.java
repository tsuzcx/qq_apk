package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;
import java.util.concurrent.Future;

public class ThreadOffFunction<IN>
  extends StreamFunction<IN, IN>
{
  private Future mFuture;
  private final int mJobType;
  private boolean mNeedSchedule;
  private final String mTAG;
  
  public ThreadOffFunction(int paramInt)
  {
    this("ThreadOffFunction", paramInt);
  }
  
  public ThreadOffFunction(@NonNull String paramString, int paramInt)
  {
    this.mJobType = paramInt;
    this.mTAG = paramString;
  }
  
  public void call(IN paramIN)
  {
    ThreadOffJob localThreadOffJob = new ThreadOffJob(this.mTAG, null);
    localThreadOffJob.setJobType(this.mJobType);
    if (this.mNeedSchedule)
    {
      this.mFuture = Bosses.get().scheduleJob(localThreadOffJob, paramIN);
      return;
    }
    this.mFuture = Bosses.get().postJob(localThreadOffJob, paramIN);
  }
  
  public void error(Error paramError)
  {
    ThreadOffErrJob localThreadOffErrJob = new ThreadOffErrJob(this.mTAG, null);
    localThreadOffErrJob.setJobType(this.mJobType);
    if (this.mNeedSchedule)
    {
      this.mFuture = Bosses.get().scheduleJob(localThreadOffErrJob, paramError);
      return;
    }
    this.mFuture = Bosses.get().postJob(localThreadOffErrJob, paramError);
  }
  
  public void onCancel()
  {
    if (this.mFuture == null) {
      return;
    }
    if (this.mNeedSchedule)
    {
      Bosses.get().cancelJob(this.mFuture, true);
      return;
    }
    this.mFuture.cancel(true);
  }
  
  public void setNeedSchedule(boolean paramBoolean)
  {
    this.mNeedSchedule = paramBoolean;
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
        ThreadOffFunction.this.notifyError(paramJobContext);
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
        ThreadOffFunction.this.notifyResult(null);
        return null;
      }
      ThreadOffFunction.this.notifyResult(paramVarArgs[0]);
      return paramVarArgs[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.async.ThreadOffFunction
 * JD-Core Version:    0.7.0.1
 */