package com.tencent.token;

import java.io.File;
import java.util.Comparator;

class ek
  implements Comparator
{
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ek
 * JD-Core Version:    0.7.0.1
 */