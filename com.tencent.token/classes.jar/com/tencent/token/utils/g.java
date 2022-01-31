package com.tencent.token.utils;

import java.io.File;
import java.io.FileFilter;

final class g
  implements FileFilter
{
  g(e parame) {}
  
  public final boolean accept(File paramFile)
  {
    if (!paramFile.getName().endsWith(this.a.g())) {}
    while (e.c(paramFile) == -1) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.g
 * JD-Core Version:    0.7.0.1
 */