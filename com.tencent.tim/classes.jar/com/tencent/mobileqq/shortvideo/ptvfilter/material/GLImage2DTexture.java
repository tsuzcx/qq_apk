package com.tencent.mobileqq.shortvideo.ptvfilter.material;

import android.graphics.Bitmap;

public class GLImage2DTexture
{
  private String basePath;
  private Bitmap gk;
  private Object mLock;
  
  private native int initTextureData(Bitmap paramBitmap);
  
  /* Error */
  private Bitmap loadBitmapFromNative(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: getstatic 39	java/io/File:separator	Ljava/lang/String;
    //   7: invokevirtual 45	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifne +173 -> 185
    //   15: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: invokevirtual 55	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   21: invokevirtual 61	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   24: new 63	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   31: ldc 69
    //   33: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: getstatic 39	java/io/File:separator	Ljava/lang/String;
    //   39: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 83	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   52: astore 5
    //   54: aload 5
    //   56: astore_1
    //   57: aload_1
    //   58: invokestatic 89	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   61: astore 4
    //   63: aload 4
    //   65: astore 5
    //   67: aload 4
    //   69: ifnull +51 -> 120
    //   72: aload 4
    //   74: astore 5
    //   76: iload_2
    //   77: ifeq +43 -> 120
    //   80: new 91	android/graphics/Matrix
    //   83: dup
    //   84: invokespecial 92	android/graphics/Matrix:<init>	()V
    //   87: astore 5
    //   89: aload 5
    //   91: fconst_1
    //   92: ldc 93
    //   94: invokevirtual 97	android/graphics/Matrix:preScale	(FF)Z
    //   97: pop
    //   98: aload 4
    //   100: iconst_0
    //   101: iconst_0
    //   102: aload 4
    //   104: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   107: aload 4
    //   109: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   112: aload 5
    //   114: iconst_1
    //   115: invokestatic 110	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   118: astore 5
    //   120: aload 5
    //   122: astore 6
    //   124: aload_1
    //   125: ifnull +11 -> 136
    //   128: aload_1
    //   129: invokevirtual 115	java/io/InputStream:close	()V
    //   132: aload 5
    //   134: astore 6
    //   136: aload 6
    //   138: areturn
    //   139: astore 5
    //   141: new 63	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   148: aload_0
    //   149: getfield 117	com/tencent/mobileqq/shortvideo/ptvfilter/material/GLImage2DTexture:basePath	Ljava/lang/String;
    //   152: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore_1
    //   163: new 119	java/io/FileInputStream
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   171: astore_1
    //   172: goto -115 -> 57
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 125	java/io/FileNotFoundException:printStackTrace	()V
    //   180: aconst_null
    //   181: astore_1
    //   182: goto -10 -> 172
    //   185: new 119	java/io/FileInputStream
    //   188: dup
    //   189: aload_1
    //   190: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   193: astore_1
    //   194: goto -137 -> 57
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 125	java/io/FileNotFoundException:printStackTrace	()V
    //   202: aconst_null
    //   203: astore_1
    //   204: goto -147 -> 57
    //   207: astore 4
    //   209: aload 4
    //   211: invokevirtual 126	java/lang/OutOfMemoryError:printStackTrace	()V
    //   214: aconst_null
    //   215: astore 4
    //   217: goto -154 -> 63
    //   220: astore_1
    //   221: aload_1
    //   222: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   225: aload 5
    //   227: areturn
    //   228: astore 5
    //   230: aconst_null
    //   231: astore 4
    //   233: aconst_null
    //   234: astore_1
    //   235: aload 5
    //   237: invokevirtual 128	java/lang/Exception:printStackTrace	()V
    //   240: aload_1
    //   241: astore 6
    //   243: aload 4
    //   245: ifnull -109 -> 136
    //   248: aload 4
    //   250: invokevirtual 115	java/io/InputStream:close	()V
    //   253: aload_1
    //   254: areturn
    //   255: astore 4
    //   257: aload 4
    //   259: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   262: aload_1
    //   263: areturn
    //   264: astore_1
    //   265: aload 4
    //   267: ifnull +8 -> 275
    //   270: aload 4
    //   272: invokevirtual 115	java/io/InputStream:close	()V
    //   275: aload_1
    //   276: athrow
    //   277: astore 4
    //   279: aload 4
    //   281: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   284: goto -9 -> 275
    //   287: astore 5
    //   289: aload_1
    //   290: astore 4
    //   292: aload 5
    //   294: astore_1
    //   295: goto -30 -> 265
    //   298: astore_1
    //   299: goto -34 -> 265
    //   302: astore 5
    //   304: aload_1
    //   305: astore 4
    //   307: aconst_null
    //   308: astore_1
    //   309: goto -74 -> 235
    //   312: astore 5
    //   314: aload_1
    //   315: astore 6
    //   317: aload 4
    //   319: astore_1
    //   320: aload 6
    //   322: astore 4
    //   324: goto -89 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	GLImage2DTexture
    //   0	327	1	paramString	String
    //   0	327	2	paramBoolean	boolean
    //   10	2	3	bool	boolean
    //   1	107	4	localBitmap	Bitmap
    //   207	3	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   215	34	4	localObject1	Object
    //   255	16	4	localIOException1	java.io.IOException
    //   277	3	4	localIOException2	java.io.IOException
    //   290	33	4	localObject2	Object
    //   52	81	5	localObject3	Object
    //   139	87	5	localException1	java.lang.Exception
    //   228	8	5	localException2	java.lang.Exception
    //   287	6	5	localObject4	Object
    //   302	1	5	localException3	java.lang.Exception
    //   312	1	5	localException4	java.lang.Exception
    //   122	199	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   15	54	139	java/lang/Exception
    //   163	172	175	java/io/FileNotFoundException
    //   185	194	197	java/io/FileNotFoundException
    //   57	63	207	java/lang/OutOfMemoryError
    //   128	132	220	java/io/IOException
    //   3	11	228	java/lang/Exception
    //   141	163	228	java/lang/Exception
    //   163	172	228	java/lang/Exception
    //   176	180	228	java/lang/Exception
    //   185	194	228	java/lang/Exception
    //   198	202	228	java/lang/Exception
    //   248	253	255	java/io/IOException
    //   3	11	264	finally
    //   15	54	264	finally
    //   141	163	264	finally
    //   163	172	264	finally
    //   176	180	264	finally
    //   185	194	264	finally
    //   198	202	264	finally
    //   270	275	277	java/io/IOException
    //   57	63	287	finally
    //   80	120	287	finally
    //   209	214	287	finally
    //   235	240	298	finally
    //   57	63	302	java/lang/Exception
    //   209	214	302	java/lang/Exception
    //   80	120	312	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.material.GLImage2DTexture
 * JD-Core Version:    0.7.0.1
 */