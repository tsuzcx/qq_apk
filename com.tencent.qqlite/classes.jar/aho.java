import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class aho
  extends BizTroopObserver
{
  public aho(Conversation paramConversation) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean)
    {
      TroopAssistantManager.a().b(paramString1, this.a.a);
      this.a.a(8, AppConstants.U, 5000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aho
 * JD-Core Version:    0.7.0.1
 */