import com.tencent.cloudfile.AirCopyExtInfo;
import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

class ater
  extends CloudFileCallback
{
  ater(ateh paramateh, FileManagerEntity paramFileManagerEntity, long paramLong, AirCopyExtInfo paramAirCopyExtInfo, TroopFileTransferManager paramTroopFileTransferManager, apcy paramapcy) {}
  
  public void onGetCloudItemCallBack(CloudBase paramCloudBase)
  {
    super.onGetCloudItemCallBack(paramCloudBase);
    if ((paramCloudBase instanceof CloudFile)) {
      this.b.cloudSha = ((CloudFile)paramCloudBase).fileSha;
    }
    ateh.a(this.this$0, this.b, this.axU, this.jdField_a_of_type_ComTencentCloudfileAirCopyExtInfo, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager, this.jdField_a_of_type_Apcy);
    this.this$0.app.a().jo(this.b.nSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ater
 * JD-Core Version:    0.7.0.1
 */