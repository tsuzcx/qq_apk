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
    //   76: istore_3
    //   77: iload_3
    //   78: newarray byte
    //   80: astore 5
    //   82: aload_1
    //   83: aload 5
    //   85: invokevirtual 121	java/io/InputStream:read	([B)I
    //   88: istore_2
    //   89: iload_2
    //   90: iload_3
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
    //   88	4	2	i	int
    //   76	16	3	j	int
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
    //   65: astore 4
    //   67: aload 4
    //   69: astore_1
    //   70: aload 4
    //   72: invokevirtual 117	java/io/InputStream:available	()I
    //   75: newarray byte
    //   77: astore_3
    //   78: aload 4
    //   80: astore_1
    //   81: aload 4
    //   83: aload_3
    //   84: invokevirtual 121	java/io/InputStream:read	([B)I
    //   87: pop
    //   88: aload 4
    //   90: astore_1
    //   91: new 100	java/lang/String
    //   94: dup
    //   95: aload_3
    //   96: ldc 132
    //   98: invokespecial 135	java/lang/String:<init>	([BLjava/lang/String;)V
    //   101: astore_3
    //   102: aload 4
    //   104: astore_1
    //   105: aload_3
    //   106: ldc 137
    //   108: ldc 139
    //   110: invokevirtual 143	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 5
    //   115: aload 4
    //   117: invokevirtual 124	java/io/InputStream:close	()V
    //   120: aload 5
    //   122: areturn
    //   123: astore_1
    //   124: aload 5
    //   126: areturn
    //   127: astore_3
    //   128: aconst_null
    //   129: astore 4
    //   131: aload 4
    //   133: astore_1
    //   134: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +34 -> 171
    //   140: aload 4
    //   142: astore_1
    //   143: ldc 8
    //   145: iconst_2
    //   146: new 52	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   153: ldc 145
    //   155: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_3
    //   159: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 4
    //   173: invokevirtual 124	java/io/InputStream:close	()V
    //   176: aload 5
    //   178: areturn
    //   179: astore_1
    //   180: aload 5
    //   182: areturn
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 124	java/io/InputStream:close	()V
    //   190: aload_3
    //   191: athrow
    //   192: astore_1
    //   193: aconst_null
    //   194: areturn
    //   195: astore_1
    //   196: goto -6 -> 190
    //   199: astore_3
    //   200: goto -14 -> 186
    //   203: astore_3
    //   204: goto -73 -> 131
    //   207: astore_1
    //   208: aload_3
    //   209: astore 5
    //   211: aload_1
    //   212: astore_3
    //   213: goto -82 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	MagicfaceResLoader
    //   0	216	1	paramString	String
    //   44	2	2	bool	boolean
    //   15	91	3	localObject1	Object
    //   127	32	3	localException1	java.lang.Exception
    //   183	8	3	localObject2	Object
    //   199	1	3	localObject3	Object
    //   203	6	3	localException2	java.lang.Exception
    //   212	1	3	str	String
    //   11	161	4	localObject4	Object
    //   1	209	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   115	120	123	java/lang/Exception
    //   3	13	127	java/lang/Exception
    //   16	45	127	java/lang/Exception
    //   57	67	127	java/lang/Exception
    //   171	176	179	java/lang/Exception
    //   3	13	183	finally
    //   16	45	183	finally
    //   57	67	183	finally
    //   49	57	192	java/lang/Exception
    //   186	190	195	java/lang/Exception
    //   70	78	199	finally
    //   81	88	199	finally
    //   91	102	199	finally
    //   105	115	199	finally
    //   134	140	199	finally
    //   143	171	199	finally
    //   70	78	203	java/lang/Exception
    //   81	88	203	java/lang/Exception
    //   91	102	203	java/lang/Exception
    //   105	115	207	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceResLoader
 * JD-Core Version:    0.7.0.1
 */