package com.tencent.dlsdk.yybutil.apkchannel.a;

import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

public final class a
{
  private static final b a = new b(101010256L);
  
  private static byte[] a(RandomAccessFile paramRandomAccessFile)
  {
    int j = 1;
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = a.a();
    for (int i = paramRandomAccessFile.read();; i = paramRandomAccessFile.read())
    {
      if (i == -1) {
        i = 0;
      }
      do
      {
        if (i != 0) {
          break label110;
        }
        throw new ZipException("archive is not a ZIP archive");
        if ((i != arrayOfByte[0]) || (paramRandomAccessFile.read() != arrayOfByte[1]) || (paramRandomAccessFile.read() != arrayOfByte[2])) {
          break;
        }
        i = j;
      } while (paramRandomAccessFile.read() == arrayOfByte[3]);
      l -= 1L;
      paramRandomAccessFile.seek(l);
    }
    label110:
    paramRandomAccessFile.seek(16L + l + 4L);
    arrayOfByte = new byte[2];
    paramRandomAccessFile.readFully(arrayOfByte);
    i = new c(arrayOfByte).b();
    if (i == 0) {
      return null;
    }
    arrayOfByte = new byte[i];
    paramRandomAccessFile.read(arrayOfByte);
    return arrayOfByte;
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    paramString = new RandomAccessFile(paramString, "r");
    if (paramString.length() == 0L)
    {
      paramString.close();
      System.out.println("ERROR:[ZipEocdCommentTool]Your file length is zero!");
      return null;
    }
    byte[] arrayOfByte = a(paramString);
    paramString.close();
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.a.a
 * JD-Core Version:    0.7.0.1
 */