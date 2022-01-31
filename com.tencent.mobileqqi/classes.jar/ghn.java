import PersonalState.UserProfile;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.richstatus.SameStatusActivity;
import java.util.HashMap;
import java.util.HashSet;

public class ghn
  extends CardObserver
{
  public ghn(SameStatusActivity paramSameStatusActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      UserProfile localUserProfile;
      if ((paramBoolean) && (paramObject != null) && (SameStatusActivity.a(this.a).containsKey(paramObject.uin)))
      {
        localUserProfile = (UserProfile)SameStatusActivity.a(this.a).get(paramObject.uin);
        localUserProfile.nPicNum = paramObject.iFaceNum;
        localUserProfile.bAge = paramObject.age;
        if (paramObject.shGender != 0) {
          break label113;
        }
        localUserProfile.bSex = 0;
      }
      for (;;)
      {
        SameStatusActivity.a(this.a).add(Long.valueOf(localUserProfile.lEctID));
        SameStatusActivity.a(this.a).notifyDataSetChanged();
        return;
        label113:
        if (paramObject.shGender == 1) {
          localUserProfile.bSex = 1;
        } else {
          localUserProfile.bSex = 2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghn
 * JD-Core Version:    0.7.0.1
 */