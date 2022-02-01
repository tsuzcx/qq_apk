package com.tencent.mobileqq.filemanager.fileviewer.model;

import aguu;
import ahbr;
import android.graphics.Rect;
import apcy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class TroopFileModel$8
  implements Runnable
{
  public TroopFileModel$8(aguu paramaguu, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, FileManagerEntity paramFileManagerEntity1, apcy paramapcy, FileManagerEntity paramFileManagerEntity2, Rect paramRect) {}
  
  public void run()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForTroopFile))) {
      ahbr.a(this.this$0.mAppInterface, this.this$0.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForTroopFile)this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord, this.g.TroopUin, this.jdField_a_of_type_Apcy, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime, 3, 3, this.bY, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.8
 * JD-Core Version:    0.7.0.1
 */