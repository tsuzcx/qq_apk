import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cfq
  extends FriendListObserver
{
  public cfq(Conversation paramConversation) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onUpdateFriendInfo uin = " + paramString + ", isSc = " + paramBoolean);
    }
    if (!paramBoolean) {}
    while (Utils.a(paramString, this.a.a.getAccount())) {
      return;
    }
    this.a.a(0L);
    this.a.k();
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatedelfriend");
      }
      this.a.a(0L);
      this.a.k();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "ContactsActivity.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (!Utils.a(paramString, this.a.a.a()))
    {
      this.a.b(new cfr(this, paramString));
      return;
    }
    this.a.l();
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      Conversation.a(this.a, 1009, 500L, true);
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap == null)
      {
        i = 0;
        QLog.d("Q.recent", 2, i);
      }
    }
    else
    {
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break label74;
      }
    }
    label74:
    label111:
    do
    {
      return;
      i = paramMap.size();
      break;
      localObject = (ProxyManager)this.a.a.getManager(16);
      String str;
      if (localObject == null)
      {
        localObject = null;
        paramMap = paramMap.entrySet().iterator();
        if (!paramMap.hasNext()) {
          break label330;
        }
        str = (String)((Map.Entry)paramMap.next()).getKey();
        i = this.a.a.b(str);
        if (i != 2) {
          break label312;
        }
        TroopAssistantManager.a().a(str, this.a.a);
      }
      for (;;)
      {
        if ((i == 3) && (localObject != null)) {}
        try
        {
          RecentUser localRecentUser = ((RecentUserProxy)localObject).b(str, 1);
          if (localRecentUser != null)
          {
            ((RecentUserProxy)localObject).b(localRecentUser);
            RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.type);
            ((RecentUserProxy)localObject).b(localRecentUser);
            RecentUtil.a(this.a.a, localRecentUser.uin, 1);
            this.a.a.a().c(localRecentUser.uin, localRecentUser.type);
          }
        }
        catch (Exception localException)
        {
          break label287;
        }
        this.a.a(9, str, 1);
        break label111;
        localObject = ((ProxyManager)localObject).a();
        break;
        TroopAssistantManager.a().c(str, this.a.a);
      }
      this.a.a(9, AppConstants.Q, 5000);
    } while (!this.a.a().isResume());
    label287:
    label312:
    label330:
    if (paramBoolean)
    {
      QQToast.a(this.a.a.a(), 2130837960, this.a.a(2131562193), 0).b(this.a.a().d());
      return;
    }
    QQToast.a(this.a.a.a(), 2130837949, this.a.a(2131562192), 0).b(this.a.a().d());
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatefriendlist");
      }
      this.a.a(0L);
      this.a.k();
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onUpdateOnlineFriend| isSuc = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(0L);
    }
    if ((Conversation.a(this.a) != null) && (Conversation.a(this.a).c))
    {
      this.a.b(new cft(this, paramBoolean));
      return;
    }
    this.a.k();
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.b(new cfs(this, paramString));
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1 = (ProxyManager)this.a.a.getManager(16);
    if (localObject1 == null)
    {
      localObject1 = null;
      TroopAssistantManager.a().h(this.a.a);
      if (localObject1 != null) {
        break label176;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label185;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.type == 1) && (this.a.a.b(localRecentUser.uin) == 3))
        {
          if (localObject1 != null) {
            ((RecentUserProxy)localObject1).b(localRecentUser);
          }
          RecentUtil.a(this.a.a, localRecentUser.uin, 1);
          this.a.a.a().c(localRecentUser.uin, localRecentUser.type);
        }
      }
      localObject1 = ((ProxyManager)localObject1).a();
      break;
      label176:
      localObject2 = ((RecentUserProxy)localObject1).a();
    }
    label185:
    this.a.a(9, AppConstants.Q, 5000);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onGetGenralSettings");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfq
 * JD-Core Version:    0.7.0.1
 */