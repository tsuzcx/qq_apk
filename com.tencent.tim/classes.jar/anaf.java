import QQService.DiscussRespHeader;
import QQService.RespAddDiscussMember;
import QQService.RespChangeDiscussName;
import QQService.RespCreateDiscuss;
import QQService.RespGetDiscussInfo;
import QQService.RespGetDiscussInteRemark;
import QQService.RespJoinDiscuss;
import QQService.RespQuitDiscuss;
import QQService.RespSetDiscussAttr;
import QQService.RespSetDiscussFlag;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class anaf
{
  private Object a(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    anaf.a locala = new anaf.a();
    locala.cew = paramBoolean;
    locala.eF = paramObject1;
    locala.eG = paramObject2;
    return locala;
  }
  
  private <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (RuntimeException paramArrayOfByte) {}
    return null;
  }
  
  private Object o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespSetDiscussFlag)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetDiscussFlag", new RespSetDiscussFlag());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg == null) || (localDiscussRespHeader == null))
    {
      QLog.w("DiscussionReceiver", 2, "<<---discussFlagResp or respheader is null");
      return null;
    }
    if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {}
    for (boolean bool = true;; bool = false) {
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
  }
  
  private Object p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespSetDiscussAttr)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetDiscussAttr", new RespSetDiscussAttr());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg == null) || (localDiscussRespHeader == null))
    {
      QLog.w("DiscussionReceiver", 2, "<<---discussAttr or respheader is null!");
      return null;
    }
    if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {}
    for (boolean bool = true;; bool = false) {
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
  }
  
  private Object q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespQuitDiscuss)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespQuitDiscuss", new RespQuitDiscuss());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg == null) || (localDiscussRespHeader == null))
    {
      QLog.w("DiscussionReceiver", 2, "<<---discussQuitResp or respheader is null");
      return null;
    }
    if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {}
    for (boolean bool = true;; bool = false) {
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
  }
  
  private Object r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespGetDiscussInfo)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetDiscussInfo", new RespGetDiscussInfo());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg == null) || (localDiscussRespHeader == null))
    {
      QLog.w("DiscussionReceiver", 2, "<<---discussInfo or respHeader is null!");
      return null;
    }
    if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {}
    for (boolean bool = true;; bool = false) {
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
  }
  
  private Object s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespGetDiscussInteRemark)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetDiscussInteRemark", new RespGetDiscussInteRemark());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg == null) || (localDiscussRespHeader == null))
    {
      QLog.w("DiscussionReceiver", 2, "<<---discussInfo or respHeader is null!");
      return null;
    }
    if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {}
    for (boolean bool = true;; bool = false) {
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
  }
  
  private Object t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespCreateDiscuss)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespCreateDiscuss", new RespCreateDiscuss());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg == null) || (localDiscussRespHeader == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionReceiver", 2, "<<---createDiscussResp or respheader is null!");
      }
      return null;
    }
    if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {}
    for (boolean bool = true;; bool = false) {
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
  }
  
  private Object u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespChangeDiscussName)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespChangeDiscussName", new RespChangeDiscussName());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg == null) || (localDiscussRespHeader == null)) {
      return null;
    }
    if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {}
    for (boolean bool = true;; bool = false) {
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
  }
  
  private Object v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespAddDiscussMember)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespAddDiscussMember", new RespAddDiscussMember());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg == null) || (localDiscussRespHeader == null))
    {
      QLog.w("DiscussionReceiver", 2, "<<---addDisMember or respheader is null!");
      return null;
    }
    if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {}
    for (boolean bool = true;; bool = false) {
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
  }
  
  private Object w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespJoinDiscuss)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespJoinDiscuss", new RespJoinDiscuss());
    DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
    if ((paramToServiceMsg == null) || (localDiscussRespHeader == null))
    {
      QLog.w("DiscussionReceiver", 2, "<<---decodeRespJoinDiscuss or respheader is null!");
      return null;
    }
    if ((paramFromServiceMsg.getResultCode() == 1000) && (localDiscussRespHeader.Result == 0)) {}
    for (boolean bool = true;; bool = false) {
      return a(bool, localDiscussRespHeader, paramToServiceMsg);
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionReceiver", 2, "~~~decode cmd: " + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      return v(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str)) {
      return u(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str)) {
      return t(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("OidbSvc.0x58a".equalsIgnoreCase(str)) {}
    for (;;)
    {
      return null;
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str)) {
        return r(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str)) {
        return q(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str)) {
        return p(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str)) {
        return o(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(str)) {
        return s(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(str)) {
        return w(paramToServiceMsg, paramFromServiceMsg);
      }
      QLog.w("DiscussionReceiver", 2, "~~~unknow cmd: " + str);
    }
  }
  
  public class a
  {
    public boolean cew;
    public Object eF;
    public Object eG;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anaf
 * JD-Core Version:    0.7.0.1
 */