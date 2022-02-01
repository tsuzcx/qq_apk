import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.13.1;
import com.tencent.qphone.base.util.QLog;

public class akcg
  extends acfd
{
  public akcg(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void dAG()
  {
    boolean bool = this.this$0.isFriend;
    acff localacff = (acff)this.this$0.app.getManager(51);
    if (localacff != null) {
      bool = localacff.isFriend(NearbyPeopleProfileActivity.a(this.this$0).uin);
    }
    for (;;)
    {
      if (bool != this.this$0.isFriend)
      {
        this.this$0.isFriend = bool;
        this.this$0.runOnUiThread(new NearbyPeopleProfileActivity.13.1(this));
      }
      return;
    }
  }
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (NearbyPeopleProfileActivity.a(this.this$0) == null) || (!NearbyPeopleProfileActivity.a(this.this$0).uin.equals(paramSetting.uin))) {
      return;
    }
    if ((paramSetting.bFaceFlags & 0x20) != 0) {
      this.this$0.dmx = 0;
    }
    for (;;)
    {
      this.this$0.bTd = paramSetting.url;
      if (NearbyPeopleProfileActivity.a(this.this$0) != null) {
        NearbyPeopleProfileActivity.a(this.this$0).dAM();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.nearby_people_card.", 2, "onGetHeadInfo mheadSize is: " + this.this$0.dmx + " mGetHeadUrl is: " + this.this$0.bTd);
      return;
      if ((paramSetting.bFaceFlags & 0x10) != 0) {
        this.this$0.dmx = 640;
      } else if ((paramSetting.bFaceFlags & 0x8) != 0) {
        this.this$0.dmx = 140;
      } else if ((paramSetting.bFaceFlags & 0x4) != 0) {
        this.this$0.dmx = 100;
      } else {
        this.this$0.dmx = 40;
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3) || (TextUtils.isEmpty(paramString))) {}
    while ((this.this$0.mMode != 3) || (this.this$0.isFriend) || (NearbyPeopleProfileActivity.a(this.this$0) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.this$0).uin))) {
      return;
    }
    dAG();
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((this.this$0.mMode != 3) || (this.this$0.isFriend) || (NearbyPeopleProfileActivity.a(this.this$0) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.this$0).uin))) {
      return;
    }
    dAG();
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (!paramBoolean2)) {}
    while ((this.this$0.mMode != 3) || (NearbyPeopleProfileActivity.a(this.this$0) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.this$0).uin))) {
      return;
    }
    dAG();
  }
  
  protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onUpdateStangerHead: " + paramBoolean1 + "isStrangerHead: " + paramBoolean2);
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (NearbyPeopleProfileActivity.a(this.this$0) != null) && (paramString.equals(NearbyPeopleProfileActivity.a(this.this$0).uin)) && (paramBoolean2) && ((this.this$0.dmx == 640) || (this.this$0.dmx == 0)) && (!TextUtils.isEmpty(this.this$0.bTd)) && (!this.this$0.crz)) {
      this.this$0.c(paramString, this.this$0.dmx, this.this$0.bTd, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcg
 * JD-Core Version:    0.7.0.1
 */