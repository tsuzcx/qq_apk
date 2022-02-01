package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import aguk;
import agwv;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;

public class SimpleFilePresenter$3
  implements Runnable
{
  public SimpleFilePresenter$3(agwv paramagwv) {}
  
  public void run()
  {
    String str = this.this$0.jdField_a_of_type_Aguk.vM();
    if ((TextUtils.isEmpty(str)) || (agwv.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OK(8);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OK(0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jo(str);
    agwv.a(this.this$0).postDelayed(agwv.a(this.this$0), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */