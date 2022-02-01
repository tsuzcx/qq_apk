package com.tencent.mobileqq.filemanager.core;

import agkf;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class FileManagerDataCenter$2
  implements Runnable
{
  public FileManagerDataCenter$2(agkf paramagkf, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.aP == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "INTENT_ACTION_RENAME_FILENAME extra is null!!!");
      }
      return;
    }
    String str1 = this.aP.getString("peerUin");
    int i = this.aP.getInt("peerType");
    String str2 = this.aP.getString("sourceStr");
    String str3 = this.aP.getString("filePath");
    long l = this.aP.getLong("dataLength");
    int j = this.aP.getInt("fileSourceId");
    Bundle localBundle = this.aP.getBundle("otherData");
    this.this$0.a(str1, i, str3, l, j, str2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.2
 * JD-Core Version:    0.7.0.1
 */