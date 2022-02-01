import android.content.Context;
import java.io.File;

public class avpg
{
  private static final String TEMP_FILE_PATH = avsu.getCacheDir("largeIntentTmp");
  
  /* Error */
  public static void b(android.content.Intent paramIntent, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_0
    //   5: invokevirtual 37	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   8: astore_0
    //   9: aload_0
    //   10: ifnull +9 -> 19
    //   13: aload_0
    //   14: aload_3
    //   15: iconst_0
    //   16: invokevirtual 43	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   19: aload_3
    //   20: invokevirtual 47	android/os/Parcel:marshall	()[B
    //   23: astore 4
    //   25: aload_1
    //   26: invokestatic 51	avpg:o	(Landroid/content/Context;)Ljava/io/File;
    //   29: astore 5
    //   31: aconst_null
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_1
    //   36: astore_0
    //   37: aload 5
    //   39: invokevirtual 57	java/io/File:exists	()Z
    //   42: ifeq +11 -> 53
    //   45: aload_1
    //   46: astore_0
    //   47: aload 5
    //   49: invokevirtual 60	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_1
    //   54: astore_0
    //   55: aload 5
    //   57: invokevirtual 64	java/io/File:getParentFile	()Ljava/io/File;
    //   60: invokevirtual 67	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload_1
    //   65: astore_0
    //   66: aload 5
    //   68: invokevirtual 70	java/io/File:createNewFile	()Z
    //   71: pop
    //   72: aload_1
    //   73: astore_0
    //   74: new 72	java/io/BufferedOutputStream
    //   77: dup
    //   78: new 74	java/io/FileOutputStream
    //   81: dup
    //   82: aload 5
    //   84: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   87: invokespecial 81	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   90: astore_1
    //   91: aload_1
    //   92: aload 4
    //   94: invokevirtual 87	java/io/OutputStream:write	([B)V
    //   97: aload_3
    //   98: invokevirtual 90	android/os/Parcel:recycle	()V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 93	java/io/OutputStream:close	()V
    //   109: return
    //   110: astore_0
    //   111: ldc 95
    //   113: iconst_2
    //   114: iconst_2
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: ldc 97
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_0
    //   126: aastore
    //   127: invokestatic 103	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   130: return
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: aload_0
    //   135: astore_2
    //   136: aload_1
    //   137: astore_0
    //   138: ldc 95
    //   140: iconst_2
    //   141: iconst_2
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc 97
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_2
    //   153: aastore
    //   154: invokestatic 103	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   157: aload_3
    //   158: invokevirtual 90	android/os/Parcel:recycle	()V
    //   161: aload_1
    //   162: ifnull -53 -> 109
    //   165: aload_1
    //   166: invokevirtual 93	java/io/OutputStream:close	()V
    //   169: return
    //   170: astore_0
    //   171: ldc 95
    //   173: iconst_2
    //   174: iconst_2
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: ldc 97
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload_0
    //   186: aastore
    //   187: invokestatic 103	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   190: return
    //   191: astore_2
    //   192: aload_0
    //   193: astore_1
    //   194: aload_2
    //   195: astore_0
    //   196: aload_3
    //   197: invokevirtual 90	android/os/Parcel:recycle	()V
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 93	java/io/OutputStream:close	()V
    //   208: aload_0
    //   209: athrow
    //   210: astore_1
    //   211: ldc 95
    //   213: iconst_2
    //   214: iconst_2
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: ldc 97
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: aload_1
    //   226: aastore
    //   227: invokestatic 103	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   230: goto -22 -> 208
    //   233: astore_0
    //   234: goto -38 -> 196
    //   237: astore_2
    //   238: goto -102 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramIntent	android.content.Intent
    //   0	241	1	paramContext	Context
    //   34	119	2	localIntent	android.content.Intent
    //   191	4	2	localObject	Object
    //   237	1	2	localException	java.lang.Exception
    //   3	194	3	localParcel	android.os.Parcel
    //   23	70	4	arrayOfByte	byte[]
    //   29	54	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   105	109	110	java/io/IOException
    //   37	45	131	java/lang/Exception
    //   47	53	131	java/lang/Exception
    //   55	64	131	java/lang/Exception
    //   66	72	131	java/lang/Exception
    //   74	91	131	java/lang/Exception
    //   165	169	170	java/io/IOException
    //   37	45	191	finally
    //   47	53	191	finally
    //   55	64	191	finally
    //   66	72	191	finally
    //   74	91	191	finally
    //   138	157	191	finally
    //   204	208	210	java/io/IOException
    //   91	97	233	finally
    //   91	97	237	java/lang/Exception
  }
  
  public static void gv(Context paramContext)
  {
    paramContext = o(paramContext);
    if (paramContext.exists()) {
      paramContext.delete();
    }
  }
  
