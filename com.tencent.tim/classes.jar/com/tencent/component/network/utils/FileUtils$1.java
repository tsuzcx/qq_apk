package com.tencent.component.network.utils;

import java.io.File;

final class FileUtils$1
  implements FileUtils.FileComparator
{
  public boolean equals(File paramFile1, File paramFile2)
  {
    return (paramFile1.length() == paramFile2.length()) && (paramFile1.lastModified() == paramFile2.lastModified());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */