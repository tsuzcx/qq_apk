package com.tencent.qqmail.plugin.nativelib;

import java.io.File;
import java.io.FileFilter;

final class SoLoader$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.plugin.nativelib.SoLoader.1
 * JD-Core Version:    0.7.0.1
 */