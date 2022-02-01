import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.troopFile.TroopFileCopyInfoEntity;
import tencent.im.cs.weiyun.weiyun_lite_message.FileExtInfo;
import tencent.im.cs.weiyun.weiyun_lite_message.TimCloudAddtionalInfo;
import tencent.im.cs.weiyun.weiyun_lite_message.TimCloudFileExtInfo;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToRspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.RspBody;

public class auqa
{
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong, TroopFileCopyInfoEntity paramTroopFileCopyInfoEntity, auqa.a parama)
  {
    if ((paramTroopFileCopyInfoEntity == null) || (TextUtils.isEmpty(paramTroopFileCopyInfoEntity.strFileID)))
    {
      QLog.e("TroopFileProtocol", 1, "reqCopyToCloudFile troopFileInfo error!");
      return;
    }
    oidb_0x6d9.CopyToReqBody localCopyToReqBody = new oidb_0x6d9.CopyToReqBody();
    localCopyToReqBody.uint32_app_id.set(52);
    localCopyToReqBody.uint64_group_code.set(paramLong);
    localCopyToReqBody.uint64_dst_uin.set(paramQQAppInterface.getLongAccountUin());
    localCopyToReqBody.uint32_src_bus_id.set(paramTroopFileCopyInfoEntity.srcBizId);
    localCopyToReqBody.str_src_file_id.set(paramTroopFileCopyInfoEntity.strFileID);
    localCopyToReqBody.uint32_dst_bus_id.set(77);
    Object localObject1 = paramTroopFileCopyInfoEntity.strFileName;
    if (paramBoolean)
    {
      localObject2 = atgi.a().encodeFileNameForAirCopy(paramTroopFileCopyInfoEntity.strFileID, paramTroopFileCopyInfoEntity.strFileName, paramTroopFileCopyInfoEntity.nFileSize);
      localObject1 = localObject2;
      if (QLog.isDevelopLevel())
      {
        QLog.i("TroopFileProtocol.AutoProcessFileListTask", 1, paramTroopFileCopyInfoEntity.strFileName + " -> " + (String)localObject2);
        localObject1 = localObject2;
      }
    }
    localCopyToReqBody.str_new_file_name.set((String)localObject1);
    localObject1 = (atgc)paramQQAppInterface.getManager(373);
    localCopyToReqBody.bytes_tim_cloud_pdir_key.set(ByteStringMicro.copyFrom(((atgc)localObject1).aF()));
    localCopyToReqBody.bytes_tim_cloud_ppdir_key.set(ByteStringMicro.copyFrom(((atgc)localObject1).aE()));
    localObject1 = new weiyun_lite_message.TimCloudAddtionalInfo();
    ((weiyun_lite_message.TimCloudAddtionalInfo)localObject1).uint32_biz_type.set(0);
    ((weiyun_lite_message.TimCloudAddtionalInfo)localObject1).uint32_src_type.set(4);
    Object localObject2 = new weiyun_lite_message.TimCloudFileExtInfo();
    ((weiyun_lite_message.TimCloudFileExtInfo)localObject2).str_show_name.set(paramTroopFileCopyInfoEntity.strFileName);
    ((weiyun_lite_message.TimCloudFileExtInfo)localObject2).uint64_peer_uin.set(paramLong);
    ((weiyun_lite_message.TimCloudFileExtInfo)localObject2).uint64_create_uin.set(paramTroopFileCopyInfoEntity.uploadUin);
    ((weiyun_lite_message.TimCloudFileExtInfo)localObject2).uint64_trans_time.set(paramTroopFileCopyInfoEntity.uploadTime);
    if (paramTroopFileCopyInfoEntity.uploadUin == paramQQAppInterface.getLongAccountUin()) {
      ((weiyun_lite_message.TimCloudFileExtInfo)localObject2).uint32_trans_type.set(1);
    }
    for (;;)
    {
      ((weiyun_lite_message.TimCloudAddtionalInfo)localObject1).msg_tim_cloud_file_ext_info.set((MessageMicro)localObject2);
      paramTroopFileCopyInfoEntity = new weiyun_lite_message.FileExtInfo();
      paramTroopFileCopyInfoEntity.bytes_tim_cloud_addtional_info.set(ByteStringMicro.copyFrom(((weiyun_lite_message.TimCloudAddtionalInfo)localObject1).toByteArray()));
      paramTroopFileCopyInfoEntity.bool_ftn_to_qcloud_auto_req.set(paramBoolean);
      localCopyToReqBody.bytes_tim_cloud_extension_info.set(ByteStringMicro.copyFrom(paramTroopFileCopyInfoEntity.toByteArray()));
      localCopyToReqBody.uint32_tim_file_exist_option.set(1);
      paramTroopFileCopyInfoEntity = new oidb_0x6d9.ReqBody();
      paramTroopFileCopyInfoEntity.copy_to_req.set(localCopyToReqBody);
      jnm.b(paramQQAppInterface, parama, paramTroopFileCopyInfoEntity.toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, null);
      return;
      ((weiyun_lite_message.TimCloudFileExtInfo)localObject2).uint32_trans_type.set(2);
    }
  }
  
  public static abstract class a
    extends jnm.d
  {
    public a()
    {
      super();
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        a(false, null, paramBundle);
        return;
      }
      oidb_0x6d9.RspBody localRspBody = new oidb_0x6d9.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        if (localRspBody.copy_to_rsp.has())
        {
          a(true, localRspBody.copy_to_rsp, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, localRspBody.copy_to_rsp, paramBundle);
        return;
      }
      a(false, localRspBody.copy_to_rsp, paramBundle);
    }
    
    public abstract void a(boolean paramBoolean, oidb_0x6d9.CopyToRspBody paramCopyToRspBody, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqa
 * JD-Core Version:    0.7.0.1
 */