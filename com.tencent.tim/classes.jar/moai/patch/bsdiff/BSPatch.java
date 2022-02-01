package moai.patch.bsdiff;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

public class BSPatch
{
  public static final int RETURN_DIFF_FILE_ERR = 2;
  public static final int RETURN_NEW_FILE_ERR = 4;
  public static final int RETURN_OLD_FILE_ERR = 3;
  public static final int RETURN_SUCCESS = 1;
  
  /* Error */
  public static int patchFast(File paramFile1, File paramFile2, File paramFile3, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: invokevirtual 28	java/io/File:length	()J
    //   8: lconst_0
    //   9: lcmp
    //   10: ifgt +5 -> 15
    //   13: iconst_3
    //   14: ireturn
    //   15: aload_1
    //   16: ifnonnull +5 -> 21
    //   19: iconst_4
    //   20: ireturn
    //   21: aload_2
    //   22: ifnull +12 -> 34
    //   25: aload_2
    //   26: invokevirtual 28	java/io/File:length	()J
    //   29: lconst_0
    //   30: lcmp
    //   31: ifgt +5 -> 36
    //   34: iconst_2
    //   35: ireturn
    //   36: new 30	java/io/BufferedInputStream
    //   39: dup
    //   40: new 32	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 38	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore 4
    //   53: aload_2
    //   54: invokevirtual 28	java/io/File:length	()J
    //   57: l2i
    //   58: newarray byte
    //   60: astore 5
    //   62: new 32	java/io/FileInputStream
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   70: astore_2
    //   71: aload_2
    //   72: aload 5
    //   74: iconst_0
    //   75: aload 5
    //   77: arraylength
    //   78: invokestatic 44	moai/patch/bsdiff/BSUtil:readFromStream	(Ljava/io/InputStream;[BII)Z
    //   81: pop
    //   82: aload_2
    //   83: invokevirtual 49	java/io/InputStream:close	()V
    //   86: aload 4
    //   88: aload_0
    //   89: invokevirtual 28	java/io/File:length	()J
    //   92: l2i
    //   93: aload 5
    //   95: iload_3
    //   96: invokestatic 52	moai/patch/bsdiff/BSPatch:patchFast	(Ljava/io/InputStream;I[BI)[B
    //   99: astore_0
    //   100: new 54	java/io/FileOutputStream
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   108: astore_1
    //   109: aload_1
    //   110: aload_0
    //   111: invokevirtual 61	java/io/OutputStream:write	([B)V
    //   114: aload_1
    //   115: invokevirtual 62	java/io/OutputStream:close	()V
    //   118: iconst_1
    //   119: ireturn
    //   120: astore_0
    //   121: aload_2
    //   122: invokevirtual 49	java/io/InputStream:close	()V
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: aload_1
    //   129: invokevirtual 62	java/io/OutputStream:close	()V
    //   132: aload_0
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramFile1	File
    //   0	134	1	paramFile2	File
    //   0	134	2	paramFile3	File
    //   0	134	3	paramInt	int
    //   51	36	4	localBufferedInputStream	java.io.BufferedInputStream
    //   60	34	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   71	82	120	finally
    //   109	114	127	finally
  }
  
  public static int patchFast(InputStream paramInputStream1, InputStream paramInputStream2, File paramFile)
    throws IOException
  {
    if (paramInputStream1 == null) {
      return 3;
    }
    if (paramFile == null) {
      return 4;
    }
    if (paramInputStream2 == null) {
      return 2;
    }
    paramInputStream1 = BSUtil.inputStreamToByte(paramInputStream1);
    paramInputStream2 = BSUtil.inputStreamToByte(paramInputStream2);
    paramInputStream1 = patchFast(paramInputStream1, paramInputStream1.length, paramInputStream2, paramInputStream2.length, 0);
    paramInputStream2 = new FileOutputStream(paramFile);
    try
    {
      paramInputStream2.write(paramInputStream1);
      return 1;
    }
    finally
    {
      paramInputStream2.close();
    }
  }
  
