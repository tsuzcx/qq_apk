import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.15.1;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;

public class uyu
  extends acfd
{
  public uyu(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.this$0.jdField_a_of_type_Alcn != null) && (TextUtils.equals(this.this$0.jdField_a_of_type_Alcn.e.uin, paramString))) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.g(this.this$0.jdField_a_of_type_Alcn);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (this.this$0.jdField_a_of_type_Alcn.e.uin != null))
    {
      paramString1 = (acff)this.this$0.app.getManager(51);
      if ((ProfileActivity.AllInOne.b(this.this$0.jdField_a_of_type_Alcn.e)) && (paramString1 != null))
      {
        paramString2 = paramString1.a(this.this$0.jdField_a_of_type_Alcn.e.uin);
        if (paramString2 != null)
        {
          paramString1 = "";
          if (paramString2.remark != null) {
            paramString1 = paramString2.remark;
          }
          this.this$0.vx(paramString1);
        }
      }
    }
  }
  
  protected void onSetSelfSignatureResult(boolean paramBoolean)
  {
    if (this.this$0.jdField_a_of_type_Alcn.e.uin.equals(this.this$0.app.getCurrentAccountUin()))
    {
      ExtensionInfo localExtensionInfo = ((acff)this.this$0.app.getManager(51)).a(this.this$0.app.getCurrentAccountUin());
      if (localExtensionInfo != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setNewSignature(localExtensionInfo.richBuffer, localExtensionInfo.richTime);
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("result_uin");
      if ((ProfileActivity.AllInOne.i(this.this$0.jdField_a_of_type_Alcn.e)) && (FriendProfileCardActivity.a(this.this$0.jdField_a_of_type_Alcn.e).equals(paramString)))
      {
        this.this$0.e(true, false, paramBundle);
        return;
      }
    } while ((paramBundle == null) || (this.this$0.jdField_a_of_type_Alcn.e == null) || (!paramBundle.equalsIgnoreCase(this.this$0.jdField_a_of_type_Alcn.e.uin)));
    this.this$0.e(false, false, null);
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (paramString == null) || (paramString.length() == 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.i(this.this$0.jdField_a_of_type_Alcn.e)) {
          break;
        }
        Object localObject = (ajdo)this.this$0.app.getManager(11);
        if (localObject == null) {}
        for (localObject = null; (localObject != null) && (((PhoneContact)localObject).mobileNo != null) && (this.this$0.jdField_a_of_type_Alcn.e != null) && (((PhoneContact)localObject).mobileNo.equals(this.this$0.jdField_a_of_type_Alcn.e.uin)); localObject = ((ajdo)localObject).a(paramString))
        {
          this.this$0.e(true, false, paramString);
          return;
        }
      }
    } while ((paramString == null) || (this.this$0.jdField_a_of_type_Alcn.e == null) || (!paramString.equals(this.this$0.jdField_a_of_type_Alcn.e.uin)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString);
    }
    this.this$0.e(false, false, null);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.this$0.jdField_a_of_type_Alcn.e.uin)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.this$0.jdField_a_of_type_Alcn.e);
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.this$0.jdField_a_of_type_Alcn.e.uin.equals(String.valueOf(paramObject))))
    {
      this.this$0.cf(2131692481, 2);
      this.this$0.finish();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onUpdateFriendList " + paramBoolean1 + ", " + paramBoolean2);
    }
    Object localObject2;
    if ((paramBoolean1) && (paramBoolean2) && (this.this$0.jdField_a_of_type_Alcn.e.uin != null))
    {
      localObject2 = (acff)this.this$0.app.getManager(51);
      if (!ProfileActivity.AllInOne.b(this.this$0.jdField_a_of_type_Alcn.e)) {
        break label155;
      }
      if (localObject2 != null)
      {
        localObject2 = ((acff)localObject2).a(this.this$0.jdField_a_of_type_Alcn.e.uin);
        if (localObject2 != null)
        {
          localObject1 = "";
          if (((Friends)localObject2).remark != null) {
            localObject1 = ((Friends)localObject2).remark;
          }
          this.this$0.vx((String)localObject1);
        }
      }
    }
    label155:
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.i(this.this$0.jdField_a_of_type_Alcn.e)) {
          break;
        }
        if (this.this$0.jdField_a_of_type_Alcn.e.pa == 53)
        {
          this.this$0.a(0L, null, null, false);
          return;
        }
        ajdo localajdo = (ajdo)this.this$0.app.getManager(11);
        if (localajdo == null) {}
        while ((localObject2 != null) && (localObject1 != null) && (((acff)localObject2).isFriend(((PhoneContact)localObject1).uin)))
        {
          this.this$0.e(true, false, ((PhoneContact)localObject1).uin);
          return;
          localObject1 = localajdo.c(FriendProfileCardActivity.a(this.this$0.jdField_a_of_type_Alcn.e));
        }
      }
    } while ((localObject2 == null) || (!((acff)localObject2).isFriend(this.this$0.jdField_a_of_type_Alcn.e.uin)) || (this.this$0.jdField_a_of_type_Alcn.e.uin.equals(this.this$0.app.getCurrentAccountUin())));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, cardInfo.allinone.uin: " + this.this$0.jdField_a_of_type_Alcn.e.uin);
    }
    ThreadManager.excute(new FriendProfileCardActivity.15.1(this), 16, null, false);
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateMobileQQHead() mobileNumber = " + paramString);
    }
    if ((!paramBoolean) || (this.this$0.jdField_a_of_type_Alcn.e == null)) {}
    String str;
    do
    {
      return;
      str = FriendProfileCardActivity.a(this.this$0.jdField_a_of_type_Alcn.e);
    } while ((str == null) || (!str.equals(paramString)) || (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null));
    this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.this$0.jdField_a_of_type_Alcn.e, 1, str, false);
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.g(this.this$0.jdField_a_of_type_Alcn);
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((paramArrayOfString[i] == null) || (!paramArrayOfString[i].equals(this.this$0.jdField_a_of_type_Alcn.e.uin))) {
          break label126;
        }
        paramArrayOfString = ((acff)this.this$0.app.getManager(51)).a(this.this$0.jdField_a_of_type_Alcn.e.uin);
        if (paramArrayOfString != null)
        {
          this.this$0.jdField_a_of_type_Alcn.richStatus = paramArrayOfString.getRichStatus();
          this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.this$0.jdField_a_of_type_Alcn, true, new String[] { "map_key_sig" });
        }
      }
      return;
      label126:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyu
 * JD-Core Version:    0.7.0.1
 */