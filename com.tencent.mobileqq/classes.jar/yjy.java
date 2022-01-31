import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ApolloTicker;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class yjy
  implements Runnable
{
  private final long jdField_a_of_type_Long;
  public final ApolloTextureView a;
  private final long b;
  
  yjy(ApolloTicker paramApolloTicker, ApolloTextureView paramApolloTextureView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = paramApolloTextureView;
    this.jdField_a_of_type_Long = paramLong2;
    this.b = paramLong1;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mIsDestroy == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mIsDestroy.get())) {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker.nativeCallbackTicker(this.b, l, 0.01666666666666667D * this.jdField_a_of_type_Long);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloTicker", 1, "[onDrawFrame]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yjy
 * JD-Core Version:    0.7.0.1
 */