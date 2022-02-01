package com.tencent.mobileqq.apollo;

import abiz;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$4
  extends IApolloRunnableTask
{
  ApolloRenderDriver$4(ApolloRenderDriver paramApolloRenderDriver, String[] paramArrayOfString) {}
  
  public String aV()
  {
    return "onExecAction";
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "start run.");
    }
    this.this$0.mLock.lock();
    int i = 0;
    try
    {
      while (i < this.ds.length)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.BA(this.ds[i]);
        i += 1;
      }
      this.this$0.mLock.unlock();
      if ((!this.this$0.cl.get()) && (this.this$0.jdField_a_of_type_Abiz != null)) {
        this.this$0.jdField_a_of_type_Abiz.onRender();
      }
      return;
    }
    finally
    {
      this.this$0.mLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.4
 * JD-Core Version:    0.7.0.1
 */