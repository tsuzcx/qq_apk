import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import GeneralSettings.ReqGetSettings;
import GeneralSettings.ReqHeader;
import GeneralSettings.ReqSetSettings;
import GeneralSettings.RespGetSettings;
import GeneralSettings.RespHeader;
import GeneralSettings.RespSetSettings;
import KQQ.ChangeFriendNameReq;
import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateReq;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigReq;
import KQQ.GetRichSigRes;
import KQQ.GroupMngReq;
import KQQ.ProfFullUsrQryReq;
import KQQ.ProfGroupInfoReq;
import KQQ.ProfGroupInfoRes;
import KQQ.ProfIncInfoReq;
import KQQ.ProfSmpInfoRes;
import KQQ.ProfUsrFullInfoRes;
import KQQ.ProfUsrQryReq;
import KQQ.ProfVipqqInfoReq;
import KQQ.ProfVipqqInfoRes;
import KQQ.ReqItem;
import KQQ.ReqRichInfo;
import KQQ.SetRichSigReq;
import KQQ.SetRichSigRes;
import KQQ.SetUserInfoReq;
import KQQ.SetUserInfoResp;
import KQQ.SyncRes;
import KQQ.WeatherInfoReq;
import QQService.SvcReqBindUin;
import QQService.SvcReqDelLoginInfo;
import QQService.SvcReqGetDevLoginInfo;
import QQService.SvcReqKikOut;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import ResPackage.ReqResOrder;
import ResPackage.ReqResUpdate;
import ResPackage.RspResOrder;
import ResPackage.RspResUpdate;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class andj
  extends swr
{
  private static final String[] gu = { "ProfileService", "StatSvc", "AvatarInfoSvr", "NickQuerySvc", "GetAvatarInfo", "ChatAvatar" };
  private amzr jdField_a_of_type_Amzr;
  private andx jdField_a_of_type_Andx;
  private final AppInterface app;
  private int dEZ;
  
  public andj(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
    this.gh.put("ProfileService.GetWeatherInfo", Integer.valueOf(1));
    this.gh.put("ProfileService.GetSimpleInfo", Integer.valueOf(2));
    this.gh.put("ProfileService.GetRichSig", Integer.valueOf(3));
    this.gh.put("ProfileService.ReqGetSettings", Integer.valueOf(4));
    this.gh.put("ProfileService.ReqSetSettings", Integer.valueOf(5));
    this.gh.put("ProfileService.SetRichSig", Integer.valueOf(7));
    this.gh.put("ProfileService.ChangeFriendName", Integer.valueOf(8));
    this.gh.put("ProfileService.GetSglUsrFullInfo", Integer.valueOf(9));
    this.gh.put("ProfileService.SetUserInfoReq", Integer.valueOf(10));
    this.gh.put("ProfileService.GetProfIncInfo", Integer.valueOf(11));
    this.gh.put("ProfileService.ProfVipqqInfo", Integer.valueOf(12));
    this.gh.put("AvatarInfoSvr.QQHeadUrlReq", Integer.valueOf(13));
    this.gh.put("ProfileService.getGroupInfoReq", Integer.valueOf(15));
    this.gh.put("ProfileService.GroupMngReq", Integer.valueOf(17));
    this.gh.put("ProfileService.CheckUpdateReq", Integer.valueOf(23));
    this.gh.put("ChatAvatar.ReqResOrder", Integer.valueOf(24));
    this.gh.put("ChatAvatar.ReqResUpdate", Integer.valueOf(25));
    this.gh.put("StatSvc.GetDevLoginInfo", Integer.valueOf(26));
    this.gh.put("StatSvc.DelDevLoginInfo", Integer.valueOf(27));
    this.gh.put("StatSvc.SvcReqKikOut", Integer.valueOf(28));
    this.gh.put("StatSvc.BindUin", Integer.valueOf(29));
    this.gh.put("ProfileService.ReqBatchProcess", Integer.valueOf(30));
    this.gh.put("StatSvc.SetStatusFromClient", Integer.valueOf(31));
    this.jdField_a_of_type_Andx = new andx(paramAppInterface);
    this.jdField_a_of_type_Amzr = new amzr(paramAppInterface);
  }
  
  private void T(ToServiceMsg paramToServiceMsg) {}
  
  private boolean a(ToServiceMsg paramToServiceMsg, ArrayList<Long> paramArrayList, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetSimpleInfo");
    int i;
    int j;
    if (paramToServiceMsg.extraData.getBoolean("reqSelfLevel", false))
    {
      i = 1;
      if (!paramToServiceMsg.extraData.getBoolean("reqXMan", false)) {
        break label106;
      }
      j = 1;
      label44:
      if (!paramToServiceMsg.extraData.getBoolean("reqDateNick", false)) {
        break label112;
      }
    }
    label106:
    label112:
    for (byte b = 1;; b = 0)
    {
      paramUniPacket.put("req", new ProfUsrQryReq(0, "", paramArrayList, 1, 1, (byte)0, i, j, (byte)1, b, (byte)1, paramToServiceMsg.extraData.getInt("getXManInfoScene", 1)));
      return true;
      i = 0;
      break;
      j = 0;
      break label44;
    }
  }
  
  private boolean a(String paramString, UniPacket paramUniPacket)
  {
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetWeatherInfo");
    int i = this.dEZ;
    this.dEZ = (i + 1);
    paramUniPacket.put("req", new WeatherInfoReq(i, "", paramString));
    return true;
  }
  
  private boolean aG(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.ChatAvatarServer.ChatAvatarObj");
    paramUniPacket.setFuncName("ReqResUpdate");
    ReqResUpdate localReqResUpdate = new ReqResUpdate();
    localReqResUpdate.SeqID = paramToServiceMsg.extraData.getInt("seq_id", 0);
    localReqResUpdate.ResID = paramToServiceMsg.extraData.getInt("ResID", 2);
    paramUniPacket.put("ReqResUpdate", localReqResUpdate);
    return true;
  }
  
  private boolean aH(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.ChatAvatarServer.ChatAvatarObj");
    paramUniPacket.setFuncName("ReqResOrder");
    ReqResOrder localReqResOrder = new ReqResOrder();
    localReqResOrder.ResID = 1;
    localReqResOrder.Path = Integer.toString(paramToServiceMsg.extraData.getInt("req_res_order_pkgid", 0));
    paramUniPacket.put("ReqResOrder", localReqResOrder);
    return true;
  }
  
  private boolean aI(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateReq called");
    }
    CheckUpdateReq localCheckUpdateReq = new CheckUpdateReq();
    localCheckUpdateReq.isSupportSubPack = true;
    localCheckUpdateReq.vecReqPkg = new ArrayList();
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isFirstTime", Boolean.valueOf(true))).booleanValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("CheckUpdateType", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, String.format("handleCheckUpdateReq isFirstTime:%s, type:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
    }
    if (bool)
    {
      paramToServiceMsg = ((QQAppInterface)this.app).a.E().entrySet().iterator();
      while (paramToServiceMsg.hasNext())
      {
        Object localObject = (Map.Entry)paramToServiceMsg.next();
        Integer localInteger = (Integer)((Map.Entry)localObject).getKey();
        localObject = (andh)((Map.Entry)localObject).getValue();
        if ((((andh)localObject).mT() & i) != 0)
        {
          localObject = ((andh)localObject).a(i);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateReq item:eServiceId=" + ((ReqItem)localObject).eServiceID + ",cOperType=" + ((ReqItem)localObject).cOperType);
            }
            localCheckUpdateReq.vecReqPkg.add(localObject);
          }
        }
      }
    }
    paramToServiceMsg = (andh)((QQAppInterface)this.app).a.E().get(Integer.valueOf(101));
    if ((paramToServiceMsg.mT() & i) != 0)
    {
      paramToServiceMsg = paramToServiceMsg.a(i);
      if (paramToServiceMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateReq item:eServiceId=" + paramToServiceMsg.eServiceID + ",cOperType=" + paramToServiceMsg.cOperType);
        }
        localCheckUpdateReq.vecReqPkg.add(paramToServiceMsg);
      }
    }
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("CheckUpdateReq");
    paramUniPacket.put("CheckUpdateReq", localCheckUpdateReq);
    return true;
  }
  
  private boolean aJ(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqGetDevLoginInfo");
    SvcReqGetDevLoginInfo localSvcReqGetDevLoginInfo = new SvcReqGetDevLoginInfo();
    localSvcReqGetDevLoginInfo.iLoginType = paramToServiceMsg.extraData.getLong("iLoginType");
    localSvcReqGetDevLoginInfo.iNextItemIndex = paramToServiceMsg.extraData.getLong("iNextItemIndex");
    localSvcReqGetDevLoginInfo.iRequireMax = paramToServiceMsg.extraData.getLong("iRequireMax");
    localSvcReqGetDevLoginInfo.iTimeStamp = paramToServiceMsg.extraData.getLong("iTimeStamp");
    localSvcReqGetDevLoginInfo.strAppName = paramToServiceMsg.extraData.getString("strAppName");
    localSvcReqGetDevLoginInfo.vecGuid = paramToServiceMsg.extraData.getByteArray("vecGuid");
    localSvcReqGetDevLoginInfo.iGetDevListType = paramToServiceMsg.extraData.getLong("iGetDevListType");
    paramUniPacket.put("SvcReqGetDevLoginInfo", localSvcReqGetDevLoginInfo);
    return true;
  }
  
  private boolean aK(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqDelLoginInfo");
    SvcReqDelLoginInfo localSvcReqDelLoginInfo = new SvcReqDelLoginInfo();
    localSvcReqDelLoginInfo.strAppName = paramToServiceMsg.extraData.getString("strAppName");
    localSvcReqDelLoginInfo.vecDeviceItemDes = ((ArrayList)paramToServiceMsg.getAttribute("vecDeviceItemDes"));
    paramToServiceMsg.addAttribute("vecDeviceItemDes", null);
    localSvcReqDelLoginInfo.vecGuid = paramToServiceMsg.extraData.getByteArray("vecGuid");
    localSvcReqDelLoginInfo.iDelType = paramToServiceMsg.extraData.getInt("iDelType");
    localSvcReqDelLoginInfo.iDelMe = paramToServiceMsg.extraData.getInt("iDelMe");
    localSvcReqDelLoginInfo.iAppId = paramToServiceMsg.extraData.getLong("iAppId");
    paramUniPacket.put("SvcReqDelLoginInfo", localSvcReqDelLoginInfo);
    return true;
  }
  
  private boolean aL(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqKikOut");
    SvcReqKikOut localSvcReqKikOut = new SvcReqKikOut();
    localSvcReqKikOut.appid = paramToServiceMsg.extraData.getLong("appid");
    localSvcReqKikOut.cKeyType = paramToServiceMsg.extraData.getByte("cKeyType");
    localSvcReqKikOut.lUin = paramToServiceMsg.extraData.getLong("lUin");
    localSvcReqKikOut.sKey = paramToServiceMsg.extraData.getByteArray("sKey");
    paramUniPacket.put("req", localSvcReqKikOut);
    return true;
  }
  
  private boolean aM(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqBindUin");
    SvcReqBindUin localSvcReqBindUin = new SvcReqBindUin();
    localSvcReqBindUin.cCmd = paramToServiceMsg.extraData.getByte("cCmd");
    localSvcReqBindUin.vecBindUin = ((ArrayList)paramToServiceMsg.getAttribute("vecBindUin"));
    paramToServiceMsg.addAttribute("vecBindUin", null);
    paramUniPacket.put("SvcReqBindUin", localSvcReqBindUin);
    return true;
  }
  
  private boolean aN(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = paramToServiceMsg.extraData.getString("uin");
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    if (u((String)localObject) == 0L)
    {
      T(paramToServiceMsg);
      return false;
    }
    localObject = new ProfGroupInfoReq();
    ((ProfGroupInfoReq)localObject).uGroupCode = u(str);
    ((ProfGroupInfoReq)localObject).dwTimeStamp = paramToServiceMsg.extraData.getLong("groupablm_timestamp");
    ((ProfGroupInfoReq)localObject).cIsGetGroupAlbum = paramToServiceMsg.extraData.getByte("get_groupablm");
    ((ProfGroupInfoReq)localObject).wSourceID = paramToServiceMsg.extraData.getInt("cStatOption", 0);
    ((ProfGroupInfoReq)localObject).cIfGetAuthInfo = paramToServiceMsg.extraData.getByte("cIfGetAuthInfo");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupInfoReq");
    paramUniPacket.put("req", localObject);
    return true;
  }
  
  private boolean aO(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrlReq();
    JceInputStream localJceInputStream = new JceInputStream(paramToServiceMsg.extraData.getByteArray("QQHeadUrlReq"));
    localJceInputStream.setServerEncoding("UTF-8");
    localQQHeadUrlReq.readFrom(localJceInputStream);
    if ((localQQHeadUrlReq.dstUsrType < 0) && (QLog.isColorLevel())) {
      QLog.e("", 2, "==============================handleGetQQHead error! ");
    }
    paramUniPacket.setServantName("GetAvatarInfo");
    paramUniPacket.setFuncName("QQHeadUrlReq");
    paramUniPacket.put("QQHeadUrlReq", localQQHeadUrlReq);
    paramToServiceMsg.setServiceCmd("AvatarInfoSvr.QQHeadUrlReq");
    return true;
  }
  
  private boolean aP(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = u(paramToServiceMsg.extraData.getString("uin"));
    if (l == 0L)
    {
      T(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ProfVipqqInfoReq();
    paramToServiceMsg.iUin = l;
    paramToServiceMsg.iRetIncomPlete = 1;
    paramToServiceMsg.iReloadFlag = 1;
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ProfVipqqInfo");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private boolean aQ(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = u(paramToServiceMsg.extraData.getString("uin"));
    if (l == 0L)
    {
      T(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ProfIncInfoReq();
    paramToServiceMsg.iUin = l;
    paramToServiceMsg.iRetIncomPlete = 1;
    paramToServiceMsg.iReloadFlag = 1;
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetProfIncInfo");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private boolean aR(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "handleGetFullInfo() ");
    }
    long l1 = u((String)paramToServiceMsg.getAttribute("uin"));
    if (l1 == 0L)
    {
      T(paramToServiceMsg);
      return false;
    }
    ArrayList localArrayList2 = null;
    String[] arrayOfString = (String[])paramToServiceMsg.getAttribute("array_uin");
    ArrayList localArrayList1 = localArrayList2;
    if (arrayOfString != null)
    {
      localArrayList1 = localArrayList2;
      if (arrayOfString.length > 0)
      {
        localArrayList2 = new ArrayList();
        int i = 0;
        for (;;)
        {
          localArrayList1 = localArrayList2;
          if (i >= arrayOfString.length) {
            break;
          }
          long l2 = u(arrayOfString[i]);
          if (l2 == 0L)
          {
            T(paramToServiceMsg);
            return false;
          }
          localArrayList2.add(Long.valueOf(l2));
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "handleGetFullInfo() uin = " + l1);
    }
    paramToServiceMsg = new ProfFullUsrQryReq(0, "", l1, localArrayList1, 1, 1, 0);
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetSglUsrFullInfo");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private boolean aS(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "handleSetUserInfo()");
    }
    String str = paramToServiceMsg.getUin();
    Object localObject = (String)paramToServiceMsg.getAttribute("nickname");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("birthday");
    Byte localByte = (Byte)paramToServiceMsg.getAttribute("gender");
    Integer[] arrayOfInteger = (Integer[])paramToServiceMsg.getAttribute("city");
    int i;
    int k;
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes();
      i = localObject.length;
      k = i + 4 + 0;
    }
    for (int m = 1;; m = 0)
    {
      i = k;
      int j = m;
      if (localInteger != null)
      {
        j = m + 1;
        i = k + 8;
      }
      k = i;
      m = j;
      if (localByte != null)
      {
        m = j + 1;
        k = i + 5;
      }
      i = k;
      int n = m;
      if (arrayOfInteger != null)
      {
        i = k;
        n = m;
        if (arrayOfInteger.length == 3)
        {
          n = m + 1;
          i = k + 16;
        }
      }
      byte[] arrayOfByte = new byte[i];
      j = 0;
      if (localObject != null)
      {
        short s = (short)localObject.length;
        aqoj.Word2Byte(arrayOfByte, 0, (short)20002);
        aqoj.Word2Byte(arrayOfByte, 2, s);
        aqoj.b(arrayOfByte, 4, (byte[])localObject, localObject.length);
        j = s + 4;
      }
      i = j;
      if (localInteger != null)
      {
        aqoj.Word2Byte(arrayOfByte, j, (short)20031);
        i = j + 2;
        aqoj.Word2Byte(arrayOfByte, i, (short)4);
        i += 2;
        aqoj.DWord2Byte(arrayOfByte, i, localInteger.intValue());
        i += 4;
      }
      j = i;
      if (localByte != null)
      {
        aqoj.Word2Byte(arrayOfByte, i, (short)20009);
        i += 2;
        aqoj.Word2Byte(arrayOfByte, i, (short)1);
        i += 2;
        arrayOfByte[i] = Byte.valueOf((byte)(localByte.byteValue() + 1)).byteValue();
        j = i + 1;
      }
      if ((arrayOfInteger != null) && (arrayOfInteger.length == 3))
      {
        aqoj.Word2Byte(arrayOfByte, j, (short)20032);
        i = j + 2;
        aqoj.Word2Byte(arrayOfByte, i, (short)12);
        i += 2;
        aqoj.DWord2Byte(arrayOfByte, i, arrayOfInteger[0].intValue());
        i += 4;
        aqoj.DWord2Byte(arrayOfByte, i, arrayOfInteger[1].intValue());
        i += 4;
        aqoj.DWord2Byte(arrayOfByte, i, arrayOfInteger[2].intValue());
      }
      localObject = new SetUserInfoReq(Long.parseLong(str), n, arrayOfByte);
      paramUniPacket.setServantName("ProfileService");
      paramUniPacket.setFuncName("SetUserInfoReq");
      paramUniPacket.put("req", localObject);
      paramToServiceMsg.setServiceCmd("ProfileService.SetUserInfoReq");
      return true;
      k = 0;
      localObject = null;
    }
  }
  
  private boolean aT(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new SetRichSigReq(paramToServiceMsg.extraData.getByteArray("sig_value"), paramToServiceMsg.extraData.getInt("key"));
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("SetRichSig");
    paramUniPacket.put("SetRichSigReq", paramToServiceMsg);
    return true;
  }
  
  private boolean aU(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = u(paramToServiceMsg.extraData.getString("uin"));
    if (l == 0L)
    {
      T(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ChangeFriendNameReq(l, paramToServiceMsg.extraData.getString("com_value"));
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ChangeFriendName");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private boolean aV(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    int j = paramToServiceMsg.extraData.getInt("reqType", 0);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("showDateNickname");
    paramToServiceMsg = new ArrayList();
    acff localacff = (acff)this.app.getManager(51);
    int k = arrayOfString.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = arrayOfString[i];
      for (;;)
      {
        try
        {
          long l2 = Long.parseLong((String)localObject);
          if (j != 1)
          {
            localObject = localacff.a((String)localObject);
            if (localObject != null)
            {
              l1 = ((ExtensionInfo)localObject).richTime;
              paramToServiceMsg.add(new ReqRichInfo(l2, l1));
            }
          }
          else
          {
            i += 1;
          }
        }
        catch (NumberFormatException paramToServiceMsg)
        {
          return false;
        }
        long l1 = 0L;
      }
    }
    if (j == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramToServiceMsg = new GetRichSigReq(paramToServiceMsg, bool1, bool2, true);
      paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
      paramUniPacket.setFuncName("GetRichSig");
      paramUniPacket.put("GetRichSigReq", paramToServiceMsg);
      return true;
    }
  }
  
  private boolean aW(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new ReqSetSettings((ArrayList)paramToServiceMsg.extraData.getSerializable("Settings"));
    ReqHeader localReqHeader = new ReqHeader(0);
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ReqSetSettings");
    paramUniPacket.put("ReqHeader", localReqHeader);
    paramUniPacket.put("ReqSetSettings", paramToServiceMsg);
    return true;
  }
  
  private boolean aX(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
    paramToServiceMsg = new ReqGetSettings(paramToServiceMsg.extraData.getInt("Revision"), (ArrayList)localObject, paramToServiceMsg.extraData.getLong("Offset"), paramToServiceMsg.extraData.getLong("Count"));
    localObject = new ReqHeader(0);
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ReqGetSettings");
    paramUniPacket.put("ReqHeader", localObject);
    paramUniPacket.put("ReqGetSettings", paramToServiceMsg);
    return true;
  }
  
  private boolean aY(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (u(paramToServiceMsg.extraData.getString("uin")) == 0L)
    {
      T(paramToServiceMsg);
      return false;
    }
    switch (paramToServiceMsg.extraData.getInt("groupreqtype"))
    {
    default: 
      T(paramToServiceMsg);
      return false;
    case 0: 
      return aZ(paramToServiceMsg, paramUniPacket);
    case 1: 
      return ba(paramToServiceMsg, paramUniPacket);
    case 2: 
      return bb(paramToServiceMsg, paramUniPacket);
    case 3: 
      return bf(paramToServiceMsg, paramUniPacket);
    case 4: 
      return bg(paramToServiceMsg, paramUniPacket);
    case 5: 
      return bh(paramToServiceMsg, paramUniPacket);
    case 6: 
      return bi(paramToServiceMsg, paramUniPacket);
    case 7: 
      return bj(paramToServiceMsg, paramUniPacket);
    case 8: 
      return bd(paramToServiceMsg, paramUniPacket);
    case 9: 
      return be(paramToServiceMsg, paramUniPacket);
    }
    return bc(paramToServiceMsg, paramUniPacket);
  }
  
  private boolean aZ(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 0;
    localGroupMngReq.uin = l;
    localGroupMngReq.cIsSupportAuthQuestionJoin = 1;
    l = u(paramToServiceMsg.extraData.getString("troop_uin"));
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt((int)l);
    localGroupMngReq.vecBody = localByteBuffer.array();
    localGroupMngReq.wSourceID = paramToServiceMsg.extraData.getInt("stat_option");
    localGroupMngReq.cIfGetAuthInfo = paramToServiceMsg.extraData.getByte("cIfGetAuthInfo");
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private Object af(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRspGetDevLoginInfo)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRspGetDevLoginInfo", new SvcRspGetDevLoginInfo());
  }
  
  private Object ag(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRspDelLoginInfo)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRspDelLoginInfo", new SvcRspDelLoginInfo());
  }
  
  private Object ah(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespKikOut)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp", new SvcRespKikOut());
  }
  
  private Object ai(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRspBindUin)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRspBindUin", new SvcRspBindUin());
  }
  
  private Object aj(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ProfGroupInfoRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new ProfGroupInfoRes());
  }
  
  private Object ak(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ProfVipqqInfoRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new ProfVipqqInfoRes());
  }
  
  private Object al(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "decodeGetFullInfo() ");
    }
    return (ProfUsrFullInfoRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new ProfUsrFullInfoRes());
  }
  
  private Object am(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "decodeSetUserInfo() ");
    }
    return (SetUserInfoResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new SetUserInfoResp());
  }
  
  private Object an(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return decodePacket(paramFromServiceMsg.getWupBuffer(), "SetRichSigRes", new SetRichSigRes());
  }
  
  private Object ao(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ChangeFriendNameRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new ChangeFriendNameRes());
  }
  
  private Object ap(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespHeader localRespHeader = (RespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    paramToServiceMsg = (RespSetSettings)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetSettings", new RespSetSettings());
    if (localRespHeader == null) {
      paramToServiceMsg = null;
    }
    while (localRespHeader.Result == 0) {
      return paramToServiceMsg;
    }
    return null;
  }
  
  private Object aq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespHeader localRespHeader = (RespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    paramToServiceMsg = (RespGetSettings)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetSettings", new RespGetSettings());
    if (localRespHeader == null) {
      paramToServiceMsg = null;
    }
    while (localRespHeader.Result == 0) {
      return paramToServiceMsg;
    }
    return null;
  }
  
  private Object ar(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return decodePacket(paramFromServiceMsg.getWupBuffer(), "GetRichSigRes", new GetRichSigRes());
  }
  
  private Object as(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = new ArrayList();
      paramFromServiceMsg.add(new ProfSmpInfoRes());
      paramToServiceMsg = (ArrayList)paramToServiceMsg.getByClass("res", paramFromServiceMsg);
      if (QLog.isColorLevel())
      {
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          paramFromServiceMsg = (ProfSmpInfoRes)paramToServiceMsg.get(0);
          QLog.e("BusinessCard_Manager", 2, "businessCardFlag: " + paramFromServiceMsg.cBusiCardFlag);
        }
      }
      else {
        return paramToServiceMsg;
      }
      QLog.e("BusinessCard_Manager", 2, "businessCardFlag: empty");
      return paramToServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      return null;
    }
    catch (RuntimeException paramToServiceMsg) {}
    return null;
  }
  
  private Object at(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (QQHeadUrlResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "QQHeadUrlResp", new QQHeadUrlResp());
  }
  
  private Object au(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RspResUpdate)decodePacket(paramFromServiceMsg.getWupBuffer(), "RspResUpdate", new RspResUpdate());
  }
  
  private Object av(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RspResOrder)decodePacket(paramFromServiceMsg.getWupBuffer(), "RspResOrder", new RspResOrder());
  }
  
  private Object aw(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SyncRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "SyncRes", new SyncRes());
  }
  
  private boolean ba(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 1;
    localGroupMngReq.uin = l1;
    long l2 = u(paramToServiceMsg.extraData.getString("troop_uin"));
    String str2 = paramToServiceMsg.extraData.getString("back_msg");
    int i = str2.getBytes().length;
    String str3 = paramToServiceMsg.extraData.getString("join_group_key");
    String str1 = paramToServiceMsg.extraData.getString("join_group_sig");
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("new_Member_Msg");
    String str4 = paramToServiceMsg.extraData.getString("pic_url");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 9);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.put((byte)i);
    localByteBuffer.put(str2.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    i = paramToServiceMsg.extraData.getInt("stat_option");
    localGroupMngReq.wSourceSubID = i;
    localGroupMngReq.wSourceID = 3;
    localGroupMngReq.sJoinGroupKey = str3;
    localGroupMngReq.sJoinGroupAuth = str1;
    if (!TextUtils.isEmpty(str4)) {
      localGroupMngReq.sJoinGroupPicUrl = str4;
    }
    if (arrayOfByte != null) {
      localGroupMngReq.vecJoinGroupRichMsg = arrayOfByte;
    }
    int j = paramToServiceMsg.extraData.getInt("join_group_verify_type");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("join_group_verify_token");
    if ((!TextUtils.isEmpty(paramToServiceMsg)) && ((j == 1) || (j == 2)))
    {
      localGroupMngReq.dwJoinVerifyType = j;
      localGroupMngReq.sJoinGroupVerifyToken = paramToServiceMsg;
    }
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopReport", 4, String.format("handleJoinGroup: wSourceSubID=%d troop_authSig=%s", new Object[] { Integer.valueOf(i), str1 }));
    }
    return true;
  }
  
  private boolean bb(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 2;
    localGroupMngReq.uin = l1;
    long l2 = u(paramToServiceMsg.extraData.getString("troop_uin"));
    paramToServiceMsg = ByteBuffer.allocate(8);
    paramToServiceMsg.putInt((int)l1);
    paramToServiceMsg.putInt((int)l2);
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean bc(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 10;
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    localGroupMngReq.uin = l1;
    localGroupMngReq.sGroupLocation = paramToServiceMsg.extraData.getString("groupcity");
    byte b1 = paramToServiceMsg.extraData.getByte("type");
    byte b2 = paramToServiceMsg.extraData.getByte("group_ops");
    String str1 = paramToServiceMsg.extraData.getString("group_name");
    String str2 = paramToServiceMsg.extraData.getString("group_memo");
    String str3 = paramToServiceMsg.extraData.getString("group_finger_memo");
    String str4 = paramToServiceMsg.extraData.getString("group_class_text");
    int i = paramToServiceMsg.extraData.getInt("group_class");
    long l2 = paramToServiceMsg.extraData.getLong("group_discussuin");
    paramToServiceMsg = ByteBuffer.allocate(str1.getBytes().length + 19 + 2 + 1 + str2.getBytes().length + 1 + str3.getBytes().length + 1 + str4.getBytes().length);
    paramToServiceMsg.put(b1);
    paramToServiceMsg.putInt(0);
    paramToServiceMsg.putInt((int)l1);
    paramToServiceMsg.put(b2);
    paramToServiceMsg.putInt(0);
    paramToServiceMsg.putInt(i);
    paramToServiceMsg.put((byte)str1.getBytes().length);
    paramToServiceMsg.put(str1.getBytes());
    paramToServiceMsg.putShort((short)0);
    paramToServiceMsg.put((byte)str2.getBytes().length);
    paramToServiceMsg.put(str2.getBytes());
    paramToServiceMsg.put((byte)str3.getBytes().length);
    paramToServiceMsg.put(str3.getBytes());
    paramToServiceMsg.put((byte)str4.getBytes().length);
    paramToServiceMsg.put(str4.getBytes());
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    localGroupMngReq.dwDiscussUin = Long.valueOf(l2).longValue();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean bd(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 8;
    localGroupMngReq.uin = l1;
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    long l2 = u(str);
    localGroupMngReq.wSourceSubID = 32;
    localGroupMngReq.wSourceID = 3;
    ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("Invite_uins");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(localArrayList.size() * 4 + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putShort((short)localArrayList.size());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localByteBuffer.putInt((int)u((String)localIterator.next()));
    }
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    QLog.d("Q.troopInviteMember", 1, "inviteGroup: groupCode=" + str + ", uinListSize=" + localArrayList.size());
    return true;
  }
  
  private boolean be(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 9;
    localGroupMngReq.uin = l1;
    long l2 = u(paramToServiceMsg.extraData.getString("troop_uin"));
    paramToServiceMsg = ByteBuffer.allocate(8);
    paramToServiceMsg.putInt((int)l2);
    paramToServiceMsg.putInt((int)l1);
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean bf(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 3;
    localGroupMngReq.uin = l1;
    long l2 = u(paramToServiceMsg.extraData.getString("troop_uin"));
    Object localObject = paramToServiceMsg.extraData.getStringArrayList("frie_uins");
    paramToServiceMsg = ByteBuffer.allocate(((ArrayList)localObject).size() * 4 + 8);
    paramToServiceMsg.putInt((int)l2);
    paramToServiceMsg.putInt((int)l1);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramToServiceMsg.putInt((int)u((String)((Iterator)localObject).next()));
    }
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean bg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 4;
    localGroupMngReq.uin = l1;
    l1 = u(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = u(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean bh(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 5;
    localGroupMngReq.uin = l1;
    l1 = u(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = u(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean bi(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 6;
    localGroupMngReq.uin = l1;
    l1 = u(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = u(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean bj(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 7;
    localGroupMngReq.uin = l1;
    l1 = u(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = u(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private long u(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Integer localInteger = (Integer)this.gh.get(paramFromServiceMsg.getServiceCmd());
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    }
    switch (i)
    {
    case 6: 
    case 11: 
    case 14: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    default: 
    case 3: 
    case 4: 
    case 5: 
    case 2: 
    case 13: 
    case 8: 
    case 15: 
    case 7: 
    case 9: 
    case 10: 
    case 12: 
      for (;;)
      {
        return null;
        i = -1;
        break;
        return ar(paramToServiceMsg, paramFromServiceMsg);
        return aq(paramToServiceMsg, paramFromServiceMsg);
        return ap(paramToServiceMsg, paramFromServiceMsg);
        return as(paramToServiceMsg, paramFromServiceMsg);
        return at(paramToServiceMsg, paramFromServiceMsg);
        return ao(paramToServiceMsg, paramFromServiceMsg);
        return aj(paramToServiceMsg, paramFromServiceMsg);
        return an(paramToServiceMsg, paramFromServiceMsg);
        return al(paramToServiceMsg, paramFromServiceMsg);
        return am(paramToServiceMsg, paramFromServiceMsg);
        ak(paramToServiceMsg, paramFromServiceMsg);
      }
    case 22: 
      return aw(paramToServiceMsg, paramFromServiceMsg);
    case 23: 
      return ae(paramToServiceMsg, paramFromServiceMsg);
    case 24: 
      return av(paramToServiceMsg, paramFromServiceMsg);
    case 25: 
      return au(paramToServiceMsg, paramFromServiceMsg);
    case 26: 
      return af(paramToServiceMsg, paramFromServiceMsg);
    case 27: 
      return ag(paramToServiceMsg, paramFromServiceMsg);
    case 28: 
      return ah(paramToServiceMsg, paramFromServiceMsg);
    case 29: 
      return ai(paramToServiceMsg, paramFromServiceMsg);
    case 30: 
      return this.jdField_a_of_type_Andx.a(paramToServiceMsg, paramFromServiceMsg);
    }
    return this.jdField_a_of_type_Amzr.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return aF(paramToServiceMsg, paramUniPacket);
  }
  
  public boolean aF(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject;
    switch (((Integer)this.gh.get(paramToServiceMsg.getServiceCmd())).intValue())
    {
    case 6: 
    case 14: 
    case 16: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    default: 
      return false;
    case 1: 
      localObject = paramToServiceMsg.extraData.getString("city");
      paramToServiceMsg = (ToServiceMsg)localObject;
      if (localObject == null) {
        paramToServiceMsg = "";
      }
      a(paramToServiceMsg, paramUniPacket);
      return true;
    case 2: 
      localObject = new ArrayList();
      Iterator localIterator = paramToServiceMsg.extraData.getStringArrayList("uinList").iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
      a(paramToServiceMsg, (ArrayList)localObject, paramUniPacket);
      return true;
    case 3: 
      return aV(paramToServiceMsg, paramUniPacket);
    case 4: 
      return aX(paramToServiceMsg, paramUniPacket);
    case 5: 
      return aW(paramToServiceMsg, paramUniPacket);
    case 7: 
      return aT(paramToServiceMsg, paramUniPacket);
    case 8: 
      return aU(paramToServiceMsg, paramUniPacket);
    case 9: 
      return aR(paramToServiceMsg, paramUniPacket);
    case 10: 
      return aS(paramToServiceMsg, paramUniPacket);
    case 11: 
      return aQ(paramToServiceMsg, paramUniPacket);
    case 12: 
      return aP(paramToServiceMsg, paramUniPacket);
    case 13: 
      return aO(paramToServiceMsg, paramUniPacket);
    case 15: 
      return aN(paramToServiceMsg, paramUniPacket);
    case 17: 
      return aY(paramToServiceMsg, paramUniPacket);
    case 23: 
      return aI(paramToServiceMsg, paramUniPacket);
    case 24: 
      return aH(paramToServiceMsg, paramUniPacket);
    case 25: 
      return aG(paramToServiceMsg, paramUniPacket);
    case 26: 
      return aJ(paramToServiceMsg, paramUniPacket);
    case 27: 
      return aK(paramToServiceMsg, paramUniPacket);
    case 28: 
      return aL(paramToServiceMsg, paramUniPacket);
    case 29: 
      return aM(paramToServiceMsg, paramUniPacket);
    case 30: 
      return this.jdField_a_of_type_Andx.a(paramToServiceMsg, paramUniPacket);
    }
    return this.jdField_a_of_type_Amzr.a(paramToServiceMsg, paramUniPacket);
  }
  
  public Object ae(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "decodeCheckUpdateReq() ");
    }
    return (CheckUpdateResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "CheckUpdateResp", new CheckUpdateResp());
  }
  
  public void destroy() {}
  
  public String[] y()
  {
    return gu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     andj
 * JD-Core Version:    0.7.0.1
 */