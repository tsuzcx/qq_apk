package com.tencent.token;

import java.io.File;
import java.io.IOException;

public abstract interface fz
{
  public static final fz a = new fz()
  {
    public void a(File paramAnonymousFile)
    {
      if (!paramAnonymousFile.delete())
      {
        if (!paramAnonymousFile.exists()) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("failed to delete ");
        localStringBuilder.append(paramAnonymousFile);
        throw new IOException(localStringBuilder.toString());
      }
    }
    
    public void a(File paramAnonymousFile1, File paramAnonymousFile2)
    {
      a(paramAnonymousFile2);
      if (paramAnonymousFile1.renameTo(paramAnonymousFile2)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to rename ");
      localStringBuilder.append(paramAnonymousFile1);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramAnonymousFile2);
      throw new IOException(localStringBuilder.toString());
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
 * Qualified Name:     com.tencent.token.fz
 * JD-Core Version:    0.7.0.1
 */