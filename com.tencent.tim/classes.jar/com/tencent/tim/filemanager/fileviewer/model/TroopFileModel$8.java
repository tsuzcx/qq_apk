package com.tencent.tim.filemanager.fileviewer.model;

import agsd;
import android.app.Activity;
import android.content.Intent;
import apcy;
import atzy.c;
import atzy.d;
import auau;
import audx;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class TroopFileModel$8
  implements Runnable
{
  public TroopFileModel$8(auau paramauau, apcy paramapcy) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileModel", 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(this.a.Status), this.a.FileName, Integer.valueOf(this.a.ErrorCode) }));
    }
    Object localObject = this.this$0.c.b();
    if ((((FileManagerEntity)localObject).isFromProcessingForward2c2cOrDiscItem()) || (((FileManagerEntity)localObject).isFromProcessingForward2DatalineItem())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (this.this$0.jdField_a_of_type_Atzy$c != null) {
                  this.this$0.jdField_a_of_type_Atzy$c.fP(this.a.FilePath, this.a.ThumbnailFile_Large);
                }
                switch (this.a.Status)
                {
                case 7: 
                case 4: 
                case 5: 
                default: 
                  return;
                case 1: 
                  if (this.this$0.jdField_a_of_type_Atzy$d != null) {
                    this.this$0.jdField_a_of_type_Atzy$d.djE();
                  }
                  break;
                }
              } while (this.this$0.jdField_a_of_type_Atzy$d == null);
              this.this$0.jdField_a_of_type_Atzy$d.aO((float)this.a.ProgressValue * 1.0F / ((float)this.a.ProgressTotal * 1.0F));
              return;
              if (this.this$0.jdField_a_of_type_Atzy$d != null) {
                this.this$0.jdField_a_of_type_Atzy$d.djE();
              }
            } while (this.this$0.jdField_a_of_type_Atzy$d == null);
            this.this$0.jdField_a_of_type_Atzy$d.aO((float)this.a.ProgressValue * 1.0F / ((float)this.a.ProgressTotal * 1.0F));
            return;
          } while (this.this$0.jdField_a_of_type_Atzy$d == null);
          this.this$0.jdField_a_of_type_Atzy$d.djF();
          return;
          long l = ((FileManagerEntity)localObject).lastTime;
          String str = ((FileManagerEntity)localObject).selfUin;
          boolean bool = ((FileManagerEntity)localObject).bSend;
          ((FileManagerEntity)localObject).copyFrom(audx.a(this.a));
          ((FileManagerEntity)localObject).lastTime = l;
          ((FileManagerEntity)localObject).selfUin = str;
          ((FileManagerEntity)localObject).bSend = bool;
          if (this.this$0.bG() == 3)
          {
            if (this.this$0.jdField_a_of_type_Atzy$d != null) {
              this.this$0.jdField_a_of_type_Atzy$d.djG();
            }
            this.this$0.a(this.this$0.c, 4);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.w("TroopFileModel", 2, "file download finished, but file not exist.");
        return;
      } while (this.this$0.jdField_a_of_type_Atzy$d == null);
      this.this$0.jdField_a_of_type_Atzy$d.djF();
      return;
    } while (this.this$0.jdField_a_of_type_Atzy$d == null);
    this.this$0.jdField_a_of_type_Atzy$d.djG();
    return;
    this.this$0.eH(this.a.FilePath, audx.fM(this.a.FileName));
    localObject = new Intent();
    ((Intent)localObject).putExtra("TroopFile_DeleteFile", true);
    ((Intent)localObject).putExtra("TroopFile_FileName", this.a.FileName);
    this.this$0.mContext.setResult(-1, (Intent)localObject);
    this.this$0.mContext.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.model.TroopFileModel.8
 * JD-Core Version:    0.7.0.1
 */