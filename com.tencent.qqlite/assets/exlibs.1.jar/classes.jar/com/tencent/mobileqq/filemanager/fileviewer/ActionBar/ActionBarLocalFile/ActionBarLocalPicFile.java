package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile;

import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import dru;

public class ActionBarLocalPicFile
  extends BaseActionBarLocalFile
{
  public ActionBarLocalPicFile(View paramView)
  {
    super(paramView);
  }
  
  public void a()
  {
    a(0, "用其他应用打开", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    super.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().d();
    if ((i == 3) || (i == 0)) {
      c();
    }
    for (;;)
    {
      a(2, "收藏", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      a(2, FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      return;
      if (i == 2) {
        h();
      } else {
        a();
      }
    }
  }
  
  public void c()
  {
    a(0, "恢复上传", new dru(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalPicFile
 * JD-Core Version:    0.7.0.1
 */