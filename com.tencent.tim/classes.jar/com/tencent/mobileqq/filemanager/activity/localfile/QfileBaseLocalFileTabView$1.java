package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;

class QfileBaseLocalFileTabView$1
  implements Runnable
{
  QfileBaseLocalFileTabView$1(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void run()
  {
    if ((this.this$0.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView == null) || (this.this$0.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout == null)) {
      return;
    }
    this.this$0.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.this$0.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), this.this$0.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.1
 * JD-Core Version:    0.7.0.1
 */