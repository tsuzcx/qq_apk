import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

public class ayj
  implements ConditionSearchManager.IConfigListener
{
  public ayj(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt == 2)) {
      NearbyPeopleProfileActivity.x(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ayj
 * JD-Core Version:    0.7.0.1
 */