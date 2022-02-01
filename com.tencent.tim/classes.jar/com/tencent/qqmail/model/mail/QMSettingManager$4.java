package com.tencent.qqmail.model.mail;

import java.io.File;
import java.io.FilenameFilter;

class QMSettingManager$4
  implements FilenameFilter
{
  QMSettingManager$4(QMSettingManager paramQMSettingManager, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return this.val$soundConf.equalsIgnoreCase(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSettingManager.4
 * JD-Core Version:    0.7.0.1
 */