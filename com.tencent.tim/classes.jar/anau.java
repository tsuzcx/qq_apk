import EncounterSvc.GPS;
import EncounterSvc.ReqGetRecommender;
import EncounterSvc.ReqUserInfo;
import EncounterSvc.RespGetRecommender;
import EncounterSvc.UserData;
import GameCenter.ReqLastGameInfo;
import NearbyGroup.ReqGetAreaList;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetNearbyGroup;
import NeighborComm.LocalInfoType;
import NeighborComm.RespHeader;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import NeighborSvc.ReqGetSwitches;
import NeighborSvc.ReqSetStateSwitch;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import QQService.FaceInfo;
import QQService.Intro;
import QQService.ReqAddFace;
import QQService.ReqDelFace;
import QQService.ReqDeleteVisitorRecord;
import QQService.ReqFaceInfo;
import QQService.ReqGetCardSwitch;
import QQService.ReqGetFace;
import QQService.ReqGetFavoriteList;
import QQService.ReqGetVoterList;
import QQService.ReqHYMakeFriendsCard;
import QQService.ReqPicSafetyCheck;
import QQService.ReqSetCard;
import QQService.ReqSetCardSwitch;
import QQService.ReqUpdateIntro;
import QQService.ReqVote;
import QQService.RespAddFace;
import QQService.RespDelFace;
import QQService.RespDeleteVisitorRecord;
import QQService.RespFaceInfo;
import QQService.RespGetCardSwitch;
import QQService.RespGetFace;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespHYMakeFriendsCard;
import QQService.RespHead;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.RespUpdateIntro;
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
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardLikeIt;
import SummaryCardTaf.SSummaryCardQueryReq;
import SummaryCardTaf.SSummaryCardSetLabel;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.mini.servlet.GetFriendPlayListV2Request;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.lbs.BusinessBuff;
import com.tencent.pb.addcontacts.AccountSearchPb.Location;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.pb.addcontacts.AccountSearchPb.search;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.LoginSig;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.ReqBody;

