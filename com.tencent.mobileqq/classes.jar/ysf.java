import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import java.util.concurrent.locks.ReentrantLock;

public class ysf
  implements Runnable
{
  public ysf(ApolloRenderDriver paramApolloRenderDriver, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysf
 * JD-Core Version:    0.7.0.1
 */