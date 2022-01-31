import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.data.AppShareID;

public class cfw
  extends ConfigObserver
{
  public cfw(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfw
 * JD-Core Version:    0.7.0.1
 */