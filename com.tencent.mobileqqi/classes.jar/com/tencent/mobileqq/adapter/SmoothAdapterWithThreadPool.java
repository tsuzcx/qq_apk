package com.tencent.mobileqq.adapter;

import android.content.Context;
import com.tencent.mobileqq.util.InfiniteTaskThreadPool;

public abstract class SmoothAdapterWithThreadPool
  extends BaseWhatASmoothAdapter
{
  public SmoothAdapterWithThreadPool(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(Runnable paramRunnable)
  {
    InfiniteTaskThreadPool.a().execute(paramRunnable);
  }
  
  protected void b(Runnable paramRunnable)
  {
    InfiniteTaskThreadPool.a().remove(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SmoothAdapterWithThreadPool
 * JD-Core Version:    0.7.0.1
 */