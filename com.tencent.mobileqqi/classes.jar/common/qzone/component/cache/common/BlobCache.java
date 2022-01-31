package common.qzone.component.cache.common;

import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.zip.Adler32;

public class BlobCache
  implements Closeable
{
  private static final int jdField_a_of_type_Int = -1289277377;
  private static final String jdField_a_of_type_JavaLangString = "BlobCache";
  private static final int jdField_b_of_type_Int = -1121680097;
  private static final int jdField_c_of_type_Int = 0;
  private static final int jdField_d_of_type_Int = 4;
  private static final int jdField_e_of_type_Int = 8;
  private static final int f = 12;
  private static final int g = 16;
  private static final int h = 20;
  private static final int i = 24;
  private static final int j = 28;
  private static final int k = 32;
  private static final int l = 4;
  private static final int m = 0;
  private static final int n = 8;
  private static final int o = 12;
  private static final int p = 16;
  private static final int q = 20;
  private int A;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private MappedByteBuffer jdField_a_of_type_JavaNioMappedByteBuffer;
  private FileChannel jdField_a_of_type_JavaNioChannelsFileChannel;
  private Adler32 jdField_a_of_type_JavaUtilZipAdler32 = new Adler32();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[32];
  private RandomAccessFile jdField_b_of_type_JavaIoRandomAccessFile;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[20];
  private RandomAccessFile jdField_c_of_type_JavaIoRandomAccessFile;
  private RandomAccessFile jdField_d_of_type_JavaIoRandomAccessFile;
  private RandomAccessFile jdField_e_of_type_JavaIoRandomAccessFile;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public BlobCache(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(paramString + ".idx", "rw");
    this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(paramString + ".0", "rw");
    this.c = new RandomAccessFile(paramString + ".1", "rw");
    this.w = paramInt3;
    if ((!paramBoolean) && (a())) {}
    do
    {
      return;
      a(paramInt1, paramInt2);
    } while (a());
    c();
    throw new IOException("unable to load index");
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[(paramInt + 7)] & 0xFF;
    int i1 = 6;
    while (i1 >= 0)
    {
      l1 = l1 << 8 | paramArrayOfByte[(paramInt + i1)] & 0xFF;
      i1 -= 1;
    }
    return l1;
  }
  
  private void a(int paramInt)
  {
    byte[] arrayOfByte = new byte[1024];
    this.jdField_a_of_type_JavaNioMappedByteBuffer.position(paramInt);
    paramInt = this.r * 12;
    while (paramInt > 0)
    {
      int i1 = Math.min(paramInt, 1024);
      this.jdField_a_of_type_JavaNioMappedByteBuffer.put(arrayOfByte, 0, i1);
      paramInt -= i1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(0L);
    this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(paramInt1 * 12 * 2 + 32);
    this.jdField_a_of_type_JavaIoRandomAccessFile.seek(0L);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    a(arrayOfByte, 0, -1289277377);
    a(arrayOfByte, 4, paramInt1);
    a(arrayOfByte, 8, paramInt2);
    a(arrayOfByte, 12, 0);
    a(arrayOfByte, 16, 0);
    a(arrayOfByte, 20, 4);
    a(arrayOfByte, 24, this.w);
    a(arrayOfByte, 28, a(arrayOfByte, 0, 28));
    this.jdField_a_of_type_JavaIoRandomAccessFile.write(arrayOfByte);
    this.jdField_b_of_type_JavaIoRandomAccessFile.setLength(0L);
    this.c.setLength(0L);
    this.jdField_b_of_type_JavaIoRandomAccessFile.seek(0L);
    this.c.seek(0L);
    a(arrayOfByte, 0, -1121680097);
    this.jdField_b_of_type_JavaIoRandomAccessFile.write(arrayOfByte, 0, 4);
    this.c.write(arrayOfByte, 0, 4);
  }
  
  static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < 4)
    {
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(i1 & 0xFF));
      i1 >>= 8;
      paramInt2 += 1;
    }
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    int i1 = 0;
    while (i1 < 8)
    {
      paramArrayOfByte[(paramInt + i1)] = ((byte)(int)(0xFF & paramLong));
      paramLong >>= 8;
      i1 += 1;
    }
  }
  
  private boolean a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(0L);
      this.jdField_b_of_type_JavaIoRandomAccessFile.seek(0L);
      this.c.seek(0L);
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte) != 32) {
        return false;
      }
      if (a(arrayOfByte, 0) != -1289277377) {
        return false;
      }
      if (a(arrayOfByte, 24) != this.w) {
        return false;
      }
      this.r = a(arrayOfByte, 4);
      this.s = a(arrayOfByte, 8);
      this.t = a(arrayOfByte, 12);
      this.u = a(arrayOfByte, 16);
      this.v = a(arrayOfByte, 20);
      int i1 = a(arrayOfByte, 28);
      if (a(arrayOfByte, 0, 28) != i1) {
        return false;
      }
      if (this.r <= 0) {
        return false;
      }
      if (this.s <= 0) {
        return false;
      }
      if ((this.t != 0) && (this.t != 1)) {
        return false;
      }
      if ((this.u >= 0) && (this.u <= this.r))
      {
        if ((this.v < 4) || (this.v > this.s)) {
          break label365;
        }
        if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() != this.r * 12 * 2 + 32) {
          return false;
        }
        arrayOfByte = new byte[4];
        if (this.jdField_b_of_type_JavaIoRandomAccessFile.read(arrayOfByte) != 4) {
          return false;
        }
        if (a(arrayOfByte, 0) != -1121680097) {
          return false;
        }
        if (this.c.read(arrayOfByte) != 4) {
          return false;
        }
        if (a(arrayOfByte, 0) != -1121680097) {
          return false;
        }
        this.jdField_a_of_type_JavaNioChannelsFileChannel = this.jdField_a_of_type_JavaIoRandomAccessFile.getChannel();
        this.jdField_a_of_type_JavaNioMappedByteBuffer = this.jdField_a_of_type_JavaNioChannelsFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, this.jdField_a_of_type_JavaIoRandomAccessFile.length());
        this.jdField_a_of_type_JavaNioMappedByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        d();
        return true;
      }
    }
    catch (IOException localIOException)
    {
      QLog.e("BlobCache", 2, "loadIndex failed.", localIOException);
      return false;
    }
    return false;
    label365:
    return false;
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    int i2 = (int)(paramLong % this.r);
    int i1 = i2;
    if (i2 < 0) {
      i1 = i2 + this.r;
    }
    int i3 = i1;
    for (;;)
    {
      i2 = i3 * 12 + paramInt;
      long l1 = this.jdField_a_of_type_JavaNioMappedByteBuffer.getLong(i2);
      int i4 = this.jdField_a_of_type_JavaNioMappedByteBuffer.getInt(i2 + 8);
      if (i4 == 0)
      {
        this.z = i2;
        return false;
      }
      if (l1 == paramLong)
      {
        this.z = i2;
        this.A = i4;
        return true;
      }
      i3 += 1;
      i2 = i3;
      if (i3 >= this.r) {
        i2 = 0;
      }
      i3 = i2;
      if (i2 == i1)
      {
        this.jdField_a_of_type_JavaNioMappedByteBuffer.putInt(i2 * 12 + paramInt + 8, 0);
        i3 = i2;
      }
    }
  }
  
  private boolean a(RandomAccessFile paramRandomAccessFile, int paramInt, BlobCache.LookupRequest paramLookupRequest)
  {
    byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    long l1 = paramRandomAccessFile.getFilePointer();
    long l2 = paramInt;
    try
    {
      paramRandomAccessFile.seek(l2);
      int i1 = paramRandomAccessFile.read(arrayOfByte);
      if (i1 != 20) {
        return false;
      }
      l2 = a(arrayOfByte, 0);
      long l3 = paramLookupRequest.jdField_a_of_type_Long;
      if (l2 != l3) {
        return false;
      }
      i1 = a(arrayOfByte, 8);
      int i2 = a(arrayOfByte, 12);
      if (i2 != paramInt) {
        return false;
      }
      i2 = a(arrayOfByte, 16);
      if (i2 >= 0)
      {
        int i3 = this.s;
        if (i2 <= i3 - paramInt - 20) {}
      }
      else
      {
        return false;
      }
      if ((paramLookupRequest.jdField_a_of_type_ArrayOfByte == null) || (paramLookupRequest.jdField_a_of_type_ArrayOfByte.length < i2)) {
        paramLookupRequest.jdField_a_of_type_ArrayOfByte = new byte[i2];
      }
      arrayOfByte = paramLookupRequest.jdField_a_of_type_ArrayOfByte;
      paramLookupRequest.jdField_a_of_type_Int = i2;
      paramInt = paramRandomAccessFile.read(arrayOfByte, 0, i2);
      if (paramInt != i2) {
        return false;
      }
      paramInt = a(arrayOfByte, 0, i2);
      return paramInt == i1;
    }
    catch (Throwable paramLookupRequest)
    {
      QLog.e("BlobCache", 2, "getBlob failed.", paramLookupRequest);
      return false;
    }
    finally
    {
      paramRandomAccessFile.seek(l1);
    }
  }
  
  private void b(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    int i1 = a(paramArrayOfByte, 0, paramInt);
    a(arrayOfByte, 0, paramLong);
    a(arrayOfByte, 8, i1);
    a(arrayOfByte, 12, this.v);
    a(arrayOfByte, 16, paramInt);
    this.d.write(arrayOfByte);
    this.d.write(paramArrayOfByte, 0, paramInt);
    this.jdField_a_of_type_JavaNioMappedByteBuffer.putLong(this.z, paramLong);
    this.jdField_a_of_type_JavaNioMappedByteBuffer.putInt(this.z + 8, this.v);
    this.v += paramInt + 20;
    a(this.jdField_a_of_type_ArrayOfByte, 20, this.v);
  }
  
  private void c()
  {
    a(this.jdField_a_of_type_JavaNioChannelsFileChannel);
    a(this.jdField_a_of_type_JavaIoRandomAccessFile);
    a(this.jdField_b_of_type_JavaIoRandomAccessFile);
    a(this.c);
  }
  
  private void d()
  {
    if (this.t == 0)
    {
      localRandomAccessFile = this.jdField_b_of_type_JavaIoRandomAccessFile;
      this.d = localRandomAccessFile;
      if (this.t != 1) {
        break label103;
      }
    }
    label103:
    for (RandomAccessFile localRandomAccessFile = this.jdField_b_of_type_JavaIoRandomAccessFile;; localRandomAccessFile = this.c)
    {
      this.e = localRandomAccessFile;
      this.d.setLength(this.v);
      this.d.seek(this.v);
      this.x = 32;
      this.y = 32;
      if (this.t != 0) {
        break label111;
      }
      this.y += this.r * 12;
      return;
      localRandomAccessFile = this.c;
      break;
    }
    label111:
    this.x += this.r * 12;
  }
  
  private void e()
  {
    this.t = (1 - this.t);
    this.u = 0;
    this.v = 4;
    a(this.jdField_a_of_type_ArrayOfByte, 12, this.t);
    a(this.jdField_a_of_type_ArrayOfByte, 16, this.u);
    a(this.jdField_a_of_type_ArrayOfByte, 20, this.v);
    f();
    d();
    a(this.x);
    a();
  }
  
  private void f()
  {
    a(this.jdField_a_of_type_ArrayOfByte, 28, a(this.jdField_a_of_type_ArrayOfByte, 0, 28));
    this.jdField_a_of_type_JavaNioMappedByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioMappedByteBuffer.put(this.jdField_a_of_type_ArrayOfByte);
  }
  
  int a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaUtilZipAdler32.reset();
    this.jdField_a_of_type_JavaUtilZipAdler32.update(paramArrayOfByte);
    return (int)this.jdField_a_of_type_JavaUtilZipAdler32.getValue();
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilZipAdler32.reset();
    this.jdField_a_of_type_JavaUtilZipAdler32.update(paramArrayOfByte, paramInt1, paramInt2);
    return (int)this.jdField_a_of_type_JavaUtilZipAdler32.getValue();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaNioMappedByteBuffer.force();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length + 24 > this.s) {
      throw new RuntimeException("blob is too large!");
    }
    if ((this.v + 20 + paramArrayOfByte.length > this.s) || (this.u * 2 >= this.r)) {
      e();
    }
    if (!a(paramLong, this.x))
    {
      this.u += 1;
      a(this.jdField_a_of_type_ArrayOfByte, 16, this.u);
    }
    b(paramLong, paramArrayOfByte, paramArrayOfByte.length);
    f();
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt + 24 > this.s) {
      throw new RuntimeException("blob is too large!");
    }
    if ((this.v + 20 + paramInt > this.s) || (this.u * 2 >= this.r)) {
      e();
    }
    if (!a(paramLong, this.x))
    {
      this.u += 1;
      a(this.jdField_a_of_type_ArrayOfByte, 16, this.u);
    }
    b(paramLong, paramArrayOfByte, paramInt);
    f();
  }
  
  public boolean a(BlobCache.LookupRequest paramLookupRequest)
  {
    if ((a(paramLookupRequest.jdField_a_of_type_Long, this.x)) && (a(this.d, this.A, paramLookupRequest))) {}
    int i1;
    do
    {
      return true;
      i1 = this.z;
      if ((!a(paramLookupRequest.jdField_a_of_type_Long, this.y)) || (!a(this.e, this.A, paramLookupRequest))) {
        break;
      }
    } while ((this.v + 20 + paramLookupRequest.jdField_a_of_type_Int > this.s) || (this.u * 2 >= this.r));
    this.z = i1;
    try
    {
      b(paramLookupRequest.jdField_a_of_type_Long, paramLookupRequest.jdField_a_of_type_ArrayOfByte, paramLookupRequest.jdField_a_of_type_Int);
      this.u += 1;
      a(this.jdField_a_of_type_ArrayOfByte, 16, this.u);
      f();
      return true;
    }
    catch (Throwable paramLookupRequest)
    {
      QLog.e("BlobCache", 2, "cannot copy over");
      return true;
    }
    return false;
  }
  
  public void b()
  {
    a();
    try
    {
      this.jdField_b_of_type_JavaIoRandomAccessFile.getFD().sync();
      try
      {
        label14:
        this.c.getFD().sync();
        return;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      break label14;
    }
  }
  
  public void close()
  {
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     common.qzone.component.cache.common.BlobCache
 * JD-Core Version:    0.7.0.1
 */