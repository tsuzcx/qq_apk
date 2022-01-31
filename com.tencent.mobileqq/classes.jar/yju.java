import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class yju
  implements Runnable
{
  public yju(ApolloGameManager paramApolloGameManager) {}
  
  public void run()
  {
    if (ApolloGameManager.a(this.a) != null) {
      ((ApolloManager)ApolloGameManager.a(this.a).getManager(152)).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yju
 * JD-Core Version:    0.7.0.1
 */