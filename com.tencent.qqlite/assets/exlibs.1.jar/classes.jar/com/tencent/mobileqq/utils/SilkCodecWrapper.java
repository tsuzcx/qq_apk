package com.tencent.mobileqq.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.ptt.PttSoLoader;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public final class SilkCodecWrapper
  extends InputStream
  implements IAudioCompressor
{
  private static final String jdField_a_of_type_JavaLangString = "SilkCodecWrapper";
  private static boolean jdField_b_of_type_Boolean = false;
  int jdField_a_of_type_Int;
  private PipedInputStream jdField_a_of_type_JavaIoPipedInputStream;
  private PipedOutputStream jdField_a_of_type_JavaIoPipedOutputStream;
  boolean jdField_a_of_type_Boolean;
  public byte[] a;
  private int jdField_b_of_type_Int = 0;
  private PipedInputStream jdField_b_of_type_JavaIoPipedInputStream;
  public byte[] b;
  private int jdField_c_of_type_Int = 0;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private byte[] e = new byte[1];
  
  public SilkCodecWrapper(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!jdField_b_of_type_Boolean)
    {
      PttSoLoader.a(paramContext, "codecsilk");
      jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Int = SilkEncoderNew(paramInt1, paramInt2);; this.jdField_a_of_type_Int = SilkDecoderNew(paramInt1, paramInt2))
    {
      this.jdField_c_of_type_Int = RecordParams.a(paramInt1);
      this.jdField_c_of_type_ArrayOfByte = new byte[this.jdField_c_of_type_Int];
      this.jdField_d_of_type_ArrayOfByte = new byte[this.jdField_c_of_type_Int];
      return;
    }
  }
  
  public static native int SilkDecoderNew(int paramInt1, int paramInt2);
  
  public static native int SilkEncoderNew(int paramInt1, int paramInt2);
  
  public static void a(Context paramContext)
  {
    if ((!jdField_b_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "codecsilk"))) {
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return decode(this.jdField_a_of_type_Int, paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaIoPipedOutputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedOutputStream.close();
      this.jdField_a_of_type_JavaIoPipedOutputStream = null;
    }
    if (this.jdField_a_of_type_JavaIoPipedInputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedInputStream.close();
      this.jdField_a_of_type_JavaIoPipedInputStream = null;
    }
    close();
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaIoPipedOutputStream = new PipedOutputStream();
      if (Build.VERSION.SDK_INT > 8) {
        break label58;
      }
    }
    label58:
    for (this.jdField_a_of_type_JavaIoPipedInputStream = new QPipedInputStream(this.jdField_a_of_type_JavaIoPipedOutputStream, 3840);; this.jdField_a_of_type_JavaIoPipedInputStream = new PipedInputStream(this.jdField_a_of_type_JavaIoPipedOutputStream, 3840))
    {
      this.jdField_b_of_type_JavaIoPipedInputStream = this.jdField_a_of_type_JavaIoPipedInputStream;
      return;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[this.jdField_d_of_type_Int];
    byte[] arrayOfByte2 = new byte[this.jdField_c_of_type_Int];
    this.jdField_a_of_type_JavaIoPipedOutputStream.write(paramArrayOfByte, 0, paramInt);
    paramInt = 0;
    while (this.jdField_a_of_type_JavaIoPipedInputStream.available() >= this.jdField_c_of_type_Int)
    {
      int i = read(arrayOfByte2);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt, i);
      paramInt += i;
    }
    paramArrayOfByte = new byte[paramInt];
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, paramInt);
    return paramArrayOfByte;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int != 0) {
      deleteCodec(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void close()
  {
    try
    {
      if (this.jdField_b_of_type_JavaIoPipedInputStream != null) {
        this.jdField_b_of_type_JavaIoPipedInputStream.close();
      }
      return;
    }
    finally
    {
      this.jdField_b_of_type_JavaIoPipedInputStream = null;
      b();
    }
  }
  
  public native int decode(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3);
  
  public native void deleteCodec(int paramInt);
  
  public native int encode(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2);
  
  protected void finalize()
  {
    if (this.jdField_a_of_type_Int != 0) {}
    try
    {
      close();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int read()
  {
    if (read(this.e, 0, 1) == 1) {
      return this.e[0] & 0xFF;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalStateException("not open");
    }
    if (this.jdField_b_of_type_JavaIoPipedInputStream.read(this.jdField_c_of_type_ArrayOfByte, 0, this.jdField_c_of_type_Int) == -1) {
      return -1;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Int = encode(this.jdField_a_of_type_Int, this.jdField_c_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte, this.jdField_c_of_type_Int);
    }
    System.arraycopy(RecordParams.b(this.jdField_b_of_type_Int), 0, paramArrayOfByte, paramInt1, 2);
    System.arraycopy(this.jdField_d_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1 + 2, this.jdField_b_of_type_Int);
    return this.jdField_b_of_type_Int + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SilkCodecWrapper
 * JD-Core Version:    0.7.0.1
 */