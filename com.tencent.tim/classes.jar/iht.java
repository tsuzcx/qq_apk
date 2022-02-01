import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class iht
  extends acfd
{
  iht(ihs paramihs) {}
  
  protected void onAddFriend(String paramString)
  {
    super.onAddFriend(paramString);
    if (QLog.isColorLevel()) {
      QLog.d(ihs.TAG, 2, "onAddFriend 进入好友列表" + paramString);
    }
    ihs.a(this.a, paramString, 4);
    this.a.ir(paramString);
  }
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ihs.TAG, 2, "onGetAutoInfo  isSuccess= " + paramBoolean + ",uin=" + paramString1 + ",remark=" + paramString2 + ",groupId" + paramInt);
    }
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 147)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ihs.TAG, 2, "onQueryUinSafetyFlag isSuccess=" + paramBoolean + ",status=" + paramInt2 + ",uin=" + paramLong);
      }
      if ((!paramBoolean) || (paramInt2 == 0)) {
        ihs.a(this.a, String.valueOf(paramLong));
      }
    }
    else
    {
      return;
    }
    ihs.a(this.a, String.valueOf(paramLong), 3, paramInt2);
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    super.onUpdateAddFriend(paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramBundle);
    int i = paramBundle.getInt("friend_setting");
    if (QLog.isColorLevel()) {
      QLog.d(ihs.TAG, 2, "onUpdateAddFriend 请求加好友回调  isSuccess= " + paramBoolean1 + ",addSuccess=" + paramBoolean2 + ",reqestUin=" + paramString + ",friendSetting" + i);
    }
    if ((paramBoolean2) && (this.a.mApp.getAccount().equals(paramString)) && (i == 0)) {
      this.a.PG = true;
    }
  }
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("uin");
    int i = paramBundle.getInt("friend_setting");
    if (QLog.isColorLevel()) {
      QLog.d(ihs.TAG, 2, "onUpdateAddFriendSetting  isSuccess= " + paramBoolean + ",uin" + str + ",friendSetting=" + i);
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.mApp.getBusinessHandler(1);
    if ((this.a.mApp.getAccount().equals(str)) && (i == 0)) {
      this.a.PG = true;
    }
    do
    {
      return;
      localFriendListHandler.a(str, null, i, (byte)0, "", this.a.amf, 0, true, null, true, "", "");
    } while (!paramBoolean);
    if (this.a.ai(str) == 2) {
      this.a.it(str);
    }
    for (;;)
    {
      paramBundle.getStringArrayList("user_question");
      paramBundle.getBoolean("contact_bothway");
      return;
      ihs.a(this.a, str, 1);
      this.a.ir(str);
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ihs.TAG, 2, "好友onUpdateCustomHead success = " + paramBoolean + ", uin = " + paramString);
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf((Long)paramObject);
    if (QLog.isColorLevel()) {
      QLog.d(ihs.TAG, 2, "onUpdateDelFriend 删除好友" + paramObject);
    }
    ihs.a(this.a, paramObject, 0);
    this.a.ir(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     iht
 * JD-Core Version:    0.7.0.1
 */