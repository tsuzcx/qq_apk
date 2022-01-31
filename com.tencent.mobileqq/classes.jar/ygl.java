import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;

public class ygl
  implements Runnable
{
  public ygl(ApolloGameManager paramApolloGameManager) {}
  
  public void run()
  {
    if (ApolloGameManager.a(this.a) == null) {}
    while ((ApolloContentUpdateHandler)ApolloGameManager.a(this.a).a(115) == null) {
      return;
    }
    ApolloContentUpdateHandler.a(ApolloGameManager.a(this.a), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ygl
 * JD-Core Version:    0.7.0.1
 */