package com.tencent.smtt.utils;

import java.io.InputStream;
import java.security.MessageDigest;

public class Md5Utils
{
  /* Error */
  public static String getMD5(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: ldc 19
    //   12: invokestatic 25	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   15: astore 6
    //   17: aload 6
    //   19: astore_2
    //   20: new 27	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: sipush 8192
    //   32: newarray byte
    //   34: astore_3
    //   35: aload_0
    //   36: aload_3
    //   37: invokevirtual 34	java/io/FileInputStream:read	([B)I
    //   40: istore_1
    //   41: iload_1
    //   42: iconst_m1
    //   43: if_icmpeq +41 -> 84
    //   46: aload_2
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 38	java/security/MessageDigest:update	([BII)V
    //   53: goto -18 -> 35
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull +7 -> 65
    //   61: aload_0
    //   62: invokevirtual 41	java/io/FileInputStream:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore 6
    //   69: aload 6
    //   71: invokevirtual 44	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   74: goto -54 -> 20
    //   77: astore_0
    //   78: aload 4
    //   80: astore_0
    //   81: goto -24 -> 57
    //   84: aload_2
    //   85: invokevirtual 48	java/security/MessageDigest:digest	()[B
    //   88: invokestatic 54	com/tencent/smtt/utils/ByteUtils:byteToHexString	([B)Ljava/lang/String;
    //   91: astore_2
    //   92: aload_0
    //   93: ifnull +7 -> 100
    //   96: aload_0
    //   97: invokevirtual 41	java/io/FileInputStream:close	()V
    //   100: aload_2
    //   101: areturn
    //   102: astore_0
    //   103: aload 5
    //   105: astore_0
    //   106: aload_0
    //   107: ifnull -42 -> 65
    //   110: aload_0
    //   111: invokevirtual 41	java/io/FileInputStream:close	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_0
    //   124: aload_3
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 41	java/io/FileInputStream:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: goto -20 -> 117
    //   140: astore_2
    //   141: aload_2
    //   142: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   145: goto -11 -> 134
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   153: goto -53 -> 100
    //   156: astore_3
    //   157: aload_0
    //   158: astore_2
    //   159: aload_3
    //   160: astore_0
    //   161: goto -35 -> 126
    //   164: astore_2
    //   165: goto -59 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramFile	java.io.File
    //   40	10	1	i	int
    //   9	38	2	localObject1	Object
    //   56	29	2	localFileNotFoundException	java.io.FileNotFoundException
    //   91	40	2	localObject2	Object
    //   140	2	2	localIOException1	java.io.IOException
    //   158	1	2	localFile	java.io.File
    //   164	1	2	localIOException2	java.io.IOException
    //   4	121	3	arrayOfByte	byte[]
    //   156	4	3	localObject3	Object
    //   6	73	4	localObject4	Object
    //   1	103	5	localObject5	Object
    //   15	3	6	localMessageDigest	MessageDigest
    //   67	3	6	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    // Exception table:
    //   from	to	target	type
    //   29	35	56	java/io/FileNotFoundException
    //   35	41	56	java/io/FileNotFoundException
    //   46	53	56	java/io/FileNotFoundException
    //   84	92	56	java/io/FileNotFoundException
    //   10	17	67	java/security/NoSuchAlgorithmException
    //   10	17	77	java/io/FileNotFoundException
    //   20	29	77	java/io/FileNotFoundException
    //   69	74	77	java/io/FileNotFoundException
    //   10	17	102	java/io/IOException
    //   20	29	102	java/io/IOException
    //   69	74	102	java/io/IOException
    //   110	114	116	java/io/IOException
    //   10	17	123	finally
    //   20	29	123	finally
    //   69	74	123	finally
    //   61	65	136	java/io/IOException
    //   130	134	140	java/io/IOException
    //   96	100	148	java/io/IOException
    //   29	35	156	finally
    //   35	41	156	finally
    //   46	53	156	finally
    //   84	92	156	finally
    //   29	35	164	java/io/IOException
    //   35	41	164	java/io/IOException
    //   46	53	164	java/io/IOException
    //   84	92	164	java/io/IOException
  }
  
  public static String getMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString);
      paramString = ByteUtils.byteToHexString(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static byte[] getMD5(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        if (localMessageDigest != null)
        {
          byte[] arrayOfByte = new byte[8192];
          for (;;)
          {
            int i = paramInputStream.read(arrayOfByte);
            if (i == -1) {
              break;
            }
            localMessageDigest.update(arrayOfByte, 0, i);
          }
          paramInputStream = localMessageDigest.digest();
          return paramInputStream;
        }
      }
      catch (Throwable paramInputStream) {}
    }
    return null;
  }
  
  public static byte[] getMD5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.Md5Utils
 * JD-Core Version:    0.7.0.1
 */