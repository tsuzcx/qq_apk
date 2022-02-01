import android.text.TextUtils;
import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

final class aueb
  extends atgg
{
  aueb(FileManagerEntity paramFileManagerEntity, atgc paramatgc, ateh paramateh, QQAppInterface paramQQAppInterface) {}
  
  public void onGetCloudItemCallBack(CloudBase paramCloudBase)
  {
    if ((paramCloudBase != null) && ((paramCloudBase instanceof CloudFile)))
    {
      paramCloudBase = (CloudFile)paramCloudBase;
      atgi.a().a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.pDirKey, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudId, this.a.aG(), 4, new auec(this));
    }
    do
    {
      return;
      if (aueh.isFileExists(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
      {
        paramCloudBase = new ArrayList();
        paramCloudBase.add(athu.a(this.val$app, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, true));
        this.jdField_b_of_type_Ateh.a(this.a.aG(), paramCloudBase);
        return;
      }
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)) && (this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime + 604800000L > NetConnInfoCenter.getServerTime()))
      {
        if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_b_of_type_Ateh.c(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, true);
          return;
        }
        this.jdField_b_of_type_Ateh.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerUtil<FileAssistant>", 2, "can't save to cloudfile, fileName:" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + " sessionId:" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aueb
 * JD-Core Version:    0.7.0.1
 */