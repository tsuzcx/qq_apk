import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ITriggerRenderCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class yix
  implements Runnable
{
  public yix(ApolloRenderDriver paramApolloRenderDriver, String[] paramArrayOfString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "start run.");
    }
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
 * Qualified Name:     yix
 * JD-Core Version:    0.7.0.1
 */