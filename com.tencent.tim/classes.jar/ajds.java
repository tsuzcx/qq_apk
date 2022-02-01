import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.ConfirmQrReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.ConfirmQrRsp;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.GetQrReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.GetQrRsp;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.QueryStateReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.QueryStateRsp;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.RejectQrReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.ReqBody;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.RspBody;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.UserData;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.VerifyTokenReq;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetDecryptKeyReq;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetDecryptKeyRsp;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetEncrptkeyReq;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetEncryptKeyRsp;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.ReqBody;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ajds
  extends accg
{
  public ajds(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(String paramString, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int j = -1;
    int i = j;
    if (paramOIDBSSOPkg != null)
    {
      i = j;
      if (paramOIDBSSOPkg.uint32_result.has())
      {
        j = paramOIDBSSOPkg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyReq result=" + j);
          i = j;
        }
      }
    }
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      localObject = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcde.RspBody();
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        paramOIDBSSOPkg.mergeFrom((byte[])localObject);
        if (paramOIDBSSOPkg.get_decrypt_key_rsp.has())
        {
          localObject = (oidb_cmd0xcde.GetDecryptKeyRsp)paramOIDBSSOPkg.get_decrypt_key_rsp.get();
          if (((oidb_cmd0xcde.GetDecryptKeyRsp)localObject).dncrypt_key.has())
          {
            localObject = ((oidb_cmd0xcde.GetDecryptKeyRsp)localObject).dncrypt_key.get().toStringUtf8();
            ajee.fY.put(paramString, localObject);
            if (QLog.isDevelopLevel()) {
              QLog.d("MsgBackup.MsgBackupAuthHandler", 4, "GetDecryptKeyReq decryptKey=" + (String)localObject + "encrytKey = " + paramOIDBSSOPkg.get_encrypt_key_rsp);
            }
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
        }
      }
    }
    QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyReq error ");
  }
  
  private void a(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int j = -1;
    int i = j;
    if (paramOIDBSSOPkg != null)
    {
      i = j;
      if (paramOIDBSSOPkg.uint32_result.has())
      {
        j = paramOIDBSSOPkg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processRejectQrRsp result=" + j);
          i = j;
        }
      }
    }
    if (i == 0)
    {
      notifyUI(5, true, null);
      return;
    }
    notifyUI(5, false, null);
  }
  
  private void b(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int j = -1;
    int i = j;
    if (paramOIDBSSOPkg != null)
    {
      i = j;
      if (paramOIDBSSOPkg.uint32_result.has())
      {
        j = paramOIDBSSOPkg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processQueryStateRsp result=" + j);
          i = j;
        }
      }
    }
    Object localObject;
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      localObject = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcdd.RspBody();
    }
    try
    {
      paramOIDBSSOPkg.mergeFrom((byte[])localObject);
      if (paramOIDBSSOPkg.query_state_rsp.has())
      {
        localObject = new ajev.a();
        paramOIDBSSOPkg = (oidb_cmd0xcdd.QueryStateRsp)paramOIDBSSOPkg.query_state_rsp.get();
        if (paramOIDBSSOPkg.state.has())
        {
          i = paramOIDBSSOPkg.state.get();
          ((ajev.a)localObject).a(i);
          if (i == 2)
          {
            if (paramOIDBSSOPkg.token.has()) {
              ((ajev.a)localObject).a(paramOIDBSSOPkg.token.get().toStringUtf8());
            }
            if (paramOIDBSSOPkg.encrypt_key.has()) {
              ((ajev.a)localObject).b(paramOIDBSSOPkg.encrypt_key.get().toStringUtf8());
            }
            if (paramOIDBSSOPkg.user_data.has()) {
              ((ajev.a)localObject).a(a((oidb_cmd0xcdd.UserData)paramOIDBSSOPkg.user_data.get()));
            }
            if (paramOIDBSSOPkg.biz_type.has()) {
              ((ajev.a)localObject).b(paramOIDBSSOPkg.biz_type.get());
            }
          }
        }
        notifyUI(4, true, ((ajev.a)localObject).a());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
      }
      notifyUI(4, false, null);
    }
  }
  
  private void c(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int j = -1;
    int i = j;
    if (paramOIDBSSOPkg != null)
    {
      i = j;
      if (paramOIDBSSOPkg.uint32_result.has())
      {
        j = paramOIDBSSOPkg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processVerifyTokenRsp result=" + j);
          i = j;
        }
      }
    }
    if (i == 0)
    {
      notifyUI(3, true, null);
      return;
    }
    notifyUI(3, false, null);
  }
  
  private void d(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int j = -1;
    int i = j;
    if (paramOIDBSSOPkg != null)
    {
      i = j;
      if (paramOIDBSSOPkg.uint32_result.has())
      {
        j = paramOIDBSSOPkg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp result=" + j);
          i = j;
        }
      }
    }
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      localObject = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcde.RspBody();
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        paramOIDBSSOPkg.mergeFrom((byte[])localObject);
        if (paramOIDBSSOPkg.get_encrypt_key_rsp.has())
        {
          paramOIDBSSOPkg = (oidb_cmd0xcde.GetEncryptKeyRsp)paramOIDBSSOPkg.get_encrypt_key_rsp.get();
          if (paramOIDBSSOPkg.encrypt_key.has())
          {
            localObject = paramOIDBSSOPkg.encrypt_key.get().toStringUtf8();
            ajee.bQS = (String)localObject;
            if (QLog.isDevelopLevel()) {
              QLog.d("MsgBackup.MsgBackupAuthHandler", 4, "GetEncryptKeyRsp encryptKey=" + (String)localObject);
            }
          }
          if (paramOIDBSSOPkg.file_meta.has())
          {
            paramOIDBSSOPkg = paramOIDBSSOPkg.file_meta.get().toStringUtf8();
            ajee.bQR = paramOIDBSSOPkg;
            if (QLog.isDevelopLevel()) {
              QLog.d("MsgBackup.MsgBackupAuthHandler", 4, "GetEncryptKeyRsp fileMeta=" + paramOIDBSSOPkg);
            }
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
        }
      }
    }
    QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp error ");
  }
  
  private void e(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int j = -1;
    int i = j;
    if (paramOIDBSSOPkg != null)
    {
      i = j;
      if (paramOIDBSSOPkg.uint32_result.has())
      {
        j = paramOIDBSSOPkg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processConfirmQrRsp result=" + j);
          i = j;
        }
      }
    }
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      Object localObject = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcdd.RspBody();
      try
      {
        paramOIDBSSOPkg.mergeFrom((byte[])localObject);
        if (paramOIDBSSOPkg.confirm_qr_rsp.has())
        {
          localObject = new ajeo.a();
          paramOIDBSSOPkg = (oidb_cmd0xcdd.ConfirmQrRsp)paramOIDBSSOPkg.confirm_qr_rsp.get();
          if (paramOIDBSSOPkg.token.has()) {
            ((ajeo.a)localObject).a(paramOIDBSSOPkg.token.get().toStringUtf8());
          }
          if (paramOIDBSSOPkg.encrypt_key.has()) {
            ((ajeo.a)localObject).b(paramOIDBSSOPkg.encrypt_key.get().toStringUtf8());
          }
          if (paramOIDBSSOPkg.user_data.has()) {
            ((ajeo.a)localObject).a(a((oidb_cmd0xcdd.UserData)paramOIDBSSOPkg.user_data.get()));
          }
          if (paramOIDBSSOPkg.biz_type.has()) {
            ((ajeo.a)localObject).a(paramOIDBSSOPkg.biz_type.get());
          }
          paramOIDBSSOPkg = ((ajeo.a)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "processGetQrRsp getQrResponse= " + paramOIDBSSOPkg);
          }
          ajgt.dxs();
          ajgt.a.cos = true;
          ajgt.a.errorCode = 0;
          notifyUI(2, true, paramOIDBSSOPkg);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
        }
      }
    }
    ajgt.dxs();
    ajgt.a.cos = false;
    ajgt.a.errorCode = i;
    notifyUI(2, false, Integer.valueOf(i));
  }
  
  private void f(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int j = -1;
    int i = j;
    if (paramOIDBSSOPkg != null)
    {
      i = j;
      if (paramOIDBSSOPkg.uint32_result.has())
      {
        j = paramOIDBSSOPkg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processGetQrRsp result=" + j);
          i = j;
        }
      }
    }
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      Object localObject = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcdd.RspBody();
      try
      {
        paramOIDBSSOPkg.mergeFrom((byte[])localObject);
        if (paramOIDBSSOPkg.get_qr_rsp.has())
        {
          localObject = new ajer.a();
          paramOIDBSSOPkg = (oidb_cmd0xcdd.GetQrRsp)paramOIDBSSOPkg.get_qr_rsp.get();
          if (paramOIDBSSOPkg.qr_sig.has()) {
            ((ajer.a)localObject).a(paramOIDBSSOPkg.qr_sig.get().toStringUtf8());
          }
          if (paramOIDBSSOPkg.token.has()) {
            ((ajer.a)localObject).b(paramOIDBSSOPkg.token.get().toStringUtf8());
          }
          if (paramOIDBSSOPkg.encrypt_key.has()) {
            ((ajer.a)localObject).c(paramOIDBSSOPkg.encrypt_key.get().toStringUtf8());
          }
          if (paramOIDBSSOPkg.user_data.has()) {
            ((ajer.a)localObject).a(a((oidb_cmd0xcdd.UserData)paramOIDBSSOPkg.user_data.get()));
          }
          if (paramOIDBSSOPkg.biz_type.has()) {
            ((ajer.a)localObject).a(paramOIDBSSOPkg.biz_type.get());
          }
          paramOIDBSSOPkg = ((ajer.a)localObject).b();
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "processGetQrRsp getQrResponse= " + paramOIDBSSOPkg);
          }
          ajgt.dxs();
          ajgt.a.cos = true;
          ajgt.a.errorCode = 0;
          notifyUI(1, true, paramOIDBSSOPkg);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
        }
      }
    }
    ajgt.dxs();
    ajgt.a.cos = false;
    ajgt.a.errorCode = i;
    notifyUI(1, false, Integer.valueOf(i));
  }
  
  public void Mo(String paramString)
  {
    Object localObject = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.VerifyTokenReq localVerifyTokenReq = new oidb_cmd0xcdd.VerifyTokenReq();
    localVerifyTokenReq.token.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_cmd0xcdd.ReqBody)localObject).verify_token_req.set(localVerifyTokenReq);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(3293);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(3);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcdd.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xcdd");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void Mp(String paramString)
  {
    Object localObject1 = new oidb_cmd0xcde.ReqBody();
    Object localObject2 = new oidb_cmd0xcde.GetDecryptKeyReq();
    ((oidb_cmd0xcde.GetDecryptKeyReq)localObject2).file_meta.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_cmd0xcde.ReqBody)localObject1).get_decrypt_key_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3294);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(2);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcde.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xcde");
    ((ToServiceMsg)localObject1).extraData.putString("req_key_file_meta", paramString);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(15000L);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void Mq(String paramString)
  {
    Object localObject = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.QueryStateReq localQueryStateReq = new oidb_cmd0xcdd.QueryStateReq();
    localQueryStateReq.qr_sig.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_cmd0xcdd.ReqBody)localObject).query_state_req.set(localQueryStateReq);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(3293);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(4);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcdd.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xcdd");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public MsgBackupUserData a(oidb_cmd0xcdd.UserData paramUserData)
  {
    MsgBackupUserData.a locala = new MsgBackupUserData.a();
    if (paramUserData.ip.has()) {
      locala.a(paramUserData.ip.get().toStringUtf8());
    }
    if (paramUserData.port.has()) {
      locala.a(paramUserData.port.get());
    }
    if (paramUserData.ssid.has()) {
      locala.b(paramUserData.ssid.get().toStringUtf8());
    }
    if (paramUserData.bssid.has()) {
      locala.c(paramUserData.bssid.get().toStringUtf8());
    }
    return locala.b();
  }
  
  public void a(MsgBackupUserData paramMsgBackupUserData, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "getQrRequest called: userdata = " + paramMsgBackupUserData + ", ispush = " + paramBoolean);
    }
    oidb_cmd0xcdd.ReqBody localReqBody = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.GetQrReq localGetQrReq = new oidb_cmd0xcdd.GetQrReq();
    localGetQrReq.push.set(paramBoolean);
    oidb_cmd0xcdd.UserData localUserData = new oidb_cmd0xcdd.UserData();
    localUserData.ip.set(ByteStringMicro.copyFromUtf8(paramMsgBackupUserData.getIp()));
    localUserData.port.set(paramMsgBackupUserData.fE());
    Object localObject = paramMsgBackupUserData.getSsid();
    PBBytesField localPBBytesField = localUserData.ssid;
    if (localObject != null)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = paramMsgBackupUserData.getBssid();
      localPBBytesField = localUserData.bssid;
      if (localObject == null) {
        break label297;
      }
    }
    for (;;)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localUserData.platform.set(paramMsgBackupUserData.getPlatform());
      localGetQrReq.user_data.set(localUserData);
      localGetQrReq.biz_type.set(paramInt);
      localReqBody.get_qr_req.set(localGetQrReq);
      paramMsgBackupUserData = new oidb_sso.OIDBSSOPkg();
      paramMsgBackupUserData.uint32_command.set(3293);
      paramMsgBackupUserData.uint32_result.set(0);
      paramMsgBackupUserData.uint32_service_type.set(1);
      paramMsgBackupUserData.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      localObject = createToServiceMsg("OidbSvc.0xcdd");
      ((ToServiceMsg)localObject).putWupBuffer(paramMsgBackupUserData.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("MsgBackup_request_type", Integer.valueOf(1));
      sendPbReq((ToServiceMsg)localObject);
      return;
      localObject = "";
      break;
      label297:
      localObject = "";
    }
  }
  
  public void a(MsgBackupUserData paramMsgBackupUserData, String paramString, int paramInt)
  {
    oidb_cmd0xcdd.ReqBody localReqBody = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.ConfirmQrReq localConfirmQrReq = new oidb_cmd0xcdd.ConfirmQrReq();
    localConfirmQrReq.qr_sig.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new oidb_cmd0xcdd.UserData();
    paramString.ip.set(ByteStringMicro.copyFromUtf8(paramMsgBackupUserData.getIp()));
    paramString.port.set(paramMsgBackupUserData.fE());
    if (paramMsgBackupUserData.getSsid() != null) {
      paramString.ssid.set(ByteStringMicro.copyFromUtf8(paramMsgBackupUserData.getSsid()));
    }
    if (paramMsgBackupUserData.getBssid() != null) {
      paramString.bssid.set(ByteStringMicro.copyFromUtf8(paramMsgBackupUserData.getBssid()));
    }
    paramString.platform.set(paramMsgBackupUserData.getPlatform());
    localConfirmQrReq.user_data.set(paramString);
    localConfirmQrReq.biz_type.set(paramInt);
    localReqBody.confirm_qr_req.set(localConfirmQrReq);
    paramMsgBackupUserData = new oidb_sso.OIDBSSOPkg();
    paramMsgBackupUserData.uint32_command.set(3293);
    paramMsgBackupUserData.uint32_result.set(0);
    paramMsgBackupUserData.uint32_service_type.set(2);
    paramMsgBackupUserData.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString = createToServiceMsg("OidbSvc.0xcdd");
    paramString.putWupBuffer(paramMsgBackupUserData.toByteArray());
    sendPbReq(paramString);
  }
  
  public void dwr()
  {
    Object localObject1 = new oidb_cmd0xcde.ReqBody();
    Object localObject2 = new oidb_cmd0xcde.GetEncrptkeyReq();
    ((oidb_cmd0xcde.ReqBody)localObject1).get_encrypt_key_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3294);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcde.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xcde");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void fj(String paramString, int paramInt)
  {
    Object localObject = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.RejectQrReq localRejectQrReq = new oidb_cmd0xcdd.RejectQrReq();
    localRejectQrReq.qr_sig.set(ByteStringMicro.copyFromUtf8(paramString));
    localRejectQrReq.biz_type.set(paramInt);
    ((oidb_cmd0xcdd.ReqBody)localObject).reject_qr_req.set(localRejectQrReq);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(3293);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(5);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcdd.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xcdd");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xcdd");
      this.allowCmdSet.add("OidbSvc.0xcde");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return ajdu.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "MsgBackupAuthHandler cmd=" + paramFromServiceMsg.getServiceCmd() + ", isSuccess = " + paramFromServiceMsg.isSuccess() + ", resultcode = " + paramFromServiceMsg.getResultCode());
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label107:
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label107;
                break label107;
                break label107;
                break label107;
                do
                {
                  return;
                } while ((!"OidbSvc.0xcdd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"OidbSvc.0xcde".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())));
                if (!paramFromServiceMsg.isSuccess()) {
                  break label331;
                }
                oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
                try
                {
                  paramObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])paramObject);
                  i = paramObject.uint32_service_type.get();
                  if (!"OidbSvc.0xcdd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
                    break;
                  }
                  if (i == 1)
                  {
                    f(paramObject);
                    return;
                  }
                }
                catch (InvalidProtocolBufferMicroException paramObject)
                {
                  for (;;)
                  {
                    QLog.w("MsgBackup.MsgBackupAuthHandler", 4, paramObject.getMessage(), paramObject);
                    paramObject = localOIDBSSOPkg;
                  }
                }
                catch (Exception paramObject)
                {
                  for (;;)
                  {
                    QLog.w("MsgBackup.MsgBackupAuthHandler", 4, paramObject.getMessage(), paramObject);
                    paramObject = localOIDBSSOPkg;
                  }
                  if (i == 2)
                  {
                    e(paramObject);
                    return;
                  }
                  if (i == 3)
                  {
                    c(paramObject);
                    return;
                  }
                  if (i == 4)
                  {
                    b(paramObject);
                    return;
                  }
                }
              } while (i != 5);
              a(paramObject);
              return;
            } while (!"OidbSvc.0xcde".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
            if (i == 1)
            {
              d(paramObject);
              return;
            }
          } while (i != 2);
          a(paramToServiceMsg.extraData.getString("req_key_file_meta"), paramObject);
          return;
          paramToServiceMsg = paramToServiceMsg.getAttribute("MsgBackup_request_type");
        } while (!(paramToServiceMsg instanceof Integer));
        i = ((Integer)paramToServiceMsg).intValue();
        if (!"OidbSvc.0xcdd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
      } while (i != 1);
      f(null);
      return;
    } while (!"OidbSvc.0xcde".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    label331:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajds
 * JD-Core Version:    0.7.0.1
 */