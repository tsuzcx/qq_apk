import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;

public class cez
  extends DataLineObserver
{
  public cez(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.a(8, AppConstants.P, 6000);
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    this.a.a(9, AppConstants.P, 6000);
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    this.a.a(8, AppConstants.P, 6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cez
 * JD-Core Version:    0.7.0.1
 */