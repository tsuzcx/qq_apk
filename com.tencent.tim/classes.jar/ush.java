import android.os.Bundle;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.26.1;
import com.tencent.mobileqq.activity.Conversation.26.2;
import com.tencent.mobileqq.activity.Conversation.26.3;
import com.tencent.mobileqq.activity.Conversation.26.4;
import com.tencent.mobileqq.activity.Conversation.26.5;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class ush
  extends acfd
{
  public ush(Conversation paramConversation) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onCancelMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      achg localachg = (achg)this.this$0.app.getManager(159);
      ArrayList localArrayList = localachg.cw();
      if (localachg.kk(paramString)) {
        this.this$0.g.sendEmptyMessage(1009);
      }
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "onCancelMayKnowRecommend recommends is empty ");
        }
        localachg.cJR();
        this.this$0.g.sendEmptyMessage(1009);
        ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).cIP();
      }
    }
  }
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1 = (ProxyManager)this.this$0.app.getManager(18);
    if (localObject1 == null)
    {
      localObject1 = null;
      aizp.a().as(this.this$0.app);
      if (localObject1 != null) {
        break label176;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label186;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.getType() == 1) && (this.this$0.app.cs(localRecentUser.uin) == 3))
        {
          if (localObject1 != null) {
            ((acxw)localObject1).f(localRecentUser);
          }
          aalb.l(this.this$0.app, localRecentUser.uin, 1);
          this.this$0.app.b().ca(localRecentUser.uin, localRecentUser.getType());
        }
      }
      localObject1 = ((ProxyManager)localObject1).a();
      break;
      label176:
      localObject2 = ((acxw)localObject1).q(false);
    }
    label186:
    this.this$0.n(9, acbn.bkz, 5000);
    this.this$0.n(9, acbn.blI, 5001);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onGetGenralSettings");
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("is_from_init");; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onGetMayKnowRecommend isSuccess = " + paramBoolean + " isFromInit: " + bool);
      }
      if (!bool) {
        Conversation.i(this.this$0);
      }
      this.this$0.g.sendEmptyMessage(1009);
      return;
    }
  }
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " Conversation.onUpdateCustomHead: uins:" + paramHashSet + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (paramHashSet.contains(this.this$0.app.getCurrentAccountUin())) {
      this.this$0.a.mUiHandler.sendEmptyMessage(3);
    }
    this.this$0.runOnUiThread(new Conversation.26.3(this, paramHashSet));
  }
  
  protected void onHideConversationMayKnowRecommend(boolean paramBoolean, Object paramObject)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onHideConversationMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      paramObject = (achg)this.this$0.app.getManager(159);
      paramObject.cJR();
      this.this$0.g.sendEmptyMessage(1009);
      paramBoolean = paramObject.kl("sp_mayknow_ml_s_a_vl");
      paramObject = this.this$0.app;
      if (paramBoolean) {}
      for (i = 2;; i = 1)
      {
        ContactReportUtils.c(paramObject, "msgtab_listhide_clk", 1, i);
        return;
      }
    }
    QQToast.a(BaseApplication.getContext(), acfp.m(2131704500), 0).show();
    paramBoolean = ((achg)this.this$0.app.getManager(159)).kl("sp_mayknow_ml_s_a_vl");
    paramObject = this.this$0.app;
    if (paramBoolean) {}
    for (;;)
    {
      ContactReportUtils.c(paramObject, "msgtab_listhide_clk", 0, i);
      return;
      i = 1;
    }
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.this$0.g.removeCallbacks(this.this$0.dO);
      this.this$0.g.postDelayed(this.this$0.dO, 1600L);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onMayknowStateChanged isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (((achg)this.this$0.app.getManager(159)).kl("sp_mayknow_ml_s_a_vl")))
    {
      this.this$0.g.sendEmptyMessage(1009);
      this.this$0.g.removeCallbacks(this.this$0.dO);
      this.this$0.g.postDelayed(this.this$0.dO, 1600L);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.this$0.h(1009, 500L, true);
    }
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap != null) {
        break label66;
      }
    }
    label66:
    for (int i = 0;; i = paramMap.size())
    {
      QLog.d("Q.recent", 2, i);
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break;
      }
      return;
    }
    Object localObject = (ProxyManager)this.this$0.app.getManager(18);
    label113:
    String str;
    if (localObject == null)
    {
      localObject = null;
      paramMap = paramMap.entrySet().iterator();
      if (!paramMap.hasNext()) {
        break label333;
      }
      str = (String)((Map.Entry)paramMap.next()).getKey();
      i = this.this$0.app.cs(str);
      if (i != 2) {
        break label315;
      }
      aizp.a().j(str, this.this$0.app);
    }
    for (;;)
    {
      if ((i == 3) && (localObject != null)) {}
      try
      {
        RecentUser localRecentUser = ((acxw)localObject).b(str, 1);
        if (localRecentUser != null)
        {
          ((acxw)localObject).f(localRecentUser);
          aajt.a().Av(localRecentUser.uin + "-" + localRecentUser.getType());
          ((acxw)localObject).f(localRecentUser);
          aalb.l(this.this$0.app, localRecentUser.uin, 1);
          this.this$0.app.b().ca(localRecentUser.uin, localRecentUser.getType());
        }
      }
      catch (Exception localException)
      {
        label290:
        break label290;
      }
      this.this$0.n(9, str, 1);
      break label113;
      localObject = ((ProxyManager)localObject).a();
      break;
      label315:
      aizp.a().l(str, this.this$0.app);
    }
    label333:
    this.this$0.n(9, acbn.bkz, 5000);
    this.this$0.n(9, acbn.blI, 5001);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " Conversation.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (!aqft.equalsWithNullCheck(paramString, this.this$0.app.getCurrentAccountUin()))
    {
      this.this$0.runOnUiThread(new Conversation.26.2(this, paramString));
      return;
    }
    this.this$0.a.mUiHandler.sendEmptyMessage(3);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatedelfriend");
      }
      this.this$0.fI(0L);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onUpdateFriendInfo uin = " + paramString + ", isSc = " + paramBoolean);
    }
    if (!paramBoolean) {}
    while (aqft.equalsWithNullCheck(paramString, this.this$0.app.getAccount())) {
      return;
    }
    this.this$0.fI(0L);
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatefriendlist");
      }
      this.this$0.fI(0L);
      this.this$0.runOnUiThread(new Conversation.26.1(this));
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if (paramBoolean) {
      this.this$0.runOnUiThread(new Conversation.26.5(this, paramArrayList));
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onUpdateOnlineFriend| isSuc = " + paramBoolean);
    }
    if (paramBoolean) {
      this.this$0.fI(0L);
    }
  }
  
  protected void onUpdateRecentList()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.this$0.fI(0L);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.this$0.runOnUiThread(new Conversation.26.4(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ush
 * JD-Core Version:    0.7.0.1
 */