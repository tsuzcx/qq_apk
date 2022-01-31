import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.BatchAddFriendData;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.os.MqqHandler;

public class vzs
  extends TroopObserver
{
  public vzs(TroopChatPie paramTroopChatPie) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 2) || (paramInt1 == 9))
    {
      if (paramInt2 == 0)
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, "已成功退出该群", 0).a();
        String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        TroopChatPie.a(this.a, paramString, str);
      }
    }
    else {
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, "操作失败", 0).a();
  }
  
  protected void a(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "onPushTroopEnterEffect: troopUin = " + paramTroopEnterEffectData.b + ", data.id = " + paramTroopEnterEffectData.jdField_a_of_type_Int);
    }
    if (AnonymousChatHelper.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "onPushTroopEnterEffect: troopUin = " + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " isAnonymous");
      }
      return;
    }
    paramTroopEnterEffectData = this.a.a();
    paramTroopEnterEffectData.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramTroopEnterEffectData.a();
  }
  
  protected void a(Boolean paramBoolean)
  {
    if ((TroopChatPie.c(this.a) != null) && (paramBoolean.booleanValue())) {
      TroopChatPie.d(this.a).a();
    }
  }
  
  protected void a(Boolean paramBoolean, ArrayList paramArrayList, List paramList)
  {
    if ((TroopChatPie.e(this.a) != null) && (paramBoolean.booleanValue())) {
      TroopChatPie.f(this.a).a();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
      this.a.d.setText(paramString2);
      if (AppSetting.b)
      {
        this.a.d.setContentDescription(paramString2);
        this.a.a().setTitle(paramString2);
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (paramTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramTroopInfo.troopuin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramTroopInfo.getTroopName();
      this.a.d.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.b)
      {
        paramTroopInfo = this.a.d.getText().toString();
        this.a.d.setContentDescription(paramTroopInfo);
        this.a.a().setTitle(this.a.d.getText());
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i("Q.aio.TroopChatPie", 2, localStringBuilder.toString());
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    ThreadManager.post(new vzt(this, paramList), 8, null, true);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    TroopChatPie.g(this.a).removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.a.c == null) || (!this.a.c.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      do
      {
        return;
        if (paramBoolean) {
          break label348;
        }
        i = 1;
        break;
        if ((this.a.c != null) && (MultiMsgManager.a().jdField_a_of_type_Int != 2)) {
          this.a.c.dismiss();
        }
        MultiMsgManager.a().b.clear();
        if ((paramBoolean) && (paramObject != null))
        {
          MultiMsgManager.a().b.putAll((Map)paramObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg", 4, "onBatchTroopCardDefaultNick = " + paramObject);
          }
        }
        while (MultiMsgManager.a().b.size() == 0)
        {
          QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131433424, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg", 4, "onBatchTroopCardDefaultNick failed");
          }
        }
      } while (paramObject == null);
      this.a.a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
      return;
      label348:
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      paramString = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString.getTroopName();
        this.a.d.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        if (AppSetting.b)
        {
          paramString = this.a.d.getText().toString();
          this.a.d.setContentDescription(paramString);
          this.a.a().setTitle(this.a.d.getText());
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, new Object[] { "onChangeGroupClassExt. oldClassExt=", Long.valueOf(paramLong1), ", newClassExt=", Long.valueOf(paramLong2) });
    }
    if (paramLong2 == 32L) {
      bool = true;
    }
    if (bool) {
      new SoLibraryChecker(this.a.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
    }
    if ((TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramBoolean) && (paramLong1 != paramLong2)) {
      TroopChatPie.a(this.a, bool, true);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie.troop.notification_center.auto_pull_down", 2, "onTroopNewFeedsAutoPullDown, isSuc:" + paramBoolean + "troopUin" + paramString1 + ",feedsId:" + paramString2 + ",flag:" + paramInt);
    }
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) {}
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4)
  {
    if (paramBoolean)
    {
      if (paramInt4 == 0)
      {
        AnonymousChatHelper.a().a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, null, paramString4);
        TroopChatPie.f(this.a).postDelayed(new vzv(this), 500L);
        return;
      }
      this.a.a(3, paramString3);
      return;
    }
    this.a.a(1, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430462));
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(paramString2, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (TroopInfo.isHomeworkTroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)))
    {
      if (!HWTroopUtils.a(paramInt)) {
        this.a.bq();
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.c(HWTroopUtils.b(paramInt));
      }
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, boolean paramBoolean2, HashMap paramHashMap)
  {
    if ((paramBoolean1) && (!paramBoolean2) && (TextUtils.equals(paramString1, this.a.a().jdField_a_of_type_JavaLangString)))
    {
      paramLong = PreferenceManager.getDefaultSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remark", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1 }), 0L);
      if ((paramLong == 0L) || (System.currentTimeMillis() - paramLong > 86400000L))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.aio.TroopChatPie", 4, "checkAddBAFGrayTip need execute data check! (Remark)");
        }
        new TroopBatchAddFriendMgr(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramString1);
      }
    }
    else
    {
      return;
    }
    BatchAddFriendData.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
  }
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (paramString1 == null)
      {
        str = "";
        QLog.d("Q.aio.TroopChatPie", 2, new Object[] { "onChangeTroopAIORedPoint. isSuc=", Boolean.valueOf(paramBoolean1), ", troopUin=", str, ", type = ", paramString2, ", from0x8c2=", Boolean.valueOf(paramBoolean2) });
      }
    }
    else {
      if ((paramBoolean1) && (!paramBoolean2)) {
        break label92;
      }
    }
    label92:
    while ((!TextUtils.equals(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!TroopInfo.isHomeworkTroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!String.valueOf(1104445552).equals(paramString2)))
    {
      return;
      str = paramString1;
      break;
    }
    TroopChatPie.a(this.a, false, new vzz(this));
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) || (!TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    Integer localInteger = ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((localInteger != null) && (-1 == localInteger.intValue())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onTroopNewFeedsComing, isSuc:" + paramBoolean1 + ", troopUin=" + paramString + ",bDeleted:" + paramBoolean2 + ", isFromPush=" + paramBoolean3 + ", hasNewNotify=" + bool);
      }
      if (paramBoolean3) {
        break;
      }
      TroopAioNotifyManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
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
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020))
      {
        int i = 0;
        if (i < paramArrayList.size())
        {
          TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
          if ((localTroopMemberCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localTroopMemberCardInfo.memberuin)))
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
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramArrayList;
          this.a.d.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (!AppSetting.b) {
            break;
          }
          paramArrayList = this.a.d.getText().toString();
          this.a.d.setContentDescription(paramArrayList);
          this.a.a().setTitle(this.a.d.getText());
          return;
          i += 1;
          break label50;
          break label15;
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, new Object[] { "onUpdateTroopUnreadMsg. isSuc=", Boolean.valueOf(paramBoolean1), ", isPush=", Boolean.valueOf(paramBoolean2) });
    }
    if ((!paramBoolean1) || (paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopUnreadMsgInfo localTroopUnreadMsgInfo = (TroopUnreadMsgInfo)paramList.next();
        if (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString)) {
          if (localTroopUnreadMsgInfo.jdField_a_of_type_Long == 1104445552L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.TroopChatPie", 2, new Object[] { "onUpdateTroopUnreadMsg homework. num=", Integer.valueOf(localTroopUnreadMsgInfo.b) });
            }
            if (TroopInfo.isHomeworkTroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              TroopChatPie.a(this.a, false, new vzu(this));
            }
          }
          else if (localTroopUnreadMsgInfo.jdField_a_of_type_Long == 1106611799L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.TroopChatPie", 2, "receive game feed red dot, push=" + paramBoolean2 + ", num=" + localTroopUnreadMsgInfo.b);
            }
            Message localMessage = TroopChatPie.c(this.a).obtainMessage(86);
            localMessage.arg1 = localTroopUnreadMsgInfo.b;
            localMessage.sendToTarget();
          }
        }
      }
    }
  }
  
  protected void b()
  {
    this.a.bp();
  }
  
  protected void b(Boolean paramBoolean)
  {
    if ((TroopChatPie.g(this.a) != null) && (paramBoolean.booleanValue())) {
      TroopChatPie.h(this.a).a();
    }
  }
  
  protected void b(String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) && (!TroopChatPie.a(this.a))) {
      this.a.b(1);
    }
  }
  
  protected void b(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1))
    {
      List localList = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      int i = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int j = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      paramString1 = ((TroopRewardMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151)).a(paramString1, paramString2);
      if (paramString1 != null)
      {
        int k = localList.indexOf(paramString1);
        if ((k >= i) && (k <= j)) {
          this.a.b(131076);
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    this.a.a(paramBoolean, paramObject);
  }
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    TroopOnlineMemberManager localTroopOnlineMemberManager;
    if (TextUtils.equals(paramString1, this.a.a().jdField_a_of_type_JavaLangString))
    {
      localTroopOnlineMemberManager = (TroopOnlineMemberManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233);
      if ((!this.a.Q) && (!TextUtils.isEmpty(paramString2)))
      {
        if (this.a.p != 2)
        {
          this.a.v(2);
          new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { this.a.a().jdField_a_of_type_JavaLangString }).a();
        }
        this.a.b(true);
        TroopChatPie.a(this.a).setText(paramString2);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar == null) {
          break label316;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(paramString1);
        if (!this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a()) {
          break label305;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.d();
        this.a.o(true);
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()))
      {
        long l = (localTroopOnlineMemberManager.b(this.a.a().jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime()) * 1000L;
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.TroopChatPie", 2, "mGetOnlineMemberTipsRunnable, delay = " + l);
        }
        ThreadManager.getSubThreadHandler().postDelayed(TroopChatPie.a(this.a), l);
      }
      return;
      label305:
      this.a.o(false);
      continue;
      label316:
      this.a.o(false);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString2)) && (paramInt == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: cmd==1," + paramBoolean + "," + paramString1 + "," + paramString2 + "," + this.a.n);
      }
      if (!paramBoolean) {
        break label191;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_history", 0, 0, paramString1, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: pullRecentGroupMsg");
      }
    }
    label191:
    while (this.a.n <= 0) {
      return;
    }
    this.a.x(1);
    paramString1 = this.a;
    paramString1.n -= 1;
  }
  
  protected void b(boolean paramBoolean, String paramString, List paramList)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null);
      bool1 = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
      bool2 = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d();
      int j = 0;
      int i = j;
      if (paramList != null)
      {
        i = j;
        if (paramList.size() > 0)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramList);
          i = j;
          if (!bool2)
          {
            i = j;
            if (!bool1)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
              i = 1;
            }
          }
        }
      }
      bool3 = TroopInfo.isQidianPrivateTroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((!bool1) && (!bool2) && (i == 0) && (!bool3)) {
        ThreadManager.getUIHandler().postDelayed(new vzy(this), 500L);
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
  
  protected void c(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 0);
    boolean bool = localSharedPreferences.getBoolean("HomeworkIcon_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    if (!TextUtils.isEmpty(paramString)) {
      i = 1;
    }
    if (((bool) && (i == 0)) || ((!bool) && (i != 0)))
    {
      if (i != 0) {
        break label149;
      }
      localSharedPreferences.edit().remove("HomeworkIcon_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).commit();
    }
    for (;;)
    {
      if (TroopChatPie.a(this.a) != null) {
        TroopChatPie.b(this.a).a();
      }
      return;
      label149:
      localSharedPreferences.edit().putBoolean("HomeworkIcon_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).commit();
    }
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
        TroopChatPie.a(this.a);
      }
    }
  }
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.equals(paramString1, this.a.a().jdField_a_of_type_JavaLangString)) && (!this.a.Q) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!paramBoolean) {
        this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(2);
      }
    }
    else {
      return;
    }
    this.a.b(true);
    TroopChatPie.b(this.a).setText(paramString2);
    if (this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(paramString1);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a())
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.d();
        this.a.o(true);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(0);
      this.a.o(false);
      return;
    }
    this.a.o(false);
  }
  
  protected void d(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramString = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramString);
      if (paramString != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString.getTroopName();
        Intent localIntent = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
        localIntent.putExtra("uinname", paramString.getTroopName());
        this.a.b(localIntent);
        this.a.bp();
        TroopChatPie.a(this.a, TroopInfo.isHomeworkTroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), true);
        TroopChatPie.b(this.a);
      }
    }
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.a().jdField_a_of_type_JavaLangString)))
    {
      long l = PreferenceManager.getDefaultSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString }), 0L);
      if ((l == 0L) || (System.currentTimeMillis() - l > 86400000L))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.aio.TroopChatPie", 4, "checkAddBAFGrayTip need execute data check!");
        }
        ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).t(paramString);
      }
    }
    else
    {
      return;
    }
    BatchAddFriendData.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  protected void e(boolean paramBoolean, String paramString)
  {
    if (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      TroopChatPie.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vzs
 * JD-Core Version:    0.7.0.1
 */