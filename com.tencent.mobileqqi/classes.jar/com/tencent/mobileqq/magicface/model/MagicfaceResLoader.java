package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.File;

public class MagicfaceResLoader
{
  public static final String a = "MagicfaceResLoader";
  public static final String b = "audio";
  public static final String c = "big";
  public static final String d = "small";
  public String e = "big";
  private String f;
  
  public MagicfaceResLoader(String paramString)
  {
    this.f = paramString;
    if (DeviceInfoUtil.f() >= 480L)
    {
      this.e = "big";
      return;
    }
    this.e = "small";
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 41	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 43	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 47	java/io/File:exists	()Z
    //   16: istore 4
    //   18: iload 4
    //   20: ifne +11 -> 31
    //   23: new 49	java/lang/NullPointerException
    //   26: dup
    //   27: invokespecial 50	java/lang/NullPointerException:<init>	()V
    //   30: athrow
    //   31: new 52	java/io/FileInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 55	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 61	java/io/InputStream:available	()I
    //   44: istore_2
    //   45: iload_2
    //   46: newarray byte
    //   48: astore 6
    //   50: aload_1
    //   51: aload 6
    //   53: invokevirtual 65	java/io/InputStream:read	([B)I
    //   56: istore_3
    //   57: iload_3
    //   58: iload_2
    //   59: if_icmpeq +3 -> 62
    //   62: aload_1
    //   63: invokevirtual 68	java/io/InputStream:close	()V
    //   66: aload 6
    //   68: areturn
    //   69: astore_1
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 68	java/io/InputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: areturn
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 68	java/io/InputStream:close	()V
    //   88: aload 5
    //   90: areturn
    //   91: astore_1
    //   92: aload 5
    //   94: areturn
    //   95: astore_1
    //   96: aconst_null
    //   97: areturn
    //   98: astore_1
    //   99: goto -33 -> 66
    //   102: astore 6
    //   104: goto -20 -> 84
    //   107: astore 5
    //   109: aload 6
    //   111: astore 5
    //   113: goto -29 -> 84
    //   116: astore 5
    //   118: goto -46 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	MagicfaceResLoader
    //   0	121	1	paramString	String
    //   44	16	2	i	int
    //   56	4	3	j	int
    //   16	3	4	bool	boolean
    //   1	92	5	arrayOfByte1	byte[]
    //   107	1	5	localObject1	Object
    //   111	1	5	localObject2	Object
    //   116	1	5	localException	java.lang.Exception
    //   48	19	6	arrayOfByte2	byte[]
    //   102	8	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	18	69	java/lang/Exception
    //   31	40	69	java/lang/Exception
    //   72	76	78	java/lang/Exception
    //   3	18	81	finally
    //   31	40	81	finally
    //   84	88	91	java/lang/Exception
    //   23	31	95	java/lang/Exception
    //   62	66	98	java/lang/Exception
    //   40	50	102	finally
    //   50	57	107	finally
    //   40	50	116	java/lang/Exception
    //   50	57	116	java/lang/Exception
  }
  
  public MagicfaceData a(String paramString1, String paramString2)
  {
    MagicfaceData localMagicfaceData = new MagicfaceData();
    localMagicfaceData.b = a(this.f + this.e + File.separator + paramString1);
    localMagicfaceData.a = a(this.f + this.e + File.separator + paramString2);
    return localMagicfaceData;
  }
  
  public String a(String paramString)
  {
    return c(this.f + this.e + File.separator + paramString);
  }
  
  public String b(String paramString)
  {
    return this.f + "audio" + File.separator + paramString;
  }
  
  /* Error */
  public String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 41	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 43	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 47	java/io/File:exists	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +11 -> 29
    //   21: new 49	java/lang/NullPointerException
    //   24: dup
    //   25: invokespecial 50	java/lang/NullPointerException:<init>	()V
    //   28: athrow
    //   29: new 52	java/io/FileInputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 55	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_1
    //   42: aload 4
    //   44: invokevirtual 61	java/io/InputStream:available	()I
    //   47: newarray byte
    //   49: astore_3
    //   50: aload 4
    //   52: astore_1
    //   53: aload 4
    //   55: aload_3
    //   56: invokevirtual 65	java/io/InputStream:read	([B)I
    //   59: pop
    //   60: aload 4
    //   62: astore_1
    //   63: new 98	java/lang/String
    //   66: dup
    //   67: aload_3
    //   68: ldc 100
    //   70: invokespecial 103	java/lang/String:<init>	([BLjava/lang/String;)V
    //   73: astore_3
    //   74: aload 4
    //   76: astore_1
    //   77: aload_3
    //   78: ldc 105
    //   80: ldc 107
    //   82: invokevirtual 111	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 5
    //   87: aload 4
    //   89: invokevirtual 68	java/io/InputStream:close	()V
    //   92: aload 5
    //   94: areturn
    //   95: astore_1
    //   96: aload 5
    //   98: areturn
    //   99: astore_3
    //   100: aconst_null
    //   101: astore 4
    //   103: aload 4
    //   105: astore_1
    //   106: ldc 8
    //   108: iconst_2
    //   109: new 74	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   116: ldc 113
    //   118: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 116	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   125: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload 4
    //   136: invokevirtual 68	java/io/InputStream:close	()V
    //   139: aload 5
    //   141: areturn
    //   142: astore_1
    //   143: aload 5
    //   145: areturn
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 68	java/io/InputStream:close	()V
    //   153: aload_3
    //   154: athrow
    //   155: astore_1
    //   156: aconst_null
    //   157: areturn
    //   158: astore_1
    //   159: goto -6 -> 153
    //   162: astore_3
    //   163: goto -14 -> 149
    //   166: astore_3
    //   167: goto -64 -> 103
    //   170: astore_1
    //   171: aload_3
    //   172: astore 5
    //   174: aload_1
    //   175: astore_3
    //   176: goto -73 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	MagicfaceResLoader
    //   0	179	1	paramString	String
    //   16	2	2	bool	boolean
    //   49	29	3	localObject1	Object
    //   99	23	3	localException1	java.lang.Exception
    //   146	8	3	localObject2	Object
    //   162	1	3	localObject3	Object
    //   166	6	3	localException2	java.lang.Exception
    //   175	1	3	str	String
    //   37	98	4	localFileInputStream	java.io.FileInputStream
    //   1	172	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   87	92	95	java/lang/Exception
    //   3	17	99	java/lang/Exception
    //   29	39	99	java/lang/Exception
    //   134	139	142	java/lang/Exception
    //   3	17	146	finally
    //   29	39	146	finally
    //   21	29	155	java/lang/Exception
    //   149	153	158	java/lang/Exception
    //   42	50	162	finally
    //   53	60	162	finally
    //   63	74	162	finally
    //   77	87	162	finally
    //   106	134	162	finally
    //   42	50	166	java/lang/Exception
    //   53	60	166	java/lang/Exception
    //   63	74	166	java/lang/Exception
    //   77	87	170	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceResLoader
 * JD-Core Version:    0.7.0.1
 */