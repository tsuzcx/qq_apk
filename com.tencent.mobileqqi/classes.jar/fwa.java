import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.mpfile.LiteMpFileMainActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.activity.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.AlbumBackupInfo;
import cooperation.weiyun.AlbumBackupLaunchProxyActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class fwa
  implements View.OnClickListener
{
  public fwa(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.c()) {
      if (QLog.isColorLevel()) {
        QLog.i(FileAssistantActivity.jdField_b_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      }
    }
    long l;
    do
    {
      do
      {
        return;
        this.a.d();
        paramView = (FileCategoryAdapter.ItemHolder)paramView.getTag();
      } while (paramView.jdField_a_of_type_Int == 0);
      l = paramView.jdField_a_of_type_Int;
      switch ((int)l)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e(FileAssistantActivity.jdField_b_of_type_JavaLangString, 2, "unknow category!!! return onClick");
    return;
    paramView = new FileManagerReporter.fileAssistantReportData();
    paramView.jdField_a_of_type_JavaLangString = "file_assistant_in";
    paramView.jdField_a_of_type_Int = 1;
    FileManagerReporter.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
    paramView = new Intent(this.a.getApplicationContext(), LiteActivity.class);
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putLong("category", l);
        paramView.putExtra("bundle", localBundle);
        this.a.startActivityForResult(paramView, 101);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.jdField_a_of_type_JavaLangString = "file_assistant_in";
      paramView.jdField_a_of_type_Int = 2;
      FileManagerReporter.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
      paramView = new Intent(this.a.getApplicationContext(), FMActivity.class);
      continue;
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.jdField_a_of_type_JavaLangString = "file_assistant_in";
      paramView.jdField_a_of_type_Int = 3;
      FileManagerReporter.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
      FileAssistantActivity.a(this.a);
      return;
      paramView = new Intent(this.a.getApplicationContext(), LiteMpFileMainActivity.class);
      this.a.startActivity(paramView);
      return;
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.jdField_a_of_type_JavaLangString = "file_assistant_in";
      paramView.jdField_a_of_type_Int = 10;
      FileManagerReporter.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
      paramView = new Intent(this.a.getApplicationContext(), FMLocalFileActivity.class);
    }
    if (AlbumBackupInfo.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
      AlbumBackupProxyActivity.a(this.a, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (;;)
    {
      this.a.overridePendingTransition(2130968596, 2130968597);
      ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Weiyun_Backup", "Enter_Backup", 0, 0, "", "", "", "");
      return;
      AlbumBackupLaunchProxyActivity.a(this.a, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    FileAssistantActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwa
 * JD-Core Version:    0.7.0.1
 */