import EncounterSvc.RespGetEncounterV2;
import com.tencent.mobileqq.activity.PeopleAroundBaseActivity;
import com.tencent.mobileqq.activity.PeopleAroundBaseActivity.BaseLbsObserver;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;

public class gbq
  extends PeopleAroundBaseActivity.BaseLbsObserver
{
  public gbq(RoamingActivity paramRoamingActivity)
  {
    super(paramRoamingActivity);
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt1, RespGetEncounterV2 paramRespGetEncounterV2, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt2 == PeopleAroundBaseActivity.x) {
      super.a(paramBoolean1, paramString, paramInt1, paramRespGetEncounterV2, paramBoolean2, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gbq
 * JD-Core Version:    0.7.0.1
 */