import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class ymg
  implements Runnable
{
  public ymg(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    if ((!ApolloGameStateMachine.a.get()) && (ApolloGameStateMachine.a(this.a) != null))
    {
      ThreadManager.remove(ApolloGameStateMachine.a(this.a));
      ThreadManager.post(ApolloGameStateMachine.a(this.a), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymg
 * JD-Core Version:    0.7.0.1
 */