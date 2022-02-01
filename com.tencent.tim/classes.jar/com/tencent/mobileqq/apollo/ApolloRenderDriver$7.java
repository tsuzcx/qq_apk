package com.tencent.mobileqq.apollo;

import abiz;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$7
  extends IApolloRunnableTask
{
  public String aV()
  {
    return "onRestoreAnimation";
  }
  
  public void run()
  {
    if (1 == this.coX) {}
    for (String str = "me.restoreAnimationState();";; str = "friend.restoreAnimationState();")
    {
      this.this$0.mLock.lock();
      try
      {
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine != null) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.BA(str);
        }
        if (this.this$0.jdField_a_of_type_Abiz != null) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.7
 * JD-Core Version:    0.7.0.1
 */