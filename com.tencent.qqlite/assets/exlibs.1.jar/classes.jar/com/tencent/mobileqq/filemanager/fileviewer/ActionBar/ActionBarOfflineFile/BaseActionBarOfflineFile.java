package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOfflineFile;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import dsy;
import dta;

public class BaseActionBarOfflineFile
  extends BaseQfileActionBar
{
  protected String a;
  
  public BaseActionBarOfflineFile(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaLangString = "BaseActionBarOfflineFile<FileAssistant>";
  }
  
  public void a()
  {
    a(0, "下载原文件", new dsy(this));
  }
  
  public void a(Activity paramActivity)
  {
    b(paramActivity, "存到微云", 2130838523, 2130838524, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    super.a(paramActivity);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("丫的类型是不是搞错了？！");
      }
    }
    else
    {
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "发给好友（免流量）", 2130838517, 2130838518, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 10002, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 3)) {
        break label197;
      }
      c();
    }
    for (;;)
    {
      a(2, "收藏", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      a(2, FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      return;
      label197:
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 2) {
        h();
      } else {
        a();
      }
    }
  }
  
  public void c()
  {
    String str = "恢复下载";
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 22) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 21) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 20) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 7) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 4) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 6) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 3)) {
      str = "恢复上传";
    }
    a(0, str, new dta(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOfflineFile.BaseActionBarOfflineFile
 * JD-Core Version:    0.7.0.1
 */