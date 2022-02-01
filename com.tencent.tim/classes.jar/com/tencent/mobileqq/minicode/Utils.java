package com.tencent.mobileqq.minicode;

import android.content.Context;
import android.util.Log;
import java.io.File;

public class Utils
{
  public static void checkResIsOK(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      File localFile = new File(paramString1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramString1 = paramString1 + paramString2;
          if (!new File(paramString1).exists()) {
            copyFileFromAssets(paramContext, paramString2, paramString1);
          }
          return;
        }
        catch (Exception paramContext)
        {
          Log.i("checkResIsOK", "exception !!!!!!!!!!!!", paramContext);
          paramContext.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
        Log.i("checkResIsOK", "exception !!!!!!!!!!!!", localException);
      }
    }
  }
  
  /* Error */
  public static void copyFileFromAssets(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_1
    //   11: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: new 65	java/io/FileOutputStream
    //   18: dup
    //   19: new 15	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: sipush 1024
    //   34: newarray byte
    //   36: astore_1
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 74	java/io/InputStream:read	([B)I
    //   42: istore_3
    //   43: iload_3
    //   44: iconst_m1
    //   45: if_icmpeq +43 -> 88
    //   48: aload_2
    //   49: aload_1
    //   50: iconst_0
    //   51: iload_3
    //   52: invokevirtual 78	java/io/FileOutputStream:write	([BII)V
    //   55: goto -18 -> 37
    //   58: astore 4
    //   60: aload_0
    //   61: astore_1
    //   62: aload_2
    //   63: astore_0
    //   64: aload 4
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 81	java/io/InputStream:close	()V
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   87: return
    //   88: aload_2
    //   89: invokevirtual 85	java/io/FileOutputStream:flush	()V
    //   92: aload_0
    //   93: ifnull +7 -> 100
    //   96: aload_0
    //   97: invokevirtual 81	java/io/InputStream:close	()V
    //   100: aload_2
    //   101: ifnull -14 -> 87
    //   104: aload_2
    //   105: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   108: return
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   114: return
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   120: return
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_0
    //   124: aload 4
    //   126: astore_2
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 81	java/io/InputStream:close	()V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   150: goto -7 -> 143
    //   153: astore_1
    //   154: aload 4
    //   156: astore_2
    //   157: goto -30 -> 127
    //   160: astore_1
    //   161: goto -34 -> 127
    //   164: astore_2
    //   165: aload_1
    //   166: astore 4
    //   168: aload_2
    //   169: astore_1
    //   170: aload_0
    //   171: astore_2
    //   172: aload 4
    //   174: astore_0
    //   175: goto -48 -> 127
    //   178: astore_2
    //   179: aconst_null
    //   180: astore_0
    //   181: aload 5
    //   183: astore_1
    //   184: goto -117 -> 67
    //   187: astore_2
    //   188: aconst_null
    //   189: astore 4
    //   191: aload_0
    //   192: astore_1
    //   193: aload 4
    //   195: astore_0
    //   196: goto -129 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramContext	Context
    //   0	199	1	paramString1	String
    //   0	199	2	paramString2	String
    //   42	10	3	i	int
    //   1	1	4	localObject1	Object
    //   58	97	4	localException	Exception
    //   166	28	4	str	String
    //   4	178	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	37	58	java/lang/Exception
    //   37	43	58	java/lang/Exception
    //   48	55	58	java/lang/Exception
    //   88	92	58	java/lang/Exception
    //   96	100	109	java/lang/Exception
    //   104	108	109	java/lang/Exception
    //   75	79	115	java/lang/Exception
    //   83	87	115	java/lang/Exception
    //   6	15	121	finally
    //   131	135	145	java/lang/Exception
    //   139	143	145	java/lang/Exception
    //   15	31	153	finally
    //   31	37	160	finally
    //   37	43	160	finally
    //   48	55	160	finally
    //   88	92	160	finally
    //   67	71	164	finally
    //   6	15	178	java/lang/Exception
    //   15	31	187	java/lang/Exception
  }
  
  /* Error */
  public static String readModelFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 27	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   9: astore 4
    //   11: new 91	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: astore_2
    //   20: new 94	java/io/BufferedReader
    //   23: dup
    //   24: new 96	java/io/InputStreamReader
    //   27: dup
    //   28: aload_2
    //   29: ldc 98
    //   31: invokespecial 101	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   34: invokespecial 104	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +62 -> 106
    //   47: aload 4
    //   49: new 27	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   56: aload_1
    //   57: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: bipush 10
    //   62: invokevirtual 110	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   65: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: goto -34 -> 38
    //   75: astore_3
    //   76: aload_2
    //   77: astore_1
    //   78: aload_3
    //   79: astore_2
    //   80: aload_2
    //   81: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 111	java/io/BufferedReader:close	()V
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 112	java/io/FileInputStream:close	()V
    //   100: aload 4
    //   102: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: areturn
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 111	java/io/BufferedReader:close	()V
    //   114: aload_2
    //   115: ifnull -15 -> 100
    //   118: aload_2
    //   119: invokevirtual 112	java/io/FileInputStream:close	()V
    //   122: goto -22 -> 100
    //   125: astore_0
    //   126: goto -26 -> 100
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_0
    //   135: ifnull +7 -> 142
    //   138: aload_0
    //   139: invokevirtual 111	java/io/BufferedReader:close	()V
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 112	java/io/FileInputStream:close	()V
    //   150: aload_1
    //   151: athrow
    //   152: astore_0
    //   153: goto -39 -> 114
    //   156: astore_0
    //   157: goto -65 -> 92
    //   160: astore_0
    //   161: goto -61 -> 100
    //   164: astore_0
    //   165: goto -23 -> 142
    //   168: astore_0
    //   169: goto -19 -> 150
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_0
    //   175: goto -41 -> 134
    //   178: astore_1
    //   179: goto -45 -> 134
    //   182: astore_3
    //   183: aload_1
    //   184: astore_2
    //   185: aload_3
    //   186: astore_1
    //   187: goto -53 -> 134
    //   190: astore_2
    //   191: aconst_null
    //   192: astore_0
    //   193: goto -113 -> 80
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_0
    //   199: aload_2
    //   200: astore_1
    //   201: aload_3
    //   202: astore_2
    //   203: goto -123 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramString	String
    //   1	96	1	localObject1	Object
    //   129	22	1	localObject2	Object
    //   172	1	1	localObject3	Object
    //   178	6	1	localObject4	Object
    //   186	15	1	localObject5	Object
    //   19	166	2	localObject6	Object
    //   190	10	2	localException1	Exception
    //   202	1	2	localObject7	Object
    //   75	4	3	localException2	Exception
    //   182	4	3	localObject8	Object
    //   196	6	3	localException3	Exception
    //   9	92	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	43	75	java/lang/Exception
    //   47	72	75	java/lang/Exception
    //   118	122	125	java/io/IOException
    //   11	20	129	finally
    //   110	114	152	java/io/IOException
    //   88	92	156	java/io/IOException
    //   96	100	160	java/io/IOException
    //   138	142	164	java/io/IOException
    //   146	150	168	java/io/IOException
    //   20	38	172	finally
    //   38	43	178	finally
    //   47	72	178	finally
    //   80	84	182	finally
    //   11	20	190	java/lang/Exception
    //   20	38	196	java/lang/Exception
  }
  
  /* Error */
  public static boolean saveBitmapToFile(android.graphics.Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: new 15	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: iconst_0
    //   16: aload_1
    //   17: ldc 116
    //   19: invokevirtual 122	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   22: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
    //   25: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 22	java/io/File:exists	()Z
    //   33: ifne +8 -> 41
    //   36: aload_1
    //   37: invokevirtual 25	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: aload 7
    //   43: invokevirtual 22	java/io/File:exists	()Z
    //   46: ifne +9 -> 55
    //   49: aload 7
    //   51: invokevirtual 129	java/io/File:createNewFile	()Z
    //   54: pop
    //   55: new 131	java/io/BufferedOutputStream
    //   58: dup
    //   59: new 65	java/io/FileOutputStream
    //   62: dup
    //   63: aload 7
    //   65: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 134	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore 7
    //   73: aload 7
    //   75: astore_1
    //   76: aload_0
    //   77: aload_2
    //   78: iload_3
    //   79: aload 7
    //   81: invokevirtual 140	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   84: istore 5
    //   86: aload 7
    //   88: astore_1
    //   89: aload 7
    //   91: invokevirtual 141	java/io/BufferedOutputStream:flush	()V
    //   94: iload 4
    //   96: ifeq +10 -> 106
    //   99: aload 7
    //   101: astore_1
    //   102: aload_0
    //   103: invokevirtual 144	android/graphics/Bitmap:recycle	()V
    //   106: iload 5
    //   108: istore 6
    //   110: aload 7
    //   112: ifnull +12 -> 124
    //   115: aload 7
    //   117: invokevirtual 145	java/io/BufferedOutputStream:close	()V
    //   120: iload 5
    //   122: istore 6
    //   124: iload 6
    //   126: ireturn
    //   127: astore_1
    //   128: ldc 147
    //   130: iconst_1
    //   131: ldc 149
    //   133: aload_1
    //   134: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: goto -82 -> 55
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   145: iload 5
    //   147: ireturn
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_2
    //   151: iconst_0
    //   152: istore 4
    //   154: aload_2
    //   155: astore_1
    //   156: ldc 147
    //   158: iconst_1
    //   159: ldc 158
    //   161: aload_0
    //   162: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: iload 4
    //   167: istore 6
    //   169: aload_2
    //   170: ifnull -46 -> 124
    //   173: aload_2
    //   174: invokevirtual 145	java/io/BufferedOutputStream:close	()V
    //   177: iload 4
    //   179: ireturn
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   185: iload 4
    //   187: ireturn
    //   188: astore_0
    //   189: aconst_null
    //   190: astore_1
    //   191: aload_1
    //   192: ifnull +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 145	java/io/BufferedOutputStream:close	()V
    //   199: aload_0
    //   200: athrow
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   206: goto -7 -> 199
    //   209: astore_0
    //   210: goto -19 -> 191
    //   213: astore_0
    //   214: iconst_0
    //   215: istore 4
    //   217: aload 7
    //   219: astore_2
    //   220: goto -66 -> 154
    //   223: astore_0
    //   224: iload 5
    //   226: istore 4
    //   228: aload 7
    //   230: astore_2
    //   231: goto -77 -> 154
    //   234: astore_1
    //   235: goto -194 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramBitmap	android.graphics.Bitmap
    //   0	238	1	paramString	String
    //   0	238	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	238	3	paramInt	int
    //   0	238	4	paramBoolean	boolean
    //   84	141	5	bool1	boolean
    //   108	60	6	bool2	boolean
    //   8	221	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   49	55	127	java/lang/Exception
    //   115	120	140	java/io/IOException
    //   55	73	148	java/lang/Exception
    //   173	177	180	java/io/IOException
    //   55	73	188	finally
    //   195	199	201	java/io/IOException
    //   76	86	209	finally
    //   89	94	209	finally
    //   102	106	209	finally
    //   156	165	209	finally
    //   76	86	213	java/lang/Exception
    //   89	94	223	java/lang/Exception
    //   102	106	223	java/lang/Exception
    //   10	41	234	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.Utils
 * JD-Core Version:    0.7.0.1
 */