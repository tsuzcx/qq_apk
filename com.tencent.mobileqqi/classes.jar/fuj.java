import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.BaseFileAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.ImageFileAdapter;
import com.tencent.mobileqq.filemanager.data.ImageFileAdapter.ViewHolder;
import com.tencent.mobileqq.filemanager.data.OfflineFileAdapter.CloudFileItemHolder;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileAdapter.WeiYunFileItemHolder;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;

class fuj
  implements View.OnClickListener
{
  fuj(fui paramfui, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a) != null) && (CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).isShowing())) {
      CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).dismiss();
    }
    int i;
    if (this.jdField_a_of_type_Fui.a.jdField_a_of_type_Long == 9L)
    {
      i = ((OfflineFileAdapter.CloudFileItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (this.jdField_a_of_type_Fui.a.jdField_a_of_type_Long != 9L) {
        break label237;
      }
      CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a, (OfflineFileInfo)this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.getItem(i));
      CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a, CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (!FMDataCache.a(CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a))) {
        break label361;
      }
      this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(null);
      this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
      return;
      if (this.jdField_a_of_type_Fui.a.jdField_a_of_type_Long == 10L)
      {
        i = ((ImageFileAdapter.ViewHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
      i = ((WeiYunFileAdapter.WeiYunFileItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      break;
      label237:
      if (this.jdField_a_of_type_Fui.a.jdField_a_of_type_Long == 10L)
      {
        CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a, this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataImageFileAdapter.a(i));
        CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a, CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).jdField_a_of_type_JavaLangString);
      }
      else
      {
        CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a, (WeiYunFileInfo)this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.getItem(i));
        CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a, CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).jdField_a_of_type_JavaLangString);
      }
    }
    label361:
    if (this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter != null) {
      this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a));
    }
    if (this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
    }
    if ((this.jdField_a_of_type_AndroidViewView.getTag() != null) && (this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter != null)) {
      this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(null);
    }
    if ((FMDataCache.a(CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a))) && (QLog.isColorLevel())) {
      QLog.d(CloudFileBrowserActivity.jdField_b_of_type_JavaLangString, 2, "there is a bug ");
    }
    if (this.jdField_a_of_type_Fui.a.jdField_a_of_type_Long == 9L) {
      this.jdField_a_of_type_Fui.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).jdField_a_of_type_Long), CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).jdField_b_of_type_JavaLangString, CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).jdField_a_of_type_JavaLangString, CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter != null) {
        this.jdField_a_of_type_Fui.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(null);
      }
      CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a, true);
      return;
      this.jdField_a_of_type_Fui.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).jdField_a_of_type_JavaLangString, CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).c, CloudFileBrowserActivity.a(this.jdField_a_of_type_Fui.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fuj
 * JD-Core Version:    0.7.0.1
 */