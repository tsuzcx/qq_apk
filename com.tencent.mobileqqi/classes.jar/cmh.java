import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class cmh
  extends BizTroopObserver
{
  public cmh(Conversation paramConversation) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean)
    {
      TroopAssistantManager.a().b(paramString1, this.a.a);
      this.a.a(8, AppConstants.Q, 5000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cmh
 * JD-Core Version:    0.7.0.1
 */