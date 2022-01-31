import android.os.AsyncTask;
import java.io.File;

public class uya
  extends AsyncTask<uyc, uye, uyd>
{
  public final umx a;
  
  public uya(umx paramumx)
  {
    if (paramumx == null) {
      throw new IllegalArgumentException("downloader should not be null");
    }
    this.a = paramumx;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: sipush 1024
    //   5: newarray byte
    //   7: astore 4
    //   9: new 29	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: ldc 32
    //   22: invokestatic 38	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   25: astore 5
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: aload 4
    //   32: invokevirtual 44	java/io/InputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle +41 -> 78
    //   40: aload_2
    //   41: astore_0
    //   42: aload 5
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 48	java/security/MessageDigest:update	([BII)V
    //   51: goto -24 -> 27
    //   54: astore_0
    //   55: aload_2
    //   56: astore_0
    //   57: ldc 50
    //   59: ldc 52
    //   61: invokestatic 57	wxe:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_3
    //   65: astore_0
    //   66: aload_2
    //   67: ifnull +9 -> 76
    //   70: aload_2
    //   71: invokevirtual 60	java/io/InputStream:close	()V
    //   74: aload_3
    //   75: astore_0
    //   76: aload_0
    //   77: areturn
    //   78: aload_2
    //   79: astore_0
    //   80: aload 5
    //   82: invokevirtual 64	java/security/MessageDigest:digest	()[B
    //   85: invokestatic 67	uya:a	([B)Ljava/lang/String;
    //   88: astore 4
    //   90: aload 4
    //   92: astore_3
    //   93: aload_3
    //   94: astore_0
    //   95: aload_2
    //   96: ifnull -20 -> 76
    //   99: aload_2
    //   100: invokevirtual 60	java/io/InputStream:close	()V
    //   103: aload_3
    //   104: areturn
    //   105: astore_0
    //   106: aload_3
    //   107: areturn
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 60	java/io/InputStream:close	()V
    //   119: aload_2
    //   120: athrow
    //   121: astore_0
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: goto -6 -> 119
    //   128: astore_2
    //   129: goto -18 -> 111
    //   132: astore_0
    //   133: aconst_null
    //   134: astore_2
    //   135: goto -80 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString	String
    //   35	13	1	i	int
    //   17	83	2	localFileInputStream	java.io.FileInputStream
    //   108	12	2	localObject1	java.lang.Object
    //   128	1	2	localObject2	java.lang.Object
    //   134	1	2	localObject3	java.lang.Object
    //   1	106	3	localObject4	java.lang.Object
    //   7	84	4	localObject5	java.lang.Object
    //   25	56	5	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   20	27	54	java/lang/Exception
    //   29	36	54	java/lang/Exception
    //   42	51	54	java/lang/Exception
    //   80	90	54	java/lang/Exception
    //   99	103	105	java/io/IOException
    //   2	18	108	finally
    //   70	74	121	java/io/IOException
    //   115	119	124	java/io/IOException
    //   20	27	128	finally
    //   29	36	128	finally
    //   42	51	128	finally
    //   57	64	128	finally
    //   80	90	128	finally
    //   2	18	132	java/lang/Exception
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 65;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 66;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 67;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 68;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 69;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 70;
    tmp92_86;
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(arrayOfChar[((k & 0xF0) >>> 4)]);
      localStringBuilder.append(arrayOfChar[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(String paramString)
  {
    wxe.b("FileDownloadTask", paramString);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!localFile.exists()) {}
    while (localFile.isDirectory()) {
      return false;
    }
    if (paramString2 == null) {
      return true;
    }
    paramString1 = a(paramString1);
    wxe.b("FileDownloadTask", "expectedMd5 = " + paramString2);
    wxe.b("FileDownloadTask", "file Md5    = " + paramString1);
    return paramString2.equalsIgnoreCase(paramString1);
  }
  
  protected uyd a(uyc... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (a(paramVarArgs.b, paramVarArgs.c))
    {
      a("already has local file, don't need download");
      return new uyd(paramVarArgs, 0, "has local file already");
    }
    this.a.a(new uyb(this, paramVarArgs));
    int i = this.a.a(paramVarArgs.a, paramVarArgs.b, 0L);
    a("download finish : " + i);
    if ((i == 0) && (!a(paramVarArgs.b, paramVarArgs.c)))
    {
      a("delete the downloaded file because of md5 mismatch");
      try
      {
        xrg.d(paramVarArgs.b);
        return new uyd(paramVarArgs, -1, "file md5 mismatch");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    return new uyd(paramVarArgs, i, "error=" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uya
 * JD-Core Version:    0.7.0.1
 */