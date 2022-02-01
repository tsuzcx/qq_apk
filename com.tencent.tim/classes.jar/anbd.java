import AccostSvc.RespClientMsg;
import AccostSvc.RespDeleteBlackList;
import AccostSvc.RespGetBlackList;
import AccostSvc.RespHeader;
import AccostSvc.RespInsertBlackList;
import AccostSvc.SvrMsg;
import MessageSvcPack.RequestPushStatus;
import MessageSvcPack.SvcResponseDelMsgV2;
import MessageSvcPack.SvcResponseDelRoamMsg;
import MessageSvcPack.SvcResponseGetMsgV2;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import MessageSvcPack.SvcResponseSetRoamMsg;
import OnlinePushPack.SvcReqPushMsg;
import PushAdMsg.AdMsgInfo;
import PushNotifyPack.RequestPushNotify;
import PushNotifyPack.SvcRequestPushReadedNotify;
import QQService.RespGetSign;
import QQService.RespOffFilePack;
import QQService.RespTmpChatPicDownload;
import QQService.SCPushStreamMsg;
import QQService.SCRespUploadStreamMsg;
import QQService.StreamData;
import QQService.StreamInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class anbd
{
  private String TAG = MessageHandler.class.getSimpleName();
  
  private Object I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("push", 2, "decodeVideoChatStatus");
    }
    return null;
  }
  
  private Object J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespGetSign localRespGetSign = (RespGetSign)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetSign", new RespGetSign());
    if ((localRespGetSign == null) || (localRespGetSign.iReplyCode != 0))
    {
      if (localRespGetSign == null) {}
      for (long l = 2139062143L;; l = localRespGetSign.iReplyCode)
      {
        d(paramToServiceMsg, l);
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", l);
        return null;
      }
    }
    return new anbd.b(localRespGetSign.vKey, localRespGetSign.vSign);
  }
  
  private Object K(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SCRespUploadStreamMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SCRespUploadStreamMsg", new SCRespUploadStreamMsg());
    if (paramToServiceMsg == null) {
      return null;
    }
    paramFromServiceMsg = paramToServiceMsg.stStreamInfo;
    return new anbd.c(anqo.R(paramFromServiceMsg.iMsgId, 0), paramToServiceMsg.shResetSeq, paramFromServiceMsg.shFlowLayer, paramFromServiceMsg, paramToServiceMsg.result);
  }
  
  private Object L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SCPushStreamMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SCPushStreamMsg", new SCPushStreamMsg());
    if (paramToServiceMsg == null) {
      return null;
    }
    paramFromServiceMsg = paramToServiceMsg.stStreamInfo;
    StreamData localStreamData = paramToServiceMsg.stStreamData;
    long l = paramToServiceMsg.lKey;
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Long.valueOf(l);
    arrayOfObject[1] = paramFromServiceMsg;
    arrayOfObject[2] = localStreamData;
    arrayOfObject[3] = Long.valueOf(paramToServiceMsg.bubbleID);
    arrayOfObject[4] = Long.valueOf(paramToServiceMsg.subBubbleId);
    arrayOfObject[5] = Long.valueOf(paramToServiceMsg.diyAddonId);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "decodeServerPushStream: iSeq:" + paramToServiceMsg.iSeq + ", lKey: " + l + ", vipBubbleID:" + arrayOfObject[3] + ", subBubbleId:" + arrayOfObject[4] + ", diyAddonId:" + arrayOfObject[5]);
    }
    return arrayOfObject;
  }
  
  private Object N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new byte[paramToServiceMsg.length - 4];
    System.arraycopy(paramToServiceMsg, 4, paramFromServiceMsg, 0, paramToServiceMsg.length - 4);
    return (RequestPushNotify)decodePacket(paramFromServiceMsg, "req_PushNotify", new RequestPushNotify());
  }
  
  private Object O(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvrMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvrMsg", new SvrMsg());
  }
  
  private Object P(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RespGetBlackList)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetBlackList", new RespGetBlackList());
  }
  
  private Object Q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespInsertBlackList localRespInsertBlackList = (RespInsertBlackList)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespInsertBlackList", new RespInsertBlackList());
    paramFromServiceMsg.extraData.putString("insertUin", paramToServiceMsg.extraData.getString("insertUin"));
    paramToServiceMsg = localRespInsertBlackList;
    if (localRespInsertBlackList.stHeader.eReplyCode != 0) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private Object R(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespDeleteBlackList localRespDeleteBlackList = (RespDeleteBlackList)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespDeleteBlackList", new RespDeleteBlackList());
    paramFromServiceMsg.extraData.putString("deleteUin", paramToServiceMsg.extraData.getString("deleteUin"));
    paramToServiceMsg = localRespDeleteBlackList;
    if (localRespDeleteBlackList.stHeader.eReplyCode != 0) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private Object S(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RespClientMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespClientMsg", new RespClientMsg());
  }
  
  private Object T(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcReqPushMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "req", new SvcReqPushMsg());
  }
  
  private Object U(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRequestPushReadedNotify)decodePacket(paramFromServiceMsg.getWupBuffer(), "req", new SvcRequestPushReadedNotify());
  }
  
  private Object V(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (RespTmpChatPicDownload)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespTmpChatPicDownload", new RespTmpChatPicDownload());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private Object W(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponseGetMsgV2)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_GetMsgV2", new SvcResponseGetMsgV2());
    if (paramToServiceMsg != null)
    {
      aivn.gB("Video", "Receive message packet: seq = " + paramFromServiceMsg.getRequestSsoSeq() + " size = " + paramToServiceMsg.vMsgInfos.size());
      return paramToServiceMsg;
    }
    return null;
  }
  
  private Object X(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponseDelMsgV2)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_DelMsgV2", new SvcResponseDelMsgV2());
    if (paramToServiceMsg != null) {
      return paramToServiceMsg;
    }
    return null;
  }
  
  private Object Y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespOffFilePack localRespOffFilePack = (RespOffFilePack)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespOffFilePack", new RespOffFilePack());
    paramToServiceMsg.extraData.getLong("msgTime");
    byte b1 = paramToServiceMsg.extraData.getByte("type");
    paramToServiceMsg.extraData.getString("friendUin");
    if ((localRespOffFilePack == null) || (localRespOffFilePack.iReplyCode != 0))
    {
      paramToServiceMsg = paramFromServiceMsg.extraData;
      if (localRespOffFilePack == null) {}
      for (l1 = 2139062143L;; l1 = localRespOffFilePack.iReplyCode)
      {
        paramToServiceMsg.putLong("ServerReplyCode", l1);
        return null;
      }
    }
    byte b2 = localRespOffFilePack.vBody[0];
    long l1 = aqoj.getLongData(localRespOffFilePack.vBody, 1);
    int i = aqoj.b(localRespOffFilePack.vBody, 5);
    paramFromServiceMsg = new byte[i];
    aqoj.copyData(paramFromServiceMsg, 0, localRespOffFilePack.vBody, 7, i);
    paramFromServiceMsg = aqoj.a(paramFromServiceMsg, 0, i);
    i += 7;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "<<<<decodeGetOffLineFileResp cSubCmd:" + b2);
    }
    long l2;
    long l3;
    long l4;
    long l5;
    byte[] arrayOfByte;
    switch (b2)
    {
    case 4: 
    case 5: 
    default: 
      return null;
    case 1: 
      l2 = aqoj.d(localRespOffFilePack.vBody, i);
      i += 8;
      l3 = aqoj.d(localRespOffFilePack.vBody, i);
      i += 8;
      l4 = aqoj.getLongData(localRespOffFilePack.vBody, i);
      i += 4;
      l5 = aqoj.getLongData(localRespOffFilePack.vBody, i);
      i += 4;
      short s = aqoj.b(localRespOffFilePack.vBody, i);
      j = i + 2;
      i = aqoj.b(localRespOffFilePack.vBody, j);
      j += 2;
      paramToServiceMsg = new byte[i];
      aqoj.copyData(paramToServiceMsg, 0, localRespOffFilePack.vBody, j, paramToServiceMsg.length);
      j += paramToServiceMsg.length;
      i = aqoj.b(localRespOffFilePack.vBody, j);
      j += 2;
      arrayOfByte = new byte[i];
      aqoj.copyData(arrayOfByte, 0, localRespOffFilePack.vBody, j, arrayOfByte.length);
      i = j + arrayOfByte.length;
      byte b3 = localRespOffFilePack.vBody[i];
      i += 1;
      long l6 = aqoj.getLongData(localRespOffFilePack.vBody, i);
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "" + l1 + "|" + l5 + "|" + s + "|" + paramToServiceMsg + "|" + arrayOfByte + "|" + b3);
      }
      return new anbd.a(l1, paramFromServiceMsg, b2, b1, l2, l3, l4, l5, s, paramToServiceMsg, arrayOfByte, b3, l6);
    case 2: 
      return new anbd.a(l1, paramFromServiceMsg, b2, b1);
    case 3: 
      j = localRespOffFilePack.vBody[i];
      i += 1;
      aqoj.b(localRespOffFilePack.vBody, i);
      i += 2;
      aqoj.b(localRespOffFilePack.vBody, i);
      i += 2;
      aqoj.b(localRespOffFilePack.vBody, i);
      i += 2;
      aqoj.b(localRespOffFilePack.vBody, i);
      i += 2;
      j = localRespOffFilePack.vBody[i];
      i += 1;
      l2 = aqoj.getLongData(localRespOffFilePack.vBody, i);
      j = i + 4;
      i = aqoj.b(localRespOffFilePack.vBody, j);
      j += 2;
      aqoj.copyData(new byte[i], 0, localRespOffFilePack.vBody, j, i);
      j += i;
      i = aqoj.b(localRespOffFilePack.vBody, j);
      j += 2;
      arrayOfByte = new byte[i];
      aqoj.copyData(arrayOfByte, 0, localRespOffFilePack.vBody, j, i);
      j += i;
      i = localRespOffFilePack.vBody[j];
      j += 1;
      aqoj.copyData(new byte[i], 0, localRespOffFilePack.vBody, j, i);
      j += i;
      i = localRespOffFilePack.vBody[j];
      j += 1;
      aqoj.copyData(new byte[i], 0, localRespOffFilePack.vBody, j, i);
      j += i;
      i = aqoj.b(localRespOffFilePack.vBody, j);
      j += 2;
      Object localObject = new byte[i];
      aqoj.copyData((byte[])localObject, 0, localRespOffFilePack.vBody, j, i);
      localObject = aqoj.a((byte[])localObject, 0, i);
      i = j + i;
      j = localRespOffFilePack.vBody[i];
      i += 1;
      l3 = aqoj.getLongData(localRespOffFilePack.vBody, i);
      i += 4;
      l4 = aqoj.getLongData(localRespOffFilePack.vBody, i);
      i += 4;
      aqoj.b(localRespOffFilePack.vBody, i);
      i += 2;
      aqoj.getLongData(localRespOffFilePack.vBody, i);
      i += 4;
      l5 = aqoj.getLongData(localRespOffFilePack.vBody, i);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "<<<<decodeGetOffLineFileResp dwUploadTime = " + l5);
      }
      return new anbd.a(l1, paramFromServiceMsg, b2, b1, l2, HexUtil.bytes2HexStr(arrayOfByte), l4, paramToServiceMsg.extraData.getLong("msgTime"), paramToServiceMsg.extraData.getShort("msgSeq"), l3, (String)localObject, paramToServiceMsg.extraData.getLong("delUin"));
    }
    int j = aqoj.b(localRespOffFilePack.vBody, i);
    paramToServiceMsg = new byte[j];
    aqoj.copyData(paramToServiceMsg, 0, localRespOffFilePack.vBody, i + 2, j);
    return new anbd.a(l1, paramFromServiceMsg, b2, b1, paramToServiceMsg);
  }
  
  private Object Z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcResponseSetRoamMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_SetRoamMsg", new SvcResponseSetRoamMsg());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString, long paramLong)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.extraData.putLong("ServerReplyCode", paramLong);
    localFromServiceMsg.setBusinessFail(paramInt, paramInt, paramString);
    try
    {
      if (paramToServiceMsg.actionListener != null) {
        paramToServiceMsg.actionListener.onActionResult(localFromServiceMsg);
      }
      return;
    }
    catch (RemoteException paramToServiceMsg) {}
  }
  
  private Object aa(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcResponseDelRoamMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_DelRoamMsg", new SvcResponseDelRoamMsg());
  }
  
  private Object ab(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (AdMsgInfo)decodePacket(paramFromServiceMsg.getWupBuffer(), "PushADMsg", new AdMsgInfo());
  }
  
  private Object ac(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullGroupMsgSeq)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_PullGroupMsgSeq", new SvcResponsePullGroupMsgSeq());
    if (QLog.isColorLevel()) {
      QLog.d("MessageService", 2, "decodePullGroupMsgNumResp res" + paramToServiceMsg);
    }
    return paramToServiceMsg;
  }
  
  private Object ad(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RequestPushStatus)decodePacket(paramFromServiceMsg.getWupBuffer(), "req_PushStatus", new RequestPushStatus());
  }
  
  private void d(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    a(paramToServiceMsg, 1001, "", paramLong);
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
  
  public Object M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "decodeRespMsg cmd: " + str);
    }
    if ("MessageSvc.PushNotify".equalsIgnoreCase(str)) {
      return N(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.GetMsgV4".equalsIgnoreCase(str)) {
      return W(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.DelMsgV2".equalsIgnoreCase(str)) {
      return X(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("TransService.ReqOffFilePack".equalsIgnoreCase(str)) {
      return Y(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str)) {
      return V(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str)) {
      return Z(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str)) {
      return aa(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ADMsgSvc.PushMsg".equalsIgnoreCase(str)) {
      return ab(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("OnlinePush.ReqPush".equalsIgnoreCase(str)) {
      return T(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.PushReaded".equalsIgnoreCase(str)) {
      return U(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("TransService.ReqGetSign".equalsIgnoreCase(str)) {
      return J(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(str)) {
      return K(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.SendVideoMsg".equalsIgnoreCase(str)) {
      return I(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("StreamSvr.PushStreamMsg".equalsIgnoreCase(str)) {
      return L(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ClientMsg".equals(str)) {
      return S(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ReqInsertBlackList".equals(str)) {
      return Q(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ReqDeleteBlackList".equals(str)) {
      return R(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ReqGetBlackList".equals(str)) {
      return P(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.SvrMsg".equals(str)) {
      return O(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) {
      return ac(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.RequestPushStatus".equalsIgnoreCase(str)) {
      return ad(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public class a
  {
    public long Ol;
    public long akA;
    public long akw;
    public long akx;
    public long aky;
    public long akz;
    public short aq;
    public short ar;
    public byte bx;
    public byte by;
    public String fileName;
    public long fileSize;
    public byte[] fu;
    public byte[] key;
    public String retMsg;
    public long senderUin;
    public long time;
    public long totalSpace;
    public byte type;
    public String url;
    public long usedSpace;
    public byte[] uuid;
    
    public a(long paramLong, String paramString, byte paramByte1, byte paramByte2)
    {
      this.akw = paramLong;
      this.retMsg = paramString;
      this.bx = paramByte1;
      this.type = paramByte2;
    }
    
    public a(long paramLong1, String paramString, byte paramByte1, byte paramByte2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, short paramShort, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte3, long paramLong6)
    {
      this.akw = paramLong1;
      this.retMsg = paramString;
      this.bx = paramByte1;
      this.type = paramByte2;
      this.totalSpace = paramLong2;
      this.usedSpace = paramLong3;
      this.akz = paramLong4;
      this.akA = paramLong5;
      this.ar = paramShort;
      this.uuid = paramArrayOfByte1;
      this.key = paramArrayOfByte2;
      this.by = paramByte3;
      this.Ol = paramLong6;
    }
    
    public a(long paramLong1, String paramString1, byte paramByte1, byte paramByte2, long paramLong2, String paramString2, long paramLong3, long paramLong4, short paramShort, long paramLong5, String paramString3, long paramLong6)
    {
      this.akw = paramLong1;
      this.retMsg = paramString1;
      this.bx = paramByte1;
      this.type = paramByte2;
      this.senderUin = paramLong2;
      this.url = paramString2;
      this.akx = paramLong3;
      this.time = paramLong4;
      this.aq = paramShort;
      this.fileSize = paramLong5;
      this.fileName = paramString3;
      this.aky = paramLong6;
    }
    
    public a(long paramLong, String paramString, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte)
    {
      this.akw = paramLong;
      this.retMsg = paramString;
      this.bx = paramByte1;
      this.type = paramByte2;
      this.fu = paramArrayOfByte;
    }
  }
  
  public class b
  {
    public byte[] vSig;
    public byte[] vkey;
    
    public b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      this.vkey = paramArrayOfByte1;
      this.vSig = paramArrayOfByte2;
    }
  }
  
  public static class c
  {
    public StreamInfo a;
    public short aq;
    public int dEW;
    public String key;
    public int layer;
    
    public c(String paramString, short paramShort, int paramInt1, StreamInfo paramStreamInfo, int paramInt2)
    {
      this.key = paramString;
      this.aq = paramShort;
      this.layer = paramInt1;
      this.a = paramStreamInfo;
      this.dEW = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anbd
 * JD-Core Version:    0.7.0.1
 */