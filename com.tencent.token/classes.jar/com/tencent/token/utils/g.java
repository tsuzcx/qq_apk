package com.tencent.token.utils;

import java.io.File;
import java.io.FileFilter;

class g
  implements FileFilter
{
  g(e parame) {}
  
  public boolean accept(File paramFile)
  {
    if (!paramFile.getName().endsWith(this.a.j())) {}
    while (e.d(paramFile) == -1) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.g
 * JD-Core Version:    0.7.0.1
 */