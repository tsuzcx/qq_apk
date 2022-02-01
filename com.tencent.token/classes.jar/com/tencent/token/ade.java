package com.tencent.token;

public final class ade
{
  /* Error */
  public static java.lang.String a(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 8
    //   2: astore_2
    //   3: aload_0
    //   4: invokevirtual 14	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: astore_3
    //   8: new 16	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_3
    //   13: aload_3
    //   14: aload_0
    //   15: invokevirtual 14	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: aload_1
    //   19: iconst_0
    //   20: invokevirtual 22	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   23: getfield 28	android/content/pm/ApplicationInfo:uid	I
    //   26: invokevirtual 32	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   29: iconst_0
    //   30: aaload
    //   31: bipush 64
    //   33: invokevirtual 36	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   36: getfield 42	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   39: iconst_0
    //   40: aaload
    //   41: invokevirtual 48	android/content/pm/Signature:toByteArray	()[B
    //   44: invokespecial 52	java/io/ByteArrayInputStream:<init>	([B)V
    //   47: astore_0
    //   48: ldc 54
    //   50: invokestatic 60	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   53: aload_0
    //   54: invokevirtual 64	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   57: checkcast 66	java/security/cert/X509Certificate
    //   60: invokevirtual 69	java/security/cert/X509Certificate:getEncoded	()[B
    //   63: invokestatic 74	com/tencent/token/ahr:a	([B)Ljava/lang/String;
    //   66: astore_1
    //   67: aload_0
    //   68: invokevirtual 78	java/io/ByteArrayInputStream:close	()V
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_0
    //   76: ifnull +8 -> 84
    //   79: aload_2
    //   80: astore_1
    //   81: goto -14 -> 67
    //   84: ldc 8
    //   86: areturn
    //   87: astore_0
    //   88: goto -15 -> 73
    //   91: astore_1
    //   92: goto -17 -> 75
    //   95: astore_0
    //   96: aload_1
    //   97: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	android.content.Context
    //   0	98	1	paramString	java.lang.String
    //   2	78	2	str	java.lang.String
    //   7	7	3	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   3	48	87	finally
    //   48	67	91	finally
    //   67	71	95	finally
  }
  
  /* Error */
  public static java.util.List<java.lang.String> a(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 84	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 86	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 88	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 91	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_0
    //   19: ldc 93
    //   21: invokevirtual 97	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   24: sipush 8192
    //   27: newarray byte
    //   29: invokestatic 100	com/tencent/token/ade:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +43 -> 79
    //   39: aload 4
    //   41: arraylength
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge +32 -> 79
    //   50: aload_3
    //   51: aload 4
    //   53: iload_1
    //   54: aaload
    //   55: invokevirtual 103	java/security/cert/Certificate:getEncoded	()[B
    //   58: invokestatic 74	com/tencent/token/ahr:a	([B)Ljava/lang/String;
    //   61: invokevirtual 107	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   64: pop
    //   65: iload_1
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: goto -24 -> 45
    //   72: astore_3
    //   73: aload_0
    //   74: invokevirtual 108	java/util/jar/JarFile:close	()V
    //   77: aload_3
    //   78: athrow
    //   79: aload_0
    //   80: invokevirtual 108	java/util/jar/JarFile:close	()V
    //   83: aload_3
    //   84: areturn
    //   85: astore 4
    //   87: goto -8 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramFile	java.io.File
    //   44	25	1	i	int
    //   42	6	2	j	int
    //   7	44	3	localArrayList	java.util.ArrayList
    //   72	12	3	localList	java.util.List<java.lang.String>
    //   32	20	4	arrayOfCertificate	java.security.cert.Certificate[]
    //   85	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   17	34	72	finally
    //   39	43	72	finally
    //   50	65	72	finally
    //   17	34	85	java/lang/Exception
    //   39	43	85	java/lang/Exception
    //   50	65	85	java/lang/Exception
  }
  
  /* Error */
  private static java.security.cert.Certificate[] a(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 116	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   7: astore_0
    //   8: aload_0
    //   9: aload_2
    //   10: iconst_0
    //   11: sipush 8192
    //   14: invokevirtual 122	java/io/InputStream:read	([BII)I
    //   17: iconst_m1
    //   18: if_icmpne -10 -> 8
    //   21: aload_3
    //   22: astore_2
    //   23: aload_1
    //   24: ifnull +8 -> 32
    //   27: aload_1
    //   28: invokevirtual 128	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   31: astore_2
    //   32: aload_0
    //   33: invokevirtual 129	java/io/InputStream:close	()V
    //   36: aload_2
    //   37: areturn
    //   38: astore_2
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: astore_0
    //   43: goto +6 -> 49
    //   46: astore_0
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +7 -> 57
    //   53: aload_1
    //   54: invokevirtual 129	java/io/InputStream:close	()V
    //   57: aload_0
    //   58: athrow
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokevirtual 129	java/io/InputStream:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_0
    //   72: goto -13 -> 59
    //   75: astore_1
    //   76: goto -15 -> 61
    //   79: astore_0
    //   80: aload_2
    //   81: areturn
    //   82: astore_1
    //   83: goto -26 -> 57
    //   86: astore_0
    //   87: aconst_null
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramJarFile	java.util.jar.JarFile
    //   0	89	1	paramJarEntry	java.util.jar.JarEntry
    //   0	89	2	paramArrayOfByte	byte[]
    //   1	21	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	21	38	finally
    //   27	32	38	finally
    //   2	8	46	finally
    //   2	8	71	java/io/IOException
    //   8	21	75	java/io/IOException
    //   27	32	75	java/io/IOException
    //   32	36	79	java/io/IOException
    //   53	57	82	java/io/IOException
    //   65	69	86	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ade
 * JD-Core Version:    0.7.0.1
 */