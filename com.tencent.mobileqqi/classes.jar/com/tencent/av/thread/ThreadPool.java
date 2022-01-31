package com.tencent.av.thread;

import bis;
import bit;
import biu;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool
{
  public static final int a = 0;
  public static final ThreadPool.JobContext a;
  private static final String jdField_a_of_type_JavaLangString = "ThreadPool";
  public static final int b = 1;
  public static final int c = 2;
  private static final int d = 4;
  private static final int e = 8;
  private static final int f = 10;
  public bit a;
  private final Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  public bit b = new bit(2);
  
  static
  {
    jdField_a_of_type_ComTencentAvThreadThreadPool$JobContext = new bis(null);
  }
  
  public ThreadPool()
  {
    this(4, 8);
  }
  
  public ThreadPool(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bit = new bit(2);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor = new ThreadPoolExecutor(paramInt1, paramInt2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory("thread-pool", 10));
  }
  
  public Future a(ThreadPool.Job paramJob)
  {
    return a(paramJob, null);
  }
  
  public Future a(ThreadPool.Job paramJob, FutureListener paramFutureListener)
  {
    paramJob = new biu(this, paramJob, paramFutureListener);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramJob);
    return paramJob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.thread.ThreadPool
 * JD-Core Version:    0.7.0.1
 */