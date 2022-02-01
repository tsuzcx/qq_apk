package com.tencent.tbs.logger.file.backup;

import java.io.File;

public abstract interface BackupStrategy
{
  public abstract boolean shouldBackup(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.backup.BackupStrategy
 * JD-Core Version:    0.7.0.1
 */