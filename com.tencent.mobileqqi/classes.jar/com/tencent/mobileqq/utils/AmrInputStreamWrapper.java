package com.tencent.mobileqq.utils;

import android.content.Context;
import java.io.InputStream;

public final class AmrInputStreamWrapper
  extends InputStream
{
  private static final int jdField_a_of_type_Int = 160;
  private static final String jdField_a_of_type_JavaLangString = "AmrInputStream";
  private static boolean jdField_a_of_type_Boolean = false;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[320];
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[1];
  private int c = 0;
  private int d = 0;
  
  public AmrInputStreamWrapper(Context paramContext, InputStream paramInputStream)
  {
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtil.a(paramContext, "amrnb", 2))) {
      jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
    this.jdField_b_of_type_Int = GsmAmrEncoderNew();
    GsmAmrEncoderInitialize(this.jdField_b_of_type_Int);
  }
  
  private static native void GsmAmrEncoderCleanup(int paramInt);
  
  private static native void GsmAmrEncoderDelete(int paramInt);
  
  private static native int GsmAmrEncoderEncode(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
  
  private static native void GsmAmrEncoderInitialize(int paramInt);
  
  private static native int GsmAmrEncoderNew();
  
  public static int a()
  {
    return GsmAmrEncoderNew();
  }
  
  public static void a(Context paramContext)
  {
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtil.a(paramContext, "amrnb", 2))) {
      jdField_a_of_type_Boolean = true;
    }
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 42	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   11: invokevirtual 60	java/io/InputStream:close	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 42	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   19: aload_0
    //   20: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   23: ifeq +10 -> 33
    //   26: aload_0
    //   27: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   30: invokestatic 62	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(I)V
    //   33: aload_0
    //   34: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   37: ifeq +10 -> 47
    //   40: aload_0
    //   41: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   44: invokestatic 64	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(I)V
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   52: return
    //   53: astore_1
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: aload_0
    //   63: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   66: ifeq +10 -> 76
    //   69: aload_0
    //   70: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   73: invokestatic 64	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(I)V
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield 42	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   97: aload_0
    //   98: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   101: ifeq +10 -> 111
    //   104: aload_0
    //   105: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   108: invokestatic 62	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(I)V
    //   111: aload_0
    //   112: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   115: ifeq +10 -> 125
    //   118: aload_0
    //   119: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   122: invokestatic 64	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(I)V
    //   125: aload_0
    //   126: iconst_0
    //   127: putfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   145: ifeq +10 -> 155
    //   148: aload_0
    //   149: getfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   152: invokestatic 64	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(I)V
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: aload_0
    //   164: iconst_0
    //   165: putfield 48	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Int	I
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	AmrInputStreamWrapper
    //   53	7	1	localObject1	java.lang.Object
    //   61	21	1	localObject2	java.lang.Object
    //   83	7	1	localObject3	java.lang.Object
    //   91	40	1	localObject4	java.lang.Object
    //   132	7	1	localObject5	java.lang.Object
    //   140	21	1	localObject6	java.lang.Object
    //   162	7	1	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   33	47	53	finally
    //   19	33	61	finally
    //   62	76	83	finally
    //   0	14	91	finally
    //   111	125	132	finally
    //   97	111	140	finally
    //   141	155	162	finally
  }
  
  protected void finalize()
  {
    if (this.jdField_b_of_type_Int != 0) {}
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
    if (read(this.jdField_b_of_type_ArrayOfByte, 0, 1) == 1) {
      return this.jdField_b_of_type_ArrayOfByte[0] & 0xFF;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Int == 0) {
      throw new IllegalStateException("not open");
    }
    if (this.d >= this.c)
    {
      this.d = 0;
      this.c = 0;
      i = 0;
      while (i < 320)
      {
        int j = this.jdField_a_of_type_JavaIoInputStream.read(this.jdField_a_of_type_ArrayOfByte, i, 320 - i);
        if (j == -1) {
          return -1;
        }
        i += j;
      }
      this.c = GsmAmrEncoderEncode(this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0);
    }
    int i = paramInt2;
    if (paramInt2 > this.c - this.d) {
      i = this.c - this.d;
    }
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, this.d, paramArrayOfByte, paramInt1, i);
    this.d += i;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AmrInputStreamWrapper
 * JD-Core Version:    0.7.0.1
 */