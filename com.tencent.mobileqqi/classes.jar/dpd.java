import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.activity.TroopDisbandActivity.MemberGridAdapter;
import com.tencent.mobileqq.app.FriendListObserver;

public class dpd
  extends FriendListObserver
{
  public dpd(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.a != null) && (this.a.a.a(paramString))) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpd
 * JD-Core Version:    0.7.0.1
 */