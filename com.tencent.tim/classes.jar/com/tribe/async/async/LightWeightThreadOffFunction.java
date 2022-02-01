package com.tribe.async.async;

import com.tribe.async.reactive.StreamFunction;

public class LightWeightThreadOffFunction<IN>
  extends StreamFunction<IN, IN>
{
  public void call(IN paramIN)
  {
    paramIN = new ThreadOffRunnable(paramIN);
    Bosses.get().postLightWeightJob(paramIN, 0);
  }
  
  public void error(Error paramError)
  {
    paramError = new ThreadOffErrRunnable(paramError);
    Bosses.get().postLightWeightJob(paramError, 0);
  }
  
  public void onCancel() {}
  
  class ThreadOffErrRunnable
    implements Runnable
  {
    private Error mError;
    
    public ThreadOffErrRunnable(Error paramError)
    {
      this.mError = paramError;
    }
    
    public void run()
    {
      LightWeightThreadOffFunction.this.notifyError(this.mError);
    }
  }
  
  class ThreadOffRunnable
    implements Runnable
  {
    private IN mResult;
    
    public ThreadOffRunnable()
    {
      Object localObject;
      this.mResult = localObject;
    }
    
    public void run()
    {
      LightWeightThreadOffFunction.this.notifyResult(this.mResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.async.LightWeightThreadOffFunction
 * JD-Core Version:    0.7.0.1
 */