  public static byte[] patchFast(InputStream paramInputStream, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt1];
    BSUtil.readFromStream(paramInputStream, arrayOfByte, 0, paramInt1);
    paramInputStream.close();
    return patchFast(arrayOfByte, paramInt1, paramArrayOfByte, paramArrayOfByte.length, paramInt2);
  }
  
  public static byte[] patchFast(InputStream paramInputStream1, InputStream paramInputStream2)
    throws IOException
  {
    if (paramInputStream1 == null) {}
    while (paramInputStream2 == null) {
      return null;
    }
    paramInputStream1 = BSUtil.inputStreamToByte(paramInputStream1);
    paramInputStream2 = BSUtil.inputStreamToByte(paramInputStream2);
    return patchFast(paramInputStream1, paramInputStream1.length, paramInputStream2, paramInputStream2.length, 0);
  }
  
  public static byte[] patchFast(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
    throws IOException
  {
    Object localObject1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte2, 0, paramInt2));
    ((DataInputStream)localObject1).skip(8L);
    long l1 = ((DataInputStream)localObject1).readLong();
    long l2 = ((DataInputStream)localObject1).readLong();
    int j = (int)((DataInputStream)localObject1).readLong();
    ((DataInputStream)localObject1).close();
    localObject1 = new ByteArrayInputStream(paramArrayOfByte2, 0, paramInt2);
    ((InputStream)localObject1).skip(32L);
    localObject1 = new DataInputStream(new GZIPInputStream((InputStream)localObject1));
    Object localObject2 = new ByteArrayInputStream(paramArrayOfByte2, 0, paramInt2);
    ((InputStream)localObject2).skip(32L + l1);
    localObject2 = new GZIPInputStream((InputStream)localObject2);
    paramArrayOfByte2 = new ByteArrayInputStream(paramArrayOfByte2, 0, paramInt2);
    paramArrayOfByte2.skip(l1 + l2 + 32L);
    paramArrayOfByte2 = new GZIPInputStream(paramArrayOfByte2);
    byte[] arrayOfByte = new byte[j];
    int[] arrayOfInt = new int[3];
    paramInt2 = 0;
    paramInt3 = 0;
    while (paramInt3 < j)
    {
      int i = 0;
      while (i <= 2)
      {
        arrayOfInt[i] = ((DataInputStream)localObject1).readInt();
        i += 1;
      }
      if (arrayOfInt[0] + paramInt3 > j) {
        throw new IOException("Corrupt by wrong patch file.");
      }
      if (!BSUtil.readFromStream((InputStream)localObject2, arrayOfByte, paramInt3, arrayOfInt[0])) {
        throw new IOException("Corrupt by wrong patch file.");
      }
      i = 0;
      while (i < arrayOfInt[0])
      {
        if ((paramInt2 + i >= 0) && (paramInt2 + i < paramInt1))
        {
          k = paramInt3 + i;
          arrayOfByte[k] = ((byte)(arrayOfByte[k] + paramArrayOfByte1[(paramInt2 + i)]));
        }
        i += 1;
      }
      paramInt3 = arrayOfInt[0] + paramInt3;
      int k = arrayOfInt[0];
      if (arrayOfInt[1] + paramInt3 > j) {
        throw new IOException("Corrupt by wrong patch file.");
      }
      if (!BSUtil.readFromStream(paramArrayOfByte2, arrayOfByte, paramInt3, arrayOfInt[1])) {
        throw new IOException("Corrupt by wrong patch file.");
      }
      i = arrayOfInt[1];
      paramInt2 = k + paramInt2 + arrayOfInt[2];
      paramInt3 += i;
    }
    ((DataInputStream)localObject1).close();
    ((InputStream)localObject2).close();
    paramArrayOfByte2.close();
    return arrayOfByte;
  }
  
  public static int patchLessMemory(RandomAccessFile paramRandomAccessFile, int paramInt1, byte[] paramArrayOfByte, int paramInt2, File paramFile, int paramInt3)
    throws IOException
  {
    if ((paramRandomAccessFile == null) || (paramInt1 <= 0)) {
      return 3;
    }
    if (paramFile == null) {
      return 4;
    }
    if ((paramArrayOfByte == null) || (paramInt2 <= 0)) {
      return 2;
    }
    int j = paramInt1 - paramInt3 - 2;
    if (j <= 2) {
      return 3;
    }
    Object localObject1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2));
    ((DataInputStream)localObject1).skip(8L);
    long l1 = ((DataInputStream)localObject1).readLong();
    long l2 = ((DataInputStream)localObject1).readLong();
    int k = (int)((DataInputStream)localObject1).readLong();
    ((DataInputStream)localObject1).close();
    localObject1 = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
    ((InputStream)localObject1).skip(32L);
    localObject1 = new DataInputStream(new GZIPInputStream((InputStream)localObject1));
    Object localObject2 = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
    ((InputStream)localObject2).skip(32L + l1);
    localObject2 = new GZIPInputStream((InputStream)localObject2);
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
    paramArrayOfByte.skip(l1 + l2 + 32L);
    paramArrayOfByte = new GZIPInputStream(paramArrayOfByte);
    paramFile = new FileOutputStream(paramFile);
    int i;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    for (;;)
    {
      try
      {
        arrayOfInt = new int[3];
        paramInt2 = 0;
        paramInt3 = 0;
      }
      finally
      {
        int[] arrayOfInt;
        paramRandomAccessFile.close();
        paramFile.close();
      }
      if (i <= 2)
      {
        arrayOfInt[i] = ((DataInputStream)localObject1).readInt();
        i += 1;
      }
      else
      {
        if (arrayOfInt[0] + paramInt3 > k)
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        arrayOfByte1 = new byte[arrayOfInt[0]];
        if (!BSUtil.readFromStream((InputStream)localObject2, arrayOfByte1, 0, arrayOfInt[0]))
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        arrayOfByte2 = new byte[arrayOfInt[0]];
        if (paramRandomAccessFile.read(arrayOfByte2, 0, arrayOfInt[0]) < arrayOfInt[0])
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (i < arrayOfInt[0])
      {
        if (paramInt2 + i == j)
        {
          arrayOfByte2[i] = 0;
          arrayOfByte2[(i + 1)] = 0;
        }
      }
      else
      {
        paramFile.write(arrayOfByte1);
        paramInt3 = arrayOfInt[0] + paramInt3;
        int m = arrayOfInt[0];
        if (arrayOfInt[1] + paramInt3 > k)
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        arrayOfByte1 = new byte[arrayOfInt[1]];
        if (!BSUtil.readFromStream(paramArrayOfByte, arrayOfByte1, 0, arrayOfInt[1]))
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        paramFile.write(arrayOfByte1);
        paramFile.flush();
        i = arrayOfInt[1];
        paramInt2 = m + paramInt2 + arrayOfInt[2];
        paramRandomAccessFile.seek(paramInt2);
        paramInt3 += i;
        while (paramInt3 >= k)
        {
          ((DataInputStream)localObject1).close();
          ((InputStream)localObject2).close();
          paramArrayOfByte.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 1;
        }
        i = 0;
        break;
      }
      if ((paramInt2 + i >= 0) && (paramInt2 + i < paramInt1)) {
        arrayOfByte1[i] = ((byte)(arrayOfByte1[i] + arrayOfByte2[i]));
      }
      i += 1;
    }
  }
  
  public static int patchLessMemory(RandomAccessFile paramRandomAccessFile, File paramFile1, File paramFile2, int paramInt)
    throws IOException
  {
    if ((paramRandomAccessFile == null) || (paramRandomAccessFile.length() <= 0L)) {
      return 3;
    }
    if (paramFile1 == null) {
      return 4;
    }
    if ((paramFile2 == null) || (paramFile2.length() <= 0L)) {
      return 2;
    }
    byte[] arrayOfByte = new byte[(int)paramFile2.length()];
    paramFile2 = new FileInputStream(paramFile2);
    try
    {
      BSUtil.readFromStream(paramFile2, arrayOfByte, 0, arrayOfByte.length);
      return patchLessMemory(paramRandomAccessFile, (int)paramRandomAccessFile.length(), arrayOfByte, arrayOfByte.length, paramFile1, paramInt);
    }
    finally
    {
      paramFile2.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.bsdiff.BSPatch
 * JD-Core Version:    0.7.0.1
 */