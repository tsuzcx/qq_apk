package com.tencent.tbs.logger.file.backup;

import java.io.File;

public class NeverBackupStrategy
  implements BackupStrategy
{
  public boolean shouldBackup(File paramFile)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.backup.NeverBackupStrategy
 * JD-Core Version:    0.7.0.1
 */