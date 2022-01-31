import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation;

public class yrf
  implements Runnable
{
  public yrf(CmGameSubProcessHandler paramCmGameSubProcessHandler) {}
  
  public void run()
  {
    if (CmGameSubProcessHandler.a(this.a) != null) {
      CmGameSubProcessHandler.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yrf
 * JD-Core Version:    0.7.0.1
 */