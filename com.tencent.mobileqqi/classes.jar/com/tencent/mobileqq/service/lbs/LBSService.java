package com.tencent.mobileqq.service.lbs;

import EncounterSvc.ReqGetEncounterV2;
import EncounterSvc.RespGetEncounterV2;
import GameCenter.ReqLastGameInfo;
import LBSAddrProtocol.ReqGetPositionApi;
import LBSAddrProtocol.RspGetPositionApi;
import LBSAddrProtocol.RspHeader;
import NearbyGroup.ReqGetAreaList;
import NearbyGroup.ReqGetGroupInArea;
import NearbyGroup.ReqGetNearbyGroup;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NearbyPubAcct.ReqGetNearbyPubAcctInfo;
import NearbyPubAcct.RspGetNearbyPubAcctInfo;
import NeighborComm.LocalInfoType;
import NeighborComm.RespHeader;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import NeighborSvc.ReqGetNeighbors;
import NeighborSvc.ReqGetPoint;
import NeighborSvc.ReqGetSwitches;
import NeighborSvc.ReqSetStateSwitch;
import NeighborSvc.ReqSetUserState;
import NeighborSvc.RespGetNeighbors;
import NeighborSvc.RespGetPoint;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import NeighborSvc.RespSetUserState;
import NeighborSvc.UserDetailLocalInfo;
import QQService.FaceInfo;
import QQService.Intro;
import QQService.ReqAddFace;
import QQService.ReqCommonCard;
import QQService.ReqDelFace;
import QQService.ReqFaceInfo;
import QQService.ReqFavorite;
import QQService.ReqGetCardSwitch;
import QQService.ReqGetFace;
import QQService.ReqGetVisitorList;
import QQService.ReqGetVoterList;
import QQService.ReqHYCommonCard;
import QQService.ReqHYMakeFriendsCard;
import QQService.ReqMakeFriendsCard;
import QQService.ReqPicSafetyCheck;
import QQService.ReqSetCard;
import QQService.ReqSetCardSwitch;
import QQService.ReqUpdateIntro;
import QQService.ReqUpdateQQFace;
import QQService.ReqVote;
import QQService.RespAddFace;
import QQService.RespCommonCard;
import QQService.RespDelFace;
import QQService.RespFaceInfo;
import QQService.RespFavorite;
import QQService.RespGetCardSwitch;
import QQService.RespGetFace;
import QQService.RespGetVisitorList;
import QQService.RespGetVoterList;
import QQService.RespHYCommonCard;
import QQService.RespHYMakeFriendsCard;
import QQService.RespHead;
import QQService.RespMakeFriendsCard;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.RespUpdateIntro;
import QQService.RespUpdateQQFace;
import QQService.RespVote;
import QQService.UserCntlData;
import SummaryCard.CondFitUser;
import SummaryCard.ReqCondSearch;
import SummaryCard.ReqSearch;
import SummaryCard.ReqSummaryCard;
import SummaryCard.ReqVoiceManage;
import SummaryCard.RespCondSearch;
import SummaryCard.RespSearch;
import SummaryCard.RespSummaryCard;
import SummaryCard.RespVoiceManage;
import SummaryCard.VoiceInfo;
import SummaryCardTaf.SSummaryCardQueryReq;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.TicketManager;

