import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.CheckGameListener;

public class ynf
  implements ApolloGameWrapper.CheckGameListener
{
  public ynf(ChatPieApolloViewController paramChatPieApolloViewController) {}
  
  public void a(boolean paramBoolean, CmGameMainManager paramCmGameMainManager)
  {
    if ((paramBoolean) && (paramCmGameMainManager != null)) {
      paramCmGameMainManager.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ynf
 * JD-Core Version:    0.7.0.1
 */