import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.utils.Utils;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskPicBackupRsp;

class awpb
  implements awpw<WeiyunPB.DiskPicBackupRsp>
{
  awpb(awov.a parama, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback, UploadFile paramUploadFile) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskPicBackupRsp paramDiskPicBackupRsp)
  {
    this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, paramInt, paramString);
  }
  
  public void a(WeiyunPB.DiskPicBackupRsp paramDiskPicBackupRsp)
  {
    if (paramDiskPicBackupRsp == null)
    {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, 1828004, acfp.m(2131715439));
      return;
    }
    ByteStringMicro localByteStringMicro1 = paramDiskPicBackupRsp.pdir_key.get();
    ByteStringMicro localByteStringMicro2 = paramDiskPicBackupRsp.ppdir_key.get();
    if (localByteStringMicro1 != null) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pDirKey = awrh.g(localByteStringMicro1);
    }
    if (localByteStringMicro2 != null) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pPDirKey = awrh.g(localByteStringMicro2);
    }
    if (!TextUtils.isEmpty(paramDiskPicBackupRsp.backup_path.get())) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pDirName = paramDiskPicBackupRsp.backup_path.get();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.setServerInfo(paramDiskPicBackupRsp.file_exist.get(), paramDiskPicBackupRsp.file_id.get(), paramDiskPicBackupRsp.server_name.get(), paramDiskPicBackupRsp.inside_upload_ip.get(), paramDiskPicBackupRsp.server_port.get(), Utils.bytes2HexStr(paramDiskPicBackupRsp.check_key.get().toByteArray()).toLowerCase(), paramDiskPicBackupRsp.channel_count.get(), Integer.toString(paramDiskPicBackupRsp.file_version.get()));
    this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, true, 0, null);
    awrd.z(BaseApplicationImpl.getApplication().getApplicationContext(), String.valueOf(this.jdField_a_of_type_Awov$a.getCurrentUin()), "upload_coupon_count", String.valueOf(paramDiskPicBackupRsp.coupon_count.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpb
 * JD-Core Version:    0.7.0.1
 */