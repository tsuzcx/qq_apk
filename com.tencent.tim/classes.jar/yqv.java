import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class yqv
  implements Manager
{
  public static int caG;
  public String aZy;
  public boolean bog;
  public boolean boh;
  private boolean boi;
  public boolean boj;
  public boolean bok;
  private acfd c = new yqx(this);
  private accn cardObserver = new yqw(this);
  private QQAppInterface d;
  public boolean isShowRedPoint;
  public List<AddFriendBlockedInfo> sY;
  
  public yqv(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    this.boi = gJ(BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("e_add_friend_setting", 101));
    zi("add_friend_blocked_expand_entrance");
    paramQQAppInterface.addObserver(this.cardObserver);
    paramQQAppInterface.addObserver(this.c);
  }
  
  private void B(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "innerReportAddFriend() isSuccess:" + paramBoolean);
    }
    if ((!paramBoolean) && (gJ(paramBundle.getInt("friend_setting"))))
    {
      String str = paramBundle.getString("uin");
      int i = paramBundle.getInt("source_id");
      int j = paramBundle.getInt("sub_source_id");
      paramBundle = paramBundle.getString("troop_uin");
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.manager", 2, "innerReportAddFriend  friendUin = " + str + " troopUin = " + paramBundle);
      }
      a().c(this.d.getCurrentUin(), str, i, j, paramBundle);
    }
  }
  
  public static yqv a(QQAppInterface paramQQAppInterface)
  {
    return (yqv)paramQQAppInterface.getManager(332);
  }
  
  private boolean b(String paramString, Object paramObject)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("add_friend_blocked_cfg_sp", 0).edit();
    if (("add_friend_blocked_show_entrance".equals(paramString)) || ("add_friend_blocked_show_red_point".equals(paramString)) || ("add_friend_blocked_expand_entrance".equals(paramString))) {
      localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    for (;;)
    {
      return localEditor.commit();
      if ("add_friend_blocked_recent_uin".equals(paramString)) {
        localEditor.putString(paramString, (String)paramObject);
      } else if ("add_friend_blocked_friend_setting".equals(paramString)) {
        localEditor.putInt(paramString, ((Integer)paramObject).intValue());
      }
    }
  }
  
  public static void bD(Activity paramActivity)
  {
    NewFriendVerifyBlockedListFragment.bv(paramActivity);
  }
  
  private boolean gJ(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4);
  }
  
  private void zh(String paramString)
  {
    this.aZy = paramString;
  }
  
  private void zi(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("add_friend_blocked_cfg_sp", 4);
    if ("add_friend_blocked_expand_entrance".equals(paramString)) {
      this.boj = localSharedPreferences.getBoolean(paramString, true);
    }
    do
    {
      return;
      if ("add_friend_blocked_show_entrance".equals(paramString))
      {
        this.bok = localSharedPreferences.getBoolean(paramString, false);
        return;
      }
      if ("add_friend_blocked_show_red_point".equals(paramString))
      {
        this.isShowRedPoint = localSharedPreferences.getBoolean(paramString, false);
        return;
      }
      if ("add_friend_blocked_recent_uin".equals(paramString))
      {
        this.aZy = localSharedPreferences.getString(paramString, "");
        return;
      }
    } while (!"add_friend_blocked_friend_setting".equals(paramString));
    this.boi = gJ(localSharedPreferences.getInt(paramString, 101));
  }
  
  public void AC(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, " onReportAddFriendBlocked()-->  success=  " + paramBoolean);
    }
    this.boh = paramBoolean;
    a().notifyUI(2, paramBoolean, null);
  }
  
  public void AD(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, " onClearAddFriendBlockedList()-->  success=  " + paramBoolean);
    }
    if (this.sY != null) {
      this.sY.clear();
    }
    this.bog = paramBoolean;
    a().notifyUI(1, paramBoolean, null);
  }
  
  public void AE(boolean paramBoolean)
  {
    this.bok = paramBoolean;
  }
  
  public void AF(boolean paramBoolean)
  {
    this.isShowRedPoint = paramBoolean;
  }
  
  public boolean Uh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "isShowRedPoint, isShowRedPoint:" + this.isShowRedPoint);
    }
    return this.isShowRedPoint;
  }
  
  public yqu a()
  {
    return (yqu)this.d.getBusinessHandler(158);
  }
  
  public void a(boolean paramBoolean, List<AddFriendBlockedInfo> paramList, String paramString)
  {
    int i;
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append(" onGetAddFriendBlockedList()--> blockedInfos =  ");
        if (paramList == null) {
          break label191;
        }
        i = paramList.size();
        QLog.d("NewFriendVerification.manager", 2, i);
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendVerification.manager", 2, " onGetAddFriendBlockedList()--> isRead =  " + ((AddFriendBlockedInfo)paramList.get(0)).isRead);
        }
        if (((AddFriendBlockedInfo)paramList.get(0)).isRead) {
          break label197;
        }
      }
    }
    label191:
    label197:
    for (boolean bool = true;; bool = false)
    {
      this.boj = bool;
      b("add_friend_blocked_expand_entrance", Boolean.valueOf(this.boj));
      this.sY.clear();
      this.sY.addAll(paramList);
      a().notifyUI(4, paramBoolean, new Object[] { paramList, paramString });
      return;
      i = 0;
      break;
    }
  }
  
  public void b(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "start --> reportAddFriendBlocked() friendUin :" + paramString1 + " friendSetting=" + paramInt1 + " troopUin = " + paramString2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("friend_setting", paramInt1);
    localBundle.putString("uin", paramString1);
    localBundle.putInt("source_id", paramInt2);
    localBundle.putInt("sub_source_id", paramInt3);
    localBundle.putString("troop_uin", paramString2);
    B(false, localBundle);
  }
  
  public void ckQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "leaveNewFriend()");
    }
    this.isShowRedPoint = false;
    this.boj = false;
    b("add_friend_blocked_expand_entrance", Boolean.valueOf(false));
    if (caG > 0) {
      anot.b(null, "dc00898", "", "", "0X800A3A3", "0X800A3A3", 0, caG, 0, "", "", "", "");
    }
    caG = 0;
  }
  
  public void ckR()
  {
    if ((this.sY == null) || (this.sY.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.sY.iterator();
      while (localIterator.hasNext()) {
        ((AddFriendBlockedInfo)localIterator.next()).isRead = true;
      }
    }
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    AE(paramBoolean2);
    AF(paramBoolean3);
    zh(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, " onGetAddFriendBlockedRedPoint() --> isShowAddFriendBlockedEntrance =  " + paramBoolean2 + " isShowRedPoint =" + paramBoolean3 + " blockedUin =" + paramString);
    }
    a().notifyUI(3, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), paramString });
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      AE(paramBoolean2);
      zh(paramString);
    }
    a().notifyUI(5, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), paramString });
  }
  
  public void onDestroy()
  {
    if (this.sY != null)
    {
      this.sY.clear();
      this.sY = null;
    }
    if (this.d != null)
    {
      this.d.removeObserver(this.cardObserver);
      this.cardObserver = null;
      this.d.removeObserver(this.c);
      this.c = null;
      this.d = null;
    }
  }
  
  public int th()
  {
    int j = 0;
    int i;
    if ((this.bok) && (this.boj)) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.manager", 2, "getEntranceType, type=" + i + ", entrance=" + this.bok + ", isEntranceExpand=" + this.boj);
      }
      return i;
      i = j;
      if (this.bok)
      {
        i = j;
        if (!this.boj) {
          i = 3;
        }
      }
    }
  }
  
  public void zd(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, " start-> clearAddFriendBlockedList() uin = " + paramString);
    }
    a().zd(paramString);
  }
  
  public void zf(String paramString)
  {
    if (this.boi)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.manager", 2, "start -> getAddFriendBlockedList()");
      }
      if (this.sY == null) {
        this.sY = new ArrayList();
      }
      a().I(paramString, 500, "");
    }
  }
  
  public void zg(String paramString)
  {
    if (this.boi)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.manager", 2, "start -> getAddFriendBlockedRedPoint() ");
      }
      a().ze(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqv
 * JD-Core Version:    0.7.0.1
 */