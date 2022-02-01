import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgRsp;

class agmr
  implements awpw<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp>
{
  agmr(agmf paramagmf, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onFailed  strFileId[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.bIk + "]strFileName[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.strFileName + "]errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    agmf.a(this.jdField_b_of_type_Agmf).a().b(false, 20, new Object[] { Integer.valueOf(paramInt), paramString, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.bIk, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.strFileName, Boolean.valueOf(false) });
  }
  
  public void a(WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onSucceed  strFileId[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.bIk + "]strFileName[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.strFileName + "]");
    }
    agmf.a(this.jdField_b_of_type_Agmf).a().b(true, 20, new Object[] { Integer.valueOf(0), null, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.bIk, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.strFileName, Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agmr
 * JD-Core Version:    0.7.0.1
 */