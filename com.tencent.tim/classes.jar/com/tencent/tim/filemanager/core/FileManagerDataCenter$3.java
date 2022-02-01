package com.tencent.tim.filemanager.core;

import android.os.Bundle;
import attf;
import com.tencent.qphone.base.util.QLog;

public class FileManagerDataCenter$3
  implements Runnable
{
  public FileManagerDataCenter$3(attf paramattf, Bundle paramBundle) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.FileManagerDataCenter.3
 * JD-Core Version:    0.7.0.1
 */