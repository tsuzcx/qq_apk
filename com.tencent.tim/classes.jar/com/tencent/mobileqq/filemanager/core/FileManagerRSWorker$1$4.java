package com.tencent.mobileqq.filemanager.core;

import agkf;
import agkl;
import agkm;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManagerRSWorker$1$4
  implements Runnable
{
  public FileManagerRSWorker$1$4(agkm paramagkm, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.a.this$0.jdField_c_of_type_JavaIoOutputStream == null) {
        this.a.this$0.jdField_c_of_type_JavaIoOutputStream = new FileOutputStream(this.a.this$0.bHJ, true);
      }
      this.a.this$0.app.a().o(this.a.this$0.nSessionId, 2002);
      this.a.this$0.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.a.this$0.app.a().u(this.a.this$0.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.a.this$0.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.a.this$0.bHM = this.bHT;
      agkl.a(this.a.this$0, this.a.this$0.YD, this.a.this$0.bHM);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1.4
 * JD-Core Version:    0.7.0.1
 */