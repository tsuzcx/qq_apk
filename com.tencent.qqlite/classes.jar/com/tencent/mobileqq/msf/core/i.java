package com.tencent.mobileqq.msf.core;

import java.io.File;
import java.util.Comparator;

class i
  implements Comparator
{
  i(h paramh) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.i
 * JD-Core Version:    0.7.0.1
 */