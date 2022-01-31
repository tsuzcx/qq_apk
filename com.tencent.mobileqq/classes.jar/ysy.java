import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ysy
  implements Runnable
{
  public ysy(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void run()
  {
    if (this.a.mIsDestroy.get()) {
      return;
    }
    if (this.a.mSurfaceCallBackData != null)
    {
      ApolloSurfaceView.access$901(this.a, this.a.mSurfaceCallBackData.jdField_a_of_type_AndroidViewSurfaceHolder, this.a.mSurfaceCallBackData.jdField_a_of_type_Int, this.a.mSurfaceCallBackData.b, this.a.mSurfaceCallBackData.c);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, new Object[] { "mSurfaceChangeRunnable mSurfaceCallBackData:", this.a.mSurfaceCallBackData });
      }
    }
    ApolloSurfaceView.access$1002(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysy
 * JD-Core Version:    0.7.0.1
 */