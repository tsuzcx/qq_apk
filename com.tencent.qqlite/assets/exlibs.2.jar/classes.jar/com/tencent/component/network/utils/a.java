package com.tencent.component.network.utils;

import java.io.File;

final class a
  implements FileUtils.FileComparator
{
  public final boolean equals(File paramFile1, File paramFile2)
  {
    return (paramFile1.length() == paramFile2.length()) && (paramFile1.lastModified() == paramFile2.lastModified());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a
 * JD-Core Version:    0.7.0.1
 */