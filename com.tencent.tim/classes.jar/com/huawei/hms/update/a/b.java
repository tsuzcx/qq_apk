package com.huawei.hms.update.a;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class b
  extends OutputStream
{
  private RandomAccessFile a;
  
  public b(File paramFile, int paramInt)
  {
    try
    {
      this.a = new RandomAccessFile(paramFile, "rwd");
      this.a.setLength(paramInt);
      return;
    }
    catch (FileNotFoundException paramFile)
    {
      HMSLog.e("RandomFileOutputStream", "create  file stream failed");
      return;
    }
    catch (IOException paramFile)
    {
      IOUtils.closeQuietly(this.a);
      HMSLog.e("RandomFileOutputStream", "create  file stream failed");
    }
  }
  
  public void a(long paramLong)
    throws IOException
  {
    this.a.seek(paramLong);
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    write(new byte[] { (byte)paramInt }, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.a.b
 * JD-Core Version:    0.7.0.1
 */