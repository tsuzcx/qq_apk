import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class atet
  extends atgg
{
  atet(ateh paramateh, FileManagerEntity paramFileManagerEntity, TroopFileTransferManager paramTroopFileTransferManager, apcy paramapcy) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    super.a(paramArrayOfByte, paramInt, paramString);
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileHandler", 2, "sendCloudFileToTroop  airCopyToOtherBiz onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
      }
      this.b.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_Apcy.Id, paramInt, null, paramString);
    }
    do
    {
      do
      {
        return;
        if (paramArrayOfByte != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("CloudFileHandler", 2, "sendCloudFileToTroop onSucceed,But uuid is null!!!");
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager == null);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_Apcy.Id, -1, null, "转存失败,请稍后重试");
      return;
      paramString = new String(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "sendCloudFileToTroop onSucceed, Uuid[" + Arrays.toString(paramArrayOfByte) + "] to hex [" + paramString + "]");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_Apcy.Id, 0, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atet
 * JD-Core Version:    0.7.0.1
 */