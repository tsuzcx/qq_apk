import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;

public class cmz
  extends FriendListObserver
{
  public cmz(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(this.a.b.a()))
    {
      Friends localFriends = ((FriendsManagerImp)this.a.b.getManager(8)).b(this.a.b.a());
      if (localFriends != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setNewSignature(localFriends.richBuffer, localFriends.richTime);
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a, paramString))) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131562991, 2);
      this.a.finish();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a, 0, paramString);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject1 = null;
    if ((!paramBoolean) || (paramString == null) || (paramString.length() == 0)) {}
    Object localObject2;
    label57:
    label215:
    label217:
    do
    {
      return;
      if (ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a))
      {
        localObject2 = (PhoneContactManager)this.a.b.getManager(10);
        if (localObject2 == null)
        {
          if ((localObject1 == null) || (((PhoneContact)localObject1).mobileNo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null) || (!((PhoneContact)localObject1).mobileNo.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a))) {
            break label215;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString + ", pc.mobileNo = " + ((PhoneContact)localObject1).mobileNo);
          }
          localObject1 = this.a.a(paramString, this.a.c());
          localObject2 = Message.obtain();
          ((Message)localObject2).what = 3;
          if (localObject1 != null) {
            break label217;
          }
        }
        for (;;)
        {
          ((Message)localObject2).obj = paramString;
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          return;
          localObject1 = ((PhoneContactManager)localObject2).d(paramString);
          break label57;
          break;
          paramString = (String)localObject1;
        }
      }
    } while ((paramString == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString);
    }
    localObject1 = (FriendManager)this.a.b.getManager(8);
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 3;
      if (localObject1 != null) {
        break label377;
      }
    }
    for (;;)
    {
      ((Message)localObject2).obj = paramString;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      return;
      localObject1 = ((FriendManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
      break;
      label377:
      paramString = (String)localObject1;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a != null))
    {
      localObject2 = (FriendManager)this.a.b.getManager(8);
      if (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) {
        break label115;
      }
      if (localObject2 != null)
      {
        localObject2 = ((FriendManager)localObject2).c(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
        if (localObject2 != null)
        {
          localObject1 = "";
          if (((Friends)localObject2).remark != null) {
            localObject1 = ((Friends)localObject2).remark;
          }
          this.a.b((String)localObject1);
        }
      }
    }
    label115:
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) {
          break;
        }
        localObject1 = (PhoneContactManager)this.a.b.getManager(10);
        if (localObject1 == null) {}
        for (localObject1 = null; (localObject2 != null) && (localObject1 != null) && (((FriendManager)localObject2).b(((PhoneContact)localObject1).uin)); localObject1 = ((PhoneContactManager)localObject1).f(this.a.c()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, pc.uin: " + ((PhoneContact)localObject1).uin);
          }
          localObject3 = this.a.a(((PhoneContact)localObject1).uin, this.a.c());
          Message localMessage = Message.obtain();
          localMessage.what = 3;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = ((PhoneContact)localObject1).uin;
          }
          localMessage.obj = localObject2;
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
          return;
        }
      }
    } while ((localObject2 == null) || (!((FriendManager)localObject2).b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(this.a.b.a())));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, cardInfo.allinone.uin: " + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    }
    Object localObject2 = ((FriendManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    Object localObject3 = Message.obtain();
    ((Message)localObject3).what = 3;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a;
    }
    ((Message)localObject3).obj = localObject1;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    if ((!paramBoolean) || (paramBundle == null)) {}
    label8:
    Object localObject1;
    Object localObject2;
    do
    {
      int i;
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while ((paramBundle.getByte("auto_send", (byte)0).byteValue() != 1) || (paramBundle.getInt("resultCode") != 0));
          localObject1 = paramBundle.getString("uin");
        } while (this.a.b.a().equals(localObject1));
        localObject2 = paramBundle.getString("friend_mobile_number");
        i = paramBundle.getInt("friend_setting");
      } while ((i != 0) && (i != 100));
      if ((ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) && (localObject1 != null) && (((String)localObject1).length() > 4) && (localObject2 != null) && (this.a.c().equals(localObject2)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + (String)localObject1 + ", mobileNum = " + (String)localObject2);
        }
        localObject2 = this.a.a((String)localObject1, this.a.c());
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null) {
          paramBundle = (Bundle)localObject1;
        }
        localMessage.obj = paramBundle;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
      }
    } while ((localObject1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null) || (!((String)localObject1).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + (String)localObject1 + ", mobileNum = " + (String)localObject2);
    }
    paramBundle = (FriendManager)this.a.b.getManager(8);
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 3;
      if (paramBundle != null) {
        break label397;
      }
    }
    for (;;)
    {
      ((Message)localObject2).obj = localObject1;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      return;
      paramBundle = paramBundle.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
      break;
      label397:
      localObject1 = paramBundle;
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateMobileQQHead() mobileNumber = " + paramString);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null)) {}
    String str;
    do
    {
      return;
      str = this.a.c();
    } while ((str == null) || (!str.equals(paramString)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null));
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a, 1, str);
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
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
        if ((paramArrayOfString[i] == null) || (!paramArrayOfString[i].equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a))) {
          break label110;
        }
        paramArrayOfString = (FriendsManagerImp)this.a.b.getManager(8);
        if (paramArrayOfString != null) {
          break label89;
        }
      }
      label89:
      for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a))
      {
        if (paramArrayOfString != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramArrayOfString.getRichStatus());
        }
        return;
      }
      label110:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmz
 * JD-Core Version:    0.7.0.1
 */