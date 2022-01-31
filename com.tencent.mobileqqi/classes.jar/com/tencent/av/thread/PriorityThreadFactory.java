package com.tencent.av.thread;

import biq;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory
  implements ThreadFactory
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  public PriorityThreadFactory(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new biq(this, paramRunnable, this.jdField_a_of_type_JavaLangString + '-' + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.thread.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */