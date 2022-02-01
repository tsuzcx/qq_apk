package com.tencent.tim.filemanager.core;

import attf;
import attm;
import attn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManagerRSWorker$1$2
  implements Runnable
{
  public void run()
  {
    try
    {
      if (this.a.this$0.jdField_c_of_type_JavaIoOutputStream == null) {
        this.a.this$0.jdField_c_of_type_JavaIoOutputStream = new FileOutputStream(this.a.this$0.bHJ, true);
      }
      if (this.a.this$0.actionType == 1) {
        this.a.this$0.app.a().o(this.a.this$0.nSessionId, 2002);
      }
      this.a.this$0.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      if (this.h != null) {
        this.a.this$0.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = this.h.toStringUtf8();
      }
      this.a.this$0.app.a().u(this.a.this$0.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.a.this$0.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      attm.a(this.a.this$0, this.a.this$0.YD, this.a.this$0.bHM);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.FileManagerRSWorker.1.2
 * JD-Core Version:    0.7.0.1
 */