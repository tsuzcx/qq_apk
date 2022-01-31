import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ITriggerRenderCallback;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class yit
  implements Runnable
{
  public yit(ApolloRenderDriver paramApolloRenderDriver, int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2) {}
  
  public void run()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "start run.");
    }
    String[] arrayOfString = ApolloActionHelper.a(ApolloUtil.d(1), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfJavaLangString[0], this.jdField_a_of_type_ArrayOfJavaLangString[1]);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_b_of_type_ArrayOfJavaLangString != null)
    {
      localObject1 = localObject3;
      if (this.jdField_b_of_type_ArrayOfJavaLangString.length == 2) {
        localObject1 = ApolloActionHelper.a(ApolloUtil.d(2), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_b_of_type_ArrayOfJavaLangString[1]);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (arrayOfString != null) {}
    for (int i = 0;; i = j) {
      do
      {
        try
        {
          while (i < arrayOfString.length)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(arrayOfString[i]);
            i += 1;
            continue;
            while (i < localObject1.length)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(localObject1[i]);
              i += 1;
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
            if ((!this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback != null)) {
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback.onRender();
            }
            return;
          }
        }
        finally
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        }
      } while (localObject2 == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yit
 * JD-Core Version:    0.7.0.1
 */