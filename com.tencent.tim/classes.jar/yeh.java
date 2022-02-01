import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.1;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.2;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.3;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.Result;

public class yeh
  extends acnd
{
  public yeh(TroopChatPie paramTroopChatPie) {}
  
  protected void H(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.this$0.sessionInfo.cZ == 1) && (this.this$0.sessionInfo.aTl.equals(paramString)))
    {
      paramString = ((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.sessionInfo.aTl);
      if (paramString != null)
      {
        this.this$0.sessionInfo.aTn = paramString.getTroopName();
        this.this$0.mTitleText.setText(this.this$0.sessionInfo.aTn);
        if (AppSetting.enableTalkBack)
        {
          paramString = this.this$0.mTitleText.getText().toString();
          this.this$0.mTitleText.setContentDescription(paramString);
          this.this$0.a().setTitle(this.this$0.mTitleText.getText());
        }
      }
    }
  }
  
  protected void J(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      if ((this.this$0.sessionInfo != null) && (this.this$0.sessionInfo.aTl.equals(String.valueOf(l)))) {
        this.this$0.bGT();
      }
    }
  }
  
  protected void a(apdj.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onPushTroopEnterEffect: troopUin = " + parama.troopUin + ", data.id = " + parama.id);
    }
    if (jof.a().dd(this.this$0.sessionInfo.aTl))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onPushTroopEnterEffect: troopUin = " + this.this$0.sessionInfo.aTl + " isAnonymous");
      }
      return;
    }
    parama = this.this$0.a();
    parama.yJ(this.this$0.sessionInfo.aTl);
    parama.dYL();
  }
  
  protected void a(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList)
  {
    paramArrayList = (PlusPanel)TroopChatPie.d(this.this$0).B(8);
    if ((paramArrayList != null) && (paramBoolean.booleanValue())) {
      paramArrayList.reload();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if ((paramBoolean) && (this.this$0.sessionInfo.cZ == 1) && (paramTroopInfo != null) && (this.this$0.sessionInfo.aTl.equals(paramTroopInfo.troopuin)))
    {
      this.this$0.sessionInfo.aTn = paramTroopInfo.getTroopName();
      this.this$0.mTitleText.setText(this.this$0.sessionInfo.aTn);
      if (AppSetting.enableTalkBack)
      {
        paramTroopInfo = this.this$0.mTitleText.getText().toString();
        this.this$0.mTitleText.setContentDescription(paramTroopInfo);
        this.this$0.a().setTitle(this.this$0.mTitleText.getText());
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!aqft.equalsWithNullCheck(String.valueOf(paramLong1), this.this$0.sessionInfo.aTl)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i(this.this$0.TAG, 2, localStringBuilder.toString());
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    ThreadManager.post(new TroopChatPie.12.1(this, paramList), 8, null, true);
  }
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    paramString = (PlusPanel)TroopChatPie.a(this.this$0).B(8);
    if ((paramString != null) && (paramTroopInfo != null) && (paramTroopInfo.troopuin.equals(this.this$0.sessionInfo.aTl))) {
      paramString.yD(true);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject = this.this$0.mActivity.getIntent().getStringExtra("uin");
    QLog.i(this.this$0.TAG, 1, String.format("troopBatchAddFrd.onTroopBatchAddFrdsReadyForTip suc_troopUin_type_intentUIn=%b_%s_%d_%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt), localObject }));
    if ((paramBoolean) && (apwn.ml(paramInt)) && (paramString.equalsIgnoreCase((String)localObject)))
    {
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 5)) {
        break label129;
      }
      paramList = (wxf)this.this$0.a(28);
      if (paramList != null) {
        paramList.ae(true, paramString);
      }
    }
    for (;;)
    {
      return;
      label129:
      if ((paramInt == 4) && (paramList != null) && (paramList.size() > 0))
      {
        if (!this.this$0.isScrolling)
        {
          localObject = (String)paramList.get(0);
          paramBoolean = this.this$0.hV((String)localObject);
          localObject = (wxf)this.this$0.a(28);
          if (localObject != null) {
            ((wxf)localObject).ae(paramBoolean, paramString);
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d(this.this$0.TAG, 2, "onTroopBatchAddFrdsReadyForTip  isScrolling = " + this.this$0.isScrolling + ",visible = " + paramBoolean + ",targetUins = " + paramList);
          return;
          this.this$0.aXo = ((String)paramList.get(0));
          paramBoolean = false;
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, new Object[] { "onChangeGroupClassExt. oldClassExt=", Long.valueOf(paramLong1), ", newClassExt=", Long.valueOf(paramLong2) });
    }
    if (paramLong2 == 32L) {
      i = 1;
    }
    if (i != 0) {
      new apke(this.this$0.mContext, "3171", "libWXVoice.so", "WXVoice").execute();
    }
    if ((TextUtils.equals(paramString, this.this$0.sessionInfo.aTl)) && (paramBoolean) && (paramLong1 != paramLong2) && (TroopChatPie.a(this.this$0) != null)) {
      TroopChatPie.a(this.this$0).a(paramLong2, true, this.this$0, paramString);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG + ".troop.notification_center.auto_pull_down", 2, "onTroopNewFeedsAutoPullDown, isSuc:" + paramBoolean + "troopUin" + paramString1 + ",feedsId:" + paramString2 + ",flag:" + paramInt);
    }
    if (!this.this$0.sessionInfo.aTl.equals(paramString1)) {}
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4)
  {
    if (paramBoolean)
    {
      if (paramInt4 == 0)
      {
        jof.a().a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, null, paramString4);
        TroopChatPie.f(this.this$0).postDelayed(new TroopChatPie.12.2(this), 500L);
        return;
      }
      this.this$0.br(3, paramString3);
      return;
    }
    this.this$0.br(1, this.this$0.mActivity.getResources().getString(2131690312));
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, this.this$0.sessionInfo.aTl)) && (TextUtils.equals(paramString2, this.this$0.app.getCurrentAccountUin())) && (TroopInfo.isHomeworkTroop(this.this$0.app, paramString1)))
    {
      if ((!apqz.mf(paramInt)) && (TroopChatPie.a(this.this$0) != null) && ((TroopChatPie.a(this.this$0).a instanceof apml))) {
        ((apml)TroopChatPie.a(this.this$0).a).f(this.this$0);
      }
      if (TroopChatPie.a(this.this$0) != null) {
        TroopChatPie.a(this.this$0).WH(paramInt);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    String str1;
    if (QLog.isColorLevel())
    {
      String str2 = this.this$0.TAG;
      if (paramString1 == null)
      {
        str1 = "";
        QLog.d(str2, 2, new Object[] { "onChangeTroopAIORedPoint. isSuc=", Boolean.valueOf(paramBoolean1), ", troopUin=", str1, ", type = ", paramString2, ", from0x8c2=", Boolean.valueOf(paramBoolean2) });
      }
    }
    else
    {
      if ((paramBoolean1) && (!paramBoolean2)) {
        break label101;
      }
    }
    label101:
    while ((!TextUtils.equals(paramString1, this.this$0.sessionInfo.aTl)) || (!TroopInfo.isHomeworkTroop(this.this$0.app, this.this$0.sessionInfo.aTl)) || (!String.valueOf(1104445552).equals(paramString2)) || (TroopChatPie.a(this.this$0) == null) || (!(TroopChatPie.a(this.this$0).a instanceof apml)))
    {
      return;
      str1 = paramString1;
      break;
    }
    ((apml)TroopChatPie.a(this.this$0).a).a(false, this.this$0);
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) || (!TextUtils.equals(paramString, this.this$0.sessionInfo.aTl))) {
      return;
    }
    Integer localInteger = ChatActivityUtils.a(this.this$0.sessionInfo.aTl, this.this$0.app.getCurrentAccountUin());
    if ((localInteger != null) && (-1 == localInteger.intValue())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onTroopNewFeedsComing, isSuc:" + paramBoolean1 + ", troopUin=" + paramString + ",bDeleted:" + paramBoolean2 + ", isFromPush=" + paramBoolean3 + ", hasNewNotify=" + bool);
      }
      if (paramBoolean3) {
        break;
      }
      apro.aV(this.this$0.app, this.this$0.sessionInfo.aTl);
      return;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<apyk> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, new Object[] { "onUpdateTroopUnreadMsg. isSuc=", Boolean.valueOf(paramBoolean1), ", isPush=", Boolean.valueOf(paramBoolean2) });
    }
    if ((!paramBoolean1) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    label421:
    for (;;)
    {
      label72:
      apyk localapyk;
      if (paramList.hasNext())
      {
        localapyk = (apyk)paramList.next();
        if (!TextUtils.equals(this.this$0.sessionInfo.aTl, localapyk.troopuin)) {
          continue;
        }
        if (localapyk.appid == 1104445552L)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.TAG, 2, new Object[] { "onUpdateTroopUnreadMsg homework. num=", Integer.valueOf(localapyk.dXV) });
          }
          if (!TroopInfo.isHomeworkTroop(this.this$0.app, this.this$0.sessionInfo.aTl)) {
            break label328;
          }
          if ((TroopChatPie.a(this.this$0) != null) && ((TroopChatPie.a(this.this$0).a instanceof apml))) {
            ((apml)TroopChatPie.a(this.this$0).a).a(false, this.this$0);
          }
        }
      }
      for (;;)
      {
        if (localapyk.appid != 2L) {
          break label421;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "receive troop album  red dot, push=" + paramBoolean2 + ", num=" + localapyk.dXV);
        }
        Message localMessage = TroopChatPie.c(this.this$0).obtainMessage(85);
        localMessage.arg1 = localapyk.dXV;
        localMessage.sendToTarget();
        break label72;
        break;
        label328:
        if (localapyk.appid == 1106611799L)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.TAG, 2, "receive game feed red dot, push=" + paramBoolean2 + ", num=" + localapyk.dXV);
          }
          localMessage = TroopChatPie.b(this.this$0).obtainMessage(85);
          localMessage.arg1 = localapyk.dXV;
          localMessage.sendToTarget();
        }
      }
    }
  }
  
  protected void ai(boolean paramBoolean, String paramString)
  {
    if (TextUtils.equals(paramString, this.this$0.sessionInfo.aTl)) {
      TroopChatPie.c(this.this$0);
    }
  }
  
  protected void bb(String paramString, boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.this$0.sessionInfo.aTl.equals(paramString1)) && (this.this$0.app.getCurrentAccountUin().equals(paramString2)) && (paramInt1 == 1) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: cmd==1," + paramBoolean + "," + paramString1 + "," + paramString2 + "," + this.this$0.bYJ);
      }
      if (!paramBoolean) {
        break label196;
      }
      this.this$0.app.b().gW(this.this$0.sessionInfo.aTl);
      anot.a(this.this$0.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_history", 0, 0, paramString1, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: pullRecentGroupMsg");
      }
    }
    label196:
    while (this.this$0.bYJ <= 0) {
      return;
    }
    this.this$0.DR(1);
    paramString1 = this.this$0;
    paramString1.bYJ -= 1;
  }
  
  protected void c(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      break label15;
    }
    label15:
    label50:
    label226:
    label227:
    for (;;)
    {
      return;
      if ((this.this$0.sessionInfo.cZ == 1000) || (this.this$0.sessionInfo.cZ == 1020))
      {
        int i = 0;
        if (i < paramArrayList.size())
        {
          TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
          if ((localTroopMemberCardInfo != null) && (this.this$0.sessionInfo.aTl.equals(localTroopMemberCardInfo.memberuin)))
          {
            paramArrayList = localTroopMemberCardInfo.name;
            if ((paramArrayList != null) && (!"".equals(paramArrayList))) {
              break label226;
            }
            paramArrayList = localTroopMemberCardInfo.nick;
          }
        }
        for (;;)
        {
          if ((paramArrayList == null) || ("".equals(paramArrayList))) {
            break label227;
          }
          this.this$0.sessionInfo.aTn = paramArrayList;
          this.this$0.mTitleText.setText(this.this$0.sessionInfo.aTn);
          if (!AppSetting.enableTalkBack) {
            break;
          }
          paramArrayList = this.this$0.mTitleText.getText().toString();
          this.this$0.mTitleText.setContentDescription(paramArrayList);
          this.this$0.a().setTitle(this.this$0.mTitleText.getText());
          return;
          i += 1;
          break label50;
          break label15;
        }
      }
    }
  }
  
  protected void cG(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.this$0.sessionInfo.aTl)))
    {
      this.this$0.bGZ();
      this.this$0.bGT();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, String.format("onPassiveExit, troopUin: %s, reason: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
  }
  
  protected void chP()
  {
    this.this$0.chH();
    if ((TroopChatPie.a(this.this$0) != null) && (TroopChatPie.b(this.this$0).a() != null)) {
      TroopChatPie.c(this.this$0).a().bzz();
    }
  }
  
  protected void d(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList)
  {
    if (!this.this$0.sessionInfo.aTl.equals(paramString)) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_Apat == null);
      bool1 = this.this$0.jdField_a_of_type_Apat.aAL();
      bool2 = this.this$0.jdField_a_of_type_Apat.aAN();
      int j = 0;
      int i = j;
      if (paramList != null)
      {
        i = j;
        if (paramList.size() > 0)
        {
          this.this$0.jdField_a_of_type_Apat.mL(paramList);
          i = j;
          if (!bool2)
          {
            i = j;
            if (!bool1)
            {
              this.this$0.jdField_a_of_type_Apat.dYt();
              i = 1;
            }
          }
        }
      }
      bool3 = TroopInfo.isQidianPrivateTroop(this.this$0.app, this.this$0.sessionInfo.aTl);
      if ((!bool1) && (!bool2) && (i == 0) && (!bool3)) {
        ThreadManager.getUIHandler().postDelayed(new TroopChatPie.12.3(this), 500L);
      }
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopAioNotifyFeeds, isSucc=").append(paramBoolean).append(", troopUin=").append(paramString).append(", size=");
    if (paramList == null) {}
    for (paramString = " ";; paramString = Integer.valueOf(paramList.size()))
    {
      QLog.d(".troop.notify_feeds.aio", 2, paramString + ", isMsgBarNeedShow=" + bool1 + ", hasMsgBar=" + bool2 + ", isQidianPrivateTroop=" + bool3);
      return;
    }
  }
  
  protected void dG(String paramString1, String paramString2)
  {
    if (this.this$0.sessionInfo.aTl.equals(paramString1))
    {
      List localList = this.this$0.jdField_a_of_type_Wki.getList();
      int i = this.this$0.b.getFirstVisiblePosition();
      int j = this.this$0.b.getLastVisiblePosition();
      paramString1 = ((apts)this.this$0.app.getManager(152)).a(paramString1, paramString2);
      if (paramString1 != null)
      {
        int k = localList.indexOf(paramString1);
        if ((k >= i) && (k <= j)) {
          this.this$0.refresh(131077);
        }
      }
    }
  }
  
  protected void di(String paramString1, String paramString2)
  {
    if ((this.this$0.sessionInfo.cZ == 1) && (this.this$0.sessionInfo.aTl.equals(paramString1)))
    {
      this.this$0.sessionInfo.aTn = paramString2;
      this.this$0.mTitleText.setText(paramString2);
      if (AppSetting.enableTalkBack)
      {
        this.this$0.mTitleText.setContentDescription(paramString2);
        this.this$0.a().setTitle(paramString2);
      }
    }
  }
  
  protected void eE(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 9) && (this.this$0.bma)) {
      QQToast.a(this.this$0.mActivity, 1, acfp.m(2131715623), 0).show();
    }
  }
  
  protected void h(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopChatPie.b(this.this$0);
    }
  }
  
  protected void i(Boolean paramBoolean)
  {
    if (((PlusPanel)TroopChatPie.c(this.this$0).B(8) != null) && (paramBoolean.booleanValue())) {}
  }
  
  protected void j(Boolean paramBoolean)
  {
    PlusPanel localPlusPanel = (PlusPanel)TroopChatPie.e(this.this$0).B(8);
    if ((localPlusPanel != null) && (paramBoolean.booleanValue())) {
      localPlusPanel.reload();
    }
  }
  
  protected void l(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopChatPie.b(this.this$0);
    }
  }
  
  protected void onUpdateRecentList()
  {
    TroopChatPie.d(this.this$0);
  }
  
  protected void p(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, this.this$0.a().aTl))
    {
      paramString2 = (apys)this.this$0.app.getManager(234);
      TroopChatPie.a(this.this$0, paramString1, true);
      if ((paramBoolean) && (this.this$0.mActivity != null) && (this.this$0.mActivity.isResume()))
      {
        long l = (paramString2.aU(this.this$0.a().aTl) - NetConnInfoCenter.getServerTime()) * 1000L;
        if (QLog.isColorLevel()) {
          QLog.i(this.this$0.TAG, 2, "mGetOnlineMemberTipsRunnable, delay = " + l);
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(TroopChatPie.a(this.this$0));
        ThreadManager.getUIHandler().post(new TroopChatPie.12.4(this, l));
      }
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 2) || (paramInt1 == 9))
    {
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "onTroopManagerSuccess, isTroopOwner =" + this.this$0.bma);
        }
        String str = acfp.m(2131715628);
        if (this.this$0.bma) {
          str = acfp.m(2131715626);
        }
        QQToast.a(this.this$0.mActivity, 2, str, 0).show();
        str = this.this$0.app.getCurrentUin();
        TroopChatPie.a(this.this$0, paramString, str);
        ((acms)this.this$0.app.getBusinessHandler(20)).a().TE(this.this$0.sessionInfo.aTl);
      }
    }
    else {
      return;
    }
    QQToast.a(this.this$0.mActivity, 1, acfp.m(2131715621), 0).show();
  }
  
  protected void q(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.this$0.aSY) || (this.this$0.jdField_a_of_type_Apyl == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (!TextUtils.equals(paramString1, this.this$0.a().aTl));
      bool1 = ((aiqk)this.this$0.a(33)).apu();
      bool2 = ((wxc)this.this$0.a(43)).Sl();
    } while ((this.this$0.aaR) || (bool1) || (bool2));
    if (!paramBoolean)
    {
      this.this$0.jdField_a_of_type_Apyl.show(2);
      return;
    }
    paramString2 = ((apys)this.this$0.app.getManager(234)).oU(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.this$0.vU(true);
      this.this$0.Cu.setText(paramString2);
    }
    if (this.this$0.jdField_a_of_type_Apyl != null)
    {
      this.this$0.jdField_a_of_type_Apyl.yJ(paramString1);
      if (this.this$0.jdField_a_of_type_Apyl.isShowing())
      {
        this.this$0.jdField_a_of_type_Apyl.update();
        TroopChatPie.a(this.this$0, true);
        return;
      }
      this.this$0.jdField_a_of_type_Apyl.show(0);
      TroopChatPie.a(this.this$0, false);
      return;
    }
    TroopChatPie.a(this.this$0, false);
  }
  
  protected void u(boolean paramBoolean, Object paramObject)
  {
    TroopChatPie.g(this.this$0).removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.this$0.jdField_a_of_type_Arhz == null) || (!this.this$0.jdField_a_of_type_Arhz.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", aqiw.getSystemNetwork(BaseApplication.getContext()) + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.this$0.app.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      do
      {
        return;
        if (paramBoolean) {
          break label405;
        }
        i = 1;
        break;
        if ((this.this$0.jdField_a_of_type_Arhz != null) && (ajlc.a().djF != 2)) {
          this.this$0.jdField_a_of_type_Arhz.dismiss();
        }
        ajlc.a().lD.clear();
        if ((paramBoolean) && (paramObject != null))
        {
          ajlc.a().lD.putAll((Map)paramObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + paramObject);
          }
        }
        while (ajlc.a().lD.size() == 0)
        {
          QQToast.a(this.this$0.mActivity, 2131700605, 0).show(this.this$0.mActivity.getTitleBarHeight());
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
          }
        }
      } while (paramObject == null);
      if (ajlc.a().djF == 6)
      {
        ((wvy)TroopChatPie.a(this.this$0).a(11)).a((Map)paramObject, ajlc.a().xL, ajlc.a().djF);
        return;
      }
      ((wwb)TroopChatPie.b(this.this$0).a(1)).b((Map)paramObject, ajlc.a().xL, ajlc.a().djF);
      return;
      label405:
      i = 0;
    }
  }
  
  protected void v(boolean paramBoolean, Object paramObject)
  {
    this.this$0.I(paramBoolean, paramObject);
  }
  
  protected void wK(String paramString)
  {
    if ((this.this$0.sessionInfo.aTl.equals(paramString)) && (!this.this$0.aSY)) {
      this.this$0.fV(1);
    }
  }
  
  protected void yA(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.this$0.sessionInfo.aTl)))
    {
      paramString = ((TroopManager)this.this$0.app.getManager(52)).c(paramString);
      if (paramString != null)
      {
        this.this$0.sessionInfo.aTn = paramString.getTroopName();
        Intent localIntent = this.this$0.mActivity.getIntent();
        localIntent.putExtra("uinname", paramString.getTroopName());
        this.this$0.bo(localIntent);
        this.this$0.chH();
        if (TroopChatPie.a(this.this$0) != null) {
          TroopChatPie.a(this.this$0).a(paramString.dwGroupClassExt, true, this.this$0, this.this$0.sessionInfo.aTl);
        }
        TroopChatPie.c(this.this$0);
        TroopChatPie.d(this.this$0);
      }
    }
  }
  
  protected void yB(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.this$0.sessionInfo.aTl))) {
      this.this$0.bGZ();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, String.format("onAddTroopSuccess, troopUin: %s", new Object[] { paramString }));
    }
  }
  
  protected void yz(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 0);
    boolean bool = localSharedPreferences.getBoolean("HomeworkIcon_" + this.this$0.sessionInfo.aTl, false);
    if (!TextUtils.isEmpty(paramString)) {
      i = 1;
    }
    if (((bool) && (i == 0)) || ((!bool) && (i != 0)))
    {
      if (i != 0) {
        break label153;
      }
      localSharedPreferences.edit().remove("HomeworkIcon_" + this.this$0.sessionInfo.aTl).commit();
    }
    for (;;)
    {
      paramString = (PlusPanel)TroopChatPie.b(this.this$0).B(8);
      if (paramString != null) {
        paramString.reload();
      }
      return;
      label153:
      localSharedPreferences.edit().putBoolean("HomeworkIcon_" + this.this$0.sessionInfo.aTl, true).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yeh
 * JD-Core Version:    0.7.0.1
 */