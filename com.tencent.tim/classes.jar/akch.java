import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

public class akch
  extends acgf
{
  public akch(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void i(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onDismissHotChat.isSuccess=" + paramBoolean + ",groupcode=" + paramString1 + ",result=" + paramInt + ",strError=" + paramString2);
    }
    if ((paramBoolean) && (paramInt == 0) && (NearbyPeopleProfileActivity.a(this.this$0) != null) && (NearbyPeopleProfileActivity.a(this.this$0).hotInfo != null) && (paramString1 != null) && (paramString1.equals(NearbyPeopleProfileActivity.a(this.this$0).hotInfo.troopUin)) && (NearbyPeopleProfileActivity.a(this.this$0) != null))
    {
      NearbyPeopleProfileActivity.a(this.this$0).strHotChatInfo = "";
      NearbyPeopleProfileActivity.a(this.this$0).hotInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akch
 * JD-Core Version:    0.7.0.1
 */