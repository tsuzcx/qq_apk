package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream
  extends ProxyOutputStream
{
  protected OutputStream branch;
  
  public TeeOutputStream(OutputStream paramOutputStream1, OutputStream paramOutputStream2)
  {
    super(paramOutputStream1);
    this.branch = paramOutputStream2;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      super.close();
      return;
    }
    finally
    {
      this.branch.close();
    }
  }
  
  public void flush()
    throws IOException
  {
    super.flush();
    this.branch.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      super.write(paramInt);
      this.branch.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      super.write(paramArrayOfByte);
      this.branch.write(paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      this.branch.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.output.TeeOutputStream
 * JD-Core Version:    0.7.0.1
 */