import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;

public class dbv
  extends LBSObserver
{
  public dbv(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if (paramBoolean) {
      this.a.c = paramLBSInfo.a();
    }
    if ((this.a.c == null) || (this.a.c.length != 4)) {
      this.a.c = new String[] { "-1", "-1", "-1", "-1" };
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbv
 * JD-Core Version:    0.7.0.1
 */