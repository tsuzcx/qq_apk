package com.tencent.token;

import java.io.File;
import java.io.IOException;

public abstract interface fw
{
  public static final fw a = new fw()
  {
    public void a(File paramAnonymousFile)
    {
      if ((!paramAnonymousFile.delete()) && (paramAnonymousFile.exists())) {
        throw new IOException("failed to delete " + paramAnonymousFile);
      }
    }
    
    public void a(File paramAnonymousFile1, File paramAnonymousFile2)
    {
      a(paramAnonymousFile2);
      if (!paramAnonymousFile1.renameTo(paramAnonymousFile2)) {
        throw new IOException("failed to rename " + paramAnonymousFile1 + " to " + paramAnonymousFile2);
      }
    }
    
    public boolean b(File paramAnonymousFile)
    {
      return paramAnonymousFile.exists();
    }
    
    public long c(File paramAnonymousFile)
    {
      return paramAnonymousFile.length();
    }
  };
  
  public abstract void a(File paramFile);
  
  public abstract void a(File paramFile1, File paramFile2);
  
  public abstract boolean b(File paramFile);
  
  public abstract long c(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fw
 * JD-Core Version:    0.7.0.1
 */