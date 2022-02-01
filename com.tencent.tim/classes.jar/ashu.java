import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;

public class ashu
  extends accg
{
  private long axg;
  private boolean deB;
  private int dkP;
  private byte[] eR;
  private byte[] eS;
  private int emc;
  private String[] fB;
  private Object fK = new Object();
  private Object fL = new Object();
  private int reqSeq;
  
  public ashu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static String V(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    return aQ(localStringBuilder.toString(), paramInt2);
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = this.fK;
        boolean bool1 = bool2;
        if (paramArrayOfByte1 != null) {
          bool1 = bool2;
        }
        try
        {
          if (paramArrayOfByte1.length > 0)
          {
            this.eR = paramArrayOfByte1;
            bool1 = true;
          }
          bool2 = bool1;
          if (paramArrayOfByte2 != null)
          {
            bool2 = bool1;
            if (paramArrayOfByte2.length > 0)
            {
              this.eS = paramArrayOfByte2;
              bool2 = true;
            }
          }
          if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
            break label154;
          }
          this.dkP = 0;
          this.fB = paramArrayOfString;
          bool2 = bool3;
        }
        finally {}
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 2, "saveSrvParam | changed = " + bool2 + " | usingIndex = " + this.dkP);
        }
        return;
      }
      finally {}
      label154:
      if (!bool2) {}
    }
  }
  
  private static String aQ(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    localStringBuffer.append("http://").append(paramString);
    if (paramInt != 80) {
      localStringBuffer.append(":").append(paramInt);
    }
    localStringBuffer.append("/");
    return localStringBuffer.toString();
  }
  
  public String DR()
  {
    synchronized (this.fK)
    {
      Object localObject2 = this.fB;
      if ((localObject2 != null) && (localObject2.length != 0))
      {
        this.dkP %= localObject2.length;
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 2, "getSrvUrl | usingIndex = " + this.dkP + " | count = " + localObject2.length + " | result = " + localObject2[this.dkP]);
        }
        localObject2 = localObject2[this.dkP];
        return localObject2;
      }
      return null;
    }
  }
  
  public boolean a(int paramInt1, MessageMicro<?> arg2, int paramInt2, Object paramObject)
  {
    synchronized (this.fL)
    {
      if (this.deB) {
        return true;
      }
      long l1 = System.currentTimeMillis();
      if (l1 - this.axg > 30000L) {
        this.emc = 0;
      }
      if (this.emc > 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 2, "req get ip too frequently");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 2, "req get ip list");
      }
      long l2;
      try
      {
        l2 = Long.parseLong(this.app.getCurrentAccountUin());
        if (l2 <= 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BigDataGetIpHandler", 2, "uin illegal");
          }
          return false;
        }
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 2, "req get ip list case long fail");
        }
        return false;
      }
      this.axg = l1;
      this.emc += 1;
      this.deB = true;
      paramObject = new subcmd0x501.SubCmd0x501ReqBody();
      paramObject.uint64_uin.set(l2);
      paramObject.uint32_idc_id.set(0);
      paramObject.uint32_appid.set(16);
      paramObject.uint32_login_sig_type.set(1);
      paramObject.uint32_request_flag.set(3);
      Object localObject = new ArrayList();
      ((List)localObject).add(Integer.valueOf(1));
      paramObject.rpt_uint32_service_types.set((List)localObject);
      localObject = new subcmd0x501.ReqBody();
      ((subcmd0x501.ReqBody)localObject).msg_subcmd_0x501_req_body.set(paramObject);
      paramObject = createToServiceMsg("HttpConn.0x6ff_501");
      paramObject.putWupBuffer(((subcmd0x501.ReqBody)localObject).toByteArray());
      paramObject.extraData.putInt("big_data_cmd", paramInt1);
      paramObject.extraData.putInt("big_data_sub_cmd", paramInt2);
      paramInt2 = this.reqSeq;
      this.reqSeq = (paramInt2 + 1);
      paramObject.extraData.putInt("big_data_cmd_seq", paramInt2);
      sendPbReq(paramObject);
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 1, "getIPList " + paramInt1 + " handler: " + getClass().getSimpleName() + " reqSeq = " + this.reqSeq + " curSeq = " + paramInt2);
      }
      return true;
    }
  }
  
  public byte[] ah()
  {
    synchronized (this.fK)
    {
      byte[] arrayOfByte = this.eR;
      return arrayOfByte;
    }
  }
  
  public byte[] ai()
  {
    synchronized (this.fK)
    {
      byte[] arrayOfByte = this.eS;
      return arrayOfByte;
    }
  }
  
  protected void lo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    synchronized (this.fL)
    {
      this.deB = false;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
      {
        i = 1;
        int j = paramToServiceMsg.extraData.getInt("big_data_cmd", -1);
        paramToServiceMsg.extraData.getInt("big_data_sub_cmd", -1);
        int k = paramToServiceMsg.extraData.getInt("big_data_cmd_seq", -1);
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 1, "handleGetIPList " + j + " handler: " + getClass().getSimpleName() + " reqSeq = " + k);
        }
        if (i == 0) {
          break label461;
        }
        if (paramObject == null) {
          break label405;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new subcmd0x501.RspBody();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = (subcmd0x501.SubCmd0x501Rspbody)paramToServiceMsg.msg_subcmd_0x501_rsp_body.get();
        paramToServiceMsg = paramObject.bytes_session_key.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.toByteArray().length <= 0)) {
          break label538;
        }
        paramToServiceMsg = paramToServiceMsg.toByteArray();
        paramFromServiceMsg = paramObject.bytes_httpconn_sig_session.get();
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.toByteArray().length <= 0)) {
          break label533;
        }
        paramFromServiceMsg = paramFromServiceMsg.toByteArray();
        paramObject = paramObject.rpt_msg_httpconn_addrs.get();
        if ((paramObject == null) || (paramObject.size() == 0)) {
          break label528;
        }
        paramObject = paramObject.iterator();
        if (!paramObject.hasNext()) {
          break label528;
        }
        ??? = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)paramObject.next();
        if (((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)???).uint32_service_type.get() != 1) {
          continue;
        }
        ??? = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)???).rpt_msg_addrs.get();
        if ((??? == null) || (((List)???).size() == 0)) {
          break label528;
        }
        paramObject = new String[((List)???).size()];
        i = 0;
        if (i < ((List)???).size())
        {
          subcmd0x501.SubCmd0x501Rspbody.IpAddr localIpAddr = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)???).get(i);
          paramObject[i] = V(localIpAddr.uint32_ip.get(), localIpAddr.uint32_port.get());
          i += 1;
          continue;
          paramToServiceMsg = finally;
          throw paramToServiceMsg;
          i = 0;
          break;
        }
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        notifyUI(2001, true, null);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        label405:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BigDataGetIpHandler", 1, "handleGetIPList fail, because exception", paramToServiceMsg);
        paramToServiceMsg.printStackTrace();
        notifyUI(2001, false, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 1, "handleRefreshGetAllTags fail, because data is null");
      }
      notifyUI(2001, false, null);
      return;
      label461:
      if (paramFromServiceMsg == null) {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 1, "getAllTags handleGetIPList fail, because res is null");
        }
      }
      for (;;)
      {
        notifyUI(2001, false, null);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 1, "getAllTags handleGetIPList fail, because res code: " + paramFromServiceMsg.getResultCode());
        }
      }
      label528:
      paramObject = null;
      continue;
      label533:
      paramFromServiceMsg = null;
      continue;
      label538:
      paramToServiceMsg = null;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return ashx.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("HttpConn.0x6ff_501".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 2, "CMD_GET_IP_LIST");
      }
      lo(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashu
 * JD-Core Version:    0.7.0.1
 */