import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.data.AppShareID;

public class cmi
  extends ConfigObserver
{
  public cmi(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cmi
 * JD-Core Version:    0.7.0.1
 */