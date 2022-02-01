import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;

public class fle
  extends LBSObserver
{
  public fle(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (paramBoolean)
    {
      this.a.c = paramArrayOfString;
      return;
    }
    this.a.c = new String[] { "-1", "-1", "-1", "-1" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fle
 * JD-Core Version:    0.7.0.1
 */