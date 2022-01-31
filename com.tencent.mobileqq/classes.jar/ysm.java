import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;

public class ysm
  implements Runnable
{
  public ysm(ApolloDaoManager paramApolloDaoManager) {}
  
  public void run()
  {
    if (this.a.a != null) {
      ApolloContentUpdateHandler.a(this.a.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysm
 * JD-Core Version:    0.7.0.1
 */