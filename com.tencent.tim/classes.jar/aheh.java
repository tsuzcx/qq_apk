import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aheh
  extends accg
{
  public aheh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void jx(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "handleReqSetSwitch ");
    }
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          int i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 2, "handleReqSetSwitch ret=" + i);
          }
          if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            i = paramFromServiceMsg.length;
            boolean bool2 = true;
            bool1 = bool2;
            if (4 > i) {
              break label215;
            }
            paramFromServiceMsg = String.valueOf(aqoj.getLongData(paramFromServiceMsg, 0));
            if (paramFromServiceMsg != null)
            {
              bool1 = bool2;
              if (paramFromServiceMsg.equals(this.app.getAccount())) {
                break label215;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.w("FlashChat", 2, "handleReqSetSwitch uin error");
            }
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    label215:
    paramToServiceMsg.extraData.getByte("lightalk_switch", (byte)0).byteValue();
    if (bool1) {}
    notifyUI(2, bool1, null);
  }
  
  public void jw(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      paramFromServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label348;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (Exception paramToServiceMsg)
    {
      long l;
      int j;
      while (QLog.isColorLevel())
      {
        QLog.d("FlashChat", 2, "handleReqGetSwitch exception: " + paramToServiceMsg.getMessage());
        return;
        label348:
        i = -1;
        continue;
        label354:
        i = 0;
      }
    }
    if (i == 0)
    {
      l = paramFromServiceMsg.getInt();
      paramFromServiceMsg.get();
      j = paramFromServiceMsg.getShort();
      if (!QLog.isColorLevel()) {
        break label354;
      }
      QLog.d("FlashChat", 2, "handleReqGetSwitch, request success, tlvCount = " + j + " uin:" + Long.valueOf(l));
    }
    for (;;)
    {
      if ((paramFromServiceMsg.hasRemaining()) && (i < j))
      {
        int k = paramFromServiceMsg.getShort();
        int m = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "handleReqGetSwitch, TLV type: " + k + ",legnth: " + m);
        }
        if (k == -25184)
        {
          i = paramFromServiceMsg.getShort();
          if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 2, "handleReqGetSwitch switchValue" + i);
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label361;
          }
          QLog.i("FlashChat", 2, "handleReqGetSwitch" + k);
          break label361;
          if (QLog.isColorLevel())
          {
            QLog.d("FlashChat", 2, "handleReqGetSwitch" + i);
            return;
          }
        }
      }
      return;
      label361:
      i += 1;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x4ff_9");
      this.allowCmdSet.add("OidbSvc.0x480_9");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aheg.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!"OidbSvc.0x4ff_9".equals(str)) {
          break;
        }
      } while (!paramToServiceMsg.extraData.getBoolean("FlashChatHanlder", false));
      jx(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while ((!"OidbSvc.0x480_9".equals(str)) || (!paramToServiceMsg.extraData.getBoolean("FlashChatHanlder", false)));
    jw(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aheh
 * JD-Core Version:    0.7.0.1
 */