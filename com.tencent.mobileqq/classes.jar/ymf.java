import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ITriggerRenderCallback;
import com.tencent.mobileqq.apollo.task.OnDressDoneListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ymf
  implements Runnable
{
  public ymf(ApolloRenderDriver paramApolloRenderDriver, String[] paramArrayOfString, OnDressDoneListener paramOnDressDoneListener) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskOnDressDoneListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloTaskOnDressDoneListener.d();
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback.onRender();
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymf
 * JD-Core Version:    0.7.0.1
 */