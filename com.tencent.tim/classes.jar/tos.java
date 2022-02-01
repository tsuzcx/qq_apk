import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.troop.NearbyVideoProxyBroadcastReceiver;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.RenameGroupResp;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.oidb.submsgtype0x136.Submsgtype0x136.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x117.submsgtype0x117.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ChatMatchInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DaRenNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FrdCustomOnlineStatusChange;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupMemberProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MQQCampusNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModCustomFace;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupMemberProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupName;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModLongNick;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModSnsGeneralInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PraiseRankNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PushReportDev;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PushSearchDev;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpateBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateOneFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ModifySyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.WaitingSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgParams;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.PushAddFrdNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.Medal;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.HotFriendNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;

public class tos
  extends tnv
{
  public tos(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void Y(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x136");
    }
    Submsgtype0x136.MsgBody localMsgBody = new Submsgtype0x136.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (localMsgBody.uint32_msg_type.get() == 0) {
        ((acms)this.app.getBusinessHandler(20)).a(String.valueOf(localMsgBody.uint64_group_id.get()), 1, 0, null, 0);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x136 " + paramArrayOfByte);
    }
  }
  
  private int a(SubMsgType0x27.ForwardBody paramForwardBody, acff paramacff, TroopManager paramTroopManager, Object paramObject, abhh paramabhh, Friends[] paramArrayOfFriends, int paramInt)
  {
    paramForwardBody = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    int n = paramInt;
    long l2;
    int m;
    int k;
    int i1;
    int i2;
    label705:
    Object localObject;
    int i3;
    if (paramForwardBody.uint64_uin.has())
    {
      l2 = paramForwardBody.uint64_uin.get();
      paramObject = paramForwardBody.rpt_msg_profile_infos.get().iterator();
      m = 0;
      k = 0;
      n = 0;
      i1 = paramInt;
      paramInt = n;
      if (paramObject.hasNext())
      {
        paramForwardBody = (SubMsgType0x27.ProfileInfo)paramObject.next();
        n = k;
        if (paramForwardBody.uint32_field.has())
        {
          n = k;
          if (!paramForwardBody.bytes_value.has()) {}
        }
        switch (paramForwardBody.uint32_field.get())
        {
        default: 
          n = k;
          if (QLog.isColorLevel())
          {
            QLog.d("cardpush", 2, "push a unknow field Uint32Field = " + paramForwardBody.uint32_field.get());
            n = k;
          }
          i2 = m;
          k = n;
          m = paramInt;
        case 20002: 
          for (paramInt = i2;; paramInt = n)
          {
            n = m;
            m = paramInt;
            paramInt = n;
            break;
            paramTroopManager = paramForwardBody.bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModProfile Nick = " + paramTroopManager);
            }
            localObject = paramacff.e(Long.toString(l2));
            paramForwardBody = null;
            if (localObject != null) {
              paramForwardBody = ((Friends)localObject).name;
            }
            paramArrayOfFriends[i1] = paramacff.a(l2 + "", paramTroopManager);
            if ((localObject != null) && (((Friends)localObject).isFriend()) && (ackd.ay(paramTroopManager, paramForwardBody))) {
              ackd.a(l2, paramTroopManager, (acdu)this.app.getManager(53));
            }
            paramForwardBody = paramacff.b(l2 + "");
            if (paramForwardBody != null)
            {
              paramForwardBody.strNick = paramTroopManager;
              paramacff.a(paramForwardBody);
              this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
            }
            this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
            TroopNameHelper.TV(Long.toString(l2));
            n = m;
            m = paramInt;
            i1 += 1;
          }
        case 20014: 
          if (paramForwardBody.bytes_value.has())
          {
            paramForwardBody = paramForwardBody.bytes_value.get();
            n = paramForwardBody.size();
            if (paramForwardBody.size() > 0)
            {
              paramTroopManager = (CardHandler)this.app.getBusinessHandler(2);
              if (paramTroopManager != null)
              {
                i3 = paramForwardBody.byteAt(0);
                if (i3 != 101) {
                  paramTroopManager.IK(i3);
                }
                i2 = n;
                n = i3;
              }
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "20014 push a ProfileInfo size = " + i2 + "  settingValue = " + n);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramForwardBody = paramForwardBody.bytes_value.get();
      if ((paramForwardBody != null) && (paramForwardBody.size() == 2))
      {
        n = paramForwardBody.byteAt(0);
        n = (short)(paramForwardBody.byteAt(1) | n << 8);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModProfile Head = " + n);
        }
        ((FriendListHandler)this.app.getBusinessHandler(1)).DH(Long.toString(l2));
        paramForwardBody = paramacff.b(l2 + "");
        if (paramForwardBody != null)
        {
          paramForwardBody.nFaceID = n;
          paramacff.a(paramForwardBody);
          this.app.getBusinessHandler(1).notifyUI(4, true, new Object[] { l2 + "", paramForwardBody, null });
          this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
        }
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = paramForwardBody.bytes_value.get().byteAt(0);
      if (i2 == 1) {
        n = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModProfile Sex = " + n);
        }
        paramForwardBody = paramacff.b(l2 + "");
        if (paramForwardBody != null)
        {
          paramForwardBody.shGender = ((short)n);
          paramacff.a(paramForwardBody);
          this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        if (i2 == 2)
        {
          n = 1;
        }
        else
        {
          n = i2;
          if (i2 == 0) {
            n = 2;
          }
        }
      }
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get(0);
      zA(i2);
      ((acle)this.app.getBusinessHandler(13)).notifyUI(101, true, Integer.valueOf(i2));
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("vip", 2, "bubble id = " + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "vip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      paramTroopManager = paramacff.e(Long.toString(l2));
      n = k;
      if (paramTroopManager == null) {
        break;
      }
      paramTroopManager = (Friends)paramTroopManager.clone();
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("bit info = %02X", new Object[] { Byte.valueOf(paramForwardBody.byteAt(0)) }));
      }
      i2 = paramTroopManager.qqVipInfo;
      if ((paramForwardBody.byteAt(0) & 0x80) == 0)
      {
        n = 0;
        label1681:
        paramTroopManager.qqVipInfo = (n << 24 | 0xFFFFFF & i2);
        i2 = paramTroopManager.superQqInfo;
        if ((paramForwardBody.byteAt(0) & 0x8) != 0) {
          break label2148;
        }
        n = 0;
        label1717:
        paramTroopManager.superQqInfo = (n << 24 | 0xFFFFFF & i2);
        if ((paramForwardBody.byteAt(0) & 0x40) == 0) {
          break label2154;
        }
        bool1 = true;
        label1747:
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "is year vip =" + bool1);
        }
        if (!bool1) {
          break label2160;
        }
        n = 65536;
        label1791:
        if (!paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
          break label2166;
        }
        paramTroopManager.superVipInfo = (paramTroopManager.superVipInfo & 0xFF00FFFF | n);
      }
      for (;;)
      {
        if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
          paramTroopManager.bigClubInfo = (n | paramTroopManager.bigClubInfo & 0xFF00FFFF);
        }
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, String.format("SVIP = %08X, VIP = %08X, SuperQQ = %08X", new Object[] { Integer.valueOf(paramTroopManager.superVipInfo), Integer.valueOf(paramTroopManager.qqVipInfo), Integer.valueOf(paramTroopManager.superQqInfo) }));
        }
        paramacff.e(paramTroopManager);
        ((acle)this.app.getBusinessHandler(13)).notifyUI(100, true, null);
        if (this.app.getCurrentAccountUin().equals(Long.toString(l2)))
        {
          paramForwardBody = new Intent("tencent.video.q2v.SVIP.PAY");
          paramForwardBody.putExtra("SVIPpaySuccess", true);
          paramForwardBody.setPackage(MobileQQ.getContext().getPackageName());
          this.app.getApp().sendBroadcast(paramForwardBody);
        }
        if (this.app.getCurrentAccountUin().equals(Long.toString(l2)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, "[EmoticonUpdateAuth] 23105 updateEmoticonAuth");
          }
          paramForwardBody = (acdz)this.app.getBusinessHandler(12);
          paramForwardBody.gT(0, 0);
          paramForwardBody.I(0, 0, 1, 0);
          if (QLog.isColorLevel()) {
            QLog.d("QVipSettingMe.", 2, "[vipInfoPush] 23105 request vipInfoHandler");
          }
          aqvl.d(this.app, "last_pull_pay_rule", 0L);
          paramForwardBody = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
          ((acny)this.app.getBusinessHandler(27)).fg(paramForwardBody, l2 + "");
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        n = 1;
        break label1681;
        label2148:
        n = 1;
        break label1717;
        label2154:
        bool1 = false;
        break label1747;
        label2160:
        n = 0;
        break label1791;
        label2166:
        if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
          paramTroopManager.qqVipInfo = (paramTroopManager.qqVipInfo & 0xFF00FFFF | n);
        } else if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
          paramTroopManager.superQqInfo = (paramTroopManager.superQqInfo & 0xFF00FFFF | n);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "vip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      paramTroopManager = Long.toString(l2);
      localObject = paramacff.e(paramTroopManager);
      n = k;
      if (localObject == null) {
        break;
      }
      localObject = (Friends)((Friends)localObject).clone();
      boolean bool1 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      boolean bool2 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      boolean bool3 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
      boolean bool4 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB);
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "SVIP: " + bool1 + "; VIP: " + bool2 + "; SuperQQ: " + bool3);
      }
      int i4 = 0;
      int i = paramForwardBody.byteAt(4);
      int j = paramForwardBody.byteAt(5);
      if ((j & 0xF0) != 0)
      {
        i2 = 16;
        i3 = 0;
        label2425:
        n = i4;
        if (i3 < 4)
        {
          if ((j & i2) != 0) {
            n = 13 - i3;
          }
        }
        else
        {
          label2450:
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(i), Byte.valueOf(j), Integer.valueOf(n) }));
          }
          if (!bool1) {
            break label2681;
          }
          ((Friends)localObject).superVipInfo = (((Friends)localObject).superVipInfo & 0xFFFF0000 | 0xFFFF & n);
        }
      }
      for (;;)
      {
        if (bool4) {
          ((Friends)localObject).bigClubInfo = (n & 0xFFFF | ((Friends)localObject).bigClubInfo & 0xFFFF0000);
        }
        paramacff.e((Friends)localObject);
        if (this.app.getCurrentAccountUin().equals(paramTroopManager)) {
          ((acle)this.app.getBusinessHandler(13)).notifyUI(100, true, null);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        i3 += 1;
        i2 = (byte)(i2 << 1);
        break label2425;
        if (i != 0)
        {
          i2 = 1;
          i3 = 0;
          for (;;)
          {
            n = i4;
            if (i3 >= 8) {
              break;
            }
            if ((i & i2) != 0)
            {
              n = 9 - i3;
              break;
            }
            i3 += 1;
            i2 = (byte)(i2 << 1);
          }
        }
        n = 1;
        break label2450;
        label2681:
        if (bool2) {
          ((Friends)localObject).qqVipInfo = (((Friends)localObject).qqVipInfo & 0xFFFF0000 | 0xFFFF & n);
        } else if (bool3) {
          ((Friends)localObject).superQqInfo = (((Friends)localObject).superQqInfo & 0xFFFF0000 | 0xFFFF & n);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "svip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      paramTroopManager = Long.toString(l2);
      localObject = paramacff.e(paramTroopManager);
      n = k;
      if (localObject == null) {
        break;
      }
      localObject = (Friends)((Friends)localObject).clone();
      if ((paramForwardBody.byteAt(5) & 0x20) != 0)
      {
        bool1 = true;
        label2827:
        i2 = ((Friends)localObject).superVipInfo;
        if (!bool1) {
          break label3010;
        }
      }
      label3010:
      for (n = 1;; n = 0)
      {
        ((Friends)localObject).superVipInfo = (n << 24 | 0xFFFFFF & i2);
        paramacff.e((Friends)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "isSVip=" + bool1 + "friend.superVipInfo=" + ((Friends)localObject).superVipInfo);
        }
        if (this.app.getCurrentAccountUin().equals(paramTroopManager))
        {
          ((acle)this.app.getBusinessHandler(13)).notifyUI(100, true, null);
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, "[EmoticonUpdateAuth] 23107 updateEmoticonAuth");
          }
          paramForwardBody = (acdz)this.app.getBusinessHandler(12);
          paramForwardBody.gT(0, 0);
          paramForwardBody.I(0, 0, 1, 0);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label2827;
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      n = k;
      if ((paramForwardBody.byteAt(5) & 0x2) == 0) {
        break;
      }
      paramTroopManager = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if ((paramForwardBody.byteAt(1) & 0x2) != 0) {
        n = 2;
      }
      for (;;)
      {
        if (n != -1)
        {
          paramTroopManager.edit().putInt("message_roam_flag" + this.app.getCurrentAccountUin(), n).commit();
          this.app.getBusinessHandler(1).notifyUI(101, true, Integer.valueOf(n));
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        if (paramTroopManager.getInt("message_roam_flag" + this.app.getCurrentAccountUin(), -1) == 2) {
          n = 1;
        } else {
          n = -1;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      if (((paramForwardBody.byteAt(31) & 0x20) != 0) || ((paramForwardBody.byteAt(34) & 0x10) != 0) || ((paramForwardBody.byteAt(29) & 0x10) != 0))
      {
        paramTroopManager = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        if (((paramForwardBody.byteAt(11) & 0x20) == 0) && ((paramForwardBody.byteAt(14) & 0x10) == 0)) {
          break label3563;
        }
        n = 4;
        label3286:
        if (n != -1)
        {
          paramTroopManager.edit().putInt("message_roam_flag" + this.app.getCurrentAccountUin(), n).commit();
          this.app.getBusinessHandler(1).notifyUI(101, true, Integer.valueOf(n));
        }
      }
      if ((paramForwardBody.byteAt(12) & 0x8) != 0)
      {
        bool1 = true;
        label3371:
        anvq.i(this.app, bool1);
        if ((paramForwardBody.byteAt(13) & 0x40) == 0) {
          break label3646;
        }
      }
      label3646:
      for (bool1 = true;; bool1 = false)
      {
        n = k;
        if (SettingCloneUtil.readValue(this.app.getApplication(), Long.toString(l2), null, "qqsetting_pcactive_key", false) == bool1) {
          break;
        }
        SettingCloneUtil.writeValue(this.app.getApplication(), Long.valueOf(l2).toString(), null, "qqsetting_pcactive_key", bool1);
        paramForwardBody = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
        paramForwardBody.putExtra("pcActive", bool1);
        paramForwardBody.putExtra("uin", Long.valueOf(l2).toString());
        this.app.getApp().sendBroadcast(paramForwardBody);
        if (bool1)
        {
          SettingCloneUtil.writeValue(this.app.getApplication(), Long.toString(l2), null, "pcactive_config", true);
          this.app.openMsfPCActive(Long.toString(l2), "config", true);
          QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
        label3563:
        if ((paramForwardBody.byteAt(9) & 0x10) != 0)
        {
          n = 3;
          break label3286;
        }
        n = paramTroopManager.getInt("message_roam_flag" + this.app.getCurrentAccountUin(), -1);
        if ((n == 4) || (n == 3))
        {
          n = 1;
          break label3286;
        }
        n = -1;
        break label3286;
        bool1 = false;
        break label3371;
      }
      long l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asLongBuffer().get();
      paramTroopManager = paramacff.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      paramForwardBody.pendantId = l1;
      paramForwardBody.timestamp = System.currentTimeMillis();
      paramacff.a(paramForwardBody);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + l2 + ", id=" + paramForwardBody.pendantId);
      }
      paramForwardBody = new HashSet(1);
      paramForwardBody.add(String.valueOf(l2));
      this.app.getBusinessHandler(1).notifyUI(66, true, paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = paramacff.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      if ((paramForwardBody.uVipFont != ku.h(paramInt)) || (paramForwardBody.vipFontType != ku.c(paramInt)))
      {
        paramForwardBody.uVipFont = ku.h(paramInt);
        paramForwardBody.vipFontType = ku.c(paramInt);
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramacff.a(paramForwardBody);
        aqnl.H(this.app);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + l2 + ", id=" + paramForwardBody.uVipFont + ", type = " + paramForwardBody.vipFontType);
      }
      n = (int)ku.h(paramInt);
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramTroopManager = paramacff.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
        paramForwardBody.magicFont = -1;
      }
      if (paramForwardBody.magicFont != i2)
      {
        paramForwardBody.magicFont = i2;
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramacff.a(paramForwardBody);
        aqnl.H(this.app);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get MagicFont uin = " + l2 + ", magicFont = " + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramTroopManager = paramacff.a(String.valueOf(l2));
      n = 0;
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
        paramForwardBody.fontEffect = -1;
        n = 1;
      }
      if (paramForwardBody.fontEffect != i2)
      {
        paramForwardBody.fontEffect = i2;
        paramForwardBody.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
        ((ku)this.app.getManager(42)).eT();
        n = 1;
      }
      if (n != 0) {
        paramacff.a(paramForwardBody);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get fontEffect uin = " + l2 + ", fontEffect = " + i2 + ", updateTime = " + paramForwardBody.fontEffectLastUpdateTime);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      k = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      n = k;
      if (k == 0) {
        break;
      }
      n = 1;
      m = paramInt;
      paramInt = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = paramacff.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      if (paramForwardBody.colorRingId != n)
      {
        paramForwardBody.colorRingId = n;
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramacff.a(paramForwardBody);
        aqpr.af(paramForwardBody.uin, 1, this.app.getCurrentAccountUin());
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + l2 + ", id=" + paramForwardBody.colorRingId);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramTroopManager = paramForwardBody.bytes_value.get();
      n = paramForwardBody.uint32_field.get();
      if ((n >= 42005) && (n <= 42012))
      {
        ByteBuffer.wrap(paramTroopManager.toByteArray()).asShortBuffer().get();
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
      }
      ByteBuffer.wrap(paramTroopManager.toByteArray()).asIntBuffer().get();
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramabhh.b(String.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l2 + ", avip flag: " + i2);
      }
      n = k;
      if (paramForwardBody.apolloVipFlag == i2) {
        break;
      }
      paramForwardBody.apolloVipFlag = i2;
      paramabhh.a(paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramabhh.b(String.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l2 + ", avip level: " + i2);
      }
      n = k;
      if (paramForwardBody.apolloVipLevel == i2) {
        break;
      }
      paramForwardBody.apolloVipLevel = i2;
      paramabhh.a(paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramabhh.b(String.valueOf(l2));
      if ((QLog.isColorLevel()) || (l2 == this.app.getLongAccountUin())) {
        QLog.d("Q.msg.BaseMessageProcessor", 1, "apollo push uin: " + l2 + ", apollo status: " + n);
      }
      if (paramForwardBody.apolloStatus != n)
      {
        paramForwardBody.apolloStatus = n;
        paramabhh.a(paramForwardBody);
        if ((l2 == this.app.getLongAccountUin()) && (paramForwardBody.isApolloStatusOpen()) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
        {
          paramForwardBody = (aqrb)this.app.getBusinessHandler(71);
          if (paramForwardBody != null) {
            paramForwardBody.Vw("statusChange");
          }
        }
      }
      paramTroopManager = String.valueOf(l2);
      if (l2 == this.app.getLongAccountUin())
      {
        paramForwardBody = new Pair(paramTroopManager, Integer.valueOf(n));
        this.app.getBusinessHandler(71).notifyUI(3, true, paramForwardBody);
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
      }
      paramForwardBody = new ArrayList();
      paramForwardBody.add(paramTroopManager);
      paramTroopManager = abrj.a(this.app);
      if (paramTroopManager != null) {
        paramTroopManager.i(n, paramForwardBody);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = String.valueOf(l2);
      if (TextUtils.isEmpty(paramForwardBody))
      {
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
      }
      paramTroopManager = paramabhh.b(paramForwardBody);
      if (paramForwardBody.equals(this.app.getCurrentUin())) {
        ((aqrb)this.app.getBusinessHandler(71)).d(new long[] { l2 });
      }
      QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "apollo push uin: " + new StringBuilder().append(l2).append("temp").toString().substring(0, 4) + ", timeStamp: " + n, ", local server:", Long.valueOf(paramTroopManager.apolloServerTS) });
      if (paramTroopManager.apolloServerTS != n)
      {
        paramTroopManager.apolloServerTS = n;
        paramabhh.a(paramTroopManager);
      }
      n = 0;
      paramTroopManager = this.app.b();
      i2 = n;
      if (paramTroopManager != null)
      {
        i2 = n;
        if (paramTroopManager.Op())
        {
          i2 = n;
          if (!TextUtils.isEmpty(paramTroopManager.oA()))
          {
            i2 = n;
            if (paramTroopManager.vc() == 0)
            {
              i2 = n;
              if (paramTroopManager.oA().equals(paramForwardBody)) {
                i2 = 1;
              }
            }
          }
        }
      }
      if ((!paramForwardBody.equals(this.app.getCurrentUin())) || (abhh.x(this.app) != 2))
      {
        n = k;
        if (i2 == 0) {
          break;
        }
      }
      paramForwardBody = (aqrb)this.app.getBusinessHandler(71);
      paramTroopManager = new ArrayList();
      paramTroopManager.add(Long.valueOf(l2));
      paramForwardBody.m(paramTroopManager, "online_push");
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = k;
      if (l2 != this.app.getLongAccountUin()) {
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (n != abhh.a(this.app))
      {
        paramForwardBody = (abhh)this.app.getManager(153);
        paramForwardBody.Hf(n);
        if (n == 1)
        {
          paramForwardBody = paramForwardBody.b(this.app.getCurrentUin());
          if ((paramForwardBody.isApolloStatusOpen()) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
          {
            paramForwardBody = (aqrb)this.app.getBusinessHandler(71);
            if (paramForwardBody != null) {
              paramForwardBody.Vw("whiteList");
            }
          }
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push white list: " + n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramabhh.b(String.valueOf(l2));
      long l3 = NetConnInfoCenter.getServerTime();
      if ((l1 > l3) && (paramForwardBody.apolloSignValidTS != l1))
      {
        paramForwardBody.apolloLocalSignTs = paramForwardBody.apolloSignValidTS;
        paramForwardBody.apolloSignValidTS = l1;
        paramForwardBody.apolloSignStr = "";
        paramabhh.a(paramForwardBody);
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push sign uin: " + l2 + ", valid TS: " + l1 + ", currTS: " + l3);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      if (paramabhh != null)
      {
        paramForwardBody = paramabhh.b(this.app.getCurrentUin());
        if ((paramForwardBody != null) && (n != paramForwardBody.apolloAISwitch))
        {
          paramForwardBody.apolloAISwitch = n;
          if ((this.app != null) && (String.valueOf(l2).equals(this.app.getCurrentUin()))) {
            paramabhh.gB(n, 2);
          }
          paramabhh.a(paramForwardBody);
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo aiSwitch  push: " + n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (i2 = paramForwardBody[0];; i2 = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        localObject = String.valueOf(l2);
        paramForwardBody = paramabhh.b((String)localObject);
        QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "cmshow_online_push,  uin: ", ApolloUtil.iY((String)localObject), ", cmshow3dFlag: ", Integer.valueOf(i2), ", local=", Integer.valueOf(paramForwardBody.cmshow3dFlag) });
        if (paramForwardBody.cmshow3dFlag != i2)
        {
          n = paramForwardBody.cmshow3dFlag;
          paramForwardBody.cmshow3dFlag = i2;
          paramabhh.a(paramForwardBody);
          if (this.app.getCurrentAccountUin().equals(String.valueOf(l2))) {
            paramabhh.gD(n, i2);
          }
          paramTroopManager = new ArrayList();
          paramTroopManager.add(localObject);
          localObject = abrj.a(this.app);
          if (localObject != null) {
            ((abrg)localObject).i(3, paramTroopManager);
          }
        }
        n = k;
        if ((i2 & 0x1) != 1) {
          break;
        }
        n = k;
        if (paramForwardBody.getApolloDress3D() != null) {
          break;
        }
        paramabhh.da("" + l2, abhh.coJ);
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
      }
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramacff.b(l2 + "");
      paramTroopManager = paramacff.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingGameId = l1;
        paramacff.a(paramForwardBody);
        this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.namePlateOfKingGameId = l1;
        paramacff.e(paramTroopManager);
        this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push gameId = " + l1 + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramacff.b(l2 + "");
      paramTroopManager = paramacff.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingLoginTime = l1;
        paramacff.a(paramForwardBody);
        this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.namePlateOfKingLoginTime = l1;
        paramacff.e(paramTroopManager);
        this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push gameLoginTime = " + l1 + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramacff.b(l2 + "");
      paramTroopManager = paramacff.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingDan = n;
        paramacff.a(paramForwardBody);
        this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.namePlateOfKingDan = n;
        paramacff.e(paramTroopManager);
        this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDan = " + n + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramacff.b(l2 + "");
      paramTroopManager = paramacff.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        if (n == 1)
        {
          bool1 = true;
          label6852:
          paramForwardBody.namePlateOfKingDanDisplatSwitch = bool1;
          paramacff.a(paramForwardBody);
          this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
        }
      }
      else if (paramTroopManager != null) {
        if (n != 1) {
          break label6980;
        }
      }
      label6980:
      for (bool1 = true;; bool1 = false)
      {
        paramTroopManager.namePlateOfKingDanDisplatSwitch = bool1;
        paramacff.e(paramTroopManager);
        this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
        QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDanDisplatSwitch = " + n + ", uin = " + l2);
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label6852;
      }
      paramForwardBody = ((TicketManager)this.app.getManager(2)).getSkey(l2 + "");
      ((acny)this.app.getBusinessHandler(27)).fg(paramForwardBody, l2 + "");
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = k;
      if (!paramForwardBody.uint32_field.has()) {
        break;
      }
      n = k;
      if (!paramForwardBody.bytes_value.has()) {
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42344 = " + n);
      }
      paramForwardBody = paramacff.b(l2 + "");
      paramTroopManager = paramacff.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.nameplateVipType = n;
        paramacff.a(paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.nameplateVipType = n;
        paramacff.e(paramTroopManager);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = k;
      if (!paramForwardBody.uint32_field.has()) {
        break;
      }
      n = k;
      if (!paramForwardBody.bytes_value.has()) {
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42354 = " + n);
      }
      paramForwardBody = paramacff.b(l2 + "");
      paramTroopManager = paramacff.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.grayNameplateFlag = n;
        paramacff.a(paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.grayNameplateFlag = n;
        paramacff.e(paramTroopManager);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club level change=" + n);
        }
        paramForwardBody = paramacff.b(l2 + "");
        paramTroopManager = paramacff.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.iBigClubVipLevel = n;
          paramacff.a(paramForwardBody);
          this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
        }
        if (paramTroopManager != null)
        {
          paramTroopManager.bigClubInfo = (n & 0xFFFF | paramTroopManager.bigClubInfo & 0xFFFF0000);
          paramacff.e(paramTroopManager);
          this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
        }
        paramForwardBody = ((TicketManager)this.app.getManager(2)).getSkey(l2 + "");
        ((acny)this.app.getBusinessHandler(27)).fg(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramacff.b(l2 + "");
        paramTroopManager = paramacff.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.iBigClubVipType = n;
          paramacff.a(paramForwardBody);
          this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
        }
        if (paramTroopManager != null)
        {
          paramTroopManager.bigClubInfo = (paramTroopManager.bigClubInfo & 0xFFFFFF | (n & 0xFF) << 24);
          paramacff.e(paramTroopManager);
          this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club type change=" + n);
        }
        paramForwardBody = ((TicketManager)this.app.getManager(2)).getSkey(l2 + "");
        ((acny)this.app.getBusinessHandler(27)).fg(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramacff.b(l2 + "");
        paramTroopManager = paramacff.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.lBigClubTemplateId = n;
          paramForwardBody.lSuperVipTemplateId = n;
          paramacff.a(paramForwardBody);
          this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
        }
        if (paramTroopManager != null)
        {
          paramTroopManager.superVipTemplateId = n;
          paramTroopManager.bigClubTemplateId = n;
          paramacff.e(paramTroopManager);
          this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club iVipType change = " + n);
        }
        paramForwardBody = paramacff.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.bigClubInfo = ((n & 0xFF) << 16 | paramForwardBody.bigClubInfo & 0xFF00FFFF);
          paramacff.e(paramForwardBody);
          this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
        }
        paramForwardBody = ((TicketManager)this.app.getManager(2)).getSkey(l2 + "");
        ((acny)this.app.getBusinessHandler(27)).fg(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      n = 0;
      if (paramForwardBody.length == 1) {
        n = paramForwardBody[0];
      }
      for (;;)
      {
        paramForwardBody = paramacff.b(l2 + "");
        if ((paramForwardBody != null) && (paramForwardBody.mQQLevelType != n))
        {
          paramForwardBody.mQQLevelType = n;
          paramacff.a(paramForwardBody);
          this.app.getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        if (paramForwardBody.length == 2) {
          n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get();
        } else if (paramForwardBody.length == 4) {
          n = ByteBuffer.wrap(paramForwardBody).asIntBuffer().get();
        } else {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_QQ_LEVEL_ICON_TYPE flag content error, len:" + paramForwardBody.length);
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramacff.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.cNewLoverDiamondFlag = n;
          paramacff.e(paramForwardBody);
          this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(l2));
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = paramacff.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      paramForwardBody.pendantDiyId = n;
      paramForwardBody.timestamp = System.currentTimeMillis();
      paramacff.a(paramForwardBody);
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get PendantDiyId, uin=" + l2 + ", id=" + paramForwardBody.pendantDiyId);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      ((aqrc)this.app.getManager(235)).a.gu(Long.toString(l2), n);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get faceId, uin=" + l2 + ", id=" + n);
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = (BubbleManager)this.app.getManager(44);
      label8872:
      label8950:
      short s;
      if (paramTroopManager != null)
      {
        if (n == 0)
        {
          bool1 = true;
          paramTroopManager.GM(bool1);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("bubble unread feature push %s", new Object[] { "" + n }));
        }
        paramTroopManager = paramForwardBody.bytes_value.get().toByteArray();
        if (paramTroopManager.length != 1) {
          break label9080;
        }
        if (paramTroopManager[0] != 1) {
          break label9074;
        }
        bool1 = true;
        paramTroopManager = (aizh)this.app.getManager(303);
        s = (short)paramForwardBody.uint32_field.get();
        if (bool1) {
          break label9106;
        }
      }
      label9106:
      for (bool2 = true;; bool2 = false)
      {
        paramTroopManager.a(s, false, "", bool2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "push temp msg block,uin=" + l2 + ", id=" + bool1 + " field=" + paramForwardBody.uint32_field.get());
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label8872;
        label9074:
        bool1 = false;
        break label8950;
        label9080:
        if (ByteBuffer.wrap(paramTroopManager).asShortBuffer().get() == 1) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      l1 = -1L;
      if (paramForwardBody.length == 4)
      {
        i2 = ByteBuffer.wrap(new byte[] { paramForwardBody[3] }).get();
        n = i2;
        if (i2 == 1) {
          l1 = ByteBuffer.wrap(new byte[] { paramForwardBody[2], paramForwardBody[1] }).asShortBuffer().get();
        }
      }
      for (n = i2;; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = aktk.a(n);
        paramTroopManager = this.app.getOnlineStatus();
        l3 = akti.a().k(this.app);
        if ((paramForwardBody != paramTroopManager) || (l3 != l1))
        {
          this.app.setOnlineStatus(paramForwardBody);
          this.app.setExtOnlineStatus(l1);
          localObject = new Bundle();
          ((Bundle)localObject).putSerializable("onlineStatus", paramForwardBody);
          ((Bundle)localObject).putLong("extOnlineStatus", l1);
          this.app.notifyObservers(AccountObserver.class, 2211, true, (Bundle)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("online new status push code: %s, newStatus: %s, curStatus: %s, ext:%s", new Object[] { Integer.valueOf(n), paramForwardBody, paramTroopManager, Long.valueOf(l1) }));
        }
        if ((paramForwardBody == AppRuntime.Status.online) && (l1 == 1000L) && ((paramTroopManager != paramForwardBody) || (l1 != l3)))
        {
          this.app.cLB();
          this.app.a(paramForwardBody, l1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "udc reset battery status");
          }
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      bool1 = ThemeUtil.isNowThemeIsSimple(this.app, false, null);
      if ((!bool1) && (aogc.pX(String.valueOf(i2)))) {
        if (!ThemeSwitcher.pZ(String.valueOf(i2))) {
          ThemeSwitcher.a(String.valueOf(i2), "209", null);
        }
      }
      for (;;)
      {
        n = k;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "theme online push " + paramForwardBody.uint32_field.get() + " themeId:" + i2 + " isSimpleMode：" + bool1);
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
        aohc.a(this.app, String.valueOf(i2), "20000000");
      }
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = (ChatBackgroundManager)this.app.getManager(63);
      if (paramTroopManager != null) {
        paramTroopManager.a(i2, 0, null, "onlinePush", -1);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, " bg online push " + paramForwardBody.uint32_field.get() + " bgId:" + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      aqsd.XT(i2);
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, " theme font online push " + paramForwardBody.uint32_field.get() + " id:" + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {
        if (paramForwardBody[0] == 0) {
          bool1 = true;
        }
      }
      for (;;)
      {
        yhf.a(this.app).zY(bool1);
        this.app.getBusinessHandler(2).notifyUI(104, true, Boolean.valueOf(bool1));
        n = k;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.msg.BaseMessageProcessor", 2, "handleModProfileBranch emotionRec flag:" + bool1);
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
        bool1 = false;
        continue;
        if (ByteBuffer.wrap(paramForwardBody).asShortBuffer().get() == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      label9978:
      SharedPreferences.Editor localEditor;
      if (paramForwardBody.length > 1) {
        if (paramForwardBody[1] == 1)
        {
          bool1 = true;
          QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value:" + bool1);
          bool2 = bool1;
          if (bool1)
          {
            paramForwardBody = (aemd)aeif.a().o(442);
            bool2 = bool1;
            if (paramForwardBody != null)
            {
              bool2 = bool1;
              if (!paramForwardBody.isOpen())
              {
                QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "get ptt auto to txt push switch is true but config is close!!");
                bool2 = false;
              }
            }
          }
          paramForwardBody = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
          paramTroopManager = "businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin();
          localObject = "businessinfo_ptt_auto_change_time_" + this.app.getCurrentAccountUin();
          String str = "businessinfo_ptt_auto_change_guide_has_show_" + this.app.getCurrentAccountUin();
          localEditor = paramForwardBody.edit();
          localEditor.putBoolean(paramTroopManager, bool2);
          l1 = NetConnInfoCenter.getServerTime();
          if (!bool2) {
            break label10253;
          }
          localEditor.putLong((String)localObject, l1);
          paramForwardBody.edit().putBoolean(str, true);
          label10214:
          localEditor.commit();
          xla.bhz = bool2;
          xla.Jb = l1;
        }
      }
      for (;;)
      {
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label9978;
        label10253:
        localEditor.putLong((String)localObject, 9223372036854775807L);
        break label10214;
        QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value is null");
        paramForwardBody = (CardHandler)this.app.getBusinessHandler(2);
        paramTroopManager = new ArrayList();
        paramTroopManager.add(Short.valueOf((short)-23249));
        paramForwardBody.d(paramTroopManager, null);
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 27370, changed global ring id", " ringId: ", Integer.valueOf(n) });
      }
      aean.a(this.app).LR(n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 42360, changed troopHonorSwitch", " troopHonorSwitch: ", Integer.valueOf(i2) });
      }
      paramForwardBody = paramacff.b(l2 + "");
      n = k;
      if (paramForwardBody == null) {
        break;
      }
      bool2 = paramForwardBody.troopHonorSwitch;
      if (i2 == 0)
      {
        bool1 = true;
        label10509:
        if (bool2 != bool1) {
          if (i2 != 0) {
            break label10597;
          }
        }
      }
      label10597:
      for (bool1 = true;; bool1 = false)
      {
        paramForwardBody.troopHonorSwitch = bool1;
        paramacff.a(paramForwardBody);
        this.app.getBusinessHandler(2).notifyUI(113, true, Boolean.valueOf(paramForwardBody.troopHonorSwitch));
        ((acms)this.app.getBusinessHandler(20)).notifyUI(80, true, null);
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label10509;
      }
      n = i1;
      if (m != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "Onlinepush hasDiyFontTimestamp: uin = " + l2 + " fontid = " + paramInt + " timestamp = " + k);
        }
        paramacff = paramacff.a(String.valueOf(l2));
        paramForwardBody = paramacff;
        if (paramacff == null)
        {
          paramForwardBody = new ExtensionInfo();
          paramForwardBody.uin = String.valueOf(l2);
        }
        m = paramInt;
        if (paramInt == 0) {
          m = (int)paramForwardBody.uVipFont;
        }
        ku.a(this.app, String.valueOf(l2), paramForwardBody, m, k);
        n = i1;
      }
      return n;
      i3 = -1;
      i2 = n;
      n = i3;
      continue;
      i2 = -1;
      n = -1;
    }
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    paramMsgInfo = paramMsgInfo.vMsg;
    aqoj.getLongData(paramMsgInfo, 0);
    int i = paramMsgInfo[4];
    aqoj.getLongData(paramMsgInfo, 5);
    aqoj.getLongData(paramMsgInfo, 9);
    aqoj.getLongData(paramMsgInfo, 13);
    i = paramMsgInfo[17];
    aqoj.getLongData(paramMsgInfo, 18);
    aqoj.b(paramMsgInfo, 22);
    aqoj.b(paramMsgInfo, 24);
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    this.app.cxj = paramSvcReqPushMsg.wUserActive;
    String str1;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    long l3;
    int n;
    ArrayList localArrayList4;
    label152:
    MsgInfo localMsgInfo;
    if ((paramSvcReqPushMsg.wGeneralFlag & 0x20) == 32)
    {
      aqel.setMute(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "OnlinePush.ReqPush,notify.wUserActive:", Integer.valueOf(paramSvcReqPushMsg.wUserActive), ", muteGeneralFlag:", Integer.valueOf(paramSvcReqPushMsg.wGeneralFlag) });
      }
      str1 = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
      localArrayList1 = new ArrayList();
      localArrayList2 = paramSvcReqPushMsg.vMsgInfos;
      if ((localArrayList2 == null) || (localArrayList2.size() <= 0)) {
        break label2314;
      }
      localArrayList3 = new ArrayList();
      l3 = paramSvcReqPushMsg.lUin;
      n = paramSvcReqPushMsg.svrip;
      localArrayList4 = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      if (!localIterator.hasNext()) {
        break label2085;
      }
      localMsgInfo = (MsgInfo)localIterator.next();
    }
    for (;;)
    {
      long l2;
      long l1;
      long l4;
      label511:
      MessageRecord localMessageRecord;
      try
      {
        new ArrayList();
        j = localMsgInfo.shMsgType;
        localObject = null;
        l2 = localMsgInfo.lFromUin;
        l1 = localMsgInfo.lFromUin;
        if (paramFromServiceMsg.getUin() != null) {
          continue;
        }
        paramToServiceMsg = Long.valueOf(this.app.getAccount());
        l4 = paramToServiceMsg.longValue();
        if (l4 == l2) {}
        paramToServiceMsg = new DelMsgInfo();
        ((acff)this.app.getManager(51)).hu(localMsgInfo.lFromUin);
        paramToServiceMsg.lFromUin = localMsgInfo.lFromUin;
        paramToServiceMsg.shMsgSeq = localMsgInfo.shMsgSeq;
        paramToServiceMsg.uMsgTime = localMsgInfo.uMsgTime;
        paramToServiceMsg.vMsgCookies = localMsgInfo.vMsgCookies;
        localArrayList3.add(paramToServiceMsg);
        if ((42 != j) && (83 != j) && (127 != j) && (QLog.isColorLevel())) {
          achp.a("Q.msg.BaseMessageProcessor", str1, localMsgInfo.shMsgSeq, String.valueOf(l3), String.valueOf(localMsgInfo.lFromUin));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + localMsgInfo.lFromUin + " msgInfo.shMsgType: " + localMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + localMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + localMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + localMsgInfo.lMsgUid);
        }
        if (!acrf.af().containsKey(Integer.valueOf(j))) {
          continue;
        }
        paramToServiceMsg = b(j, localMsgInfo, paramSvcReqPushMsg);
        if (paramToServiceMsg == null) {
          break label2248;
        }
        if (paramToServiceMsg.h != null) {
          localArrayList1.add(paramToServiceMsg.h);
        }
        if (paramToServiceMsg.aQc) {
          break label152;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        String str2;
        label584:
        paramToServiceMsg.printStackTrace();
        if ((localMsgInfo.vMsg == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + aqhs.bytes2HexStr(localMsgInfo.vMsg));
        continue;
      }
      if (paramToServiceMsg != null)
      {
        localMessageRecord = anbi.d(i);
        if (j != 1006) {
          break label2055;
        }
        str2 = aqgv.y(this.app, String.valueOf(l2));
        localMessageRecord.init(String.valueOf(l3), aqgv.y(this.app, String.valueOf(l1)), str2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
        localMessageRecord.shmsgseq = localMsgInfo.shMsgSeq;
        localMessageRecord.isread = bool1;
        localMessageRecord.msgUid = localMsgInfo.lMsgUid;
        localMessageRecord.msgData = ((byte[])localObject);
        if (k > 0) {
          localMessageRecord.extraflag = k;
        }
        if (!achp.a(this.app, localMessageRecord, true)) {
          localArrayList1.add(localMessageRecord);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + l1 + " msgType: " + i + " friendType: " + j + " shMsgSeq: " + localMsgInfo.shMsgSeq + " msgContent: " + aqft.pk(paramToServiceMsg));
        }
      }
      if (localMsgInfo.uAppShareID <= 0L) {
        break label152;
      }
      localArrayList4.add(aqgb.bM(localMsgInfo.uAppShareID));
      break label152;
      aqel.setMute(false);
      break;
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
      continue;
      if (169 == j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + localArrayList2.size());
        }
        if (achp.a(this.app, 0, String.valueOf(l1), String.valueOf(l2), localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq)) {
          break label152;
        }
        localArrayList3.remove(paramToServiceMsg);
        paramToServiceMsg = new String(localMsgInfo.vMsg) + localMsgInfo.uMsgTime;
        if (!this.app.a().a().kJ(paramToServiceMsg))
        {
          paramToServiceMsg = new long[1];
          paramToServiceMsg[0] = localMsgInfo.lFromUin;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
          }
          a(String.valueOf(l1), l3, paramToServiceMsg, localMsgInfo.vMsg, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq, false);
          localMsgInfo.lFromUin = paramToServiceMsg[0];
          break label152;
        }
        if (!QLog.isColorLevel()) {
          break label152;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
        break label152;
      }
      if (8 == j)
      {
        paramToServiceMsg = new byte[4];
        if (localMsgInfo.vMsg.length > 4) {
          aqoj.copyData(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
        }
        l2 = aqoj.getLongData(paramToServiceMsg, 0);
        if (localMsgInfo.vMsg.length >= 9)
        {
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          aqoj.copyData(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(anbk.B(paramToServiceMsg), "utf-8");
          break label2270;
        }
      }
      else
      {
        if (132 == j)
        {
          paramToServiceMsg = new byte[4];
          if (localMsgInfo.vMsg.length > 4) {
            aqoj.copyData(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
          }
          l2 = aqoj.getLongData(paramToServiceMsg, 0);
          paramToServiceMsg = (ToServiceMsg)localObject;
          if (localMsgInfo.vMsg.length < 9) {
            break label2292;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          aqoj.copyData(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(anbk.B(paramToServiceMsg), "utf-8");
          break label2292;
        }
        if (732 == j)
        {
          if (localMsgInfo.vMsg == null) {
            return;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length];
          aqoj.copyData(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, paramToServiceMsg.length);
          i = paramToServiceMsg[4];
          if (!QLog.isColorLevel()) {
            break label2315;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + aqoj.getLongData(localMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + localMsgInfo.shMsgSeq);
          break label2315;
          label1358:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2339;
          }
          paramToServiceMsg = (apuf)this.app.getManager(81);
          localObject = new byte[localMsgInfo.vMsg.length - 7];
          aqoj.copyData((byte[])localObject, 0, localMsgInfo.vMsg, 7, localObject.length);
          paramToServiceMsg = paramToServiceMsg.a(this.app, (byte[])localObject, localMsgInfo.shMsgSeq, localMsgInfo.uRealMsgTime, false, false, null);
          if (paramToServiceMsg == null) {
            break label2339;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2339;
          label1450:
          ((apsw)this.app.getManager(48)).f(paramToServiceMsg, localMsgInfo.shMsgSeq);
          break label2339;
          label1475:
          if (i == 15)
          {
            c(paramToServiceMsg, localMsgInfo.shMsgSeq);
            return;
          }
          if (i != 6) {
            break label2378;
          }
          ah(paramToServiceMsg);
          break label2339;
          label1509:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2339;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 7];
          aqoj.copyData(paramToServiceMsg, 0, localMsgInfo.vMsg, 7, paramToServiceMsg.length);
          f(paramToServiceMsg, i);
          break label2339;
        }
        if (230 == j)
        {
          paramToServiceMsg = new String(anbk.B(localMsgInfo.vMsg), "utf-8");
          localObject = ((acff)this.app.getManager(51)).e(l1 + "");
          if ((localObject != null) && (((Friends)localObject).isFriend())) {}
          for (j = 0;; j = 1006)
          {
            label1636:
            localObject = new SafeMsg.SafeMoreInfo();
            ((SafeMsg.SafeMoreInfo)localObject).strFromMobile.set(localMsgInfo.strFromMobile);
            ((SafeMsg.SafeMoreInfo)localObject).strFromName.set(localMsgInfo.strFromName);
            ((SafeMsg.SafeMoreInfo)localObject).strMsgTxt.set(paramToServiceMsg);
            localObject = ((SafeMsg.SafeMoreInfo)localObject).toByteArray();
            i = -1002;
            k = -1;
            bool1 = true;
            break;
            localObject = ((ajdo)this.app.getManager(11)).di(String.valueOf(l2));
            if ((localObject == null) || (((String)localObject).length() == 0)) {
              break label2395;
            }
          }
        }
        if (SystemMsg.isSystemMessage(j))
        {
          this.app.a().a().Kg(2);
          l1 = 9998L;
          i = -1006 - (j - 187);
          this.app.a().a().a(l3, localMsgInfo.lFromUin, j, i, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
          bool1 = false;
          k = -1;
          localObject = null;
          paramToServiceMsg = null;
          j = 0;
          continue;
        }
        if (SystemMsg.isTroopSystemMessage(j))
        {
          this.app.a().a().Kg(3);
          if (j == 45)
          {
            paramToServiceMsg = a(localMsgInfo, l3);
            if ((paramToServiceMsg == null) || (achp.a(this.app, paramToServiceMsg, true))) {
              break label2403;
            }
            localArrayList1.add(paramToServiceMsg);
            break label2403;
          }
        }
      }
      for (;;)
      {
        anze.a().a(l2, localMsgInfo.uMsgTime, this.app);
        k = i;
        localObject = null;
        paramToServiceMsg = null;
        int m = 0;
        bool1 = false;
        i = j;
        j = m;
        break label511;
        this.app.a().a().a(j, localMsgInfo.vMsg, localMsgInfo.lFromUin, localMsgInfo.uMsgTime, null);
        l1 = 9998L;
        i = 32769;
        j = SystemMsg.getTroopSystemMsgType(j);
        continue;
        if (528 == j)
        {
          paramToServiceMsg = b(localMsgInfo, l4);
          if ((paramToServiceMsg == null) || (achp.a(this.app, paramToServiceMsg, true))) {
            break label2414;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2414;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
        break;
        label2055:
        localMessageRecord.init(l3, l1, l2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
        break label584;
        label2085:
        if (localArrayList4.size() > 0) {
          cM(localArrayList4);
        }
        i = paramFromServiceMsg.getRequestSsoSeq();
        this.app.a().a(l3, localArrayList3, n, i, null);
        boolean bool2;
        if (localArrayList1.size() > 0)
        {
          bool2 = achp.F(localArrayList1);
          i = top.a(localArrayList1, this.app);
          paramToServiceMsg = this.app.b();
          if ((!bool2) || (!this.app.isBackground_Stop)) {
            break label2237;
          }
        }
        label2237:
        for (bool1 = true;; bool1 = false)
        {
          paramToServiceMsg.c(localArrayList1, String.valueOf(l3), bool1);
          this.app.a().UG((int)paramSvcReqPushMsg.uMsgTime);
          a("handleGetBuddyMessageResp", true, i, this.a.aO(bool2), false);
          this.app.a().dI(localArrayList1);
          return;
        }
        paramToServiceMsg = null;
        break label2270;
        label2248:
        bool1 = false;
        k = -1;
        localObject = null;
        paramToServiceMsg = null;
        i = -1000;
        j = 0;
        break label511;
        label2270:
        j = 1000;
        i = -1000;
        k = -1;
        localObject = null;
        bool1 = false;
        break label511;
        label2292:
        j = 1020;
        i = -1000;
        k = -1;
        localObject = null;
        bool1 = false;
        break label511;
        label2314:
        return;
        label2315:
        if ((i == 16) || (i == 17)) {
          break label1358;
        }
        if (i == 20) {
          break label1358;
        }
        label2339:
        label2378:
        do
        {
          bool1 = false;
          k = -1;
          localObject = null;
          paramToServiceMsg = null;
          i = -1000;
          j = 0;
          break;
          if (i == 12) {
            break label1450;
          }
          if (i != 14) {
            break label1475;
          }
          break label1450;
          if (i == 11) {
            break label1509;
          }
        } while (i != 13);
        break label1509;
        label2395:
        j = 1000;
        break label1636;
        label2403:
        i = -1;
        j = -1000;
      }
      label2414:
      boolean bool1 = false;
      int k = -1;
      Object localObject = null;
      paramToServiceMsg = null;
      int i = -1000;
      int j = 0;
    }
  }
  
  private void a(String paramString, long paramLong1, long[] paramArrayOfLong, byte[] paramArrayOfByte, long paramLong2, short paramShort, boolean paramBoolean)
  {
    paramLong1 = paramArrayOfLong[0];
    paramArrayOfByte = aojs.a(paramArrayOfByte, paramArrayOfLong);
    if (paramArrayOfByte != null) {
      this.app.a().a(paramString, String.valueOf(paramArrayOfLong[0]), paramArrayOfByte, paramLong2, paramShort, paramLong1, paramBoolean);
    }
  }
  
  private void aa(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessorQ.nearby.video_chat", 2, "handleMsgType0x210SuMsgType0xe4");
    }
    if (this.app != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.nearbyVideoChatPush");
      localIntent.putExtra("uin", this.app.getCurrentUin());
      localIntent.putExtra("pushData", paramArrayOfByte);
      localIntent.setPackage(MobileQQ.getContext().getPackageName());
      NearbyVideoProxyBroadcastReceiver.V(this.app.getApp(), localIntent);
    }
  }
  
  private void ab(byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x116.MsgBody();
    try
    {
      ((submsgtype0x116.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      long l1 = ihk.q(((submsgtype0x116.MsgBody)localObject).uint32_group_id.get());
      long l2 = ihk.q(((submsgtype0x116.MsgBody)localObject).uint32_room_id.get());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x116 qqMainThread;roomId=" + l2 + ";groupId=" + l1);
      }
      if (this.app != null)
      {
        localObject = new Intent("tencent.video.q2v.GvideoMemInviteUpdate");
        ((Intent)localObject).putExtra("uin", this.app.getCurrentUin());
        ((Intent)localObject).putExtra("groupId", l1);
        ((Intent)localObject).putExtra("roomId", l2);
        ((Intent)localObject).putExtra("pushData", paramArrayOfByte);
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        this.app.getApp().sendBroadcast((Intent)localObject);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  private void ac(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = new submsgtype0x117.MsgBody();
        try
        {
          ((submsgtype0x117.MsgBody)localObject).mergeFrom(paramArrayOfByte);
          paramArrayOfByte = ((submsgtype0x117.MsgBody)localObject).rpt_uint32_moudle_id.get();
          l = ((submsgtype0x117.MsgBody)localObject).uint64_uin.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x117 音视频测试环境push,moudleIds==null || moudleIds.size()== 0");
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          long l;
          for (;;)
          {
            paramArrayOfByte.printStackTrace();
          }
          localObject = new StringBuilder(acfp.m(2131709366));
          ((StringBuilder)localObject).append(l);
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            int i = ((Integer)paramArrayOfByte.next()).intValue();
            if (i == 92) {
              ((StringBuilder)localObject).append("|音视频");
            } else if (i == 93) {
              ((StringBuilder)localObject).append("|双人");
            } else if (i == 94) {
              ((StringBuilder)localObject).append("|多人");
            }
          }
          ((StringBuilder)localObject).append("】");
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x117 音视频测试环境push" + ((StringBuilder)localObject).toString());
  }
  
  private void ah(byte[] paramArrayOfByte)
  {
    long l = aqoj.getLongData(paramArrayOfByte, 0);
    String str = String.valueOf(l);
    int i = paramArrayOfByte[5];
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg cOp = " + i);
    }
    int j;
    HotChatManager localHotChatManager;
    HotChatInfo localHotChatInfo;
    if (i == 3)
    {
      j = paramArrayOfByte[10];
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j);
      }
      localHotChatManager = (HotChatManager)this.app.getManager(60);
      localHotChatInfo = localHotChatManager.a(String.valueOf(l));
      if (j == 3)
      {
        int k = paramArrayOfByte[11];
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j + ", cSubOp2 = " + k);
        }
        switch (k)
        {
        }
      }
    }
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
                  do
                  {
                    return;
                  } while (localHotChatInfo == null);
                  localHotChatManager.b(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
                  acfx.a(this.app, localHotChatInfo, this.app.getApp().getString(2131694666), true);
                  acgh.o(this.app, str, 6);
                  ((acfv)this.app.getBusinessHandler(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED });
                  return;
                } while (localHotChatInfo == null);
                localHotChatManager.b(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
                acfx.a(this.app, localHotChatInfo, this.app.getApp().getString(2131694642), true);
                acgh.o(this.app, str, 6);
                ((acfv)this.app.getBusinessHandler(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
                return;
              } while (localHotChatInfo == null);
              localHotChatManager.b(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
              acfx.a(this.app, localHotChatInfo, this.app.getApp().getString(2131694643), true);
              acgh.o(this.app, str, 6);
              ((acfv)this.app.getBusinessHandler(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
              return;
              if (j != 2) {
                break;
              }
            } while (localHotChatInfo == null);
            localHotChatManager.b(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY);
            acfx.a(this.app, localHotChatInfo, this.app.getApp().getString(2131694641), false);
            acgh.o(this.app, str, 6);
            ((acfv)this.app.getBusinessHandler(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY });
            return;
          } while (j != 1);
          paramArrayOfByte = this.app.a();
        } while (paramArrayOfByte == null);
        paramArrayOfByte.am(l, false);
        return;
      } while (i != 1);
      j = paramArrayOfByte[10];
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j);
      }
      paramArrayOfByte = this.app.a();
    } while (paramArrayOfByte == null);
    switch (j)
    {
    default: 
      return;
    case 0: 
    case 2: 
      paramArrayOfByte.am(l, true);
      return;
    case 1: 
      paramArrayOfByte.an(l, false);
      return;
    }
    paramArrayOfByte.an(l, true);
  }
  
  /* Error */
  private MessageRecord b(MsgInfo paramMsgInfo, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 150
    //   8: iconst_2
    //   9: ldc_w 1736
    //   12: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: getfield 1174	OnlinePushPack/MsgInfo:vMsg	[B
    //   19: invokestatic 1741	anas:a	([B)LIMMsgBodyPack/MsgType0x210;
    //   22: astore 32
    //   24: aload 32
    //   26: ifnonnull +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +33 -> 67
    //   37: ldc 150
    //   39: iconst_2
    //   40: new 79	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 1743
    //   50: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 32
    //   55: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   58: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload 32
    //   69: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   72: ldc2_w 1749
    //   75: lcmp
    //   76: ifne +140 -> 216
    //   79: aload 32
    //   81: getfield 1754	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   84: ifnull +132 -> 216
    //   87: aload 32
    //   89: getfield 1754	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -65 -> 29
    //   97: aload_1
    //   98: getfield 1759	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   101: ifnull -72 -> 29
    //   104: aload_1
    //   105: getfield 1759	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   108: astore 28
    //   110: aload 28
    //   112: ifnull -83 -> 29
    //   115: aload 28
    //   117: invokeinterface 1649 1 0
    //   122: ifle -93 -> 29
    //   125: aload_0
    //   126: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 12
    //   131: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 1761	anec
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull -110 -> 29
    //   142: aload 28
    //   144: invokeinterface 126 1 0
    //   149: astore 28
    //   151: aload 28
    //   153: invokeinterface 131 1 0
    //   158: ifeq -129 -> 29
    //   161: aload 28
    //   163: invokeinterface 135 1 0
    //   168: checkcast 1763	IMMsgBodyPack/PluginNum
    //   171: astore 29
    //   173: aload 29
    //   175: ifnull -24 -> 151
    //   178: aload 29
    //   180: getfield 1766	IMMsgBodyPack/PluginNum:dwID	J
    //   183: lstore_2
    //   184: aload 29
    //   186: getfield 1769	IMMsgBodyPack/PluginNum:cFlag	B
    //   189: ifne +21 -> 210
    //   192: iconst_0
    //   193: istore 19
    //   195: aload_1
    //   196: lload_2
    //   197: iload 19
    //   199: aload 29
    //   201: getfield 1772	IMMsgBodyPack/PluginNum:dwNUm	J
    //   204: invokevirtual 1775	anec:c	(JZJ)V
    //   207: goto -56 -> 151
    //   210: iconst_1
    //   211: istore 19
    //   213: goto -18 -> 195
    //   216: aload 32
    //   218: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   221: ifnull +17203 -> 17424
    //   224: aload 32
    //   226: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   229: ldc2_w 1779
    //   232: lcmp
    //   233: ifne +29 -> 262
    //   236: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +12 -> 251
    //   242: ldc 150
    //   244: iconst_2
    //   245: ldc_w 1782
    //   248: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_0
    //   252: aload 32
    //   254: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   257: invokevirtual 1784	tos:Z	([B)V
    //   260: aconst_null
    //   261: areturn
    //   262: aload 32
    //   264: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   267: ldc2_w 1785
    //   270: lcmp
    //   271: ifeq +27 -> 298
    //   274: aload 32
    //   276: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   279: ldc2_w 1787
    //   282: lcmp
    //   283: ifeq +15 -> 298
    //   286: aload 32
    //   288: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   291: ldc2_w 1789
    //   294: lcmp
    //   295: ifne +46 -> 341
    //   298: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +13 -> 314
    //   304: ldc_w 1792
    //   307: iconst_2
    //   308: ldc_w 1794
    //   311: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload_0
    //   315: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: bipush 11
    //   320: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   323: checkcast 1796	com/tencent/mobileqq/app/PublicAccountHandler
    //   326: aload 32
    //   328: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   331: aload 32
    //   333: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   336: invokevirtual 1800	com/tencent/mobileqq/app/PublicAccountHandler:j	(J[B)V
    //   339: aconst_null
    //   340: areturn
    //   341: aload 32
    //   343: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   346: ldc2_w 1801
    //   349: lcmp
    //   350: ifne +41 -> 391
    //   353: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +13 -> 369
    //   359: ldc_w 1804
    //   362: iconst_2
    //   363: ldc_w 1806
    //   366: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_0
    //   370: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   373: bipush 18
    //   375: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   378: checkcast 1808	aclo
    //   381: aload 32
    //   383: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   386: invokevirtual 1811	aclo:aN	([B)V
    //   389: aconst_null
    //   390: areturn
    //   391: aload 32
    //   393: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   396: ldc2_w 1812
    //   399: lcmp
    //   400: ifne +15 -> 415
    //   403: aload_0
    //   404: lload_2
    //   405: aload 32
    //   407: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   410: invokespecial 1816	tos:g	(J[B)V
    //   413: aconst_null
    //   414: areturn
    //   415: aload 32
    //   417: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   420: ldc2_w 1817
    //   423: lcmp
    //   424: ifne +83 -> 507
    //   427: new 1820	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   430: dup
    //   431: invokespecial 1821	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:<init>	()V
    //   434: aload 32
    //   436: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   439: invokevirtual 1822	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   442: checkcast 1820	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   445: getfield 1825	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:uint32_bubble_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   448: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   451: istore 4
    //   453: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq -427 -> 29
    //   459: ldc 21
    //   461: iconst_2
    //   462: new 79	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 1827
    //   472: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: iload 4
    //   477: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aconst_null
    //   487: areturn
    //   488: astore_1
    //   489: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq -463 -> 29
    //   495: ldc 21
    //   497: iconst_2
    //   498: ldc_w 1829
    //   501: aload_1
    //   502: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   505: aconst_null
    //   506: areturn
    //   507: aload 32
    //   509: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   512: ldc2_w 1833
    //   515: lcmp
    //   516: ifne +617 -> 1133
    //   519: new 1836	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody
    //   522: dup
    //   523: invokespecial 1837	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:<init>	()V
    //   526: astore 29
    //   528: aload 29
    //   530: aload 32
    //   532: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   535: invokevirtual 1838	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   538: pop
    //   539: aload 29
    //   541: getfield 1841	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   544: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   547: iconst_1
    //   548: if_icmpne -519 -> 29
    //   551: new 79	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   558: aload 29
    //   560: getfield 1844	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   563: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   566: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   569: ldc 186
    //   571: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: astore_1
    //   578: new 79	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   585: aload 29
    //   587: getfield 1847	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint64_action_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   590: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   593: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   596: ldc 186
    //   598: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: astore 28
    //   606: aload 29
    //   608: getfield 1851	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:source	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   611: invokevirtual 1854	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   614: iconst_2
    //   615: if_icmpne +261 -> 876
    //   618: sipush 1001
    //   621: istore 4
    //   623: aload 29
    //   625: getfield 1858	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:bool_new_friend	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   628: invokevirtual 1862	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   631: ifeq +34 -> 665
    //   634: iconst_0
    //   635: istore 4
    //   637: aload_0
    //   638: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   641: iconst_1
    //   642: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   645: checkcast 252	com/tencent/mobileqq/app/FriendListHandler
    //   648: astore 30
    //   650: aload 30
    //   652: bipush 63
    //   654: iconst_1
    //   655: aload_1
    //   656: invokevirtual 1863	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   659: aload 30
    //   661: aload_1
    //   662: invokevirtual 1866	com/tencent/mobileqq/app/FriendListHandler:DG	(Ljava/lang/String;)V
    //   665: aload 29
    //   667: getfield 1869	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:rpt_msg_business_msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   670: invokevirtual 120	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   673: invokeinterface 126 1 0
    //   678: astore 29
    //   680: aload 29
    //   682: invokeinterface 131 1 0
    //   687: ifeq -658 -> 29
    //   690: aload 29
    //   692: invokeinterface 135 1 0
    //   697: checkcast 1871	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg
    //   700: astore 30
    //   702: aload 30
    //   704: getfield 1874	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:msg_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   707: invokevirtual 1854	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   710: istore 5
    //   712: iload 5
    //   714: iconst_1
    //   715: if_icmpne +169 -> 884
    //   718: sipush -1000
    //   721: invokestatic 1308	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   724: checkcast 1876	com/tencent/mobileqq/data/MessageForText
    //   727: astore 31
    //   729: aload 31
    //   731: aload_1
    //   732: putfield 1879	com/tencent/mobileqq/data/MessageForText:frienduin	Ljava/lang/String;
    //   735: aload_0
    //   736: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   739: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   742: aload 28
    //   744: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   747: ifeq +9 -> 756
    //   750: aload 31
    //   752: iconst_1
    //   753: putfield 1882	com/tencent/mobileqq/data/MessageForText:issend	I
    //   756: aload 31
    //   758: aload_0
    //   759: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   762: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   765: aload_1
    //   766: aload 28
    //   768: aload 30
    //   770: getfield 1885	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bytes_msg_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   773: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   776: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   779: invokestatic 622	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   782: sipush -1000
    //   785: iload 4
    //   787: aload_0
    //   788: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   791: invokevirtual 739	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   794: aload_1
    //   795: iload 4
    //   797: invokevirtual 1888	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/imcore/message/QQMessageFacade$Message;
    //   800: getfield 1891	com/tencent/imcore/message/QQMessageFacade$Message:shmsgseq	J
    //   803: lconst_1
    //   804: ladd
    //   805: invokevirtual 1892	com/tencent/mobileqq/data/MessageForText:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   808: aload 31
    //   810: iconst_0
    //   811: putfield 1893	com/tencent/mobileqq/data/MessageForText:isread	Z
    //   814: aload_0
    //   815: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   818: invokevirtual 739	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   821: aload 31
    //   823: aload_0
    //   824: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   827: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   830: invokevirtual 1896	com/tencent/imcore/message/QQMessageFacade:b	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   833: goto -153 -> 680
    //   836: astore_1
    //   837: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   840: ifeq -811 -> 29
    //   843: ldc_w 1898
    //   846: iconst_2
    //   847: new 79	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   854: ldc_w 1900
    //   857: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload 32
    //   862: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   865: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   868: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   874: aconst_null
    //   875: areturn
    //   876: sipush 10002
    //   879: istore 4
    //   881: goto -258 -> 623
    //   884: iload 5
    //   886: iconst_2
    //   887: if_icmpne -207 -> 680
    //   890: aload 30
    //   892: getfield 1903	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bool_tab_visible	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   895: invokevirtual 1862	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   898: istore 19
    //   900: aload 30
    //   902: getfield 1885	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bytes_msg_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   905: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   908: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   911: astore 30
    //   913: iload 19
    //   915: ifeq +140 -> 1055
    //   918: sipush -5001
    //   921: invokestatic 1308	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   924: checkcast 1905	com/tencent/mobileqq/data/MessageForNewGrayTips
    //   927: astore 31
    //   929: aload 31
    //   931: aload_0
    //   932: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   935: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   938: aload_1
    //   939: aload_1
    //   940: aload 30
    //   942: invokestatic 622	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   945: sipush -5001
    //   948: iload 4
    //   950: lconst_1
    //   951: aload_0
    //   952: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   955: invokevirtual 739	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   958: aload_1
    //   959: iload 4
    //   961: invokevirtual 1888	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/imcore/message/QQMessageFacade$Message;
    //   964: getfield 1891	com/tencent/imcore/message/QQMessageFacade$Message:shmsgseq	J
    //   967: ladd
    //   968: invokevirtual 1906	com/tencent/mobileqq/data/MessageForNewGrayTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   971: aload 31
    //   973: iconst_1
    //   974: putfield 1907	com/tencent/mobileqq/data/MessageForNewGrayTips:isread	Z
    //   977: aload 31
    //   979: iconst_1
    //   980: putfield 1910	com/tencent/mobileqq/data/MessageForNewGrayTips:mNeedTimeStamp	Z
    //   983: aload 31
    //   985: invokevirtual 1913	com/tencent/mobileqq/data/MessageForNewGrayTips:updateMsgData	()V
    //   988: aload_0
    //   989: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   992: invokevirtual 739	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   995: aload 31
    //   997: aload_0
    //   998: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1001: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1004: invokevirtual 1896	com/tencent/imcore/message/QQMessageFacade:b	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1007: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1010: ifeq -330 -> 680
    //   1013: ldc_w 1898
    //   1016: iconst_2
    //   1017: new 79	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1024: ldc_w 1915
    //   1027: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: iload 19
    //   1032: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1035: ldc_w 1917
    //   1038: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload 30
    //   1043: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1052: goto -372 -> 680
    //   1055: sipush -5000
    //   1058: invokestatic 1308	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1061: astore 31
    //   1063: aload 31
    //   1065: aload_0
    //   1066: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1069: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1072: aload_1
    //   1073: aload_1
    //   1074: aload 30
    //   1076: invokestatic 622	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   1079: sipush -5000
    //   1082: iload 4
    //   1084: lconst_1
    //   1085: aload_0
    //   1086: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1089: invokevirtual 739	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1092: aload_1
    //   1093: iload 4
    //   1095: invokevirtual 1888	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/imcore/message/QQMessageFacade$Message;
    //   1098: getfield 1891	com/tencent/imcore/message/QQMessageFacade$Message:shmsgseq	J
    //   1101: ladd
    //   1102: invokevirtual 1320	com/tencent/mobileqq/data/MessageRecord:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   1105: aload 31
    //   1107: iconst_1
    //   1108: putfield 1326	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   1111: aload_0
    //   1112: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1115: invokevirtual 739	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1118: aload 31
    //   1120: aload_0
    //   1121: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1124: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1127: invokevirtual 1896	com/tencent/imcore/message/QQMessageFacade:b	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1130: goto -123 -> 1007
    //   1133: aload 32
    //   1135: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1138: ldc2_w 1918
    //   1141: lcmp
    //   1142: ifne +315 -> 1457
    //   1145: new 1921	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody
    //   1148: dup
    //   1149: invokespecial 1922	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:<init>	()V
    //   1152: astore 28
    //   1154: aload 28
    //   1156: aload 32
    //   1158: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1161: invokevirtual 1923	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1164: pop
    //   1165: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1168: ifeq +111 -> 1279
    //   1171: new 79	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1178: ldc_w 1925
    //   1181: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: astore 29
    //   1186: aload 28
    //   1188: getfield 1928	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1191: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1194: ifeq +251 -> 1445
    //   1197: aload 28
    //   1199: getfield 1928	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1202: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1205: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1208: astore_1
    //   1209: aload 29
    //   1211: aload_1
    //   1212: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: ldc_w 1930
    //   1218: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: astore 29
    //   1223: aload 28
    //   1225: getfield 1933	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1228: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1231: ifeq +220 -> 1451
    //   1234: aload 28
    //   1236: getfield 1933	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1239: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1242: invokestatic 1015	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1245: astore_1
    //   1246: ldc_w 1935
    //   1249: iconst_2
    //   1250: aload 29
    //   1252: aload_1
    //   1253: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: ldc_w 1937
    //   1259: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: aload 28
    //   1264: getfield 1940	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1267: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1270: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1273: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1276: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1279: aload 28
    //   1281: getfield 1928	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1284: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1287: ifeq -1258 -> 29
    //   1290: aload 28
    //   1292: getfield 1933	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1295: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1298: ifeq +87 -> 1385
    //   1301: aload 28
    //   1303: getfield 1933	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1306: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1309: istore 4
    //   1311: aload 28
    //   1313: getfield 1928	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1316: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1319: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1322: astore_1
    //   1323: aload_0
    //   1324: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1327: bipush 52
    //   1329: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1332: checkcast 1942	com/tencent/mobileqq/app/TroopManager
    //   1335: astore 29
    //   1337: aload 29
    //   1339: aload_1
    //   1340: invokevirtual 1945	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1343: astore 30
    //   1345: aload 30
    //   1347: iload 4
    //   1349: i2b
    //   1350: putfield 1950	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1353: aload 29
    //   1355: aload 30
    //   1357: invokevirtual 1953	com/tencent/mobileqq/app/TroopManager:i	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1360: iconst_1
    //   1361: aload 30
    //   1363: getfield 1950	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1366: if_icmpne +19 -> 1385
    //   1369: aload_0
    //   1370: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1373: bipush 20
    //   1375: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   1378: checkcast 58	acms
    //   1381: aload_1
    //   1382: invokevirtual 1956	acms:EW	(Ljava/lang/String;)V
    //   1385: aload 28
    //   1387: getfield 1940	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1390: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1393: ifeq -1364 -> 29
    //   1396: aload 28
    //   1398: getfield 1928	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1401: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1404: lstore_2
    //   1405: aload_0
    //   1406: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1409: bipush 20
    //   1411: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   1414: checkcast 58	acms
    //   1417: lload_2
    //   1418: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1421: invokevirtual 1956	acms:EW	(Ljava/lang/String;)V
    //   1424: aconst_null
    //   1425: areturn
    //   1426: astore_1
    //   1427: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1430: ifeq -1401 -> 29
    //   1433: ldc_w 1935
    //   1436: iconst_2
    //   1437: ldc_w 1958
    //   1440: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1443: aconst_null
    //   1444: areturn
    //   1445: ldc 186
    //   1447: astore_1
    //   1448: goto -239 -> 1209
    //   1451: ldc 186
    //   1453: astore_1
    //   1454: goto -208 -> 1246
    //   1457: aload 32
    //   1459: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1462: ldc2_w 1959
    //   1465: lcmp
    //   1466: ifne +25 -> 1491
    //   1469: aload_0
    //   1470: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1473: bipush 17
    //   1475: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1478: checkcast 487	anvq
    //   1481: aload 32
    //   1483: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1486: invokevirtual 1963	anvq:by	([B)V
    //   1489: aconst_null
    //   1490: areturn
    //   1491: aload 32
    //   1493: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1496: ldc2_w 1964
    //   1499: lcmp
    //   1500: ifne +17 -> 1517
    //   1503: aload_0
    //   1504: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1507: aload 32
    //   1509: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1512: invokestatic 1970	accy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   1515: aconst_null
    //   1516: areturn
    //   1517: aload 32
    //   1519: ifnull +35 -> 1554
    //   1522: aload 32
    //   1524: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1527: ldc2_w 1971
    //   1530: lcmp
    //   1531: ifne +23 -> 1554
    //   1534: aload 32
    //   1536: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1539: ifnull +15 -> 1554
    //   1542: aload_0
    //   1543: lload_2
    //   1544: aload 32
    //   1546: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1549: invokevirtual 1974	tos:h	(J[B)V
    //   1552: aconst_null
    //   1553: areturn
    //   1554: aload 32
    //   1556: ifnull +35 -> 1591
    //   1559: aload 32
    //   1561: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1564: ldc2_w 1975
    //   1567: lcmp
    //   1568: ifne +23 -> 1591
    //   1571: aload 32
    //   1573: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1576: ifnull +15 -> 1591
    //   1579: aload_0
    //   1580: aload 32
    //   1582: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1585: invokevirtual 1978	tos:o	([B)Ljava/lang/String;
    //   1588: pop
    //   1589: aconst_null
    //   1590: areturn
    //   1591: aload 32
    //   1593: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1596: ldc2_w 1979
    //   1599: lcmp
    //   1600: ifne +22 -> 1622
    //   1603: aload 32
    //   1605: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1608: ifnull +14 -> 1622
    //   1611: aload_0
    //   1612: aload 32
    //   1614: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1617: invokespecial 1982	tos:aa	([B)V
    //   1620: aconst_null
    //   1621: areturn
    //   1622: aload 32
    //   1624: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1627: ldc2_w 1983
    //   1630: lcmp
    //   1631: ifne +22 -> 1653
    //   1634: aload 32
    //   1636: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1639: ifnull +14 -> 1653
    //   1642: aload_0
    //   1643: aload 32
    //   1645: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1648: invokevirtual 1987	tos:ad	([B)V
    //   1651: aconst_null
    //   1652: areturn
    //   1653: aload 32
    //   1655: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1658: ldc2_w 1988
    //   1661: lcmp
    //   1662: ifne +22 -> 1684
    //   1665: aload 32
    //   1667: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1670: ifnull +14 -> 1684
    //   1673: aload_0
    //   1674: aload 32
    //   1676: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1679: invokespecial 1991	tos:ab	([B)V
    //   1682: aconst_null
    //   1683: areturn
    //   1684: aload 32
    //   1686: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1689: ldc2_w 1992
    //   1692: lcmp
    //   1693: ifne +22 -> 1715
    //   1696: aload 32
    //   1698: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1701: ifnull +14 -> 1715
    //   1704: aload_0
    //   1705: aload 32
    //   1707: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1710: invokespecial 1995	tos:ac	([B)V
    //   1713: aconst_null
    //   1714: areturn
    //   1715: aload 32
    //   1717: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1720: ldc2_w 1996
    //   1723: lcmp
    //   1724: ifne +32 -> 1756
    //   1727: aload 32
    //   1729: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1732: ifnull +24 -> 1756
    //   1735: new 1999	akla
    //   1738: dup
    //   1739: aload_0
    //   1740: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1743: invokespecial 2002	akla:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   1746: aload 32
    //   1748: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1751: invokevirtual 2005	akla:bo	([B)V
    //   1754: aconst_null
    //   1755: areturn
    //   1756: aload 32
    //   1758: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1761: ldc2_w 2006
    //   1764: lcmp
    //   1765: ifne +14 -> 1779
    //   1768: aload_0
    //   1769: aload 32
    //   1771: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1774: invokevirtual 2009	tos:af	([B)V
    //   1777: aconst_null
    //   1778: areturn
    //   1779: aload 32
    //   1781: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1784: ldc2_w 2010
    //   1787: lcmp
    //   1788: ifne +14 -> 1802
    //   1791: aload_0
    //   1792: aload 32
    //   1794: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1797: invokevirtual 2014	tos:ag	([B)V
    //   1800: aconst_null
    //   1801: areturn
    //   1802: aload 32
    //   1804: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1807: ldc2_w 2015
    //   1810: lcmp
    //   1811: ifne +22 -> 1833
    //   1814: aload 32
    //   1816: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1819: ifnull +14 -> 1833
    //   1822: aload_0
    //   1823: aload 32
    //   1825: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1828: invokevirtual 2019	tos:ae	([B)V
    //   1831: aconst_null
    //   1832: areturn
    //   1833: aload 32
    //   1835: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1838: ldc2_w 2020
    //   1841: lcmp
    //   1842: ifne +75 -> 1917
    //   1845: aload 32
    //   1847: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1850: ifnull +67 -> 1917
    //   1853: new 2023	tencent/im/s2c/msgtype0x210/submsgtype0x93/submsgtype0x93$MsgBody
    //   1856: dup
    //   1857: invokespecial 2024	tencent/im/s2c/msgtype0x210/submsgtype0x93/submsgtype0x93$MsgBody:<init>	()V
    //   1860: astore_1
    //   1861: aload_1
    //   1862: aload 32
    //   1864: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1867: invokevirtual 2025	tencent/im/s2c/msgtype0x210/submsgtype0x93/submsgtype0x93$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1870: pop
    //   1871: aload_0
    //   1872: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1875: bipush 75
    //   1877: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   1880: checkcast 2027	atnf
    //   1883: astore 28
    //   1885: aload 28
    //   1887: ifnull -1858 -> 29
    //   1890: aload 28
    //   1892: aload_1
    //   1893: invokevirtual 2030	atnf:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x93/submsgtype0x93$MsgBody;)V
    //   1896: aconst_null
    //   1897: areturn
    //   1898: astore_1
    //   1899: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1902: ifeq -1873 -> 29
    //   1905: ldc 21
    //   1907: iconst_2
    //   1908: ldc_w 2032
    //   1911: aload_1
    //   1912: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1915: aconst_null
    //   1916: areturn
    //   1917: aload 32
    //   1919: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1922: ldc2_w 2033
    //   1925: lcmp
    //   1926: ifne +63 -> 1989
    //   1929: aload 32
    //   1931: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1934: ifnull +55 -> 1989
    //   1937: new 2036	tencent/im/s2c/msgtype0x210/submsgtype0x8f/submsgtype0x8f$MsgBody
    //   1940: dup
    //   1941: invokespecial 2037	tencent/im/s2c/msgtype0x210/submsgtype0x8f/submsgtype0x8f$MsgBody:<init>	()V
    //   1944: astore_1
    //   1945: aload_1
    //   1946: aload 32
    //   1948: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1951: invokevirtual 2038	tencent/im/s2c/msgtype0x210/submsgtype0x8f/submsgtype0x8f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1954: pop
    //   1955: aload_0
    //   1956: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1959: bipush 75
    //   1961: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   1964: checkcast 2027	atnf
    //   1967: astore 28
    //   1969: aload 28
    //   1971: ifnull -1942 -> 29
    //   1974: aload 28
    //   1976: aload_1
    //   1977: invokevirtual 2041	atnf:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x8f/submsgtype0x8f$MsgBody;)V
    //   1980: aconst_null
    //   1981: areturn
    //   1982: astore_1
    //   1983: aload_1
    //   1984: invokevirtual 1635	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1987: aconst_null
    //   1988: areturn
    //   1989: aload 32
    //   1991: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1994: ldc2_w 2042
    //   1997: lcmp
    //   1998: ifne +311 -> 2309
    //   2001: aload 32
    //   2003: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2006: ifnull +303 -> 2309
    //   2009: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2012: ifeq +13 -> 2025
    //   2015: ldc_w 2045
    //   2018: iconst_2
    //   2019: ldc_w 2047
    //   2022: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2025: new 2049	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock
    //   2028: dup
    //   2029: invokespecial 2050	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:<init>	()V
    //   2032: astore_1
    //   2033: aload_1
    //   2034: aload 32
    //   2036: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2039: invokevirtual 2051	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2042: pop
    //   2043: new 364	android/content/Intent
    //   2046: dup
    //   2047: invokespecial 2052	android/content/Intent:<init>	()V
    //   2050: astore 28
    //   2052: aload 28
    //   2054: ldc_w 2054
    //   2057: aload_1
    //   2058: getfield 2056	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   2061: invokevirtual 1862	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   2064: invokevirtual 374	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2067: pop
    //   2068: aload 28
    //   2070: ldc_w 2058
    //   2073: aload_1
    //   2074: getfield 2061	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2077: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2080: invokevirtual 516	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2083: pop
    //   2084: aload 28
    //   2086: ldc_w 2065
    //   2089: aload_1
    //   2090: getfield 2068	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2093: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2096: invokevirtual 516	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2099: pop
    //   2100: aload 28
    //   2102: ldc_w 2070
    //   2105: aload_1
    //   2106: getfield 2073	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2109: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2112: invokevirtual 516	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2115: pop
    //   2116: aload 28
    //   2118: ldc_w 2075
    //   2121: aload_1
    //   2122: getfield 2078	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2125: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2128: invokevirtual 516	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2131: pop
    //   2132: aload_1
    //   2133: getfield 2081	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_wording_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2136: invokevirtual 1647	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   2139: astore 29
    //   2141: new 699	java/util/ArrayList
    //   2144: dup
    //   2145: invokespecial 700	java/util/ArrayList:<init>	()V
    //   2148: astore 30
    //   2150: aload 29
    //   2152: ifnull +21 -> 2173
    //   2155: aload 29
    //   2157: invokeinterface 1649 1 0
    //   2162: ifle +11 -> 2173
    //   2165: aload 30
    //   2167: aload 29
    //   2169: invokevirtual 2085	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2172: pop
    //   2173: aload 28
    //   2175: ldc_w 2087
    //   2178: aload 30
    //   2180: invokevirtual 2091	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   2183: pop
    //   2184: aload_0
    //   2185: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2188: aload 28
    //   2190: invokevirtual 2094	com/tencent/mobileqq/app/QQAppInterface:setDevLockIntent	(Landroid/content/Intent;)V
    //   2193: aload_0
    //   2194: sipush 8007
    //   2197: iconst_1
    //   2198: bipush 6
    //   2200: anewarray 261	java/lang/Object
    //   2203: dup
    //   2204: iconst_0
    //   2205: aload_1
    //   2206: getfield 2056	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   2209: invokevirtual 1862	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   2212: invokestatic 1077	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2215: aastore
    //   2216: dup
    //   2217: iconst_1
    //   2218: aload_1
    //   2219: getfield 2061	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2222: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2225: aastore
    //   2226: dup
    //   2227: iconst_2
    //   2228: aload_1
    //   2229: getfield 2068	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2232: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2235: aastore
    //   2236: dup
    //   2237: iconst_3
    //   2238: aload_1
    //   2239: getfield 2073	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2242: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2245: aastore
    //   2246: dup
    //   2247: iconst_4
    //   2248: aload_1
    //   2249: getfield 2078	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2252: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2255: aastore
    //   2256: dup
    //   2257: iconst_5
    //   2258: aload 30
    //   2260: aastore
    //   2261: invokevirtual 2096	tos:b	(IZLjava/lang/Object;)V
    //   2264: aconst_null
    //   2265: areturn
    //   2266: astore_1
    //   2267: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2270: ifeq +13 -> 2283
    //   2273: ldc_w 2045
    //   2276: iconst_2
    //   2277: ldc_w 2098
    //   2280: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2283: aload_0
    //   2284: sipush 8007
    //   2287: iconst_0
    //   2288: iconst_2
    //   2289: anewarray 261	java/lang/Object
    //   2292: dup
    //   2293: iconst_0
    //   2294: iconst_1
    //   2295: invokestatic 1077	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2298: aastore
    //   2299: dup
    //   2300: iconst_1
    //   2301: ldc 186
    //   2303: aastore
    //   2304: invokevirtual 2096	tos:b	(IZLjava/lang/Object;)V
    //   2307: aconst_null
    //   2308: areturn
    //   2309: aload 32
    //   2311: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2314: ldc2_w 2099
    //   2317: lcmp
    //   2318: ifne +327 -> 2645
    //   2321: aload 32
    //   2323: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2326: ifnull +319 -> 2645
    //   2329: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2332: ifeq +13 -> 2345
    //   2335: ldc_w 2045
    //   2338: iconst_2
    //   2339: ldc_w 2102
    //   2342: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2345: new 2104	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   2348: dup
    //   2349: invokespecial 2105	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   2352: pop
    //   2353: aconst_null
    //   2354: astore 28
    //   2356: aconst_null
    //   2357: astore 29
    //   2359: aconst_null
    //   2360: astore 30
    //   2362: aconst_null
    //   2363: astore 31
    //   2365: new 2104	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   2368: dup
    //   2369: invokespecial 2105	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   2372: astore 33
    //   2374: aload 33
    //   2376: aload 32
    //   2378: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2381: invokevirtual 2106	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2384: pop
    //   2385: aload 33
    //   2387: getfield 2109	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2390: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2393: ifeq +26 -> 2419
    //   2396: new 69	java/lang/String
    //   2399: dup
    //   2400: aload 33
    //   2402: getfield 2109	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2405: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2408: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2411: ldc_w 1417
    //   2414: invokespecial 1420	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2417: astore 28
    //   2419: aload 33
    //   2421: getfield 2112	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2424: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2427: ifeq +26 -> 2453
    //   2430: new 69	java/lang/String
    //   2433: dup
    //   2434: aload 33
    //   2436: getfield 2112	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2439: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2442: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2445: ldc_w 1417
    //   2448: invokespecial 1420	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2451: astore 29
    //   2453: aload 33
    //   2455: getfield 2115	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2458: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2461: ifeq +26 -> 2487
    //   2464: new 69	java/lang/String
    //   2467: dup
    //   2468: aload 33
    //   2470: getfield 2115	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2473: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2476: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2479: ldc_w 1417
    //   2482: invokespecial 1420	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2485: astore 30
    //   2487: aload 33
    //   2489: getfield 2118	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2492: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2495: ifeq +16 -> 2511
    //   2498: aload 33
    //   2500: getfield 2118	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2503: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2506: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2509: astore 31
    //   2511: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2514: ifeq +53 -> 2567
    //   2517: ldc_w 2045
    //   2520: iconst_2
    //   2521: new 79	java/lang/StringBuilder
    //   2524: dup
    //   2525: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2528: ldc_w 2120
    //   2531: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2534: aload 28
    //   2536: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2539: ldc_w 2122
    //   2542: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2545: aload 29
    //   2547: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2550: ldc_w 2124
    //   2553: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: aload 30
    //   2558: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2561: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2564: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2567: invokestatic 2129	afsf:a	()Lafsf;
    //   2570: aload_0
    //   2571: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2574: aload 28
    //   2576: aload 29
    //   2578: aload 30
    //   2580: aload 31
    //   2582: invokevirtual 2132	afsf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    //   2585: aload_1
    //   2586: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   2589: lstore_2
    //   2590: aload_1
    //   2591: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2594: istore 4
    //   2596: aload_1
    //   2597: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   2600: lstore 15
    //   2602: aload_1
    //   2603: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   2606: istore 5
    //   2608: aload_0
    //   2609: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2612: lload_2
    //   2613: iload 4
    //   2615: lload 15
    //   2617: iload 5
    //   2619: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   2622: aconst_null
    //   2623: areturn
    //   2624: astore 28
    //   2626: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2629: ifeq -44 -> 2585
    //   2632: ldc_w 2045
    //   2635: iconst_2
    //   2636: ldc_w 2139
    //   2639: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2642: goto -57 -> 2585
    //   2645: aload 32
    //   2647: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2650: ldc2_w 2140
    //   2653: lcmp
    //   2654: ifne +33 -> 2687
    //   2657: aload 32
    //   2659: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2662: ifnull +25 -> 2687
    //   2665: aload_0
    //   2666: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2669: bipush 24
    //   2671: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   2674: checkcast 2143	acli
    //   2677: aload 32
    //   2679: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2682: invokevirtual 2146	acli:aK	([B)V
    //   2685: aconst_null
    //   2686: areturn
    //   2687: aload 32
    //   2689: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2692: ldc2_w 2147
    //   2695: lcmp
    //   2696: ifne +221 -> 2917
    //   2699: aload 32
    //   2701: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2704: ifnull +213 -> 2917
    //   2707: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2710: ifeq +13 -> 2723
    //   2713: ldc_w 2150
    //   2716: iconst_2
    //   2717: ldc_w 2152
    //   2720: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2723: aload_0
    //   2724: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2727: iconst_4
    //   2728: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   2731: checkcast 1967	accy
    //   2734: astore_1
    //   2735: aload_1
    //   2736: ifnull -2707 -> 29
    //   2739: new 2154	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody
    //   2742: dup
    //   2743: invokespecial 2155	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:<init>	()V
    //   2746: astore 28
    //   2748: aload 28
    //   2750: aload 32
    //   2752: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2755: invokevirtual 2156	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2758: pop
    //   2759: aload 28
    //   2761: getfield 2159	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   2764: invokevirtual 1854	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   2767: istore 4
    //   2769: aload 28
    //   2771: getfield 2162	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:task_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2774: invokevirtual 120	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2777: astore 30
    //   2779: new 699	java/util/ArrayList
    //   2782: dup
    //   2783: invokespecial 700	java/util/ArrayList:<init>	()V
    //   2786: astore 29
    //   2788: aload 30
    //   2790: ifnull +87 -> 2877
    //   2793: aload 30
    //   2795: invokeinterface 1649 1 0
    //   2800: ifle +77 -> 2877
    //   2803: aload 30
    //   2805: invokeinterface 126 1 0
    //   2810: astore 30
    //   2812: aload 30
    //   2814: invokeinterface 131 1 0
    //   2819: ifeq +58 -> 2877
    //   2822: aload 30
    //   2824: invokeinterface 135 1 0
    //   2829: checkcast 2164	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo
    //   2832: astore 31
    //   2834: new 2166	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   2837: dup
    //   2838: invokespecial 2167	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:<init>	()V
    //   2841: astore 32
    //   2843: aload 32
    //   2845: aload 31
    //   2847: getfield 2170	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2850: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2853: putfield 2173	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   2856: aload 29
    //   2858: aload 32
    //   2860: invokevirtual 701	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2863: pop
    //   2864: goto -52 -> 2812
    //   2867: astore 29
    //   2869: aload 29
    //   2871: invokevirtual 1635	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2874: goto -115 -> 2759
    //   2877: aload 28
    //   2879: getfield 2176	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2882: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2885: lstore_2
    //   2886: iload 4
    //   2888: iconst_1
    //   2889: if_icmpne +20 -> 2909
    //   2892: iconst_0
    //   2893: istore 4
    //   2895: aload_1
    //   2896: lload_2
    //   2897: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2900: iload 4
    //   2902: aload 29
    //   2904: invokevirtual 2179	accy:b	(Ljava/lang/String;ILjava/util/ArrayList;)V
    //   2907: aconst_null
    //   2908: areturn
    //   2909: sipush 3000
    //   2912: istore 4
    //   2914: goto -19 -> 2895
    //   2917: aload 32
    //   2919: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2922: ldc2_w 2180
    //   2925: lcmp
    //   2926: ifne +20 -> 2946
    //   2929: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2932: ifeq -2903 -> 29
    //   2935: ldc 21
    //   2937: iconst_2
    //   2938: ldc_w 2183
    //   2941: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2944: aconst_null
    //   2945: areturn
    //   2946: aload 32
    //   2948: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2951: ldc2_w 2184
    //   2954: lcmp
    //   2955: ifne +160 -> 3115
    //   2958: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2961: ifeq +44 -> 3005
    //   2964: new 79	java/lang/StringBuilder
    //   2967: dup
    //   2968: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2971: ldc_w 2187
    //   2974: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2977: astore_1
    //   2978: aload 32
    //   2980: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2983: ifnull +84 -> 3067
    //   2986: iconst_1
    //   2987: istore 19
    //   2989: ldc_w 2189
    //   2992: iconst_2
    //   2993: aload_1
    //   2994: iload 19
    //   2996: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2999: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3002: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3005: new 2191	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody
    //   3008: dup
    //   3009: invokespecial 2192	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:<init>	()V
    //   3012: astore_1
    //   3013: aload_1
    //   3014: aload 32
    //   3016: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3019: invokevirtual 2193	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3022: pop
    //   3023: aload_1
    //   3024: getfield 2196	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3027: invokevirtual 2197	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   3030: ifeq -3001 -> 29
    //   3033: aload_1
    //   3034: getfield 2196	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3037: invokevirtual 120	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3040: astore_1
    //   3041: aload_0
    //   3042: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3045: iconst_3
    //   3046: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   3049: checkcast 2199	acgr
    //   3052: astore 28
    //   3054: aload 28
    //   3056: ifnull -3027 -> 29
    //   3059: aload 28
    //   3061: aload_1
    //   3062: invokevirtual 2203	acgr:iS	(Ljava/util/List;)V
    //   3065: aconst_null
    //   3066: areturn
    //   3067: iconst_0
    //   3068: istore 19
    //   3070: goto -81 -> 2989
    //   3073: astore 28
    //   3075: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3078: ifeq -55 -> 3023
    //   3081: ldc_w 2189
    //   3084: iconst_2
    //   3085: new 79	java/lang/StringBuilder
    //   3088: dup
    //   3089: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3092: ldc_w 2205
    //   3095: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3098: aload 28
    //   3100: invokevirtual 2206	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   3103: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3106: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3109: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3112: goto -89 -> 3023
    //   3115: aload 32
    //   3117: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3120: ldc2_w 2207
    //   3123: lcmp
    //   3124: ifne +27 -> 3151
    //   3127: aload_0
    //   3128: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3131: bipush 22
    //   3133: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3136: checkcast 2210	ackn
    //   3139: astore_1
    //   3140: aload_1
    //   3141: ifnull -3112 -> 29
    //   3144: aload_1
    //   3145: invokevirtual 2213	ackn:abC	()Z
    //   3148: pop
    //   3149: aconst_null
    //   3150: areturn
    //   3151: aload 32
    //   3153: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3156: ldc2_w 2214
    //   3159: lcmp
    //   3160: ifne +89 -> 3249
    //   3163: aload 32
    //   3165: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3168: ifnull +81 -> 3249
    //   3171: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3174: ifeq +12 -> 3186
    //   3177: ldc 21
    //   3179: iconst_2
    //   3180: ldc_w 2217
    //   3183: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3186: aload_0
    //   3187: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3190: ldc_w 2219
    //   3193: ldc 186
    //   3195: ldc 186
    //   3197: ldc_w 2221
    //   3200: ldc_w 2221
    //   3203: iconst_0
    //   3204: iconst_0
    //   3205: ldc 186
    //   3207: ldc 186
    //   3209: ldc 186
    //   3211: ldc 186
    //   3213: invokestatic 2226	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3216: new 2228	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody
    //   3219: dup
    //   3220: invokespecial 2229	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody:<init>	()V
    //   3223: pop
    //   3224: new 2231	iuq
    //   3227: dup
    //   3228: invokestatic 2232	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3231: invokespecial 2235	iuq:<init>	(Landroid/content/Context;)V
    //   3234: new 2237	tot
    //   3237: dup
    //   3238: aload_0
    //   3239: aload 32
    //   3241: invokespecial 2240	tot:<init>	(Ltos;LIMMsgBodyPack/MsgType0x210;)V
    //   3244: invokevirtual 2243	iuq:a	(Liuq$a;)V
    //   3247: aconst_null
    //   3248: areturn
    //   3249: aload 32
    //   3251: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3254: ldc2_w 2244
    //   3257: lcmp
    //   3258: ifne +57 -> 3315
    //   3261: aload 32
    //   3263: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3266: ifnull +49 -> 3315
    //   3269: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3272: ifeq +13 -> 3285
    //   3275: ldc_w 2247
    //   3278: iconst_2
    //   3279: ldc_w 2249
    //   3282: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3285: aload_0
    //   3286: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3289: aload 32
    //   3291: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3294: aload_1
    //   3295: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   3298: aload_1
    //   3299: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3302: aload_1
    //   3303: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3306: aload_1
    //   3307: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   3310: invokestatic 2254	zym:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJIJI)V
    //   3313: aconst_null
    //   3314: areturn
    //   3315: aload 32
    //   3317: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3320: ldc2_w 2255
    //   3323: lcmp
    //   3324: ifne +25 -> 3349
    //   3327: aload 32
    //   3329: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3332: ifnull +17 -> 3349
    //   3335: aload_0
    //   3336: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3339: aload 32
    //   3341: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3344: invokestatic 2260	yiz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3347: aconst_null
    //   3348: areturn
    //   3349: aload 32
    //   3351: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3354: ldc2_w 2261
    //   3357: lcmp
    //   3358: ifne +57 -> 3415
    //   3361: aload 32
    //   3363: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3366: ifnull +49 -> 3415
    //   3369: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3372: ifeq +13 -> 3385
    //   3375: ldc_w 2247
    //   3378: iconst_2
    //   3379: ldc_w 2264
    //   3382: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3385: aload_0
    //   3386: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3389: aload 32
    //   3391: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3394: aload_1
    //   3395: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   3398: aload_1
    //   3399: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3402: aload_1
    //   3403: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3406: aload_1
    //   3407: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   3410: invokestatic 2266	zym:b	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJIJI)V
    //   3413: aconst_null
    //   3414: areturn
    //   3415: aload 32
    //   3417: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3420: ldc2_w 2267
    //   3423: lcmp
    //   3424: ifne +81 -> 3505
    //   3427: aload 32
    //   3429: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3432: ifnull +73 -> 3505
    //   3435: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3438: ifeq +13 -> 3451
    //   3441: ldc_w 2270
    //   3444: iconst_2
    //   3445: ldc_w 2272
    //   3448: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3451: aload_0
    //   3452: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3455: aload 32
    //   3457: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3460: invokestatic 2276	anda:d	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3463: aload_1
    //   3464: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   3467: lstore_2
    //   3468: aload_1
    //   3469: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3472: istore 4
    //   3474: aload_1
    //   3475: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3478: lstore 15
    //   3480: aload_1
    //   3481: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   3484: istore 5
    //   3486: aload_0
    //   3487: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3490: invokevirtual 1374	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   3493: lload_2
    //   3494: iload 4
    //   3496: lload 15
    //   3498: iload 5
    //   3500: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3503: aconst_null
    //   3504: areturn
    //   3505: aload 32
    //   3507: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3510: ldc2_w 2277
    //   3513: lcmp
    //   3514: ifne +433 -> 3947
    //   3517: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3520: ifeq +13 -> 3533
    //   3523: ldc_w 2280
    //   3526: iconst_2
    //   3527: ldc_w 2272
    //   3530: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3533: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3536: ifeq +13 -> 3549
    //   3539: ldc_w 2282
    //   3542: iconst_2
    //   3543: ldc_w 2284
    //   3546: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3549: new 2286	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody
    //   3552: dup
    //   3553: invokespecial 2287	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:<init>	()V
    //   3556: astore 31
    //   3558: aload 31
    //   3560: aload 32
    //   3562: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3565: invokevirtual 2288	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3568: pop
    //   3569: aload 31
    //   3571: getfield 2291	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3574: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3577: lstore_2
    //   3578: aload_0
    //   3579: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3582: invokevirtual 1236	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3585: astore 28
    //   3587: invokestatic 2296	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3590: lload_2
    //   3591: invokestatic 169	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3594: aconst_null
    //   3595: ldc_w 493
    //   3598: iconst_0
    //   3599: invokestatic 499	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   3602: ifne +326 -> 3928
    //   3605: lload_2
    //   3606: invokestatic 169	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3609: aload 28
    //   3611: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3614: istore 19
    //   3616: iload 19
    //   3618: ifeq +310 -> 3928
    //   3621: aconst_null
    //   3622: astore 28
    //   3624: aconst_null
    //   3625: astore 29
    //   3627: aconst_null
    //   3628: astore 33
    //   3630: aload 31
    //   3632: getfield 2299	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3635: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3638: ifeq +14024 -> 17662
    //   3641: new 69	java/lang/String
    //   3644: dup
    //   3645: aload 31
    //   3647: getfield 2299	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3650: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3653: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3656: ldc_w 1417
    //   3659: invokespecial 1420	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3662: astore 30
    //   3664: aload 30
    //   3666: astore 28
    //   3668: aload 31
    //   3670: getfield 2302	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3673: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3676: ifeq +13980 -> 17656
    //   3679: new 69	java/lang/String
    //   3682: dup
    //   3683: aload 31
    //   3685: getfield 2302	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3688: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3691: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3694: ldc_w 1417
    //   3697: invokespecial 1420	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3700: astore 30
    //   3702: aload 30
    //   3704: astore 29
    //   3706: aload 31
    //   3708: getfield 2305	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3711: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3714: ifeq +13936 -> 17650
    //   3717: new 69	java/lang/String
    //   3720: dup
    //   3721: aload 31
    //   3723: getfield 2305	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3726: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3729: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3732: ldc_w 1417
    //   3735: invokespecial 1420	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3738: astore 30
    //   3740: aload 30
    //   3742: astore 31
    //   3744: aload 28
    //   3746: astore 30
    //   3748: aload 29
    //   3750: astore 32
    //   3752: invokestatic 2296	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3755: lload_2
    //   3756: invokestatic 169	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3759: aload 30
    //   3761: aload 31
    //   3763: aload 32
    //   3765: invokevirtual 2309	com/tencent/common/app/BaseApplicationImpl:setPCActiveNotice	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3768: aload_0
    //   3769: sipush 8013
    //   3772: iconst_1
    //   3773: iconst_4
    //   3774: anewarray 261	java/lang/Object
    //   3777: dup
    //   3778: iconst_0
    //   3779: lload_2
    //   3780: invokestatic 169	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3783: aastore
    //   3784: dup
    //   3785: iconst_1
    //   3786: aload 30
    //   3788: aastore
    //   3789: dup
    //   3790: iconst_2
    //   3791: aload 31
    //   3793: aastore
    //   3794: dup
    //   3795: iconst_3
    //   3796: aload 32
    //   3798: aastore
    //   3799: invokevirtual 2096	tos:b	(IZLjava/lang/Object;)V
    //   3802: aload_1
    //   3803: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   3806: lstore_2
    //   3807: aload_1
    //   3808: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3811: istore 4
    //   3813: aload_1
    //   3814: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3817: lstore 15
    //   3819: aload_1
    //   3820: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   3823: istore 5
    //   3825: aload_0
    //   3826: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   3829: lload_2
    //   3830: iload 4
    //   3832: lload 15
    //   3834: iload 5
    //   3836: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3839: aconst_null
    //   3840: areturn
    //   3841: astore 30
    //   3843: aload 29
    //   3845: astore 32
    //   3847: aload 33
    //   3849: astore 31
    //   3851: aload 28
    //   3853: astore 30
    //   3855: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3858: ifeq -106 -> 3752
    //   3861: ldc_w 2280
    //   3864: iconst_2
    //   3865: ldc_w 2311
    //   3868: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3871: aload 29
    //   3873: astore 32
    //   3875: aload 33
    //   3877: astore 31
    //   3879: aload 28
    //   3881: astore 30
    //   3883: goto -131 -> 3752
    //   3886: astore 28
    //   3888: aload 28
    //   3890: invokevirtual 1635	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   3893: aload_0
    //   3894: sipush 8013
    //   3897: iconst_0
    //   3898: iconst_4
    //   3899: anewarray 261	java/lang/Object
    //   3902: dup
    //   3903: iconst_0
    //   3904: ldc 186
    //   3906: aastore
    //   3907: dup
    //   3908: iconst_1
    //   3909: ldc 186
    //   3911: aastore
    //   3912: dup
    //   3913: iconst_2
    //   3914: ldc 186
    //   3916: aastore
    //   3917: dup
    //   3918: iconst_3
    //   3919: ldc 186
    //   3921: aastore
    //   3922: invokevirtual 2096	tos:b	(IZLjava/lang/Object;)V
    //   3925: goto -123 -> 3802
    //   3928: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3931: ifeq -129 -> 3802
    //   3934: ldc_w 2280
    //   3937: iconst_2
    //   3938: ldc_w 2313
    //   3941: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3944: goto -142 -> 3802
    //   3947: ldc2_w 2314
    //   3950: aload 32
    //   3952: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3955: lcmp
    //   3956: ifne +46 -> 4002
    //   3959: aload_0
    //   3960: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3963: aload 32
    //   3965: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3968: invokestatic 2320	jnp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)Ltencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo;
    //   3971: astore_1
    //   3972: aload_1
    //   3973: ifnull -3944 -> 29
    //   3976: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3979: ifeq +13 -> 3992
    //   3982: ldc_w 2322
    //   3985: iconst_2
    //   3986: ldc_w 2324
    //   3989: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3992: aload_0
    //   3993: bipush 105
    //   3995: iconst_1
    //   3996: aload_1
    //   3997: invokevirtual 2096	tos:b	(IZLjava/lang/Object;)V
    //   4000: aconst_null
    //   4001: areturn
    //   4002: aload 32
    //   4004: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   4007: ldc2_w 2325
    //   4010: lcmp
    //   4011: ifne +26 -> 4037
    //   4014: ldc_w 2328
    //   4017: ldc_w 2330
    //   4020: iconst_0
    //   4021: iconst_0
    //   4022: iconst_1
    //   4023: anewarray 69	java/lang/String
    //   4026: dup
    //   4027: iconst_0
    //   4028: ldc_w 2332
    //   4031: aastore
    //   4032: invokestatic 2337	rar:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   4035: aconst_null
    //   4036: areturn
    //   4037: aload 32
    //   4039: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   4042: ldc2_w 2338
    //   4045: lcmp
    //   4046: ifne +1677 -> 5723
    //   4049: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4052: ifeq +13 -> 4065
    //   4055: ldc_w 2341
    //   4058: iconst_2
    //   4059: ldc_w 2272
    //   4062: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4065: new 2343	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody
    //   4068: dup
    //   4069: invokespecial 2344	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:<init>	()V
    //   4072: astore 29
    //   4074: aload 29
    //   4076: aload 32
    //   4078: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   4081: invokevirtual 2345	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4084: pop
    //   4085: iconst_0
    //   4086: istore 4
    //   4088: iload 4
    //   4090: aload 29
    //   4092: getfield 2348	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4095: invokevirtual 2349	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   4098: if_icmpge -4069 -> 29
    //   4101: aload 29
    //   4103: getfield 2348	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4106: invokevirtual 120	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4109: iload 4
    //   4111: invokeinterface 2351 2 0
    //   4116: checkcast 2353	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody
    //   4119: astore 28
    //   4121: iconst_m1
    //   4122: istore 5
    //   4124: aload 28
    //   4126: getfield 2356	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4129: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4132: ifeq +13 -> 4145
    //   4135: aload 28
    //   4137: getfield 2356	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4140: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4143: istore 5
    //   4145: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4148: ifeq +31 -> 4179
    //   4151: ldc_w 2341
    //   4154: iconst_2
    //   4155: new 79	java/lang/StringBuilder
    //   4158: dup
    //   4159: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4162: ldc_w 2358
    //   4165: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4168: iload 5
    //   4170: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4173: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4176: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4179: iload 5
    //   4181: sipush 2001
    //   4184: if_icmpne +263 -> 4447
    //   4187: aload 28
    //   4189: getfield 2362	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   4192: invokevirtual 2365	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:has	()Z
    //   4195: ifeq +252 -> 4447
    //   4198: aload 28
    //   4200: getfield 2362	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   4203: invokevirtual 2366	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4206: checkcast 2364	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike
    //   4209: astore 30
    //   4211: ldc 186
    //   4213: astore 28
    //   4215: lconst_0
    //   4216: lstore_2
    //   4217: iconst_0
    //   4218: istore 6
    //   4220: iconst_0
    //   4221: istore 5
    //   4223: aload 30
    //   4225: getfield 2369	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4228: invokevirtual 2370	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   4231: ifeq +13 -> 4244
    //   4234: aload 30
    //   4236: getfield 2369	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4239: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4242: astore 28
    //   4244: aload 30
    //   4246: getfield 2373	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4249: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4252: ifeq +13 -> 4265
    //   4255: aload 30
    //   4257: getfield 2373	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4260: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4263: istore 5
    //   4265: aload 30
    //   4267: getfield 2374	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4270: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4273: ifeq +12 -> 4285
    //   4276: aload 30
    //   4278: getfield 2374	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4281: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4284: lstore_2
    //   4285: aload 30
    //   4287: getfield 2377	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4290: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4293: ifeq +13 -> 4306
    //   4296: aload 30
    //   4298: getfield 2377	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4301: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4304: istore 6
    //   4306: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4309: ifeq +63 -> 4372
    //   4312: ldc_w 2341
    //   4315: iconst_2
    //   4316: new 79	java/lang/StringBuilder
    //   4319: dup
    //   4320: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4323: ldc_w 2379
    //   4326: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4329: aload 28
    //   4331: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4334: ldc_w 2381
    //   4337: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4340: iload 6
    //   4342: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4345: ldc_w 2383
    //   4348: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4351: iload 5
    //   4353: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4356: ldc_w 2385
    //   4359: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4362: lload_2
    //   4363: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4366: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4369: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4372: aload_0
    //   4373: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4376: bipush 71
    //   4378: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4381: checkcast 2387	afci
    //   4384: astore 28
    //   4386: aload 28
    //   4388: ifnull +13 -> 4401
    //   4391: aload 28
    //   4393: invokevirtual 2390	afci:a	()Lafde;
    //   4396: aload 30
    //   4398: invokevirtual 2395	afde:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;)V
    //   4401: aload_1
    //   4402: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   4405: lstore_2
    //   4406: aload_1
    //   4407: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   4410: istore 5
    //   4412: aload_1
    //   4413: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   4416: lstore 15
    //   4418: aload_1
    //   4419: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   4422: istore 6
    //   4424: aload_0
    //   4425: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   4428: lload_2
    //   4429: iload 5
    //   4431: lload 15
    //   4433: iload 6
    //   4435: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   4438: iload 4
    //   4440: iconst_1
    //   4441: iadd
    //   4442: istore 4
    //   4444: goto -356 -> 4088
    //   4447: iload 5
    //   4449: sipush 2002
    //   4452: if_icmpne +456 -> 4908
    //   4455: aload 28
    //   4457: getfield 2399	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   4460: invokevirtual 2402	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:has	()Z
    //   4463: ifeq +445 -> 4908
    //   4466: aload 28
    //   4468: getfield 2399	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   4471: invokevirtual 2403	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4474: checkcast 2401	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify
    //   4477: astore 30
    //   4479: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4482: ifeq +33 -> 4515
    //   4485: ldc 21
    //   4487: iconst_2
    //   4488: new 79	java/lang/StringBuilder
    //   4491: dup
    //   4492: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4495: ldc_w 2405
    //   4498: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4501: aload 30
    //   4503: invokevirtual 2406	java/lang/Object:toString	()Ljava/lang/String;
    //   4506: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4509: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4512: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4515: lconst_0
    //   4516: lstore_2
    //   4517: aload 30
    //   4519: getfield 2407	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4522: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4525: ifeq +12 -> 4537
    //   4528: aload 30
    //   4530: getfield 2407	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4533: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4536: lstore_2
    //   4537: lload_2
    //   4538: invokestatic 169	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4541: astore 28
    //   4543: aload 30
    //   4545: getfield 2410	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4548: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4551: ifeq +13093 -> 17644
    //   4554: aload 30
    //   4556: getfield 2410	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4559: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4562: istore 5
    //   4564: aload 30
    //   4566: getfield 2413	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4569: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4572: ifeq +13066 -> 17638
    //   4575: aload 30
    //   4577: getfield 2413	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4580: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4583: istore 6
    //   4585: iconst_m1
    //   4586: istore 7
    //   4588: iconst_m1
    //   4589: istore 8
    //   4591: aload 30
    //   4593: getfield 2416	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4596: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4599: ifeq +13 -> 4612
    //   4602: aload 30
    //   4604: getfield 2416	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4607: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4610: istore 7
    //   4612: aload 30
    //   4614: getfield 2419	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4617: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4620: ifeq +13 -> 4633
    //   4623: aload 30
    //   4625: getfield 2419	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4628: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4631: istore 8
    //   4633: aload 30
    //   4635: getfield 2422	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_redpack_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4638: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4641: istore 9
    //   4643: aload 30
    //   4645: getfield 2425	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:str_redpack_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4648: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4651: astore 30
    //   4653: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4656: ifeq +13012 -> 17668
    //   4659: ldc 21
    //   4661: iconst_2
    //   4662: new 79	java/lang/StringBuilder
    //   4665: dup
    //   4666: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4669: ldc_w 2427
    //   4672: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4675: iload 9
    //   4677: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4680: ldc_w 2429
    //   4683: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4686: aload 30
    //   4688: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4691: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4694: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4697: goto +12971 -> 17668
    //   4700: aload_0
    //   4701: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4704: sipush 131
    //   4707: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4710: checkcast 2431	acgn
    //   4713: astore 31
    //   4715: aload 31
    //   4717: iload 7
    //   4719: iload 8
    //   4721: iconst_1
    //   4722: invokevirtual 2434	acgn:x	(IIZ)V
    //   4725: aload 31
    //   4727: iload 9
    //   4729: aload 30
    //   4731: invokevirtual 2438	acgn:ca	(ILjava/lang/String;)V
    //   4734: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4737: ifeq +12944 -> 17681
    //   4740: ldc 21
    //   4742: iconst_2
    //   4743: new 79	java/lang/StringBuilder
    //   4746: dup
    //   4747: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4750: ldc_w 2440
    //   4753: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4756: aload 28
    //   4758: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4761: ldc_w 2442
    //   4764: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4767: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4770: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4773: goto +12908 -> 17681
    //   4776: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4779: ifeq +41 -> 4820
    //   4782: ldc 21
    //   4784: iconst_2
    //   4785: new 79	java/lang/StringBuilder
    //   4788: dup
    //   4789: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4792: ldc_w 2444
    //   4795: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4798: iload 5
    //   4800: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4803: ldc_w 2446
    //   4806: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4809: iload 6
    //   4811: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4814: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4817: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4820: aload_0
    //   4821: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4824: iconst_2
    //   4825: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4828: checkcast 420	mqq/manager/TicketManager
    //   4831: aload 28
    //   4833: invokeinterface 424 2 0
    //   4838: astore 30
    //   4840: aload_0
    //   4841: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4844: bipush 27
    //   4846: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   4849: checkcast 426	acny
    //   4852: aload 30
    //   4854: aload 28
    //   4856: invokevirtual 430	acny:fg	(Ljava/lang/String;Ljava/lang/String;)V
    //   4859: aload_0
    //   4860: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4863: invokestatic 2451	aqsz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laqsz;
    //   4866: invokevirtual 2454	aqsz:efr	()V
    //   4869: goto -468 -> 4401
    //   4872: astore_1
    //   4873: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4876: ifeq -4847 -> 29
    //   4879: ldc_w 2341
    //   4882: iconst_2
    //   4883: new 79	java/lang/StringBuilder
    //   4886: dup
    //   4887: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4890: ldc_w 2456
    //   4893: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4896: aload_1
    //   4897: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4900: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4903: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4906: aconst_null
    //   4907: areturn
    //   4908: iload 5
    //   4910: sipush 2003
    //   4913: if_icmpne +155 -> 5068
    //   4916: aload 28
    //   4918: getfield 2460	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4921: invokevirtual 2463	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:has	()Z
    //   4924: ifeq +144 -> 5068
    //   4927: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4930: ifeq +13 -> 4943
    //   4933: ldc_w 2465
    //   4936: iconst_2
    //   4937: ldc_w 2467
    //   4940: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4943: aload 28
    //   4945: getfield 2460	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4948: invokevirtual 2468	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4951: checkcast 2462	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound
    //   4954: astore 28
    //   4956: new 969	android/os/Bundle
    //   4959: dup
    //   4960: invokespecial 970	android/os/Bundle:<init>	()V
    //   4963: astore 30
    //   4965: aload 28
    //   4967: getfield 2469	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4970: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4973: ifeq +19 -> 4992
    //   4976: aload 30
    //   4978: ldc_w 2471
    //   4981: aload 28
    //   4983: getfield 2469	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4986: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4989: invokevirtual 2473	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4992: aload 28
    //   4994: getfield 2476	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4997: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   5000: ifeq +19 -> 5019
    //   5003: aload 30
    //   5005: ldc_w 2478
    //   5008: aload 28
    //   5010: getfield 2476	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5013: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5016: invokevirtual 2473	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   5019: aload 28
    //   5021: getfield 2481	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5024: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   5027: ifeq +19 -> 5046
    //   5030: aload 30
    //   5032: ldc_w 2483
    //   5035: aload 28
    //   5037: getfield 2481	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5040: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5043: invokevirtual 982	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   5046: aload_0
    //   5047: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5050: bipush 51
    //   5052: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   5055: checkcast 2485	syw
    //   5058: bipush 111
    //   5060: aload 30
    //   5062: invokevirtual 2489	syw:l	(ILandroid/os/Bundle;)V
    //   5065: goto -664 -> 4401
    //   5068: iload 5
    //   5070: sipush 2007
    //   5073: if_icmpne +49 -> 5122
    //   5076: aload 28
    //   5078: getfield 2493	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_babyq_reward_info	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$RewardInfo;
    //   5081: invokevirtual 2496	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$RewardInfo:has	()Z
    //   5084: ifeq +38 -> 5122
    //   5087: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5090: ifeq +12 -> 5102
    //   5093: ldc 21
    //   5095: iconst_2
    //   5096: ldc_w 2498
    //   5099: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5102: aload_0
    //   5103: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5106: bipush 53
    //   5108: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   5111: checkcast 2500	acbs
    //   5114: aload 28
    //   5116: invokevirtual 2503	acbs:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody;)V
    //   5119: goto -718 -> 4401
    //   5122: iload 5
    //   5124: sipush 2011
    //   5127: if_icmpne -726 -> 4401
    //   5130: aload 28
    //   5132: getfield 2507	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mod_qim_friend_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ;
    //   5135: invokevirtual 2510	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:has	()Z
    //   5138: ifeq -737 -> 4401
    //   5141: aload 28
    //   5143: getfield 2507	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mod_qim_friend_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ;
    //   5146: invokevirtual 2511	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5149: checkcast 2509	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ
    //   5152: astore 28
    //   5154: iconst_m1
    //   5155: istore 5
    //   5157: aload 28
    //   5159: getfield 2514	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:uint32_notify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5162: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   5165: ifeq +13 -> 5178
    //   5168: aload 28
    //   5170: getfield 2514	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:uint32_notify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5173: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5176: istore 5
    //   5178: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5181: ifeq +31 -> 5212
    //   5184: ldc_w 2516
    //   5187: iconst_2
    //   5188: new 79	java/lang/StringBuilder
    //   5191: dup
    //   5192: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5195: ldc_w 2518
    //   5198: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5201: iload 5
    //   5203: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5206: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5209: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5212: iload 5
    //   5214: iconst_1
    //   5215: if_icmpne +190 -> 5405
    //   5218: aload 28
    //   5220: getfield 2522	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ;
    //   5223: invokevirtual 2525	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:has	()Z
    //   5226: ifeq -825 -> 4401
    //   5229: aload 28
    //   5231: getfield 2522	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ;
    //   5234: astore 28
    //   5236: new 2527	com/tencent/mobileqq/data/QIMFollwerAdd
    //   5239: dup
    //   5240: invokespecial 2528	com/tencent/mobileqq/data/QIMFollwerAdd:<init>	()V
    //   5243: astore 30
    //   5245: aload 30
    //   5247: aload 28
    //   5249: getfield 2529	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5252: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5255: putfield 2531	com/tencent/mobileqq/data/QIMFollwerAdd:uin	J
    //   5258: aload 30
    //   5260: aload 28
    //   5262: getfield 2534	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5265: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5268: putfield 2537	com/tencent/mobileqq/data/QIMFollwerAdd:gender	I
    //   5271: aload 30
    //   5273: aload 28
    //   5275: getfield 2540	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_cares_count	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5278: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5281: putfield 2543	com/tencent/mobileqq/data/QIMFollwerAdd:careSCount	J
    //   5284: aload 30
    //   5286: aload 28
    //   5288: getfield 2546	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_storys_total_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5291: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5294: putfield 2549	com/tencent/mobileqq/data/QIMFollwerAdd:totalNum	J
    //   5297: aload 30
    //   5299: aload 28
    //   5301: getfield 2552	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_smart_remark	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5304: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5307: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5310: putfield 2555	com/tencent/mobileqq/data/QIMFollwerAdd:smartRemark	Ljava/lang/String;
    //   5313: aload 30
    //   5315: aload 28
    //   5317: getfield 2556	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5320: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5323: putfield 2559	com/tencent/mobileqq/data/QIMFollwerAdd:opType	I
    //   5326: aload 30
    //   5328: aload 28
    //   5330: getfield 2562	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_fans_count	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5333: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5336: putfield 2565	com/tencent/mobileqq/data/QIMFollwerAdd:fansCount	J
    //   5339: aload 30
    //   5341: aload 28
    //   5343: getfield 2568	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_longnick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5346: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5349: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5352: invokestatic 2574	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   5355: invokevirtual 2577	com/tencent/mobileqq/richstatus/RichStatus:getPlainText	()Ljava/lang/String;
    //   5358: putfield 2580	com/tencent/mobileqq/data/QIMFollwerAdd:longNick	Ljava/lang/String;
    //   5361: aload 30
    //   5363: invokestatic 2583	anaz:gQ	()J
    //   5366: putfield 2586	com/tencent/mobileqq/data/QIMFollwerAdd:upTime	J
    //   5369: aload 30
    //   5371: aload 28
    //   5373: getfield 2589	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_src_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5376: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5379: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5382: putfield 2591	com/tencent/mobileqq/data/QIMFollwerAdd:source	Ljava/lang/String;
    //   5385: aload_0
    //   5386: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5389: bipush 34
    //   5391: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5394: checkcast 2593	ysf
    //   5397: aload 30
    //   5399: invokevirtual 2596	ysf:b	(Lcom/tencent/mobileqq/data/QIMFollwerAdd;)V
    //   5402: goto -1001 -> 4401
    //   5405: iload 5
    //   5407: iconst_2
    //   5408: if_icmpeq -1007 -> 4401
    //   5411: iload 5
    //   5413: iconst_3
    //   5414: if_icmpne -1013 -> 4401
    //   5417: aload 28
    //   5419: getfield 2600	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_not_login_frd_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
    //   5422: invokevirtual 2603	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:has	()Z
    //   5425: ifeq -1024 -> 4401
    //   5428: aload 28
    //   5430: getfield 2600	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_not_login_frd_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
    //   5433: invokevirtual 2604	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5436: checkcast 2602	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ
    //   5439: astore 28
    //   5441: new 2606	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   5444: dup
    //   5445: invokespecial 2607	com/tencent/mobileqq/data/QIMNotifyAddFriend:<init>	()V
    //   5448: astore 30
    //   5450: aload 30
    //   5452: aload 28
    //   5454: getfield 2608	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5457: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5460: putfield 2609	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   5463: aload 30
    //   5465: aload 28
    //   5467: getfield 2612	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_qq_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5470: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5473: putfield 2615	com/tencent/mobileqq/data/QIMNotifyAddFriend:qqUin	J
    //   5476: aload 30
    //   5478: aload 28
    //   5480: getfield 2618	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5483: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5486: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5489: putfield 2621	com/tencent/mobileqq/data/QIMNotifyAddFriend:nickName	Ljava/lang/String;
    //   5492: aload 30
    //   5494: aload 28
    //   5496: getfield 2622	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5499: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5502: putfield 2623	com/tencent/mobileqq/data/QIMNotifyAddFriend:gender	I
    //   5505: aload 30
    //   5507: aload 28
    //   5509: getfield 2626	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5512: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5515: putfield 2629	com/tencent/mobileqq/data/QIMNotifyAddFriend:age	I
    //   5518: aload 30
    //   5520: aload 28
    //   5522: getfield 2632	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_coverstory	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5525: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5528: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5531: putfield 2635	com/tencent/mobileqq/data/QIMNotifyAddFriend:coverStory	Ljava/lang/String;
    //   5534: aload 30
    //   5536: aload 28
    //   5538: getfield 2636	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_storys_total_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5541: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5544: putfield 2639	com/tencent/mobileqq/data/QIMNotifyAddFriend:storyTotalNum	J
    //   5547: aload 30
    //   5549: aload 28
    //   5551: getfield 2642	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5554: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5557: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5560: putfield 2644	com/tencent/mobileqq/data/QIMNotifyAddFriend:wording	Ljava/lang/String;
    //   5563: iconst_0
    //   5564: istore 5
    //   5566: iload 5
    //   5568: aload 28
    //   5570: getfield 2647	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5573: invokevirtual 2349	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   5576: if_icmpge +81 -> 5657
    //   5579: aload 28
    //   5581: getfield 2647	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5584: iload 5
    //   5586: invokevirtual 2650	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5589: checkcast 2652	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo
    //   5592: astore 31
    //   5594: new 2654	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo
    //   5597: dup
    //   5598: invokespecial 2655	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:<init>	()V
    //   5601: astore 32
    //   5603: aload 32
    //   5605: aload 31
    //   5607: getfield 2658	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo:bytes_video_cover_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5610: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5613: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5616: putfield 2661	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:coverUrl	Ljava/lang/String;
    //   5619: aload 32
    //   5621: aload 31
    //   5623: getfield 2664	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo:bytes_vid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5626: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5629: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5632: putfield 2667	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:videoVid	Ljava/lang/String;
    //   5635: aload 30
    //   5637: getfield 2671	com/tencent/mobileqq/data/QIMNotifyAddFriend:videoInfos	Ljava/util/List;
    //   5640: aload 32
    //   5642: invokeinterface 1133 2 0
    //   5647: pop
    //   5648: iload 5
    //   5650: iconst_1
    //   5651: iadd
    //   5652: istore 5
    //   5654: goto -88 -> 5566
    //   5657: aload 30
    //   5659: invokestatic 2583	anaz:gQ	()J
    //   5662: putfield 2674	com/tencent/mobileqq/data/QIMNotifyAddFriend:pushTime	J
    //   5665: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5668: ifeq +34 -> 5702
    //   5671: ldc_w 2516
    //   5674: iconst_2
    //   5675: new 79	java/lang/StringBuilder
    //   5678: dup
    //   5679: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5682: ldc_w 2676
    //   5685: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5688: aload 30
    //   5690: invokevirtual 2677	com/tencent/mobileqq/data/QIMNotifyAddFriend:toString	()Ljava/lang/String;
    //   5693: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5696: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5699: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5702: aload_0
    //   5703: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5706: sipush 257
    //   5709: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5712: checkcast 2679	acjf
    //   5715: aload 30
    //   5717: invokevirtual 2682	acjf:a	(Lcom/tencent/mobileqq/data/QIMNotifyAddFriend;)V
    //   5720: goto -1319 -> 4401
    //   5723: aload 32
    //   5725: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5728: ldc2_w 2683
    //   5731: lcmp
    //   5732: ifne +394 -> 6126
    //   5735: new 2686	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody
    //   5738: dup
    //   5739: invokespecial 2687	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:<init>	()V
    //   5742: astore_1
    //   5743: aload_1
    //   5744: aload 32
    //   5746: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5749: invokevirtual 2688	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5752: pop
    //   5753: aload_1
    //   5754: getfield 2689	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5757: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5760: istore 4
    //   5762: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5765: ifeq +46 -> 5811
    //   5768: ldc 21
    //   5770: iconst_2
    //   5771: new 79	java/lang/StringBuilder
    //   5774: dup
    //   5775: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5778: ldc_w 2691
    //   5781: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5784: iload 4
    //   5786: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5789: ldc_w 2693
    //   5792: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5795: aload_1
    //   5796: getfield 2696	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5799: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5802: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5805: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5808: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5811: iload 4
    //   5813: sipush 1004
    //   5816: if_icmpne +56 -> 5872
    //   5819: aload_0
    //   5820: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5823: bipush 79
    //   5825: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5828: checkcast 2698	com/tencent/mobileqq/portal/PortalManager
    //   5831: astore 28
    //   5833: aload 28
    //   5835: ifnull -5806 -> 29
    //   5838: aload 28
    //   5840: aload_1
    //   5841: invokevirtual 2701	com/tencent/mobileqq/portal/PortalManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   5844: aconst_null
    //   5845: areturn
    //   5846: astore_1
    //   5847: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5850: ifeq +13 -> 5863
    //   5853: ldc_w 2703
    //   5856: iconst_2
    //   5857: ldc 186
    //   5859: aload_1
    //   5860: invokestatic 2705	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5863: new 2707	java/lang/RuntimeException
    //   5866: dup
    //   5867: aload_1
    //   5868: invokespecial 2710	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   5871: athrow
    //   5872: iload 4
    //   5874: bipush 49
    //   5876: if_icmpne +26 -> 5902
    //   5879: aload_0
    //   5880: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5883: aload_0
    //   5884: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5887: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5890: aload_1
    //   5891: getfield 2696	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5894: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5897: invokestatic 2715	aevk:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   5900: aconst_null
    //   5901: areturn
    //   5902: iload 4
    //   5904: bipush 46
    //   5906: if_icmpne +29 -> 5935
    //   5909: aload_0
    //   5910: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5913: aload_0
    //   5914: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5917: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5920: aload_1
    //   5921: getfield 2696	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5924: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5927: ldc_w 2717
    //   5930: invokestatic 2722	tns:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;)V
    //   5933: aconst_null
    //   5934: areturn
    //   5935: iload 4
    //   5937: sipush 1003
    //   5940: if_icmpne +22 -> 5962
    //   5943: aload_0
    //   5944: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5947: sipush 167
    //   5950: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5953: checkcast 2724	com/tencent/mobileqq/olympic/OlympicManager
    //   5956: aload_1
    //   5957: invokevirtual 2725	com/tencent/mobileqq/olympic/OlympicManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   5960: aconst_null
    //   5961: areturn
    //   5962: iload 4
    //   5964: sipush 222
    //   5967: if_icmpne +101 -> 6068
    //   5970: aload_0
    //   5971: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5974: invokevirtual 2729	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   5977: ldc_w 2731
    //   5980: iconst_0
    //   5981: invokeinterface 485 3 0
    //   5986: istore 4
    //   5988: iload 4
    //   5990: aload_1
    //   5991: getfield 2696	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5994: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5997: if_icmpeq +20 -> 6017
    //   6000: aload_0
    //   6001: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6004: sipush 222
    //   6007: aload_0
    //   6008: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6011: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6014: invokestatic 2734	aevk:d	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)V
    //   6017: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6020: ifeq -5991 -> 29
    //   6023: ldc 21
    //   6025: iconst_2
    //   6026: new 79	java/lang/StringBuilder
    //   6029: dup
    //   6030: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   6033: ldc_w 2736
    //   6036: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6039: iload 4
    //   6041: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6044: ldc_w 2693
    //   6047: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6050: aload_1
    //   6051: getfield 2696	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6054: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6057: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6060: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6063: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6066: aconst_null
    //   6067: areturn
    //   6068: iload 4
    //   6070: sipush 283
    //   6073: if_icmpne -6044 -> 29
    //   6076: aload_0
    //   6077: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6080: ifnull -6051 -> 29
    //   6083: ldc 21
    //   6085: iconst_1
    //   6086: ldc_w 2738
    //   6089: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6092: aload_0
    //   6093: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6096: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6099: astore_1
    //   6100: aload_0
    //   6101: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6104: sipush 283
    //   6107: aload_1
    //   6108: invokestatic 2734	aevk:d	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)V
    //   6111: aconst_null
    //   6112: areturn
    //   6113: astore_1
    //   6114: ldc 21
    //   6116: iconst_1
    //   6117: ldc_w 2740
    //   6120: aload_1
    //   6121: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6124: aconst_null
    //   6125: areturn
    //   6126: aload 32
    //   6128: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6131: ldc2_w 2741
    //   6134: lcmp
    //   6135: ifne +26 -> 6161
    //   6138: aload_0
    //   6139: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6142: bipush 36
    //   6144: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6147: checkcast 2744	altq
    //   6150: aload 32
    //   6152: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6155: invokevirtual 2748	altq:p	([B)Z
    //   6158: pop
    //   6159: aconst_null
    //   6160: areturn
    //   6161: aload 32
    //   6163: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6166: ldc2_w 2749
    //   6169: lcmp
    //   6170: ifne +25 -> 6195
    //   6173: aload_0
    //   6174: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6177: bipush 36
    //   6179: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6182: checkcast 2744	altq
    //   6185: aload 32
    //   6187: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6190: invokevirtual 2753	altq:bp	([B)V
    //   6193: aconst_null
    //   6194: areturn
    //   6195: aload 32
    //   6197: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6200: ldc2_w 2754
    //   6203: lcmp
    //   6204: ifne +281 -> 6485
    //   6207: aload_0
    //   6208: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6211: bipush 85
    //   6213: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6216: checkcast 2757	acof
    //   6219: astore 28
    //   6221: aload 28
    //   6223: aload_1
    //   6224: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6227: invokevirtual 2760	acof:iD	(I)Z
    //   6230: ifne +218 -> 6448
    //   6233: new 2762	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody
    //   6236: dup
    //   6237: invokespecial 2763	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:<init>	()V
    //   6240: astore_1
    //   6241: aload_1
    //   6242: aload 32
    //   6244: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6247: invokevirtual 2764	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6250: pop
    //   6251: aload_1
    //   6252: getfield 2768	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:msg_system_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify;
    //   6255: invokevirtual 2771	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6258: checkcast 2770	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify
    //   6261: getfield 2774	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify:bytes_msg_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6264: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6267: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6270: astore 29
    //   6272: new 2776	org/json/JSONObject
    //   6275: dup
    //   6276: aload_1
    //   6277: getfield 2779	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:bytes_push_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6280: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6283: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6286: invokespecial 2780	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6289: astore_1
    //   6290: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6293: ifeq +62 -> 6355
    //   6296: ldc 21
    //   6298: iconst_2
    //   6299: new 79	java/lang/StringBuilder
    //   6302: dup
    //   6303: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   6306: ldc_w 2782
    //   6309: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6312: aload 29
    //   6314: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6317: ldc_w 2784
    //   6320: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6323: aload_1
    //   6324: ldc_w 2786
    //   6327: invokevirtual 2789	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6330: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6333: ldc_w 2791
    //   6336: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6339: aload_1
    //   6340: ldc_w 2793
    //   6343: invokevirtual 2797	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6346: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6349: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6352: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6355: aload 28
    //   6357: aload 29
    //   6359: aload_1
    //   6360: ldc_w 2786
    //   6363: invokevirtual 2789	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6366: aload_1
    //   6367: ldc_w 2793
    //   6370: invokevirtual 2797	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6373: invokevirtual 2800	acof:l	(Ljava/lang/String;Ljava/lang/String;J)V
    //   6376: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6379: ifeq +12 -> 6391
    //   6382: ldc 21
    //   6384: iconst_2
    //   6385: ldc_w 2802
    //   6388: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6391: aload_0
    //   6392: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6395: ldc_w 2804
    //   6398: ldc_w 2806
    //   6401: ldc 186
    //   6403: ldc 186
    //   6405: ldc_w 2808
    //   6408: iconst_0
    //   6409: iconst_0
    //   6410: ldc 186
    //   6412: ldc 186
    //   6414: aload_1
    //   6415: ldc_w 2786
    //   6418: invokevirtual 2789	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6421: ldc 186
    //   6423: invokestatic 2226	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6426: aconst_null
    //   6427: areturn
    //   6428: astore_1
    //   6429: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6432: ifeq -6403 -> 29
    //   6435: ldc_w 2810
    //   6438: iconst_2
    //   6439: ldc_w 2812
    //   6442: aload_1
    //   6443: invokestatic 2705	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6446: aconst_null
    //   6447: areturn
    //   6448: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6451: ifeq -6422 -> 29
    //   6454: ldc 21
    //   6456: iconst_2
    //   6457: new 79	java/lang/StringBuilder
    //   6460: dup
    //   6461: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   6464: ldc_w 2814
    //   6467: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6470: aload_1
    //   6471: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6474: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6477: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6480: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6483: aconst_null
    //   6484: areturn
    //   6485: aload 32
    //   6487: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6490: ldc2_w 2815
    //   6493: lcmp
    //   6494: ifne +147 -> 6641
    //   6497: aload_1
    //   6498: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   6501: lstore 15
    //   6503: aload_1
    //   6504: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6507: istore 4
    //   6509: aload_1
    //   6510: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   6513: lstore 17
    //   6515: aload_1
    //   6516: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   6519: istore 5
    //   6521: aload 32
    //   6523: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6526: l2i
    //   6527: istore 6
    //   6529: aload_0
    //   6530: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6533: bipush 85
    //   6535: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6538: checkcast 2757	acof
    //   6541: aload_1
    //   6542: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6545: invokevirtual 2760	acof:iD	(I)Z
    //   6548: ifeq +55 -> 6603
    //   6551: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6554: ifeq +32 -> 6586
    //   6557: ldc 21
    //   6559: iconst_2
    //   6560: new 79	java/lang/StringBuilder
    //   6563: dup
    //   6564: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   6567: ldc_w 2814
    //   6570: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6573: aload_1
    //   6574: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6577: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6580: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6583: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6586: aload_0
    //   6587: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   6590: lload 15
    //   6592: iload 4
    //   6594: lload 17
    //   6596: iload 5
    //   6598: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   6601: aconst_null
    //   6602: areturn
    //   6603: aload_0
    //   6604: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6607: aload 32
    //   6609: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6612: lload 15
    //   6614: lload_2
    //   6615: iload 4
    //   6617: iload 5
    //   6619: iload 6
    //   6621: invokestatic 2821	ancl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJJIII)Z
    //   6624: ifeq -38 -> 6586
    //   6627: aload_0
    //   6628: ldc_w 2823
    //   6631: iconst_1
    //   6632: iconst_1
    //   6633: iconst_1
    //   6634: iconst_0
    //   6635: invokevirtual 1568	tos:a	(Ljava/lang/String;ZIZZ)V
    //   6638: goto -52 -> 6586
    //   6641: aload 32
    //   6643: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6646: ldc2_w 2824
    //   6649: lcmp
    //   6650: ifne +25 -> 6675
    //   6653: aload_0
    //   6654: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6657: bipush 47
    //   6659: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   6662: checkcast 2827	acji
    //   6665: aload 32
    //   6667: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6670: invokevirtual 2830	acji:az	([B)V
    //   6673: aconst_null
    //   6674: areturn
    //   6675: aload 32
    //   6677: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6680: ldc2_w 2831
    //   6683: lcmp
    //   6684: ifne +270 -> 6954
    //   6687: invokestatic 2835	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6690: ifeq +46 -> 6736
    //   6693: ldc_w 2837
    //   6696: iconst_4
    //   6697: new 79	java/lang/StringBuilder
    //   6700: dup
    //   6701: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   6704: ldc_w 2839
    //   6707: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6710: aload_1
    //   6711: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6714: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6717: ldc_w 2841
    //   6720: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6723: aload_1
    //   6724: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   6727: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6730: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6733: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6736: new 2843	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody
    //   6739: dup
    //   6740: invokespecial 2844	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:<init>	()V
    //   6743: astore_1
    //   6744: aload_1
    //   6745: aload 32
    //   6747: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6750: invokevirtual 2845	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6753: pop
    //   6754: aload_1
    //   6755: getfield 2848	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6758: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6761: pop
    //   6762: aload_1
    //   6763: getfield 2851	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_undeal_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6766: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6769: istore 4
    //   6771: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6774: ifeq +31 -> 6805
    //   6777: ldc_w 2837
    //   6780: iconst_2
    //   6781: new 79	java/lang/StringBuilder
    //   6784: dup
    //   6785: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   6788: ldc_w 2853
    //   6791: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6794: iload 4
    //   6796: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6799: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6802: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6805: ldc_w 2855
    //   6808: iconst_m1
    //   6809: aload_0
    //   6810: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6813: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6816: invokestatic 2861	cooperation/qzone/LocalMultiProcConfig:getInt4Uin	(Ljava/lang/String;IJ)I
    //   6819: istore 5
    //   6821: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6824: ifeq +46 -> 6870
    //   6827: ldc 21
    //   6829: iconst_2
    //   6830: new 79	java/lang/StringBuilder
    //   6833: dup
    //   6834: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   6837: ldc_w 2863
    //   6840: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6843: aload_0
    //   6844: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6847: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6850: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6853: ldc_w 2865
    //   6856: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6859: iload 5
    //   6861: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6864: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6867: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6870: iload 5
    //   6872: iconst_1
    //   6873: if_icmpne -6844 -> 29
    //   6876: aload_0
    //   6877: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6880: bipush 10
    //   6882: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6885: checkcast 2867	aneo
    //   6888: astore_1
    //   6889: new 699	java/util/ArrayList
    //   6892: dup
    //   6893: invokespecial 700	java/util/ArrayList:<init>	()V
    //   6896: astore 28
    //   6898: new 2869	cooperation/qzone/UndealCount/QZoneCountUserInfo
    //   6901: dup
    //   6902: invokespecial 2870	cooperation/qzone/UndealCount/QZoneCountUserInfo:<init>	()V
    //   6905: astore 29
    //   6907: aload 29
    //   6909: aload_0
    //   6910: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6913: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6916: putfield 2871	cooperation/qzone/UndealCount/QZoneCountUserInfo:uin	J
    //   6919: aload 28
    //   6921: aload 29
    //   6923: invokevirtual 701	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6926: pop
    //   6927: aload_1
    //   6928: bipush 17
    //   6930: iload 4
    //   6932: i2l
    //   6933: aload 28
    //   6935: ldc 186
    //   6937: iconst_0
    //   6938: iconst_1
    //   6939: ldc 186
    //   6941: invokevirtual 2874	aneo:a	(IJLjava/util/ArrayList;Ljava/lang/String;ZZLjava/lang/String;)Z
    //   6944: pop
    //   6945: aconst_null
    //   6946: areturn
    //   6947: astore_1
    //   6948: aload_1
    //   6949: invokevirtual 1635	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   6952: aconst_null
    //   6953: areturn
    //   6954: aload 32
    //   6956: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6959: ldc2_w 2875
    //   6962: lcmp
    //   6963: ifne +25 -> 6988
    //   6966: aload_1
    //   6967: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6970: aload_1
    //   6971: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   6974: aload_0
    //   6975: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6978: aload 32
    //   6980: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6983: invokestatic 2881	ancw:a	(IILcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   6986: aconst_null
    //   6987: areturn
    //   6988: aload 32
    //   6990: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6993: ldc2_w 2882
    //   6996: lcmp
    //   6997: ifne +164 -> 7161
    //   7000: invokestatic 2835	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7003: ifeq +45 -> 7048
    //   7006: ldc 21
    //   7008: iconst_4
    //   7009: new 79	java/lang/StringBuilder
    //   7012: dup
    //   7013: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   7016: ldc_w 2885
    //   7019: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7022: aload_1
    //   7023: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   7026: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7029: ldc_w 2841
    //   7032: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7035: aload_1
    //   7036: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   7039: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7042: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7045: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7048: new 2887	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody
    //   7051: dup
    //   7052: invokespecial 2888	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:<init>	()V
    //   7055: astore_1
    //   7056: aload_1
    //   7057: aload 32
    //   7059: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7062: invokevirtual 2889	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7065: pop
    //   7066: aload_1
    //   7067: ifnull -7038 -> 29
    //   7070: aload_1
    //   7071: getfield 2892	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:uint32_notify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7074: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7077: iconst_1
    //   7078: if_icmpne +77 -> 7155
    //   7081: iconst_1
    //   7082: istore 19
    //   7084: iload 19
    //   7086: iconst_1
    //   7087: if_icmpne -7058 -> 29
    //   7090: new 69	java/lang/String
    //   7093: dup
    //   7094: aload_1
    //   7095: getfield 2895	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:bytes_notify_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7098: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7101: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   7104: ldc_w 1417
    //   7107: invokespecial 1420	java/lang/String:<init>	([BLjava/lang/String;)V
    //   7110: astore_1
    //   7111: aload_0
    //   7112: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7115: iload 19
    //   7117: aload_1
    //   7118: invokestatic 2900	alkm:c	(Lcom/tencent/mobileqq/app/QQAppInterface;ZLjava/lang/String;)V
    //   7121: aload_0
    //   7122: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7125: invokevirtual 2903	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   7128: iload 19
    //   7130: aload_1
    //   7131: invokevirtual 2908	com/tencent/av/gaudio/AVNotifyCenter:h	(ZLjava/lang/String;)V
    //   7134: aconst_null
    //   7135: areturn
    //   7136: astore_1
    //   7137: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7140: ifeq -7111 -> 29
    //   7143: ldc 21
    //   7145: iconst_2
    //   7146: ldc_w 2910
    //   7149: aload_1
    //   7150: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7153: aconst_null
    //   7154: areturn
    //   7155: iconst_0
    //   7156: istore 19
    //   7158: goto -74 -> 7084
    //   7161: aload 32
    //   7163: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7166: ldc2_w 2911
    //   7169: lcmp
    //   7170: ifne +559 -> 7729
    //   7173: new 2914	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody
    //   7176: dup
    //   7177: invokespecial 2915	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:<init>	()V
    //   7180: astore 28
    //   7182: sipush -2029
    //   7185: invokestatic 1308	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7188: checkcast 2917	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7191: astore 29
    //   7193: aload 28
    //   7195: aload 32
    //   7197: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7200: invokevirtual 2918	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7203: pop
    //   7204: aload 29
    //   7206: new 79	java/lang/StringBuilder
    //   7209: dup
    //   7210: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   7213: aload 28
    //   7215: getfield 2921	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7218: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7221: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7224: ldc 186
    //   7226: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7229: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7232: putfield 2924	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7235: aload 29
    //   7237: new 79	java/lang/StringBuilder
    //   7240: dup
    //   7241: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   7244: aload 28
    //   7246: getfield 2927	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7249: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7252: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7255: ldc 186
    //   7257: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7260: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7263: putfield 2930	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7266: aload 29
    //   7268: aload 28
    //   7270: getfield 2933	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7273: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7276: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7279: putfield 2936	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7282: aload 29
    //   7284: aload 28
    //   7286: getfield 2939	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7289: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7292: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7295: putfield 2942	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7298: aload 29
    //   7300: aload 28
    //   7302: getfield 2945	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7305: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7308: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7311: putfield 2948	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   7314: aload 29
    //   7316: aload 28
    //   7318: getfield 2949	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7321: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7324: putfield 2952	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7327: aload 29
    //   7329: aload 28
    //   7331: getfield 2955	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_sub_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7334: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7337: putfield 2958	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7340: aload 29
    //   7342: aload 28
    //   7344: getfield 2961	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_jumpurl	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7347: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7350: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7353: putfield 2963	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   7356: aload_0
    //   7357: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7360: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7363: astore 30
    //   7365: aload_0
    //   7366: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7369: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7372: aload 29
    //   7374: getfield 2924	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7377: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7380: ifeq +309 -> 7689
    //   7383: aload 29
    //   7385: getfield 2930	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7388: astore 28
    //   7390: aload 29
    //   7392: aload 30
    //   7394: aload 28
    //   7396: ldc 186
    //   7398: ldc_w 2965
    //   7401: aload_1
    //   7402: invokevirtual 2968	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   7405: sipush -2029
    //   7408: iconst_0
    //   7409: aload_1
    //   7410: invokevirtual 2971	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   7413: i2l
    //   7414: invokevirtual 2972	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   7417: aload 29
    //   7419: iconst_1
    //   7420: putfield 2973	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   7423: aload 29
    //   7425: aload_1
    //   7426: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   7429: i2l
    //   7430: putfield 2974	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   7433: aload 29
    //   7435: aload_1
    //   7436: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   7439: putfield 2975	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   7442: aload 29
    //   7444: invokevirtual 2978	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   7447: pop
    //   7448: aload 29
    //   7450: invokevirtual 2981	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   7453: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7456: ifeq +77 -> 7533
    //   7459: ldc 21
    //   7461: iconst_2
    //   7462: new 79	java/lang/StringBuilder
    //   7465: dup
    //   7466: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   7469: ldc_w 2983
    //   7472: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7475: aload 29
    //   7477: getfield 2952	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7480: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7483: ldc_w 2985
    //   7486: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7489: aload 29
    //   7491: getfield 2958	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7494: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7497: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7500: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7503: ldc 21
    //   7505: iconst_2
    //   7506: new 79	java/lang/StringBuilder
    //   7509: dup
    //   7510: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   7513: ldc_w 2987
    //   7516: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7519: aload 29
    //   7521: getfield 2963	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   7524: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7527: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7530: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7533: aload 29
    //   7535: getfield 2952	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7538: iconst_1
    //   7539: if_icmpne +11 -> 7550
    //   7542: aload 29
    //   7544: getfield 2958	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7547: ifeq +10086 -> 17633
    //   7550: aload 29
    //   7552: astore_1
    //   7553: aload 29
    //   7555: getfield 2952	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7558: iconst_1
    //   7559: if_icmpne +128 -> 7687
    //   7562: aload_0
    //   7563: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7566: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7569: astore 28
    //   7571: aconst_null
    //   7572: astore_1
    //   7573: aload 28
    //   7575: aload 29
    //   7577: getfield 2924	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7580: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7583: ifeq +124 -> 7707
    //   7586: aload 29
    //   7588: getfield 2936	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7591: astore_1
    //   7592: ldc_w 2988
    //   7595: invokestatic 1656	acfp:m	(I)Ljava/lang/String;
    //   7598: astore 28
    //   7600: ldc_w 2989
    //   7603: invokestatic 1656	acfp:m	(I)Ljava/lang/String;
    //   7606: astore 30
    //   7608: aload 29
    //   7610: aload_0
    //   7611: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7614: aload_1
    //   7615: invokevirtual 2992	com/tencent/mobileqq/data/MessageForQQWalletTips:getQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   7618: astore 31
    //   7620: aload 29
    //   7622: astore_1
    //   7623: aload 31
    //   7625: invokestatic 717	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7628: ifne +59 -> 7687
    //   7631: aload 31
    //   7633: aload 28
    //   7635: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7638: ifne +16 -> 7654
    //   7641: aload 29
    //   7643: astore_1
    //   7644: aload 31
    //   7646: aload 30
    //   7648: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7651: ifeq +36 -> 7687
    //   7654: aload 29
    //   7656: aload_0
    //   7657: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7660: aload 31
    //   7662: aload 29
    //   7664: getfield 2995	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightStart	I
    //   7667: aload 29
    //   7669: getfield 2998	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightEnd	I
    //   7672: aload 29
    //   7674: getfield 3001	com/tencent/mobileqq/data/MessageForQQWalletTips:textColor	Ljava/lang/String;
    //   7677: aload 29
    //   7679: getfield 3004	com/tencent/mobileqq/data/MessageForQQWalletTips:url	Ljava/lang/String;
    //   7682: invokevirtual 3008	com/tencent/mobileqq/data/MessageForQQWalletTips:addQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    //   7685: aconst_null
    //   7686: astore_1
    //   7687: aload_1
    //   7688: areturn
    //   7689: aload 29
    //   7691: getfield 2924	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7694: astore 28
    //   7696: goto -306 -> 7390
    //   7699: astore_1
    //   7700: aload_1
    //   7701: invokevirtual 1392	java/lang/Exception:printStackTrace	()V
    //   7704: goto -171 -> 7533
    //   7707: aload 28
    //   7709: aload 29
    //   7711: getfield 2930	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7714: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7717: ifeq -125 -> 7592
    //   7720: aload 29
    //   7722: getfield 2942	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7725: astore_1
    //   7726: goto -134 -> 7592
    //   7729: aload 32
    //   7731: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7734: ldc2_w 3009
    //   7737: lcmp
    //   7738: ifne +75 -> 7813
    //   7741: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7744: ifeq +13 -> 7757
    //   7747: ldc_w 3012
    //   7750: iconst_2
    //   7751: ldc_w 3014
    //   7754: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7757: new 3016	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7760: dup
    //   7761: invokespecial 3017	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:<init>	()V
    //   7764: aload 32
    //   7766: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7769: invokevirtual 3018	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7772: checkcast 3016	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7775: astore_1
    //   7776: aload_0
    //   7777: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7780: bipush 85
    //   7782: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   7785: checkcast 3020	ashy
    //   7788: aload_1
    //   7789: invokevirtual 3023	ashy:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody;)V
    //   7792: aconst_null
    //   7793: areturn
    //   7794: astore_1
    //   7795: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7798: ifeq -7769 -> 29
    //   7801: ldc 21
    //   7803: iconst_2
    //   7804: ldc_w 3025
    //   7807: aload_1
    //   7808: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7811: aconst_null
    //   7812: areturn
    //   7813: aload 32
    //   7815: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7818: ldc2_w 3026
    //   7821: lcmp
    //   7822: ifne +75 -> 7897
    //   7825: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7828: ifeq +13 -> 7841
    //   7831: ldc_w 3029
    //   7834: iconst_2
    //   7835: ldc_w 3031
    //   7838: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7841: new 3033	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7844: dup
    //   7845: invokespecial 3034	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:<init>	()V
    //   7848: aload 32
    //   7850: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7853: invokevirtual 3035	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7856: checkcast 3033	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7859: astore_1
    //   7860: aload_0
    //   7861: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7864: bipush 85
    //   7866: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   7869: checkcast 3020	ashy
    //   7872: aload_1
    //   7873: invokevirtual 3038	ashy:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody;)V
    //   7876: aconst_null
    //   7877: areturn
    //   7878: astore_1
    //   7879: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7882: ifeq -7853 -> 29
    //   7885: ldc 21
    //   7887: iconst_2
    //   7888: ldc_w 3040
    //   7891: aload_1
    //   7892: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7895: aconst_null
    //   7896: areturn
    //   7897: aload 32
    //   7899: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7902: ldc2_w 3041
    //   7905: lcmp
    //   7906: ifne +357 -> 8263
    //   7909: new 3044	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody
    //   7912: dup
    //   7913: invokespecial 3045	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:<init>	()V
    //   7916: astore 31
    //   7918: sipush -2029
    //   7921: invokestatic 1308	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7924: checkcast 2917	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7927: astore 30
    //   7929: aload 31
    //   7931: aload 32
    //   7933: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7936: invokevirtual 3046	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7939: pop
    //   7940: iconst_0
    //   7941: istore 5
    //   7943: ldc 186
    //   7945: astore 29
    //   7947: aload 29
    //   7949: astore 28
    //   7951: iload 5
    //   7953: istore 4
    //   7955: aload 31
    //   7957: getfield 3050	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:sint32_sessiontype	Lcom/tencent/mobileqq/pb/PBSInt32Field;
    //   7960: invokevirtual 3053	com/tencent/mobileqq/pb/PBSInt32Field:get	()I
    //   7963: tableswitch	default:+9731 -> 17694, 3:+240->8203, 4:+261->8224, 5:+29->7992, 6:+9745->17708
    //   7993: lload_0
    //   7994: new 79	java/lang/StringBuilder
    //   7997: dup
    //   7998: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   8001: aload 31
    //   8003: getfield 3054	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8006: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8009: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8012: ldc 186
    //   8014: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8017: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8020: putfield 2924	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8023: aload 30
    //   8025: new 79	java/lang/StringBuilder
    //   8028: dup
    //   8029: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   8032: aload 31
    //   8034: getfield 3055	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8037: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8040: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8043: ldc 186
    //   8045: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8048: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8051: putfield 2930	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   8054: aload 30
    //   8056: aload 31
    //   8058: getfield 3056	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8061: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8064: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8067: putfield 2936	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   8070: aload 30
    //   8072: aload 31
    //   8074: getfield 3057	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8077: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8080: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8083: putfield 2942	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   8086: aload 30
    //   8088: aload 31
    //   8090: getfield 3058	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8093: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8096: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8099: putfield 2948	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   8102: aload_0
    //   8103: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8106: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8109: astore 31
    //   8111: aload_0
    //   8112: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8115: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8118: aload 30
    //   8120: getfield 2924	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8123: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8126: ifeq +119 -> 8245
    //   8129: aload 30
    //   8131: getfield 2930	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   8134: astore 29
    //   8136: aload 30
    //   8138: aload 31
    //   8140: aload 29
    //   8142: aload 28
    //   8144: ldc_w 2965
    //   8147: aload_1
    //   8148: invokevirtual 2968	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   8151: sipush -2029
    //   8154: iload 4
    //   8156: aload_1
    //   8157: invokevirtual 2971	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   8160: i2l
    //   8161: invokevirtual 2972	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   8164: aload 30
    //   8166: iconst_1
    //   8167: putfield 2973	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   8170: aload 30
    //   8172: aload_1
    //   8173: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8176: i2l
    //   8177: putfield 2974	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   8180: aload 30
    //   8182: aload_1
    //   8183: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8186: putfield 2975	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   8189: aload 30
    //   8191: invokevirtual 2978	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   8194: pop
    //   8195: aload 30
    //   8197: invokevirtual 2981	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   8200: goto +9505 -> 17705
    //   8203: sipush 1000
    //   8206: istore 4
    //   8208: aload 31
    //   8210: getfield 3061	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8213: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8216: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   8219: astore 28
    //   8221: goto -229 -> 7992
    //   8224: sipush 1004
    //   8227: istore 4
    //   8229: aload 31
    //   8231: getfield 3061	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8234: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8237: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   8240: astore 28
    //   8242: goto -250 -> 7992
    //   8245: aload 30
    //   8247: getfield 2924	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8250: astore 29
    //   8252: goto -116 -> 8136
    //   8255: astore_1
    //   8256: aload_1
    //   8257: invokevirtual 1392	java/lang/Exception:printStackTrace	()V
    //   8260: goto +9445 -> 17705
    //   8263: aload 32
    //   8265: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8268: ldc2_w 3062
    //   8271: lcmp
    //   8272: ifne +305 -> 8577
    //   8275: aload_0
    //   8276: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8279: bipush 51
    //   8281: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8284: checkcast 171	acff
    //   8287: astore 34
    //   8289: new 3065	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody
    //   8292: dup
    //   8293: invokespecial 3066	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:<init>	()V
    //   8296: astore 33
    //   8298: sipush -2029
    //   8301: invokestatic 1308	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   8304: checkcast 2917	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   8307: astore 31
    //   8309: aload 33
    //   8311: aload 32
    //   8313: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8316: invokevirtual 3067	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8319: pop
    //   8320: new 79	java/lang/StringBuilder
    //   8323: dup
    //   8324: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   8327: aload 33
    //   8329: getfield 3068	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8332: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8335: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8338: ldc 186
    //   8340: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8343: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8346: astore 29
    //   8348: new 79	java/lang/StringBuilder
    //   8351: dup
    //   8352: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   8355: aload 33
    //   8357: getfield 3069	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8360: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8363: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8366: ldc 186
    //   8368: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8371: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8374: astore 30
    //   8376: aload_0
    //   8377: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8380: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8383: aload 29
    //   8385: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8388: ifeq +166 -> 8554
    //   8391: aload 30
    //   8393: astore 28
    //   8395: aload 34
    //   8397: aload 28
    //   8399: invokevirtual 175	acff:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   8402: astore 32
    //   8404: aload 32
    //   8406: ifnull +155 -> 8561
    //   8409: aload 32
    //   8411: invokevirtual 192	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   8414: ifeq +147 -> 8561
    //   8417: iconst_0
    //   8418: istore 4
    //   8420: aload 31
    //   8422: aload 29
    //   8424: putfield 2924	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8427: aload 31
    //   8429: aload 30
    //   8431: putfield 2930	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   8434: aload 31
    //   8436: aload 33
    //   8438: getfield 3070	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8441: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8444: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8447: putfield 2936	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   8450: aload 31
    //   8452: aload 33
    //   8454: getfield 3071	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8457: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8460: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8463: putfield 2942	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   8466: aload 31
    //   8468: aload 33
    //   8470: getfield 3072	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8473: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8476: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8479: putfield 2948	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   8482: aload 31
    //   8484: aload_0
    //   8485: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8488: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8491: aload 28
    //   8493: ldc 186
    //   8495: ldc_w 2965
    //   8498: aload_1
    //   8499: invokevirtual 2968	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   8502: sipush -2029
    //   8505: iload 4
    //   8507: aload_1
    //   8508: invokevirtual 2971	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   8511: i2l
    //   8512: invokevirtual 2972	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   8515: aload 31
    //   8517: iconst_1
    //   8518: putfield 2973	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   8521: aload 31
    //   8523: aload_1
    //   8524: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8527: i2l
    //   8528: putfield 2974	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   8531: aload 31
    //   8533: aload_1
    //   8534: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8537: putfield 2975	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   8540: aload 31
    //   8542: invokevirtual 2978	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   8545: pop
    //   8546: aload 31
    //   8548: invokevirtual 2981	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   8551: aload 31
    //   8553: areturn
    //   8554: aload 29
    //   8556: astore 28
    //   8558: goto -163 -> 8395
    //   8561: sipush 1001
    //   8564: istore 4
    //   8566: goto -146 -> 8420
    //   8569: astore_1
    //   8570: aload_1
    //   8571: invokevirtual 1392	java/lang/Exception:printStackTrace	()V
    //   8574: goto -23 -> 8551
    //   8577: aload 32
    //   8579: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8582: ldc2_w 3073
    //   8585: lcmp
    //   8586: ifne +62 -> 8648
    //   8589: aload_0
    //   8590: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8593: bipush 62
    //   8595: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   8598: checkcast 3076	acyy
    //   8601: aload 32
    //   8603: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8606: invokevirtual 3079	acyy:aS	([B)V
    //   8609: aload_1
    //   8610: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   8613: lstore_2
    //   8614: aload_1
    //   8615: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8618: istore 4
    //   8620: aload_1
    //   8621: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8624: lstore 15
    //   8626: aload_1
    //   8627: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   8630: istore 5
    //   8632: aload_0
    //   8633: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8636: lload_2
    //   8637: iload 4
    //   8639: lload 15
    //   8641: iload 5
    //   8643: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   8646: aconst_null
    //   8647: areturn
    //   8648: aload 32
    //   8650: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8653: ldc2_w 3080
    //   8656: lcmp
    //   8657: ifne +114 -> 8771
    //   8660: new 3083	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody
    //   8663: dup
    //   8664: invokespecial 3084	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:<init>	()V
    //   8667: astore_1
    //   8668: aload_1
    //   8669: aload 32
    //   8671: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8674: invokevirtual 3085	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8677: pop
    //   8678: aload_1
    //   8679: getfield 3088	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8682: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   8685: ifeq +34 -> 8719
    //   8688: aload_1
    //   8689: getfield 3088	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8692: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8695: lconst_1
    //   8696: lcmp
    //   8697: ifne +68 -> 8765
    //   8700: iconst_1
    //   8701: istore 4
    //   8703: iload 4
    //   8705: ifeq +14 -> 8719
    //   8708: aload_0
    //   8709: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8712: invokevirtual 1485	com/tencent/mobileqq/app/MessageHandler:a	()Lacrp;
    //   8715: iconst_2
    //   8716: invokevirtual 1490	acrp:Kg	(I)V
    //   8719: aload_1
    //   8720: getfield 3091	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:rpt_msg_msg_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   8723: invokevirtual 2197	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   8726: ifeq -8697 -> 29
    //   8729: aload_0
    //   8730: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8733: aload_1
    //   8734: invokestatic 3096	yrv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody;)V
    //   8737: aconst_null
    //   8738: areturn
    //   8739: astore_1
    //   8740: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8743: ifeq +13 -> 8756
    //   8746: ldc_w 2703
    //   8749: iconst_2
    //   8750: ldc 186
    //   8752: aload_1
    //   8753: invokestatic 2705	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8756: new 2707	java/lang/RuntimeException
    //   8759: dup
    //   8760: aload_1
    //   8761: invokespecial 2710	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   8764: athrow
    //   8765: iconst_0
    //   8766: istore 4
    //   8768: goto -65 -> 8703
    //   8771: aload 32
    //   8773: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8776: ldc2_w 3097
    //   8779: lcmp
    //   8780: ifeq +15 -> 8795
    //   8783: aload 32
    //   8785: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8788: ldc2_w 3099
    //   8791: lcmp
    //   8792: ifne +68 -> 8860
    //   8795: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8798: ifeq +13 -> 8811
    //   8801: ldc_w 3102
    //   8804: iconst_2
    //   8805: ldc_w 3104
    //   8808: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8811: new 3106	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody
    //   8814: dup
    //   8815: invokespecial 3107	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:<init>	()V
    //   8818: astore_1
    //   8819: aload_1
    //   8820: aload 32
    //   8822: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8825: invokevirtual 3108	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8828: pop
    //   8829: aload_0
    //   8830: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8833: aload_1
    //   8834: lconst_0
    //   8835: iconst_0
    //   8836: invokestatic 3113	ancp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody;JZ)V
    //   8839: aconst_null
    //   8840: areturn
    //   8841: astore_1
    //   8842: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8845: ifeq -8816 -> 29
    //   8848: ldc_w 3102
    //   8851: iconst_2
    //   8852: ldc_w 3115
    //   8855: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8858: aconst_null
    //   8859: areturn
    //   8860: aload 32
    //   8862: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8865: ldc2_w 3116
    //   8868: lcmp
    //   8869: ifne +25 -> 8894
    //   8872: aload_0
    //   8873: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8876: bipush 51
    //   8878: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   8881: checkcast 2485	syw
    //   8884: aload 32
    //   8886: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8889: invokevirtual 3120	syw:X	([B)V
    //   8892: aconst_null
    //   8893: areturn
    //   8894: aload 32
    //   8896: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8899: ldc2_w 3121
    //   8902: lcmp
    //   8903: ifne +24 -> 8927
    //   8906: iconst_2
    //   8907: invokestatic 3127	com/tencent/mqp/app/sec/d:x	()[Ljava/lang/Object;
    //   8910: aload 32
    //   8912: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8915: invokestatic 3131	com/tencent/mqp/app/sec/d:e1	(I[Ljava/lang/Object;[B)V
    //   8918: aconst_null
    //   8919: areturn
    //   8920: astore_1
    //   8921: aload_1
    //   8922: invokevirtual 3132	java/lang/Throwable:printStackTrace	()V
    //   8925: aconst_null
    //   8926: areturn
    //   8927: aload 32
    //   8929: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8932: ldc2_w 3133
    //   8935: lcmp
    //   8936: ifne +181 -> 9117
    //   8939: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8942: ifeq +12 -> 8954
    //   8945: ldc 21
    //   8947: iconst_4
    //   8948: ldc_w 3136
    //   8951: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8954: new 3138	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody
    //   8957: dup
    //   8958: invokespecial 3139	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:<init>	()V
    //   8961: astore_1
    //   8962: aload_1
    //   8963: aload 32
    //   8965: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8968: invokevirtual 3140	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8971: pop
    //   8972: new 364	android/content/Intent
    //   8975: dup
    //   8976: ldc_w 3142
    //   8979: invokespecial 368	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   8982: astore 28
    //   8984: aload_1
    //   8985: getfield 3145	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8988: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   8991: ifeq +114 -> 9105
    //   8994: aload_1
    //   8995: getfield 3145	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8998: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9001: tableswitch	default:+8719 -> 17720, 0:+80->9081, 1:+92->9093
    //   9025: iload_2
    //   9026: ldc_w 3147
    //   9029: invokevirtual 3150	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9032: pop
    //   9033: aload 28
    //   9035: ldc_w 3152
    //   9038: aload_1
    //   9039: getfield 3155	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:string_push_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9042: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9045: invokevirtual 516	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9048: pop
    //   9049: aload_0
    //   9050: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9053: invokevirtual 392	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9056: aload 28
    //   9058: invokevirtual 396	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   9061: aconst_null
    //   9062: areturn
    //   9063: astore_1
    //   9064: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9067: ifeq -9038 -> 29
    //   9070: ldc 21
    //   9072: iconst_4
    //   9073: ldc_w 3157
    //   9076: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9079: aconst_null
    //   9080: areturn
    //   9081: aload 28
    //   9083: ldc_w 3147
    //   9086: invokevirtual 3150	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9089: pop
    //   9090: goto -57 -> 9033
    //   9093: aload 28
    //   9095: ldc_w 3159
    //   9098: invokevirtual 3150	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9101: pop
    //   9102: goto -69 -> 9033
    //   9105: aload 28
    //   9107: ldc_w 3147
    //   9110: invokevirtual 3150	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9113: pop
    //   9114: goto -81 -> 9033
    //   9117: aload 32
    //   9119: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9122: ldc2_w 3160
    //   9125: lcmp
    //   9126: ifne +238 -> 9364
    //   9129: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9132: ifeq +12 -> 9144
    //   9135: ldc 21
    //   9137: iconst_2
    //   9138: ldc_w 3163
    //   9141: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9144: new 3165	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody
    //   9147: dup
    //   9148: invokespecial 3166	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:<init>	()V
    //   9151: astore_1
    //   9152: aload_1
    //   9153: aload 32
    //   9155: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9158: invokevirtual 3167	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9161: pop
    //   9162: aload_1
    //   9163: getfield 3170	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:string_params	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9166: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9169: astore_1
    //   9170: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9173: ifeq +28 -> 9201
    //   9176: ldc 21
    //   9178: new 79	java/lang/StringBuilder
    //   9181: dup
    //   9182: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9185: ldc_w 3172
    //   9188: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9191: aload_1
    //   9192: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9195: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9198: invokestatic 3176	asbt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9201: new 2776	org/json/JSONObject
    //   9204: dup
    //   9205: aload_1
    //   9206: invokespecial 2780	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9209: ldc_w 3178
    //   9212: invokevirtual 2789	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9215: astore 28
    //   9217: ldc_w 3180
    //   9220: invokestatic 3184	tbb:gQ	(Ljava/lang/String;)Ljava/lang/String;
    //   9223: ldc_w 3186
    //   9226: invokevirtual 3190	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   9229: astore 29
    //   9231: iconst_0
    //   9232: istore 6
    //   9234: iconst_0
    //   9235: istore 4
    //   9237: iload 6
    //   9239: istore 5
    //   9241: iload 4
    //   9243: aload 29
    //   9245: arraylength
    //   9246: if_icmpge +38 -> 9284
    //   9249: aload 29
    //   9251: iload 4
    //   9253: aaload
    //   9254: invokestatic 717	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9257: ifne +98 -> 9355
    //   9260: aload 28
    //   9262: invokestatic 717	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9265: ifne +90 -> 9355
    //   9268: aload 29
    //   9270: iload 4
    //   9272: aaload
    //   9273: aload 28
    //   9275: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9278: ifeq +77 -> 9355
    //   9281: iconst_1
    //   9282: istore 5
    //   9284: iload 5
    //   9286: ifne +33 -> 9319
    //   9289: aload 28
    //   9291: invokestatic 717	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9294: ifne +25 -> 9319
    //   9297: aload 28
    //   9299: ldc_w 3192
    //   9302: invokestatic 3194	tbb:X	(Ljava/lang/String;Ljava/lang/String;)Z
    //   9305: pop
    //   9306: aload 28
    //   9308: aload_1
    //   9309: ldc_w 3196
    //   9312: invokestatic 3199	tbb:h	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   9315: pop
    //   9316: invokestatic 3204	tax:registerReceiver	()V
    //   9319: invokestatic 3209	com/tencent/gamecenter/appointment/GameCenterCheck:bCp	()V
    //   9322: aload_0
    //   9323: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9326: ldc_w 3211
    //   9329: ldc_w 3213
    //   9332: aload 28
    //   9334: ldc_w 3215
    //   9337: ldc_w 3217
    //   9340: ldc_w 3219
    //   9343: invokestatic 3222	tbb:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   9346: aconst_null
    //   9347: areturn
    //   9348: astore_1
    //   9349: aload_1
    //   9350: invokevirtual 1392	java/lang/Exception:printStackTrace	()V
    //   9353: aconst_null
    //   9354: areturn
    //   9355: iload 4
    //   9357: iconst_1
    //   9358: iadd
    //   9359: istore 4
    //   9361: goto -124 -> 9237
    //   9364: aload 32
    //   9366: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9369: ldc2_w 3223
    //   9372: lcmp
    //   9373: ifne +57 -> 9430
    //   9376: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9379: ifeq +12 -> 9391
    //   9382: ldc 21
    //   9384: iconst_2
    //   9385: ldc_w 3226
    //   9388: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9391: new 3228	tencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody
    //   9394: dup
    //   9395: invokespecial 3229	tencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody:<init>	()V
    //   9398: astore_1
    //   9399: aload_1
    //   9400: aload 32
    //   9402: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9405: invokevirtual 3230	tencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9408: pop
    //   9409: aload_0
    //   9410: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9413: bipush 12
    //   9415: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9418: checkcast 1761	anec
    //   9421: aload_1
    //   9422: invokevirtual 3233	anec:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody;)V
    //   9425: aconst_null
    //   9426: areturn
    //   9427: astore_1
    //   9428: aconst_null
    //   9429: areturn
    //   9430: aload 32
    //   9432: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9435: ldc2_w 3234
    //   9438: lcmp
    //   9439: ifne +1451 -> 10890
    //   9442: new 3237	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody
    //   9445: dup
    //   9446: invokespecial 3238	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:<init>	()V
    //   9449: astore 28
    //   9451: aload 28
    //   9453: aload 32
    //   9455: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9458: invokevirtual 3239	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9461: pop
    //   9462: aload 28
    //   9464: getfield 3242	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9467: invokevirtual 2370	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   9470: ifeq +1201 -> 10671
    //   9473: aload 28
    //   9475: getfield 3242	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9478: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9481: invokevirtual 3245	java/lang/String:trim	()Ljava/lang/String;
    //   9484: astore_1
    //   9485: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9488: ifeq +30 -> 9518
    //   9491: ldc_w 3247
    //   9494: iconst_2
    //   9495: new 79	java/lang/StringBuilder
    //   9498: dup
    //   9499: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9502: ldc_w 3249
    //   9505: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9508: aload_1
    //   9509: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9512: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9515: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9518: aload 28
    //   9520: getfield 3252	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9523: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9526: iconst_1
    //   9527: if_icmpne +1150 -> 10677
    //   9530: iconst_1
    //   9531: istore 22
    //   9533: aload 28
    //   9535: getfield 3255	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_folder_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9538: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9541: iconst_1
    //   9542: if_icmpne +1141 -> 10683
    //   9545: iconst_1
    //   9546: istore 23
    //   9548: aload 28
    //   9550: getfield 3258	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9553: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9556: iconst_1
    //   9557: if_icmpne +1132 -> 10689
    //   9560: iconst_1
    //   9561: istore 20
    //   9563: aload 28
    //   9565: getfield 3261	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9568: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9571: iconst_1
    //   9572: if_icmpne +1123 -> 10695
    //   9575: iconst_1
    //   9576: istore 19
    //   9578: aload 28
    //   9580: getfield 3264	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9583: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9586: iconst_1
    //   9587: if_icmpne +1114 -> 10701
    //   9590: iconst_1
    //   9591: istore 21
    //   9593: aload 28
    //   9595: getfield 3267	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_start_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9598: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9601: istore 6
    //   9603: aload 28
    //   9605: getfield 3270	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_end_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9608: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9611: istore 7
    //   9613: invokestatic 552	java/lang/System:currentTimeMillis	()J
    //   9616: ldc2_w 997
    //   9619: ldiv
    //   9620: l2i
    //   9621: istore 8
    //   9623: aload 28
    //   9625: getfield 3273	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_period_of_validity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9628: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9631: istore 5
    //   9633: aload 28
    //   9635: getfield 3276	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9638: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9641: istore 9
    //   9643: aload 28
    //   9645: getfield 3279	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_task_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9648: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9651: astore 31
    //   9653: aload 28
    //   9655: getfield 3282	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9658: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9661: astore 32
    //   9663: aload 28
    //   9665: getfield 3285	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_color	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9668: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9671: astore 33
    //   9673: aload 28
    //   9675: getfield 3288	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9678: invokevirtual 2063	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9681: astore 29
    //   9683: aload 28
    //   9685: getfield 3291	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9688: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9691: istore 10
    //   9693: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9696: ifeq +163 -> 9859
    //   9699: ldc_w 3247
    //   9702: iconst_2
    //   9703: new 79	java/lang/StringBuilder
    //   9706: dup
    //   9707: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9710: ldc_w 3293
    //   9713: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9716: iload 6
    //   9718: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9721: ldc_w 3295
    //   9724: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9727: iload 7
    //   9729: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9732: ldc_w 3297
    //   9735: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9738: iload 5
    //   9740: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9743: ldc_w 3299
    //   9746: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9749: iload 23
    //   9751: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9754: ldc_w 3301
    //   9757: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9760: iload 22
    //   9762: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9765: ldc_w 3301
    //   9768: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9771: iload 20
    //   9773: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9776: ldc_w 3301
    //   9779: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9782: iload 19
    //   9784: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9787: ldc_w 3301
    //   9790: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9793: iload 21
    //   9795: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9798: ldc_w 3303
    //   9801: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9804: iload 9
    //   9806: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9809: ldc_w 3305
    //   9812: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9815: aload 31
    //   9817: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9820: ldc_w 3307
    //   9823: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9826: aload 32
    //   9828: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9831: ldc_w 3309
    //   9834: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9837: aload 33
    //   9839: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9842: ldc_w 3311
    //   9845: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9848: aload 29
    //   9850: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9853: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9856: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9859: iload 8
    //   9861: iload 6
    //   9863: if_icmplt -9834 -> 29
    //   9866: iload 8
    //   9868: iload 7
    //   9870: if_icmpgt -9841 -> 29
    //   9873: iload 5
    //   9875: istore 4
    //   9877: iload 5
    //   9879: ldc_w 3312
    //   9882: if_icmple +8 -> 9890
    //   9885: ldc_w 3312
    //   9888: istore 4
    //   9890: iload 22
    //   9892: ifne +18 -> 9910
    //   9895: iload 20
    //   9897: ifne +13 -> 9910
    //   9900: iload 19
    //   9902: ifne +8 -> 9910
    //   9905: iload 21
    //   9907: ifeq +7723 -> 17630
    //   9910: iconst_1
    //   9911: istore 23
    //   9913: iload 23
    //   9915: ifne +7696 -> 17611
    //   9918: iload 22
    //   9920: ifne +15 -> 9935
    //   9923: aload 28
    //   9925: getfield 3315	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9928: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9931: iconst_1
    //   9932: if_icmpne +775 -> 10707
    //   9935: iconst_1
    //   9936: istore 22
    //   9938: iload 20
    //   9940: ifne +15 -> 9955
    //   9943: aload 28
    //   9945: getfield 3318	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9948: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9951: iconst_1
    //   9952: if_icmpne +761 -> 10713
    //   9955: iconst_1
    //   9956: istore 20
    //   9958: iload 19
    //   9960: ifne +15 -> 9975
    //   9963: aload 28
    //   9965: getfield 3321	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9968: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9971: iconst_1
    //   9972: if_icmpne +747 -> 10719
    //   9975: iconst_1
    //   9976: istore 19
    //   9978: iload 21
    //   9980: ifne +15 -> 9995
    //   9983: aload 28
    //   9985: getfield 3324	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9988: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9991: iconst_1
    //   9992: if_icmpne +733 -> 10725
    //   9995: iconst_1
    //   9996: istore 21
    //   9998: iload 21
    //   10000: istore 24
    //   10002: iload 22
    //   10004: istore 25
    //   10006: iload 20
    //   10008: istore 26
    //   10010: iload 19
    //   10012: istore 27
    //   10014: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10017: ifeq +80 -> 10097
    //   10020: ldc_w 3247
    //   10023: iconst_2
    //   10024: new 79	java/lang/StringBuilder
    //   10027: dup
    //   10028: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   10031: ldc_w 3326
    //   10034: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10037: iload 22
    //   10039: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10042: ldc_w 3301
    //   10045: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10048: iload 20
    //   10050: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10053: ldc_w 3301
    //   10056: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10059: iload 19
    //   10061: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10064: ldc_w 3301
    //   10067: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10070: iload 21
    //   10072: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10075: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10078: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10081: iload 19
    //   10083: istore 27
    //   10085: iload 20
    //   10087: istore 26
    //   10089: iload 22
    //   10091: istore 25
    //   10093: iload 21
    //   10095: istore 24
    //   10097: aload_0
    //   10098: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10101: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   10104: astore 30
    //   10106: aload 30
    //   10108: astore 28
    //   10110: aload 30
    //   10112: invokestatic 717	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10115: ifeq +8 -> 10123
    //   10118: ldc_w 3328
    //   10121: astore 28
    //   10123: aload_0
    //   10124: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10127: invokevirtual 392	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10130: new 79	java/lang/StringBuilder
    //   10133: dup
    //   10134: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   10137: ldc_w 3330
    //   10140: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10143: aload 28
    //   10145: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10148: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10151: iconst_0
    //   10152: invokevirtual 1102	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10155: astore 30
    //   10157: aload 30
    //   10159: invokeinterface 470 1 0
    //   10164: astore 28
    //   10166: aload 30
    //   10168: ldc_w 3332
    //   10171: iconst_0
    //   10172: invokeinterface 3336 3 0
    //   10177: ifne +59 -> 10236
    //   10180: aload 30
    //   10182: ldc_w 3338
    //   10185: iconst_0
    //   10186: invokeinterface 3336 3 0
    //   10191: ifne +45 -> 10236
    //   10194: aload 30
    //   10196: ldc_w 3340
    //   10199: iconst_0
    //   10200: invokeinterface 3336 3 0
    //   10205: ifne +31 -> 10236
    //   10208: aload 30
    //   10210: ldc_w 3342
    //   10213: iconst_0
    //   10214: invokeinterface 3336 3 0
    //   10219: ifne +17 -> 10236
    //   10222: aload 30
    //   10224: ldc_w 3344
    //   10227: iconst_0
    //   10228: invokeinterface 3336 3 0
    //   10233: ifeq +109 -> 10342
    //   10236: aload 30
    //   10238: ldc_w 3346
    //   10241: iconst_0
    //   10242: invokeinterface 485 3 0
    //   10247: istore 5
    //   10249: aload 30
    //   10251: ldc_w 3348
    //   10254: iconst_0
    //   10255: invokeinterface 485 3 0
    //   10260: istore 11
    //   10262: aload 30
    //   10264: ldc_w 3350
    //   10267: iconst_0
    //   10268: invokeinterface 485 3 0
    //   10273: istore 12
    //   10275: aload 30
    //   10277: ldc_w 3352
    //   10280: iconst_0
    //   10281: invokeinterface 485 3 0
    //   10286: istore 13
    //   10288: invokestatic 552	java/lang/System:currentTimeMillis	()J
    //   10291: ldc2_w 997
    //   10294: ldiv
    //   10295: l2i
    //   10296: istore 14
    //   10298: iload 14
    //   10300: ifeq +42 -> 10342
    //   10303: iload 11
    //   10305: ifeq +37 -> 10342
    //   10308: iload 12
    //   10310: ifeq +32 -> 10342
    //   10313: iload 13
    //   10315: ifeq +27 -> 10342
    //   10318: iload 14
    //   10320: iload 11
    //   10322: if_icmplt +409 -> 10731
    //   10325: iload 14
    //   10327: iload 12
    //   10329: if_icmpgt +402 -> 10731
    //   10332: iload 14
    //   10334: iload 5
    //   10336: isub
    //   10337: iload 13
    //   10339: if_icmpge +392 -> 10731
    //   10342: aload 28
    //   10344: ldc_w 3348
    //   10347: iload 6
    //   10349: invokeinterface 478 3 0
    //   10354: pop
    //   10355: aload 28
    //   10357: ldc_w 3350
    //   10360: iload 7
    //   10362: invokeinterface 478 3 0
    //   10367: pop
    //   10368: aload 28
    //   10370: ldc_w 3352
    //   10373: iload 4
    //   10375: invokeinterface 478 3 0
    //   10380: pop
    //   10381: aload 28
    //   10383: ldc_w 3354
    //   10386: aload_1
    //   10387: invokeinterface 3358 3 0
    //   10392: pop
    //   10393: aload 28
    //   10395: ldc_w 3346
    //   10398: iload 8
    //   10400: invokeinterface 478 3 0
    //   10405: pop
    //   10406: aload 28
    //   10408: ldc_w 3360
    //   10411: iload 9
    //   10413: invokeinterface 478 3 0
    //   10418: pop
    //   10419: aload 28
    //   10421: ldc_w 3362
    //   10424: aload 31
    //   10426: invokeinterface 3358 3 0
    //   10431: pop
    //   10432: aload 28
    //   10434: ldc_w 3364
    //   10437: aload 32
    //   10439: invokeinterface 3358 3 0
    //   10444: pop
    //   10445: aload 28
    //   10447: ldc_w 3366
    //   10450: aload 33
    //   10452: invokeinterface 3358 3 0
    //   10457: pop
    //   10458: aload 28
    //   10460: ldc_w 3368
    //   10463: invokestatic 622	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   10466: invokeinterface 1115 4 0
    //   10471: pop
    //   10472: aload 28
    //   10474: ldc_w 3370
    //   10477: iload 10
    //   10479: invokeinterface 478 3 0
    //   10484: pop
    //   10485: aload 29
    //   10487: ifnonnull +323 -> 10810
    //   10490: ldc 186
    //   10492: astore_1
    //   10493: aload 28
    //   10495: ldc_w 3372
    //   10498: aload_1
    //   10499: invokeinterface 3358 3 0
    //   10504: pop
    //   10505: aload 28
    //   10507: ldc_w 3374
    //   10510: iconst_1
    //   10511: invokeinterface 478 3 0
    //   10516: pop
    //   10517: aload 28
    //   10519: ldc_w 3344
    //   10522: iload 23
    //   10524: invokeinterface 1112 3 0
    //   10529: pop
    //   10530: aload 28
    //   10532: ldc_w 3332
    //   10535: iload 25
    //   10537: invokeinterface 1112 3 0
    //   10542: pop
    //   10543: aload 28
    //   10545: ldc_w 3338
    //   10548: iload 26
    //   10550: invokeinterface 1112 3 0
    //   10555: pop
    //   10556: aload 28
    //   10558: ldc_w 3340
    //   10561: iload 27
    //   10563: invokeinterface 1112 3 0
    //   10568: pop
    //   10569: aload 28
    //   10571: ldc_w 3342
    //   10574: iload 24
    //   10576: invokeinterface 1112 3 0
    //   10581: pop
    //   10582: aload 28
    //   10584: invokeinterface 481 1 0
    //   10589: pop
    //   10590: iload 23
    //   10592: ifeq +224 -> 10816
    //   10595: aload_0
    //   10596: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10599: bipush 88
    //   10601: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10604: checkcast 3376	kdm
    //   10607: invokestatic 622	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   10610: iload 23
    //   10612: invokevirtual 3379	kdm:T	(JZ)V
    //   10615: aload_0
    //   10616: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10619: bipush 68
    //   10621: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   10624: checkcast 3381	kdp
    //   10627: invokevirtual 3384	kdp:aBR	()V
    //   10630: aconst_null
    //   10631: astore_1
    //   10632: iload 25
    //   10634: ifeq +208 -> 10842
    //   10637: ldc_w 3386
    //   10640: astore_1
    //   10641: aload_0
    //   10642: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10645: ldc_w 3388
    //   10648: ldc 186
    //   10650: ldc 186
    //   10652: ldc_w 3390
    //   10655: aload_1
    //   10656: iconst_0
    //   10657: iconst_0
    //   10658: ldc 186
    //   10660: ldc 186
    //   10662: ldc 186
    //   10664: ldc 186
    //   10666: invokestatic 2226	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10669: aconst_null
    //   10670: areturn
    //   10671: ldc 186
    //   10673: astore_1
    //   10674: goto -1189 -> 9485
    //   10677: iconst_0
    //   10678: istore 22
    //   10680: goto -1147 -> 9533
    //   10683: iconst_0
    //   10684: istore 23
    //   10686: goto -1138 -> 9548
    //   10689: iconst_0
    //   10690: istore 20
    //   10692: goto -1129 -> 9563
    //   10695: iconst_0
    //   10696: istore 19
    //   10698: goto -1120 -> 9578
    //   10701: iconst_0
    //   10702: istore 21
    //   10704: goto -1111 -> 9593
    //   10707: iconst_0
    //   10708: istore 22
    //   10710: goto -772 -> 9938
    //   10713: iconst_0
    //   10714: istore 20
    //   10716: goto -758 -> 9958
    //   10719: iconst_0
    //   10720: istore 19
    //   10722: goto -744 -> 9978
    //   10725: iconst_0
    //   10726: istore 21
    //   10728: goto -730 -> 9998
    //   10731: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10734: ifeq +13 -> 10747
    //   10737: ldc_w 3247
    //   10740: iconst_2
    //   10741: ldc_w 3392
    //   10744: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10747: aload 28
    //   10749: ldc_w 3332
    //   10752: iconst_0
    //   10753: invokeinterface 1112 3 0
    //   10758: pop
    //   10759: aload 28
    //   10761: ldc_w 3338
    //   10764: iconst_0
    //   10765: invokeinterface 1112 3 0
    //   10770: pop
    //   10771: aload 28
    //   10773: ldc_w 3340
    //   10776: iconst_0
    //   10777: invokeinterface 1112 3 0
    //   10782: pop
    //   10783: aload 28
    //   10785: ldc_w 3342
    //   10788: iconst_0
    //   10789: invokeinterface 1112 3 0
    //   10794: pop
    //   10795: aload 28
    //   10797: ldc_w 3344
    //   10800: iconst_0
    //   10801: invokeinterface 1112 3 0
    //   10806: pop
    //   10807: goto -465 -> 10342
    //   10810: aload 29
    //   10812: astore_1
    //   10813: goto -320 -> 10493
    //   10816: aload_0
    //   10817: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10820: ldc_w 3394
    //   10823: invokevirtual 3398	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   10826: astore_1
    //   10827: aload_1
    //   10828: ifnull -213 -> 10615
    //   10831: aload_1
    //   10832: sipush 1009
    //   10835: invokevirtual 3403	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   10838: pop
    //   10839: goto -224 -> 10615
    //   10842: iload 26
    //   10844: ifeq +10 -> 10854
    //   10847: ldc_w 3405
    //   10850: astore_1
    //   10851: goto -210 -> 10641
    //   10854: iload 27
    //   10856: ifeq +10 -> 10866
    //   10859: ldc_w 3407
    //   10862: astore_1
    //   10863: goto -222 -> 10641
    //   10866: iload 24
    //   10868: ifeq +10 -> 10878
    //   10871: ldc_w 3409
    //   10874: astore_1
    //   10875: goto -234 -> 10641
    //   10878: iload 23
    //   10880: ifeq -239 -> 10641
    //   10883: ldc_w 3411
    //   10886: astore_1
    //   10887: goto -246 -> 10641
    //   10890: aload 32
    //   10892: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10895: ldc2_w 3412
    //   10898: lcmp
    //   10899: ifne +87 -> 10986
    //   10902: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10905: ifeq +12 -> 10917
    //   10908: ldc 21
    //   10910: iconst_2
    //   10911: ldc_w 3415
    //   10914: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10917: aload_0
    //   10918: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10921: sipush 153
    //   10924: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10927: checkcast 648	abhh
    //   10930: astore 28
    //   10932: aload 28
    //   10934: ifnull +13 -> 10947
    //   10937: aload 28
    //   10939: aload 32
    //   10941: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10944: invokevirtual 3418	abhh:at	([B)V
    //   10947: aload_1
    //   10948: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   10951: lstore_2
    //   10952: aload_1
    //   10953: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   10956: istore 4
    //   10958: aload_1
    //   10959: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   10962: lstore 15
    //   10964: aload_1
    //   10965: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   10968: istore 5
    //   10970: aload_0
    //   10971: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   10974: lload_2
    //   10975: iload 4
    //   10977: lload 15
    //   10979: iload 5
    //   10981: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   10984: aconst_null
    //   10985: areturn
    //   10986: aload 32
    //   10988: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10991: ldc2_w 3419
    //   10994: lcmp
    //   10995: ifne +56 -> 11051
    //   10998: new 3422	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody
    //   11001: dup
    //   11002: invokespecial 3423	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:<init>	()V
    //   11005: astore_1
    //   11006: aload_1
    //   11007: aload 32
    //   11009: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11012: invokevirtual 3424	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11015: pop
    //   11016: aload_1
    //   11017: getfield 3425	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   11020: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   11023: pop2
    //   11024: aload_1
    //   11025: getfield 3428	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11028: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11031: pop
    //   11032: aload_1
    //   11033: getfield 3432	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:msg_mod_block	Ltencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock;
    //   11036: invokevirtual 3435	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11039: checkcast 3434	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock
    //   11042: getfield 3438	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11045: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11048: pop
    //   11049: aconst_null
    //   11050: areturn
    //   11051: aload 32
    //   11053: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11056: ldc2_w 3439
    //   11059: lcmp
    //   11060: ifne +87 -> 11147
    //   11063: new 3442	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   11066: dup
    //   11067: invokespecial 3443	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   11070: astore_1
    //   11071: aload_1
    //   11072: aload 32
    //   11074: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11077: invokevirtual 3444	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11080: pop
    //   11081: aload_1
    //   11082: getfield 3447	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11085: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11088: istore 4
    //   11090: iload 4
    //   11092: ifne +26 -> 11118
    //   11095: iconst_1
    //   11096: istore 19
    //   11098: aload_0
    //   11099: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11102: sipush 138
    //   11105: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11108: checkcast 3449	ylm
    //   11111: iload 19
    //   11113: invokevirtual 3452	ylm:Aj	(Z)V
    //   11116: aconst_null
    //   11117: areturn
    //   11118: iconst_0
    //   11119: istore 19
    //   11121: goto -23 -> 11098
    //   11124: astore_1
    //   11125: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11128: ifeq +13 -> 11141
    //   11131: ldc_w 3454
    //   11134: iconst_2
    //   11135: ldc_w 3456
    //   11138: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11141: iconst_1
    //   11142: istore 19
    //   11144: goto -46 -> 11098
    //   11147: aload 32
    //   11149: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11152: ldc2_w 3457
    //   11155: lcmp
    //   11156: ifne +547 -> 11703
    //   11159: iconst_0
    //   11160: istore 19
    //   11162: aload_0
    //   11163: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11166: invokevirtual 392	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11169: ldc_w 3460
    //   11172: invokevirtual 3463	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11175: checkcast 3465	android/app/ActivityManager
    //   11178: iconst_1
    //   11179: invokevirtual 3469	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   11182: astore_1
    //   11183: aload_1
    //   11184: ifnull +6421 -> 17605
    //   11187: aload_1
    //   11188: invokeinterface 1649 1 0
    //   11193: iconst_1
    //   11194: if_icmplt +6411 -> 17605
    //   11197: aload_1
    //   11198: iconst_0
    //   11199: invokeinterface 2351 2 0
    //   11204: checkcast 3471	android/app/ActivityManager$RunningTaskInfo
    //   11207: getfield 3475	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   11210: invokevirtual 3480	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   11213: astore_1
    //   11214: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11217: ifeq +29 -> 11246
    //   11220: ldc 21
    //   11222: iconst_2
    //   11223: new 79	java/lang/StringBuilder
    //   11226: dup
    //   11227: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   11230: ldc_w 3482
    //   11233: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11236: aload_1
    //   11237: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11240: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11243: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11246: ldc_w 3484
    //   11249: aload_1
    //   11250: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11253: istore 20
    //   11255: iload 20
    //   11257: istore 19
    //   11259: aload_0
    //   11260: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11263: invokevirtual 392	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11266: ldc_w 3486
    //   11269: invokevirtual 3463	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11272: checkcast 3488	android/os/PowerManager
    //   11275: invokevirtual 3491	android/os/PowerManager:isScreenOn	()Z
    //   11278: istore 20
    //   11280: iload 20
    //   11282: ifeq +18 -> 11300
    //   11285: aload_0
    //   11286: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11289: getfield 3494	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   11292: ifeq -11263 -> 29
    //   11295: iload 19
    //   11297: ifne -11268 -> 29
    //   11300: new 3496	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody
    //   11303: dup
    //   11304: invokespecial 3497	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:<init>	()V
    //   11307: astore 30
    //   11309: aconst_null
    //   11310: astore_1
    //   11311: aconst_null
    //   11312: astore 28
    //   11314: aconst_null
    //   11315: astore 29
    //   11317: aload 30
    //   11319: aload 32
    //   11321: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11324: invokevirtual 3498	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11327: pop
    //   11328: aload 30
    //   11330: getfield 3501	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11333: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11336: ifeq +15 -> 11351
    //   11339: aload 30
    //   11341: getfield 3501	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11344: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11347: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11350: astore_1
    //   11351: aload 30
    //   11353: getfield 3504	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11356: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11359: ifeq +16 -> 11375
    //   11362: aload 30
    //   11364: getfield 3504	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11367: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11370: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11373: astore 28
    //   11375: aload 30
    //   11377: getfield 3507	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11380: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11383: ifeq +16 -> 11399
    //   11386: aload 30
    //   11388: getfield 3507	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11391: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11394: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11397: astore 29
    //   11399: aload_1
    //   11400: invokestatic 717	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11403: ifne -11374 -> 29
    //   11406: aload 28
    //   11408: invokestatic 717	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11411: ifne -11382 -> 29
    //   11414: aload 29
    //   11416: invokestatic 717	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11419: ifne -11390 -> 29
    //   11422: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11425: ifeq +51 -> 11476
    //   11428: ldc 21
    //   11430: iconst_2
    //   11431: new 79	java/lang/StringBuilder
    //   11434: dup
    //   11435: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   11438: ldc_w 3509
    //   11441: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11444: aload_1
    //   11445: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11448: ldc_w 3511
    //   11451: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11454: aload 28
    //   11456: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11459: ldc_w 3513
    //   11462: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11465: aload 29
    //   11467: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11470: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11473: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11476: new 364	android/content/Intent
    //   11479: dup
    //   11480: aload_0
    //   11481: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11484: invokevirtual 392	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11487: ldc_w 3515
    //   11490: invokespecial 3518	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11493: astore 30
    //   11495: aload 30
    //   11497: ldc_w 3519
    //   11500: aload 29
    //   11502: invokevirtual 516	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11505: pop
    //   11506: aload 30
    //   11508: ldc_w 3521
    //   11511: sipush 3001
    //   11514: invokevirtual 3524	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11517: pop
    //   11518: new 3526	com/tencent/qphone/base/remote/ToServiceMsg
    //   11521: dup
    //   11522: ldc_w 3528
    //   11525: aload_0
    //   11526: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11529: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11532: ldc_w 3530
    //   11535: invokespecial 3533	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11538: astore 29
    //   11540: aload 29
    //   11542: getfield 3537	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11545: ldc_w 3539
    //   11548: iconst_3
    //   11549: anewarray 69	java/lang/String
    //   11552: dup
    //   11553: iconst_0
    //   11554: aload 28
    //   11556: aastore
    //   11557: dup
    //   11558: iconst_1
    //   11559: aload_1
    //   11560: aastore
    //   11561: dup
    //   11562: iconst_2
    //   11563: aload 28
    //   11565: aastore
    //   11566: invokevirtual 3543	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11569: aload 29
    //   11571: getfield 3537	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11574: ldc_w 3545
    //   11577: aload 30
    //   11579: invokevirtual 3549	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11582: aload 29
    //   11584: getfield 3537	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11587: ldc_w 3551
    //   11590: aconst_null
    //   11591: invokevirtual 3549	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11594: aload_0
    //   11595: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11598: aload 29
    //   11600: invokevirtual 3555	com/tencent/mobileqq/app/QQAppInterface:sendToService	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   11603: aconst_null
    //   11604: ldc_w 3388
    //   11607: ldc 186
    //   11609: ldc 186
    //   11611: ldc_w 3557
    //   11614: ldc_w 3557
    //   11617: iconst_0
    //   11618: iconst_0
    //   11619: ldc 186
    //   11621: ldc 186
    //   11623: ldc 186
    //   11625: ldc 186
    //   11627: invokestatic 2226	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11630: aconst_null
    //   11631: areturn
    //   11632: astore_1
    //   11633: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11636: ifeq +12 -> 11648
    //   11639: ldc 21
    //   11641: iconst_2
    //   11642: ldc_w 3559
    //   11645: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11648: aload_1
    //   11649: invokevirtual 1392	java/lang/Exception:printStackTrace	()V
    //   11652: aconst_null
    //   11653: areturn
    //   11654: astore_1
    //   11655: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11658: ifeq +12 -> 11670
    //   11661: ldc 21
    //   11663: iconst_2
    //   11664: ldc_w 3561
    //   11667: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11670: aload_1
    //   11671: invokevirtual 1392	java/lang/Exception:printStackTrace	()V
    //   11674: goto -415 -> 11259
    //   11677: astore_1
    //   11678: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11681: ifeq +12 -> 11693
    //   11684: ldc 21
    //   11686: iconst_2
    //   11687: ldc_w 3563
    //   11690: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11693: aload_1
    //   11694: invokevirtual 1392	java/lang/Exception:printStackTrace	()V
    //   11697: iconst_1
    //   11698: istore 20
    //   11700: goto -420 -> 11280
    //   11703: aload 32
    //   11705: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11708: ldc2_w 3564
    //   11711: lcmp
    //   11712: ifne +28 -> 11740
    //   11715: aload 32
    //   11717: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11720: ifnull +20 -> 11740
    //   11723: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11726: ifeq -11697 -> 29
    //   11729: ldc 21
    //   11731: iconst_2
    //   11732: ldc_w 3567
    //   11735: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11738: aconst_null
    //   11739: areturn
    //   11740: aload 32
    //   11742: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11745: ldc2_w 3439
    //   11748: lcmp
    //   11749: ifne +87 -> 11836
    //   11752: new 3442	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   11755: dup
    //   11756: invokespecial 3443	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   11759: astore_1
    //   11760: aload_1
    //   11761: aload 32
    //   11763: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11766: invokevirtual 3444	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11769: pop
    //   11770: aload_1
    //   11771: getfield 3447	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11774: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11777: istore 4
    //   11779: iload 4
    //   11781: ifne +26 -> 11807
    //   11784: iconst_1
    //   11785: istore 19
    //   11787: aload_0
    //   11788: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11791: sipush 138
    //   11794: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11797: checkcast 3449	ylm
    //   11800: iload 19
    //   11802: invokevirtual 3452	ylm:Aj	(Z)V
    //   11805: aconst_null
    //   11806: areturn
    //   11807: iconst_0
    //   11808: istore 19
    //   11810: goto -23 -> 11787
    //   11813: astore_1
    //   11814: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11817: ifeq +13 -> 11830
    //   11820: ldc_w 3454
    //   11823: iconst_2
    //   11824: ldc_w 3456
    //   11827: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11830: iconst_1
    //   11831: istore 19
    //   11833: goto -46 -> 11787
    //   11836: aload 32
    //   11838: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11841: ldc2_w 3568
    //   11844: lcmp
    //   11845: ifne +99 -> 11944
    //   11848: new 3571	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody
    //   11851: dup
    //   11852: invokespecial 3572	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody:<init>	()V
    //   11855: astore_1
    //   11856: aload_1
    //   11857: aload 32
    //   11859: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11862: invokevirtual 3573	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11865: pop
    //   11866: aload_0
    //   11867: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11870: bipush 75
    //   11872: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   11875: checkcast 2027	atnf
    //   11878: astore 28
    //   11880: aload_0
    //   11881: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11884: bipush 115
    //   11886: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11889: checkcast 3575	atnk
    //   11892: astore 29
    //   11894: aload 28
    //   11896: aload_1
    //   11897: iconst_0
    //   11898: invokevirtual 3578	atnf:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody;Z)V
    //   11901: aconst_null
    //   11902: areturn
    //   11903: astore 28
    //   11905: ldc 21
    //   11907: iconst_1
    //   11908: new 79	java/lang/StringBuilder
    //   11911: dup
    //   11912: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   11915: ldc_w 3580
    //   11918: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11921: aload 28
    //   11923: invokevirtual 3581	java/lang/Exception:toString	()Ljava/lang/String;
    //   11926: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11929: ldc_w 3583
    //   11932: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11935: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11938: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11941: goto -75 -> 11866
    //   11944: aload 32
    //   11946: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11949: ldc2_w 3584
    //   11952: lcmp
    //   11953: ifne +130 -> 12083
    //   11956: new 3587	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody
    //   11959: dup
    //   11960: invokespecial 3588	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody:<init>	()V
    //   11963: astore_1
    //   11964: aload_1
    //   11965: aload 32
    //   11967: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11970: invokevirtual 3589	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11973: pop
    //   11974: aload_1
    //   11975: getfield 3592	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody:uint64_app_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   11978: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   11981: lstore_2
    //   11982: lload_2
    //   11983: ldc2_w 3593
    //   11986: lcmp
    //   11987: ifeq +11 -> 11998
    //   11990: lload_2
    //   11991: ldc2_w 3595
    //   11994: lcmp
    //   11995: ifne +60 -> 12055
    //   11998: aload_0
    //   11999: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12002: bipush 75
    //   12004: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   12007: checkcast 2027	atnf
    //   12010: aload_1
    //   12011: iconst_0
    //   12012: invokevirtual 3599	atnf:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody;Z)V
    //   12015: aconst_null
    //   12016: areturn
    //   12017: astore_1
    //   12018: ldc 21
    //   12020: iconst_1
    //   12021: new 79	java/lang/StringBuilder
    //   12024: dup
    //   12025: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   12028: ldc_w 3601
    //   12031: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12034: aload_1
    //   12035: invokevirtual 3581	java/lang/Exception:toString	()Ljava/lang/String;
    //   12038: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12041: ldc_w 3583
    //   12044: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12047: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12050: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12053: aconst_null
    //   12054: areturn
    //   12055: lload_2
    //   12056: ldc2_w 3602
    //   12059: lcmp
    //   12060: ifne -12031 -> 29
    //   12063: aload_0
    //   12064: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12067: sipush 181
    //   12070: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   12073: checkcast 3605	aunu
    //   12076: aload_1
    //   12077: iconst_0
    //   12078: invokevirtual 3606	aunu:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody;Z)V
    //   12081: aconst_null
    //   12082: areturn
    //   12083: aload 32
    //   12085: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12088: ldc2_w 3607
    //   12091: lcmp
    //   12092: ifne +75 -> 12167
    //   12095: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12098: ifeq +13 -> 12111
    //   12101: ldc_w 3610
    //   12104: iconst_2
    //   12105: ldc_w 3612
    //   12108: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12111: new 3614	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody
    //   12114: dup
    //   12115: invokespecial 3615	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:<init>	()V
    //   12118: astore_1
    //   12119: aload_1
    //   12120: aload 32
    //   12122: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12125: invokevirtual 3616	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12128: pop
    //   12129: aload_0
    //   12130: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12133: bipush 20
    //   12135: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   12138: checkcast 58	acms
    //   12141: aload_1
    //   12142: invokevirtual 3619	acms:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody;)V
    //   12145: aconst_null
    //   12146: areturn
    //   12147: astore_1
    //   12148: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12151: ifeq -12122 -> 29
    //   12154: ldc_w 3610
    //   12157: iconst_2
    //   12158: ldc_w 3621
    //   12161: aload_1
    //   12162: invokestatic 3623	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   12165: aconst_null
    //   12166: areturn
    //   12167: aload 32
    //   12169: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12172: ldc2_w 3624
    //   12175: lcmp
    //   12176: ifne +47 -> 12223
    //   12179: new 3627	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody
    //   12182: dup
    //   12183: invokespecial 3628	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:<init>	()V
    //   12186: astore_1
    //   12187: aload_1
    //   12188: aload 32
    //   12190: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12193: invokevirtual 3629	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12196: pop
    //   12197: aload_0
    //   12198: aload_1
    //   12199: invokevirtual 3632	tos:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody;)V
    //   12202: aconst_null
    //   12203: areturn
    //   12204: astore_1
    //   12205: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12208: ifeq -12179 -> 29
    //   12211: ldc_w 3634
    //   12214: iconst_2
    //   12215: ldc_w 3636
    //   12218: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12221: aconst_null
    //   12222: areturn
    //   12223: aload 32
    //   12225: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12228: ldc2_w 3637
    //   12231: lcmp
    //   12232: ifne +78 -> 12310
    //   12235: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12238: ifeq +13 -> 12251
    //   12241: ldc_w 3640
    //   12244: iconst_2
    //   12245: ldc_w 3642
    //   12248: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12251: new 3644	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody
    //   12254: dup
    //   12255: invokespecial 3645	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:<init>	()V
    //   12258: astore_1
    //   12259: aload_1
    //   12260: aload 32
    //   12262: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12265: invokevirtual 3646	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12268: pop
    //   12269: aload_0
    //   12270: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12273: sipush 156
    //   12276: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12279: checkcast 3648	ahvn
    //   12282: aload_1
    //   12283: iconst_0
    //   12284: invokevirtual 3651	ahvn:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody;Z)V
    //   12287: aconst_null
    //   12288: areturn
    //   12289: astore 28
    //   12291: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12294: ifeq -25 -> 12269
    //   12297: ldc_w 3640
    //   12300: iconst_2
    //   12301: ldc_w 3653
    //   12304: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12307: goto -38 -> 12269
    //   12310: aload 32
    //   12312: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12315: ldc2_w 3654
    //   12318: lcmp
    //   12319: ifne +697 -> 13016
    //   12322: new 3657	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody
    //   12325: dup
    //   12326: invokespecial 3658	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:<init>	()V
    //   12329: astore 28
    //   12331: aload 28
    //   12333: aload 32
    //   12335: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12338: invokevirtual 3659	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12341: pop
    //   12342: aload 28
    //   12344: getfield 3660	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12347: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12350: ifeq +578 -> 12928
    //   12353: aload 28
    //   12355: getfield 3660	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12358: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12361: iconst_2
    //   12362: if_icmpne +566 -> 12928
    //   12365: aload 28
    //   12367: getfield 3664	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12370: getfield 3670	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:fixed32_timestamp	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   12373: invokevirtual 3673	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   12376: i2l
    //   12377: lstore_2
    //   12378: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12381: ifeq +29 -> 12410
    //   12384: ldc 21
    //   12386: iconst_2
    //   12387: new 79	java/lang/StringBuilder
    //   12390: dup
    //   12391: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   12394: ldc_w 3675
    //   12397: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12400: lload_2
    //   12401: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12404: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12407: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12410: aload 28
    //   12412: getfield 3664	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12415: getfield 3678	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:rpt_msg_friend_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   12418: invokevirtual 120	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   12421: astore 30
    //   12423: aload 30
    //   12425: ifnull +542 -> 12967
    //   12428: aload 30
    //   12430: invokeinterface 1649 1 0
    //   12435: ifle +532 -> 12967
    //   12438: new 699	java/util/ArrayList
    //   12441: dup
    //   12442: aload 30
    //   12444: invokeinterface 1649 1 0
    //   12449: invokespecial 3679	java/util/ArrayList:<init>	(I)V
    //   12452: astore 29
    //   12454: aload 30
    //   12456: invokeinterface 126 1 0
    //   12461: astore 30
    //   12463: aload 30
    //   12465: invokeinterface 131 1 0
    //   12470: ifeq +497 -> 12967
    //   12473: aload 30
    //   12475: invokeinterface 135 1 0
    //   12480: checkcast 3681	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow
    //   12483: astore 31
    //   12485: new 3683	com/tencent/mobileqq/data/PushRecommend
    //   12488: dup
    //   12489: invokespecial 3684	com/tencent/mobileqq/data/PushRecommend:<init>	()V
    //   12492: astore 32
    //   12494: aload 31
    //   12496: getfield 3685	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12499: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   12502: ifeq +19 -> 12521
    //   12505: aload 32
    //   12507: aload 31
    //   12509: getfield 3685	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12512: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   12515: invokestatic 169	java/lang/Long:toString	(J)Ljava/lang/String;
    //   12518: putfield 3686	com/tencent/mobileqq/data/PushRecommend:uin	Ljava/lang/String;
    //   12521: aload 31
    //   12523: getfield 3689	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12526: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12529: ifeq +26 -> 12555
    //   12532: aload 32
    //   12534: new 69	java/lang/String
    //   12537: dup
    //   12538: aload 31
    //   12540: getfield 3689	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12543: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12546: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12549: invokespecial 1371	java/lang/String:<init>	([B)V
    //   12552: putfield 3692	com/tencent/mobileqq/data/PushRecommend:nick	Ljava/lang/String;
    //   12555: aload 31
    //   12557: getfield 3693	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12560: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12563: ifeq +17 -> 12580
    //   12566: aload 32
    //   12568: aload 31
    //   12570: getfield 3693	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12573: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12576: i2s
    //   12577: putfield 3695	com/tencent/mobileqq/data/PushRecommend:age	S
    //   12580: aload 31
    //   12582: getfield 3698	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12585: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12588: ifeq +17 -> 12605
    //   12591: aload 32
    //   12593: aload 31
    //   12595: getfield 3698	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12598: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12601: i2s
    //   12602: putfield 3700	com/tencent/mobileqq/data/PushRecommend:gender	S
    //   12605: aload 31
    //   12607: getfield 3703	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12610: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12613: ifeq +26 -> 12639
    //   12616: aload 32
    //   12618: new 69	java/lang/String
    //   12621: dup
    //   12622: aload 31
    //   12624: getfield 3703	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12627: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12630: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12633: invokespecial 1371	java/lang/String:<init>	([B)V
    //   12636: putfield 3706	com/tencent/mobileqq/data/PushRecommend:recommendReason	Ljava/lang/String;
    //   12639: aload 31
    //   12641: getfield 3709	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12644: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12647: ifeq +19 -> 12666
    //   12650: aload 32
    //   12652: aload 31
    //   12654: getfield 3709	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12657: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12660: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12663: putfield 3712	com/tencent/mobileqq/data/PushRecommend:algBuffer	[B
    //   12666: aload 31
    //   12668: getfield 3715	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12671: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12674: ifeq +26 -> 12700
    //   12677: aload 32
    //   12679: new 69	java/lang/String
    //   12682: dup
    //   12683: aload 31
    //   12685: getfield 3715	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12688: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12691: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12694: invokespecial 1371	java/lang/String:<init>	([B)V
    //   12697: putfield 3718	com/tencent/mobileqq/data/PushRecommend:sourceReason	Ljava/lang/String;
    //   12700: aload 31
    //   12702: getfield 3721	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12705: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12708: ifeq +16 -> 12724
    //   12711: aload 32
    //   12713: aload 31
    //   12715: getfield 3721	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12718: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12721: putfield 3724	com/tencent/mobileqq/data/PushRecommend:fromSource	I
    //   12724: aload 31
    //   12726: getfield 3728	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12729: invokevirtual 3731	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:has	()Z
    //   12732: ifeq +69 -> 12801
    //   12735: aload 31
    //   12737: getfield 3728	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12740: invokevirtual 3732	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12743: checkcast 3730	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource
    //   12746: astore 33
    //   12748: aload 33
    //   12750: ifnull +51 -> 12801
    //   12753: aload 33
    //   12755: getfield 3733	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12758: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12761: ifeq +16 -> 12777
    //   12764: aload 32
    //   12766: aload 33
    //   12768: getfield 3733	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12771: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12774: putfield 3736	com/tencent/mobileqq/data/PushRecommend:sourceId	I
    //   12777: aload 33
    //   12779: getfield 3739	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12782: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12785: ifeq +16 -> 12801
    //   12788: aload 32
    //   12790: aload 33
    //   12792: getfield 3739	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12795: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12798: putfield 3742	com/tencent/mobileqq/data/PushRecommend:subSourceId	I
    //   12801: aload 31
    //   12803: getfield 3745	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12806: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12809: ifeq +26 -> 12835
    //   12812: aload 32
    //   12814: new 69	java/lang/String
    //   12817: dup
    //   12818: aload 31
    //   12820: getfield 3745	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12823: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12826: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12829: invokespecial 1371	java/lang/String:<init>	([B)V
    //   12832: putfield 3748	com/tencent/mobileqq/data/PushRecommend:wzryVerifyStr	Ljava/lang/String;
    //   12835: aload 31
    //   12837: getfield 3751	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12840: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12843: ifeq +16 -> 12859
    //   12846: aload 32
    //   12848: aload 31
    //   12850: getfield 3751	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12853: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12856: putfield 3754	com/tencent/mobileqq/data/PushRecommend:wzrySourceId	I
    //   12859: aload 31
    //   12861: getfield 3757	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12864: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12867: ifeq +26 -> 12893
    //   12870: aload 32
    //   12872: new 69	java/lang/String
    //   12875: dup
    //   12876: aload 31
    //   12878: getfield 3757	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12881: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12884: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12887: invokespecial 1371	java/lang/String:<init>	([B)V
    //   12890: putfield 3760	com/tencent/mobileqq/data/PushRecommend:wzryGameNick	Ljava/lang/String;
    //   12893: aload 32
    //   12895: lload_2
    //   12896: putfield 3761	com/tencent/mobileqq/data/PushRecommend:timestamp	J
    //   12899: aload 29
    //   12901: aload 32
    //   12903: invokevirtual 701	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   12906: pop
    //   12907: goto -444 -> 12463
    //   12910: astore 28
    //   12912: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12915: ifeq +13 -> 12928
    //   12918: ldc_w 3634
    //   12921: iconst_2
    //   12922: ldc_w 3763
    //   12925: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12928: aload_1
    //   12929: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   12932: lstore_2
    //   12933: aload_1
    //   12934: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   12937: istore 4
    //   12939: aload_1
    //   12940: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   12943: lstore 15
    //   12945: aload_1
    //   12946: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   12949: istore 5
    //   12951: aload_0
    //   12952: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   12955: lload_2
    //   12956: iload 4
    //   12958: lload 15
    //   12960: iload 5
    //   12962: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   12965: aconst_null
    //   12966: areturn
    //   12967: aload 28
    //   12969: getfield 3664	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12972: getfield 3764	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12975: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12978: ifeq -50 -> 12928
    //   12981: aload 28
    //   12983: getfield 3664	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12986: getfield 3764	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12989: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12992: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   12995: astore 28
    //   12997: aload_0
    //   12998: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13001: aload_0
    //   13002: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13005: invokevirtual 720	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   13008: aload 28
    //   13010: invokestatic 3770	com/tencent/mobileqq/data/KplRoleInfo:saveGameNickWithUin	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   13013: goto -85 -> 12928
    //   13016: aload 32
    //   13018: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13021: ldc2_w 3771
    //   13024: lcmp
    //   13025: ifne +172 -> 13197
    //   13028: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13031: ifeq +13 -> 13044
    //   13034: ldc_w 3774
    //   13037: iconst_2
    //   13038: ldc_w 3776
    //   13041: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13044: new 3778	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody
    //   13047: dup
    //   13048: invokespecial 3779	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:<init>	()V
    //   13051: astore_1
    //   13052: aload_1
    //   13053: aload 32
    //   13055: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13058: invokevirtual 3780	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13061: pop
    //   13062: aload_1
    //   13063: getfield 3781	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   13066: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   13069: istore 4
    //   13071: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13074: ifeq +28 -> 13102
    //   13077: ldc_w 3774
    //   13080: iconst_2
    //   13081: iconst_2
    //   13082: anewarray 261	java/lang/Object
    //   13085: dup
    //   13086: iconst_0
    //   13087: ldc_w 3783
    //   13090: aastore
    //   13091: dup
    //   13092: iconst_1
    //   13093: iload 4
    //   13095: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13098: aastore
    //   13099: invokestatic 736	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   13102: iload 4
    //   13104: iconst_1
    //   13105: if_icmpne -13076 -> 29
    //   13108: aload_1
    //   13109: getfield 3787	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:msg_body_type	Ltencent/im/oidb/olympic/submsgtype0xb4$BodyType;
    //   13112: astore_1
    //   13113: aload_1
    //   13114: getfield 3793	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   13117: invokevirtual 3796	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:has	()Z
    //   13120: ifeq +59 -> 13179
    //   13123: aload_0
    //   13124: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13127: bipush 94
    //   13129: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   13132: checkcast 3798	akps
    //   13135: astore 28
    //   13137: aload 28
    //   13139: ifnull -13110 -> 29
    //   13142: aload 28
    //   13144: aload_1
    //   13145: getfield 3793	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   13148: invokevirtual 3799	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13151: checkcast 3795	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo
    //   13154: invokevirtual 3802	akps:a	(Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;)V
    //   13157: aconst_null
    //   13158: areturn
    //   13159: astore_1
    //   13160: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13163: ifeq -13134 -> 29
    //   13166: ldc_w 3774
    //   13169: iconst_2
    //   13170: ldc_w 3804
    //   13173: aload_1
    //   13174: invokestatic 2705	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13177: aconst_null
    //   13178: areturn
    //   13179: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13182: ifeq -13153 -> 29
    //   13185: ldc_w 3774
    //   13188: iconst_2
    //   13189: ldc_w 3806
    //   13192: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13195: aconst_null
    //   13196: areturn
    //   13197: aload 32
    //   13199: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13202: ldc2_w 3807
    //   13205: lcmp
    //   13206: ifne +18 -> 13224
    //   13209: aload_0
    //   13210: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13213: aload 32
    //   13215: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13218: iconst_1
    //   13219: invokestatic 3813	andb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BZ)V
    //   13222: aconst_null
    //   13223: areturn
    //   13224: aload 32
    //   13226: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13229: ldc2_w 3814
    //   13232: lcmp
    //   13233: ifne +70 -> 13303
    //   13236: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13239: ifeq +13 -> 13252
    //   13242: ldc_w 3817
    //   13245: iconst_2
    //   13246: ldc_w 3819
    //   13249: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13252: new 3821	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody
    //   13255: dup
    //   13256: invokespecial 3822	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:<init>	()V
    //   13259: astore_1
    //   13260: aload_1
    //   13261: aload 32
    //   13263: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13266: invokevirtual 3823	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13269: pop
    //   13270: aload_0
    //   13271: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13274: invokevirtual 1723	com/tencent/mobileqq/app/QQAppInterface:a	()Lacjq;
    //   13277: aload_1
    //   13278: invokevirtual 3826	acjq:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody;)V
    //   13281: aconst_null
    //   13282: areturn
    //   13283: astore_1
    //   13284: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13287: ifeq -13258 -> 29
    //   13290: ldc_w 3817
    //   13293: iconst_2
    //   13294: ldc_w 3828
    //   13297: aload_1
    //   13298: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13301: aconst_null
    //   13302: areturn
    //   13303: aload 32
    //   13305: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13308: ldc2_w 3829
    //   13311: lcmp
    //   13312: ifne +166 -> 13478
    //   13315: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13318: ifeq +13 -> 13331
    //   13321: ldc_w 3832
    //   13324: iconst_2
    //   13325: ldc_w 3834
    //   13328: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13331: new 3836	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody
    //   13334: dup
    //   13335: invokespecial 3837	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:<init>	()V
    //   13338: astore_1
    //   13339: aload_1
    //   13340: aload 32
    //   13342: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13345: invokevirtual 3838	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13348: pop
    //   13349: aload_0
    //   13350: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13353: invokevirtual 1723	com/tencent/mobileqq/app/QQAppInterface:a	()Lacjq;
    //   13356: aload_1
    //   13357: invokevirtual 3841	acjq:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody;)V
    //   13360: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13363: ifeq -13334 -> 29
    //   13366: aload_1
    //   13367: getfield 3844	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:bytes_business	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   13370: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   13373: invokevirtual 271	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   13376: astore_1
    //   13377: ldc_w 3832
    //   13380: iconst_2
    //   13381: new 79	java/lang/StringBuilder
    //   13384: dup
    //   13385: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   13388: ldc_w 3846
    //   13391: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13394: aload_1
    //   13395: arraylength
    //   13396: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13399: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13402: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13405: ldc_w 3832
    //   13408: iconst_2
    //   13409: new 79	java/lang/StringBuilder
    //   13412: dup
    //   13413: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   13416: ldc_w 3848
    //   13419: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13422: aload_1
    //   13423: arraylength
    //   13424: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13427: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13430: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13433: aconst_null
    //   13434: areturn
    //   13435: astore_1
    //   13436: aload_1
    //   13437: invokevirtual 1392	java/lang/Exception:printStackTrace	()V
    //   13440: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13443: ifeq -13414 -> 29
    //   13446: ldc_w 3832
    //   13449: iconst_2
    //   13450: new 79	java/lang/StringBuilder
    //   13453: dup
    //   13454: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   13457: ldc_w 3850
    //   13460: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13463: aload_1
    //   13464: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13467: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13470: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13473: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13476: aconst_null
    //   13477: areturn
    //   13478: aload 32
    //   13480: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13483: ldc2_w 3854
    //   13486: lcmp
    //   13487: ifne +101 -> 13588
    //   13490: aload 32
    //   13492: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13495: ifnull +93 -> 13588
    //   13498: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13501: ifeq +13 -> 13514
    //   13504: ldc_w 3857
    //   13507: iconst_2
    //   13508: ldc_w 3859
    //   13511: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13514: aload_1
    //   13515: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   13518: lstore_2
    //   13519: aload_1
    //   13520: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13523: istore 4
    //   13525: aload_1
    //   13526: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13529: lstore 15
    //   13531: aload_1
    //   13532: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   13535: istore 5
    //   13537: aload_1
    //   13538: getfield 1275	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13541: istore 6
    //   13543: new 3861	acrj
    //   13546: dup
    //   13547: lload_2
    //   13548: iload 4
    //   13550: i2l
    //   13551: lload 15
    //   13553: iload 5
    //   13555: iload 6
    //   13557: iconst_1
    //   13558: invokespecial 3864	acrj:<init>	(JJJIIZ)V
    //   13561: astore_1
    //   13562: aload_0
    //   13563: aload 32
    //   13565: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13568: aload_1
    //   13569: invokevirtual 3867	tos:a	([BLacrj;)V
    //   13572: aload_0
    //   13573: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13576: lload_2
    //   13577: iload 4
    //   13579: lload 15
    //   13581: iload 5
    //   13583: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13586: aconst_null
    //   13587: areturn
    //   13588: aload 32
    //   13590: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13593: ldc2_w 3868
    //   13596: lcmp
    //   13597: ifne +19 -> 13616
    //   13600: aload_0
    //   13601: aload 32
    //   13603: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13606: aload_1
    //   13607: getfield 1275	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13610: i2l
    //   13611: invokevirtual 3872	tos:h	([BJ)V
    //   13614: aconst_null
    //   13615: areturn
    //   13616: aload 32
    //   13618: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13621: ldc2_w 3873
    //   13624: lcmp
    //   13625: ifne +28 -> 13653
    //   13628: aload_0
    //   13629: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13632: aload_1
    //   13633: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   13636: aload_1
    //   13637: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13640: aload_1
    //   13641: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13644: aload_1
    //   13645: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   13648: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13651: aconst_null
    //   13652: areturn
    //   13653: aload 32
    //   13655: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13658: ldc2_w 3875
    //   13661: lcmp
    //   13662: ifne +19 -> 13681
    //   13665: aload_0
    //   13666: aload 32
    //   13668: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13671: aload_1
    //   13672: getfield 1275	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13675: i2l
    //   13676: invokevirtual 3878	tos:i	([BJ)V
    //   13679: aconst_null
    //   13680: areturn
    //   13681: aload 32
    //   13683: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13686: ldc2_w 3879
    //   13689: lcmp
    //   13690: ifne +28 -> 13718
    //   13693: aload_0
    //   13694: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13697: aload_1
    //   13698: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   13701: aload_1
    //   13702: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13705: aload_1
    //   13706: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13709: aload_1
    //   13710: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   13713: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13716: aconst_null
    //   13717: areturn
    //   13718: aload 32
    //   13720: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13723: ldc2_w 3881
    //   13726: lcmp
    //   13727: ifne +28 -> 13755
    //   13730: aload_0
    //   13731: getfield 1561	tos:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13734: aload_1
    //   13735: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   13738: aload_1
    //   13739: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13742: aload_1
    //   13743: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13746: aload_1
    //   13747: getfield 1227	OnlinePushPack/MsgInfo:shMsgType	S
    //   13750: invokestatic 2137	anbh:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13753: aconst_null
    //   13754: areturn
    //   13755: aload 32
    //   13757: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13760: ldc2_w 3883
    //   13763: lcmp
    //   13764: ifne +70 -> 13834
    //   13767: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13770: ifeq +13 -> 13783
    //   13773: ldc_w 3886
    //   13776: iconst_2
    //   13777: ldc_w 3888
    //   13780: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13783: aload_0
    //   13784: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13787: bipush 34
    //   13789: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   13792: checkcast 3890	acll
    //   13795: astore_1
    //   13796: aload_1
    //   13797: ifnull +19 -> 13816
    //   13800: aload_1
    //   13801: aload 32
    //   13803: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13806: aload 32
    //   13808: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13811: invokevirtual 3891	acll:j	(J[B)V
    //   13814: aconst_null
    //   13815: areturn
    //   13816: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13819: ifeq -13790 -> 29
    //   13822: ldc_w 3886
    //   13825: iconst_2
    //   13826: ldc_w 3893
    //   13829: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13832: aconst_null
    //   13833: areturn
    //   13834: aload 32
    //   13836: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13839: ldc2_w 3894
    //   13842: lcmp
    //   13843: ifne +15 -> 13858
    //   13846: aload_0
    //   13847: aload 32
    //   13849: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13852: aload_1
    //   13853: invokevirtual 3898	tos:a	([BLOnlinePushPack/MsgInfo;)V
    //   13856: aconst_null
    //   13857: areturn
    //   13858: aload 32
    //   13860: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13863: ldc2_w 3899
    //   13866: lcmp
    //   13867: ifne +25 -> 13892
    //   13870: aload_0
    //   13871: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13874: bipush 98
    //   13876: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   13879: checkcast 3902	pma
    //   13882: aload 32
    //   13884: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13887: invokevirtual 3905	pma:P	([B)V
    //   13890: aconst_null
    //   13891: areturn
    //   13892: aload 32
    //   13894: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13897: ldc2_w 3906
    //   13900: lcmp
    //   13901: ifne +70 -> 13971
    //   13904: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13907: ifeq +13 -> 13920
    //   13910: ldc_w 3817
    //   13913: iconst_2
    //   13914: ldc_w 3909
    //   13917: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13920: new 3911	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody
    //   13923: dup
    //   13924: invokespecial 3912	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:<init>	()V
    //   13927: astore_1
    //   13928: aload_1
    //   13929: aload 32
    //   13931: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13934: invokevirtual 3913	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13937: pop
    //   13938: aload_0
    //   13939: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13942: invokevirtual 1723	com/tencent/mobileqq/app/QQAppInterface:a	()Lacjq;
    //   13945: aload_1
    //   13946: invokevirtual 3916	acjq:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody;)V
    //   13949: aconst_null
    //   13950: areturn
    //   13951: astore_1
    //   13952: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13955: ifeq -13926 -> 29
    //   13958: ldc_w 3817
    //   13961: iconst_2
    //   13962: ldc_w 3918
    //   13965: aload_1
    //   13966: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13969: aconst_null
    //   13970: areturn
    //   13971: aload 32
    //   13973: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13976: ldc2_w 3919
    //   13979: lcmp
    //   13980: ifne +25 -> 14005
    //   13983: aload_0
    //   13984: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13987: bipush 98
    //   13989: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   13992: checkcast 3902	pma
    //   13995: aload 32
    //   13997: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14000: invokevirtual 3923	pma:Q	([B)V
    //   14003: aconst_null
    //   14004: areturn
    //   14005: aload 32
    //   14007: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14010: ldc2_w 3924
    //   14013: lcmp
    //   14014: ifne +25 -> 14039
    //   14017: aload_0
    //   14018: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14021: bipush 98
    //   14023: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   14026: checkcast 3902	pma
    //   14029: aload 32
    //   14031: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14034: invokevirtual 3928	pma:R	([B)V
    //   14037: aconst_null
    //   14038: areturn
    //   14039: aload 32
    //   14041: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14044: ldc2_w 3929
    //   14047: lcmp
    //   14048: ifne +41 -> 14089
    //   14051: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14054: ifeq +12 -> 14066
    //   14057: ldc 21
    //   14059: iconst_2
    //   14060: ldc_w 3932
    //   14063: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14066: aload_0
    //   14067: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14070: sipush 202
    //   14073: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14076: checkcast 3934	com/tencent/mobileqq/data/MsgBoxInterFollowManager
    //   14079: aload 32
    //   14081: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14084: invokevirtual 3937	com/tencent/mobileqq/data/MsgBoxInterFollowManager:decode0xd7InteractAndFollowMsg	([B)V
    //   14087: aconst_null
    //   14088: areturn
    //   14089: aload 32
    //   14091: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14094: ldc2_w 3938
    //   14097: lcmp
    //   14098: ifne +41 -> 14139
    //   14101: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14104: ifeq +12 -> 14116
    //   14107: ldc 21
    //   14109: iconst_2
    //   14110: ldc_w 3941
    //   14113: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14116: aload_0
    //   14117: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14120: sipush 202
    //   14123: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14126: checkcast 3934	com/tencent/mobileqq/data/MsgBoxInterFollowManager
    //   14129: aload 32
    //   14131: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14134: invokevirtual 3944	com/tencent/mobileqq/data/MsgBoxInterFollowManager:decode0xfeInteractAndFollowMsg	([B)V
    //   14137: aconst_null
    //   14138: areturn
    //   14139: aload 32
    //   14141: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14144: ldc2_w 3945
    //   14147: lcmp
    //   14148: ifne +25 -> 14173
    //   14151: aload_0
    //   14152: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14155: bipush 107
    //   14157: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   14160: checkcast 3948	ardq
    //   14163: aload 32
    //   14165: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14168: invokevirtual 3951	ardq:bF	([B)V
    //   14171: aconst_null
    //   14172: areturn
    //   14173: aload 32
    //   14175: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14178: ldc2_w 3952
    //   14181: lcmp
    //   14182: ifne +70 -> 14252
    //   14185: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14188: ifeq +13 -> 14201
    //   14191: ldc_w 3955
    //   14194: iconst_2
    //   14195: ldc_w 3957
    //   14198: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14201: new 3959	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody
    //   14204: dup
    //   14205: invokespecial 3960	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:<init>	()V
    //   14208: astore_1
    //   14209: aload_1
    //   14210: aload 32
    //   14212: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14215: invokevirtual 3961	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14218: pop
    //   14219: aload_0
    //   14220: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14223: invokevirtual 1723	com/tencent/mobileqq/app/QQAppInterface:a	()Lacjq;
    //   14226: aload_1
    //   14227: invokevirtual 3964	acjq:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody;)V
    //   14230: aconst_null
    //   14231: areturn
    //   14232: astore_1
    //   14233: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14236: ifeq -14207 -> 29
    //   14239: ldc_w 3955
    //   14242: iconst_2
    //   14243: ldc_w 3966
    //   14246: aload_1
    //   14247: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14250: aconst_null
    //   14251: areturn
    //   14252: aload 32
    //   14254: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14257: ldc2_w 3967
    //   14260: lcmp
    //   14261: ifne +20 -> 14281
    //   14264: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14267: ifeq -14238 -> 29
    //   14270: ldc 21
    //   14272: iconst_2
    //   14273: ldc_w 3970
    //   14276: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14279: aconst_null
    //   14280: areturn
    //   14281: aload 32
    //   14283: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14286: ldc2_w 3971
    //   14289: lcmp
    //   14290: ifne +20 -> 14310
    //   14293: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14296: ifeq -14267 -> 29
    //   14299: ldc 21
    //   14301: iconst_2
    //   14302: ldc_w 3974
    //   14305: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14308: aconst_null
    //   14309: areturn
    //   14310: aload 32
    //   14312: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14315: ldc2_w 3975
    //   14318: lcmp
    //   14319: ifne +219 -> 14538
    //   14322: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14325: ifeq +13 -> 14338
    //   14328: ldc_w 3978
    //   14331: iconst_2
    //   14332: ldc_w 3980
    //   14335: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14338: new 3982	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody
    //   14341: dup
    //   14342: invokespecial 3983	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:<init>	()V
    //   14345: astore_1
    //   14346: aload_1
    //   14347: aload 32
    //   14349: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14352: invokevirtual 3984	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14355: pop
    //   14356: aload_1
    //   14357: getfield 3988	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14360: invokevirtual 3991	tencent/im/apollo_game_status$STCMGameMessage:has	()Z
    //   14363: ifeq -14334 -> 29
    //   14366: aload_1
    //   14367: getfield 3988	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14370: invokevirtual 3992	tencent/im/apollo_game_status$STCMGameMessage:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14373: checkcast 3990	tencent/im/apollo_game_status$STCMGameMessage
    //   14376: astore_1
    //   14377: aload_1
    //   14378: getfield 3996	tencent/im/apollo_game_status$STCMGameMessage:msg_comm	Ltencent/im/apollo_game_status$STCMGameMessage$STMsgComm;
    //   14381: invokevirtual 3999	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14384: checkcast 3998	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm
    //   14387: astore 29
    //   14389: aload 29
    //   14391: getfield 4002	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:uint32_session_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   14394: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   14397: invokestatic 4005	aqft:K	(I)J
    //   14400: lstore 15
    //   14402: aload_0
    //   14403: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14406: sipush 211
    //   14409: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14412: checkcast 4007	abhe
    //   14415: astore 28
    //   14417: lload_2
    //   14418: lload 15
    //   14420: lcmp
    //   14421: ifne +102 -> 14523
    //   14424: aload 29
    //   14426: getfield 4010	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:rpt_uint32_session_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   14429: invokevirtual 1647	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   14432: astore 29
    //   14434: aload 29
    //   14436: ifnull -14407 -> 29
    //   14439: aload 29
    //   14441: invokeinterface 1649 1 0
    //   14446: ifle -14417 -> 29
    //   14449: aload 29
    //   14451: invokeinterface 126 1 0
    //   14456: astore 29
    //   14458: aload 29
    //   14460: invokeinterface 131 1 0
    //   14465: ifeq -14436 -> 29
    //   14468: aload 29
    //   14470: invokeinterface 135 1 0
    //   14475: checkcast 293	java/lang/Integer
    //   14478: invokevirtual 1660	java/lang/Integer:intValue	()I
    //   14481: invokestatic 4005	aqft:K	(I)J
    //   14484: lstore 15
    //   14486: lload 15
    //   14488: lload_2
    //   14489: lcmp
    //   14490: ifeq -32 -> 14458
    //   14493: aload 28
    //   14495: iconst_0
    //   14496: iconst_0
    //   14497: lload 15
    //   14499: invokestatic 169	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14502: aload_1
    //   14503: invokevirtual 4013	abhe:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14506: goto -48 -> 14458
    //   14509: astore_1
    //   14510: ldc_w 3978
    //   14513: iconst_1
    //   14514: ldc_w 4015
    //   14517: aload_1
    //   14518: invokestatic 1832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14521: aconst_null
    //   14522: areturn
    //   14523: aload 28
    //   14525: iconst_0
    //   14526: iconst_0
    //   14527: lload 15
    //   14529: invokestatic 169	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14532: aload_1
    //   14533: invokevirtual 4013	abhe:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14536: aconst_null
    //   14537: areturn
    //   14538: aload 32
    //   14540: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14543: ldc2_w 4016
    //   14546: lcmp
    //   14547: ifne +138 -> 14685
    //   14550: ldc_w 4019
    //   14553: iconst_1
    //   14554: ldc_w 4021
    //   14557: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14560: new 4023	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody
    //   14563: dup
    //   14564: invokespecial 4024	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:<init>	()V
    //   14567: astore_1
    //   14568: aload_1
    //   14569: aload 32
    //   14571: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14574: invokevirtual 4025	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14577: pop
    //   14578: aload_1
    //   14579: getfield 4029	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14582: invokevirtual 4032	tencent/im/apollo_push_msgInfo$STPushMsgElem:has	()Z
    //   14585: ifeq -14556 -> 29
    //   14588: aload_1
    //   14589: getfield 4029	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14592: invokevirtual 4033	tencent/im/apollo_push_msgInfo$STPushMsgElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14595: checkcast 4031	tencent/im/apollo_push_msgInfo$STPushMsgElem
    //   14598: astore_1
    //   14599: aload_0
    //   14600: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14603: ifnull -14574 -> 29
    //   14606: aload_0
    //   14607: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14610: sipush 227
    //   14613: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14616: checkcast 4035	abht
    //   14619: astore 28
    //   14621: aload 28
    //   14623: iconst_0
    //   14624: aload_1
    //   14625: invokevirtual 4038	abht:a	(ILtencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14628: aload 28
    //   14630: aload_1
    //   14631: invokevirtual 4041	abht:c	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14634: aload 28
    //   14636: aload_1
    //   14637: invokevirtual 4043	abht:b	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14640: aload 28
    //   14642: aload_1
    //   14643: invokevirtual 4045	abht:a	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14646: aconst_null
    //   14647: areturn
    //   14648: astore_1
    //   14649: aload_1
    //   14650: invokevirtual 1392	java/lang/Exception:printStackTrace	()V
    //   14653: ldc_w 4019
    //   14656: iconst_1
    //   14657: new 79	java/lang/StringBuilder
    //   14660: dup
    //   14661: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   14664: ldc_w 4047
    //   14667: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14670: aload_1
    //   14671: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14674: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14677: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14680: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14683: aconst_null
    //   14684: areturn
    //   14685: aload 32
    //   14687: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14690: ldc2_w 4048
    //   14693: lcmp
    //   14694: ifne +86 -> 14780
    //   14697: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14700: ifeq +12 -> 14712
    //   14703: ldc 21
    //   14705: iconst_2
    //   14706: ldc_w 4051
    //   14709: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14712: new 4053	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody
    //   14715: dup
    //   14716: invokespecial 4054	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:<init>	()V
    //   14719: astore_1
    //   14720: aload 32
    //   14722: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14725: ifnull +13 -> 14738
    //   14728: aload_1
    //   14729: aload 32
    //   14731: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14734: invokevirtual 4055	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14737: pop
    //   14738: aload_0
    //   14739: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14742: aload_1
    //   14743: invokestatic 4058	acof:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody;)V
    //   14746: aconst_null
    //   14747: areturn
    //   14748: astore_1
    //   14749: ldc 21
    //   14751: iconst_1
    //   14752: new 79	java/lang/StringBuilder
    //   14755: dup
    //   14756: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   14759: ldc_w 4060
    //   14762: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14765: aload_1
    //   14766: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14769: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14772: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14775: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14778: aconst_null
    //   14779: areturn
    //   14780: aload 32
    //   14782: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14785: ldc2_w 4061
    //   14788: lcmp
    //   14789: ifne +192 -> 14981
    //   14792: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14795: ifeq +12 -> 14807
    //   14798: ldc 21
    //   14800: iconst_2
    //   14801: ldc_w 4064
    //   14804: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14807: aload 32
    //   14809: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14812: arraylength
    //   14813: istore 4
    //   14815: iload 4
    //   14817: bipush 6
    //   14819: if_icmpge +32 -> 14851
    //   14822: ldc 21
    //   14824: iconst_2
    //   14825: new 79	java/lang/StringBuilder
    //   14828: dup
    //   14829: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   14832: ldc_w 4066
    //   14835: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14838: iload 4
    //   14840: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14843: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14846: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14849: aconst_null
    //   14850: areturn
    //   14851: aload 32
    //   14853: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14856: iconst_0
    //   14857: baload
    //   14858: iconst_4
    //   14859: ishl
    //   14860: aload 32
    //   14862: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14865: iconst_1
    //   14866: baload
    //   14867: iadd
    //   14868: istore 5
    //   14870: iconst_4
    //   14871: newarray byte
    //   14873: astore_1
    //   14874: aload 32
    //   14876: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14879: iconst_2
    //   14880: aload_1
    //   14881: iconst_0
    //   14882: iconst_4
    //   14883: invokestatic 4070	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14886: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14889: ifeq +30 -> 14919
    //   14892: ldc 21
    //   14894: iconst_2
    //   14895: new 79	java/lang/StringBuilder
    //   14898: dup
    //   14899: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   14902: ldc_w 4072
    //   14905: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14908: iload 5
    //   14910: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14913: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14916: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14919: invokestatic 4078	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   14922: new 4080	com/tencent/imcore/message/OnLinePushMessageProcessor$2
    //   14925: dup
    //   14926: aload_0
    //   14927: iload 5
    //   14929: invokespecial 4083	com/tencent/imcore/message/OnLinePushMessageProcessor$2:<init>	(Ltos;I)V
    //   14932: invokevirtual 4087	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   14935: pop
    //   14936: iload 4
    //   14938: bipush 6
    //   14940: if_icmple -14911 -> 29
    //   14943: iload 4
    //   14945: bipush 6
    //   14947: isub
    //   14948: newarray byte
    //   14950: astore 28
    //   14952: aload 32
    //   14954: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14957: bipush 6
    //   14959: aload 28
    //   14961: iconst_0
    //   14962: iload 4
    //   14964: bipush 6
    //   14966: isub
    //   14967: invokestatic 4070	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14970: iload 5
    //   14972: aload_1
    //   14973: aload 28
    //   14975: invokestatic 4092	aczv:b	(I[B[B)Z
    //   14978: pop
    //   14979: aconst_null
    //   14980: areturn
    //   14981: aload 32
    //   14983: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14986: ldc2_w 4093
    //   14989: lcmp
    //   14990: ifne +118 -> 15108
    //   14993: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14996: ifeq +12 -> 15008
    //   14999: ldc 21
    //   15001: iconst_2
    //   15002: ldc_w 4096
    //   15005: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15008: aload_0
    //   15009: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15012: sipush 252
    //   15015: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15018: checkcast 4098	puz
    //   15021: astore_1
    //   15022: new 4100	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify
    //   15025: dup
    //   15026: invokespecial 4101	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:<init>	()V
    //   15029: astore 28
    //   15031: aload 28
    //   15033: aload 32
    //   15035: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15038: invokevirtual 4102	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15041: pop
    //   15042: aload_0
    //   15043: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15046: sipush 251
    //   15049: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15052: checkcast 4104	puy
    //   15055: astore 29
    //   15057: aload_1
    //   15058: getfield 4107	puz:aBT	Z
    //   15061: ifeq -15032 -> 29
    //   15064: aload 29
    //   15066: invokevirtual 4110	puy:a	()Lpum;
    //   15069: aload 28
    //   15071: invokevirtual 4115	pum:a	(Lcom/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify;)V
    //   15074: aconst_null
    //   15075: areturn
    //   15076: astore_1
    //   15077: ldc 21
    //   15079: iconst_1
    //   15080: new 79	java/lang/StringBuilder
    //   15083: dup
    //   15084: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   15087: ldc_w 4117
    //   15090: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15093: aload_1
    //   15094: invokevirtual 4118	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   15097: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15100: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15103: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15106: aconst_null
    //   15107: areturn
    //   15108: aload 32
    //   15110: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15113: ldc2_w 4119
    //   15116: lcmp
    //   15117: ifne +80 -> 15197
    //   15120: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15123: ifeq +33 -> 15156
    //   15126: ldc 21
    //   15128: iconst_2
    //   15129: new 79	java/lang/StringBuilder
    //   15132: dup
    //   15133: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   15136: ldc_w 4122
    //   15139: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15142: aload 32
    //   15144: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15147: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15150: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15153: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15156: aload_0
    //   15157: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15160: sipush 253
    //   15163: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15166: checkcast 4124	plz
    //   15169: astore 28
    //   15171: aload_1
    //   15172: getfield 1230	OnlinePushPack/MsgInfo:lFromUin	J
    //   15175: lstore_2
    //   15176: aload 28
    //   15178: aload 28
    //   15180: aload 32
    //   15182: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15185: lload_2
    //   15186: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   15189: invokevirtual 4127	plz:a	([BLjava/lang/String;)Lcom/tencent/mobileqq/data/MessageForQQStoryFeed;
    //   15192: invokevirtual 4130	plz:a	(Lcom/tencent/mobileqq/data/MessageForQQStoryFeed;)V
    //   15195: aconst_null
    //   15196: areturn
    //   15197: aload 32
    //   15199: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15202: ldc2_w 4131
    //   15205: lcmp
    //   15206: ifne +237 -> 15443
    //   15209: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15212: ifeq +12 -> 15224
    //   15215: ldc 21
    //   15217: iconst_2
    //   15218: ldc_w 4134
    //   15221: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15224: new 4136	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody
    //   15227: dup
    //   15228: invokespecial 4137	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:<init>	()V
    //   15231: astore_1
    //   15232: aload 32
    //   15234: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15237: ifnull -15208 -> 29
    //   15240: aload_1
    //   15241: aload 32
    //   15243: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15246: invokevirtual 4138	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15249: pop
    //   15250: aload_1
    //   15251: getfield 4141	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:rpt_now_push_msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   15254: invokevirtual 120	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   15257: invokeinterface 126 1 0
    //   15262: astore_1
    //   15263: aload_1
    //   15264: invokeinterface 131 1 0
    //   15269: ifeq -15240 -> 29
    //   15272: aload_1
    //   15273: invokeinterface 135 1 0
    //   15278: checkcast 4143	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg
    //   15281: astore 28
    //   15283: aload_0
    //   15284: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15287: sipush 266
    //   15290: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15293: checkcast 4145	aklj
    //   15296: aload 28
    //   15298: invokevirtual 4148	aklj:a	(Lcom/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg;)V
    //   15301: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15304: ifeq -41 -> 15263
    //   15307: ldc 21
    //   15309: iconst_2
    //   15310: new 79	java/lang/StringBuilder
    //   15313: dup
    //   15314: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   15317: ldc_w 4150
    //   15320: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15323: aload 28
    //   15325: getfield 4153	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15328: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15331: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15334: ldc_w 4155
    //   15337: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15340: aload 28
    //   15342: getfield 4156	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15345: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15348: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15351: ldc_w 4158
    //   15354: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15357: aload 28
    //   15359: getfield 4159	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15362: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15365: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15368: ldc_w 4161
    //   15371: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15374: aload 28
    //   15376: getfield 4164	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_start_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15379: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15382: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15385: ldc_w 4166
    //   15388: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15391: aload 28
    //   15393: getfield 4169	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15396: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15399: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15402: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15405: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15408: goto -145 -> 15263
    //   15411: astore_1
    //   15412: ldc 21
    //   15414: iconst_1
    //   15415: new 79	java/lang/StringBuilder
    //   15418: dup
    //   15419: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   15422: ldc_w 4171
    //   15425: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15428: aload_1
    //   15429: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   15432: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15435: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15438: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15441: aconst_null
    //   15442: areturn
    //   15443: aload 32
    //   15445: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15448: ldc2_w 4172
    //   15451: lcmp
    //   15452: ifne +32 -> 15484
    //   15455: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15458: ifeq +12 -> 15470
    //   15461: ldc 21
    //   15463: iconst_2
    //   15464: ldc_w 4175
    //   15467: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15470: aload_0
    //   15471: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15474: aload 32
    //   15476: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15479: aload_1
    //   15480: invokestatic 4180	afce:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BLOnlinePushPack/MsgInfo;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   15483: areturn
    //   15484: aload 32
    //   15486: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15489: ldc2_w 4181
    //   15492: lcmp
    //   15493: ifne +65 -> 15558
    //   15496: new 4184	tencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody
    //   15499: dup
    //   15500: invokespecial 4185	tencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody:<init>	()V
    //   15503: astore 28
    //   15505: aload 28
    //   15507: aload 32
    //   15509: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15512: invokevirtual 4186	tencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15515: pop
    //   15516: aload_0
    //   15517: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15520: sipush 284
    //   15523: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15526: checkcast 4188	aizd
    //   15529: aload 28
    //   15531: aload_1
    //   15532: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   15535: aload_1
    //   15536: getfield 1282	OnlinePushPack/MsgInfo:lMsgUid	J
    //   15539: invokevirtual 4191	aizd:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody;SJ)V
    //   15542: aconst_null
    //   15543: areturn
    //   15544: astore_1
    //   15545: ldc 21
    //   15547: iconst_1
    //   15548: aload_1
    //   15549: iconst_0
    //   15550: anewarray 261	java/lang/Object
    //   15553: invokestatic 4194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   15556: aconst_null
    //   15557: areturn
    //   15558: aload 32
    //   15560: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15563: ldc2_w 4195
    //   15566: lcmp
    //   15567: ifne +75 -> 15642
    //   15570: new 4198	tencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody
    //   15573: dup
    //   15574: invokespecial 4199	tencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody:<init>	()V
    //   15577: astore_1
    //   15578: aload_1
    //   15579: aload 32
    //   15581: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15584: invokevirtual 4200	tencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15587: pop
    //   15588: aload_0
    //   15589: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15592: invokevirtual 4203	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   15595: invokevirtual 4208	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Laegz;
    //   15598: aload_1
    //   15599: invokevirtual 4213	aegz:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody;)V
    //   15602: aconst_null
    //   15603: areturn
    //   15604: astore_1
    //   15605: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15608: ifeq -15579 -> 29
    //   15611: ldc 21
    //   15613: iconst_2
    //   15614: new 79	java/lang/StringBuilder
    //   15617: dup
    //   15618: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   15621: ldc_w 4215
    //   15624: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15627: aload_1
    //   15628: invokevirtual 3581	java/lang/Exception:toString	()Ljava/lang/String;
    //   15631: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15634: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15637: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15640: aconst_null
    //   15641: areturn
    //   15642: aload 32
    //   15644: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15647: ldc2_w 4216
    //   15650: lcmp
    //   15651: ifne +75 -> 15726
    //   15654: new 4219	tencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody
    //   15657: dup
    //   15658: invokespecial 4220	tencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody:<init>	()V
    //   15661: astore_1
    //   15662: aload_1
    //   15663: aload 32
    //   15665: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15668: invokevirtual 4221	tencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15671: pop
    //   15672: aload_0
    //   15673: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15676: invokevirtual 4203	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   15679: invokevirtual 4208	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Laegz;
    //   15682: aload_1
    //   15683: invokevirtual 4224	aegz:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody;)V
    //   15686: aconst_null
    //   15687: areturn
    //   15688: astore_1
    //   15689: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15692: ifeq -15663 -> 29
    //   15695: ldc 21
    //   15697: iconst_2
    //   15698: new 79	java/lang/StringBuilder
    //   15701: dup
    //   15702: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   15705: ldc_w 4226
    //   15708: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15711: aload_1
    //   15712: invokevirtual 3581	java/lang/Exception:toString	()Ljava/lang/String;
    //   15715: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15718: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15721: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15724: aconst_null
    //   15725: areturn
    //   15726: aload 32
    //   15728: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15731: ldc2_w 4227
    //   15734: lcmp
    //   15735: ifne +32 -> 15767
    //   15738: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15741: ifeq +12 -> 15753
    //   15744: ldc 21
    //   15746: iconst_2
    //   15747: ldc_w 4230
    //   15750: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15753: aload_0
    //   15754: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15757: aload 32
    //   15759: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15762: aload_1
    //   15763: invokestatic 4234	afdd:b	(Lcom/tencent/mobileqq/app/QQAppInterface;[BLOnlinePushPack/MsgInfo;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   15766: areturn
    //   15767: aload 32
    //   15769: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15772: ldc2_w 4235
    //   15775: lcmp
    //   15776: ifne +32 -> 15808
    //   15779: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15782: ifeq +12 -> 15794
    //   15785: ldc 21
    //   15787: iconst_2
    //   15788: ldc_w 4238
    //   15791: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15794: aload_0
    //   15795: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15798: aload 32
    //   15800: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15803: invokestatic 4242	achg:c	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   15806: aconst_null
    //   15807: areturn
    //   15808: aload 32
    //   15810: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15813: ldc2_w 4243
    //   15816: lcmp
    //   15817: ifne +48 -> 15865
    //   15820: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15823: ifeq +12 -> 15835
    //   15826: ldc 21
    //   15828: iconst_2
    //   15829: ldc_w 4246
    //   15832: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15835: aload_0
    //   15836: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15839: iconst_1
    //   15840: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   15843: checkcast 252	com/tencent/mobileqq/app/FriendListHandler
    //   15846: checkcast 252	com/tencent/mobileqq/app/FriendListHandler
    //   15849: astore_1
    //   15850: aload_1
    //   15851: ifnull -15822 -> 29
    //   15854: aload_1
    //   15855: aload 32
    //   15857: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15860: invokevirtual 4249	com/tencent/mobileqq/app/FriendListHandler:aw	([B)V
    //   15863: aconst_null
    //   15864: areturn
    //   15865: aload 32
    //   15867: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15870: ldc2_w 4250
    //   15873: lcmp
    //   15874: ifne +43 -> 15917
    //   15877: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15880: ifeq +12 -> 15892
    //   15883: ldc 21
    //   15885: iconst_2
    //   15886: ldc_w 4253
    //   15889: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15892: aload_0
    //   15893: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15896: aload 32
    //   15898: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15901: aload_1
    //   15902: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   15905: i2l
    //   15906: aload_1
    //   15907: getfield 1275	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   15910: i2l
    //   15911: iconst_0
    //   15912: invokestatic 4258	ainz:b	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJJZ)V
    //   15915: aconst_null
    //   15916: areturn
    //   15917: aload 32
    //   15919: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15922: ldc2_w 4259
    //   15925: lcmp
    //   15926: ifeq +15 -> 15941
    //   15929: aload 32
    //   15931: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15934: ldc2_w 4261
    //   15937: lcmp
    //   15938: ifne +92 -> 16030
    //   15941: aload_0
    //   15942: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15945: sipush 339
    //   15948: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15951: checkcast 4264	aohy
    //   15954: iconst_4
    //   15955: invokevirtual 4267	aohy:a	(I)Laoih;
    //   15958: astore 28
    //   15960: aload 28
    //   15962: ifnull -15933 -> 29
    //   15965: aload_0
    //   15966: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15969: astore 29
    //   15971: aload 32
    //   15973: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15976: astore 30
    //   15978: aload_1
    //   15979: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   15982: i2l
    //   15983: lstore_2
    //   15984: aload_1
    //   15985: getfield 1275	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   15988: i2l
    //   15989: lstore 15
    //   15991: aload 32
    //   15993: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15996: ldc2_w 4259
    //   15999: lcmp
    //   16000: ifne +24 -> 16024
    //   16003: iconst_0
    //   16004: istore 19
    //   16006: aload 28
    //   16008: aload 29
    //   16010: aload 30
    //   16012: lload_2
    //   16013: lload 15
    //   16015: iload 19
    //   16017: invokeinterface 4271 8 0
    //   16022: aconst_null
    //   16023: areturn
    //   16024: iconst_1
    //   16025: istore 19
    //   16027: goto -21 -> 16006
    //   16030: aload 32
    //   16032: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16035: ldc2_w 4272
    //   16038: lcmp
    //   16039: ifne +29 -> 16068
    //   16042: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16045: ifeq +12 -> 16057
    //   16048: ldc 21
    //   16050: iconst_2
    //   16051: ldc_w 4275
    //   16054: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16057: aload 32
    //   16059: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16062: lload_2
    //   16063: invokestatic 4279	aljs:k	([BJ)V
    //   16066: aconst_null
    //   16067: areturn
    //   16068: aload 32
    //   16070: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16073: ldc2_w 4280
    //   16076: lcmp
    //   16077: ifne +193 -> 16270
    //   16080: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16083: ifeq +12 -> 16095
    //   16086: ldc 21
    //   16088: iconst_2
    //   16089: ldc_w 4283
    //   16092: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16095: new 4285	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody
    //   16098: dup
    //   16099: invokespecial 4286	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:<init>	()V
    //   16102: astore_1
    //   16103: aload 32
    //   16105: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16108: ifnull -16079 -> 29
    //   16111: aload_1
    //   16112: aload 32
    //   16114: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16117: invokevirtual 4287	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16120: pop
    //   16121: aload_1
    //   16122: getfield 4288	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   16125: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   16128: lstore_2
    //   16129: aload_1
    //   16130: getfield 4289	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   16133: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   16136: lstore 15
    //   16138: aload_1
    //   16139: getfield 4293	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:msg_notify_item	Ltencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem;
    //   16142: invokevirtual 4296	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16145: checkcast 4295	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem
    //   16148: astore_1
    //   16149: aload_1
    //   16150: getfield 4299	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint32_timeout_s	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16153: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   16156: istore 4
    //   16158: aload_1
    //   16159: getfield 4302	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint32_event_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16162: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   16165: istore 5
    //   16167: aload_1
    //   16168: getfield 4305	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint32_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16171: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   16174: istore 6
    //   16176: aload_1
    //   16177: getfield 4308	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint64_timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   16180: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   16183: lstore 17
    //   16185: aload_1
    //   16186: getfield 4309	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   16189: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   16192: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   16195: astore_1
    //   16196: aload_0
    //   16197: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16200: sipush 316
    //   16203: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   16206: astore 28
    //   16208: aload 28
    //   16210: instanceof 4311
    //   16213: ifeq -16184 -> 29
    //   16216: aload 28
    //   16218: checkcast 4311	aibo
    //   16221: lload_2
    //   16222: lload 15
    //   16224: lload 17
    //   16226: iload 6
    //   16228: iload 4
    //   16230: iload 5
    //   16232: aload_1
    //   16233: invokevirtual 4314	aibo:a	(JJJIIILjava/lang/String;)V
    //   16236: aconst_null
    //   16237: areturn
    //   16238: astore_1
    //   16239: ldc 21
    //   16241: iconst_1
    //   16242: new 79	java/lang/StringBuilder
    //   16245: dup
    //   16246: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   16249: ldc_w 4316
    //   16252: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16255: aload_1
    //   16256: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16259: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16262: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16265: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16268: aconst_null
    //   16269: areturn
    //   16270: aload 32
    //   16272: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16275: ldc2_w 4317
    //   16278: lcmp
    //   16279: ifne +138 -> 16417
    //   16282: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16285: ifeq +12 -> 16297
    //   16288: ldc 21
    //   16290: iconst_2
    //   16291: ldc_w 4320
    //   16294: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16297: new 4322	tencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody
    //   16300: dup
    //   16301: invokespecial 4323	tencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody:<init>	()V
    //   16304: astore 28
    //   16306: aload 32
    //   16308: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16311: ifnull -16282 -> 29
    //   16314: aload 28
    //   16316: aload 32
    //   16318: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16321: invokevirtual 4324	tencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16324: pop
    //   16325: ldc 21
    //   16327: iconst_1
    //   16328: new 79	java/lang/StringBuilder
    //   16331: dup
    //   16332: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   16335: ldc_w 4326
    //   16338: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16341: aload 28
    //   16343: invokevirtual 2406	java/lang/Object:toString	()Ljava/lang/String;
    //   16346: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16349: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16352: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16355: aload_1
    //   16356: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   16359: invokestatic 4329	aobw:iD	(I)Z
    //   16362: ifne -16333 -> 29
    //   16365: aload_0
    //   16366: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16369: aload 28
    //   16371: invokestatic 4332	aobw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody;)V
    //   16374: ldc 21
    //   16376: iconst_1
    //   16377: ldc_w 4334
    //   16380: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16383: aconst_null
    //   16384: areturn
    //   16385: astore_1
    //   16386: ldc 21
    //   16388: iconst_1
    //   16389: new 79	java/lang/StringBuilder
    //   16392: dup
    //   16393: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   16396: ldc_w 4316
    //   16399: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16402: aload_1
    //   16403: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16406: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16409: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16412: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16415: aconst_null
    //   16416: areturn
    //   16417: aload 32
    //   16419: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16422: ldc2_w 4335
    //   16425: lcmp
    //   16426: ifne +101 -> 16527
    //   16429: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16432: ifeq +12 -> 16444
    //   16435: ldc 21
    //   16437: iconst_2
    //   16438: ldc_w 4338
    //   16441: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16444: new 4340	tencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody
    //   16447: dup
    //   16448: invokespecial 4341	tencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody:<init>	()V
    //   16451: astore_1
    //   16452: aload 32
    //   16454: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16457: ifnull -16428 -> 29
    //   16460: aload_1
    //   16461: aload 32
    //   16463: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16466: invokevirtual 4342	tencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16469: pop
    //   16470: aload_0
    //   16471: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16474: aload_1
    //   16475: invokestatic 4347	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody;)V
    //   16478: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16481: ifeq -16452 -> 29
    //   16484: ldc 21
    //   16486: iconst_2
    //   16487: ldc_w 4349
    //   16490: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16493: aconst_null
    //   16494: areturn
    //   16495: astore_1
    //   16496: ldc 21
    //   16498: iconst_1
    //   16499: new 79	java/lang/StringBuilder
    //   16502: dup
    //   16503: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   16506: ldc_w 4351
    //   16509: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16512: aload_1
    //   16513: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16516: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16519: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16522: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16525: aconst_null
    //   16526: areturn
    //   16527: aload 32
    //   16529: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16532: ldc2_w 4352
    //   16535: lcmp
    //   16536: ifne +26 -> 16562
    //   16539: aload_0
    //   16540: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16543: aload 32
    //   16545: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16548: aload_1
    //   16549: getfield 1252	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   16552: aload_1
    //   16553: getfield 1275	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   16556: iconst_0
    //   16557: invokestatic 4358	aiqq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BSIZ)V
    //   16560: aconst_null
    //   16561: areturn
    //   16562: aload 32
    //   16564: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16567: ldc2_w 4359
    //   16570: lcmp
    //   16571: ifne +85 -> 16656
    //   16574: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16577: ifeq +12 -> 16589
    //   16580: ldc 21
    //   16582: iconst_2
    //   16583: ldc_w 4362
    //   16586: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16589: new 4364	tencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody
    //   16592: dup
    //   16593: invokespecial 4365	tencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody:<init>	()V
    //   16596: astore_1
    //   16597: aload 32
    //   16599: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16602: ifnull -16573 -> 29
    //   16605: aload_1
    //   16606: aload 32
    //   16608: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16611: invokevirtual 4366	tencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16614: pop
    //   16615: invokestatic 4371	ajdv:a	()Lajdv;
    //   16618: aload_1
    //   16619: invokevirtual 4374	ajdv:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody;)V
    //   16622: aconst_null
    //   16623: areturn
    //   16624: astore_1
    //   16625: ldc 21
    //   16627: iconst_1
    //   16628: new 79	java/lang/StringBuilder
    //   16631: dup
    //   16632: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   16635: ldc_w 4376
    //   16638: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16641: aload_1
    //   16642: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16645: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16648: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16651: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16654: aconst_null
    //   16655: areturn
    //   16656: aload 32
    //   16658: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16661: ldc2_w 4377
    //   16664: lcmp
    //   16665: ifne +257 -> 16922
    //   16668: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16671: ifeq +12 -> 16683
    //   16674: ldc 21
    //   16676: iconst_2
    //   16677: ldc_w 4380
    //   16680: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16683: new 4382	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody
    //   16686: dup
    //   16687: invokespecial 4383	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:<init>	()V
    //   16690: astore_1
    //   16691: aload 32
    //   16693: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16696: ifnull -16667 -> 29
    //   16699: aload_1
    //   16700: aload 32
    //   16702: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16705: invokevirtual 4384	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16708: pop
    //   16709: aload_1
    //   16710: getfield 4385	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16713: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   16716: ifeq +106 -> 16822
    //   16719: aload_1
    //   16720: getfield 4385	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16723: invokevirtual 46	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   16726: istore 4
    //   16728: iload 4
    //   16730: iconst_2
    //   16731: if_icmpne +97 -> 16828
    //   16734: aload_0
    //   16735: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16738: invokevirtual 2903	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   16741: aload_1
    //   16742: invokevirtual 4388	com/tencent/av/gaudio/AVNotifyCenter:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody;)V
    //   16745: ldc 186
    //   16747: astore_1
    //   16748: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16751: ifeq -16722 -> 29
    //   16754: ldc 21
    //   16756: iconst_2
    //   16757: iconst_4
    //   16758: anewarray 261	java/lang/Object
    //   16761: dup
    //   16762: iconst_0
    //   16763: ldc_w 4390
    //   16766: aastore
    //   16767: dup
    //   16768: iconst_1
    //   16769: iload 4
    //   16771: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16774: aastore
    //   16775: dup
    //   16776: iconst_2
    //   16777: ldc_w 4392
    //   16780: aastore
    //   16781: dup
    //   16782: iconst_3
    //   16783: aload_1
    //   16784: aastore
    //   16785: invokestatic 736	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   16788: aconst_null
    //   16789: areturn
    //   16790: astore_1
    //   16791: ldc 21
    //   16793: iconst_1
    //   16794: new 79	java/lang/StringBuilder
    //   16797: dup
    //   16798: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   16801: ldc_w 4394
    //   16804: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16807: aload_1
    //   16808: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16811: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16814: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16817: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16820: aconst_null
    //   16821: areturn
    //   16822: iconst_0
    //   16823: istore 4
    //   16825: goto -97 -> 16728
    //   16828: aload_1
    //   16829: getfield 4397	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   16832: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   16835: istore 19
    //   16837: iload 19
    //   16839: ifeq +77 -> 16916
    //   16842: aload_1
    //   16843: getfield 4397	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   16846: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   16849: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   16852: astore_1
    //   16853: new 969	android/os/Bundle
    //   16856: dup
    //   16857: invokespecial 970	android/os/Bundle:<init>	()V
    //   16860: astore 28
    //   16862: aload 28
    //   16864: ldc_w 4399
    //   16867: iload 4
    //   16869: invokevirtual 2473	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   16872: aload 28
    //   16874: ldc_w 4401
    //   16877: aload_1
    //   16878: invokevirtual 4403	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   16881: aload_0
    //   16882: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16885: ldc_w 4405
    //   16888: bipush 11
    //   16890: iconst_1
    //   16891: aload 28
    //   16893: invokevirtual 988	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   16896: goto -148 -> 16748
    //   16899: astore_1
    //   16900: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16903: ifeq +13 -> 16916
    //   16906: ldc 21
    //   16908: iconst_2
    //   16909: ldc_w 4407
    //   16912: aload_1
    //   16913: invokestatic 4409	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16916: ldc 186
    //   16918: astore_1
    //   16919: goto -66 -> 16853
    //   16922: aload 32
    //   16924: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16927: ldc2_w 4410
    //   16930: lcmp
    //   16931: ifne +85 -> 17016
    //   16934: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16937: ifeq +12 -> 16949
    //   16940: ldc 21
    //   16942: iconst_2
    //   16943: ldc_w 4413
    //   16946: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16949: new 4415	tencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody
    //   16952: dup
    //   16953: invokespecial 4416	tencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody:<init>	()V
    //   16956: astore_1
    //   16957: aload 32
    //   16959: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16962: ifnull -16933 -> 29
    //   16965: aload_1
    //   16966: aload 32
    //   16968: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16971: invokevirtual 4417	tencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16974: pop
    //   16975: invokestatic 4371	ajdv:a	()Lajdv;
    //   16978: aload_1
    //   16979: invokevirtual 4420	ajdv:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody;)V
    //   16982: aconst_null
    //   16983: areturn
    //   16984: astore_1
    //   16985: ldc 21
    //   16987: iconst_1
    //   16988: new 79	java/lang/StringBuilder
    //   16991: dup
    //   16992: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   16995: ldc_w 4422
    //   16998: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17001: aload_1
    //   17002: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   17005: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17008: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17011: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17014: aconst_null
    //   17015: areturn
    //   17016: aload 32
    //   17018: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17021: ldc2_w 4423
    //   17024: lcmp
    //   17025: ifeq +15 -> 17040
    //   17028: aload 32
    //   17030: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17033: ldc2_w 4425
    //   17036: lcmp
    //   17037: ifne +49 -> 17086
    //   17040: aload_0
    //   17041: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17044: astore 28
    //   17046: aload 32
    //   17048: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17051: astore 29
    //   17053: aload 32
    //   17055: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17058: ldc2_w 4423
    //   17061: lcmp
    //   17062: ifne +18 -> 17080
    //   17065: iconst_1
    //   17066: istore 19
    //   17068: aload 28
    //   17070: aload 29
    //   17072: aload_1
    //   17073: iload 19
    //   17075: invokestatic 4431	ahwb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BLOnlinePushPack/MsgInfo;Z)V
    //   17078: aconst_null
    //   17079: areturn
    //   17080: iconst_0
    //   17081: istore 19
    //   17083: goto -15 -> 17068
    //   17086: aload 32
    //   17088: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17091: ldc2_w 4432
    //   17094: lcmp
    //   17095: ifeq +15 -> 17110
    //   17098: aload 32
    //   17100: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17103: ldc2_w 4434
    //   17106: lcmp
    //   17107: ifne +184 -> 17291
    //   17110: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17113: ifeq +33 -> 17146
    //   17116: ldc 21
    //   17118: iconst_2
    //   17119: new 79	java/lang/StringBuilder
    //   17122: dup
    //   17123: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   17126: ldc_w 4437
    //   17129: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17132: aload 32
    //   17134: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17137: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17140: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17143: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17146: new 4439	tencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody
    //   17149: dup
    //   17150: invokespecial 4440	tencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody:<init>	()V
    //   17153: astore_1
    //   17154: aload 32
    //   17156: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17159: ifnull +100 -> 17259
    //   17162: aload_1
    //   17163: aload 32
    //   17165: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17168: invokevirtual 4441	tencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   17171: pop
    //   17172: aload_0
    //   17173: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17176: bipush 127
    //   17178: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   17181: checkcast 4443	afsg
    //   17184: astore 28
    //   17186: aload 32
    //   17188: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17191: ldc2_w 4432
    //   17194: lcmp
    //   17195: ifne +58 -> 17253
    //   17198: iconst_1
    //   17199: istore 19
    //   17201: aload 28
    //   17203: aload_1
    //   17204: iload 19
    //   17206: invokevirtual 4446	afsg:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody;Z)V
    //   17209: ldc_w 4448
    //   17212: iconst_2
    //   17213: ldc_w 4450
    //   17216: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17219: aconst_null
    //   17220: areturn
    //   17221: astore_1
    //   17222: ldc 21
    //   17224: iconst_1
    //   17225: new 79	java/lang/StringBuilder
    //   17228: dup
    //   17229: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   17232: ldc_w 4452
    //   17235: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17238: aload_1
    //   17239: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   17242: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17245: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17248: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17251: aconst_null
    //   17252: areturn
    //   17253: iconst_0
    //   17254: istore 19
    //   17256: goto -55 -> 17201
    //   17259: ldc 21
    //   17261: iconst_2
    //   17262: new 79	java/lang/StringBuilder
    //   17265: dup
    //   17266: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   17269: ldc_w 4454
    //   17272: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17275: aload 32
    //   17277: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17280: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17283: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17286: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17289: aconst_null
    //   17290: areturn
    //   17291: aload 32
    //   17293: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17296: ldc2_w 4455
    //   17299: lcmp
    //   17300: ifne +50 -> 17350
    //   17303: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17306: ifeq +12 -> 17318
    //   17309: ldc 21
    //   17311: iconst_2
    //   17312: ldc_w 4458
    //   17315: invokestatic 774	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17318: aload_0
    //   17319: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17322: sipush 169
    //   17325: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   17328: checkcast 4460	ypc
    //   17331: checkcast 4460	ypc
    //   17334: astore_1
    //   17335: aload_1
    //   17336: ifnull -17307 -> 29
    //   17339: aload_1
    //   17340: aload 32
    //   17342: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17345: invokevirtual 4462	ypc:an	([B)V
    //   17348: aconst_null
    //   17349: areturn
    //   17350: aload 32
    //   17352: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17355: ldc2_w 4463
    //   17358: lcmp
    //   17359: ifne +14 -> 17373
    //   17362: aload_0
    //   17363: aload 32
    //   17365: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17368: invokespecial 4466	tos:Y	([B)V
    //   17371: aconst_null
    //   17372: areturn
    //   17373: aload 32
    //   17375: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17378: ldc2_w 4467
    //   17381: lcmp
    //   17382: ifne -17353 -> 29
    //   17385: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17388: ifeq +13 -> 17401
    //   17391: getstatic 4473	augm:TAG	Ljava/lang/String;
    //   17394: iconst_2
    //   17395: ldc_w 4475
    //   17398: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17401: aload_0
    //   17402: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17405: sipush 179
    //   17408: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   17411: checkcast 4470	augm
    //   17414: aload 32
    //   17416: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17419: invokevirtual 4478	augm:cd	([B)V
    //   17422: aconst_null
    //   17423: areturn
    //   17424: aload 32
    //   17426: getfield 1748	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17429: ldc2_w 4479
    //   17432: lcmp
    //   17433: ifne -17404 -> 29
    //   17436: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17439: ifeq +12 -> 17451
    //   17442: ldc 21
    //   17444: iconst_2
    //   17445: ldc_w 4482
    //   17448: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17451: new 4484	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody
    //   17454: dup
    //   17455: invokespecial 4485	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:<init>	()V
    //   17458: astore 28
    //   17460: aload 32
    //   17462: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17465: ifnull -17436 -> 29
    //   17468: aload 28
    //   17470: aload 32
    //   17472: getfield 1778	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17475: invokevirtual 4486	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   17478: pop
    //   17479: aload 28
    //   17481: getfield 4487	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17484: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   17487: ifeq +86 -> 17573
    //   17490: aload 28
    //   17492: getfield 4487	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17495: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   17498: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   17501: astore_1
    //   17502: aload 28
    //   17504: getfield 4490	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17507: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   17510: ifeq +69 -> 17579
    //   17513: aload 28
    //   17515: getfield 4490	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17518: invokevirtual 158	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   17521: invokevirtual 163	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   17524: astore 28
    //   17526: invokestatic 4495	adrm:a	()Ladrm;
    //   17529: aload_0
    //   17530: getfield 50	tos:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17533: aload_1
    //   17534: aload 28
    //   17536: invokevirtual 4497	adrm:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   17539: aconst_null
    //   17540: areturn
    //   17541: astore_1
    //   17542: ldc 21
    //   17544: iconst_1
    //   17545: new 79	java/lang/StringBuilder
    //   17548: dup
    //   17549: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   17552: ldc_w 4499
    //   17555: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17558: aload_1
    //   17559: invokevirtual 3853	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   17562: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17565: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17568: invokestatic 899	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17571: aconst_null
    //   17572: areturn
    //   17573: ldc 186
    //   17575: astore_1
    //   17576: goto -74 -> 17502
    //   17579: ldc 186
    //   17581: astore 28
    //   17583: goto -57 -> 17526
    //   17586: astore 28
    //   17588: goto -6572 -> 11016
    //   17591: astore_1
    //   17592: goto -8130 -> 9462
    //   17595: astore 30
    //   17597: goto -13754 -> 3843
    //   17600: astore 30
    //   17602: goto -13759 -> 3843
    //   17605: iconst_0
    //   17606: istore 19
    //   17608: goto -6349 -> 11259
    //   17611: iload 21
    //   17613: istore 24
    //   17615: iload 22
    //   17617: istore 25
    //   17619: iload 20
    //   17621: istore 26
    //   17623: iload 19
    //   17625: istore 27
    //   17627: goto -7530 -> 10097
    //   17630: goto -7717 -> 9913
    //   17633: aconst_null
    //   17634: astore_1
    //   17635: goto -9948 -> 7687
    //   17638: iconst_0
    //   17639: istore 6
    //   17641: goto -13056 -> 4585
    //   17644: iconst_0
    //   17645: istore 5
    //   17647: goto -13083 -> 4564
    //   17650: aconst_null
    //   17651: astore 30
    //   17653: goto -13913 -> 3740
    //   17656: aconst_null
    //   17657: astore 29
    //   17659: goto -13953 -> 3706
    //   17662: aconst_null
    //   17663: astore 28
    //   17665: goto -13997 -> 3668
    //   17668: iload 7
    //   17670: ifge -12970 -> 4700
    //   17673: iload 8
    //   17675: iflt -12941 -> 4734
    //   17678: goto -12978 -> 4700
    //   17681: iload 5
    //   17683: ifne -12907 -> 4776
    //   17686: iload 6
    //   17688: ifeq -12829 -> 4859
    //   17691: goto -12915 -> 4776
    //   17694: aload 29
    //   17696: astore 28
    //   17698: iload 5
    //   17700: istore 4
    //   17702: goto -9710 -> 7992
    //   17705: aload 30
    //   17707: areturn
    //   17708: sipush 1001
    //   17711: istore 4
    //   17713: aload 29
    //   17715: astore 28
    //   17717: goto -9725 -> 7992
    //   17720: goto -8696 -> 9024
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17723	0	this	tos
    //   0	17723	1	paramMsgInfo	MsgInfo
    //   0	17723	2	paramLong	long
    //   451	17261	4	i	int
    //   710	16989	5	j	int
    //   4218	13469	6	k	int
    //   4586	13083	7	m	int
    //   4589	13085	8	n	int
    //   4641	5771	9	i1	int
    //   9691	787	10	i2	int
    //   10260	63	11	i3	int
    //   10273	57	12	i4	int
    //   10286	54	13	i5	int
    //   10296	41	14	i6	int
    //   2600	13623	15	l1	long
    //   6513	9712	17	l2	long
    //   193	17431	19	bool1	boolean
    //   9561	8059	20	bool2	boolean
    //   9591	8021	21	bool3	boolean
    //   9531	8085	22	bool4	boolean
    //   9546	1333	23	bool5	boolean
    //   10000	7614	24	bool6	boolean
    //   10004	7614	25	bool7	boolean
    //   10008	7614	26	bool8	boolean
    //   10012	7614	27	bool9	boolean
    //   108	2467	28	localObject1	Object
    //   2624	1	28	localException1	Exception
    //   2746	314	28	localObject2	Object
    //   3073	26	28	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   3585	295	28	localObject3	Object
    //   3886	3	28	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   4119	7776	28	localObject4	Object
    //   11903	19	28	localException2	Exception
    //   12289	1	28	localException3	Exception
    //   12329	82	28	localMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody
    //   12910	72	28	localException4	Exception
    //   12995	4587	28	localObject5	Object
    //   17586	1	28	localThrowable	java.lang.Throwable
    //   17663	53	28	localObject6	Object
    //   171	2686	29	localObject7	Object
    //   2867	36	29	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   3625	14089	29	localObject8	Object
    //   648	3139	30	localObject9	Object
    //   3841	1	30	localException5	Exception
    //   3853	12158	30	localObject10	Object
    //   17595	1	30	localException6	Exception
    //   17600	1	30	localException7	Exception
    //   17651	55	30	localMessageRecord	MessageRecord
    //   727	12150	31	localObject11	Object
    //   22	17449	32	localObject12	Object
    //   2372	10419	33	localObject13	Object
    //   8287	109	34	localacff	acff
    // Exception table:
    //   from	to	target	type
    //   427	486	488	java/lang/Exception
    //   519	618	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   623	634	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   637	665	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   665	680	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   680	712	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   718	756	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   756	833	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   890	913	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   918	1007	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1007	1052	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1055	1130	836	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1145	1209	1426	java/lang/Exception
    //   1209	1246	1426	java/lang/Exception
    //   1246	1279	1426	java/lang/Exception
    //   1279	1385	1426	java/lang/Exception
    //   1385	1424	1426	java/lang/Exception
    //   1861	1885	1898	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1890	1896	1898	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1945	1969	1982	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1974	1980	1982	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2033	2150	2266	java/lang/Exception
    //   2155	2173	2266	java/lang/Exception
    //   2173	2264	2266	java/lang/Exception
    //   2365	2385	2624	java/lang/Exception
    //   2385	2419	2624	java/lang/Exception
    //   2419	2453	2624	java/lang/Exception
    //   2453	2487	2624	java/lang/Exception
    //   2487	2511	2624	java/lang/Exception
    //   2511	2567	2624	java/lang/Exception
    //   2567	2585	2624	java/lang/Exception
    //   2748	2759	2867	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3013	3023	3073	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3630	3664	3841	java/lang/Exception
    //   3533	3549	3886	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3549	3616	3886	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3630	3664	3886	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3668	3702	3886	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3706	3740	3886	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3752	3802	3886	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3855	3871	3886	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3928	3944	3886	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4065	4085	4872	java/lang/Exception
    //   4088	4121	4872	java/lang/Exception
    //   4124	4145	4872	java/lang/Exception
    //   4145	4179	4872	java/lang/Exception
    //   4187	4211	4872	java/lang/Exception
    //   4223	4244	4872	java/lang/Exception
    //   4244	4265	4872	java/lang/Exception
    //   4265	4285	4872	java/lang/Exception
    //   4285	4306	4872	java/lang/Exception
    //   4306	4372	4872	java/lang/Exception
    //   4372	4386	4872	java/lang/Exception
    //   4391	4401	4872	java/lang/Exception
    //   4401	4438	4872	java/lang/Exception
    //   4455	4515	4872	java/lang/Exception
    //   4517	4537	4872	java/lang/Exception
    //   4537	4564	4872	java/lang/Exception
    //   4564	4585	4872	java/lang/Exception
    //   4591	4612	4872	java/lang/Exception
    //   4612	4633	4872	java/lang/Exception
    //   4633	4697	4872	java/lang/Exception
    //   4700	4734	4872	java/lang/Exception
    //   4734	4773	4872	java/lang/Exception
    //   4776	4820	4872	java/lang/Exception
    //   4820	4859	4872	java/lang/Exception
    //   4859	4869	4872	java/lang/Exception
    //   4916	4943	4872	java/lang/Exception
    //   4943	4992	4872	java/lang/Exception
    //   4992	5019	4872	java/lang/Exception
    //   5019	5046	4872	java/lang/Exception
    //   5046	5065	4872	java/lang/Exception
    //   5076	5102	4872	java/lang/Exception
    //   5102	5119	4872	java/lang/Exception
    //   5130	5154	4872	java/lang/Exception
    //   5157	5178	4872	java/lang/Exception
    //   5178	5212	4872	java/lang/Exception
    //   5218	5402	4872	java/lang/Exception
    //   5417	5563	4872	java/lang/Exception
    //   5566	5648	4872	java/lang/Exception
    //   5657	5702	4872	java/lang/Exception
    //   5702	5720	4872	java/lang/Exception
    //   5743	5753	5846	java/lang/Throwable
    //   6076	6111	6113	java/lang/Throwable
    //   6241	6355	6428	java/lang/Exception
    //   6355	6391	6428	java/lang/Exception
    //   6391	6426	6428	java/lang/Exception
    //   6736	6805	6947	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6805	6870	6947	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6876	6945	6947	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7056	7066	7136	java/lang/Exception
    //   7070	7081	7136	java/lang/Exception
    //   7090	7134	7136	java/lang/Exception
    //   7193	7390	7699	java/lang/Exception
    //   7390	7533	7699	java/lang/Exception
    //   7689	7696	7699	java/lang/Exception
    //   7757	7792	7794	java/lang/Exception
    //   7841	7876	7878	java/lang/Exception
    //   7929	7940	8255	java/lang/Exception
    //   7955	7992	8255	java/lang/Exception
    //   7992	8136	8255	java/lang/Exception
    //   8136	8200	8255	java/lang/Exception
    //   8208	8221	8255	java/lang/Exception
    //   8229	8242	8255	java/lang/Exception
    //   8245	8252	8255	java/lang/Exception
    //   8309	8391	8569	java/lang/Exception
    //   8395	8404	8569	java/lang/Exception
    //   8409	8417	8569	java/lang/Exception
    //   8420	8551	8569	java/lang/Exception
    //   8668	8678	8739	java/lang/Throwable
    //   8819	8839	8841	java/lang/Exception
    //   8906	8918	8920	java/lang/Throwable
    //   8962	9024	9063	java/lang/Exception
    //   9024	9033	9063	java/lang/Exception
    //   9033	9061	9063	java/lang/Exception
    //   9081	9090	9063	java/lang/Exception
    //   9093	9102	9063	java/lang/Exception
    //   9105	9114	9063	java/lang/Exception
    //   9152	9201	9348	java/lang/Exception
    //   9201	9231	9348	java/lang/Exception
    //   9241	9281	9348	java/lang/Exception
    //   9289	9319	9348	java/lang/Exception
    //   9319	9346	9348	java/lang/Exception
    //   9399	9425	9427	java/lang/Exception
    //   11071	11090	11124	java/lang/Exception
    //   11317	11328	11632	java/lang/Exception
    //   11328	11351	11632	java/lang/Exception
    //   11351	11375	11632	java/lang/Exception
    //   11375	11399	11632	java/lang/Exception
    //   11399	11476	11632	java/lang/Exception
    //   11476	11630	11632	java/lang/Exception
    //   11162	11183	11654	java/lang/Exception
    //   11187	11246	11654	java/lang/Exception
    //   11246	11255	11654	java/lang/Exception
    //   11259	11280	11677	java/lang/Exception
    //   11760	11779	11813	java/lang/Exception
    //   11856	11866	11903	java/lang/Exception
    //   11964	11982	12017	java/lang/Exception
    //   11998	12015	12017	java/lang/Exception
    //   12063	12081	12017	java/lang/Exception
    //   12111	12145	12147	java/lang/Exception
    //   12187	12202	12204	java/lang/Exception
    //   12259	12269	12289	java/lang/Exception
    //   12331	12410	12910	java/lang/Exception
    //   12410	12423	12910	java/lang/Exception
    //   12428	12463	12910	java/lang/Exception
    //   12463	12521	12910	java/lang/Exception
    //   12521	12555	12910	java/lang/Exception
    //   12555	12580	12910	java/lang/Exception
    //   12580	12605	12910	java/lang/Exception
    //   12605	12639	12910	java/lang/Exception
    //   12639	12666	12910	java/lang/Exception
    //   12666	12700	12910	java/lang/Exception
    //   12700	12724	12910	java/lang/Exception
    //   12724	12748	12910	java/lang/Exception
    //   12753	12777	12910	java/lang/Exception
    //   12777	12801	12910	java/lang/Exception
    //   12801	12835	12910	java/lang/Exception
    //   12835	12859	12910	java/lang/Exception
    //   12859	12893	12910	java/lang/Exception
    //   12893	12907	12910	java/lang/Exception
    //   12967	13013	12910	java/lang/Exception
    //   13052	13102	13159	java/lang/Exception
    //   13108	13137	13159	java/lang/Exception
    //   13142	13157	13159	java/lang/Exception
    //   13179	13195	13159	java/lang/Exception
    //   13252	13281	13283	java/lang/Exception
    //   13331	13433	13435	java/lang/Exception
    //   13920	13949	13951	java/lang/Exception
    //   14201	14230	14232	java/lang/Exception
    //   14338	14417	14509	java/lang/Exception
    //   14424	14434	14509	java/lang/Exception
    //   14439	14458	14509	java/lang/Exception
    //   14458	14486	14509	java/lang/Exception
    //   14493	14506	14509	java/lang/Exception
    //   14523	14536	14509	java/lang/Exception
    //   14560	14646	14648	java/lang/Exception
    //   14712	14738	14748	java/lang/Exception
    //   14738	14746	14748	java/lang/Exception
    //   15022	15074	15076	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   15224	15263	15411	java/lang/Exception
    //   15263	15408	15411	java/lang/Exception
    //   15505	15542	15544	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   15578	15602	15604	java/lang/Exception
    //   15662	15686	15688	java/lang/Exception
    //   16095	16236	16238	java/lang/Exception
    //   16297	16383	16385	java/lang/Exception
    //   16444	16493	16495	java/lang/Exception
    //   16589	16622	16624	java/lang/Exception
    //   16683	16728	16790	java/lang/Exception
    //   16734	16745	16790	java/lang/Exception
    //   16748	16788	16790	java/lang/Exception
    //   16828	16837	16790	java/lang/Exception
    //   16842	16853	16790	java/lang/Exception
    //   16853	16896	16790	java/lang/Exception
    //   16900	16916	16790	java/lang/Exception
    //   16842	16853	16899	java/lang/Throwable
    //   16949	16982	16984	java/lang/Exception
    //   17146	17198	17221	java/lang/Exception
    //   17201	17219	17221	java/lang/Exception
    //   17259	17289	17221	java/lang/Exception
    //   17451	17502	17541	java/lang/Exception
    //   17502	17526	17541	java/lang/Exception
    //   17526	17539	17541	java/lang/Exception
    //   11006	11016	17586	java/lang/Throwable
    //   9451	9462	17591	java/lang/Throwable
    //   3668	3702	17595	java/lang/Exception
    //   3706	3740	17600	java/lang/Exception
  }
  
  private tov b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.a.a(acrf.dC(paramInt)).a(acrf.gH(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  private boolean c(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    long l1 = aqoj.getLongData(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = aqoj.getLongData(paramArrayOfByte, 5);
      long l3 = aqoj.getLongData(paramArrayOfByte, 9);
      int i = aqoj.c(paramArrayOfByte, 13);
      paramArrayOfByte = aqoj.a(paramArrayOfByte, 15, i);
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.app.getManager(52)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  private void f(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new cmd0x2dc.GroupVisitorJoinMsg();
    try
    {
      cmd0x2dc.GroupVisitorJoinMsg localGroupVisitorJoinMsg = (cmd0x2dc.GroupVisitorJoinMsg)((cmd0x2dc.GroupVisitorJoinMsg)localObject).mergeFrom(paramArrayOfByte);
      long l = localGroupVisitorJoinMsg.uint64_group_code.get();
      paramArrayOfByte = localGroupVisitorJoinMsg.rpt_msg_visitor_join_info.get();
      int i;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
      {
        localObject = this.app.getCurrentAccountUin();
        if (((HotChatManager)this.app.getManager(60)).kj(String.valueOf(l)))
        {
          Iterator localIterator = paramArrayOfByte.iterator();
          paramArrayOfByte = "";
          while (localIterator.hasNext())
          {
            cmd0x2dc.VisitorJoinInfo localVisitorJoinInfo = (cmd0x2dc.VisitorJoinInfo)localIterator.next();
            String str = "" + localVisitorJoinInfo.uint64_visitor_uin.get();
            if (!str.equalsIgnoreCase((String)localObject))
            {
              if (localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8().equals("")) {}
              for (paramArrayOfByte = paramArrayOfByte + str + "、";; paramArrayOfByte = paramArrayOfByte + localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8() + "、") {
                break;
              }
            }
          }
          localObject = paramArrayOfByte;
          if (paramArrayOfByte.length() > 1) {
            localObject = paramArrayOfByte.substring(0, paramArrayOfByte.length() - 1);
          }
          if (!localGroupVisitorJoinMsg.uint32_op_flag.has()) {
            break label394;
          }
          i = localGroupVisitorJoinMsg.uint32_op_flag.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "handleEnterOpenTroopHotChatPushMsg. groupCode=" + l + ", name=" + (String)localObject + ", op_flag=" + i);
          }
          if (paramInt != 11) {
            break label399;
          }
          paramArrayOfByte = (String)localObject + this.app.getApplication().getString(2131694649);
        }
      }
      for (;;)
      {
        acqn.a(this.app, String.valueOf(l), paramArrayOfByte, 1, false, true);
        return;
        label394:
        i = 0;
        break;
        label399:
        paramArrayOfByte = (byte[])localObject;
        if (paramInt == 13) {
          if (1 == i) {
            paramArrayOfByte = (String)localObject + this.app.getApplication().getString(2131694671);
          } else {
            paramArrayOfByte = (String)localObject + this.app.getApplication().getString(2131694653);
          }
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private boolean fQ(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return true;
  }
  
  private boolean fR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean fS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void g(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject1 = new submsgtype0x31.MsgBody();
    int i;
    long l1;
    anxr localanxr;
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12017");
        paramArrayOfByte.put("fail_step", "msgbyod_null");
        paramArrayOfByte.put("fail_location", "MessageHandler");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        long l2;
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramArrayOfByte);
            }
            paramArrayOfByte = null;
          }
          if ((!paramArrayOfByte.uint32_flag.has()) || (!paramArrayOfByte.uint64_bind_uin.has()) || (!paramArrayOfByte.uint64_uin.has()))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uinflag_null");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
          i = paramArrayOfByte.uint32_flag.get();
          l1 = paramArrayOfByte.uint32_time.get();
          l1 = paramArrayOfByte.uint64_uin.get();
          l2 = paramArrayOfByte.uint64_bind_uin.get();
          if ((l1 <= 0L) || (l2 <= 0L))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uin_error");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
        } while (!String.valueOf(paramLong).equalsIgnoreCase(this.app.getAccount()));
        paramArrayOfByte = new anxs();
        paramArrayOfByte.aQf = String.valueOf(l1);
        paramArrayOfByte.aLa = String.valueOf(l2);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", "12018");
        ((HashMap)localObject1).put("fail_step", "success_" + i);
        ((HashMap)localObject1).put("fail_location", "MessageHandler");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBPushNotifaction", true, 0L, 0L, (HashMap)localObject1, "");
        localObject1 = (anxk)this.app.getManager(62);
        if (i == 1)
        {
          anxk.a(this.app, (byte)0, paramArrayOfByte.aQf);
          anxk.aJ(this.app, paramArrayOfByte.aQf);
          paramArrayOfByte.errorType = 1;
          ((anxk)localObject1).a(paramArrayOfByte.aQf, 1);
          b(8004, true, paramArrayOfByte);
          return;
        }
      } while (i != 0);
      localObject1 = String.valueOf(l1);
      localanxr = (anxr)this.app.getManager(61);
      paramArrayOfByte.RF((String)localObject1);
      localanxr.a(paramArrayOfByte);
      Object localObject2 = paramArrayOfByte.dM();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint is new,msg num=1, subUin=" + str);
          }
          i = 1 - this.app.a().A(str, 7000);
          if (i != 0) {
            this.app.a().G(str, 7000, i);
          }
        }
      }
      boolean bool = false;
      localObject2 = anxk.b(this.app, (String)localObject1);
      if (localObject2 != null) {
        bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      }
      if (!bool) {
        break label782;
      }
    }
    localanxr.am((String)localObject1, 1);
    this.app.getSubAccountKey(this.app.getAccount(), String.valueOf(l1), new tou(this, localanxr));
    for (;;)
    {
      paramArrayOfByte.errorType = 0;
      b(8004, true, paramArrayOfByte);
      return;
      label782:
      if (localanxr.am(String.valueOf(l1), 2))
      {
        i = 1 - this.app.a().A((String)localObject1, 7000);
        if (i != 0)
        {
          this.app.a().G((String)localObject1, 7000, i);
          this.app.b().as(new String[] { acbn.bku, localObject1 });
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint need to verify,msg num=1, subUin=" + (String)localObject1);
        }
      }
    }
  }
  
  private void zA(int paramInt)
  {
    ((acle)this.app.getBusinessHandler(13)).JK(paramInt);
  }
  
  public boolean Oo()
  {
    return ((this.app.isBackground_Pause) || (this.app.isBackground_Stop)) && (this.app.cxj == 0);
  }
  
  public void Z(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new SubMsgType0x27.MsgBody();
    acff localacff;
    TroopManager localTroopManager;
    acja localacja;
    abhh localabhh;
    int j;
    Friends[] arrayOfFriends;
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
              try
              {
                paramArrayOfByte = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
                if (paramArrayOfByte == null) {
                  break;
                }
                localacff = (acff)this.app.getManager(51);
                localTroopManager = (TroopManager)this.app.getManager(52);
                localacja = (acja)this.app.getManager(56);
                localabhh = (abhh)this.app.getManager(153);
                j = 0;
                paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get();
                arrayOfFriends = new Friends[paramArrayOfByte.size()];
                new ArrayList();
                Iterator localIterator = paramArrayOfByte.iterator();
                if (!localIterator.hasNext()) {
                  break label7773;
                }
                paramArrayOfByte = (SubMsgType0x27.ForwardBody)localIterator.next();
                if ((paramArrayOfByte.uint32_notify_type.has()) && (paramArrayOfByte.uint32_notify_type.get() == 1))
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("cardpush", 2, "push a no content，如何处理？");
                  continue;
                }
                if (!paramArrayOfByte.uint32_op_type.has()) {
                  continue;
                }
              }
              catch (Exception paramArrayOfByte)
              {
                paramArrayOfByte.printStackTrace();
                return;
              }
              switch (paramArrayOfByte.uint32_op_type.get())
              {
              case 60: 
              case 61: 
              case 202: 
              default: 
                break;
              case 0: 
                if (paramArrayOfByte.msg_add_group.has())
                {
                  localObject1 = (SubMsgType0x27.AddGroup)paramArrayOfByte.msg_add_group.get();
                  paramArrayOfByte = new Groups();
                  if (((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.has()) {
                    paramArrayOfByte.group_id = ((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.get();
                  }
                  if (((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.has()) {
                    paramArrayOfByte.group_name = ((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.get().toStringUtf8();
                  }
                  if (((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.has()) {
                    paramArrayOfByte.seqid = ((byte)((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.get());
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a AddGroup  = id:" + paramArrayOfByte.group_id + " name : " + paramArrayOfByte.group_name + " sortid: " + paramArrayOfByte.seqid);
                  }
                  localacff.a(paramArrayOfByte);
                  localObject1 = new AddGroupResp();
                  ((AddGroupResp)localObject1).dwToUin = Long.valueOf(this.app.getAccount()).longValue();
                  ((AddGroupResp)localObject1).dwSequence = paramArrayOfByte.seqid;
                  ((AddGroupResp)localObject1).cGroupId = ((byte)paramArrayOfByte.group_id);
                  ((AddGroupResp)localObject1).cSortId = paramArrayOfByte.seqid;
                  paramArrayOfByte = new GroupActionResp(0, "", (AddGroupResp)localObject1);
                  this.app.getBusinessHandler(1).notifyUI(18, true, paramArrayOfByte);
                }
                break;
              case 1: 
                if (paramArrayOfByte.msg_del_group.has())
                {
                  localObject1 = (SubMsgType0x27.DelGroup)paramArrayOfByte.msg_del_group.get();
                  if (((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.has())
                  {
                    localObject2 = localacff.a(((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get() + "");
                    if (QLog.isColorLevel()) {
                      QLog.d("cardpush", 2, "push a DelGroup  = id:" + ((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                    }
                    paramArrayOfByte = new DelGroupResp();
                    paramArrayOfByte.dwToUin = Long.valueOf(this.app.getAccount()).longValue();
                    paramArrayOfByte.dwSequence = ((Groups)localObject2).seqid;
                    paramArrayOfByte.cGroupid = ((byte)((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                    localObject1 = new GroupActionResp(0, "", paramArrayOfByte);
                    ((FriendListHandler)this.app.getBusinessHandler(1)).a(paramArrayOfByte, true, (GroupActionResp)localObject1);
                  }
                }
                break;
              }
            }
          } while (!paramArrayOfByte.msg_mod_group_name.has());
          localObject1 = (SubMsgType0x27.ModGroupName)paramArrayOfByte.msg_mod_group_name.get();
        } while ((!((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.has()) || (!((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.has()));
        i = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
        localObject2 = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
        paramArrayOfByte = localacff.a(String.valueOf(i));
        if (paramArrayOfByte != null) {}
        for (paramArrayOfByte.group_name = ((String)localObject2);; paramArrayOfByte.group_name = ((String)localObject2))
        {
          localacff.a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupName  = id:" + ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get() + " name:" + ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          }
          paramArrayOfByte = new RenameGroupResp();
          paramArrayOfByte.dwToUin = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          i = (byte)((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          paramArrayOfByte.sGroupName = new String(((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          paramArrayOfByte = new GroupActionResp(0, "", paramArrayOfByte);
          this.app.getBusinessHandler(1).notifyUI(19, true, paramArrayOfByte);
          break;
          paramArrayOfByte = new Groups();
          paramArrayOfByte.group_id = i;
        }
      } while (!paramArrayOfByte.msg_mod_group_sort.has());
      localObject2 = ((SubMsgType0x27.ModGroupSort)paramArrayOfByte.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
    } while (localObject2 == null);
    paramArrayOfByte = new byte[((List)localObject2).size()];
    localObject1 = new byte[((List)localObject2).size()];
    Object localObject2 = ((List)localObject2).iterator();
    int i = 0;
    label1208:
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (SubMsgType0x27.GroupSort)((Iterator)localObject2).next();
      if ((!((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.has()) || (!((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.has())) {
        break label7801;
      }
      paramArrayOfByte[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get());
      localObject1[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get() + " sortid:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
      }
      i += 1;
    }
    label1408:
    label2070:
    label6456:
    label7773:
    label7801:
    for (;;)
    {
      break label1208;
      this.app.getBusinessHandler(1).notifyUI(22, true, null);
      localacff.c(paramArrayOfByte, (byte[])localObject1);
      break;
      if (!paramArrayOfByte.msg_mod_friend_group.has()) {
        break;
      }
      paramArrayOfByte = ((SubMsgType0x27.ModFriendGroup)paramArrayOfByte.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte.iterator();
      do
      {
        if (!paramArrayOfByte.hasNext()) {
          break;
        }
        localObject1 = (SubMsgType0x27.FriendGroup)paramArrayOfByte.next();
      } while ((!((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.has()) || (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get().size() <= 0));
      long l1 = ((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.get();
      int k = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get(0)).intValue();
      if (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get().size() > 0) {}
      for (i = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get(0)).intValue();; i = 0)
      {
        localacff.dw(l1 + "", k);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l1 + " newgroupid:" + k);
        }
        this.app.getBusinessHandler(1).notifyUI(9, true, new Object[] { l1 + "", Byte.valueOf((byte)k), Byte.valueOf((byte)i) });
        break label1408;
        if (!paramArrayOfByte.msg_del_friend.has()) {
          break;
        }
        localObject1 = ((SubMsgType0x27.DelFriend)paramArrayOfByte.msg_del_friend.get()).rpt_uint64_uins.get();
        paramArrayOfByte = (plz)this.app.getManager(253);
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label2070;
          }
          l1 = ((Long)((Iterator)localObject1).next()).longValue();
          localacff.yZ(l1 + "");
          localacja.Ez(l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1);
          }
          try
          {
            localObject2 = (asgx)this.app.getManager(165);
            if ((localObject2 != null) && (((asgx)localObject2).sH(l1 + "")))
            {
              this.app.a().a().bR(String.valueOf(l1), true);
              localObject2 = this.app.getApplication().getBaseContext().getSharedPreferences(this.app.getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
              ((SharedPreferences.Editor)localObject2).putBoolean(this.app.getCurrentAccountUin() + "_" + l1 + "", false);
              ((SharedPreferences.Editor)localObject2).commit();
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1 + " error :" + localException2.toString());
              }
            }
          }
          this.app.getBusinessHandler(1).notifyUI(15, true, Long.valueOf(l1));
          localObject2 = String.valueOf(l1);
          paramArrayOfByte.qM((String)localObject2);
          aluu.aB(this.app, (String)localObject2);
        }
        paramArrayOfByte = (PhoneContactManagerImp)this.app.getManager(11);
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte.clH();
        break;
        Object localObject6;
        Object localObject7;
        if (paramArrayOfByte.msg_mod_friend_rings.has())
        {
          localObject1 = ((SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject1).next();
            localObject4 = ((SubMsgType0x27.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject6 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject4).next();
              i = ((SubMsgType0x27.SnsUpdateItem)localObject6).uint32_update_sns_type.get();
              if ((i == 13569) && (((SubMsgType0x27.SnsUpateBuffer)localObject3).uint32_result.get() == 0))
              {
                localObject5 = localTroopManager.jp(Long.valueOf(((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_uin.get()).toString());
                i = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().size();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 4, "ONLine push commonTroop troopUin=" + (String)localObject5 + " status=" + i);
                }
                if (i == 0)
                {
                  if (localTroopManager.kw((String)localObject5)) {
                    this.app.getBusinessHandler(22).notifyUI(18, true, new Object[] { localObject5, Integer.valueOf(1), Integer.valueOf(0), null });
                  }
                }
                else if (i >= 4)
                {
                  localObject6 = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().toByteArray();
                  localObject7 = new byte[4];
                  System.arraycopy(localObject6, 0, localObject7, 0, 4);
                  if (localTroopManager.n((String)localObject5, achp.c((byte[])localObject7))) {
                    this.app.getBusinessHandler(22).notifyUI(18, true, new Object[] { localObject5, Integer.valueOf(0), Integer.valueOf(0), null });
                  }
                }
              }
              else if (i == 13571)
              {
                l1 = ((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_uin.get();
                l2 = ((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_code.get();
                Long.valueOf(l1).toString();
                localObject5 = String.valueOf(Long.valueOf(l2));
                i = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().size();
                localObject6 = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().toByteArray();
                if (i >= 6)
                {
                  if ((localObject6[0] != 1) || (localObject6[0] == 0)) {}
                  i = localObject6[1];
                  if (i == 1)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinePush, oprerate external show troop...");
                    }
                    localObject7 = new byte[4];
                    System.arraycopy(localObject6, 2, localObject7, 0, 4);
                    if (localTroopManager.o((String)localObject5, achp.c((byte[])localObject7))) {
                      this.app.getBusinessHandler(20).notifyUI(54, true, new Object[] { localObject5, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                    }
                  }
                  if ((i == 0) && (localTroopManager.ky((String)localObject5))) {
                    this.app.getBusinessHandler(20).notifyUI(54, true, new Object[] { localObject5, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                  }
                }
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_friend_rings.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get();
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.rpt_msg_sns_general_infos.has())) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_sns_general_infos.get();
        Object localObject3 = new HashMap();
        localObject4 = paramArrayOfByte.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          paramArrayOfByte = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject4).next();
          if ((paramArrayOfByte != null) && (paramArrayOfByte.uint64_uin.has()) && (paramArrayOfByte.rpt_msg_sns_update_item.has()))
          {
            l1 = paramArrayOfByte.uint64_uin.get();
            localObject5 = String.valueOf(l1);
            localObject6 = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject6).next();
              if ((localObject7 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.has()) && (!FriendsStatusUtil.a((SubMsgType0x27.SnsUpdateItem)localObject7, this.app, (String)localObject5)))
              {
                if (((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get() == 13568) {
                  abbf.a((String)localObject5, ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8(), this.app);
                }
                localObject1 = (SpecialCareInfo)((HashMap)localObject3).get(localObject5);
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  localObject1 = localacff.a(String.valueOf(l1));
                  paramArrayOfByte = (byte[])localObject1;
                  if (localObject1 == null)
                  {
                    paramArrayOfByte = new SpecialCareInfo();
                    paramArrayOfByte.uin = String.valueOf(String.valueOf(l1));
                  }
                  ((HashMap)localObject3).put(paramArrayOfByte.uin, paramArrayOfByte);
                }
                i = ((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get();
                localObject1 = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8();
                FriendListHandler.a(paramArrayOfByte, i, (String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 uin=" + paramArrayOfByte.uin + ", itemtype=" + i + ",itemVal=" + (String)localObject1);
                }
              }
            }
          }
        }
        paramArrayOfByte = ((HashMap)localObject3).entrySet().iterator();
        localObject1 = new ArrayList();
        while (paramArrayOfByte.hasNext())
        {
          localObject3 = (SpecialCareInfo)((Map.Entry)paramArrayOfByte.next()).getValue();
          if ((localObject3 != null) && ((((SpecialCareInfo)localObject3).getStatus() != 1000) || (((SpecialCareInfo)localObject3).globalSwitch != 0))) {
            ((List)localObject1).add(localObject3);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=" + ((List)localObject1).size());
        }
        localacff.iO((List)localObject1);
        if (((List)localObject1).size() <= 0) {
          break;
        }
        this.app.getBusinessHandler(1).notifyUI(99, true, new Object[] { Boolean.valueOf(true), localObject1 });
        break;
        if (!paramArrayOfByte.msg_mod_friend_flag.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.SnsUpdateFlag)paramArrayOfByte.msg_mod_friend_flag.get();
        if (!paramArrayOfByte.rpt_msg_update_sns_flag.has()) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_update_sns_flag.get().iterator();
        do
        {
          do
          {
            if (!paramArrayOfByte.hasNext()) {
              break;
            }
            localObject1 = (SubMsgType0x27.SnsUpdateOneFlag)paramArrayOfByte.next();
            l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64__uin.get();
            i = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint32_flag.get();
            l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + i + " id:" + l2);
            }
          } while (l2 != 4051L);
          localObject1 = localacff.e(String.valueOf(l1));
        } while (localObject1 == null);
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((Friends)localObject1).setShieldFlag(bool);
          localacff.e((Friends)localObject1);
          this.app.getBusinessHandler(1).notifyUI(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
          break;
        }
        if (!paramArrayOfByte.msg_mod_profile.has()) {
          break;
        }
        j = a(paramArrayOfByte, localacff, localTroopManager, null, localabhh, arrayOfFriends, j);
        break;
        if (!paramArrayOfByte.msg_mod_custom_face.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModCustomFace)paramArrayOfByte.msg_mod_custom_face.get();
        if ((!((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.has()) || (!((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.has())) {
          break;
        }
        paramArrayOfByte = (FriendListHandler)this.app.getBusinessHandler(1);
        if (((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.get() == 0)
        {
          l1 = ((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.get();
          localObject1 = Long.toString(l1);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l1);
          }
          paramArrayOfByte.DH((String)localObject1);
          this.app.getBusinessHandler(1).notifyUI(3, true, localObject1);
          break;
        }
        if (((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.get() != 1) {
          break;
        }
        l1 = ((SubMsgType0x27.ModCustomFace)localObject1).uint64_group_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l1);
        }
        localObject1 = localTroopManager.b(String.valueOf(l1));
        ((TroopInfo)localObject1).hasSetNewTroopHead = true;
        localTroopManager.i((TroopInfo)localObject1);
        paramArrayOfByte.DI(Long.toString(l1));
        break;
        if (!paramArrayOfByte.msg_daren_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.DaRenNotify)paramArrayOfByte.msg_daren_notify.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        i = paramArrayOfByte.uint32_login_days.get();
        k = paramArrayOfByte.uint32_days.get();
        if (this.app.getCurrentAccountUin().equals(String.valueOf(l1)))
        {
          paramArrayOfByte = localacff.c(this.app.getCurrentAccountUin());
          if ((i != paramArrayOfByte.lLoginDays) || (k != paramArrayOfByte.lQQMasterLogindays))
          {
            paramArrayOfByte.lLoginDays = i;
            paramArrayOfByte.lQQMasterLogindays = k;
            localacff.a(paramArrayOfByte);
            this.app.getBusinessHandler(2).notifyUI(1, true, paramArrayOfByte);
          }
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "daren notify received local data logindays=" + paramArrayOfByte.lLoginDays + ";days=" + paramArrayOfByte.lQQMasterLogindays);
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cardpush", 2, "daren notify received uin=" + l1 + ";logindays=" + i + ";days=" + k);
        break;
        if (!paramArrayOfByte.msg_mod_friend_remark.has()) {
          break;
        }
        localObject1 = ((SubMsgType0x27.ModFriendRemark)paramArrayOfByte.msg_mod_friend_remark.get()).rpt_msg_frd_rmk.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (SubMsgType0x27.FriendRemark)((Iterator)localObject1).next();
          if (((SubMsgType0x27.FriendRemark)localObject3).uint32_type.has()) {
            if (((SubMsgType0x27.FriendRemark)localObject3).uint32_type.get() == 0)
            {
              l1 = ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get();
              localObject4 = localacff.e(Long.toString(l1));
              paramArrayOfByte = null;
              if (localObject4 != null) {
                paramArrayOfByte = ((Friends)localObject4).remark;
              }
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "备注 = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + ",oldRemark = " + paramArrayOfByte);
              }
              localacff.b(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8());
              localObject5 = localacff.b(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "");
              localObject6 = ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8();
              if ((localObject5 != null) && (!((String)localObject6).equals(((Card)localObject5).strReMark)))
              {
                ((Card)localObject5).strReMark = ((String)localObject6);
                localacff.a((Card)localObject5);
              }
              if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (ackd.az((String)localObject6, paramArrayOfByte))) {
                ackd.b(l1, (String)localObject6, (acdu)this.app.getManager(53));
              }
              this.app.getBusinessHandler(1).notifyUI(3, true, Long.toString(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get()));
              this.app.getBusinessHandler(1).notifyUI(27, true, new Object[] { ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
              TroopNameHelper.TV(Long.toString(l1));
            }
            else if (((SubMsgType0x27.FriendRemark)localObject3).uint32_type.get() == 1)
            {
              if (((SubMsgType0x27.FriendRemark)localObject3).uint64_group_code.has())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remarkuin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + " troopcode = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_group_code.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remark uin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_rich_long_nick_ex.has()) {
          break;
        }
        Object localObject5 = (SubMsgType0x27.ModLongNick)paramArrayOfByte.msg_mod_rich_long_nick_ex.get();
        localObject3 = Long.toString(((SubMsgType0x27.ModLongNick)localObject5).uint64_uin.get());
        paramArrayOfByte = ByteBuffer.wrap(((SubMsgType0x27.ModLongNick)localObject5).bytes_value.get().toByteArray());
        l1 = paramArrayOfByte.getLong();
        localObject4 = new byte[paramArrayOfByte.remaining()];
        paramArrayOfByte.get((byte[])localObject4);
        localObject1 = localacff.a((String)localObject3);
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1 == null)
        {
          paramArrayOfByte = new ExtensionInfo();
          paramArrayOfByte.uin = ((String)localObject3);
        }
        paramArrayOfByte.setRichBuffer((byte[])localObject4, l1);
        paramArrayOfByte.isAdded2C2C = SignatureManager.a(this.app, (String)localObject3, paramArrayOfByte.getRichStatus());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "insertSignMsgIfNeeded from OnLinePush uin = " + (String)localObject3 + " result =  " + paramArrayOfByte.isAdded2C2C);
        }
        localacff.a(paramArrayOfByte);
        paramArrayOfByte = localacff.b(((SubMsgType0x27.ModLongNick)localObject5).uint64_uin.get() + "");
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.vRichSign = ((byte[])localObject4);
          paramArrayOfByte.lSignModifyTime = l1;
          localacff.a(paramArrayOfByte);
        }
        this.app.getBusinessHandler(1).notifyUI(3, true, localObject3);
        this.app.getBusinessHandler(1).notifyUI(2, true, new String[] { localObject3 });
        break;
        if (!paramArrayOfByte.msg_mod_group_profile.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModGroupProfile)paramArrayOfByte.msg_mod_group_profile.get();
        paramArrayOfByte.uint64_cmd_uin.get();
        if (!paramArrayOfByte.uint64_group_code.has()) {
          break;
        }
        l1 = paramArrayOfByte.uint64_group_uin.get();
        long l2 = paramArrayOfByte.uint64_group_code.get();
        for (;;)
        {
          try
          {
            paramArrayOfByte = paramArrayOfByte.rpt_msg_group_profile_infos.get().iterator();
            if (!paramArrayOfByte.hasNext()) {
              break;
            }
            localObject1 = (SubMsgType0x27.GroupProfileInfo)paramArrayOfByte.next();
            if ((!((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.has()) || (!((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.has())) {
              continue;
            }
            if (((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.get() == 1)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("cardpush", 2, "push a ModGroupProfile 1--TroopName  = " + ((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.get().toStringUtf8());
              continue;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
          }
          if (((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.get() == 2)
          {
            localObject1 = ((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.get();
            if ((localObject1 != null) && (((ByteStringMicro)localObject1).size() == 2))
            {
              i = ((ByteStringMicro)localObject1).byteAt(0);
              short s = (short)(((ByteStringMicro)localObject1).byteAt(1) | i << 8);
              localObject1 = localTroopManager.b(l1 + "");
              ((TroopInfo)localObject1).troopface = s;
              ((TroopInfo)localObject1).hasSetNewTroopHead = true;
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupProfile 2--TroopHead(2bytes) = " + s);
              }
              localTroopManager.i((TroopInfo)localObject1);
              ((FriendListHandler)this.app.getBusinessHandler(1)).DI(l1 + "");
            }
          }
          else if (((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.get() == 3)
          {
            localObject1 = ((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange:" + l1 + "," + l2 + "," + (String)localObject1);
            }
            localObject3 = localTroopManager.b(l2 + "");
            if (localObject3 != null)
            {
              ((TroopInfo)localObject3).troopCreditLevel = Long.valueOf((String)localObject1).longValue();
              localTroopManager.i((TroopInfo)localObject3);
              if (QLog.isColorLevel()) {
                QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange, save");
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_group_member_profile.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModGroupMemberProfile)paramArrayOfByte.msg_mod_group_member_profile.get();
        if ((!((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.has()) || (!((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.has())) {
          break;
        }
        l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.get();
        l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.get();
        long l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_uin.get();
        paramArrayOfByte = aqgx.a().a(this.app, l2 + "", l3 + "");
        localObject1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).rpt_msg_group_member_profile_infos.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject1).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.has()))
          {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() != 1) {
              break label5907;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size());
            }
            ackd.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size());
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte.colorNick = aqpm.f(((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get());
              paramArrayOfByte.name = aqpm.pQ(paramArrayOfByte.colorNick);
              localTroopManager.a(l1 + "", l3 + "", paramArrayOfByte.colorNick, -100, null, null, -100, -100, -100, -100L, -100L);
            }
          }
          for (;;)
          {
            if (paramArrayOfByte == null) {
              break label6456;
            }
            aqgx.a().a(this.app, paramArrayOfByte);
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(paramArrayOfByte);
            this.app.getBusinessHandler(20).notifyUI(16, true, localObject3);
            this.app.getBusinessHandler(20).notifyUI(11, true, new Object[] { localObject3, Boolean.valueOf(true) });
            break;
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 2)
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size() == 1)
              {
                byte b = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().byteAt(0);
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 2--sex = " + b);
                }
                localTroopManager.a(l1 + "", l3 + "", null, -100, null, null, -100, b, -100, -100L, -100L);
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.sex = b;
                }
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 3)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 3--phone = " + (String)localObject3);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.tel = ((String)localObject3);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 4)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 4--email= " + (String)localObject3);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.email = ((String)localObject3);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 5)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 5--remark= " + (String)localObject3);
              }
              ((TroopManager)this.app.getManager(52)).a(l1 + "", l3 + "", null, -100, null, (String)localObject3, -100, -100, -100, -100L, -100L);
              if (paramArrayOfByte != null) {
                paramArrayOfByte.memo = ((String)localObject3);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 6)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 6--job= " + (String)localObject3);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.job = ((String)localObject3);
              }
            }
            else if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 7) && (paramArrayOfByte != null))
            {
              paramArrayOfByte.colorNick = aqpm.f(((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get());
              paramArrayOfByte.name = aqpm.pQ(paramArrayOfByte.colorNick);
            }
          }
        }
        if (!paramArrayOfByte.msg_appointment_notify.has()) {
          break;
        }
        localObject5 = (SubMsgType0x27.AppointmentNotify)paramArrayOfByte.msg_appointment_notify.get();
        if (!((SubMsgType0x27.AppointmentNotify)localObject5).uint32_notifytype.has()) {
          break;
        }
        l1 = ((SubMsgType0x27.AppointmentNotify)localObject5).uint32_notifytype.get();
        if ((l1 == 2L) || (l1 == 4L) || (l1 == 5L) || ((l1 == 6L) && (((SubMsgType0x27.AppointmentNotify)localObject5).bytes_feed_event_info.has())))
        {
          this.app.a().a((SubMsgType0x27.AppointmentNotify)localObject5);
          break;
        }
        if (((l1 != 0L) && (l1 != 1L) && (l1 != 3L)) || (!((SubMsgType0x27.AppointmentNotify)localObject5).uint64_from_uin.has())) {
          break;
        }
        l2 = ((SubMsgType0x27.AppointmentNotify)localObject5).uint64_from_uin.get();
        localObject1 = null;
        localObject3 = this.app.getCurrentAccountUin();
        localObject4 = Long.toString(l2);
        if (l1 == 0L) {}
        for (paramArrayOfByte = (byte[])localObject3;; paramArrayOfByte = (byte[])localObject4)
        {
          if (((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.has()) {
            localObject1 = ((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.get();
          }
          localObject5 = new ArrayList();
          localObject6 = anbi.d(-1024);
          l2 = anaz.gQ();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handle date push friendUin=" + (String)localObject4 + ",senderUin=" + paramArrayOfByte + ",notifytype=" + l1);
          }
          ((MessageRecord)localObject6).init((String)localObject3, (String)localObject4, paramArrayOfByte, (String)localObject1, l2, -1024, 1010, l2);
          ((MessageRecord)localObject6).isread = false;
          if (l1 == 0L)
          {
            ((MessageRecord)localObject6).issend = 1;
            ((MessageRecord)localObject6).isread = true;
          }
          ((ArrayList)localObject5).add(localObject6);
          this.app.b().b((MessageRecord)localObject6, ((MessageRecord)localObject6).selfuin);
          a("handleMsgType0x210SubMsgType0x27", true, (List)localObject5, false, false);
          break;
          if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject5).bytes_sig.has()))
          {
            paramArrayOfByte = ((SubMsgType0x27.AppointmentNotify)localObject5).bytes_sig.get().toByteArray();
            if (paramArrayOfByte != null) {
              this.app.a().w((String)localObject4, paramArrayOfByte);
            }
          }
        }
        if (!paramArrayOfByte.bytes_redpoint_info.has()) {
          break;
        }
        ((akjp)this.app.getManager(160)).bn(paramArrayOfByte.bytes_redpoint_info.get().toByteArray());
        break;
        if (!paramArrayOfByte.msg_push_search_dev.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.PushSearchDev)paramArrayOfByte.msg_push_search_dev.get();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("optype", 200);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject1).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.uint32_dev_time.has()) {
          ((Bundle)localObject1).putInt("devtime", paramArrayOfByte.uint32_dev_time.get());
        }
        if (paramArrayOfByte.uint64_din.has()) {
          ((Bundle)localObject1).putLong("din", paramArrayOfByte.uint64_din.get());
        }
        if (paramArrayOfByte.str_data.has()) {
          ((Bundle)localObject1).putString("data", paramArrayOfByte.str_data.get());
        }
        ((syw)this.app.getBusinessHandler(51)).l(39, (Bundle)localObject1);
        break;
        if (!paramArrayOfByte.msg_push_report_dev.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.PushReportDev)paramArrayOfByte.msg_push_report_dev.get();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("optype", 201);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject1).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.bytes_cookie.has()) {
          ((Bundle)localObject1).putString("cookie", paramArrayOfByte.bytes_cookie.get().toStringUtf8());
        }
        if (paramArrayOfByte.uint32_report_max_num.has()) {
          ((Bundle)localObject1).putInt("count", paramArrayOfByte.uint32_report_max_num.get());
        }
        if (paramArrayOfByte.bytes_sn.has()) {
          ((Bundle)localObject1).putString("sn", paramArrayOfByte.bytes_sn.get().toStringUtf8());
        }
        ((syw)this.app.getBusinessHandler(51)).l(39, (Bundle)localObject1);
        break;
        if (!paramArrayOfByte.msg_new_comein_user_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.NewComeinUserNotify)paramArrayOfByte.msg_new_comein_user_notify.get();
        if (paramArrayOfByte.uint32_msg_type.has()) {}
        for (i = paramArrayOfByte.uint32_msg_type.get();; i = -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg0x210submsg0x27 face2face add friend push, type:" + i);
          }
          if (i == 1)
          {
            localObject1 = (acgr)this.app.getBusinessHandler(3);
            if (localObject1 == null) {
              break;
            }
            ((acgr)localObject1).a(paramArrayOfByte);
            break;
          }
          if ((i != 2) && (i != 3)) {
            break;
          }
          localObject1 = (acia)this.app.getBusinessHandler(57);
          if (localObject1 == null) {
            break;
          }
          ((acia)localObject1).a(i, paramArrayOfByte);
          break;
          paramArrayOfByte = (SubMsgType0x27.PraiseRankNotify)paramArrayOfByte.msg_praise_rank_notify.get();
          if (paramArrayOfByte.str_msg.has()) {}
          for (paramArrayOfByte = paramArrayOfByte.str_msg.get();; paramArrayOfByte = null)
          {
            for (;;)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "praise rank notify: " + paramArrayOfByte);
                }
                if (TextUtils.isEmpty(paramArrayOfByte)) {
                  break;
                }
                localObject1 = aqcu.decodeResource(this.app.getApp().getResources(), 2130840732);
                localObject3 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
                localObject4 = new Intent(this.app.getApp(), LikeRankingListActivity.class);
                ((Intent)localObject4).putExtra("param_from", 1);
                ((Intent)localObject4).addFlags(67108864);
                ((ToServiceMsg)localObject3).extraData.putStringArray("cmds", new String[] { "QQ", "QQ", paramArrayOfByte });
                ((ToServiceMsg)localObject3).extraData.putParcelable("intent", (Parcelable)localObject4);
                ((ToServiceMsg)localObject3).extraData.putParcelable("bitmap", (Parcelable)localObject1);
                this.app.sendToService((ToServiceMsg)localObject3);
                this.app.reportClickEvent("dc00898", "0X8007618");
                break;
                try
                {
                  paramArrayOfByte = (SubMsgType0x27.MQQCampusNotify)paramArrayOfByte.msg_campus_notify.get();
                  if (paramArrayOfByte == null) {
                    break;
                  }
                  ((aeam)this.app.getManager(240)).a(paramArrayOfByte);
                }
                catch (Exception paramArrayOfByte) {}
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.MQQCampusNotify fail", paramArrayOfByte);
              break;
              try
              {
                for (;;)
                {
                  if ((SubMsgType0x27.ChatMatchInfo)paramArrayOfByte.msg_chat_match_info.get() != null) {
                    QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
                  }
                  try
                  {
                    paramArrayOfByte = (SubMsgType0x27.FrdCustomOnlineStatusChange)paramArrayOfByte.msg_frd_custom_online_status_change.get();
                    if (paramArrayOfByte == null) {
                      break;
                    }
                    aqqb.b.a(paramArrayOfByte);
                    QLog.d("Q.msg.BaseMessageProcessorCustomOnlineStatus", 2, "SubMsgType0x27.FrdCustomOnlineStatusChange");
                  }
                  catch (Exception paramArrayOfByte) {}
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.FrdCustomOnlineStatusChange fail", paramArrayOfByte);
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.ChatMatchInfo fail", localException1);
                  }
                }
              }
            }
            localacff.a(arrayOfFriends, j);
            return;
          }
        }
      }
    }
  }
  
  protected long a(submsgtype0x26.MsgBody paramMsgBody)
  {
    long l2 = 0L;
    long l1 = l2;
    Object localObject1;
    int i;
    if (paramMsgBody.uint32_sub_cmd.get() == 1)
    {
      l1 = l2;
      if (paramMsgBody.rpt_msg_subcmd_0x1_push_body.has())
      {
        localObject1 = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
        l1 = 0L;
        i = 0;
        while (i < ((List)localObject1).size())
        {
          Object localObject2 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)((List)localObject1).get(i);
          if (((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).msg_app_id.uint64_app_id.get() == 101846662L)
          {
            l2 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).uint64_group_code.get();
            localObject2 = (apoz)this.app.getManager(355);
            l1 = l2;
            if (localObject2 != null)
            {
              ((apoz)localObject2).lQ(l2);
              l1 = l2;
            }
          }
          i += 1;
        }
      }
    }
    l2 = l1;
    if (paramMsgBody.uint32_sub_cmd.get() == 1)
    {
      l2 = l1;
      if (paramMsgBody.rpt_msg_subcmd_0x1_push_body.has())
      {
        paramMsgBody = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
        i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= paramMsgBody.size()) {
            break;
          }
          localObject1 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)paramMsgBody.get(i);
          l1 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject1).uint64_group_code.get();
          l2 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject1).msg_app_id.uint64_app_id.get();
          int j = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject1).sint32_unread_num.get();
          localObject1 = (apoz)this.app.getManager(355);
          if (localObject1 != null) {
            ((apoz)localObject1).r(l1, l2, j);
          }
          i += 1;
        }
      }
    }
    return l2;
  }
  
  protected void a(submsgtype0x26.MsgBody paramMsgBody)
  {
    if ((!paramMsgBody.msg_subcmd_0x3_push_body.has()) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
    }
    paramMsgBody = (submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo)paramMsgBody.msg_subcmd_0x3_push_body.get();
    if ((paramMsgBody.uint64_conf_uin.has()) && (paramMsgBody.msg_app_tip_notify.has()))
    {
      paramMsgBody.uint64_conf_uin.get();
      paramMsgBody = (submsgtype0x26.AppTipNotify)paramMsgBody.msg_app_tip_notify.get();
      if (paramMsgBody.bytes_text.has())
      {
        paramMsgBody = paramMsgBody.bytes_text.get().toByteArray();
        if (paramMsgBody.length > 0) {
          this.app.a().aC(paramMsgBody);
        }
      }
    }
  }
  
  public void a(SubMsgType0xa8.MsgBody paramMsgBody)
  {
    if (!Oo()) {
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, "handlePullActivePushMsg, isNeedNotifyActivePush is false");
      }
    }
    Object localObject1;
    Intent localIntent;
    int i;
    do
    {
      do
      {
        return;
        anot.a(this.app, "CliOper", "", "", "0X80065A9", "0X80065A9", 0, 0, "", "", "", "");
      } while (!paramMsgBody.bytes_msg_summary.has());
      localObject1 = paramMsgBody.bytes_msg_summary.get().toStringUtf8();
      localIntent = new Intent(this.app.getApp(), SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(335544320);
      i = paramMsgBody.uint32_action_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionType: %d, brief: %s", new Object[] { Integer.valueOf(i), localObject1 }));
      }
      if (i != 1) {
        break;
      }
    } while (!paramMsgBody.uint32_action_subType.has());
    int j = paramMsgBody.uint32_action_subType.get();
    localIntent.putExtra("extra_pull_active_push_type", i);
    localIntent.putExtra("extra_pull_active_push_subtype", j);
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionSubType: %d", new Object[] { Integer.valueOf(j) }));
    }
    paramMsgBody = "";
    for (;;)
    {
      localIntent.putExtra(aizc.bQj, (String)localObject1);
      localIntent.putExtra("activepull_push_flag", true);
      Object localObject2 = aizc.bQi;
      Object localObject3 = aqcu.decodeResource(this.app.getApp().getResources(), 2130840732);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
      localToServiceMsg.extraData.putStringArray("cmds", new String[] { localObject1, localObject2, localObject1 });
      localToServiceMsg.extraData.putParcelable("intent", localIntent);
      localToServiceMsg.extraData.putParcelable("bitmap", (Parcelable)localObject3);
      this.app.sendToService(localToServiceMsg);
      localObject1 = this.app.getApp().getBaseContext();
      if (!aqlr.isScreenLocked((Context)localObject1)) {
        break;
      }
      localObject2 = (aizc)this.app.getManager(145);
      ((aizc)localObject2).dA(localIntent);
      localObject3 = (aizf)this.app.getManager(72);
      if (SettingCloneUtil.readValue((Context)localObject1, this.app.getCurrentAccountUin(), ((Context)localObject1).getString(2131695500), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "handlePullActivePushMsg, start lsActivity");
        }
        ((aizf)localObject3).a(this.app, acbn.blt, 9653, false, aizb.a(paramMsgBody, 1008, localIntent));
      }
      this.app.b().as(((aizc)localObject2).a);
      return;
      if (i == 2)
      {
        if (!paramMsgBody.bytes_extend_content.has()) {
          break;
        }
        paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
        localIntent.putExtra("extra_pull_active_push_type", i);
        localIntent.putExtra("extra_pull_active_push_url", paramMsgBody);
        if (QLog.isColorLevel()) {
          QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: url: %s", new Object[] { paramMsgBody }));
        }
        paramMsgBody = "";
        continue;
      }
      if ((i != 3) || (!paramMsgBody.bytes_extend_content.has())) {
        break;
      }
      paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
      localIntent.putExtra("open_chatfragment", true);
      localIntent.putExtra("uin", paramMsgBody);
      localIntent.putExtra("param_fromuin", paramMsgBody);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("isforceRequestDetail", true);
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: public account uin: %s", new Object[] { paramMsgBody }));
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    boolean bool2 = true;
    Object localObject = new SubMsgType0xcb.MsgBody();
    label477:
    String str;
    try
    {
      ((SubMsgType0xcb.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (MessageForNearbyLiveTip)anbi.d(-2053);
      if (((SubMsgType0xcb.MsgBody)localObject).uint32_anchor_status.get() == 1)
      {
        bool1 = true;
        paramArrayOfByte.isLiving = bool1;
        paramArrayOfByte.jumpingUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_jump_schema.get().toStringUtf8();
        paramArrayOfByte.msg = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_wording.get().toStringUtf8();
        paramArrayOfByte.headUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_head_url.get().toStringUtf8();
        paramArrayOfByte.nickName = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_nickname.get().toStringUtf8();
        paramArrayOfByte.liveEndWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_end_wording.get().toStringUtf8();
        paramArrayOfByte.c2cMsgWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_c2c_msg_wording.get().toStringUtf8();
        paramArrayOfByte.startLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject).uint32_live_wording_type.get();
        paramArrayOfByte.endLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject).uint32_end_wording_type.get();
        paramArrayOfByte.time = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.msgseq = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.shmsgseq = paramMsgInfo.shMsgSeq;
        paramArrayOfByte.msgUid = paramMsgInfo.lMsgUid;
        paramArrayOfByte.selfuin = this.app.getCurrentAccountUin();
        paramArrayOfByte.istroop = 1001;
        paramArrayOfByte.senderuin = String.valueOf(paramMsgInfo.lFromUin + acbn.Pd);
        paramArrayOfByte.frienduin = String.valueOf(paramMsgInfo.lFromUin + acbn.Pd);
        paramArrayOfByte.getBytes();
        if (QLog.isColorLevel())
        {
          paramMsgInfo = new StringBuilder();
          paramMsgInfo.append("status=").append(paramArrayOfByte.isLiving).append("jumpingUrl=").append(paramArrayOfByte.jumpingUrl).append("liveWording=").append(paramArrayOfByte.msg).append("headUrl").append(paramArrayOfByte.headUrl).append("nickName").append(paramArrayOfByte.nickName).append("startLiveWordingType=").append(((SubMsgType0xcb.MsgBody)localObject).uint32_live_wording_type.get()).append("endLiveWordingType=").append(((SubMsgType0xcb.MsgBody)localObject).uint32_end_wording_type.get());
          QLog.i("Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
        }
        if ((!MessageForNearbyLiveTip.isHuayangTip(paramArrayOfByte.jumpingUrl)) || (MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramArrayOfByte.jumpingUrl))) {
          break label477;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg discard a not support huayang tips message, jumpUrl=" + paramArrayOfByte.jumpingUrl);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg decode failed" + paramArrayOfByte.toString());
            continue;
            bool1 = false;
          }
        }
        paramMsgInfo = new ArrayList();
      } while (achp.a(this.app, paramArrayOfByte, true));
      paramMsgInfo.add(paramArrayOfByte);
      boolean bool3 = paramArrayOfByte.senderuin.equals(String.valueOf(1822701914L + acbn.Pd));
      if (bool3) {
        paramArrayOfByte.isLiving = true;
      }
      if (paramArrayOfByte.isLiving)
      {
        bool2 = achp.F(paramMsgInfo);
        int i = top.a(paramMsgInfo, this.app);
        localObject = this.app.b();
        str = this.app.getCurrentAccountUin();
        if ((bool2) && (this.app.isBackground_Stop)) {}
        for (bool1 = true;; bool1 = false)
        {
          ((QQMessageFacade)localObject).c(paramMsgInfo, str, bool1);
          this.app.a().UG((int)paramArrayOfByte.time);
          if ((anwa.aze()) || (!bool3)) {
            break;
          }
          a("handleGetBuddyMessageResp", true, i, this.a.aO(bool2), false);
          return;
        }
      }
      localObject = this.app.b().a(paramArrayOfByte.frienduin, paramArrayOfByte.istroop);
      if (localObject != null)
      {
        this.app.b().c(paramArrayOfByte.frienduin, paramArrayOfByte.istroop, ((MessageRecord)localObject).uniseq, paramArrayOfByte.msgData);
        this.app.b().as(localObject);
        return;
      }
      bool1 = achp.F(paramMsgInfo);
      localObject = this.app.b();
      str = this.app.getCurrentAccountUin();
      if (!bool1) {
        break label786;
      }
    }
    if (this.app.isBackground_Stop) {}
    label786:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQMessageFacade)localObject).c(paramMsgInfo, str, bool1);
      this.app.a().UG((int)paramArrayOfByte.time);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7");
    }
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new submsgtype0xc7.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (submsgtype0xc7.MsgBody)((submsgtype0xc7.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get().iterator();
        if (!paramArrayOfByte.hasNext()) {
          break;
        }
        localObject = (submsgtype0xc7.ForwardBody)paramArrayOfByte.next();
        if ((!((submsgtype0xc7.ForwardBody)localObject).uint32_notify_type.has()) || (((submsgtype0xc7.ForwardBody)localObject).uint32_notify_type.get() != 1)) {
          break label133;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7 push a no content");
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramArrayOfByte) {}
      QLog.e("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7", paramArrayOfByte);
      return;
      label133:
      if (((submsgtype0xc7.ForwardBody)localObject).uint32_op_type.has()) {
        switch (((submsgtype0xc7.ForwardBody)localObject).uint32_op_type.get())
        {
        default: 
          break;
        case 3000: 
          if (((submsgtype0xc7.ForwardBody)localObject).msg_hot_friend_notify.has())
          {
            localObject = (submsgtype0xc7.HotFriendNotify)((submsgtype0xc7.ForwardBody)localObject).msg_hot_friend_notify.get();
            ajom.a(this.app, (submsgtype0xc7.HotFriendNotify)localObject, paramacrj);
          }
          break;
        case 4000: 
          if (((submsgtype0xc7.ForwardBody)localObject).msg_relational_chain_change.has())
          {
            localObject = (submsgtype0xc7.RelationalChainChange)((submsgtype0xc7.ForwardBody)localObject).msg_relational_chain_change.get();
            if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 10001L) {
              ajok.a(this.app, (submsgtype0xc7.RelationalChainChange)localObject, paramacrj);
            } else if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 19999L) {
              ajoq.a(this.app, (submsgtype0xc7.RelationalChainChange)localObject, paramacrj);
            } else if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 10002L) {
              wky.a(this.app, (submsgtype0xc7.RelationalChainChange)localObject, paramacrj);
            }
          }
          break;
        }
      }
    }
  }
  
  public void ad(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
    }
    submsgtype0x26.MsgBody localMsgBody = new submsgtype0x26.MsgBody();
    do
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_sub_cmd.has())
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not body");
          }
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
        return;
      }
      long l = a(localMsgBody);
      if (l != 0L)
      {
        apox localapox = (apox)this.app.getBusinessHandler(171);
        if (localapox != null) {
          localapox.notifyUI(6, true, new Object[] { Long.valueOf(l) });
        }
      }
      if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
      {
        ((acms)this.app.getBusinessHandler(20)).aP(paramArrayOfByte);
        return;
      }
    } while (localMsgBody.uint32_sub_cmd.get() != 3);
    a(localMsgBody);
  }
  
  public void ae(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe");
    }
    Object localObject = new SubMsgType0xbe.MsgBody();
    try
    {
      ((SubMsgType0xbe.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (!((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : msg has not uint64_group_code");
        }
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : fail to parse submsgtype0xbe.");
      return;
    }
    try
    {
      paramArrayOfByte = new JSONObject();
      if (((SubMsgType0xbe.MsgBody)localObject).uint64_uin.has()) {
        paramArrayOfByte.put("uin", ((SubMsgType0xbe.MsgBody)localObject).uint64_uin.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has()) {
        paramArrayOfByte.put("groupCode", ((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.has()) {
        paramArrayOfByte.put("notifyType", ((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.has()) {
        paramArrayOfByte.put("onlineLevel", ((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.has())
      {
        JSONArray localJSONArray = new JSONArray();
        localObject = ((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          SubMsgType0xbe.Medal localMedal = (SubMsgType0xbe.Medal)((Iterator)localObject).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("id", localMedal.uint32_id.get());
          localJSONObject.put("level", localMedal.uint32_level.get());
          localJSONObject.put("type", localMedal.uint32_type.get());
          localJSONObject.put("iconUrl", localMedal.str_icon_url.get());
          localJSONObject.put("flashUrl", localMedal.str_flash_url.get());
          localJSONObject.put("name", localMedal.str_name.get());
          localJSONArray.put(localJSONObject);
        }
        paramArrayOfByte.put("medalList", localJSONArray);
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    this.app.a().EJ(paramArrayOfByte.toString());
  }
  
  public void af(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83");
    }
    Object localObject1 = new SubMsgType0x83.MsgBody();
    do
    {
      try
      {
        ((SubMsgType0x83.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.has())
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : msg has not uint64_group_id");
          }
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : fail to parse submsgtype0x83.");
        return;
      }
    } while (!((SubMsgType0x83.MsgBody)localObject1).rpt_msg_params.has());
    paramArrayOfByte = ((SubMsgType0x83.MsgBody)localObject1).rpt_msg_params;
    long l1 = -1L;
    if (((SubMsgType0x83.MsgBody)localObject1).uint64_seq.has()) {
      l1 = ((SubMsgType0x83.MsgBody)localObject1).uint64_seq.get();
    }
    long l2 = -1L;
    if (((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.has()) {
      l2 = ((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.get();
    }
    int i = 0;
    label146:
    if (i < paramArrayOfByte.size())
    {
      localObject1 = (SubMsgType0x83.MsgParams)paramArrayOfByte.get(i);
      if ((localObject1 != null) && (((SubMsgType0x83.MsgParams)localObject1).uint32_type.has())) {
        break label187;
      }
    }
    label187:
    int j;
    label440:
    do
    {
      for (;;)
      {
        i += 1;
        break label146;
        break;
        j = ((SubMsgType0x83.MsgParams)localObject1).uint32_type.get();
        Object localObject3;
        int k;
        if ((j >= 2001) && (j <= 3000))
        {
          if ((((SubMsgType0x83.MsgParams)localObject1).str_data.has()) && (((SubMsgType0x83.MsgParams)localObject1).uint64_from_uin.has()) && (((SubMsgType0x83.MsgParams)localObject1).uint64_to_uin.has()))
          {
            localObject3 = ((SubMsgType0x83.MsgParams)localObject1).str_data.get();
            try
            {
              k = new JSONObject((String)localObject3).getInt("count");
              this.app.a().c(j, ((SubMsgType0x83.MsgParams)localObject1).uint64_from_uin.get(), ((SubMsgType0x83.MsgParams)localObject1).uint64_to_uin.get(), k, l1, l2);
            }
            catch (Exception localException1) {}
          }
        }
        else
        {
          if (j != 1005) {
            break label440;
          }
          if ((localException1.str_data.has()) && (localException1.uint64_from_uin.has()) && (localException1.uint64_to_uin.has()))
          {
            localObject3 = localException1.str_data.get();
            try
            {
              localObject3 = new JSONObject((String)localObject3);
              j = ((JSONObject)localObject3).optInt("enable");
              k = ((JSONObject)localObject3).optInt("level");
              this.app.a().c(localException1.uint32_type.get(), localException1.uint64_from_uin.get(), localException1.uint64_to_uin.get(), j, k, l1, l2);
            }
            catch (Exception localException2) {}
          }
        }
      }
    } while ((j != 1010) || (!localException2.bytes_data.has()));
    Object localObject2 = new String(localException2.bytes_data.get().toByteArray());
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (((JSONObject)localObject2).getInt("sndRank") == 0) {
          break label541;
        }
        j = 1;
        boolean bool = ((JSONObject)localObject2).getBoolean("rank_changed");
        if ((j == 0) || (!bool)) {
          break;
        }
        this.app.a().hH(l2);
      }
      catch (Exception localException3) {}
      break;
      label541:
      j = 0;
    }
  }
  
  public void ag(byte[] paramArrayOfByte)
  {
    this.app.a().aJ(paramArrayOfByte);
  }
  
  public void cM(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = this.app.a().a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.app.a().g().add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Request list add appid = " + str);
          }
        }
      }
      if (localArrayList.size() > 0) {
        anae.a(this.app, this.app.getCurrentAccountUin(), localArrayList);
      }
    }
  }
  
  public void f(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcReqPushMsg)paramVarArgs[2]);
      return;
    }
    bN(getClass().getName(), paramInt);
  }
  
  public void h(long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
    }
    int n = 0;
    int m = 0;
    try
    {
      paramArrayOfByte = (submsgtype0x44.MsgBody)new submsgtype0x44.MsgBody().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
      if (QLog.isColorLevel())
      {
        if ((paramArrayOfByte.msg_friend_msg_sync.has()) && (paramArrayOfByte.msg_friend_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get() + ";fuin" + paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
        }
        if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get() + ";grp_code=" + paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
        }
        if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
        }
      }
      if (!paramArrayOfByte.msg_friend_msg_sync.has()) {
        break label1297;
      }
    }
    int i;
    label350:
    Object localObject2;
    Object localObject1;
    if (paramArrayOfByte.msg_friend_msg_sync.get() != null) {
      if (fQ(paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get()))
      {
        i = 1;
        if (fS(paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get()))
        {
          localObject2 = String.valueOf(paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (aqmr.isValideUin((String)localObject2)))
          {
            localObject1 = (FriendListHandler)this.app.getBusinessHandler(1);
            j = paramArrayOfByte.msg_friend_msg_sync.uint32_sourceid.get();
            localObject2 = String.valueOf(localObject2);
            if (!((FriendListHandler)localObject1).a((String)localObject2, 0, j, null, false, false, -1L)) {
              ((FriendListHandler)localObject1).DF((String)localObject2);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get());
        }
      }
    }
    label1297:
    for (int j = i;; j = 0)
    {
      int k = n;
      if (paramArrayOfByte.msg_group_msg_sync.has())
      {
        k = n;
        if (paramArrayOfByte.msg_group_msg_sync.get() != null)
        {
          i = m;
          if (fQ(paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get())) {
            i = 1;
          }
          if (fR(paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get()))
          {
            localObject1 = String.valueOf(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            Object localObject3 = anzf.bF(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (aqmr.isValideUin((String)localObject1)))
            {
              TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
              if (localTroopManager.b((String)localObject1) == null)
              {
                localObject2 = new TroopInfo();
                ((TroopInfo)localObject2).troopuin = ((String)localObject1);
                ((TroopInfo)localObject2).troopcode = ((String)localObject3);
                localTroopManager.h((TroopInfo)localObject2);
                localObject3 = (acms)this.app.getBusinessHandler(20);
                ((acms)localObject3).a(((TroopInfo)localObject2).troopuin, false, "", true, true, true, false);
                ((acms)localObject3).a(1, accc.Z(((TroopInfo)localObject2).troopuin), 0L, 2, 0, 0, true);
                ((acms)localObject3).notifyUI(6, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), localObject1 });
                ((acms)localObject3).notifyUI(127, true, new Object[] { localObject1 });
              }
              b(2001, true, null);
            }
          }
          k = i;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get());
            k = i;
          }
        }
      }
      if ((j != 0) || (k != 0))
      {
        if ((j == 0) || (k == 0)) {
          break label1251;
        }
        this.a.a().Kg(4);
      }
      for (;;)
      {
        if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null))
        {
          if (fQ(paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get()))
          {
            this.app.a().G(acbn.bkT, 9000, 0 - anze.a().af(this.app));
            anze.a().N(this.app, 0);
            anzd.a().M(this.app, 0);
            localObject1 = (ysf)this.app.getManager(34);
            this.app.b().a(acbn.bkJ, 0, true, true);
            ((ysf)localObject1).cln();
          }
          i = ((submsgtype0x44.ClearCountMsg)paramArrayOfByte.msg_clean_count_msg.get()).uint32_updateflag.get();
          if (i > 0) {
            this.a.a().Kg(2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get() + " updateFlag=" + i);
          }
        }
        if ((paramArrayOfByte.msg_modify_msg_sync.has()) && (paramArrayOfByte.msg_modify_msg_sync.get() != null))
        {
          this.a.a().Kh(2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_modify_msg_sync =" + paramArrayOfByte.msg_modify_msg_sync.get());
          }
        }
        if ((!paramArrayOfByte.msg_waiting_msg_sync.has()) || (paramArrayOfByte.msg_waiting_msg_sync.get() == null)) {
          break;
        }
        this.a.a().Kg(2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_waiting_msg_sync =" + paramArrayOfByte.msg_waiting_msg_sync.get());
        return;
        label1251:
        if (j != 0) {
          this.a.a().Kg(2);
        } else if (k != 0) {
          this.a.a().y(3, 1, false);
        }
      }
      i = 0;
      break label350;
    }
  }
  
  public void h(byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)this.app.getManager(162)).a(paramArrayOfByte, paramLong, this);
  }
  
  public void i(byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)this.app.getManager(162)).f(paramArrayOfByte, paramLong);
  }
  
  public String o(byte[] paramArrayOfByte)
  {
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse start");
    }
    SubMsgType0xb3.PushAddFrdNotify localPushAddFrdNotify;
    int i;
    int j;
    long l1;
    MessageHandler localMessageHandler;
    for (;;)
    {
      try
      {
        paramArrayOfByte = (SubMsgType0xb3.MsgBody)new SubMsgType0xb3.MsgBody().mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msgBody is null.");
          }
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
        continue;
        if (!paramArrayOfByte.msg_add_frd_notify.has())
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msg_add_frd_notify is null.");
          return null;
        }
        localPushAddFrdNotify = (SubMsgType0xb3.PushAddFrdNotify)paramArrayOfByte.msg_add_frd_notify.get();
        i = localPushAddFrdNotify.uint32_source_id.get();
        j = localPushAddFrdNotify.uint32_subsource_id.get();
        if (!localPushAddFrdNotify.uint64_req_uin.has()) {
          break;
        }
      }
      l1 = localPushAddFrdNotify.uint64_req_uin.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, "decodeC2CMsgPkgSubMsgType0xb3, sourceid:" + i + "|subSourceid:" + j + " |reqUin: " + l1);
      }
      if ((i != 3076) && (i != 3077) && (i != 2076) && (i != 2077) && (i != 10012) && (i != 10013))
      {
        boolean bool = azcl.oD(i);
        localMessageHandler = (MessageHandler)this.app.getBusinessHandler(0);
        if (!bool) {
          break label411;
        }
        if (!localPushAddFrdNotify.bytes_mobile.has()) {
          break label398;
        }
        paramArrayOfByte = localPushAddFrdNotify.bytes_mobile.get().toStringUtf8();
      }
    }
    for (;;)
    {
      label297:
      long l3 = localPushAddFrdNotify.uint64_fuin.get();
      if (localPushAddFrdNotify.uint64_fuin_bubble_id.has()) {}
      for (long l2 = localPushAddFrdNotify.uint64_fuin_bubble_id.get();; l2 = -1L)
      {
        if (localPushAddFrdNotify.bytes_wording.has()) {
          str = localPushAddFrdNotify.bytes_wording.get().toStringUtf8();
        }
        localMessageHandler.a(String.valueOf(l3), paramArrayOfByte, l2, str, localPushAddFrdNotify.fixed32_timestamp.get(), i, j, l1);
        return String.valueOf(localPushAddFrdNotify.uint64_fuin.get());
        l1 = 0L;
        break;
        label398:
        paramArrayOfByte = null;
        break label297;
      }
      label411:
      paramArrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tos
 * JD-Core Version:    0.7.0.1
 */