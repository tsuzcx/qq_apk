import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.qphone.base.util.QLog;

public class kt
  extends FriendListObserver
{
  public kt(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (BmqqProfileCardActivity.a(this.a).a.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131362938, 2);
      this.a.finish();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (BmqqProfileCardActivity.a(this.a) == null) {}
    while ((!paramBoolean) || (!paramString.equals(BmqqProfileCardActivity.a(this.a).a))) {
      return;
    }
    this.a.a(BmqqProfileCardActivity.a(this.a), 0, paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject1 = null;
    if ((!paramBoolean) || (paramString == null) || (paramString.length() == 0)) {}
    Object localObject2;
    label54:
    label206:
    label208:
    do
    {
      return;
      if (ProfileActivity.AllInOne.h(BmqqProfileCardActivity.a(this.a)))
      {
        localObject2 = (PhoneContactManager)this.a.app.getManager(10);
        if (localObject2 == null)
        {
          if ((localObject1 == null) || (((PhoneContact)localObject1).mobileNo == null) || (BmqqProfileCardActivity.a(this.a) == null) || (!((PhoneContact)localObject1).mobileNo.equals(BmqqProfileCardActivity.a(this.a).a))) {
            break label206;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString + ", pc.mobileNo = " + ((PhoneContact)localObject1).mobileNo);
          }
          localObject1 = this.a.a(paramString, BmqqProfileCardActivity.a(this.a));
          localObject2 = Message.obtain();
          ((Message)localObject2).what = 3;
          if (localObject1 != null) {
            break label208;
          }
        }
        for (;;)
        {
          ((Message)localObject2).obj = paramString;
          this.a.a.sendMessage((Message)localObject2);
          return;
          localObject1 = ((PhoneContactManager)localObject2).a(paramString);
          break label54;
          break;
          paramString = (String)localObject1;
        }
      }
    } while ((paramString == null) || (BmqqProfileCardActivity.a(this.a) == null) || (!paramString.equals(BmqqProfileCardActivity.a(this.a).a)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString);
    }
    localObject1 = (FriendManager)this.a.app.getManager(8);
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 3;
      if (localObject1 != null) {
        break label359;
      }
    }
    for (;;)
    {
      ((Message)localObject2).obj = paramString;
      this.a.a.sendMessage((Message)localObject2);
      return;
      localObject1 = ((FriendManager)localObject1).a(BmqqProfileCardActivity.a(this.a).a);
      break;
      label359:
      paramString = (String)localObject1;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((!BmqqProfileCardActivity.a(this.a).a.equals(paramString1)) || (!ProfileActivity.AllInOne.b(BmqqProfileCardActivity.a(this.a)))) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        BmqqProfileCardActivity.a(this.a, paramString2);
        return;
      }
      paramString1 = (FriendManager)this.a.app.getManager(8);
      if (paramString1 == null) {}
      for (paramString1 = null; paramString1 != null; paramString1 = paramString1.c(BmqqProfileCardActivity.a(this.a).a))
      {
        String str = "";
        paramString2 = str;
        if (paramString1.remark != null)
        {
          paramString2 = str;
          if (paramString1.isRemark == 1) {
            paramString2 = paramString1.remark;
          }
        }
        BmqqProfileCardActivity.a(this.a, paramString2);
        return;
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (BmqqProfileCardActivity.a(this.a).a != null))
    {
      localObject2 = (FriendManager)this.a.app.getManager(8);
      if (!ProfileActivity.AllInOne.b(BmqqProfileCardActivity.a(this.a))) {
        break label57;
      }
      if (localObject2 == null) {}
    }
    label57:
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.h(BmqqProfileCardActivity.a(this.a))) {
          break;
        }
        localObject1 = (PhoneContactManager)this.a.app.getManager(10);
        if (localObject1 == null) {}
        for (localObject1 = null; (localObject2 != null) && (localObject1 != null) && (((FriendManager)localObject2).b(((PhoneContact)localObject1).uin)); localObject1 = ((PhoneContactManager)localObject1).c(BmqqProfileCardActivity.a(this.a)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, pc.uin: " + ((PhoneContact)localObject1).uin);
          }
          localObject3 = this.a.a(((PhoneContact)localObject1).uin, BmqqProfileCardActivity.a(this.a));
          Message localMessage = Message.obtain();
          localMessage.what = 3;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = ((PhoneContact)localObject1).uin;
          }
          localMessage.obj = localObject2;
          this.a.a.sendMessage(localMessage);
          return;
        }
      }
    } while ((localObject2 == null) || (!((FriendManager)localObject2).b(BmqqProfileCardActivity.a(this.a).a)) || (BmqqProfileCardActivity.a(this.a).a.equals(this.a.app.a())));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, cardInfo.allinone.uin: " + BmqqProfileCardActivity.a(this.a).a);
    }
    Object localObject2 = ((FriendManager)localObject2).a(BmqqProfileCardActivity.a(this.a).a);
    Object localObject3 = Message.obtain();
    ((Message)localObject3).what = 3;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = BmqqProfileCardActivity.a(this.a).a;
    }
    ((Message)localObject3).obj = localObject1;
    this.a.a.sendMessage((Message)localObject3);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3)) {}
    label12:
    String str;
    do
    {
      int i;
      do
      {
        do
        {
          break label12;
          do
          {
            return;
          } while ((paramBundle.getByte("auto_send", (byte)0).byteValue() != 1) || (paramBundle.getInt("resultCode") != 0));
          str = paramBundle.getString("uin");
        } while (this.a.app.a().equals(str));
        i = paramBundle.getInt("friend_setting");
      } while ((i != 0) && (i != 100));
      if ((ProfileActivity.AllInOne.h(BmqqProfileCardActivity.a(this.a))) && (BmqqProfileCardActivity.a(this.a).equals(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + str);
        }
        paramBundle = this.a.a(str, BmqqProfileCardActivity.a(this.a));
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        paramString = paramBundle;
        if (paramBundle == null) {
          paramString = str;
        }
        localMessage.obj = paramString;
        this.a.a.sendMessage(localMessage);
        return;
      }
    } while ((str == null) || (BmqqProfileCardActivity.a(this.a) == null) || (!str.equalsIgnoreCase(BmqqProfileCardActivity.a(this.a).a)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + str);
    }
    paramString = (FriendManager)this.a.app.getManager(8);
    if (paramString == null)
    {
      paramString = null;
      paramBundle = Message.obtain();
      paramBundle.what = 3;
      if (paramString != null) {
        break label358;
      }
    }
    for (;;)
    {
      paramBundle.obj = str;
      this.a.a.sendMessage(paramBundle);
      return;
      paramString = paramString.a(BmqqProfileCardActivity.a(this.a).a);
      break;
      label358:
      str = paramString;
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateMobileQQHead() mobileNumber = " + paramString);
    }
    if ((!paramBoolean) || (BmqqProfileCardActivity.a(this.a) == null)) {}
    String str;
    do
    {
      return;
      str = BmqqProfileCardActivity.a(this.a);
    } while ((str == null) || (!str.equals(paramString)));
    this.a.a(BmqqProfileCardActivity.a(this.a), 1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kt
 * JD-Core Version:    0.7.0.1
 */