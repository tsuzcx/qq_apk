package com.tencent.ttpic.baseutils.io;

import java.io.File;

final class FileUtils$4
  implements FileUtils.FileComparator
{
  public boolean equals(String paramString, File paramFile)
  {
    long l = FileUtils.access$100(paramString);
    return (l != -1L) && (l == paramFile.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.io.FileUtils.4
 * JD-Core Version:    0.7.0.1
 */