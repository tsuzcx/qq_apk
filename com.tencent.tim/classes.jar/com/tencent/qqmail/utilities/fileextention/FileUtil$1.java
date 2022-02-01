package com.tencent.qqmail.utilities.fileextention;

import java.io.File;
import java.util.Comparator;

final class FileUtil$1
  implements Comparator<File>
{
  public int compare(File paramFile1, File paramFile2)
  {
    return Long.valueOf(paramFile1.lastModified()).compareTo(Long.valueOf(paramFile2.lastModified()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.fileextention.FileUtil.1
 * JD-Core Version:    0.7.0.1
 */