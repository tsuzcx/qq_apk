import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ymp
  implements Runnable
{
  public ymp(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(new ymq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymp
 * JD-Core Version:    0.7.0.1
 */