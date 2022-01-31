import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ymi
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  public ymi(ApolloRenderDriver paramApolloRenderDriver, String paramString, ReentrantLock paramReentrantLock, ApolloEngine paramApolloEngine)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = paramReentrantLock;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloEngine);
  }
  
  public void run()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      ApolloEngine localApolloEngine = (ApolloEngine)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localApolloEngine != null)
      {
        QLog.d("ApolloRenderDriver", 2, "run js =" + this.jdField_a_of_type_JavaLangString);
        localApolloEngine.a(this.jdField_a_of_type_JavaLangString);
        if (!this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a.get()) {
          localApolloEngine.a(0.0D);
        }
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymi
 * JD-Core Version:    0.7.0.1
 */