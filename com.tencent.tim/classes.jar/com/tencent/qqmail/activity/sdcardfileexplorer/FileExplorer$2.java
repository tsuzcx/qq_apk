package com.tencent.qqmail.activity.sdcardfileexplorer;

import java.io.File;
import java.util.Comparator;

class FileExplorer$2
  implements Comparator<File>
{
  FileExplorer$2(FileExplorer paramFileExplorer) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {
      if (paramFile1 != null) {}
    }
    do
    {
      return -1;
      return 1;
      if ((paramFile1.isDirectory()) && (paramFile2.isDirectory())) {
        return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
      }
    } while (paramFile1.isDirectory());
    if (paramFile2.isDirectory()) {
      return 1;
    }
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.FileExplorer.2
 * JD-Core Version:    0.7.0.1
 */