import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class yvt
  implements Runnable
{
  public yvt(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    if ((!ApolloGameStateMachine.a.get()) && (ApolloGameStateMachine.a(this.a) != null))
    {
      ThreadManager.removeJobFromThreadPool(ApolloGameStateMachine.a(this.a), 16);
      ThreadManager.excute(ApolloGameStateMachine.a(this.a), 16, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvt
 * JD-Core Version:    0.7.0.1
 */