import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.BaseFileAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;

public class fpp
  implements View.OnClickListener
{
  public fpp(CloudFileBrowserActivity paramCloudFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
    }
    if ((((Button)paramView.findViewById(2131231700)).getTag() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(null);
    }
    if ((FMDataCache.a(CloudFileBrowserActivity.a(this.a))) && (QLog.isColorLevel())) {
      QLog.d(CloudFileBrowserActivity.jdField_b_of_type_JavaLangString, 2, "there is a bug ");
    }
    if (this.a.jdField_a_of_type_Long == 9L) {
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(CloudFileBrowserActivity.a(this.a).jdField_a_of_type_Long), CloudFileBrowserActivity.a(this.a).jdField_b_of_type_JavaLangString, CloudFileBrowserActivity.a(this.a).jdField_a_of_type_JavaLangString, CloudFileBrowserActivity.a(this.a).jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(null);
      CloudFileBrowserActivity.a(this.a, true);
      return;
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(CloudFileBrowserActivity.a(this.a).jdField_a_of_type_JavaLangString, CloudFileBrowserActivity.a(this.a).c, CloudFileBrowserActivity.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fpp
 * JD-Core Version:    0.7.0.1
 */