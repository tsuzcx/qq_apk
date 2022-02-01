import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.io.File;

class agfs
  implements ausj.a
{
  agfs(agfr paramagfr, FileInfo paramFileInfo, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!ahbj.isFileExists(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getPath())) || (ahbj.deleteFile(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getPath())))
    {
      ahav.da(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getPath());
      this.a.a.this$0.b(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getPath())));
      this.a.a.this$0.a.sendBroadcast(paramView);
      label104:
      this.a.a.this$0.refreshList();
      if (this.jdField_c_of_type_Ausj.isShowing()) {
        this.jdField_c_of_type_Ausj.dismiss();
      }
      return;
      ahao.OS(2131693519);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfs
 * JD-Core Version:    0.7.0.1
 */