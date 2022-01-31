package com.tencent.mobileqq.activity.recent;

import MessageSvcPack.UinPairReadInfo;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantActivity;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.activity.HelloListActivity;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SpaceGateActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
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
    int k = 0;
    int m = 0;
    int n = 0;
    int j = 0;
    if ((paramRecentUser == null) || (paramActivity == null) || (paramQQAppInterface == null))
    {
      i = j;
      if (QLog.isDevelopLevel())
      {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser + "," + paramActivity + "," + paramQQAppInterface + "]");
        i = j;
      }
      return i;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser.uin + "," + paramRecentUser.type + "]");
    }
    if (paramRecentUser.msgType == 3) {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
    }
    while (String.valueOf(AppConstants.V).equals(paramRecentUser.uin))
    {
      paramActivity.startActivity(new Intent(paramActivity, HelloListActivity.class).putExtra(HelloListActivity.jdField_a_of_type_JavaLangString, HelloListActivity.jdField_a_of_type_Int));
      return 0;
      if (paramRecentUser.msgType == 4) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, paramRecentUser.uin, "", "", "");
      }
    }
    if (String.valueOf(AppConstants.N).equals(paramRecentUser.uin))
    {
      paramActivity.startActivity(new Intent(paramActivity, SpaceGateActivity.class));
      return 0;
    }
    if (AppConstants.S.equals(paramRecentUser.uin))
    {
      paramQQAppInterface.a().c(AppConstants.S, 0);
      paramRecentUser = new Intent(paramActivity, VisitorsActivity.class);
      paramRecentUser.putExtra("votersOnly", true);
      paramRecentUser.putExtra("toUin", Long.valueOf(paramQQAppInterface.a()));
      paramActivity.startActivity(paramRecentUser);
      return 0;
    }
    if (String.valueOf(AppConstants.R).equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, NewFriendActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
      return 0;
    }
    if (String.valueOf(AppConstants.Q).equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, TroopAssistantActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_help", 0, 0, "", "", "", "");
      return 0;
    }
    if (String.valueOf(AppConstants.ae).equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, QZoneShareAlbumAssistantActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
      QZoneShareAlbumAssistantManager.a().a();
      return 0;
    }
    if (String.valueOf(AppConstants.O).equals(paramRecentUser.uin))
    {
      SubAccountAssistantForward.a(paramQQAppInterface, paramActivity, paramQQAppInterface.getAccount());
      paramQQAppInterface.a().c(AppConstants.O, 7000);
      if (QLog.isColorLevel()) {
        QLog.d("subaccount", 2, "subaccount is clicked..");
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", SubAccountAssistantManager.a().a(paramQQAppInterface), "Bind_account", "Clk_bind_account", 0, 0, "", "", "", "");
      return 0;
    }
    if (String.valueOf(AppConstants.W).equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, QQBroadcastActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
      return 0;
    }
    if (paramRecentUser.type == 6000)
    {
      paramActivity.startActivity(new Intent(paramActivity, LiteActivity.class));
      return 0;
    }
    if ((paramRecentUser.type == 1000) || (paramRecentUser.type == 1020) || (paramRecentUser.type == 1004)) {
      if (a(paramQQAppInterface, paramRecentUser.uin))
      {
        paramRecentUser.type = 0;
        if (!paramBoolean) {
          break label1314;
        }
      }
    }
    label1314:
    for (int i = 2;; i = 0)
    {
      j = i | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString);
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, "from_enterchat");
      return j;
      if ((paramRecentUser.troopUin == null) || (paramRecentUser.troopUin.trim().length() == 0))
      {
        paramQQAppInterface = paramQQAppInterface.a().a().b(paramRecentUser.uin, 1);
        if (paramQQAppInterface != null) {
          paramRecentUser.troopUin = paramQQAppInterface.troopUin;
        }
      }
      a(paramActivity, String.valueOf(paramRecentUser.uin), paramRecentUser.troopUin, paramRecentUser.type, paramString);
      return 0;
      if (paramRecentUser.type == 1005)
      {
        i = k;
        if (a(paramQQAppInterface, paramRecentUser.uin))
        {
          paramRecentUser.type = 0;
          i = k;
          if (paramBoolean) {
            i = 2;
          }
        }
        return i | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString);
      }
      if (paramRecentUser.type == 1023)
      {
        i = m;
        if (a(paramQQAppInterface, paramRecentUser.uin))
        {
          paramRecentUser.type = 0;
          i = m;
          if (paramBoolean) {
            i = 2;
          }
        }
        return i | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString);
      }
      if (paramRecentUser.type == 1024) {
        return 0x0 | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString);
      }
      if (paramRecentUser.type == 7200)
      {
        paramQQAppInterface = new Intent(paramActivity, PubAccountAssistantActivity.class);
        paramQQAppInterface.setFlags(67108864);
        paramActivity.startActivity(paramQQAppInterface);
        return 0;
      }
      if (paramRecentUser.type == 9000)
      {
        paramRecentUser = "1";
        Intent localIntent = new Intent();
        localIntent.putExtra("key_tab_mode", 2);
        localIntent.setClass(paramActivity, TroopActivity.class);
        i = GroupSystemMsgController.a().a(paramQQAppInterface);
        if (i > 0)
        {
          paramString = "0";
          paramRecentUser = "0";
          localIntent.putExtra("_key_mode", 0);
        }
        for (;;)
        {
          paramQQAppInterface.a().b(AppConstants.ag, 9000, -i);
          paramActivity.startActivity(localIntent);
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "Clk_notice", 0, 0, "", paramRecentUser, paramString, "");
          return 0;
          i = RecommendTroopManagerImp.a(paramQQAppInterface);
          if (i > 0)
          {
            paramRecentUser = "0";
            paramString = "1";
            localIntent.putExtra("_key_mode", 1);
          }
          else
          {
            paramString = "0";
            localIntent.putExtra("_key_mode", 0);
          }
        }
      }
      if (a(paramQQAppInterface, paramRecentUser.uin))
      {
        i = n;
        if (1 != paramRecentUser.type)
        {
          i = n;
          if (3000 != paramRecentUser.type)
          {
            i = n;
            if (paramRecentUser.type != 0)
            {
              paramRecentUser.type = 0;
              i = n;
              if (paramBoolean) {
                i = 2;
              }
            }
          }
        }
        return i | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString);
      }
      return 0x0 | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString);
    }
  }
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    StartupTracker.a(null, "Recent_clk_enterchat");
    Intent localIntent = new Intent(paramActivity, ChatActivity.class);
    localIntent.addFlags(67108864);
    Object localObject1;
    int i;
    if (paramInt == 1)
    {
      StartupTracker.a(null, "Recent_clk_enterchat_troop");
      localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
      if (localObject1 != null)
      {
        if (((FriendManager)localObject1).f(paramString1))
        {
          localObject1 = ((FriendManager)localObject1).a(paramString1);
          if (localObject1 != null) {
            localIntent.putExtra("troop_uin", ((OpenTroopInfo)localObject1).troopUin);
          }
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Open_group", "Clk_open_group", 22, 0, paramString1, "", "", "");
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
        }
      }
      else
      {
        i = 1;
        StartupTracker.a("Recent_clk_enterchat_troop", null);
      }
    }
    for (;;)
    {
      localIntent.putExtra("uin", paramString1);
      if (paramQQAppInterface.a().a(paramString1, paramInt) > 0) {
        localIntent.putExtra("has_new_message", true);
      }
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("entrance", 1);
      a(localIntent);
      paramActivity.startActivity(localIntent);
      StartupTracker.a("Recent_clk_enterchat", null);
      return i;
      localObject1 = ((FriendManager)localObject1).a(paramString1 + "");
      if ((localObject1 == null) || (((TroopInfo)localObject1).troopcode == null)) {
        break;
      }
      localIntent.putExtra("troop_uin", ((TroopInfo)localObject1).troopcode);
      break;
      if ((paramInt == 0) || (paramInt == 1024))
      {
        StartupTracker.a(null, "Recent_clk_enterchat_cmr");
        if ((paramInt == 1024) || (CrmUtils.b(paramQQAppInterface, String.valueOf(paramString1))))
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
          localIntent.setClass(paramActivity, ChatForEnterpriseActivity.class);
        }
        StartupTracker.a("Recent_clk_enterchat_cmr", null);
        i = 0;
      }
      else
      {
        if (paramInt != 3000) {
          break label398;
        }
        i = 0;
      }
    }
    label398:
    if (paramInt == 1008)
    {
      StartupTracker.a(null, "Recent_clk_enterchat_cmr");
      localObject1 = ((PublicAccountDataManager)paramQQAppInterface.getManager(51)).b(String.valueOf(paramString1));
      if ((localObject1 == null) || (((PublicAccountInfo)localObject1).extendType != 2)) {
        break label493;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
      localIntent.setClass(paramActivity, ChatForEnterpriseActivity.class);
    }
    for (;;)
    {
      StartupTracker.a("Recent_clk_enterchat_pub", null);
      i = 0;
      break;
      label493:
      Object localObject2 = paramQQAppInterface.a().a(paramString1, 1008);
      String str = "";
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject2 = XMLMessageUtils.a((MessageRecord)localObject2);
        localObject1 = str;
        if (localObject2 != null) {
          localObject1 = Long.toString(((PAMessage)localObject2).mMsgId);
        }
      }
      PublicAccountHandler.a(paramQQAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_3", "msg_aio", (String)localObject1);
      localIntent.setClass(paramActivity, PublicAccountChatActivity.class);
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
      if ((paramRecentUser.type == 7200) || (paramRecentUser.type == 1008)) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
      } else if (String.valueOf(AppConstants.ae).equals(paramRecentUser.uin)) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A3", "0X80041A3", 0, 0, "", "", "", "");
      } else if (String.valueOf(9992L).equals(paramRecentUser.uin)) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419F", "0X800419F", 0, 0, "", "", "", "");
      } else if ((paramRecentUser.type == 1001) && (AppConstants.V.equals(paramRecentUser.uin))) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
      } else if ((paramRecentUser.type == 1009) && (AppConstants.N.equals(paramRecentUser.uin))) {
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
      do
      {
        do
        {
          do
          {
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
                if ((paramRecentUser.type == 0) && (AppConstants.U.equals(paramRecentUser.uin))) {
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
              if (paramRecentUser.type != 7200) {
                break;
              }
              paramRecentUser = PubAccountAssistantManager.a().a(paramQQAppInterface);
            } while ((paramRecentUser == null) || (paramRecentUser.size() <= 0));
            paramRecentUser = (PubAccountAssistantData)paramRecentUser.get(0);
          } while (paramRecentUser == null);
          paramRecentUser = paramQQAppInterface.a().a(paramRecentUser.mUin, paramRecentUser.mType);
        } while (paramRecentUser == null);
        PubAccountAssistantManager.a().a(paramQQAppInterface, paramRecentUser.time);
        return;
        if (String.valueOf(AppConstants.ae).equals(paramRecentUser.uin))
        {
          QZoneShareAlbumAssistantManager.a().a();
          return;
        }
        if (!String.valueOf(9992L).equals(paramRecentUser.uin)) {
          break;
        }
        paramRecentUser = SubAccountDataControll.a().a(paramQQAppInterface);
      } while (paramRecentUser == null);
      ((MessageHandler)paramQQAppInterface.a(0)).a().a(paramRecentUser.subuin, null);
      SubAccountDataControll.a().b(paramQQAppInterface, paramRecentUser.subuin);
      return;
      if (String.valueOf(9995L).equals(paramRecentUser.uin))
      {
        ((NewFriendManager)paramQQAppInterface.getManager(32)).f();
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
    ((RecommendTroopManagerImp)paramQQAppInterface.getManager(19)).a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    label8:
    do
    {
      long l;
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
            l = paramQQAppInterface.a().b(paramString, paramInt);
            if (paramInt != 1) {
              break;
            }
          } while (l == -1L);
          if (QLog.isColorLevel()) {
            QLog.d("sendGroupMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l);
          }
          paramQQAppInterface.a().a(Long.valueOf(paramString).longValue(), l);
          if (paramInt != 3000) {
            break;
          }
        } while (l == -1L);
        if (QLog.isColorLevel()) {
          QLog.d("sendDisMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l);
        }
        paramQQAppInterface.a().b(Long.valueOf(paramString).longValue(), l);
      } while ((paramInt != 0) || (l == -1L));
      if (QLog.isColorLevel()) {
        QLog.d("sendMsgReadedReport", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new UinPairReadInfo(Long.valueOf(paramString).longValue(), l, 0L, null));
      paramQQAppInterface.a().c(localArrayList);
    } while (!AppConstants.U.equals(paramString));
    paramQQAppInterface.a().a().a();
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
    int k = 0;
    int j = 0;
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {
      return;
    }
    paramQQAppInterface.a().a().b(paramRecentUser);
    a(paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type);
    paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.type);
    if ((paramRecentUser.type == 0) && (AppConstants.U.equals(paramRecentUser.uin))) {
      SystemMsgController.a().a(paramQQAppInterface, true);
    }
    if ((paramRecentUser.type == 4000) && (AppConstants.R.equals(paramRecentUser.uin)))
    {
      NewFriendManager.a(paramQQAppInterface, true);
      ((NewFriendManager)paramQQAppInterface.getManager(32)).g();
    }
    label232:
    label234:
    Object localObject;
    switch (paramRecentUser.type)
    {
    default: 
      i = 0;
    case 0: 
    case 1: 
    case 3000: 
    case 1008: 
    case 5000: 
    case 7000: 
    case 4000: 
    case 6000: 
      for (;;)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, i + "", "", "", "");
        if (paramRecentUser.type != 5000) {
          break label452;
        }
        TroopAssistantManager.a().a(paramQQAppInterface, true);
        paramRecentUser = TroopAssistantManager.a().a(paramQQAppInterface);
        if (paramRecentUser != null) {
          break label407;
        }
        i = 0;
        label309:
        while (j < i)
        {
          localObject = (TroopAssistantData)paramRecentUser.get(j);
          if (localObject != null) {
            break label417;
          }
          label331:
          j += 1;
        }
        if (!paramRecentUser.uin.equals(AppConstants.U)) {
          break label232;
        }
        i = 7;
        continue;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 8;
      }
    }
    for (int i = 9;; i = 0)
    {
      QZoneShareAlbumAssistantManager.a().m(paramQQAppInterface);
      break label234;
      label407:
      i = paramRecentUser.size();
      break label309;
      label417:
      localObject = paramQQAppInterface.a().a(((TroopAssistantData)localObject).troopUin, 1);
      if (localObject == null) {
        break label331;
      }
      TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject).time);
      break label331;
      label452:
      if (paramRecentUser.type != 7200) {
        break;
      }
      PubAccountAssistantManager.a().a(paramQQAppInterface, true);
      paramRecentUser = PubAccountAssistantManager.a().a(paramQQAppInterface);
      if (paramRecentUser == null)
      {
        i = 0;
        j = k;
        if (j >= i) {
          break;
        }
        localObject = (PubAccountAssistantData)paramRecentUser.get(j);
        if (localObject != null) {
          break label529;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = paramRecentUser.size();
        j = k;
        break;
        label529:
        localObject = paramQQAppInterface.a().a(((PubAccountAssistantData)localObject).mUin, ((PubAccountAssistantData)localObject).mType);
        if (localObject != null) {
          TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject).time);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil
 * JD-Core Version:    0.7.0.1
 */