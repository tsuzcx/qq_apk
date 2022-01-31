import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.IWyTaskManager.DownloadTask;
import com.weiyun.sdk.IWyTaskManager.Task;
import com.weiyun.sdk.IWyTaskManager.TaskListener;

public class fum
  implements IWyTaskManager.TaskListener
{
  public fum(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void onCanceled(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is canceled[" + String.valueOf(this.a.c) + "],set trafficData size[" + String.valueOf(this.a.jdField_a_of_type_Long) + "]");
    }
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      paramTask = new String[3];
      paramTask[0] = "param_WIFIFileFlow";
      paramTask[1] = "param_WIFIFlow";
      paramTask[2] = "param_Flow";
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramTask, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 3, null, 0, null);
      return;
      paramTask = new String[3];
      paramTask[0] = "param_XGFileFlow";
      paramTask[1] = "param_XGFlow";
      paramTask[2] = "param_Flow";
    }
  }
  
  public void onFailed(IWyTaskManager.Task paramTask, Object paramObject, IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onFailed[" + String.valueOf(this.a.c) + "],set trafficData size[" + String.valueOf(this.a.jdField_a_of_type_Long) + "]");
    }
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      paramTask = new String[3];
      paramTask[0] = "param_WIFIFileFlow";
      paramTask[1] = "param_WIFIFlow";
      paramTask[2] = "param_Flow";
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramTask, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 36, null, paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg);
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.g, "", "", "", paramWyErrorStatus.errorCode, "", this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "errCode[" + String.valueOf(paramWyErrorStatus.errorCode) + "]errmsg[" + paramWyErrorStatus.errorMsg + "]", null);
      return;
      paramTask = new String[3];
      paramTask[0] = "param_XGFileFlow";
      paramTask[1] = "param_XGFlow";
      paramTask[2] = "param_Flow";
    }
  }
  
  public void onProgressChange(IWyTaskManager.Task paramTask, Object paramObject, long paramLong1, long paramLong2)
  {
    paramLong2 = System.currentTimeMillis();
    this.a.jdField_a_of_type_Long = paramLong1;
    if (paramLong2 - this.a.f < 1000L) {
      return;
    }
    this.a.f = paramLong2;
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.a.c) + "]" + "WeiYun download is onProgressChange mtransferedSize[" + String.valueOf(this.a.jdField_a_of_type_Long) + "/" + String.valueOf(this.a.d) + "]");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.a.jdField_a_of_type_Long / (float)this.a.d);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
  }
  
  public void onStarted(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted[" + String.valueOf(this.a.c) + "]");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
  }
  
  public void onSucceed(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed[" + String.valueOf(this.a.c) + "],set trafficData size[" + String.valueOf(this.a.jdField_a_of_type_Long) + "]");
    }
    paramTask = (IWyTaskManager.DownloadTask)this.a.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = paramTask.getFilePath();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    this.a.h = System.currentTimeMillis();
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      paramTask = new String[3];
      paramTask[0] = "param_WIFIFileFlow";
      paramTask[1] = "param_WIFIFlow";
      paramTask[2] = "param_Flow";
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramTask, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 35, null, 0, null);
      paramTask = new FileManagerReporter.fileAssistantReportData();
      paramTask.jdField_a_of_type_JavaLangString = "rece_file_suc";
      paramTask.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramTask);
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.h - this.a.g, "", "", "", this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.d, 0, null);
      return;
      paramTask = new String[3];
      paramTask[0] = "param_XGFileFlow";
      paramTask[1] = "param_XGFlow";
      paramTask[2] = "param_Flow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fum
 * JD-Core Version:    0.7.0.1
 */