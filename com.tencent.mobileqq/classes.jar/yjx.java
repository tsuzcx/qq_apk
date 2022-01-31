import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTicker;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class yjx
  implements Runnable
{
  private final long jdField_a_of_type_Long;
  public final ApolloSurfaceView a;
  private final long b;
  
  yjx(ApolloTicker paramApolloTicker, ApolloSurfaceView paramApolloSurfaceView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = paramApolloSurfaceView;
    this.jdField_a_of_type_Long = paramLong2;
    this.b = paramLong1;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mIsDestroy == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mIsDestroy.get()) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mRenderMode != 0)) {
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
 * Qualified Name:     yjx
 * JD-Core Version:    0.7.0.1
 */