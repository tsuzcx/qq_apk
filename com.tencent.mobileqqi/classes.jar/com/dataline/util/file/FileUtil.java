package com.dataline.util.file;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.util.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil
{
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 17
    //   3: invokestatic 21	com/dataline/util/file/FileUtil:d	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: invokestatic 26	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   11: ifeq +5 -> 16
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual 32	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: ldc 33
    //   22: invokestatic 39	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   25: astore_0
    //   26: aload_0
    //   27: aload_1
    //   28: invokestatic 42	com/dataline/util/file/FileUtil:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   31: pop
    //   32: aload_0
    //   33: ifnull +35 -> 68
    //   36: aload_0
    //   37: invokevirtual 47	android/graphics/Bitmap:recycle	()V
    //   40: aload_1
    //   41: areturn
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 50	java/io/FileNotFoundException:printStackTrace	()V
    //   47: aload_1
    //   48: areturn
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   56: aload_1
    //   57: areturn
    //   58: astore_0
    //   59: goto -7 -> 52
    //   62: astore_0
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -22 -> 43
    //   68: aload_1
    //   69: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramContext	Context
    //   6	63	1	str	String
    // Exception table:
    //   from	to	target	type
    //   7	14	42	java/io/FileNotFoundException
    //   16	32	42	java/io/FileNotFoundException
    //   36	40	42	java/io/FileNotFoundException
    //   0	7	49	java/io/IOException
    //   7	14	58	java/io/IOException
    //   16	32	58	java/io/IOException
    //   36	40	58	java/io/IOException
    //   0	7	62	java/io/FileNotFoundException
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Context localContext2 = null;
    Context localContext1 = null;
    Bitmap localBitmap = MediaStoreUtil.a(paramString, 150, 150);
    if (localBitmap == null) {
      return null;
    }
    try
    {
      paramContext = d(paramContext, paramString);
      localContext1 = paramContext;
      localContext2 = paramContext;
      a(localBitmap, paramContext);
      localContext1 = paramContext;
      localContext2 = paramContext;
      MediaStoreUtil.a(paramContext, MediaStoreUtil.a(paramString));
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return localContext1;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return localContext2;
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    paramFile.delete();
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: ireturn
    //   12: new 80	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 82	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: ldc 86
    //   26: invokespecial 89	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   29: astore_1
    //   30: aload_0
    //   31: getstatic 95	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   34: bipush 70
    //   36: aload_1
    //   37: invokevirtual 99	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   40: istore_3
    //   41: iload_3
    //   42: istore_2
    //   43: aload_1
    //   44: ifnull -34 -> 10
    //   47: aload_1
    //   48: invokevirtual 104	java/io/OutputStream:flush	()V
    //   51: aload_1
    //   52: invokevirtual 107	java/io/OutputStream:close	()V
    //   55: iload_3
    //   56: ireturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +11 -> 72
    //   64: aload_1
    //   65: invokevirtual 104	java/io/OutputStream:flush	()V
    //   68: aload_1
    //   69: invokevirtual 107	java/io/OutputStream:close	()V
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -15 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramBitmap	Bitmap
    //   0	78	1	paramString	String
    //   9	34	2	bool1	boolean
    //   40	16	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   12	30	57	finally
    //   30	41	74	finally
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore_2
    //   8: aload_0
    //   9: invokevirtual 111	java/io/File:isFile	()Z
    //   12: ifeq +93 -> 105
    //   15: aload_1
    //   16: invokevirtual 114	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 78	java/io/File:delete	()Z
    //   26: pop
    //   27: new 82	java/io/FileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore 4
    //   37: new 118	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore 5
    //   47: ldc 120
    //   49: newarray byte
    //   51: astore 6
    //   53: aload 5
    //   55: aload 6
    //   57: invokevirtual 124	java/io/FileInputStream:read	([B)I
    //   60: istore_3
    //   61: iload_3
    //   62: iconst_m1
    //   63: if_icmpeq +121 -> 184
    //   66: aload 4
    //   68: aload 6
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 128	java/io/FileOutputStream:write	([BII)V
    //   75: aload 4
    //   77: invokevirtual 129	java/io/FileOutputStream:flush	()V
    //   80: goto -27 -> 53
    //   83: astore 6
    //   85: aload 4
    //   87: ifnull +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   95: aload 5
    //   97: ifnull +8 -> 105
    //   100: aload 5
    //   102: invokevirtual 131	java/io/FileInputStream:close	()V
    //   105: aload_0
    //   106: invokevirtual 69	java/io/File:isDirectory	()Z
    //   109: ifeq +130 -> 239
    //   112: aload_0
    //   113: invokevirtual 73	java/io/File:listFiles	()[Ljava/io/File;
    //   116: astore_0
    //   117: aload_1
    //   118: invokevirtual 134	java/io/File:mkdir	()Z
    //   121: pop
    //   122: iload_2
    //   123: aload_0
    //   124: arraylength
    //   125: if_icmpge +114 -> 239
    //   128: aload_0
    //   129: iload_2
    //   130: aaload
    //   131: invokevirtual 138	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   134: new 65	java/io/File
    //   137: dup
    //   138: new 140	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   145: aload_1
    //   146: invokevirtual 138	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   149: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: getstatic 149	java/io/File:separator	Ljava/lang/String;
    //   155: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: iload_2
    //   160: aaload
    //   161: invokevirtual 156	java/io/File:getName	()Ljava/lang/String;
    //   164: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   173: invokestatic 162	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   176: pop
    //   177: iload_2
    //   178: iconst_1
    //   179: iadd
    //   180: istore_2
    //   181: goto -59 -> 122
    //   184: aload 4
    //   186: ifnull +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   194: aload 5
    //   196: ifnull -91 -> 105
    //   199: aload 5
    //   201: invokevirtual 131	java/io/FileInputStream:close	()V
    //   204: goto -99 -> 105
    //   207: astore 4
    //   209: goto -104 -> 105
    //   212: astore_0
    //   213: aconst_null
    //   214: astore 4
    //   216: aload 6
    //   218: astore_1
    //   219: aload 4
    //   221: ifnull +8 -> 229
    //   224: aload 4
    //   226: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 131	java/io/FileInputStream:close	()V
    //   237: aload_0
    //   238: athrow
    //   239: iconst_1
    //   240: ireturn
    //   241: astore 4
    //   243: goto -49 -> 194
    //   246: astore 4
    //   248: goto -153 -> 95
    //   251: astore 4
    //   253: goto -148 -> 105
    //   256: astore 4
    //   258: goto -29 -> 229
    //   261: astore_1
    //   262: goto -25 -> 237
    //   265: astore_0
    //   266: aload 6
    //   268: astore_1
    //   269: goto -50 -> 219
    //   272: astore_0
    //   273: aload 5
    //   275: astore_1
    //   276: goto -57 -> 219
    //   279: astore 4
    //   281: aconst_null
    //   282: astore 4
    //   284: aload 7
    //   286: astore 5
    //   288: goto -203 -> 85
    //   291: astore 5
    //   293: aload 7
    //   295: astore 5
    //   297: goto -212 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramFile1	File
    //   0	300	1	paramFile2	File
    //   7	174	2	i	int
    //   60	12	3	j	int
    //   35	155	4	localFileOutputStream	java.io.FileOutputStream
    //   207	1	4	localIOException1	IOException
    //   214	11	4	localObject1	Object
    //   241	1	4	localIOException2	IOException
    //   246	1	4	localIOException3	IOException
    //   251	1	4	localIOException4	IOException
    //   256	1	4	localIOException5	IOException
    //   279	1	4	localIOException6	IOException
    //   282	1	4	localObject2	Object
    //   45	242	5	localObject3	Object
    //   291	1	5	localIOException7	IOException
    //   295	1	5	localObject4	Object
    //   1	68	6	arrayOfByte	byte[]
    //   83	184	6	localIOException8	IOException
    //   4	290	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   47	53	83	java/io/IOException
    //   53	61	83	java/io/IOException
    //   66	80	83	java/io/IOException
    //   199	204	207	java/io/IOException
    //   15	27	212	finally
    //   27	37	212	finally
    //   189	194	241	java/io/IOException
    //   90	95	246	java/io/IOException
    //   100	105	251	java/io/IOException
    //   224	229	256	java/io/IOException
    //   233	237	261	java/io/IOException
    //   37	47	265	finally
    //   47	53	272	finally
    //   53	61	272	finally
    //   66	80	272	finally
    //   15	27	279	java/io/IOException
    //   27	37	279	java/io/IOException
    //   37	47	291	java/io/IOException
  }
  
  public static String b(Context paramContext, String paramString)
  {
    Bitmap localBitmap = MediaStoreUtil.b(paramString, 157, 157);
    if (localBitmap == null) {
      return null;
    }
    try
    {
      paramContext = d(paramContext, paramString);
      a(localBitmap, paramContext);
      localBitmap.recycle();
      MediaStoreUtil.a(paramContext, MediaStoreUtil.a(paramString));
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    if (a(paramFile1, paramFile2))
    {
      a(paramFile1);
      return true;
    }
    return false;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    Bitmap localBitmap;
    if (FileManagerUtil.a(paramString) == 0) {
      localBitmap = MediaStoreUtil.a(paramString, 150, 150);
    }
    for (;;)
    {
      if (localBitmap == null)
      {
        return null;
        if (FileManagerUtil.a(paramString) == 2) {
          localBitmap = MediaStoreUtil.c(paramString, 150, 150);
        }
      }
      else
      {
        try
        {
          paramContext = d(paramContext, paramString);
          localBitmap = null;
        }
        catch (FileNotFoundException paramString)
        {
          for (;;)
          {
            try
            {
              a(localBitmap, paramContext);
              localBitmap.recycle();
              MediaStoreUtil.a(paramContext, MediaStoreUtil.a(paramString));
              return paramContext;
            }
            catch (IOException paramString)
            {
              continue;
            }
            catch (FileNotFoundException paramString)
            {
              continue;
            }
            paramString = paramString;
            paramContext = null;
            paramString.printStackTrace();
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramContext = null;
            paramString.printStackTrace();
          }
        }
        catch (OutOfMemoryError paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            paramContext = null;
          }
        }
      }
    }
  }
  
  public static String d(Context paramContext, String paramString)
  {
    paramContext = new File(Utils.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + File.separator + FileManagerUtil.a(paramString) + ".JPG";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.file.FileUtil
 * JD-Core Version:    0.7.0.1
 */