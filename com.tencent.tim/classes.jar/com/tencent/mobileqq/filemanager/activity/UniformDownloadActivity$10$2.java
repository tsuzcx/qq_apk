package com.tencent.mobileqq.filemanager.activity;

import agdf;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.downloadnew.DownloadInfo;

public class UniformDownloadActivity$10$2
  implements Runnable
{
  public UniformDownloadActivity$10$2(agdf paramagdf, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    UniformDownloadActivity.b(this.jdField_a_of_type_Agdf.this$0).setVisibility(0);
    UniformDownloadActivity.a(this.jdField_a_of_type_Agdf.this$0).setVisibility(0);
    UniformDownloadActivity.b(this.jdField_a_of_type_Agdf.this$0).setText(this.jdField_a_of_type_Agdf.this$0.getString(2131692975, new Object[] { this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.progress + "%" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.2
 * JD-Core Version:    0.7.0.1
 */