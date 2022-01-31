package com.tencent.mobileqq.app;

import KQQ.GroupMemberFlag;
import KQQ.GroupMngRes;
import KQQ.ProfGroupInfoRes;
import KQQ.RespBatchProcess;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.common.util.SubString;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.compatible.PbServlet;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.CustomEntry;
import com.tencent.mobileqq.data.TroopMemberCard.GBarInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.mobileqq.troopshare.TroopShareResp;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.protofile.join_group_link.join_group_link.ReqBody;
import com.tencent.protofile.join_group_link.join_group_link.RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cwv;
import cww;
import friendlist.GetMultiTroopInfoResp;
import friendlist.GetTroopAppointRemarkResp;
import friendlist.GetTroopListRespV2;
import friendlist.GetTroopMemberListReq;
import friendlist.GetTroopMemberListResp;
import friendlist.GetTroopRemarkReq;
import friendlist.GetTroopRemarkResp;
import friendlist.ModifyGroupCardResp;
import friendlist.ModifyGroupInfoResp;
import friendlist.stTroopInfoV2;
import friendlist.stTroopMemberInfo;
import friendlist.stTroopNum;
import friendlist.stTroopRemarkInfo;
import friendlist.stUinInfo;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.AnonyMsg;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.AnonyStatus;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.ReqBody;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.RspBody;
import tencent.im.group.group_member_info.CustomEntry;
import tencent.im.group.group_member_info.GBarInfo;
import tencent.im.group.group_member_info.MemberInfo;
import tencent.im.group.group_member_info.ReqBody;
import tencent.im.group.group_member_info.RspBody;
import tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationReq;
import tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationRes;
import tencent.im.kqq.searchgroup.SearchGroup.GroupClusterInfo;
import tencent.im.kqq.searchgroup.SearchGroup.SearchGroupReq;
import tencent.im.kqq.searchgroup.SearchGroup.SearchGroupRes;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0x89e.oidb_0x89e.ReqBody;
import tencent.im.oidb.cmd0x89e.oidb_0x89e.RspBody;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.KickMemberInfo;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.KickResult;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.ReqBody;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.RspBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.ReqBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.RspBody;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.DelPicReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ModifyOrderReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ReqBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.RspBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.SetDefaultReq;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb.GroupConcernedInfo;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb.ReqBody;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb.UinInfo;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb.WriteReq;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca.ReqBody;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca.RspBody;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x4UpdateApp;

public class TroopHandler
  extends BusinessHandler
{
  public static final int A = 23;
  public static final int B = 24;
  public static final int C = 25;
  public static final int D = 26;
  public static final int E = 27;
  public static final int F = 28;
  public static final int G = 29;
  public static final int H = 30;
  public static final int I = 31;
  public static final int J = 32;
  public static final int K = 33;
  public static final int L = 34;
  public static final int M = 35;
  public static final int N = 36;
  public static final int O = 37;
  public static final int P = 38;
  public static final int Q = 39;
  public static final int R = 40;
  public static final int S = 41;
  public static final int T = 42;
  public static final int U = 43;
  public static final int V = 44;
  public static final int W = 45;
  public static final int X = 46;
  public static final int Y = 47;
  public static final int Z = 48;
  public static final int a = 0;
  public static final long a = 1L;
  public static final String a = "TroopHandler";
  private static final short jdField_a_of_type_Short = 500;
  private static final int aA = 4;
  private static final int aB = 5;
  private static final int aC = 6;
  public static final int aa = 49;
  public static final int ab = 50;
  public static final int ac = 51;
  public static final int ad = 52;
  public static final int ae = 53;
  public static final int af = 54;
  public static final int ag = 55;
  public static final int ah = 56;
  public static final int ai = 57;
  public static final int aj = 58;
  public static final int ak = 59;
  public static final int al = 60;
  public static final int am = 61;
  public static int an = 9101;
  public static int ao = 9102;
  public static int ap = 9103;
  public static final int aq = 1;
  public static final int ar = 2;
  public static final int as = 4;
  public static final int at = 8;
  public static final int au = 16;
  public static final int av = 32;
  public static final int aw = 63;
  private static final int ax = 1;
  private static final int ay = 2;
  private static final int az = 3;
  public static final int b = 0;
  public static final long b = 2L;
  public static final String b = "get_troop_member";
  public static final int c = -1;
  public static final long c = 21L;
  public static final String c = "command";
  public static final int d = 0;
  public static final long d = 1101236949L;
  public static final String d = "operation";
  public static final int e = 1;
  public static final long e = 1101484419L;
  public static final String e = "troop_code";
  public static final int f = 2;
  public static final long f = 1102858908L;
  public static final String f = "troop_member_uin";
  public static final int g = 3;
  public static final String g = "GroupSvc.JoinGroupLink";
  public static final int h = 4;
  public static String h = "GroupCodeZero";
  public static final int i = 5;
  public static final String i = "has_to_qzone_troop_permission";
  public static final int j = 6;
  public static final String j = "needUpdatePreferences";
  public static final int k = 7;
  private static final String k = "_role";
  public static final int l = 8;
  public static final int m = 9;
  public static final int n = 10;
  public static final int o = 11;
  public static final int p = 12;
  public static final int q = 13;
  public static final int r = 14;
  public static final int s = 15;
  public static final int t = 16;
  public static final int u = 17;
  public static final int v = 18;
  public static final int w = 19;
  public static final int x = 20;
  public static final int y = 21;
  public static final int z = 22;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  protected Set b;
  private long g = -1L;
  
  TroopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l1 = Long.parseLong(paramString);
        if (l1 >= 10000L) {
          return l1;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private String a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = paramLong + 4294967296L;
    }
    return String.valueOf(l1);
  }
  
  public static String a(String paramString)
  {
    return paramString + "_role";
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    cwv localcwv = new cwv();
    localcwv.jdField_a_of_type_Long = paramIntent.getLongExtra("TroopUin", 0L);
    localcwv.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isClear", false);
    localcwv.b = paramIntent.getIntExtra("lat", 0);
    localcwv.c = paramIntent.getIntExtra("lon", 0);
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramIntent = new GroupLocation.SetGroupLocationRes();
        paramIntent.mergeFrom(paramArrayOfByte);
        localcwv.jdField_a_of_type_Int = paramIntent.result.get();
        if (localcwv.jdField_a_of_type_Int != 0) {
          break label213;
        }
        localcwv.jdField_a_of_type_JavaLangString = paramIntent.grouplocation.get();
        paramIntent = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (paramIntent != null)
        {
          paramFromServiceMsg = paramIntent.a("" + localcwv.jdField_a_of_type_Long);
          paramFromServiceMsg.strLocation = localcwv.jdField_a_of_type_JavaLangString;
          paramIntent.b(paramFromServiceMsg);
        }
        bool = true;
      }
      catch (Exception paramIntent)
      {
        localcwv.jdField_a_of_type_Int = -1;
        continue;
      }
      a(15, bool, localcwv);
      return;
      localcwv.jdField_a_of_type_Int = paramFromServiceMsg.getResultCode();
      continue;
      label213:
      bool = false;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetMultiTroopInfoResp paramGetMultiTroopInfoResp)
  {
    int i2 = 0;
    if (paramGetMultiTroopInfoResp == null)
    {
      a(2, false, null);
      return;
    }
    if (paramFromServiceMsg == null)
    {
      a(2, false, null);
      return;
    }
    if (paramGetMultiTroopInfoResp.result != 0)
    {
      a(2, false, null);
      return;
    }
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    int i1 = i2;
    if (paramGetMultiTroopInfoResp.vecTroopInfo != null)
    {
      i1 = i2;
      if (paramGetMultiTroopInfoResp.vecTroopInfo.size() > 0)
      {
        Iterator localIterator = paramGetMultiTroopInfoResp.vecTroopInfo.iterator();
        i1 = 0;
        while (localIterator.hasNext())
        {
          stTroopInfoV2 localstTroopInfoV2 = (stTroopInfoV2)localIterator.next();
          paramGetMultiTroopInfoResp = localFriendsManagerImp.a(String.valueOf(localstTroopInfoV2.dwGroupCode));
          paramFromServiceMsg = paramGetMultiTroopInfoResp;
          if (paramGetMultiTroopInfoResp == null)
          {
            paramFromServiceMsg = new TroopInfo();
            paramFromServiceMsg.troopuin = String.valueOf(localstTroopInfoV2.dwGroupCode);
          }
          paramFromServiceMsg.troopcode = String.valueOf(localstTroopInfoV2.dwGroupUin);
          if (paramFromServiceMsg.troopcode != null)
          {
            i2 = i1;
            if (!paramFromServiceMsg.troopcode.equals("0")) {}
          }
          else
          {
            i2 = 1;
          }
          paramFromServiceMsg.troopname = localstTroopInfoV2.strGroupName;
          paramFromServiceMsg.troopmemo = localstTroopInfoV2.strGroupMemo;
          paramFromServiceMsg.fingertroopmemo = localstTroopInfoV2.strFingerMemo;
          paramFromServiceMsg.troopowneruin = Long.toString(localstTroopInfoV2.dwGroupOwnerUin);
          paramFromServiceMsg.dwGroupClassExt = localstTroopInfoV2.dwGroupClassExt;
          paramFromServiceMsg.troopface = ((short)localstTroopInfoV2.wGroupFace);
          paramFromServiceMsg.cGroupOption = ((short)localstTroopInfoV2.cGroupOption);
          paramFromServiceMsg.wMemberNum = localstTroopInfoV2.memberNum;
          paramFromServiceMsg.timeSec = l1;
          paramFromServiceMsg.dwGroupFlagExt = localstTroopInfoV2.dwGroupFlagExt;
          paramFromServiceMsg.dwAuthGroupType = localstTroopInfoV2.dwCertificationType;
          localArrayList.add(paramFromServiceMsg);
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("refreshTroopList", 2, "handleMultiTroopInfo save troop " + paramFromServiceMsg.troopuin + " troopcode:" + paramFromServiceMsg.troopcode);
            i1 = i2;
          }
        }
        localFriendsManagerImp.b(localArrayList, l1);
      }
    }
    if (i1 != 0) {
      a(ao);
    }
    a(2, true, localArrayList);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetTroopAppointRemarkResp paramGetTroopAppointRemarkResp)
  {
    if (paramFromServiceMsg == null) {
      a(10, false, null);
    }
    do
    {
      do
      {
        return;
      } while (paramGetTroopAppointRemarkResp == null);
      try
      {
        if (paramGetTroopAppointRemarkResp.result != 0)
        {
          a(10, false, null);
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        a(10, false, null);
        return;
      }
      paramFromServiceMsg = paramGetTroopAppointRemarkResp.vecTroopRemark;
    } while (paramFromServiceMsg == null);
    paramFromServiceMsg = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramGetTroopAppointRemarkResp.GroupCode), paramFromServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("handlerGetTroopMemberCardInfoList", 2, "bRet = " + paramFromServiceMsg[1]);
    }
    a(10, true, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GroupMngRes paramGroupMngRes)
  {
    Object localObject1 = paramGroupMngRes.vecBody;
    paramToServiceMsg = new TroopInfo();
    try
    {
      localObject1 = ByteBuffer.wrap((byte[])localObject1);
      paramToServiceMsg.troopcode = String.valueOf(((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
      paramToServiceMsg.troopuin = String.valueOf(((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
      paramToServiceMsg.strLocation = paramGroupMngRes.sGroupLocation;
      paramToServiceMsg.troopAuthenticateInfo = paramGroupMngRes.sAuthGrpInfo;
      paramToServiceMsg.joinTroopQuestion = paramGroupMngRes.sJoinQuestion;
      paramToServiceMsg.joinTroopAnswer = paramGroupMngRes.sJoinAnswer;
      while (((ByteBuffer)localObject1).remaining() > 0)
      {
        i1 = ((ByteBuffer)localObject1).get();
        ((ByteBuffer)localObject1).remaining();
        switch (i1 & 0xFF)
        {
        case 6: 
        case 10: 
        case 15: 
        case 17: 
          i1 = ((ByteBuffer)localObject1).get() & 0xFF;
          ((ByteBuffer)localObject1).get(new byte[i1], 0, i1);
        }
      }
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      for (;;)
      {
        int i1;
        localBufferUnderflowException.printStackTrace();
        TroopInfo localTroopInfo = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramToServiceMsg.troopuin);
        Object localObject2;
        if (localTroopInfo != null)
        {
          localTroopInfo.trooptype = paramToServiceMsg.trooptype;
          localTroopInfo.troopCreateTime = paramToServiceMsg.troopCreateTime;
          localTroopInfo.dwGroupFlag = paramToServiceMsg.dwGroupFlag;
          localTroopInfo.troopowneruin = paramToServiceMsg.troopowneruin;
          localTroopInfo.cGroupOption = paramToServiceMsg.cGroupOption;
          localTroopInfo.dwGroupClassExt = paramToServiceMsg.dwGroupClassExt;
          localTroopInfo.wMemberMax = paramToServiceMsg.wMemberMax;
          localTroopInfo.wSpecialClass = paramToServiceMsg.wSpecialClass;
          localTroopInfo.cGroupLevel = paramToServiceMsg.cGroupLevel;
          localTroopInfo.troopname = paramToServiceMsg.troopname;
          localTroopInfo.troopface = paramToServiceMsg.troopface;
          localTroopInfo.fingertroopmemo = paramToServiceMsg.fingertroopmemo;
          localTroopInfo.wMemberNum = paramToServiceMsg.wMemberNum;
          localTroopInfo.strLocation = paramToServiceMsg.strLocation;
          localTroopInfo.dwGroupFlagExt = paramToServiceMsg.dwGroupFlagExt;
          localTroopInfo.troopAuthenticateInfo = paramToServiceMsg.troopAuthenticateInfo;
          localTroopInfo.joinTroopQuestion = paramToServiceMsg.joinTroopQuestion;
          localTroopInfo.joinTroopAnswer = paramToServiceMsg.joinTroopAnswer;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          ((EntityManager)localObject2).a(localTroopInfo);
          ((EntityManager)localObject2).a();
        }
        for (boolean bool = true;; bool = false)
        {
          a(6, true, new Object[] { Byte.valueOf(paramGroupMngRes.result), paramToServiceMsg, Boolean.valueOf(bool) });
          return;
          localTroopInfo.get();
          paramToServiceMsg.trooptype = (localTroopInfo.get() & 0xFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.troopCreateTime = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.dwGroupFlag = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.troopowneruin = String.valueOf(localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.cGroupOption = ((short)(localTroopInfo.get() & 0xFF));
          break;
          localTroopInfo.get();
          paramToServiceMsg.dwGroupClassExt = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.wMemberMax = (localTroopInfo.getShort() & 0xFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.wSpecialClass = (localTroopInfo.getShort() & 0xFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.cGroupLevel = ((short)(localTroopInfo.get() & 0xFF));
          break;
          localTroopInfo.get();
          paramToServiceMsg.dwGroupFlagExt = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          i1 = localTroopInfo.get() & 0xFF;
          localObject2 = new byte[i1];
          localTroopInfo.get((byte[])localObject2, 0, i1);
          paramToServiceMsg.troopname = PkgTools.c((byte[])localObject2, 0, i1);
          break;
          localTroopInfo.get();
          paramToServiceMsg.troopface = ((short)(localTroopInfo.getShort() & 0xFFFF));
          break;
          i1 = localTroopInfo.get() & 0xFF;
          localObject2 = new byte[i1];
          localTroopInfo.get((byte[])localObject2, 0, i1);
          paramToServiceMsg.fingertroopmemo = PkgTools.c((byte[])localObject2, 0, i1);
          break;
          localTroopInfo.get();
          paramToServiceMsg.wMemberNum = (localTroopInfo.getShort() & 0xFFFF);
          break;
          TroopSystemMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.troopuin, paramToServiceMsg.troopname);
          TroopSystemMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.troopuin, paramToServiceMsg.dwGroupFlagExt);
          TroopSystemMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.troopuin, paramToServiceMsg.joinTroopQuestion);
          TroopSystemMsgUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.troopuin, paramToServiceMsg.joinTroopAnswer);
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i2 = paramToServiceMsg.extraData.getInt("groupreqtype");
    String str1 = paramToServiceMsg.extraData.getString("troop_uin");
    if (paramFromServiceMsg.isSuccess()) {}
    for (GroupMngRes localGroupMngRes = (GroupMngRes)a(paramFromServiceMsg.getWupBuffer(), "GroupMngRes", new GroupMngRes());; localGroupMngRes = null)
    {
      Object localObject1;
      Object localObject2;
      switch (i2)
      {
      default: 
        a(5, false, new Object[] { Integer.valueOf(i2), Integer.valueOf(-1) });
        return;
      case 0: 
        if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
        {
          a(paramToServiceMsg, localGroupMngRes);
          return;
        }
        a(6, false, null);
        return;
      case 3: 
        localObject1 = paramToServiceMsg.extraData.getString("troop_uin");
        localObject2 = paramToServiceMsg.extraData.getStringArrayList("frie_uins");
        if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0) && (str1 != null) && (localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          localObject1 = paramFromServiceMsg.a((String)localObject1);
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str2 = (String)((Iterator)localObject2).next();
            TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramToServiceMsg.a(TroopMemberInfo.class, "troopuin=? and memberuin=?", new String[] { str1, str2 });
            if (localTroopMemberInfo != null)
            {
              paramToServiceMsg.b(localTroopMemberInfo);
              if (((TroopInfo)localObject1).wMemberNum > 0) {
                ((TroopInfo)localObject1).wMemberNum -= 1;
              }
              if ((((TroopInfo)localObject1).Administrator != null) && (((TroopInfo)localObject1).Administrator.contains(str2))) {
                ((TroopInfo)localObject1).Administrator.replace(str2, "");
              }
            }
          }
          paramFromServiceMsg.b((TroopInfo)localObject1);
          paramToServiceMsg.a();
          a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
          return;
        }
        if (paramFromServiceMsg.isSuccess()) {}
        for (b1 = localGroupMngRes.result;; b1 = -1)
        {
          a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
          return;
        }
      case 1: 
        if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
        {
          a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
          return;
        }
        if (paramFromServiceMsg.isSuccess()) {}
        for (b1 = localGroupMngRes.result;; b1 = -1)
        {
          a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
          return;
        }
      case 2: 
        if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
        {
          paramToServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 1);
          paramToServiceMsg.e(str1);
          DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
          return;
        }
        if (paramFromServiceMsg.isSuccess()) {}
        for (b1 = localGroupMngRes.result;; b1 = -1)
        {
          a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
          return;
        }
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        if ((i2 == 4) || (i2 == 5)) {
          if (paramFromServiceMsg.isSuccess()) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(String.valueOf(AppConstants.Y), 0).edit().putInt(paramToServiceMsg.extraData.getString("Request_uin") + "_answer_joined_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L), i2).commit();
          }
        }
        while ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
        {
          a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
          return;
          if (((i2 == 6) || (i2 == 7)) && (paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
          {
            int i1 = 0;
            if (i2 == 6)
            {
              if (1 != localGroupMngRes.cIsMemInvite) {
                break label1178;
              }
              i1 = 1;
              label947:
              if (i1 == 0)
              {
                localObject1 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
                if (((FriendsManagerImp)localObject1).a(paramToServiceMsg.extraData.getString("troop_uin")) == null)
                {
                  localObject2 = new TroopInfo();
                  ((TroopInfo)localObject2).troopuin = String.valueOf(paramToServiceMsg.extraData.getString("troop_uin"));
                  ((FriendsManagerImp)localObject1).a((TroopInfo)localObject2);
                  ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(((TroopInfo)localObject2).troopuin, (byte)1, ((TroopInfo)localObject2).dwTimeStamp, 0);
                }
              }
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(String.valueOf(AppConstants.Y), 0).edit();
            paramToServiceMsg = paramToServiceMsg.extraData.getString("Request_uin") + "_member_answer_joined_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
            ((SharedPreferences.Editor)localObject1).putInt(paramToServiceMsg, i2);
            if (i2 == 6) {
              if (i1 == 0) {
                break label1184;
              }
            }
            label1178:
            label1184:
            for (i1 = 1;; i1 = 0)
            {
              ((SharedPreferences.Editor)localObject1).putInt(a(paramToServiceMsg), i1);
              ((SharedPreferences.Editor)localObject1).commit();
              break;
              i1 = 0;
              break label947;
            }
          }
        }
        if (paramFromServiceMsg.isSuccess()) {}
        for (b1 = localGroupMngRes.result;; b1 = -1)
        {
          a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
          return;
        }
      }
      if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
      {
        paramToServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 1);
        paramToServiceMsg.e(str1);
        DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
        return;
      }
      if (paramFromServiceMsg.isSuccess()) {}
      for (byte b1 = localGroupMngRes.result;; b1 = -1)
      {
        a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
        return;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, ModifyGroupCardResp paramModifyGroupCardResp)
  {
    if (paramFromServiceMsg == null)
    {
      a(9, false, null);
      return;
    }
    if (paramModifyGroupCardResp == null)
    {
      a(9, false, null);
      return;
    }
    if (paramToServiceMsg == null)
    {
      a(9, false, null);
      return;
    }
    if (paramModifyGroupCardResp.result != 0)
    {
      a(9, false, null);
      return;
    }
    paramFromServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecUinInfo");
    long l1 = paramToServiceMsg.extraData.getLong("dwGroupCode");
    paramToServiceMsg.extraData.getLong("dwZero");
    paramToServiceMsg.extraData.getLong("dwNewSeq");
    a(9, true, DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), paramFromServiceMsg));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, ModifyGroupInfoResp paramModifyGroupInfoResp)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(11, false, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null });
      return;
    }
    long l1 = paramToServiceMsg.extraData.getLong("dwGroupCode");
    int i1 = paramToServiceMsg.extraData.getInt("modify_troopinfo_flag");
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localFriendsManagerImp == null) {}
    for (paramFromServiceMsg = null; (paramModifyGroupInfoResp == null) || (l1 != paramModifyGroupInfoResp.dwGroupCode) || (paramModifyGroupInfoResp.result != 0); paramFromServiceMsg = localFriendsManagerImp.a(Long.toString(l1)))
    {
      a(11, false, new Object[] { Long.valueOf(l1), Integer.valueOf(i1), paramFromServiceMsg });
      return;
    }
    paramModifyGroupInfoResp = paramFromServiceMsg;
    if (paramFromServiceMsg == null)
    {
      paramModifyGroupInfoResp = new TroopInfo();
      paramModifyGroupInfoResp.troopuin = Long.toString(l1);
    }
    paramModifyGroupInfoResp.troopname = paramToServiceMsg.extraData.getString("strGroupName");
    paramModifyGroupInfoResp.dwGroupClassExt = paramToServiceMsg.extraData.getLong("dwGroupClass");
    paramModifyGroupInfoResp.cGroupOption = ((short)(int)paramToServiceMsg.extraData.getLong("cGroupOption"));
    paramModifyGroupInfoResp.troopmemo = paramToServiceMsg.extraData.getString("strGroupMemo");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("strFingerMemo");
    try
    {
      paramFromServiceMsg = paramToServiceMsg.getBytes("utf-8");
      if (paramFromServiceMsg.length > 120) {}
      for (paramModifyGroupInfoResp.fingertroopmemo = SubString.a(paramFromServiceMsg, 120);; paramModifyGroupInfoResp.fingertroopmemo = paramToServiceMsg)
      {
        paramModifyGroupInfoResp.mRichFingerMemo = paramToServiceMsg;
        localFriendsManagerImp.b(paramModifyGroupInfoResp);
        a(11, true, new Object[] { Long.valueOf(l1), Integer.valueOf(i1), paramModifyGroupInfoResp });
        return;
      }
    }
    catch (IOException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramModifyGroupInfoResp.fingertroopmemo = "";
      }
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, GetTroopListRespV2 paramGetTroopListRespV2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +27 -> 28
    //   4: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +13 -> 20
    //   10: ldc_w 837
    //   13: iconst_2
    //   14: ldc_w 839
    //   17: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: aload_0
    //   21: iconst_1
    //   22: iconst_0
    //   23: aconst_null
    //   24: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   27: return
    //   28: aload_2
    //   29: getfield 844	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   32: ifnonnull +65 -> 97
    //   35: aload_2
    //   36: getfield 847	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   39: ifnonnull +58 -> 97
    //   42: aload_2
    //   43: getfield 850	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   46: ifnonnull +51 -> 97
    //   49: aload_2
    //   50: getfield 853	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   53: ifnonnull +44 -> 97
    //   56: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +13 -> 72
    //   62: ldc_w 837
    //   65: iconst_2
    //   66: ldc_w 855
    //   69: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_2
    //   73: getfield 858	friendlist/GetTroopListRespV2:errorCode	S
    //   76: ifne +15 -> 91
    //   79: iconst_1
    //   80: istore 7
    //   82: aload_0
    //   83: iconst_1
    //   84: iload 7
    //   86: aconst_null
    //   87: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   90: return
    //   91: iconst_0
    //   92: istore 7
    //   94: goto -12 -> 82
    //   97: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +136 -> 236
    //   103: new 240	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 860
    //   113: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: astore 10
    //   118: aload_2
    //   119: getfield 844	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   122: ifnull +129 -> 251
    //   125: aload_2
    //   126: getfield 844	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   129: invokevirtual 371	java/util/ArrayList:size	()I
    //   132: istore_3
    //   133: aload 10
    //   135: iload_3
    //   136: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: ldc_w 865
    //   142: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: astore 10
    //   147: aload_2
    //   148: getfield 847	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   151: ifnull +105 -> 256
    //   154: aload_2
    //   155: getfield 847	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   158: invokevirtual 371	java/util/ArrayList:size	()I
    //   161: istore_3
    //   162: aload 10
    //   164: iload_3
    //   165: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc_w 867
    //   171: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: astore 10
    //   176: aload_2
    //   177: getfield 850	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   180: ifnull +81 -> 261
    //   183: aload_2
    //   184: getfield 850	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   187: invokevirtual 371	java/util/ArrayList:size	()I
    //   190: istore_3
    //   191: aload 10
    //   193: iload_3
    //   194: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc_w 869
    //   200: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: astore 10
    //   205: aload_2
    //   206: getfield 853	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   209: ifnull +57 -> 266
    //   212: aload_2
    //   213: getfield 853	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   216: invokevirtual 371	java/util/ArrayList:size	()I
    //   219: istore_3
    //   220: ldc_w 837
    //   223: iconst_2
    //   224: aload 10
    //   226: iload_3
    //   227: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_2
    //   237: getfield 858	friendlist/GetTroopListRespV2:errorCode	S
    //   240: sipush 2001
    //   243: if_icmpne +28 -> 271
    //   246: aload_0
    //   247: invokevirtual 870	com/tencent/mobileqq/app/TroopHandler:a	()V
    //   250: return
    //   251: iconst_m1
    //   252: istore_3
    //   253: goto -120 -> 133
    //   256: iconst_m1
    //   257: istore_3
    //   258: goto -96 -> 162
    //   261: iconst_m1
    //   262: istore_3
    //   263: goto -72 -> 191
    //   266: iconst_m1
    //   267: istore_3
    //   268: goto -48 -> 220
    //   271: new 358	java/util/ArrayList
    //   274: dup
    //   275: invokespecial 359	java/util/ArrayList:<init>	()V
    //   278: astore 12
    //   280: invokestatic 365	java/lang/System:currentTimeMillis	()J
    //   283: lstore 8
    //   285: iconst_0
    //   286: istore 5
    //   288: iconst_0
    //   289: istore 6
    //   291: aconst_null
    //   292: astore 11
    //   294: new 358	java/util/ArrayList
    //   297: dup
    //   298: invokespecial 359	java/util/ArrayList:<init>	()V
    //   301: astore 13
    //   303: aload_0
    //   304: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   307: bipush 44
    //   309: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   312: checkcast 872	com/tencent/mobileqq/app/TroopManager
    //   315: astore 14
    //   317: aload 14
    //   319: invokevirtual 875	com/tencent/mobileqq/app/TroopManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   322: astore 10
    //   324: aload 10
    //   326: invokevirtual 878	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   329: aload_2
    //   330: getfield 847	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   333: ifnull +139 -> 472
    //   336: iconst_0
    //   337: istore_3
    //   338: iload_3
    //   339: aload_2
    //   340: getfield 847	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   343: invokevirtual 371	java/util/ArrayList:size	()I
    //   346: if_icmpge +126 -> 472
    //   349: aload_2
    //   350: getfield 847	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   353: iload_3
    //   354: invokevirtual 881	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   357: checkcast 883	friendlist/stTroopNum
    //   360: astore 15
    //   362: aload 14
    //   364: aload 15
    //   366: getfield 884	friendlist/stTroopNum:GroupCode	J
    //   369: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   372: invokevirtual 886	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)V
    //   375: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +48 -> 426
    //   381: ldc_w 837
    //   384: iconst_2
    //   385: new 240	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   392: ldc_w 888
    //   395: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 15
    //   400: getfield 891	friendlist/stTroopNum:GroupUin	J
    //   403: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: ldc_w 893
    //   409: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 15
    //   414: getfield 884	friendlist/stTroopNum:GroupCode	J
    //   417: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   420: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload_0
    //   427: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   430: invokevirtual 896	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   433: astore 11
    //   435: aload 11
    //   437: invokevirtual 901	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   440: aload 15
    //   442: getfield 884	friendlist/stTroopNum:GroupCode	J
    //   445: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   448: iconst_1
    //   449: invokevirtual 906	com/tencent/mobileqq/app/proxy/RecentUserProxy:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/RecentUser;
    //   452: astore 15
    //   454: aload 15
    //   456: ifnull +1010 -> 1466
    //   459: aload 11
    //   461: invokevirtual 901	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   464: aload 15
    //   466: invokevirtual 909	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	(Lcom/tencent/mobileqq/data/RecentUser;)V
    //   469: goto +997 -> 1466
    //   472: aload_2
    //   473: getfield 844	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   476: ifnull +435 -> 911
    //   479: iconst_0
    //   480: istore 4
    //   482: iload 6
    //   484: istore_3
    //   485: iload_3
    //   486: istore 5
    //   488: iload 4
    //   490: aload_2
    //   491: getfield 844	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   494: invokevirtual 371	java/util/ArrayList:size	()I
    //   497: if_icmpge +414 -> 911
    //   500: aload_2
    //   501: getfield 844	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   504: iload 4
    //   506: invokevirtual 881	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   509: checkcast 883	friendlist/stTroopNum
    //   512: astore 15
    //   514: aload 14
    //   516: aload 15
    //   518: getfield 884	friendlist/stTroopNum:GroupCode	J
    //   521: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   524: invokevirtual 910	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   527: astore 11
    //   529: aload 11
    //   531: ifnonnull +956 -> 1487
    //   534: iconst_1
    //   535: istore 5
    //   537: iload 5
    //   539: ifeq +25 -> 564
    //   542: new 339	com/tencent/mobileqq/data/TroopInfo
    //   545: dup
    //   546: invokespecial 390	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   549: astore 11
    //   551: aload 11
    //   553: aload 15
    //   555: getfield 884	friendlist/stTroopNum:GroupCode	J
    //   558: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   561: putfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   564: aload 11
    //   566: aload_1
    //   567: invokevirtual 913	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   570: putfield 916	com/tencent/mobileqq/data/TroopInfo:uin	Ljava/lang/String;
    //   573: aload 11
    //   575: aload 15
    //   577: getfield 891	friendlist/stTroopNum:GroupUin	J
    //   580: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   583: putfield 399	com/tencent/mobileqq/data/TroopInfo:troopcode	Ljava/lang/String;
    //   586: aload 11
    //   588: aload 15
    //   590: getfield 919	friendlist/stTroopNum:dwGroupInfoSeq	J
    //   593: putfield 920	com/tencent/mobileqq/data/TroopInfo:dwGroupInfoSeq	J
    //   596: aload 11
    //   598: aload 15
    //   600: getfield 921	friendlist/stTroopNum:strGroupName	Ljava/lang/String;
    //   603: putfield 411	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   606: aload 11
    //   608: aload 15
    //   610: getfield 922	friendlist/stTroopNum:strGroupMemo	Ljava/lang/String;
    //   613: putfield 417	com/tencent/mobileqq/data/TroopInfo:troopmemo	Ljava/lang/String;
    //   616: aload 11
    //   618: aload 15
    //   620: getfield 923	friendlist/stTroopNum:dwGroupFlagExt	J
    //   623: putfield 459	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt	J
    //   626: aload 11
    //   628: aload 15
    //   630: getfield 924	friendlist/stTroopNum:dwCertificationType	J
    //   633: putfield 465	com/tencent/mobileqq/data/TroopInfo:dwAuthGroupType	J
    //   636: aload 11
    //   638: lload 8
    //   640: putfield 455	com/tencent/mobileqq/data/TroopInfo:timeSec	J
    //   643: aload 11
    //   645: aload 15
    //   647: getfield 927	friendlist/stTroopNum:dwGroupRankSeq	J
    //   650: putfield 930	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   653: aload 11
    //   655: aload 15
    //   657: getfield 933	friendlist/stTroopNum:dwShutupTimestamp	J
    //   660: putfield 936	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp	J
    //   663: aload 11
    //   665: aload 15
    //   667: getfield 939	friendlist/stTroopNum:dwMyShutupTimestamp	J
    //   670: putfield 942	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp_me	J
    //   673: aload 11
    //   675: aload 15
    //   677: getfield 945	friendlist/stTroopNum:dwCmdUinUinFlag	J
    //   680: putfield 946	com/tencent/mobileqq/data/TroopInfo:dwCmdUinUinFlag	J
    //   683: aload 11
    //   685: aload 15
    //   687: getfield 949	friendlist/stTroopNum:dwAdditionalFlag	J
    //   690: putfield 950	com/tencent/mobileqq/data/TroopInfo:dwAdditionalFlag	J
    //   693: aload 11
    //   695: aload 15
    //   697: getfield 953	friendlist/stTroopNum:dwGroupTypeFlag	J
    //   700: l2i
    //   701: putfield 956	com/tencent/mobileqq/data/TroopInfo:troopTypeExt	I
    //   704: iload 5
    //   706: ifeq +101 -> 807
    //   709: aload 14
    //   711: aload 11
    //   713: invokevirtual 957	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   716: aload_0
    //   717: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   720: aload 11
    //   722: getfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   725: invokevirtual 959	com/tencent/mobileqq/app/QQAppInterface:c	(Ljava/lang/String;)V
    //   728: aload 11
    //   730: getfield 399	com/tencent/mobileqq/data/TroopInfo:troopcode	Ljava/lang/String;
    //   733: ifnull +740 -> 1473
    //   736: aload 11
    //   738: getfield 399	com/tencent/mobileqq/data/TroopInfo:troopcode	Ljava/lang/String;
    //   741: ldc_w 401
    //   744: invokevirtual 405	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   747: ifeq +134 -> 881
    //   750: goto +723 -> 1473
    //   753: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   756: ifeq +722 -> 1478
    //   759: ldc_w 837
    //   762: iconst_2
    //   763: new 240	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   770: ldc_w 961
    //   773: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: aload 15
    //   778: getfield 891	friendlist/stTroopNum:GroupUin	J
    //   781: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   784: ldc_w 893
    //   787: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload 15
    //   792: getfield 884	friendlist/stTroopNum:GroupCode	J
    //   795: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   798: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   804: goto +674 -> 1478
    //   807: aload 14
    //   809: aload 11
    //   811: invokevirtual 962	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   814: goto -98 -> 716
    //   817: astore 11
    //   819: aload 10
    //   821: astore_1
    //   822: aload 11
    //   824: astore 10
    //   826: aload 10
    //   828: invokevirtual 495	java/lang/Exception:printStackTrace	()V
    //   831: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +15 -> 849
    //   837: ldc_w 964
    //   840: iconst_2
    //   841: aload 10
    //   843: invokestatic 968	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   846: invokestatic 970	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   849: aload_1
    //   850: ifnull +7 -> 857
    //   853: aload_1
    //   854: invokevirtual 972	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   857: aload_2
    //   858: getfield 975	friendlist/GetTroopListRespV2:vecCookies	[B
    //   861: ifnull +488 -> 1349
    //   864: aload_2
    //   865: getfield 975	friendlist/GetTroopListRespV2:vecCookies	[B
    //   868: arraylength
    //   869: ifle +480 -> 1349
    //   872: aload_0
    //   873: aload_2
    //   874: getfield 975	friendlist/GetTroopListRespV2:vecCookies	[B
    //   877: invokevirtual 978	com/tencent/mobileqq/app/TroopHandler:b	([B)V
    //   880: return
    //   881: aload 12
    //   883: aload 15
    //   885: getfield 884	friendlist/stTroopNum:GroupCode	J
    //   888: invokestatic 807	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   891: invokevirtual 468	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   894: pop
    //   895: goto -142 -> 753
    //   898: astore_1
    //   899: aload 10
    //   901: ifnull +8 -> 909
    //   904: aload 10
    //   906: invokevirtual 972	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   909: aload_1
    //   910: athrow
    //   911: aload_2
    //   912: getfield 850	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   915: ifnull +269 -> 1184
    //   918: aload_2
    //   919: getfield 850	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   922: invokevirtual 375	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   925: astore 15
    //   927: aload 15
    //   929: invokeinterface 380 1 0
    //   934: ifeq +250 -> 1184
    //   937: aload 15
    //   939: invokeinterface 384 1 0
    //   944: checkcast 980	friendlist/stGroupRankInfo
    //   947: astore 16
    //   949: aload 14
    //   951: aload 16
    //   953: getfield 981	friendlist/stGroupRankInfo:dwGroupCode	J
    //   956: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   959: invokevirtual 910	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   962: astore 12
    //   964: aload 12
    //   966: astore 11
    //   968: aload 12
    //   970: ifnonnull +25 -> 995
    //   973: new 339	com/tencent/mobileqq/data/TroopInfo
    //   976: dup
    //   977: invokespecial 390	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   980: astore 11
    //   982: aload 11
    //   984: aload 16
    //   986: getfield 981	friendlist/stGroupRankInfo:dwGroupCode	J
    //   989: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   992: putfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   995: aload 11
    //   997: aload_1
    //   998: invokevirtual 913	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1001: putfield 916	com/tencent/mobileqq/data/TroopInfo:uin	Ljava/lang/String;
    //   1004: aload 11
    //   1006: aload 16
    //   1008: getfield 984	friendlist/stGroupRankInfo:cGroupRankSysFlag	B
    //   1011: putfield 985	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1014: aload 11
    //   1016: aload 16
    //   1018: getfield 988	friendlist/stGroupRankInfo:cGroupRankUserFlag	B
    //   1021: putfield 989	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1024: aload 11
    //   1026: aload 16
    //   1028: getfield 990	friendlist/stGroupRankInfo:dwGroupRankSeq	J
    //   1031: putfield 930	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   1034: aload 11
    //   1036: aload 16
    //   1038: getfield 993	friendlist/stGroupRankInfo:vecRankMap	Ljava/util/ArrayList;
    //   1041: invokevirtual 997	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap	(Ljava/util/List;)V
    //   1044: aload 11
    //   1046: aload 16
    //   1048: getfield 1000	friendlist/stGroupRankInfo:strOwnerName	Ljava/lang/String;
    //   1051: putfield 1003	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   1054: aload 11
    //   1056: aload 16
    //   1058: getfield 1006	friendlist/stGroupRankInfo:strAdminName	Ljava/lang/String;
    //   1061: putfield 1009	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   1064: aload 14
    //   1066: aload 11
    //   1068: invokevirtual 962	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1071: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1074: ifeq -147 -> 927
    //   1077: new 240	java/lang/StringBuilder
    //   1080: dup
    //   1081: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1084: ldc_w 1011
    //   1087: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: aload 16
    //   1092: getfield 981	friendlist/stGroupRankInfo:dwGroupCode	J
    //   1095: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1098: ldc_w 1013
    //   1101: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: aload 16
    //   1106: getfield 984	friendlist/stGroupRankInfo:cGroupRankSysFlag	B
    //   1109: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1112: ldc_w 1015
    //   1115: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: aload 16
    //   1120: getfield 988	friendlist/stGroupRankInfo:cGroupRankUserFlag	B
    //   1123: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1126: ldc_w 1017
    //   1129: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: aload 16
    //   1134: getfield 990	friendlist/stGroupRankInfo:dwGroupRankSeq	J
    //   1137: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1140: ldc_w 1019
    //   1143: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: astore 11
    //   1148: aload 16
    //   1150: getfield 993	friendlist/stGroupRankInfo:vecRankMap	Ljava/util/ArrayList;
    //   1153: ifnull +340 -> 1493
    //   1156: aload 16
    //   1158: getfield 993	friendlist/stGroupRankInfo:vecRankMap	Ljava/util/ArrayList;
    //   1161: invokevirtual 371	java/util/ArrayList:size	()I
    //   1164: istore_3
    //   1165: ldc_w 837
    //   1168: iconst_2
    //   1169: aload 11
    //   1171: iload_3
    //   1172: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1181: goto -254 -> 927
    //   1184: aload_2
    //   1185: getfield 853	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   1188: ifnull +131 -> 1319
    //   1191: aload_0
    //   1192: getfield 215	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_Boolean	Z
    //   1195: ifeq +124 -> 1319
    //   1198: new 1021	java/util/HashMap
    //   1201: dup
    //   1202: invokespecial 1022	java/util/HashMap:<init>	()V
    //   1205: astore_1
    //   1206: aload_2
    //   1207: getfield 853	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   1210: invokevirtual 375	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1213: astore 11
    //   1215: aload 11
    //   1217: invokeinterface 380 1 0
    //   1222: ifeq +97 -> 1319
    //   1225: aload 11
    //   1227: invokeinterface 384 1 0
    //   1232: checkcast 1024	friendlist/stFavoriteGroup
    //   1235: astore 12
    //   1237: aload 12
    //   1239: getfield 1027	friendlist/stFavoriteGroup:dwSnsFlag	J
    //   1242: lstore 8
    //   1244: ldc2_w 117
    //   1247: lload 8
    //   1249: land
    //   1250: ldc2_w 117
    //   1253: lcmp
    //   1254: ifne +33 -> 1287
    //   1257: aload_1
    //   1258: new 226	java/lang/Long
    //   1261: dup
    //   1262: aload 12
    //   1264: getfield 1028	friendlist/stFavoriteGroup:dwGroupCode	J
    //   1267: invokespecial 1031	java/lang/Long:<init>	(J)V
    //   1270: invokevirtual 1032	java/lang/Long:toString	()Ljava/lang/String;
    //   1273: aload 12
    //   1275: getfield 1035	friendlist/stFavoriteGroup:dwOpenTimestamp	J
    //   1278: invokestatic 807	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1281: invokeinterface 1041 3 0
    //   1286: pop
    //   1287: lload 8
    //   1289: ldc2_w 1042
    //   1292: land
    //   1293: ldc2_w 1042
    //   1296: lcmp
    //   1297: ifne -82 -> 1215
    //   1300: aload 13
    //   1302: aload 12
    //   1304: getfield 1028	friendlist/stFavoriteGroup:dwGroupCode	J
    //   1307: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1310: invokeinterface 1046 2 0
    //   1315: pop
    //   1316: goto -101 -> 1215
    //   1319: aload 10
    //   1321: invokevirtual 1048	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   1324: iload 5
    //   1326: ifeq +10 -> 1336
    //   1329: aload_0
    //   1330: getstatic 190	com/tencent/mobileqq/app/TroopHandler:an	I
    //   1333: invokevirtual 488	com/tencent/mobileqq/app/TroopHandler:a	(I)V
    //   1336: aload 10
    //   1338: ifnull -481 -> 857
    //   1341: aload 10
    //   1343: invokevirtual 972	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1346: goto -489 -> 857
    //   1349: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1352: ifeq +12 -> 1364
    //   1355: ldc 63
    //   1357: iconst_2
    //   1358: ldc_w 1050
    //   1361: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1364: aload_0
    //   1365: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1368: bipush 44
    //   1370: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1373: checkcast 872	com/tencent/mobileqq/app/TroopManager
    //   1376: astore_1
    //   1377: aload_0
    //   1378: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1381: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1384: new 240	java/lang/StringBuilder
    //   1387: dup
    //   1388: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1391: aload_0
    //   1392: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1395: invokevirtual 1055	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1398: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: ldc_w 1057
    //   1404: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1410: iconst_0
    //   1411: invokevirtual 737	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1414: invokeinterface 743 1 0
    //   1419: ldc_w 1059
    //   1422: iconst_0
    //   1423: invokeinterface 1063 3 0
    //   1428: invokeinterface 763 1 0
    //   1433: pop
    //   1434: aload_0
    //   1435: iconst_1
    //   1436: iconst_1
    //   1437: aconst_null
    //   1438: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1441: return
    //   1442: astore_1
    //   1443: aconst_null
    //   1444: astore 10
    //   1446: goto -547 -> 899
    //   1449: astore_2
    //   1450: aload_1
    //   1451: astore 10
    //   1453: aload_2
    //   1454: astore_1
    //   1455: goto -556 -> 899
    //   1458: astore 10
    //   1460: aload 11
    //   1462: astore_1
    //   1463: goto -637 -> 826
    //   1466: iload_3
    //   1467: iconst_1
    //   1468: iadd
    //   1469: istore_3
    //   1470: goto -1132 -> 338
    //   1473: iconst_1
    //   1474: istore_3
    //   1475: goto -722 -> 753
    //   1478: iload 4
    //   1480: iconst_1
    //   1481: iadd
    //   1482: istore 4
    //   1484: goto -999 -> 485
    //   1487: iconst_0
    //   1488: istore 5
    //   1490: goto -953 -> 537
    //   1493: iconst_m1
    //   1494: istore_3
    //   1495: goto -330 -> 1165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1498	0	this	TroopHandler
    //   0	1498	1	paramToServiceMsg	ToServiceMsg
    //   0	1498	2	paramGetTroopListRespV2	GetTroopListRespV2
    //   132	1363	3	i1	int
    //   480	1003	4	i2	int
    //   286	1203	5	i3	int
    //   289	194	6	i4	int
    //   80	13	7	bool	boolean
    //   283	1005	8	l1	long
    //   116	1336	10	localObject1	Object
    //   1458	1	10	localException1	Exception
    //   292	518	11	localObject2	Object
    //   817	6	11	localException2	Exception
    //   966	495	11	localObject3	Object
    //   278	1025	12	localObject4	Object
    //   301	1000	13	localArrayList	ArrayList
    //   315	750	14	localTroopManager	TroopManager
    //   360	578	15	localObject5	Object
    //   947	210	16	localstGroupRankInfo	friendlist.stGroupRankInfo
    // Exception table:
    //   from	to	target	type
    //   324	336	817	java/lang/Exception
    //   338	426	817	java/lang/Exception
    //   426	454	817	java/lang/Exception
    //   459	469	817	java/lang/Exception
    //   472	479	817	java/lang/Exception
    //   488	529	817	java/lang/Exception
    //   542	564	817	java/lang/Exception
    //   564	704	817	java/lang/Exception
    //   709	716	817	java/lang/Exception
    //   716	750	817	java/lang/Exception
    //   753	804	817	java/lang/Exception
    //   807	814	817	java/lang/Exception
    //   881	895	817	java/lang/Exception
    //   911	927	817	java/lang/Exception
    //   927	964	817	java/lang/Exception
    //   973	995	817	java/lang/Exception
    //   995	1165	817	java/lang/Exception
    //   1165	1181	817	java/lang/Exception
    //   1184	1215	817	java/lang/Exception
    //   1215	1244	817	java/lang/Exception
    //   1257	1287	817	java/lang/Exception
    //   1300	1316	817	java/lang/Exception
    //   1319	1324	817	java/lang/Exception
    //   1329	1336	817	java/lang/Exception
    //   324	336	898	finally
    //   338	426	898	finally
    //   426	454	898	finally
    //   459	469	898	finally
    //   472	479	898	finally
    //   488	529	898	finally
    //   542	564	898	finally
    //   564	704	898	finally
    //   709	716	898	finally
    //   716	750	898	finally
    //   753	804	898	finally
    //   807	814	898	finally
    //   881	895	898	finally
    //   911	927	898	finally
    //   927	964	898	finally
    //   973	995	898	finally
    //   995	1165	898	finally
    //   1165	1181	898	finally
    //   1184	1215	898	finally
    //   1215	1244	898	finally
    //   1257	1287	898	finally
    //   1300	1316	898	finally
    //   1319	1324	898	finally
    //   1329	1336	898	finally
    //   303	324	1442	finally
    //   826	849	1449	finally
    //   303	324	1458	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopMemberListResp paramGetTroopMemberListResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "FriendListHandler.handleGetTroopMemberList, resp.result: " + paramGetTroopMemberListResp.result + " member count: " + paramGetTroopMemberListResp.vecTroopMember.size());
    }
    long l3 = paramToServiceMsg.extraData.getLong("troop_time");
    String str1;
    int i1;
    EntityManager localEntityManager;
    EntityTransaction localEntityTransaction;
    Object localObject;
    stTroopMemberInfo localstTroopMemberInfo;
    if (paramGetTroopMemberListResp != null)
    {
      long l1 = paramGetTroopMemberListResp.GroupUin;
      paramGetTroopMemberListResp.GroupUin = paramGetTroopMemberListResp.GroupCode;
      paramGetTroopMemberListResp.GroupCode = l1;
      str1 = a(paramGetTroopMemberListResp.GroupUin);
      if (paramGetTroopMemberListResp.result != 1)
      {
        i1 = paramGetTroopMemberListResp.vecTroopMember.size();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localEntityTransaction = localEntityManager.a();
        localEntityTransaction.a();
        for (;;)
        {
          try
          {
            localObject = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { str1, "0" }, null, null, null, null);
            if ((localObject == null) || (((List)localObject).size() <= 0)) {
              break label1665;
            }
            localObject = (TroopMemberInfo)((List)localObject).get(0);
            if (localObject == null)
            {
              localObject = new TroopMemberInfo();
              ((TroopMemberInfo)localObject).troopuin = str1;
              ((TroopMemberInfo)localObject).memberuin = "0";
              ((TroopMemberInfo)localObject).datetime = l3;
              localEntityManager.a((Entity)localObject);
              ChnToSpell.a(BaseApplication.getContext());
              Iterator localIterator = paramGetTroopMemberListResp.vecTroopMember.iterator();
              if (!localIterator.hasNext()) {
                break label1411;
              }
              localstTroopMemberInfo = (stTroopMemberInfo)localIterator.next();
              long l2 = localstTroopMemberInfo.MemberUin;
              l1 = l2;
              if (l2 < 0L) {
                l1 = localstTroopMemberInfo.MemberUin + 4294967296L;
              }
              String str2 = String.valueOf(l1);
              localObject = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { str1, str2 }, null, null, null, null);
              if ((localObject == null) || (((List)localObject).size() <= 0)) {
                break label1659;
              }
              localObject = (TroopMemberInfo)((List)localObject).get(0);
              label374:
              if (localObject != null) {
                break;
              }
              localObject = new TroopMemberInfo();
              ((TroopMemberInfo)localObject).troopuin = str1;
              ((TroopMemberInfo)localObject).memberuin = str2;
              ((TroopMemberInfo)localObject).friendnick = localstTroopMemberInfo.Nick;
              ((TroopMemberInfo)localObject).pyFirst_friendnick = ChnToSpell.a(((TroopMemberInfo)localObject).friendnick, 2);
              ((TroopMemberInfo)localObject).pyAll_friendnick = ChnToSpell.a(((TroopMemberInfo)localObject).friendnick, 1);
              ((TroopMemberInfo)localObject).troopnick = localstTroopMemberInfo.sName;
              ((TroopMemberInfo)localObject).pyFirst_troopnick = ChnToSpell.a(((TroopMemberInfo)localObject).troopnick, 2);
              ((TroopMemberInfo)localObject).pyAll_troopnick = ChnToSpell.a(((TroopMemberInfo)localObject).troopnick, 1);
              ((TroopMemberInfo)localObject).autoremark = localstTroopMemberInfo.strAutoRemark;
              ((TroopMemberInfo)localObject).faceid = localstTroopMemberInfo.FaceId;
              ((TroopMemberInfo)localObject).sex = localstTroopMemberInfo.Gender;
              ((TroopMemberInfo)localObject).status = localstTroopMemberInfo.Status;
              ((TroopMemberInfo)localObject).age = localstTroopMemberInfo.Age;
              ((TroopMemberInfo)localObject).alias = localstTroopMemberInfo.sShowName;
              ((TroopMemberInfo)localObject).datetime = l3;
              ((TroopMemberInfo)localObject).qqVipInfo = 0;
              ((TroopMemberInfo)localObject).superQqInfo = 0;
              ((TroopMemberInfo)localObject).superVipInfo = 0;
              ((TroopMemberInfo)localObject).level = ((int)localstTroopMemberInfo.dwMemberLevel);
              ((TroopMemberInfo)localObject).join_time = localstTroopMemberInfo.dwJoinTime;
              ((TroopMemberInfo)localObject).last_active_time = localstTroopMemberInfo.dwLastSpeakTime;
              ((TroopMemberInfo)localObject).active_point = localstTroopMemberInfo.dwPoint;
              ((TroopMemberInfo)localObject).credit_level = localstTroopMemberInfo.dwCreditLevel;
              if (localstTroopMemberInfo.cConcerned != 1) {
                break label1671;
              }
              bool = true;
              label626:
              ((TroopMemberInfo)localObject).isTroopFollowed = bool;
              localEntityManager.a((Entity)localObject);
              label640:
              TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, str2);
              localObject = localTroopMemberCardInfo;
              if (localTroopMemberCardInfo == null)
              {
                localObject = new TroopMemberCardInfo();
                ((TroopMemberCardInfo)localObject).troopuin = str1;
                ((TroopMemberCardInfo)localObject).memberuin = str2;
              }
              ((TroopMemberCardInfo)localObject).nick = localstTroopMemberInfo.Nick;
              ((TroopMemberCardInfo)localObject).name = localstTroopMemberInfo.sName;
              ((TroopMemberCardInfo)localObject).sex = localstTroopMemberInfo.cGender;
              ((TroopMemberCardInfo)localObject).tel = localstTroopMemberInfo.sPhone;
              ((TroopMemberCardInfo)localObject).email = localstTroopMemberInfo.sEmail;
              ((TroopMemberCardInfo)localObject).memo = localstTroopMemberInfo.sMemo;
              DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (TroopMemberCardInfo)localObject);
              continue;
            }
            ((TroopMemberInfo)localObject).datetime = l3;
          }
          finally
          {
            localEntityTransaction.b();
          }
          localEntityManager.a((Entity)localObject);
        }
        if ((localstTroopMemberInfo.Nick == null) || (localstTroopMemberInfo.Nick.length() == 0))
        {
          ((TroopMemberInfo)localObject).pyFirst_friendnick = "";
          ((TroopMemberInfo)localObject).pyAll_friendnick = "";
          label825:
          ((TroopMemberInfo)localObject).friendnick = localstTroopMemberInfo.Nick;
          if ((localstTroopMemberInfo.sName != null) && (localstTroopMemberInfo.sName.length() != 0)) {
            break label1179;
          }
          ((TroopMemberInfo)localObject).pyFirst_troopnick = "";
          ((TroopMemberInfo)localObject).pyAll_troopnick = "";
          label870:
          ((TroopMemberInfo)localObject).troopnick = localstTroopMemberInfo.sName;
          if ((localstTroopMemberInfo.strAutoRemark != null) && (localstTroopMemberInfo.strAutoRemark.length() != 0)) {
            break label1295;
          }
          ((TroopMemberInfo)localObject).pyFirst_autoremark = "";
          ((TroopMemberInfo)localObject).pyAll_autoremark = "";
          label915:
          ((TroopMemberInfo)localObject).autoremark = localstTroopMemberInfo.strAutoRemark;
          ((TroopMemberInfo)localObject).faceid = localstTroopMemberInfo.FaceId;
          ((TroopMemberInfo)localObject).sex = localstTroopMemberInfo.Gender;
          ((TroopMemberInfo)localObject).status = localstTroopMemberInfo.Status;
          ((TroopMemberInfo)localObject).age = localstTroopMemberInfo.Age;
          ((TroopMemberInfo)localObject).alias = localstTroopMemberInfo.sShowName;
          ((TroopMemberInfo)localObject).datetime = l3;
          ((TroopMemberInfo)localObject).level = ((int)localstTroopMemberInfo.dwMemberLevel);
          ((TroopMemberInfo)localObject).join_time = localstTroopMemberInfo.dwJoinTime;
          ((TroopMemberInfo)localObject).last_active_time = localstTroopMemberInfo.dwLastSpeakTime;
          ((TroopMemberInfo)localObject).active_point = localstTroopMemberInfo.dwPoint;
          ((TroopMemberInfo)localObject).credit_level = localstTroopMemberInfo.dwCreditLevel;
          if (localstTroopMemberInfo.cConcerned != 1) {
            break label1677;
          }
        }
      }
    }
    label1411:
    label1671:
    label1677:
    for (boolean bool = true;; bool = false)
    {
      ((TroopMemberInfo)localObject).isTroopFollowed = bool;
      localEntityManager.a((Entity)localObject);
      break label640;
      if (!localstTroopMemberInfo.Nick.equals(((TroopMemberInfo)localObject).friendnick))
      {
        ((TroopMemberInfo)localObject).pyFirst_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 2);
        ((TroopMemberInfo)localObject).pyAll_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 1);
        break label825;
      }
      if ((((TroopMemberInfo)localObject).pyFirst_friendnick == null) || (((TroopMemberInfo)localObject).pyFirst_friendnick.length() == 0)) {
        ((TroopMemberInfo)localObject).pyFirst_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 2);
      }
      if ((((TroopMemberInfo)localObject).pyAll_friendnick != null) && (((TroopMemberInfo)localObject).pyAll_friendnick.length() != 0)) {
        break label825;
      }
      ((TroopMemberInfo)localObject).pyAll_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 1);
      break label825;
      label1179:
      if (!localstTroopMemberInfo.sName.equals(((TroopMemberInfo)localObject).troopnick))
      {
        ((TroopMemberInfo)localObject).pyFirst_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 2);
        ((TroopMemberInfo)localObject).pyAll_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 1);
        break label870;
      }
      if ((((TroopMemberInfo)localObject).pyFirst_troopnick == null) || (((TroopMemberInfo)localObject).pyFirst_troopnick.length() == 0)) {
        ((TroopMemberInfo)localObject).pyFirst_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 2);
      }
      if ((((TroopMemberInfo)localObject).pyAll_troopnick != null) && (((TroopMemberInfo)localObject).pyAll_troopnick.length() != 0)) {
        break label870;
      }
      ((TroopMemberInfo)localObject).pyAll_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 1);
      break label870;
      label1295:
      if (!localstTroopMemberInfo.strAutoRemark.equals(((TroopMemberInfo)localObject).autoremark))
      {
        ((TroopMemberInfo)localObject).pyFirst_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 2);
        ((TroopMemberInfo)localObject).pyAll_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 1);
        break label915;
      }
      if ((((TroopMemberInfo)localObject).pyFirst_autoremark == null) || (((TroopMemberInfo)localObject).pyFirst_autoremark.length() == 0)) {
        ((TroopMemberInfo)localObject).pyFirst_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 2);
      }
      if ((((TroopMemberInfo)localObject).pyAll_autoremark != null) && (((TroopMemberInfo)localObject).pyAll_autoremark.length() != 0)) {
        break label915;
      }
      ((TroopMemberInfo)localObject).pyAll_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 1);
      break label915;
      localEntityTransaction.c();
      localEntityTransaction.b();
      if (paramGetTroopMemberListResp.NextUin != 0L)
      {
        paramToServiceMsg.extraData.putBoolean("force_refresh", true);
        paramToServiceMsg.extraData.putLong("nextuin", paramGetTroopMemberListResp.NextUin);
        paramToServiceMsg.extraData.putLong("troop_time", l3);
        paramGetTroopMemberListResp = new UniPacket(true);
        paramGetTroopMemberListResp.setEncodeName("utf-8");
        if (a(paramToServiceMsg, paramGetTroopMemberListResp))
        {
          paramToServiceMsg.setServiceName("mobileqq.service");
          paramToServiceMsg.setRequestSsoSeq(paramGetTroopMemberListResp.getRequestId());
          paramToServiceMsg.putWupBuffer(paramGetTroopMemberListResp.encode());
          a(paramToServiceMsg);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("get_troop_member", 2, "FriendListHandler.handleGetTroopMemberList, request the next page data");
          }
          a(40, false, Integer.valueOf(i1));
          return;
          a(4, false, null);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new TroopMemberInfo().getTableName(), "troopuin=? and memberuin<>? and memberuin<>? and datetime<?", new String[] { str1, "1000000", "10000", String.valueOf(l3) });
      }
      a(40, true, Integer.valueOf(i1));
      localEntityManager.a();
      ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b();
      a(4, true, null);
      return;
      label1659:
      localObject = null;
      break label374;
      localObject = null;
      break;
      bool = false;
      break label626;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopRemarkResp paramGetTroopRemarkResp)
  {
    long l1 = paramGetTroopRemarkResp.GroupUin;
    paramGetTroopRemarkResp.GroupUin = paramGetTroopRemarkResp.GroupCode;
    paramGetTroopRemarkResp.GroupCode = l1;
    String str1 = a(paramGetTroopRemarkResp.GroupUin);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg.getUin()).createEntityManager();
    Object localObject = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { str1, "0" }, null, null, null, null);
    if (localObject != null) {}
    for (localObject = (TroopMemberInfo)((List)localObject).get(0);; localObject = null)
    {
      EntityTransaction localEntityTransaction;
      if (localObject == null)
      {
        localObject = new TroopMemberInfo();
        ((TroopMemberInfo)localObject).troopuin = str1;
        ((TroopMemberInfo)localObject).memberuin = "0";
        ((TroopMemberInfo)localObject).datetime = System.currentTimeMillis();
        localEntityManager.a((Entity)localObject);
        localEntityTransaction = localEntityManager.a();
        localEntityTransaction.a();
      }
      for (;;)
      {
        stTroopRemarkInfo localstTroopRemarkInfo;
        try
        {
          Iterator localIterator = paramGetTroopRemarkResp.vecTroopRemark.iterator();
          if (!localIterator.hasNext()) {
            break label397;
          }
          localstTroopRemarkInfo = (stTroopRemarkInfo)localIterator.next();
          long l2 = localstTroopRemarkInfo.MemberUin;
          l1 = l2;
          if (l2 < 0L) {
            l1 = localstTroopRemarkInfo.MemberUin + 4294967296L;
          }
          String str2 = String.valueOf(l1);
          localObject = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { str1, str2 }, null, null, null, null);
          if (localObject == null) {
            break label516;
          }
          localObject = (TroopMemberInfo)((List)localObject).get(0);
          if (localObject != null) {
            break label358;
          }
          localObject = new TroopMemberInfo();
          ((TroopMemberInfo)localObject).troopuin = str1;
          ((TroopMemberInfo)localObject).memberuin = str2;
          ((TroopMemberInfo)localObject).troopnick = localstTroopRemarkInfo.strNick;
          ((TroopMemberInfo)localObject).troopremark = localstTroopRemarkInfo.strRemark;
          ((TroopMemberInfo)localObject).datetime = System.currentTimeMillis();
          localEntityManager.a((Entity)localObject);
          continue;
          ((TroopMemberInfo)localObject).datetime = System.currentTimeMillis();
        }
        finally
        {
          localEntityTransaction.b();
        }
        localEntityManager.a((Entity)localObject);
        break;
        label358:
        ((TroopMemberInfo)localObject).troopnick = localstTroopRemarkInfo.strNick;
        ((TroopMemberInfo)localObject).troopremark = localstTroopRemarkInfo.strRemark;
        ((TroopMemberInfo)localObject).datetime = System.currentTimeMillis();
        localEntityManager.a((Entity)localObject);
        continue;
        label397:
        localEntityTransaction.c();
        localEntityTransaction.b();
        localEntityManager.a();
        if (paramGetTroopRemarkResp.NextUin != 0L)
        {
          paramToServiceMsg.extraData.putBoolean("force_refresh", true);
          paramToServiceMsg.extraData.putLong("nextuin", paramGetTroopRemarkResp.NextUin);
          paramGetTroopRemarkResp = new UniPacket(true);
          paramGetTroopRemarkResp.setEncodeName("utf-8");
          if (b(paramToServiceMsg, paramGetTroopRemarkResp))
          {
            paramToServiceMsg.setServiceName("mobileqq.service");
            paramToServiceMsg.setRequestSsoSeq(paramGetTroopRemarkResp.getRequestId());
            paramToServiceMsg.putWupBuffer(paramGetTroopRemarkResp.encode());
            a(paramToServiceMsg);
            return;
          }
          a(3, false, null);
          return;
        }
        a(3, true, null);
        return;
        label516:
        localObject = null;
      }
    }
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      a(44, false, new Object[] { paramString, Integer.valueOf(2), null });
    }
    int i1;
    do
    {
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(44, false, new Object[] { paramString, Integer.valueOf(2), null });
        return;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()))
        {
          a(44, false, new Object[] { paramString, Integer.valueOf(2), null });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(44, false, new Object[] { paramString, Integer.valueOf(2), null });
        return;
      }
      i1 = paramFromServiceMsg.uint32_result.get();
      if (i1 == 0)
      {
        long l1 = paramToServiceMsg.extraData.getLong("troopUin");
        paramToServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
        paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramObject = Long.toString(l1);
        byte b1 = -100;
        if (paramString.equals("OidbSvc.0x8bb_2")) {
          b1 = 1;
        }
        while (paramFromServiceMsg != null)
        {
          i1 = 0;
          while (i1 < paramToServiceMsg.length)
          {
            String str = Long.toString(paramToServiceMsg[i1]);
            if ((!TextUtils.isEmpty(paramObject)) && (!TextUtils.isEmpty(str))) {
              paramFromServiceMsg.a(paramObject, str, null, -100, null, null, -100, -100, -100, -100L, b1, -100L, -100.0D);
            }
            i1 += 1;
          }
          if (paramString.equals("OidbSvc.0x8bb_3")) {
            b1 = 0;
          }
        }
        a(44, true, new Object[] { paramString, Integer.valueOf(1), paramToServiceMsg });
        return;
      }
      if (i1 == 65)
      {
        a(44, false, new Object[] { paramString, Integer.valueOf(3), null });
        return;
      }
    } while (i1 != 66);
    a(44, false, new Object[] { paramString, Integer.valueOf(4), null });
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    GetTroopMemberListReq localGetTroopMemberListReq = new GetTroopMemberListReq();
    localGetTroopMemberListReq.uin = l1;
    localGetTroopMemberListReq.GroupCode = paramToServiceMsg.getLong("troop_uin");
    localGetTroopMemberListReq.GroupUin = paramToServiceMsg.getLong("troop_code");
    localGetTroopMemberListReq.NextUin = paramToServiceMsg.getLong("nextuin");
    paramToServiceMsg.getBoolean("force_refresh");
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopMemberListReq");
    paramUniPacket.put("GTML", localGetTroopMemberListReq);
    return true;
  }
  
  private long b(String paramString)
  {
    try
    {
      long l1 = Long.valueOf(paramString).longValue();
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    cww localcww = new cww();
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramFromServiceMsg.isSuccess()) {
      try
      {
        paramFromServiceMsg = new SearchGroup.SearchGroupRes();
      }
      catch (Exception paramFromServiceMsg)
      {
        label140:
        label233:
        paramFromServiceMsg = localObject1;
      }
    }
    try
    {
      paramFromServiceMsg.mergeFrom(paramArrayOfByte);
      localcww.jdField_a_of_type_Int = paramFromServiceMsg.dwResult.get();
      localcww.jdField_a_of_type_JavaLangString = paramFromServiceMsg.sErrInfo.get();
      if (localcww.jdField_a_of_type_Int != 0) {
        break label326;
      }
      paramArrayOfByte = (SearchGroup.GroupClusterInfo)paramFromServiceMsg.stGroupClusterInfo.get();
      if (paramArrayOfByte.dwIsEnd.get() != 1) {
        break label233;
      }
      bool = true;
      localcww.jdField_a_of_type_Boolean = bool;
      localcww.b = paramArrayOfByte.dwTotalSearchNum.get();
      localcww.jdField_a_of_type_Long = paramFromServiceMsg.dwNextRecTime.get();
      localcww.jdField_a_of_type_JavaUtilList = paramArrayOfByte.vGroupInfo.get();
      bool = true;
    }
    catch (Exception paramArrayOfByte)
    {
      label243:
      break label243;
      label285:
      bool = false;
      break label140;
    }
    if (paramIntent.getIntExtra("searchType", 0) == 8)
    {
      if (bool) {}
      a(28, bool, localcww);
      if (paramFromServiceMsg != null) {
        if (NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()) != 1) {
          break label285;
        }
      }
      for (paramIntent = new String[] { "param_WIFIRecommendTroopDownload", "param_WIFIFlow", "param_Flow" };; paramIntent = new String[] { "param_XGRecommendTroopDownload", "param_XGFlow", "param_Flow" })
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramIntent, paramFromServiceMsg.getSerializedSize());
        return;
        bool = false;
        break;
        localcww.jdField_a_of_type_Int = -1;
        localcww.jdField_a_of_type_Boolean = true;
        bool = false;
        break label140;
        localcww.jdField_a_of_type_Int = paramFromServiceMsg.getResultCode();
        localcww.jdField_a_of_type_Boolean = true;
        bool = false;
        paramFromServiceMsg = localObject2;
        break label140;
      }
    }
    a(13, bool, localcww);
  }
  
  private void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      a(43, false, new Object[] { Integer.valueOf(2), null });
    }
    for (;;)
    {
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(43, false, new Object[] { Integer.valueOf(2), null });
        return;
      }
      paramString = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramString = (oidb_sso.OIDBSSOPkg)paramString.mergeFrom((byte[])paramObject);
        if ((paramString == null) || (!paramString.uint32_result.has()) || (paramString.uint32_result.get() != 0) || (!paramString.bytes_bodybuffer.has()) || (paramString.bytes_bodybuffer.get() == null))
        {
          a(43, false, new Object[] { Integer.valueOf(2), null });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        a(43, false, new Object[] { Integer.valueOf(2), null });
        return;
      }
      paramToServiceMsg = new oidb_0x8a0.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom(paramString.bytes_bodybuffer.get().toByteArray());
        paramString = Long.toString(paramToServiceMsg.opt_uint64_group_code.get());
        paramFromServiceMsg = paramToServiceMsg.rpt_msg_kick_result.get();
        paramToServiceMsg = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (oidb_0x8a0.KickResult)paramFromServiceMsg.next();
          if (paramObject.opt_uint32_result.get() == 0) {
            paramToServiceMsg.add(Long.toString(paramObject.opt_uint64_member_uin.get()));
          }
        }
        if (paramToServiceMsg.size() <= 0) {}
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        a(43, false, new Object[] { Integer.valueOf(2), null });
        return;
      }
    }
    paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    paramObject = paramToServiceMsg.iterator();
    while (paramObject.hasNext()) {
      paramFromServiceMsg.a(paramString, (String)paramObject.next());
    }
    a(43, true, new Object[] { Integer.valueOf(1), paramToServiceMsg });
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {}
    GetTroopRemarkReq localGetTroopRemarkReq;
    do
    {
      return false;
      paramToServiceMsg = paramToServiceMsg.extraData;
      localGetTroopRemarkReq = new GetTroopRemarkReq();
      localGetTroopRemarkReq.uin = l1;
      localGetTroopRemarkReq.GroupCode = paramToServiceMsg.getLong("troop_code");
      localGetTroopRemarkReq.GroupUin = paramToServiceMsg.getLong("troop_uin");
    } while ((localGetTroopRemarkReq.GroupCode == 0L) || (localGetTroopRemarkReq.GroupUin == 0L));
    localGetTroopRemarkReq.NextUin = paramToServiceMsg.getLong("nextuin");
    localGetTroopRemarkReq.Seq = 0L;
    paramToServiceMsg.getBoolean("force_refresh");
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopRemarkReq");
    paramUniPacket.put("GTR", localGetTroopRemarkReq);
    return true;
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = -1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleTroopShareLink: start");
    }
    TroopShareResp localTroopShareResp = new TroopShareResp();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(0, false, localTroopShareResp);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handlerBindSubAccount: req == null || resp == null");
      }
      return;
    }
    localTroopShareResp.jdField_a_of_type_Boolean = paramToServiceMsg.extraData.getBoolean("isVerify");
    localTroopShareResp.jdField_a_of_type_JavaLangString = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() == 1000) {
      paramToServiceMsg = new join_group_link.RspBody();
    }
    for (;;)
    {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramToServiceMsg.error_code.has()) {
            i1 = paramToServiceMsg.error_code.get();
          }
          if (i1 == 0) {
            bool1 = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          bool1 = false;
        }
        try
        {
          if (paramToServiceMsg.group_code.has()) {
            localTroopShareResp.jdField_a_of_type_JavaLangString = String.valueOf(paramToServiceMsg.group_code.get());
          }
          bool2 = bool1;
          if (paramToServiceMsg.url.has())
          {
            localTroopShareResp.b = paramToServiceMsg.url.get();
            bool2 = bool1;
          }
          a(0, bool2, localTroopShareResp);
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler", 2, "handleTroopShareLink.errCode:" + localTroopShareResp.jdField_a_of_type_Int + "　troopUin:" + localTroopShareResp.jdField_a_of_type_JavaLangString + " isVerify:" + localTroopShareResp.jdField_a_of_type_Boolean + " shareUrl:" + localTroopShareResp.b);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopHandler", 2, "handleTroopShareLink: end");
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          label321:
          break label321;
        }
      }
      localTroopShareResp.jdField_a_of_type_Int = i1;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handleTroopShareLink: RspBody parseFrom byte InvalidProtocolBufferMicroException");
      }
      paramToServiceMsg.printStackTrace();
      bool2 = bool1;
      continue;
      localTroopShareResp.jdField_a_of_type_Int = -1;
      bool2 = false;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troop_code");
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        label290:
        paramToServiceMsg = null;
      }
      for (;;)
      {
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = paramFromServiceMsg;
          if (paramToServiceMsg != null) {
            paramToServiceMsg.uint32_result.get();
          }
          if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          continue;
        }
        try
        {
          paramFromServiceMsg = new oidb_0x88d.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          paramToServiceMsg = paramFromServiceMsg.stzrspgroupinfo.get();
          if (paramToServiceMsg != null) {
            continue;
          }
          i1 = 0;
          if (i1 > 0)
          {
            paramToServiceMsg = (oidb_0x88d.RspGroupInfo)paramToServiceMsg.get(0);
            if ((paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.uint64_group_code.has()) && (paramToServiceMsg.uint64_group_code.get() == Long.parseLong(str)) && (paramToServiceMsg.stgroupinfo.has()))
            {
              paramObject = (oidb_0x88d.GroupInfo)paramToServiceMsg.stgroupinfo.get();
              if (paramObject.uint32_group_admin_max_num.has())
              {
                FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
                paramFromServiceMsg = localFriendsManagerImp.a(str);
                paramToServiceMsg = paramFromServiceMsg;
                if (paramFromServiceMsg == null)
                {
                  paramToServiceMsg = new TroopInfo();
                  paramToServiceMsg.troopuin = str;
                }
                paramToServiceMsg.maxAdminNum = paramObject.uint32_group_admin_max_num.get();
                localFriendsManagerImp.b(paramToServiceMsg);
                a(26, true, new Object[] { str, Integer.valueOf(paramObject.uint32_group_admin_max_num.get()) });
              }
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            break label290;
          }
          QLog.i("TroopHandler", 2, paramToServiceMsg.toString());
          break label290;
        }
      }
      a(26, false, null);
      return;
      paramFromServiceMsg.printStackTrace();
      continue;
      int i1 = paramToServiceMsg.size();
    }
  }
  
  /* Error */
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 11
    //   6: aconst_null
    //   7: astore 16
    //   9: aconst_null
    //   10: astore 17
    //   12: aconst_null
    //   13: astore 18
    //   15: aload_1
    //   16: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   19: ldc_w 659
    //   22: invokevirtual 794	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   25: lstore 12
    //   27: aload_1
    //   28: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 1641
    //   34: invokevirtual 657	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   37: istore 9
    //   39: iconst_m1
    //   40: istore 4
    //   42: iload 4
    //   44: istore 5
    //   46: aload_2
    //   47: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   50: sipush 1000
    //   53: if_icmpne +782 -> 835
    //   56: new 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   59: dup
    //   60: invokespecial 1358	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: aload_3
    //   66: checkcast 1359	[B
    //   69: checkcast 1359	[B
    //   72: invokevirtual 1360	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   75: checkcast 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: astore_2
    //   79: aload_2
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +53 -> 135
    //   85: aload_1
    //   86: getfield 1364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   92: istore 5
    //   94: iload 5
    //   96: istore 4
    //   98: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +34 -> 135
    //   104: ldc 63
    //   106: iconst_2
    //   107: new 240	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 1643
    //   117: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload 5
    //   122: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iload 5
    //   133: istore 4
    //   135: iload 4
    //   137: istore 5
    //   139: aload_1
    //   140: ifnull +695 -> 835
    //   143: iload 4
    //   145: istore 5
    //   147: aload_1
    //   148: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   151: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   154: ifeq +681 -> 835
    //   157: iload 4
    //   159: istore 5
    //   161: aload_1
    //   162: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   165: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: ifnull +667 -> 835
    //   171: aload_1
    //   172: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   175: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   178: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   181: astore_1
    //   182: new 1613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   185: dup
    //   186: invokespecial 1614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   189: astore_3
    //   190: aload_3
    //   191: aload_1
    //   192: invokevirtual 1615	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   195: pop
    //   196: iload 4
    //   198: ifeq +632 -> 830
    //   201: aload_3
    //   202: getfield 1646	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   205: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   208: ifeq +622 -> 830
    //   211: aload_3
    //   212: getfield 1646	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   218: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   221: invokestatic 731	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   224: astore_1
    //   225: aconst_null
    //   226: astore_2
    //   227: iload 4
    //   229: istore 5
    //   231: aload_3
    //   232: getfield 1618	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   235: invokevirtual 1474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   238: astore_3
    //   239: aload_3
    //   240: ifnonnull +123 -> 363
    //   243: iconst_0
    //   244: istore 7
    //   246: goto +599 -> 845
    //   249: aload_2
    //   250: ifnonnull +189 -> 439
    //   253: iload 8
    //   255: iload 7
    //   257: if_icmpge +182 -> 439
    //   260: iload 4
    //   262: istore 5
    //   264: aload_3
    //   265: iload 8
    //   267: invokeinterface 1086 2 0
    //   272: checkcast 1620	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   275: astore 18
    //   277: iload 4
    //   279: istore 6
    //   281: aload 18
    //   283: ifnull +540 -> 823
    //   286: iload 4
    //   288: istore 5
    //   290: aload 18
    //   292: getfield 1624	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   295: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   298: lstore 14
    //   300: lload 14
    //   302: lload 12
    //   304: lcmp
    //   305: ifeq +73 -> 378
    //   308: iload 8
    //   310: iconst_1
    //   311: iadd
    //   312: istore 8
    //   314: goto -65 -> 249
    //   317: astore_2
    //   318: aconst_null
    //   319: astore_1
    //   320: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +33 -> 356
    //   326: ldc_w 1648
    //   329: iconst_2
    //   330: new 240	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 1650
    //   340: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_2
    //   344: invokevirtual 1651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   347: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload_2
    //   357: invokevirtual 1611	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   360: goto -279 -> 81
    //   363: iload 4
    //   365: istore 5
    //   367: aload_3
    //   368: invokeinterface 1085 1 0
    //   373: istore 7
    //   375: goto +470 -> 845
    //   378: iload 4
    //   380: istore 5
    //   382: aload 18
    //   384: getfield 1621	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   387: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   390: istore 4
    //   392: iload 4
    //   394: istore 6
    //   396: iload 4
    //   398: ifne +425 -> 823
    //   401: iload 4
    //   403: istore 5
    //   405: iload 4
    //   407: istore 6
    //   409: aload 18
    //   411: getfield 1628	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   414: invokevirtual 1631	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   417: ifeq +406 -> 823
    //   420: iload 4
    //   422: istore 5
    //   424: aload 18
    //   426: getfield 1628	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   429: invokevirtual 1632	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   432: checkcast 1630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   435: astore_2
    //   436: goto -128 -> 308
    //   439: aload_2
    //   440: ifnull +374 -> 814
    //   443: iconst_1
    //   444: istore 11
    //   446: aload 17
    //   448: astore_3
    //   449: aload_0
    //   450: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   453: bipush 8
    //   455: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   458: checkcast 329	com/tencent/mobileqq/app/FriendsManagerImp
    //   461: lload 12
    //   463: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   466: invokevirtual 337	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   469: astore 16
    //   471: aload 16
    //   473: ifnonnull +335 -> 808
    //   476: new 339	com/tencent/mobileqq/data/TroopInfo
    //   479: dup
    //   480: invokespecial 390	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   483: astore 17
    //   485: aload 17
    //   487: astore_3
    //   488: aload 17
    //   490: lload 12
    //   492: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   495: putfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   498: aload 17
    //   500: astore_3
    //   501: aload_2
    //   502: getfield 1654	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   505: invokevirtual 1369	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   508: ifeq +50 -> 558
    //   511: aload_3
    //   512: aload_2
    //   513: getfield 1654	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   516: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   519: i2l
    //   520: putfield 435	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   523: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +32 -> 558
    //   529: ldc 63
    //   531: iconst_2
    //   532: new 240	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   539: ldc_w 1656
    //   542: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload_3
    //   546: getfield 576	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   549: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   552: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: aload_3
    //   559: astore 16
    //   561: iload 11
    //   563: istore 10
    //   565: aload_2
    //   566: getfield 1659	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   569: invokevirtual 1588	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   572: ifeq +82 -> 654
    //   575: aload_3
    //   576: new 240	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 331
    //   586: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_2
    //   590: getfield 1659	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   593: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   596: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: putfield 431	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   605: aload_3
    //   606: astore 16
    //   608: iload 11
    //   610: istore 10
    //   612: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +39 -> 654
    //   618: ldc 63
    //   620: iconst_2
    //   621: new 240	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 1661
    //   631: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload_3
    //   635: getfield 431	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   638: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: iload 11
    //   649: istore 10
    //   651: aload_3
    //   652: astore 16
    //   654: iload 10
    //   656: istore 11
    //   658: aload 16
    //   660: astore 17
    //   662: iload 4
    //   664: istore 5
    //   666: aload_1
    //   667: astore 16
    //   669: aload_0
    //   670: bipush 50
    //   672: iload 11
    //   674: iconst_5
    //   675: anewarray 606	java/lang/Object
    //   678: dup
    //   679: iconst_0
    //   680: lload 12
    //   682: invokestatic 807	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   685: aastore
    //   686: dup
    //   687: iconst_1
    //   688: iload 9
    //   690: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   693: aastore
    //   694: dup
    //   695: iconst_2
    //   696: aload 17
    //   698: aastore
    //   699: dup
    //   700: iconst_3
    //   701: iload 5
    //   703: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   706: aastore
    //   707: dup
    //   708: iconst_4
    //   709: aload 16
    //   711: aastore
    //   712: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   715: return
    //   716: astore_2
    //   717: aconst_null
    //   718: astore_1
    //   719: aload 16
    //   721: astore_3
    //   722: aload_1
    //   723: astore 16
    //   725: iload 4
    //   727: istore 5
    //   729: aload_3
    //   730: astore 17
    //   732: iload 10
    //   734: istore 11
    //   736: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq -70 -> 669
    //   742: ldc 63
    //   744: iconst_2
    //   745: aload_2
    //   746: invokevirtual 1639	java/lang/Exception:toString	()Ljava/lang/String;
    //   749: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: aload_1
    //   753: astore 16
    //   755: iload 4
    //   757: istore 5
    //   759: aload_3
    //   760: astore 17
    //   762: iload 10
    //   764: istore 11
    //   766: goto -97 -> 669
    //   769: astore_2
    //   770: iload 5
    //   772: istore 4
    //   774: aload 16
    //   776: astore_3
    //   777: goto -55 -> 722
    //   780: astore_2
    //   781: iconst_1
    //   782: istore 10
    //   784: goto -62 -> 722
    //   787: astore_2
    //   788: aload 16
    //   790: astore_3
    //   791: iconst_1
    //   792: istore 10
    //   794: goto -72 -> 722
    //   797: astore_2
    //   798: iconst_1
    //   799: istore 10
    //   801: goto -79 -> 722
    //   804: astore_2
    //   805: goto -485 -> 320
    //   808: aload 16
    //   810: astore_3
    //   811: goto -310 -> 501
    //   814: aconst_null
    //   815: astore 16
    //   817: iconst_0
    //   818: istore 10
    //   820: goto -166 -> 654
    //   823: iload 6
    //   825: istore 4
    //   827: goto -519 -> 308
    //   830: aconst_null
    //   831: astore_1
    //   832: goto -607 -> 225
    //   835: aconst_null
    //   836: astore 16
    //   838: aload 18
    //   840: astore 17
    //   842: goto -173 -> 669
    //   845: iconst_0
    //   846: istore 8
    //   848: goto -599 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	851	0	this	TroopHandler
    //   0	851	1	paramToServiceMsg	ToServiceMsg
    //   0	851	2	paramFromServiceMsg	FromServiceMsg
    //   0	851	3	paramObject	Object
    //   40	786	4	i1	int
    //   44	727	5	i2	int
    //   279	545	6	i3	int
    //   244	130	7	i4	int
    //   253	594	8	i5	int
    //   37	652	9	i6	int
    //   1	818	10	bool1	boolean
    //   4	761	11	bool2	boolean
    //   25	656	12	l1	long
    //   298	3	14	l2	long
    //   7	830	16	localObject1	Object
    //   10	831	17	localObject2	Object
    //   13	826	18	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    // Exception table:
    //   from	to	target	type
    //   56	64	317	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   182	196	716	java/lang/Exception
    //   201	225	716	java/lang/Exception
    //   231	239	769	java/lang/Exception
    //   264	277	769	java/lang/Exception
    //   290	300	769	java/lang/Exception
    //   367	375	769	java/lang/Exception
    //   382	392	769	java/lang/Exception
    //   409	420	769	java/lang/Exception
    //   424	436	769	java/lang/Exception
    //   449	471	780	java/lang/Exception
    //   488	498	780	java/lang/Exception
    //   476	485	787	java/lang/Exception
    //   501	558	797	java/lang/Exception
    //   565	605	797	java/lang/Exception
    //   612	647	797	java/lang/Exception
    //   64	79	804	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.extraData.getString("troop_uin");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
    paramObject = (ProfGroupInfoRes)paramObject;
    if (paramFromServiceMsg.isSuccess()) {
      if (paramObject.cResult == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg.getUin()) == null) {
          return;
        }
        paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramToServiceMsg = paramFromServiceMsg.a(String.valueOf(paramObject.uGroupCode));
        if (paramToServiceMsg != null) {
          break label505;
        }
        paramToServiceMsg = new TroopInfo();
        paramToServiceMsg.troopuin = String.valueOf(paramObject.uGroupCode);
      }
    }
    label437:
    label505:
    for (;;)
    {
      paramToServiceMsg.troopcode = String.valueOf(paramObject.uGroupUin);
      if ((paramToServiceMsg.troopcode == null) || (paramToServiceMsg.troopcode.equals("0"))) {
        a(ap);
      }
      paramToServiceMsg.troopowneruin = String.valueOf(paramObject.uGroupOwnerUin);
      paramToServiceMsg.troopname = paramObject.sGroupName;
      paramToServiceMsg.troopface = paramObject.wGroupFace;
      paramToServiceMsg.troopmemo = paramObject.sGroupMemo;
      if (paramObject.vAdministrator != null)
      {
        paramToServiceMsg.fingertroopmemo = paramObject.sFingerGroupMemo;
        localObject = new StringBuffer();
        Iterator localIterator = paramObject.vAdministrator.iterator();
        while (localIterator.hasNext())
        {
          GroupMemberFlag localGroupMemberFlag = (GroupMemberFlag)localIterator.next();
          if (localGroupMemberFlag.dwUin != 0L) {
            ((StringBuffer)localObject).append(String.valueOf(localGroupMemberFlag.dwUin) + "|");
          }
        }
        paramToServiceMsg.Administrator = ((StringBuffer)localObject).toString();
      }
      if (paramObject.cAlbumResult == 33)
      {
        paramToServiceMsg.cAlbumResult = paramObject.cAlbumResult;
        paramToServiceMsg.dwTimeStamp = 0L;
        paramToServiceMsg.updateQZonePhotoUrls(null);
        paramToServiceMsg.strLocation = paramObject.sGroupLocation;
        if (1 != paramObject.cInviteSwitchOpen) {
          break label437;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramToServiceMsg.mMemberInvitingFlag = bool;
        paramToServiceMsg.dwGroupFlagExt = paramObject.dwFlagExt;
        paramToServiceMsg.troopAuthenticateInfo = paramObject.sAuthGrpInfo;
        paramFromServiceMsg.b(paramToServiceMsg);
        a(8, true, paramObject.uGroupCode + "");
        return;
        if (paramObject.cAlbumResult != 0) {
          break;
        }
        paramToServiceMsg.cAlbumResult = paramObject.cAlbumResult;
        if (paramToServiceMsg.dwTimeStamp == paramObject.dwTimeStamp) {
          break;
        }
        paramToServiceMsg.dwTimeStamp = paramObject.dwTimeStamp;
        paramToServiceMsg.updateQZonePhotoUrls(paramObject.vsUrl);
        break;
      }
      if (paramObject.cResult != 5) {
        break;
      }
      paramToServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      paramFromServiceMsg = String.valueOf(paramObject.uGroupCode);
      if (paramToServiceMsg.a(paramFromServiceMsg) != null) {
        paramToServiceMsg.e(paramFromServiceMsg);
      }
      a(8, false, localObject);
      return;
      a(8, false, localObject);
      return;
    }
  }
  
  /* Error */
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 290	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +511 -> 515
    //   7: new 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   10: dup
    //   11: invokespecial 1358	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_3
    //   17: checkcast 1359	[B
    //   20: checkcast 1359	[B
    //   23: invokevirtual 1360	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   26: checkcast 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: iconst_m1
    //   33: istore 4
    //   35: aload_1
    //   36: ifnull +54 -> 90
    //   39: aload_1
    //   40: getfield 1364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   43: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   46: istore 5
    //   48: iload 5
    //   50: istore 4
    //   52: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +35 -> 90
    //   58: ldc_w 1732
    //   61: iconst_2
    //   62: new 240	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 1734
    //   72: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 5
    //   77: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: iload 5
    //   88: istore 4
    //   90: iload 4
    //   92: ifne +339 -> 431
    //   95: aload_1
    //   96: ifnull +335 -> 431
    //   99: aload_1
    //   100: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   106: ifeq +325 -> 431
    //   109: aload_1
    //   110: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: ifnull +315 -> 431
    //   119: aload_1
    //   120: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   129: astore_3
    //   130: aload_0
    //   131: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: bipush 8
    //   136: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   139: checkcast 329	com/tencent/mobileqq/app/FriendsManagerImp
    //   142: astore_2
    //   143: aload_2
    //   144: invokevirtual 1735	com/tencent/mobileqq/app/FriendsManagerImp:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   147: astore_1
    //   148: new 1737	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody
    //   151: dup
    //   152: invokespecial 1738	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody:<init>	()V
    //   155: astore 6
    //   157: aload 6
    //   159: aload_3
    //   160: invokevirtual 1739	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   163: pop
    //   164: aload 6
    //   166: getfield 1742	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody:rpt_msg_grp_member_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   169: invokevirtual 1744	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   172: ifne +331 -> 503
    //   175: aload 6
    //   177: getfield 1742	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody:rpt_msg_grp_member_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   180: invokevirtual 1474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   183: astore_3
    //   184: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +42 -> 229
    //   190: new 240	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   197: ldc_w 1746
    //   200: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: astore 6
    //   205: aload_3
    //   206: ifnonnull +270 -> 476
    //   209: iconst_0
    //   210: istore 4
    //   212: ldc_w 1732
    //   215: iconst_2
    //   216: aload 6
    //   218: iload 4
    //   220: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_3
    //   230: ifnull +273 -> 503
    //   233: aload_1
    //   234: invokevirtual 878	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   237: aload_3
    //   238: invokeinterface 1540 1 0
    //   243: astore_3
    //   244: aload_3
    //   245: invokeinterface 380 1 0
    //   250: ifeq +249 -> 499
    //   253: aload_3
    //   254: invokeinterface 384 1 0
    //   259: checkcast 1748	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo
    //   262: astore 7
    //   264: aload 7
    //   266: ifnull -22 -> 244
    //   269: aload 7
    //   271: getfield 1749	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   274: invokevirtual 1588	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   277: ifeq -33 -> 244
    //   280: aload 7
    //   282: getfield 1752	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   285: invokevirtual 1744	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   288: ifne -44 -> 244
    //   291: aload 7
    //   293: getfield 1752	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   296: invokevirtual 1474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   299: astore 6
    //   301: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +43 -> 347
    //   307: new 240	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   314: ldc_w 1754
    //   317: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: astore 8
    //   322: aload 6
    //   324: ifnonnull +163 -> 487
    //   327: iconst_0
    //   328: istore 4
    //   330: ldc_w 1732
    //   333: iconst_2
    //   334: aload 8
    //   336: iload 4
    //   338: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload 6
    //   349: ifnull -105 -> 244
    //   352: aload_2
    //   353: aload 7
    //   355: getfield 1749	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   358: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   361: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   364: invokevirtual 337	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   367: astore 7
    //   369: aload 7
    //   371: ifnull -127 -> 244
    //   374: aload 7
    //   376: aload 6
    //   378: invokevirtual 1757	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap2	(Ljava/util/List;)V
    //   381: aload_2
    //   382: aload 7
    //   384: invokevirtual 345	com/tencent/mobileqq/app/FriendsManagerImp:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   387: goto -143 -> 244
    //   390: astore_2
    //   391: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +33 -> 427
    //   397: ldc_w 1732
    //   400: iconst_2
    //   401: new 240	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 1759
    //   411: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_2
    //   415: invokevirtual 1639	java/lang/Exception:toString	()Ljava/lang/String;
    //   418: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: aload_1
    //   428: invokevirtual 972	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   431: return
    //   432: astore_2
    //   433: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq +33 -> 469
    //   439: ldc_w 1732
    //   442: iconst_2
    //   443: new 240	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   450: ldc_w 1761
    //   453: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload_2
    //   457: invokevirtual 1651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   460: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_2
    //   470: invokevirtual 1611	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   473: goto -441 -> 32
    //   476: aload_3
    //   477: invokeinterface 1085 1 0
    //   482: istore 4
    //   484: goto -272 -> 212
    //   487: aload 6
    //   489: invokeinterface 1085 1 0
    //   494: istore 4
    //   496: goto -166 -> 330
    //   499: aload_1
    //   500: invokevirtual 1048	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   503: aload_1
    //   504: invokevirtual 972	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   507: return
    //   508: astore_2
    //   509: aload_1
    //   510: invokevirtual 972	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   513: aload_2
    //   514: athrow
    //   515: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq -87 -> 431
    //   521: ldc_w 1732
    //   524: iconst_2
    //   525: new 240	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 1763
    //   535: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_2
    //   539: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   542: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   545: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	TroopHandler
    //   0	552	1	paramToServiceMsg	ToServiceMsg
    //   0	552	2	paramFromServiceMsg	FromServiceMsg
    //   0	552	3	paramObject	Object
    //   33	462	4	i1	int
    //   46	41	5	i2	int
    //   155	333	6	localObject1	Object
    //   262	121	7	localObject2	Object
    //   320	15	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   148	205	390	java/lang/Exception
    //   212	229	390	java/lang/Exception
    //   233	244	390	java/lang/Exception
    //   244	264	390	java/lang/Exception
    //   269	322	390	java/lang/Exception
    //   330	347	390	java/lang/Exception
    //   352	369	390	java/lang/Exception
    //   374	387	390	java/lang/Exception
    //   476	484	390	java/lang/Exception
    //   487	496	390	java/lang/Exception
    //   499	503	390	java/lang/Exception
    //   15	30	432	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   148	205	508	finally
    //   212	229	508	finally
    //   233	244	508	finally
    //   244	264	508	finally
    //   269	322	508	finally
    //   330	347	508	finally
    //   352	369	508	finally
    //   374	387	508	finally
    //   391	427	508	finally
    //   476	484	508	finally
    //   487	496	508	finally
    //   499	503	508	finally
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(47, false, null);
      return;
    }
    paramFromServiceMsg = new cmd0x3bb.AnonyMsg();
    cmd0x3bb.RspBody localRspBody;
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localRspBody = (cmd0x3bb.RspBody)paramFromServiceMsg.msg_anony_rsp.get();
      if (localRspBody == null)
      {
        a(47, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(47, false, null);
      return;
    }
    if (localRspBody.int32_ret.get() != 0)
    {
      a(47, false, null);
      return;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    paramObject = new String(localRspBody.str_anony_name.get().toByteArray());
    int i2 = localRspBody.uint32_portrait_index.get();
    int i3 = localRspBody.uint32_bubble_index.get();
    int i4 = localRspBody.uint32_expired_time.get();
    paramToServiceMsg = (cmd0x3bb.AnonyStatus)localRspBody.msg_anony_status.get();
    int i1;
    if (paramToServiceMsg != null)
    {
      i1 = paramToServiceMsg.uint32_forbid_talking.get();
      paramToServiceMsg = new String(paramToServiceMsg.str_err_msg.get().toByteArray());
    }
    for (;;)
    {
      a(47, true, new Object[] { paramFromServiceMsg, paramObject, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i1), paramToServiceMsg });
      return;
      paramToServiceMsg = "";
      i1 = 0;
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    paramToServiceMsg = new Object[2];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(52, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(52, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(52, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x88d.RspBody();
    int i1;
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = paramObject.stzrspgroupinfo.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label294;
      }
      paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
      i1 = paramFromServiceMsg.uint32_result.get();
      if (i1 == 0)
      {
        a(52, true, new Object[] { str, Integer.valueOf(i1), Integer.valueOf(((oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get()).uint32_group_member_max_num.get()) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(52, false, paramToServiceMsg);
      return;
    }
    a(52, false, new Object[] { str, Integer.valueOf(i1) });
    return;
    label294:
    a(52, false, paramToServiceMsg);
  }
  
  /* Error */
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 290	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +444 -> 448
    //   7: new 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   10: dup
    //   11: invokespecial 1358	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_3
    //   17: checkcast 1359	[B
    //   20: checkcast 1359	[B
    //   23: invokevirtual 1360	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   26: checkcast 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: iconst_m1
    //   33: istore 4
    //   35: aload_1
    //   36: ifnull +54 -> 90
    //   39: aload_1
    //   40: getfield 1364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   43: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   46: istore 5
    //   48: iload 5
    //   50: istore 4
    //   52: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +35 -> 90
    //   58: ldc_w 1732
    //   61: iconst_2
    //   62: new 240	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 1734
    //   72: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 5
    //   77: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: iload 5
    //   88: istore 4
    //   90: iload 4
    //   92: ifne +250 -> 342
    //   95: aload_1
    //   96: ifnull +246 -> 342
    //   99: aload_1
    //   100: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   106: ifeq +236 -> 342
    //   109: aload_1
    //   110: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: ifnull +226 -> 342
    //   119: aload_1
    //   120: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   129: astore 6
    //   131: aload_0
    //   132: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   135: bipush 8
    //   137: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   140: checkcast 329	com/tencent/mobileqq/app/FriendsManagerImp
    //   143: astore_2
    //   144: aload_2
    //   145: invokevirtual 1735	com/tencent/mobileqq/app/FriendsManagerImp:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   148: astore_1
    //   149: new 1809	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   152: dup
    //   153: invokespecial 1810	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   156: astore_3
    //   157: aload_3
    //   158: aload 6
    //   160: invokevirtual 1811	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   163: pop
    //   164: aload_1
    //   165: invokevirtual 878	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   168: aload_3
    //   169: getfield 1812	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   172: invokevirtual 1588	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   175: ifeq +163 -> 338
    //   178: aload_3
    //   179: getfield 1813	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   182: invokevirtual 1744	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   185: ifne +153 -> 338
    //   188: aload_3
    //   189: getfield 1813	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   192: invokevirtual 1474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   195: astore 7
    //   197: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +43 -> 243
    //   203: new 240	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 1754
    //   213: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: astore 6
    //   218: aload 7
    //   220: ifnonnull +167 -> 387
    //   223: iconst_0
    //   224: istore 4
    //   226: ldc_w 1732
    //   229: iconst_2
    //   230: aload 6
    //   232: iload 4
    //   234: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload 7
    //   245: ifnull +89 -> 334
    //   248: aload_2
    //   249: aload_3
    //   250: getfield 1812	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   253: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   256: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   259: invokevirtual 337	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   262: astore 6
    //   264: aload 6
    //   266: ifnull +68 -> 334
    //   269: aload 6
    //   271: aload 7
    //   273: invokevirtual 1816	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;)V
    //   276: aload_3
    //   277: getfield 1819	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   280: astore 7
    //   282: aload 7
    //   284: ifnull +18 -> 302
    //   287: aload 6
    //   289: aload_3
    //   290: getfield 1819	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   293: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   296: invokevirtual 1822	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   299: putfield 1003	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   302: aload_3
    //   303: getfield 1825	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   306: astore 7
    //   308: aload 7
    //   310: ifnull +18 -> 328
    //   313: aload 6
    //   315: aload_3
    //   316: getfield 1825	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   319: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   322: invokevirtual 1822	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   325: putfield 1009	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   328: aload_2
    //   329: aload 6
    //   331: invokevirtual 345	com/tencent/mobileqq/app/FriendsManagerImp:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   334: aload_1
    //   335: invokevirtual 1048	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   338: aload_1
    //   339: invokevirtual 972	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   342: return
    //   343: astore_2
    //   344: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +33 -> 380
    //   350: ldc_w 1732
    //   353: iconst_2
    //   354: new 240	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 1761
    //   364: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_2
    //   368: invokevirtual 1651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   371: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload_2
    //   381: invokevirtual 1611	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   384: goto -352 -> 32
    //   387: aload 7
    //   389: invokeinterface 1085 1 0
    //   394: istore 4
    //   396: goto -170 -> 226
    //   399: astore_2
    //   400: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +33 -> 436
    //   406: ldc_w 1732
    //   409: iconst_2
    //   410: new 240	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 1827
    //   420: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_2
    //   424: invokevirtual 1639	java/lang/Exception:toString	()Ljava/lang/String;
    //   427: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aload_1
    //   437: invokevirtual 972	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   440: return
    //   441: astore_2
    //   442: aload_1
    //   443: invokevirtual 972	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   446: aload_2
    //   447: athrow
    //   448: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq -109 -> 342
    //   454: ldc_w 1732
    //   457: iconst_2
    //   458: new 240	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   465: ldc_w 1763
    //   468: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload_2
    //   472: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   475: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   478: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   484: return
    //   485: astore_3
    //   486: goto -158 -> 328
    //   489: astore 7
    //   491: goto -189 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	TroopHandler
    //   0	494	1	paramToServiceMsg	ToServiceMsg
    //   0	494	2	paramFromServiceMsg	FromServiceMsg
    //   0	494	3	paramObject	Object
    //   33	362	4	i1	int
    //   46	41	5	i2	int
    //   129	201	6	localObject1	Object
    //   195	193	7	localObject2	Object
    //   489	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   15	30	343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   149	218	399	java/lang/Exception
    //   226	243	399	java/lang/Exception
    //   248	264	399	java/lang/Exception
    //   269	282	399	java/lang/Exception
    //   302	308	399	java/lang/Exception
    //   328	334	399	java/lang/Exception
    //   334	338	399	java/lang/Exception
    //   387	396	399	java/lang/Exception
    //   149	218	441	finally
    //   226	243	441	finally
    //   248	264	441	finally
    //   269	282	441	finally
    //   287	302	441	finally
    //   302	308	441	finally
    //   313	328	441	finally
    //   328	334	441	finally
    //   334	338	441	finally
    //   387	396	441	finally
    //   400	436	441	finally
    //   313	328	485	java/lang/Exception
    //   287	302	489	java/lang/Exception
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Boolean.valueOf(false);
    arrayOfObject[2] = "";
    arrayOfObject[3] = "";
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(56, false, arrayOfObject);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(56, false, arrayOfObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(56, false, arrayOfObject);
      return;
    }
    paramObject = new cmd0x8a7.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        boolean bool = paramObject.bool_can_at_all.get();
        if (paramObject.bytes_prompt_msg_1.has())
        {
          paramToServiceMsg = paramObject.bytes_prompt_msg_1.get().toStringUtf8();
          paramFromServiceMsg = "";
          if (paramObject.bytes_prompt_msg_2.has()) {
            paramFromServiceMsg = paramObject.bytes_prompt_msg_2.get().toStringUtf8();
          }
          a(56, true, new Object[] { str, Boolean.valueOf(bool), paramToServiceMsg, paramFromServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(56, false, arrayOfObject);
        return;
      }
      paramToServiceMsg = "";
    }
  }
  
  /* Error */
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 6
    //   6: iconst_1
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 10
    //   12: iconst_0
    //   13: istore 9
    //   15: aload_2
    //   16: invokevirtual 290	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +567 -> 586
    //   22: aload_3
    //   23: ifnull +563 -> 586
    //   26: iconst_1
    //   27: istore 8
    //   29: iload 8
    //   31: ifeq +726 -> 757
    //   34: iload 6
    //   36: istore 5
    //   38: aload_1
    //   39: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   42: ldc_w 1372
    //   45: invokevirtual 662	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 1426	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   51: invokevirtual 1429	java/lang/Long:longValue	()J
    //   54: lstore 12
    //   56: iload 6
    //   58: istore 5
    //   60: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq +45 -> 108
    //   66: iload 6
    //   68: istore 5
    //   70: ldc 63
    //   72: iconst_2
    //   73: new 240	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 1847
    //   83: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: iload 8
    //   88: invokevirtual 1604	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   91: ldc_w 1849
    //   94: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: lload 12
    //   99: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: iload 6
    //   110: istore 5
    //   112: new 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   115: dup
    //   116: invokespecial 1358	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   119: astore_1
    //   120: iload 6
    //   122: istore 5
    //   124: aload_1
    //   125: aload_3
    //   126: checkcast 1359	[B
    //   129: checkcast 1359	[B
    //   132: invokevirtual 1360	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   135: pop
    //   136: aload_1
    //   137: ifnull +16 -> 153
    //   140: iload 6
    //   142: istore 5
    //   144: aload_1
    //   145: getfield 1364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   148: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   151: istore 4
    //   153: iload 4
    //   155: istore 5
    //   157: iload 10
    //   159: istore 7
    //   161: aload_1
    //   162: ifnull +498 -> 660
    //   165: iload 4
    //   167: istore 5
    //   169: aload_1
    //   170: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   173: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   176: istore 11
    //   178: iload 4
    //   180: istore 5
    //   182: iload 10
    //   184: istore 7
    //   186: iload 11
    //   188: ifeq +472 -> 660
    //   191: aload_1
    //   192: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   195: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   198: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   201: astore_2
    //   202: new 1809	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   205: dup
    //   206: invokespecial 1810	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   209: astore_1
    //   210: aload_1
    //   211: aload_2
    //   212: invokevirtual 1811	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   215: pop
    //   216: lload 12
    //   218: aload_1
    //   219: getfield 1812	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   222: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   225: lcmp
    //   226: ifne +427 -> 653
    //   229: new 1695	java/lang/StringBuffer
    //   232: dup
    //   233: invokespecial 1696	java/lang/StringBuffer:<init>	()V
    //   236: astore_3
    //   237: aload_1
    //   238: getfield 1852	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_member_level_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   241: invokevirtual 1474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   244: astore_1
    //   245: new 1021	java/util/HashMap
    //   248: dup
    //   249: aload_1
    //   250: invokeinterface 1085 1 0
    //   255: invokespecial 1854	java/util/HashMap:<init>	(I)V
    //   258: astore 14
    //   260: aload_1
    //   261: invokeinterface 1540 1 0
    //   266: astore 15
    //   268: aload 15
    //   270: invokeinterface 380 1 0
    //   275: ifeq +317 -> 592
    //   278: aload 15
    //   280: invokeinterface 384 1 0
    //   285: checkcast 1856	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo
    //   288: astore 17
    //   290: ldc_w 331
    //   293: astore_2
    //   294: aload 17
    //   296: getfield 1859	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   299: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   302: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   305: astore 16
    //   307: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +23 -> 333
    //   313: aload_3
    //   314: ldc_w 1861
    //   317: invokevirtual 1706	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   320: pop
    //   321: aload_3
    //   322: aload 16
    //   324: iconst_0
    //   325: iconst_4
    //   326: invokevirtual 1865	java/lang/String:substring	(II)Ljava/lang/String;
    //   329: invokevirtual 1706	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   332: pop
    //   333: aload 17
    //   335: getfield 1868	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   338: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   341: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   344: astore 18
    //   346: aload_2
    //   347: astore_1
    //   348: aload 18
    //   350: ifnull +48 -> 398
    //   353: aload_2
    //   354: astore_1
    //   355: aload 18
    //   357: arraylength
    //   358: ifle +40 -> 398
    //   361: new 220	java/lang/String
    //   364: dup
    //   365: aload 18
    //   367: invokespecial 1782	java/lang/String:<init>	([B)V
    //   370: astore_2
    //   371: aload_2
    //   372: astore_1
    //   373: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +22 -> 398
    //   379: aload_3
    //   380: ldc_w 1870
    //   383: invokevirtual 1706	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   386: pop
    //   387: aload_3
    //   388: aload_2
    //   389: invokestatic 1873	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   392: invokevirtual 1706	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   395: pop
    //   396: aload_2
    //   397: astore_1
    //   398: aload 17
    //   400: getfield 1876	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:bytes_nick_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   403: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   406: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   409: astore_2
    //   410: aload_2
    //   411: ifnull +343 -> 754
    //   414: aload_2
    //   415: arraylength
    //   416: ifle +338 -> 754
    //   419: aload_1
    //   420: invokestatic 1385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   423: ifeq +331 -> 754
    //   426: new 220	java/lang/String
    //   429: dup
    //   430: aload_2
    //   431: invokespecial 1782	java/lang/String:<init>	([B)V
    //   434: astore_2
    //   435: aload_2
    //   436: astore_1
    //   437: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   440: ifeq +22 -> 462
    //   443: aload_3
    //   444: ldc_w 1878
    //   447: invokevirtual 1706	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   450: pop
    //   451: aload_3
    //   452: aload_2
    //   453: invokestatic 1873	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   456: invokevirtual 1706	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   459: pop
    //   460: aload_2
    //   461: astore_1
    //   462: aload_1
    //   463: astore_2
    //   464: aload_1
    //   465: invokestatic 1385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   468: ifeq +20 -> 488
    //   471: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +290 -> 764
    //   477: aload_3
    //   478: ldc_w 1880
    //   481: invokevirtual 1706	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   484: pop
    //   485: goto +279 -> 764
    //   488: aload 14
    //   490: aload 16
    //   492: aload_2
    //   493: invokeinterface 1041 3 0
    //   498: pop
    //   499: goto -231 -> 268
    //   502: astore_1
    //   503: iconst_0
    //   504: istore 5
    //   506: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq +13 -> 522
    //   512: ldc 63
    //   514: iconst_2
    //   515: ldc_w 1882
    //   518: aload_1
    //   519: invokestatic 1885	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   522: iload 5
    //   524: istore 4
    //   526: iload 9
    //   528: istore 8
    //   530: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq +39 -> 572
    //   536: ldc 63
    //   538: iconst_2
    //   539: new 240	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 1887
    //   549: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokestatic 365	java/lang/System:currentTimeMillis	()J
    //   555: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   558: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: iload 9
    //   566: istore 8
    //   568: iload 5
    //   570: istore 4
    //   572: aload_0
    //   573: bipush 57
    //   575: iload 8
    //   577: iload 4
    //   579: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   582: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   585: return
    //   586: iconst_0
    //   587: istore 8
    //   589: goto -560 -> 29
    //   592: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq +13 -> 608
    //   598: ldc 63
    //   600: iconst_2
    //   601: aload_3
    //   602: invokevirtual 1707	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   605: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: aload_0
    //   609: bipush 57
    //   611: iload 8
    //   613: aload 14
    //   615: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   618: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   621: ifeq -36 -> 585
    //   624: ldc 63
    //   626: iconst_2
    //   627: new 240	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   634: ldc_w 1887
    //   637: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokestatic 365	java/lang/System:currentTimeMillis	()J
    //   643: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   646: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   652: return
    //   653: iconst_0
    //   654: istore 5
    //   656: iload 10
    //   658: istore 7
    //   660: iload 5
    //   662: istore 4
    //   664: iload 7
    //   666: istore 8
    //   668: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq -99 -> 572
    //   674: ldc 63
    //   676: iconst_2
    //   677: new 240	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   684: ldc_w 1887
    //   687: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokestatic 365	java/lang/System:currentTimeMillis	()J
    //   693: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   696: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: iload 5
    //   704: istore 4
    //   706: iload 7
    //   708: istore 8
    //   710: goto -138 -> 572
    //   713: astore_1
    //   714: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq +31 -> 748
    //   720: ldc 63
    //   722: iconst_2
    //   723: new 240	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   730: ldc_w 1887
    //   733: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: invokestatic 365	java/lang/System:currentTimeMillis	()J
    //   739: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   742: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: aload_1
    //   749: athrow
    //   750: astore_1
    //   751: goto -245 -> 506
    //   754: goto -292 -> 462
    //   757: iload 8
    //   759: istore 7
    //   761: goto -101 -> 660
    //   764: ldc_w 1889
    //   767: astore_2
    //   768: goto -280 -> 488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	771	0	this	TroopHandler
    //   0	771	1	paramToServiceMsg	ToServiceMsg
    //   0	771	2	paramFromServiceMsg	FromServiceMsg
    //   0	771	3	paramObject	Object
    //   7	698	4	i1	int
    //   1	702	5	i2	int
    //   4	137	6	i3	int
    //   159	601	7	bool1	boolean
    //   27	731	8	bool2	boolean
    //   13	552	9	bool3	boolean
    //   10	647	10	bool4	boolean
    //   176	11	11	bool5	boolean
    //   54	163	12	l1	long
    //   258	356	14	localHashMap	HashMap
    //   266	13	15	localIterator	Iterator
    //   305	186	16	str	String
    //   288	111	17	localMemberLevelInfo	tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo
    //   344	22	18	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   191	268	502	java/lang/Exception
    //   268	290	502	java/lang/Exception
    //   294	333	502	java/lang/Exception
    //   333	346	502	java/lang/Exception
    //   355	371	502	java/lang/Exception
    //   373	396	502	java/lang/Exception
    //   398	410	502	java/lang/Exception
    //   414	435	502	java/lang/Exception
    //   437	460	502	java/lang/Exception
    //   464	485	502	java/lang/Exception
    //   488	499	502	java/lang/Exception
    //   592	608	502	java/lang/Exception
    //   608	618	502	java/lang/Exception
    //   38	56	713	finally
    //   60	66	713	finally
    //   70	108	713	finally
    //   112	120	713	finally
    //   124	136	713	finally
    //   144	153	713	finally
    //   169	178	713	finally
    //   191	268	713	finally
    //   268	290	713	finally
    //   294	333	713	finally
    //   333	346	713	finally
    //   355	371	713	finally
    //   373	396	713	finally
    //   398	410	713	finally
    //   414	435	713	finally
    //   437	460	713	finally
    //   464	485	713	finally
    //   488	499	713	finally
    //   506	522	713	finally
    //   592	608	713	finally
    //   608	618	713	finally
    //   38	56	750	java/lang/Exception
    //   60	66	750	java/lang/Exception
    //   70	108	750	java/lang/Exception
    //   112	120	750	java/lang/Exception
    //   124	136	750	java/lang/Exception
    //   144	153	750	java/lang/Exception
    //   169	178	750	java/lang/Exception
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(59, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(59, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(59, false, paramToServiceMsg);
      return;
    }
    paramObject = new cmd0x8ca.RspBody();
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      long l1 = paramObject.opt_uint64_group_code.get();
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "" + l1, Integer.valueOf(0));
      a(59, true, paramToServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(59, false, paramToServiceMsg);
    }
  }
  
  protected Class a()
  {
    return TroopObserver.class;
  }
  
  public ArrayList a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(String.valueOf(this.g)))) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  public void a()
  {
    b(null);
  }
  
  public void a(byte paramByte, String paramString1, String paramString2)
  {
    if ((paramByte == 0) || (paramByte == 1))
    {
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), TroopServlet.class);
      localNewIntent.putExtra("command", 0);
      localNewIntent.putExtra("operation", paramByte);
      localNewIntent.putExtra("troop_code", paramString1);
      localNewIntent.putExtra("troop_member_uin", paramString2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.a(BaseApplication.getContext()).a(null, h, false, 0L, 0L, localHashMap, "");
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new cmd0x3bb.ReqBody();
    try
    {
      ((cmd0x3bb.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((cmd0x3bb.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString2));
      cmd0x3bb.AnonyMsg localAnonyMsg = new cmd0x3bb.AnonyMsg();
      localAnonyMsg.uint32_cmd.set(paramInt);
      localAnonyMsg.msg_anony_req.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "anony_msg.group");
      ((ToServiceMsg)localObject).putWupBuffer(localAnonyMsg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString2);
      b((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "TroopHandler.getAnonymousChatNick, memberUin: " + paramString1 + " troopUin: " + paramString2);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", troopUin : " + paramString2);
    }
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
    a(paramLong, 0L, 5, null, 6, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x88d_1").append("|troopuin = ").append(paramLong).append("|flag = ").append(paramInt);
      QLog.i("Q.troopquestionverify.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    if ((paramInt & 0x80) == 128) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_option.set(0);
    }
    if ((paramInt & 0x800000) == 8388608) {
      ((oidb_0x88d.GroupInfo)localObject2).string_group_question.set(ByteStringMicro.EMPTY);
    }
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(paramLong);
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_1");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong);
    ((ToServiceMsg)localObject2).extraData.putInt("nFlag", paramInt);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, long paramLong2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), PbServlet.class);
    localNewIntent.putExtra("cmd", "ProfileService.SearchGroup");
    localNewIntent.putExtra("searchType", paramInt3);
    SearchGroup.SearchGroupReq localSearchGroupReq = new SearchGroup.SearchGroupReq();
    localSearchGroupReq.qwUin.set(paramLong1);
    localSearchGroupReq.dwReqUinNum.set(paramInt1);
    localSearchGroupReq.dwPageNo.set(paramInt2);
    localSearchGroupReq.eSubCmd.set(paramInt3);
    localSearchGroupReq.sReqContent.set(paramString);
    localSearchGroupReq.eGroupSortType.set(paramInt4);
    localSearchGroupReq.dwNextRecTime.set((int)paramLong2);
    localNewIntent.putExtra("data", localSearchGroupReq.toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "group_member_card.get_group_member_card_info");
    group_member_info.ReqBody localReqBody = new group_member_info.ReqBody();
    localReqBody.uint64_group_code.set(paramLong1);
    localReqBody.uint64_uin.set(paramLong2);
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "FriendListHandler.getTroopMemberCard, memberUin: " + paramLong2 + " troopCode: " + paramLong1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, List paramList, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder(150);
      paramList.append("send_oidb_0x899_0").append("|troopuin = ").append(paramLong1).append("|flag = ").append(paramInt1).append("|nStartUin = ").append(paramLong2).append("|memberNum = ").append(paramInt2).append("|filterMethod = ").append(paramInt3);
      QLog.i("Q.troopdisband.", 2, paramList.toString());
    }
    Object localObject = new oidb_0x899.memberlist();
    ((oidb_0x899.memberlist)localObject).uint64_member_uin.set(0L);
    paramList = new oidb_0x899.ReqBody();
    paramList.uint64_group_code.set(paramLong1);
    paramList.uint64_start_uin.set(paramLong2);
    if (paramInt1 == 4) {
      ((oidb_0x899.memberlist)localObject).uint32_uin_flag.set(0);
    }
    for (;;)
    {
      paramList.uint32_identify_flag.set(paramInt1);
      paramList.memberlist_opt.set((MessageMicro)localObject);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2201);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramList.toByteArray()));
      paramList = a("OidbSvc.0x899_0");
      paramList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      paramList.extraData.putLong("troop_uin", paramLong1);
      paramList.extraData.putInt("nFlag", paramInt1);
      paramList.extraData.putLong("nStartUin", paramLong2);
      paramList.setTimeout(30000L);
      b(paramList);
      return;
      if (paramInt1 == 5)
      {
        paramList.uint32_member_num.set(paramInt2);
        paramList.uint32_filter_method.set(paramInt3);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x89e").append("|troopuin = ").append(paramLong1).append("|oldOwner = ").append(paramLong2).append("|newOwner = ").append(paramLong3);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x89e.ReqBody();
    ((oidb_0x89e.ReqBody)localObject2).uint64_group_code.set(paramLong1);
    ((oidb_0x89e.ReqBody)localObject2).uint64_old_owner.set(paramLong2);
    ((oidb_0x89e.ReqBody)localObject2).uint64_new_owner.set(paramLong3);
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2206);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89e.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x89e_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong1);
    ((ToServiceMsg)localObject2).extraData.putLong("OldOwner", paramLong2);
    ((ToServiceMsg)localObject2).extraData.putLong("NewOwner", paramLong3);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.ModifyGroupInfoReq");
    localToServiceMsg.extraData.putLong("dwGroupCode", paramLong1);
    localToServiceMsg.extraData.putLong("cGroupOption", paramLong2);
    localToServiceMsg.extraData.putLong("dwGroupClass", paramLong3);
    Bundle localBundle = localToServiceMsg.extraData;
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    localBundle.putString("strGroupName", (String)localObject);
    localToServiceMsg.extraData.putInt("wGroupFace", paramInt1);
    localObject = localToServiceMsg.extraData;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((Bundle)localObject).putString("strGroupMemo", paramString1);
    paramString2 = localToServiceMsg.extraData;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    paramString2.putString("strFingerMemo", paramString1);
    localToServiceMsg.extraData.putInt("modify_troopinfo_flag", paramInt2);
    if ((paramInt2 & 0x2) == 2) {
      localToServiceMsg.extraData.putLong("dwValidMask", 2L);
    }
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, List paramList, boolean paramBoolean)
  {
    Object localObject = new oidb_0x8a0.ReqBody();
    ((oidb_0x8a0.ReqBody)localObject).opt_uint64_group_code.set(paramLong);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramList.size())
    {
      oidb_0x8a0.KickMemberInfo localKickMemberInfo = new oidb_0x8a0.KickMemberInfo();
      localKickMemberInfo.opt_uint32_opearte.set(5);
      localKickMemberInfo.opt_uint64_member_uin.set(((Long)paramList.get(i1)).longValue());
      PBUInt32Field localPBUInt32Field = localKickMemberInfo.opt_uint32_flag;
      if (paramBoolean) {}
      for (int i2 = 1;; i2 = 0)
      {
        localPBUInt32Field.set(i2);
        localArrayList.add(localKickMemberInfo);
        i1 += 1;
        break;
      }
    }
    ((oidb_0x8a0.ReqBody)localObject).rpt_msg_kick_list.set(localArrayList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2208);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8a0.ReqBody)localObject).toByteArray()));
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x8a0_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.ReqBatchProcess");
    localToServiceMsg.extraData.putLong("troop_code", paramLong);
    localToServiceMsg.extraData.putBoolean("is_admin", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean, String paramString)
  {
    int i1 = 0;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), PbServlet.class);
    localNewIntent.putExtra("cmd", "ProfileService.Pb.SetGroupLocation");
    GroupLocation.SetGroupLocationReq localSetGroupLocationReq = new GroupLocation.SetGroupLocationReq();
    localSetGroupLocationReq.groupcode.set(Utils.a(paramLong));
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localSetGroupLocationReq.grouplocation.set(str);
    localNewIntent.putExtra("data", localSetGroupLocationReq.toByteArray());
    localNewIntent.putExtra("TroopUin", paramLong);
    localNewIntent.putExtra("isClear", paramBoolean);
    paramString = str.split("\\|");
    int i2;
    if (paramString.length == 4)
    {
      i2 = (int)(Float.valueOf(paramString[1]).floatValue() * 1000000.0F);
      i1 = (int)(Float.valueOf(paramString[2]).floatValue() * 1000000.0F);
    }
    for (;;)
    {
      localNewIntent.putExtra("lat", i2);
      localNewIntent.putExtra("lon", i1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
      i2 = 0;
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    paramObject = (byte[])paramObject;
    if (str.equalsIgnoreCase("ProfileService.SearchGroup")) {
      b(paramIntent, paramFromServiceMsg, paramObject);
    }
    while (!str.equalsIgnoreCase("ProfileService.Pb.SetGroupLocation")) {
      return;
    }
    a(paramIntent, paramFromServiceMsg, paramObject);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    cmd0x8ca.ReqBody localReqBody = new cmd0x8ca.ReqBody();
    localReqBody.opt_uint32_sub_cmd.set(3L);
    try
    {
      localReqBody.opt_uint64_from_uin.set(Long.parseLong(paramQQAppInterface.a()));
      localReqBody.opt_uint64_group_code.set(Long.parseLong(paramString));
      localReqBody.opt_bytes_group_sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      localReqBody.opt_uint64_appid.set(1102858908L);
      paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
      paramArrayOfByte.uint32_command.set(2250);
      paramArrayOfByte.uint32_result.set(0);
      paramArrayOfByte.uint32_service_type.set(2);
      paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramQQAppInterface = new ToServiceMsg("mobileqq.service", paramQQAppInterface.a(), "OidbSvc.0x8ca_2");
      paramQQAppInterface.extraData.putString("troopUin", paramString);
      paramQQAppInterface.putWupBuffer(paramArrayOfByte.toByteArray());
      b(paramQQAppInterface);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, "clearAioFCRedDot error, NumberFormatException, troopUin : " + paramString);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (c(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "cmdfilter error=" + str);
      }
      return;
    }
    if ("GroupSvc.JoinGroupLink".equalsIgnoreCase(str))
    {
      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("friendlist.GetTroopListReqV2".equals(str))
    {
      if (paramObject == null)
      {
        a(1, false, null);
        return;
      }
      paramFromServiceMsg = (GetTroopListRespV2)paramObject;
      if ((paramFromServiceMsg.result == 1) || ((paramFromServiceMsg.vecTroopList == null) && (paramFromServiceMsg.vecTroopListDel == null)))
      {
        a(1, false, null);
        return;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("friendlist.GetMultiTroopInfoReq".equals(str))
    {
      if (paramFromServiceMsg.isSuccess())
      {
        if (paramObject != null)
        {
          a(paramFromServiceMsg, (GetMultiTroopInfoResp)paramObject);
          return;
        }
        a(2, true, null);
        return;
      }
      a(2, false, null);
      return;
    }
    if ("friendlist.ModifyGroupCardReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject != null)
      {
        a(paramToServiceMsg, paramFromServiceMsg, (ModifyGroupCardResp)paramObject);
        return;
      }
      a(9, false, null);
      return;
    }
    if ("friendlist.ModifyGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd())) {
      if (!(paramObject instanceof ModifyGroupInfoResp)) {
        break label922;
      }
    }
    label922:
    for (paramObject = (ModifyGroupInfoResp)paramObject;; paramObject = null)
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("friendlist.GetTroopAppointRemarkReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(paramFromServiceMsg, (GetTroopAppointRemarkResp)paramObject);
          return;
        }
        a(10, false, null);
        return;
      }
      if ("friendlist.getTroopRemark".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(paramToServiceMsg, (GetTroopRemarkResp)paramObject);
          return;
        }
        a(3, false, null);
        return;
      }
      if ("friendlist.getTroopMemberList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(paramToServiceMsg, (GetTroopMemberListResp)paramObject);
          return;
        }
        a(4, false, null);
        return;
      }
      if ("group_member_card.get_group_member_card_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.getGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        switch (paramToServiceMsg.extraData.getInt("subCmd", -1))
        {
        case 3: 
        case 5: 
        default: 
          return;
        case 1: 
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 4: 
          j(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 2: 
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_7".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x899_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x89e_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8c9_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8fd_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8b8_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        switch (paramToServiceMsg.extraData.getInt("subCmd", -1))
        {
        case 4: 
        default: 
          l(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 3: 
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_10".equals(paramFromServiceMsg.getServiceCmd()))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.ReqBatchProcess".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x8bb_2".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x8bb_3".equals(paramFromServiceMsg.getServiceCmd())))
      {
        a(paramFromServiceMsg.getServiceCmd(), paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8a0_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramFromServiceMsg.getServiceCmd(), paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("anony_msg.group".equals(paramFromServiceMsg.getServiceCmd()))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.GroupMngReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x787_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8a7_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        v(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x787_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        w(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (!"OidbSvc.0x8ca_2".equals(paramFromServiceMsg.getServiceCmd())) {
        break;
      }
      x(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      try
      {
        paramString = paramString.trim();
        long l1 = Long.parseLong(paramString);
        Object localObject = new cmd0x8b4.ReqBody();
        ((cmd0x8b4.ReqBody)localObject).uint64_gc.set(l1);
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(2228);
        localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject).toByteArray()));
        localOIDBSSOPkg.uint32_service_type.set(0);
        localObject = a("OidbSvc.0x8b4");
        ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
        ((ToServiceMsg)localObject).extraData.putString("0x8d4_cmd_key", "getShowEternalStatus");
        ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
        b((ToServiceMsg)localObject);
        return;
      }
      catch (NumberFormatException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TroopHandler", 2, "NumberFormatException");
  }
  
  public void a(String paramString, byte paramByte, long paramLong, int paramInt)
  {
    Object localObject = Long.valueOf(SystemClock.uptimeMillis());
    Long localLong = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localLong != null) && (Math.abs(((Long)localObject).longValue() - localLong.longValue()) < 60000L)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
    localObject = a("ProfileService.getGroupInfoReq");
    ((ToServiceMsg)localObject).extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putByte("get_groupablm", paramByte);
    ((ToServiceMsg)localObject).extraData.putLong("groupablm_timestamp", paramLong);
    ((ToServiceMsg)localObject).extraData.putInt("cStatOption", paramInt);
    ((ToServiceMsg)localObject).extraData.putByte("cIfGetAuthInfo", (byte)1);
    a((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 0);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putInt("stat_option", paramInt);
    localToServiceMsg.extraData.putByte("cIfGetAuthInfo", (byte)1);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopHandler", 2, "getShowExternalTroopList destUin is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = paramString.trim();
          long l1 = Long.parseLong(paramString);
          if (l1 != 0L)
          {
            Object localObject1 = new cmd0x8b4.ReqBody();
            ((cmd0x8b4.ReqBody)localObject1).uint64_dst_uin.set(l1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_start.set(paramInt1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_cnt.set(paramInt2);
            Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
            localObject2 = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2228);
            ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject1).toByteArray()));
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
            localObject1 = a("OidbSvc.0x8b4");
            ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
            ((ToServiceMsg)localObject1).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
            ((ToServiceMsg)localObject1).extraData.putString("target_uin", paramString);
            b((ToServiceMsg)localObject1);
            return;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopHandler", 2, "NumberFormatException");
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    Object localObject1 = new oidb_0x8b8.ReqBody();
    if ((paramArrayList == null) && (paramInt > 2)) {
      return;
    }
    try
    {
      ((oidb_0x8b8.ReqBody)localObject1).uint64_group_uin.set(Long.parseLong(paramString));
      ((oidb_0x8b8.ReqBody)localObject1).uint32_subcmd.set(paramInt + 1);
      ((oidb_0x8b8.ReqBody)localObject1).uint32_sequence.set(23);
      Object localObject2;
      if (paramInt == 0)
      {
        localObject2 = new oidb_0x8b8.ModifyOrderReq();
        ((oidb_0x8b8.ModifyOrderReq)localObject2).rpt_uint32_pic_list.set(paramArrayList);
        ((oidb_0x8b8.ModifyOrderReq)localObject2).uint32_pic_cnt.set(paramArrayList.size());
        ((oidb_0x8b8.ReqBody)localObject1).msg_modify_order.set((MessageMicro)localObject2);
      }
      for (;;)
      {
        paramArrayList = new oidb_sso.OIDBSSOPkg();
        paramArrayList.uint32_command.set(2232);
        paramArrayList.uint32_service_type.set(1);
        paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8b8.ReqBody)localObject1).toByteArray()));
        localObject1 = a("OidbSvc.0x8b8_1");
        ((ToServiceMsg)localObject1).putWupBuffer(paramArrayList.toByteArray());
        ((ToServiceMsg)localObject1).extraData.putInt("subCmd", paramInt);
        ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
        ((ToServiceMsg)localObject1).setTimeout(30000L);
        b((ToServiceMsg)localObject1);
        return;
        int i1;
        if (paramInt == 1)
        {
          localObject2 = new oidb_0x8b8.SetDefaultReq();
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            i1 = ((Integer)paramArrayList.next()).intValue();
            ((oidb_0x8b8.SetDefaultReq)localObject2).uint32_default_id.set(i1);
          }
          ((oidb_0x8b8.ReqBody)localObject1).msg_set_default.set((MessageMicro)localObject2);
        }
        else if (paramInt == 2)
        {
          localObject2 = new oidb_0x8b8.DelPicReq();
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            i1 = ((Integer)localIterator.next()).intValue();
            ((oidb_0x8b8.DelPicReq)localObject2).rpt_uint32_del_list.add(Integer.valueOf(i1));
          }
          ((oidb_0x8b8.DelPicReq)localObject2).uint32_del_cnt.set(paramArrayList.size());
          ((oidb_0x8b8.ReqBody)localObject1).msg_del_pic.set((MessageMicro)localObject2);
        }
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = new cmd0x8a7.ReqBody();
    ((cmd0x8a7.ReqBody)localObject).uint32_sub_cmd.set(1);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_uin.set(2);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_group.set(1);
    try
    {
      ((cmd0x8a7.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((cmd0x8a7.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString2));
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2215);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(0);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8a7.ReqBody)localObject).toByteArray()));
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x8a7_0");
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString2);
      ((ToServiceMsg)localObject).putWupBuffer(paramString1.toByteArray());
      b((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", troopUin : " + paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("joinGroup", 2, "sourceID:" + paramInt);
    }
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 1);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("back_msg", paramString2);
    localToServiceMsg.extraData.putInt("stat_option", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, ArrayList paramArrayList)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = a("friendlist.GetTroopAppointRemarkReq");
    localToServiceMsg.extraData.putString("GroupUin", paramString1);
    localToServiceMsg.extraData.putString("GroupCode", paramString2);
    localToServiceMsg.extraData.putByte("cRichInfo", (byte)2);
    localToServiceMsg.extraData.putSerializable("vecUinList", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 4);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("Request_uin", paramString2);
    localToServiceMsg.extraData.putByteArray("Auth", paramArrayOfByte);
    localToServiceMsg.extraData.putString("back_msg", paramString3);
    localToServiceMsg.extraData.putLong("infotime", paramLong1);
    localToServiceMsg.extraData.putLong("dbid", paramLong2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 3);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putStringArrayList("frie_uins", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, ArrayList paramArrayList, String paramString2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 8);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putStringArrayList("Invite_uins", paramArrayList);
    localToServiceMsg.extraData.putString("back_msg", paramString2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramString == null) || (paramArrayList1 == null) || (paramArrayList2 == null)) {}
    while (paramArrayList1.size() != paramArrayList2.size()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList1.size())
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList1.get(i1);
      int i2 = ((Integer)paramArrayList2.get(i1)).intValue();
      stUinInfo localstUinInfo = new stUinInfo();
      localstUinInfo.cGender = localTroopMemberCardInfo.sex;
      localstUinInfo.dwuin = Long.parseLong(localTroopMemberCardInfo.memberuin);
      localstUinInfo.sEmail = localTroopMemberCardInfo.email;
      localstUinInfo.sName = localTroopMemberCardInfo.name;
      localstUinInfo.sPhone = localTroopMemberCardInfo.tel;
      localstUinInfo.sRemark = localTroopMemberCardInfo.memo;
      localstUinInfo.dwFlag = i2;
      localArrayList.add(localstUinInfo);
      i1 += 1;
    }
    paramArrayList1 = a("friendlist.ModifyGroupCardReq");
    paramArrayList1.extraData.putLong("dwZero", 0L);
    paramArrayList1.extraData.putLong("dwGroupCode", Long.parseLong(paramString));
    paramArrayList1.extraData.putSerializable("vecUinInfo", localArrayList);
    paramArrayList1.extraData.putLong("dwNewSeq", 0L);
    a(paramArrayList1);
  }
  
  public void a(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList3 == null)) {}
    while ((paramArrayList1.size() != paramArrayList2.size()) || (paramArrayList1.size() != paramArrayList3.size())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramArrayList1.size())
    {
      String str = (String)paramArrayList1.get(i1);
      Object localObject = paramArrayList2.get(i1);
      int i2 = ((Integer)paramArrayList3.get(i1)).intValue();
      stUinInfo localstUinInfo = new stUinInfo();
      localstUinInfo.dwuin = Long.parseLong(str);
      switch (i2)
      {
      }
      for (;;)
      {
        localArrayList.add(localstUinInfo);
        i1 += 1;
        break;
        localstUinInfo.dwFlag = 1L;
        localstUinInfo.sName = ((String)localObject);
        continue;
        localstUinInfo.dwFlag = 2L;
        localstUinInfo.cGender = ((Byte)localObject).byteValue();
        continue;
        localstUinInfo.dwFlag = 4L;
        localstUinInfo.sName = ((String)localObject);
        continue;
        localstUinInfo.dwFlag = 8L;
        localstUinInfo.sName = ((String)localObject);
        continue;
        localstUinInfo.dwFlag = 16L;
        localstUinInfo.sName = ((String)localObject);
      }
    }
    paramArrayList1 = a("friendlist.ModifyGroupCardReq");
    paramArrayList1.extraData.putLong("dwZero", 0L);
    paramArrayList1.extraData.putLong("dwGroupCode", Long.parseLong(paramString));
    paramArrayList1.extraData.putSerializable("vecUinInfo", localArrayList);
    paramArrayList1.extraData.putLong("dwNewSeq", 0L);
    a(paramArrayList1);
  }
  
  public void a(String paramString, List paramList)
  {
    long l2 = -1L;
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopgetnews.", 2, "send_oidb_0x8c9_2, troopUin = " + paramString + ", appIds : " + paramList);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (str != null) {}
    for (;;)
    {
      try
      {
        l1 = Long.valueOf(str).longValue();
        if (paramString != null) {
          l2 = Long.valueOf(paramString).longValue();
        }
        paramString = new oidb_0x8c9.ReqBody();
        paramString.opt_uint64_from_uin.set(l1);
        paramString.opt_uint64_group_code.set(l2);
        paramString.rpt_uint64_appid.set(paramList);
        paramList = new oidb_sso.OIDBSSOPkg();
        paramList.uint32_command.set(2249);
        paramList.uint32_service_type.set(2);
        paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
        paramString = a("OidbSvc.0x8c9_2");
        paramString.putWupBuffer(paramList.toByteArray());
        b(paramString);
        return;
      }
      catch (Exception paramList)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.troopgetnews.", 2, "myUin error: myUin = " + str + ", strTroopUin = " + paramString);
        return;
      }
      long l1 = -1L;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "getTroopShareLink: start");
    }
    join_group_link.ReqBody localReqBody = new join_group_link.ReqBody();
    if (paramBoolean) {
      localReqBody.type.set(1);
    }
    for (;;)
    {
      localReqBody.group_code.set(Long.valueOf(paramString).longValue());
      ToServiceMsg localToServiceMsg = a("GroupSvc.JoinGroupLink");
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      localToServiceMsg.extraData.putBoolean("isVerify", paramBoolean);
      localToServiceMsg.extraData.putString("troopUin", paramString);
      b(localToServiceMsg);
      return;
      localReqBody.type.set(2);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.GetMultiTroopInfoReq");
    localToServiceMsg.extraData.putSerializable("vecGroupCode", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, long paramLong, List paramList)
  {
    oidb_0x8bb.ReqBody localReqBody = new oidb_0x8bb.ReqBody();
    Object localObject = new oidb_0x8bb.GroupConcernedInfo();
    ArrayList localArrayList = new ArrayList();
    long[] arrayOfLong = new long[paramList.size()];
    int i1 = 0;
    while (i1 < paramList.size())
    {
      oidb_0x8bb.UinInfo localUinInfo = new oidb_0x8bb.UinInfo();
      localUinInfo.uint64_uin.set(((Long)paramList.get(i1)).longValue());
      localArrayList.add(localUinInfo);
      arrayOfLong[i1] = ((Long)paramList.get(i1)).longValue();
      i1 += 1;
    }
    ((oidb_0x8bb.GroupConcernedInfo)localObject).rpt_msg_concerned.set(localArrayList);
    ((oidb_0x8bb.GroupConcernedInfo)localObject).uint64_group_code.set(paramLong);
    paramList = new oidb_0x8bb.WriteReq();
    localArrayList = new ArrayList();
    localArrayList.add(localObject);
    paramList.rpt_msg_group_concerned.set(localArrayList);
    localReqBody.msg_write_req.set(paramList);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2235);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    paramList = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type;
    if (paramBoolean)
    {
      i1 = 2;
      paramList.set(i1);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      if (!paramBoolean) {
        break label335;
      }
    }
    label335:
    for (paramList = "OidbSvc.0x8bb_2";; paramList = "OidbSvc.0x8bb_3")
    {
      paramList = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramList);
      paramList.extraData.putLong("troopUin", paramLong);
      paramList.extraData.putLongArray("uinList", arrayOfLong);
      paramList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      b(paramList);
      return;
      i1 = 3;
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.getTroopMemberList");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putBoolean("force_refresh", paramBoolean);
    try
    {
      localToServiceMsg.extraData.putLong("uin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      localToServiceMsg.extraData.putLong("troop_uin", Long.parseLong(paramString1));
      localToServiceMsg.extraData.putLong("troop_code", Long.parseLong(paramString2));
      localToServiceMsg.extraData.putLong("troop_time", System.currentTimeMillis());
      localToServiceMsg.extraData.putLong("version", 2L);
      a(localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "FriendListHandler.getTroopMemberList, troopUin: " + paramString1 + " troopCode: " + paramString2);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_troop_member", 2, "FriendListHandler.getTroopMemberList error, NumberFormatException, troopUin: " + paramString1 + " troopCode: " + paramString2);
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i2 = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.troopgetnews.", 4, "handleTroopNewsOnlinePush.");
    }
    Object localObject2 = new submsgtype0x26.MsgBody();
    long l1;
    label312:
    label378:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            ((submsgtype0x26.MsgBody)localObject2).mergeFrom(paramArrayOfByte);
            if (((submsgtype0x26.MsgBody)localObject2).uint32_sub_cmd.get() == 4)
            {
              if ((!((submsgtype0x26.MsgBody)localObject2).msg_subcmd_0x4_push_body.has()) && (QLog.isColorLevel())) {
                QLog.e("TroopHandler", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
              }
              paramArrayOfByte = (submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)((submsgtype0x26.MsgBody)localObject2).msg_subcmd_0x4_push_body.get();
              if ((paramArrayOfByte.msg_app_id.has()) && (paramArrayOfByte.msg_app_id.uint64_app_id.has()) && (paramArrayOfByte.uint64_group_code.has()) && (paramArrayOfByte.sint32_unread_num.has()))
              {
                l1 = paramArrayOfByte.msg_app_id.uint64_app_id.get();
                long l2 = paramArrayOfByte.uint64_group_code.get();
                if ((paramArrayOfByte.sint32_unread_num.get() == 0) && (l1 == 1102858908L)) {
                  a(60, true, new Object[] { "" + l2, Boolean.valueOf(true) });
                }
              }
            }
            if ((((submsgtype0x26.MsgBody)localObject2).uint32_sub_cmd.has()) && (((submsgtype0x26.MsgBody)localObject2).uint32_sub_cmd.get() == 1)) {
              break label312;
            }
            if (QLog.isDevelopLevel())
            {
              localObject1 = new StringBuilder().append("handleTroopNewsOnlinePush : msgBody is null or NotSupportSubCMd :");
              if (localObject2 == null)
              {
                paramArrayOfByte = "null";
                QLog.e("Q.troopgetnews.", 4, paramArrayOfByte);
              }
            }
            else
            {
              return;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.e("Q.troopgetnews.", 4, "handleTroopNewsOnlinePush : fail to parse submsgtype0x26.");
            return;
          }
          paramArrayOfByte = Integer.valueOf(((submsgtype0x26.MsgBody)localObject2).uint32_sub_cmd.get());
          continue;
          try
          {
            if (((submsgtype0x26.MsgBody)localObject2).rpt_msg_subcmd_0x1_push_body.has()) {
              break label378;
            }
            if (QLog.isDevelopLevel())
            {
              QLog.i("Q.troopgetnews.", 4, "rpt_msg_subcmd_0x1_push_body.has() = false");
              return;
            }
          }
          catch (Exception paramArrayOfByte) {}
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.troopgetnews.", 4, "handleTroopNewsOnlinePush|exception = " + paramArrayOfByte.toString());
      return;
      paramArrayOfByte = ((submsgtype0x26.MsgBody)localObject2).rpt_msg_subcmd_0x1_push_body.get();
      if (paramArrayOfByte != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.e("Q.troopgetnews.", 4, "rpt_msg_subcmd_0x1_push_body is null");
    return;
    Object localObject1 = new ArrayList();
    localObject2 = paramArrayOfByte.iterator();
    paramArrayOfByte = null;
    int i1 = 0;
    for (;;)
    {
      label429:
      if (((Iterator)localObject2).hasNext())
      {
        submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum localSubCmd0x1UpdateAppUnreadNum = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)((Iterator)localObject2).next();
        if (localSubCmd0x1UpdateAppUnreadNum == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.e("Q.troopgetnews.", 4, "unreadNum is null");
          }
        }
        else
        {
          l1 = localSubCmd0x1UpdateAppUnreadNum.msg_app_id.uint64_app_id.get();
          paramArrayOfByte = new TroopUnreadMsgInfo();
          paramArrayOfByte.jdField_a_of_type_Long = l1;
          paramArrayOfByte.jdField_a_of_type_JavaLangString = String.valueOf(localSubCmd0x1UpdateAppUnreadNum.uint64_group_code.get());
          paramArrayOfByte.b = localSubCmd0x1UpdateAppUnreadNum.sint32_unread_num.get();
          i2 += paramArrayOfByte.b;
          paramArrayOfByte.jdField_a_of_type_Int = localSubCmd0x1UpdateAppUnreadNum.sint32_album_cnt.get();
          if (paramArrayOfByte.jdField_a_of_type_Long == 2L)
          {
            DBUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_photo_new", paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.b);
            DBUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_photo_message", paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.jdField_a_of_type_Int);
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.troopgetnews.", 4, "add photoinfo, groupCode = " + paramArrayOfByte.jdField_a_of_type_JavaLangString + ", appid = " + paramArrayOfByte.jdField_a_of_type_Long + ", messageNum = " + paramArrayOfByte.jdField_a_of_type_Int + ", newPhotoes = " + paramArrayOfByte.b);
      }
      ((List)localObject1).add(paramArrayOfByte);
      break label429;
      if (paramArrayOfByte.jdField_a_of_type_Long == 1L)
      {
        DBUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_file_new", paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.b);
      }
      else if (paramArrayOfByte.jdField_a_of_type_Long == 1101236949L)
      {
        DBUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_notification_new", paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.b);
      }
      else if (paramArrayOfByte.jdField_a_of_type_Long == 1101484419L)
      {
        DBUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "group_activity_new_message", paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.b);
      }
      else if ((paramArrayOfByte.jdField_a_of_type_Long == 1102858908L) && (paramArrayOfByte.b == -1))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte.jdField_a_of_type_JavaLangString, Integer.valueOf(-1));
        i1 = 1;
        continue;
        if (i2 != 0) {
          a(29, true, new Object[] { Boolean.valueOf(true), localObject1, Integer.valueOf(-1) });
        }
        while (i1 != 0)
        {
          a(60, true, new Object[] { paramArrayOfByte.jdField_a_of_type_JavaLangString, Boolean.valueOf(false) });
          return;
          a(29, true, new Object[] { Boolean.valueOf(true), localObject1, Integer.valueOf(0) });
        }
        break;
      }
    }
  }
  
  public boolean a(String paramString, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    short s1;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "getTroopCardDefaultNickBatch uin=" + paramString + " size=" + paramArrayList.size() + " time=" + System.currentTimeMillis());
      }
      s1 = (short)paramArrayList.size();
    } while (s1 > 500);
    try
    {
      long l1 = Long.parseLong(paramString);
      Object localObject2 = new oidb_0x787.Filter();
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_uin.set(1);
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_name.set(1);
      ((oidb_0x787.Filter)localObject2).uint32_nick_name.set(1);
      Object localObject1 = new oidb_0x787.ReqBody();
      ((oidb_0x787.ReqBody)localObject1).uint64_group_code.set(l1);
      ((oidb_0x787.ReqBody)localObject1).uint64_begin_uin.set(0L);
      ((oidb_0x787.ReqBody)localObject1).uint64_data_time.set(0L);
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          l1 = Long.parseLong(str);
          ((oidb_0x787.ReqBody)localObject1).rpt_uin_list.add(Long.valueOf(l1));
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler", 2, "getTroopCardDefaultNickBatch parseLong err uin=" + str, localException);
        }
      }
      ((oidb_0x787.ReqBody)localObject1).opt_filter.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1927);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x787_1");
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject1).extraData.putStringArrayList("batchuin", paramArrayList);
      ((ToServiceMsg)localObject1).extraData.putShort("uincount", s1);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x88d_0").append("|troopuin = ").append(paramLong).append("|flag = ").append(paramInt1);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    if ((paramInt1 & 0x2) == 2) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_create_time.set(0);
    }
    if ((paramInt1 & 0x20) == 32) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_member_num.set(0);
    }
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(paramLong);
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    if (paramInt2 > 0) {
      ((oidb_0x88d.ReqGroupInfo)localObject1).uint32_last_get_group_name_time.set(paramInt2);
    }
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong);
    ((ToServiceMsg)localObject2).extraData.putInt("nFlag", paramInt1);
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 1);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt1, List paramList, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("send_oidb_0x899_0").append("|troopuin = ").append(paramLong1).append("|flag = ").append(paramInt1).append("|nStartUin = ").append(paramLong2).append("|memberNum = ").append(paramInt2).append("|filterMethod = ").append(paramInt3);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject).toString());
    }
    oidb_0x899.memberlist localmemberlist = new oidb_0x899.memberlist();
    localmemberlist.uint64_member_uin.set(0L);
    localmemberlist.uint32_shutup_timestap.set(0);
    Object localObject = new oidb_0x899.ReqBody();
    ((oidb_0x899.ReqBody)localObject).uint64_group_code.set(paramLong1);
    ((oidb_0x899.ReqBody)localObject).uint64_start_uin.set(paramLong2);
    if (paramInt1 == 3)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Long localLong = (Long)paramList.next();
        ((oidb_0x899.ReqBody)localObject).rpt_uint64_uin_list.add(localLong);
      }
    }
    ((oidb_0x899.ReqBody)localObject).uint32_identify_flag.set(paramInt1);
    ((oidb_0x899.ReqBody)localObject).memberlist_opt.set(localmemberlist);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2201);
    paramList.uint32_result.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x899.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x899_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("troop_uin", paramLong1);
    ((ToServiceMsg)localObject).extraData.putInt("nFlag", paramInt1);
    ((ToServiceMsg)localObject).extraData.putLong("nStartUin", paramLong2);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "handleGetTroopMemberCard : data==null");
      }
      a(49, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "handleGetTroopMemberCard : resp.isSuccess=" + paramFromServiceMsg.isSuccess());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      a(49, false, null);
      return;
    }
    paramFromServiceMsg = new group_member_info.RspBody();
    int i1;
    int i2;
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      long l1 = paramFromServiceMsg.uint64_group_code.get();
      int i3 = paramFromServiceMsg.uint32_self_role.get();
      paramToServiceMsg = new TroopMemberCard();
      paramToServiceMsg.result = -1;
      if (paramFromServiceMsg.msg_meminfo.has())
      {
        paramFromServiceMsg = (group_member_info.MemberInfo)paramFromServiceMsg.msg_meminfo.get();
        paramToServiceMsg.result = paramFromServiceMsg.uint32_result.get();
        paramToServiceMsg.isAllowModCard = paramFromServiceMsg.bool_is_allow_mod_card.get();
        paramToServiceMsg.memberUin = paramFromServiceMsg.uint64_uin.get();
        paramToServiceMsg.isConcerned = paramFromServiceMsg.bool_is_concerned.get();
        paramToServiceMsg.isFriend = paramFromServiceMsg.bool_is_friend.get();
        paramToServiceMsg.credit = paramFromServiceMsg.uint32_credit.get();
        paramToServiceMsg.sex = -1;
        if (paramFromServiceMsg.uint32_sex.has()) {
          paramToServiceMsg.sex = paramFromServiceMsg.uint32_sex.get();
        }
        paramToServiceMsg.location = "";
        if (paramFromServiceMsg.str_location.has()) {
          paramToServiceMsg.location = paramFromServiceMsg.str_location.get().toStringUtf8();
        }
        paramToServiceMsg.age = paramFromServiceMsg.uint32_age.get();
        paramToServiceMsg.nick = "";
        paramToServiceMsg.remark = "";
        paramToServiceMsg.card = "";
        if (paramFromServiceMsg.str_nick.has()) {
          paramToServiceMsg.nick = paramFromServiceMsg.str_nick.get().toStringUtf8();
        }
        if (paramFromServiceMsg.str_remark.has()) {
          paramToServiceMsg.remark = paramFromServiceMsg.str_remark.get().toStringUtf8();
        }
        if (paramFromServiceMsg.str_card.has()) {
          paramToServiceMsg.card = paramFromServiceMsg.str_card.get().toStringUtf8();
        }
        paramToServiceMsg.levelName = paramFromServiceMsg.str_lev.get().toStringUtf8();
        paramToServiceMsg.memberRole = -1;
        if (paramFromServiceMsg.uint32_role.has()) {
          paramToServiceMsg.memberRole = paramFromServiceMsg.uint32_role.get();
        }
        paramToServiceMsg.joinTime = paramFromServiceMsg.uint64_join.get();
        paramToServiceMsg.lastSpeak = paramFromServiceMsg.uint64_last_speak.get();
        paramToServiceMsg.isVip = paramFromServiceMsg.bool_is_vip.get();
        paramToServiceMsg.isYearVip = paramFromServiceMsg.bool_is_year_vip.get();
        paramToServiceMsg.isSuperVip = paramFromServiceMsg.bool_is_super_vip.get();
        paramToServiceMsg.isSuperQQ = paramFromServiceMsg.bool_is_super_qq.get();
        paramToServiceMsg.vipLevel = paramFromServiceMsg.uint32_vip_lev.get();
        paramToServiceMsg.gbarTitle = paramFromServiceMsg.str_gbar_title.get().toStringUtf8();
        paramToServiceMsg.gbarLinkUrl = paramFromServiceMsg.str_gbar_url.get().toStringUtf8();
        paramToServiceMsg.gbarCount = paramFromServiceMsg.uint32_gbar_cnt.get();
        paramToServiceMsg.gbarList = new ArrayList();
        paramObject = paramFromServiceMsg.rpt_msg_gbar_concerned.get();
        if (paramObject == null) {
          break label895;
        }
        i1 = paramObject.size();
        break label889;
        Object localObject;
        while (i2 < i1)
        {
          localObject = (group_member_info.GBarInfo)paramObject.get(i2);
          TroopMemberCard.GBarInfo localGBarInfo = new TroopMemberCard.GBarInfo();
          localGBarInfo.gbarId = ((group_member_info.GBarInfo)localObject).uint32_gbar_id.get();
          localGBarInfo.level = ((group_member_info.GBarInfo)localObject).uint32_uin_lev.get();
          localGBarInfo.headUrl = ((group_member_info.GBarInfo)localObject).str_head_portrait.get().toStringUtf8();
          paramToServiceMsg.gbarList.add(localGBarInfo);
          i2 += 1;
        }
        paramToServiceMsg.customEntryList = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_custom_enties.get();
        if (paramFromServiceMsg == null) {
          break label907;
        }
        i1 = paramFromServiceMsg.size();
        break label901;
        while (i2 < i1)
        {
          paramObject = (group_member_info.CustomEntry)paramFromServiceMsg.get(i2);
          localObject = new TroopMemberCard.CustomEntry();
          ((TroopMemberCard.CustomEntry)localObject).label = paramObject.str_name.get().toStringUtf8();
          ((TroopMemberCard.CustomEntry)localObject).info = paramObject.str_value.get().toStringUtf8();
          ((TroopMemberCard.CustomEntry)localObject).linkUrl = paramObject.str_url.get().toStringUtf8();
          ((TroopMemberCard.CustomEntry)localObject).isClickable = paramObject.bool_clicked.get();
          ((TroopMemberCard.CustomEntry)localObject).reportId = paramObject.uint64_report_id.get();
          paramToServiceMsg.customEntryList.add(localObject);
          i2 += 1;
        }
      }
      else
      {
        a(49, true, new Object[] { Long.valueOf(l1), Integer.valueOf(i3), paramToServiceMsg });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "onReceive: handleGetTroopMemberCard mergeFrom:" + paramToServiceMsg.toString());
      }
      a(49, false, null);
      return;
    }
    for (;;)
    {
      label889:
      i2 = 0;
      break;
      label895:
      i1 = 0;
    }
    for (;;)
    {
      label901:
      i2 = 0;
      break;
      label907:
      i1 = 0;
    }
  }
  
  public void b(String paramString)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_admin_max_num.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putString("troop_code", paramString);
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 2);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void b(String paramString, int paramInt)
  {
    a(51, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void b(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 6);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("Request_uin", paramString2);
    localToServiceMsg.extraData.putByteArray("Auth", paramArrayOfByte);
    localToServiceMsg.extraData.putString("back_msg", paramString3);
    localToServiceMsg.extraData.putLong("infotime", paramLong1);
    localToServiceMsg.extraData.putLong("dbid", paramLong2);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 6);
    ((ToServiceMsg)localObject2).extraData.putBoolean("needUpdatePreferences", paramBoolean);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.getTroopRemark");
    localToServiceMsg.extraData.putBoolean("force_refresh", paramBoolean);
    localToServiceMsg.extraData.putLong("uin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localToServiceMsg.extraData.putLong("troop_uin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("troop_code", Long.parseLong(paramString2));
    a(localToServiceMsg);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    ToServiceMsg localToServiceMsg = a("friendlist.GetTroopListReqV2");
    localToServiceMsg.extraData.putByte("bGetMSFMsgFlag", (byte)0);
    localToServiceMsg.extraData.putByte("bGroupFlagExt", (byte)1);
    if (paramArrayOfByte != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localToServiceMsg.extraData.putByteArray("vecCookies", paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("Q.getTroopList", 2, "get troop list, cookie != null");
      }
    }
    for (;;)
    {
      a(localToServiceMsg);
      return;
      this.jdField_a_of_type_Boolean = true;
      paramArrayOfByte = new ArrayList();
      Object localObject1 = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((ContactFacade)localObject1).a("-1003");
        if (localObject1 != null)
        {
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "load_trooplist", 0).getBoolean("load_all_1", true);
          while (i1 < ((List)localObject1).size())
          {
            localObject2 = (TroopInfo)((List)localObject1).get(i1);
            stTroopNum localstTroopNum = new stTroopNum();
            localstTroopNum.GroupCode = Long.parseLong(((TroopInfo)localObject2).troopuin);
            if (!bool) {
              localstTroopNum.dwGroupInfoSeq = ((TroopInfo)localObject2).dwGroupInfoSeq;
            }
            localstTroopNum.dwGroupFlagExt = ((TroopInfo)localObject2).dwGroupFlagExt;
            localstTroopNum.dwGroupRankSeq = ((TroopInfo)localObject2).dwGroupLevelSeq;
            paramArrayOfByte.add(localstTroopNum);
            i1 += 1;
          }
        }
      }
      if (!paramArrayOfByte.isEmpty()) {
        localToServiceMsg.extraData.putSerializable("vecGroupInfo", paramArrayOfByte);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayOfByte.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((StringBuilder)localObject1).append(((stTroopNum)((Iterator)localObject2).next()).GroupCode).append(";");
        }
        QLog.d("Q.getTroopList", 2, "get troop list, cookie == null, request size: " + paramArrayOfByte.size() + " request troop uins: " + ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "handleBatchGetTroopInfo");
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    if (bool)
    {
      paramToServiceMsg = (RespBatchProcess)paramObject;
      if ((paramToServiceMsg.batch_response_list != null) && (paramToServiceMsg.batch_response_list.size() != 0)) {}
    }
    else
    {
      return;
    }
    a(32, bool, paramToServiceMsg);
  }
  
  public void c(String paramString)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).string_group_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_face.set(0);
    Object localObject2 = new oidb_0x88d.GroupGeoInfo();
    ((oidb_0x88d.GroupGeoInfo)localObject2).bytes_geocontent.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupGeoInfo)localObject2).int64_latitude.set(0L);
    ((oidb_0x88d.GroupGeoInfo)localObject2).int64_longitude.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).group_geo_info.set((MessageMicro)localObject2);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flag_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).string_certification_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint64_group_owner.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_class_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_type_flag.set(0);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
    localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 4);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void c(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 5);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("Request_uin", paramString2);
    localToServiceMsg.extraData.putByteArray("Auth", paramArrayOfByte);
    localToServiceMsg.extraData.putString("back_msg", paramString3);
    localToServiceMsg.extraData.putLong("infotime", paramLong1);
    localToServiceMsg.extraData.putLong("dbid", paramLong2);
    a(localToServiceMsg);
  }
  
  protected boolean c(String paramString)
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("friendlist.GetTroopListReqV2");
      this.b.add("ProfileService.getGroupInfoReq");
      this.b.add("friendlist.GetMultiTroopInfoReq");
      this.b.add("friendlist.ModifyGroupCardReq");
      this.b.add("friendlist.ModifyGroupInfoReq");
      this.b.add("friendlist.GetTroopAppointRemarkReq");
      this.b.add("friendlist.getTroopMemberList");
      this.b.add("group_member_card.get_group_member_card_info");
      this.b.add("OidbSvc.0x8a0_0");
      this.b.add("friendlist.getTroopRemark");
      this.b.add("OidbSvc.0x88d_0");
      this.b.add("OidbSvc.0x899_0");
      this.b.add("OidbSvc.0x88d_7");
      this.b.add("OidbSvc.0x89e_0");
      this.b.add("OidbSvc.0x8b8_1");
      this.b.add("OidbSvc.0x8c9_2");
      this.b.add("OidbSvc.0x8fd_0");
      this.b.add("OidbSvc.0x88d_1");
      this.b.add("OidbSvc.0x88d_10");
      this.b.add("ProfileService.ReqBatchProcess");
      this.b.add("GroupSvc.JoinGroupLink");
      this.b.add("ProfileService.GroupMngReq");
      this.b.add("anony_msg.group");
      this.b.add("OidbSvc.0x8bb_2");
      this.b.add("OidbSvc.0x8bb_3");
      this.b.add("OidbSvc.0x8b4");
      this.b.add("OidbSvc.0x5d6_3");
      this.b.add("OidbSvc.0x787_0");
      this.b.add("OidbSvc.0x8a7_0");
      this.b.add("OidbSvc.0x8ca_2");
      this.b.add("OidbSvc.0x787_1");
    }
    return !this.b.contains(paramString);
  }
  
  /* Error */
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: sipush 1000
    //   7: if_icmpne +425 -> 432
    //   10: new 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   13: dup
    //   14: invokespecial 1358	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   17: aload_3
    //   18: checkcast 1359	[B
    //   21: checkcast 1359	[B
    //   24: invokevirtual 1360	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +46 -> 78
    //   35: aload_1
    //   36: getfield 1364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   39: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   42: istore 4
    //   44: invokestatic 2665	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +31 -> 78
    //   50: ldc_w 2593
    //   53: iconst_4
    //   54: new 240	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 3141
    //   64: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload 4
    //   69: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_1
    //   79: ifnull +353 -> 432
    //   82: aload_1
    //   83: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   86: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   89: ifeq +343 -> 432
    //   92: aload_1
    //   93: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   96: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   99: ifnull +333 -> 432
    //   102: aload_1
    //   103: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   106: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   109: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   112: astore_1
    //   113: new 3143	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody
    //   116: dup
    //   117: invokespecial 3144	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:<init>	()V
    //   120: astore_3
    //   121: aload_3
    //   122: aload_1
    //   123: invokevirtual 3145	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   126: pop
    //   127: aload_3
    //   128: getfield 3146	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:opt_uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   131: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   134: lstore 5
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_3
    //   139: getfield 3149	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:rpt_group_app_unread_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   142: invokevirtual 2711	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   145: ifeq +520 -> 665
    //   148: aload_3
    //   149: getfield 3149	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:rpt_group_app_unread_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   152: invokevirtual 1474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   155: astore_1
    //   156: new 358	java/util/ArrayList
    //   159: dup
    //   160: invokespecial 359	java/util/ArrayList:<init>	()V
    //   163: astore_2
    //   164: aload_1
    //   165: invokeinterface 1540 1 0
    //   170: astore 9
    //   172: aconst_null
    //   173: astore_1
    //   174: iconst_0
    //   175: istore 4
    //   177: aload 9
    //   179: invokeinterface 380 1 0
    //   184: ifeq +448 -> 632
    //   187: aload 9
    //   189: invokeinterface 384 1 0
    //   194: checkcast 3151	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo
    //   197: astore 10
    //   199: aload 10
    //   201: getfield 3152	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo:opt_uint64_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   204: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   207: lstore 7
    //   209: new 2724	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo
    //   212: dup
    //   213: invokespecial 2725	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:<init>	()V
    //   216: astore_1
    //   217: aload_1
    //   218: lload 7
    //   220: putfield 2726	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   223: aload_1
    //   224: lload 5
    //   226: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   229: putfield 2728	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   232: aload_1
    //   233: aload 10
    //   235: getfield 3155	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo:opt_int32_group_unread_num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   238: invokevirtual 306	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   241: putfield 2730	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   244: aload_1
    //   245: aload 10
    //   247: getfield 3158	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo:opt_int32_group_album_passive_cnt	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   250: invokevirtual 306	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   253: putfield 2734	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   256: aload_1
    //   257: getfield 2726	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   260: ldc2_w 117
    //   263: lcmp
    //   264: ifne +169 -> 433
    //   267: aload_0
    //   268: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: invokevirtual 721	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   274: ldc_w 2736
    //   277: lload 5
    //   279: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   282: aload_1
    //   283: getfield 2730	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   286: invokestatic 2739	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   289: aload_0
    //   290: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   293: invokevirtual 721	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   296: ldc_w 2741
    //   299: lload 5
    //   301: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   304: aload_1
    //   305: getfield 2734	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   308: invokestatic 2739	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   311: invokestatic 2665	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   314: ifeq +70 -> 384
    //   317: ldc_w 2593
    //   320: iconst_4
    //   321: new 240	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   328: ldc_w 2743
    //   331: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: lload 5
    //   336: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   339: ldc_w 2745
    //   342: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_1
    //   346: getfield 2726	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   349: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: ldc_w 2747
    //   355: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_1
    //   359: getfield 2734	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   362: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: ldc_w 2749
    //   368: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_1
    //   372: getfield 2730	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   375: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload_2
    //   385: aload_1
    //   386: invokeinterface 1046 2 0
    //   391: pop
    //   392: goto -215 -> 177
    //   395: astore_1
    //   396: invokestatic 2665	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   399: ifeq +33 -> 432
    //   402: ldc_w 2593
    //   405: iconst_4
    //   406: new 240	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 3160
    //   416: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_1
    //   420: invokevirtual 1651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   423: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: return
    //   433: aload_1
    //   434: getfield 2726	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   437: lconst_1
    //   438: lcmp
    //   439: ifne +28 -> 467
    //   442: aload_0
    //   443: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   446: invokevirtual 721	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   449: ldc_w 2751
    //   452: lload 5
    //   454: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   457: aload_1
    //   458: getfield 2730	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   461: invokestatic 2739	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   464: goto -153 -> 311
    //   467: aload_1
    //   468: getfield 2726	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   471: ldc2_w 128
    //   474: lcmp
    //   475: ifne +28 -> 503
    //   478: aload_0
    //   479: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   482: invokevirtual 721	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   485: ldc_w 2753
    //   488: lload 5
    //   490: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   493: aload_1
    //   494: getfield 2730	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   497: invokestatic 2739	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   500: goto -189 -> 311
    //   503: aload_1
    //   504: getfield 2726	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   507: ldc2_w 133
    //   510: lcmp
    //   511: ifne +28 -> 539
    //   514: aload_0
    //   515: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   518: invokevirtual 721	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   521: ldc_w 2755
    //   524: lload 5
    //   526: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   529: aload_1
    //   530: getfield 2730	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   533: invokestatic 2739	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   536: goto -225 -> 311
    //   539: aload_1
    //   540: getfield 2726	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   543: ldc2_w 138
    //   546: lcmp
    //   547: ifne +154 -> 701
    //   550: aload_1
    //   551: getfield 2730	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   554: iconst_m1
    //   555: if_icmpne +21 -> 576
    //   558: aload_0
    //   559: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   562: aload_1
    //   563: getfield 2728	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   566: iconst_m1
    //   567: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   570: invokestatic 1899	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Integer;)V
    //   573: goto +131 -> 704
    //   576: aload_0
    //   577: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   580: aload_1
    //   581: getfield 2728	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   584: iconst_0
    //   585: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   588: invokestatic 1899	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Integer;)V
    //   591: goto +113 -> 704
    //   594: astore_1
    //   595: invokestatic 2665	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   598: ifeq -166 -> 432
    //   601: ldc_w 2593
    //   604: iconst_4
    //   605: new 240	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   612: ldc_w 3162
    //   615: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload_1
    //   619: invokevirtual 1639	java/lang/Exception:toString	()Ljava/lang/String;
    //   622: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: return
    //   632: iload 4
    //   634: ifeq +76 -> 710
    //   637: aload_0
    //   638: bipush 60
    //   640: iconst_1
    //   641: iconst_2
    //   642: anewarray 606	java/lang/Object
    //   645: dup
    //   646: iconst_0
    //   647: aload_1
    //   648: getfield 2728	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   651: aastore
    //   652: dup
    //   653: iconst_1
    //   654: iconst_0
    //   655: invokestatic 618	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   658: aastore
    //   659: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   662: goto +48 -> 710
    //   665: aload_0
    //   666: bipush 29
    //   668: iconst_1
    //   669: iconst_3
    //   670: anewarray 606	java/lang/Object
    //   673: dup
    //   674: iconst_0
    //   675: iconst_0
    //   676: invokestatic 618	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   679: aastore
    //   680: dup
    //   681: iconst_1
    //   682: aload_1
    //   683: aastore
    //   684: dup
    //   685: iconst_2
    //   686: aload_3
    //   687: getfield 3165	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:opt_int32_show_red_point_mobile	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   690: invokevirtual 306	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   693: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   696: aastore
    //   697: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   700: return
    //   701: goto -390 -> 311
    //   704: iconst_1
    //   705: istore 4
    //   707: goto -396 -> 311
    //   710: aload_2
    //   711: astore_1
    //   712: goto -47 -> 665
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	715	0	this	TroopHandler
    //   0	715	1	paramToServiceMsg	ToServiceMsg
    //   0	715	2	paramFromServiceMsg	FromServiceMsg
    //   0	715	3	paramObject	Object
    //   42	664	4	i1	int
    //   134	391	5	l1	long
    //   207	12	7	l2	long
    //   170	18	9	localIterator	Iterator
    //   197	49	10	localGroupAppUnreadInfo	tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.GroupAppUnreadInfo
    // Exception table:
    //   from	to	target	type
    //   10	31	395	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	136	594	java/lang/Exception
    //   138	172	594	java/lang/Exception
    //   177	311	594	java/lang/Exception
    //   311	384	594	java/lang/Exception
    //   384	392	594	java/lang/Exception
    //   433	464	594	java/lang/Exception
    //   467	500	594	java/lang/Exception
    //   503	536	594	java/lang/Exception
    //   539	573	594	java/lang/Exception
    //   576	591	594	java/lang/Exception
    //   637	662	594	java/lang/Exception
    //   665	700	594	java/lang/Exception
  }
  
  public void d(String paramString)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).string_group_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_face.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_type_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).string_certification_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(0L);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_class_ext.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(10);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_10");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
    b((ToServiceMsg)localObject2);
  }
  
  public void d(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 7);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("Request_uin", paramString2);
    localToServiceMsg.extraData.putByteArray("Auth", paramArrayOfByte);
    localToServiceMsg.extraData.putString("back_msg", paramString3);
    localToServiceMsg.extraData.putLong("infotime", paramLong1);
    localToServiceMsg.extraData.putLong("dbid", paramLong2);
    a(localToServiceMsg);
  }
  
  /* Error */
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 10
    //   6: aconst_null
    //   7: astore 20
    //   9: aconst_null
    //   10: astore 19
    //   12: aconst_null
    //   13: astore 22
    //   15: aconst_null
    //   16: astore 21
    //   18: aload_1
    //   19: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 659
    //   25: invokevirtual 794	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   28: lstore 17
    //   30: aload_1
    //   31: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   34: ldc_w 1641
    //   37: invokevirtual 657	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   40: istore 5
    //   42: aload_1
    //   43: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   46: ldc_w 2143
    //   49: invokevirtual 794	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   52: lstore 11
    //   54: iconst_m1
    //   55: istore 4
    //   57: iload 4
    //   59: istore 6
    //   61: aload_2
    //   62: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   65: sipush 1000
    //   68: if_icmpne +1744 -> 1812
    //   71: new 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   74: dup
    //   75: invokespecial 1358	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload_3
    //   81: checkcast 1359	[B
    //   84: checkcast 1359	[B
    //   87: invokevirtual 1360	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   90: checkcast 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: astore_3
    //   94: aload_3
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull +54 -> 151
    //   100: aload_1
    //   101: getfield 1364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   104: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   107: istore 6
    //   109: iload 6
    //   111: istore 4
    //   113: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +35 -> 151
    //   119: ldc_w 1648
    //   122: iconst_2
    //   123: new 240	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 3167
    //   133: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload 6
    //   138: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: iload 6
    //   149: istore 4
    //   151: iload 4
    //   153: istore 6
    //   155: aload_1
    //   156: ifnull +1656 -> 1812
    //   159: iload 4
    //   161: istore 6
    //   163: aload_1
    //   164: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   167: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   170: ifeq +1642 -> 1812
    //   173: iload 4
    //   175: istore 6
    //   177: aload_1
    //   178: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   181: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   184: ifnull +1628 -> 1812
    //   187: aload_1
    //   188: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   191: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   194: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   197: astore_1
    //   198: new 3169	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   201: dup
    //   202: invokespecial 3170	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   205: astore 22
    //   207: aload 22
    //   209: aload_1
    //   210: invokevirtual 3171	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   213: pop
    //   214: aload 20
    //   216: astore_1
    //   217: iload 4
    //   219: ifeq +111 -> 330
    //   222: aload 20
    //   224: astore_1
    //   225: aload 22
    //   227: getfield 3172	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   230: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   233: ifeq +97 -> 330
    //   236: aload 22
    //   238: getfield 3172	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   241: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   244: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   247: invokestatic 731	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   250: astore 20
    //   252: aload 20
    //   254: astore_1
    //   255: lload 11
    //   257: lstore 15
    //   259: iload 5
    //   261: istore 7
    //   263: aload 21
    //   265: astore_3
    //   266: iload 10
    //   268: istore 9
    //   270: aload 20
    //   272: astore 19
    //   274: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +53 -> 330
    //   280: lload 11
    //   282: lstore 15
    //   284: iload 5
    //   286: istore 7
    //   288: aload 21
    //   290: astore_3
    //   291: iload 10
    //   293: istore 9
    //   295: aload 20
    //   297: astore 19
    //   299: ldc_w 1648
    //   302: iconst_2
    //   303: new 240	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 3174
    //   313: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 20
    //   318: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload 20
    //   329: astore_1
    //   330: iload 4
    //   332: ifne +1472 -> 1804
    //   335: lload 11
    //   337: lstore 15
    //   339: iload 5
    //   341: istore 7
    //   343: aload 21
    //   345: astore_3
    //   346: iload 10
    //   348: istore 9
    //   350: aload_1
    //   351: astore 19
    //   353: aload 22
    //   355: getfield 3175	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   358: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   361: lload 17
    //   363: lcmp
    //   364: ifne +1440 -> 1804
    //   367: iconst_1
    //   368: istore 10
    //   370: lload 11
    //   372: lstore 15
    //   374: iload 5
    //   376: istore 7
    //   378: aload 21
    //   380: astore_3
    //   381: iload 10
    //   383: istore 9
    //   385: aload_1
    //   386: astore 19
    //   388: aload 22
    //   390: getfield 3178	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   393: invokevirtual 1474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   396: astore 20
    //   398: lload 11
    //   400: lstore 13
    //   402: lload 11
    //   404: lstore 15
    //   406: iload 5
    //   408: istore 7
    //   410: aload 20
    //   412: astore_3
    //   413: iload 10
    //   415: istore 9
    //   417: aload_1
    //   418: astore 19
    //   420: aload 22
    //   422: getfield 3179	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint64_start_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   425: invokevirtual 1588	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   428: ifeq +109 -> 537
    //   431: lload 11
    //   433: lstore 15
    //   435: iload 5
    //   437: istore 7
    //   439: aload 20
    //   441: astore_3
    //   442: iload 10
    //   444: istore 9
    //   446: aload_1
    //   447: astore 19
    //   449: aload 22
    //   451: getfield 3179	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint64_start_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   454: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   457: lstore 11
    //   459: lload 11
    //   461: lstore 13
    //   463: lload 11
    //   465: lstore 15
    //   467: iload 5
    //   469: istore 7
    //   471: aload 20
    //   473: astore_3
    //   474: iload 10
    //   476: istore 9
    //   478: aload_1
    //   479: astore 19
    //   481: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +53 -> 537
    //   487: lload 11
    //   489: lstore 15
    //   491: iload 5
    //   493: istore 7
    //   495: aload 20
    //   497: astore_3
    //   498: iload 10
    //   500: istore 9
    //   502: aload_1
    //   503: astore 19
    //   505: ldc_w 1648
    //   508: iconst_2
    //   509: new 240	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   516: ldc_w 3181
    //   519: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: lload 11
    //   524: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   527: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: lload 11
    //   535: lstore 13
    //   537: iload 5
    //   539: istore 6
    //   541: lload 13
    //   543: lstore 15
    //   545: iload 5
    //   547: istore 7
    //   549: aload 20
    //   551: astore_3
    //   552: iload 10
    //   554: istore 9
    //   556: aload_1
    //   557: astore 19
    //   559: aload 22
    //   561: getfield 3182	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint32_identify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   564: invokevirtual 1369	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   567: ifeq +109 -> 676
    //   570: lload 13
    //   572: lstore 15
    //   574: iload 5
    //   576: istore 7
    //   578: aload 20
    //   580: astore_3
    //   581: iload 10
    //   583: istore 9
    //   585: aload_1
    //   586: astore 19
    //   588: aload 22
    //   590: getfield 3182	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint32_identify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   593: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   596: istore 5
    //   598: iload 5
    //   600: istore 6
    //   602: lload 13
    //   604: lstore 15
    //   606: iload 5
    //   608: istore 7
    //   610: aload 20
    //   612: astore_3
    //   613: iload 10
    //   615: istore 9
    //   617: aload_1
    //   618: astore 19
    //   620: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +53 -> 676
    //   626: lload 13
    //   628: lstore 15
    //   630: iload 5
    //   632: istore 7
    //   634: aload 20
    //   636: astore_3
    //   637: iload 10
    //   639: istore 9
    //   641: aload_1
    //   642: astore 19
    //   644: ldc_w 1648
    //   647: iconst_2
    //   648: new 240	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 3184
    //   658: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: iload 5
    //   663: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   666: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: iload 5
    //   674: istore 6
    //   676: iload 6
    //   678: iconst_5
    //   679: if_icmpne +702 -> 1381
    //   682: lload 13
    //   684: lstore 15
    //   686: iload 6
    //   688: istore 7
    //   690: aload 20
    //   692: astore_3
    //   693: iload 10
    //   695: istore 9
    //   697: aload_1
    //   698: astore 19
    //   700: aload_0
    //   701: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   704: bipush 8
    //   706: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   709: checkcast 329	com/tencent/mobileqq/app/FriendsManagerImp
    //   712: astore 23
    //   714: lload 13
    //   716: lstore 15
    //   718: iload 6
    //   720: istore 7
    //   722: aload 20
    //   724: astore_3
    //   725: iload 10
    //   727: istore 9
    //   729: aload_1
    //   730: astore 19
    //   732: aload 23
    //   734: lload 17
    //   736: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   739: invokevirtual 337	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   742: astore 22
    //   744: aload 22
    //   746: astore 21
    //   748: aload 22
    //   750: ifnonnull +58 -> 808
    //   753: lload 13
    //   755: lstore 15
    //   757: iload 6
    //   759: istore 7
    //   761: aload 20
    //   763: astore_3
    //   764: iload 10
    //   766: istore 9
    //   768: aload_1
    //   769: astore 19
    //   771: new 339	com/tencent/mobileqq/data/TroopInfo
    //   774: dup
    //   775: invokespecial 390	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   778: astore 21
    //   780: lload 13
    //   782: lstore 15
    //   784: iload 6
    //   786: istore 7
    //   788: aload 20
    //   790: astore_3
    //   791: iload 10
    //   793: istore 9
    //   795: aload_1
    //   796: astore 19
    //   798: aload 21
    //   800: lload 17
    //   802: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   805: putfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   808: lload 13
    //   810: lstore 15
    //   812: iload 6
    //   814: istore 7
    //   816: aload 20
    //   818: astore_3
    //   819: iload 10
    //   821: istore 9
    //   823: aload_1
    //   824: astore 19
    //   826: aload 21
    //   828: aload 20
    //   830: invokevirtual 3187	com/tencent/mobileqq/data/TroopInfo:updateSomeMemberUins	(Ljava/util/List;)V
    //   833: lload 13
    //   835: lstore 15
    //   837: iload 6
    //   839: istore 7
    //   841: aload 20
    //   843: astore_3
    //   844: iload 10
    //   846: istore 9
    //   848: aload_1
    //   849: astore 19
    //   851: aload 23
    //   853: aload 21
    //   855: invokevirtual 345	com/tencent/mobileqq/app/FriendsManagerImp:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   858: lload 13
    //   860: lstore 15
    //   862: iload 6
    //   864: istore 7
    //   866: aload 20
    //   868: astore_3
    //   869: iload 10
    //   871: istore 9
    //   873: aload_1
    //   874: astore 19
    //   876: aload_0
    //   877: getfield 207	com/tencent/mobileqq/app/TroopHandler:g	J
    //   880: lload 17
    //   882: lcmp
    //   883: ifne +498 -> 1381
    //   886: lload 13
    //   888: lstore 15
    //   890: iload 6
    //   892: istore 7
    //   894: aload 20
    //   896: astore_3
    //   897: iload 10
    //   899: istore 9
    //   901: aload_1
    //   902: astore 19
    //   904: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   907: ifeq +30 -> 937
    //   910: lload 13
    //   912: lstore 15
    //   914: iload 6
    //   916: istore 7
    //   918: aload 20
    //   920: astore_3
    //   921: iload 10
    //   923: istore 9
    //   925: aload_1
    //   926: astore 19
    //   928: ldc 63
    //   930: iconst_2
    //   931: ldc_w 3189
    //   934: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   937: lload 13
    //   939: lstore 15
    //   941: iload 6
    //   943: istore 7
    //   945: aload 20
    //   947: astore_3
    //   948: iload 10
    //   950: istore 9
    //   952: aload_1
    //   953: astore 19
    //   955: aload_0
    //   956: getfield 1904	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   959: ifnonnull +217 -> 1176
    //   962: lload 13
    //   964: lstore 15
    //   966: iload 6
    //   968: istore 7
    //   970: aload 20
    //   972: astore_3
    //   973: iload 10
    //   975: istore 9
    //   977: aload_1
    //   978: astore 19
    //   980: aload_0
    //   981: new 358	java/util/ArrayList
    //   984: dup
    //   985: invokespecial 359	java/util/ArrayList:<init>	()V
    //   988: putfield 1904	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   991: goto +836 -> 1827
    //   994: lload 13
    //   996: lstore 15
    //   998: iload 6
    //   1000: istore 7
    //   1002: aload 20
    //   1004: astore_3
    //   1005: iload 10
    //   1007: istore 9
    //   1009: aload_1
    //   1010: astore 19
    //   1012: iload 5
    //   1014: aload 20
    //   1016: invokeinterface 1085 1 0
    //   1021: if_icmpge +360 -> 1381
    //   1024: lload 13
    //   1026: lstore 15
    //   1028: iload 6
    //   1030: istore 7
    //   1032: aload 20
    //   1034: astore_3
    //   1035: iload 10
    //   1037: istore 9
    //   1039: aload_1
    //   1040: astore 19
    //   1042: aload 20
    //   1044: iload 5
    //   1046: invokeinterface 1086 2 0
    //   1051: checkcast 2116	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist
    //   1054: astore 21
    //   1056: lload 13
    //   1058: lstore 15
    //   1060: iload 6
    //   1062: istore 7
    //   1064: aload 20
    //   1066: astore_3
    //   1067: iload 10
    //   1069: istore 9
    //   1071: aload_1
    //   1072: astore 19
    //   1074: aload 21
    //   1076: getfield 2120	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1079: invokevirtual 1588	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1082: ifeq +40 -> 1122
    //   1085: lload 13
    //   1087: lstore 15
    //   1089: iload 6
    //   1091: istore 7
    //   1093: aload 20
    //   1095: astore_3
    //   1096: iload 10
    //   1098: istore 9
    //   1100: aload_1
    //   1101: astore 19
    //   1103: aload_0
    //   1104: getfield 1904	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1107: aload 21
    //   1109: getfield 2120	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1112: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1115: invokestatic 807	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1118: invokevirtual 468	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1121: pop
    //   1122: iload 5
    //   1124: iconst_1
    //   1125: iadd
    //   1126: istore 5
    //   1128: goto -134 -> 994
    //   1131: astore_3
    //   1132: aconst_null
    //   1133: astore_1
    //   1134: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1137: ifeq +32 -> 1169
    //   1140: ldc 63
    //   1142: iconst_2
    //   1143: new 240	java/lang/StringBuilder
    //   1146: dup
    //   1147: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1150: ldc_w 3191
    //   1153: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: aload_3
    //   1157: invokevirtual 1651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   1160: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1169: aload_3
    //   1170: invokevirtual 1611	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1173: goto -1077 -> 96
    //   1176: lload 13
    //   1178: lstore 15
    //   1180: iload 6
    //   1182: istore 7
    //   1184: aload 20
    //   1186: astore_3
    //   1187: iload 10
    //   1189: istore 9
    //   1191: aload_1
    //   1192: astore 19
    //   1194: aload_0
    //   1195: getfield 1904	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1198: invokevirtual 3194	java/util/ArrayList:clear	()V
    //   1201: goto +626 -> 1827
    //   1204: astore_1
    //   1205: aload 19
    //   1207: astore_1
    //   1208: iload 7
    //   1210: istore 5
    //   1212: lload 15
    //   1214: lstore 11
    //   1216: aload_0
    //   1217: bipush 19
    //   1219: iload 9
    //   1221: bipush 6
    //   1223: anewarray 606	java/lang/Object
    //   1226: dup
    //   1227: iconst_0
    //   1228: lload 17
    //   1230: invokestatic 807	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1233: aastore
    //   1234: dup
    //   1235: iconst_1
    //   1236: iload 5
    //   1238: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1241: aastore
    //   1242: dup
    //   1243: iconst_2
    //   1244: aload_3
    //   1245: aastore
    //   1246: dup
    //   1247: iconst_3
    //   1248: lload 11
    //   1250: invokestatic 807	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1253: aastore
    //   1254: dup
    //   1255: iconst_4
    //   1256: iload 4
    //   1258: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1261: aastore
    //   1262: dup
    //   1263: iconst_5
    //   1264: aload_1
    //   1265: aastore
    //   1266: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1269: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1272: ifeq +108 -> 1380
    //   1275: new 240	java/lang/StringBuilder
    //   1278: dup
    //   1279: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1282: astore_3
    //   1283: aload_3
    //   1284: ldc_w 3196
    //   1287: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: ldc_w 3198
    //   1293: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: iload 9
    //   1298: invokevirtual 1604	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1301: ldc_w 3200
    //   1304: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload_2
    //   1308: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1311: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1314: ldc_w 1995
    //   1317: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: lload 17
    //   1322: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1325: ldc_w 1997
    //   1328: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: iload 5
    //   1333: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1336: ldc_w 3202
    //   1339: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: lload 11
    //   1344: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1347: ldc_w 3204
    //   1350: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: iload 4
    //   1355: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1358: ldc_w 3206
    //   1361: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: aload_1
    //   1365: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: ldc_w 1648
    //   1372: iconst_2
    //   1373: aload_3
    //   1374: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1377: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1380: return
    //   1381: lload 13
    //   1383: lstore 15
    //   1385: iload 6
    //   1387: istore 7
    //   1389: aload 20
    //   1391: astore_3
    //   1392: iload 10
    //   1394: istore 9
    //   1396: aload_1
    //   1397: astore 19
    //   1399: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1402: ifeq +372 -> 1774
    //   1405: lload 13
    //   1407: lstore 15
    //   1409: iload 6
    //   1411: istore 7
    //   1413: aload 20
    //   1415: astore_3
    //   1416: iload 10
    //   1418: istore 9
    //   1420: aload_1
    //   1421: astore 19
    //   1423: new 240	java/lang/StringBuilder
    //   1426: dup
    //   1427: sipush 200
    //   1430: invokespecial 1991	java/lang/StringBuilder:<init>	(I)V
    //   1433: astore 21
    //   1435: lload 13
    //   1437: lstore 15
    //   1439: iload 6
    //   1441: istore 7
    //   1443: aload 20
    //   1445: astore_3
    //   1446: iload 10
    //   1448: istore 9
    //   1450: aload_1
    //   1451: astore 19
    //   1453: aload 21
    //   1455: ldc_w 3196
    //   1458: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: ldc_w 3208
    //   1464: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: lload 13
    //   1469: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1472: ldc_w 3210
    //   1475: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: iload 6
    //   1480: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: aload 20
    //   1486: ifnull +356 -> 1842
    //   1489: lload 13
    //   1491: lstore 15
    //   1493: iload 6
    //   1495: istore 7
    //   1497: aload 20
    //   1499: astore_3
    //   1500: iload 10
    //   1502: istore 9
    //   1504: aload_1
    //   1505: astore 19
    //   1507: aload 20
    //   1509: invokeinterface 1085 1 0
    //   1514: istore 5
    //   1516: lload 13
    //   1518: lstore 15
    //   1520: iload 6
    //   1522: istore 7
    //   1524: aload 20
    //   1526: astore_3
    //   1527: iload 10
    //   1529: istore 9
    //   1531: aload_1
    //   1532: astore 19
    //   1534: aload 21
    //   1536: ldc_w 3212
    //   1539: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: iload 5
    //   1544: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1547: ldc_w 3214
    //   1550: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: pop
    //   1554: iconst_0
    //   1555: istore 8
    //   1557: iload 8
    //   1559: iload 5
    //   1561: if_icmpge +156 -> 1717
    //   1564: lload 13
    //   1566: lstore 15
    //   1568: iload 6
    //   1570: istore 7
    //   1572: aload 20
    //   1574: astore_3
    //   1575: iload 10
    //   1577: istore 9
    //   1579: aload_1
    //   1580: astore 19
    //   1582: aload 20
    //   1584: iload 8
    //   1586: invokeinterface 1086 2 0
    //   1591: checkcast 2116	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist
    //   1594: astore 22
    //   1596: aload 22
    //   1598: ifnull +72 -> 1670
    //   1601: lload 13
    //   1603: lstore 15
    //   1605: iload 6
    //   1607: istore 7
    //   1609: aload 20
    //   1611: astore_3
    //   1612: iload 10
    //   1614: istore 9
    //   1616: aload_1
    //   1617: astore 19
    //   1619: aload 21
    //   1621: ldc_w 3216
    //   1624: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: iload 8
    //   1629: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1632: ldc_w 3218
    //   1635: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: aload 22
    //   1640: getfield 2120	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1643: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1646: ldc_w 3218
    //   1649: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: aload 22
    //   1654: getfield 2130	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint32_uin_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1657: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1660: ldc_w 3220
    //   1663: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: pop
    //   1667: goto +166 -> 1833
    //   1670: lload 13
    //   1672: lstore 15
    //   1674: iload 6
    //   1676: istore 7
    //   1678: aload 20
    //   1680: astore_3
    //   1681: iload 10
    //   1683: istore 9
    //   1685: aload_1
    //   1686: astore 19
    //   1688: aload 21
    //   1690: ldc_w 3216
    //   1693: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1696: iload 8
    //   1698: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1701: ldc_w 3222
    //   1704: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: ldc_w 3220
    //   1710: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: pop
    //   1714: goto +119 -> 1833
    //   1717: lload 13
    //   1719: lstore 15
    //   1721: iload 6
    //   1723: istore 7
    //   1725: aload 20
    //   1727: astore_3
    //   1728: iload 10
    //   1730: istore 9
    //   1732: aload_1
    //   1733: astore 19
    //   1735: aload 21
    //   1737: ldc_w 3224
    //   1740: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: pop
    //   1744: lload 13
    //   1746: lstore 15
    //   1748: iload 6
    //   1750: istore 7
    //   1752: aload 20
    //   1754: astore_3
    //   1755: iload 10
    //   1757: istore 9
    //   1759: aload_1
    //   1760: astore 19
    //   1762: ldc_w 1648
    //   1765: iconst_2
    //   1766: aload 21
    //   1768: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1771: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1774: lload 13
    //   1776: lstore 11
    //   1778: iload 6
    //   1780: istore 5
    //   1782: aload 20
    //   1784: astore_3
    //   1785: iconst_1
    //   1786: istore 9
    //   1788: goto -572 -> 1216
    //   1791: astore_1
    //   1792: aconst_null
    //   1793: astore_1
    //   1794: aload 19
    //   1796: astore_3
    //   1797: goto -581 -> 1216
    //   1800: astore_3
    //   1801: goto -667 -> 1134
    //   1804: aconst_null
    //   1805: astore_3
    //   1806: iconst_0
    //   1807: istore 9
    //   1809: goto -21 -> 1788
    //   1812: iload 6
    //   1814: istore 4
    //   1816: iconst_0
    //   1817: istore 9
    //   1819: aconst_null
    //   1820: astore_1
    //   1821: aload 22
    //   1823: astore_3
    //   1824: goto -608 -> 1216
    //   1827: iconst_0
    //   1828: istore 5
    //   1830: goto -836 -> 994
    //   1833: iload 8
    //   1835: iconst_1
    //   1836: iadd
    //   1837: istore 8
    //   1839: goto -282 -> 1557
    //   1842: iconst_0
    //   1843: istore 5
    //   1845: goto -329 -> 1516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1848	0	this	TroopHandler
    //   0	1848	1	paramToServiceMsg	ToServiceMsg
    //   0	1848	2	paramFromServiceMsg	FromServiceMsg
    //   0	1848	3	paramObject	Object
    //   55	1760	4	i1	int
    //   40	1804	5	i2	int
    //   59	1754	6	i3	int
    //   261	1490	7	i4	int
    //   1555	283	8	i5	int
    //   1	1817	9	bool1	boolean
    //   4	1752	10	bool2	boolean
    //   52	1725	11	l1	long
    //   400	1375	13	l2	long
    //   257	1490	15	l3	long
    //   28	1293	17	l4	long
    //   10	1785	19	localObject1	Object
    //   7	1776	20	localObject2	Object
    //   16	1751	21	localObject3	Object
    //   13	1809	22	localObject4	Object
    //   712	140	23	localFriendsManagerImp	FriendsManagerImp
    // Exception table:
    //   from	to	target	type
    //   71	79	1131	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   274	280	1204	java/lang/Exception
    //   299	327	1204	java/lang/Exception
    //   353	367	1204	java/lang/Exception
    //   388	398	1204	java/lang/Exception
    //   420	431	1204	java/lang/Exception
    //   449	459	1204	java/lang/Exception
    //   481	487	1204	java/lang/Exception
    //   505	533	1204	java/lang/Exception
    //   559	570	1204	java/lang/Exception
    //   588	598	1204	java/lang/Exception
    //   620	626	1204	java/lang/Exception
    //   644	672	1204	java/lang/Exception
    //   700	714	1204	java/lang/Exception
    //   732	744	1204	java/lang/Exception
    //   771	780	1204	java/lang/Exception
    //   798	808	1204	java/lang/Exception
    //   826	833	1204	java/lang/Exception
    //   851	858	1204	java/lang/Exception
    //   876	886	1204	java/lang/Exception
    //   904	910	1204	java/lang/Exception
    //   928	937	1204	java/lang/Exception
    //   955	962	1204	java/lang/Exception
    //   980	991	1204	java/lang/Exception
    //   1012	1024	1204	java/lang/Exception
    //   1042	1056	1204	java/lang/Exception
    //   1074	1085	1204	java/lang/Exception
    //   1103	1122	1204	java/lang/Exception
    //   1194	1201	1204	java/lang/Exception
    //   1399	1405	1204	java/lang/Exception
    //   1423	1435	1204	java/lang/Exception
    //   1453	1484	1204	java/lang/Exception
    //   1507	1516	1204	java/lang/Exception
    //   1534	1554	1204	java/lang/Exception
    //   1582	1596	1204	java/lang/Exception
    //   1619	1667	1204	java/lang/Exception
    //   1688	1714	1204	java/lang/Exception
    //   1735	1744	1204	java/lang/Exception
    //   1762	1774	1204	java/lang/Exception
    //   198	214	1791	java/lang/Exception
    //   225	252	1791	java/lang/Exception
    //   79	94	1800	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void e(String paramString)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.set(0);
    Object localObject2 = new oidb_0x88d.GroupHeadPortrait();
    ((oidb_0x88d.GroupInfo)localObject1).msg_head_portrait.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    try
    {
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString));
      ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
      localObject1 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(7);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x88d_7");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  /* Error */
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 12
    //   3: iconst_0
    //   4: istore 11
    //   6: iconst_0
    //   7: istore 10
    //   9: aconst_null
    //   10: astore 18
    //   12: aconst_null
    //   13: astore 17
    //   15: aconst_null
    //   16: astore 19
    //   18: aload_1
    //   19: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 659
    //   25: invokevirtual 794	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   28: lstore 13
    //   30: aload_1
    //   31: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   34: ldc_w 1641
    //   37: invokevirtual 657	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   40: istore 9
    //   42: iconst_m1
    //   43: istore 4
    //   45: iload 4
    //   47: istore 5
    //   49: aload_2
    //   50: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   53: sipush 1000
    //   56: if_icmpne +976 -> 1032
    //   59: new 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   62: dup
    //   63: invokespecial 1358	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   66: astore_1
    //   67: aload_1
    //   68: aload_3
    //   69: checkcast 1359	[B
    //   72: checkcast 1359	[B
    //   75: invokevirtual 1360	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: checkcast 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   81: astore_3
    //   82: aload_3
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +54 -> 139
    //   88: aload_1
    //   89: getfield 1364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   92: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   95: istore 5
    //   97: iload 5
    //   99: istore 4
    //   101: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +35 -> 139
    //   107: ldc_w 1648
    //   110: iconst_2
    //   111: new 240	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 3237
    //   121: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload 5
    //   126: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: iload 5
    //   137: istore 4
    //   139: iload 4
    //   141: istore 5
    //   143: aload_1
    //   144: ifnull +888 -> 1032
    //   147: iload 4
    //   149: istore 5
    //   151: aload_1
    //   152: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   155: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   158: ifeq +874 -> 1032
    //   161: iload 4
    //   163: istore 5
    //   165: aload_1
    //   166: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   169: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   172: ifnull +860 -> 1032
    //   175: aload_1
    //   176: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   179: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   182: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   185: astore_1
    //   186: new 1613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   189: dup
    //   190: invokespecial 1614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   193: astore 19
    //   195: aload 19
    //   197: aload_1
    //   198: invokevirtual 1615	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   201: pop
    //   202: iload 4
    //   204: ifeq +823 -> 1027
    //   207: aload 19
    //   209: getfield 1646	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   212: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   215: ifeq +812 -> 1027
    //   218: aload 19
    //   220: getfield 1646	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   223: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   226: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   229: invokestatic 731	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_3
    //   235: iload 4
    //   237: istore 5
    //   239: aload 17
    //   241: astore 18
    //   243: iload 11
    //   245: istore 10
    //   247: aload 19
    //   249: getfield 1618	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   252: invokevirtual 1474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   255: astore 19
    //   257: aload 19
    //   259: ifnonnull +140 -> 399
    //   262: iconst_0
    //   263: istore 7
    //   265: goto +777 -> 1042
    //   268: aload_3
    //   269: ifnonnull +239 -> 508
    //   272: iload 8
    //   274: iload 7
    //   276: if_icmpge +232 -> 508
    //   279: iload 4
    //   281: istore 5
    //   283: aload 17
    //   285: astore 18
    //   287: iload 11
    //   289: istore 10
    //   291: aload 19
    //   293: iload 8
    //   295: invokeinterface 1086 2 0
    //   300: checkcast 1620	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   303: astore 20
    //   305: iload 4
    //   307: istore 6
    //   309: aload 20
    //   311: ifnull +709 -> 1020
    //   314: iload 4
    //   316: istore 5
    //   318: aload 17
    //   320: astore 18
    //   322: iload 11
    //   324: istore 10
    //   326: aload 20
    //   328: getfield 1624	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   331: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   334: lstore 15
    //   336: lload 15
    //   338: lload 13
    //   340: lcmp
    //   341: ifeq +82 -> 423
    //   344: iload 8
    //   346: iconst_1
    //   347: iadd
    //   348: istore 8
    //   350: goto -82 -> 268
    //   353: astore_3
    //   354: aconst_null
    //   355: astore_1
    //   356: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +33 -> 392
    //   362: ldc_w 1648
    //   365: iconst_2
    //   366: new 240	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 3239
    //   376: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_3
    //   380: invokevirtual 1651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   383: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: aload_3
    //   393: invokevirtual 1611	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   396: goto -312 -> 84
    //   399: iload 4
    //   401: istore 5
    //   403: aload 17
    //   405: astore 18
    //   407: iload 11
    //   409: istore 10
    //   411: aload 19
    //   413: invokeinterface 1085 1 0
    //   418: istore 7
    //   420: goto +622 -> 1042
    //   423: iload 4
    //   425: istore 5
    //   427: aload 17
    //   429: astore 18
    //   431: iload 11
    //   433: istore 10
    //   435: aload 20
    //   437: getfield 1621	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   440: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   443: istore 4
    //   445: iload 4
    //   447: istore 6
    //   449: iload 4
    //   451: ifne +569 -> 1020
    //   454: iload 4
    //   456: istore 5
    //   458: aload 17
    //   460: astore 18
    //   462: iload 11
    //   464: istore 10
    //   466: iload 4
    //   468: istore 6
    //   470: aload 20
    //   472: getfield 1628	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   475: invokevirtual 1631	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   478: ifeq +542 -> 1020
    //   481: iload 4
    //   483: istore 5
    //   485: aload 17
    //   487: astore 18
    //   489: iload 11
    //   491: istore 10
    //   493: aload 20
    //   495: getfield 1628	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   498: invokevirtual 1632	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   501: checkcast 1630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   504: astore_3
    //   505: goto -161 -> 344
    //   508: aload_3
    //   509: ifnull +503 -> 1012
    //   512: iconst_1
    //   513: istore 12
    //   515: iconst_1
    //   516: istore 11
    //   518: iload 4
    //   520: istore 5
    //   522: aload 17
    //   524: astore 18
    //   526: iload 12
    //   528: istore 10
    //   530: aload_0
    //   531: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   534: bipush 8
    //   536: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   539: checkcast 329	com/tencent/mobileqq/app/FriendsManagerImp
    //   542: astore 19
    //   544: iload 4
    //   546: istore 5
    //   548: aload 17
    //   550: astore 18
    //   552: iload 12
    //   554: istore 10
    //   556: aload 19
    //   558: lload 13
    //   560: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   563: invokevirtual 337	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   566: astore 17
    //   568: aload 17
    //   570: ifnonnull +439 -> 1009
    //   573: iload 4
    //   575: istore 5
    //   577: aload 17
    //   579: astore 18
    //   581: iload 12
    //   583: istore 10
    //   585: new 339	com/tencent/mobileqq/data/TroopInfo
    //   588: dup
    //   589: invokespecial 390	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   592: astore 17
    //   594: aload 17
    //   596: lload 13
    //   598: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   601: putfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   604: aload_3
    //   605: getfield 2810	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   608: invokevirtual 1369	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   611: ifeq +53 -> 664
    //   614: aload 17
    //   616: aload_3
    //   617: getfield 2810	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   620: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   623: i2l
    //   624: putfield 576	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   627: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   630: ifeq +34 -> 664
    //   633: ldc_w 1648
    //   636: iconst_2
    //   637: new 240	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   644: ldc_w 3241
    //   647: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: aload 17
    //   652: getfield 576	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   655: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   658: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: aload_3
    //   665: getfield 2813	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   668: invokevirtual 1369	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   671: ifeq +52 -> 723
    //   674: aload 17
    //   676: aload_3
    //   677: getfield 2813	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   680: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   683: putfield 452	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   686: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   689: ifeq +34 -> 723
    //   692: ldc_w 1648
    //   695: iconst_2
    //   696: new 240	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 3243
    //   706: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload 17
    //   711: getfield 452	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   714: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   717: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   723: aload 19
    //   725: aload 17
    //   727: invokevirtual 345	com/tencent/mobileqq/app/FriendsManagerImp:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   730: aload 17
    //   732: astore_3
    //   733: iconst_1
    //   734: istore 10
    //   736: iload 10
    //   738: istore 11
    //   740: aload_3
    //   741: astore 19
    //   743: iload 4
    //   745: istore 5
    //   747: aload_1
    //   748: astore 18
    //   750: aload_0
    //   751: bipush 18
    //   753: iload 11
    //   755: iconst_5
    //   756: anewarray 606	java/lang/Object
    //   759: dup
    //   760: iconst_0
    //   761: lload 13
    //   763: invokestatic 807	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   766: aastore
    //   767: dup
    //   768: iconst_1
    //   769: iload 9
    //   771: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   774: aastore
    //   775: dup
    //   776: iconst_2
    //   777: aload 19
    //   779: aastore
    //   780: dup
    //   781: iconst_3
    //   782: iload 5
    //   784: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   787: aastore
    //   788: dup
    //   789: iconst_4
    //   790: aload 18
    //   792: aastore
    //   793: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   796: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   799: ifeq +101 -> 900
    //   802: new 240	java/lang/StringBuilder
    //   805: dup
    //   806: sipush 150
    //   809: invokespecial 1991	java/lang/StringBuilder:<init>	(I)V
    //   812: astore_1
    //   813: aload_1
    //   814: ldc_w 3245
    //   817: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: ldc_w 3198
    //   823: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: iload 11
    //   828: invokevirtual 1604	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   831: ldc_w 3200
    //   834: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: aload_2
    //   838: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   841: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: ldc_w 1995
    //   847: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: lload 13
    //   852: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   855: ldc_w 1997
    //   858: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: iload 9
    //   863: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   866: ldc_w 3204
    //   869: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: iload 5
    //   874: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   877: ldc_w 3206
    //   880: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload 18
    //   885: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: ldc_w 1648
    //   892: iconst_2
    //   893: aload_1
    //   894: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   897: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   900: return
    //   901: astore 17
    //   903: aconst_null
    //   904: astore_1
    //   905: iload 12
    //   907: istore 10
    //   909: aload 18
    //   911: astore_3
    //   912: aload_1
    //   913: astore 18
    //   915: iload 4
    //   917: istore 5
    //   919: aload_3
    //   920: astore 19
    //   922: iload 10
    //   924: istore 11
    //   926: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   929: ifeq -179 -> 750
    //   932: ldc_w 1648
    //   935: iconst_2
    //   936: aload 17
    //   938: invokevirtual 1639	java/lang/Exception:toString	()Ljava/lang/String;
    //   941: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   944: aload_1
    //   945: astore 18
    //   947: iload 4
    //   949: istore 5
    //   951: aload_3
    //   952: astore 19
    //   954: iload 10
    //   956: istore 11
    //   958: goto -208 -> 750
    //   961: astore 17
    //   963: iload 5
    //   965: istore 4
    //   967: aload 18
    //   969: astore_3
    //   970: goto -58 -> 912
    //   973: astore 18
    //   975: aload 17
    //   977: astore_3
    //   978: aload 18
    //   980: astore 17
    //   982: iload 11
    //   984: istore 10
    //   986: goto -74 -> 912
    //   989: astore 18
    //   991: aload 17
    //   993: astore_3
    //   994: aload 18
    //   996: astore 17
    //   998: iload 11
    //   1000: istore 10
    //   1002: goto -90 -> 912
    //   1005: astore_3
    //   1006: goto -650 -> 356
    //   1009: goto -405 -> 604
    //   1012: aconst_null
    //   1013: astore_3
    //   1014: iconst_0
    //   1015: istore 10
    //   1017: goto -281 -> 736
    //   1020: iload 6
    //   1022: istore 4
    //   1024: goto -680 -> 344
    //   1027: aconst_null
    //   1028: astore_1
    //   1029: goto -796 -> 233
    //   1032: aconst_null
    //   1033: astore 18
    //   1035: iload 10
    //   1037: istore 11
    //   1039: goto -289 -> 750
    //   1042: iconst_0
    //   1043: istore 8
    //   1045: goto -777 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1048	0	this	TroopHandler
    //   0	1048	1	paramToServiceMsg	ToServiceMsg
    //   0	1048	2	paramFromServiceMsg	FromServiceMsg
    //   0	1048	3	paramObject	Object
    //   43	980	4	i1	int
    //   47	917	5	i2	int
    //   307	714	6	i3	int
    //   263	156	7	i4	int
    //   272	772	8	i5	int
    //   40	822	9	i6	int
    //   7	1029	10	bool1	boolean
    //   4	1034	11	bool2	boolean
    //   1	905	12	bool3	boolean
    //   28	823	13	l1	long
    //   334	3	15	l2	long
    //   13	718	17	localTroopInfo	TroopInfo
    //   901	36	17	localException1	Exception
    //   961	15	17	localException2	Exception
    //   980	17	17	localException3	Exception
    //   10	958	18	localObject1	Object
    //   973	6	18	localException4	Exception
    //   989	6	18	localException5	Exception
    //   1033	1	18	localObject2	Object
    //   16	937	19	localObject3	Object
    //   303	191	20	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    // Exception table:
    //   from	to	target	type
    //   59	67	353	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   186	202	901	java/lang/Exception
    //   207	233	901	java/lang/Exception
    //   247	257	961	java/lang/Exception
    //   291	305	961	java/lang/Exception
    //   326	336	961	java/lang/Exception
    //   411	420	961	java/lang/Exception
    //   435	445	961	java/lang/Exception
    //   470	481	961	java/lang/Exception
    //   493	505	961	java/lang/Exception
    //   530	544	961	java/lang/Exception
    //   556	568	961	java/lang/Exception
    //   585	594	961	java/lang/Exception
    //   594	604	973	java/lang/Exception
    //   604	664	989	java/lang/Exception
    //   664	723	989	java/lang/Exception
    //   723	730	989	java/lang/Exception
    //   67	82	1005	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void f(String paramString)
  {
    long l2 = -1L;
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopgetnews.", 2, "send_oidb_0x8c9_2, troopUin = " + paramString);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        l1 = Long.valueOf((String)localObject).longValue();
        if (paramString != null) {
          l2 = Long.valueOf(paramString).longValue();
        }
        paramString = new oidb_0x8c9.ReqBody();
        localObject = new ArrayList();
        ((ArrayList)localObject).add(Long.valueOf(2L));
        ((ArrayList)localObject).add(Long.valueOf(1L));
        ((ArrayList)localObject).add(Long.valueOf(1101236949L));
        ((ArrayList)localObject).add(Long.valueOf(1101484419L));
        paramString.opt_uint64_from_uin.set(l1);
        paramString.opt_uint64_group_code.set(l2);
        paramString.rpt_uint64_appid.set((List)localObject);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2249);
        ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
        ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
        paramString = a("OidbSvc.0x8c9_2");
        paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
        b(paramString);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.troopgetnews.", 2, "myUin error: myUin = " + (String)localObject + ", strTroopUin = " + paramString);
        return;
      }
      long l1 = -1L;
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i1 = paramToServiceMsg.extraData.getInt("subCmd");
    if (paramFromServiceMsg.getResultCode() == 1000) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    int i2;
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramObject;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      TroopInfo localTroopInfo;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x8b8_1|oidb_sso parseFrom byte " + paramObject.toString());
        }
        paramObject.printStackTrace();
      }
      if (localTroopInfo == null) {
        break label374;
      }
      localTroopInfo.mTroopAvatarId = paramToServiceMsg.uint32_default_id.get();
      localTroopInfo.mTroopPicList = localArrayList;
      paramObject.b(localTroopInfo);
      label374:
      if (localTroopInfo == null) {
        break label514;
      }
    }
    if (paramToServiceMsg != null)
    {
      i2 = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopdisband.", 2, "handle_oidb_0x8b8_1|oidb_sso.OIDBSSOPkg.result " + i2);
      }
    }
    ArrayList localArrayList;
    if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      paramObject = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      try
      {
        paramToServiceMsg = new oidb_0x8b8.RspBody();
        paramToServiceMsg.mergeFrom(paramObject);
        i2 = paramToServiceMsg.uint32_result.get();
        paramToServiceMsg.uint32_sequence.get();
        paramToServiceMsg.uint32_subcmd.get();
        paramToServiceMsg.uint64_group_uin.get();
        paramObject = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        localTroopInfo = paramObject.a(String.valueOf(l1));
        localArrayList = new ArrayList();
        Iterator localIterator = paramToServiceMsg.rpt_uint32_pic_list.get().iterator();
        while (localIterator.hasNext())
        {
          int i3 = ((Integer)localIterator.next()).intValue();
          if (i3 >= 0)
          {
            localArrayList.add(String.valueOf(i3));
            continue;
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        }
      }
    }
    for (;;)
    {
      a(46, false, new Object[] { String.valueOf(l1), Integer.valueOf(i2), null, Integer.valueOf(i1), null });
      while (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder(150);
        paramToServiceMsg.append("handle_oidb_0x8b8_1").append("|isSuccess = ").append(false).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|result = ").append(i2).append("|strErrorMsg = ").append(null);
        QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        return;
        label514:
        a(46, false, new Object[] { String.valueOf(l1), Integer.valueOf(i2), null, Integer.valueOf(i1), localArrayList });
      }
    }
  }
  
  public void g(String paramString)
  {
    oidb_0x787.Filter localFilter = new oidb_0x787.Filter();
    localFilter.uint32_member_level_info_uin.set(0);
    localFilter.uint32_member_level_info_point.set(0);
    localFilter.uint32_member_level_info_active_day.set(0);
    localFilter.uint32_member_level_info_level.set(0);
    localFilter.uint32_level_name.set(1);
    localFilter.uint32_data_time.set(0);
    localFilter.uint32_sys_show_flag.set(0);
    localFilter.uint32_user_show_flag.set(0);
    Object localObject = new oidb_0x787.ReqBody();
    ((oidb_0x787.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x787.ReqBody)localObject).uint64_begin_uin.set(0L);
    ((oidb_0x787.ReqBody)localObject).uint64_data_time.set(0L);
    ((oidb_0x787.ReqBody)localObject).rpt_uin_list.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
    ((oidb_0x787.ReqBody)localObject).opt_filter.set(localFilter);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1927);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x787_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool4 = false;
    boolean bool3 = false;
    bool1 = false;
    localObject1 = null;
    Object localObject10 = null;
    localObject9 = null;
    localObject7 = null;
    Object localObject11 = null;
    i5 = -1;
    l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i7 = paramToServiceMsg.extraData.getInt("nFlag");
    localObject8 = null;
    Object localObject12 = null;
    i1 = -1;
    localObject5 = localObject10;
    i2 = i1;
    localObject6 = localObject12;
    i4 = i5;
    Object localObject3 = localObject11;
    bool2 = bool1;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_7|oidb_sso parseFrom byte " + paramObject.toString());
          }
          paramObject.printStackTrace();
        }
        i2 = i1;
        localObject3 = localObject7;
        bool1 = bool3;
        i4 = ((List)localObject5).size();
      }
      if (paramToServiceMsg != null)
      {
        i2 = paramToServiceMsg.uint32_result.get();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_7|oidb_sso.OIDBSSOPkg.result " + i2);
          i1 = i2;
        }
      }
      localObject5 = localObject10;
      i2 = i1;
      localObject6 = localObject12;
      i4 = i5;
      localObject3 = localObject11;
      bool2 = bool1;
      if (paramToServiceMsg != null)
      {
        localObject5 = localObject10;
        i2 = i1;
        localObject6 = localObject12;
        i4 = i5;
        localObject3 = localObject11;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.has())
        {
          localObject5 = localObject10;
          i2 = i1;
          localObject6 = localObject12;
          i4 = i5;
          localObject3 = localObject11;
          bool2 = bool1;
          if (paramToServiceMsg.bytes_bodybuffer.get() != null) {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          }
        }
      }
    }
    try
    {
      paramObject = new oidb_0x88d.RspBody();
      paramObject.mergeFrom(paramToServiceMsg);
      if ((i1 == 0) || (!paramObject.str_errorinfo.has())) {
        break label1234;
      }
      paramToServiceMsg = String.valueOf(paramObject.str_errorinfo.get().toByteArray());
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        int i6;
        bool1 = bool4;
        paramObject = localObject9;
        i3 = i5;
        localObject7 = localObject8;
        paramToServiceMsg = localObject1;
        localObject1 = localException4;
        localObject5 = paramToServiceMsg;
        i2 = i1;
        localObject6 = localObject7;
        i4 = i3;
        localObject4 = paramObject;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.troopdisband.", 2, localObject1.toString());
          localObject5 = paramToServiceMsg;
          i2 = i1;
          localObject6 = localObject7;
          i4 = i3;
          localObject4 = paramObject;
          bool2 = bool1;
          continue;
          a(45, bool2, new Object[] { String.valueOf(l1), Integer.valueOf(i2), localObject5, Integer.valueOf(i4), localObject6 });
          continue;
          paramToServiceMsg = null;
          continue;
          i6 = 0;
        }
      }
    }
    localObject1 = null;
    i2 = i1;
    localObject3 = localObject7;
    bool1 = bool3;
    try
    {
      localObject5 = paramObject.stzrspgroupinfo.get();
      if (localObject5 != null) {
        break label492;
      }
      i4 = 0;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        long l2;
        label492:
        Object localObject4;
        i1 = i2;
        localObject7 = localObject8;
        int i3 = i5;
        paramObject = localObject4;
        continue;
        paramObject = null;
        i2 = -1;
        Object localObject2 = null;
        bool1 = false;
        continue;
        paramObject = localObject2;
        i1 = i3;
      }
    }
    if ((localObject1 == null) && (i6 < i4))
    {
      i2 = i1;
      localObject3 = localObject7;
      bool1 = bool3;
      paramObject = (oidb_0x88d.RspGroupInfo)((List)localObject5).get(i6);
      i3 = i1;
      if (paramObject != null)
      {
        i2 = i1;
        localObject3 = localObject7;
        bool1 = bool3;
        l2 = paramObject.uint64_group_code.get();
        if (l2 != l1) {}
        for (paramObject = localObject1;; paramObject = (oidb_0x88d.GroupInfo)paramObject.stgroupinfo.get())
        {
          i6 += 1;
          localObject1 = paramObject;
          break;
          i2 = i1;
          localObject3 = localObject7;
          bool1 = bool3;
          i1 = paramObject.uint32_result.get();
          i3 = i1;
          if (i1 != 0) {
            break label1224;
          }
          i2 = i1;
          localObject3 = localObject7;
          bool1 = bool3;
          i3 = i1;
          if (!paramObject.stgroupinfo.has()) {
            break label1224;
          }
          i2 = i1;
          localObject3 = localObject7;
          bool1 = bool3;
        }
      }
    }
    else if (localObject1 != null)
    {
      bool3 = true;
      bool2 = true;
      i2 = i1;
      localObject3 = localObject7;
      bool1 = bool3;
      localObject5 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      i2 = i1;
      localObject3 = localObject7;
      bool1 = bool3;
      paramObject = ((FriendsManagerImp)localObject5).a(String.valueOf(l1));
      i2 = i1;
      localObject3 = paramObject;
      bool1 = bool3;
      if (localObject1.msg_head_portrait.has())
      {
        i2 = i1;
        localObject3 = paramObject;
        bool1 = bool3;
        if (localObject1.uint32_head_portrait_seq.has())
        {
          i2 = i1;
          localObject3 = paramObject;
          bool1 = bool3;
          localObject6 = localObject1.msg_head_portrait;
          i2 = i1;
          localObject3 = paramObject;
          bool1 = bool3;
          i3 = localObject1.uint32_head_portrait_seq.get();
        }
      }
      for (;;)
      {
        try
        {
          localObject7 = TroopInfo.setAvatarPicId((oidb_0x88d.GroupHeadPortrait)localObject6);
          if (paramObject == null) {}
        }
        catch (Exception localException2)
        {
          localObject7 = localObject8;
          bool1 = bool2;
          continue;
        }
        try
        {
          paramObject.mTroopPicList = ((List)localObject7);
          ((FriendsManagerImp)localObject5).b(paramObject);
          bool1 = true;
          i2 = i3;
          localObject1 = paramObject;
          paramObject = localObject7;
        }
        catch (Exception localException3)
        {
          bool1 = bool2;
          continue;
          localObject4 = null;
          i2 = -1;
          localObject2 = paramObject;
          bool1 = true;
          paramObject = localObject4;
          continue;
        }
        bool2 = bool1;
        localObject3 = localObject1;
        i4 = i2;
        localObject6 = paramObject;
        i2 = i1;
        localObject5 = paramToServiceMsg;
        if (localObject3 == null) {
          continue;
        }
        a(45, bool2, new Object[] { String.valueOf(l1), Integer.valueOf(i2), localObject5, Integer.valueOf(i4), null });
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder(150);
          paramToServiceMsg.append("handle_oidb_0x88d_0").append("|isSuccess = ").append(bool2).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|seq = ").append(i7).append("|result = ").append(i2).append("|strErrorMsg = ").append((String)localObject5);
          QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        }
        return;
        i2 = i1;
        localObject3 = paramObject;
        bool1 = bool3;
        if (!localObject1.uint32_head_portrait_seq.has()) {
          break label1192;
        }
        i2 = i1;
        localObject3 = paramObject;
        bool1 = bool3;
        i3 = localObject1.uint32_head_portrait_seq.get();
        i2 = i3;
        localObject1 = paramObject;
        paramObject = null;
        bool1 = true;
      }
    }
  }
  
  public void h(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 2);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a(localToServiceMsg);
  }
  
  public void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i6 = paramToServiceMsg.extraData.getInt("nFlag");
    int i1 = -1;
    int i2;
    Object localObject3;
    Object localObject4;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + paramObject.toString());
          }
          paramObject.printStackTrace();
        }
        i2 = i1;
        bool1 = bool2;
        i4 = ((List)localObject1).size();
      }
      if (paramToServiceMsg != null)
      {
        i2 = paramToServiceMsg.uint32_result.get();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + i2);
          i1 = i2;
        }
      }
      localObject3 = null;
      localObject4 = null;
      if ((i1 == 0) && (paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    else
    {
      try
      {
        localObject1 = new oidb_0x88d.RspBody();
        ((oidb_0x88d.RspBody)localObject1).mergeFrom(paramToServiceMsg);
        if ((i1 == 0) || (!((oidb_0x88d.RspBody)localObject1).str_errorinfo.has())) {
          break label864;
        }
        paramToServiceMsg = String.valueOf(((oidb_0x88d.RspBody)localObject1).str_errorinfo.get().toByteArray());
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(paramObject))
            {
              ((TroopInfo)localObject4).mTags = paramObject;
              ((FriendsManagerImp)localObject1).b((TroopInfo)localObject4);
            }
            bool1 = true;
            bool2 = bool1;
            localObject4 = paramObject;
            i2 = i1;
            localObject1 = paramToServiceMsg;
            a(31, bool2, new Object[] { Long.valueOf(l1), Integer.valueOf(i6), localObject4, Integer.valueOf(i2), localObject1 });
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder(150);
              paramToServiceMsg.append("handle_oidb_0x88d_0").append("|isSuccess = ").append(bool2).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|flag = ").append(i6).append("|result = ").append(i2).append("|strErrorMsg = ").append((String)localObject1);
              QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
            }
            return;
          }
          catch (Exception localException)
          {
            Object localObject1;
            localObject3 = paramObject;
            paramObject = localException;
            bool1 = bool2;
            continue;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          bool1 = bool3;
          localObject1 = paramToServiceMsg;
          i2 = i1;
          localObject4 = localObject3;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.troopdisband.", 2, paramObject.toString());
            localObject1 = paramToServiceMsg;
            i2 = i1;
            localObject4 = localObject3;
            bool2 = bool1;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
      paramObject = null;
      i2 = i1;
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((oidb_0x88d.RspBody)localObject1).stzrspgroupinfo.get();
        if (localObject1 != null) {
          continue;
        }
        i4 = 0;
      }
      catch (Exception paramObject)
      {
        int i4;
        int i3;
        long l2;
        i1 = i2;
        continue;
        paramObject = null;
        continue;
        paramObject = null;
        bool1 = false;
        continue;
        i1 = i3;
        continue;
      }
      if ((paramObject == null) && (i5 < i4))
      {
        i2 = i1;
        bool1 = bool2;
        localObject4 = (oidb_0x88d.RspGroupInfo)((List)localObject1).get(i5);
        i3 = i1;
        if (localObject4 != null)
        {
          i2 = i1;
          bool1 = bool2;
          l2 = ((oidb_0x88d.RspGroupInfo)localObject4).uint64_group_code.get();
          if (l2 != l1)
          {
            i5 += 1;
            continue;
          }
          i2 = i1;
          bool1 = bool2;
          i1 = ((oidb_0x88d.RspGroupInfo)localObject4).uint32_result.get();
          i3 = i1;
          if (i1 == 0)
          {
            i2 = i1;
            bool1 = bool2;
            i3 = i1;
            if (((oidb_0x88d.RspGroupInfo)localObject4).stgroupinfo.has())
            {
              i2 = i1;
              bool1 = bool2;
              paramObject = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject4).stgroupinfo.get();
              continue;
            }
          }
        }
      }
      else if (paramObject != null)
      {
        bool3 = true;
        bool2 = true;
        i2 = i1;
        bool1 = bool3;
        localObject1 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        i2 = i1;
        bool1 = bool3;
        localObject4 = ((FriendsManagerImp)localObject1).a(String.valueOf(l1));
        i2 = i1;
        bool1 = bool3;
        if (paramObject.rpt_tag_record.has())
        {
          i2 = i1;
          bool1 = bool3;
          if (paramObject.rpt_tag_record.size() > 0)
          {
            i2 = i1;
            bool1 = bool3;
            paramObject = TroopInfo.setTags(paramObject.rpt_tag_record.get());
            if (localObject4 == null) {}
          }
        }
      }
      label864:
      Object localObject2 = null;
      i2 = i1;
      bool2 = bool1;
      continue;
      int i5 = 0;
    }
  }
  
  public void i(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 9);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a(localToServiceMsg);
  }
  
  public void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1 = null;
    Object localObject3 = null;
    oidb_0x88d.RspGroupInfo localRspGroupInfo = null;
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    String str = String.valueOf(l1);
    int i6 = paramToServiceMsg.extraData.getInt("nFlag");
    int i1 = -1;
    int i2;
    if (paramFromServiceMsg.getResultCode() == 1000)
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
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + paramFromServiceMsg.toString());
          }
          paramFromServiceMsg.printStackTrace();
        }
        i2 = i1;
        localObject1 = localObject3;
        bool1 = bool2;
        i4 = paramObject.size();
      }
      if (paramToServiceMsg != null)
      {
        i2 = paramToServiceMsg.uint32_result.get();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + i2);
          i1 = i2;
        }
      }
      if ((i1 == 0) && (paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    else
    {
      try
      {
        paramObject = new oidb_0x88d.RspBody();
        paramObject.mergeFrom(paramToServiceMsg);
        if ((i1 == 0) || (!paramObject.str_errorinfo.has())) {
          break label931;
        }
        paramToServiceMsg = String.valueOf(paramObject.str_errorinfo.get().toByteArray());
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          try
          {
            paramObject.troopuin = str;
          }
          catch (Exception localException1)
          {
            paramFromServiceMsg = paramObject;
            paramObject = localException1;
            bool1 = bool2;
            continue;
          }
          try
          {
            paramObject.troopowneruin = String.valueOf(paramFromServiceMsg.uint64_group_owner.get());
            paramObject.troopname = paramFromServiceMsg.string_group_name.get().toStringUtf8();
            paramObject.troopface = ((short)paramFromServiceMsg.uint32_group_face.get());
            paramObject.troopmemo = paramFromServiceMsg.string_group_memo.get().toStringUtf8();
            paramObject.fingertroopmemo = paramFromServiceMsg.string_group_finger_memo.get().toStringUtf8();
            paramObject.mRichFingerMemo = paramFromServiceMsg.string_group_rich_finger_memo.get().toStringUtf8();
            localObject1 = (oidb_0x88d.GroupGeoInfo)paramFromServiceMsg.group_geo_info.get();
            paramObject.strLocation = ((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.get().toStringUtf8();
            paramObject.troopLat = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.get());
            paramObject.troopLon = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.get());
            paramObject.troopTypeExt = paramFromServiceMsg.uint32_group_type_flag.get();
            paramObject.dwGroupClassExt = paramFromServiceMsg.uint32_group_class_ext.get();
            paramObject.dwGroupFlagExt = paramFromServiceMsg.uint32_group_flag_ext.get();
            paramObject.troopAuthenticateInfo = paramFromServiceMsg.string_certification_text.get().toStringUtf8();
            paramFromServiceMsg = paramObject;
            bool1 = true;
            bool2 = bool1;
            localObject3 = paramFromServiceMsg;
            i2 = i1;
            localObject1 = paramToServiceMsg;
            a(33, bool2, new Object[] { Long.valueOf(l1), Integer.valueOf(i6), localObject3, Integer.valueOf(i2), localObject1 });
            return;
          }
          catch (Exception localException2)
          {
            paramFromServiceMsg = paramObject;
            paramObject = localException2;
            bool1 = bool2;
            continue;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          bool1 = bool3;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          localObject1 = paramToServiceMsg;
          i2 = i1;
          localObject3 = paramFromServiceMsg;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.troopdisband.", 2, paramObject.toString());
            localObject1 = paramToServiceMsg;
            i2 = i1;
            localObject3 = paramFromServiceMsg;
            bool2 = bool1;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
      paramFromServiceMsg = null;
      i2 = i1;
      localObject1 = localObject3;
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        paramObject = paramObject.stzrspgroupinfo.get();
        if (paramObject != null) {
          continue;
        }
        i4 = 0;
      }
      catch (Exception paramObject)
      {
        int i4;
        int i3;
        long l2;
        i1 = i2;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        continue;
        continue;
        paramFromServiceMsg = null;
        bool1 = false;
        continue;
        i1 = i3;
        continue;
      }
      if ((paramFromServiceMsg == null) && (i5 < i4))
      {
        i2 = i1;
        localObject1 = localObject3;
        bool1 = bool2;
        localRspGroupInfo = (oidb_0x88d.RspGroupInfo)paramObject.get(i5);
        i3 = i1;
        if (localRspGroupInfo != null)
        {
          i2 = i1;
          localObject1 = localObject3;
          bool1 = bool2;
          l2 = localRspGroupInfo.uint64_group_code.get();
          if (l2 != l1)
          {
            i5 += 1;
            continue;
          }
          i2 = i1;
          localObject1 = localObject3;
          bool1 = bool2;
          i1 = localRspGroupInfo.uint32_result.get();
          i3 = i1;
          if (i1 == 0)
          {
            i2 = i1;
            localObject1 = localObject3;
            bool1 = bool2;
            i3 = i1;
            if (localRspGroupInfo.stgroupinfo.has())
            {
              i2 = i1;
              localObject1 = localObject3;
              bool1 = bool2;
              paramFromServiceMsg = (oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get();
              continue;
            }
          }
        }
      }
      else if (paramFromServiceMsg != null)
      {
        bool3 = true;
        bool2 = true;
        i2 = i1;
        localObject1 = localObject3;
        bool1 = bool3;
        paramObject = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(str);
        if ((paramObject == null) || (paramObject == null))
        {
          i2 = i1;
          localObject1 = paramObject;
          bool1 = bool3;
          paramObject = new TroopInfo();
        }
      }
      label931:
      Object localObject2 = null;
      i2 = i1;
      localObject3 = localRspGroupInfo;
      bool2 = bool1;
      continue;
      int i5 = 0;
    }
  }
  
  public void j(String paramString)
  {
    a(paramString, 0);
  }
  
  public void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject1 = null;
    long l1 = paramToServiceMsg.extraData.getLong("OldOwner");
    long l2 = paramToServiceMsg.extraData.getLong("NewOwner");
    long l3 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i2;
    int i1;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          try
          {
            label135:
            localObject2 = new oidb_0x89e.RspBody();
            ((oidb_0x89e.RspBody)localObject2).mergeFrom(paramToServiceMsg);
            if (!((oidb_0x89e.RspBody)localObject2).uint32_result.has()) {
              break label821;
            }
            i2 = ((oidb_0x89e.RspBody)localObject2).uint32_result.get();
            i1 = i2;
            i3 = i2;
          }
          catch (Exception localException1)
          {
            bool2 = false;
            paramToServiceMsg = null;
            i2 = i1;
            i1 = i2;
            paramObject = paramToServiceMsg;
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|exception = " + localException1.toString());
            i1 = i2;
            paramObject = paramToServiceMsg;
            bool1 = bool2;
            continue;
          }
          try
          {
            if (QLog.isColorLevel())
            {
              i3 = i2;
              QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|oidb_0x89e.RspBody.result = " + i2);
              i1 = i2;
            }
            paramToServiceMsg = (ToServiceMsg)localObject1;
            if (i1 > 0)
            {
              paramToServiceMsg = (ToServiceMsg)localObject1;
              i3 = i1;
              if (((oidb_0x89e.RspBody)localObject2).str_errorinfo.has())
              {
                i3 = i1;
                localObject1 = String.valueOf(((oidb_0x89e.RspBody)localObject2).str_errorinfo.get().toByteArray());
                paramToServiceMsg = (ToServiceMsg)localObject1;
                bool1 = bool4;
                paramObject = localObject1;
              }
            }
          }
          catch (Exception localException2)
          {
            i2 = i3;
            bool2 = false;
            paramToServiceMsg = null;
            continue;
          }
          try
          {
            if (QLog.isColorLevel())
            {
              bool1 = bool4;
              paramObject = localObject1;
              QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|strErrorMsg = " + (String)localObject1);
              paramToServiceMsg = (ToServiceMsg)localObject1;
            }
            bool2 = bool3;
            if (i1 == 0)
            {
              bool2 = bool3;
              bool1 = bool4;
              paramObject = paramToServiceMsg;
              if (((oidb_0x89e.RspBody)localObject2).uint64_group_code.get() == l3)
              {
                bool3 = true;
                bool2 = true;
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                localObject2 = localFriendsManagerImp.a(String.valueOf(l3));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  bool1 = bool3;
                  paramObject = paramToServiceMsg;
                  localObject1 = new TroopInfo();
                  bool1 = bool3;
                  paramObject = paramToServiceMsg;
                  ((TroopInfo)localObject1).troopuin = String.valueOf(l3);
                }
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                ((TroopInfo)localObject1).troopowneruin = String.valueOf(l2);
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                localFriendsManagerImp.b((TroopInfo)localObject1);
              }
            }
            bool1 = bool2;
            paramObject = paramToServiceMsg;
            a(20, bool1, new Object[] { Long.valueOf(l3), String.valueOf(l1), String.valueOf(l2), Integer.valueOf(i1), paramObject });
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder(150);
              paramToServiceMsg.append("handle_oidb_0x89e_0").append("|isSuccess = ").append(bool1).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l3).append("|oldOwner = ").append(l1).append("|newOwner = ").append(l2).append("|result = ").append(i1).append("|strErrorMsg = ").append(paramObject);
              QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
            }
            return;
          }
          catch (Exception localException3)
          {
            paramToServiceMsg = paramObject;
            i2 = i1;
            bool2 = bool1;
            continue;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler", 2, "handle_oidb_0x89e_0| oidb_sso parseFrom byte " + paramObject.toString());
          }
          paramObject.printStackTrace();
        }
      }
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
        if (paramToServiceMsg == null) {
          break label832;
        }
        i2 = paramToServiceMsg.uint32_result.get();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|oidb_sso.OIDBSSOPkg.result = " + i2);
          i1 = i2;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        break label675;
        break label257;
        bool1 = false;
        paramObject = null;
        break label509;
        i1 = -1;
        break label135;
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    for (;;)
    {
      Object localObject2;
      int i3;
      label257:
      boolean bool2;
      FriendsManagerImp localFriendsManagerImp;
      label509:
      i1 = -1;
      label675:
      label821:
      label832:
      boolean bool1 = false;
      paramObject = null;
    }
  }
  
  public void k(String paramString)
  {
    Object localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(0);
    Object localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(b(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint32_last_get_group_name_time.set(0);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.uint32_group_member_max_num.set(0);
    localGroupInfo.uint32_active_member_num.set(0);
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set(localGroupInfo);
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x88d_1");
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 5);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  /* Error */
  public void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 11
    //   6: aconst_null
    //   7: astore 16
    //   9: aconst_null
    //   10: astore 17
    //   12: aconst_null
    //   13: astore 18
    //   15: aload_1
    //   16: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   19: ldc_w 659
    //   22: invokevirtual 794	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   25: lstore 12
    //   27: aload_1
    //   28: getfield 650	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 1641
    //   34: invokevirtual 657	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   37: istore 9
    //   39: iconst_m1
    //   40: istore 4
    //   42: iload 4
    //   44: istore 5
    //   46: aload_2
    //   47: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   50: sipush 1000
    //   53: if_icmpne +890 -> 943
    //   56: new 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   59: dup
    //   60: invokespecial 1358	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: aload_3
    //   66: checkcast 1359	[B
    //   69: checkcast 1359	[B
    //   72: invokevirtual 1360	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   75: checkcast 1357	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: astore_3
    //   79: aload_3
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +54 -> 136
    //   85: aload_1
    //   86: getfield 1364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   92: istore 5
    //   94: iload 5
    //   96: istore 4
    //   98: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +35 -> 136
    //   104: ldc_w 1648
    //   107: iconst_2
    //   108: new 240	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 3352
    //   118: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload 5
    //   123: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: iload 5
    //   134: istore 4
    //   136: iload 4
    //   138: istore 5
    //   140: aload_1
    //   141: ifnull +802 -> 943
    //   144: iload 4
    //   146: istore 5
    //   148: aload_1
    //   149: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   152: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   155: ifeq +788 -> 943
    //   158: iload 4
    //   160: istore 5
    //   162: aload_1
    //   163: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   166: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   169: ifnull +774 -> 943
    //   172: aload_1
    //   173: getfield 1513	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   176: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   179: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   182: astore_1
    //   183: new 1613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   186: dup
    //   187: invokespecial 1614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   190: astore 18
    //   192: aload 18
    //   194: aload_1
    //   195: invokevirtual 1615	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   198: pop
    //   199: iload 4
    //   201: ifeq +737 -> 938
    //   204: aload 18
    //   206: getfield 1646	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   212: ifeq +726 -> 938
    //   215: aload 18
    //   217: getfield 1646	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   223: invokevirtual 1527	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   226: invokestatic 731	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_3
    //   232: iload 4
    //   234: istore 5
    //   236: aload 18
    //   238: getfield 1618	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   241: invokevirtual 1474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   244: astore 18
    //   246: aload 18
    //   248: ifnonnull +124 -> 372
    //   251: iconst_0
    //   252: istore 7
    //   254: goto +695 -> 949
    //   257: aload_3
    //   258: ifnonnull +191 -> 449
    //   261: iload 8
    //   263: iload 7
    //   265: if_icmpge +184 -> 449
    //   268: iload 4
    //   270: istore 5
    //   272: aload 18
    //   274: iload 8
    //   276: invokeinterface 1086 2 0
    //   281: checkcast 1620	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   284: astore 19
    //   286: iload 4
    //   288: istore 6
    //   290: aload 19
    //   292: ifnull +639 -> 931
    //   295: iload 4
    //   297: istore 5
    //   299: aload 19
    //   301: getfield 1624	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   304: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   307: lstore 14
    //   309: lload 14
    //   311: lload 12
    //   313: lcmp
    //   314: ifeq +74 -> 388
    //   317: iload 8
    //   319: iconst_1
    //   320: iadd
    //   321: istore 8
    //   323: goto -66 -> 257
    //   326: astore_3
    //   327: aconst_null
    //   328: astore_1
    //   329: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +33 -> 365
    //   335: ldc_w 1648
    //   338: iconst_2
    //   339: new 240	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 3354
    //   349: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_3
    //   353: invokevirtual 1651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   356: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload_3
    //   366: invokevirtual 1611	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   369: goto -288 -> 81
    //   372: iload 4
    //   374: istore 5
    //   376: aload 18
    //   378: invokeinterface 1085 1 0
    //   383: istore 7
    //   385: goto +564 -> 949
    //   388: iload 4
    //   390: istore 5
    //   392: aload 19
    //   394: getfield 1621	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   397: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   400: istore 4
    //   402: iload 4
    //   404: istore 6
    //   406: iload 4
    //   408: ifne +523 -> 931
    //   411: iload 4
    //   413: istore 5
    //   415: iload 4
    //   417: istore 6
    //   419: aload 19
    //   421: getfield 1628	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   424: invokevirtual 1631	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   427: ifeq +504 -> 931
    //   430: iload 4
    //   432: istore 5
    //   434: aload 19
    //   436: getfield 1628	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   439: invokevirtual 1632	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   442: checkcast 1630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   445: astore_3
    //   446: goto -129 -> 317
    //   449: aload_3
    //   450: ifnull +472 -> 922
    //   453: iconst_1
    //   454: istore 10
    //   456: aload 17
    //   458: astore 16
    //   460: aload_0
    //   461: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: bipush 8
    //   466: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   469: checkcast 329	com/tencent/mobileqq/app/FriendsManagerImp
    //   472: lload 12
    //   474: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   477: invokevirtual 337	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   480: astore 17
    //   482: aload 17
    //   484: ifnonnull +431 -> 915
    //   487: new 339	com/tencent/mobileqq/data/TroopInfo
    //   490: dup
    //   491: invokespecial 390	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   494: astore 18
    //   496: aload 18
    //   498: astore 16
    //   500: aload 18
    //   502: lload 12
    //   504: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   507: putfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   510: aload 18
    //   512: astore 16
    //   514: aload_3
    //   515: getfield 2003	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   518: invokevirtual 1369	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   521: ifeq +16 -> 537
    //   524: aload 16
    //   526: aload_3
    //   527: getfield 2003	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   530: invokevirtual 1370	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   533: i2s
    //   534: putfield 446	com/tencent/mobileqq/data/TroopInfo:cGroupOption	S
    //   537: aload_3
    //   538: getfield 2007	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   541: invokevirtual 1516	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   544: ifeq +55 -> 599
    //   547: aload 16
    //   549: aload_3
    //   550: getfield 2007	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   553: invokevirtual 1519	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   556: invokevirtual 1822	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   559: putfield 551	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   562: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +34 -> 599
    //   568: ldc_w 1999
    //   571: iconst_2
    //   572: new 240	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 3356
    //   582: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 16
    //   587: getfield 551	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   590: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 482	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload_0
    //   600: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   603: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   606: aload 16
    //   608: getfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   611: aload 16
    //   613: getfield 411	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   616: invokestatic 636	com/tencent/mobileqq/util/TroopSystemMsgUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   619: aload_0
    //   620: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   623: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   626: aload 16
    //   628: getfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   631: aload 16
    //   633: getfield 446	com/tencent/mobileqq/data/TroopInfo:cGroupOption	S
    //   636: invokestatic 3359	com/tencent/mobileqq/util/TroopSystemMsgUtil:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   639: aload_0
    //   640: getfield 321	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   643: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   646: aload 16
    //   648: getfield 393	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   651: aload 16
    //   653: getfield 551	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   656: invokestatic 641	com/tencent/mobileqq/util/TroopSystemMsgUtil:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   659: iload 10
    //   661: istore 11
    //   663: aload 16
    //   665: astore 18
    //   667: iload 4
    //   669: istore 5
    //   671: aload_1
    //   672: astore 17
    //   674: aload_0
    //   675: bipush 25
    //   677: iload 11
    //   679: iconst_5
    //   680: anewarray 606	java/lang/Object
    //   683: dup
    //   684: iconst_0
    //   685: lload 12
    //   687: invokestatic 807	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   690: aastore
    //   691: dup
    //   692: iconst_1
    //   693: iload 9
    //   695: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   698: aastore
    //   699: dup
    //   700: iconst_2
    //   701: aload 18
    //   703: aastore
    //   704: dup
    //   705: iconst_3
    //   706: iload 5
    //   708: invokestatic 677	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   711: aastore
    //   712: dup
    //   713: iconst_4
    //   714: aload 17
    //   716: aastore
    //   717: invokevirtual 348	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   720: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   723: ifeq +101 -> 824
    //   726: new 240	java/lang/StringBuilder
    //   729: dup
    //   730: sipush 150
    //   733: invokespecial 1991	java/lang/StringBuilder:<init>	(I)V
    //   736: astore_1
    //   737: aload_1
    //   738: ldc_w 3361
    //   741: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: ldc_w 3198
    //   747: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: iload 11
    //   752: invokevirtual 1604	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   755: ldc_w 3200
    //   758: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload_2
    //   762: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   765: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   768: ldc_w 1995
    //   771: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: lload 12
    //   776: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   779: ldc_w 1997
    //   782: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: iload 9
    //   787: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   790: ldc_w 3204
    //   793: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: iload 5
    //   798: invokevirtual 863	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   801: ldc_w 3206
    //   804: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: aload 17
    //   809: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: ldc_w 1999
    //   816: iconst_2
    //   817: aload_1
    //   818: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   824: return
    //   825: astore_3
    //   826: aconst_null
    //   827: astore_1
    //   828: aload_1
    //   829: astore 17
    //   831: iload 4
    //   833: istore 5
    //   835: aload 16
    //   837: astore 18
    //   839: iload 10
    //   841: istore 11
    //   843: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq -172 -> 674
    //   849: ldc_w 1999
    //   852: iconst_2
    //   853: aload_3
    //   854: invokevirtual 1639	java/lang/Exception:toString	()Ljava/lang/String;
    //   857: invokestatic 1052	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   860: aload_1
    //   861: astore 17
    //   863: iload 4
    //   865: istore 5
    //   867: aload 16
    //   869: astore 18
    //   871: iload 10
    //   873: istore 11
    //   875: goto -201 -> 674
    //   878: astore_3
    //   879: iload 5
    //   881: istore 4
    //   883: goto -55 -> 828
    //   886: astore_3
    //   887: iconst_1
    //   888: istore 10
    //   890: goto -62 -> 828
    //   893: astore_3
    //   894: aload 17
    //   896: astore 16
    //   898: iconst_1
    //   899: istore 10
    //   901: goto -73 -> 828
    //   904: astore_3
    //   905: iconst_1
    //   906: istore 10
    //   908: goto -80 -> 828
    //   911: astore_3
    //   912: goto -583 -> 329
    //   915: aload 17
    //   917: astore 16
    //   919: goto -405 -> 514
    //   922: aconst_null
    //   923: astore 16
    //   925: iconst_0
    //   926: istore 10
    //   928: goto -269 -> 659
    //   931: iload 6
    //   933: istore 4
    //   935: goto -618 -> 317
    //   938: aconst_null
    //   939: astore_1
    //   940: goto -710 -> 230
    //   943: aconst_null
    //   944: astore 17
    //   946: goto -272 -> 674
    //   949: iconst_0
    //   950: istore 8
    //   952: goto -695 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	955	0	this	TroopHandler
    //   0	955	1	paramToServiceMsg	ToServiceMsg
    //   0	955	2	paramFromServiceMsg	FromServiceMsg
    //   0	955	3	paramObject	Object
    //   40	894	4	i1	int
    //   44	836	5	i2	int
    //   288	644	6	i3	int
    //   252	132	7	i4	int
    //   261	690	8	i5	int
    //   37	749	9	i6	int
    //   1	926	10	bool1	boolean
    //   4	870	11	bool2	boolean
    //   25	750	12	l1	long
    //   307	3	14	l2	long
    //   7	917	16	localObject1	Object
    //   10	935	17	localObject2	Object
    //   13	857	18	localObject3	Object
    //   284	151	19	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    // Exception table:
    //   from	to	target	type
    //   56	64	326	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   183	199	825	java/lang/Exception
    //   204	230	825	java/lang/Exception
    //   236	246	878	java/lang/Exception
    //   272	286	878	java/lang/Exception
    //   299	309	878	java/lang/Exception
    //   376	385	878	java/lang/Exception
    //   392	402	878	java/lang/Exception
    //   419	430	878	java/lang/Exception
    //   434	446	878	java/lang/Exception
    //   460	482	886	java/lang/Exception
    //   500	510	886	java/lang/Exception
    //   487	496	893	java/lang/Exception
    //   514	537	904	java/lang/Exception
    //   537	599	904	java/lang/Exception
    //   599	659	904	java/lang/Exception
    //   64	79	911	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void l(String paramString)
  {
    b(paramString, false);
  }
  
  public void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i6 = paramToServiceMsg.extraData.getInt("nFlag");
    int i1 = -1;
    Object localObject1;
    int i2;
    int i5;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      for (localObject1 = new oidb_sso.OIDBSSOPkg();; localObject1 = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject3).stgroupinfo.get())
      {
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])paramObject);
          if (paramObject != null)
          {
            i2 = paramObject.uint32_result.get();
            i1 = i2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + i2);
              i1 = i2;
            }
          }
          if ((i1 != 0) || (paramObject == null) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null)) {
            break label841;
          }
          paramObject = paramObject.bytes_bodybuffer.get().toByteArray();
          try
          {
            localObject2 = new oidb_0x88d.RspBody();
            ((oidb_0x88d.RspBody)localObject2).mergeFrom(paramObject);
            if ((i1 == 0) || (!((oidb_0x88d.RspBody)localObject2).str_errorinfo.has())) {
              break label836;
            }
            paramObject = String.valueOf(((oidb_0x88d.RspBody)localObject2).str_errorinfo.get().toByteArray());
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              try
              {
                Object localObject2;
                if (((oidb_0x88d.GroupInfo)localObject1).uint32_app_privilege_flag.has())
                {
                  i2 = ((oidb_0x88d.GroupInfo)localObject1).uint32_app_privilege_flag.get();
                  if ((i2 & 0x1) != 1)
                  {
                    bool1 = true;
                    break;
                    localObject3 = String.valueOf(l1);
                    localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
                    localObject2 = localFriendsManagerImp.a((String)localObject3);
                    localObject1 = localObject2;
                    if (localObject2 == null)
                    {
                      localObject1 = new TroopInfo();
                      ((TroopInfo)localObject1).troopuin = ((String)localObject3);
                    }
                    ((TroopInfo)localObject1).troopPrivilegeFlag = i2;
                    localFriendsManagerImp.b((TroopInfo)localObject1);
                    if (paramToServiceMsg.extraData.getBoolean("needUpdatePreferences", false)) {
                      m((String)localObject3);
                    }
                    a(58, true, new Object[] { Boolean.valueOf(((TroopInfo)localObject1).isAdmin()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                    return;
                  }
                  bool1 = false;
                  break;
                  bool2 = false;
                  continue;
                }
                bool1 = true;
                i2 = i1;
                a(58, bool1, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true) });
                if (!QLog.isColorLevel()) {
                  continue;
                }
                paramToServiceMsg = new StringBuilder(150);
                paramToServiceMsg.append("handle_oidb_0x88d_0").append("|isSuccess = ").append(bool1).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|flag = ").append(i6).append("|result = ").append(i2).append("|strErrorMsg = ").append(paramObject);
                QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
                return;
              }
              catch (Exception localException3)
              {
                bool2 = true;
                paramToServiceMsg = paramObject;
                continue;
              }
              localException1 = localException1;
              paramToServiceMsg = null;
              paramObject = paramToServiceMsg;
              i2 = i1;
              bool1 = bool2;
              if (QLog.isColorLevel())
              {
                QLog.i("Q.troopdisband.", 2, localException1.toString());
                paramObject = paramToServiceMsg;
                i2 = i1;
                bool1 = bool2;
                continue;
                paramObject = null;
              }
            }
          }
          localObject1 = null;
          i2 = i1;
          for (;;)
          {
            try
            {
              localObject2 = ((oidb_0x88d.RspBody)localObject2).stzrspgroupinfo.get();
              if (localObject2 != null) {
                continue;
              }
              i4 = 0;
            }
            catch (Exception localException2)
            {
              int i4;
              Object localObject3;
              int i3;
              long l2;
              paramToServiceMsg = paramObject;
              i1 = i2;
              continue;
              bool1 = false;
              continue;
              i1 = i3;
              continue;
            }
            if ((localObject1 != null) || (i5 >= i4)) {
              continue;
            }
            i2 = i1;
            localObject3 = (oidb_0x88d.RspGroupInfo)((List)localObject2).get(i5);
            i3 = i1;
            if (localObject3 == null) {
              continue;
            }
            i2 = i1;
            l2 = ((oidb_0x88d.RspGroupInfo)localObject3).uint64_group_code.get();
            if (l2 == l1) {
              continue;
            }
            i5 += 1;
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + paramObject.toString());
            }
            paramObject.printStackTrace();
            paramObject = localObject1;
          }
          i2 = i1;
          i4 = ((List)localObject2).size();
        }
        i2 = i1;
        i1 = ((oidb_0x88d.RspGroupInfo)localObject3).uint32_result.get();
        i3 = i1;
        if (i1 != 0) {
          break label829;
        }
        i2 = i1;
        i3 = i1;
        if (!((oidb_0x88d.RspGroupInfo)localObject3).stgroupinfo.has()) {
          break label829;
        }
        i2 = i1;
      }
      if (localObject1 == null) {
        break label823;
      }
    }
    for (;;)
    {
      FriendsManagerImp localFriendsManagerImp;
      label823:
      label829:
      label836:
      label841:
      paramObject = null;
      i2 = i1;
      continue;
      i5 = 0;
      break;
      if ((i2 & 0x2) != 2) {
        bool2 = true;
      }
    }
  }
  
  public void m(String paramString)
  {
    TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(TroopInfo.class, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("TroopHandler", 2, "PrivilegeFlag:" + localTroopInfo.troopPrivilegeFlag);
      QLog.d("TroopHandler", 2, "troop.isAdmin:" + localTroopInfo.isAdmin());
    }
    if ((localTroopInfo != null) && ((localTroopInfo.troopPrivilegeFlag & 1L) == 1L) && (!localTroopInfo.isAdmin())) {}
    for (int i1 = 0;; i1 = 1)
    {
      long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
      if (i1 != LocalMultiProcConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "__qzone_pic_permission__" + paramString, -1, l1)) {
        LocalMultiProcConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "__qzone_pic_permission__" + paramString, i1, l1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler
 * JD-Core Version:    0.7.0.1
 */