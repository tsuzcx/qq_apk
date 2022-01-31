package common.qzone.component.util;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil
{
  private static final long jdField_a_of_type_Long = -7661587058870466123L;
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static long[] jdField_a_of_type_ArrayOfLong = new long[256];
  private static final long b = -1L;
  
  static
  {
    int i = 0;
    while (i < 256)
    {
      long l1 = i;
      int j = 0;
      if (j < 8)
      {
        if (((int)l1 & 0x1) != 0) {}
        for (long l2 = -7661587058870466123L;; l2 = 0L)
        {
          l1 = l1 >> 1 ^ l2;
          j += 1;
          break;
        }
      }
      jdField_a_of_type_ArrayOfLong[i] = l1;
      i += 1;
    }
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    long l = -1L;
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      l = l >> 8 ^ jdField_a_of_type_ArrayOfLong[(((int)l ^ paramArrayOfByte[i]) & 0xFF)];
      i += 1;
    }
    return l;
  }
  
  public static String a(File paramFile)
  {
    return a(paramFile, "MD5");
  }
  
  /* Error */
  public static String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_3
    //   6: aload_0
    //   7: ifnull +23 -> 30
    //   10: aload 4
    //   12: astore_3
    //   13: aload_0
    //   14: invokevirtual 56	java/io/File:exists	()Z
    //   17: ifeq +13 -> 30
    //   20: aload_0
    //   21: invokevirtual 59	java/io/File:isFile	()Z
    //   24: ifne +8 -> 32
    //   27: aload 4
    //   29: astore_3
    //   30: aload_3
    //   31: areturn
    //   32: aload_1
    //   33: invokestatic 65	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   36: astore_1
    //   37: new 67	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 70	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_0
    //   46: sipush 1024
    //   49: newarray byte
    //   51: astore_3
    //   52: aload_0
    //   53: aload_3
    //   54: invokevirtual 74	java/io/FileInputStream:read	([B)I
    //   57: istore_2
    //   58: iload_2
    //   59: ifle +30 -> 89
    //   62: aload_1
    //   63: aload_3
    //   64: iconst_0
    //   65: iload_2
    //   66: invokevirtual 78	java/security/MessageDigest:update	([BII)V
    //   69: goto -17 -> 52
    //   72: astore_1
    //   73: aload 4
    //   75: astore_3
    //   76: aload_0
    //   77: ifnull -47 -> 30
    //   80: aload_0
    //   81: invokevirtual 81	java/io/FileInputStream:close	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: areturn
    //   89: aload_1
    //   90: invokevirtual 85	java/security/MessageDigest:digest	()[B
    //   93: invokestatic 88	common/qzone/component/util/SecurityUtil:a	([B)Ljava/lang/String;
    //   96: astore_1
    //   97: aload_1
    //   98: astore_3
    //   99: aload_0
    //   100: ifnull -70 -> 30
    //   103: aload_0
    //   104: invokevirtual 81	java/io/FileInputStream:close	()V
    //   107: aload_1
    //   108: areturn
    //   109: astore_0
    //   110: aload_1
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_0
    //   115: aload 4
    //   117: astore_3
    //   118: aload_0
    //   119: ifnull -89 -> 30
    //   122: aload_0
    //   123: invokevirtual 81	java/io/FileInputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aconst_null
    //   130: areturn
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_0
    //   134: aload_0
    //   135: ifnull +7 -> 142
    //   138: aload_0
    //   139: invokevirtual 81	java/io/FileInputStream:close	()V
    //   142: aload_1
    //   143: athrow
    //   144: astore_0
    //   145: goto -3 -> 142
    //   148: astore_1
    //   149: goto -15 -> 134
    //   152: astore_1
    //   153: goto -38 -> 115
    //   156: astore_0
    //   157: aconst_null
    //   158: astore_0
    //   159: goto -86 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramFile	File
    //   0	162	1	paramString	String
    //   57	9	2	i	int
    //   5	113	3	localObject1	Object
    //   1	115	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   46	52	72	java/io/IOException
    //   52	58	72	java/io/IOException
    //   62	69	72	java/io/IOException
    //   89	97	72	java/io/IOException
    //   80	84	86	java/io/IOException
    //   103	107	109	java/io/IOException
    //   32	46	112	java/security/NoSuchAlgorithmException
    //   122	126	128	java/io/IOException
    //   32	46	131	finally
    //   138	142	144	java/io/IOException
    //   46	52	148	finally
    //   52	58	148	finally
    //   62	69	148	finally
    //   89	97	148	finally
    //   46	52	152	java/security/NoSuchAlgorithmException
    //   52	58	152	java/security/NoSuchAlgorithmException
    //   62	69	152	java/security/NoSuchAlgorithmException
    //   89	97	152	java/security/NoSuchAlgorithmException
    //   32	46	156	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    return a(paramString, "MD5");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString2 = MessageDigest.getInstance(paramString2);
      paramString2.update(paramString1.getBytes());
      paramString1 = a(paramString2.digest());
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1) {}
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramString.length() * 2];
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int j = 0;
    while (i < k)
    {
      int m = paramString[i];
      int n = j + 1;
      arrayOfByte[j] = ((byte)(m & 0xFF));
      j = n + 1;
      arrayOfByte[n] = ((byte)(m >> 8));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     common.qzone.component.util.SecurityUtil
 * JD-Core Version:    0.7.0.1
 */