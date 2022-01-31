import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.CheckGameListener;

public class ytl
  implements ApolloGameWrapper.CheckGameListener
{
  public ytl(ChatPieApolloViewController paramChatPieApolloViewController) {}
  
  public void a(boolean paramBoolean, CmGameMainManager paramCmGameMainManager)
  {
    if ((paramBoolean) && (paramCmGameMainManager != null)) {
      paramCmGameMainManager.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ytl
 * JD-Core Version:    0.7.0.1
 */