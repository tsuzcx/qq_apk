import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.data.ApolloGameData;

public class ysv
  implements Runnable
{
  public ysv(ApolloGameActivity paramApolloGameActivity) {}
  
  public void run()
  {
    ApolloGameUtil.a(this.a, ApolloGameActivity.a(this.a).game.gameId, null, ApolloGameActivity.a(this.a).mGameType, ApolloGameActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysv
 * JD-Core Version:    0.7.0.1
 */