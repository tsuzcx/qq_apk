package com.tencent.mobileqq.filemanager.fileviewer.model;

import agsd;
import aguk.c;
import aguk.d;
import aguu;
import ahav;
import android.app.Activity;
import android.content.Intent;
import apcy;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class TroopFileModel$7
  implements Runnable
{
  public TroopFileModel$7(aguu paramaguu, apcy paramapcy) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileModel<FileAssistant>", 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(this.a.Status), this.a.FileName, Integer.valueOf(this.a.ErrorCode) }));
    }
    Object localObject = this.this$0.c.b();
    if ((((FileManagerEntity)localObject).isFromProcessingForward2c2cOrDiscItem()) || (((FileManagerEntity)localObject).isFromProcessingForward2DatalineItem())) {}
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Aguk$c != null) {
        this.this$0.jdField_a_of_type_Aguk$c.fP(this.a.FilePath, this.a.ThumbnailFile_Large);
      }
      if (this.this$0.jdField_a_of_type_Aguk$d != null) {
        break;
      }
      QLog.d("TroopFileModel<FileAssistant>", 1, "updateTroopFileInfo: error, transListener is null!");
    } while (!QLog.isDevelopLevel());
    QQToast.a(this.this$0.mContext, 1, 2131693619, 0);
    return;
    switch (this.a.Status)
    {
    }
    for (;;)
    {
      aguu.a(this.this$0, this.a.Status);
      return;
      if (aguu.a(this.this$0) != 8) {
        this.this$0.jdField_a_of_type_Aguk$d.djE();
      }
      this.this$0.jdField_a_of_type_Aguk$d.aO((float)this.a.ProgressValue * 1.0F / ((float)this.a.ProgressTotal * 1.0F));
      continue;
      this.this$0.jdField_a_of_type_Aguk$d.djF();
      continue;
      aguu.a(this.this$0, (FileManagerEntity)localObject, this.a);
      if (this.this$0.bG() == 3)
      {
        if (this.this$0.jdField_a_of_type_Aguk$d != null) {
          this.this$0.jdField_a_of_type_Aguk$d.djG();
        }
        this.this$0.a(this.this$0.c, 4);
        continue;
        this.this$0.jdField_a_of_type_Aguk$d.djF();
        continue;
        this.this$0.jdField_a_of_type_Aguk$d.djG();
        continue;
        this.this$0.jdField_a_of_type_Aguk$d.djE();
        this.this$0.jdField_a_of_type_Aguk$d.aO((float)this.a.ProgressValue * 1.0F / ((float)this.a.ProgressTotal * 1.0F));
        continue;
        this.this$0.eH(this.a.FilePath, ahav.getFileType(this.a.FileName));
        localObject = new Intent();
        ((Intent)localObject).putExtra("TroopFile_DeleteFile", true);
        ((Intent)localObject).putExtra("TroopFile_FileName", this.a.FileName);
        this.this$0.mContext.setResult(-1, (Intent)localObject);
        this.this$0.mContext.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.7
 * JD-Core Version:    0.7.0.1
 */