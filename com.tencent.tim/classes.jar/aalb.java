import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.a;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil.1;
import com.tencent.mobileqq.activity.recent.RecentUtil.2;
import com.tencent.mobileqq.activity.recent.RecentUtil.3;
import com.tencent.mobileqq.activity.recent.RecentUtil.4;
import com.tencent.mobileqq.activity.recent.RecentUtil.5;
import com.tencent.mobileqq.activity.recent.RecentUtil.6;
import com.tencent.mobileqq.activity.recent.RecentUtil.7;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public final class aalb
{
  public static long LY;
  public static boolean bwg;
  public static boolean bwh;
  public static boolean bwi = true;
  public static MessageRecord r;
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean, int paramInt, RecentBaseData paramRecentBaseData)
  {
    return a(paramActivity, paramQQAppInterface, paramRecentUser, paramString, paramBoolean, paramInt, paramRecentBaseData, null, null);
  }
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean, int paramInt, RecentBaseData paramRecentBaseData, Bundle paramBundle, Intent[] paramArrayOfIntent)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    if ((paramRecentUser == null) || (paramActivity == null) || (paramQQAppInterface == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser + "," + paramActivity + "," + paramQQAppInterface + "]");
      }
      i = 0;
      return i;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser.uin + "," + paramRecentUser.getType() + "]");
    }
    boolean bool1;
    if ((paramInt == 0) || (paramInt == 2))
    {
      bool1 = true;
      label146:
      if ((paramRecentBaseData != null) && (paramInt == 0) && (paramRecentUser.uin != null) && ((paramRecentUser.getType() == 1008) || (paramRecentUser.getType() == 7220)))
      {
        aakp.a(paramQQAppInterface, paramRecentUser.uin, paramRecentBaseData.mUnreadFlag, paramRecentBaseData.wU(), 1, paramString);
        if ((paramRecentUser.getType() == 7220) || (acbn.blx.equalsIgnoreCase(paramRecentBaseData.qx())) || (acbn.blN.equalsIgnoreCase(paramRecentBaseData.qx())) || ("2290230341".equalsIgnoreCase(paramRecentBaseData.qx()))) {
          aakp.D.add(new aakp.a(paramRecentUser.uin, paramString, System.currentTimeMillis()));
        }
      }
      if (((paramRecentUser.uin == null) || (paramRecentUser.uin.length() != 4)) && (!acbn.bkG.equals(paramRecentUser.uin)) && (!TextUtils.equals(paramRecentUser.uin, acbn.blw)) && (!TextUtils.equals(paramRecentUser.uin, acbn.blN)) && (!TextUtils.equals(paramRecentUser.uin, acbn.blS)) && (!TextUtils.equals(paramRecentUser.uin, acbn.blO)) && (!TextUtils.equals(paramRecentUser.uin, acbn.blP)) && (!TextUtils.equals(paramRecentUser.uin, "2290230341")) && (!TextUtils.equals(paramRecentUser.uin, "2747277822")) && (!TextUtils.equals(paramRecentUser.uin, "3046055438")) && (!TextUtils.equals(paramRecentUser.uin, acbn.blT))) {
        break label669;
      }
    }
    for (;;)
    {
      try
      {
        bool2 = a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
        paramInt = k;
        if (bool2) {
          break label2226;
        }
        if (paramRecentUser.getType() != 8999) {
          break label675;
        }
        paramInt = 0;
        if (paramRecentUser.msgType != 17) {
          break label2048;
        }
        paramActivity = (apnu)paramQQAppInterface.getManager(363);
        long l = 0L;
        if (paramRecentUser.uin != null) {
          l = paramActivity.aQ(paramRecentUser.uin);
        }
        paramActivity = null;
        if (l != 0L) {
          paramActivity = paramQQAppInterface.b().d(paramRecentUser.uin, paramRecentUser.getType(), l);
        }
        if (!MessageForQQWalletMsg.isRedPacketMsg(paramActivity)) {
          break label2019;
        }
        anot.a(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_hongbaoSign", 0, 0, paramRecentUser.uin, "", "", "");
        label555:
        anot.a(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
        paramActivity = ".troop.special_msg.special_attention";
        label584:
        i = paramInt;
        if (TextUtils.isEmpty(paramActivity)) {
          break;
        }
        i = paramInt;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(aalb.class.getSimpleName() + paramActivity, 2, "onRecentUserClick, r.uin:" + paramRecentUser.uin);
        return paramInt;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      bool1 = false;
      break label146;
      label669:
      boolean bool2 = false;
    }
    label675:
    if (paramRecentUser.getType() == 7000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "RecentUtil.onRecentUserClick. r.uin=" + paramRecentUser.uin + " r.type=" + paramRecentUser.getType());
      }
      paramString = paramRecentUser.uin;
      if ((paramRecentBaseData instanceof RecentItemSubAccount)) {
        paramString = ((RecentItemSubAccount)paramRecentBaseData).showSubUin;
      }
      paramRecentBaseData = paramString;
      if (paramString == null) {
        paramRecentBaseData = "";
      }
      anxj.j(paramQQAppInterface, paramActivity, paramRecentBaseData);
      paramQQAppInterface.b().ca(paramRecentUser.uin, paramRecentUser.getType());
      if (acbn.bku.equals(paramRecentUser.uin)) {}
      for (paramActivity = null;; paramActivity = paramRecentUser.uin)
      {
        anot.a(paramQQAppInterface, "CliOper", "", paramActivity, "Bind_account", "Clk_bind_account", 0, 0, "", "", "", "");
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X800713E", "0X800713E", 0, 0, "", "", "", "");
        paramInt = 0;
        break;
      }
    }
    if ((paramRecentUser.getType() == 1000) || (paramRecentUser.getType() == 1020) || (paramRecentUser.getType() == 1004)) {
      if (q(paramQQAppInterface, paramRecentUser.uin))
      {
        paramRecentUser.setType(0);
        if (!paramBoolean) {
          break label2229;
        }
      }
    }
    label2048:
    label2226:
    label2229:
    for (paramInt = 2;; paramInt = 0)
    {
      i = paramInt | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.getType(), paramString, bool1);
      paramInt = i;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.recent", 2, "from_enterchat");
        paramInt = i;
        break;
        if ((paramRecentUser.troopUin == null) || (paramRecentUser.troopUin.trim().length() == 0))
        {
          paramRecentBaseData = paramQQAppInterface.a().a().b(paramRecentUser.uin, 1);
          if (paramRecentBaseData != null) {
            paramRecentUser.troopUin = paramRecentBaseData.troopUin;
          }
        }
        a(paramActivity, paramRecentUser.uin, paramRecentUser.troopUin, paramRecentUser.getType(), paramString, bool1);
        paramInt = 0;
        break;
        if ((paramRecentUser.getType() == 1005) || (paramRecentUser.getType() == 1023))
        {
          paramInt = i;
          if (q(paramQQAppInterface, paramRecentUser.uin))
          {
            paramRecentUser.setType(0);
            paramInt = i;
            if (paramBoolean) {
              paramInt = 2;
            }
          }
          paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool1);
          break;
        }
        if (paramRecentUser.getType() == 1024)
        {
          paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool1);
          break;
        }
        if (paramRecentUser.getType() == 6002)
        {
          paramString = (syw)paramQQAppInterface.getBusinessHandler(51);
          paramString.a(paramActivity, paramString.a(Long.parseLong(paramRecentUser.uin)), false);
          paramInt = 0;
          break;
        }
        if (paramRecentUser.getType() == 10005)
        {
          l(paramQQAppInterface, paramRecentUser.uin, 10005);
          paramQQAppInterface.b().a(paramRecentUser.uin, 10005, true, true);
          aibe.a().a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
          paramInt = 0;
          break;
        }
        if (paramRecentUser.lFlag == 16L)
        {
          l(paramQQAppInterface, paramRecentUser.uin, 1008);
          paramQQAppInterface.b().a(paramRecentUser.uin, 1008, true, true);
          a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
          paramInt = 0;
          break;
        }
        if (paramRecentUser.getType() == 6004)
        {
          paramRecentBaseData = ((jnv)paramQQAppInterface.getManager(70)).a(46, false);
          if ((paramRecentBaseData != null) && (paramRecentBaseData.uint32_number.has()))
          {
            paramInt = paramRecentBaseData.uint32_number.get();
            label1370:
            if ((paramRecentBaseData == null) || (paramRecentBaseData.bool_display_reddot.get())) {}
          }
          for (;;)
          {
            try
            {
              if (!paramRecentBaseData.str_custom_buffer.has()) {
                continue;
              }
              paramString = paramRecentBaseData.str_custom_buffer.get().toStringUtf8();
              if (TextUtils.isEmpty(paramString)) {
                continue;
              }
              paramString = new JSONObject(paramString);
              if (paramRecentBaseData.uint32_last_time.has()) {
                paramString.put("lastTime", paramRecentBaseData.uint32_last_time.get());
              }
              paramString.put("lastMsg", paramString.get("msg"));
              paramString = paramString.toString();
              paramRecentBaseData.str_custom_buffer.set(ByteStringMicro.copyFromUtf8(paramString));
              jnp.a(paramQQAppInterface, paramRecentBaseData, 0, true);
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              continue;
              if (paramInt <= 99) {
                continue;
              }
              paramString = paramString + "(99+)";
              continue;
              paramString = paramString + "(" + paramInt + ")";
              continue;
            }
            paramString = null;
            if (paramInt > 0)
            {
              a(paramQQAppInterface, paramRecentUser, true, true);
              paramInt = paramQQAppInterface.b().bl();
              paramString = acfp.m(2131713722);
              if (paramInt > 0) {
                continue;
              }
            }
            paramRecentBaseData = new Intent(paramActivity, QQBrowserActivity.class);
            if (!TextUtils.isEmpty(paramString)) {
              paramRecentBaseData.putExtra("selfSet_leftViewText", paramString);
            }
            paramRecentBaseData.putExtra("is_wrap_content", true);
            paramRecentBaseData.putExtra("url", "https://docs.qq.com/components/Notifications.html?_wv=3");
            paramRecentBaseData.putExtra("hide_more_button", true);
            paramRecentBaseData.putExtra("webStyle", "noBottomBar");
            paramRecentBaseData.putExtra("isScreenOrientationPortrait", true);
            paramRecentBaseData.putExtra("title", paramQQAppInterface.getApp().getString(2131720991));
            paramRecentBaseData.addFlags(603979776);
            paramActivity.startActivity(paramRecentBaseData);
            paramInt = 0;
            break;
            paramInt = 0;
            break label1370;
            paramString = null;
            continue;
            paramString = new JSONObject();
          }
        }
        if (paramRecentUser.getType() == 8114)
        {
          LoginUserGuideHelper.e(paramActivity, paramQQAppInterface);
          anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009F4C", "0X8009F4C", 0, 0, "", "", "", "");
          paramInt = 0;
          break;
        }
        if ((paramRecentUser.getType() == 1) && ((paramRecentUser.lFlag & 1L) != 0L))
        {
          paramRecentBaseData = paramQQAppInterface.a(true);
          if (paramRecentBaseData != null)
          {
            HotChatInfo localHotChatInfo = paramRecentBaseData.a(paramRecentUser.uin);
            if ((localHotChatInfo != null) && (localHotChatInfo.apolloGameId > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "clk_reliao_msgtab", 0, 0, new String[] { String.valueOf(localHotChatInfo.apolloGameId) });
            }
          }
          if ((paramRecentBaseData != null) && (!paramRecentBaseData.kj(paramRecentUser.uin))) {
            return 4;
          }
        }
        if (q(paramQQAppInterface, paramRecentUser.uin))
        {
          paramInt = j;
          if (1 != paramRecentUser.getType())
          {
            paramInt = j;
            if (3000 != paramRecentUser.getType())
            {
              paramInt = j;
              if (paramRecentUser.getType() != 0)
              {
                paramRecentUser.setType(0);
                paramInt = j;
                if (paramBoolean) {
                  paramInt = 2;
                }
              }
            }
          }
          paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool1, paramBundle, paramArrayOfIntent);
          break;
        }
        paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool1, paramBundle, paramArrayOfIntent);
        break;
        label2019:
        anot.a(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
        break label555;
        if (paramRecentUser.msgType == 24)
        {
          anot.a(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, paramRecentUser.uin, "", "", "");
          paramActivity = ".troop.special_msg.at_msg";
          break label584;
        }
        if (paramRecentUser.msgType == 22)
        {
          i = paramQQAppInterface.cs(paramRecentUser.uin);
          if (paramRecentUser.getType() == 3000) {}
          for (paramActivity = "Grp_Dis_replyMsg";; paramActivity = "Grp_replyMsg")
          {
            anot.a(paramQQAppInterface, "P_CliOper", paramActivity, "", "Msglist", "Clk_replySign", 0, 0, paramRecentUser.uin, "" + i, "", "");
            paramActivity = "";
            break;
          }
        }
        if (paramRecentUser.msgType == 16) {
          anot.b(null, "dc00898", "", paramRecentUser.uin, "qq_vip", "0X800A907", 0, 1, 0, "", "", "", "");
        }
        paramActivity = "";
        break label584;
      }
      break;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    return a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, paramBoolean, null, null);
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    return a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, paramBoolean, paramBundle, null);
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle, Intent[] paramArrayOfIntent)
  {
    aqmq.track(null, "Recent_clk_enterchat");
    SuspendThreadManager.a().Qn(true);
    Object localObject1 = new Intent();
    if ((paramArrayOfIntent != null) && (paramArrayOfIntent.length != 0)) {
      paramArrayOfIntent[0] = localObject1;
    }
    long l1;
    if (bwg)
    {
      ((Intent)localObject1).setClassName(paramContext, ChatActivity.class.getName());
      if (r != null) {
        if ((r.istroop == 1) || (r.istroop == 3000))
        {
          l1 = r.shmsgseq;
          ((Intent)localObject1).putExtra("searched_timeorseq", l1);
          paramArrayOfIntent = (Intent[])localObject1;
        }
      }
    }
    for (;;)
    {
      label110:
      if (paramBundle != null) {
        paramArrayOfIntent.putExtras(paramBundle);
      }
      if (paramInt == 8001)
      {
        paramQQAppInterface = (augo)paramQQAppInterface.getManager(374);
        if ((paramContext instanceof Activity)) {
          paramQQAppInterface.g((Activity)paramContext, new Intent(), 1);
        }
        for (;;)
        {
          anpc.report("tim_msg_tab_email_noti_click");
          return 0;
          l1 = r.time;
          break;
          if (LY == 0L) {
            break label1212;
          }
          ((Intent)localObject1).putExtra("searched_timeorseq", LY);
          paramArrayOfIntent = (Intent[])localObject1;
          break label110;
          paramArrayOfIntent = null;
          if (paramBundle != null) {
            paramArrayOfIntent = paramBundle.getString("KEY_OPEN_AIO_INTENT_CLASS_NAME");
          }
          localObject2 = paramArrayOfIntent;
          if (TextUtils.isEmpty(paramArrayOfIntent)) {
            localObject2 = SplashActivity.class.getName();
          }
          ((Intent)localObject1).setClassName(paramContext, (String)localObject2);
          paramArrayOfIntent = wja.a((Intent)localObject1, new int[] { 1 });
          break label110;
          paramQQAppInterface.g(BaseActivity.sTopActivity, new Intent(), 1);
        }
      }
      int i;
      if (paramInt == 3000) {
        i = 0;
      }
      label302:
      label359:
      boolean bool;
      for (;;)
      {
        paramArrayOfIntent.putExtra("uin", paramString1);
        paramArrayOfIntent.putExtra("uintype", paramInt);
        paramArrayOfIntent.putExtra("uinname", paramString2);
        paramArrayOfIntent.putExtra("entrance", 1);
        cT(paramArrayOfIntent);
        if (!paramBoolean) {
          break label1190;
        }
        w(paramContext, paramArrayOfIntent);
        aqmq.track("Recent_clk_enterchat", null);
        return i;
        if ((paramInt == 0) || (paramInt == 1024))
        {
          if (paramInt != 1024)
          {
            bool = paramBoolean;
            if (!jqs.c(paramQQAppInterface, paramString1)) {
              break label1170;
            }
          }
          aqmq.track(null, "Recent_clk_enterchat_cmr");
          anot.a(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
          aqmq.track("Recent_clk_enterchat_cmr", null);
          i = 0;
        }
        else
        {
          if (paramInt == 1)
          {
            aqmq.track(null, "Recent_clk_enterchat_troop");
            paramBundle = ((HotChatManager)paramQQAppInterface.getManager(60)).a(paramString1);
            if (paramBundle != null) {
              paramArrayOfIntent.putExtra("troop_uin", paramBundle.troopCode);
            }
            for (;;)
            {
              i = 1;
              aqmq.track("Recent_clk_enterchat_troop", null);
              break;
              paramBundle = (TroopManager)paramQQAppInterface.getManager(52);
              if (paramBundle != null)
              {
                paramBundle = paramBundle.a(paramString1 + "", true);
                if ((paramBundle == null) || (paramBundle.troopuin == null)) {
                  break label605;
                }
                paramArrayOfIntent.putExtra("troop_uin", paramBundle.troopuin);
              }
              anot.a(paramQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
            }
            label605:
            if (QLog.isColorLevel()) {
              QLog.e("RecentUtil", 2, "when enter troop AIO, troop is not exist!!");
            }
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131713727), 0).show();
            return 0;
          }
          if (paramInt != 1008) {
            break label1034;
          }
          aqmq.track(null, "Recent_clk_enterchat_cmr");
          paramBundle = ((acja)paramQQAppInterface.getManager(56)).c(String.valueOf(paramString1));
          if ((paramBundle == null) || (paramBundle.extendType != 2)) {
            break label759;
          }
          anot.a(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
          paramArrayOfIntent.putExtra("chat_subType", 1);
          paramArrayOfIntent.setClass(paramContext, ChatActivity.class);
          paramBoolean = false;
          aqmq.track("Recent_clk_enterchat_pub", null);
          i = 0;
        }
      }
      label759:
      Object localObject2 = paramQQAppInterface.b().a(paramString1, 1008);
      paramBundle = "";
      localObject1 = paramBundle;
      if (localObject2 != null)
      {
        localObject1 = wna.a((MessageRecord)localObject2);
        if (localObject1 != null) {
          paramBundle = Long.toString(((PAMessage)localObject1).mMsgId);
        }
        localObject1 = paramBundle;
        if (!TextUtils.isEmpty(paramBundle)) {}
      }
      for (paramBundle = ((MessageRecord)localObject2).getExtInfoFromExtStr("pa_msgId");; paramBundle = (Bundle)localObject1)
      {
        if (localObject2 != null) {}
        for (i = paramQQAppInterface.a().A(paramString1, ((MessageRecord)localObject2).istroop);; i = 0)
        {
          kbp.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_3", "msg_aio", 0, 0, paramString1, paramBundle, String.valueOf(i), "", false);
          int j;
          if ("2909288299".equals(paramString1))
          {
            if (i > 0)
            {
              j = 2;
              label897:
              anot.a(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8007055", "0X8007055", 0, 0, "", "", "", nyn.bG(j));
            }
          }
          else
          {
            if ((xki.hN(paramString1)) && (abdi.b(paramContext, paramQQAppInterface))) {
              break;
            }
            paramArrayOfIntent.putExtra("shouldreport", true);
            if ((paramContext instanceof SplashActivity))
            {
              paramArrayOfIntent.putExtra("start_time", System.currentTimeMillis());
              paramArrayOfIntent.putExtra("red_hot_count", i);
            }
            if (i <= 0) {
              break label1028;
            }
          }
          label1028:
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramArrayOfIntent.putExtra("has_unread_msg", paramBoolean);
            paramArrayOfIntent.putExtra("jump_from", 1);
            odd.bU(null, "SUBSCRIPT_AIO_COST");
            break;
            j = 1;
            break label897;
          }
          label1034:
          bool = paramBoolean;
          if (paramInt == 9501)
          {
            tar.a(paramQQAppInterface, "Usr_AIO_Open", 2, 0, 0);
            paramQQAppInterface = (syw)paramQQAppInterface.getBusinessHandler(51);
            l1 = 0L;
          }
          try
          {
            long l2 = Long.parseLong(paramString1);
            l1 = l2;
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
            }
          }
          paramArrayOfIntent.setClass(paramContext, ChatActivity.class);
          paramBoolean = false;
          bool = paramBoolean;
          if (paramQQAppInterface != null)
          {
            bool = paramBoolean;
            if (paramQQAppInterface.i(l1, 9))
            {
              paramQQAppInterface = new Bundle();
              paramQQAppInterface.putString("din", String.valueOf(l1));
              paramQQAppInterface.putString("devName", paramString2);
              paramQQAppInterface.putBoolean("bFromLightApp", false);
              paramQQAppInterface.putInt("operType", 5);
              paramArrayOfIntent.putExtras(paramQQAppInterface);
              bool = paramBoolean;
            }
          }
          label1170:
          i = 0;
          paramBoolean = bool;
          break label302;
          label1190:
          paramContext.startActivity(paramArrayOfIntent);
          break label359;
        }
      }
      label1212:
      paramArrayOfIntent = (Intent[])localObject1;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramContext == null) {}
    jxl localjxl;
    jxc localjxc;
    do
    {
      return;
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        while (TextUtils.isEmpty(paramString)) {
          if (QLog.isColorLevel())
          {
            QLog.d("RecentUtil", 2, "openAdvertisement empty uin!");
            return;
          }
        }
        localjxl = jxl.a();
        localObject = localjxl.b(paramString);
        if (localObject != null)
        {
          a(paramContext, paramQQAppInterface, paramString, paramInt, (jxc)localObject);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecentUtil", 2, "openAdvertisement item recreate, uin:" + paramString);
        }
        localObject = paramQQAppInterface.b().k(paramString, paramInt).iterator();
      }
      localjxc = jxp.a(paramQQAppInterface, (MessageRecord)((Iterator)localObject).next(), true);
    } while (localjxc == null);
    localjxl.b(localjxc);
    a(paramContext, paramQQAppInterface, paramString, paramInt, localjxc);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramQQAppInterface = new Intent(paramContext, ChatActivity.class);
    if (LY != 0L) {
      paramQQAppInterface.putExtra("searched_timeorseq", LY);
    }
    paramQQAppInterface.putExtra("uin", paramString1);
    paramQQAppInterface.putExtra("uintype", paramInt);
    paramQQAppInterface.putExtra("uinname", paramString2);
    paramQQAppInterface.putExtra("entrance", 1);
    paramQQAppInterface.putExtra("key_message_highlight", true);
    cT(paramQQAppInterface);
    paramContext.startActivity(paramQQAppInterface);
    aqmq.track("Recent_clk_enterchat", null);
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, jxc paramjxc)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", paramjxc.hV());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", bwi);
    bwi = false;
    paramContext.startActivity(localIntent);
    ThreadManager.post(new RecentUtil.7(paramQQAppInterface, paramString, paramInt, paramjxc), 5, null, false);
    jxl.a().a(paramQQAppInterface, 2, paramjxc);
    if (QLog.isColorLevel()) {
      QLog.d("RecentUtil", 2, "openAdvertisement start, uin:" + paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Intent localIntent;
    long l;
    if (paramContext != null)
    {
      if (!bwg) {
        break label146;
      }
      localIntent = new Intent(paramContext, ChatActivity.class);
      if (r == null) {
        break label179;
      }
      if ((r.istroop != 1) && (r.istroop != 3000)) {
        break label135;
      }
      l = r.shmsgseq;
      localIntent.putExtra("searched_timeorseq", l);
    }
    label135:
    label146:
    label179:
    for (;;)
    {
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString3);
      cT(localIntent);
      if (paramBoolean)
      {
        if ((paramContext instanceof SplashActivity)) {
          w(paramContext, localIntent);
        }
        return;
        l = r.time;
        break;
        localIntent = wja.a(new Intent(paramContext, SplashActivity.class), new int[] { 1 });
        continue;
      }
      paramContext.startActivity(localIntent);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label135:
    label503:
    label632:
    do
    {
      do
      {
        Object localObject1;
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                return;
                paramQQAppInterface.a().a().b(paramRecentUser, false);
                if (!top.x(paramRecentUser.uin, paramRecentUser.getType())) {
                  break label782;
                }
                if ((!acbn.bkY.equals(paramRecentUser.uin)) && (!acbn.bkE.equals(paramRecentUser.uin))) {
                  break;
                }
                localObject1 = paramQQAppInterface.b().a(paramRecentUser.uin, paramRecentUser.getType());
                if (localObject1 != null) {
                  paramQQAppInterface.a().T(paramRecentUser.getType(), ((QQMessageFacade.Message)localObject1).time);
                }
                localObject1 = paramRecentUser.uin;
                i = paramRecentUser.getType();
                ThreadManager.post(new RecentUtil.3((MessageHandler)paramQQAppInterface.getBusinessHandler(0), (String)localObject1, i), 8, null, false);
                paramQQAppInterface.b().a(paramRecentUser.uin, paramRecentUser.getType(), true, true);
                if (paramRecentUser.getType() == 1) {
                  ajpd.ar(paramQQAppInterface, paramRecentUser.uin);
                }
                if ((paramRecentUser.getType() == 9000) && (acbn.bkT.equals(paramRecentUser.uin)))
                {
                  paramQQAppInterface.a().a().cOd();
                  anze.a().N(paramQQAppInterface, 0);
                  ((ackn)paramQQAppInterface.getManager(22)).cmt();
                }
                if ((paramRecentUser.getType() == 7210) && (acbn.bkZ.equals(paramRecentUser.uin)))
                {
                  oan.a().ar(paramQQAppInterface);
                  oan.a().aq(paramQQAppInterface);
                  paramQQAppInterface.ba(true, 0);
                }
                if ((paramRecentUser.getType() == 7230) && (acbn.bly.equals(paramRecentUser.uin)))
                {
                  localObject1 = nyn.a();
                  i = ((nyn)localObject1).rc();
                  int j = ((nyn)localObject1).c(paramQQAppInterface);
                  long l = ((nyn)localObject1).dn();
                  if (paramInt != -1) {
                    anot.a(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X80067EB", "0X80067EB", 0, 0, "" + j, "" + i, String.valueOf(paramInt + 1), "" + l);
                  }
                  ((nyn)localObject1).af(paramQQAppInterface);
                  paramQQAppInterface.ba(true, 0);
                  if (QLog.isColorLevel()) {
                    QLog.d("RecentUtil", 2, "deleteServiceAccountFolderFromMsgTab");
                  }
                }
                if (!acbn.bkZ.equals(paramRecentUser.uin)) {
                  break label797;
                }
                anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572D", "0X800572D", 0, 0, "", "", "", "");
                anot.a(paramQQAppInterface, "CliOper", "", "", "0X800623F", "0X800623F", 0, 0, "", "", "", "");
                oac.d(paramQQAppInterface, false);
                paramInt = 0;
                switch (paramRecentUser.getType())
                {
                default: 
                  anot.a(paramQQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, paramInt + "", "", "", "");
                  if (paramRecentUser.getType() != 5000) {
                    break label997;
                  }
                  aizp.a().I(paramQQAppInterface, true);
                  paramRecentUser = aizp.a().l(paramQQAppInterface);
                  if (paramRecentUser != null) {
                    break label952;
                  }
                  paramInt = 0;
                  i = 0;
                }
              } while (i >= paramInt);
              localObject1 = (TroopAssistantData)paramRecentUser.get(i);
              if (localObject1 == null) {}
              for (;;)
              {
                i += 1;
                break label710;
                if ((1032 != paramRecentUser.getType()) || (!acbn.blK.equals(paramRecentUser.uin))) {
                  break;
                }
                paramQQAppInterface.a().bEp();
                aegu.B(paramQQAppInterface, false);
                aegu.A(paramQQAppInterface, false);
                break;
                l(paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
                break label135;
                if (!acbn.blb.equals(paramRecentUser.uin)) {
                  break label503;
                }
                if (((kdm)paramQQAppInterface.getManager(88)).b(paramQQAppInterface) > 0) {}
                for (localObject1 = "havereddot";; localObject1 = "noreddot")
                {
                  anot.a(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsglist", "Del_shopHelper", 0, 0, "", "", (String)localObject1, "");
                  break;
                }
                if (!paramRecentUser.uin.equals(acbn.bkD)) {
                  break label632;
                }
                paramInt = 7;
                break label632;
                paramInt = 1;
                break label632;
                paramInt = 2;
                break label632;
                paramInt = 3;
                k(paramQQAppInterface, paramRecentUser.uin, 2);
                break label632;
                paramInt = 4;
                break label632;
                paramInt = 5;
                break label632;
                paramInt = 6;
                break label632;
                paramInt = 8;
                break label632;
                paramInt = 9;
                break label632;
                paramInt = 11;
                break label632;
                paramInt = 12;
                break label632;
                paramInt = paramRecentUser.size();
                break label708;
                localObject1 = paramQQAppInterface.b().a(((TroopAssistantData)localObject1).troopUin, 1);
                if (localObject1 != null) {
                  aizp.a().f(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
                }
              }
              if (paramRecentUser.getType() == 7210)
              {
                oan.a().f(paramQQAppInterface, true);
                ThreadManager.post(new RecentUtil.4(paramQQAppInterface), 8, null, false);
                oan.a().au(paramQQAppInterface);
                return;
              }
              if (paramRecentUser.getType() != 7120) {
                break;
              }
              paramRecentUser = (kdm)paramQQAppInterface.getManager(88);
            } while (paramRecentUser == null);
            paramRecentUser.lK(true);
            localObject1 = paramRecentUser.am();
            Object localObject2;
            if (localObject1 == null)
            {
              paramInt = 0;
              i = 0;
              if (i < paramInt)
              {
                localObject2 = (EcShopData)((List)localObject1).get(i);
                if (localObject2 != null) {
                  break label1123;
                }
              }
            }
            for (;;)
            {
              i += 1;
              break label1082;
              break;
              paramInt = ((List)localObject1).size();
              break label1080;
              localObject2 = paramQQAppInterface.b().a(((EcShopData)localObject2).mUin, 1008);
              if (localObject2 != null) {
                paramRecentUser.eh(((QQMessageFacade.Message)localObject2).time);
              }
            }
            if (paramRecentUser.getType() != 9002) {
              break;
            }
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004E99", "0X8004E99", 0, 0, "", "", "", "");
            localObject1 = paramQQAppInterface.b().k(acbn.bla, 0);
            paramRecentUser = new ArrayList(((List)localObject1).size());
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if ((!((MessageRecord)localObject2).isread) && ((((MessageRecord)localObject2).extLong & 0x1) == 1) && (!TextUtils.isEmpty(((MessageRecord)localObject2).extStr))) {
                paramRecentUser.add(((MessageRecord)localObject2).extStr);
              }
              paramQQAppInterface.b().t(acbn.bla, 0, ((MessageRecord)localObject2).uniseq);
            }
          } while (paramRecentUser.size() <= 0);
          acoe.e(paramQQAppInterface, (ArrayList)paramRecentUser);
          return;
          if (paramRecentUser.getType() == 9003)
          {
            ((ylm)paramQQAppInterface.getManager(138)).cjj();
            return;
          }
          if ((paramRecentUser.getType() == 7000) && (acbn.bku.equals(paramRecentUser.uin)))
          {
            ThreadManager.postImmediately(new RecentUtil.5(paramQQAppInterface), null, true);
            return;
          }
          if (paramRecentUser.getType() != 10005) {
            break;
          }
          localObject1 = aibe.a().b(paramRecentUser.uin);
        } while (localObject1 == null);
        aibe.a().a(paramQQAppInterface, paramRecentUser, (jxc)localObject1, true);
        return;
      } while (paramRecentUser.getType() != 6004);
      paramQQAppInterface = (jnp)paramQQAppInterface.getBusinessHandler(43);
    } while (paramQQAppInterface == null);
    label708:
    label710:
    label997:
    paramQQAppInterface.nX(46);
    label782:
    label797:
    label952:
    label1080:
    label1082:
    label1123:
    return;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label136:
    label185:
    label210:
    label468:
    do
    {
      do
      {
        Object localObject1;
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
                  do
                  {
                    do
                    {
                      for (;;)
                      {
                        return;
                        int i = paramRecentUser.getType();
                        localObject1 = paramRecentUser.uin;
                        if ((i != 1033) && (i != 1034)) {
                          anod.T(1, 1, i, paramQQAppInterface.a().A((String)localObject1, i));
                        }
                        if (top.x(paramRecentUser.uin, paramRecentUser.getType())) {
                          if ((acbn.bkY.equals(paramRecentUser.uin)) || (acbn.bkE.equals(paramRecentUser.uin)))
                          {
                            localObject1 = paramQQAppInterface.b().a(paramRecentUser.uin, paramRecentUser.getType());
                            if (localObject1 != null) {
                              paramQQAppInterface.a().T(paramRecentUser.getType(), ((QQMessageFacade.Message)localObject1).time);
                            }
                            localObject1 = paramRecentUser.uin;
                            i = paramRecentUser.getType();
                            paramQQAppInterface.b().cb((String)localObject1, i);
                            ThreadManager.post(new RecentUtil.2((MessageHandler)paramQQAppInterface.getBusinessHandler(0), (String)localObject1, i), 8, null, false);
                            if (paramRecentUser.getType() != 5000) {
                              break label468;
                            }
                            paramRecentUser = aizp.a().l(paramQQAppInterface);
                            if (paramRecentUser != null) {
                              break label422;
                            }
                            i = 0;
                            if (j >= i) {
                              break label431;
                            }
                            localObject1 = (TroopAssistantData)paramRecentUser.get(j);
                            if (localObject1 != null) {
                              break label433;
                            }
                          }
                        }
                        for (;;)
                        {
                          j += 1;
                          break label210;
                          if ((1032 != paramRecentUser.getType()) || (!acbn.blK.equals(paramRecentUser.uin))) {
                            break label136;
                          }
                          paramQQAppInterface.a().bEp();
                          aegu.B(paramQQAppInterface, false);
                          aegu.A(paramQQAppInterface, false);
                          break label136;
                          if (paramBoolean1)
                          {
                            localObject1 = new SessionInfo();
                            ((SessionInfo)localObject1).aTl = paramRecentUser.uin;
                            ((SessionInfo)localObject1).troopUin = paramRecentUser.uin;
                            ((SessionInfo)localObject1).cZ = paramRecentUser.getType();
                            if (((SessionInfo)localObject1).cZ == 1006) {
                              ((SessionInfo)localObject1).aTo = aqgv.x(paramQQAppInterface, ((SessionInfo)localObject1).aTl);
                            }
                            ujt.a(paramQQAppInterface, (SessionInfo)localObject1);
                          }
                          if ((7000 == paramRecentUser.getType()) && (acbn.bku.equals(paramRecentUser.uin))) {
                            anxk.bG(paramQQAppInterface);
                          }
                          paramQQAppInterface.b().a(paramRecentUser.uin, paramRecentUser.getType(), true, paramBoolean2);
                          if (paramRecentUser.getType() != 1) {
                            break label185;
                          }
                          ajpd.ar(paramQQAppInterface, paramRecentUser.uin);
                          break label185;
                          i = paramRecentUser.size();
                          break label210;
                          break;
                          localObject1 = paramQQAppInterface.b().a(((TroopAssistantData)localObject1).troopUin, 1);
                          if (localObject1 != null) {
                            aizp.a().f(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
                          }
                        }
                        if (5001 != paramRecentUser.getType()) {
                          break;
                        }
                        paramRecentUser = (acfs)paramQQAppInterface.getManager(255);
                        localObject1 = paramRecentUser.dW();
                        if ((localObject1 != null) && (((List)localObject1).size() > 0))
                        {
                          localObject1 = ((List)localObject1).iterator();
                          while (((Iterator)localObject1).hasNext())
                          {
                            Object localObject2 = (HotChatItemData)((Iterator)localObject1).next();
                            localObject2 = paramQQAppInterface.b().a(((HotChatItemData)localObject2).mTroopUin, 1);
                            if (localObject2 != null) {
                              paramRecentUser.eh(((QQMessageFacade.Message)localObject2).time);
                            }
                          }
                        }
                      }
                      if (acbn.bkA.equals(paramRecentUser.uin))
                      {
                        ((ysf)paramQQAppInterface.getManager(34)).cls();
                        return;
                      }
                      if (String.valueOf(9980L).equals(paramRecentUser.uin))
                      {
                        paramQQAppInterface.a().a().cOd();
                        anze.a().N(paramQQAppInterface, 0);
                        ((ackn)paramQQAppInterface.getManager(22)).cmt();
                        return;
                      }
                      if (paramRecentUser.getType() != 7210) {
                        break;
                      }
                      paramRecentUser = oan.a().b(paramQQAppInterface);
                    } while ((paramRecentUser == null) || (paramRecentUser.size() <= 0));
                    paramRecentUser = (TroopBarData)paramRecentUser.get(0);
                  } while (paramRecentUser == null);
                  paramRecentUser = paramQQAppInterface.b().a(paramRecentUser.mUin, 1008);
                } while (paramRecentUser == null);
                oan.a().f(paramQQAppInterface, paramRecentUser.time);
                return;
                if (paramRecentUser.getType() != 7120) {
                  break;
                }
                paramRecentUser = (kdm)paramQQAppInterface.getManager(88);
              } while (paramRecentUser == null);
              localObject1 = paramRecentUser.am();
            } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
            localObject1 = (EcShopData)((List)localObject1).get(0);
          } while (localObject1 == null);
          paramQQAppInterface = paramQQAppInterface.b().a(((EcShopData)localObject1).mUin, 1008);
        } while (paramQQAppInterface == null);
        paramRecentUser.eh(paramQQAppInterface.time);
        return;
        if (paramRecentUser.getType() == 7220)
        {
          ((KandianMergeManager)paramQQAppInterface.getManager(162)).aIC();
          return;
        }
        if (1001 == paramRecentUser.getType())
        {
          paramQQAppInterface.a().clearMsgBoxUnreadCount();
          return;
        }
        if (paramRecentUser.lFlag == 16L)
        {
          localObject1 = new SessionInfo();
          ((SessionInfo)localObject1).cZ = 1008;
          paramRecentUser = paramRecentUser.uin;
          ((SessionInfo)localObject1).troopUin = paramRecentUser;
          ((SessionInfo)localObject1).aTl = paramRecentUser;
          ujt.a(paramQQAppInterface, (SessionInfo)localObject1);
          paramQQAppInterface.b().a(((SessionInfo)localObject1).aTl, 1008, true, paramBoolean2);
          return;
        }
        if (paramRecentUser.getType() == 10005)
        {
          localObject1 = new SessionInfo();
          ((SessionInfo)localObject1).cZ = 10005;
          paramRecentUser = paramRecentUser.uin;
          ((SessionInfo)localObject1).troopUin = paramRecentUser;
          ((SessionInfo)localObject1).aTl = paramRecentUser;
          ujt.a(paramQQAppInterface, (SessionInfo)localObject1);
          paramQQAppInterface.b().a(((SessionInfo)localObject1).aTl, 1008, true, paramBoolean2);
          return;
        }
        if (paramRecentUser.getType() != 6004) {
          break;
        }
        paramQQAppInterface = (jnp)paramQQAppInterface.getBusinessHandler(43);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.nX(46);
      return;
    } while ((!"2747277822".equals(paramRecentUser.uin)) || (!ahta.isInited()));
    label422:
    label431:
    label433:
    ((ahta)paramQQAppInterface.getManager(358)).Pr(0);
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
        paramQQMessageFacade = paramQQMessageFacade.a(paramRecentUser.uin, paramRecentUser.getType());
        if (paramQQMessageFacade != null) {
          paramRecentUser.lastmsgdrafttime = paramQQMessageFacade.getTime();
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "updateLastDraftTimeForNewRU| cost = " + (l2 - l1));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
    throws JSONException
  {
    if (acbn.bkE.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.g(paramActivity, 1001, paramRecentUser.uin);
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X80050F5", "0X80050F5", 0, 0, "", "", "", "");
      anot.a(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "clk_friend", 0, 0, "", "", "", "");
      paramActivity = paramQQAppInterface.b().a(paramRecentUser.uin, 1001);
      if ((paramActivity != null) && (paramActivity.msgtype == -4011))
      {
        paramActivity = akkw.a(paramQQAppInterface);
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X80055FB", "0X80055FB", 0, 0, paramActivity[0], "", paramActivity[1], "");
      }
      return true;
    }
    if (acbn.bkY.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.g(paramActivity, 1010, paramRecentUser.uin);
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004947", "0X8004947", 0, 0, "", "", "", "");
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X80050F6", "0X80050F6", 0, 0, "", "", "", "");
      return true;
    }
    if (acbn.ble.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.g(paramActivity, 1001, acbn.bkE);
      anot.a(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "tip_single", 0, 0, "", "", "", "");
      return true;
    }
    if (acbn.blf.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.g(paramActivity, 1010, acbn.bkY);
      return true;
    }
    if (String.valueOf(acbn.bkt).equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.g(paramActivity, 1009, paramRecentUser.uin);
      return true;
    }
    if (acbn.bkB.equals(paramRecentUser.uin))
    {
      paramQQAppInterface.b().ca(acbn.bkB, 0);
      paramRecentUser = new Intent(paramActivity, VisitorsActivity.class);
      paramRecentUser.putExtra("votersOnly", true);
      paramRecentUser.putExtra("toUin", Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
      paramActivity.startActivity(paramRecentUser);
      return true;
    }
    if (acbn.bkA.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent();
      if ((paramActivity instanceof QQLSActivity)) {
        paramRecentUser.putExtra("from", "from_lsa");
      }
      NewFriendActivity.g(paramActivity, paramRecentUser, 1);
      anot.a(paramQQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
      return true;
    }
    if (acbn.bkz.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, TroopAssistantActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      anot.a(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_help", 0, 0, "", "", "", "");
      return true;
    }
    Object localObject1;
    Object localObject2;
    if (acbn.blI.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, HotChatCenterFragment.class);
      paramRecentBaseData = (acfs)paramQQAppInterface.getManager(255);
      localObject1 = paramRecentBaseData.a();
      ApolloGameUtil.a(paramQQAppInterface.a().createEntityManager(), true);
      if (localObject1 != null)
      {
        paramRecentBaseData.dy(((HotChatItemData)localObject1).mTroopUin, 1);
        localObject2 = paramQQAppInterface.getHandler(Conversation.class);
        if (localObject2 != null) {
          ((MqqHandler)localObject2).sendEmptyMessage(1009);
        }
        if (((HotChatItemData)localObject1).mIsRead4Folder) {
          break label680;
        }
      }
      label680:
      for (paramInt = 99;; paramInt = paramRecentBaseData.Aw())
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "clk_reliao_folder", paramInt, 0, new String[0]);
        paramRecentUser.setFlags(67108864);
        PublicFragmentActivity.start(paramActivity, paramRecentUser, HotChatCenterFragment.class);
        return true;
      }
    }
    if (acbn.bkG.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, QQBroadcastActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
      return true;
    }
    if (acbn.bkZ.equals(paramRecentUser.uin))
    {
      oac.d(paramQQAppInterface, false);
      paramRecentUser = oan.a();
      if (paramRecentUser.r(paramQQAppInterface)) {
        anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B70", "0X8005B70", 0, 0, paramQQAppInterface.getCurrentAccountUin(), "", "", "");
      }
      paramRecentUser.j(paramQQAppInterface, false);
      paramRecentUser.i(paramQQAppInterface, false);
      paramInt = oan.a().g(paramQQAppInterface);
      if (paramInt > 0)
      {
        anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572B", "0X800572B", 0, 0, "", "", "", "");
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X8006573", "0X8006573", 0, 0, "", "", "", "");
        if (paramInt <= 0) {
          break label3742;
        }
      }
    }
    label1543:
    label2444:
    label3727:
    label3730:
    label3742:
    for (paramInt = 1;; paramInt = 0)
    {
      ThreadManager.post(new RecentUtil.1(paramQQAppInterface, paramInt), 8, null, false);
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800623E", "0X800623E", 0, 0, "", "", "", "");
      anot.a(paramQQAppInterface, "P_CliOper", "Grp_tribe", "", "Msglist", "Clk_tribeHelper", 0, 0, "", "", "", "");
      if (awit.cA(paramQQAppInterface))
      {
        paramQQAppInterface = kgw.a(paramActivity, 0, 1);
        label955:
        paramQQAppInterface.putExtra("start_time", System.currentTimeMillis());
        if (paramInt == 0) {
          break label1074;
        }
      }
      label1074:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramQQAppInterface.putExtra("has_red_hot", bool1);
        paramQQAppInterface.putExtra("come_from", 1);
        paramQQAppInterface.setFlags(67108864);
        paramActivity.startActivity(paramQQAppInterface);
        return true;
        anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572C", "0X800572C", 0, 0, "", "", "", "");
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X8006574", "0X8006574", 0, 0, "", "", "", "");
        break;
        paramQQAppInterface = kgw.a(paramActivity, -1, 1);
        break label955;
      }
      int j;
      int i;
      if (TextUtils.equals(acbn.blw, paramRecentUser.uin))
      {
        if (paramRecentBaseData != null) {
          paramInt = paramRecentBaseData.mPosition;
        }
        for (;;)
        {
          localObject1 = new ArrayList();
          paramRecentBaseData = paramQQAppInterface.b();
          if (paramRecentBaseData == null) {
            break label1504;
          }
          paramRecentBaseData = paramRecentBaseData.d(paramRecentUser.uin, paramRecentUser.getType());
          if ((paramRecentBaseData == null) || (!(paramRecentBaseData instanceof MessageForStructing)) || (paramRecentBaseData.extInt != 1)) {
            break label1543;
          }
          paramRecentUser = (MessageForStructing)paramRecentBaseData;
          if (paramRecentUser.structingMsg == null) {
            paramRecentUser.parse();
          }
          if (paramRecentUser.structingMsg == null) {
            break label1365;
          }
          if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mArticleIds))
          {
            localObject2 = paramRecentUser.structingMsg.mArticleIds.split("\\|");
            j = localObject2.length;
            i = 0;
            label1221:
            if (i < j)
            {
              String str2 = localObject2[i];
              try
              {
                ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong(str2)));
                i += 1;
                break label1221;
                paramInt = -1;
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  localException3.printStackTrace();
                }
              }
            }
          }
        }
        if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mMsgActionData))
        {
          localObject2 = ocp.e(paramRecentUser.structingMsg.mMsgActionData);
          if (localObject2 == null) {}
        }
      }
      for (;;)
      {
        long l;
        try
        {
          l = Long.parseLong(((JSONObject)localObject2).getString("id"));
          if (l != -1L) {
            anot.a(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(paramInt + 1), "", String.valueOf(l), "");
          }
          ocp.a(paramQQAppInterface, paramRecentUser, 1);
          label1365:
          paramQQAppInterface = "";
          paramRecentUser = paramQQAppInterface;
          if (paramRecentBaseData == null) {
            break label3730;
          }
          paramRecentUser = paramQQAppInterface;
        }
        catch (Exception localException2)
        {
          label1504:
          localException2.printStackTrace();
        }
        try
        {
          if (!(paramRecentBaseData instanceof MessageForStructing)) {
            break label3730;
          }
          paramRecentBaseData = (MessageForStructing)paramRecentBaseData;
          if (paramRecentBaseData.structingMsg.mStrategyIds != null) {
            paramQQAppInterface = paramRecentBaseData.structingMsg.mStrategyIds.split("\\|")[0];
          }
          paramRecentUser = paramQQAppInterface;
          if (paramRecentBaseData.structingMsg.mAlgorithmIds == null) {
            break label3730;
          }
          paramRecentUser = paramRecentBaseData.structingMsg.mAlgorithmIds.split("\\|")[0];
          kbp.a(null, "CliOper", "", "", "0X80066F4", "0X80066F4", 0, 0, String.valueOf(paramInt + 1), "", paramQQAppInterface, kxm.eu(paramRecentUser), false);
          kbp.d("0X80066F4", "", String.valueOf(paramInt + 1), "", paramQQAppInterface, kxm.eu(paramRecentUser));
        }
        catch (Exception paramQQAppInterface)
        {
          QLog.d("KandianMergeManager", 1, "failed to report new kandian click " + paramQQAppInterface.toString());
          continue;
          l = ((Long)((ArrayList)localObject1).get(0)).longValue();
          continue;
        }
        if (((ArrayList)localObject1).isEmpty())
        {
          l = -1L;
          kgw.a(paramActivity, (List)localObject1, l, 5);
          return true;
          l = -1L;
          continue;
          anot.a(null, "CliOper", "", "", "0X80066F6", "0X80066F6", 0, 0, String.valueOf(paramInt + 1), "", "", "");
        }
        else
        {
          if (acbn.blr.equals(paramRecentUser.uin))
          {
            paramRecentUser = (ylm)paramQQAppInterface.getManager(138);
            if (paramRecentUser != null)
            {
              paramRecentUser.dq(paramActivity);
              paramRecentUser.setRead(false);
              anot.a(paramQQAppInterface, "CliOper", "", "", "0X800618B", "0X800618B", 0, 0, "", "", "", "");
            }
            return true;
          }
          if (acbn.bkR.equals(paramRecentUser.uin)) {
            return true;
          }
          Object localObject3;
          if (acbn.bkT.equals(paramRecentUser.uin))
          {
            paramRecentBaseData = "1";
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("key_tab_mode", 2);
            ((Intent)localObject3).setClass(paramActivity, TroopActivity.class);
            paramInt = anze.a().af(paramQQAppInterface);
            if (paramInt > 0)
            {
              localObject1 = "0";
              paramRecentBaseData = "0";
              paramQQAppInterface.a().G(acbn.bkT, 9000, -paramInt);
              if (yya.UN())
              {
                yya.Bc(false);
                yya.cmU();
                ((Intent)localObject3).putExtra("show_type", true);
              }
              ((Intent)localObject3).putExtra("_key_mode", paramRecentUser.jumpTabMode);
              ((Intent)localObject3).putExtra("key_from", 2);
              if (paramInt <= 0) {
                break label1923;
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              ((Intent)localObject3).putExtra("has_red", bool1);
              paramActivity.startActivity((Intent)localObject3);
              anot.a(paramQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "Clk_notice", 0, 0, "", paramRecentBaseData, (String)localObject1, "");
              return true;
              paramInt = ackn.F(paramQQAppInterface);
              if (paramInt > 0)
              {
                paramRecentBaseData = "0";
                localObject1 = "1";
                break;
              }
              localObject1 = "0";
              break;
            }
          }
          if (acbn.bkw.equals(paramRecentUser.uin))
          {
            paramRecentUser = new Intent(paramActivity, LiteActivity.class);
            paramRecentUser.putExtra("targetUin", acbn.bkw);
            paramActivity.startActivity(paramRecentUser);
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X800603B", "0X800603B", 0, 0, "", "", "", "");
            return true;
          }
          if (acbn.bkx.equals(paramRecentUser.uin))
          {
            paramRecentUser = new Intent(paramActivity, LiteActivity.class);
            paramRecentUser.putExtra("targetUin", acbn.bkx);
            paramActivity.startActivity(paramRecentUser);
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X8006040", "0X8006040", 0, 0, "", "", "", "");
            return true;
          }
          if (acbn.bla.equals(paramRecentUser.uin))
          {
            paramQQAppInterface = new Intent(paramActivity, ActivateFriendActivity.class);
            paramQQAppInterface.setFlags(67108864);
            if (paramInt == 0) {}
            for (paramInt = 1;; paramInt = 3)
            {
              paramQQAppInterface.putExtra("af_key_from", paramInt);
              paramActivity.startActivity(paramQQAppInterface);
              return true;
            }
          }
          Object localObject4;
          if (acbn.blb.equals(paramRecentUser.uin))
          {
            paramRecentUser = new Intent(paramActivity, EcshopWebActivity.class);
            paramRecentUser.putExtra("start_time", System.currentTimeMillis());
            paramRecentUser.setFlags(67108864);
            anot.a(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Msglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
            localObject1 = (kdm)paramQQAppInterface.getManager(88);
            localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappecshopurl", "");
            if (localObject1 != null)
            {
              localObject4 = ((kdm)localObject1).am();
              if (localObject4 != null) {
                break label2418;
              }
              paramInt = 0;
              if (paramInt == 0) {
                anot.a(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_noMsglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
              }
              i = ((kdm)localObject1).b(paramQQAppInterface);
              if (i <= 0) {
                break label3727;
              }
              i = 1;
            }
          }
          for (;;)
          {
            anot.a(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064CB", "0X80064CB", 0, 0, "" + i, "" + paramInt, "", "");
            if (i != 0)
            {
              bool1 = true;
              label2364:
              paramRecentUser.putExtra("has_red_hot", bool1);
              if (paramRecentBaseData != null) {
                break label2435;
              }
              paramInt = -1;
              label2381:
              ((kdm)localObject1).a(paramRecentUser, paramActivity, paramInt);
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((kdm)localObject1).H(paramQQAppInterface);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label2444;
              }
              paramActivity.startActivity(paramRecentUser);
            }
            for (;;)
            {
              return true;
              label2418:
              paramInt = ((List)localObject4).size();
              break;
              bool1 = false;
              break label2364;
              paramInt = paramRecentBaseData.mUnreadNum;
              break label2381;
              if (MiniAppLauncher.isMiniAppUrl((String)localObject3))
              {
                MiniAppLauncher.startMiniApp(paramActivity, (String)localObject3, 4003, null);
                MiniAppBusiReport.report("shopping_folder", "click", "message", String.valueOf(paramRecentBaseData.mUnreadNum));
              }
            }
            if (1012 == paramRecentUser.msgType)
            {
              paramQQAppInterface = new ProfileActivity.AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0);
              paramRecentUser = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
              paramRecentUser.putExtra("param_mode", 2);
              paramRecentUser.putExtra("AllInOne", paramQQAppInterface);
              paramRecentUser.putExtra("frome_where", -1);
              paramRecentUser.putExtra("abp_flag", true);
              paramRecentUser.addFlags(67108864);
              paramActivity.startActivity(paramRecentUser);
              return true;
            }
            MessageRecord localMessageRecord;
            String str3;
            String str4;
            String str5;
            if ((1030 == paramRecentUser.msgType) || (1035 == paramRecentUser.msgType) || (1041 == paramRecentUser.msgType) || (1042 == paramRecentUser.msgType))
            {
              if ((paramRecentBaseData instanceof RecentItemNoticeData))
              {
                paramQQAppInterface = ((RecentItemNoticeData)paramRecentBaseData).intent;
                if (paramQQAppInterface != null) {
                  paramActivity.startActivity(paramQQAppInterface);
                }
                return true;
              }
            }
            else if (TextUtils.equals(acbn.blx, paramRecentUser.uin))
            {
              localObject1 = paramQQAppInterface.b();
              if (localObject1 != null)
              {
                localMessageRecord = ((QQMessageFacade)localObject1).d(paramRecentUser.uin, paramRecentUser.getType());
                kxm.a(paramQQAppInterface, localMessageRecord);
                str3 = kxm.a.ahf;
                str4 = kxm.a.aeN;
                str5 = kxm.a.Wz;
                paramRecentUser = (KandianMergeManager)paramQQAppInterface.getManager(162);
                localObject1 = paramRecentUser.a();
                if (localObject1 == null) {
                  break label3716;
                }
                l = ((KandianMsgBoxRedPntInfo)localObject1).mUin;
                i = ((KandianMsgBoxRedPntInfo)localObject1).mMsgType;
                localObject3 = String.valueOf(l);
              }
            }
            for (localObject4 = String.valueOf(i);; localObject4 = "")
            {
              label2792:
              boolean bool2;
              label2809:
              boolean bool3;
              if (paramRecentBaseData != null)
              {
                i = paramRecentBaseData.mPosition;
                if ((localMessageRecord == null) || (localMessageRecord.uniseq != paramRecentUser.cv())) {
                  break label3146;
                }
                j = 1;
                bool1 = false;
                bool2 = false;
                if (localMessageRecord == null) {
                  break label3152;
                }
                paramRecentUser = localMessageRecord.senderuin;
                localObject1 = paramRecentUser;
                if (localMessageRecord != null) {
                  bool3 = bool1;
                }
              }
              for (;;)
              {
                try
                {
                  JSONObject localJSONObject = new JSONObject(localMessageRecord.extStr);
                  bool3 = bool1;
                  if (!localJSONObject.has("kdShouldShowMergedAvatar")) {
                    continue;
                  }
                  bool3 = bool1;
                  if (!localJSONObject.getBoolean("kdShouldShowMergedAvatar")) {
                    continue;
                  }
                  bool3 = bool1;
                  if (localMessageRecord.isread) {
                    continue;
                  }
                  bool1 = true;
                  localObject1 = paramRecentUser;
                  bool2 = bool1;
                  bool3 = bool1;
                  if (localJSONObject.has("kdUin"))
                  {
                    bool3 = bool1;
                    localObject1 = localJSONObject.getString("kdUin");
                    bool2 = bool1;
                  }
                  paramRecentUser = (RecentUser)localObject1;
                }
                catch (Exception localException1)
                {
                  label3146:
                  label3152:
                  localException1.printStackTrace();
                  bool2 = bool3;
                  continue;
                  String str1 = "";
                  continue;
                  paramRecentUser = "";
                  continue;
                  paramRecentUser = "";
                  continue;
                  bool1 = false;
                  continue;
                  paramInt = 5;
                  continue;
                }
                if (paramInt != 1)
                {
                  if (j == 0) {
                    continue;
                  }
                  localObject1 = "1";
                  kbp.a(null, "CliOper", "", paramRecentUser, "0X80066F4", "0X80066F4", 0, 0, String.valueOf(i + 1), str5, str3, kxm.a(str4, (String)localObject4, (String)localObject1, (String)localObject3, bool2), false);
                  kbp.d("0X80066F4", paramRecentUser, String.valueOf(i + 1), "", str3, kxm.P(str4, (String)localObject4));
                  kxm.a(21, str5, str3, str4, paramRecentUser, -1);
                }
                if (paramRecentBaseData == null) {
                  continue;
                }
                if (paramRecentBaseData.mLastMsg == null) {
                  continue;
                }
                paramRecentUser = paramRecentBaseData.mLastMsg.toString();
                paramRecentUser = new StringBuilder().append("enter kandianMergeBox, brief : ").append(kxm.ev(paramRecentUser)).append(",isUnRead : ");
                if ((paramRecentBaseData == null) || (paramRecentBaseData.mUnreadNum == 0)) {
                  continue;
                }
                bool1 = true;
                QLog.d("KandianMergeManager", 1, bool1);
                if (paramInt != 1) {
                  continue;
                }
                paramInt = 9;
                kgw.b(paramQQAppInterface, paramActivity, paramInt, 0);
                odd.bU(null, "KANDIAN_FEEDS_STAGE_1_COST");
                odd.bU(null, "KANDIAN_FEEDS_COST");
                odd.bU(null, "KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER");
                return true;
                i = -1;
                break;
                j = 0;
                break label2792;
                paramRecentUser = "";
                break label2809;
                bool1 = false;
              }
              if (acbn.bly.equals(paramRecentUser.uin))
              {
                ocp.a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
                odd.bU(null, "SERVICE_FOLDER_COST");
                return true;
              }
              if (acbn.blB.equals(paramRecentUser.uin))
              {
                ((apqx)paramQQAppInterface.getManager(183)).fr(paramActivity);
                return true;
              }
              if (acbn.blK.equals(paramRecentUser.uin))
              {
                ConfessMsgListFragment.an(paramActivity, 1);
                anot.a(paramQQAppInterface, "dc00898", "", "", "0X8008F4C", "0X8008F4C", 0, 0, "", "", "", "");
                return true;
              }
              if (acbn.blN.equals(paramRecentUser.uin))
              {
                ogj.c(paramActivity, "from_home_page", 1, true);
                return true;
              }
              if (acbn.blS.equals(paramRecentUser.uin))
              {
                ocp.b(paramActivity, paramQQAppInterface);
                return true;
              }
              if (acbn.blO.equals(paramRecentUser.uin))
              {
                paramQQAppInterface = paramQQAppInterface.b().d(paramRecentUser.uin, paramRecentUser.getType());
                if (paramQQAppInterface != null) {
                  kvv.i(paramQQAppInterface);
                }
                if (paramRecentBaseData.mUnreadNum > 0) {}
                for (paramInt = 1;; paramInt = 3)
                {
                  KandianSubscribeManager.P(paramActivity, paramInt);
                  return true;
                }
              }
              if ((TextUtils.equals(paramRecentUser.uin, "2290230341")) && (QZoneMsgActivity.e(paramActivity, paramQQAppInterface))) {
                return true;
              }
              if (acbn.blP.equals(paramRecentUser.uin))
              {
                paramRecentUser = paramQQAppInterface.b().d(paramRecentUser.uin, paramRecentUser.getType());
                if (paramInt == 1)
                {
                  kxm.aIa();
                  paramActivity.startActivity(ReadInJoyLockScreenJumpDelegate.a(paramActivity, 9, ((KandianDailyManager)paramQQAppInterface.getManager(296)).b()));
                }
                for (;;)
                {
                  return true;
                  if (paramRecentUser != null)
                  {
                    kvs.h(paramRecentUser);
                    KandianDailyManager.bV(paramActivity);
                  }
                }
              }
              if (("2747277822".equals(paramRecentUser.uin)) && (ahty.anY()))
              {
                ahua.es(paramActivity);
                paramQQAppInterface.a().h("2747277822", 1008, false);
                l(paramQQAppInterface, "2747277822", 1008);
                if (ahta.isInited())
                {
                  paramQQAppInterface = (ahta)paramQQAppInterface.getManager(358);
                  if (paramQQAppInterface.cie)
                  {
                    paramActivity = paramQQAppInterface.a();
                    paramQQAppInterface = "";
                    if (paramActivity != null) {
                      paramQQAppInterface = paramActivity.wx();
                    }
                    awot.a().c(paramQQAppInterface, "1", "145", "920", "92003", "206346", "0", "0", "20", "0");
                  }
                  return true;
                }
              }
              else
              {
                if (MiniGamePublicAccountHelper.shouldOpenWebFragment(paramRecentUser.uin))
                {
                  MiniGamePublicAccountHelper.launchMiniGamePublicAccount(paramActivity);
                  paramQQAppInterface.a().h(acbn.blT, 1008, false);
                  return true;
                }
                if (TextUtils.equals("3046055438", paramRecentUser.uin))
                {
                  kee.d(paramQQAppInterface, paramActivity, paramRecentUser.uin, paramActivity.getResources().getString(2131692999));
                  kee.h(paramQQAppInterface, "qgg.push.click");
                  kee.I(paramQQAppInterface);
                  return true;
                }
                return false;
              }
              return true;
              localObject3 = "";
            }
          }
          paramRecentBaseData = "";
          paramQQAppInterface = paramRecentUser;
          paramRecentUser = paramRecentBaseData;
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 5000) {}
    for (;;)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      return;
      if ((paramRecentUser.getType() == 7200) || (paramRecentUser.getType() == 1008))
      {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
        if (paramRecentUser.getType() == 1008) {
          k(paramQQAppInterface, paramRecentUser.uin, 1);
        }
      }
      else if (String.valueOf(9992L).equals(paramRecentUser.uin))
      {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X800419F", "0X800419F", 0, 0, "", "", "", "");
      }
      else if (((paramRecentUser.getType() == 1001) || (paramRecentUser.getType() == 10002)) && (acbn.bkE.equals(paramRecentUser.uin)))
      {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X80050FD", "0X80050FD", 0, 0, "", "", "", "");
        anot.a(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.getType() == 1010) && (acbn.bkY.equals(paramRecentUser.uin)))
      {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X80050FF", "0X80050FF", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.getType() == 1009) && (acbn.bkt.equals(paramRecentUser.uin)))
      {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X80041A4", "0X80041A4", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static boolean b(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData == null) {}
    return false;
  }
  
  public static void cT(Intent paramIntent)
  {
    if (bwg)
    {
      paramIntent.putExtra("aio_msg_source", 1);
      paramIntent.putExtra("entrance", 7);
      bwg = false;
      r = null;
      LY = 0L;
      return;
    }
    paramIntent.putExtra("aio_msg_source", 0);
  }
  
  public static void hH(List<nyi> paramList)
  {
    if ((paramList != null) && (paramList.size() == 0)) {}
  }
  
  public static void k(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    ThreadManager.post(new RecentUtil.6(paramQQAppInterface, paramString, paramInt), 2, null, false);
    if ("2290230341".equals(paramString))
    {
      if (paramInt != 1) {
        break label58;
      }
      paramString = "0X80090E4";
    }
    for (;;)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
      return;
      label58:
      paramString = "0X80090E5";
      anor.Vk(3);
    }
  }
  
  public static void l(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while (paramQQAppInterface.a().A(paramString, paramInt) <= 0);
        l = paramQQAppInterface.b().g(paramString, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("RecentUtil,uin: %s, uinType: %d, id: %d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(l) }));
        }
      } while (l == -1L);
      String str = top.cp(paramInt);
      paramQQAppInterface.a().a(str).m(paramString, paramInt, l);
    } while (!ahta.isInited());
    ((ahta)paramQQAppInterface.getManager(358)).Pr(0);
  }
  
  public static boolean q(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface != null) {
          break label35;
        }
      }
    }
    label35:
    for (bool1 = false;; bool1 = paramQQAppInterface.isFriend(paramString)) {
      return bool1;
    }
  }
  
  public static void w(Context paramContext, Intent paramIntent)
  {
    if ((paramContext instanceof SplashActivity))
    {
      paramContext = (SplashActivity)paramContext;
      paramIntent.putExtra("isFromMainTab", true);
      paramIntent.putExtra("isBack2Root", true);
      paramContext.setIntent(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.SpalshActivity", 2, "mainTabToAio-->openAioFragment");
      }
      paramContext.aw(false, 1);
    }
    while (paramIntent.getBooleanExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.SpalshActivity", 2, "start->SpalshActivity-->AIO");
    }
    paramContext.startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalb
 * JD-Core Version:    0.7.0.1
 */