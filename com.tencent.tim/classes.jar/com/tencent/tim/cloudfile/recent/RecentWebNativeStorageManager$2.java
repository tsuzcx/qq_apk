package com.tencent.tim.cloudfile.recent;

import android.text.TextUtils;
import aqgv;
import atlb;
import atmp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class RecentWebNativeStorageManager$2
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerNick))) {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerNick = aqgv.e(atmp.a(this.this$0), this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
    }
    Object localObject;
    if ((this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin)))
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (!this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin.equals(atmp.a(this.this$0).getCurrentAccountUin())) {
        break label137;
      }
    }
    label137:
    for (int i = 0;; i = 1)
    {
      ((FileManagerEntity)localObject).nOpType = i;
      localObject = atmp.a(this.jdField_b_of_type_ComTencentCloudfileCloudHistoryInfo, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (localObject != null) {
        this.this$0.a("recent_file_local", ((atlb)localObject).toJson());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.recent.RecentWebNativeStorageManager.2
 * JD-Core Version:    0.7.0.1
 */