  /* Error */
  public static android.content.Intent j(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokestatic 51	avpg:o	(Landroid/content/Context;)Ljava/io/File;
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 57	java/io/File:exists	()Z
    //   13: ifne +61 -> 74
    //   16: new 33	android/content/Intent
    //   19: dup
    //   20: invokespecial 109	android/content/Intent:<init>	()V
    //   23: astore_0
    //   24: iconst_0
    //   25: ifeq +11 -> 36
    //   28: new 111	java/lang/NullPointerException
    //   31: dup
    //   32: invokespecial 112	java/lang/NullPointerException:<init>	()V
    //   35: athrow
    //   36: aload_0
    //   37: astore_2
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 111	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 112	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: aload_2
    //   51: areturn
    //   52: astore_1
    //   53: ldc 95
    //   55: iconst_2
    //   56: iconst_2
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: ldc 97
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload_1
    //   68: aastore
    //   69: invokestatic 103	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: areturn
    //   74: new 114	java/io/BufferedInputStream
    //   77: dup
    //   78: new 116	java/io/FileInputStream
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: invokespecial 120	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 126	java/io/InputStream:available	()I
    //   94: newarray byte
    //   96: astore_2
    //   97: aload_0
    //   98: aload_2
    //   99: invokevirtual 130	java/io/InputStream:read	([B)I
    //   102: pop
    //   103: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   106: astore_1
    //   107: aload_1
    //   108: aload_2
    //   109: iconst_0
    //   110: aload_2
    //   111: arraylength
    //   112: invokevirtual 134	android/os/Parcel:unmarshall	([BII)V
    //   115: aload_1
    //   116: iconst_0
    //   117: invokevirtual 138	android/os/Parcel:setDataPosition	(I)V
    //   120: new 33	android/content/Intent
    //   123: dup
    //   124: invokespecial 109	android/content/Intent:<init>	()V
    //   127: astore_3
    //   128: new 39	android/os/Bundle
    //   131: dup
    //   132: invokespecial 139	android/os/Bundle:<init>	()V
    //   135: astore_2
    //   136: aload_2
    //   137: aload_1
    //   138: invokevirtual 143	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   141: aload_3
    //   142: aload_2
    //   143: invokevirtual 147	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   146: pop
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 90	android/os/Parcel:recycle	()V
    //   155: aload_3
    //   156: astore_2
    //   157: aload_0
    //   158: ifnull -108 -> 50
    //   161: aload_0
    //   162: invokevirtual 148	java/io/InputStream:close	()V
    //   165: aload_3
    //   166: areturn
    //   167: astore_0
    //   168: ldc 95
    //   170: iconst_2
    //   171: iconst_2
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: ldc 97
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: aload_0
    //   183: aastore
    //   184: invokestatic 103	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   187: aload_3
    //   188: areturn
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_2
    //   192: ldc 95
    //   194: iconst_2
    //   195: iconst_2
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: ldc 97
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: aload_0
    //   207: aastore
    //   208: invokestatic 103	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   211: new 33	android/content/Intent
    //   214: dup
    //   215: invokespecial 109	android/content/Intent:<init>	()V
    //   218: astore_0
    //   219: aload_2
    //   220: ifnull +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 90	android/os/Parcel:recycle	()V
    //   227: aload_0
    //   228: astore_2
    //   229: aload_1
    //   230: ifnull -180 -> 50
    //   233: aload_1
    //   234: invokevirtual 148	java/io/InputStream:close	()V
    //   237: aload_0
    //   238: areturn
    //   239: astore_1
    //   240: ldc 95
    //   242: iconst_2
    //   243: iconst_2
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: ldc 97
    //   251: aastore
    //   252: dup
    //   253: iconst_1
    //   254: aload_1
    //   255: aastore
    //   256: invokestatic 103	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   259: aload_0
    //   260: areturn
    //   261: astore_0
    //   262: aconst_null
    //   263: astore_2
    //   264: aload_3
    //   265: astore_1
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 90	android/os/Parcel:recycle	()V
    //   274: aload_1
    //   275: ifnull +7 -> 282
    //   278: aload_1
    //   279: invokevirtual 148	java/io/InputStream:close	()V
    //   282: aload_0
    //   283: athrow
    //   284: astore_1
    //   285: ldc 95
    //   287: iconst_2
    //   288: iconst_2
    //   289: anewarray 4	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: ldc 97
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: aload_1
    //   300: aastore
    //   301: invokestatic 103	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   304: goto -22 -> 282
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_2
    //   310: aload_0
    //   311: astore_1
    //   312: aload_3
    //   313: astore_0
    //   314: goto -48 -> 266
    //   317: astore_3
    //   318: aload_1
    //   319: astore_2
    //   320: aload_0
    //   321: astore_1
    //   322: aload_3
    //   323: astore_0
    //   324: goto -58 -> 266
    //   327: astore_0
    //   328: goto -62 -> 266
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_2
    //   334: aload_0
    //   335: astore_1
    //   336: aload_3
    //   337: astore_0
    //   338: goto -146 -> 192
    //   341: astore_3
    //   342: aload_1
    //   343: astore_2
    //   344: aload_0
    //   345: astore_1
    //   346: aload_3
    //   347: astore_0
    //   348: goto -156 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramContext	Context
    //   3	1	1	localObject1	Object
    //   52	16	1	localIOException1	java.io.IOException
    //   106	128	1	localParcel	android.os.Parcel
    //   239	16	1	localIOException2	java.io.IOException
    //   265	14	1	localIntent1	android.content.Intent
    //   284	16	1	localIOException3	java.io.IOException
    //   311	35	1	localContext	Context
    //   37	307	2	localObject2	Object
    //   1	264	3	localIntent2	android.content.Intent
    //   307	6	3	localObject3	Object
    //   317	6	3	localObject4	Object
    //   331	6	3	localException1	java.lang.Exception
    //   341	6	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   28	36	52	java/io/IOException
    //   42	50	52	java/io/IOException
    //   151	155	167	java/io/IOException
    //   161	165	167	java/io/IOException
    //   4	24	189	java/lang/Exception
    //   74	90	189	java/lang/Exception
    //   223	227	239	java/io/IOException
    //   233	237	239	java/io/IOException
    //   4	24	261	finally
    //   74	90	261	finally
    //   270	274	284	java/io/IOException
    //   278	282	284	java/io/IOException
    //   90	107	307	finally
    //   107	147	317	finally
    //   192	219	327	finally
    //   90	107	331	java/lang/Exception
    //   107	147	341	java/lang/Exception
  }
  
  private static File o(Context paramContext)
  {
    return new File(TEMP_FILE_PATH, "tmp.dat");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avpg
 * JD-Core Version:    0.7.0.1
 */