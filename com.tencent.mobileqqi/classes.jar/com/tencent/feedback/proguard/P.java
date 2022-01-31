package com.tencent.feedback.proguard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class P
  implements N
{
  public final byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ZipOutputStream localZipOutputStream = new ZipOutputStream(localByteArrayOutputStream);
    ZipEntry localZipEntry = new ZipEntry("zip");
    localZipEntry.setSize(paramArrayOfByte.length);
    localZipOutputStream.putNextEntry(localZipEntry);
    localZipOutputStream.write(paramArrayOfByte);
    localZipOutputStream.closeEntry();
    localZipOutputStream.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
    throws Exception
  {
    ByteArrayOutputStream localByteArrayOutputStream = null;
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    ZipInputStream localZipInputStream = new ZipInputStream(localByteArrayInputStream);
    paramArrayOfByte = localByteArrayOutputStream;
    if (localZipInputStream.getNextEntry() == null)
    {
      localZipInputStream.close();
      localByteArrayInputStream.close();
      return paramArrayOfByte;
    }
    paramArrayOfByte = new byte[1024];
    localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = localZipInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length);
      if (i == -1)
      {
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        break;
      }
      localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.P
 * JD-Core Version:    0.7.0.1
 */