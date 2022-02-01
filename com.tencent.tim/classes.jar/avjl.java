import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardDataWireReqBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardDataWireRspBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardGroupReqBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardGroupRspBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardOfflineFileReqBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardOfflineFileRspBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ReqBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class avjl
  extends accg
{
  public avjl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private oidb_cmd0xd68.ForwardDataWireReqBody a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, long paramLong)
  {
    oidb_cmd0xd68.ForwardDataWireReqBody localForwardDataWireReqBody = new oidb_cmd0xd68.ForwardDataWireReqBody();
    localForwardDataWireReqBody.uint64_dst_uin.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    localForwardDataWireReqBody.uint32_src_svcid.set(236);
    localForwardDataWireReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localForwardDataWireReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localForwardDataWireReqBody.bytes_src_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    localForwardDataWireReqBody.uint32_client_type.set(2);
    localForwardDataWireReqBody.cid.set(paramString4);
    localForwardDataWireReqBody.str_file_name.set(paramString5);
    localForwardDataWireReqBody.uint64_file_size.set(paramLong);
    boolean bool = ahbj.fileExistsAndNotEmpty(paramString1);
    if ((TextUtils.isEmpty(paramString5)) && (bool))
    {
      localForwardDataWireReqBody.str_file_name.set(ahbj.getFileNameNoEx(paramString1));
      localForwardDataWireReqBody.uint64_file_size.set(ahbj.getFileSize(paramString1));
    }
    return localForwardDataWireReqBody;
  }
  
  private oidb_cmd0xd68.ForwardGroupReqBody a(long paramLong1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, long paramLong2)
  {
    oidb_cmd0xd68.ForwardGroupReqBody localForwardGroupReqBody = new oidb_cmd0xd68.ForwardGroupReqBody();
    localForwardGroupReqBody.uint64_group_code.set(paramLong1);
    localForwardGroupReqBody.uint32_app_id.set(AppSetting.getAppId());
    localForwardGroupReqBody.uint32_src_bus_id.set(236);
    localForwardGroupReqBody.bytes_dst_folder_id.set(ByteStringMicro.copyFrom("/".getBytes()));
    localForwardGroupReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localForwardGroupReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localForwardGroupReqBody.bytes_src_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    paramString3 = localForwardGroupReqBody.str_file_name;
    paramString2 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString2 = "";
    }
    paramString3.set(paramString2);
    localForwardGroupReqBody.uint64_file_size.set(paramLong2);
    localForwardGroupReqBody.cid.set(paramString4);
    if (!TextUtils.isEmpty(paramString1)) {
      localForwardGroupReqBody.str_local_path.set(paramString1);
    }
    return localForwardGroupReqBody;
  }
  
  private oidb_cmd0xd68.ForwardOfflineFileReqBody a(long paramLong1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, long paramLong2)
  {
    oidb_cmd0xd68.ForwardOfflineFileReqBody localForwardOfflineFileReqBody = new oidb_cmd0xd68.ForwardOfflineFileReqBody();
    localForwardOfflineFileReqBody.uint64_dst_uin.set(paramLong1);
    localForwardOfflineFileReqBody.uint32_src_svcid.set(236);
    localForwardOfflineFileReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localForwardOfflineFileReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localForwardOfflineFileReqBody.bytes_src_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    localForwardOfflineFileReqBody.uint32_client_type.set(2);
    localForwardOfflineFileReqBody.cid.set(paramString4);
    paramString2 = localForwardOfflineFileReqBody.str_file_name;
    paramString1 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString1 = "";
    }
    paramString2.set(paramString1);
    localForwardOfflineFileReqBody.uint64_file_size.set(paramLong2);
    return localForwardOfflineFileReqBody;
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QfavFileForwardHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xd68.RspBody paramRspBody)
  {
    if (paramRspBody.forward_group_rsp == null) {}
    long l;
    TroopFileTransferManager localTroopFileTransferManager;
    do
    {
      return;
      l = ((Long)paramToServiceMsg.getAttribute("sessionId")).longValue();
      paramToServiceMsg = this.app.a().b(l);
      if (paramToServiceMsg == null)
      {
        QLog.e("QfavFileForwardHandler", 4, "handleGroupRsp fileManagerEntity is null");
        return;
      }
      localTroopFileTransferManager = TroopFileTransferManager.a(this.app, Long.parseLong(paramToServiceMsg.peerUin));
    } while (localTroopFileTransferManager == null);
    wte.a().h(this.app, paramToServiceMsg.msgSeq);
    String str = new String(paramRspBody.forward_group_rsp.bytes_save_file_path.get().toByteArray());
    localTroopFileTransferManager.a(l, UUID.fromString(paramToServiceMsg.strTroopFileUuid), null, paramRspBody.forward_group_rsp.int32_ret_code.get(), str, paramRspBody.forward_group_rsp.str_ret_msg.get());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, oidb_cmd0xd68.RspBody paramRspBody)
  {
    if (paramRspBody.forward_offline_rsp == null) {}
    do
    {
      return;
      long l = ((Long)paramToServiceMsg.getAttribute("sessionId")).longValue();
      paramToServiceMsg = this.app.a().b(l);
    } while (paramToServiceMsg == null);
    int j = paramRspBody.forward_offline_rsp.int32_ret_code.get();
    String str = paramRspBody.forward_offline_rsp.str_ret_msg.get();
    if (j == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (paramToServiceMsg.status != 2)
      {
        paramToServiceMsg.status = 1005;
        this.app.a().u(paramToServiceMsg);
      }
      QLog.e("QfavFileForwardHandler", 1, "Id[" + paramToServiceMsg.nSessionId + "]wk,handleOfflineRsp-->failed ret_code:" + j);
      this.app.a().a(paramToServiceMsg.uniseq, paramToServiceMsg.nSessionId, paramToServiceMsg.peerUin, paramToServiceMsg.peerType, 15, null, j, str);
      return;
    }
    paramToServiceMsg.Uuid = new String(paramRspBody.forward_offline_rsp.bytes_uuid.get().toByteArray());
    paramToServiceMsg.setCloudType(1);
    paramToServiceMsg.status = 1;
    paramToServiceMsg.isReaded = false;
    paramToServiceMsg.bSend = true;
    paramToServiceMsg.fProgress = 0.0F;
    paramToServiceMsg.bOnceSuccess = true;
    this.app.a().dhl();
    this.app.a().u(paramToServiceMsg);
    paramToServiceMsg.status = 2;
    ahav.jR(paramToServiceMsg.nSessionId);
    QLog.i("QfavFileForwardHandler", 2, "=_= ^ [CS Replay]->[CC] Id[" + paramToServiceMsg.nSessionId + "]sendFavFile2Offline onSucceed, entity thumbSize(" + paramToServiceMsg.imgHeight + ":" + paramToServiceMsg.imgWidth + ")");
    if (paramToServiceMsg.peerType == 3000)
    {
      QLog.i("QfavFileForwardHandler", 2, "=_= ^ [Disc Feed]sendDiscFileFeed[" + paramToServiceMsg.nSessionId + "]");
      this.app.a().a(paramToServiceMsg.nSessionId, paramToServiceMsg.peerUin, this.app.getCurrentAccountUin(), paramToServiceMsg.fileName, paramToServiceMsg.fileSize, paramToServiceMsg.Uuid, paramToServiceMsg.uniseq, paramToServiceMsg.msgUid, null);
    }
    for (;;)
    {
      this.app.a().a(paramToServiceMsg, 10, "");
      paramRspBody = new ahau.a();
      paramRspBody.bJE = "send_file_suc";
      paramRspBody.cYX = 1;
      ahau.a(this.app.getCurrentAccountUin(), paramRspBody);
      ahav.a(this.app, paramToServiceMsg);
      return;
      paramRspBody = paramToServiceMsg.peerUin.replace("+", "");
      QLog.i("QfavFileForwardHandler", 2, "=_= ^ [Offline CC]sendC2COfflineFileMsg[" + paramToServiceMsg.nSessionId + "]");
      this.app.a().a(paramRspBody, paramToServiceMsg, null);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, oidb_cmd0xd68.RspBody paramRspBody)
  {
    if (paramRspBody.forward_data_wire_rsp == null) {}
    do
    {
      Object localObject;
      do
      {
        return;
        long l = ((Long)paramToServiceMsg.getAttribute("sessionId")).longValue();
        localObject = new String(paramRspBody.forward_data_wire_rsp.bytes_uuid.get().toByteArray());
        paramToServiceMsg = (acde)this.app.getBusinessHandler(8);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramToServiceMsg.OnSessionComplete(l, 0, -999);
          return;
        }
        int i = DataLineMsgRecord.getDevTypeBySeId(l);
        paramRspBody = this.app.b().a(i).a(l);
      } while (paramRspBody == null);
      paramRspBody.serverPath = ((String)localObject);
      paramRspBody.nOpType = 1;
      paramRspBody.bIsSended = true;
      paramRspBody.bIsTransfering = false;
      if (paramRspBody.entityID != 0L)
      {
        localObject = this.app.a().b(paramRspBody.entityID);
        if (localObject != null)
        {
          ((FileManagerEntity)localObject).status = 1;
          ((FileManagerEntity)localObject).Uuid = paramRspBody.serverPath;
        }
      }
    } while (!paramToServiceMsg.c(paramRspBody));
    paramToServiceMsg.e(paramRspBody);
  }
  
  public void a(int paramInt, long paramLong1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, long paramLong2, long paramLong3)
  {
    oidb_cmd0xd68.ReqBody localReqBody = new oidb_cmd0xd68.ReqBody();
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      localReqBody.forward_group_req.set(a(paramLong1, paramString1, paramString2, paramString3, paramArrayOfByte, paramString4, paramString5, paramLong2));
    }
    for (;;)
    {
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(3432);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(paramInt);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramString2 = createToServiceMsg("OidbSvc.0xd68");
      paramString2.putWupBuffer(paramString1.toByteArray());
      paramString2.addAttribute("sessionId", Long.valueOf(paramLong3));
      sendPbReq(paramString2);
      return;
      localReqBody.forward_offline_req.set(a(paramLong1, paramString1, paramString2, paramString3, paramArrayOfByte, paramString4, paramString5, paramLong2));
      continue;
      localReqBody.forward_data_wire_req.set(a(paramString1, paramString2, paramString3, paramArrayOfByte, paramString4, paramString5, paramLong2));
    }
  }
  
  public void a(int paramInt, FileManagerEntity paramFileManagerEntity, long paramLong)
  {
    String str2 = paramFileManagerEntity.strFavFileId;
    if (TextUtils.isEmpty(str2))
    {
      QLog.e("QfavFileForwardHandler", 2, "forward " + paramInt + " strFavFileId is Empty!");
      return;
    }
    String str1 = str2.substring(0, str2.indexOf('/'));
    str2 = str2.substring(str2.indexOf('/'));
    a(paramInt, paramLong, paramFileManagerEntity.getFilePath(), str1, str2, HexUtil.hexStr2Bytes(paramFileManagerEntity.strFileMd5), paramFileManagerEntity.strFavId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId);
  }
  
  public void a(int paramInt, FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2)
  {
    String str2 = paramFileManagerEntity.strFavFileId;
    String str1 = str2.substring(0, str2.indexOf('/'));
    str2 = str2.substring(str2.indexOf('/'));
    a(paramInt, paramLong1, paramFileManagerEntity.getFilePath(), str1, str2, HexUtil.hexStr2Bytes(paramFileManagerEntity.strFileMd5), paramFileManagerEntity.strFavId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramLong2);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return avjo.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QfavFileForwardHandler", 4, "onReceive");
    }
    String str = paramToServiceMsg.getServiceCmd();
    if (QLog.isDevelopLevel())
    {
      QLog.i("QfavFileForwardHandler", 4, "cmd=" + str);
      QLog.i("QfavFileForwardHandler", 4, "data length =" + ((byte[])paramObject).length);
    }
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      if (str.compareTo("OidbSvc.0xd68") != 0) {
        break label219;
      }
      paramFromServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (paramFromServiceMsg != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QfavFileForwardHandler", 2, "onReceive: ssoPkg parse failed");
    return;
    paramObject = new oidb_cmd0xd68.RspBody();
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      switch (paramFromServiceMsg.uint32_service_type.get())
      {
      case 1: 
        a(paramToServiceMsg, paramObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      return;
    }
    b(paramToServiceMsg, paramObject);
    return;
    c(paramToServiceMsg, paramObject);
    return;
    label219:
    QLog.e("QfavFileForwardHandler", 4, "cmd=" + str);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjl
 * JD-Core Version:    0.7.0.1
 */