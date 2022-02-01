package com.tencent.tbs.logger.file.backup;

import java.io.File;

public class FileSizeBackupStrategy
  implements BackupStrategy
{
  private long maxSize;
  
  public FileSizeBackupStrategy(long paramLong)
  {
    this.maxSize = paramLong;
  }
  
  public boolean shouldBackup(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.length() > this.maxSize) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.backup.FileSizeBackupStrategy
 * JD-Core Version:    0.7.0.1
 */