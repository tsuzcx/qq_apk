import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class fse
  implements View.OnClickListener
{
  public fse(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (LocalFileAdapter.LocalFileItemHolder)paramView.getTag();
    paramView = ((LocalFileAdapter.LocalFileItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    if (paramView.a()) {
      LocalFileBrowserActivity.a(this.a, paramView.c(), true);
    }
    do
    {
      return;
      if (this.a.g())
      {
        if (FMDataCache.a(paramView)) {
          FMDataCache.b(paramView);
        }
        for (;;)
        {
          this.a.f();
          if (!this.a.g()) {
            break;
          }
          ((LocalFileAdapter.LocalFileItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((LocalFileAdapter.LocalFileItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(paramView));
          return;
          FMDataCache.a(paramView);
        }
        ((LocalFileAdapter.LocalFileItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        return;
      }
      if (this.a.c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(LocalFileBrowserActivity.jdField_b_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    this.a.d();
    Object localObject2 = FileManagerUtil.a(paramView);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject2).nSessionId);
    localForwardFileInfo.c(3);
    localForwardFileInfo.a(10000);
    localForwardFileInfo.a(paramView.c());
    localForwardFileInfo.d(paramView.d());
    localForwardFileInfo.d(paramView.a());
    localObject1 = new Intent(this.a.getApplicationContext(), QfileFileViewerActivity.class);
    ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
    if (((FileManagerEntity)localObject2).nFileType == 0)
    {
      FMDataCache.a(this.a.a);
      ((Intent)localObject1).putExtra("clicked_file_hashcode", paramView.hashCode());
    }
    localObject2 = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_JavaLangString = "file_viewer_in";
    ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Int = 80;
    ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_b_of_type_JavaLangString = FileUtil.a(paramView.d());
    ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Long = paramView.a();
    FileManagerReporter.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject2);
    this.a.startActivityForResult((Intent)localObject1, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fse
 * JD-Core Version:    0.7.0.1
 */