import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class dnp
  implements Runnable
{
  public dnp(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if ("run task sessionid[" + String.valueOf(this.a.c) + "]," + " actionType[" + String.valueOf(this.a.jdField_b_of_type_Int) + "], " + "strUin[" + this.a.e != null)
      {
        localObject = FileManagerUtil.e(this.a.e);
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, (String)localObject);
      }
    }
    else
    {
      this.a.g = System.currentTimeMillis();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      switch (this.a.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
      return;
      if ("null], filePath[" + this.a.jdField_b_of_type_JavaLangString != null)
      {
        localObject = this.a.jdField_b_of_type_JavaLangString;
        break;
      }
      localObject = "null], uniseq[" + String.valueOf(this.a.jdField_b_of_type_Long) + "]";
      break;
      localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "send_file_number";
      FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
      this.a.b();
      continue;
      localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "rece_file_number";
      FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
      this.a.a();
      continue;
      this.a.g();
      continue;
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dnp
 * JD-Core Version:    0.7.0.1
 */