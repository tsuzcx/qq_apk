import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;

public class flf
  extends LBSObserver
{
  public flf(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
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
 * Qualified Name:     flf
 * JD-Core Version:    0.7.0.1
 */