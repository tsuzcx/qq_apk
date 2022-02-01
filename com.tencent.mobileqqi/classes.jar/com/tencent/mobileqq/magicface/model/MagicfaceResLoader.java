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
    //   44: istore_3
    //   45: iload_3
    //   46: newarray byte
    //   48: astore 6
    //   50: aload_1
    //   51: aload 6
    //   53: invokevirtual 65	java/io/InputStream:read	([B)I
    //   56: istore_2
    //   57: iload_2
    //   58: iload_3
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
    //   56	4	2	i	int
    //   44	16	3	j	int
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
    //   37: astore_3
    //   38: aload_3
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 61	java/io/InputStream:available	()I
    //   44: newarray byte
    //   46: astore 4
    //   48: aload_3
    //   49: astore_1
    //   50: aload_3
    //   51: aload 4
    //   53: invokevirtual 65	java/io/InputStream:read	([B)I
    //   56: pop
    //   57: aload_3
    //   58: astore_1
    //   59: new 98	java/lang/String
    //   62: dup
    //   63: aload 4
    //   65: ldc 100
    //   67: invokespecial 103	java/lang/String:<init>	([BLjava/lang/String;)V
    //   70: astore 4
    //   72: aload_3
    //   73: astore_1
    //   74: aload 4
    //   76: ldc 105
    //   78: ldc 107
    //   80: invokevirtual 111	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 5
    //   85: aload_3
    //   86: invokevirtual 68	java/io/InputStream:close	()V
    //   89: aload 5
    //   91: areturn
    //   92: astore_1
    //   93: aload 5
    //   95: areturn
    //   96: astore 4
    //   98: aconst_null
    //   99: astore_3
    //   100: aload_3
    //   101: astore_1
    //   102: ldc 8
    //   104: iconst_2
    //   105: new 74	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   112: ldc 113
    //   114: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 4
    //   119: invokevirtual 116	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_3
    //   132: invokevirtual 68	java/io/InputStream:close	()V
    //   135: aload 5
    //   137: areturn
    //   138: astore_1
    //   139: aload 5
    //   141: areturn
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 68	java/io/InputStream:close	()V
    //   149: aload_3
    //   150: athrow
    //   151: astore_1
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: goto -6 -> 149
    //   158: astore_3
    //   159: goto -14 -> 145
    //   162: astore 4
    //   164: goto -64 -> 100
    //   167: astore_1
    //   168: aload 4
    //   170: astore 5
    //   172: aload_1
    //   173: astore 4
    //   175: goto -75 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	MagicfaceResLoader
    //   0	178	1	paramString	String
    //   16	2	2	bool	boolean
    //   37	95	3	localFileInputStream	java.io.FileInputStream
    //   142	8	3	localObject1	Object
    //   158	1	3	localObject2	Object
    //   46	29	4	localObject3	Object
    //   96	22	4	localException1	java.lang.Exception
    //   162	7	4	localException2	java.lang.Exception
    //   173	1	4	str	String
    //   1	170	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   85	89	92	java/lang/Exception
    //   3	17	96	java/lang/Exception
    //   29	38	96	java/lang/Exception
    //   131	135	138	java/lang/Exception
    //   3	17	142	finally
    //   29	38	142	finally
    //   21	29	151	java/lang/Exception
    //   145	149	154	java/lang/Exception
    //   40	48	158	finally
    //   50	57	158	finally
    //   59	72	158	finally
    //   74	85	158	finally
    //   102	131	158	finally
    //   40	48	162	java/lang/Exception
    //   50	57	162	java/lang/Exception
    //   59	72	162	java/lang/Exception
    //   74	85	167	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceResLoader
 * JD-Core Version:    0.7.0.1
 */