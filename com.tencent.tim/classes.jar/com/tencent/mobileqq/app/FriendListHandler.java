package com.tencent.mobileqq.app;

import AvatarInfo.DestQQHeadInfo;
import AvatarInfo.QQHeadInfo;
import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import GeneralSettings.RespGetSettings;
import GeneralSettings.RespSetSettings;
import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigRes;
import KQQ.ProfSmpInfoRes;
import KQQ.ResRichSigInfo;
import KQQ.RespItem;
import KQQ.SetRichSigRes;
import QQService.BindUin;
import QQService.BindUinResult;
import QQService.DeviceItemDes;
import QQService.EVIPSPEC;
import QQService.SvcDevLoginInfo;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SummaryCard.RespCondSearch;
import SummaryCard.RespHead;
import SummaryCard.RespSearch;
import abbf;
import abgt;
import abhh;
import accg;
import acci;
import acdu;
import aceb;
import acfb;
import acfc;
import acfd;
import acff;
import acfp;
import achg;
import ackd;
import acle;
import acmq;
import acxu;
import acxw;
import aczr;
import adyp;
import adyr;
import aean;
import ajdo;
import ajnp;
import ajok;
import ajol;
import ajpj;
import aktp;
import akum;
import alkt;
import alsb;
import aluf;
import aluh;
import alui;
import aluu;
import amxh;
import anaz;
import anbi;
import andh;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import anpc;
import aqdm;
import aqfo;
import aqft;
import aqgu;
import aqgx;
import aqiw;
import aqlz;
import aqmr;
import aqoe;
import aqoj;
import aqrc;
import asgx;
import auvk;
import azcl;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.device_lock_confirm_auth.DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.DeviceInfo;
import com.tencent.ims.device_lock_recommend_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.RspBody;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddFriendResp;
import friendlist.AddGroupResp;
import friendlist.DelFriendResp;
import friendlist.DelGroupResp;
import friendlist.FriendInfo;
import friendlist.FriendListSubSrvRspCode;
import friendlist.GetAutoInfoResp;
import friendlist.GetFriendListResp;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.GetUserAddFriendSettingResp;
import friendlist.GroupInfo;
import friendlist.LastLoginInfo;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMemResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import friendlist.SetGroupResp;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jji;
import jqc;
import jqs;
import ku;
import mqq.app.Constants.Key;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import tencent.im.friend.AddContactVerifyInfo.AddFriendVerifyInfo;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdRsp;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ReqBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.RspBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdRsp;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.ReqBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.RspBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.UdcUinData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.MsgBox;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.OneFrdData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RspBody;
import tencent.im.oidb.cmd0x7c6.cmd0x7c6.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.RspBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.ReqBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.RspBody;
import tencent.im.oidb.cmd0x829.oidb_0x829.AddFrdInfo;
import tencent.im.oidb.cmd0x829.oidb_0x829.ReqBody;
import tencent.im.oidb.cmd0x829.oidb_0x829.RspBody;
import tencent.im.oidb.cmd0xaed.cmd0xaed.ReqBody;
import tencent.im.oidb.cmd0xc83.ReqBody;
import tencent.im.oidb.cmd0xc83.RspBody;
import tencent.im.oidb.cmd0xc85.ReqBody;
import tencent.im.oidb.cmd0xc85.RspBody;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.BindContactsFriendInfo;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.ReqBody;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.RspBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DeleteReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DoubtInfo;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.GetListReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.GetListRspBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.GetUnreadNumRspBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.ReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.RspBody;
import tencent.im.oidb.cmd0xd72.oidb_cmd0xd72.ReqBody;
import tencent.im.oidb.cmd0xd72.oidb_cmd0xd72.RspBody;
import tencent.im.oidb.oidb_0xc26.ReqBody;
import tencent.im.oidb.oidb_0xc26.RspBody;
import tencent.im.oidb.oidb_0xc34.ReqBody;
import tencent.im.oidb.oidb_0xc34.RspBody;
import tencent.im.oidb.oidb_0xc35.ExposeItem;
import tencent.im.oidb.oidb_0xc35.ReqBody;
import tencent.im.oidb.oidb_0xc35.RspBody;
import tencent.im.oidb.oidb_0xc36.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x11e.SubMsgType0x11e.MsgBody;
import ujt;
import wky;
import ysf;

