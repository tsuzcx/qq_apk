import ColorNick.QC.readItemInfoReq;
import ColorNick.QC.readItemInfoRsp;
import GROUP.MessageRemindReq;
import GROUP.MessageRemindRsp;
import MQQ.GetRoamToastReq;
import MQQ.GetRoamToastRsp;
import ProfileLogic.QC.readUserInfoReq;
import ProfileLogic.QC.readUserInfoRsp;
import ProfileLogic.QC.setUserFlagReq;
import ProfileLogic.QC.setUserFlagRsp;
import ProfileLogic.QC.setUserProfileReq;
import ProfileLogic.QC.setUserProfileRsp;
import QC.BubbleRecommendReq;
import QC.BubbleRecommendRsp;
import QC.FaceReq;
import QC.FaceRsp;
import QC.FontRecommendReq;
import QC.FontRecommendRsp;
import QC.SetFontBubbleReq;
import QC.SetFontBubbleRsp;
import QC.UniLoginCheckReq;
import QC.UniLoginCheckRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class anac
  extends swr
{
  private static int cRe;
  private static ConcurrentHashMap<String, aqve> gY = new ConcurrentHashMap();
  
  public static void Qe(String paramString)
  {
    gY.remove(paramString);
  }
  
  public static void a(aqve paramaqve, String paramString)
  {
    gY.put(paramString, paramaqve);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasService", 2, "decode: cmd=" + paramToServiceMsg.getServiceCmd());
    }
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
      if (paramToServiceMsg.getServiceCmd().equals("FriendClone.CloneAuthStatus"))
      {
        int i = ((Integer)localUniPacket.getByClass("", Integer.valueOf(-1))).intValue();
        paramFromServiceMsg = new ArrayList();
        int j = paramToServiceMsg.extraData.getInt("operation", -1);
        paramFromServiceMsg.add(Integer.valueOf(i));
        paramFromServiceMsg.add(Integer.valueOf(j));
        if (j == 257)
        {
          boolean bool = ((Boolean)localUniPacket.getByClass("bOpenAuth", new Boolean(false))).booleanValue();
          paramFromServiceMsg.add(Boolean.valueOf(bool));
          if (QLog.isColorLevel()) {
            QLog.d("VasService", 2, "decode: ret=" + i + " openAuth=" + bool + " funName=" + localUniPacket.getFuncName());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("VasService", 2, "decode: ret=" + i + " funName=" + localUniPacket.getFuncName());
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("VasService", 1, "decode error: ", paramToServiceMsg);
      return null;
    }
    if (paramToServiceMsg.getServiceCmd().equals("groupnick.readitem"))
    {
      paramFromServiceMsg = (readItemInfoRsp)localUniPacket.getByClass("stRsp", new readItemInfoRsp());
      paramToServiceMsg = paramFromServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("VasService", 2, "decode: ret =  funName = " + localUniPacket.getFuncName() + " infoRsp = " + paramFromServiceMsg.toString());
        return paramFromServiceMsg;
      }
    }
    else
    {
      if (paramToServiceMsg.getServiceCmd().equals("profilelogic.readUserInfo")) {
        return (readUserInfoRsp)localUniPacket.getByClass("stRsp", new readUserInfoRsp());
      }
      if (paramToServiceMsg.getServiceCmd().equals("profilelogic.setUserProfile")) {
        return (setUserProfileRsp)localUniPacket.getByClass("stRsp", new setUserProfileRsp());
      }
      if (paramToServiceMsg.getServiceCmd().equals("profilelogic.setUserFlag")) {
        return (setUserFlagRsp)localUniPacket.getByClass("stRsp", new setUserFlagRsp());
      }
      if (paramToServiceMsg.getServiceCmd().equals("GroupCare.getMessageRemindInfo")) {
        return (MessageRemindRsp)localUniPacket.getByClass("stRsp", new MessageRemindRsp());
      }
      if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getFontRecommend")) {
        return (FontRecommendRsp)localUniPacket.getByClass("rsp", new FontRecommendRsp());
      }
      if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getBubbleRecommend")) {
        return (BubbleRecommendRsp)localUniPacket.getByClass("rsp", new BubbleRecommendRsp());
      }
      if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.setFontBubble")) {
        return (SetFontBubbleRsp)localUniPacket.getByClass("rsp", new SetFontBubbleRsp());
      }
      if (paramToServiceMsg.getServiceCmd().equals("RoamWrap.GetRoamToast")) {
        return (GetRoamToastRsp)localUniPacket.getByClass("stRsp", new GetRoamToastRsp());
      }
      if (paramToServiceMsg.getServiceCmd().equals("Face.setFace")) {
        return (FaceRsp)localUniPacket.getByClass("rsp", new FaceRsp());
      }
      if (paramToServiceMsg.getServiceCmd().equals("QCUniBusinessLogin.check")) {
        return (UniLoginCheckRsp)localUniPacket.getByClass("rsp", new UniLoginCheckRsp());
      }
      if (gY.containsKey(aqve.d(paramToServiceMsg)))
      {
        paramToServiceMsg = ((aqve)gY.get(aqve.d(paramToServiceMsg))).a(paramToServiceMsg, paramFromServiceMsg, localUniPacket);
        return paramToServiceMsg;
      }
      return null;
      paramToServiceMsg = paramFromServiceMsg;
    }
    return paramToServiceMsg;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasService", 2, "encodeReqMsg: cmd=" + paramToServiceMsg.getServiceCmd());
    }
    boolean bool;
    if (paramToServiceMsg.getServiceCmd().equals("FriendClone.CloneAuthStatus"))
    {
      i = paramToServiceMsg.extraData.getInt("operation", -1);
      if (i == 257)
      {
        paramUniPacket.setFuncName("getCloneAuthStatus");
        paramUniPacket.setServantName("MQQ.FriendCloneServer.FriendCloneObj");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        localObject = paramToServiceMsg.extraData.getString("uUin");
        bool = paramToServiceMsg.extraData.getBoolean("bOpenAuth", false);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label151;
        }
        QLog.e("VasService", 2, "encodeReqMsg: uin is empty");
      }
    }
    label151:
    do
    {
      do
      {
        return false;
      } while (i != 258);
      paramUniPacket.setFuncName("setCloneAuthStatus");
      break;
      paramUniPacket.put("uUin", Long.valueOf(Long.parseLong((String)localObject)));
      paramUniPacket.put("bOpenAuth", Boolean.valueOf(bool));
      if (QLog.isColorLevel()) {
        QLog.d("VasService", 2, "encodeReqMsg: svName=" + paramUniPacket.getServantName() + " funName=" + paramUniPacket.getFuncName() + " uin=" + paramUniPacket.getByClass("uUin", new Long(1L)) + " openAuth=" + paramUniPacket.getByClass("bOpenAuth", new Boolean(false)));
      }
      return true;
      if (paramToServiceMsg.getServiceCmd().equals("groupnick.readitem"))
      {
        paramUniPacket.setFuncName("readItemInfo");
        paramUniPacket.put("stReq", (readItemInfoReq)paramToServiceMsg.extraData.getSerializable("req"));
        paramUniPacket.setServantName("QC.readGroupNickServer.readGroupNickObj");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("profilelogic.readUserInfo"))
      {
        paramUniPacket.setServantName("QC.ProfileLogicServer.ProfileLogicObj");
        paramUniPacket.setFuncName("ReadUserProfile");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("stReq", (readUserInfoReq)paramToServiceMsg.extraData.getSerializable("req"));
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("profilelogic.setUserProfile"))
      {
        paramUniPacket.setServantName("QC.ProfileLogicServer.ProfileLogicObj");
        paramUniPacket.setFuncName("SetUserProfile");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("stReq", (setUserProfileReq)paramToServiceMsg.extraData.get("req"));
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("profilelogic.setUserFlag"))
      {
        paramUniPacket.setServantName("QC.ProfileLogicServer.ProfileLogicObj");
        paramUniPacket.setFuncName("SetUserFlag");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("stReq", (setUserFlagReq)paramToServiceMsg.extraData.get("req"));
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("GroupCare.getMessageRemindInfo"))
      {
        paramUniPacket.setServantName("GROUP.GroupCareServer.GroupCareObj");
        paramUniPacket.setFuncName("getMessageRemindInfo");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("stReq", (MessageRemindReq)paramToServiceMsg.extraData.get("req"));
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getFontRecommend"))
      {
        paramUniPacket.setServantName("QC.FontBubbleRecommendServer.FontBubbleRecommendObj");
        paramUniPacket.setFuncName("getFontRecommend");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("req", (FontRecommendReq)paramToServiceMsg.extraData.get("req"));
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getBubbleRecommend"))
      {
        paramUniPacket.setServantName("QC.FontBubbleRecommendServer.FontBubbleRecommendObj");
        paramUniPacket.setFuncName("getBubbleRecommend");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("req", (BubbleRecommendReq)paramToServiceMsg.extraData.get("req"));
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("QCUniBusinessLogin.check"))
      {
        paramUniPacket.setServantName("QC.UniBusinessLoginServer.UniBusinessLoginObj");
        paramUniPacket.setFuncName("UniLoginCheck");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("stReq", (UniLoginCheckReq)paramToServiceMsg.extraData.get("req"));
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("FontBubbleRecommend.setFontBubble"))
      {
        paramUniPacket.setServantName("QC.FontBubbleRecommendServer.FontBubbleRecommendObj");
        paramUniPacket.setFuncName("setFontBubble");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("req", (SetFontBubbleReq)paramToServiceMsg.extraData.get("req"));
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("RoamWrap.GetRoamToast"))
      {
        paramUniPacket.setServantName("MQQ.RoamWrapServer.RoamWrapObj");
        paramUniPacket.setFuncName("GetRoamToast");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("stReq", (GetRoamToastReq)paramToServiceMsg.extraData.get("req"));
        return true;
      }
      if (paramToServiceMsg.getServiceCmd().equals("Face.setFace"))
      {
        paramUniPacket.setServantName("QC.FaceServer.FaceObj");
        paramUniPacket.setFuncName("setFace");
        i = cRe;
        cRe = i + 1;
        paramUniPacket.setRequestId(i);
        paramUniPacket.put("req", (FaceReq)paramToServiceMsg.extraData.get("req"));
        return true;
      }
    } while (!gY.containsKey(aqve.d(paramToServiceMsg)));
    Object localObject = (aqve)gY.get(aqve.d(paramToServiceMsg));
    int i = cRe;
    cRe = i + 1;
    ((aqve)localObject).a(paramToServiceMsg, paramUniPacket, i);
    return true;
  }
  
  public String[] y()
  {
    return anab.gv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anac
 * JD-Core Version:    0.7.0.1
 */