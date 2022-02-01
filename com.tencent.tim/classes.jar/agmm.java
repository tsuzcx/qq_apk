import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;

class agmm
  implements awpw<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp>
{
  agmm(agmf paramagmf, TroopFileTransferManager paramTroopFileTransferManager, apcy paramapcy, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_Apcy.Id, paramInt, null, paramString);
  }
  
  public void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new String(paramCrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp.length() < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop onSucceed,But uuid is null!!!");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_Apcy.Id, -1, null, acfp.m(2131716919));
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop onSucceed, Uuid[" + paramCrossBidProxyCopyFileToOtherBidMsgRsp + "]");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_Apcy.Id, 0, paramCrossBidProxyCopyFileToOtherBidMsgRsp, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agmm
 * JD-Core Version:    0.7.0.1
 */