public class anau
  extends swr
{
  private static String[] gu = { "NeighborSvc", "KQQFS", "MCardSvc", "MobileQQ", "EncounterSvc", "VisitorSvc", "LBS", "SummaryCard", "NearbyGroup", "NeighborRecommender" };
  public UserData[] a = new UserData[2];
  private AppInterface app;
  private byte[] fr = new byte[0];
  
  public anau(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
  }
  
  private boolean N(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
  
  private boolean O(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
  
  private boolean P(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    int i = paramToServiceMsg.extraData.getInt("timestamp", 0);
    Object localObject = new QQService.ReqHead(Long.parseLong(this.app.getCurrentAccountUin()), (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    boolean bool = ((acff)this.app.getManager(51)).isFriend(String.valueOf(l));
    if ((l == Long.parseLong(this.app.getCurrentAccountUin())) || (bool)) {}
    for (byte b = 0;; b = 1)
    {
      localObject = new ReqFaceInfo((QQService.ReqHead)localObject, l, i, b);
      paramUniPacket.setServantName("MCardSvc");
      paramUniPacket.setFuncName("ReqFaceInfo");
      paramUniPacket.put("ReqFaceInfo", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("MCardSvc.ReqFaceInfo");
      return true;
    }
  }
  
  private boolean Q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject1 = paramToServiceMsg.extraData.getString("lUin");
    long l = paramToServiceMsg.extraData.getLong("lNextMid");
    int i = paramToServiceMsg.extraData.getInt("iPageSize");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("strCookie");
    QQService.ReqHead localReqHead = new QQService.ReqHead(Long.parseLong(this.app.getCurrentAccountUin()), (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    localObject2 = new UserCntlData(l, (byte[])localObject2);
    localObject1 = new ReqGetFace(localReqHead, Long.parseLong((String)localObject1), (UserCntlData)localObject2, i);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqGetFace");
    paramUniPacket.put("ReqGetFace", localObject1);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqGetFace");
    return true;
  }
  
  private boolean R(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    int k = paramToServiceMsg.extraData.getInt("radius");
    paramToServiceMsg = new ReqGetAreaList();
    paramToServiceMsg.iLat = i;
    paramToServiceMsg.iLon = j;
    paramToServiceMsg.iRadius = k;
    paramToServiceMsg.vClientVersion = "3.4.4".getBytes();
    paramToServiceMsg.uiClientType = 2L;
    paramUniPacket.setServantName("NearbyGroup");
    paramUniPacket.setFuncName("ReqGetAreaList");
    paramUniPacket.put("ReqGetAreaList", paramToServiceMsg);
    return true;
  }
  
  private boolean S(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return true;
  }
  
  private boolean T(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "handleGetNearbyRecommender");
    }
    Object localObject1 = SosoInterface.b();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).a == null) || (((SosoInterface.SosoLbsInfo)localObject1).a.cf == 0.0D) || (((SosoInterface.SosoLbsInfo)localObject1).a.cg == 0.0D))
    {
      SosoInterface.aj(60000L, getClass().getSimpleName());
      localObject1 = SosoInterface.b();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        NeighborComm.ReqHeader localReqHeader = new NeighborComm.ReqHeader();
        localReqHeader.shVersion = 2;
        localReqHeader.lMID = J(Long.parseLong(paramToServiceMsg.getUin()));
        localReqHeader.iAppID = AppSetting.getAppId();
        localReqHeader.eBusiType = 0;
        localReqHeader.eMqqSysType = 2;
        ReqUserInfo localReqUserInfo = new ReqUserInfo();
        localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
        localReqUserInfo.strAuthPassword = "NzVK_qGE";
        localReqUserInfo.eListType = 0;
        localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
        localReqUserInfo.stGps = new GPS((int)(((SosoInterface.SosoLbsInfo)localObject1).a.cf * 1000000.0D), (int)(((SosoInterface.SosoLbsInfo)localObject1).a.cg * 1000000.0D), -1, 0);
        localReqUserInfo.vSOSOCells = new ArrayList();
        Object localObject2;
        if (((SosoInterface.SosoLbsInfo)localObject1).mCells != null)
        {
          localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).mCells.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SosoInterface.SosoCell localSosoCell = (SosoInterface.SosoCell)((Iterator)localObject2).next();
            localReqUserInfo.vSOSOCells.add(new SOSO_Cell((short)localSosoCell.cAI, (short)localSosoCell.cAJ, localSosoCell.cAK, localSosoCell.cAL, (short)localSosoCell.cAM));
          }
        }
        localReqUserInfo.vSOSOMac = new ArrayList();
        if (((SosoInterface.SosoLbsInfo)localObject1).tZ != null)
        {
          localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).tZ.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
            localReqUserInfo.vSOSOMac.add(new SOSO_Wifi(((SosoInterface.SosoWifi)localObject2).RK, (short)((SosoInterface.SosoWifi)localObject2).mRssi));
          }
        }
        localObject1 = new ReqGetRecommender();
        ((ReqGetRecommender)localObject1).stUserInfo = localReqUserInfo;
        ((ReqGetRecommender)localObject1).eTimingType = paramToServiceMsg.extraData.getInt("timingType");
        paramUniPacket.setEncodeName("utf-8");
        paramUniPacket.setServantName("EncounterObj");
        paramUniPacket.setFuncName("CMD_GET_RECOMMENDER");
        paramUniPacket.put("ReqHeader", localReqHeader);
        paramUniPacket.put("ReqGetRecommender", localObject1);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSService", 2, "handleGetNearbyRecommender lbsinfo is null");
      }
      paramToServiceMsg.extraData.putBoolean("isLbsInfoNull", true);
      return false;
    }
  }
  
  private boolean U(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = 0;
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = J(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.getAppId();
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
  
  private boolean V(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = J(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.getAppId();
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
  
  private boolean W(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    long l = Long.parseLong(paramToServiceMsg.extraData.getString("friendUin"));
    byte b = paramToServiceMsg.extraData.getByte("bReqType");
    ((QQService.ReqHead)localObject).bReqType = b;
    localObject = new ReqHYMakeFriendsCard((QQService.ReqHead)localObject, l, b, paramToServiceMsg.extraData.getInt("uFaceTimeStamp"));
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqHYMakeFriendsCard");
    paramUniPacket.put("ReqHYMakeFriendsCard", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqHYMakeFriendsCard");
    return true;
  }
  
  private boolean X(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
  
  public static boolean Y(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SummaryCard.ReqHead localReqHead = new SummaryCard.ReqHead();
    localReqHead.iVersion = 2;
    paramUniPacket.setServantName("SummaryCardServantObj");
    paramUniPacket.setFuncName("ReqSummaryCard");
    paramUniPacket.put("ReqHead", localReqHead);
    paramUniPacket.put("ReqSummaryCard", a(paramToServiceMsg));
    paramToServiceMsg.setTimeout(30000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.ReqSummaryCard");
    return true;
  }
  
  private boolean Z(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    ReqSummaryCard localReqSummaryCard = new ReqSummaryCard(paramToServiceMsg.extraData.getLong("targetUin", 0L), paramToServiceMsg.extraData.getInt("comeFromType", 0), 0L, (byte)0, 0L, 0L, null, "", 0L, 0, null, null, null, null, null, 0L, 0L, null, (byte)0, paramToServiceMsg.extraData.getIntegerArrayList("req0x5ebFieldIdList"), (byte)0, (byte)0, (byte)0, null, 1L);
    SummaryCard.ReqHead localReqHead = new SummaryCard.ReqHead();
    localReqHead.iVersion = 2;
    paramUniPacket.setServantName("SummaryCardServantObj");
    paramUniPacket.setFuncName("ReqSummaryCard");
    paramUniPacket.put("ReqHead", localReqHead);
    paramUniPacket.put("ReqSummaryCard", localReqSummaryCard);
    paramToServiceMsg.setTimeout(30000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.ReqSummaryCard");
    return true;
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
  
  public static ReqSummaryCard a(ToServiceMsg paramToServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin", 0L);
    int k = paramToServiceMsg.extraData.getInt("comeFromType", 0);
    long l3 = paramToServiceMsg.extraData.getLong("qzoneFeedTimeStamp", 0L);
    byte b1 = paramToServiceMsg.extraData.getByte("isFriend");
    long l4 = paramToServiceMsg.extraData.getLong("troopCode", 0L);
    long l5 = paramToServiceMsg.extraData.getLong("troopUin", 0L);
    String str = paramToServiceMsg.extraData.getString("strSearchName");
    long l6 = paramToServiceMsg.extraData.getLong("lGetControl");
    int m = paramToServiceMsg.extraData.getInt("bReqCommLabel");
    int n = paramToServiceMsg.extraData.getInt("EAddFriendSource");
    long l7 = paramToServiceMsg.extraData.getLong("tinyId");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isNearbyPeopleCard");
    long l8 = paramToServiceMsg.extraData.getLong("likeSource");
    byte b2 = paramToServiceMsg.extraData.getByte("bReqExtendCard");
    Object localObject3 = paramToServiceMsg.extraData.getParcelableArrayList("busiList");
    if (localObject3 == null) {
      localObject3 = new ArrayList();
    }
    for (;;)
    {
      Object localObject2 = paramToServiceMsg.extraData.getByteArray("vSeed");
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new byte[1];
        localObject1[0] = 0;
      }
      Object localObject4 = paramToServiceMsg.extraData.getByteArray("vSecureSig");
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        localObject2 = new byte[1];
        localObject2[0] = 0;
      }
      byte b3 = paramToServiceMsg.extraData.getByte("bReqMedalWallInfo");
      ArrayList localArrayList = paramToServiceMsg.extraData.getIntegerArrayList("req0x5ebFieldIdList");
      localObject4 = new ReqLastGameInfo((byte)1, l2);
      Object localObject5 = new UniPacket(true);
      ((UniPacket)localObject5).setEncodeName("utf-8");
      ((UniPacket)localObject5).setFuncName("ReqLastGameInfo");
      ((UniPacket)localObject5).setServantName("QQService.GameSvc");
      ((UniPacket)localObject5).put("ReqLastGameInfo", localObject4);
      localObject5 = ((UniPacket)localObject5).encode();
      localObject4 = null;
      Object localObject6;
      if (!bool)
      {
        localObject4 = new SSummaryCardQueryReq(1, Long.parseLong(paramToServiceMsg.getUin()), l2, "3.4.4", k, 109L);
        localObject6 = new UniPacket(true);
        ((UniPacket)localObject6).setEncodeName("utf-8");
        ((UniPacket)localObject6).setFuncName("query");
        ((UniPacket)localObject6).setServantName("MCardSvc");
        ((UniPacket)localObject6).put("req", localObject4);
        localObject4 = ((UniPacket)localObject6).encode();
      }
      label1125:
      for (;;)
      {
        try
        {
          i = Integer.parseInt("3058");
          localObject6 = new ArrayList();
          if ((l2 > 0L) || (bool))
          {
            ((ArrayList)localObject3).add(new BusinessBuff(2, null));
            ((ArrayList)localObject3).add(new BusinessBuff(4, null));
            if (!bool)
            {
              if (l1 != l2) {
                continue;
              }
              if (l1 > 0L)
              {
                localObject7 = new GetUserAppListRequest(null, l1, 5L);
                if (localObject7 != null) {
                  ((ArrayList)localObject3).add(new BusinessBuff(17, ((GetUserAppListRequest)localObject7).getBusiBuf()));
                }
              }
            }
            localObject7 = new oidb_0xe5b.ReqBody();
            ((oidb_0xe5b.ReqBody)localObject7).uint64_uin.set(l2);
            ((oidb_0xe5b.ReqBody)localObject7).uint32_max_count.set(10);
            ((oidb_0xe5b.ReqBody)localObject7).bool_req_achievement_content.set(false);
            ((ArrayList)localObject3).add(new BusinessBuff(18, ((oidb_0xe5b.ReqBody)localObject7).toByteArray()));
            localObject3 = ((ArrayList)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject7 = (BusinessBuff)((Iterator)localObject3).next();
              Object localObject8 = new SummaryCardBusiEntry.comm();
              ((SummaryCardBusiEntry.comm)localObject8).ver.set(1);
              ((SummaryCardBusiEntry.comm)localObject8).seq.set(paramToServiceMsg.getAppSeq());
              ((SummaryCardBusiEntry.comm)localObject8).fromuin.set(l1);
              ((SummaryCardBusiEntry.comm)localObject8).touin.set(l2);
              ((SummaryCardBusiEntry.comm)localObject8).service.set(((BusinessBuff)localObject7).DX());
              ((SummaryCardBusiEntry.comm)localObject8).platform.set(2);
              ((SummaryCardBusiEntry.comm)localObject8).qqver.set("3.4.4.3058");
              ((SummaryCardBusiEntry.comm)localObject8).build.set(i);
              Object localObject9;
              if ((((BusinessBuff)localObject7).DX() == 17) || (((BusinessBuff)localObject7).DX() == 18))
              {
                ((SummaryCardBusiEntry.comm)localObject8).msg_login_sig.setHasFlag(true);
                ((SummaryCardBusiEntry.comm)localObject8).msg_login_sig.uint32_type.set(8);
                ((SummaryCardBusiEntry.comm)localObject8).msg_login_sig.uint32_appid.set(16);
                localObject9 = paramToServiceMsg.extraData.getString("msg_login_sig");
                if ((!TextUtils.isEmpty((CharSequence)localObject9)) && (!HexUtil.emptybytes.equals(localObject9))) {
                  ((SummaryCardBusiEntry.comm)localObject8).msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject9));
                }
              }
              else
              {
                localObject8 = ((SummaryCardBusiEntry.comm)localObject8).toByteArray();
                int i1 = localObject8.length;
                int j = 0;
                if (((BusinessBuff)localObject7).al() != null) {
                  j = ((BusinessBuff)localObject7).al().length;
                }
                localObject9 = new byte[i1 + 9 + j + 1];
                localObject9[0] = 40;
                aqoj.DWord2Byte((byte[])localObject9, 1, i1);
                aqoj.DWord2Byte((byte[])localObject9, 5, j);
                aqoj.b((byte[])localObject9, 9, (byte[])localObject8, i1);
                j = localObject8.length + 9;
                if (((BusinessBuff)localObject7).al() == null) {
                  break label1125;
                }
                aqoj.b((byte[])localObject9, j, ((BusinessBuff)localObject7).al(), ((BusinessBuff)localObject7).al().length);
                j = ((BusinessBuff)localObject7).al().length + j;
                localObject9[j] = 41;
                ((ArrayList)localObject6).add(localObject9);
                continue;
              }
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Object localObject7;
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.SummaryCard", 2, localNumberFormatException.toString());
          }
          int i = 0;
          continue;
          if (l2 > 0L)
          {
            localObject7 = new GetFriendPlayListV2Request(null, String.valueOf(l2), 1);
            if (localObject7 != null)
            {
              ((ArrayList)localObject3).add(new BusinessBuff(17, ((GetFriendPlayListV2Request)localObject7).getBusiBuf()));
              continue;
              QLog.d("LBSService", 1, "MiniAppSummaryCard buildReqSummaryCard SummaryCardBusiEntry.MINI_APP_SERVICE set A2 failed");
              continue;
              return new ReqSummaryCard(l2, k, l3, b1, l4, l5, (byte[])localObject1, str, l6, n, (byte[])localObject2, (byte[])localObject5, (byte[])localObject4, null, localNumberFormatException, l7, l8, null, b3, localArrayList, (byte)1, (byte)m, b2, null, 1L);
            }
          }
        }
      }
    }
  }
  
  private Object a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespSetStateSwitch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetStateSwitch", new RespSetStateSwitch());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private boolean aa(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("pttcenter_targetuin", 0L);
    int i = paramToServiceMsg.extraData.getInt("pttcenter_voice_optype");
    short s = paramToServiceMsg.extraData.getShort("pttcenter_shDuration");
    Object localObject = paramToServiceMsg.extraData.getString("pttcenter_filekey");
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "handleVoiceManager() destUin = " + l + ", eOpType = " + i + ", shDuration = " + s + ", filekey = " + (String)localObject);
    }
    localObject = new ReqVoiceManage(i, new VoiceInfo(aqep.ae((String)localObject), s, (byte)0, null), l);
    SummaryCard.ReqHead localReqHead = new SummaryCard.ReqHead();
    localReqHead.iVersion = 2;
    paramUniPacket.setServantName("SummaryCardServantObj");
    paramUniPacket.setFuncName("ReqVoiceManage");
    paramUniPacket.put("ReqHead", localReqHead);
    paramUniPacket.put("ReqVoiceManage", localObject);
    paramToServiceMsg.setTimeout(30000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.ReqVoiceManage");
    return true;
  }
  
  private boolean ab(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject3 = null;
    QQService.ReqHead localReqHead = new QQService.ReqHead();
    localReqHead.shVersion = 2;
    localReqHead.iSeq = paramUniPacket.getRequestId();
    localReqHead.lUIN = Long.parseLong(paramToServiceMsg.getUin());
    int i = paramToServiceMsg.extraData.getInt("eSubCmd");
    byte b = paramToServiceMsg.extraData.getByte("bIsSingle");
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
          localObject1 = new ReqSetCard(localReqHead, i, b, (ArrayList)localObject1, arrayOfByte1, localArrayList1, localArrayList2, arrayOfByte2);
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
  
  private boolean ac(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SSummaryCardSetLabel localSSummaryCardSetLabel;
    try
    {
      Object localObject = (List)paramToServiceMsg.extraData.getSerializable("labels");
      if (localObject != null)
      {
        localSSummaryCardSetLabel = new SSummaryCardSetLabel();
        localSSummaryCardSetLabel.cmd = 4;
        localSSummaryCardSetLabel.uin = Long.parseLong(this.app.getCurrentAccountUin());
        localSSummaryCardSetLabel.version = "3.4.4";
        localSSummaryCardSetLabel.platform = 109L;
        localSSummaryCardSetLabel.labels = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localSSummaryCardSetLabel.labels.add(((Iterator)localObject).next());
        }
      }
      return false;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    paramUniPacket.setServantName("SummaryCard");
    paramUniPacket.setFuncName("SetLabel");
    paramUniPacket.put("SSummaryCardSetLabel", localSSummaryCardSetLabel);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.SetLabel");
    return true;
  }
  
  private boolean ad(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    try
    {
      SSummaryCardLikeIt localSSummaryCardLikeIt = new SSummaryCardLikeIt();
      localSSummaryCardLikeIt.cmd = 3;
      localSSummaryCardLikeIt.uin = paramToServiceMsg.extraData.getLong("selfUin");
      localSSummaryCardLikeIt.likeuin = paramToServiceMsg.extraData.getLong("destUin");
      localSSummaryCardLikeIt.label = paramToServiceMsg.extraData.getLong("labelId");
      localSSummaryCardLikeIt.platform = 109L;
      localSSummaryCardLikeIt.version = "3.4.4";
      paramUniPacket.setServantName("SummaryCard");
      paramUniPacket.setFuncName("LikeIt");
      paramUniPacket.put("SSummaryCardLikeIt", localSSummaryCardLikeIt);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.LikeIt");
      return true;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return false;
  }
  
  private boolean ae(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
  
  private boolean af(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
  
  private boolean ag(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
  
  private boolean ah(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    int i = paramToServiceMsg.extraData.getInt("type");
    ReqDeleteVisitorRecord localReqDeleteVisitorRecord = new ReqDeleteVisitorRecord(new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null), l2, i);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqDeleteVisitorRecord");
    paramUniPacket.put("ReqDeleteVisitorRecord", localReqDeleteVisitorRecord);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqDeleteVisitorRecord");
    return true;
  }
  
  private boolean ai(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
  
  private boolean aj(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("nextMid");
    int i = paramToServiceMsg.extraData.getInt("pageSize");
    Object localObject = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null);
    UserCntlData localUserCntlData = new UserCntlData(l2, new byte[0]);
    if (i < 54) {}
    for (;;)
    {
      localObject = new ReqGetFavoriteList((QQService.ReqHead)localObject, localUserCntlData, i);
      paramUniPacket.setServantName("VisitorSvc");
      paramUniPacket.setFuncName("ReqGetFavoriteList");
      paramUniPacket.put("ReqGetFavoriteList", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("VisitorSvc.ReqGetFavoriteList");
      return true;
      i = 30;
    }
  }
  
  private boolean ak(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
  
  private boolean al(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("param_keyword");
    String str = paramToServiceMsg.extraData.getString("param_country_code");
    double d1 = paramToServiceMsg.extraData.getDouble("search_longtitude");
    double d2 = paramToServiceMsg.extraData.getDouble("search_latitude");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("search_list");
    int n = paramToServiceMsg.extraData.getInt("search_page");
    int i1 = paramToServiceMsg.extraData.getInt("search_version");
    int i2 = paramToServiceMsg.extraData.getInt("filter_type", 0);
    Object localObject1 = null;
    if (i1 == 2) {}
    label720:
    for (;;)
    {
      localObject1 = new ReqSearch((String)localObject2, str, i1, (ArrayList)localObject1);
      localObject2 = new SummaryCard.ReqHead();
      ((SummaryCard.ReqHead)localObject2).iVersion = 2;
      paramUniPacket.setServantName("SummaryCardServantObj");
      paramUniPacket.setFuncName("ReqSearch");
      paramUniPacket.put("ReqHead", localObject2);
      paramUniPacket.put("ReqSearch", localObject1);
      paramToServiceMsg.setTimeout(30000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.ReqSearch");
      return true;
      if (i1 == 3)
      {
        localObject1 = new ArrayList();
        try
        {
          i = Integer.parseInt("3058");
          int i3 = arrayOfInt.length;
          j = 0;
          for (;;)
          {
            if (j >= i3) {
              break label720;
            }
            Object localObject3 = new SummaryCardBusiEntry.comm();
            ((SummaryCardBusiEntry.comm)localObject3).ver.set(1);
            ((SummaryCardBusiEntry.comm)localObject3).seq.set(paramToServiceMsg.getAppSeq());
            ((SummaryCardBusiEntry.comm)localObject3).service.set(arrayOfInt[j]);
            if (arrayOfInt[j] == 80000004)
            {
              ((SummaryCardBusiEntry.comm)localObject3).msg_login_sig.setHasFlag(true);
              ((SummaryCardBusiEntry.comm)localObject3).msg_login_sig.uint32_type.set(64);
              localObject4 = (TicketManager)this.app.getManager(2);
              if (localObject4 != null)
              {
                localObject4 = ((TicketManager)localObject4).getA2(this.app.getCurrentAccountUin());
                if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!HexUtil.emptybytes.equals(localObject4))) {
                  ((SummaryCardBusiEntry.comm)localObject3).msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject4));
                }
              }
            }
            ((SummaryCardBusiEntry.comm)localObject3).platform.set(2);
            ((SummaryCardBusiEntry.comm)localObject3).qqver.set("3.4.4.3058");
            ((SummaryCardBusiEntry.comm)localObject3).build.set(i);
            localObject3 = ((SummaryCardBusiEntry.comm)localObject3).toByteArray();
            int k = localObject3.length;
            localObject4 = new AccountSearchPb.search();
            ((AccountSearchPb.search)localObject4).start.set(n);
            if (arrayOfInt[j] != 80000001) {
              break;
            }
            ((AccountSearchPb.search)localObject4).count.set(4);
            ((AccountSearchPb.search)localObject4).keyword.set((String)localObject2);
            ((AccountSearchPb.search)localObject4).highlight.add(localObject2);
            Object localObject5 = new AccountSearchPb.Location();
            ((AccountSearchPb.Location)localObject5).double_longitude.set(d1);
            ((AccountSearchPb.Location)localObject5).double_latitude.set(d2);
            ((AccountSearchPb.search)localObject4).msg_user_location.set((MessageMicro)localObject5);
            ((AccountSearchPb.search)localObject4).filtertype.set(i2);
            if (QLog.isDevelopLevel()) {
              QLog.d("LBSService", 4, "request has set filtertype " + i2);
            }
            localObject4 = ((AccountSearchPb.search)localObject4).toByteArray();
            int i4 = localObject4.length;
            localObject5 = new byte[k + 9 + i4 + 1];
            localObject5[0] = 40;
            aqoj.DWord2Byte((byte[])localObject5, 1, k);
            aqoj.DWord2Byte((byte[])localObject5, 5, i4);
            aqoj.b((byte[])localObject5, 9, (byte[])localObject3, k);
            int m = localObject3.length + 9;
            k = m;
            if (localObject4 != null)
            {
              aqoj.b((byte[])localObject5, m, (byte[])localObject4, i4);
              k = m + i4;
            }
            localObject5[k] = 41;
            ((ArrayList)localObject1).add(localObject5);
            j += 1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int j;
            Object localObject4;
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.SummaryCard", 2, localNumberFormatException.toString());
            }
            int i = 0;
            continue;
            if (arrayOfInt[j] == 80000003) {
              ((AccountSearchPb.search)localObject4).count.set(8);
            }
          }
        }
      }
    }
  }
  
  public static ArrayList<yow> am(ArrayList<byte[]> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(6);
    int k = paramArrayList.size();
    int i = 0;
    label53:
    label73:
    int n;
    Object localObject2;
    SummaryCardBusiEntry.comm localcomm;
    if (i < k)
    {
      Object localObject1 = (byte[])paramArrayList.get(i);
      if (localObject1 == null)
      {
        j = 0;
        if (j > 10) {
          break label73;
        }
      }
      label509:
      do
      {
        int m;
        do
        {
          i += 1;
          break;
          j = localObject1.length;
          break label53;
          n = (int)aqoj.getLongData((byte[])localObject1, 1);
          m = (int)aqoj.getLongData((byte[])localObject1, 5);
        } while ((n <= 0) || (n + 9 >= j));
        localObject2 = new byte[n];
        aqoj.copyData((byte[])localObject2, 0, (byte[])localObject1, 9, n);
        j = n + 9;
        localcomm = new SummaryCardBusiEntry.comm();
        for (;;)
        {
          try
          {
            localcomm.mergeFrom((byte[])localObject2);
            n = localcomm.result.get();
            if (n != 0) {
              break label556;
            }
            n = localcomm.service.get();
            localObject2 = new byte[m];
            aqoj.copyData((byte[])localObject2, 0, (byte[])localObject1, j, m);
            localObject1 = new AccountSearchPb.search();
            ((AccountSearchPb.search)localObject1).mergeFrom((byte[])localObject2);
            localObject2 = new yow();
            ((yow)localObject2).resultType = n;
            ((yow)localObject2).cak = ((AccountSearchPb.search)localObject1).start.get();
            if (((AccountSearchPb.search)localObject1).end.get() != 1) {
              break label509;
            }
            bool = true;
            ((yow)localObject2).bnV = bool;
            ((yow)localObject2).sS = ((AccountSearchPb.search)localObject1).list.get();
            ((yow)localObject2).sR = ((AccountSearchPb.search)localObject1).highlight.get();
            ((yow)localObject2).aZp = ((AccountSearchPb.search)localObject1).article_more_url.get();
            ((yow)localObject2).b = ((AccountSearchPb.hotwordrecord)((AccountSearchPb.search)localObject1).hotword_record.get());
            ((yow)localObject2).sT = ((AccountSearchPb.search)localObject1).result_items.get();
            ((yow)localObject2).bnW = ((AccountSearchPb.search)localObject1).bool_keyword_suicide.get();
            ((yow)localObject2).bnU = ((AccountSearchPb.search)localObject1).bool_exact_search.get();
            if (((((yow)localObject2).sS == null) || (((yow)localObject2).sS.size() <= 0)) && ((((yow)localObject2).sT == null) || (((yow)localObject2).sT.size() <= 0)) && (!((yow)localObject2).bnW)) {
              break;
            }
            localArrayList.add(localObject2);
            if (n != 80000000) {
              break label515;
            }
            localObject1 = ((AccountSearchPb.search)localObject1).list.get().iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (AccountSearchPb.record)((Iterator)localObject1).next();
            if (((AccountSearchPb.record)localObject2).sign.get() == null) {
              continue;
            }
            ((AccountSearchPb.record)localObject2).richStatus = RichStatus.parseStatus(((AccountSearchPb.record)localObject2).sign.get().toByteArray());
            continue;
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (Exception localException) {}
          QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
          break;
          boolean bool = false;
        }
      } while ((n != 80000001) || (!localException.bool_location_group.has()));
      label515:
      if (!localException.bool_location_group.get()) {
        break label630;
      }
    }
    label556:
    label630:
    for (int j = 1;; j = 2)
    {
      ((yow)localObject2).mExtraFlag = j;
      break;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.profilecard.SummaryCard", 4, "busi entry, [" + localcomm.service.get() + "," + n + "," + localcomm.err_msg.get());
      break;
      return localArrayList;
    }
  }
  
  private boolean am(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("param_page");
    long l = paramToServiceMsg.extraData.getLong("param_session_id");
    Object localObject1 = paramToServiceMsg.extraData.getString("param_keyword");
    int j = paramToServiceMsg.extraData.getInt("param_sex_index");
    int k = paramToServiceMsg.extraData.getInt("param_age_index1");
    int m = paramToServiceMsg.extraData.getInt("param_age_index2");
    int n = paramToServiceMsg.extraData.getInt("param_job_index");
    int i1 = paramToServiceMsg.extraData.getInt("param_xingzuo_index");
    Object localObject3 = paramToServiceMsg.extraData.getStringArray("param_loc_code");
    Object localObject2 = paramToServiceMsg.extraData.getStringArray("param_home_code");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(16);
    if ((localObject3 != null) && (localObject3.length == 4))
    {
      localByteBuffer.putInt(accv.cm(localObject3[0]));
      localByteBuffer.putInt(accv.cm(localObject3[1]));
      localByteBuffer.putInt(accv.cm(localObject3[2]));
      localByteBuffer.putInt(accv.cm(localObject3[3]));
      localObject3 = ByteBuffer.allocate(16);
      if ((localObject2 == null) || (localObject2.length != 4)) {
        break label484;
      }
      ((ByteBuffer)localObject3).putInt(accv.cm(localObject2[0]));
      ((ByteBuffer)localObject3).putInt(accv.cm(localObject2[1]));
      ((ByteBuffer)localObject3).putInt(accv.cm(localObject2[2]));
      ((ByteBuffer)localObject3).putInt(accv.cm(localObject2[3]));
    }
    for (;;)
    {
      short s2 = (short)k;
      short s3 = (short)m;
      short s1 = s2;
      if (s2 < 0) {
        s1 = 0;
      }
      s2 = s3;
      if (s1 > s3)
      {
        s3 = 32767;
        s2 = s3;
        if (QLog.isColorLevel())
        {
          QLog.i("LBSService", 2, String.format("handleCondSearchFriend [%s, %s]--[%s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Short.valueOf(s1), Short.valueOf(32767) }));
          s2 = s3;
        }
      }
      localObject1 = new ReqCondSearch(i, l, 1L, (String)localObject1, (byte)j, localByteBuffer.array(), (short)255, ((ByteBuffer)localObject3).array(), (byte)i1, n, s1, s2);
      localObject2 = new SummaryCard.ReqHead();
      ((SummaryCard.ReqHead)localObject2).iVersion = 2;
      paramUniPacket.setServantName("SummaryCardServantObj");
      paramUniPacket.setFuncName("ReqCondSearch");
      paramUniPacket.put("ReqHead", localObject2);
      paramUniPacket.put("ReqCondSearch", localObject1);
      paramToServiceMsg.setTimeout(15000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.ReqCondSearch");
      return true;
      localByteBuffer.putInt(0).putInt(0).putInt(0).putInt(0);
      break;
      label484:
      ((ByteBuffer)localObject3).putInt(0).putInt(0).putInt(0).putInt(0);
    }
  }
  
  private Object b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespGetSwitches)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetSwitches", new RespGetSwitches());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private Object c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.eReplyCode == 0)) {
      this.fr = paramFromServiceMsg.vContext;
    }
    return paramFromServiceMsg;
  }
  
  private Object d(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetVoterList)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetVoterList", new RespGetVoterList());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  private void e(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetFavoriteList)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetFavoriteList", new RespGetFavoriteList());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  private Object f(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespFaceInfo)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespFaceInfo", new RespFaceInfo());
  }
  
  private void f(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespDeleteVisitorRecord)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespDeleteVisitorRecord", new RespDeleteVisitorRecord());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  private Object g(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    if ((paramToServiceMsg != null) && (paramToServiceMsg.eReplyCode == 0))
    {
      paramFromServiceMsg = (RespGetRecommender)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetRecommender", new RespGetRecommender());
      return new Object[] { paramToServiceMsg, paramFromServiceMsg };
    }
    if (QLog.isColorLevel()) {
      if (paramToServiceMsg != null) {
        break label94;
      }
    }
    label94:
    for (paramFromServiceMsg = "decodeNearbyRecommender respHeader is null";; paramFromServiceMsg = String.valueOf(paramToServiceMsg.eReplyCode))
    {
      QLog.i("LBS", 2, paramFromServiceMsg);
      paramFromServiceMsg = null;
      break;
    }
  }
  
  private Object h(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespHYMakeFriendsCard)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHYMakeFriendsCard", new RespHYMakeFriendsCard());
  }
  
  private Object i(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespUpdateIntro)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespUpdateIntro", new RespUpdateIntro());
  }
  
  private Object j(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSummaryCard)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSummaryCard", new RespSummaryCard());
  }
  
  private Object k(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespVoiceManage)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespVoiceManage", new RespVoiceManage());
  }
  
  private Object l(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespSearch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSearch", new RespSearch());
    int i = paramToServiceMsg.extraData.getInt("search_version");
    if (i == 2) {}
    while (i != 3) {
      return paramFromServiceMsg;
    }
    boolean bool = paramToServiceMsg.extraData.getBoolean("search_decode");
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "decodeSearchFriend | needDecode = " + bool);
    }
    if (bool) {
      return am(paramFromServiceMsg.vvRespServices);
    }
    return paramFromServiceMsg.vvRespServices;
  }
  
  private Object m(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespCondSearch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespCondSearch", new RespCondSearch());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.vUserList != null) && (!paramFromServiceMsg.vUserList.isEmpty()))
    {
      int i = 0;
      while (i < paramFromServiceMsg.vUserList.size())
      {
        paramToServiceMsg = (CondFitUser)paramFromServiceMsg.vUserList.get(i);
        if (paramToServiceMsg.vRichSign != null) {
          paramToServiceMsg.richStatus = RichStatus.parseStatus(paramToServiceMsg.vRichSign);
        }
        String str1 = accv.bi(paramToServiceMsg.dwCountry);
        String str2 = accv.bi(paramToServiceMsg.dwProvince);
        String str3 = accv.bi(paramToServiceMsg.dwCity);
        paramToServiceMsg.locDesc = ((accv)this.app.getManager(59)).e(new String[] { str1, str2, str3, "0" });
        i += 1;
      }
    }
    return paramFromServiceMsg;
  }
  
  private Object n(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSetCard)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetCard", new RespSetCard());
  }
  
  private Object o(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (SSummaryCardLableRsp)decodePacket(paramFromServiceMsg.getWupBuffer(), "SSummaryCardLableRsp", new SSummaryCardLableRsp());
  }
  
  private Object p(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (SSummaryCardLableRsp)decodePacket(paramFromServiceMsg.getWupBuffer(), "SSummaryCardLableRsp", new SSummaryCardLableRsp());
  }
  
  private Object q(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSetCardSwitch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetCardSwitch", new RespSetCardSwitch());
  }
  
  private Object r(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespGetCardSwitch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetCardSwitch", new RespGetCardSwitch());
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("MCardSvc.ReqFaceInfo".equals(paramFromServiceMsg.getServiceCmd())) {
      return f(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqHYMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return h(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqAddFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return (RespAddFace)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespAddFace", new RespAddFace());
    }
    if ("MCardSvc.ReqDelFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return (RespDelFace)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespDelFace", new RespDelFace());
    }
    if ("MCardSvc.ReqUpdateIntro".equals(paramFromServiceMsg.getServiceCmd())) {
      return i(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return n(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.SetLabel".equals(paramFromServiceMsg.getServiceCmd())) {
      return o(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.LikeIt".equals(paramFromServiceMsg.getServiceCmd())) {
      return p(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqGetCardSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return r(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqSetCardSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return q(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqGetFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return e(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return j(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqVoiceManage".equals(paramFromServiceMsg.getServiceCmd())) {
      return k(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.GetGroupList".equals(paramFromServiceMsg.getServiceCmd())) {
      return c(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.ReqGetAreaList".equals(paramFromServiceMsg.getServiceCmd())) {
      return d(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqSetStateSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return a(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqGetSwitches".equals(paramFromServiceMsg.getServiceCmd())) {
      return b(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd())) {
      return acic.a(this, paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return l(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return m(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd())) {
      return g(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd())) {
      return acic.a(this.app, paramFromServiceMsg, paramToServiceMsg, this);
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    boolean bool = false;
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqHYMakeFriendsCard")) {
      bool = W(paramToServiceMsg, paramUniPacket);
    }
    do
    {
      return bool;
      if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqAddFace")) {
        return N(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqDelFace")) {
        return O(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqFaceInfo")) {
        return P(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqUpdateIntro")) {
        return X(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCard")) {
        return ab(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("SummaryCard.SetLabel")) {
        return ac(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("SummaryCard.LikeIt")) {
        return ad(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqGetCardSwitch")) {
        return ae(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCardSwitch")) {
        return af(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqVote")) {
        return ag(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetVoterList")) {
        return ai(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetFavoriteList")) {
        return aj(paramToServiceMsg, paramUniPacket);
      }
      if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqDeleteVisitorRecord")) {
        return ah(paramToServiceMsg, paramUniPacket);
      }
      if ("MCardSvc.ReqPicSafetyCheck".equals(paramToServiceMsg.getServiceCmd())) {
        return ak(paramToServiceMsg, paramUniPacket);
      }
      if ("MCardSvc.ReqGetFace".equals(paramToServiceMsg.getServiceCmd())) {
        return Q(paramToServiceMsg, paramUniPacket);
      }
      if ("SummaryCard.ReqSummaryCard".equals(paramToServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("simpleinfo_pull", false)) {
          return Z(paramToServiceMsg, paramUniPacket);
        }
        return Y(paramToServiceMsg, paramUniPacket);
      }
      if ("SummaryCard.ReqVoiceManage".equals(paramToServiceMsg.getServiceCmd())) {
        return aa(paramToServiceMsg, paramUniPacket);
      }
      if ("VisitorSvc.ReqFavorite".equals(paramToServiceMsg.getServiceCmd())) {
        return acic.b(paramToServiceMsg, paramUniPacket);
      }
      if ("NearbyGroup.GetGroupList".equals(paramToServiceMsg.getServiceCmd())) {
        return S(paramToServiceMsg, paramUniPacket);
      }
      if ("NearbyGroup.ReqGetAreaList".equals(paramToServiceMsg.getServiceCmd())) {
        return R(paramToServiceMsg, paramUniPacket);
      }
      if ("NeighborSvc.ReqSetStateSwitch".equals(paramToServiceMsg.getServiceCmd())) {
        return U(paramToServiceMsg, paramUniPacket);
      }
      if ("NeighborSvc.ReqGetSwitches".equals(paramToServiceMsg.getServiceCmd())) {
        return V(paramToServiceMsg, paramUniPacket);
      }
      if ("NeighborSvc.ReqGetPoint".equals(paramToServiceMsg.getServiceCmd())) {
        return acic.a(this, paramToServiceMsg, paramUniPacket);
      }
      if ("SummaryCard.ReqSearch".equals(paramToServiceMsg.getServiceCmd())) {
        return al(paramToServiceMsg, paramUniPacket);
      }
      if ("SummaryCard.ReqCondSearch".equals(paramToServiceMsg.getServiceCmd())) {
        return am(paramToServiceMsg, paramUniPacket);
      }
      if ("NeighborRecommender.ReqGetRecommender".equals(paramToServiceMsg.getServiceCmd())) {
        return T(paramToServiceMsg, paramUniPacket);
      }
    } while (!"EncounterSvc.ReqGetEncounter".equals(paramToServiceMsg.getServiceCmd()));
    return acic.a(this.app, paramToServiceMsg, paramUniPacket, this);
  }
  
  public void c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespVote)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespVote", new RespVote());
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
  
  public Object e(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespGetFace)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetFace", new RespGetFace());
  }
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("VisitorSvc.ReqVote".equals(paramFromServiceMsg.getServiceCmd())) {
      c(paramFromServiceMsg, paramToServiceMsg);
    }
    do
    {
      do
      {
        return;
        if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
        {
          d(paramFromServiceMsg, paramToServiceMsg);
          return;
        }
        if ("VisitorSvc.ReqGetFavoriteList".equals(paramFromServiceMsg.getServiceCmd()))
        {
          e(paramFromServiceMsg, paramToServiceMsg);
          return;
        }
      } while ("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd()));
      if ("VisitorSvc.ReqDeleteVisitorRecord".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramFromServiceMsg, paramToServiceMsg);
        return;
      }
      if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
      {
        acic.b(paramFromServiceMsg, paramToServiceMsg);
        return;
      }
    } while (!"NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd()));
  }
  
  public String[] y()
  {
    return gu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anau
 * JD-Core Version:    0.7.0.1
 */