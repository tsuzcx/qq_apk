package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarAppDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarMusciDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarOtherDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarPicDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalAppFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalMusciFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalOtherFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalPicFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOfflineFile.BaseActionBarOfflineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOnlineFile.BaseActionBarOnlineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarWeiYunFile.BaseActionBarWeiyunFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class ActionBarManager
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  BaseActionBar jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar;
  IFileBrowser jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser;
  final String jdField_a_of_type_JavaLangString = "ActionBarManager<FileAssistant>";
  
  public ActionBarManager(IFileBrowser paramIFileBrowser)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = paramIFileBrowser;
    c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b().setVisibility(0);
  }
  
  public void a(BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar == null)
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("actionBar 还未创建!");
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(paramIActionBarClickEvent);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b().setVisibility(8);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      ((RelativeLayout)localObject).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(((RelativeLayout)localObject).getContext(), 2130903410, null));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ActionBarManager<FileAssistant>", 2, "creater actionbar faild, adapteris null!");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.f();
    }
    int i = ((IFileViewerAdapter)localObject).c();
    int j = ((IFileViewerAdapter)localObject).a();
    switch (i)
    {
    case 5: 
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c()) {
        b();
      }
      break;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(1, false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(2, false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(3, false);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
      switch (j)
      {
      case 2: 
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalOtherFile((View)localObject);
        break;
      case 5: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalAppFile((View)localObject);
        break;
      case 0: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalPicFile((View)localObject);
        break;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalMusciFile((View)localObject);
        break;
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
        switch (j)
        {
        case 2: 
        case 3: 
        case 4: 
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarOtherDataLineFile((View)localObject);
          break;
        case 5: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarAppDataLineFile((View)localObject);
          break;
        case 0: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarPicDataLineFile((View)localObject);
          break;
        case 1: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarMusciDataLineFile((View)localObject);
          break;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new BaseActionBarOfflineFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
          break;
          if (FileUtil.b(((IFileViewerAdapter)localObject).b()))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
            switch (j)
            {
            case 2: 
            case 3: 
            case 4: 
            default: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalOtherFile((View)localObject);
              break;
            case 5: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalAppFile((View)localObject);
              break;
            case 0: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalPicFile((View)localObject);
              break;
            case 1: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalMusciFile((View)localObject);
              break;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new BaseActionBarWeiyunFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
          break;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new BaseActionBarOnlineFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
          break;
          a();
        }
        break;
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager
 * JD-Core Version:    0.7.0.1
 */