public class FriendListHandler
  extends accg
{
  private static int cvg = 100;
  public static int cvh = -1;
  private long PA;
  private long PB = 15000L;
  private long PC;
  private long Px;
  private long Py;
  private long Pz;
  private short V = 20002;
  private final aluh jdField_a_of_type_Aluh = new aluh();
  private alui jdField_a_of_type_Alui;
  private QQHeadDownloadHandler jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler;
  private boolean bHs;
  private boolean bHt;
  private boolean bHu;
  private final Object bU = new Object();
  private Object cq = new Object();
  private Object cr = new Object();
  private int cva;
  private int cvb;
  private int cvc;
  private int cvd;
  private int cve = -1;
  private volatile int cvf = -1;
  private String[] ef;
  private MqqHandler g;
  private Hashtable<Integer, ArrayList<QQHeadDetails>> i = new Hashtable();
  private HashMap<Long, String> iN;
  private Hashtable<String, Long> j = new Hashtable();
  private Hashtable<String, b> m = new Hashtable();
  private Hashtable<String, a> n = new Hashtable();
  private ArrayList<oidb_0x7df.FriendScore> sA = new ArrayList();
  
  protected FriendListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    init();
  }
  
  private void M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getInt("setId") == 4051) {
      N(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("friendUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isSet");
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagError : uin : " + l + " isSet:" + bool);
    }
    notifyUI(56, false, new Object[] { Long.valueOf(l), Boolean.valueOf(bool), Boolean.valueOf(false), Boolean.valueOf(false), "" });
  }
  
  public static int a(VipBaseInfo paramVipBaseInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(paramInt1));
      if ((paramVipBaseInfo != null) && (paramVipBaseInfo.iVipLevel != -1) && (paramVipBaseInfo.iVipType != -1)) {}
    }
    else
    {
      return paramInt2;
    }
    if (paramVipBaseInfo.bOpen) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      return (paramInt1 << 8 | (byte)paramVipBaseInfo.iVipType & 0xFF) << 16 | (short)paramVipBaseInfo.iVipLevel;
    }
  }
  
  private Map<String, Integer> a(ArrayList<GeneralSettings.Setting> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int k = 0;
      if (k < paramArrayList.size())
      {
        GeneralSettings.Setting localSetting = (GeneralSettings.Setting)paramArrayList.get(k);
        Object localObject = localSetting.Path;
        if ((localObject == null) || (((String)localObject).length() == 0)) {}
        for (;;)
        {
          k += 1;
          break;
          localObject = ((String)localObject).split("\\.");
          if ((localObject != null) && (localObject.length != 0)) {
            localHashMap.put(localObject[(localObject.length - 1)], Integer.valueOf(Integer.parseInt(localSetting.Value)));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() " + paramFromServiceMsg.uint32_result.get());
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new FriendListHandler.3(this, paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean), 8, null, false);
      return;
    }
    b(paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean);
  }
  
  public static void a(SpecialCareInfo paramSpecialCareInfo, int paramInt, String paramString)
  {
    if (paramInt == 13568)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramSpecialCareInfo.specialRingSwitch = 0;
          return;
        }
        if (!Pattern.compile("[0-9]*").matcher(paramString).matches()) {
          return;
        }
        paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString);
        paramSpecialCareInfo.specialRingSwitch = 1;
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramString);
        }
        paramSpecialCareInfo.specialRingSwitch = 0;
        return;
      }
    }
    else
    {
      if (paramInt == 13573)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label111;
          }
          paramSpecialCareInfo.globalSwitch = 0;
          return;
        }
        catch (Exception paramSpecialCareInfo)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
        return;
        label111:
        paramSpecialCareInfo.globalSwitch = 1;
        return;
      }
      if (paramInt == 13572) {
        try
        {
          if (TextUtils.isEmpty(paramString))
          {
            paramSpecialCareInfo.qzoneSwitch = 0;
            return;
          }
        }
        catch (Exception paramSpecialCareInfo)
        {
          if (QLog.isColorLevel())
          {
            QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
            return;
            paramSpecialCareInfo.qzoneSwitch = 1;
          }
        }
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, DelFriendResp paramDelFriendResp)
  {
    if (paramDelFriendResp.errorCode != 0)
    {
      notifyUI(15, false, null);
      return;
    }
    paramFromServiceMsg = (PhoneContactManagerImp)this.app.getManager(11);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.clH();
    }
    ((acff)this.app.getManager(51)).yZ(String.valueOf(paramDelFriendResp.deluin));
    aluu.aB(this.app, paramDelFriendResp.deluin + "");
    this.app.a().a().bR(String.valueOf(paramDelFriendResp.deluin), true);
    paramFromServiceMsg = (ajpj)this.app.getManager(106);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.go.put("" + paramDelFriendResp.deluin, Integer.valueOf(1));
    }
    notifyUI(15, true, Long.valueOf(paramDelFriendResp.deluin));
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetLastLoginInfoResp paramGetLastLoginInfoResp)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramGetLastLoginInfoResp != null) && (paramGetLastLoginInfoResp.errorCode == 0))
    {
      paramFromServiceMsg = paramGetLastLoginInfoResp.stPageInfo;
      ArrayList localArrayList = paramGetLastLoginInfoResp.vecLastLoginInfo;
      acff localacff = (acff)this.app.getManager(51);
      iL(localArrayList);
      if (paramFromServiceMsg.dwCurrentReqIndex == paramFromServiceMsg.dwTotalReqTimes)
      {
        aqgu.B(this.app.getApp().getApplicationContext(), this.app.getAccount(), paramGetLastLoginInfoResp.iRefreshIntervalMin);
        notifyUI(48, true, Boolean.valueOf(true));
      }
      while (paramFromServiceMsg.dwCurrentReqIndex >= paramFromServiceMsg.dwTotalReqTimes) {
        return;
      }
      notifyUI(48, true, Boolean.valueOf(false));
      p(paramFromServiceMsg.dwTotalReqTimes, paramFromServiceMsg.dwCurrentReqIndex, paramFromServiceMsg.dwCurrentReqUin);
      return;
    }
    notifyUI(48, false, Boolean.valueOf(true));
  }
  
  private void a(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, QQHeadUrlResp paramQQHeadUrlResp)
  {
    int k;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramQQHeadUrlResp == null) || (paramQQHeadUrlResp.result != 0) || (paramQQHeadUrlResp.UserHeadInfoList == null))
    {
      k = 65535;
      if (paramQQHeadUrlResp != null) {
        k = paramQQHeadUrlResp.result;
      }
    }
    label262:
    do
    {
      for (;;)
      {
        d(???, k);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleQQHead handleResp for QQHeadInfo appear error and error code =" + k);
        }
        return;
        if (paramFromServiceMsg != null) {
          k = paramFromServiceMsg.getResultCode();
        }
      }
      paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
      Object localObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        ??? = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        for (;;)
        {
          if (!paramFromServiceMsg.hasNext()) {
            break label262;
          }
          localObject = (QQHeadDetails)paramFromServiceMsg.next();
          Iterator localIterator = paramQQHeadUrlResp.UserHeadInfoList.iterator();
          if (localIterator.hasNext())
          {
            QQHeadInfo localQQHeadInfo = (QQHeadInfo)localIterator.next();
            if (((localQQHeadInfo.dstUsrType == 11) || (!((QQHeadDetails)localObject).boh.equals(Long.toString(localQQHeadInfo.uin)))) && ((localQQHeadInfo.dstUsrType != 11) || (!((QQHeadDetails)localObject).boh.equals(localQQHeadInfo.phoneNum)))) {
              break;
            }
            localQQHeadInfo.headLevel = ((QQHeadDetails)localObject).bb;
            ???.add(localQQHeadInfo);
          }
        }
        paramQQHeadUrlResp.UserHeadInfoList = ???;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {}
      synchronized (this.cr)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler = new QQHeadDownloadHandler(this.app, this);
        }
        ??? = new StringBuilder("handleQQHead handleResp for QQHeadInfo");
        k = 0;
        if (k < paramQQHeadUrlResp.UserHeadInfoList.size())
        {
          paramFromServiceMsg = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(k);
          c(0, a(paramFromServiceMsg.dstUsrType, paramFromServiceMsg.uin, paramFromServiceMsg.phoneNum), paramFromServiceMsg.dstUsrType, 2);
          ???.append(" qqHeadUrlResp id=").append(k).append(" QQHeadInfo.uin=").append(aqmr.getSimpleUinForPrint(Long.toString(paramFromServiceMsg.uin))).append(" QQHeadInfo.systemId=").append(paramFromServiceMsg.systemHeadID).append("  QQHeadInfo.headtype=").append(paramFromServiceMsg.cHeadType).append("|");
          localObject = new FaceInfo();
          ((FaceInfo)localObject).b = paramFromServiceMsg;
          this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.b((FaceInfo)localObject);
          k += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler", 2, ???.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespGetSettings paramRespGetSettings)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "handleGetGeneralSettingAll cmd=" + paramFromServiceMsg.getMsfCommand() + " resp.isSucc=" + paramFromServiceMsg.isSuccess() + " resultCode=" + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      int i2 = paramToServiceMsg.extraData.getInt("Revision");
      int i1 = paramToServiceMsg.extraData.getInt("respRevision", -1);
      boolean bool = paramToServiceMsg.extraData.getBoolean("needTroopSettings");
      long l = paramToServiceMsg.extraData.getLong("Offset");
      paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
      if (paramRespGetSettings == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerGetGeneralSettingAll, data == null");
        }
        this.app.bG(false, true);
        notifyUI(35, false, new Object[] { Boolean.valueOf(true) });
        return;
      }
      if ((paramRespGetSettings.Settings == null) || (paramRespGetSettings.Settings.size() == 0))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("handlerGetGeneralSettingAll, data.Settings=");
          if (paramRespGetSettings.Settings != null) {
            break label289;
          }
        }
        label289:
        for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
        {
          QLog.d("RoamSetting", 2, paramToServiceMsg);
          aqgx.a().l(paramRespGetSettings.Revision, this.app);
          this.app.bG(true, true);
          notifyUI(35, true, new Object[] { Boolean.valueOf(true) });
          return;
        }
      }
      if ((i1 != -1) && (i1 < paramRespGetSettings.Revision))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "respRevision != data.Revision, load settings again, respRev=" + i1 + " data.Rev=" + paramRespGetSettings.Revision);
        }
        this.app.bG(false, false);
        this.app.aP(bool);
        notifyUI(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      int k = i1;
      if (i1 == -1) {
        k = paramRespGetSettings.Revision;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("oldRevision=").append(i2).append(" lastRespRevision=").append(k).append(" total=").append(paramRespGetSettings.Total).append(" offset=").append(l).append(" data.settings.size=");
        if (paramRespGetSettings.Settings != null) {
          break label591;
        }
      }
      label591:
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
      {
        QLog.d("RoamSetting", 2, paramToServiceMsg);
        aqgx.a().c(paramRespGetSettings.Settings, this.app);
        l += paramRespGetSettings.Settings.size();
        if (paramRespGetSettings.Total <= l) {
          break;
        }
        ((aqlz)this.app.getManager(31)).a(i2, l, k, bool, null);
        notifyUI(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      aqgx.a().l(paramRespGetSettings.Revision, this.app);
      this.app.bG(true, true);
      notifyUI(35, true, new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.app.bG(false, true);
    notifyUI(35, false, new Object[] { Boolean.valueOf(true) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespSetSettings paramRespSetSettings)
  {
    Object localObject1 = (ArrayList)paramToServiceMsg.extraData.getSerializable("Settings");
    int k = paramToServiceMsg.extraData.getInt("localRevision");
    Object localObject2;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("handlerUploadRoamSettingNewValue isSuccess = ").append(paramFromServiceMsg.isSuccess()).append(" reqLocalRevision=").append(k).append(" data.Revision=");
      if (paramRespSetSettings == null)
      {
        paramToServiceMsg = "null";
        QLog.d("FriendListHandler", 2, paramToServiceMsg);
      }
    }
    else
    {
      paramToServiceMsg = (aqlz)this.app.getManager(31);
      if (!paramFromServiceMsg.isSuccess()) {
        break label216;
      }
      if (paramRespSetSettings == null) {
        break label1312;
      }
      if (k + 1 != paramRespSetSettings.Revision) {
        break label201;
      }
      aqgx.a().c((ArrayList)localObject1, this.app);
      aqgx.a().l(paramRespSetSettings.Revision, this.app);
      this.app.bH(true, false);
      bool2 = true;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerUploadRoamSettingNewValue  settings is null.");
        }
        return;
        paramToServiceMsg = Integer.valueOf(paramRespSetSettings.Revision);
        break;
        label201:
        this.app.bH(true, true);
        bool2 = true;
        continue;
        label216:
        this.app.bH(false, false);
        bool2 = false;
        continue;
      }
      paramFromServiceMsg = a((ArrayList)localObject1);
      paramRespSetSettings = ((ArrayList)localObject1).iterator();
      boolean bool1 = false;
      label247:
      if (paramRespSetSettings.hasNext())
      {
        localObject1 = (GeneralSettings.Setting)paramRespSetSettings.next();
        if (((GeneralSettings.Setting)localObject1).Path == null) {
          break label1309;
        }
        if (!((GeneralSettings.Setting)localObject1).Path.startsWith("message.group.policy.")) {
          break label494;
        }
        if ((bool1) || ((!bool2) && ((bool2) || (!paramToServiceMsg.aEU())))) {
          break label405;
        }
        localObject1 = paramFromServiceMsg.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          Boolean localBoolean = (Boolean)paramToServiceMsg.jb.get(localObject2);
          if ((localBoolean != null) && (localBoolean.booleanValue())) {
            paramToServiceMsg.jb.put(localObject2, Boolean.valueOf(false));
          }
        }
        notifyUI(38, bool2, paramFromServiceMsg);
        bool1 = true;
      }
      label405:
      label1309:
      for (;;)
      {
        break label247;
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + " hasNotifyTroop=" + bool1 + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.aEU());
          continue;
          label494:
          if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.ring.switch"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.aEU()))) {
              notifyUI(43, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.aEU());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.vibrate.switch"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.aEU()))) {
              notifyUI(44, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.aEU());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("sync.c2c_message"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.aEU()))) {
              notifyUI(47, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.aEU());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.group.ring"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.aEU()))) {
              notifyUI(41, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.aEU());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.group.vibrate"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.aEU()))) {
              notifyUI(42, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.aEU());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.ring.care"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.aEU()))) {
              notifyUI(78, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "-->handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.aEU());
            }
          }
          else if ((((GeneralSettings.Setting)localObject1).Path.startsWith("message.push_detail")) && (QLog.isColorLevel())) {
            QLog.d("RoamSetting", 2, "-->handleUploadRoamsSettingNewValue path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.aEU());
          }
        }
      }
      label1312:
      bool2 = true;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRespKikOut paramSvcRespKikOut)
  {
    int k = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerKickOutDev index = " + k);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRespKikOut == null)
      {
        notifyUI(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(k) });
        return;
      }
      notifyUI(52, true, new Object[] { Long.valueOf(paramSvcRespKikOut.appid), Integer.valueOf(paramSvcRespKikOut.result), Integer.valueOf(k) });
      return;
    }
    if (paramSvcRespKikOut == null)
    {
      notifyUI(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(k) });
      return;
    }
    notifyUI(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(k) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspBindUin paramSvcRspBindUin)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlerBindUinStaus() success");
      }
      if (paramSvcRspBindUin != null)
      {
        paramToServiceMsg = paramSvcRspBindUin.vecResult;
        if (paramToServiceMsg != null)
        {
          int k = 0;
          if (k < paramToServiceMsg.size())
          {
            paramFromServiceMsg = (BindUinResult)paramToServiceMsg.get(k);
            if (paramFromServiceMsg == null) {}
            for (;;)
            {
              k += 1;
              break;
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "result iResult = " + paramFromServiceMsg.iResult + "; lUin = " + paramFromServiceMsg.lUin + "; strResult = " + paramFromServiceMsg.strResult);
              }
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("FriendListHandler", 2, "handlerBindUinStaus res no success");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int k = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + k);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        notifyUI(61, false, new Object[] { null, Integer.valueOf(k) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        notifyUI(61, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(k) });
        return;
      }
      notifyUI(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(k) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      notifyUI(61, false, new Object[] { null, Integer.valueOf(k) });
      return;
    }
    notifyUI(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(k) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        notifyUI(50, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int k;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          k = 0;
          if (k < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(k);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          k += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerMultiClientList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(k);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              notifyUI(50, true, new Object[] { paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo });
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID =" + aqoj.C(NetConnInfoCenter.GUID) + "; info.guid = " + aqoj.C(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      notifyUI(50, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      notifyUI(50, false, null);
      return;
    }
    notifyUI(50, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if ((paramGetFriendListResp.result == 1) || (paramGetFriendListResp.vecFriendInfo == null) || (paramGetFriendListResp.vecFriendInfo.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo failed");
      }
      return;
    }
    Object localObject = (acff)this.app.getManager(51);
    VasFaceManager localVasFaceManager = ((aqrc)this.app.getManager(235)).a;
    FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
    Friends localFriends1 = new Friends();
    localFriends1.name = localFriendInfo.nick;
    localFriends1.remark = localFriendInfo.remark;
    localFriends1.uin = String.valueOf(localFriendInfo.friendUin);
    localFriends1.groupid = localFriendInfo.groupId;
    localFriends1.cSpecialFlag = localFriendInfo.cSpecialFlag;
    if (localFriendInfo.cSpecialFlag < 0)
    {
      QLog.i("FriendListHandler", 1, "infoResp.cSpecialFlag is 0xFF");
      localFriends1.cSpecialFlag = 0;
    }
    localFriends1.detalStatusFlag = localFriendInfo.detalStatusFlag;
    localFriends1.alias = localFriendInfo.sShowName;
    localFriends1.iTermType = localFriendInfo.iTermType;
    localFriends1.abilityBits = localFriendInfo.uAbiFlag;
    localFriends1.netTypeIconId = localFriendInfo.eIconType;
    localFriends1.strTermDesc = localFriendInfo.strTermDesc;
    localFriends1.uExtOnlineStatus = localFriendInfo.uExtOnlineStatus;
    localFriends1.iBatteryStatus = localFriendInfo.iBatteryStatus;
    int i2 = paramGetFriendListResp.wGetExtSnsRspCode;
    int i1 = 0;
    int k;
    if (paramGetFriendListResp.stSubSrvRspCode != null)
    {
      k = paramGetFriendListResp.stSubSrvRspCode.wGetMutualMarkRspCode;
      i1 = paramGetFriendListResp.stSubSrvRspCode.wGetIntimateInfoRspCode;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, new Object[] { "handleGetFriendDetailInfo uin=", localFriends1.uin, ", cSpecialFlag=", Byte.valueOf(localFriends1.cSpecialFlag), " wGetExtSnsRspCode:", Integer.valueOf(i2), " wGetMutualMarkRspCode:", Integer.valueOf(k), " wGetIntimateInfoRspCode:", Integer.valueOf(i1), " extOnline:", Long.valueOf(localFriendInfo.uExtOnlineStatus), " battery:", Integer.valueOf(localFriendInfo.iBatteryStatus) });
      }
      if (localFriends1.eNetwork != localFriendInfo.eNetworkType)
      {
        localFriends1.eNetwork = localFriendInfo.eNetworkType;
        notifyUI(13, true, null);
      }
      localFriends1.setShieldFlag(false);
      paramToServiceMsg = ((acff)localObject).e(localFriends1.uin);
      if (paramToServiceMsg != null)
      {
        if (paramToServiceMsg.gathtertype != 1) {
          break label1859;
        }
        localFriends1.gathtertype = 1;
        localFriends1.age = paramToServiceMsg.age;
        localFriends1.smartRemark = paramToServiceMsg.smartRemark;
        localFriends1.gender = paramToServiceMsg.gender;
        localFriends1.recommReason = paramToServiceMsg.recommReason;
        if (((paramToServiceMsg.gathtertype == 1) || (paramToServiceMsg.gathtertype == 2)) && (QLog.isColorLevel())) {
          QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendDetailInfo  friend.gathtertype = " + localFriends1.gathtertype + " | friend.age = " + localFriends1.age + " | friend.recommReason = " + localFriends1.recommReason);
        }
      }
      Friends localFriends2 = ((acff)localObject).e(localFriends1.uin);
      paramToServiceMsg = localFriendInfo.oVipInfo;
      int i3 = EVIPSPEC.E_SP_QQVIP.value();
      label635:
      boolean bool;
      label674:
      label713:
      label752:
      SpecialCareInfo localSpecialCareInfo;
      if (localFriends2 != null)
      {
        i1 = localFriends2.qqVipInfo;
        localFriends1.qqVipInfo = a(paramToServiceMsg, i3, i1);
        paramToServiceMsg = localFriendInfo.oVipInfo;
        i3 = EVIPSPEC.E_SP_SUPERQQ.value();
        if (localFriends2 == null) {
          break label1882;
        }
        i1 = localFriends2.superQqInfo;
        localFriends1.superQqInfo = a(paramToServiceMsg, i3, i1);
        paramToServiceMsg = localFriendInfo.oVipInfo;
        i3 = EVIPSPEC.E_SP_SUPERVIP.value();
        if (localFriends2 == null) {
          break label1888;
        }
        i1 = localFriends2.superVipInfo;
        localFriends1.superVipInfo = a(paramToServiceMsg, i3, i1);
        paramToServiceMsg = localFriendInfo.oVipInfo;
        i3 = EVIPSPEC.E_SP_BIGCLUB.value();
        if (localFriends2 == null) {
          break label1894;
        }
        i1 = localFriends2.bigClubInfo;
        localFriends1.bigClubInfo = a(paramToServiceMsg, i3, i1);
        localFriends1.cNewLoverDiamondFlag = localFriendInfo.cNewLoverDiamondFlag;
        if ((localFriendInfo.oVipInfo != null) && (localFriendInfo.oVipInfo.mOpenInfo != null))
        {
          paramToServiceMsg = (VipOpenInfo)localFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
          if (paramToServiceMsg != null) {
            localFriends1.superVipTemplateId = ((int)paramToServiceMsg.lNameplateId);
          }
          paramToServiceMsg = (VipOpenInfo)localFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
          if (paramToServiceMsg != null) {
            localFriends1.bigClubTemplateId = ((int)paramToServiceMsg.lNameplateId);
          }
          if (localFriends2 != null)
          {
            localFriends2.nameplateVipType = localFriendInfo.oVipInfo.iNameplateVipType;
            localFriends2.grayNameplateFlag = localFriendInfo.oVipInfo.iGrayNameplateFlag;
          }
        }
        localFriends1.namePlateOfKingGameId = localFriendInfo.uGameAppid;
        localFriends1.namePlateOfKingLoginTime = localFriendInfo.uGameLastLoginTime;
        localFriends1.namePlateOfKingDan = ((int)localFriendInfo.ulKingOfGloryRank);
        if (localFriendInfo.cKingOfGloryFlag != 1) {
          break label1900;
        }
        bool = true;
        label948:
        localFriends1.namePlateOfKingDanDisplatSwitch = bool;
        if ((!TextUtils.isEmpty(localFriends1.uin)) && (this.app.getCurrentUin().equals(localFriends1.uin))) {
          this.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.app.getCurrentUin(), localFriends1.namePlateOfKingDanDisplatSwitch).apply();
        }
        if (localFriends2 != null)
        {
          localFriends1.datetime = localFriends2.datetime;
          localFriends1.lastLoginType = localFriends2.lastLoginType;
          if (localFriends2.gathtertype == 1)
          {
            localFriends1.gender = localFriends2.gender;
            localFriends1.age = localFriends2.age;
            localFriends1.smartRemark = localFriends2.smartRemark;
            localFriends1.recommReason = localFriends2.recommReason;
          }
        }
        asgx.a(this.app, localFriends1);
        paramGetFriendListResp = ((acff)localObject).a(localFriends1.uin);
        paramToServiceMsg = paramGetFriendListResp;
        if (paramGetFriendListResp == null)
        {
          paramToServiceMsg = new ExtensionInfo();
          paramToServiceMsg.uin = localFriends1.uin;
        }
        paramToServiceMsg.pendantId = localFriendInfo.ulFaceAddonId;
        paramToServiceMsg.uVipFont = ku.h(localFriendInfo.uFounderFont);
        paramToServiceMsg.vipFontType = ku.c(localFriendInfo.uFounderFont);
        paramToServiceMsg.colorRingId = localFriendInfo.uColorRing;
        paramToServiceMsg.magicFont = (localFriendInfo.cSpecialFlag >> 3 & 0x1);
        paramToServiceMsg.faceId = ((int)localFriendInfo.uFaceStoreId);
        paramToServiceMsg.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
        paramToServiceMsg.timestamp = System.currentTimeMillis();
        paramToServiceMsg.latestPLUpdateTimestamp = localFriendInfo.uTagUpdateTime;
        paramToServiceMsg.fontEffect = ((int)localFriendInfo.uFontEffect);
        paramToServiceMsg.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
        localSpecialCareInfo = new SpecialCareInfo();
        a(localFriendInfo.vecRing, paramToServiceMsg, localFriends1, localSpecialCareInfo, 0L);
        if (localSpecialCareInfo != null) {
          ((acff)localObject).a(localSpecialCareInfo);
        }
        ajok.a(this.app, localFriends1, paramToServiceMsg, localFriendInfo.vecIntimateInfo);
        if (i2 == 0) {
          wky.a(this.app, (acff)localObject, localFriends1, paramToServiceMsg, localFriends1.uin, localFriendInfo.vecExtSnsFrdData);
        }
        if (k == 0) {
          ajnp.b(this.app, (acff)localObject, localFriends1, paramToServiceMsg, localFriends1.uin, localFriendInfo.vecMutualMarkData);
        }
        ((acff)localObject).f(localFriends1);
        ((acff)localObject).a(paramToServiceMsg);
        localVasFaceManager.d(paramToServiceMsg);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("handleGetFriendDetailInfo, Get ExtensionInfo, uin=");
          if (localFriends2 == null) {
            break label1906;
          }
        }
      }
      label1859:
      label1882:
      label1888:
      label1894:
      label1900:
      label1906:
      for (paramGetFriendListResp = localFriends2.uin;; paramGetFriendListResp = "")
      {
        QLog.d("FriendListHandler", 2, paramGetFriendListResp + ", id=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont + ", fontType = " + paramToServiceMsg.vipFontType + ", magicfont = " + paramToServiceMsg.magicFont + ",latestplNewsTs=" + paramToServiceMsg.latestPLUpdateTimestamp + ",fontEffect=" + paramToServiceMsg.fontEffect + ",fontEffectLastUpdateTime=" + paramToServiceMsg.fontEffectLastUpdateTime);
        if (localFriends2 != null)
        {
          paramToServiceMsg = (abhh)this.app.getManager(153);
          paramGetFriendListResp = paramToServiceMsg.b(localFriends2.uin);
          if ((paramGetFriendListResp.apolloStatus != localFriendInfo.cApolloFlag) || (paramGetFriendListResp.apolloServerTS != localFriendInfo.uApolloTimestamp) || (paramGetFriendListResp.apolloSignValidTS != localFriendInfo.uApolloSignTime))
          {
            paramGetFriendListResp.apolloStatus = localFriendInfo.cApolloFlag;
            paramGetFriendListResp.apolloServerTS = localFriendInfo.uApolloTimestamp;
            paramGetFriendListResp.apolloSignValidTS = localFriendInfo.uApolloSignTime;
            paramGetFriendListResp.apolloSignStr = "";
            paramToServiceMsg.a(paramGetFriendListResp);
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo, update apollo info uin=" + localFriends2.uin + "apollo status: " + localFriendInfo.cApolloFlag + ", apollo svr TS: " + localFriendInfo.uApolloTimestamp + ", sign TS: " + localFriendInfo.uApolloSignTime);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleGetFriendDetailInfo | uin = " + localFriends1.uin + " | group = " + localFriends1.groupid);
        }
        if (this.Py == 0L) {
          notifyUI(1, true, Boolean.valueOf(true));
        }
        paramToServiceMsg = new ArrayList();
        paramToServiceMsg.add(localSpecialCareInfo);
        notifyUI(99, true, new Object[] { Boolean.valueOf(true), paramToServiceMsg });
        paramToServiceMsg = (ajdo)this.app.getManager(11);
        if (paramToServiceMsg != null) {
          paramToServiceMsg.clK();
        }
        K(new String[] { localFriends1.uin });
        return;
        if (paramToServiceMsg.gathtertype != 2) {
          break;
        }
        localFriends1.gathtertype = 2;
        break;
        i1 = 0;
        break label635;
        i1 = 0;
        break label674;
        i1 = 0;
        break label713;
        i1 = 0;
        break label752;
        bool = false;
        break label948;
      }
      k = 0;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetUserAddFriendSettingResp paramGetUserAddFriendSettingResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    if ((paramGetUserAddFriendSettingResp != null) && (paramGetUserAddFriendSettingResp.result == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleAddFriendSetting " + paramGetUserAddFriendSettingResp.queryuinsetting + ", " + paramGetUserAddFriendSettingResp.contact_bothway_friend + ", " + paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      }
      paramToServiceMsg.putInt("friend_setting", paramGetUserAddFriendSettingResp.queryuinsetting);
      paramToServiceMsg.putLong("query_friend_uin", paramGetUserAddFriendSettingResp.queryuin);
      paramToServiceMsg.putStringArrayList("user_question", paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      paramToServiceMsg.putBoolean("contact_bothway", paramGetUserAddFriendSettingResp.contact_bothway_friend);
      notifyUI(12, true, paramToServiceMsg);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleAddFriendSetting ");
      if (paramGetUserAddFriendSettingResp == null) {
        break label184;
      }
    }
    label184:
    for (int k = paramGetUserAddFriendSettingResp.result;; k = -10000)
    {
      QLog.d("FriendListHandler", 2, k);
      notifyUI(12, false, paramToServiceMsg);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, MovGroupMemResp paramMovGroupMemResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    String str = paramToServiceMsg.getString("uin");
    byte b1 = paramToServiceMsg.getByte("group_id");
    byte b2 = paramToServiceMsg.getByte("away_group_id");
    if (paramMovGroupMemResp.result == 0)
    {
      ((acff)this.app.getManager(51)).dw(str, b1);
      notifyUI(9, true, new Object[] { str, Byte.valueOf(b1), Byte.valueOf(b2) });
      return;
    }
    notifyUI(9, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, SetGroupResp paramSetGroupResp)
  {
    boolean bool;
    int k;
    if (paramSetGroupResp.result == 0)
    {
      bool = true;
      k = paramToServiceMsg.extraData.getInt("set_type", -1);
      if (k == paramSetGroupResp.reqtype) {
        break label674;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleSetGroupResp | unmatched reqtype, local = " + k + ", remote = " + paramSetGroupResp.reqtype);
      }
      bool = false;
    }
    label674:
    for (;;)
    {
      Object localObject1 = ByteBuffer.wrap(paramSetGroupResp.vecBody);
      acff localacff = (acff)this.app.getManager(51);
      Object localObject2;
      switch (k)
      {
      default: 
        return;
        bool = false;
        break;
      case 0: 
        localObject2 = new AddGroupResp();
        if (bool)
        {
          ((AddGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject2).cGroupId = ((ByteBuffer)localObject1).get();
          ((AddGroupResp)localObject2).cSortId = ((ByteBuffer)localObject1).get();
          localObject1 = localacff.a(((AddGroupResp)localObject2).cGroupId + "");
          if (localObject1 == null) {
            break label300;
          }
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject2).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject2).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
        for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = (ToServiceMsg)localObject1)
        {
          localacff.a(paramToServiceMsg);
          notifyUI(18, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (AddGroupResp)localObject2));
          return;
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject2).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject2).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
      case 1: 
        localObject2 = new RenameGroupResp();
        if (bool)
        {
          ((RenameGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((RenameGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          k = ((ByteBuffer)localObject1).get();
          ((RenameGroupResp)localObject2).cLen = ((ByteBuffer)localObject1).get();
          paramToServiceMsg = new byte[((RenameGroupResp)localObject2).cLen];
          ((ByteBuffer)localObject1).get(paramToServiceMsg, 0, ((RenameGroupResp)localObject2).cLen);
          ((RenameGroupResp)localObject2).sGroupName = new String(paramToServiceMsg);
          paramToServiceMsg = localacff.a(String.valueOf(k));
          if (paramToServiceMsg == null) {
            break label491;
          }
        }
        for (paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName;; paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName)
        {
          localacff.a(paramToServiceMsg);
          notifyUI(19, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (RenameGroupResp)localObject2));
          return;
          paramToServiceMsg = new Groups();
          paramToServiceMsg.group_id = ((int)((RenameGroupResp)localObject2).dwSequence);
        }
      case 2: 
        paramToServiceMsg = new DelGroupResp();
        if (bool)
        {
          paramToServiceMsg.dwToUin = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.dwSequence = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.cGroupid = ((ByteBuffer)localObject1).get();
        }
        a(paramToServiceMsg, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, paramToServiceMsg));
        return;
      case 3: 
        label300:
        label491:
        localObject2 = new ReSortGroupResp();
        if (bool)
        {
          ((ReSortGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((ReSortGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          localacff.c(paramToServiceMsg.extraData.getByteArray("group_id_list"), paramToServiceMsg.extraData.getByteArray("sort_id_list"));
        }
        notifyUI(22, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (ReSortGroupResp)localObject2));
        return;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Oidb_0x5d1.RspBody paramRspBody)
  {
    Object localObject2 = (acff)this.app.getManager(51);
    int k = paramRspBody.uint32_cmd.get();
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    Object localObject1 = "";
    long l2;
    int i1;
    boolean bool1;
    label266:
    boolean bool2;
    if ((k == 1) && (paramRspBody.msg_set_friend_id.has()))
    {
      paramToServiceMsg = (Oidb_0x5d1.SetFriendIdRsp)paramRspBody.msg_set_friend_id.get();
      l2 = paramToServiceMsg.uint64_seq.get();
      i1 = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + k + "result : " + i1 + " newSeq:" + l2);
      }
      if (i1 == 0)
      {
        paramRspBody = ((acff)localObject2).e(String.valueOf(l1));
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (paramRspBody != null)
        {
          paramRspBody.setShieldFlag(true);
          ((acff)localObject2).a(paramRspBody);
          paramToServiceMsg = this.app.getCurrentAccountUin();
          paramRspBody = acfp.m(2131706581);
          l2 = anaz.gQ();
          localObject2 = anbi.d(-2012);
          ((MessageRecord)localObject2).init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, paramRspBody, l2, 0, 0, l2);
          ((MessageRecord)localObject2).msgtype = -2012;
          ((MessageRecord)localObject2).isread = true;
          this.app.b().b((MessageRecord)localObject2, paramToServiceMsg);
          paramToServiceMsg = (ToServiceMsg)localObject1;
        }
        if (i1 != 0) {
          break label335;
        }
        bool1 = true;
        if (i1 != 0) {
          break label341;
        }
        bool2 = true;
        label274:
        notifyUI(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
      }
    }
    label335:
    label341:
    do
    {
      return;
      paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
      break;
      bool1 = false;
      break label266;
      bool2 = false;
      break label274;
      if ((k == 2) && (paramRspBody.msg_clear_friend_id.has()))
      {
        paramToServiceMsg = (Oidb_0x5d1.ClearFriendIdRsp)paramRspBody.msg_clear_friend_id.get();
        l2 = paramToServiceMsg.uint64_seq.get();
        i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + k + "result : " + i1 + " newSeq:" + l2);
        }
        if (i1 == 0)
        {
          paramToServiceMsg = ((acff)localObject2).e(String.valueOf(l1));
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.setShieldFlag(false);
            ((acff)localObject2).a(paramToServiceMsg);
            paramToServiceMsg = this.app.getCurrentAccountUin();
            paramRspBody = acfp.m(2131706584);
            l2 = anaz.gQ();
            localObject1 = anbi.d(-2012);
            ((MessageRecord)localObject1).init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, paramRspBody, l2, 0, 0, l2);
            ((MessageRecord)localObject1).msgtype = -2012;
            ((MessageRecord)localObject1).isread = true;
            this.app.b().b((MessageRecord)localObject1, paramToServiceMsg);
          }
          paramToServiceMsg = "";
          if (i1 != 0) {
            break label642;
          }
          bool1 = true;
          if (i1 != 0) {
            break label648;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          notifyUI(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(false), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
          return;
          paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
          break;
          bool1 = false;
          break label573;
        }
      }
    } while (!QLog.isColorLevel());
    label573:
    QLog.d("FriendListHandler", 2, "<---handleSetFriendShieldFlagResp : cmd:" + k);
    label642:
    label648:
    return;
  }
  
  private void a(AddFriendResp paramAddFriendResp, ToServiceMsg paramToServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramToServiceMsg.extraData);
    if (paramAddFriendResp == null) {
      notifyUI(11, false, localBundle);
    }
    Object localObject;
    for (;;)
    {
      return;
      localBundle.putInt("resultCode", paramAddFriendResp.result);
      localBundle.putString("ErrorString", paramAddFriendResp.ErrorString);
      if (paramAddFriendResp.verify != null)
      {
        localObject = new AddContactVerifyInfo.AddFriendVerifyInfo();
        try
        {
          ((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).mergeFrom(paramAddFriendResp.verify);
          if (((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).str_url.has())
          {
            String str1 = ((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).str_url.get();
            if (!TextUtils.isEmpty(str1))
            {
              localBundle.putString("security_check_url", str1);
              localBundle.putString("security_check_buffer", ((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).str_verify_info.get());
              notifyUI(120, true, localBundle);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("FriendListHandler", 2, "handleAddFriend, needSecCheck");
              return;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("FriendListHandler", 1, "handleAddFriend, ", localException);
          }
        }
      }
    }
    if (paramAddFriendResp.result == 0)
    {
      paramToServiceMsg = paramToServiceMsg.extraData;
      boolean bool1 = paramToServiceMsg.getBoolean("auto_send", false);
      int i1 = paramToServiceMsg.getInt("source_id");
      localObject = paramToServiceMsg.getString("uin");
      int i2 = paramToServiceMsg.getInt("friend_setting");
      boolean bool2 = paramToServiceMsg.getBoolean("contact_bothway");
      String str2 = paramToServiceMsg.getString("remark");
      int k;
      if ((bool1) && (AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i1, bool2))) {
        k = 1;
      }
      for (;;)
      {
        if ((bool1) && (k != 0) && (paramAddFriendResp.adduin != 0L)) {
          a(String.valueOf(paramAddFriendResp.adduin), paramAddFriendResp.myfriendgroupid, i1, paramToServiceMsg.getString("src_name"), true, false, -1L);
        }
        try
        {
          for (;;)
          {
            ((acff)this.app.getManager(51)).a().OW((String)localObject);
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("$handleAddFriend|autoSend=").append(bool1).append(",uin").append(paramAddFriendResp.adduin).append(",sourceId=").append(i1).append(",beBothWay=").append(bool2).append(",successDirectly=").append(AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i1, bool2));
              QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
            }
            localBundle.putByteArray("sig", paramAddFriendResp.sig);
            localBundle.putString("result_uin", String.valueOf(paramAddFriendResp.adduin));
            if ((!bool1) || (k == 0)) {
              break label530;
            }
            bool1 = true;
            localBundle.putBoolean("addDirect", bool1);
            notifyUI(11, true, localBundle);
            return;
            k = 0;
            break;
            if (azcl.oD(i1)) {
              ((PhoneContactManagerImp)this.app.getManager(11)).J((String)localObject, i2, str2);
            }
          }
        }
        catch (Throwable paramToServiceMsg)
        {
          for (;;)
          {
            paramToServiceMsg.printStackTrace();
            continue;
            label530:
            bool1 = false;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "ErrorString" + paramAddFriendResp.ErrorString + "resultCode" + paramAddFriendResp.result);
    }
    notifyUI(11, true, localBundle);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getFriendGroupList " + paramBoolean1 + ", " + paramString + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramLong);
    }
    if (!paramBoolean1)
    {
      if (((acff)this.app.getManager(51)).aae()) {
        notifyUI(1, true, null);
      }
    }
    else {
      notifyUI(1, true, Boolean.valueOf(false));
    }
    paramString = createToServiceMsg("friendlist.getFriendGroupList");
    paramString.setEnableFastResend(true);
    paramString.extraData.putLong("timeStamp", paramLong);
    paramString.extraData.putStringArrayList("uinList", paramArrayList);
    paramString.extraData.putShort("friendStartIndex", (short)paramInt1);
    paramString.extraData.putShort("friendTotalCount", paramShort);
    paramString.extraData.putShort("friendCount", (short)paramInt2);
    paramString.extraData.putByte("groupStartIndex", (byte)paramInt3);
    paramString.extraData.getByte("groupCount", (byte)paramInt4);
    paramString.extraData.putLong("startTime", System.currentTimeMillis());
    paramString.extraData.putByte("ifShowTermType", (byte)1);
    paramString.extraData.putBoolean("is_manual_pull_refresh", paramBoolean2);
    send(paramString);
  }
  
  private void a(String paramString, GetFriendListResp paramGetFriendListResp, ToServiceMsg paramToServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("timeStamp");
    ArrayList localArrayList1 = paramToServiceMsg.extraData.getStringArrayList("uinList");
    boolean bool5 = paramToServiceMsg.extraData.getBoolean("is_manual_pull_refresh");
    int i4 = paramGetFriendListResp.startIndex;
    int i5 = paramGetFriendListResp.friend_count;
    int i6 = paramGetFriendListResp.wGetExtSnsRspCode;
    int i1;
    int k;
    if (paramGetFriendListResp.stSubSrvRspCode != null)
    {
      i1 = paramGetFriendListResp.stSubSrvRspCode.wGetMutualMarkRspCode;
      k = paramGetFriendListResp.stSubSrvRspCode.wGetIntimateInfoRspCode;
    }
    label1302:
    label1450:
    label1969:
    label3264:
    label3270:
    label3276:
    label3282:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + paramGetFriendListResp.result + ", " + paramGetFriendListResp.serverTime + ", " + i4 + ", " + i5 + " totalCount=" + paramGetFriendListResp.totoal_friend_count + " wGetExtSnsRspCode:" + i6 + " wGetMutualMarkRspCode:" + i1 + " wGetIntimateInfoRspCode:" + k);
      }
      if (paramGetFriendListResp.result == 1)
      {
        QLog.e("FriendListHandler", 2, "handleGetFriendList fail code");
        notifyUI(1, false, Boolean.valueOf(false));
        notifyUI(99, false, null);
        if (paramToServiceMsg.extraData.getShort("friendTotalCount") == 0) {}
        for (k = paramGetFriendListResp.totoal_friend_count;; k = paramToServiceMsg.extraData.getShort("friendTotalCount"))
        {
          a(false, k, paramToServiceMsg.extraData.getShort("friendStartIndex"), 1);
          return;
        }
      }
      auvk.traceBegin("handleGetFriendList");
      if (i4 == 0)
      {
        this.cvc = 0;
        l = System.currentTimeMillis();
      }
      g(paramGetFriendListResp.cShowPcIcon);
      acff localacff = (acff)this.app.getManager(51);
      abhh localabhh = (abhh)this.app.getManager(153);
      VasFaceManager localVasFaceManager = ((aqrc)this.app.getManager(235)).a;
      Object localObject2 = (ku)this.app.getManager(42);
      Object localObject3;
      Object localObject1;
      if ((paramGetFriendListResp.stSelfInfo != null) && (i4 == 0))
      {
        localObject3 = paramGetFriendListResp.stSelfInfo;
        localObject1 = localacff.e(this.app.getCurrentAccountUin());
        if (localObject1 != null) {
          break label4594;
        }
        localObject1 = new Friends();
        ((Friends)localObject1).name = ((FriendInfo)localObject3).nick;
        ((Friends)localObject1).remark = ((FriendInfo)localObject3).remark;
        ((Friends)localObject1).uin = String.valueOf(((FriendInfo)localObject3).friendUin);
        ((Friends)localObject1).cSpecialFlag = ((FriendInfo)localObject3).cSpecialFlag;
        ((Friends)localObject1).detalStatusFlag = ((FriendInfo)localObject3).detalStatusFlag;
        ((Friends)localObject1).alias = ((FriendInfo)localObject3).sShowName;
        ((Friends)localObject1).iBatteryStatus = ((FriendInfo)localObject3).iBatteryStatus;
        ((Friends)localObject1).uExtOnlineStatus = ((FriendInfo)localObject3).uExtOnlineStatus;
        akum.b((Friends)localObject1, ((FriendInfo)localObject3).vecMusicInfo, "GetFriendList(self)");
        aktp.a((Friends)localObject1, ((FriendInfo)localObject3).vecPoiInfo, "GetFriendList(self)");
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, new Object[] { "handleGetFriendList selfUin=" + ((Friends)localObject1).uin + ", cSpecialFlag=" + ((Friends)localObject1).cSpecialFlag, " battery:", Integer.valueOf(((FriendInfo)localObject3).iBatteryStatus), " extOnline:", Long.valueOf(((FriendInfo)localObject3).uExtOnlineStatus) });
        }
      }
      label1887:
      label3300:
      label3562:
      label4588:
      label4594:
      for (;;)
      {
        ((Friends)localObject1).abilityBits = ((FriendInfo)localObject3).uAbiFlag;
        ((Friends)localObject1).eNetwork = ((FriendInfo)localObject3).eNetworkType;
        ((Friends)localObject1).groupid = -1;
        ((Friends)localObject1).qqVipInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_QQVIP.value(), ((Friends)localObject1).qqVipInfo);
        ((Friends)localObject1).superQqInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), ((Friends)localObject1).superQqInfo);
        ((Friends)localObject1).superVipInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), ((Friends)localObject1).superVipInfo);
        ((Friends)localObject1).bigClubInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_BIGCLUB.value(), ((Friends)localObject1).bigClubInfo);
        ((Friends)localObject1).cNewLoverDiamondFlag = ((FriendInfo)localObject3).cNewLoverDiamondFlag;
        if ((((FriendInfo)localObject3).oVipInfo != null) && (((FriendInfo)localObject3).oVipInfo.mOpenInfo != null))
        {
          localObject4 = (VipOpenInfo)((FriendInfo)localObject3).oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
          if (localObject4 != null) {
            ((Friends)localObject1).superVipTemplateId = ((int)((VipOpenInfo)localObject4).lNameplateId);
          }
          localObject4 = (VipOpenInfo)((FriendInfo)localObject3).oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
          if (localObject4 != null) {
            ((Friends)localObject1).bigClubTemplateId = ((int)((VipOpenInfo)localObject4).lNameplateId);
          }
          ((Friends)localObject1).nameplateVipType = ((FriendInfo)localObject3).oVipInfo.iNameplateVipType;
          ((Friends)localObject1).grayNameplateFlag = ((FriendInfo)localObject3).oVipInfo.iGrayNameplateFlag;
        }
        ((Friends)localObject1).namePlateOfKingGameId = ((FriendInfo)localObject3).uGameAppid;
        ((Friends)localObject1).namePlateOfKingLoginTime = ((FriendInfo)localObject3).uGameLastLoginTime;
        ((Friends)localObject1).namePlateOfKingDan = ((int)((FriendInfo)localObject3).ulKingOfGloryRank);
        if (((FriendInfo)localObject3).cKingOfGloryFlag == 1) {}
        int i3;
        int i2;
        for (boolean bool1 = true;; bool1 = false)
        {
          ((Friends)localObject1).namePlateOfKingDanDisplatSwitch = bool1;
          localacff.e((Friends)localObject1);
          localVasFaceManager.gu(((Friends)localObject1).uin, (int)((FriendInfo)localObject3).uFaceStoreId);
          if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler.selfFontEffect", 2, "self fontEffect: " + (int)((FriendInfo)localObject3).uFontEffect);
          }
          ((ku)localObject2).m(((Friends)localObject1).uin, (int)((FriendInfo)localObject3).uFontEffect);
          this.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.app.getCurrentUin(), ((Friends)localObject1).namePlateOfKingDanDisplatSwitch).apply();
          if (paramGetFriendListResp.vecGroupInfo == null) {
            break label1302;
          }
          i3 = paramGetFriendListResp.vecGroupInfo.size();
          localObject1 = new Groups[i3];
          i2 = 0;
          while (i2 < i3)
          {
            localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(i2);
            localObject3 = new Groups();
            ((Groups)localObject3).group_id = ((GroupInfo)localObject2).groupId;
            ((Groups)localObject3).group_name = ((GroupInfo)localObject2).groupname;
            ((Groups)localObject3).group_friend_count = ((GroupInfo)localObject2).friend_count;
            ((Groups)localObject3).seqid = ((GroupInfo)localObject2).seqid;
            ((Groups)localObject3).datetime = l;
            localObject1[i2] = localObject3;
            i2 += 1;
          }
        }
        if ((i3 > 0) && (QLog.isColorLevel()))
        {
          localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(0);
          QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + aqft.pk(((GroupInfo)localObject2).groupname) + ", " + ((GroupInfo)localObject2).friend_count + ", " + ((GroupInfo)localObject2).sqqOnLine_count + ", " + ((GroupInfo)localObject2).seqid);
        }
        localacff.a((Groups[])localObject1);
        int i7 = paramGetFriendListResp.vecFriendInfo.size();
        this.cvc += i7;
        localObject2 = new Friends[i7];
        localObject3 = new ArrayList(i7);
        Object localObject4 = new ArrayList(i7);
        boolean bool4;
        Object localObject7;
        ArrayList localArrayList2;
        ArrayList localArrayList3;
        HashMap localHashMap1;
        ArrayList localArrayList4;
        HashMap localHashMap2;
        ArrayList localArrayList5;
        Object localObject6;
        Object localObject5;
        Object localObject8;
        Friends localFriends;
        Object localObject9;
        boolean bool2;
        if (i4 + i5 >= paramGetFriendListResp.totoal_friend_count)
        {
          bool4 = true;
          localObject7 = abbf.a(this.app);
          localArrayList2 = new ArrayList();
          localArrayList3 = new ArrayList();
          localHashMap1 = new HashMap();
          localArrayList4 = new ArrayList();
          localHashMap2 = new HashMap();
          localArrayList5 = new ArrayList();
          localObject6 = new ArrayList();
          localObject5 = new ArrayList();
          i2 = 0;
          if (i2 >= i7) {
            break label3562;
          }
          localObject8 = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(i2);
          localFriends = new Friends();
          localObject2[i2] = localFriends;
          localFriends.name = ((FriendInfo)localObject8).nick;
          localFriends.remark = ((FriendInfo)localObject8).remark;
          localFriends.uin = String.valueOf(((FriendInfo)localObject8).friendUin);
          localArrayList1.add(localFriends.uin);
          localFriends.groupid = ((FriendInfo)localObject8).groupId;
          localFriends.cSpecialFlag = ((FriendInfo)localObject8).cSpecialFlag;
          localFriends.detalStatusFlag = ((FriendInfo)localObject8).detalStatusFlag;
          localFriends.datetime = l;
          localFriends.alias = ((FriendInfo)localObject8).sShowName;
          localFriends.abilityBits = ((FriendInfo)localObject8).uAbiFlag;
          localFriends.eNetwork = ((FriendInfo)localObject8).eNetworkType;
          localFriends.netTypeIconId = ((FriendInfo)localObject8).eIconType;
          localFriends.strTermDesc = ((FriendInfo)localObject8).strTermDesc;
          localFriends.setShieldFlag(false);
          localFriends.namePlateOfKingGameId = ((FriendInfo)localObject8).uGameAppid;
          localFriends.namePlateOfKingLoginTime = ((FriendInfo)localObject8).uGameLastLoginTime;
          localFriends.namePlateOfKingDan = ((int)((FriendInfo)localObject8).ulKingOfGloryRank);
          if (((FriendInfo)localObject8).cKingOfGloryFlag != 1) {
            break label3264;
          }
          bool1 = true;
          localFriends.namePlateOfKingDanDisplatSwitch = bool1;
          localFriends.strMasterUin = ((FriendInfo)localObject8).strMasterUin;
          localFriends.uExtOnlineStatus = ((FriendInfo)localObject8).uExtOnlineStatus;
          localFriends.iBatteryStatus = ((FriendInfo)localObject8).iBatteryStatus;
          akum.b(localFriends, ((FriendInfo)localObject8).vecMusicInfo, "GetFriendList");
          aktp.a(localFriends, ((FriendInfo)localObject8).vecPoiInfo, "GetFriendList");
          if ((!TextUtils.isEmpty(localFriends.uin)) && (this.app.getCurrentUin().equals(localFriends.uin))) {
            this.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.app.getCurrentUin(), localFriends.namePlateOfKingDanDisplatSwitch).apply();
          }
          if (((FriendInfo)localObject8).cOlympicTorch != 1) {
            break label3270;
          }
          bool1 = true;
          localFriends.setOlympicTorchFlag(bool1);
          localObject1 = localacff.e(localFriends.uin);
          localFriends.iTermType = ((FriendInfo)localObject8).iTermType;
          localObject9 = ((FriendInfo)localObject8).oVipInfo;
          int i8 = EVIPSPEC.E_SP_QQVIP.value();
          if (localObject1 == null) {
            break label3276;
          }
          i3 = ((Friends)localObject1).qqVipInfo;
          localFriends.qqVipInfo = a((VipBaseInfo)localObject9, i8, i3);
          localObject9 = ((FriendInfo)localObject8).oVipInfo;
          i8 = EVIPSPEC.E_SP_SUPERQQ.value();
          if (localObject1 == null) {
            break label3282;
          }
          i3 = ((Friends)localObject1).superQqInfo;
          localFriends.superQqInfo = a((VipBaseInfo)localObject9, i8, i3);
          localObject9 = ((FriendInfo)localObject8).oVipInfo;
          i8 = EVIPSPEC.E_SP_SUPERVIP.value();
          if (localObject1 == null) {
            break label3288;
          }
          i3 = ((Friends)localObject1).superVipInfo;
          localFriends.superVipInfo = a((VipBaseInfo)localObject9, i8, i3);
          localObject9 = ((FriendInfo)localObject8).oVipInfo;
          i8 = EVIPSPEC.E_SP_BIGCLUB.value();
          if (localObject1 == null) {
            break label3294;
          }
          i3 = ((Friends)localObject1).bigClubInfo;
          localFriends.bigClubInfo = a((VipBaseInfo)localObject9, i8, i3);
          localFriends.cNewLoverDiamondFlag = ((FriendInfo)localObject8).cNewLoverDiamondFlag;
          if ((((FriendInfo)localObject8).oVipInfo != null) && (((FriendInfo)localObject8).oVipInfo.mOpenInfo != null))
          {
            localObject9 = (VipOpenInfo)((FriendInfo)localObject8).oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
            if (localObject9 != null) {
              localFriends.superVipTemplateId = ((int)((VipOpenInfo)localObject9).lNameplateId);
            }
            localObject9 = (VipOpenInfo)((FriendInfo)localObject8).oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
            if (localObject9 != null) {
              localFriends.bigClubTemplateId = ((int)((VipOpenInfo)localObject9).lNameplateId);
            }
            localFriends.nameplateVipType = ((FriendInfo)localObject8).oVipInfo.iNameplateVipType;
            localFriends.grayNameplateFlag = ((FriendInfo)localObject8).oVipInfo.iGrayNameplateFlag;
          }
          if (localObject1 != null)
          {
            localFriends.showLoginClient = ((Friends)localObject1).showLoginClient;
            localFriends.lastLoginType = ((Friends)localObject1).lastLoginType;
          }
          if ((localObject1 != null) && (ackd.ay(localFriends.name, ((Friends)localObject1).name)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend Name changed.oldName " + ((Friends)localObject1).name + ",newName " + localFriends.name + ",oldRemark " + ((Friends)localObject1).remark + ",newRemark =" + localFriends.remark);
            }
            ((ArrayList)localObject6).add(localFriends);
          }
          if ((localObject1 != null) && (!TextUtils.isEmpty(((FriendInfo)localObject8).nick)) && (!((FriendInfo)localObject8).nick.equals(((FriendInfo)localObject8).remark)) && (ackd.az(localFriends.remark, ((Friends)localObject1).remark)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend remark changed.oldName " + ((Friends)localObject1).name + ",newName " + localFriends.name + ",oldRemark " + ((Friends)localObject1).remark + ",newRemark =" + localFriends.remark);
            }
            ((ArrayList)localObject5).add(localFriends);
          }
          if (localObject1 != null)
          {
            if (((Friends)localObject1).gathtertype != 1) {
              break label3300;
            }
            localFriends.gathtertype = 1;
            localFriends.age = ((Friends)localObject1).age;
            localFriends.smartRemark = ((Friends)localObject1).smartRemark;
            localFriends.gender = ((Friends)localObject1).gender;
            localFriends.recommReason = ((Friends)localObject1).recommReason;
          }
          localObject1 = localacff.a(String.valueOf(localFriends.uin));
          i3 = ((FriendInfo)localObject8).cSpecialFlag >> 3 & 0x1;
          bool1 = false;
          if (localObject1 != null) {
            break label3318;
          }
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = String.valueOf(localFriends.uin);
          ((ExtensionInfo)localObject1).pendantId = ((FriendInfo)localObject8).ulFaceAddonId;
          ((ExtensionInfo)localObject1).uVipFont = ku.h(((FriendInfo)localObject8).uFounderFont);
          ((ExtensionInfo)localObject1).vipFontType = ku.c(((FriendInfo)localObject8).uFounderFont);
          ((ExtensionInfo)localObject1).magicFont = i3;
          ((ExtensionInfo)localObject1).colorRingId = ((FriendInfo)localObject8).uColorRing;
          ((ExtensionInfo)localObject1).timestamp = l;
          ((ExtensionInfo)localObject1).fontEffect = ((int)((FriendInfo)localObject8).uFontEffect);
          ((ExtensionInfo)localObject1).fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
          ((ArrayList)localObject3).add(localObject1);
          bool1 = true;
          bool2 = true;
        }
        for (;;)
        {
          if (((ExtensionInfo)localObject1).faceId != ((FriendInfo)localObject8).uFaceStoreId) {
            bool1 = true;
          }
          for (;;)
          {
            ((ExtensionInfo)localObject1).faceId = ((int)((FriendInfo)localObject8).uFaceStoreId);
            ((ExtensionInfo)localObject1).faceIdUpdateTime = NetConnInfoCenter.getServerTime();
            localObject9 = new SpecialCareInfo();
            if (a(((FriendInfo)localObject8).vecRing, (ExtensionInfo)localObject1, localFriends, (Set)localObject7, localArrayList2, localArrayList3, localHashMap1, localArrayList4, localHashMap2, (SpecialCareInfo)localObject9, l)) {
              bool1 = true;
            }
            if (((SpecialCareInfo)localObject9).globalSwitch != 0) {
              localArrayList5.add(localObject9);
            }
            if (ajok.a(this.app, localFriends, (ExtensionInfo)localObject1, ((FriendInfo)localObject8).vecIntimateInfo)) {}
            for (boolean bool3 = true;; bool3 = bool1)
            {
              bool1 = bool3;
              if (i6 == 0)
              {
                bool1 = bool3;
                if (wky.a(this.app, localacff, localFriends, (ExtensionInfo)localObject1, localFriends.uin, ((FriendInfo)localObject8).vecExtSnsFrdData)) {
                  bool1 = true;
                }
              }
              bool3 = bool1;
              if (i1 == 0)
              {
                bool3 = bool1;
                if (ajnp.b(this.app, localacff, localFriends, (ExtensionInfo)localObject1, localFriends.uin, ((FriendInfo)localObject8).vecMutualMarkData)) {
                  bool3 = true;
                }
              }
              if ((!bool2) && (bool3)) {
                ((ArrayList)localObject3).add(localObject1);
              }
              localObject9 = localabhh.b(localFriends.uin);
              if (localObject9 != null) {
                if ((((ApolloBaseInfo)localObject9).apolloStatus != ((FriendInfo)localObject8).cApolloFlag) || (((ApolloBaseInfo)localObject9).apolloServerTS != ((FriendInfo)localObject8).uApolloTimestamp) || (((ApolloBaseInfo)localObject9).apolloSignValidTS != ((FriendInfo)localObject8).uApolloSignTime) || (((ApolloBaseInfo)localObject9).cmshow3dFlag != ((FriendInfo)localObject8).cCentiShow3DFlag))
                {
                  ((ApolloBaseInfo)localObject9).apolloStatus = ((FriendInfo)localObject8).cApolloFlag;
                  ((ApolloBaseInfo)localObject9).apolloServerTS = ((FriendInfo)localObject8).uApolloTimestamp;
                  ((ApolloBaseInfo)localObject9).apolloSignValidTS = ((FriendInfo)localObject8).uApolloSignTime;
                  ((ApolloBaseInfo)localObject9).apolloSignStr = "";
                  ((ApolloBaseInfo)localObject9).cmshow3dFlag = ((FriendInfo)localObject8).cCentiShow3DFlag;
                  ((ApolloBaseInfo)localObject9).apolloUpdateTime = NetConnInfoCenter.getServerTime();
                  ((ArrayList)localObject4).add(localObject9);
                }
              }
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  localObject9 = new StringBuilder();
                  ((StringBuilder)localObject9).append("handleGetFriendList, Get Extension").append(", uin=").append(((ExtensionInfo)localObject1).uin).append(", id=").append(((ExtensionInfo)localObject1).pendantId).append(", font=").append(((ExtensionInfo)localObject1).uVipFont).append(", fontType=").append(((ExtensionInfo)localObject1).vipFontType).append(", magicfont=").append(i3).append(", latestplNewsTs=").append(((ExtensionInfo)localObject1).latestPLUpdateTimestamp).append(", fontEffect=").append(((ExtensionInfo)localObject1).fontEffect).append(", fontEffectLastUpdateTime=").append(((ExtensionInfo)localObject1).fontEffectLastUpdateTime).append(", extensionAdded=").append(bool2).append(", extensionChanged=").append(bool3).append(", cSpecialFlag=").append(localFriends.cSpecialFlag).append(", battery=").append(((FriendInfo)localObject8).iBatteryStatus).append(", extOnline=").append(((FriendInfo)localObject8).uExtOnlineStatus).append(", cmshow3dFlag=").append(((FriendInfo)localObject8).cCentiShow3DFlag).append(", apolloServerTS=").append(((FriendInfo)localObject8).uApolloTimestamp).append(", apolloStatus=").append(((FriendInfo)localObject8).cApolloFlag);
                  QLog.d("FriendListHandler", 2, ((StringBuilder)localObject9).toString());
                }
                i2 += 1;
                break label1450;
                bool4 = false;
                break;
                bool1 = false;
                break label1667;
                bool1 = false;
                break label1831;
                i3 = 0;
                break label1887;
                i3 = 0;
                break label1928;
                i3 = 0;
                break label1969;
                i3 = 0;
                break label2010;
                if (((Friends)localObject1).gathtertype != 2) {
                  break label2453;
                }
                localFriends.gathtertype = 2;
                break label2453;
                label3318:
                if ((((ExtensionInfo)localObject1).pendantId == ((FriendInfo)localObject8).ulFaceAddonId) && (((ExtensionInfo)localObject1).uVipFont == ku.h(((FriendInfo)localObject8).uFounderFont)) && (((ExtensionInfo)localObject1).vipFontType == ku.c(((FriendInfo)localObject8).uFounderFont)) && (((ExtensionInfo)localObject1).colorRingId == ((FriendInfo)localObject8).uColorRing) && (((ExtensionInfo)localObject1).magicFont == i3) && (((ExtensionInfo)localObject1).latestPLUpdateTimestamp == ((FriendInfo)localObject8).uTagUpdateTime) && (((ExtensionInfo)localObject1).fontEffect == (int)((FriendInfo)localObject8).uFontEffect)) {
                  break label4588;
                }
                ((ExtensionInfo)localObject1).pendantId = ((FriendInfo)localObject8).ulFaceAddonId;
                ((ExtensionInfo)localObject1).uVipFont = ku.h(((FriendInfo)localObject8).uFounderFont);
                ((ExtensionInfo)localObject1).vipFontType = ku.c(((FriendInfo)localObject8).uFounderFont);
                ((ExtensionInfo)localObject1).magicFont = i3;
                ((ExtensionInfo)localObject1).colorRingId = ((FriendInfo)localObject8).uColorRing;
                ((ExtensionInfo)localObject1).timestamp = l;
                ((ExtensionInfo)localObject1).latestPLUpdateTimestamp = ((FriendInfo)localObject8).uTagUpdateTime;
                ((ExtensionInfo)localObject1).fontEffect = ((int)((FriendInfo)localObject8).uFontEffect);
                ((ExtensionInfo)localObject1).fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
                ((ArrayList)localObject3).add(localObject1);
                bool1 = true;
                bool2 = true;
                break label2642;
                if (QLog.isColorLevel()) {
                  QLog.e("FriendListHandler", 2, "apolloBaseInfo return null uin: " + localFriends.uin);
                }
              }
              localObject1 = (acdu)this.app.getManager(53);
              if (((ArrayList)localObject6).size() > 0)
              {
                localObject6 = ((ArrayList)localObject6).iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  localObject7 = (Friends)((Iterator)localObject6).next();
                  localObject8 = ((Friends)localObject7).name;
                  ackd.a(Long.parseLong(((Friends)localObject7).uin), (String)localObject8, (acdu)localObject1);
                }
              }
              if (((ArrayList)localObject5).size() > 0)
              {
                localObject5 = ((ArrayList)localObject5).iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  localObject6 = (Friends)((Iterator)localObject5).next();
                  localObject7 = ((Friends)localObject6).remark;
                  ackd.b(Long.parseLong(((Friends)localObject6).uin), (String)localObject7, (acdu)localObject1);
                }
              }
              if ((i7 > 0) && (QLog.isColorLevel()))
              {
                localObject1 = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
                QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendList uin=" + ((FriendInfo)localObject1).friendUin + " | eNetwork=" + ((FriendInfo)localObject1).eNetworkType + " | iTermType=" + ((FriendInfo)localObject1).iTermType + " | abilityBits=" + ((FriendInfo)localObject1).uAbiFlag + " | name=" + aqft.pk(((FriendInfo)localObject1).nick) + " | netTypeIconId=" + ((FriendInfo)localObject1).eIconType + " | detalStatusFlag=" + ((FriendInfo)localObject1).detalStatusFlag + " | isMqqOnLine=" + ((FriendInfo)localObject1).isMqqOnLine + " | netTypeIconIdIphoneOrWphoneNoWifi=" + ((FriendInfo)localObject1).eIconType + " | hasTorch=" + ((FriendInfo)localObject1).cOlympicTorch);
              }
              if (QLog.isColorLevel()) {
                QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendList uin=" + this.app.getCurrentAccountUin() + " | size:" + i7 + " | extensionInfoList.size:" + ((ArrayList)localObject3).size());
              }
              asgx.a(this.app, (Friends[])localObject2);
              localacff.a((Friends[])localObject2, l, bool4);
              localacff.iN((List)localObject3);
              localVasFaceManager.h((Collection)localObject3);
              localacff.a(localArrayList5, l, bool4);
              localabhh.hW((List)localObject4);
              if (localHashMap2.size() > 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("tag_hidden_chat", 2, new Object[] { "friendlist size", Integer.valueOf(localHashMap2.size()) });
                }
                FriendsStatusUtil.b(localHashMap2, this.app);
              }
              for (;;)
              {
                abbf.b(localArrayList2, this.app);
                abbf.c(localArrayList3, this.app);
                abbf.a(localHashMap1, this.app);
                abbf.d(localArrayList4, this.app);
                auvk.traceEnd();
                if (bool4) {
                  break;
                }
                a(paramString, i4 + i5, 200, 0, 0, l, localArrayList1, true, bool5, paramGetFriendListResp.totoal_friend_count);
                notifyUI(1, true, Boolean.valueOf(false));
                notifyUI(99, true, new Object[] { Boolean.valueOf(false), null });
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("tag_hidden_chat", 2, "friendlist size 0");
                }
              }
              if (paramToServiceMsg.extraData.getShort("friendTotalCount") == 0)
              {
                i2 = paramGetFriendListResp.totoal_friend_count;
                a(true, i2, paramToServiceMsg.extraData.getShort("friendStartIndex"), 0);
                this.Py = 0L;
                this.cvc = 0;
                paramString = new StringBuilder().append("actual friend count is ");
                if (this.cvc != paramGetFriendListResp.totoal_friend_count) {
                  break label4475;
                }
                bool1 = true;
                QLog.d("FriendListHandler", 2, bool1);
                paramString = (PhoneContactManagerImp)this.app.getManager(11);
                if (paramString != null)
                {
                  paramString.clK();
                  if (!bool5) {
                    paramString.clH();
                  }
                }
                this.app.cLK();
                notifyUI(1, true, Boolean.valueOf(true));
                notifyUI(99, true, new Object[] { Boolean.valueOf(true), null });
                if (!localArrayList1.isEmpty())
                {
                  paramString = new String[localArrayList1.size()];
                  localArrayList1.toArray(paramString);
                  localArrayList1.clear();
                  if (!this.app.a.abT()) {
                    break label4481;
                  }
                  J(paramString);
                }
                c(localacff);
                ackd.P(this.app, "775_hot_friend_new_boat_clear_version");
                ackd.P(this.app, "top_position_and_disturb_clear_version");
                ackd.P(this.app, "check_message_preview_version_clear");
                l = paramGetFriendListResp.serverTime;
                this.Pz = l;
                i2 = 1;
                if (i2 >= 19) {
                  break label4557;
                }
                if ((k == 0) || (i2 != 16)) {
                  break label4489;
                }
              }
              for (;;)
              {
                i2 += 1;
                break label4432;
                i2 = paramToServiceMsg.extraData.getShort("friendTotalCount");
                break;
                label4475:
                bool1 = false;
                break label4250;
                this.ef = paramString;
                break label4381;
                if (((i1 == 0) || (i2 != 18)) && (i2 != 13)) {
                  this.app.getPreferences().edit().putLong("inccheckupdatetimeStamp" + i2, l).commit();
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "FriendListHandler in handleGetFriendList() to getGatheredContactsList()");
              }
              IY(0);
              return;
            }
          }
          bool2 = false;
        }
      }
      label2010:
      label3294:
      k = 0;
      label2642:
      label3288:
      i1 = 0;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle)
  {
    Object localObject2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      if (paramBundle != null) {
        paramBundle.getString("troop_uin");
      }
      localObject2 = new StringBuilder(300);
      localStringBuilder = ((StringBuilder)localObject2).append("addFriendInternal, uin:").append(paramString1).append(", sourceID:").append(paramInt2).append(", subSourceId:").append(paramInt3).append(", extraUin:").append(paramString2).append(", friendSetting:").append(paramInt1).append(", groupId:").append(paramByte1).append(", msg:").append(paramString3).append(", autoSend:").append(paramBoolean1).append(", isContactBothWay:").append(paramBoolean2).append(", remark:").append(paramString4).append(", sourceName:").append(paramString5).append(", myCard:").append(paramByte2).append(", extraParam:").append(paramBundle).append(", sig:");
      if (paramArrayOfByte != null) {
        break label532;
      }
      localObject1 = "null";
      localStringBuilder = localStringBuilder.append(localObject1).append(", ticket:");
      if (paramString6 != null) {
        break label543;
      }
    }
    label532:
    label543:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramString6.length()))
    {
      localStringBuilder.append(localObject1);
      QLog.d("addFriendTag", 2, ((StringBuilder)localObject2).toString());
      localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.addFriend");
      localObject2 = ((ToServiceMsg)localObject1).extraData;
      ((Bundle)localObject2).putString("uin", paramString1);
      ((Bundle)localObject2).putInt("friend_setting", paramInt1);
      ((Bundle)localObject2).putByte("group_id", paramByte1);
      ((Bundle)localObject2).putString("msg", paramString3);
      ((Bundle)localObject2).putInt("source_id", paramInt2);
      ((Bundle)localObject2).putByte("show_my_card", paramByte2);
      ((Bundle)localObject2).putInt("sub_source_id", paramInt3);
      ((Bundle)localObject2).putString("extra", paramString2);
      ((Bundle)localObject2).putBoolean("auto_send", paramBoolean1);
      ((Bundle)localObject2).putByteArray("sig", paramArrayOfByte);
      ((Bundle)localObject2).putBoolean("contact_bothway", paramBoolean2);
      ((Bundle)localObject2).putString("remark", paramString4);
      ((Bundle)localObject2).putString("src_name", paramString5);
      if (paramBundle != null)
      {
        ((Bundle)localObject2).putString("troop_uin", paramBundle.getString("troop_uin"));
        ((Bundle)localObject2).putString("troop_code", paramBundle.getString("troop_code"));
        ((Bundle)localObject2).putInt("flc_notify_type", paramBundle.getInt("flc_notify_type"));
        ((Bundle)localObject2).putString("flc_recommend_uin", paramBundle.getString("flc_recommend_uin"));
        paramString2 = paramBundle.getByteArray("friend_src_desc");
        if (paramString2 != null) {
          ((Bundle)localObject2).putByteArray("friend_src_desc", paramString2);
        }
      }
      paramString1 = this.jdField_a_of_type_Aluh.b(paramString1, paramInt2, paramInt3);
      if ((paramString1 != null) && (paramString1.length > 0)) {
        ((Bundle)localObject2).putByteArray("flc_add_frd_token", paramString1);
      }
      ((Bundle)localObject2).putString("security_ticket", paramString6);
      send((ToServiceMsg)localObject1);
      return;
      localObject1 = Integer.valueOf(paramArrayOfByte.length);
      break;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, short paramShort, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("reqGetStatus", str);
      localHashMap.put("currNetStatus", jqc.hS());
      localHashMap.put("friendListCount", "" + paramInt1);
      localHashMap.put("fromIndex", "" + paramShort);
      localHashMap.put("reqCountEveryPage", "200");
      localHashMap.put("retryCount", "" + this.cvb);
      localHashMap.put("totalConsume", "" + (System.currentTimeMillis() - this.Py));
      localHashMap.put("errorCode", "" + paramInt2);
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "QQFriendListReqGetEvent", true, 0L, 0L, localHashMap, null);
      this.cvb = 0;
      if (paramBoolean) {
        break;
      }
      this.cva += 1;
      if (this.Px == 0L) {
        this.Px = this.Py;
      }
      return;
    }
    cII();
  }
  
  private void a(byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo, Friends paramFriends, SpecialCareInfo paramSpecialCareInfo, long paramLong)
  {
    Object localObject1 = new Oidb_0x5d0.SnsUpateBuffer();
    try
    {
      ((Oidb_0x5d0.SnsUpateBuffer)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject1;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.rpt_msg_sns_update_item.has())) {
        break label977;
      }
      localObject1 = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject1).next();
        if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has()))
        {
          paramSpecialCareInfo.uin = paramFriends.uin;
          paramSpecialCareInfo.dateTime = paramLong;
          int k = localSnsUpdateItem.uint32_update_sns_type.get();
          Object localObject3 = localSnsUpdateItem.bytes_value.get().toStringUtf8();
          label646:
          label694:
          long l;
          label761:
          Object localObject2;
          switch (k)
          {
          case 13569: 
          case 13570: 
          case 13571: 
          case 13574: 
          case 13576: 
          case 13577: 
          default: 
            break;
          case 13568: 
            abbf.a(String.valueOf(paramArrayOfByte.uint64_uin.get()), localSnsUpdateItem.bytes_value.get().toStringUtf8(), this.app);
            try
            {
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                paramSpecialCareInfo.specialRingSwitch = 0;
              }
              while (QLog.isColorLevel())
              {
                QLog.d("FriendListHandler", 2, new Object[] { "updateSnsDataSingle: invoked(旧的特别关心铃声和开关，不需要同步到新的开关上，新开关仅适用0x350e). friendlist::ring switch & id", " info: ", paramSpecialCareInfo });
                break;
                if (Pattern.compile("[0-9]*").matcher((CharSequence)localObject3).matches())
                {
                  paramSpecialCareInfo.friendRingId = Integer.parseInt((String)localObject3);
                  paramSpecialCareInfo.specialRingSwitch = 1;
                }
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException1);
                }
                paramSpecialCareInfo.specialRingSwitch = 0;
              }
            }
          case 13578: 
            localObject3 = new FriendsStatusUtil.UpdateFriendStatusItem(paramFriends.uin, 13578, 18);
            if (!localException1.bytes_value.has()) {
              ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).aT(null);
            }
            for (;;)
            {
              FriendsStatusUtil.a(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject3, paramExtensionInfo);
              break;
              ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).aT(localException1.bytes_value.get().toByteArray());
            }
          case 13579: 
            localObject3 = new String(localException1.bytes_value.get().toByteArray());
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, new Object[] { "updateSnsDataSingle, friend.uin=", paramFriends.uin, " setTime=", localObject3 });
            }
            localObject3 = new FriendsStatusUtil.UpdateFriendStatusItem(paramFriends.uin, 13579, 19);
            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).aU(localException1.bytes_value.get().toByteArray());
            FriendsStatusUtil.a(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject3, paramExtensionInfo);
            break;
          case 13573: 
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label646;
              }
              paramSpecialCareInfo.globalSwitch = 0;
            }
            catch (Exception localException2) {}
            if (QLog.isColorLevel())
            {
              QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException2);
              continue;
              paramSpecialCareInfo.globalSwitch = 1;
            }
            break;
          case 13572: 
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label694;
              }
              paramSpecialCareInfo.qzoneSwitch = 0;
            }
            catch (Exception localException3) {}
            if (QLog.isColorLevel())
            {
              QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException3);
              continue;
              paramSpecialCareInfo.qzoneSwitch = 1;
            }
            break;
          case 13575: 
            a(String.valueOf(paramArrayOfByte.uint64_uin.get()), localException3.bytes_value.get().toByteArray(), paramExtensionInfo);
            break;
          case 13581: 
            l = paramArrayOfByte.uint64_uin.get();
            if (TextUtils.isEmpty(localException3.bytes_value.get().toStringUtf8()))
            {
              k = 0;
              localObject2 = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(l), 13581, 21);
              if (k != 0) {
                break label810;
              }
              ((FriendsStatusUtil.UpdateFriendStatusItem)localObject2).aT(null);
            }
            for (;;)
            {
              FriendsStatusUtil.a(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject2, paramExtensionInfo);
              break;
              k = 1;
              break label761;
              ((FriendsStatusUtil.UpdateFriendStatusItem)localObject2).aT(new byte[1]);
            }
          case 13582: 
            l = paramArrayOfByte.uint64_uin.get();
            localObject2 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toByteArray();
            localObject3 = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(l), 13582, 21);
            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).aU((byte[])localObject2);
            FriendsStatusUtil.a(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject3, paramExtensionInfo);
            break;
          case 13580: 
            label810:
            localObject3 = String.valueOf(paramArrayOfByte.uint64_uin.get());
            FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem((String)localObject3, 13580, 21);
            if (((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.has())
            {
              localUpdateFriendStatusItem.aU(((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toByteArray());
              FriendsStatusUtil.a(this.app, localUpdateFriendStatusItem, paramExtensionInfo);
            }
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, new Object[] { "updateSnsDataSingle: invoked. UPDATE_SNS_TYPE_RING_ID uin:", localObject3 });
            }
            break;
          }
        }
      }
      label977:
      paramArrayOfByte = paramFriends.uin;
      if (!abbf.e(paramArrayOfByte, this.app)) {
        break label1001;
      }
      abbf.h(paramArrayOfByte, this.app);
      label1001:
      if (!abbf.f(paramArrayOfByte, this.app)) {
        return;
      }
      abbf.i(paramArrayOfByte, this.app);
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.rpt_uin32_idlist.has()))
    {
      localObject1 = paramArrayOfByte.rpt_uin32_idlist.get().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((Integer)((Iterator)localObject1).next()).intValue() == 4051) {
          paramFriends.setShieldFlag(true);
        }
      }
    }
  }
  
  private void a(String[] paramArrayOfString, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramInt1 >= paramArrayOfString.length) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "doGetRichStatus uinArray.lenth = " + paramArrayOfString.length + " reqType = " + paramInt2 + "pos = " + paramInt1);
    }
    int k = Math.min(50, paramArrayOfString.length - paramInt1);
    String[] arrayOfString = new String[k];
    System.arraycopy(paramArrayOfString, paramInt1, arrayOfString, 0, k);
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GetRichSig");
    localToServiceMsg.extraData.putStringArray("totalArray", paramArrayOfString);
    localToServiceMsg.extraData.putInt("nextStartPos", k + paramInt1);
    localToServiceMsg.extraData.putStringArray("sendArray", arrayOfString);
    localToServiceMsg.extraData.putInt("reqType", paramInt2);
    localToServiceMsg.extraData.putBoolean("showDateNickname", paramBoolean);
    localToServiceMsg.extraData.putBundle("circleBundle", paramBundle);
    send(localToServiceMsg);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo)
  {
    boolean bool1 = false;
    int i15 = paramArrayOfByte.length;
    int i2;
    int i1;
    if (i15 >= 3)
    {
      i2 = paramArrayOfByte[0] & 0xFF;
      i1 = (paramArrayOfByte[1] << 8 & 0xFF00) + (paramArrayOfByte[2] & 0xFF);
      paramExtensionInfo.praiseHotLevel = i2;
      paramExtensionInfo.praiseDays = i1;
      bool1 = true;
    }
    for (;;)
    {
      int i4;
      int i3;
      if (i15 >= 6)
      {
        i4 = paramArrayOfByte[3] & 0xFF;
        i3 = (paramArrayOfByte[4] << 8 & 0xFF00) + (paramArrayOfByte[5] & 0xFF);
        paramExtensionInfo.chatHotLevel = i4;
        paramExtensionInfo.chatDays = i3;
        bool1 = true;
      }
      for (;;)
      {
        int i6;
        int i5;
        if (i15 >= 9)
        {
          i6 = paramArrayOfByte[6] & 0xFF;
          i5 = (paramArrayOfByte[7] << 8 & 0xFF00) + (paramArrayOfByte[8] & 0xFF);
          paramExtensionInfo.bestIntimacyType = i6;
          paramExtensionInfo.bestIntimacyDays = i5;
          bool1 = true;
        }
        for (;;)
        {
          int i7;
          if (i15 >= 11)
          {
            i7 = (paramArrayOfByte[9] << 8 & 0xFF00) + (paramArrayOfByte[10] & 0xFF);
            paramExtensionInfo.lastpraiseTime = (86400 * i7 - 28800);
            bool1 = true;
          }
          for (;;)
          {
            int i8;
            if (i15 >= 13)
            {
              i8 = (paramArrayOfByte[11] << 8 & 0xFF00) + (paramArrayOfByte[12] & 0xFF);
              paramExtensionInfo.lastChatTime = (86400 * i8 - 28800);
              bool1 = true;
            }
            for (;;)
            {
              int k;
              int i10;
              int i12;
              int i13;
              if (i15 >= 24)
              {
                k = paramArrayOfByte[18];
                i9 = paramArrayOfByte[19];
                i10 = paramArrayOfByte[20];
                i11 = paramArrayOfByte[21];
                i12 = paramArrayOfByte[22];
                i13 = paramArrayOfByte[23];
                paramExtensionInfo.loverChatLevel = (k & 0xFF);
                paramExtensionInfo.loverChatDays = ((i9 << 8 & 0xFF00) + (i10 & 0xFF));
                paramExtensionInfo.loverLastChatTime = (86400 * ((i11 << 8 & 0xFF00) + (i12 & 0xFF)) - 28800);
                paramExtensionInfo.loverFlag = (i13 & 0xFF);
                bool1 = true;
              }
              int i9 = 0;
              if (i15 >= 25) {
                i9 = paramArrayOfByte[24] & 0xFF;
              }
              boolean bool3 = paramExtensionInfo.loverTransFlag;
              boolean bool2;
              if (i9 != 0)
              {
                bool2 = true;
                if (bool3 != bool2)
                {
                  if (i9 == 0) {
                    break label993;
                  }
                  bool1 = true;
                  label418:
                  paramExtensionInfo.loverTransFlag = bool1;
                  bool1 = true;
                }
                if (i15 < 30) {
                  break label999;
                }
                i10 = paramArrayOfByte[25];
                k = paramArrayOfByte[26];
                i11 = paramArrayOfByte[27];
                i12 = paramArrayOfByte[28];
                i13 = paramArrayOfByte[29];
                paramExtensionInfo.newBestIntimacyType = (i10 & 0xFF);
                bool1 = true;
                i10 = (i12 << 8 & 0xFF00) + (i13 & 0xFF);
              }
              for (int i11 = (i11 & 0xFF) + (k << 8 & 0xFF00);; i11 = 0)
              {
                i13 = 0;
                i12 = 0;
                k = 0;
                int i14 = 0;
                if (i15 >= 33)
                {
                  i13 = paramArrayOfByte[30] & 0xFF;
                  i12 = (paramArrayOfByte[31] << 8 & 0xFF00) + (paramArrayOfByte[32] & 0xFF);
                  paramExtensionInfo.friendshipLevel = i13;
                  paramExtensionInfo.friendshipChatDays = i12;
                  k = i14;
                  if (i15 >= 35)
                  {
                    k = (paramArrayOfByte[33] << 8 & 0xFF00) + (paramArrayOfByte[34] & 0xFF);
                    paramExtensionInfo.lastFriendshipTime = (86400 * k - 28800);
                  }
                  bool1 = true;
                }
                if (ajol.arm())
                {
                  paramExtensionInfo.hasRemindChat = false;
                  paramExtensionInfo.hasRemindPraise = false;
                  paramExtensionInfo.hasRemindQzoneVisit = false;
                  paramExtensionInfo.hasRemindLoverChat = false;
                  bool1 = true;
                }
                if (QLog.isColorLevel())
                {
                  paramArrayOfByte = new StringBuilder(1024);
                  paramArrayOfByte.append(" FriendListHandler=== hotFriend uin: ").append(paramString).append(",dataLen=").append(i15).append(", praiseData=").append(i2).append("|").append(i1).append(",chatData=").append(i4).append("|").append(i3).append(",closeData=").append(i6).append("|").append(i5).append(",lastpraiseTime=").append(i7).append(",lastChatTime=").append(i8).append(",cLoverLevel=").append(paramExtensionInfo.loverChatLevel).append(",wLoverDay=").append(paramExtensionInfo.loverChatDays).append(",wLstLoverDay=").append(paramExtensionInfo.loverLastChatTime).append(",cLoverFlag=").append(paramExtensionInfo.loverFlag).append(",cTransFlag=").append(i9).append(",hasRemindChat=").append(paramExtensionInfo.hasRemindChat).append(",hasRemindPraise=").append(paramExtensionInfo.hasRemindPraise).append(",hasRemindQzoneVisit=").append(paramExtensionInfo.hasRemindQzoneVisit).append(",hasRemindLoverChat=").append(paramExtensionInfo.hasRemindLoverChat).append(",newBoatLevel=" + paramExtensionInfo.newBestIntimacyType + " | newBoatDay=" + i11 + " | lastNewBoatDay=" + i10).append(",friendshipData=").append(i13).append("|").append(i12).append("|").append(k);
                  QLog.i("FriendReactive", 2, paramArrayOfByte.toString());
                }
                return bool1;
                bool2 = false;
                break;
                label993:
                bool1 = false;
                break label418;
                label999:
                i10 = 0;
              }
              i8 = 0;
            }
            i7 = 0;
          }
          i5 = 0;
          i6 = 0;
        }
        i3 = 0;
        i4 = 0;
      }
      i1 = 0;
      i2 = 0;
    }
  }
  
  private boolean a(byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo, Friends paramFriends, Set<String> paramSet, List<String> paramList1, List<String> paramList2, Map<String, Integer> paramMap, List<String> paramList3, Map<String, Boolean> paramMap1, SpecialCareInfo paramSpecialCareInfo, long paramLong)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject1 = new Oidb_0x5d0.SnsUpateBuffer();
    try
    {
      ((Oidb_0x5d0.SnsUpateBuffer)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject1;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      if (paramArrayOfByte == null) {
        break label1367;
      }
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.rpt_uin32_idlist.has()))
    {
      localObject1 = paramArrayOfByte.rpt_uin32_idlist.get().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((Integer)((Iterator)localObject1).next()).intValue() == 4051) {
          paramFriends.setShieldFlag(true);
        }
      }
    }
    Object localObject2;
    int k;
    Object localObject4;
    Object localObject3;
    if (paramArrayOfByte.rpt_msg_sns_update_item.has())
    {
      localObject1 = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
      bool1 = bool2;
      bool2 = bool1;
      if (!((Iterator)localObject1).hasNext()) {
        break label1425;
      }
      localObject2 = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject2).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.has()))
      {
        paramSpecialCareInfo.uin = paramFriends.uin;
        paramSpecialCareInfo.dateTime = paramLong;
        k = ((Oidb_0x5d0.SnsUpdateItem)localObject2).uint32_update_sns_type.get();
        localObject4 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toStringUtf8();
        localObject3 = String.valueOf(paramArrayOfByte.uint64_uin.get());
        switch (k)
        {
        }
      }
    }
    for (;;)
    {
      break;
      localObject2 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toStringUtf8();
      if ((localObject2 == null) || (((String)localObject2).length() == 0))
      {
        if ((paramSet != null) && (paramSet.contains(localObject3))) {
          paramList2.add(localObject3);
        }
        if (abbf.f((String)localObject3, this.app)) {
          paramList3.add(localObject3);
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, new Object[] { "updateSnsDataBath: invoked. should turn off sound", " uinStr: ", localObject3 });
        }
      }
      try
      {
        label439:
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
        while (QLog.isColorLevel())
        {
          for (;;)
          {
            QLog.d("FriendListHandler", 2, new Object[] { "updateSnsDataBath: invoked(旧的特别关心铃声和开关，不需要同步到新的开关上，新开关仅适用0x350e). friendlist::ring switch & id", " info: ", paramSpecialCareInfo, " info.friendRingId: ", Integer.valueOf(paramSpecialCareInfo.friendRingId), " info.uin: ", paramSpecialCareInfo.uin });
            break;
            try
            {
              k = Integer.parseInt((String)localObject2);
              paramList1.add(localObject3);
              paramMap.put(localObject3, Integer.valueOf(k));
            }
            catch (Exception localException1) {}
          }
          if (!QLog.isColorLevel()) {
            break label439;
          }
          QLog.i("FriendListHandler", 2, "dealWithRespSound|exception = " + localException1.toString());
          break label439;
          if (Pattern.compile("[0-9]*").matcher((CharSequence)localObject4).matches())
          {
            paramSpecialCareInfo.friendRingId = Integer.parseInt((String)localObject4);
            paramSpecialCareInfo.specialRingSwitch = 1;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException2);
          }
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
      }
      localObject4 = new FriendsStatusUtil.UpdateFriendStatusItem((String)localObject3, 13580, 21);
      if (localException2.bytes_value.has())
      {
        ((FriendsStatusUtil.UpdateFriendStatusItem)localObject4).aU(localException2.bytes_value.get().toByteArray());
        FriendsStatusUtil.a(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject4, paramExtensionInfo);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, new Object[] { "updateSnsDataBath: invoked. UPDATE_SNS_TYPE_RING_ID uin:", localObject3 });
        continue;
        localObject4 = new FriendsStatusUtil.UpdateFriendStatusItem((String)localObject3, 13582, 21);
        if (localException2.bytes_value.has())
        {
          ((FriendsStatusUtil.UpdateFriendStatusItem)localObject4).aU(localException2.bytes_value.get().toByteArray());
          FriendsStatusUtil.a(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject4, paramExtensionInfo);
        }
        if (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler", 2, new Object[] { "updateSnsDataBath: invoked. inc update notification switch::preview & vibrate", " uinStr: ", localObject3 });
          continue;
          localObject3 = new FriendsStatusUtil.UpdateFriendStatusItem(paramFriends.uin, 13578, 18);
          if (!localException2.bytes_value.has()) {
            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).aT(null);
          }
          for (;;)
          {
            FriendsStatusUtil.a(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject3, paramExtensionInfo);
            break;
            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).aT(localException2.bytes_value.get().toByteArray());
          }
          localObject3 = new String(localException2.bytes_value.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, new Object[] { "这里是全量拉的免打扰 friend.uin=", paramFriends.uin, " setTime=", localObject3 });
          }
          localObject3 = new FriendsStatusUtil.UpdateFriendStatusItem(paramFriends.uin, 13579, 19);
          ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).aU(localException2.bytes_value.get().toByteArray());
          FriendsStatusUtil.b(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject3, paramExtensionInfo);
          continue;
          byte[] arrayOfByte = localException2.bytes_value.get().toByteArray();
          int i1 = 0;
          k = i1;
          if (arrayOfByte != null)
          {
            k = i1;
            if (arrayOfByte.length >= 1)
            {
              i1 = arrayOfByte[0] & 0x2;
              k = i1;
              if (i1 == 2)
              {
                paramFriends.friendType = 1;
                k = i1;
              }
            }
          }
          if (QLog.isColorLevel())
          {
            QLog.d("Q.contacttab.friend", 2, "handleGetFriendList | friend.uin : " + paramFriends.uin + " | friend.friendType : " + paramFriends.friendType + " | itemType : " + k);
            continue;
            try
            {
              if (TextUtils.isEmpty((CharSequence)localObject4))
              {
                paramSpecialCareInfo.globalSwitch = 0;
                if ((paramSet != null) && (paramSet.contains(localObject3))) {
                  paramList2.add(localObject3);
                }
                if (abbf.f((String)localObject3, this.app)) {
                  paramList3.add(localObject3);
                }
              }
              else
              {
                paramSpecialCareInfo.globalSwitch = 1;
              }
            }
            catch (Exception localException3)
            {
              if (QLog.isColorLevel()) {
                QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException3);
              }
            }
            continue;
            try
            {
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                paramSpecialCareInfo.qzoneSwitch = 0;
              } else {
                paramSpecialCareInfo.qzoneSwitch = 1;
              }
            }
            catch (Exception localException4)
            {
              if (QLog.isColorLevel()) {
                QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException4);
              }
            }
            continue;
            if (a((String)localObject3, localException4.bytes_value.get().toByteArray(), paramExtensionInfo))
            {
              bool1 = true;
              continue;
              String str = localException4.bytes_value.get().toStringUtf8();
              if ((str == null) || (str.length() == 0))
              {
                paramMap1.put(localObject3, Boolean.valueOf(false));
              }
              else
              {
                paramMap1.put(localObject3, Boolean.valueOf(true));
                continue;
                label1367:
                paramArrayOfByte = paramFriends.uin;
                if ((paramSet != null) && (paramSet.contains(paramArrayOfByte))) {
                  paramList2.add(paramArrayOfByte);
                }
                bool2 = bool1;
                if (abbf.f(paramArrayOfByte, this.app))
                {
                  paramList3.add(paramArrayOfByte);
                  bool2 = bool1;
                }
                label1425:
                return bool2;
              }
            }
          }
        }
      }
    }
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    label103:
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.flh", 2, "getQQHead, uin=" + paramString + ",headType=" + paramInt1 + ",idType=" + paramInt2 + ",level=" + paramByte1 + ",faceFileType=" + paramByte2);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramInt1 != 1) {
          break label103;
        }
        paramBoolean = Friends.isValidUin(paramString);
        if (paramBoolean) {
          break label103;
        }
      }
      for (;;)
      {
        return;
        localObject = paramInt1 + "_" + paramString;
        if (paramInt1 == 32) {
          localObject = "stranger_" + Integer.toString(paramInt2) + "_" + paramString;
        }
        if (paramInt1 == 16) {
          localObject = "qcall_" + Integer.toString(paramInt2) + "_" + paramString;
        }
        if (ka((String)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, noNeedDownload= " + (String)localObject);
        }
      }
      bD((String)localObject, false);
    }
    finally {}
    boolean bool;
    label295:
    label356:
    int k;
    if ((this.app.a != null) && (this.app.a.He()))
    {
      bool = true;
      if (!QLog.isColorLevel()) {
        break label614;
      }
      QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead end keyStr = " + (String)localObject + ",isImmediatelyGet=" + this.bHu + ",InActionLoginB=" + bool);
      break label614;
      this.cvd += 1;
      localObject = (ArrayList)this.i.get(Integer.valueOf(k));
      if (localObject != null) {
        break label605;
      }
      localObject = new ArrayList();
      this.i.put(Integer.valueOf(k), localObject);
      if (!QLog.isColorLevel()) {
        break label626;
      }
      QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL destQQHeadInfoTable.put(keyType, destQQHeadInfoList); keyType = " + k + "destQQHeadInfoTable.size = " + this.i.size());
      break label626;
    }
    for (;;)
    {
      paramBoolean = this.app.isFaceFileExist(paramInt1, paramString, paramInt2);
      for (;;)
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramBoolean)
        {
          Pair localPair = this.app.getQQHeadSetting(paramInt1, paramString, paramInt2);
          l1 = l2;
          if (localPair != null)
          {
            l1 = l2;
            if (localPair.second != null) {
              l1 = ((com.tencent.mobileqq.data.Setting)localPair.second).headImgTimestamp;
            }
          }
        }
        ((ArrayList)localObject).add(new QQHeadDetails(paramInt1, paramString, l1, paramByte1));
        if ((!this.bHu) && (bool) && (!TextUtils.equals(paramString, this.app.getCurrentAccountUin()))) {
          break;
        }
        cIN();
        break;
        bool = false;
        break label295;
        paramBoolean = true;
        continue;
        paramBoolean = false;
      }
      label605:
      break label626;
      label614:
      do
      {
        k = paramInt1;
        break;
      } while (paramInt1 != 32);
      k = paramInt2;
      break label356;
      label626:
      switch (paramByte2)
      {
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int k = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + k);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        notifyUI(62, false, new Object[] { null, Integer.valueOf(k) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        notifyUI(62, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(k) });
        return;
      }
      notifyUI(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(k) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      notifyUI(62, false, new Object[] { null, Integer.valueOf(k) });
      return;
    }
    notifyUI(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(k) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        notifyUI(58, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int k;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          k = 0;
          if (k < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(k);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          k += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(k);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              notifyUI(58, true, paramSvcRspGetDevLoginInfo);
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID =" + aqoj.C(NetConnInfoCenter.GUID) + "; info.guid = " + aqoj.C(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      notifyUI(58, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      notifyUI(58, false, null);
      return;
    }
    notifyUI(58, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject = (GetRichSigRes)paramObject;
    paramObject = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((localObject == null) || (((GetRichSigRes)localObject).cResult != 0) || (((GetRichSigRes)localObject).vstSigInfo == null) || (((GetRichSigRes)localObject).vstSigInfo.size() == 0))
    {
      notifyUI(65, false, new Object[] { paramObject, null });
      n(paramToServiceMsg);
      return;
    }
    HashMap localHashMap = new HashMap(paramObject.length);
    localObject = ((GetRichSigRes)localObject).vstSigInfo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject).next();
      localHashMap.put(Long.toString(localResRichSigInfo.lUin), RichStatus.parseStatus(localResRichSigInfo.vbSigInfo));
    }
    notifyUI(65, true, new Object[] { paramObject, localHashMap });
    n(paramToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    int i1 = paramToServiceMsg.extraData.getInt("bType");
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lToMID"));
    int i2 = paramToServiceMsg.extraData.getByte("bGroupId");
    int k = i1;
    if (i1 == 1) {
      k = 2;
    }
    if (k == 0)
    {
      paramToServiceMsg.extraData.getString("strNickName");
      a(str, i2, 3999, null, false, false, -1L);
    }
    paramToServiceMsg = str + "_answer_added_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
    aqgu.C(this.app.getApp().getApplicationContext(), paramToServiceMsg, k);
    notifyUI(10, true, new Object[] { str, Integer.valueOf(k) });
  }
  
  private void c(long paramLong, int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("AvatarInfoSvr.QQHeadUrlReq", null);
    Object localObject = new ArrayList();
    int k = 0;
    while (k < paramArrayList.size())
    {
      QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(k);
      ((ArrayList)localObject).add(localQQHeadDetails.a());
      c(0, localQQHeadDetails.boh, localQQHeadDetails.userType, 1);
      k += 1;
    }
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    paramArrayList = new QQHeadUrlReq(paramLong, (ArrayList)localObject, (byte)paramInt);
    localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding("UTF-8");
    paramArrayList.writeTo((JceOutputStream)localObject);
    localToServiceMsg.extraData.putByteArray("QQHeadUrlReq", ((JceOutputStream)localObject).toByteArray());
    send(localToServiceMsg);
  }
  
  private void c(acff paramacff)
  {
    Object localObject = abbf.a(this.app);
    if ((paramacff != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramacff.isFriend(str))
        {
          abbf.h(str, this.app);
          if (abbf.f(str, this.app)) {
            abbf.i(str, this.app);
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int k = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + k);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        notifyUI(51, false, new Object[] { null, Integer.valueOf(k) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        notifyUI(51, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(k) });
        return;
      }
      notifyUI(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(k) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      notifyUI(51, false, new Object[] { null, Integer.valueOf(k) });
      return;
    }
    notifyUI(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(k) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        notifyUI(59, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size() > 0))
        {
          int i1 = 0;
          int k = 0;
          if (k < paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.get(k);
            int i2;
            if (paramToServiceMsg == null) {
              i2 = i1;
            }
            for (;;)
            {
              k += 1;
              i1 = i2;
              break;
              if (paramToServiceMsg.vecGuid != null) {
                break label153;
              }
              i2 = i1;
              if (QLog.isColorLevel())
              {
                QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                i2 = i1;
              }
            }
            label153:
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            for (;;)
            {
              i2 = i1;
              if (System.currentTimeMillis() / 1000L - paramToServiceMsg.iLoginTime >= 2592000L) {
                break;
              }
              i2 = i1;
              if (i1 != 0) {
                break;
              }
              i2 = i1;
              if (paramToServiceMsg.iTerType != 3L) {
                break;
              }
              i2 = 1;
              notifyUI(102, true, null);
              break;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID =" + aqoj.C(NetConnInfoCenter.GUID) + "; info.guid = " + aqoj.C(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
        notifyUI(59, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      notifyUI(59, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      notifyUI(59, false, null);
      return;
    }
    notifyUI(59, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    paramObject = (GetRichSigRes)paramObject;
    acff localacff = (acff)this.app.getManager(51);
    if ((paramObject == null) || (paramObject.cResult != 0) || (paramObject.vstSigInfo == null) || (paramObject.vstSigInfo.size() == 0) || (localacff == null))
    {
      if (paramToServiceMsg.extraData.getInt("reqType") == 3) {
        this.bHt = false;
      }
      n(paramToServiceMsg);
      return;
    }
    ArrayList localArrayList1 = new ArrayList(paramObject.vstSigInfo.size());
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramObject.vstSigInfo.iterator();
    while (localIterator.hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)localIterator.next();
      String str = Long.toString(localResRichSigInfo.lUin);
      if (localResRichSigInfo.cStatus == 1)
      {
        ExtensionInfo localExtensionInfo = localacff.a(str);
        paramObject = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          paramObject = new ExtensionInfo();
          paramObject.uin = str;
        }
        if ((paramObject.richTime != localResRichSigInfo.dwTime) || (!Arrays.equals(paramObject.richBuffer, localResRichSigInfo.vbSigInfo)))
        {
          paramObject.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
          paramObject.isAdded2C2C = SignatureManager.a(this.app, str, paramObject.getRichStatus());
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "insertSignMsgIfNeeded from FriendList uin = " + str + " result = " + paramObject.isAdded2C2C);
          }
          localArrayList1.add(paramObject);
          localArrayList2.add(str);
        }
      }
    }
    if (localArrayList2.size() > 0)
    {
      paramObject = new String[localArrayList2.size()];
      localArrayList2.toArray(paramObject);
      notifyUI(2, true, paramObject);
      localacff.iN(localArrayList1);
    }
    if ((paramToServiceMsg.extraData.getInt("reqType") == 3) && (this.bHt) && (paramToServiceMsg.extraData.getStringArray("totalArray").length == paramToServiceMsg.extraData.getInt("nextStartPos")))
    {
      this.app.getPreferences().edit().putLong("inccheckupdatetimeStamp13", this.Pz).commit();
      this.bHt = false;
    }
    n(paramToServiceMsg);
  }
  
  private void cII()
  {
    if ((this.Px != 0L) && (this.cva != 0))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("mFriendListFailedCount", this.cva + "");
      localHashMap.put("failedTime", System.currentTimeMillis() - this.Px + "");
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "QQFriendListReqFailedStatistics", true, 0L, 0L, localHashMap, null);
      this.cva = 0;
      this.Px = 0L;
    }
  }
  
  private void cIN()
  {
    for (;;)
    {
      label155:
      int k;
      Object localObject3;
      try
      {
        this.g.removeMessages(0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead start !!! ");
        }
        if (this.cvd > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead destQQHeadInfoCount = " + this.cvd);
          }
          localObject1 = this.app.getCurrentAccountUin();
          if (localObject1 == null) {
            break label576;
          }
        }
        Enumeration localEnumeration;
        try
        {
          l = Long.valueOf((String)localObject1).longValue();
          if (l == -1L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead|myUin error: myUin=" + (String)localObject1);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          l = -1L;
          continue;
          localEnumeration = this.i.keys();
        }
        if (!localEnumeration.hasMoreElements()) {
          break label555;
        }
        k = ((Integer)localEnumeration.nextElement()).intValue();
        Object localObject1 = (List)this.i.get(Integer.valueOf(k));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "em.hasMoreElements() QQHeadDetails head_or_id = " + k);
        }
        if (!QLog.isColorLevel()) {
          break label361;
        }
        localObject3 = new StringBuilder("doExecuteGetQQHead sendRequests for QQHeadInfo head_or_id=").append(k);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          QQHeadDetails localQQHeadDetails = (QQHeadDetails)localIterator.next();
          ((StringBuilder)localObject3).append(" QQheadDetail uinOrMobile=").append(aqmr.getSimpleUinForPrint(localQQHeadDetails.boh)).append(",Timestamp=").append(localQQHeadDetails.headImgTimestamp).append("|");
          continue;
        }
        ((StringBuilder)localObject3).append(" QQHeadDetailList length = ").append(localList.size());
      }
      finally {}
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject3).toString());
      label361:
      if ((localList != null) && (!localList.isEmpty())) {}
      for (Object localObject2 = aqdm.l(localList, 50);; localObject2 = null)
      {
        if (localObject2 == null) {
          break label574;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = new ArrayList((List)((Iterator)localObject2).next());
          if (k == 11)
          {
            c(l, k, (ArrayList)localObject3);
          }
          else if (k >= 200)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "realGetQQHead_Stranger = " + k);
            }
            l(k, (ArrayList)localObject3);
          }
          else if (k == 16)
          {
            k(k, (ArrayList)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL = " + k);
            }
          }
          else
          {
            d(l, k, (ArrayList)localObject3);
          }
        }
        break label155;
        label555:
        this.cvd = 0;
        this.i.clear();
        break;
      }
      label574:
      continue;
      label576:
      long l = -1L;
    }
  }
  
  private void d(long paramLong, int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int k = paramInt;
    if (paramInt == 4) {
      k = 8;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("IncreaseURLSvr.QQHeadUrlReq", null);
    QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
    localQQHeadUrlReq.srcUsrType.set(1);
    localQQHeadUrlReq.srcUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localQQHeadUrlReq.dstUsrType.set(k);
    paramInt = 0;
    while (paramInt < paramArrayList.size())
    {
      QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(paramInt);
      QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
      try
      {
        localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.boh));
        c(0, localQQHeadDetails.boh, localQQHeadDetails.userType, 1);
        localReqUsrInfo.timestamp.set((int)localQQHeadDetails.headImgTimestamp);
        localQQHeadUrlReq.dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        label169:
        break label169;
      }
      paramInt += 1;
    }
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("dstUsrType", k);
    localToServiceMsg.putWupBuffer(localQQHeadUrlReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localStringBuilder.append("handleGetQQHeadError, result=").append(paramInt).append(", uinListSize=");
    if (localArrayList != null) {}
    for (int k = localArrayList.size();; k = -1)
    {
      ((StringBuilder)localObject).append(k);
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        break;
      }
      QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
      return;
    }
    k = 0;
    if (k < localArrayList.size())
    {
      QQHeadDetails localQQHeadDetails = (QQHeadDetails)localArrayList.get(k);
      String str = localQQHeadDetails.userType + "_" + localQQHeadDetails.boh;
      int i1;
      if (localQQHeadDetails.userType == 32)
      {
        i1 = paramToServiceMsg.extraData.getInt("subtype");
        localObject = "stranger_" + i1 + "_" + str;
      }
      for (;;)
      {
        bD((String)localObject, true);
        a(9201, (String)localObject, localQQHeadDetails.userType, 2, 0, null, paramInt, 0L);
        if (localQQHeadDetails != null) {
          localStringBuilder.append("; uin=").append((String)localObject).append(", timestamp=").append(localQQHeadDetails.headImgTimestamp);
        }
        localObject = (aczr)this.app.getManager(199);
        if ((localObject != null) && (((aczr)localObject).adh())) {
          ((aczr)localObject).Gg(localQQHeadDetails.boh);
        }
        k += 1;
        break;
        localObject = str;
        if (localQQHeadDetails.userType == 16)
        {
          i1 = paramToServiceMsg.extraData.getInt("subtype");
          localObject = "qcall_" + i1 + "_" + str;
        }
      }
    }
    QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        notifyUI(60, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size() > 0))
        {
          int k = 0;
          if (k < paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.get(k);
            if (paramToServiceMsg == null) {}
            for (;;)
            {
              k += 1;
              break;
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                }
              }
              else if (NetConnInfoCenter.GUID == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID is null");
                }
              }
              else {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID =" + aqoj.C(NetConnInfoCenter.GUID) + "; info.guid = " + aqoj.C(paramToServiceMsg.vecGuid));
                  }
                }
                catch (Exception paramToServiceMsg)
                {
                  paramToServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
        notifyUI(60, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      notifyUI(60, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      notifyUI(60, false, null);
      return;
    }
    notifyUI(60, false, null);
  }
  
  private void dA(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch success=" + bool);
      }
      if (!bool) {
        break label793;
      }
    }
    label793:
    label799:
    label809:
    label815:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null)
        {
          return;
          bool = false;
          break;
        }
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label809;
        }
        bool = true;
        i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch result=" + bool);
        }
        if ((bool) && (paramToServiceMsg.bytes_bodybuffer != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          k = paramToServiceMsg.get();
          int i2 = paramToServiceMsg.getInt();
          i1 = paramToServiceMsg.getShort();
          paramFromServiceMsg = new HashMap(i1);
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch cNickCut=" + k + " dwNextUin=" + i2 + " wSimpleInfoNum=" + i1);
          }
          if (i2 == -1)
          {
            paramObject = new StringBuffer();
            k = 0;
            if (k < i1)
            {
              String str = String.valueOf(aqft.K(paramToServiceMsg.getInt()));
              i2 = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldNum=");
                paramObject.append(i2);
              }
              if (i2 != 1) {
                break label799;
              }
              i2 = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldID=");
                paramObject.append(i2);
              }
              if (i2 != this.V) {
                break label799;
              }
              Object localObject = new byte[paramToServiceMsg.getShort()];
              paramToServiceMsg.get((byte[])localObject);
              localObject = new String((byte[])localObject);
              if (QLog.isColorLevel())
              {
                paramObject.append(" uin=");
                paramObject.append(str.substring(0, 4));
                paramObject.append(" nick=");
                paramObject.append(aqft.pk((String)localObject));
              }
              paramFromServiceMsg.put(str, localObject);
              break label799;
            }
            if (!QLog.isColorLevel()) {
              break label815;
            }
            QLog.d("FriendListHandler", 2, paramObject.toString());
            break label815;
            notifyUI(75, bool, paramFromServiceMsg);
            return;
          }
          bool = false;
          continue;
        }
        k = i1;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
          k = i1;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i1 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch e", paramToServiceMsg);
        k = i1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        k = i1;
        continue;
      }
      catch (Exception paramToServiceMsg)
      {
        i1 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch ex", paramToServiceMsg);
        k = i1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        k = i1;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
      }
      notifyUI(75, false, Integer.valueOf(k));
      return;
      int i1 = 0;
      continue;
      int k = (short)(k + 1);
      continue;
      bool = false;
    }
  }
  
  private void dB(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("tag_hidden_chat", 2, "FriendListHandler.handleSetHiddenChatResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_chat_types");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    int i2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          int k;
          if (QLog.isColorLevel()) {
            QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
          }
          paramFromServiceMsg.printStackTrace();
          continue;
          paramToServiceMsg.aT(null);
        }
        i2 = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        k = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "ssoPkg.uint32_result=" + k);
        }
        if (k == 0)
        {
          k = 0;
          for (;;)
          {
            if (k >= arrayOfString.length) {
              break label284;
            }
            paramToServiceMsg = arrayOfString[k];
            i2 = arrayOfBoolean[k];
            int i1 = arrayOfInt[k];
            paramToServiceMsg = new FriendsStatusUtil.UpdateFriendStatusItem(paramToServiceMsg, 13581, 21);
            if (i2 == 0) {
              break;
            }
            paramToServiceMsg.aT(new byte[1]);
            FriendsStatusUtil.a(this.app, paramToServiceMsg, null);
            k += 1;
          }
        }
      }
    }
    for (;;)
    {
      label284:
      notifyUI(130, i2, new Object[] { arrayOfString, arrayOfBoolean });
      return;
      int i3 = 0;
    }
  }
  
  private void dC(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("tag_msg_notification", 2, "FriendListHandler.handleSetMessageNotificationSettingResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    aean localaean = aean.a(this.app);
    int i1 = paramToServiceMsg.extraData.getInt("param_type");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          int k;
          if (QLog.isColorLevel()) {
            QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
          }
          paramFromServiceMsg.printStackTrace();
        }
        bool = true;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        k = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "ssoPkg.uint32_result=" + k);
        }
        if (k == 0)
        {
          k = 0;
          while (k < arrayOfString.length)
          {
            localaean.o(arrayOfString[k], i1, arrayOfBoolean[k]);
            k += 1;
          }
        }
      }
    }
    for (;;)
    {
      notifyUI(131, bool, new Object[] { arrayOfString, arrayOfBoolean, Integer.valueOf(i1) });
      return;
      boolean bool = false;
    }
  }
  
  private void dD(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switch", 2, "FriendListHandler.handleSetSpecialCareSwitchResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    int i2 = paramToServiceMsg.extraData.getInt("param_type");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    int i3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int k;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switch", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (i3 != 0)
            {
              paramToServiceMsg.DQ(paramFromServiceMsg);
              paramObject = new SpecialCareInfo();
              paramObject.globalSwitch = 1;
              paramObject.specialRingSwitch = 1;
              paramObject.friendRingId = 1;
              paramObject.qzoneSwitch = 1;
              paramObject.uin = paramFromServiceMsg;
              paramToServiceMsg.a(paramObject);
              abbf.a(paramFromServiceMsg, "1", this.app);
            }
            else
            {
              paramToServiceMsg.DQ(paramFromServiceMsg);
            }
          }
          paramObject = paramToServiceMsg.a(paramFromServiceMsg);
          if (paramObject != null) {
            if (i3 == 0) {
              break label395;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            paramObject.specialRingSwitch = i1;
            paramToServiceMsg.a(paramObject);
            if (i3 == 0) {
              break;
            }
            abbf.a(paramFromServiceMsg, "1", this.app);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        } while (paramFromServiceMsg == null);
        if (i3 == 0) {
          break label433;
        }
        for (i1 = 1;; i1 = 0)
        {
          paramFromServiceMsg.qzoneSwitch = i1;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        i3 = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        k = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switch", 2, "ssoPkg.uint32_result=" + k);
        }
        if (k == 0)
        {
          paramToServiceMsg = (acff)this.app.getManager(51);
          k = 0;
          while (k < arrayOfString.length)
          {
            paramFromServiceMsg = arrayOfString[k];
            i3 = arrayOfBoolean[k];
            switch (i2)
            {
            default: 
              k += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      int i1;
      label395:
      label433:
      paramToServiceMsg = new Object[3];
      paramToServiceMsg[0] = Integer.valueOf(i2);
      paramToServiceMsg[1] = arrayOfString;
      paramToServiceMsg[2] = arrayOfBoolean;
      switch (i2)
      {
      default: 
        return;
      case 1: 
        notifyUI(96, i3, paramToServiceMsg);
        return;
      case 2: 
        notifyUI(97, i3, paramToServiceMsg);
        return;
      }
      notifyUI(98, i3, paramToServiceMsg);
      return;
      int i4 = 0;
    }
  }
  
  private void dF(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switches_of_a_person", 2, "FriendListHandler.handleSetSpecialCareSwitchesOfAPersonResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    String str = paramToServiceMsg.extraData.getString("param_uin");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_type");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_ring_ids");
    int k;
    int i3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int i1;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switches_of_a_person", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (i3 != 0)
            {
              paramToServiceMsg.DQ(str);
              paramFromServiceMsg = new SpecialCareInfo();
              paramFromServiceMsg.globalSwitch = 1;
              paramFromServiceMsg.uin = str;
              paramToServiceMsg.a(paramFromServiceMsg);
              abbf.a(str, "1", this.app);
            }
            else
            {
              paramToServiceMsg.DQ(str);
            }
          }
          paramObject = paramToServiceMsg.a(str);
          if (paramObject != null) {
            if (i3 == 0) {
              break label436;
            }
          }
          for (i2 = 1;; i2 = 0)
          {
            paramObject.specialRingSwitch = i2;
            paramToServiceMsg.a(paramObject);
            if (i3 == 0) {
              break;
            }
            abbf.a(str, paramFromServiceMsg, this.app);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(str);
        } while (paramFromServiceMsg == null);
        if (i3 == 0) {
          break label475;
        }
        for (int i2 = 1;; i2 = 0)
        {
          paramFromServiceMsg.qzoneSwitch = i2;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        i3 = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        k = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switches_of_a_person", 2, "ssoPkg.uint32_result=" + k);
        }
        if (k == 0)
        {
          paramToServiceMsg = (acff)this.app.getManager(51);
          if ((arrayOfBoolean != null) && (arrayOfInt != null) && (arrayOfString != null) && (arrayOfBoolean.length >= arrayOfInt.length) && (arrayOfString.length >= arrayOfInt.length))
          {
            i1 = 0;
            while (i1 < arrayOfInt.length)
            {
              i2 = arrayOfInt[i1];
              i3 = arrayOfBoolean[i1];
              paramFromServiceMsg = arrayOfString[i1];
              switch (i2)
              {
              default: 
                i1 += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label436:
      label475:
      notifyUI(100, i3, new Object[] { Integer.valueOf(k), str, arrayOfInt, arrayOfBoolean, arrayOfString });
      return;
      int i4 = 0;
      continue;
      i4 = 0;
      k = -1;
    }
  }
  
  private void dG(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int k = 1; k == 0; k = 0)
    {
      notifyUI(66, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label113;
        }
        k = 1;
        if (k != 0) {
          break label119;
        }
        notifyUI(66, false, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(66, false, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.stranger_info", 2, paramToServiceMsg.getMessage());
      return;
      label113:
      k = 0;
    }
    label119:
    if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (localByteBuffer.getInt() == -1)
      {
        int i4 = localByteBuffer.getShort();
        paramFromServiceMsg = new ArrayList(i4);
        paramObject = new HashSet(i4);
        acff localacff = (acff)this.app.getManager(51);
        int i2 = 0;
        while (i2 < i4)
        {
          long l1 = aqft.K(localByteBuffer.getInt());
          paramToServiceMsg = localacff.a(String.valueOf(l1));
          if (paramToServiceMsg != null) {
            break label785;
          }
          paramToServiceMsg = new ExtensionInfo();
          paramToServiceMsg.uin = String.valueOf(l1);
          k = 1;
          int i5 = localByteBuffer.getShort();
          int i1;
          if (i5 > 0)
          {
            int i3 = 0;
            i1 = k;
            if (i3 < i5)
            {
              int i6 = localByteBuffer.getShort();
              long l2;
              if (i6 == 27025)
              {
                if (localByteBuffer.getShort() != 8) {
                  break label782;
                }
                l2 = localByteBuffer.getLong();
                if (paramToServiceMsg.pendantId == l2) {
                  break label782;
                }
                paramToServiceMsg.pendantId = l2;
                paramToServiceMsg.lastUpdateTime = NetConnInfoCenter.getServerTime();
                k = 1;
                i1 = k;
              }
              for (;;)
              {
                i3 += 1;
                k = i1;
                break;
                if (i6 == 27201)
                {
                  i1 = k;
                  if (localByteBuffer.getShort() == 4)
                  {
                    l2 = localByteBuffer.getInt();
                    if (paramToServiceMsg.uVipFont == ku.h(l2))
                    {
                      i1 = k;
                      if (paramToServiceMsg.vipFontType == ku.c(l2)) {}
                    }
                    else
                    {
                      paramToServiceMsg.uVipFont = ku.h(l2);
                      paramToServiceMsg.vipFontType = ku.c(l2);
                      paramToServiceMsg.lastUpdateTime = NetConnInfoCenter.getServerTime();
                      i1 = 1;
                    }
                  }
                }
                else if (i6 == 27041)
                {
                  i1 = k;
                  if (localByteBuffer.getShort() == 4)
                  {
                    i6 = localByteBuffer.getInt();
                    i1 = k;
                    if (paramToServiceMsg.colorRingId != i6)
                    {
                      paramToServiceMsg.colorRingId = i6;
                      i1 = 1;
                    }
                  }
                }
                else
                {
                  i1 = k;
                  if (i6 == 20059)
                  {
                    i1 = k;
                    if (localByteBuffer.getShort() == 4)
                    {
                      i6 = localByteBuffer.getInt();
                      i1 = k;
                      if (i6 >= 0)
                      {
                        i1 = k;
                        if (String.valueOf(l1).equals(this.app.getCurrentAccountUin()))
                        {
                          ((BubbleManager)this.app.getManager(44)).a(i6, true);
                          ((acle)this.app.getBusinessHandler(13)).JK(i6);
                          i1 = k;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          else
          {
            i1 = k;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetStrangerInfo, uin=" + l1 + ", pendant=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont + ", fontType = " + paramToServiceMsg.vipFontType);
          }
          if (i1 != 0)
          {
            paramToServiceMsg.timestamp = System.currentTimeMillis();
            paramFromServiceMsg.add(paramToServiceMsg);
            paramObject.add(paramToServiceMsg.uin);
          }
          i2 += 1;
        }
        localacff.iN(paramFromServiceMsg);
        paramToServiceMsg = paramObject;
      }
    }
    for (;;)
    {
      label259:
      label343:
      notifyUI(66, true, paramToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.stranger_info", 2, "handleGetStrangerInfo. addonId size : " + paramFromServiceMsg.size());
      return;
      label782:
      break label343;
      label785:
      k = 0;
      break label259;
      paramToServiceMsg = null;
      paramFromServiceMsg = null;
    }
  }
  
  private void dH(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_QCall ....");
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject2;
    }
    int k;
    List localList;
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
          ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramObject = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + localException.getMessage());
        }
        localException.printStackTrace();
        continue;
        if (paramFromServiceMsg != null) {
          k = paramFromServiceMsg.getResultCode();
        }
      }
      localList = paramObject.dstUsrHeadInfos.get();
      localArrayList = new ArrayList();
      paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
      localObject2 = new ArrayList();
      paramObject.dstUidType.get();
      i2 = ???.extraData.getInt("idType");
      paramObject = paramFromServiceMsg.iterator();
    }
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
    {
      k = 65535;
      if (paramObject != null)
      {
        k = paramObject.result.get();
        d(???, k);
        return;
      }
    }
    ArrayList localArrayList;
    int i2;
    QQHeadDetails localQQHeadDetails;
    label282:
    String str;
    if (paramObject.hasNext())
    {
      localQQHeadDetails = (QQHeadDetails)paramObject.next();
      Iterator localIterator1 = localList.iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          ??? = (MultiHeadUrl.RspUsrHeadInfo)localIterator1.next();
          str = alkt.longToString(???.dstUin.get());
          if (localQQHeadDetails.boh.equals(str))
          {
            paramFromServiceMsg = ???.dstHeadInfos.get();
            ??? = null;
            Iterator localIterator2 = paramFromServiceMsg.iterator();
            label346:
            if (localIterator2.hasNext())
            {
              paramFromServiceMsg = (MultiHeadUrl.RspHeadInfo)localIterator2.next();
              paramFromServiceMsg.usrType.get();
              if (paramFromServiceMsg.faceType.get() == 0) {
                break label1103;
              }
              ??? = paramFromServiceMsg;
            }
          }
        }
      }
    }
    for (;;)
    {
      break label346;
      if (??? != null)
      {
        label394:
        paramFromServiceMsg = this.app.getQQHeadSetting(16, str, i2);
        if (this.app.isFaceFileExist(16, str, i2)) {
          break label671;
        }
        int i1 = 1;
        k = i1;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL file not exist.id=" + str + ",idType=" + i2);
          k = i1;
        }
        label480:
        if (k == 0) {
          break label784;
        }
        paramFromServiceMsg = new QQHeadInfo();
        paramFromServiceMsg.headLevel = localQQHeadDetails.bb;
        paramFromServiceMsg.idType = i2;
        paramFromServiceMsg.phoneNum = str;
        paramFromServiceMsg.dwTimestamp = ???.timestamp.get();
        paramFromServiceMsg.cHeadType = ((byte)???.faceType.get());
        paramFromServiceMsg.dstUsrType = 16;
        paramFromServiceMsg.dwFaceFlgas = ((byte)???.faceFlag.get());
        paramFromServiceMsg.downLoadUrl = ???.url.get();
        paramFromServiceMsg.systemHeadID = ((short)???.sysid.get());
        paramFromServiceMsg.originUsrType = ???.usrType.get();
        if (!???.headVerify.has()) {
          break label786;
        }
      }
      label784:
      label786:
      for (??? = ???.headVerify.get();; ??? = "")
      {
        paramFromServiceMsg.headVerify = ???;
        ((List)localObject2).add(paramFromServiceMsg);
        break label282;
        if (0 != 0)
        {
          ??? = null;
          break label394;
        }
        if (!QLog.isColorLevel()) {
          break label282;
        }
        QLog.d("headqcall", 2, "there is no headinfo uin=" + str);
        break label282;
        break;
        label671:
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.second;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL setting=" + paramFromServiceMsg + "targetInfo.timestamp=" + ???.timestamp.get());
          }
          if (paramFromServiceMsg == null)
          {
            k = 1;
            break label480;
          }
          if (paramFromServiceMsg.headImgTimestamp != ???.timestamp.get())
          {
            k = 1;
            break label480;
          }
          localArrayList.add(localQQHeadDetails);
          k = 0;
          break label480;
        }
        k = 1;
        break label480;
        break label282;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {}
      synchronized (this.cr)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler = new QQHeadDownloadHandler(this.app, this);
        }
        k = 0;
        if (k < ((List)localObject2).size())
        {
          ??? = (QQHeadInfo)((List)localObject2).get(k);
          c(0, i(???.uin, ???.phoneNum), ???.dstUsrType, 2);
          paramFromServiceMsg = new FaceInfo();
          paramFromServiceMsg.uin = ???.phoneNum;
          paramFromServiceMsg.idType = ???.idType;
          paramFromServiceMsg.aRY = ???.dstUsrType;
          paramFromServiceMsg.b = ???;
          this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.b(paramFromServiceMsg);
          k += 1;
        }
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      paramFromServiceMsg = this.app.a().createEntityManager();
      ??? = paramFromServiceMsg.getTransaction();
      ???.begin();
      k = 0;
      try
      {
        while (k < localArrayList.size())
        {
          paramObject = (QQHeadDetails)localArrayList.get(k);
          paramObject = "qcall_" + String.valueOf(i2) + "_" + paramObject.boh;
          localObject2 = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.find(com.tencent.mobileqq.data.Setting.class, paramObject);
          if (localObject2 != null)
          {
            ((com.tencent.mobileqq.data.Setting)localObject2).updateTimestamp = System.currentTimeMillis();
            this.app.a((com.tencent.mobileqq.data.Setting)localObject2);
            paramFromServiceMsg.update((Entity)localObject2);
          }
          bD(paramObject, true);
          k += 1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        ???.commit();
        ???.end();
        return;
      }
    }
  }
  
  private void dI(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger ....");
    }
    ArrayList localArrayList1 = null;
    Object localObject1 = localArrayList1;
    if (paramFromServiceMsg != null) {
      localObject1 = localArrayList1;
    }
    int k;
    List localList;
    ArrayList localArrayList2;
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localArrayList1;
        if (paramObject != null)
        {
          localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
          ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramObject = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + localException.getMessage());
        }
        localException.printStackTrace();
        continue;
        if (paramFromServiceMsg != null) {
          k = paramFromServiceMsg.getResultCode();
        }
      }
      localList = paramObject.dstUsrHeadInfos.get();
      localArrayList1 = new ArrayList();
      paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
      localArrayList2 = new ArrayList();
      i2 = paramObject.dstUidType.get();
      i1 = ???.extraData.getInt("idType");
      localIterator1 = paramFromServiceMsg.iterator();
    }
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
    {
      k = 65535;
      if (paramObject != null)
      {
        k = paramObject.result.get();
        d(???, k);
        return;
      }
    }
    int i2;
    int i1;
    Iterator localIterator1;
    label255:
    QQHeadDetails localQQHeadDetails;
    label286:
    label323:
    Object localObject2;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = localList.iterator();
      if (localIterator2.hasNext())
      {
        ??? = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        if (i2 == 0)
        {
          paramObject = String.valueOf(???.dstUin.get());
          if (!localQQHeadDetails.boh.equals(paramObject)) {
            break label430;
          }
          localObject2 = ???.dstHeadInfos.get();
          paramFromServiceMsg = null;
          ??? = null;
          Iterator localIterator3 = ((List)localObject2).iterator();
          label357:
          if (!localIterator3.hasNext()) {
            break label456;
          }
          localObject2 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
          k = ((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get();
          if (k != 1) {
            break label432;
          }
          paramFromServiceMsg = (FromServiceMsg)localObject2;
        }
      }
    }
    label680:
    for (;;)
    {
      break label357;
      if (i2 == 1)
      {
        paramObject = String.valueOf(???.dstTid.get());
        break label323;
      }
      paramObject = ???.dstOpenid.get();
      break label323;
      label430:
      break label286;
      label432:
      if ((k == 32) && (((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get() != 0))
      {
        ??? = (ToServiceMsg)localObject2;
        continue;
        label456:
        if (??? != null)
        {
          label460:
          paramFromServiceMsg = this.app.getQQHeadSetting(32, paramObject, i1);
          if (this.app.isFaceFileExist(32, paramObject, i1)) {
            break label680;
          }
          k = 1;
          label491:
          if (k == 0) {
            break label752;
          }
          paramFromServiceMsg = new QQHeadInfo();
          paramFromServiceMsg.headLevel = localQQHeadDetails.bb;
          paramFromServiceMsg.idType = i1;
          paramFromServiceMsg.phoneNum = paramObject;
          paramFromServiceMsg.dwTimestamp = ???.timestamp.get();
          paramFromServiceMsg.cHeadType = ((byte)???.faceType.get());
          paramFromServiceMsg.dstUsrType = 32;
          paramFromServiceMsg.dwFaceFlgas = ((byte)???.faceFlag.get());
          paramFromServiceMsg.downLoadUrl = ???.url.get();
          paramFromServiceMsg.systemHeadID = ((short)???.sysid.get());
          paramFromServiceMsg.originUsrType = ???.usrType.get();
          if (!???.headVerify.has()) {
            break label746;
          }
        }
        label746:
        for (??? = ???.headVerify.get();; ??? = "")
        {
          paramFromServiceMsg.headVerify = ???;
          localArrayList2.add(paramFromServiceMsg);
          break;
          if (paramFromServiceMsg != null)
          {
            ??? = paramFromServiceMsg;
            break label460;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("headstranger", 2, "there is no headinfo uin=" + paramObject);
          break;
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.second;
            if (paramFromServiceMsg == null)
            {
              k = 1;
              break label491;
            }
            if (paramFromServiceMsg.headImgTimestamp != ???.timestamp.get())
            {
              k = 1;
              break label491;
            }
            localArrayList1.add(localQQHeadDetails);
            k = 0;
            break label491;
          }
          k = 1;
          break label491;
        }
        label752:
        notifyUI(5, true, new Object[] { localQQHeadDetails.boh, Integer.valueOf(i1), Boolean.valueOf(true) });
        break label286;
        break label255;
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {}
        synchronized (this.cr)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler = new QQHeadDownloadHandler(this.app, this);
          }
          k = 0;
          if (k < localArrayList2.size())
          {
            ??? = (QQHeadInfo)localArrayList2.get(k);
            c(0, i(???.uin, ???.phoneNum), ???.dstUsrType, 2);
            paramFromServiceMsg = new FaceInfo();
            paramFromServiceMsg.uin = ???.phoneNum;
            paramFromServiceMsg.idType = ???.idType;
            paramFromServiceMsg.aRY = ???.dstUsrType;
            paramFromServiceMsg.b = ???;
            this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.b(paramFromServiceMsg);
            k += 1;
          }
        }
        if (localArrayList1.size() <= 0) {
          break;
        }
        paramFromServiceMsg = this.app.a().createEntityManager();
        ??? = paramFromServiceMsg.getTransaction();
        ???.begin();
        k = 0;
        try
        {
          while (k < localArrayList1.size())
          {
            paramObject = (QQHeadDetails)localArrayList1.get(k);
            paramObject = "stranger_" + String.valueOf(i1) + "_" + paramObject.boh;
            localObject2 = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.find(com.tencent.mobileqq.data.Setting.class, paramObject);
            if (localObject2 != null)
            {
              ((com.tencent.mobileqq.data.Setting)localObject2).updateTimestamp = System.currentTimeMillis();
              this.app.a((com.tencent.mobileqq.data.Setting)localObject2);
              paramFromServiceMsg.update((Entity)localObject2);
            }
            bD(paramObject, true);
            k += 1;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          ???.commit();
          ???.end();
          return;
        }
      }
    }
  }
  
  private void dJ(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject3 = null;
    Object localObject1 = localObject3;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject3;
    }
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject3;
        if (paramObject != null)
        {
          localObject1 = new QQHeadUrl.QQHeadUrlRsp();
          ((QQHeadUrl.QQHeadUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        Object localObject2 = null;
        continue;
        if (paramFromServiceMsg != null)
        {
          k = paramFromServiceMsg.getResultCode();
          continue;
          notifyUI(133, false, new Object[] { Integer.valueOf(0), ??? });
          return;
          k = ((QQHeadUrl.QQHeadUrlRsp)localObject2).dstUsrType.get();
          if (k == 8) {
            k = 4;
          }
          for (;;)
          {
            int i2 = (byte)((QQHeadUrl.QQHeadUrlRsp)localObject2).dstEncryptType.get();
            paramObject = new ArrayList();
            paramFromServiceMsg = new ArrayList();
            ??? = ???.extraData.getParcelableArrayList("uinList");
            if ((??? != null) && (???.size() > 0))
            {
              localObject2 = ((QQHeadUrl.QQHeadUrlRsp)localObject2).dstHeadInfos.get();
              localObject3 = ???.iterator();
            }
            for (;;)
            {
              QQHeadDetails localQQHeadDetails;
              Object localObject4;
              QQHeadUrl.RspHeadInfo localRspHeadInfo;
              if (((Iterator)localObject3).hasNext())
              {
                localQQHeadDetails = (QQHeadDetails)((Iterator)localObject3).next();
                localObject4 = ((List)localObject2).iterator();
                if (!((Iterator)localObject4).hasNext()) {
                  break label1111;
                }
                localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((Iterator)localObject4).next();
                if (i2 == 1)
                {
                  ??? = localRspHeadInfo.dstUid.get();
                  if (!localQQHeadDetails.boh.equals(???)) {
                    break label641;
                  }
                  localObject4 = new QQHeadInfo();
                  ((QQHeadInfo)localObject4).headLevel = localQQHeadDetails.bb;
                  if (i2 != 1) {
                    break label643;
                  }
                  ((QQHeadInfo)localObject4).phoneNum = localRspHeadInfo.dstUid.get();
                  ((QQHeadInfo)localObject4).dwTimestamp = localRspHeadInfo.timestamp.get();
                  ((QQHeadInfo)localObject4).cHeadType = ((byte)localRspHeadInfo.faceType.get());
                  ((QQHeadInfo)localObject4).dstUsrType = ((byte)k);
                  ((QQHeadInfo)localObject4).dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
                  ((QQHeadInfo)localObject4).downLoadUrl = localRspHeadInfo.url.get();
                  ((QQHeadInfo)localObject4).systemHeadID = ((short)localRspHeadInfo.sysid.get());
                  if (!localRspHeadInfo.headVerify.has()) {
                    break label659;
                  }
                  ??? = localRspHeadInfo.headVerify.get();
                  ((QQHeadInfo)localObject4).headVerify = ???;
                  paramObject.add(localObject4);
                }
              }
              for (int i1 = 1;; i1 = 0)
              {
                if (i1 != 0) {
                  break label1115;
                }
                paramFromServiceMsg.add(localQQHeadDetails);
                break label378;
                ??? = String.valueOf(localRspHeadInfo.dstUin.get());
                break label446;
                break label409;
                ((QQHeadInfo)localObject4).uin = localRspHeadInfo.dstUin.get();
                break label496;
                ??? = "";
                break label593;
                if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {}
                synchronized (this.cr)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
                    this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler = new QQHeadDownloadHandler(this.app, this);
                  }
                  i1 = 0;
                  if (i1 < paramObject.size())
                  {
                    ??? = (QQHeadInfo)paramObject.get(i1);
                    c(0, i(???.uin, ???.phoneNum), ???.dstUsrType, 2);
                    localObject2 = new FaceInfo();
                    ((FaceInfo)localObject2).uin = String.valueOf(???.uin);
                    ((FaceInfo)localObject2).idType = ???.idType;
                    ((FaceInfo)localObject2).aRY = ???.dstUsrType;
                    ((FaceInfo)localObject2).b = ???;
                    this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.b((FaceInfo)localObject2);
                    i1 += 1;
                  }
                }
                if (paramFromServiceMsg.size() <= 0) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handleQQHead_New noChangeQQHeadInfoList");
                }
                localObject2 = this.app.a().createEntityManager();
                paramObject = ((EntityManager)localObject2).getTransaction();
                paramObject.begin();
                i1 = 0;
                try
                {
                  if (i1 < paramFromServiceMsg.size())
                  {
                    localObject3 = (QQHeadDetails)paramFromServiceMsg.get(i1);
                    if (k == 4) {}
                    for (??? = "troop_" + ((QQHeadDetails)localObject3).boh;; ??? = ((QQHeadDetails)localObject3).boh)
                    {
                      ??? = (com.tencent.mobileqq.data.Setting)((EntityManager)localObject2).find(com.tencent.mobileqq.data.Setting.class, ???);
                      if (??? != null)
                      {
                        ???.updateTimestamp = System.currentTimeMillis();
                        this.app.a(???);
                        ((EntityManager)localObject2).update(???);
                      }
                      bD(k + "_" + ((QQHeadDetails)localObject3).boh, true);
                      i1 += 1;
                      break;
                    }
                  }
                  if (k == 1) {
                    break label1037;
                  }
                }
                catch (Exception ???)
                {
                  paramObject.commit();
                  paramObject.end();
                }
                if (k != 32) {
                  break;
                }
                ??? = new ArrayList(paramFromServiceMsg.size());
                paramFromServiceMsg = paramFromServiceMsg.iterator();
                while (paramFromServiceMsg.hasNext()) {
                  ???.add(((QQHeadDetails)paramFromServiceMsg.next()).boh);
                }
                notifyUI(133, true, new Object[] { Integer.valueOf(0), ??? });
                return;
              }
            }
          }
        }
        else
        {
          k = 65535;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleQQHead_New qqHeadUrlResp=" + localObject1 + " qqHeadUrlRespData = " + paramObject);
    }
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (localObject1 == null) || (((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get() != 0)) {
      if (localObject1 != null)
      {
        k = ((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get();
        d(???, k);
        k = ???.extraData.getInt("dstUsrType", 1);
        if ((k != 1) && (k != 32)) {
          break label292;
        }
        paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
        ??? = new ArrayList();
        if (!(paramFromServiceMsg instanceof ArrayList)) {
          break label269;
        }
        paramFromServiceMsg = ((ArrayList)paramFromServiceMsg).iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = paramFromServiceMsg.next();
          if ((paramObject instanceof QQHeadDetails)) {
            ???.add(((QQHeadDetails)paramObject).boh);
          }
        }
      }
    }
  }
  
  private void dK(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = paramToServiceMsg.extraData.getInt("search_version");
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (k != 2) {
        break label170;
      }
      bool1 &= paramObject instanceof RespSearch;
      k = 87;
    }
    for (;;)
    {
      label45:
      Object localObject = null;
      int i1;
      label90:
      boolean bool2;
      if (bool1)
      {
        paramFromServiceMsg = (RespHead)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
        if (paramFromServiceMsg != null)
        {
          i1 = paramFromServiceMsg.iResult;
          paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
          bool2 = paramToServiceMsg.extraData.getBoolean("search_decode");
        }
      }
      for (;;)
      {
        notifyUI(49, bool1, new Object[] { Integer.valueOf(k), paramObject, Integer.valueOf(i1), paramFromServiceMsg, Boolean.valueOf(bool2), Long.valueOf(paramToServiceMsg.extraData.getLong("session_id")) });
        return;
        bool1 = false;
        break;
        label170:
        if (k != 3) {
          break label215;
        }
        bool1 &= paramObject instanceof ArrayList;
        k = 88;
        break label45;
        paramFromServiceMsg = null;
        bool1 = false;
        i1 = 0;
        break label90;
        bool2 = false;
        i1 = 0;
        paramFromServiceMsg = localObject;
      }
      label215:
      k = -1;
    }
  }
  
  private void dL(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int k;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && ((paramObject instanceof RespCondSearch)))
    {
      bool = true;
      if (!bool) {
        break label135;
      }
      paramFromServiceMsg = (RespHead)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
      if (paramFromServiceMsg == null) {
        break label126;
      }
      k = paramFromServiceMsg.iResult;
      paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
    }
    for (;;)
    {
      notifyUI(73, bool, new Object[] { Long.valueOf(paramToServiceMsg.extraData.getLong("search_seq")), paramObject, Integer.valueOf(k), Integer.valueOf(paramToServiceMsg.extraData.getInt("param_search_from")) });
      return;
      bool = false;
      break;
      label126:
      k = 0;
      bool = false;
      continue;
      label135:
      k = 0;
    }
  }
  
  private void dM(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("dwReqType", 1L);
    if (l == 0L)
    {
      paramToServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("dwUin"));
      if (paramObject != null) {
        break label76;
      }
      notifyUI(68, false, new Object[] { Long.valueOf(l), paramToServiceMsg });
    }
    label76:
    while (!(paramObject instanceof GetOnlineInfoResp))
    {
      return;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("strMobile");
      break;
    }
    paramFromServiceMsg = (GetOnlineInfoResp)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleOnlineInfo, uin = " + aqmr.getSimpleUinForPrint(paramToServiceMsg) + ", result = " + paramFromServiceMsg.result + ", itermType = " + paramFromServiceMsg.iTermType + ", netType = " + paramFromServiceMsg.eNetworkType + ", abi = " + paramFromServiceMsg.uAbiFlag + ", status = " + paramFromServiceMsg.dwStatus + ", strTermDesc = " + paramFromServiceMsg.strTermDesc);
    }
    if ((l == 0L) && (paramFromServiceMsg.result == 0)) {
      ((acff)this.app.getManager(51)).a(paramToServiceMsg, paramFromServiceMsg);
    }
    for (;;)
    {
      paramFromServiceMsg.dwInterval *= 1000L;
      if (paramFromServiceMsg.dwInterval < 15000L) {
        paramFromServiceMsg.dwInterval = 15000L;
      }
      this.PB = paramFromServiceMsg.dwInterval;
      notifyUI(68, true, new Object[] { Long.valueOf(l), paramToServiceMsg, paramFromServiceMsg });
      return;
      if ((l == 1L) && (paramFromServiceMsg.result == 0)) {
        ((ajdo)this.app.getManager(11)).a(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  private void dN(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = true;
    String str1 = paramToServiceMsg.extraData.getString("uin");
    String str2 = paramToServiceMsg.extraData.getString("com_value");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("notify_plugin");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str1;
    paramToServiceMsg[1] = str2;
    if (1000 == paramFromServiceMsg.getResultCode())
    {
      paramFromServiceMsg = (ChangeFriendNameRes)paramObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.cResult == 0))
      {
        C(str1, str2, true);
        paramToServiceMsg[2] = Byte.valueOf(paramFromServiceMsg.cResult);
        notifyUI(27, true, paramToServiceMsg);
        if (bool2)
        {
          paramToServiceMsg = new Intent("action_set_remark_plugin");
          paramToServiceMsg.putExtra("uin", str1);
          paramToServiceMsg.putExtra("remark", str2);
          paramToServiceMsg.putExtra("is_suc", bool1);
          BaseApplicationImpl.getContext().sendBroadcast(paramToServiceMsg);
        }
        return;
      }
      if (paramFromServiceMsg != null)
      {
        paramToServiceMsg[2] = Byte.valueOf(paramFromServiceMsg.cResult);
        label175:
        notifyUI(27, false, paramToServiceMsg);
      }
    }
    for (;;)
    {
      bool1 = false;
      break;
      paramToServiceMsg[2] = Byte.valueOf(-1);
      break label175;
      paramToServiceMsg[2] = Byte.valueOf(-1);
      notifyUI(27, false, paramToServiceMsg);
    }
  }
  
  private void dO(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (SetRichSigRes)paramObject;
      if (paramObject.cResult == 0)
      {
        acff localacff = (acff)this.app.getManager(51);
        if (localacff != null)
        {
          byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("sig_value");
          if (paramObject.dwTime == 0L) {
            paramObject.dwTime = 1L;
          }
          paramFromServiceMsg = localacff.a(this.app.getCurrentAccountUin());
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = this.app.getCurrentAccountUin();
          }
          if (paramToServiceMsg.timestamp != paramObject.dwTime)
          {
            paramToServiceMsg.setRichBuffer(arrayOfByte, paramObject.dwTime);
            localacff.a(paramToServiceMsg);
          }
        }
        notifyUI(28, true, null);
        return;
      }
      notifyUI(28, false, Integer.valueOf(paramObject.cResult));
      return;
    }
    notifyUI(28, false, null);
  }
  
  private void dP(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0x5d1.RspBody localRspBody = new Oidb_0x5d1.RspBody();
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      M(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    for (paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();; paramFromServiceMsg = localRspBody)
    {
      label174:
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          k = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0|oidb_sso.OIDBSSOPkg.result = " + k);
          }
        }
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      try
      {
        localRspBody.mergeFrom((byte[])paramFromServiceMsg);
        paramFromServiceMsg = localRspBody;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        break label174;
      }
      if (paramFromServiceMsg == null) {
        break;
      }
      int k = paramFromServiceMsg.uint32_id.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : setId:" + k + "hex:" + "");
      }
      if (k != 4051) {
        break;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0| oidb_sso parseFrom byte " + paramToServiceMsg.toString());
      return;
    }
  }
  
  private void dQ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = p(paramToServiceMsg);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramToServiceMsg.extraData.getLong("uin"));
    if (k == 147) {}
    for (k = 72;; k = 71)
    {
      if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
      {
        notifyUI(k, false, localBundle);
        return;
      }
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l = paramToServiceMsg.getInt();
          paramToServiceMsg.getShort();
          paramFromServiceMsg = new byte[4];
          paramToServiceMsg.get(paramFromServiceMsg);
          l = aqft.c(paramFromServiceMsg, 0);
          int i1 = paramToServiceMsg.get();
          localBundle.putLong("uin", l);
          localBundle.putInt("safety_flag", i1 & 0x1F);
          notifyUI(k, true, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handle_oidb_0x476 error:" + paramToServiceMsg.getMessage());
        }
        notifyUI(k, false, localBundle);
        return;
      }
    }
  }
  
  private void dR(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_show_to_friends", true);
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "set network switch isSuccess = " + bool1 + "; isShowedToFriends = " + bool2);
      }
      if (!bool1) {
        break label192;
      }
    }
    label192:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.app.bB(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleSetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.app.aR(false);
        notifyUI(76, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void dS(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.app.bB(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleGetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool3 = false;
        bool1 = bool2;
        bool2 = bool3;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "get network switch isSuccess = " + bool2 + "; isShowedToFriends = " + bool1);
      }
      if (!bool2) {
        bool1 = this.app.aR(false);
      }
      notifyUI(77, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void dT(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() != 1000) {
      notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
    }
    for (;;)
    {
      return;
      int k = paramToServiceMsg.extraData.getInt("startIndex");
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
        label73:
        if (!paramToServiceMsg.uint32_result.has())
        {
          notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        break label73;
        int i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList result " + i1);
        }
        if (i1 == 0)
        {
          paramFromServiceMsg = new cmd0x7c4.RspBody();
          int i2;
          acff localacff;
          ArrayList localArrayList;
          for (;;)
          {
            try
            {
              paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
              paramObject = (cmd0x7c4.GetSNFrdListRsp)paramFromServiceMsg.msg_get_sn_frd_list_rsp.get();
              paramObject.uint64_uin.get();
              i1 = paramObject.uint32_sequence.get();
              i2 = paramObject.uint32_over.get();
              if (paramFromServiceMsg.rpt_msg_recommend_reason.has())
              {
                paramToServiceMsg = paramFromServiceMsg.rpt_msg_recommend_reason.get();
                ((acff)this.app.getManager(51)).iR(paramToServiceMsg);
              }
              paramToServiceMsg = paramObject.rpt_msg_one_frd_data.get();
              localacff = (acff)this.app.getManager(51);
              if (paramToServiceMsg == null) {
                break label577;
              }
              localArrayList = new ArrayList();
              Iterator localIterator = paramToServiceMsg.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              cmd0x7c4.OneFrdData localOneFrdData = (cmd0x7c4.OneFrdData)localIterator.next();
              Friends localFriends = new Friends();
              localFriends.uin = String.valueOf(localOneFrdData.uint64_frd_id.get());
              localFriends.age = localOneFrdData.uint32_ages.get();
              if (localOneFrdData.bytes_smart_remark.has())
              {
                paramToServiceMsg = localOneFrdData.bytes_smart_remark.get().toStringUtf8();
                localFriends.smartRemark = paramToServiceMsg;
                localFriends.gender = ((byte)localOneFrdData.uint32_gender.get());
                int i3 = localOneFrdData.uint32_reason_id.get();
                localFriends.recommReason = localacff.dx(i3);
                localArrayList.add(localFriends);
                if (QLog.isColorLevel()) {
                  QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList Gather List : " + localFriends.uin + " ; resonId = " + i3 + " ; f.recommReason =  " + localFriends.recommReason + " ; f.age = " + localFriends.age + " ; f.smartRemark = " + localFriends.smartRemark + " ; f.gender = " + localFriends.gender);
                }
              }
              else
              {
                paramToServiceMsg = null;
              }
            }
            catch (Exception paramToServiceMsg)
            {
              notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
              return;
            }
          }
          localacff.A(localArrayList, k);
          label577:
          if (paramObject.uint32_recommend_frd_count.has())
          {
            k = paramObject.uint32_recommend_frd_count.get();
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  推荐人数 : " + k);
            }
            localacff.Jc(k);
            boolean bool = paramFromServiceMsg.msg_box.has();
            this.app.getHandler(Conversation.class);
            if (!bool) {
              break label863;
            }
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. ");
            }
            paramToServiceMsg = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
            bool = paramToServiceMsg.getBoolean("hasPulledRecomGathered", false);
            paramToServiceMsg.edit().putBoolean("hasMsgBox", true).commit();
            if (!bool) {
              break label845;
            }
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. hasPulled. ");
            }
          }
          for (;;)
          {
            if (i2 != 0) {
              break label881;
            }
            k = paramObject.uint32_next_start_idx.get();
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "FriendListHandler handleGetGatheredContactsList. not Completed. continue to get. startIndex = " + k);
            }
            IY(k);
            notifyUI(79, true, new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
            return;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  no recommended field. ");
            break;
            label845:
            if (QLog.isColorLevel())
            {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. hasPulled. go to get.");
              continue;
              label863:
              if (QLog.isColorLevel()) {
                QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList no has MsgBox. ");
              }
            }
          }
          label881:
          if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler", 2, "FriendListHandler handleGetGatheredContactsList. Completed.");
          }
          this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit().putInt("GetFrdListReq_seq", i1).commit();
          notifyUI(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
          if (localacff != null) {
            localacff.cJd();
          }
        }
        else
        {
          if (i1 == 1)
          {
            notifyUI(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
            return;
          }
          notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
        }
      }
    }
  }
  
  private void dU(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = paramToServiceMsg.extraData.getInt("key_permission_opcode");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("key_dongtai_permission", false);
    boolean bool1;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject) == null)
    {
      if (!QLog.isColorLevel()) {
        break label167;
      }
      QLog.d("FriendListHandler", 2, "handleSetDongtaiPermission: ssoPkg parse failed");
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1) {
        if (k == 1) {
          bool2 = this.app.aT(false);
        }
      }
      label257:
      for (;;)
      {
        label73:
        if (k == 1) {
          notifyUI(81, bool1, Boolean.valueOf(bool2));
        }
        label167:
        do
        {
          return;
          if (k == 1) {}
          try
          {
            this.app.bE(bool2, false);
          }
          catch (Exception paramToServiceMsg)
          {
            if (!QLog.isColorLevel()) {
              break label167;
            }
            QLog.d("FriendListHandler", 2, "handleSetDongtaiPermission " + paramToServiceMsg.getMessage());
          }
          if (k == 2)
          {
            this.app.bF(bool2, false);
            break label260;
            bool1 = false;
            break;
          }
          if (k != 3) {
            break label260;
          }
          this.app.bE(bool2, false);
          this.app.bF(bool2, false);
          break label260;
          if (k != 2) {
            break label257;
          }
          bool2 = this.app.aU(false);
          break label73;
          if (k == 2)
          {
            notifyUI(83, bool1, Boolean.valueOf(bool2));
            return;
          }
        } while (k != 3);
        notifyUI(85, bool1, null);
        return;
      }
      label260:
      bool1 = true;
    }
  }
  
  private void dV(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1;
    int k;
    Object localObject;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      k = paramToServiceMsg.extraData.getInt("key_permission_opcode");
      paramFromServiceMsg = null;
      localObject = null;
      if (!bool1) {
        break label702;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          bool2 = true;
          if (!bool2) {
            continue;
          }
          paramObject = new cmd0x7c7.RspBody();
          paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (k != 1) {
            continue;
          }
          i1 = paramObject.uint32_not_see_qzone.get();
          if (i1 != 1) {
            continue;
          }
          bool1 = true;
          bool3 = bool1;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          if (paramObject.uint32_not_see_qzone.get() == 1)
          {
            bool1 = true;
            paramToServiceMsg.add(Boolean.valueOf(bool1));
            if (paramObject.uint32_prevent_dynamic.get() == 1)
            {
              bool1 = true;
              paramToServiceMsg.add(Boolean.valueOf(bool1));
              paramFromServiceMsg = this.app;
              if (paramObject.uint32_not_see_qzone.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.bE(bool1, false);
              paramFromServiceMsg = this.app;
              if (paramObject.uint32_prevent_dynamic.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.bF(bool1, false);
              bool1 = true;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          if (paramToServiceMsg == null) {
            continue;
          }
          int i1 = paramToServiceMsg.uint32_result.get();
          paramToServiceMsg = localObject;
          bool1 = bool4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FriendListHandler", 2, "handleGetDongtaiPermission  fail resultCode : " + i1);
          paramToServiceMsg = localObject;
          bool1 = bool4;
        }
        catch (Exception paramObject)
        {
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramObject;
          bool1 = bool3;
          continue;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool1 = bool3;
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetDongtaiPermission Exception " + paramToServiceMsg.getMessage());
        }
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = false;
        continue;
        paramToServiceMsg = localObject;
        bool1 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "ssoPkg is null");
        paramToServiceMsg = localObject;
        bool1 = bool4;
        continue;
        if (k == 2)
        {
          bool3 = this.app.aU(false);
          paramFromServiceMsg = paramToServiceMsg;
          continue;
        }
        paramFromServiceMsg = paramToServiceMsg;
        bool3 = bool1;
        if (k != 3) {
          continue;
        }
        paramFromServiceMsg = new ArrayList();
        paramFromServiceMsg.add(Boolean.valueOf(this.app.aT(false)));
        paramFromServiceMsg.add(Boolean.valueOf(this.app.aU(false)));
        bool3 = bool1;
        continue;
        if (k == 2)
        {
          notifyUI(84, bool2, Boolean.valueOf(bool3));
          return;
        }
        if (k != 3) {
          continue;
        }
        notifyUI(86, bool2, paramFromServiceMsg);
        return;
      }
      try
      {
        this.app.bE(bool1, false);
        paramToServiceMsg = null;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool3;
        continue;
        paramToServiceMsg = null;
        bool1 = true;
        continue;
      }
      paramFromServiceMsg = paramToServiceMsg;
      bool3 = bool1;
      if (!bool2)
      {
        if (k == 1)
        {
          bool3 = this.app.aT(false);
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
      else
      {
        if (k != 1) {
          continue;
        }
        notifyUI(82, bool2, Boolean.valueOf(bool3));
        return;
        bool1 = false;
        break;
        bool2 = false;
        continue;
        bool1 = false;
        continue;
        if (k == 2)
        {
          i1 = paramObject.uint32_prevent_dynamic.get();
          if (i1 == 1)
          {
            bool1 = true;
            bool3 = bool1;
            this.app.bF(bool1, false);
            paramToServiceMsg = null;
            continue;
          }
          bool1 = false;
          continue;
        }
        if (k != 3) {
          break label694;
        }
        paramToServiceMsg = new ArrayList();
      }
      label694:
      label702:
      bool3 = true;
      boolean bool2 = bool1;
      paramToServiceMsg = null;
      bool1 = bool3;
    }
  }
  
  private void dW(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool3 = true;
    boolean bool4;
    boolean bool5;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      bool4 = paramToServiceMsg.extraData.getBoolean("isGather", true);
      bool5 = paramToServiceMsg.extraData.getBoolean("needNotifyPlugin", false);
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("friendUinList");
      bool1 = bool2;
      if (!bool2) {}
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        paramFromServiceMsg = (acff)this.app.getManager(51);
        if (!bool4) {
          continue;
        }
        paramFromServiceMsg.iQ(paramToServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp,error: " + paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int k = paramFromServiceMsg.uint32_result.get();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp fail: resultCode = " + k);
        continue;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp,error: " + paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp ssoPkg is null");
        continue;
        notifyUI(91, bool1, paramToServiceMsg);
        continue;
        bool2 = false;
        continue;
        bool2 = bool3;
        if (!bool1) {
          continue;
        }
        bool2 = false;
        continue;
      }
      if (!bool4) {
        continue;
      }
      notifyUI(90, bool1, paramToServiceMsg);
      if (bool5)
      {
        paramFromServiceMsg = new Intent("action_gather_resp");
        paramFromServiceMsg.putStringArrayListExtra("key_uin_list", paramToServiceMsg);
        paramFromServiceMsg.putExtra("key_is_suc", bool1);
        if (!bool4) {
          continue;
        }
        if (!bool1) {
          continue;
        }
        bool2 = bool3;
        paramFromServiceMsg.putExtra("key_is_gather", bool2);
        BaseApplicationImpl.getContext().sendBroadcast(paramFromServiceMsg);
      }
      return;
      bool2 = false;
      break;
      bool1 = false;
      continue;
      paramFromServiceMsg.iP(paramToServiceMsg);
    }
  }
  
  private void dX(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    oidb_0xc26.RspBody localRspBody;
    int k;
    int i1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool = true;
      localRspBody = new oidb_0xc26.RspBody();
      k = -1;
      if (!bool) {
        break label405;
      }
      i1 = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      k = i1;
      if (i1 == 0) {
        break label405;
      }
      k = i1;
      bool = false;
    }
    label276:
    label405:
    for (;;)
    {
      achg localachg = (achg)this.app.getManager(159);
      label93:
      List localList;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
      {
        paramToServiceMsg = paramToServiceMsg.extraData.getBundle("EXTRA:OidbSvc.0xc26_0");
        if (!bool) {
          break label399;
        }
        Object localObject = localRspBody.rpt_msg_persons.get();
        localRspBody.rpt_entry_close.get();
        paramFromServiceMsg = localRspBody.rpt_entry_inuse.get();
        paramObject = localRspBody.rpt_entry_delays.get();
        i1 = localRspBody.uint32_timestamp.get();
        localRspBody.uint32_next_gap.get();
        int i2 = localRspBody.uint32_msg_up.get();
        int i3 = localRspBody.uint32_list_switch.get();
        int i4 = localRspBody.uint32_add_page_list_switch.get();
        int i5 = localRspBody.em_rsp_data_type.get();
        localList = localRspBody.rpt_msg_rgroup_items.get();
        localObject = MayKnowRecommend.covServerDataToLocal((List)localObject, i1, 23);
        localachg.iV(paramFromServiceMsg);
        localachg.iW(paramObject);
        if (i5 != 1) {
          break label387;
        }
        if (!localRspBody.rpt_msg_tables.has()) {
          break label377;
        }
        paramFromServiceMsg = localRspBody.rpt_msg_tables.get();
        label253:
        if (!localRspBody.bytes_cookies.has()) {
          break label382;
        }
        paramObject = localRspBody.bytes_cookies.get().toByteArray();
        localachg.a(bool, (ArrayList)localObject, i1, i2, i3, i4, paramToServiceMsg, paramFromServiceMsg, paramObject);
        label296:
        localachg.Jp(i5);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 1, "handleGetMayKnowRecommend, isSuc=" + bool + ",oidbesult=" + k);
        }
        notifyUI(92, bool, paramToServiceMsg);
        notifyUI(113, bool, paramToServiceMsg);
        return;
        bool = false;
        break;
        paramToServiceMsg = null;
        break label93;
        label377:
        paramFromServiceMsg = null;
        break label253;
        label382:
        paramObject = null;
        break label276;
        localachg.K(bool, localList);
        break label296;
        bool = false;
      }
    }
  }
  
  private void dY(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    int i1;
    boolean bool;
    Bundle localBundle;
    int i2;
    Object localObject;
    int i3;
    do
    {
      return;
      i1 = ((Integer)paramToServiceMsg.getAttribute("tabID", Integer.valueOf(0))).intValue();
      bool = ((Boolean)paramToServiceMsg.getAttribute("isFirstPage", Boolean.valueOf(true))).booleanValue();
      localBundle = (Bundle)paramToServiceMsg.getAttribute("extra_bd", null);
      i2 = localBundle.getInt("load_biz_type", 0);
      localObject = new oidb_0xc26.RspBody();
      i3 = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (i3 != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "handleGetConnectionsPerson sus " + i1 + " " + bool);
      }
    } while (((oidb_0xc26.RspBody)localObject).em_rsp_data_type.get() != 1);
    paramObject = ((oidb_0xc26.RspBody)localObject).rpt_msg_persons.get();
    if (((oidb_0xc26.RspBody)localObject).rpt_msg_tables.has())
    {
      paramToServiceMsg = ((oidb_0xc26.RspBody)localObject).rpt_msg_tables.get();
      if (!((oidb_0xc26.RspBody)localObject).bytes_cookies.has()) {
        break label318;
      }
    }
    label318:
    for (paramFromServiceMsg = ((oidb_0xc26.RspBody)localObject).bytes_cookies.get().toByteArray();; paramFromServiceMsg = null)
    {
      int k = ((oidb_0xc26.RspBody)localObject).uint32_timestamp.get();
      localObject = (achg)this.app.getManager(159);
      if (!bool) {
        k = ((achg)localObject).gx(i1) - 1;
      }
      ((achg)localObject).a(i1, MayKnowRecommend.covServerDataToLocal(paramObject, k, i1), paramToServiceMsg, paramFromServiceMsg, bool, localBundle);
      if (!bool) {
        ((achg)localObject).Jj(i1);
      }
      notifyUI(132, true, new Object[] { Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(i2) });
      return;
      paramToServiceMsg = null;
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "handleGetConnectionsPerson failed result:" + i3 + " " + i1 + ", bizType=" + i2);
    }
    paramToServiceMsg = (achg)this.app.getManager(159);
    if (i3 == 1205) {
      paramToServiceMsg.Jl(i1);
    }
    if (!bool) {
      paramToServiceMsg.Jj(i1);
    }
    notifyUI(132, false, new Object[] { Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(i2) });
  }
  
  private void dZ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int k;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      k = -1;
      bool2 = bool1;
      if (bool1)
      {
        int i1 = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xc36.RspBody());
        k = i1;
        bool2 = bool1;
        if (i1 != 0)
        {
          bool2 = false;
          k = i1;
        }
      }
      paramToServiceMsg = paramToServiceMsg.extraData.getString("uin");
      if (!bool2) {
        break label137;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 1, "handleCancelMayKnowRecommend, isSuc=" + bool2 + ",oidbesult=" + k + ", uin=" + paramToServiceMsg);
      }
      return;
      bool1 = false;
      break;
      label137:
      bool2 = false;
    }
  }
  
  private void dz(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    paramObject = (GetAutoInfoResp)paramObject;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && (paramObject.errorCode == 0))
    {
      paramToServiceMsg.putInt("group_id", paramObject.cGroupID);
      paramToServiceMsg.putString("nick_name", paramObject.strRemark);
      notifyUI(33, true, paramToServiceMsg);
      return;
    }
    notifyUI(33, false, paramToServiceMsg);
  }
  
  private void e(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof GetSimpleOnlineFriendInfoResp))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)paramObject;
      if (paramFromServiceMsg == null) {
        notifyUI(13, false, null);
      }
    }
    else
    {
      return;
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 1))
    {
      notifyUI(13, false, null);
      return;
    }
    if (paramFromServiceMsg.shClickInterval > 30)
    {
      k = paramFromServiceMsg.shClickInterval * 1000;
      QQAppInterface.cxs = k;
      if (paramFromServiceMsg.intervalTimeMin <= 3) {
        break label179;
      }
    }
    label179:
    for (int k = paramFromServiceMsg.intervalTimeMin * 60 * 1000;; k = 180000)
    {
      QQAppInterface.cxr = k;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "Next Get Online Friend Delay " + QQAppInterface.cxr);
      }
      g(paramFromServiceMsg.cShowPcIcon);
      if (paramFromServiceMsg.vecFriendInfo.size() <= 0) {
        break label186;
      }
      ((acff)this.app.getManager(51)).dC(paramFromServiceMsg.vecFriendInfo);
      notifyUI(13, true, null);
      return;
      k = 30000;
      break;
    }
    label186:
    notifyUI(13, false, null);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    bool2 = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleInfoOpenId ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label225;
      }
    }
    label225:
    for (int k = paramArrayOfByte.length;; k = -1)
    {
      QLog.d("FriendListHandler", 2, k);
      paramToServiceMsg = paramToServiceMsg.extraData;
      bool1 = bool2;
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          break;
        }
        paramArrayOfByte = new oidb_0x5e1.RspBody();
        paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramArrayOfByte.rpt_msg_uin_data.size() <= 0) {
          break;
        }
        paramFromServiceMsg = new String(((oidb_0x5e1.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(0)).bytes_nick.get().toByteArray());
        paramToServiceMsg.putString("nick_name", paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleInfoOpenId " + paramFromServiceMsg);
        }
        bool1 = true;
      }
      catch (Throwable paramFromServiceMsg)
      {
        for (;;)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("FriendListHandler", 2, "", paramFromServiceMsg);
            bool1 = bool2;
            continue;
            bool1 = false;
          }
        }
      }
      notifyUI(74, bool1, paramToServiceMsg);
      return;
    }
  }
  
  private void ea(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    int k;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      k = -1;
      if (!bool1) {
        break label125;
      }
      int i1 = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xc35.RspBody());
      k = i1;
      if (i1 == 0) {
        break label125;
      }
      bool1 = bool2;
      k = i1;
    }
    label125:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 1, "handleReportMayknowExplosure, isSuc=" + bool1 + ",oidbesult=" + k);
      }
      ((achg)this.mApp.getManager(159)).Fd(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void eb(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xc34.RspBody());
    if (k != 0) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 1, "handleReqHideConversationTroopRecommend, isSuc=" + bool + ",oidbesult=" + k);
    }
  }
  
  private void ec(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xc34.RspBody());
    if (k != 0) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 1, "handleReqHideConversationMayknowRecommend, isSuc=" + bool + ",oidbesult=" + k);
      }
      if (bool) {
        ((achg)this.app.getManager(159)).cJU();
      }
      notifyUI(116, bool, null);
      return;
    }
  }
  
  private void ed(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend resp: " + paramFromServiceMsg + ", data: " + paramObject);
    }
    boolean bool;
    Object localObject;
    if ((??? != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label733;
      }
      cvh = 0;
      localObject = new oidb_0x7df.RspBody();
      ??? = a(???, paramFromServiceMsg, paramObject);
      if (??? == null) {
        break label373;
      }
    }
    int k;
    label373:
    label379:
    do
    {
      for (;;)
      {
        try
        {
          ((oidb_0x7df.RspBody)localObject).mergeFrom(???.bytes_bodybuffer.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend isSuccess: " + bool);
          }
          if (!bool) {
            break label733;
          }
          notifyUI(95, true, localObject);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend isOver: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_over.has()) {
              break label379;
            }
            k = ((oidb_0x7df.RspBody)localObject).uint32_over.get();
            ??? = ???.append(k).append(", next: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_next_start.has()) {
              break label385;
            }
            k = ((oidb_0x7df.RspBody)localObject).uint32_next_start.get();
            ??? = ???.append(k).append(", total: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_total.has()) {
              break label391;
            }
            k = ((oidb_0x7df.RspBody)localObject).uint32_total.get();
            ??? = ???.append(k).append(", lowest: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_low_score.has()) {
              break label397;
            }
            k = ((oidb_0x7df.RspBody)localObject).uint32_low_score.get();
            QLog.d("FriendListHandler", 2, k);
          }
          if (((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.has()) {
            break label403;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend rpt_msg_friend_score has no data.");
          }
          return;
          bool = false;
        }
        catch (Exception ???)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend RspBody mergeFrom failed.");
          }
          ???.printStackTrace();
          bool = false;
          continue;
        }
        bool = false;
        continue;
        k = -1;
        continue;
        k = -1;
        continue;
        k = -1;
        continue;
        k = -1;
      }
      paramFromServiceMsg = ((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.get();
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0)) {
        break label441;
      }
    } while (!QLog.isColorLevel());
    label385:
    label391:
    label397:
    label403:
    QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend friendList is null or has no data.");
    return;
    label441:
    paramObject = paramFromServiceMsg.iterator();
    while (paramObject.hasNext())
    {
      localObject = (oidb_0x7df.FriendScore)paramObject.next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend uin: ");
        if (((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.has())
        {
          ??? = String.valueOf(((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.get());
          label512:
          ??? = localStringBuilder.append(???).append(", score: ");
          if (!((oidb_0x7df.FriendScore)localObject).uint32_friend_score.has()) {
            break label678;
          }
          k = ((oidb_0x7df.FriendScore)localObject).uint32_friend_score.get();
          label546:
          localStringBuilder = ???.append(k).append(", relation: ");
          if (!((oidb_0x7df.FriendScore)localObject).bytes_relation_name.has()) {
            break label684;
          }
          ??? = ((oidb_0x7df.FriendScore)localObject).bytes_relation_name.get().toStringUtf8();
          label583:
          ??? = localStringBuilder.append(???).append(", rank: ");
          if (!((oidb_0x7df.FriendScore)localObject).uint32_rank.has()) {
            break label690;
          }
          k = ((oidb_0x7df.FriendScore)localObject).uint32_rank.get();
          label617:
          localStringBuilder = ???.append(k).append(", nick: ");
          if (!((oidb_0x7df.FriendScore)localObject).bytes_nick.has()) {
            break label696;
          }
        }
        label678:
        label684:
        label690:
        label696:
        for (??? = ((oidb_0x7df.FriendScore)localObject).bytes_nick.get().toStringUtf8();; ??? = "")
        {
          QLog.d("FriendListHandler", 2, ???);
          break;
          ??? = "";
          break label512;
          k = -1;
          break label546;
          ??? = "";
          break label583;
          k = -1;
          break label617;
        }
      }
    }
    synchronized (this.bU)
    {
      this.sA.clear();
      this.sA.addAll(paramFromServiceMsg);
      return;
    }
    label733:
    cvh = 1;
    notifyUI(95, false, null);
  }
  
  private void ee(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((QLog.isColorLevel()) && (paramFromServiceMsg != null)) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.handleBatchAddPhoneFriend sso resp: " + paramFromServiceMsg + ", data: " + paramObject);
    }
    boolean bool2;
    oidb_0x829.RspBody localRspBody;
    ArrayList localArrayList1;
    int i1;
    ArrayList localArrayList2;
    String str;
    int i2;
    int i3;
    PhoneContactManagerImp localPhoneContactManagerImp;
    boolean bool1;
    int k;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      localRspBody = new oidb_0x829.RspBody();
      localArrayList1 = (ArrayList)paramToServiceMsg.extraData.getSerializable("phones");
      i1 = Integer.valueOf(paramToServiceMsg.extraData.getInt("package", -1)).intValue();
      localArrayList2 = (ArrayList)paramToServiceMsg.extraData.getSerializable("resultList");
      str = paramToServiceMsg.extraData.getString("verifyMsg");
      i2 = Integer.valueOf(paramToServiceMsg.extraData.getInt("sourceId")).intValue();
      i3 = i1 * 30;
      localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
      bool1 = bool2;
      if (bool2)
      {
        paramToServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        if (paramToServiceMsg == null) {
          break label474;
        }
        k = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "FriendListHandler.handleBatchAddPhoneFriend oidb result code: " + k);
        }
        if (k != 0) {
          break label442;
        }
        bool2 = true;
        label243:
        bool1 = bool2;
        if (!bool2) {}
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool1 = bool2;
      }
      catch (Exception paramToServiceMsg)
      {
        label442:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "FriendListHandler.handleBatchAddPhoneFriend RspBody mergeFrom failed.");
        bool1 = false;
        paramToServiceMsg.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendListHandler.handleBatchAddPhoneFriend isSuccess: " + bool1);
      }
      if (!bool1) {
        break label553;
      }
      if (!localRspBody.rpt_add_frd_info.has()) {
        break label480;
      }
      k = 0;
      if (k >= localRspBody.rpt_add_frd_info.size()) {
        break label480;
      }
      paramToServiceMsg = (oidb_0x829.AddFrdInfo)localRspBody.rpt_add_frd_info.get(k);
      paramFromServiceMsg = new AddBatchPhoneFriendResult();
      paramFromServiceMsg.mobile = paramToServiceMsg.bytes_mobile.get().toStringUtf8();
      paramFromServiceMsg.remark = paramToServiceMsg.bytes_remark.get().toStringUtf8();
      paramFromServiceMsg.allowType = paramToServiceMsg.uint32_allow_type.get();
      paramFromServiceMsg.sendReqFlag = paramToServiceMsg.uint32_send_req_flag.get();
      paramFromServiceMsg.sendResult = paramToServiceMsg.uint32_send_result.get();
      localArrayList2.add(paramFromServiceMsg);
      k += 1;
      continue;
      bool2 = false;
      break;
      bool2 = false;
      break label243;
      label474:
      bool1 = false;
    }
    label480:
    if ((i1 != -1) && (localArrayList1 != null) && (localArrayList2 != null) && (i3 < localArrayList1.size()))
    {
      this.app.runOnUiThread(new FriendListHandler.6(this, localArrayList1, str, i1, i2, localArrayList2));
      return;
    }
    localPhoneContactManagerImp.c(localArrayList1, localArrayList2, i2);
    notifyUI(110, true, localArrayList2);
    return;
    label553:
    if ((i1 != -1) && (localArrayList1 != null) && (localArrayList2 != null) && (i3 < localArrayList1.size()))
    {
      this.app.runOnUiThread(new FriendListHandler.7(this, localArrayList1, str, i1, i2, localArrayList2));
      return;
    }
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      localPhoneContactManagerImp.c(localArrayList1, localArrayList2, i2);
      notifyUI(110, true, localArrayList2);
      return;
    }
    notifyUI(110, false, null);
  }
  
  private void ef(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    cmd0xc83.RspBody localRspBody = new cmd0xc83.RspBody();
    int i2 = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i2 != 0) {
      bool = false;
    }
    int k;
    if ((bool) && (localRspBody.uint32_result.has()) && (localRspBody.uint32_result.get() == 0))
    {
      bool = true;
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("selfUin", "");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("frdUin", "");
      if (!localRspBody.uint32_retry_interval.has()) {
        break label220;
      }
      k = localRspBody.uint32_retry_interval.get();
      label109:
      if (QLog.isColorLevel()) {
        if (!localRspBody.uint32_result.has()) {
          break label226;
        }
      }
    }
    label220:
    label226:
    for (int i1 = localRspBody.uint32_result.get();; i1 = -1)
    {
      QLog.i("FriendReactive", 2, String.format("handleReqRecheckInHotReactive suc=%b oidb=%d result=%d interval=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(k) }));
      notifyUI(117, bool, new Object[] { paramFromServiceMsg, paramToServiceMsg, Integer.valueOf(k) });
      return;
      bool = false;
      break;
      k = 0;
      break label109;
    }
  }
  
  private void eg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    cmd0xc85.RspBody localRspBody = new cmd0xc85.RspBody();
    int i3 = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i3 != 0) {
      bool = false;
    }
    int k;
    label109:
    long l;
    int i2;
    if ((bool) && (localRspBody.uint32_result.has()) && (localRspBody.uint32_result.get() == 0))
    {
      i1 = 1;
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("selfUin", "");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("frdUin", "");
      if (!localRspBody.uint32_recent_interaction_time.has()) {
        break label264;
      }
      k = localRspBody.uint32_recent_interaction_time.get();
      l = k;
      if (k > 0) {
        l = 1000L * (86400 * k - 28800);
      }
      if (l < 0L) {
        break label270;
      }
      i2 = 1;
      label146:
      bool = i2 & i1;
      if (QLog.isColorLevel()) {
        if (!localRspBody.uint32_result.has()) {
          break label276;
        }
      }
    }
    label264:
    label270:
    label276:
    for (int i1 = localRspBody.uint32_result.get();; i1 = -1)
    {
      QLog.i("IceBreak", 2, String.format("handleReqLastChatTime suc=%b oidb=%d result=%d ts=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(k) }));
      notifyUI(118, bool, new Object[] { paramFromServiceMsg, paramToServiceMsg, Long.valueOf(l) });
      return;
      i1 = 0;
      break;
      k = 0;
      break label109;
      i2 = 0;
      break label146;
    }
  }
  
  private void eh(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (this.jdField_a_of_type_Alui == null) {
      return;
    }
    this.jdField_a_of_type_Alui.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void ei(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new cmd0xcf0.RspBody();
    int i1 = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int k;
    if (i1 == 0)
    {
      k = paramToServiceMsg.uint32_total_bind_contacts_frd_num.get();
      paramToServiceMsg = paramToServiceMsg.rpt_msg_bind_contacts_frds.get();
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramFromServiceMsg = new ArrayList(paramToServiceMsg.size());
        paramObject = paramToServiceMsg.iterator();
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (!paramObject.hasNext()) {
            break;
          }
          paramToServiceMsg = (cmd0xcf0.BindContactsFriendInfo)paramObject.next();
          if ((paramToServiceMsg != null) && (paramToServiceMsg.uint64_uin.get() != 0L)) {
            paramFromServiceMsg.add(String.valueOf(paramToServiceMsg.uint64_uin.get()));
          }
        }
      }
      paramToServiceMsg = null;
      paramFromServiceMsg = (ajdo)this.app.getManager(11);
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.J(k, paramToServiceMsg);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg == null)
        {
          paramFromServiceMsg = "null";
          QLog.i("FriendListHandler", 2, String.format("handleGetFriendsHasBindPhone [%s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(k), paramFromServiceMsg }));
        }
      }
      else {
        if (i1 != 0) {
          break label253;
        }
      }
      label253:
      for (boolean bool = true;; bool = false)
      {
        notifyUI(121, bool, new Object[] { Integer.valueOf(k), paramToServiceMsg });
        return;
        paramFromServiceMsg = Integer.valueOf(paramToServiceMsg.size());
        break;
      }
      k = 0;
      paramToServiceMsg = null;
    }
  }
  
  private void g(byte paramByte)
  {
    byte b = 1;
    boolean bool;
    if ((paramByte == 0) || (paramByte == 1))
    {
      if (paramByte != 1) {
        break label59;
      }
      bool = true;
      if (bool != aaa()) {
        if (!bool) {
          break label64;
        }
      }
    }
    label59:
    label64:
    for (paramByte = b;; paramByte = 0)
    {
      this.cvf = paramByte;
      aqgu.g(this.app.getApp().getApplicationContext(), this.app.getAccount(), bool);
      return;
      bool = false;
      break;
    }
  }
  
  private void iL(List<LastLoginInfo> paramList)
  {
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("saveLastLoginInfos begin ");
      if (paramList != null)
      {
        k = paramList.size();
        QLog.d("FriendListHandler", 2, k);
      }
    }
    else
    {
      localObject1 = (acff)this.app.getManager(51);
      localObject2 = ((acff)localObject1).cq();
      if ((paramList == null) || (localObject2 == null)) {
        break label335;
      }
      localArrayList = new ArrayList(((ArrayList)localObject2).size());
      if (paramList.size() != 0) {
        break label188;
      }
      paramList = ((ArrayList)localObject2).iterator();
      label102:
      while (paramList.hasNext())
      {
        localObject2 = (Friends)paramList.next();
        if (localObject2 != null)
        {
          if (((Friends)localObject2).lastLoginType == 0L) {
            break label356;
          }
          ((Friends)localObject2).lastLoginType = 0L;
        }
      }
    }
    label188:
    label335:
    label351:
    label356:
    for (int k = 1;; k = 0)
    {
      if (((Friends)localObject2).showLoginClient != 0L)
      {
        ((Friends)localObject2).showLoginClient = 0L;
        k = 1;
      }
      if (k == 0) {
        break label102;
      }
      localArrayList.add(localObject2);
      break label102;
      k = -1;
      break;
      paramList = paramList.iterator();
      Friends localFriends;
      while (paramList.hasNext())
      {
        localObject2 = (LastLoginInfo)paramList.next();
        localFriends = ((acff)localObject1).e(String.valueOf(((LastLoginInfo)localObject2).dwFriendUin));
        if (localFriends != null)
        {
          if (localFriends.showLoginClient == ((LastLoginInfo)localObject2).dwClient) {
            break label351;
          }
          localFriends.showLoginClient = ((LastLoginInfo)localObject2).dwClient;
        }
      }
      for (k = 1;; k = 0)
      {
        if (localFriends.lastLoginType != ((LastLoginInfo)localObject2).dwLastLoginType)
        {
          localFriends.lastLoginType = ((LastLoginInfo)localObject2).dwLastLoginType;
          k = 1;
        }
        if (k == 0) {
          break;
        }
        localArrayList.add(localFriends);
        break;
        ((acff)localObject1).a((Friends[])localArrayList.toArray(new Friends[localArrayList.size()]), localArrayList.size());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "saveLastLoginInfos ends ");
        }
        return;
      }
    }
  }
  
  private boolean jY(String paramString)
  {
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l1;
    long l2;
    long l3;
    if (bool1)
    {
      Context localContext = this.app.getApp().getApplicationContext();
      Card localCard = ((acff)this.app.getManager(51)).c(paramString);
      l1 = aqgu.h(localContext, paramString) + 28800000L;
      l2 = System.currentTimeMillis() + 28800000L;
      l3 = localCard.iXManScene1DelayTime * 1000;
      if ((l1 / 86400000L == l2 / 86400000L) || (Math.abs(l2 - l1) <= 28800000L) || (l2 % 86400000L < l3)) {
        break label238;
      }
    }
    label238:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, String.format("shouldReqXMan toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s lastReqDay=%s currentDay=%s lastReqInterval=%s time=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1 / 86400000L), Long.valueOf(l2 / 86400000L), Long.valueOf(Math.abs(l2 - l1)), Long.valueOf(l2 % 86400000L) }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  private boolean jZ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, String.format("shouldReqXManScene2 friendUin=%s", new Object[] { paramString }));
    }
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l1;
    long l2;
    long l3;
    if (bool1)
    {
      Context localContext = this.app.getApp().getApplicationContext();
      Card localCard = ((acff)this.app.getManager(51)).c(paramString);
      l1 = aqgu.i(localContext, paramString);
      l2 = System.currentTimeMillis();
      l3 = localCard.iXManScene2DelayTime * 1000;
      if ((l3 < 0L) || (Math.abs(l2 - l1) <= l3)) {
        break label181;
      }
    }
    label181:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, String.format("shouldReqXManScene2 toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  private void k(int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
    localMultiBusidUrlReq.srcUidType.set(0);
    localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(16));
    localMultiBusidUrlReq.dstUidType.set(0);
    int k = 0;
    for (;;)
    {
      if (k >= paramArrayList.size()) {
        break label171;
      }
      QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(k);
      MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
      try
      {
        localReqUsrInfo.dstUin.set(alkt.getLong(localQQHeadDetails.boh));
        c(0, localQQHeadDetails.boh, localQQHeadDetails.userType, 1);
        localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ERROR", 2, localException.getMessage());
          }
        }
      }
      k += 1;
    }
    label171:
    new HashMap().put("connum", String.valueOf(paramArrayList.size()));
    ToServiceMsg localToServiceMsg = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("idType", paramInt);
    localToServiceMsg.extraData.putInt("qqHeadType", 16);
    localToServiceMsg.putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_QCall .  idType = " + paramInt);
    }
    sendPbReq(localToServiceMsg);
  }
  
  private void l(int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int k;
    switch (paramInt)
    {
    case 203: 
    default: 
      k = 0;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq;
    label321:
    for (;;)
    {
      localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
      localMultiBusidUrlReq.srcUidType.set(0);
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(1));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(32));
      localMultiBusidUrlReq.dstUidType.set(k);
      int i1 = 0;
      label115:
      if (i1 < paramArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(i1);
        MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
        if (k == 0) {}
        try
        {
          localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.boh));
          for (;;)
          {
            c(0, localQQHeadDetails.boh, localQQHeadDetails.userType, 1);
            localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
            if (QLog.isColorLevel()) {
              QLog.i("multiBusidUrlReq.dstUsrInfos", 2, " multiBusidUrlReq.dstUsrInfos reqUsrInfo.dstUin = " + localReqUsrInfo.dstUin + " ,reqUsrInfo.dstTid = " + localReqUsrInfo.dstTid + " ,reqUsrInfo.dstOpenid = " + localReqUsrInfo.dstOpenid);
            }
            i1 += 1;
            break label115;
            k = 2;
            break;
            k = 1;
            break;
            if (k != 1) {
              break label321;
            }
            localReqUsrInfo.dstTid.set(Long.parseLong(localQQHeadDetails.boh));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.i("ERROR", 2, localException.getMessage());
              continue;
              if (k == 2) {
                localReqUsrInfo.dstOpenid.set(localException.boh);
              }
            }
          }
        }
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("connum", String.valueOf(paramArrayList.size()));
    anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actNearbyHeadConNum", true, 0L, 0L, (HashMap)localObject, "");
    localObject = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
    ((ToServiceMsg)localObject).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putLong("startTime", System.currentTimeMillis());
    ((ToServiceMsg)localObject).extraData.putInt("idType", paramInt);
    ((ToServiceMsg)localObject).putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_Stranger .  idType = " + paramInt);
    }
    sendPbReq((ToServiceMsg)localObject);
  }
  
  private void n(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg.extraData.getStringArray("totalArray"), paramToServiceMsg.extraData.getInt("nextStartPos"), paramToServiceMsg.extraData.getInt("reqType"), paramToServiceMsg.extraData.getBundle("circleBundle"), paramToServiceMsg.extraData.getBoolean("showDateNickname"));
  }
  
  private int p(ToServiceMsg paramToServiceMsg)
  {
    int k = 0;
    try
    {
      Object localObject = ByteBuffer.wrap(paramToServiceMsg.getWupBuffer());
      paramToServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
      ((ByteBuffer)localObject).get(paramToServiceMsg);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramToServiceMsg);
      int i1 = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
      k = i1;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "getServiceTypeFromToServiceMsg error:" + paramToServiceMsg.getMessage());
    }
    return k;
    return 0;
  }
  
  private void p(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetLastLoginInfoReq");
    localToServiceMsg.extraData.putLong("uin", l);
    localToServiceMsg.extraData.putLong("total_req_times", paramLong1);
    localToServiceMsg.extraData.putLong("current_req_index", paramLong2);
    localToServiceMsg.extraData.putLong("current_req_uin", paramLong3);
    send(localToServiceMsg);
  }
  
  public void B(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (this.app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "getFriendInfoBatch uinList is empty or app is null");
      }
      return;
    }
    Object localObject2 = this.app.getCurrentAccountUin();
    Object localObject1 = "";
    int k = paramArrayList.size() - 1;
    label54:
    String str;
    if (k >= 0)
    {
      str = (String)paramArrayList.get(k);
      if ((str == null) || (str.length() == 0) || (!Friends.isValidUin(str)) || (!jW(str))) {
        paramArrayList.remove(k);
      }
    }
    for (;;)
    {
      k -= 1;
      break label54;
      if (str.equals(localObject2))
      {
        localObject1 = localObject2;
        continue;
        if (paramArrayList.isEmpty())
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FriendListHandler", 2, "getFriendInfoBatch uinList is empty");
          return;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendListHandler", 4, String.format(Locale.getDefault(), "getFriendInfoBatch size: %d, friendUin: %s", new Object[] { Integer.valueOf(paramArrayList.size()), localObject1 }));
        }
        localObject2 = createToServiceMsg("ProfileService.GetSimpleInfo");
        ((ToServiceMsg)localObject2).extraData.putStringArrayList("uinList", paramArrayList);
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqSelfLevel", jX((String)localObject1));
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqXMan", jY((String)localObject1));
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqDateNick", paramBoolean);
        ((ToServiceMsg)localObject2).extraData.putBoolean("batch_data", true);
        send((ToServiceMsg)localObject2);
        return;
      }
    }
  }
  
  public void C(String paramString1, String paramString2, boolean paramBoolean)
  {
    g(paramString1, paramString2, paramBoolean, false);
  }
  
  public void DF(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.getFriendGroupList");
    localToServiceMsg.extraData.putBoolean("getSingleFriend", true);
    localToServiceMsg.extraData.putString("targetUin", paramString);
    send(localToServiceMsg);
  }
  
  public void DG(String paramString)
  {
    bC(paramString, false);
  }
  
  public void DH(String paramString)
  {
    a(1, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void DI(String paramString)
  {
    a(4, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void DJ(String paramString)
  {
    a(11, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void DK(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new FriendListHandler.5(this, paramString));
  }
  
  public void DL(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendReactive.FriendListHandler", 2, "reqRecheckInHotReactive frdUin=" + paramString);
    }
    try
    {
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      Object localObject = new cmd0xc83.ReqBody();
      ((cmd0xc83.ReqBody)localObject).uint64_from_uin.set(l);
      ((cmd0xc83.ReqBody)localObject).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((cmd0xc83.ReqBody)localObject).uint32_op.set(2);
      localObject = makeOIDBPkg("OidbSvc.0xc83", 3203, 0, ((cmd0xc83.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("selfUin", this.mApp.getCurrentAccountUin());
      ((ToServiceMsg)localObject).extraData.putString("frdUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqRecheckInHotReactive exception", paramString);
    }
  }
  
  public boolean E(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    short s1;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "getFriendNickByBatch|uinsize = " + paramArrayList.size() + " time=" + System.currentTimeMillis());
      }
      s1 = (short)paramArrayList.size();
    } while (s1 > 500);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1181);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(s1 * 4 + 7);
    ((ByteBuffer)localObject).put((byte)0).putShort((short)1).putShort(this.V).putShort(s1);
    short s2 = 0;
    for (;;)
    {
      if (s2 < s1) {
        try
        {
          ((ByteBuffer)localObject).putInt(aqft.ag(Long.parseLong((String)paramArrayList.get(s2))));
          s2 = (short)(s2 + 1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "getFriendNickByBatch parseLong err uin=" + (String)paramArrayList.get(s2), localException);
            }
          }
        }
      }
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x49d_107");
    ((ToServiceMsg)localObject).extraData.putStringArrayList("batchuin", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putShort("uincount", s1);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public void EQ(boolean paramBoolean)
  {
    by(paramBoolean, false);
  }
  
  public void ER(boolean paramBoolean) {}
  
  public void ES(boolean paramBoolean)
  {
    int k = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      k = 0;
    }
    ((ByteBuffer)localObject).put((byte)k);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x491_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_show_to_friends", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void IY(int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OidbSvc.0x7c4_0");
    localToServiceMsg.extraData.putInt("startIndex", paramInt);
    cmd0x7c4.ReqBody localReqBody = new cmd0x7c4.ReqBody();
    Object localObject = this.app.getAccount();
    cmd0x7c4.GetSNFrdListReq localGetSNFrdListReq = new cmd0x7c4.GetSNFrdListReq();
    localGetSNFrdListReq.uint64_uin.set(Long.parseLong((String)localObject));
    int k = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
    localGetSNFrdListReq.uint32_sequence.set(k);
    localGetSNFrdListReq.uint32_start_idx.set(paramInt);
    localGetSNFrdListReq.uint32_req_num.set(cvg);
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "FriendListHandler getGatheredContactsList(). startIndex = " + paramInt + " | seq = " + k);
    }
    localReqBody.msg_get_sn_frd_list_req.set(localGetSNFrdListReq);
    localReqBody.uint32_client_ver.set(2);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1988);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  public void IZ(int paramInt)
  {
    cmd0xcf0.ReqBody localReqBody = new cmd0xcf0.ReqBody();
    localReqBody.uint32_expect_bind_contacts_frd_num.set(paramInt);
    sendPbReq(makeOIDBPkg("OidbSvc.0xcf0_0", 3312, 0, localReqBody.toByteArray()));
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getFriendsHasBindPhone :" + paramInt);
    }
  }
  
  public void J(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 3, null, false);
    this.bHt = true;
  }
  
  public void K(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 0, null, false);
  }
  
  public void L(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      i1 = paramArrayOfString.length;
      k = 0;
      if (k < i1)
      {
        String str = paramArrayOfString[k];
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          k += 1;
          break;
          if ((Friends.isValidUin(str)) && (jW(str))) {
            localArrayList.add(str);
          }
        }
      }
    } while (localArrayList.size() < 1);
    paramArrayOfString = new String[localArrayList.size()];
    int i1 = localArrayList.size();
    int k = 0;
    while (k < i1)
    {
      paramArrayOfString[k] = ((String)localArrayList.get(k));
      k += 1;
    }
    K(paramArrayOfString);
    paramArrayOfString = createToServiceMsg("ProfileService.GetSimpleInfo");
    paramArrayOfString.extraData.putStringArrayList("uinList", localArrayList);
    paramArrayOfString.extraData.putBoolean("batch_data", true);
    send(paramArrayOfString);
  }
  
  public <T> void P(int paramInt, List<T> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleMayKnowRecommendPush: " + paramList + ", opType: " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ThreadManager.getSubThreadHandler().post(new FriendListHandler.4(this));
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "decodePush0x210_0x111, do add mayknow list");
      }
      try
      {
        notifyUI(114, ((achg)this.app.getManager(159)).a(true, paramList), paramList);
        return;
      }
      catch (Throwable paramList)
      {
        QLog.e("FriendListHandler", 1, paramList, new Object[0]);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "decodePush0x210_0x111, do del mayknow list");
    }
    try
    {
      notifyUI(115, ((achg)this.app.getManager(159)).b(true, paramList), paramList);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.e("FriendListHandler", 1, paramList, new Object[0]);
    }
  }
  
  public boolean ZX()
  {
    return this.bHt;
  }
  
  public boolean ZY()
  {
    long l = System.currentTimeMillis() - this.PA;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getOnlineFriend  | intervalTime = " + l + " | sGetOnlineFriendDelay = " + QQAppInterface.cxs);
    }
    return (this.PA > 0L) && ((l < QQAppInterface.cxs) || (l > QQAppInterface.cxr - QQAppInterface.cxs));
  }
  
  public boolean ZZ()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.PC;
    if ((l2 < this.PB) && (l2 > -this.PB)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.PC = l1;
      }
      return bool;
    }
  }
  
  public aluh a()
  {
    return this.jdField_a_of_type_Aluh;
  }
  
  public QQHeadDownloadHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {}
    synchronized (this.cr)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler = new QQHeadDownloadHandler(this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler;
    }
  }
  
  public String a(int paramInt, long paramLong, String paramString)
  {
    if (paramInt == 11) {
      return paramString;
    }
    return Long.toString(paramLong);
  }
  
  public void a(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "AddFriendGroup :" + paramString);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 0);
    localToServiceMsg.extraData.putByte("sort_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    send(localToServiceMsg);
  }
  
  public void a(byte paramByte, ArrayList<BindUin> paramArrayList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.BindUin");
    localToServiceMsg.extraData.putByte("cCmd", paramByte);
    localToServiceMsg.addAttribute("vecBindUin", paramArrayList);
    send(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = false;
    int k = 1;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getConnectionsPerson, entryType=").append(paramInt1).append(" tabID=").append(paramInt2).append(" hasCookie=");
      if (paramArrayOfByte != null) {
        bool = true;
      }
      QLog.i("FriendListHandler", 2, bool + " isFirstPage=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        localObject = new oidb_0xc26.ReqBody();
        achg localachg = (achg)this.app.getManager(159);
        if ((localachg == null) || (!localachg.aaC())) {
          break label309;
        }
        ((oidb_0xc26.ReqBody)localObject).uint32_phone_book.set(1);
        if (!QLog.isColorLevel()) {
          break label309;
        }
        QLog.i("FriendListHandler", 2, "getMayKnowRecommend uint32_phone_book seted");
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, paramArrayOfByte.toString());
        return;
      }
      QLog.e("FriendListHandler", 1, "getConnectionsPerson, unknown entry type");
      k = -1;
      ((oidb_0xc26.ReqBody)localObject).em_entry.set(k);
      ((oidb_0xc26.ReqBody)localObject).uint32_tab_id.set(paramInt2);
      ((oidb_0xc26.ReqBody)localObject).uint32_want.set(50);
      if (paramArrayOfByte != null) {
        ((oidb_0xc26.ReqBody)localObject).bytes_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xc26_1", 3110, 0, ((oidb_0xc26.ReqBody)localObject).toByteArray());
      paramArrayOfByte.addAttribute("tabID", Integer.valueOf(paramInt2));
      paramArrayOfByte.addAttribute("isFirstPage", Boolean.valueOf(paramBoolean));
      paramArrayOfByte.addAttribute("extra_bd", paramBundle);
      sendPbReq(paramArrayOfByte);
      return;
      k = 2;
      continue;
      k = 3;
      continue;
      k = 4;
      continue;
      k = 5;
      continue;
      k = 6;
      continue;
      label309:
      switch (paramInt1)
      {
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getAllGeneralSettings.localRevision=" + paramInt1 + " offset=" + paramLong + " respRevision=" + paramInt2 + " isNeedGetTroopMsgFilter=" + paramBoolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localArrayList.add("message.group.policy.*");
    }
    localArrayList.add("message.group.policy_pc.*");
    localArrayList.add("sync.c2c_message");
    localArrayList.add("message.group.ring");
    localArrayList.add("message.group.vibrate");
    localArrayList.add("message.ring.switch");
    localArrayList.add("message.vibrate.switch");
    localArrayList.add("message.ring.care");
    localArrayList.add("message.push_detail");
    a(localArrayList, paramInt1, paramLong, paramInt2, 100, paramBoolean);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, String paramString, long paramLong3, long paramLong4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BumpSvc.ReqComfirmContactFriend");
    Object localObject = ((ajdo)this.app.getManager(11)).a();
    if (localObject != null)
    {
      String str = ((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo;
      if ((str != null) && (str.length() > 0))
      {
        localObject = str;
        if (str.startsWith("+")) {
          localObject = str.substring(1);
        }
      }
    }
    for (long l = Long.parseLong((String)localObject);; l = 0L)
    {
      localToServiceMsg.extraData.putInt("bType", paramInt);
      localToServiceMsg.extraData.putLong("lToMID", paramLong1);
      localToServiceMsg.extraData.putLong("lFromMobile", l);
      localToServiceMsg.extraData.putLong("lToMobile", paramLong2);
      localToServiceMsg.extraData.putByteArray("vSig", paramArrayOfByte);
      localToServiceMsg.extraData.putByte("bGroupId", paramByte);
      localToServiceMsg.extraData.putString("strNickName", paramString);
      localToServiceMsg.extraData.putLong("infotime", paramLong3);
      localToServiceMsg.extraData.putLong("dbid", paramLong4);
      send(localToServiceMsg);
      return;
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, long paramLong)
  {
    boolean bool;
    long l1;
    if (paramInt1 == 0)
    {
      bool = true;
      l1 = paramLong;
      if (paramLong == 0L) {
        l1 = System.currentTimeMillis();
      }
      if (paramInt3 != 1) {
        break label652;
      }
      if (this.m.containsKey(paramString1)) {
        this.m.remove(paramString1);
      }
      paramString2 = new b();
      paramString2.PD = l1;
      paramString2.aRY = paramInt2;
      this.m.put(paramString1, paramString2);
    }
    for (;;)
    {
      long l2;
      Object localObject;
      if (((!bool) || (paramInt3 == 4)) && (paramString2 != null))
      {
        l2 = paramString2.PE - paramString2.PD;
        l1 = 0L;
        paramLong = l1;
        if (paramString2.PF > paramString2.PE)
        {
          paramLong = l1;
          if (paramString2.PE > 0L) {
            paramLong = paramString2.PF - paramString2.PE;
          }
        }
        l1 = paramString2.PG - paramString2.PF;
        if ((QLog.isColorLevel()) || ((bool) && (paramInt3 == 4) && (paramString2.costTime > 3000L)))
        {
          localObject = new StringBuffer(200);
          ((StringBuffer)localObject).append("===QQHeadStat resultCode=").append(paramInt1);
          ((StringBuffer)localObject).append(", uin=").append(String.format("%11s", new Object[] { paramString1 }));
          ((StringBuffer)localObject).append(", totalTime=").append(String.format("%-5s", new Object[] { Long.valueOf(paramString2.costTime) }));
          ((StringBuffer)localObject).append(", picSize=").append(String.format("%-6s", new Object[] { Integer.valueOf(paramString2.size) }));
          ((StringBuffer)localObject).append(", downInfoTime=").append(l2);
          ((StringBuffer)localObject).append(", intervalTime=").append(paramLong);
          ((StringBuffer)localObject).append(", downPicTime=").append(l1);
          ((StringBuffer)localObject).append(", reasonCode=").append(paramInt5);
          ((StringBuffer)localObject).append(", downUrl=").append(paramString2.downUrl);
          if (!QLog.isColorLevel()) {
            break label822;
          }
        }
      }
      label652:
      label822:
      for (paramInt3 = 2;; paramInt3 = 1)
      {
        QLog.d("QQHeadCostTime", paramInt3, ((StringBuffer)localObject).toString());
        if (aqiw.isNetSupport(BaseApplication.getContext()))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("qqhead_uin", paramString1);
          ((HashMap)localObject).put("downInfo_time", String.valueOf(l2));
          ((HashMap)localObject).put("interval_time", String.valueOf(paramLong));
          ((HashMap)localObject).put("downPic_time", String.valueOf(l1));
          ((HashMap)localObject).put("downPic_size", String.valueOf(paramString2.size));
          ((HashMap)localObject).put("download_url", paramString2.downUrl);
          ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt1));
          ((HashMap)localObject).put("fail_reason", Integer.toString(paramInt5));
          ((HashMap)localObject).put("param_threadOpId", String.valueOf(acmq.a().AZ()));
          paramString1 = FaceDownloader.dA(paramInt2);
          if (!TextUtils.isEmpty(paramString1)) {
            anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), paramString1, bool, paramString2.costTime, paramString2.size, (HashMap)localObject, "");
          }
          paramString1 = FaceDownloader.dB(paramInt2);
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), paramString1, bool, paramString2.costTime, paramString2.size, (HashMap)localObject, "");
        }
        do
        {
          return;
          bool = false;
          break;
          if (!this.m.containsKey(paramString1)) {
            break label828;
          }
          localObject = (b)this.m.get(paramString1);
        } while (localObject == null);
        switch (paramInt3)
        {
        }
        for (;;)
        {
          paramString2 = (String)localObject;
          break;
          ((b)localObject).PE = l1;
          if (!bool) {
            this.m.remove(paramString1);
          }
          ((b)localObject).costTime = (((b)localObject).PE - ((b)localObject).PD);
          paramString2 = (String)localObject;
          break;
          ((b)localObject).PF = l1;
          paramString2 = (String)localObject;
          break;
          ((b)localObject).PG = l1;
          ((b)localObject).size = paramInt4;
          ((b)localObject).downUrl = paramString2;
          ((b)localObject).costTime = (((b)localObject).PG - ((b)localObject).PD);
          this.m.remove(paramString1);
        }
      }
      label828:
      paramString2 = null;
    }
  }
  
  public void a(int paramInt, ArrayList<FriendsStatusUtil.UpdateFriendStatusItem> paramArrayList, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 4, " create0x5d6SendPackage serType=" + paramInt);
    }
    if ((paramArrayList == null) || (paramArrayList.size() > 20))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("create0x5d6SendPackage serType=").append(paramInt).append(" length=");
        if (paramArrayList != null) {
          break label93;
        }
      }
      label93:
      for (paramInt = 0;; paramInt = paramArrayList.size())
      {
        QLog.d("FriendListHandler", 4, paramInt);
        return;
      }
    }
    Object localObject1 = new ArrayList(1);
    int k = 0;
    while (k < paramArrayList.size())
    {
      Object localObject3 = (FriendsStatusUtil.UpdateFriendStatusItem)paramArrayList.get(k);
      localObject2 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(Long.parseLong(((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).uin));
      ArrayList localArrayList = new ArrayList(1);
      oidb_0x5d6.SnsUpdateItem localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
      localSnsUpdateItem.uint32_update_sns_type.set(((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).cAQ);
      localObject3 = ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).S();
      if (localObject3 != null) {
        localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
      }
      localArrayList.add(localSnsUpdateItem);
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set(localArrayList);
      ((List)localObject1).add(localObject2);
      k += 1;
    }
    Object localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    paramString = createToServiceMsg(paramString);
    paramString.extraData.putParcelableArrayList("param_status_item_list", paramArrayList);
    paramString.extraData.putInt("param_type", paramInt);
    paramString.extraData.putBoolean("param_notify_plugin", paramBoolean);
    paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq(paramString);
  }
  
  public void a(int paramInt, ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.size() == 0)) {
      return;
    }
    Object localObject = new ConcurrentHashMap();
    ((Map)localObject).putAll(paramConcurrentHashMap);
    paramConcurrentHashMap = new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramConcurrentHashMap.add(new GeneralSettings.Setting((String)localEntry.getKey(), ((Integer)localEntry.getValue()).toString()));
    }
    localObject = createToServiceMsg("ProfileService.ReqSetSettings");
    ((ToServiceMsg)localObject).extraData.putSerializable("Settings", paramConcurrentHashMap);
    ((ToServiceMsg)localObject).extraData.putSerializable("localRevision", Integer.valueOf(paramInt));
    send((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Object paramObject)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("getSuspiciousMsgList ").append(paramInt).append(" ");
      if (paramArrayOfByte != null) {
        break label166;
      }
    }
    label166:
    for (Object localObject1 = " no cookie ";; localObject1 = " has cookie ")
    {
      QLog.i("FriendListHandler", 2, (String)localObject1 + paramObject);
      localObject1 = new oidb_cmd0xd69.ReqBody();
      ((oidb_cmd0xd69.ReqBody)localObject1).cmd_type.set(1);
      localObject2 = new oidb_cmd0xd69.GetListReqBody();
      ((oidb_cmd0xd69.GetListReqBody)localObject2).req_num.set(paramInt);
      if (paramArrayOfByte != null) {
        ((oidb_cmd0xd69.GetListReqBody)localObject2).bytes_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      ((oidb_cmd0xd69.ReqBody)localObject1).msg_get_list_body.set((MessageMicro)localObject2);
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject1).toByteArray());
      paramArrayOfByte.addAttribute("cmd", Integer.valueOf(1));
      paramArrayOfByte.addAttribute("exactData", paramObject);
      sendPbReq(paramArrayOfByte);
      return;
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setMessageNotificationSetting(). uin size=");
      if (paramArrayOfString != null) {
        break label88;
      }
      k = -1;
      localObject1 = ((StringBuilder)localObject1).append(k).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label95;
      }
    }
    label88:
    label95:
    for (int k = -1;; k = paramArrayOfBoolean.length)
    {
      QLog.d("tag_msg_notification", 2, k);
      if ((paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label102;
      }
      return;
      k = paramArrayOfString.length;
      break;
    }
    label102:
    Object localObject1 = new ArrayList();
    Object localObject2 = (acff)this.app.getManager(51);
    k = 0;
    boolean bool = false;
    while (k < paramArrayOfString.length)
    {
      String str = paramArrayOfString[k];
      Object localObject3 = ((acff)localObject2).a(str, false);
      if (localObject3 == null)
      {
        QLog.d("FriendListHandler", 1, new Object[] { "setMessageNotificationSetting: invoked. ", " extensionInfo: ", localObject3 });
        k += 1;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, new Object[] { "setMessageNotificationSetting: invoked. ", " type: ", Integer.valueOf(paramInt), " uin: ", str, " isSwitchOn: ", Boolean.valueOf(bool) });
        }
        Object localObject5 = aean.a((ExtensionInfo)localObject3);
        int i2 = paramArrayOfBoolean[k];
        Object localObject4 = new oidb_0x5d6.SnsUpdateItem();
        localObject3 = new ArrayList();
        byte[] arrayOfByte = new byte[2];
        if (paramInt == 1) {
          if (i2 != 0)
          {
            i1 = 0;
            label306:
            ((ExtensionInfo)localObject5).messageEnablePreviewNew = i1;
          }
        }
        do
        {
          localObject5 = aean.a((ExtensionInfo)localObject5);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).uint32_update_sns_type.set(13582);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject5));
          ((List)localObject3).add(localObject4);
          localObject4 = new oidb_0x5d6.SnsUpateBuffer();
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).uint64_uin.set(Long.parseLong(str));
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).rpt_msg_sns_update_item.set((List)localObject3);
          ((List)localObject1).add(localObject4);
          break;
          i1 = 1;
          break label306;
          if (paramInt == 3)
          {
            if (i2 != 0) {}
            for (i1 = 0;; i1 = 1)
            {
              ((ExtensionInfo)localObject5).messageEnableVibrateNew = i1;
              break;
            }
          }
        } while (paramInt != 2);
        if (i2 != 0) {}
        for (int i1 = 0;; i1 = 1)
        {
          ((ExtensionInfo)localObject5).messageEnableSoundNew = i1;
          break;
        }
      }
    }
    localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(21);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x5d6_21");
    ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.SvcReqKikOut");
    localToServiceMsg.extraData.putLong("appid", paramLong);
    localToServiceMsg.extraData.putByte("cKeyType", paramByte);
    localToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.app.getAccount()));
    localToServiceMsg.extraData.putByteArray("sKey", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.setIsSupportRetry(true);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2, int paramInt3, int paramInt4, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt5, int paramInt6, int paramInt7)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("SummaryCard.ReqCondSearch");
    localToServiceMsg.extraData.putLong("search_seq", paramLong1);
    localToServiceMsg.extraData.putInt("param_page", paramInt1);
    localToServiceMsg.extraData.putLong("param_session_id", paramLong2);
    localToServiceMsg.extraData.putString("param_keyword", paramString);
    localToServiceMsg.extraData.putInt("param_sex_index", paramInt2);
    localToServiceMsg.extraData.putInt("param_age_index1", paramInt3);
    localToServiceMsg.extraData.putInt("param_age_index2", paramInt4);
    localToServiceMsg.extraData.putStringArray("param_loc_code", paramArrayOfString1);
    localToServiceMsg.extraData.putStringArray("param_home_code", paramArrayOfString2);
    localToServiceMsg.extraData.putInt("param_job_index", paramInt5);
    localToServiceMsg.extraData.putInt("param_xingzuo_index", paramInt6);
    localToServiceMsg.extraData.putInt("param_search_from", paramInt7);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, String paramString, int paramInt2, ArrayList<abgt> paramArrayList)
  {
    device_lock_confirm_auth.ReqBody localReqBody = new device_lock_confirm_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.app.getAppid());
    localReqBody.uint32_subappid.set(paramInt1);
    localReqBody.uint32_seq.set(paramInt2);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    int k = paramArrayList.size();
    paramString = new ArrayList();
    paramInt2 = 0;
    if (paramInt2 < k)
    {
      device_lock_confirm_auth.DeviceInfo localDeviceInfo = new device_lock_confirm_auth.DeviceInfo();
      abgt localabgt = (abgt)paramArrayList.get(paramInt2);
      if (localabgt == null) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        localDeviceInfo.bytes_appname.set(ByteStringMicro.copyFrom(localabgt.appName.getBytes()));
        localDeviceInfo.bytes_device_name.set(ByteStringMicro.copyFrom(localabgt.strDeviceName.getBytes()));
        localDeviceInfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(localabgt.strDeviceTypeInfo.getBytes()));
        localDeviceInfo.bytes_guid.set(ByteStringMicro.copyFrom(localabgt.cH));
        localDeviceInfo.uint32_appid.set(localabgt.appId);
        localDeviceInfo.uint32_auth_status.set(localabgt.authState);
        localDeviceInfo.uint32_subappid.set(paramInt1);
        paramString.add(localDeviceInfo);
      }
    }
    if (paramString.size() > 0) {
      localReqBody.rpt_msg_devicelist.set(paramString);
    }
    paramString = createToServiceMsg("DevLockAuthSvc.ConfirmAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    sendPbReq(paramString);
  }
  
  public void a(CheckUpdateResp paramCheckUpdateResp)
  {
    Object localObject1 = null;
    Object localObject2;
    int k;
    label70:
    andh localandh;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("FriendListHandler, handleCheckUpdate, ");
      if (paramCheckUpdateResp != null)
      {
        k = paramCheckUpdateResp.result;
        QLog.d("ProfileService.CheckUpdateReq", 2, k);
      }
    }
    else
    {
      if ((paramCheckUpdateResp == null) || (paramCheckUpdateResp.result != 0)) {
        break label237;
      }
      Iterator localIterator = paramCheckUpdateResp.vecResPkg.iterator();
      paramCheckUpdateResp = null;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (RespItem)localIterator.next();
      } while (localObject2 == null);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "FriendListHandler::handleCheckUpdate item eServiceId = " + ((RespItem)localObject2).eServiceID + ",result=" + ((RespItem)localObject2).cResult);
      }
      localandh = this.app.a.a(((RespItem)localObject2).eServiceID);
      if (localandh == null) {
        break label211;
      }
      if (((RespItem)localObject2).eServiceID != 101) {
        break label202;
      }
      localObject1 = localandh;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
      break label70;
      k = -1;
      break;
      label202:
      localandh.a((RespItem)localObject2);
      label211:
      localObject2 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject1;
      localObject1 = localObject2;
    }
    if ((paramCheckUpdateResp != null) && (localObject1 != null)) {
      paramCheckUpdateResp.a((RespItem)localObject1);
    }
    label237:
    this.app.a.cNp();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, ArrayList<String> paramArrayList, FromServiceMsg paramFromServiceMsg, ArrayList<ProfSmpInfoRes> paramArrayList1)
  {
    acff localacff = (acff)this.app.getManager(51);
    EntityTransaction localEntityTransaction = localacff.a();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
        Iterator localIterator = paramArrayList1.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localProfSmpInfoRes = (ProfSmpInfoRes)localIterator.next();
        localObject2 = String.valueOf(localProfSmpInfoRes.dwUin);
        if (!paramArrayList.contains(localObject2)) {
          continue;
        }
        if (((String)localObject2).equals(this.app.getCurrentAccountUin())) {
          this.app.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + (String)localObject2, localProfSmpInfoRes.strNick);
        }
        if (localProfSmpInfoRes.cSpecialFlag < 0)
        {
          QLog.i("FriendListHandler", 1, "Info.cSpecialFlag is 0xFF");
          localProfSmpInfoRes.cSpecialFlag = 0;
        }
        if ((jqs.cU(localProfSmpInfoRes.cSpecialFlag)) || (asgx.mS(localProfSmpInfoRes.cSpecialFlag)))
        {
          localArrayList2.add(localObject2);
          if (jqs.cU(localProfSmpInfoRes.cSpecialFlag))
          {
            paramFromServiceMsg = (aceb)this.app.getBusinessHandler(21);
            if (paramFromServiceMsg != null) {
              paramFromServiceMsg.hq(SystemClock.uptimeMillis());
            }
          }
        }
        localacff.a(String.valueOf(localProfSmpInfoRes.dwUin), localProfSmpInfoRes.strNick, localProfSmpInfoRes.cSpecialFlag, (short)localProfSmpInfoRes.cSex, localProfSmpInfoRes.wAge);
        paramFromServiceMsg = localacff.c((String)localObject2);
        paramFromServiceMsg.nFaceID = localProfSmpInfoRes.wFace;
        paramFromServiceMsg.shGender = ((short)localProfSmpInfoRes.cSex);
        paramFromServiceMsg.age = localProfSmpInfoRes.wAge;
        paramFromServiceMsg.shAge = ((short)localProfSmpInfoRes.wAge);
        if (localProfSmpInfoRes.strNick != null) {
          paramFromServiceMsg.strNick = localProfSmpInfoRes.strNick;
        }
        if (localProfSmpInfoRes.sCountry != null) {
          paramFromServiceMsg.strCountry = localProfSmpInfoRes.sCountry;
        }
        if (localProfSmpInfoRes.sProvince != null) {
          paramFromServiceMsg.strProvince = localProfSmpInfoRes.sProvince;
        }
        if (localProfSmpInfoRes.sCity != null) {
          paramFromServiceMsg.strCity = localProfSmpInfoRes.sCity;
        }
        if ((localProfSmpInfoRes.cBusiCardFlag == 1) && (((String)localObject2).equals(this.app.getCurrentAccountUin())))
        {
          localObject1 = (adyp)this.app.getManager(112);
          if (localObject1 != null)
          {
            int k = ((adyp)localObject1).Cc();
            adyr.a(this.app, k, 0, true);
            ((adyp)localObject1).bu(1, true);
          }
        }
        if ((((String)localObject2).equals(this.app.getCurrentAccountUin())) && (localProfSmpInfoRes.wLevel != 0)) {
          paramFromServiceMsg.iQQLevel = localProfSmpInfoRes.wLevel;
        }
        if ((localProfSmpInfoRes.isShowXMan == -1) || (localProfSmpInfoRes.dwLoginDay < 0L) || (localProfSmpInfoRes.dwPhoneQQXManDay <= 0L)) {
          continue;
        }
        if (!((String)localObject2).equals(this.app.getCurrentAccountUin())) {
          continue;
        }
        paramFromServiceMsg.lLoginDays = localProfSmpInfoRes.dwLoginDay;
        paramFromServiceMsg.lQQMasterLogindays = localProfSmpInfoRes.dwPhoneQQXManDay;
        paramFromServiceMsg.iXManScene1DelayTime = localProfSmpInfoRes.iXManScene1DelayTime;
        paramFromServiceMsg.iXManScene2DelayTime = localProfSmpInfoRes.iXManScene2DelayTime;
        if (localProfSmpInfoRes.isShowXMan != 1) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramArrayList)
      {
        ProfSmpInfoRes localProfSmpInfoRes;
        Object localObject2;
        Object localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FriendListHandler", 2, "handleFriendInfo err", paramArrayList);
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.end();
        paramArrayList = localArrayList2.iterator();
        if (!paramArrayList.hasNext()) {
          break label1401;
        }
        paramFromServiceMsg = (String)paramArrayList.next();
        try
        {
          localObject1 = this.app.b().k(paramFromServiceMsg, 0);
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            continue;
          }
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((((MessageRecord)localObject2).msgtype != -1013) && (((MessageRecord)localObject2).msgtype != -1019) && (((MessageRecord)localObject2).msgtype != -1018) && (((MessageRecord)localObject2).msgtype != -2019) && (((MessageRecord)localObject2).msgtype != -7006)) {
            continue;
          }
          this.app.b().t(paramFromServiceMsg, 0, ((MessageRecord)localObject2).uniseq);
          continue;
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
        }
        boolean bool = false;
        continue;
        localEntityTransaction.commit();
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.end();
        continue;
      }
      finally
      {
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.end();
      }
      paramFromServiceMsg.setXManFlag(bool);
      if (paramArrayList.size() == 1)
      {
        if (!((String)localObject2).equals(this.app.getCurrentAccountUin())) {
          paramFromServiceMsg.allowPeopleSee = localProfSmpInfoRes.bOpenLoginDays;
        }
        paramFromServiceMsg.allowClick = localProfSmpInfoRes.bXManIconClick;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("Info.isShowXMan=");
        ((StringBuffer)localObject1).append(localProfSmpInfoRes.isShowXMan);
        ((StringBuffer)localObject1).append(";Info.dwLoginDay=");
        ((StringBuffer)localObject1).append(localProfSmpInfoRes.dwLoginDay);
        ((StringBuffer)localObject1).append(";Info.dwPhoneQQXManDay=");
        ((StringBuffer)localObject1).append(localProfSmpInfoRes.dwPhoneQQXManDay);
        ((StringBuffer)localObject1).append(";card.allowClick=");
        ((StringBuffer)localObject1).append(paramFromServiceMsg.allowClick);
        ((StringBuffer)localObject1).append(";card.allowPeopleSee= ");
        ((StringBuffer)localObject1).append(paramFromServiceMsg.allowPeopleSee);
        QLog.d("FriendListHandler", 2, ((StringBuffer)localObject1).toString());
      }
      localacff.a(paramFromServiceMsg);
      if (paramToServiceMsg.extraData.getBoolean("reqDateNick", false))
      {
        localObject1 = localProfSmpInfoRes.sDateNick;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramFromServiceMsg = localProfSmpInfoRes.strNick;
        }
        localObject1 = paramFromServiceMsg;
        if (TextUtils.isEmpty(paramFromServiceMsg)) {
          localObject1 = localObject2;
        }
        localArrayList1.add(new Object[] { localObject2, localObject1, Byte.valueOf(localProfSmpInfoRes.cSex) });
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo add to nickSaveList| uin=" + (String)localObject2 + " | datenick = " + localProfSmpInfoRes.sDateNick + " | nick=" + localProfSmpInfoRes.strNick);
        }
        notifyUI(89, true, new Object[] { localObject2, localObject1 });
      }
      if (paramToServiceMsg.extraData.getBoolean("reqSelfLevel", false))
      {
        aqgu.m(this.app.getApp().getApplicationContext(), this.app.getCurrentAccountUin(), System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | iQQLevel = " + localProfSmpInfoRes.wLevel);
        }
      }
      if (paramToServiceMsg.extraData.getBoolean("reqXMan", false))
      {
        paramFromServiceMsg = this.app.getApp().getApplicationContext();
        localObject1 = this.app.getCurrentAccountUin();
        aqgu.n(paramFromServiceMsg, (String)localObject1, System.currentTimeMillis());
        if (paramToServiceMsg.extraData.getInt("getXManInfoScene", 0) == 2) {
          aqgu.o(paramFromServiceMsg, (String)localObject1, System.currentTimeMillis());
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | dwLoginDay=" + localProfSmpInfoRes.dwLoginDay + " | dwPhoneQQXManDay=" + localProfSmpInfoRes.dwPhoneQQXManDay + " | isShowXMan=" + localProfSmpInfoRes.isShowXMan + " | iXManScene1DelayTime=" + localProfSmpInfoRes.iXManScene1DelayTime + " | iXManScene2DelayTime=" + localProfSmpInfoRes.iXManScene2DelayTime);
        }
      }
      notifyUI(3, true, localObject2);
    }
    label1401:
    paramArrayList = localArrayList1.iterator();
    while (paramArrayList.hasNext())
    {
      paramFromServiceMsg = (Object[])paramArrayList.next();
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleFriendInfo handle nickSaveList:" + paramFromServiceMsg[0] + ", " + paramFromServiceMsg[1] + ", " + paramFromServiceMsg[2]);
        }
        localacff.e((String)paramFromServiceMsg[0], (String)paramFromServiceMsg[1], ((Byte)paramFromServiceMsg[2]).byteValue());
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FriendListHandler", 2, "handleFriendInfo saveDateNickByUin err" + paramFromServiceMsg, paramFromServiceMsg);
        } else {
          QLog.i("FriendListHandler", 1, "handleFriendInfo saveDateNickByUin err" + paramFromServiceMsg);
        }
      }
    }
    if (paramToServiceMsg.extraData.getBoolean("batch_data")) {
      notifyUI(67, true, paramArrayList1);
    }
  }
  
  public void a(DelGroupResp paramDelGroupResp, boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    acff localacff = (acff)this.app.getManager(51);
    if (paramBoolean) {
      localacff.Jb(paramDelGroupResp.cGroupid);
    }
    notifyUI(21, paramBoolean, paramGroupActionResp);
  }
  
  public void a(String paramString, byte paramByte1, byte paramByte2)
  {
    a(1, paramString, 0, paramByte1, paramByte2, false);
  }
  
  public void a(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    a(32, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getUserAddFriendSetting " + paramString1 + ", " + paramInt1 + ", " + paramString2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.getUserAddFriendSetting");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    localToServiceMsg.extraData.putInt("random_key", paramInt3);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localToServiceMsg.extraData.putString("extra", paramString2);
    }
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5)
  {
    a(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt3, long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    localToServiceMsg.extraData.putInt("search_page", paramInt2);
    localToServiceMsg.extraData.putIntArray("search_list", paramArrayOfInt);
    localToServiceMsg.extraData.putInt("search_version", paramInt1);
    localToServiceMsg.extraData.putDouble("search_longtitude", paramDouble1);
    localToServiceMsg.extraData.putDouble("search_latitude", paramDouble2);
    localToServiceMsg.extraData.putBoolean("search_decode", paramBoolean);
    localToServiceMsg.extraData.putInt("filter_type", paramInt3);
    localToServiceMsg.extraData.putLong("session_id", paramLong);
    if (QLog.isDevelopLevel()) {
      QLog.d("FriendListHandler", 4, "search friend with filter:" + paramInt3);
    }
    send(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 2);
    if (paramBoolean) {
      localToServiceMsg.extraData.putInt("iDelMe", 1);
    }
    for (;;)
    {
      localToServiceMsg.extraData.putLong("iAppId", paramLong);
      send(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putInt("iDelMe", 0);
    }
  }
  
  public void a(String paramString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("uin=").append(paramString).append(", type size=");
      if (paramArrayOfInt != null) {
        break label141;
      }
      localObject1 = "";
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", switchState size=");
      if (paramArrayOfBoolean != null) {
        break label151;
      }
      localObject1 = "null";
      label63:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", ringId size=");
      if (paramArrayOfString != null) {
        break label161;
      }
    }
    label141:
    label151:
    label161:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramArrayOfString.length))
    {
      QLog.d("set_special_care_switches_of_a_person", 2, localObject1);
      if ((!aqmr.isEmpty(paramString)) && (paramArrayOfInt != null) && (paramArrayOfBoolean != null) && (paramArrayOfString != null) && (paramArrayOfInt.length == paramArrayOfBoolean.length) && (paramArrayOfBoolean.length == paramArrayOfString.length)) {
        break label172;
      }
      return;
      localObject1 = Integer.valueOf(paramArrayOfInt.length);
      break;
      localObject1 = Integer.valueOf(paramArrayOfBoolean.length);
      break label63;
    }
    label172:
    Object localObject2 = new ArrayList();
    localObject1 = new oidb_0x5d6.SnsUpateBuffer();
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).uint64_uin.set(Long.parseLong(paramString));
    int k = 0;
    if (k < paramArrayOfInt.length)
    {
      int i1 = paramArrayOfInt[k];
      int i2 = paramArrayOfBoolean[k];
      Object localObject3 = paramArrayOfString[k];
      oidb_0x5d6.SnsUpdateItem localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
      switch (i1)
      {
      }
      for (;;)
      {
        k += 1;
        break;
        if (i2 != 0)
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
        }
        else
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          if (i2 != 0)
          {
            if (aqmr.isEmpty((String)localObject3)) {
              throw new IllegalArgumentException("special ring id can not be empty!");
            }
            localObject3 = ((String)localObject3).getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          if (i2 != 0)
          {
            localObject3 = "1".getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
        }
      }
    }
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.set((List)localObject2);
    localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    localObject1 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject1).extraData.putString("param_uin", paramString);
    ((ToServiceMsg)localObject1).extraData.putIntArray("param_type", paramArrayOfInt);
    ((ToServiceMsg)localObject1).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject1).extraData.putStringArray("param_ring_ids", paramArrayOfString);
    ((ToServiceMsg)localObject1).extraData.putBoolean("param_is_set_switches_of_a_person", true);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(ArrayList<String> paramArrayList, int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "GeneralSettings getGeneralSettings start offset =" + paramLong1);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.ReqGetSettings");
    localToServiceMsg.extraData.putSerializable("Paths", paramArrayList);
    localToServiceMsg.extraData.putInt("Revision", paramInt1);
    localToServiceMsg.extraData.putLong("Offset", paramLong1);
    localToServiceMsg.extraData.putLong("Count", paramLong2);
    localToServiceMsg.extraData.putInt("respRevision", paramInt2);
    localToServiceMsg.extraData.putBoolean("needTroopSettings", paramBoolean);
    send(localToServiceMsg);
  }
  
  public void a(ArrayList<PhoneContact> paramArrayList, String paramString, int paramInt1, int paramInt2, ArrayList<AddBatchPhoneFriendResult> paramArrayList1)
  {
    if ((paramInt2 != 3078) && (paramInt2 != 3079))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "addBatchPhoneFriend, sourceId=" + paramInt2 + " is invalid.");
      }
      return;
    }
    Object localObject2 = new ArrayList(30);
    int i2 = paramInt1 * 30;
    int k = paramArrayList.size() - i2;
    int i1;
    if (k > 30)
    {
      i1 = i2 + 30;
      k = paramInt1 + 1;
    }
    while (i2 < i1)
    {
      ((List)localObject2).add(ByteStringMicro.copyFrom(((PhoneContact)paramArrayList.get(i2)).unifiedCode.getBytes()));
      i2 += 1;
      continue;
      if (k == 30)
      {
        i1 = i2 + 30;
        k = -1;
      }
      else
      {
        i1 = k + i2;
        k = -1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("addFriendTag", 2, String.format("addBatchPhoneFriend sourceId:%s, pkgIndex:%s, verifyMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString }));
    }
    Object localObject1 = new oidb_0x829.ReqBody();
    ((oidb_0x829.ReqBody)localObject1).uint32_source_id.set(paramInt2);
    ((oidb_0x829.ReqBody)localObject1).uint32_sub_source_id.set(1);
    ((oidb_0x829.ReqBody)localObject1).bytes_msg.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    ((oidb_0x829.ReqBody)localObject1).rpt_bytes_mobiles.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2089);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x829.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x829_1");
    ((ToServiceMsg)localObject1).extraData.putSerializable("phones", paramArrayList);
    ((ToServiceMsg)localObject1).extraData.putInt("package", k);
    ((ToServiceMsg)localObject1).extraData.putString("verifyMsg", paramString);
    ((ToServiceMsg)localObject1).extraData.putSerializable("resultList", paramArrayList1);
    ((ToServiceMsg)localObject1).extraData.putInt("sourceId", paramInt2);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(short paramShort, List<String> paramList, boolean paramBoolean)
  {
    a(paramShort, paramList, paramBoolean, false);
  }
  
  public void a(short paramShort, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramShort <= 0) || (paramList == null) || (paramShort != paramList.size())) {
      return;
    }
    for (;;)
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      try
      {
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1268);
        localOIDBSSOPkg.uint32_service_type.set(5);
        if (!paramBoolean1) {
          break label302;
        }
        s = paramShort * 12 + 2;
        localObject = ByteBuffer.allocate(s);
        ((ByteBuffer)localObject).putShort(paramShort);
        s = 0;
        if (s >= paramShort) {
          break label203;
        }
        ((ByteBuffer)localObject).putInt(aqft.ag(Long.parseLong((String)paramList.get(s))));
        if (paramBoolean1)
        {
          ((ByteBuffer)localObject).putShort((short)2);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)1).putShort((short)4057).put((byte)0);
        }
        else
        {
          ((ByteBuffer)localObject).putShort((short)1);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)0);
        }
      }
      catch (Exception paramList) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendListHandler", 2, "gatherContacts  Exception " + paramList.getMessage());
      return;
      label203:
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      Object localObject = createToServiceMsg("OidbSvc.0x4f4_5");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("isGather", paramBoolean1);
      ((ToServiceMsg)localObject).extraData.putStringArrayList("friendUinList", (ArrayList)paramList);
      ((ToServiceMsg)localObject).extraData.putBoolean("needNotifyPlugin", paramBoolean2);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
      s += 1;
      continue;
      label302:
      short s = paramShort * 9 + 2;
    }
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    a(paramArrayOfString, 0, 2, null, paramBoolean);
  }
  
  public void a(String[] paramArrayOfString, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
  {
    int i1 = -1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setHiddenChat(). uin size=");
      if (paramArrayOfString != null) {
        break label92;
      }
      k = -1;
      localObject1 = ((StringBuilder)localObject1).append(k).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label99;
      }
    }
    label92:
    label99:
    for (int k = i1;; k = paramArrayOfBoolean.length)
    {
      QLog.d("tag_hidden_chat", 2, k);
      if ((paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label106;
      }
      return;
      k = paramArrayOfString.length;
      break;
    }
    label106:
    Object localObject1 = new ArrayList();
    k = 0;
    if (k < paramArrayOfString.length)
    {
      localObject2 = paramArrayOfString[k];
      int i2 = paramArrayOfBoolean[k];
      Object localObject3 = new oidb_0x5d6.SnsUpdateItem();
      ArrayList localArrayList = new ArrayList();
      if (i2 != 0)
      {
        ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13581);
        byte[] arrayOfByte = "1".getBytes();
        ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
        localArrayList.add(localObject3);
      }
      for (;;)
      {
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        k += 1;
        break;
        ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13581);
        localArrayList.add(localObject3);
      }
    }
    Object localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(21);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x5d6_21");
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).extraData.putIntArray("param_chat_types", paramArrayOfInt);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public boolean a(int paramInt1, int paramInt2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: start: " + paramInt1 + ", count: " + paramInt2 + ", uinList: " + paramArrayList + ", isSort: " + paramBoolean1 + ", reqNick: " + paramBoolean2);
    }
    if (((paramArrayList == null) || (paramArrayList.size() <= 0)) && ((paramInt1 < 0) || (paramInt2 <= 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: input invalid.");
      }
      return false;
    }
    paramArrayList = new oidb_0x7df.ReqBody();
    paramArrayList.uint32_seq.set(0);
    paramArrayList.uint32_start_index.set(paramInt1);
    paramArrayList.uint32_req_num.set(paramInt2);
    Object localObject = paramArrayList.uint32_sort;
    if (paramBoolean1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = paramArrayList.uint32_nick;
      paramInt1 = k;
      if (paramBoolean2) {
        paramInt1 = 1;
      }
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2015);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(3);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayList.toByteArray()));
      paramArrayList = createToServiceMsg("OidbSvc.0x7df_3");
      paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      sendPbReq(paramArrayList);
      cvh = 3;
      return true;
    }
  }
  
  public boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriendToFriendList " + paramString1 + ", " + paramInt1 + ", " + paramInt2 + ", " + paramString2 + ", " + paramBoolean1);
    }
    paramString2 = (acff)this.app.getManager(51);
    Object localObject = (PhoneContactManagerImp)this.app.getManager(11);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).clH();
    }
    paramBoolean1 = paramString2.e(paramString1, paramInt1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler addFriendToFriendList flag = " + paramBoolean1);
    }
    if (paramBoolean1)
    {
      localObject = this.app.b().k(paramString1, 0);
      if ((localObject == null) || (((List)localObject).size() <= 0))
      {
        localObject = new SessionInfo();
        ((SessionInfo)localObject).aTl = paramString1;
        ((SessionInfo)localObject).cZ = 0;
        ujt.a(this.app, (SessionInfo)localObject, true);
      }
      if (this.Py == 0L) {
        notifyUI(1, true, Boolean.valueOf(true));
      }
      notifyUI(63, true, paramString1);
      localObject = (ajpj)this.app.getManager(106);
      if (localObject != null) {
        ((ajpj)localObject).go.put("" + paramString1, Integer.valueOf(1));
      }
      DF(paramString1);
      paramString2.bF(paramString1, false);
      ((alsb)this.app.getManager(91)).kN(Long.valueOf(paramString1).longValue());
      if ((asgx.ag(this.app, paramString1)) || ((!jqs.b(this.app, paramString1)) && (!jqs.c(this.app, paramString1)))) {
        this.app.a().dA(paramString1, paramInt2);
      }
      if (jqs.b(this.app, paramString1))
      {
        localObject = (aceb)this.app.getBusinessHandler(21);
        if (localObject != null) {
          ((aceb)localObject).hq(SystemClock.uptimeMillis());
        }
      }
    }
    paramString2 = paramString2.a();
    if (paramString2 != null) {
      paramString2.OX(paramString1);
    }
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    ujt.a(this.app, BaseApplication.getContext(), paramString2);
    return paramBoolean1;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, List<String> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Alui == null) {
      this.jdField_a_of_type_Alui = new alui();
    }
    paramBoolean = this.jdField_a_of_type_Alui.b(paramString1, paramString2, paramString3, paramList, paramBoolean, paramInt1, paramInt2);
    if (paramBoolean) {
      this.jdField_a_of_type_Alui.c(this);
    }
    return paramBoolean;
  }
  
  public boolean a(List<Long> paramList1, List<Long> paramList2, int paramInt, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getMayKnowRecommend, filterUins=");
      if (paramList1 == null) {
        break label227;
      }
      localObject = paramList1;
      QLog.i("FriendListHandler", 2, localObject + ", entryType=" + paramInt);
    }
    for (;;)
    {
      try
      {
        localObject = new oidb_0xc26.ReqBody();
        if (paramList1 != null) {
          ((oidb_0xc26.ReqBody)localObject).rpt_filter_uins.set(paramList1);
        }
        paramList1 = (achg)this.app.getManager(159);
        if ((paramList1 == null) || (!paramList1.aaC())) {
          break label285;
        }
        ((oidb_0xc26.ReqBody)localObject).uint32_phone_book.set(1);
        if (!QLog.isColorLevel()) {
          break label285;
        }
        QLog.i("FriendListHandler", 2, "getMayKnowRecommend uint32_phone_book seted");
      }
      catch (Exception paramList1)
      {
        label227:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, paramList1, new Object[0]);
        return true;
      }
      QLog.e("FriendListHandler", 1, "getMayKnowRecommend, unknown entry type");
      paramInt = k;
      ((oidb_0xc26.ReqBody)localObject).em_entry.set(paramInt);
      ((oidb_0xc26.ReqBody)localObject).uint32_fetch_rgroup.set(1);
      if (paramList2 != null) {
        ((oidb_0xc26.ReqBody)localObject).rpt_expected_uins.set(paramList2);
      }
      ((oidb_0xc26.ReqBody)localObject).uint32_tab_id.set(23);
      ((oidb_0xc26.ReqBody)localObject).uint32_want.set(50);
      paramList1 = makeOIDBPkg("OidbSvc.0xc26_0", 3110, 0, ((oidb_0xc26.ReqBody)localObject).toByteArray());
      paramList1.extraData.putBundle("EXTRA:OidbSvc.0xc26_0", paramBundle);
      sendPbReq(paramList1);
      return true;
      localObject = "";
      break;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
      continue;
      paramInt = 6;
      continue;
      label285:
      int k = -1;
      switch (paramInt)
      {
      }
    }
  }
  
  public void aW(boolean paramBoolean, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.CheckUpdateReq");
    localToServiceMsg.addAttribute("CheckUpdateType", Integer.valueOf(paramInt));
    localToServiceMsg.addAttribute("isFirstTime", Boolean.valueOf(paramBoolean));
    send(localToServiceMsg);
  }
  
  public boolean aaa()
  {
    if (this.cvf == -1) {}
    for (;;)
    {
      try
      {
        if (!aqgu.ak(this.app.getApp().getApplicationContext(), this.app.getAccount())) {
          continue;
        }
        k = 1;
        this.cvf = k;
      }
      catch (Exception localException)
      {
        int k;
        this.cvf = 0;
        continue;
      }
      if (this.cvf != 1) {
        break label62;
      }
      return true;
      k = 0;
    }
    label62:
    return false;
  }
  
  public boolean aab()
  {
    boolean bool1;
    if (this.app.getCurrentAccountUin() == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = aqgu.al(this.app.getApp().getApplicationContext(), this.app.getAccount());
      bool1 = bool2;
    } while (!bool2);
    p(0L, 0L, 0L);
    return bool2;
  }
  
  public void ac(String paramString, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetAutoInfoReq");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("cType", (byte)1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    send(localToServiceMsg);
  }
  
  public void ai(long paramLong, boolean paramBoolean)
  {
    f(paramLong, 4051, paramBoolean);
  }
  
  public void aw(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        SubMsgType0x11e.MsgBody localMsgBody = new SubMsgType0x11e.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_type.has()) {
          break label172;
        }
        l = localMsgBody.uint32_type.get();
        if (!localMsgBody.str_reason.has()) {
          break label179;
        }
        paramArrayOfByte = localMsgBody.str_reason.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "decodePush0x210_0x11e,type = " + l + " reason = " + paramArrayOfByte);
        }
        if (l == 1L)
        {
          EQ(true);
          return;
        }
        if (l != 2L) {
          break label171;
        }
        aW(true, 8);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        QLog.i("FriendListHandler", 1, "decodePush0x210_0x11e decode error, e=" + paramArrayOfByte.toString());
        return;
      }
      QLog.i("FriendListHandler", 1, "decodePush0x210_0x11e pbData = null");
      label171:
      return;
      label172:
      long l = -1L;
      continue;
      label179:
      paramArrayOfByte = null;
    }
  }
  
  public void b(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "RenameFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 1);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    send(localToServiceMsg);
  }
  
  public void b(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setSpecialCareSwitch(). type=").append(paramInt).append(", uin size=");
      if (paramArrayOfString != null) {
        break label108;
      }
      k = -1;
      localObject1 = ((StringBuilder)localObject1).append(k).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label115;
      }
    }
    label108:
    label115:
    for (int k = -1;; k = paramArrayOfBoolean.length)
    {
      QLog.d("set_special_care_switch", 2, k);
      if ((paramInt >= 1) && (paramInt <= 3) && (paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label122;
      }
      return;
      k = paramArrayOfString.length;
      break;
    }
    label122:
    Object localObject1 = new ArrayList();
    k = 0;
    if (k < paramArrayOfString.length)
    {
      localObject2 = paramArrayOfString[k];
      int i1 = paramArrayOfBoolean[k];
      Object localObject3 = new oidb_0x5d6.SnsUpdateItem();
      ArrayList localArrayList = new ArrayList();
      switch (paramInt)
      {
      }
      for (;;)
      {
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        k += 1;
        break;
        byte[] arrayOfByte;
        if (i1 != 0)
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
        }
        else
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          if (i1 != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          if (i1 != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
        }
      }
    }
    Object localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void b(String paramString, byte paramByte)
  {
    a(4, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void b(String paramString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)0);
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    send(localToServiceMsg);
  }
  
  public void b(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "getQCallHead QQHEAD_TYPE_QCALL uin = " + paramString + " idType = " + paramInt + ", level =  faceFileType = " + paramByte2);
    }
    a(16, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public void b(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt1, paramByte1, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, paramByte2, paramString6, paramBundle);
  }
  
  public void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 3);
    localToServiceMsg.extraData.putByteArray("group_id_list", paramArrayOfByte1);
    localToServiceMsg.extraData.putByteArray("sort_id_list", paramArrayOfByte2);
    send(localToServiceMsg);
  }
  
  public void bC(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchInfoListManager", 2, "uin = " + paramString);
    }
    if ((Friends.isValidUin(paramString)) && (jW(paramString)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GetSimpleInfo");
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putBoolean("reqSelfLevel", jX(paramString));
      localToServiceMsg.extraData.putBoolean("reqXMan", jY(paramString));
      localToServiceMsg.extraData.putBoolean("reqDateNick", paramBoolean);
      send(localToServiceMsg);
    }
  }
  
  public void bD(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, uinOrMobile= " + paramString + ",isRemove=" + paramBoolean + "downloadSize=" + this.j.size());
    }
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = this.cq;
    if (paramBoolean) {
      try
      {
        this.j.remove(paramString);
        return;
      }
      finally {}
    }
    ArrayList localArrayList;
    Object localObject2;
    if (this.j.size() > 30)
    {
      long l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.j.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l - ((Long)this.j.get(str)).longValue()) > 60000L) {
          localArrayList.add(str);
        }
      }
    }
    for (;;)
    {
      int k;
      if (k < localArrayList.size())
      {
        localObject2 = (String)localArrayList.get(k);
        this.j.remove(localObject2);
        c(9205, (String)localObject2, -1, 4);
        k += 1;
      }
      else
      {
        this.j.put(paramString, Long.valueOf(System.currentTimeMillis()));
        break;
        k = 0;
      }
    }
  }
  
  public void bE(String paramString, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetOnlineInfoReq");
    if (paramBoolean)
    {
      localToServiceMsg.extraData.putLong("dwReqType", 1L);
      localToServiceMsg.extraData.putString("strMobile", paramString);
    }
    for (;;)
    {
      localToServiceMsg.setTimeout(15000L);
      send(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putLong("dwReqType", 0L);
      localToServiceMsg.extraData.putLong("dwUin", jji.B(paramString));
    }
  }
  
  public String bj(long paramLong)
  {
    int k = 0;
    if (this.iN == null)
    {
      Object localObject1 = this.app.a(ServerConfigManager.ConfigType.app, "offlineTips");
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        this.iN = new HashMap();
        try
        {
          localObject1 = ((String)localObject1).split(";");
          int i1 = localObject1.length;
          while (k < i1)
          {
            Object localObject2 = localObject1[k].split(":");
            long l = Long.parseLong(localObject2[0]);
            localObject2 = localObject2[1];
            this.iN.put(Long.valueOf(l), localObject2);
            k += 1;
          }
          str = null;
        }
        catch (Exception localException) {}
      }
    }
    String str;
    if (this.iN != null) {
      str = (String)this.iN.get(Long.valueOf(paramLong));
    }
    return str;
  }
  
  /* Error */
  public void by(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 1219	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +43 -> 52
    //   12: ldc_w 1750
    //   15: iconst_2
    //   16: new 160	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 1752
    //   26: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_3
    //   30: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc_w 1362
    //   36: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 1342	com/tencent/mobileqq/app/FriendListHandler:Py	J
    //   43: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 1342	com/tencent/mobileqq/app/FriendListHandler:Py	J
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +23 -> 81
    //   61: aload_0
    //   62: getfield 1342	com/tencent/mobileqq/app/FriendListHandler:Py	J
    //   65: lstore 5
    //   67: lload_3
    //   68: lload 5
    //   70: lsub
    //   71: ldc2_w 5346
    //   74: lcmp
    //   75: ifge +6 -> 81
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: aload_0
    //   82: lload_3
    //   83: putfield 1342	com/tencent/mobileqq/app/FriendListHandler:Py	J
    //   86: new 106	java/util/ArrayList
    //   89: dup
    //   90: invokespecial 107	java/util/ArrayList:<init>	()V
    //   93: astore 7
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 399	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: invokevirtual 1577	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   103: iconst_0
    //   104: bipush 20
    //   106: iconst_0
    //   107: bipush 100
    //   109: lconst_0
    //   110: aload 7
    //   112: iload_1
    //   113: iload_2
    //   114: iconst_0
    //   115: invokespecial 2075	com/tencent/mobileqq/app/FriendListHandler:a	(Ljava/lang/String;IIIIJLjava/util/ArrayList;ZZS)V
    //   118: goto -40 -> 78
    //   121: astore 7
    //   123: aload_0
    //   124: monitorexit
    //   125: aload 7
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	FriendListHandler
    //   0	128	1	paramBoolean1	boolean
    //   0	128	2	paramBoolean2	boolean
    //   5	78	3	l1	long
    //   65	4	5	l2	long
    //   93	18	7	localArrayList	ArrayList
    //   121	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	121	finally
    //   52	67	121	finally
    //   81	118	121	finally
  }
  
  public void c(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramString, paramInt2, paramInt3, 0, null, 0, 0L);
  }
  
  public void c(String paramString, byte paramByte)
  {
    a(11, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void cIJ()
  {
    if (this.ef != null)
    {
      J(this.ef);
      this.ef = null;
    }
  }
  
  public void cIK()
  {
    String str = this.app.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (jY(str))) {
      DG(str);
    }
  }
  
  public void cIL()
  {
    Object localObject = this.app.getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (jZ((String)localObject)) && (Friends.isValidUin((String)localObject)) && (jW((String)localObject)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      localObject = createToServiceMsg("ProfileService.GetSimpleInfo");
      ((ToServiceMsg)localObject).extraData.putStringArrayList("uinList", localArrayList);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqSelfLevel", false);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqXMan", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqDateNick", false);
      ((ToServiceMsg)localObject).extraData.putInt("getXManInfoScene", 2);
      send((ToServiceMsg)localObject);
    }
  }
  
  public void cIM()
  {
    Message localMessage = this.g.obtainMessage();
    localMessage.what = 0;
    this.g.sendMessage(localMessage);
  }
  
  public void cIO()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.app.getCurrentAccountUin()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x490_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void cIP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reqHideConversationMayknowRecommend ");
    }
    try
    {
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      oidb_0xc34.ReqBody localReqBody = new oidb_0xc34.ReqBody();
      localReqBody.uint64_uin.set(l);
      sendPbReq(makeOIDBPkg("OidbSvc.0xc34_0", 3124, 0, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqHideConversationMayknowRecommend exception", localException);
    }
  }
  
  public void cIQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reqHideConversationTroopRecommend ");
    }
    try
    {
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      oidb_0xc34.ReqBody localReqBody = new oidb_0xc34.ReqBody();
      localReqBody.uint64_uin.set(l);
      sendPbReq(makeOIDBPkg("OidbSvc.0xc34_1", 3124, 1, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqHideConversationTroopRecommend exception", localException);
    }
  }
  
  public void cIR()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getSuspiciousFriendsUnreadNum");
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(2);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(2));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void cIS()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "deleteAllSuspiciousMsg ");
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(4);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(4));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void cIT()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "sendReadReportSuspicious ");
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(5);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(5));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public ArrayList<oidb_0x7df.FriendScore> cm()
  {
    synchronized (this.bU)
    {
      ArrayList localArrayList = this.sA;
      return localArrayList;
    }
  }
  
  public void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess()) {
      if (QLog.isColorLevel()) {
        QLog.d("TAG", 2, "onReceive: onReceive handleRecommendDeviceList");
      }
    }
    for (paramFromServiceMsg = new device_lock_recommend_auth.RspBody();; paramFromServiceMsg = null)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint64_uin.has()) {
          paramFromServiceMsg.uint64_uin.get();
        }
        if (paramFromServiceMsg.uint32_seq.has()) {
          paramFromServiceMsg.uint32_seq.get();
        }
        if (paramFromServiceMsg.uint32_ret.has()) {
          paramFromServiceMsg.uint32_ret.get();
        }
        if (!paramFromServiceMsg.rpt_msg_devicelist.has()) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_devicelist.get();
        paramObject = new ArrayList();
        if (paramFromServiceMsg == null) {}
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        try
        {
          int i1 = paramFromServiceMsg.size();
          int k = 0;
          label137:
          if (k < i1)
          {
            device_lock_recommend_auth.DeviceInfo localDeviceInfo = (device_lock_recommend_auth.DeviceInfo)paramFromServiceMsg.get(k);
            if (localDeviceInfo == null) {}
            for (;;)
            {
              k += 1;
              break label137;
              paramObject = paramObject;
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
              }
              paramObject.printStackTrace();
              break;
              abgt localabgt = new abgt();
              if (localDeviceInfo.bytes_appname.has())
              {
                localabgt.appName = new String(localDeviceInfo.bytes_appname.get().toByteArray(), "UTF-8");
                if (localDeviceInfo.bytes_guid.has())
                {
                  localabgt.cH = localDeviceInfo.bytes_guid.get().toByteArray();
                  if (localDeviceInfo.bytes_device_typeinfo.has())
                  {
                    localabgt.strDeviceTypeInfo = new String(localDeviceInfo.bytes_device_typeinfo.get().toByteArray(), "UTF-8");
                    new StringBuffer();
                    if (localDeviceInfo.bytes_device_name.has())
                    {
                      localabgt.strDeviceName = new String(localDeviceInfo.bytes_device_name.get().toByteArray(), "UTF-8");
                      if (localDeviceInfo.uint32_auth_status.has())
                      {
                        localabgt.authState = localDeviceInfo.uint32_auth_status.get();
                        if (localDeviceInfo.uint32_appid.has())
                        {
                          localabgt.appId = localDeviceInfo.uint32_appid.get();
                          if (localDeviceInfo.uint32_subappid.has())
                          {
                            localabgt.cow = localDeviceInfo.uint32_subappid.get();
                            paramObject.add(localabgt);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          if (paramObject.size() <= 0) {
            break label444;
          }
        }
        catch (Exception paramFromServiceMsg) {}
        notifyUI(69, true, paramObject);
        return;
      }
      label444:
      notifyUI(69, false, null);
      return;
    }
  }
  
  public void d(String paramString, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.delFriend");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("del_type", paramByte);
    send(localToServiceMsg);
  }
  
  public void d(String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 1);
    send(localToServiceMsg);
  }
  
  public void dE(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = paramToServiceMsg.extraData.getInt("param_type", -1);
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("param_status_item_list");
    boolean bool = paramToServiceMsg.extraData.getBoolean("param_notify_plugin", false);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 4, "handle0x5d6ResponsePackage serviceType=" + k);
    }
    if ((paramFromServiceMsg == null) || (paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 4, "handle0x5d6ResponsePackage req failed!");
      }
      FriendsStatusUtil.a(k, false, localArrayList, null, this.app, bool);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 4, "handle0x5d6ResponsePackage parse oidb_sso.OIDBSSOPkg failed.");
        }
        FriendsStatusUtil.a(k, false, localArrayList, null, this.app, bool);
        paramFromServiceMsg.printStackTrace();
      }
      int i1 = paramToServiceMsg.uint32_result.get();
      if (!QLog.isColorLevel()) {
        break label283;
      }
      QLog.d("FriendListHandler", 4, "ssoPkg.uint32_result=" + i1);
      label283:
      if (i1 != 0) {
        break label415;
      }
      paramFromServiceMsg = new oidb_0x5d6.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = paramFromServiceMsg.rpt_msg_update_result.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 4, "handle0x5d6ResponsePackage resultList null!");
          }
          FriendsStatusUtil.a(k, false, localArrayList, null, this.app, bool);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 4, "handle0x5d6ResponsePackage res failed!");
        }
        FriendsStatusUtil.a(k, false, localArrayList, null, this.app, bool);
        paramToServiceMsg.printStackTrace();
        return;
      }
      FriendsStatusUtil.a(k, true, localArrayList, paramToServiceMsg, this.app, bool);
      return;
      label415:
      if (!QLog.isColorLevel()) {
        break label430;
      }
      QLog.d("FriendListHandler", 4, "handle0x5d6ResponsePackage uint32_result failed!");
      label430:
      FriendsStatusUtil.a(k, false, localArrayList, null, this.app, bool);
    }
    if ((!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 4, "handle0x5d6ResponsePackage res failed!");
      }
      FriendsStatusUtil.a(k, false, localArrayList, null, this.app, bool);
      return;
    }
  }
  
  public void du(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c7.ReqBody();
    ((cmd0x7c7.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    if (paramInt == 1)
    {
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1991);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(0);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c7.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg("OidbSvc.0x7c7_0");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      if (paramInt != 1) {
        break label168;
      }
      ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
      if (paramInt == 2)
      {
        ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
        break;
      }
      if (paramInt != 3) {
        break;
      }
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
      break;
      label168:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      }
    }
  }
  
  public void dv(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.FriendListHandler", 2, String.format("reqLastChatTime frdUin=%s daysForward=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    try
    {
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      Object localObject = new cmd0xc85.ReqBody();
      ((cmd0xc85.ReqBody)localObject).uint64_from_uin.set(l);
      ((cmd0xc85.ReqBody)localObject).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((cmd0xc85.ReqBody)localObject).uint32_op.set(2);
      ((cmd0xc85.ReqBody)localObject).uint32_interval_days.set(paramInt);
      localObject = makeOIDBPkg("OidbSvc.0xc85", 3205, 0, ((cmd0xc85.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("selfUin", this.mApp.getCurrentAccountUin());
      ((ToServiceMsg)localObject).extraData.putString("frdUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqRecheckInHotReactive exception", paramString);
    }
  }
  
  public void e(String paramString, byte paramByte)
  {
    if ((paramByte != 0) && (ZY())) {}
    do
    {
      return;
      this.PA = System.currentTimeMillis();
      paramString = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetSimpleOnlineFriendInfoReq");
      paramString.extraData.putLong("startTime", System.currentTimeMillis());
      paramString.setTimeout(120000L);
      paramString.extraData.putByte("ifShowTermType", (byte)1);
      paramString.extraData.putByte("srcType", paramByte);
      send(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("getOnlineFriend", 2, "send getOnlineFriend");
  }
  
  public void e(ConcurrentHashMap<String, MayKnowExposure> paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.size() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure, needReportCnt=" + paramConcurrentHashMap.size());
    }
    for (;;)
    {
      ArrayList localArrayList;
      int k;
      try
      {
        long l = Long.parseLong(this.mApp.getCurrentAccountUin());
        localArrayList = new ArrayList();
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        k = 0;
        if ((paramConcurrentHashMap.hasNext()) && (k < 99)) {
          break label189;
        }
        paramConcurrentHashMap = new oidb_0xc35.ReqBody();
        paramConcurrentHashMap.uint64_uin.set(l);
        paramConcurrentHashMap.rpt_msg_expose_info.set(localArrayList);
        sendPbReq(makeOIDBPkg("OidbSvc.0xc35_0", 3125, 0, paramConcurrentHashMap.toByteArray()));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure, realReportCnt=" + k);
        return;
      }
      catch (Exception paramConcurrentHashMap) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure", paramConcurrentHashMap);
      return;
      label189:
      MayKnowExposure localMayKnowExposure = (MayKnowExposure)((Map.Entry)paramConcurrentHashMap.next()).getValue();
      oidb_0xc35.ExposeItem localExposeItem = new oidb_0xc35.ExposeItem();
      localExposeItem.uint64_friend.set(Long.parseLong(localMayKnowExposure.uin));
      localExposeItem.uint32_action_id.set(localMayKnowExposure.actionId);
      localExposeItem.uint32_entrance_Id.set(localMayKnowExposure.entranceId);
      localExposeItem.uint32_expose_count.set(localMayKnowExposure.exposeCnt);
      localExposeItem.uint32_expose_time.set(localMayKnowExposure.exposeTime);
      localExposeItem.uint32_page_id.set(localMayKnowExposure.pageId);
      if (localMayKnowExposure.acBuffer != null) {
        localExposeItem.bytes_algo_buffer.set(ByteStringMicro.copyFrom(localMayKnowExposure.acBuffer));
      }
      if (localMayKnowExposure.additive != null) {
        localExposeItem.bytes_addition.set(ByteStringMicro.copyFrom(localMayKnowExposure.additive));
      }
      localArrayList.add(localExposeItem);
      k += 1;
    }
  }
  
  public void eI(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "infoOpenId " + paramString1 + ", " + paramString2);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1505);
    localOIDBSSOPkg.uint32_service_type.set(8);
    oidb_0x5e1.ReqBody localReqBody = new oidb_0x5e1.ReqBody();
    localReqBody.rpt_bytes_openid.add(ByteStringMicro.copyFrom(paramString1.getBytes()));
    localReqBody.uint32_appid.set((int)Long.parseLong(paramString2));
    localReqBody.uint32_req_nick.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc.0x5e1_8");
    paramString2.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString2.extraData.putString("uin", paramString1);
    sendPbReq(paramString2);
  }
  
  public void ej(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    long l = ((Long)paramToServiceMsg.getAttribute("toUin", Long.valueOf(0L))).longValue();
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "handleAgreeSuspiciousMsg " + l);
    }
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_cmd0xd72.RspBody());
    if (k == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "handleAgreeSuspiciousMsg suc " + l);
      }
      ((ysf)this.mApp.getManager(34)).gq(l);
      notifyUI(129, true, new Object[] { Integer.valueOf(k), Long.valueOf(l) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "handleAgreeSuspiciousMsg failed result:" + k);
    }
    notifyUI(129, false, new Object[] { Integer.valueOf(k), Long.valueOf(l) });
  }
  
  public void ek(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    int k = ((Integer)paramToServiceMsg.getAttribute("cmd", Integer.valueOf(0))).intValue();
    Object localObject2 = new oidb_cmd0xd69.RspBody();
    int i1 = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
    int i2;
    if (i1 == 0)
    {
      i2 = ((oidb_cmd0xd69.RspBody)localObject2).cmd_type.get();
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "handleGetSuspiciousMsg cmd:" + i2 + " localCmd:" + k);
      }
      paramObject = (ysf)this.mApp.getManager(34);
      if (i2 == 2) {
        if (!((oidb_cmd0xd69.RspBody)localObject2).msg_get_unread_num_body.has()) {
          break label950;
        }
      }
    }
    label276:
    label409:
    label933:
    label938:
    label943:
    label950:
    for (k = ((oidb_cmd0xd69.GetUnreadNumRspBody)((oidb_cmd0xd69.RspBody)localObject2).msg_get_unread_num_body.get()).doubt_unread_num.get();; k = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "handleGetSuspiciousUnreadMsg suc " + k);
      }
      paramObject.EA(k);
      notifyUI(124, true, new Object[] { Integer.valueOf(i1), Integer.valueOf(k) });
      return;
      Object localObject1;
      boolean bool;
      if (i2 == 1)
      {
        localObject1 = paramToServiceMsg.getAttribute("exactData");
        if (!((oidb_cmd0xd69.RspBody)localObject2).msg_get_list_body.has()) {
          break label943;
        }
        if (!((oidb_cmd0xd69.RspBody)localObject2).msg_get_list_body.bytes_cookies.has()) {
          break label938;
        }
        paramFromServiceMsg = ((oidb_cmd0xd69.RspBody)localObject2).msg_get_list_body.bytes_cookies.get().toByteArray();
        paramToServiceMsg = (oidb_cmd0xd69.GetListRspBody)((oidb_cmd0xd69.RspBody)localObject2).msg_get_list_body.get();
        if (!paramToServiceMsg.rpt_msg_list.has()) {
          break label933;
        }
        localObject2 = paramToServiceMsg.rpt_msg_list.get();
        paramToServiceMsg = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramToServiceMsg.add(SysSuspiciousMsg.covertFrom((oidb_cmd0xd69.DoubtInfo)((Iterator)localObject2).next()));
        }
        if (paramFromServiceMsg == null)
        {
          bool = true;
          paramObject.x(paramToServiceMsg, bool);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("handleGetSuspiciousList suc  ");
          if (paramToServiceMsg == null) {
            break label485;
          }
          paramObject = Integer.valueOf(paramToServiceMsg.size());
          localObject2 = ((StringBuilder)localObject2).append(paramObject).append(" ");
          if (paramFromServiceMsg == null) {
            break label492;
          }
        }
        label485:
        label492:
        for (paramObject = " has cookie";; paramObject = " no cookie")
        {
          QLog.i("FriendListHandler", 2, paramObject);
          notifyUI(125, true, new Object[] { Integer.valueOf(i1), paramToServiceMsg, paramFromServiceMsg, localObject1 });
          return;
          bool = false;
          break;
          paramObject = " no list";
          break label409;
        }
        long l;
        if (i2 == 3)
        {
          l = ((Long)paramToServiceMsg.getAttribute("uin", Long.valueOf(0L))).longValue();
          if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler", 2, "handleGetSuspiciousDelete " + l);
          }
          paramObject.gq(l);
          notifyUI(126, true, new Object[] { Integer.valueOf(i1), Long.valueOf(l) });
          return;
        }
        if (i2 == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler", 2, "handleGetSuspiciousClear ");
          }
          paramObject.clz();
          notifyUI(127, true, new Object[] { Integer.valueOf(i1) });
          return;
        }
        if (i2 != 5) {
          break;
        }
        notifyUI(128, true, new Object[] { Integer.valueOf(i1) });
        return;
        k = ((oidb_cmd0xd69.RspBody)localObject2).cmd_type.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleGetSuspiciousMsg failed result:" + i1 + " cmd:" + k);
        }
        if (k == 2)
        {
          notifyUI(124, false, new Object[] { Integer.valueOf(i1), Integer.valueOf(0) });
          return;
        }
        if (k == 1)
        {
          notifyUI(125, false, new Object[] { Integer.valueOf(i1), null, null, paramToServiceMsg.getAttribute("exactData") });
          return;
        }
        if (k == 3)
        {
          l = ((Long)paramToServiceMsg.getAttribute("uin", Long.valueOf(0L))).longValue();
          if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler", 2, "handleGetSuspiciousDel failed:" + l);
          }
          notifyUI(126, false, new Object[] { Integer.valueOf(i1), Long.valueOf(l) });
          return;
        }
        if (k == 4)
        {
          notifyUI(127, false, new Object[] { Integer.valueOf(i1) });
          return;
        }
        if (k != 5) {
          break;
        }
        notifyUI(128, false, new Object[] { Integer.valueOf(i1) });
        return;
        paramToServiceMsg = null;
        continue;
        paramFromServiceMsg = null;
        break label276;
        paramToServiceMsg = null;
        paramFromServiceMsg = null;
      }
    }
  }
  
  public void f(byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "DeleteFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 2);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    send(localToServiceMsg);
  }
  
  public void f(long paramLong, int paramInt, boolean paramBoolean)
  {
    int k;
    Object localObject1;
    long l;
    Object localObject2;
    if (paramBoolean)
    {
      k = 1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " setId:" + paramInt + " isSet:" + paramBoolean);
      }
      localObject1 = new Oidb_0x5d1.ReqBody();
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_cmd.set(k);
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_id.set(paramInt);
      l = this.app.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacts.", 2, "FriendListHandler.send_oidb_0x5d1_0 " + l);
      }
      if (!paramBoolean) {
        break label317;
      }
      localObject2 = new Oidb_0x5d1.SetFriendIdReq();
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint64_seq.set(l);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_set_friend_id.set((MessageMicro)localObject2);
    }
    for (;;)
    {
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1489);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d1.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x5d1_0");
      ((ToServiceMsg)localObject1).extraData.putLong("friendUin", paramLong);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isSet", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putInt("setId", paramInt);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
      return;
      k = 2;
      break;
      label317:
      localObject2 = new Oidb_0x5d1.ClearFriendIdReq();
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint64_seq.set(l);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_clear_friend_id.set((MessageMicro)localObject2);
    }
  }
  
  public void f(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 1L);
    send(localToServiceMsg);
  }
  
  public void g(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 2L);
    send(localToServiceMsg);
  }
  
  public void g(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (!paramBoolean1)
    {
      localObject = createToServiceMsg("ProfileService.ChangeFriendName");
      ((ToServiceMsg)localObject).extraData.putString("com_value", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      ((ToServiceMsg)localObject).extraData.putBoolean("notify_plugin", paramBoolean2);
      send((ToServiceMsg)localObject);
    }
    do
    {
      return;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      paramString2 = (acff)this.app.getManager(51);
      Card localCard = paramString2.c(paramString1);
      localCard.strReMark = ((String)localObject);
      paramString2.a(localCard);
      paramString2.b(paramString1, (String)localObject);
      ((acdu)this.app.getManager(53)).eH(paramString1, (String)localObject);
      paramString1 = (ajdo)this.app.getManager(11);
    } while (paramString1 == null);
    paramString1.clK();
  }
  
  public void h(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 4L);
    send(localToServiceMsg);
  }
  
  public void hs(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "deleteSuspiciousMsg " + paramLong);
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(3);
    oidb_cmd0xd69.DeleteReqBody localDeleteReqBody = new oidb_cmd0xd69.DeleteReqBody();
    localDeleteReqBody.doubt_uin.set(paramLong);
    ((oidb_cmd0xd69.ReqBody)localObject).msg_delete_body.set(localDeleteReqBody);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(3));
    ((ToServiceMsg)localObject).addAttribute("uin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void ht(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "agreeSuspiciousMsg " + paramLong);
    }
    Object localObject = new oidb_cmd0xd72.ReqBody();
    ((oidb_cmd0xd72.ReqBody)localObject).doubt_uin.set(paramLong);
    ((oidb_cmd0xd72.ReqBody)localObject).uin.set(this.app.getLongAccountUin());
    localObject = makeOIDBPkg("OidbSvc.0xd72", 3442, 0, ((oidb_cmd0xd72.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("toUin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public String i(long paramLong, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return String.valueOf(paramLong);
  }
  
  public void iM(List<QIMNotifyAddFriend> paramList)
  {
    Object localObject = new cmd0xaed.ReqBody();
    ((cmd0xaed.ReqBody)localObject).uint64_qq_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    StringBuilder localStringBuilder = new StringBuilder("addBatchQIMFriends ");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QIMNotifyAddFriend localQIMNotifyAddFriend = (QIMNotifyAddFriend)paramList.next();
      ((cmd0xaed.ReqBody)localObject).rpt_uint64_add_qim_uins.add(Long.valueOf(localQIMNotifyAddFriend.uin));
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(localQIMNotifyAddFriend.uin);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.QIM", 2, localStringBuilder.toString());
    }
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2797);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xaed.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xaed_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected void init()
  {
    this.g = new acfb(this, this.app.getApp().getMainLooper());
    ThreadManager.excute(new FriendListHandler.2(this), 16, null, false);
  }
  
  public void j(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    a(paramString1, paramInt1, paramInt2, paramString2, 0);
  }
  
  public boolean jW(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2;
    synchronized (this.n)
    {
      if (!this.n.containsKey(paramString)) {
        break label181;
      }
      paramString = (a)this.n.get(paramString);
      l2 = Math.abs(l1 - paramString.startTime);
      if (paramString.expiredTime > 0L)
      {
        if (l1 < paramString.expiredTime) {
          return false;
        }
        paramString.expiredTime = 0L;
        paramString.startTime = l1;
        paramString.count = 1L;
        return true;
      }
    }
    if (l2 < 5000L) {
      return false;
    }
    paramString.count += 1L;
    if ((paramString.count >= 8L) && (l2 < 120000L)) {
      paramString.expiredTime = (l1 + 1800000L);
    }
    for (;;)
    {
      return true;
      if (l2 > 60000L)
      {
        paramString.expiredTime = 0L;
        paramString.startTime = l1;
        paramString.count = 1L;
      }
    }
    label181:
    Object localObject1;
    Object localObject2;
    if (this.n.size() > 20)
    {
      localObject1 = new ArrayList();
      localObject2 = this.n.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        a locala = (a)this.n.get(str);
        if (((locala.expiredTime == 0L) && (l1 - locala.startTime > 60000L)) || ((locala.expiredTime > 0L) && (l1 > locala.expiredTime))) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    for (;;)
    {
      int k;
      if (k < ((ArrayList)localObject1).size())
      {
        localObject2 = (String)((ArrayList)localObject1).get(k);
        this.n.remove(localObject2);
        k += 1;
      }
      else
      {
        localObject1 = new a();
        ((a)localObject1).startTime = l1;
        ((a)localObject1).count = 1L;
        this.n.put(paramString, localObject1);
        break;
        k = 0;
      }
    }
  }
  
  public boolean jX(String paramString)
  {
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l;
    if (bool1)
    {
      l = aqgu.g(this.app.getApp().getApplicationContext(), this.app.getCurrentAccountUin());
      if (Math.abs(System.currentTimeMillis() - l) <= 86400000L) {
        break label109;
      }
    }
    label109:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, "$shouldReqLevel | lastReqTime = " + l + " | currentTime = " + System.currentTimeMillis());
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public void k(long paramLong, String paramString, int paramInt)
  {
    device_lock_recommend_auth.ReqBody localReqBody = new device_lock_recommend_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.app.getAppid());
    localReqBody.uint32_subappid.set(paramInt);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.uint32_seq.set(1);
    paramString = createToServiceMsg("DevLockAuthSvc.RecommendAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    sendPbReq(paramString);
  }
  
  public boolean ka(String paramString)
  {
    for (;;)
    {
      int k;
      boolean bool1;
      boolean bool3;
      synchronized (this.cq)
      {
        if (!this.j.containsKey(paramString)) {
          break label275;
        }
        long l = ((Long)this.j.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.j.remove(paramString);
          c(9205, paramString, -1, 4);
          k = 0;
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool3 = aqfo.isExistSDCard();
            if (((bool3) && (aqfo.getSDCardAvailableSize() < 2048L)) || ((!bool3) && (aqfo.getSystemAvailableSize() < 102400L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.flh", 2, "getQQHead|fail, storage is not enough. uinOrMobile=" + paramString + ", isExistSDCard=" + bool3);
              }
              bool2 = false;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, whatIf= " + k + ", NeedDownload=" + bool2);
            }
            return bool2;
          }
        }
        else
        {
          k = 1;
          bool1 = false;
        }
      }
      boolean bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!this.bHs)
        {
          this.bHs = true;
          aqgu.H(this.app.getApp().getApplicationContext(), true);
          bool2 = bool1;
          continue;
          label275:
          k = -1;
          bool1 = true;
        }
      }
    }
  }
  
  public void l(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "send_oidb_0x476 " + paramLong + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1142);
    localOIDBSSOPkg.uint32_service_type.set(paramInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.putShort((short)1);
    localByteBuffer.putInt((int)paramLong);
    localOIDBSSOPkg.bytes_bodybuffer.setHasFlag(true);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.extraData.putLong("uin", paramLong);
    sendPbReq(paramString);
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("friendlist.getFriendGroupList");
      this.allowCmdSet.add("friendlist.GetLastLoginInfoReq");
      this.allowCmdSet.add("ProfileService.GetRichSig");
      this.allowCmdSet.add("ProfileService.GetSimpleInfo");
      this.allowCmdSet.add("AvatarInfoSvr.QQHeadUrlReq");
      this.allowCmdSet.add("IncreaseURLSvr.QQHeadUrlReq");
      this.allowCmdSet.add("OidbSvc.0xc34_0");
      this.allowCmdSet.add("OidbSvc.0xc34_1");
      this.allowCmdSet.add("OidbSvc.0xc83");
      this.allowCmdSet.add("OidbSvc.0xc85");
      this.allowCmdSet.add("StatSvc.GetDevLoginInfo");
      this.allowCmdSet.add("StatSvc.DelDevLoginInfo");
      this.allowCmdSet.add("StatSvc.SvcReqKikOut");
      this.allowCmdSet.add("StatSvc.BindUin");
      this.allowCmdSet.add("ProfileService.ReqGetSettings");
      this.allowCmdSet.add("ProfileService.ReqSetSettings");
      this.allowCmdSet.add("friendlist.MovGroupMemReq");
      this.allowCmdSet.add("BumpSvc.ReqComfirmContactFriend");
      this.allowCmdSet.add("friendlist.addFriend");
      this.allowCmdSet.add("friendlist.getUserAddFriendSetting");
      this.allowCmdSet.add("friendlist.GetSimpleOnlineFriendInfoReq");
      this.allowCmdSet.add("friendlist.GetOnlineInfoReq");
      this.allowCmdSet.add("friendlist.delFriend");
      this.allowCmdSet.add("friendlist.SetGroupReq");
      this.allowCmdSet.add("ProfileService.ChangeFriendName");
      this.allowCmdSet.add("ProfileService.SetRichSig");
      this.allowCmdSet.add("StatSvc.register");
      this.allowCmdSet.add("friendlist.GetAutoInfoReq");
      this.allowCmdSet.add("ProfileService.CheckUpdateReq");
      this.allowCmdSet.add("SummaryCard.ReqSearch");
      this.allowCmdSet.add("SummaryCard.ReqCondSearch");
      this.allowCmdSet.add("OidbSvc.0x5d1_0");
      this.allowCmdSet.add("OidbSvc.0x4fc_30");
      this.allowCmdSet.add("DevLockAuthSvc.RecommendAuth");
      this.allowCmdSet.add("DevLockAuthSvc.ConfirmAuth");
      this.allowCmdSet.add("OidbSvc.0x476_146");
      this.allowCmdSet.add("OidbSvc.0x476_147");
      this.allowCmdSet.add("OidbSvc.0x490_107");
      this.allowCmdSet.add("OidbSvc.0x491_107");
      this.allowCmdSet.add("OidbSvc.0x5e1_8");
      this.allowCmdSet.add("OidbSvc.0x49d_107");
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
      this.allowCmdSet.add("OidbSvc.0x7c4_0");
      this.allowCmdSet.add("OidbSvc.0x4f4_5");
      this.allowCmdSet.add("OidbSvc.0x7c6_0");
      this.allowCmdSet.add("OidbSvc.0x7c7_0");
      this.allowCmdSet.add("OidbSvc.0x847_3");
      this.allowCmdSet.add("OidbSvc.0x53b_0");
      this.allowCmdSet.add("OidbSvc.0x6c9_0");
      this.allowCmdSet.add("OidbSvc.0x7df_3");
      this.allowCmdSet.add("OidbSvc.0x5d6_7");
      this.allowCmdSet.add("OidbSvc.0x5d6_19");
      this.allowCmdSet.add("OidbSvc.0x5d6_18");
      this.allowCmdSet.add("OidbSvc.0x77c");
      this.allowCmdSet.add("OidbSvc.0x5d6_21");
      this.allowCmdSet.add("OidbSvc.0x829_1");
      this.allowCmdSet.add("OidbSvc.0x777");
      this.allowCmdSet.add("OidbSvc.0xc26_0");
      this.allowCmdSet.add("OidbSvc.0xc36_0");
      this.allowCmdSet.add("OidbSvc.0xc35_0");
      this.allowCmdSet.add("OidbSvc.0xcf0_0");
      this.allowCmdSet.add("OidbSvc.0xd69");
      this.allowCmdSet.add("OidbSvc.0xd72");
      this.allowCmdSet.add("OidbSvc.0x5d6_21");
      this.allowCmdSet.add("OidbSvc.0xc26_1");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends acci> observerClass()
  {
    return acfd.class;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.close();
    }
    cII();
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label224:
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              do
              {
                do
                {
                  short s;
                  do
                  {
                    do
                    {
                      return;
                      if (!paramFromServiceMsg.getServiceCmd().equals("friendlist.getFriendGroupList")) {
                        break label523;
                      }
                      if (!paramFromServiceMsg.isSuccess()) {
                        break label224;
                      }
                      paramObject = (GetFriendListResp)paramObject;
                      if (paramObject == null) {
                        break;
                      }
                      if (paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
                      {
                        a(paramToServiceMsg, paramObject);
                        return;
                      }
                      if (paramToServiceMsg.extraData.getByte("ifShowTermType", (byte)0).byteValue() == 1)
                      {
                        a(paramFromServiceMsg.getUin(), paramObject, paramToServiceMsg);
                        return;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d("FriendListHandler", 1, "handleGetFriendList unknow request!");
                    return;
                    if (!paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
                    {
                      s = paramToServiceMsg.extraData.getShort("friendStartIndex");
                      k = paramToServiceMsg.extraData.getShort("friendTotalCount");
                      QLog.e("FriendListHandler", 1, "friend list unserialize error");
                      a(false, k, s, paramFromServiceMsg.getResultCode());
                      this.Py = 0L;
                    }
                    notifyUI(1, false, null);
                    notifyUI(99, false, null);
                    return;
                    if ((paramFromServiceMsg.getResultCode() != 2901) || (paramToServiceMsg == null) || (paramToServiceMsg.extraData == null)) {
                      break label416;
                    }
                    k = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
                    if (QLog.isColorLevel()) {
                      QLog.d("FriendListHandler", 2, "k_resend_cnt" + k);
                    }
                    if (k >= 2) {
                      break;
                    }
                    paramToServiceMsg.extraData.putInt("k_resend_cnt", k + 1);
                    send(paramToServiceMsg);
                  } while (paramToServiceMsg.extraData.getBoolean("getSingleFriend"));
                  this.cvb += 1;
                  return;
                  if (!paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
                  {
                    QLog.e("FriendListHandler", 1, "getFriendList timeout");
                    s = paramToServiceMsg.extraData.getShort("friendStartIndex");
                    a(false, paramToServiceMsg.extraData.getShort("friendTotalCount"), s, paramFromServiceMsg.getResultCode());
                    this.Py = 0L;
                  }
                  notifyUI(1, false, null);
                  notifyUI(99, false, null);
                  return;
                  if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && (!paramToServiceMsg.extraData.getBoolean("getSingleFriend")))
                  {
                    QLog.e("FriendListHandler", 1, "getFriendList fail " + paramFromServiceMsg.getResultCode());
                    s = paramToServiceMsg.extraData.getShort("friendStartIndex");
                    a(false, paramToServiceMsg.extraData.getShort("friendTotalCount"), s, paramFromServiceMsg.getResultCode());
                    this.Py = 0L;
                  }
                  notifyUI(1, false, null);
                  notifyUI(99, false, null);
                  return;
                  if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.RecommendAuth"))
                  {
                    d(paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.ConfirmAuth"))
                  {
                    ER(paramFromServiceMsg.isSuccess());
                    return;
                  }
                  if (paramFromServiceMsg.getServiceCmd().equals("friendlist.GetLastLoginInfoReq"))
                  {
                    a(paramFromServiceMsg, (GetLastLoginInfoResp)paramObject);
                    return;
                  }
                  if (!paramFromServiceMsg.getServiceCmd().equals("ProfileService.GetRichSig")) {
                    break;
                  }
                } while (!paramFromServiceMsg.isSuccess());
                k = paramToServiceMsg.extraData.getInt("reqType", 0);
                if ((k == 0) || (k == 3))
                {
                  c(paramToServiceMsg, paramObject);
                  return;
                }
                b(paramToServiceMsg, paramObject);
                return;
                if (!"ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd())) {
                  break;
                }
                localObject = paramToServiceMsg.extraData.getStringArrayList("uinList");
              } while (!paramFromServiceMsg.isSuccess());
              paramObject = (ArrayList)paramObject;
            } while ((paramObject == null) || (localObject == null));
            a(paramToServiceMsg, (ArrayList)localObject, paramFromServiceMsg, paramObject);
            return;
            if ("OidbSvc.0x4fc_30".equals(paramFromServiceMsg.getServiceCmd()))
            {
              dG(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("AvatarInfoSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (QQHeadUrlResp)paramObject);
              return;
            }
            if ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              dJ(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramToServiceMsg.extraData.getInt("qqHeadType") == 16)
              {
                dH(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              dI(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("StatSvc.GetDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 1L)
              {
                b(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 2L)
              {
                c(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 4L)
              {
                d(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              a(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
              return;
            }
            if ("StatSvc.DelDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramToServiceMsg.extraData.getInt("iDelType") == 1)
              {
                b(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getInt("iDelType") == 2)
              {
                a(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
                return;
              }
              c(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
              return;
            }
            if ("StatSvc.SvcReqKikOut".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (SvcRespKikOut)paramObject);
              return;
            }
            if ("StatSvc.BindUin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (SvcRspBindUin)paramObject);
              return;
            }
            if ("ProfileService.ReqGetSettings".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (RespGetSettings)paramObject);
              return;
            }
            if ("ProfileService.ReqSetSettings".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (RespSetSettings)paramObject);
              return;
            }
            if (!"friendlist.MovGroupMemReq".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
            k = paramToServiceMsg.extraData.getByte("move_fri_type");
            if (k == 0)
            {
              if (paramObject != null)
              {
                a(paramToServiceMsg, (MovGroupMemResp)paramObject);
                return;
              }
              notifyUI(9, false, null);
              return;
            }
          } while ((k != 1) || (paramObject == null));
          paramToServiceMsg = (MovGroupMemResp)paramObject;
          return;
          if ("BumpSvc.ReqComfirmContactFriend".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramFromServiceMsg.isSuccess())
            {
              b(paramToServiceMsg, true);
              return;
            }
            notifyUI(10, false, null);
            return;
          }
          if ("friendlist.addFriend".equals(paramFromServiceMsg.getServiceCmd()))
          {
            a((AddFriendResp)paramObject, paramToServiceMsg);
            return;
          }
          if ("friendlist.getUserAddFriendSetting".equals(paramFromServiceMsg.getServiceCmd()))
          {
            a(paramToServiceMsg, (GetUserAddFriendSettingResp)paramObject);
            return;
          }
          if ("friendlist.GetSimpleOnlineFriendInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramObject != null)
            {
              e(paramFromServiceMsg, paramObject);
              return;
            }
            notifyUI(13, false, null);
            return;
          }
          if ("friendlist.GetOnlineInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
          {
            dM(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("friendlist.delFriend".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramObject != null)
            {
              a(paramFromServiceMsg, (DelFriendResp)paramObject);
              return;
            }
            notifyUI(15, false, null);
            return;
          }
          if ("friendlist.SetGroupReq".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("onSetGroupCmd :").append(paramToServiceMsg.extraData.getInt("set_type", -1000)).append(", ").append(paramFromServiceMsg.isSuccess()).append(", ");
              if (paramObject == null) {
                break label1441;
              }
            }
            for (;;)
            {
              QLog.d("FriendListHandler", 2, bool);
              if (!paramFromServiceMsg.isSuccess()) {
                break label1447;
              }
              paramFromServiceMsg = (SetGroupResp)paramObject;
              if (paramFromServiceMsg == null) {
                break;
              }
              a(paramToServiceMsg, paramFromServiceMsg);
              return;
              bool = false;
            }
            switch (paramToServiceMsg.extraData.getInt("set_type", -1))
            {
            default: 
              return;
            case 0: 
              notifyUI(18, false, null);
              return;
            case 1: 
              notifyUI(19, false, null);
              return;
            case 2: 
              notifyUI(21, false, null);
              return;
            }
            notifyUI(22, false, null);
            return;
          }
          if ("ProfileService.ChangeFriendName".equals(paramFromServiceMsg.getServiceCmd()))
          {
            dN(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("ProfileService.SetRichSig".equals(paramFromServiceMsg.getServiceCmd()))
          {
            dO(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetAutoInfoReq"))
          {
            dz(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (!"ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd())) {
            break;
          }
          if ((paramFromServiceMsg.getResultCode() == 1000) && (QLog.isColorLevel())) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate ok resultcode = " + paramFromServiceMsg.getResultCode());
          }
          if (((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && (QLog.isColorLevel())) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate timeout resultcode = " + paramFromServiceMsg.getResultCode());
          }
          a((CheckUpdateResp)paramObject);
          this.app.a();
        } while ((!acxu.ENABLE) || (!aqoe.cg(this.app)));
        if (amxh.awk()) {}
        for (int k = 1;; k = 0)
        {
          this.app.a().Km(k);
          if (k != 1) {
            break;
          }
          aqoe.an(this.app, true);
          this.app.a().cOM();
          return;
        }
        aqoe.am(this.app, false);
        return;
        if ("SummaryCard.ReqSearch".equals(paramFromServiceMsg.getServiceCmd()))
        {
          dK(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5d1_0".equals(paramFromServiceMsg.getServiceCmd()))
        {
          dP(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (("OidbSvc.0x476_146".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x476_147".equals(paramFromServiceMsg.getServiceCmd())))
        {
          dQ(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd()))
        {
          dL(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x491_107".equals(paramFromServiceMsg.getServiceCmd()))
        {
          dR(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x490_107".equals(paramFromServiceMsg.getServiceCmd()))
        {
          dS(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5e1_8".equals(paramFromServiceMsg.getServiceCmd()))
        {
          e(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
          return;
        }
        if ("OidbSvc.0x49d_107".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          dA(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x7c4_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          dT(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x4f4_5".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          dW(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x7c6_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          dU(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x7c7_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          dV(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x7df_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          ed(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5d6_7".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          if (paramToServiceMsg.extraData.getBoolean("param_is_set_switches_of_a_person"))
          {
            dF(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          dD(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5d6_21".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          if (paramToServiceMsg.extraData.getInt("param_type") == 0)
          {
            dB(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          dC(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (("OidbSvc.0x5d6_18".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x5d6_19".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
        {
          dE(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while ("OidbSvc.0x77c".equals(paramFromServiceMsg.getServiceCmd()));
      if ("OidbSvc.0x829_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        ee(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x777".equals(paramFromServiceMsg.getServiceCmd()))
      {
        eh(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc26_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        dX(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc36_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        dZ(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc35_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        ea(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc34_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        ec(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc83".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        ef(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc85".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        eg(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xcf0_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        ei(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc34_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        eb(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd69".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        ek(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd72".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        ej(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xc26_1".equals(paramFromServiceMsg.getServiceCmd()));
    label416:
    label1441:
    label1447:
    dY(paramToServiceMsg, paramFromServiceMsg, paramObject);
    label523:
  }
  
  public void q(boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c6.ReqBody();
    ((cmd0x7c6.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    int k;
    if (paramInt == 1)
    {
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
      if (paramBoolean)
      {
        k = 1;
        paramString.set(k);
        label48:
        paramString = new oidb_sso.OIDBSSOPkg();
        paramString.uint32_command.set(1990);
        paramString.uint32_result.set(0);
        paramString.uint32_service_type.set(0);
        paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c6.ReqBody)localObject).toByteArray()));
        localObject = createToServiceMsg("OidbSvc.0x7c6_0");
        ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
        if (paramInt != 1) {
          break label290;
        }
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
      }
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).extraData.putBoolean("key_dongtai_permission", paramBoolean);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
      k = 0;
      break;
      if (paramInt == 2)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
        if (paramBoolean) {}
        for (k = 1;; k = 0)
        {
          paramString.set(k);
          break;
        }
      }
      if (paramInt == 3)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
        if (paramBoolean)
        {
          k = 1;
          label216:
          paramString.set(k);
          paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
          if (!paramBoolean) {
            break label250;
          }
        }
        label250:
        for (k = 1;; k = 0)
        {
          paramString.set(k);
          break;
          k = 0;
          break label216;
        }
      }
      if (paramInt != 4) {
        break label48;
      }
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_recv_msg_box;
      if (paramBoolean == true) {}
      for (k = 1;; k = 0)
      {
        paramString.set(k);
        break;
      }
      label290:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      } else if (paramInt == 4) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 4);
      }
    }
  }
  
  public String rA()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {}
    synchronized (this.cr)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler = new QQHeadDownloadHandler(this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.rR();
    }
  }
  
  public String rz()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {}
    synchronized (this.cr)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler = new QQHeadDownloadHandler(this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.rz();
    }
  }
  
  public static class AddBatchPhoneFriendResult
    implements Serializable
  {
    public static final int ALLOW_TYPE_NEED_ANSWER = 2;
    public static final int ALLOW_TYPE_REFUSE_ADD = 1;
    public static final int ALLOW_TYPE_SEND_ADD_REQ = 3;
    public static final int SEND_ADD_UP_LIMIT = 32;
    public static final int SEND_ADD_UP_LIMIT_OTHER = 33;
    public static final int SEND_REQ_ALREAY = 1;
    public static final int SEND_REQ_NO = 2;
    public static final int SEND_REQ_UNKNOWN = 0;
    public static final int SEND_SECURITY_FORCED_FAILED = 37;
    public static final int SEND_SUCCESS = 0;
    public int allowType;
    public String mobile;
    public String remark;
    public int sendReqFlag;
    public int sendResult;
  }
  
  public static class QQHeadDetails
    implements Parcelable
  {
    public static final Parcelable.Creator<QQHeadDetails> CREATOR = new acfc();
    public byte bb;
    public String boh;
    public long headImgTimestamp;
    public int userType;
    
    private QQHeadDetails() {}
    
    public QQHeadDetails(int paramInt, String paramString, long paramLong, byte paramByte)
    {
      this.userType = paramInt;
      this.boh = paramString;
      this.headImgTimestamp = paramLong;
      this.bb = paramByte;
    }
    
    public DestQQHeadInfo a()
    {
      long l1 = 0L;
      if (this.userType == 11) {
        return new DestQQHeadInfo(0L, this.headImgTimestamp, this.boh);
      }
      try
      {
        long l2 = Long.parseLong(this.boh);
        l1 = l2;
      }
      catch (Exception localException)
      {
        label38:
        break label38;
      }
      return new DestQQHeadInfo(l1, this.headImgTimestamp, null);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{uinOrMobile:").append(this.boh).append(",timestamp:").append(this.headImgTimestamp).append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.userType);
      paramParcel.writeString(this.boh);
      paramParcel.writeLong(this.headImgTimestamp);
      paramParcel.writeByte(this.bb);
    }
  }
  
  static class a
  {
    public long count;
    public long expiredTime;
    public long startTime;
  }
  
  class b
  {
    public long PD;
    public long PE;
    public long PF;
    public long PG;
    public int aRY;
    public long costTime;
    public String downUrl = "";
    public int size;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler
 * JD-Core Version:    0.7.0.1
 */