package com.tencent.token;

import java.io.File;
import java.io.IOException;

class hx
  implements hw
{
  public void a(File paramFile)
  {
    if ((!paramFile.delete()) && (paramFile.exists())) {
      throw new IOException("failed to delete " + paramFile);
    }
  }
  
  public void a(File paramFile1, File paramFile2)
  {
    a(paramFile2);
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException("failed to rename " + paramFile1 + " to " + paramFile2);
    }
  }
  
  public boolean b(File paramFile)
  {
    return paramFile.exists();
  }
  
  public long c(File paramFile)
  {
    return paramFile.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hx
 * JD-Core Version:    0.7.0.1
 */