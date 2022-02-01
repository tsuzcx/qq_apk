package com.tencent.mobileqq.apollo;

import abiz;
import abvg;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$1
  extends IApolloRunnableTask
{
  ApolloRenderDriver$1(ApolloRenderDriver paramApolloRenderDriver, int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2) {}
  
  public String aV()
  {
    return "onSetActions";
  }
  
  public void run()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "start run.");
    }
    String[] arrayOfString = abvg.a(ApolloUtil.du(1), this.val$actionId, this.val$taskId, this.dq[0], this.dq[1]);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.dr != null)
    {
      localObject1 = localObject3;
      if (this.dr.length == 2) {
        localObject1 = abvg.a(ApolloUtil.du(2), this.val$actionId, this.val$taskId, this.dr[0], this.dr[1]);
      }
    }
    this.this$0.mLock.lock();
    if (arrayOfString != null) {}
    for (int i = 0;; i = j) {
      do
      {
        try
        {
          while (i < arrayOfString.length)
          {
            this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.BA(arrayOfString[i]);
            i += 1;
            continue;
            while (i < localObject1.length)
            {
              this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.BA(localObject1[i]);
              i += 1;
            }
            this.this$0.mLock.unlock();
            if ((!this.this$0.cl.get()) && (this.this$0.jdField_a_of_type_Abiz != null)) {
              this.this$0.jdField_a_of_type_Abiz.onRender();
            }
            return;
          }
        }
        finally
        {
          this.this$0.mLock.unlock();
        }
      } while (localObject2 == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.1
 * JD-Core Version:    0.7.0.1
 */