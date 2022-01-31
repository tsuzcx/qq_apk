package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MagicfaceResLoader
{
  public static final String a = "MagicfaceResLoader";
  public static final String b = "audio";
  public static final String c = "small";
  public static final String d = "big";
  public static final String e = "xbig";
  public static final String f = "sbig";
  public static String g = null;
  private String h;
  
  public MagicfaceResLoader(String paramString)
  {
    this.h = paramString;
    a();
  }
  
  public static String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceResLoader", 2, "func getVideoPath begins.");
    }
    if (g != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[1]. videoPath:" + g);
      }
      return g;
    }
    long l = Math.min(DeviceInfoUtil.f(), DeviceInfoUtil.g());
    boolean bool = DeviceInfoUtil.e();
    int i;
    if (DeviceInfoUtil.b() >= 2)
    {
      i = 1;
      if (l < 480L) {
        break label159;
      }
      if (!bool) {
        break label139;
      }
      g = "sbig";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[2]. videoPath:" + g);
      }
      return g;
      i = 0;
      break;
      label139:
      if (i != 0)
      {
        g = "xbig";
      }
      else
      {
        g = "big";
        continue;
        label159:
        if (l >= 640L)
        {
          if (i != 0) {
            g = "xbig";
          } else {
            g = "big";
          }
        }
        else if (l >= 852L) {
          g = "big";
        } else {
          g = "small";
        }
      }
    }
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 93	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: astore 5
    //   17: aload 7
    //   19: invokevirtual 98	java/io/File:exists	()Z
    //   22: ifne +40 -> 62
    //   25: new 93	java/io/File
    //   28: dup
    //   29: aload_1
    //   30: ldc 20
    //   32: ldc 17
    //   34: invokevirtual 104	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   37: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore 5
    //   42: aload 5
    //   44: invokevirtual 98	java/io/File:exists	()Z
    //   47: istore 4
    //   49: iload 4
    //   51: ifne +11 -> 62
    //   54: new 106	java/lang/NullPointerException
    //   57: dup
    //   58: invokespecial 107	java/lang/NullPointerException:<init>	()V
    //   61: athrow
    //   62: new 109	java/io/FileInputStream
    //   65: dup
    //   66: aload 5
    //   68: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 117	java/io/InputStream:available	()I
    //   76: istore_2
    //   77: iload_2
    //   78: newarray byte
    //   80: astore 5
    //   82: aload_1
    //   83: aload 5
    //   85: invokevirtual 121	java/io/InputStream:read	([B)I
    //   88: istore_3
    //   89: iload_3
    //   90: iload_2
    //   91: if_icmpeq +3 -> 94
    //   94: aload_1
    //   95: invokevirtual 124	java/io/InputStream:close	()V
    //   98: aload 5
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 124	java/io/InputStream:close	()V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_1
    //   111: aconst_null
    //   112: areturn
    //   113: astore_1
    //   114: aconst_null
    //   115: astore_1
    //   116: aload 6
    //   118: astore 5
    //   120: aload_1
    //   121: invokevirtual 124	java/io/InputStream:close	()V
    //   124: aload 5
    //   126: areturn
    //   127: astore_1
    //   128: aload 5
    //   130: areturn
    //   131: astore_1
    //   132: aconst_null
    //   133: areturn
    //   134: astore_1
    //   135: goto -37 -> 98
    //   138: astore 5
    //   140: aload 6
    //   142: astore 5
    //   144: goto -24 -> 120
    //   147: astore 6
    //   149: goto -29 -> 120
    //   152: astore 5
    //   154: goto -50 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	MagicfaceResLoader
    //   0	157	1	paramString	String
    //   76	16	2	i	int
    //   88	4	3	j	int
    //   47	3	4	bool	boolean
    //   15	114	5	localObject1	Object
    //   138	1	5	localObject2	Object
    //   142	1	5	localObject3	Object
    //   152	1	5	localException	java.lang.Exception
    //   1	140	6	localObject4	Object
    //   147	1	6	localObject5	Object
    //   11	7	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   3	13	101	java/lang/Exception
    //   17	49	101	java/lang/Exception
    //   62	72	101	java/lang/Exception
    //   104	108	110	java/lang/Exception
    //   3	13	113	finally
    //   17	49	113	finally
    //   62	72	113	finally
    //   120	124	127	java/lang/Exception
    //   54	62	131	java/lang/Exception
    //   94	98	134	java/lang/Exception
    //   72	82	138	finally
    //   82	89	147	finally
    //   72	82	152	java/lang/Exception
    //   82	89	152	java/lang/Exception
  }
  
  public String a(String paramString)
  {
    return c(this.h + g + File.separator + paramString);
  }
  
  public String b(String paramString)
  {
    return this.h + "audio" + File.separator + paramString;
  }
  
  /* Error */
  public String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 93	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: aload 4
    //   15: astore_3
    //   16: aload 4
    //   18: invokevirtual 98	java/io/File:exists	()Z
    //   21: ifne +36 -> 57
    //   24: new 93	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: ldc 20
    //   31: ldc 17
    //   33: invokevirtual 104	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   36: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_3
    //   40: aload_3
    //   41: invokevirtual 98	java/io/File:exists	()Z
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +11 -> 57
    //   49: new 106	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 107	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: new 109	java/io/FileInputStream
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: astore_3
    //   66: aload_3
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 117	java/io/InputStream:available	()I
    //   72: newarray byte
    //   74: astore 4
    //   76: aload_3
    //   77: astore_1
    //   78: aload_3
    //   79: aload 4
    //   81: invokevirtual 121	java/io/InputStream:read	([B)I
    //   84: pop
    //   85: aload_3
    //   86: astore_1
    //   87: new 100	java/lang/String
    //   90: dup
    //   91: aload 4
    //   93: ldc 132
    //   95: invokespecial 135	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: astore 4
    //   100: aload_3
    //   101: astore_1
    //   102: aload 4
    //   104: ldc 137
    //   106: ldc 139
    //   108: invokevirtual 143	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 5
    //   113: aload_3
    //   114: invokevirtual 124	java/io/InputStream:close	()V
    //   117: aload 5
    //   119: areturn
    //   120: astore_1
    //   121: aload 5
    //   123: areturn
    //   124: astore 4
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_3
    //   129: astore_1
    //   130: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +34 -> 167
    //   136: aload_3
    //   137: astore_1
    //   138: ldc 8
    //   140: iconst_2
    //   141: new 52	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   148: ldc 145
    //   150: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 4
    //   155: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_3
    //   168: invokevirtual 124	java/io/InputStream:close	()V
    //   171: aload 5
    //   173: areturn
    //   174: astore_1
    //   175: aload 5
    //   177: areturn
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 124	java/io/InputStream:close	()V
    //   185: aload_3
    //   186: athrow
    //   187: astore_1
    //   188: aconst_null
    //   189: areturn
    //   190: astore_1
    //   191: goto -6 -> 185
    //   194: astore_3
    //   195: goto -14 -> 181
    //   198: astore 4
    //   200: goto -72 -> 128
    //   203: astore_1
    //   204: aload 4
    //   206: astore 5
    //   208: aload_1
    //   209: astore 4
    //   211: goto -83 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	MagicfaceResLoader
    //   0	214	1	paramString	String
    //   44	2	2	bool	boolean
    //   15	153	3	localObject1	Object
    //   178	8	3	localObject2	Object
    //   194	1	3	localObject3	Object
    //   11	92	4	localObject4	Object
    //   124	30	4	localException1	java.lang.Exception
    //   198	7	4	localException2	java.lang.Exception
    //   209	1	4	str	String
    //   1	206	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   113	117	120	java/lang/Exception
    //   3	13	124	java/lang/Exception
    //   16	45	124	java/lang/Exception
    //   57	66	124	java/lang/Exception
    //   167	171	174	java/lang/Exception
    //   3	13	178	finally
    //   16	45	178	finally
    //   57	66	178	finally
    //   49	57	187	java/lang/Exception
    //   181	185	190	java/lang/Exception
    //   68	76	194	finally
    //   78	85	194	finally
    //   87	100	194	finally
    //   102	113	194	finally
    //   130	136	194	finally
    //   138	167	194	finally
    //   68	76	198	java/lang/Exception
    //   78	85	198	java/lang/Exception
    //   87	100	198	java/lang/Exception
    //   102	113	203	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceResLoader
 * JD-Core Version:    0.7.0.1
 */