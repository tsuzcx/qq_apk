package com.tencent.mobileqq.activity.recent;

import MessageSvcPack.UinPairReadInfo;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public final class RecentUtil
{
  public static final int a = 0;
  public static boolean a = false;
  public static final int b = 1;
  public static boolean b = false;
  public static final int c = 2;
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    int m = 0;
    if ((paramRecentUser == null) || (paramActivity == null) || (paramQQAppInterface == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser + "," + paramActivity + "," + paramQQAppInterface + "]");
      }
      j = 0;
      return j;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser.uin + "," + paramRecentUser.type + "]");
    }
    boolean bool = false;
    if (((paramRecentUser.uin != null) && (paramRecentUser.uin.length() == 4)) || (AppConstants.aa.equals(paramRecentUser.uin))) {
      bool = a(paramQQAppInterface, paramActivity, paramRecentUser);
    }
    if (!bool) {
      if (paramRecentUser.type == 8999) {
        i = 0;
      }
    }
    for (;;)
    {
      if (paramRecentUser.msgType == 3)
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
        return i;
        if ((paramRecentUser.type == 1000) || (paramRecentUser.type == 1020) || (paramRecentUser.type == 1004))
        {
          if (a(paramQQAppInterface, paramRecentUser.uin))
          {
            paramRecentUser.type = 0;
            i = m;
            if (paramBoolean) {
              i = 2;
            }
            j = i | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString);
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.recent", 2, "from_enterchat");
              i = j;
            }
          }
          else
          {
            if ((paramRecentUser.troopUin == null) || (paramRecentUser.troopUin.trim().length() == 0))
            {
              RecentUser localRecentUser = paramQQAppInterface.a().a().b(paramRecentUser.uin, 1);
              if (localRecentUser != null) {
                paramRecentUser.troopUin = localRecentUser.troopUin;
              }
            }
            a(paramActivity, paramRecentUser.uin, paramRecentUser.troopUin, paramRecentUser.type, paramString);
            i = 0;
          }
        }
        else if ((paramRecentUser.type == 1005) || (paramRecentUser.type == 1023))
        {
          i = j;
          if (a(paramQQAppInterface, paramRecentUser.uin))
          {
            paramRecentUser.type = 0;
            i = j;
            if (paramBoolean) {
              i = 2;
            }
          }
          i |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString);
        }
        else if (paramRecentUser.type == 1024)
        {
          i = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString);
        }
        else if (a(paramQQAppInterface, paramRecentUser.uin))
        {
          i = k;
          if (1 != paramRecentUser.type)
          {
            i = k;
            if (3000 != paramRecentUser.type)
            {
              i = k;
              if (paramRecentUser.type != 0)
              {
                paramRecentUser.type = 0;
                i = k;
                if (paramBoolean) {
                  i = 2;
                }
              }
            }
          }
          i |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString);
        }
        else
        {
          i = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString);
        }
      }
      else
      {
        j = i;
        if (paramRecentUser.msgType != 4) {
          break;
        }
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, paramRecentUser.uin, "", "", "");
        return i;
      }
    }
  }
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    StartupTracker.a(null, "Recent_clk_enterchat");
    Intent localIntent = new Intent(paramActivity, ChatActivity.class);
    localIntent.addFlags(67108864);
    if (paramInt == 3000) {}
    do
    {
      for (;;)
      {
        StartupTracker.a("Recent_clk_enterchat_troop", null);
        localIntent.putExtra("uin", paramString1);
        localIntent.putExtra("uintype", paramInt);
        localIntent.putExtra("uinname", paramString2);
        localIntent.putExtra("entrance", 1);
        a(localIntent);
        paramActivity.startActivity(localIntent);
        StartupTracker.a("Recent_clk_enterchat", null);
        return 1;
        if ((paramInt != 0) && (paramInt != 1024)) {
          break;
        }
        if ((paramInt == 1024) || (CrmUtils.c(paramQQAppInterface, paramString1)))
        {
          StartupTracker.a(null, "Recent_clk_enterchat_cmr");
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
          localIntent.setClass(paramActivity, ChatActivity.class);
          StartupTracker.a("Recent_clk_enterchat_cmr", null);
        }
      }
    } while (paramInt != 1);
    StartupTracker.a(null, "Recent_clk_enterchat_troop");
    Object localObject = (FriendManager)paramQQAppInterface.getManager(8);
    if (localObject != null)
    {
      if (!((FriendManager)localObject).f(paramString1)) {
        break label285;
      }
      localObject = ((FriendManager)localObject).a(paramString1);
      if (localObject != null) {
        localIntent.putExtra("troop_uin", ((OpenTroopInfo)localObject).troopUin);
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Open_group", "Clk_open_group", 22, 0, paramString1, "", "", "");
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
      break;
      label285:
      localObject = ((FriendManager)localObject).a(paramString1 + "");
      if ((localObject != null) && (((TroopInfo)localObject).troopcode != null)) {
        localIntent.putExtra("troop_uin", ((TroopInfo)localObject).troopcode);
      }
    }
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(paramActivity, ChatActivity.class);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString3);
      a(localIntent);
      localIntent.addFlags(67108864);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (a)
    {
      paramIntent.putExtra("aio_msg_source", 1);
      a = false;
      return;
    }
    paramIntent.putExtra("aio_msg_source", 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.type == 5000) {}
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      return;
      if (paramRecentUser.type == 7200) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
      } else if ((paramRecentUser.type == 1001) && (AppConstants.Z.equals(paramRecentUser.uin))) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
      } else if ((paramRecentUser.type == 1009) && (AppConstants.S.equals(paramRecentUser.uin))) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A4", "0X80041A4", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean)
  {
    int j = 0;
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label117:
    do
    {
      return;
      Object localObject;
      if (paramBoolean)
      {
        localObject = new SessionInfo();
        ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramRecentUser.uin;
        ((SessionInfo)localObject).b = paramRecentUser.uin;
        ((SessionInfo)localObject).jdField_a_of_type_Int = paramRecentUser.type;
        if (((SessionInfo)localObject).jdField_a_of_type_Int == 1006) {
          ((SessionInfo)localObject).f = ContactUtils.d(paramQQAppInterface, ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
        }
        ChatActivityFacade.a(paramQQAppInterface, (SessionInfo)localObject);
      }
      int i;
      if (MsgProxyUtils.a(paramRecentUser.uin, paramRecentUser.type))
      {
        ((MessageHandler)paramQQAppInterface.a(0)).b(paramRecentUser.uin, paramRecentUser.type);
        if ((paramRecentUser.type == 0) && (AppConstants.Y.equals(paramRecentUser.uin))) {
          SystemMsgController.a().a(paramQQAppInterface, true);
        }
        if (paramRecentUser.type != 5000) {
          break label265;
        }
        paramRecentUser = TroopAssistantManager.a().a(paramQQAppInterface);
        if (paramRecentUser != null) {
          break label220;
        }
        i = 0;
        if (j >= i) {
          break label228;
        }
        localObject = (TroopAssistantData)paramRecentUser.get(j);
        if (localObject != null) {
          break label230;
        }
      }
      for (;;)
      {
        j += 1;
        break label169;
        paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.type);
        break label117;
        i = paramRecentUser.size();
        break label169;
        break;
        localObject = paramQQAppInterface.a().a(((TroopAssistantData)localObject).troopUin, 1);
        if (localObject != null) {
          TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject).time);
        }
      }
      if (String.valueOf(9995L).equals(paramRecentUser.uin))
      {
        ((NewFriendManager)paramQQAppInterface.getManager(31)).f();
        return;
      }
    } while (!String.valueOf(9980L).equals(paramRecentUser.uin));
    label169:
    label220:
    label228:
    label230:
    paramQQAppInterface.a().a().c();
    label265:
    GroupSystemMsgController.a().a(paramQQAppInterface, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    label8:
    long l2;
    do
    {
      do
      {
        do
        {
          break label8;
          break label8;
          do
          {
            return;
          } while (paramQQAppInterface.a().a(paramString, paramInt) <= 0);
          l2 = paramQQAppInterface.a().b(paramString, paramInt);
          if (paramInt != 1) {
            break;
          }
        } while (l2 == -1L);
        if (QLog.isColorLevel()) {
          QLog.d("sendGroupMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l2);
        }
        ((TroopMessageProcessor)paramQQAppInterface.a().a("troop_processor")).a(Long.valueOf(paramString).longValue(), l2);
        if (paramInt != 3000) {
          break;
        }
      } while (l2 == -1L);
      if (QLog.isColorLevel()) {
        QLog.d("sendDisMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l2);
      }
      ((DiscMessageProcessor)paramQQAppInterface.a().a("disc_processor")).a(Long.valueOf(paramString).longValue(), l2);
    } while ((!MsgProxyUtils.a(paramInt)) || (l2 == -1L));
    if (QLog.isColorLevel()) {
      QLog.d("sendMsgReadedReport", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l2);
    }
    ArrayList localArrayList = new ArrayList();
    long l1;
    if (paramInt == 1006)
    {
      String str = ContactUtils.d(paramQQAppInterface, paramString);
      if (TextUtils.isEmpty(str)) {
        break label382;
      }
      l1 = Long.valueOf(str).longValue();
    }
    for (;;)
    {
      if (l1 != -1L)
      {
        localArrayList.add(new UinPairReadInfo(l1, l2, 0L, null));
        ((C2CMessageProcessor)paramQQAppInterface.a().a("c2c_processor")).b(localArrayList);
      }
      if (!AppConstants.Y.equals(paramString)) {
        break;
      }
      paramQQAppInterface.a().a().a();
      return;
      l1 = Long.valueOf(paramString).longValue();
      continue;
      label382:
      l1 = -1L;
    }
  }
  
  public static void a(RecentUser paramRecentUser, QQMessageFacade paramQQMessageFacade)
  {
    long l1 = System.currentTimeMillis();
    if ((paramRecentUser == null) || (paramQQMessageFacade == null)) {}
    long l2;
    do
    {
      return;
      if ((paramRecentUser.getStatus() == 1000) && (paramRecentUser.lastmsgdrafttime == 0L))
      {
        paramQQMessageFacade = paramQQMessageFacade.a(paramRecentUser.uin, paramRecentUser.type);
        if (paramQQMessageFacade != null) {
          paramRecentUser.lastmsgdrafttime = paramQQMessageFacade.getTime();
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "updateLastDraftTimeForNewRU| cost = " + (l2 - l1));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser)
  {
    if (AppConstants.Z.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1001, paramRecentUser.uin);
      return true;
    }
    if (String.valueOf(AppConstants.S).equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1009, paramRecentUser.uin);
      return true;
    }
    if (AppConstants.W.equals(paramRecentUser.uin))
    {
      paramQQAppInterface.a().c(AppConstants.W, 0);
      paramRecentUser = new Intent(paramActivity, VisitorsActivity.class);
      paramRecentUser.putExtra("votersOnly", true);
      paramRecentUser.putExtra("toUin", Long.valueOf(paramQQAppInterface.a()));
      paramActivity.startActivity(paramRecentUser);
      return true;
    }
    if (AppConstants.V.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, NewFriendActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.U.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, TroopAssistantActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_help", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.aa.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, QQBroadcastActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
      return true;
    }
    if (AppConstants.aj.equals(paramRecentUser.uin))
    {
      String str1 = "1";
      Intent localIntent = new Intent();
      localIntent.putExtra("key_tab_mode", 2);
      localIntent.setClass(paramActivity, TroopActivity.class);
      int i = GroupSystemMsgController.a().a(paramQQAppInterface);
      String str2;
      if (i > 0)
      {
        str2 = "0";
        str1 = "0";
      }
      for (;;)
      {
        paramQQAppInterface.a().b(AppConstants.aj, 9000, -i);
        localIntent.putExtra("_key_mode", paramRecentUser.jumpTabMode);
        paramActivity.startActivity(localIntent);
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "Clk_notice", 0, 0, "", str1, str2, "");
        return true;
        if (i > 0)
        {
          str1 = "0";
          str2 = "1";
        }
        else
        {
          str2 = "0";
        }
      }
    }
    if (AppConstants.T.equals(paramRecentUser.uin))
    {
      paramActivity.startActivity(new Intent(paramActivity, LiteActivity.class));
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
        if (paramQQAppInterface != null) {
          break label35;
        }
      }
    }
    label35:
    for (bool1 = false;; bool1 = paramQQAppInterface.b(paramString)) {
      return bool1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    int j = 0;
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    int i;
    label214:
    do
    {
      do
      {
        return;
        paramQQAppInterface.a().a().b(paramRecentUser);
        a(paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type);
        paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.type);
        if ((paramRecentUser.type == 0) && (AppConstants.Y.equals(paramRecentUser.uin))) {
          SystemMsgController.a().a(paramQQAppInterface, true);
        }
        if ((paramRecentUser.type == 4000) && (AppConstants.V.equals(paramRecentUser.uin)))
        {
          NewFriendManager.a(paramQQAppInterface, true);
          ((NewFriendManager)paramQQAppInterface.getManager(31)).g();
        }
        switch (paramRecentUser.type)
        {
        default: 
          i = 0;
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, i + "", "", "", "");
        }
      } while (paramRecentUser.type != 5000);
      TroopAssistantManager.a().a(paramQQAppInterface, true);
      paramRecentUser = TroopAssistantManager.a().a(paramQQAppInterface);
      if (paramRecentUser != null) {
        break;
      }
      i = 0;
    } while (j >= i);
    label289:
    Object localObject = (TroopAssistantData)paramRecentUser.get(j);
    if (localObject == null) {}
    for (;;)
    {
      j += 1;
      break label289;
      if (!paramRecentUser.uin.equals(AppConstants.Y)) {
        break;
      }
      i = 7;
      break label214;
      i = 1;
      break label214;
      i = 2;
      break label214;
      i = 4;
      break label214;
      i = 6;
      break label214;
      i = 8;
      break label214;
      i = 9;
      break label214;
      i = paramRecentUser.size();
      break label289;
      localObject = paramQQAppInterface.a().a(((TroopAssistantData)localObject).troopUin, 1);
      if (localObject != null) {
        TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject).time);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil
 * JD-Core Version:    0.7.0.1
 */