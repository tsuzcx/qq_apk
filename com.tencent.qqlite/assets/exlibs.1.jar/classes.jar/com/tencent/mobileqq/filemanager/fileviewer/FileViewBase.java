package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

public abstract class FileViewBase
{
  protected Activity a;
  protected IFileViewListener a;
  protected IFileViewerAdapter a;
  
  public FileViewBase(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public abstract View a(ViewGroup paramViewGroup);
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
  }
  
  public void a() {}
  
  public void a(IFileViewListener paramIFileViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = paramIFileViewListener;
  }
  
  public void a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = paramIFileViewerAdapter;
  }
  
  public abstract boolean a();
  
  public abstract void b();
  
  public void c() {}
  
  public void d() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewBase
 * JD-Core Version:    0.7.0.1
 */