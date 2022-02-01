package com.tencent.token;

import java.io.File;
import java.io.IOException;

public abstract interface amh
{
  public static final amh a = new amh()
  {
    public final void a(File paramAnonymousFile)
    {
      if (!paramAnonymousFile.delete())
      {
        if (!paramAnonymousFile.exists()) {
          return;
        }
        throw new IOException("failed to delete ".concat(String.valueOf(paramAnonymousFile)));
      }
    }
  };
  
  public abstract void a(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amh
 * JD-Core Version:    0.7.0.1
 */