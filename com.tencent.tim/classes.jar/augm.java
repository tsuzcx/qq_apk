import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.mail.MailPluginRecentMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xac2.oidb_0xac2.ReqBody;
import tencent.im.oidb.cmd0xac3.oidb_0xac3.ReqBody;
import tencent.im.oidb.cmd0xac4.oidb_0xac4.ReqBody;
import tencent.im.oidb.cmd0xac4.oidb_0xac4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0xf6.Submsgtype0xf6.MsgBody;

public class augm
  extends accg
{
  public static String TAG = "MailPluginHandler";
  
  public augm(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void o(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "mailPlugin0xac4, uin=" + paramLong + ", mailAccount=" + paramString);
    }
    Object localObject = new oidb_0xac4.ReqBody();
    if (paramLong != 0L) {
      ((oidb_0xac4.ReqBody)localObject).uint64_uin.set(paramLong);
    }
    if (!TextUtils.isEmpty(paramString)) {
      ((oidb_0xac4.ReqBody)localObject).bytes_mail.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2756);
    paramString.uint32_result.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xac4.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xac4");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).extraData.putInt("0xac4_subtype", paramInt);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void bd(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "mailPluginUnBindMail, uin=" + paramLong + ", mailAccount=" + paramString);
    }
    Object localObject = new oidb_0xac3.ReqBody();
    ((oidb_0xac3.ReqBody)localObject).uint64_uin.set(paramLong);
    ((oidb_0xac3.ReqBody)localObject).bytes_mail.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2755);
    paramString.uint32_result.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xac3.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xac3");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void cd(byte[] paramArrayOfByte)
  {
    try
    {
      Submsgtype0xf6.MsgBody localMsgBody = new Submsgtype0xf6.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (localMsgBody != null)
      {
        paramArrayOfByte = "";
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (localMsgBody.bytes_mail_sender.has()) {
          paramArrayOfByte = localMsgBody.bytes_mail_sender.get().toStringUtf8();
        }
        if (localMsgBody.bytes_mail_sender_nickname.has()) {
          str1 = localMsgBody.bytes_mail_sender_nickname.get().toStringUtf8();
        }
        if (localMsgBody.bytes_mail_to.has()) {
          str2 = localMsgBody.bytes_mail_to.get().toStringUtf8();
        }
        if (localMsgBody.bytes_mail_title.has()) {
          str3 = localMsgBody.bytes_mail_title.get().toStringUtf8();
        }
        if (localMsgBody.bytes_mail_digest.has()) {
          str4 = localMsgBody.bytes_mail_digest.get().toStringUtf8();
        }
        paramArrayOfByte = new MailPluginRecentMsg(paramArrayOfByte, str1, str2, str3, str4);
        ((augo)this.app.getManager(374)).a(paramArrayOfByte, 1);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void lU(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label125;
      }
      int i = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "handleMailPluginBindMail ret=" + i);
      }
      if (i != 0) {
        break label125;
      }
      bool1 = true;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        boolean bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "handleMailPluginBindMail", paramToServiceMsg);
          bool1 = bool2;
          continue;
          bool1 = false;
        }
      }
    }
    notifyUI(1, bool1, null);
  }
  
  public void lV(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label125;
      }
      int i = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "handleMailPluginUnBindMail ret=" + i);
      }
      if (i != 0) {
        break label125;
      }
      bool1 = true;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        boolean bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "handleMailPluginUnBindMail", paramToServiceMsg);
          bool1 = bool2;
          continue;
          bool1 = false;
        }
      }
    }
    notifyUI(2, bool1, null);
  }
  
  public void lW(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramToServiceMsg.extraData.getInt("0xac4_subtype");
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
          break label475;
        }
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "handleMailPlugin0xac4 ret=" + i);
        }
        if ((i != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
          break label475;
        }
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0xac4.RspBody();
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        label437:
        if (!QLog.isColorLevel()) {
          break label475;
        }
        QLog.d(TAG, 2, "handleMailPlugin0xac4", paramToServiceMsg);
        return;
        paramToServiceMsg = paramFromServiceMsg;
        continue;
        continue;
      }
      try
      {
        paramFromServiceMsg = (oidb_0xac4.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "handleMailPlugin0xac4|parseFrom byte InvalidProtocolBufferMicroException");
        paramFromServiceMsg.printStackTrace();
        continue;
        i = paramFromServiceMsg.size();
        continue;
        i = paramToServiceMsg.size();
      }
    }
    if (paramToServiceMsg != null) {
      if (j == 5)
      {
        bool = false;
        if (paramToServiceMsg.uint64_has_binding.has()) {
          if (paramToServiceMsg.uint64_has_binding.get() != 1L) {
            break label476;
          }
        }
      }
    }
    label467:
    label472:
    label475:
    label476:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "handleMailPlugin0xac4|uint64_has_binding = " + paramToServiceMsg.uint64_has_binding.get());
      }
      notifyUI(5, true, Boolean.valueOf(bool));
      if (j == 3)
      {
        paramFromServiceMsg = new ArrayList();
        if (!paramToServiceMsg.rpt_msg_mail_info.has()) {
          break label472;
        }
        paramFromServiceMsg = paramToServiceMsg.rpt_msg_mail_info.get();
        if (QLog.isColorLevel())
        {
          paramObject = TAG;
          StringBuilder localStringBuilder = new StringBuilder().append("handleMailPlugin0xac4|rpt_msg_mail_info = ");
          if (paramFromServiceMsg == null)
          {
            i = 0;
            QLog.d(paramObject, 2, i);
          }
        }
        else
        {
          notifyUI(3, true, paramFromServiceMsg);
        }
      }
      else
      {
        if (j != 4) {
          break label475;
        }
        paramFromServiceMsg = new ArrayList();
        if (!paramToServiceMsg.rpt_msg_uin_info.has()) {
          break label467;
        }
        paramToServiceMsg = paramToServiceMsg.rpt_msg_uin_info.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = TAG;
          paramObject = new StringBuilder().append("handleMailPlugin0xac4|rpt_msg_uin_info = ");
          if (paramToServiceMsg != null) {
            break label437;
          }
          i = 0;
          QLog.d(paramFromServiceMsg, 2, i);
        }
        notifyUI(4, true, paramToServiceMsg);
        return;
      }
      return;
    }
  }
  
  public void n(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "mailPluginBindMail, uin=" + paramLong + ", mailAccount=" + paramString + ", mailType" + paramInt);
    }
    Object localObject = new oidb_0xac2.ReqBody();
    ((oidb_0xac2.ReqBody)localObject).uint64_uin.set(paramLong);
    ((oidb_0xac2.ReqBody)localObject).bytes_mail.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_0xac2.ReqBody)localObject).uint64_mail_type.set(paramInt);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2754);
    paramString.uint32_result.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xac2.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xac2");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void nt(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "mailPluginGetBindRelation, uin=" + paramLong);
    }
    if (paramLong <= 0L) {
      return;
    }
    o(paramLong, null, 3);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return augr.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    boolean bool = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onReceive, cmd=" + str + ", isSucc=" + bool);
    }
    if ("OidbSvc.0xac2".equals(str)) {
      lU(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.0xac3".equals(str))
      {
        lV(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xac4".equals(str));
    lW(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augm
 * JD-Core Version:    0.7.0.1
 */