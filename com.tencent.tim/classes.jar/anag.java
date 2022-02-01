import QQService.AddDiscussMemberInfo;
import QQService.DiscussReqHeader;
import QQService.MemberAttrInfo;
import QQService.ReqAddDiscussMember;
import QQService.ReqChangeDiscussName;
import QQService.ReqCreateDiscuss;
import QQService.ReqGetDiscussInfo;
import QQService.ReqGetDiscussInteRemark;
import QQService.ReqJoinDiscuss;
import QQService.ReqQuitDiscuss;
import QQService.ReqSetDiscussAttr;
import QQService.ReqSetDiscussFlag;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class anag
{
  private DiscussReqHeader a = new DiscussReqHeader();
  private final int dEK = 0;
  
  public anag()
  {
    this.a.Version = 0;
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQServiceDiscussSvc");
    paramUniPacket.setFuncName("ReqSetDiscussFlag");
    ReqSetDiscussFlag localReqSetDiscussFlag = new ReqSetDiscussFlag();
    localReqSetDiscussFlag.DiscussUin = paramToServiceMsg.extraData.getLong("discussUin");
    localReqSetDiscussFlag.Flag = paramToServiceMsg.extraData.getByte("flag");
    paramUniPacket.put("ReqSetDiscussFlag", localReqSetDiscussFlag);
    paramUniPacket.put("DiscussReqHeader", this.a);
    return true;
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQServiceDiscussSvc");
    paramUniPacket.setFuncName("ReqSetDiscussAttr");
    ReqSetDiscussAttr localReqSetDiscussAttr = new ReqSetDiscussAttr();
    localReqSetDiscussAttr.Attr = new HashMap();
    localReqSetDiscussAttr.DiscussUin = paramToServiceMsg.extraData.getLong("discussUin");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("infoType");
    paramToServiceMsg = paramToServiceMsg.extraData.getIntArray("attrType");
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      MemberAttrInfo localMemberAttrInfo = new MemberAttrInfo();
      localMemberAttrInfo.Value = paramToServiceMsg[i];
      localMemberAttrInfo.StrValue = "";
      int k = arrayOfInt[i];
      localReqSetDiscussAttr.Attr.put(Integer.valueOf(k), localMemberAttrInfo);
      i += 1;
    }
    paramUniPacket.put("ReqSetDiscussAttr", localReqSetDiscussAttr);
    paramUniPacket.put("DiscussReqHeader", this.a);
    return true;
  }
  
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQServiceDiscussSvc");
    paramUniPacket.setFuncName("ReqQuitDiscuss");
    ReqQuitDiscuss localReqQuitDiscuss = new ReqQuitDiscuss();
    localReqQuitDiscuss.DiscussUin = paramToServiceMsg.extraData.getLong("discussUin");
    paramUniPacket.put("ReqQuitDiscuss", localReqQuitDiscuss);
    paramUniPacket.put("DiscussReqHeader", this.a);
    return true;
  }
  
  private boolean r(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQServiceDiscussSvc");
    paramUniPacket.setFuncName("ReqGetDiscussInfo");
    ReqGetDiscussInfo localReqGetDiscussInfo = new ReqGetDiscussInfo();
    Map localMap = (Map)paramToServiceMsg.getAttribute("inteRemarkUinMap");
    localReqGetDiscussInfo.DiscussUin = paramToServiceMsg.extraData.getLong("discussUin");
    localReqGetDiscussInfo.InteRemarkTimeStamp = paramToServiceMsg.extraData.getLong("InteRemarkTimeStamp", 0L);
    if (localMap != null) {
      localReqGetDiscussInfo.UinList = localMap;
    }
    localReqGetDiscussInfo.InfoSeq = paramToServiceMsg.extraData.getLong("infoSeq", 0L);
    localReqGetDiscussInfo.Signature = paramToServiceMsg.extraData.getString("signature");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder().append("createGetDiscussInfoBuffer reqUIn =").append(localReqGetDiscussInfo.DiscussUin).append(",inteRemarktime =").append(localReqGetDiscussInfo.InteRemarkTimeStamp).append(",uinList size ");
      if (localReqGetDiscussInfo.UinList == null) {
        break label213;
      }
    }
    label213:
    for (int i = localReqGetDiscussInfo.UinList.size();; i = -1)
    {
      QLog.d("DiscussionSender", 2, i + ", signature=" + localReqGetDiscussInfo.Signature);
      paramUniPacket.put("ReqGetDiscussInfo", localReqGetDiscussInfo);
      paramUniPacket.put("DiscussReqHeader", this.a);
      return true;
    }
  }
  
  private boolean s(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQServiceDiscussSvc");
    paramUniPacket.setFuncName("ReqGetDiscussInteRemark");
    ReqGetDiscussInteRemark localReqGetDiscussInteRemark = new ReqGetDiscussInteRemark();
    localReqGetDiscussInteRemark.DiscussUin = paramToServiceMsg.extraData.getLong("discussUin");
    localReqGetDiscussInteRemark.UinList = ((ArrayList)paramToServiceMsg.getAttribute("inteRemarkUinList"));
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionSender", 2, "createGetDiscussInteRemarkBuffer reqUIn =" + localReqGetDiscussInteRemark.DiscussUin + " uinList size " + localReqGetDiscussInteRemark.UinList.size());
    }
    paramUniPacket.put("ReqGetDiscussInteRemark", localReqGetDiscussInteRemark);
    paramUniPacket.put("DiscussReqHeader", this.a);
    return true;
  }
  
  private boolean t(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQServiceDiscussSvc");
    paramUniPacket.setFuncName("ReqCreateDiscuss");
    ReqCreateDiscuss localReqCreateDiscuss = new ReqCreateDiscuss();
    localReqCreateDiscuss.Name = paramToServiceMsg.extraData.getString("name");
    ArrayList localArrayList = new ArrayList();
    long[] arrayOfLong1 = paramToServiceMsg.extraData.getLongArray("uin");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("type");
    long[] arrayOfLong2 = paramToServiceMsg.extraData.getLongArray("refUin");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("refStr");
    int j = paramToServiceMsg.extraData.getInt("from");
    int k = arrayOfLong1.length;
    int i = 0;
    while (i < k)
    {
      paramToServiceMsg = new AddDiscussMemberInfo();
      paramToServiceMsg.Uin = arrayOfLong1[i];
      paramToServiceMsg.Type = arrayOfInt[i];
      paramToServiceMsg.RefUin = arrayOfLong2[i];
      paramToServiceMsg.RefStr = arrayOfString[i];
      localArrayList.add(paramToServiceMsg);
      i += 1;
    }
    localReqCreateDiscuss.Members = localArrayList;
    localReqCreateDiscuss.Refer = j;
    paramUniPacket.put("ReqCreateDiscuss", localReqCreateDiscuss);
    paramUniPacket.put("DiscussReqHeader", this.a);
    return true;
  }
  
  private boolean u(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQServiceDiscussSvc");
    paramUniPacket.setFuncName("ReqChangeDiscussName");
    ReqChangeDiscussName localReqChangeDiscussName = new ReqChangeDiscussName();
    localReqChangeDiscussName.DiscussUin = paramToServiceMsg.extraData.getLong("discussUin");
    localReqChangeDiscussName.NewName = paramToServiceMsg.extraData.getString("newName");
    paramUniPacket.put("ReqChangeDiscussName", localReqChangeDiscussName);
    paramUniPacket.put("DiscussReqHeader", this.a);
    return true;
  }
  
  private boolean v(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQServiceDiscussSvc");
    paramUniPacket.setFuncName("ReqAddDiscussMember");
    ReqAddDiscussMember localReqAddDiscussMember = new ReqAddDiscussMember();
    localReqAddDiscussMember.DiscussUin = paramToServiceMsg.extraData.getLong("discussUin");
    ArrayList localArrayList = new ArrayList();
    long[] arrayOfLong1 = paramToServiceMsg.extraData.getLongArray("uin");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("type");
    long[] arrayOfLong2 = paramToServiceMsg.extraData.getLongArray("refUin");
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArray("refStr");
    int j = arrayOfLong1.length;
    int i = 0;
    while (i < j)
    {
      AddDiscussMemberInfo localAddDiscussMemberInfo = new AddDiscussMemberInfo();
      localAddDiscussMemberInfo.Uin = arrayOfLong1[i];
      localAddDiscussMemberInfo.Type = arrayOfInt[i];
      localAddDiscussMemberInfo.RefUin = arrayOfLong2[i];
      localAddDiscussMemberInfo.RefStr = paramToServiceMsg[i];
      localArrayList.add(localAddDiscussMemberInfo);
      i += 1;
    }
    localReqAddDiscussMember.Members = localArrayList;
    paramUniPacket.put("ReqAddDiscussMember", localReqAddDiscussMember);
    paramUniPacket.put("DiscussReqHeader", this.a);
    return true;
  }
  
  private boolean w(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQServiceDiscussSvc");
    paramUniPacket.setFuncName("ReqJoinDiscuss");
    ReqJoinDiscuss localReqJoinDiscuss = new ReqJoinDiscuss();
    localReqJoinDiscuss.Signature = paramToServiceMsg.extraData.getString("signature");
    localReqJoinDiscuss.From = paramToServiceMsg.extraData.getInt("addDisSource");
    paramUniPacket.put("ReqJoinDiscuss", localReqJoinDiscuss);
    paramUniPacket.put("DiscussReqHeader", this.a);
    return true;
  }
  
  public boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionSender", 2, "~~~create wup buffer cmd: " + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      return v(paramToServiceMsg, paramUniPacket);
    }
    if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str)) {
      return u(paramToServiceMsg, paramUniPacket);
    }
    if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str)) {
      return t(paramToServiceMsg, paramUniPacket);
    }
    if ("OidbSvc.0x58a".equalsIgnoreCase(str)) {}
    do
    {
      return false;
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str)) {
        return r(paramToServiceMsg, paramUniPacket);
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str)) {
        return q(paramToServiceMsg, paramUniPacket);
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str)) {
        return p(paramToServiceMsg, paramUniPacket);
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str)) {
        return o(paramToServiceMsg, paramUniPacket);
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(str)) {
        return s(paramToServiceMsg, paramUniPacket);
      }
    } while (!"QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(str));
    return w(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anag
 * JD-Core Version:    0.7.0.1
 */