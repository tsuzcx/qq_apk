package tmsdk.common.d.a.b;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import tmsdk.common.tcc.TccCryptor;

public class b
{
  @Deprecated
  public static JceStruct a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, JceStruct paramJceStruct)
  {
    if (paramArrayOfByte2 != null)
    {
      if (paramArrayOfByte2.length == 0) {
        return null;
      }
      paramContext = b(paramContext, paramArrayOfByte1, paramArrayOfByte2);
      if (paramContext == null) {
        return null;
      }
      return h.a(paramContext, paramJceStruct);
    }
    return null;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, JceStruct paramJceStruct)
  {
    paramArrayOfByte = b(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return null;
    }
    return h.a(paramArrayOfByte, paramJceStruct);
  }
  
  @Deprecated
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    paramContext = a(paramJceStruct);
    if (paramContext == null) {
      return null;
    }
    return TccCryptor.encrypt(paramContext, paramArrayOfByte);
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramContext = a(paramArrayOfByte2);
    if (paramContext == null) {
      return null;
    }
    return TccCryptor.encrypt(paramContext, paramArrayOfByte1);
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    paramJceStruct = a(h.a(paramJceStruct));
    if (paramJceStruct == null) {
      return null;
    }
    return paramJceStruct;
  }
  
  /* Error */
  private static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 38	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 42	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 44	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 47	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 51	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 54	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 58	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 61	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 62	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: goto +25 -> 74
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   57: aload_1
    //   58: invokevirtual 61	java/io/ByteArrayOutputStream:close	()V
    //   61: aload_2
    //   62: invokevirtual 62	java/util/zip/DeflaterOutputStream:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   72: aconst_null
    //   73: areturn
    //   74: aload_1
    //   75: invokevirtual 61	java/io/ByteArrayOutputStream:close	()V
    //   78: aload_2
    //   79: invokevirtual 62	java/util/zip/DeflaterOutputStream:close	()V
    //   82: goto +8 -> 90
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   41	34	1	localIOException1	java.io.IOException
    //   85	2	1	localIOException2	java.io.IOException
    //   16	63	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   53	57	48	finally
    //   17	31	52	java/io/IOException
    //   57	65	67	java/io/IOException
    //   74	82	85	java/io/IOException
  }
  
  public static byte[] b(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 != null) {
      if (paramArrayOfByte2.length == 0) {
        return null;
      }
    }
    try
    {
      paramContext = TccCryptor.decrypt(paramArrayOfByte2, paramArrayOfByte1);
      if (paramContext == null) {
        return null;
      }
      return b(paramContext);
    }
    catch (Exception paramContext) {}
    return null;
    return null;
  }
  
  /* Error */
  private static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 72	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 74	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 76	java/util/zip/InflaterInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 79	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 38	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 42	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 83	java/util/zip/InflaterInputStream:read	()I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +11 -> 44
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 86	java/io/ByteArrayOutputStream:write	(I)V
    //   41: goto -15 -> 26
    //   44: aload_3
    //   45: invokevirtual 58	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 87	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: invokevirtual 88	java/util/zip/InflaterInputStream:close	()V
    //   58: aload_3
    //   59: invokevirtual 61	java/io/ByteArrayOutputStream:close	()V
    //   62: aload 4
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   70: aload 4
    //   72: areturn
    //   73: astore 4
    //   75: goto +31 -> 106
    //   78: astore 4
    //   80: aload 4
    //   82: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   85: aload_0
    //   86: invokevirtual 87	java/io/ByteArrayInputStream:close	()V
    //   89: aload_2
    //   90: invokevirtual 88	java/util/zip/InflaterInputStream:close	()V
    //   93: aload_3
    //   94: invokevirtual 61	java/io/ByteArrayOutputStream:close	()V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   104: aconst_null
    //   105: areturn
    //   106: aload_0
    //   107: invokevirtual 87	java/io/ByteArrayInputStream:close	()V
    //   110: aload_2
    //   111: invokevirtual 88	java/util/zip/InflaterInputStream:close	()V
    //   114: aload_3
    //   115: invokevirtual 61	java/io/ByteArrayOutputStream:close	()V
    //   118: goto +8 -> 126
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   126: aload 4
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramArrayOfByte	byte[]
    //   30	8	1	i	int
    //   17	94	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   25	90	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   48	23	4	arrayOfByte	byte[]
    //   73	1	4	localObject	Object
    //   78	49	4	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   50	62	65	java/io/IOException
    //   26	31	73	finally
    //   36	41	73	finally
    //   44	50	73	finally
    //   80	85	73	finally
    //   26	31	78	java/io/IOException
    //   36	41	78	java/io/IOException
    //   44	50	78	java/io/IOException
    //   85	97	99	java/io/IOException
    //   106	118	121	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */