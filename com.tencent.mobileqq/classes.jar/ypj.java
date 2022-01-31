import android.util.LruCache;
import com.tencent.mobileqq.apollo.game.ApolloGameResManager;
import com.tencent.mobileqq.apollo.game.ApolloGameResManager.ApolloGameRes;

public class ypj
  extends LruCache
{
  public ypj(ApolloGameResManager paramApolloGameResManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, ApolloGameResManager.ApolloGameRes paramApolloGameRes)
  {
    if ((paramApolloGameRes == null) || (paramApolloGameRes.a == null)) {
      return 0;
    }
    return paramApolloGameRes.a.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypj
 * JD-Core Version:    0.7.0.1
 */