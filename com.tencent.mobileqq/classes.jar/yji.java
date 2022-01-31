import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class yji
  implements Runnable
{
  public yji(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(new yjj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yji
 * JD-Core Version:    0.7.0.1
 */