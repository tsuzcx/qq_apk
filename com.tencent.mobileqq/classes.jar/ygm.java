import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ygm
  implements Runnable
{
  public ygm(ApolloGameManager paramApolloGameManager) {}
  
  public void run()
  {
    if (ApolloGameManager.a(this.a) != null)
    {
      ((ApolloManager)ApolloGameManager.a(this.a).getManager(152)).e();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[onGetGameList] change reload");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ygm
 * JD-Core Version:    0.7.0.1
 */