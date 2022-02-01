package com.tencent.biz.richframework.preload;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ryn;
import ryo;
import ryq;
import ryr;
import rys;
import ryt;
import ryu;

public class Worker<T>
  implements Runnable, rys, ryt<T>
{
  private static final ThreadFactory c = new ryr();
  private static ExecutorService q = new ThreadPoolExecutor(2, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c);
  private long CE;
  ryn<T> jdField_a_of_type_Ryn;
  private volatile ryu<T> jdField_a_of_type_Ryu;
  private String aDz;
  private T[] m;
  private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
  private int mSeq;
  private volatile String mState = "";
  private ExecutorService r;
  
  public Worker(String paramString, ryn<T> paramryn, ryu<T> paramryu, int paramInt)
  {
    this.aDz = paramString;
    this.mSeq = paramInt;
    a(paramryn);
    if (paramryu != null) {
      this.jdField_a_of_type_Ryu = paramryu;
    }
  }
  
  private void a(ryn<T> paramryn)
  {
    this.jdField_a_of_type_Ryn = paramryn;
    setState(ryq.aDw);
  }
  
  private void a(ryu<T> paramryu, T... paramVarArgs)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Ryn.CD > 0L) && (l - this.CE > this.jdField_a_of_type_Ryn.CD * 1000L))
      {
        ryo.log("id=" + this.aDz + ", seq=" + this.mSeq + ", preload response is expored! mPreloadExpiredTime " + this.jdField_a_of_type_Ryn.CD);
        paramVarArgs = null;
      }
      while (isMainThread())
      {
        ryo.log("id=" + this.aDz + ", seq=" + this.mSeq + ", is in mainThread");
        paramryu.s(paramVarArgs);
        if (!this.jdField_a_of_type_Ryn.aKy) {
          return;
        }
        ryo.remove(this.aDz);
        return;
        ryo.log("id=" + this.aDz + ", seq=" + this.mSeq + ", preload response is not expored! mPreloadExpiredTime " + this.jdField_a_of_type_Ryn.CD);
      }
      ryo.log("id=" + this.aDz + ", seq=" + this.mSeq + ", is not in mainThread");
    }
    catch (Exception paramryu)
    {
      ryo.log(paramryu);
      return;
    }
    this.mMainThreadHandler.post(new Worker.2(this, paramryu, paramVarArgs));
  }
  
  private boolean isMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  private void setState(String paramString)
  {
    this.mState = paramString;
    ryo.log("id=" + this.aDz + ", seq=" + this.mSeq + ", set state to " + paramString);
  }
  
  public void a(ryu paramryu)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("id=").append(this.aDz).append(", seq=").append(this.mSeq).append(", setListener listener ");
    if (paramryu != null) {}
    for (boolean bool = true;; bool = false)
    {
      ryo.log(bool);
      if (paramryu != null)
      {
        this.jdField_a_of_type_Ryu = paramryu;
        ryo.log("id=" + this.aDz + ", seq=" + this.mSeq + ", cur state " + this.mState);
        if (ryq.aDy.equals(this.mState)) {
          a(paramryu, this.m);
        }
      }
      return;
    }
  }
  
  public void bxr()
  {
    if (this.r != null) {
      this.r.execute(this);
    }
    for (;;)
    {
      setState(ryq.aDx);
      return;
      q.execute(this);
    }
  }
  
  public void onRemove()
  {
    try
    {
      ryo.log("id=" + this.aDz + ", seq=" + this.mSeq + ", on remove worker");
      this.jdField_a_of_type_Ryn.onRemove();
      return;
    }
    catch (Exception localException)
    {
      ryo.log(localException);
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Ryn.a(this);
      return;
    }
    catch (Exception localException)
    {
      ryo.log(localException);
    }
  }
  
  public void u(T... paramVarArgs)
  {
    this.m = paramVarArgs;
    this.CE = System.currentTimeMillis();
    setState(ryq.aDy);
    if (this.jdField_a_of_type_Ryu != null)
    {
      a(this.jdField_a_of_type_Ryu, paramVarArgs);
      return;
    }
    ryo.log("id=" + this.aDz + ", seq=" + this.mSeq + ", done but listener is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.preload.Worker
 * JD-Core Version:    0.7.0.1
 */