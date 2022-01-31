import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMRecentFileActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileUtil;

public class frk
  implements View.OnClickListener
{
  public frk(FMRecentFileActivity paramFMRecentFileActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecentFileAdapter.ItemHolder)paramView.getTag();
    FileManagerEntity localFileManagerEntity = paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.a.b.a().b();
    FMRecentFileActivity.a(this.a);
    if (this.a.g())
    {
      if (FMDataCache.a(localFileManagerEntity)) {
        FMDataCache.b(localFileManagerEntity);
      }
      for (;;)
      {
        this.a.f();
        FMRecentFileActivity.a(this.a);
        return;
        FMDataCache.a(localFileManagerEntity);
      }
    }
    Object localObject = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_JavaLangString = "file_viewer_in";
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 73;
    ((FileManagerReporter.fileAssistantReportData)localObject).b = FileUtil.a(localFileManagerEntity.fileName);
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Long = localFileManagerEntity.fileSize;
    FileManagerReporter.a(this.a.b.a(), (FileManagerReporter.fileAssistantReportData)localObject);
    localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).c(localFileManagerEntity.cloudType);
    ((ForwardFileInfo)localObject).a(10001);
    ((ForwardFileInfo)localObject).b(paramView.b);
    ((ForwardFileInfo)localObject).c(paramView.jdField_a_of_type_Long);
    ((ForwardFileInfo)localObject).d(localFileManagerEntity.fileName);
    ((ForwardFileInfo)localObject).d(localFileManagerEntity.fileSize);
    ((ForwardFileInfo)localObject).b(localFileManagerEntity.Uuid);
    paramView = new Intent(this.a.getApplicationContext(), QfileFileViewerActivity.class);
    paramView.putExtra("fileinfo", (Parcelable)localObject);
    this.a.startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     frk
 * JD-Core Version:    0.7.0.1
 */