public class LBSService
  extends BaseProtocolCoder
{
  public static final int a = 2;
  protected static final String a = "http://112.90.138.176:8080/mmu/0";
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "NeighborSvc", "KQQFS", "MCardSvc", "MobileQQ", "EncounterSvc", "VisitorSvc", "LBS", "SummaryCard", "NearbyGroup" };
  public static final int b = 3000;
  protected static final String b = "http://112.90.138.176:8080/mmd/0";
  private static final int c = 2;
  protected static final String c = "9u23fh$jkf^%43hj";
  private static final int jdField_d_of_type_Int = 30;
  private static final String jdField_d_of_type_JavaLangString = "LBSService";
  private EncounterSvc.UserData jdField_a_of_type_EncounterSvcUserData;
  private NeighborSvc.UserData jdField_a_of_type_NeighborSvcUserData;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public LBSService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean A(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    ReqVote localReqVote = new ReqVote(new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null), l2);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqVote");
    paramUniPacket.put("ReqVote", localReqVote);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqVote");
    return true;
  }
  
  private boolean B(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vCookies");
    localObject = new ReqFavorite(new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, (byte[])localObject), l2, 0);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqFavorite");
    paramUniPacket.put("ReqFavorite", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqFavorite");
    return true;
  }
  
  private boolean C(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg.extraData.getLong("selfUin");
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("nextMid");
    int i = paramToServiceMsg.extraData.getInt("pageSize");
    Object localObject = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null);
    UserCntlData localUserCntlData = new UserCntlData(l2, new byte[0]);
    if (i < 54) {}
    for (;;)
    {
      localObject = new ReqGetVoterList((QQService.ReqHead)localObject, localUserCntlData, i);
      paramUniPacket.setServantName("VisitorSvc");
      paramUniPacket.setFuncName("ReqGetVoterList");
      paramUniPacket.put("ReqGetVoterList", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("VisitorSvc.ReqGetVoterList");
      return true;
      i = 30;
    }
  }
  
  private boolean D(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg.extraData.getLong("selfUin");
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("nextMid");
    int i = paramToServiceMsg.extraData.getInt("pageSize");
    Object localObject = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null);
    UserCntlData localUserCntlData = new UserCntlData(l2, new byte[0]);
    if (i < 54) {}
    for (;;)
    {
      localObject = new ReqGetVisitorList((QQService.ReqHead)localObject, localUserCntlData, i);
      paramUniPacket.setServantName("VisitorSvc");
      paramUniPacket.setFuncName("ReqGetVisitorList");
      paramUniPacket.put("ReqGetVisitorList", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("VisitorSvc.ReqGetVisitorList");
      return true;
      i = 30;
    }
  }
  
  private boolean E(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("lToUIN");
    int i = paramToServiceMsg.extraData.getInt("iScene");
    ReqPicSafetyCheck localReqPicSafetyCheck = new ReqPicSafetyCheck(new QQService.ReqHead(l, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null), l, i);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqPicSafetyCheck");
    paramUniPacket.put("ReqPicSafetyCheck", localReqPicSafetyCheck);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqPicSafetyCheck");
    return true;
  }
  
  private boolean F(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject1 = paramToServiceMsg.extraData.getString("param_keyword");
    Object localObject2 = paramToServiceMsg.extraData.getString("param_country_code");
    paramToServiceMsg.extraData.getInt("param_sh_version");
    localObject1 = new ReqSearch((String)localObject1, (String)localObject2, 2);
    localObject2 = new SummaryCard.ReqHead();
    paramUniPacket.setServantName("SummaryCardServantObj");
    paramUniPacket.setFuncName("ReqSearch");
    paramUniPacket.put("ReqHead", localObject2);
    paramUniPacket.put("ReqSearch", localObject1);
    paramToServiceMsg.setTimeout(30000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.ReqSearch");
    return true;
  }
  
  private boolean G(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("param_page");
    long l = paramToServiceMsg.extraData.getLong("param_session_id");
    Object localObject1 = paramToServiceMsg.extraData.getString("param_keyword");
    int j = paramToServiceMsg.extraData.getInt("param_sex_index");
    int k = paramToServiceMsg.extraData.getInt("param_age_index");
    Object localObject3 = paramToServiceMsg.extraData.getStringArray("param_loc_code");
    Object localObject2 = paramToServiceMsg.extraData.getStringArray("param_home_code");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(16);
    if ((localObject3 != null) && (localObject3.length == 4))
    {
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[0]));
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[1]));
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[2]));
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[3]));
      localObject3 = ByteBuffer.allocate(16);
      if ((localObject2 == null) || (localObject2.length != 4)) {
        break label323;
      }
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[0]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[1]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[2]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[3]));
    }
    for (;;)
    {
      localObject1 = new ReqCondSearch(i, l, 1L, (String)localObject1, (byte)j, localByteBuffer.array(), (short)k, ((ByteBuffer)localObject3).array());
      localObject2 = new SummaryCard.ReqHead();
      paramUniPacket.setServantName("SummaryCardServantObj");
      paramUniPacket.setFuncName("ReqCondSearch");
      paramUniPacket.put("ReqHead", localObject2);
      paramUniPacket.put("ReqCondSearch", localObject1);
      paramToServiceMsg.setTimeout(15000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.ReqCondSearch");
      return true;
      localByteBuffer.putInt(0).putInt(0).putInt(0).putInt(0);
      break;
      label323:
      ((ByteBuffer)localObject3).putInt(0).putInt(0).putInt(0).putInt(0);
    }
  }
  
  private static long a(long paramLong)
  {
    Object localObject = new ByteArrayOutputStream(8);
    DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
    try
    {
      localDataOutputStream.writeLong(paramLong);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      localObject[0] = 0;
      localObject[1] = 0;
      paramLong = new DataInputStream(new ByteArrayInputStream((byte[])localObject)).readLong();
      return paramLong;
    }
    catch (IOException localIOException) {}
    return 0L;
  }
  
  private ReqGetNearbyGroup a(int paramInt1, int paramInt2)
  {
    ReqGetNearbyGroup localReqGetNearbyGroup = null;
    NearbyGroup.LBSInfo localLBSInfo;
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localLBSInfo = new NearbyGroup.LBSInfo();
      localLBSInfo.stGps = new NearbyGroup.GPS(paramInt1, paramInt2, 0, 1);
    }
    for (;;)
    {
      if (localLBSInfo != null)
      {
        localReqGetNearbyGroup = new ReqGetNearbyGroup();
        localReqGetNearbyGroup.stLBSInfo = localLBSInfo;
      }
      return localReqGetNearbyGroup;
      localLBSInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
  }
  
  public static RspGetAreaList a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetAreaList)localUniPacket.getByClass("RspGetAreaList", new RspGetAreaList());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static RspGetGroupInArea a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetGroupInArea)localUniPacket.getByClass("RspGetGroupInArea", new RspGetGroupInArea());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static RspGetNearbyGroup a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetNearbyGroup)localUniPacket.getByClass("RspGetNearbyGroup", new RspGetNearbyGroup());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  private NearbyPubAcct.LBSInfo a(NearbyGroup.LBSInfo paramLBSInfo)
  {
    Object localObject1 = null;
    if (paramLBSInfo != null)
    {
      localObject1 = new NearbyPubAcct.GPS(paramLBSInfo.stGps.iLat, paramLBSInfo.stGps.iLon, paramLBSInfo.stGps.iAlt, paramLBSInfo.stGps.eType);
      NearbyPubAcct.Attr localAttr = new NearbyPubAcct.Attr(paramLBSInfo.stAttr.strImei, paramLBSInfo.stAttr.strImsi, paramLBSInfo.stAttr.strPhonenum);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = paramLBSInfo.vWifis.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearbyGroup.Wifi)((Iterator)localObject2).next();
        localArrayList.add(new NearbyPubAcct.Wifi(((NearbyGroup.Wifi)localObject3).lMac, ((NearbyGroup.Wifi)localObject3).shRssi));
      }
      localObject2 = new ArrayList();
      paramLBSInfo = paramLBSInfo.vCells.iterator();
      while (paramLBSInfo.hasNext())
      {
        localObject3 = (NearbyGroup.Cell)paramLBSInfo.next();
        ((ArrayList)localObject2).add(new NearbyPubAcct.Cell(((NearbyGroup.Cell)localObject3).shMcc, ((NearbyGroup.Cell)localObject3).shMnc, ((NearbyGroup.Cell)localObject3).iLac, ((NearbyGroup.Cell)localObject3).iCellId, ((NearbyGroup.Cell)localObject3).shRssi));
      }
      localObject1 = new NearbyPubAcct.LBSInfo((NearbyPubAcct.GPS)localObject1, localArrayList, (ArrayList)localObject2, localAttr);
    }
    return localObject1;
  }
  
  public static RspGetNearbyPubAcctInfo a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      label23:
      paramArrayOfByte = localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetNearbyPubAcctInfo)localUniPacket.getByClass("nearby_pubacct", new RspGetNearbyPubAcctInfo());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      break label23;
    }
  }
  
  private byte[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        break label108;
      }
      localObject = new NearbyPubAcct.LBSInfo();
      ((NearbyPubAcct.LBSInfo)localObject).stGps = new NearbyPubAcct.GPS(paramInt1, paramInt2, 0, 1);
    }
    for (;;)
    {
      localObject = new ReqGetNearbyPubAcctInfo((short)2, new byte[0], 2, (NearbyPubAcct.LBSInfo)localObject);
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setRequestId(1);
      localUniPacket.setServantName("PubAccountSvc.nearby_pubacct");
      localUniPacket.setFuncName("nearby_pubacct");
      localUniPacket.put("nearby_pubacct", localObject);
      localObject = localUniPacket.encode();
      return localObject;
      label108:
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
  }
  
  private Object b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = (RspHeader)a(paramFromServiceMsg.getWupBuffer(), "RspHeader", new RspHeader());
      if ((paramToServiceMsg != null) && (paramToServiceMsg.eResult == 0))
      {
        paramFromServiceMsg = (RspGetPositionApi)a(paramFromServiceMsg.getWupBuffer(), "RspGetPositionApi", new RspGetPositionApi());
        if (paramFromServiceMsg != null) {}
        return paramFromServiceMsg;
      }
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("selfuin");
    Object localObject = paramToServiceMsg.extraData.getByteArray("filekey");
    localObject = new ReqUpdateQQFace(new QQService.ReqHead(l, (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null), new FaceInfo((byte[])localObject, 0), 0);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqUpdateQQFace");
    paramUniPacket.put("ReqUpdateQQFace", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqUpdateQQFace");
    return true;
  }
  
  private Object c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespSetUserState)a(paramFromServiceMsg.getWupBuffer(), "RespSetUserState", new RespSetUserState());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetVisitorList)a(paramFromServiceMsg.getWupBuffer(), "RespGetVisitorList", new RespGetVisitorList());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("selfuin");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("filekey");
    int i = paramToServiceMsg.extraData.getInt("timestamp", 0);
    Object localObject1 = new QQService.ReqHead(l, (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    localObject2 = new FaceInfo((byte[])localObject2, 0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    localObject1 = new ReqAddFace((QQService.ReqHead)localObject1, i, localArrayList);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqAddFace");
    paramUniPacket.put("ReqAddFace", localObject1);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqAddFace");
    return true;
  }
  
  private Object d(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespSetStateSwitch)a(paramFromServiceMsg.getWupBuffer(), "RespSetStateSwitch", new RespSetStateSwitch());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetVoterList)a(paramFromServiceMsg.getWupBuffer(), "RespGetVoterList", new RespGetVoterList());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfuin");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("filekey");
    long l2 = paramToServiceMsg.extraData.getLong("timestamp");
    Object localObject1 = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    localObject2 = new FaceInfo((byte[])localObject2, 0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    localObject1 = new ReqDelFace((QQService.ReqHead)localObject1, (int)l2, localArrayList);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqDelFace");
    paramUniPacket.put("ReqDelFace", localObject1);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqDelFace");
    return true;
  }
  
  private Object e(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespGetSwitches)a(paramFromServiceMsg.getWupBuffer(), "RespGetSwitches", new RespGetSwitches());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    int i = paramToServiceMsg.extraData.getInt("timestamp", 0);
    Object localObject = new QQService.ReqHead(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    boolean bool = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(String.valueOf(l));
    if ((l == Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) || (bool)) {}
    for (byte b1 = 0;; b1 = 1)
    {
      localObject = new ReqFaceInfo((QQService.ReqHead)localObject, l, i, b1);
      paramUniPacket.setServantName("MCardSvc");
      paramUniPacket.setFuncName("ReqFaceInfo");
      paramUniPacket.put("ReqFaceInfo", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("MCardSvc.ReqFaceInfo");
      return true;
    }
  }
  
  private Object f(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.eReplyCode == 0)) {
      this.jdField_a_of_type_ArrayOfByte = paramFromServiceMsg.vContext;
    }
    return paramFromServiceMsg;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject1 = paramToServiceMsg.extraData.getString("lUin");
    long l = paramToServiceMsg.extraData.getLong("lNextMid");
    int i = paramToServiceMsg.extraData.getInt("iPageSize");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("strCookie");
    QQService.ReqHead localReqHead = new QQService.ReqHead(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    localObject2 = new UserCntlData(l, (byte[])localObject2);
    localObject1 = new ReqGetFace(localReqHead, Long.parseLong((String)localObject1), (UserCntlData)localObject2, i);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqGetFace");
    paramUniPacket.put("ReqGetFace", localObject1);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqGetFace");
    return true;
  }
  
  private Object g(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    int k = paramToServiceMsg.extraData.getInt("radius");
    paramToServiceMsg = new ReqGetAreaList();
    paramToServiceMsg.iLat = i;
    paramToServiceMsg.iLon = j;
    paramToServiceMsg.iRadius = k;
    paramUniPacket.setServantName("NearbyGroup");
    paramUniPacket.setFuncName("ReqGetAreaList");
    paramUniPacket.put("ReqGetAreaList", paramToServiceMsg);
    return true;
  }
  
  private Object h(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.extraData.getString("areaName");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    int k = paramToServiceMsg.extraData.getInt("startIndex");
    int m = paramToServiceMsg.extraData.getInt("count");
    paramToServiceMsg = new ReqGetGroupInArea();
    paramToServiceMsg.strAreaName = str;
    paramToServiceMsg.iLat = i;
    paramToServiceMsg.iLon = j;
    paramToServiceMsg.dwGroupStartIdx = k;
    paramToServiceMsg.iCount = m;
    paramUniPacket.setServantName("NearbyGroup");
    paramUniPacket.setFuncName("ReqGetGroupInArea");
    paramUniPacket.put("ReqGetGroupInArea", paramToServiceMsg);
    return true;
  }
  
  private Object i(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "LBSService --> decodeGetPointInfo(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespGetPoint)a(paramFromServiceMsg.getWupBuffer(), "RespGetPoint", new RespGetPoint());
      if (paramFromServiceMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LBSService", 2, "LBSService --> decodeGetPointInfo(), url: " + new String(paramFromServiceMsg.stUDLinfo.SOSOUrl) + " , cityId = " + paramFromServiceMsg.stUDLinfo.cityId);
        }
        return paramFromServiceMsg;
      }
    }
    return null;
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    String str = paramToServiceMsg.extraData.getString("strGroupArea");
    boolean bool = paramToServiceMsg.extraData.getBoolean("first");
    short s = paramToServiceMsg.extraData.getShort("shSortType");
    if ((i == 0) && (j == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    paramToServiceMsg = a(i, j);
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.shVersion = 2;
      paramToServiceMsg.iCount = 30;
      paramToServiceMsg.bShowOpen = true;
      paramToServiceMsg.bShowXiaoQu = true;
      paramToServiceMsg.bShowActivity = true;
      paramToServiceMsg.shSortType = s;
      if ((!bool) && (this.jdField_a_of_type_ArrayOfByte != null)) {
        paramToServiceMsg.vContext = this.jdField_a_of_type_ArrayOfByte;
      }
      if (!TextUtils.isEmpty(str)) {
        paramToServiceMsg.strGroupArea = str;
      }
      paramUniPacket.setServantName("NearbyGroup");
      paramUniPacket.setFuncName("GetList");
      paramUniPacket.put("ReqGetNearbyGroup", paramToServiceMsg);
      return true;
    }
    return false;
  }
  
  private Object j(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    if (paramToServiceMsg != null) {
      ReportLog.a("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + paramToServiceMsg.eReplyCode);
    }
    while (paramToServiceMsg != null) {
      if ((paramToServiceMsg.eReplyCode == 0) || (paramToServiceMsg.eReplyCode == 300))
      {
        paramFromServiceMsg = (RespGetEncounterV2)a(paramFromServiceMsg.getWupBuffer(), "RespGetEncounterV2", new RespGetEncounterV2());
        if (paramFromServiceMsg != null) {
          this.jdField_a_of_type_EncounterSvcUserData = paramFromServiceMsg.stUserData;
        }
        return paramFromServiceMsg;
        ReportLog.a("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + null);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("svenxu", 2, "cmd = " + paramFromServiceMsg.getServiceCmd() + " ReplyCode = " + paramToServiceMsg.eReplyCode);
        }
        LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg.eReplyCode);
        return Integer.valueOf(paramToServiceMsg.eReplyCode);
      }
    }
    LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1111);
    return null;
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int k = paramToServiceMsg.extraData.getInt("lat");
    int m = paramToServiceMsg.extraData.getInt("lon");
    Object localObject1;
    int i;
    boolean bool;
    NeighborComm.ReqHeader localReqHeader;
    EncounterSvc.ReqUserInfo localReqUserInfo;
    if ((k != 0) && (m != 0))
    {
      localObject1 = null;
      i = 1;
      if ((localObject1 == null) && (i == 0)) {
        break label698;
      }
      bool = paramToServiceMsg.extraData.getBoolean("first");
      localReqHeader = new NeighborComm.ReqHeader();
      localReqHeader.shVersion = 2;
      localReqHeader.lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
      localReqHeader.iAppID = AppSetting.jdField_a_of_type_Int;
      localReqHeader.eBusiType = 0;
      localReqHeader.eMqqSysType = 2;
      localReqUserInfo = new EncounterSvc.ReqUserInfo();
      localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
      localReqUserInfo.strAuthPassword = "NzVK_qGE";
      localReqUserInfo.eListType = 0;
      if (i == 0) {
        break label339;
      }
      localReqUserInfo.vCells = new ArrayList(1);
      localReqUserInfo.vMacs = new ArrayList(1);
      localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      localReqUserInfo.stGps = new EncounterSvc.GPS(k, m, 0, 1);
    }
    int n;
    for (;;)
    {
      if ((this.jdField_a_of_type_EncounterSvcUserData == null) || (bool)) {
        this.jdField_a_of_type_EncounterSvcUserData = new EncounterSvc.UserData();
      }
      n = paramToServiceMsg.extraData.getInt("gender");
      Object localObject3 = paramToServiceMsg.extraData.getLongArray("tags");
      localObject2 = null;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label561;
      }
      localObject1 = localObject2;
      if (localObject3.length <= 0) {
        break label561;
      }
      localObject2 = new ArrayList();
      int j = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (j >= localObject3.length) {
          break;
        }
        ((ArrayList)localObject2).add(Long.valueOf(localObject3[j]));
        j += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      i = 0;
      break;
      label339:
      localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
      localReqUserInfo.stGps = new EncounterSvc.GPS(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int, ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b, -1, 0);
      localReqUserInfo.vSOSOCells = new ArrayList();
      if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
          localReqUserInfo.vSOSOCells.add(new SOSO_Cell((short)((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject3).b, ((SosoInterface.SosoCell)localObject3).c, ((SosoInterface.SosoCell)localObject3).d, (short)((SosoInterface.SosoCell)localObject3).e));
        }
      }
      localReqUserInfo.vSOSOMac = new ArrayList();
      if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
      {
        localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
          localReqUserInfo.vSOSOMac.add(new SOSO_Wifi(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long, (short)((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int));
        }
      }
    }
    label561:
    Object localObject2 = a(k, m, bool);
    if (i != 0) {
      i = paramToServiceMsg.extraData.getInt("roamMode");
    }
    for (paramToServiceMsg = new ReqGetEncounterV2(localReqUserInfo, this.jdField_a_of_type_EncounterSvcUserData, n, -1, (ArrayList)localObject1, new byte[1], (byte)i, 2000, -1, 0, null, (byte[])localObject2, 0, (byte)1);; paramToServiceMsg = new ReqGetEncounterV2(localReqUserInfo, this.jdField_a_of_type_EncounterSvcUserData, n, -1, (ArrayList)localObject1, new byte[1], (byte)0, 2000, -1, 0, null, (byte[])localObject2, 0, (byte)1))
    {
      paramUniPacket.setEncodeName("utf-8");
      paramUniPacket.setServantName("EncounterObj");
      paramUniPacket.setFuncName("CMD_GET_ENCOUNTERV2");
      paramUniPacket.put("ReqHeader", localReqHeader);
      paramUniPacket.put("ReqGetEncounterV2", paramToServiceMsg);
      return true;
    }
    label698:
    return false;
  }
  
  private Object k(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetNeighbors)a(paramFromServiceMsg.getWupBuffer(), "RespGetNeighbors", new RespGetNeighbors());
    if (paramToServiceMsg != null) {
      return paramToServiceMsg.stUserData;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.eReplyCode == 0)) {}
    }
    for (int i = paramFromServiceMsg.eReplyCode;; i = -111)
    {
      LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
      return null;
    }
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.jdField_a_of_type_Int;
    if (paramToServiceMsg.extraData.getBoolean("k_visible_for_near_people")) {}
    for (int i = 1;; i = 0)
    {
      localObject = new ReqSetUserState((NeighborSvc.ReqHeader)localObject, i);
      paramUniPacket.setServantName("NeighborObj");
      paramUniPacket.setFuncName("CMD_SET_USER_STATE");
      paramUniPacket.put("ReqSetUserState", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("NeighborSvc.ReqSetUserState");
      return true;
    }
  }
  
  private Object l(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespCommonCard)a(paramFromServiceMsg.getWupBuffer(), "RespCommonCard", new RespCommonCard());
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = 0;
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.jdField_a_of_type_Int;
    if (paramToServiceMsg.extraData.getBoolean("k_be_share", false)) {
      i = 1;
    }
    localObject = new ReqSetStateSwitch((NeighborSvc.ReqHeader)localObject, (byte)i);
    paramUniPacket.setServantName("NeighborObj");
    paramUniPacket.setFuncName("CMD_SET_STATE_SWITCH");
    paramUniPacket.put("ReqSetStateSwitch", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("NeighborSvc.ReqSetStateSwitch");
    return true;
  }
  
  private Object m(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespFaceInfo)a(paramFromServiceMsg.getWupBuffer(), "RespFaceInfo", new RespFaceInfo());
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.jdField_a_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(64));
    localObject = new ReqGetSwitches((NeighborSvc.ReqHeader)localObject, localArrayList);
    paramUniPacket.setServantName("NeighborObj");
    paramUniPacket.setFuncName("CMD_GET_SWITCHES");
    paramUniPacket.put("ReqGetSwitches", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("NeighborSvc.ReqGetSwitches");
    return true;
  }
  
  private Object n(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespMakeFriendsCard)a(paramFromServiceMsg.getWupBuffer(), "RespMakeFriendsCard", new RespMakeFriendsCard());
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int j = paramToServiceMsg.extraData.getInt("lat");
    int k = paramToServiceMsg.extraData.getInt("lon");
    Object localObject1;
    int i;
    boolean bool;
    NeighborSvc.ReqHeader localReqHeader;
    NeighborSvc.ReqUserInfo localReqUserInfo;
    if ((j != 0) && (k != 0))
    {
      localObject1 = null;
      i = 1;
      if ((localObject1 == null) && (i == 0)) {
        break label529;
      }
      bool = paramToServiceMsg.extraData.getBoolean("first");
      localReqHeader = new NeighborSvc.ReqHeader();
      localReqHeader.shVersion = 2;
      localReqHeader.lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
      localReqHeader.iAppID = AppSetting.jdField_a_of_type_Int;
      localReqHeader.eBusiType = 0;
      localReqHeader.eMqqSysType = 2;
      localReqUserInfo = new NeighborSvc.ReqUserInfo();
      localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
      localReqUserInfo.strAuthPassword = "NzVK_qGE";
      localReqUserInfo.eListType = 0;
      if (i == 0) {
        break label307;
      }
      localReqUserInfo.vCells = new ArrayList(1);
      localReqUserInfo.vMacs = new ArrayList(1);
      localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      localReqUserInfo.stGps = new NeighborSvc.GPS(j, k, 0, 1);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_NeighborSvcUserData == null) || (bool)) {
        this.jdField_a_of_type_NeighborSvcUserData = new NeighborSvc.UserData();
      }
      localObject1 = new ReqGetNeighbors(localReqHeader, localReqUserInfo, this.jdField_a_of_type_NeighborSvcUserData, -1, 0, null, 0, null);
      paramUniPacket.setServantName("NeighborObj");
      paramUniPacket.setFuncName("CMD_GET_NEIGHBORS");
      paramUniPacket.put("ReqGetNeighbors", localObject1);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("NeighborSvc.ReqGetNeighbors");
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      i = 0;
      break;
      label307:
      localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
      localReqUserInfo.stGps = new NeighborSvc.GPS(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int, ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b, -1, 0);
      localReqUserInfo.vSOSOCells = new ArrayList();
      Object localObject2;
      if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          SosoInterface.SosoCell localSosoCell = (SosoInterface.SosoCell)((Iterator)localObject2).next();
          localReqUserInfo.vSOSOCells.add(new SOSO_Cell((short)localSosoCell.jdField_a_of_type_Int, (short)localSosoCell.b, localSosoCell.c, localSosoCell.d, (short)localSosoCell.e));
        }
      }
      localReqUserInfo.vSOSOMac = new ArrayList();
      if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
      {
        localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
          localReqUserInfo.vSOSOMac.add(new SOSO_Wifi(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long, (short)((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int));
        }
      }
    }
    label529:
    paramUniPacket = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    paramUniPacket.setMsgFail();
    try
    {
      paramToServiceMsg.actionListener.onActionResult(paramUniPacket);
      label559:
      return false;
    }
    catch (RemoteException paramToServiceMsg)
    {
      break label559;
    }
  }
  
  private Object o(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespHYCommonCard)a(paramFromServiceMsg.getWupBuffer(), "RespHYCommonCard", new RespHYCommonCard());
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    if (((bool1) && (i != 0) && (j != 0)) || (bool2))
    {
      NeighborSvc.ReqHeader localReqHeader = new NeighborSvc.ReqHeader();
      localReqHeader.shVersion = 2;
      localReqHeader.lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
      localReqHeader.iAppID = AppSetting.jdField_a_of_type_Int;
      localReqHeader.eBusiType = 0;
      localReqHeader.eMqqSysType = 2;
      Object localObject1 = new NeighborSvc.ReqUserInfo();
      ((NeighborSvc.ReqUserInfo)localObject1).strAuthName = "B1_QQ_Neighbor_android";
      ((NeighborSvc.ReqUserInfo)localObject1).strAuthPassword = "NzVK_qGE";
      ((NeighborSvc.ReqUserInfo)localObject1).eListType = 0;
      label218:
      byte b1;
      if (bool1)
      {
        ((NeighborSvc.ReqUserInfo)localObject1).vCells = new ArrayList(1);
        ((NeighborSvc.ReqUserInfo)localObject1).vMacs = new ArrayList(1);
        ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(i, j, 0, 1);
        ((NeighborSvc.ReqUserInfo)localObject1).eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
        if (!bool1) {
          break label576;
        }
        i = 1;
        b1 = (byte)i;
        if (!bool2) {
          break label582;
        }
      }
      label576:
      label582:
      for (i = 1;; i = 0)
      {
        localObject1 = new ReqGetPoint((NeighborSvc.ReqUserInfo)localObject1, b1, (byte)i);
        paramUniPacket.setServantName("NeighborObj");
        paramUniPacket.setFuncName("CMD_GET_POINT");
        paramUniPacket.put("ReqHeader", localReqHeader);
        paramUniPacket.put("ReqGetPoint", localObject1);
        paramToServiceMsg.setTimeout(30000L);
        paramToServiceMsg.setServiceCmd("NeighborSvc.ReqGetPoint");
        return true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localObject2 == null) {
          return false;
        }
        if (((NearbyGroup.LBSInfo)localObject2).vWifis != null)
        {
          ((NeighborSvc.ReqUserInfo)localObject1).vMacs = new ArrayList(((NearbyGroup.LBSInfo)localObject2).vWifis.size());
          i = 0;
          while (i < ((NearbyGroup.LBSInfo)localObject2).vWifis.size())
          {
            ((NeighborSvc.ReqUserInfo)localObject1).vMacs.add(Long.valueOf(((NearbyGroup.Wifi)((NearbyGroup.LBSInfo)localObject2).vWifis.get(i)).lMac));
            i += 1;
          }
        }
        ((NeighborSvc.ReqUserInfo)localObject1).vMacs = new ArrayList();
        if (((NearbyGroup.LBSInfo)localObject2).vCells != null)
        {
          ((NeighborSvc.ReqUserInfo)localObject1).vCells = new ArrayList(((NearbyGroup.LBSInfo)localObject2).vCells.size());
          i = 0;
          while (i < ((NearbyGroup.LBSInfo)localObject2).vCells.size())
          {
            NearbyGroup.Cell localCell = (NearbyGroup.Cell)((NearbyGroup.LBSInfo)localObject2).vCells.get(i);
            ((NeighborSvc.ReqUserInfo)localObject1).vCells.add(new NeighborSvc.Cell(localCell.shMcc, localCell.shMnc, localCell.iLac, localCell.iCellId));
            i += 1;
          }
        }
        ((NeighborSvc.ReqUserInfo)localObject1).vCells = new ArrayList();
        if (((NearbyGroup.LBSInfo)localObject2).stGps == null) {
          break;
        }
        localObject2 = ((NearbyGroup.LBSInfo)localObject2).stGps;
        ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(((NearbyGroup.GPS)localObject2).iLat, ((NearbyGroup.GPS)localObject2).iLon, ((NearbyGroup.GPS)localObject2).iAlt, ((NearbyGroup.GPS)localObject2).eType);
        break;
        i = 0;
        break label218;
      }
    }
    paramUniPacket = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    paramUniPacket.setMsgFail();
    try
    {
      paramToServiceMsg.actionListener.onActionResult(paramUniPacket);
      label618:
      return false;
    }
    catch (RemoteException paramToServiceMsg)
    {
      break label618;
    }
  }
  
  private Object p(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespHYMakeFriendsCard)a(paramFromServiceMsg.getWupBuffer(), "RespHYMakeFriendsCard", new RespHYMakeFriendsCard());
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    localObject = new ReqCommonCard((QQService.ReqHead)localObject, paramToServiceMsg.extraData.getInt("uFaceTimeStamp"));
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqCommonCard");
    paramUniPacket.put("ReqCommonCard", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqCommonCard");
    return true;
  }
  
  private Object q(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespUpdateIntro)a(paramFromServiceMsg.getWupBuffer(), "RespUpdateIntro", new RespUpdateIntro());
  }
  
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    byte b1 = paramToServiceMsg.extraData.getByte("bReqType");
    ((QQService.ReqHead)localObject).bReqType = b1;
    localObject = new ReqMakeFriendsCard((QQService.ReqHead)localObject, b1, paramToServiceMsg.extraData.getInt("uFaceTimeStamp"));
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqMakeFriendsCard");
    paramUniPacket.put("ReqMakeFriendsCard", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqMakeFriendsCard");
    return true;
  }
  
  private Object r(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSummaryCard)a(paramFromServiceMsg.getWupBuffer(), "RespSummaryCard", new RespSummaryCard());
  }
  
  private boolean r(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    long l = Long.parseLong(paramToServiceMsg.extraData.getString("friendUin"));
    byte b1 = paramToServiceMsg.extraData.getByte("bReqType");
    ((QQService.ReqHead)localObject).bReqType = b1;
    localObject = new ReqHYCommonCard((QQService.ReqHead)localObject, l, b1, paramToServiceMsg.extraData.getInt("uFaceTimeStamp"));
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqHYCommonCard");
    paramUniPacket.put("ReqHYCommonCard", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqHYCommonCard");
    return true;
  }
  
  private Object s(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespVoiceManage)a(paramFromServiceMsg.getWupBuffer(), "RespVoiceManage", new RespVoiceManage());
  }
  
  private boolean s(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    long l = Long.parseLong(paramToServiceMsg.extraData.getString("friendUin"));
    byte b1 = paramToServiceMsg.extraData.getByte("bReqType");
    ((QQService.ReqHead)localObject).bReqType = b1;
    localObject = new ReqHYMakeFriendsCard((QQService.ReqHead)localObject, l, b1, paramToServiceMsg.extraData.getInt("uFaceTimeStamp"));
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqHYMakeFriendsCard");
    paramUniPacket.put("ReqHYMakeFriendsCard", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqHYMakeFriendsCard");
    return true;
  }
  
  private Object t(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSearch)a(paramFromServiceMsg.getWupBuffer(), "RespSearch", new RespSearch());
  }
  
  private boolean t(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    String str = paramToServiceMsg.extraData.getString("vContent");
    localObject = new ReqUpdateIntro((QQService.ReqHead)localObject, new Intro(paramToServiceMsg.extraData.getShort("shType"), str.getBytes()));
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqUpdateIntro");
    paramUniPacket.put("ReqUpdateIntro", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqUpdateIntro");
    return true;
  }
  
  private Object u(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespCondSearch)a(paramFromServiceMsg.getWupBuffer(), "RespCondSearch", new RespCondSearch());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.vUserList != null) && (!paramFromServiceMsg.vUserList.isEmpty()))
    {
      int i = 0;
      while (i < paramFromServiceMsg.vUserList.size())
      {
        paramToServiceMsg = (CondFitUser)paramFromServiceMsg.vUserList.get(i);
        if (paramToServiceMsg.vRichSign != null) {
          paramToServiceMsg.richStatus = RichStatus.a(paramToServiceMsg.vRichSign);
        }
        String str1 = ConditionSearchManager.a(paramToServiceMsg.dwCountry);
        String str2 = ConditionSearchManager.a(paramToServiceMsg.dwProvince);
        String str3 = ConditionSearchManager.a(paramToServiceMsg.dwCity);
        paramToServiceMsg.locDesc = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(new String[] { str1, str2, str3, "0" });
        i += 1;
      }
    }
    return paramFromServiceMsg;
  }
  
  private boolean u(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin", 0L);
    int n = paramToServiceMsg.extraData.getInt("comeFromType", 0);
    long l3 = paramToServiceMsg.extraData.getLong("qzoneFeedTimeStamp", 0L);
    byte b1 = paramToServiceMsg.extraData.getByte("isFriend");
    long l4 = paramToServiceMsg.extraData.getLong("troopCode", 0L);
    long l5 = paramToServiceMsg.extraData.getLong("troopUin", 0L);
    String str = paramToServiceMsg.extraData.getString("strSearchName");
    long l6 = paramToServiceMsg.extraData.getLong("lGetControl");
    int i1 = paramToServiceMsg.extraData.getInt("EAddFriendSource");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("vSeed");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new byte[1];
      localObject1[0] = 0;
    }
    Object localObject3 = paramToServiceMsg.extraData.getByteArray("vSecureSig");
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new byte[1];
      localObject2[0] = 0;
    }
    localObject3 = new ReqLastGameInfo((byte)1, l2);
    Object localObject5 = new UniPacket(true);
    ((UniPacket)localObject5).setEncodeName("utf-8");
    ((UniPacket)localObject5).setFuncName("ReqLastGameInfo");
    ((UniPacket)localObject5).setServantName("QQService.GameSvc");
    ((UniPacket)localObject5).put("ReqLastGameInfo", localObject3);
    localObject5 = ((UniPacket)localObject5).encode();
    localObject3 = new SSummaryCardQueryReq(1, Long.parseLong(paramToServiceMsg.getUin()), l2, "6.0.0", n, 109L);
    Object localObject6 = new UniPacket(true);
    ((UniPacket)localObject6).setEncodeName("utf-8");
    ((UniPacket)localObject6).setFuncName("query");
    ((UniPacket)localObject6).setServantName("MCardSvc");
    ((UniPacket)localObject6).put("req", localObject3);
    localObject6 = ((UniPacket)localObject6).encode();
    for (;;)
    {
      try
      {
        i = Integer.parseInt("6500");
        localArrayList = new ArrayList();
        if ((l2 > 0L) || (n == 37))
        {
          int[] arrayOfInt = new int[4];
          int[] tmp362_360 = arrayOfInt;
          tmp362_360[0] = 1;
          int[] tmp366_362 = tmp362_360;
          tmp366_362[1] = 2;
          int[] tmp370_366 = tmp366_362;
          tmp370_366[2] = 3;
          int[] tmp374_370 = tmp370_366;
          tmp374_370[3] = 4;
          tmp374_370;
          int j = 0;
          if (j < tmp370_366.length)
          {
            Object localObject7 = new SummaryCardBusiEntry.comm();
            ((SummaryCardBusiEntry.comm)localObject7).ver.set(1);
            ((SummaryCardBusiEntry.comm)localObject7).seq.set(paramToServiceMsg.getAppSeq());
            ((SummaryCardBusiEntry.comm)localObject7).fromuin.set(l1);
            ((SummaryCardBusiEntry.comm)localObject7).touin.set(l2);
            ((SummaryCardBusiEntry.comm)localObject7).service.set(tmp370_366[j]);
            if ((tmp370_366[j] == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
            {
              localObject3 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
              if (localObject3 == null) {
                break label802;
              }
              localObject3 = ((TicketManager)localObject3).getSid(String.valueOf(l1));
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label796;
              }
              localObject3 = ((String)localObject3).getBytes();
              if (localObject3 != null) {
                ((SummaryCardBusiEntry.comm)localObject7).session_key.set(ByteStringMicro.copyFrom((byte[])localObject3));
              }
            }
            ((SummaryCardBusiEntry.comm)localObject7).platform.set(2);
            ((SummaryCardBusiEntry.comm)localObject7).qqver.set("6.0.0.6500");
            ((SummaryCardBusiEntry.comm)localObject7).build.set(i);
            localObject3 = ((SummaryCardBusiEntry.comm)localObject7).toByteArray();
            int k = localObject3.length;
            localObject7 = new byte[k + 9 + 0 + 1];
            localObject7[0] = 40;
            PkgTools.a((byte[])localObject7, 1, k);
            PkgTools.a((byte[])localObject7, 5, 0);
            PkgTools.a((byte[])localObject7, 9, (byte[])localObject3, k);
            int m = localObject3.length + 9;
            k = m;
            if (0 != 0)
            {
              PkgTools.a((byte[])localObject7, m, null, 0);
              k = m + 0;
            }
            localObject7[k] = 41;
            tmp366_362.add(localObject7);
            j += 1;
            continue;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ArrayList localArrayList;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localNumberFormatException.toString());
        }
        int i = 0;
        continue;
        localObject1 = new ReqSummaryCard(l2, n, l3, b1, l4, l5, (byte[])localObject1, str, l6, i1, (byte[])localObject2, (byte[])localObject5, (byte[])tmp362_360, null, tmp366_362);
        localObject2 = new SummaryCard.ReqHead();
        paramUniPacket.setServantName("SummaryCardServantObj");
        paramUniPacket.setFuncName("ReqSummaryCard");
        paramUniPacket.put("ReqHead", localObject2);
        paramUniPacket.put("ReqSummaryCard", localObject1);
        paramToServiceMsg.setTimeout(30000L);
        paramToServiceMsg.setServiceCmd("SummaryCard.ReqSummaryCard");
        return true;
      }
      label796:
      Object localObject4 = null;
      continue;
      label802:
      localObject4 = null;
    }
  }
  
  private Object v(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSetCard)a(paramFromServiceMsg.getWupBuffer(), "RespSetCard", new RespSetCard());
  }
  
  private boolean v(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("pttcenter_targetuin", 0L);
    int i = paramToServiceMsg.extraData.getInt("pttcenter_voice_optype");
    short s = paramToServiceMsg.extraData.getShort("pttcenter_shDuration");
    Object localObject = paramToServiceMsg.extraData.getString("pttcenter_filekey");
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "handleVoiceManager() destUin = " + l + ", eOpType = " + i + ", shDuration = " + s + ", filekey = " + (String)localObject);
    }
    localObject = new ReqVoiceManage(i, new VoiceInfo(ProfileCardUtil.a((String)localObject), s, (byte)0, null), l);
    SummaryCard.ReqHead localReqHead = new SummaryCard.ReqHead();
    paramUniPacket.setServantName("SummaryCardServantObj");
    paramUniPacket.setFuncName("ReqVoiceManage");
    paramUniPacket.put("ReqHead", localReqHead);
    paramUniPacket.put("ReqVoiceManage", localObject);
    paramToServiceMsg.setTimeout(30000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.ReqVoiceManage");
    return true;
  }
  
  private Object w(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSetCardSwitch)a(paramFromServiceMsg.getWupBuffer(), "RespSetCardSwitch", new RespSetCardSwitch());
  }
  
  private boolean w(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = paramToServiceMsg.extraData.getByteArray("devicedata");
    paramToServiceMsg = new LBSAddrProtocol.ReqHeader((short)2, 0, paramToServiceMsg.extraData.getString("account"), 0, 0, "B1_QQ_Neighbor_android", "NzVK_qGE", "");
    localObject = new ReqGetPositionApi((byte[])localObject, 0);
    paramUniPacket.setServantName("LBS.AddressServer.AddressServantObj");
    paramUniPacket.setFuncName("ReqGetPositionApi");
    paramUniPacket.put("ReqHeader", paramToServiceMsg);
    paramUniPacket.put("ReqGetPositionApi", localObject);
    return true;
  }
  
  private Object x(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespGetCardSwitch)a(paramFromServiceMsg.getWupBuffer(), "RespGetCardSwitch", new RespGetCardSwitch());
  }
  
  private boolean x(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject3 = null;
    QQService.ReqHead localReqHead = new QQService.ReqHead();
    localReqHead.shVersion = 2;
    localReqHead.iSeq = paramUniPacket.getRequestId();
    localReqHead.lUIN = Long.parseLong(paramToServiceMsg.getUin());
    int i = paramToServiceMsg.extraData.getInt("eSubCmd");
    byte b1 = paramToServiceMsg.extraData.getByte("bIsSingle");
    byte[] arrayOfByte1 = paramToServiceMsg.extraData.getByteArray("vBackground");
    byte[] arrayOfByte2 = paramToServiceMsg.extraData.getByteArray("vReqSetTemplate");
    for (;;)
    {
      try
      {
        Object localObject1 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vTagsID"))).readObject();
        ArrayList localArrayList2;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localArrayList1 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vDelTags"))).readObject();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            ArrayList localArrayList1 = null;
          }
        }
        try
        {
          localArrayList2 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vAddTags"))).readObject();
          localObject1 = new ReqSetCard(localReqHead, i, b1, (ArrayList)localObject1, arrayOfByte1, localArrayList1, localArrayList2, arrayOfByte2);
          paramUniPacket.setServantName("MCardSvc");
          paramUniPacket.setFuncName("ReqSetCard");
          paramUniPacket.put("ReqSetCard", localObject1);
          paramToServiceMsg.setTimeout(10000L);
          paramToServiceMsg.setServiceCmd("MCardSvc.ReqSetCard");
          return true;
        }
        catch (Exception localException3)
        {
          break label252;
        }
        localException1 = localException1;
        localArrayList1 = null;
        localObject1 = null;
      }
      label252:
      localObject2 = localObject3;
    }
  }
  
  private boolean y(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    localObject = new ReqGetCardSwitch((QQService.ReqHead)localObject);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqGetCardSwitch");
    paramUniPacket.put("ReqGetCardSwitch", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqGetCardSwitch");
    return true;
  }
  
  private boolean z(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    boolean bool = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    long l = paramToServiceMsg.extraData.getLong("target_value");
    if (bool) {}
    for (localObject = new ReqSetCardSwitch((QQService.ReqHead)localObject, l, 2L);; localObject = new ReqSetCardSwitch((QQService.ReqHead)localObject, 2L, l))
    {
      paramUniPacket.setServantName("MCardSvc");
      paramUniPacket.setFuncName("ReqSetCardSwitch");
      paramUniPacket.put("ReqSetCardSwitch", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("MCardSvc.ReqSetCardSwitch");
      return true;
    }
  }
  
  public Object a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespGetFace)a(paramFromServiceMsg.getWupBuffer(), "RespGetFace", new RespGetFace());
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("LBS.AddressService".equals(paramFromServiceMsg.getServiceCmd())) {
      return b(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqGetNeighbors".equals(paramFromServiceMsg.getServiceCmd())) {
      return k(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqSetUserState".equals(paramFromServiceMsg.getServiceCmd())) {
      return c(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd())) {
      return j(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqCommonCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return l(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqFaceInfo".equals(paramFromServiceMsg.getServiceCmd())) {
      return m(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqUpdateQQFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return (RespUpdateQQFace)a(paramFromServiceMsg.getWupBuffer(), "RespUpdateQQFace", new RespUpdateQQFace());
    }
    if ("MCardSvc.ReqMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return n(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqHYCommonCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return o(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqHYMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return p(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqAddFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return (RespAddFace)a(paramFromServiceMsg.getWupBuffer(), "RespAddFace", new RespAddFace());
    }
    if ("MCardSvc.ReqDelFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return (RespDelFace)a(paramFromServiceMsg.getWupBuffer(), "RespDelFace", new RespDelFace());
    }
    if ("MCardSvc.ReqUpdateIntro".equals(paramFromServiceMsg.getServiceCmd())) {
      return q(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return v(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqGetCardSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return x(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqSetCardSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return w(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqGetFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return a(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return r(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqVoiceManage".equals(paramFromServiceMsg.getServiceCmd())) {
      return s(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.GetGroupList".equals(paramFromServiceMsg.getServiceCmd())) {
      return f(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.ReqGetAreaList".equals(paramFromServiceMsg.getServiceCmd())) {
      return g(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.ReqGetGroupInArea".equals(paramFromServiceMsg.getServiceCmd())) {
      return h(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqSetStateSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return d(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqGetSwitches".equals(paramFromServiceMsg.getServiceCmd())) {
      return e(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd())) {
      return i(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return t(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return u(paramFromServiceMsg, paramToServiceMsg);
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespVote)a(paramFromServiceMsg.getWupBuffer(), "RespVote", new RespVote());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
      localFromServiceMsg.setBusinessFail(1002, 1002, "");
      paramToServiceMsg.actionListener.onActionResult(localFromServiceMsg);
      return;
    }
    catch (RemoteException paramToServiceMsg) {}
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString)
  {
    try
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
      localFromServiceMsg.setBusinessFail(paramInt, paramInt, paramString);
      paramToServiceMsg.actionListener.onActionResult(localFromServiceMsg);
      return;
    }
    catch (RemoteException paramToServiceMsg) {}
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        return;
      } while (("NeighborSvc.ReqGetNeighbors".equals(paramFromServiceMsg.getServiceCmd())) || ("NeighborSvc.ReqSetUserState".equals(paramFromServiceMsg.getServiceCmd())));
      if ("VisitorSvc.ReqVote".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramFromServiceMsg, paramToServiceMsg);
        return;
      }
      if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramFromServiceMsg, paramToServiceMsg);
        return;
      }
      if ("VisitorSvc.ReqGetVisitorList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramFromServiceMsg, paramToServiceMsg);
        return;
      }
    } while (("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd())) || (!"VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd())));
    b(paramFromServiceMsg, paramToServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equals("EncounterSvc.ReqGetEncounter")) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("NeighborSvc.ReqGetNeighbors")) {
      return n(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("NeighborSvc.ReqSetUserState")) {
      return k(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqCommonCard")) {
      return p(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqMakeFriendsCard")) {
      return q(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqHYCommonCard")) {
      return r(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqHYMakeFriendsCard")) {
      return s(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqAddFace")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqDelFace")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqFaceInfo")) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqUpdateIntro")) {
      return t(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqUpdateQQFace")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCard")) {
      return x(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqGetCardSwitch")) {
      return y(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCardSwitch")) {
      return z(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqVote")) {
      return A(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetVoterList")) {
      return C(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetVisitorList")) {
      return D(paramToServiceMsg, paramUniPacket);
    }
    if ("LBS.AddressService".equals(paramToServiceMsg.getServiceCmd())) {
      return w(paramToServiceMsg, paramUniPacket);
    }
    if ("MCardSvc.ReqPicSafetyCheck".equals(paramToServiceMsg.getServiceCmd())) {
      return E(paramToServiceMsg, paramUniPacket);
    }
    if ("MCardSvc.ReqGetFace".equals(paramToServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqSummaryCard".equals(paramToServiceMsg.getServiceCmd())) {
      return u(paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqVoiceManage".equals(paramToServiceMsg.getServiceCmd())) {
      return v(paramToServiceMsg, paramUniPacket);
    }
    if ("VisitorSvc.ReqFavorite".equals(paramToServiceMsg.getServiceCmd())) {
      return B(paramToServiceMsg, paramUniPacket);
    }
    if ("NearbyGroup.GetGroupList".equals(paramToServiceMsg.getServiceCmd())) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    if ("NearbyGroup.ReqGetAreaList".equals(paramToServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if ("NearbyGroup.ReqGetGroupInArea".equals(paramToServiceMsg.getServiceCmd())) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborSvc.ReqSetStateSwitch".equals(paramToServiceMsg.getServiceCmd())) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborSvc.ReqGetSwitches".equals(paramToServiceMsg.getServiceCmd())) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramToServiceMsg.getServiceCmd())) {
      return o(paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqSearch".equals(paramToServiceMsg.getServiceCmd())) {
      return F(paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqCondSearch".equals(paramToServiceMsg.getServiceCmd())) {
      return G(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespFavorite)a(paramFromServiceMsg.getWupBuffer(), "RespFavorite", new RespFavorite());
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.lbs.LBSService
 * JD-Core Version:    0.7.0.1
 */