package com.tencent.tbs.logger.file.clean;

import java.io.File;

public abstract interface CleanStrategy
{
  public abstract boolean shouldClean(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.clean.CleanStrategy
 * JD-Core Version:    0.7.0.1
 */