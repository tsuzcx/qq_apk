package com.tencent.token;

import java.io.File;
import java.io.FilenameFilter;

class el
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("TOKEN_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.el
 * JD-Core Version:    0.7.0.1
 */