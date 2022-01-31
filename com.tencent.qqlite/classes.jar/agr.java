import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;

public class agr
  extends DataLineObserver
{
  public agr(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.a(8, AppConstants.T, 6000);
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    this.a.a(9, AppConstants.T, 6000);
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    this.a.a(8, AppConstants.T, 6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     agr
 * JD-Core Version:    0.7.0.1
 */