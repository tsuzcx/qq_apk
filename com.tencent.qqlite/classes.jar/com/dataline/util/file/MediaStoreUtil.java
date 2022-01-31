package com.dataline.util.file;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class MediaStoreUtil
{
  public static int a(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  @TargetApi(8)
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inJustDecodeBounds = false;
    int j = localOptions.outHeight;
    paramInt1 = localOptions.outWidth / paramInt1;
    paramInt2 = j / paramInt2;
    if (paramInt1 < paramInt2)
    {
      if (paramInt1 > 0) {
        break label79;
      }
      paramInt1 = i;
    }
    label79:
    for (;;)
    {
      localOptions.inSampleSize = paramInt1;
      return BitmapFactory.decodeFile(paramString, localOptions);
      paramInt1 = paramInt2;
      break;
    }
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 89
    //   2: invokestatic 95	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: invokevirtual 99	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   8: astore_2
    //   9: ldc 89
    //   11: invokestatic 95	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   14: ldc 101
    //   16: iconst_0
    //   17: anewarray 91	java/lang/Class
    //   20: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   23: astore 5
    //   25: aload 5
    //   27: astore 4
    //   29: aload_2
    //   30: astore_3
    //   31: ldc 89
    //   33: invokestatic 95	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   36: ldc 107
    //   38: iconst_1
    //   39: anewarray 91	java/lang/Class
    //   42: dup
    //   43: iconst_0
    //   44: ldc 42
    //   46: aastore
    //   47: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   50: aload_2
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_0
    //   58: aastore
    //   59: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload 5
    //   65: astore 4
    //   67: aload_2
    //   68: astore_3
    //   69: ldc 89
    //   71: invokestatic 95	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   74: ldc 115
    //   76: iconst_1
    //   77: anewarray 91	java/lang/Class
    //   80: dup
    //   81: iconst_0
    //   82: getstatic 121	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   85: aastore
    //   86: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   89: aload_2
    //   90: iconst_1
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: bipush 9
    //   98: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: aastore
    //   102: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   105: checkcast 42	java/lang/String
    //   108: invokestatic 128	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   111: sipush 1000
    //   114: idiv
    //   115: istore_1
    //   116: aload 5
    //   118: astore 4
    //   120: aload_2
    //   121: astore_3
    //   122: ldc 130
    //   124: iconst_3
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: iload_1
    //   131: sipush 3600
    //   134: idiv
    //   135: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: iload_1
    //   142: sipush 3600
    //   145: irem
    //   146: bipush 60
    //   148: idiv
    //   149: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: dup
    //   154: iconst_2
    //   155: iload_1
    //   156: bipush 60
    //   158: irem
    //   159: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: invokestatic 136	java/text/MessageFormat:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   166: astore_0
    //   167: aload 5
    //   169: ifnull +14 -> 183
    //   172: aload 5
    //   174: aload_2
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   182: pop
    //   183: aload_0
    //   184: areturn
    //   185: astore_2
    //   186: aload_2
    //   187: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   190: aload_0
    //   191: areturn
    //   192: astore 6
    //   194: aconst_null
    //   195: astore_0
    //   196: aconst_null
    //   197: astore_2
    //   198: aload_0
    //   199: astore 4
    //   201: aload_2
    //   202: astore_3
    //   203: aload 6
    //   205: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   208: aload_0
    //   209: ifnull +13 -> 222
    //   212: aload_0
    //   213: aload_2
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   221: pop
    //   222: aconst_null
    //   223: areturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   229: aconst_null
    //   230: areturn
    //   231: astore_0
    //   232: aconst_null
    //   233: astore 4
    //   235: aconst_null
    //   236: astore_2
    //   237: aload 4
    //   239: ifnull +14 -> 253
    //   242: aload 4
    //   244: aload_2
    //   245: iconst_0
    //   246: anewarray 4	java/lang/Object
    //   249: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: aload_0
    //   254: athrow
    //   255: astore_2
    //   256: aload_2
    //   257: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   260: goto -7 -> 253
    //   263: astore_0
    //   264: aconst_null
    //   265: astore 4
    //   267: goto -30 -> 237
    //   270: astore_0
    //   271: aload_3
    //   272: astore_2
    //   273: goto -36 -> 237
    //   276: astore 6
    //   278: aconst_null
    //   279: astore_0
    //   280: goto -82 -> 198
    //   283: astore 6
    //   285: aload 5
    //   287: astore_0
    //   288: goto -90 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramString	String
    //   115	44	1	i	int
    //   8	167	2	localObject1	Object
    //   185	2	2	localException1	java.lang.Exception
    //   197	48	2	localObject2	Object
    //   255	2	2	localException2	java.lang.Exception
    //   272	1	2	localObject3	Object
    //   30	242	3	localObject4	Object
    //   27	239	4	localObject5	Object
    //   23	263	5	localMethod	java.lang.reflect.Method
    //   192	12	6	localException3	java.lang.Exception
    //   276	1	6	localException4	java.lang.Exception
    //   283	1	6	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   172	183	185	java/lang/Exception
    //   0	9	192	java/lang/Exception
    //   212	222	224	java/lang/Exception
    //   0	9	231	finally
    //   242	253	255	java/lang/Exception
    //   9	25	263	finally
    //   31	63	270	finally
    //   69	116	270	finally
    //   122	167	270	finally
    //   203	208	270	finally
    //   9	25	276	java/lang/Exception
    //   31	63	283	java/lang/Exception
    //   69	116	283	java/lang/Exception
    //   122	167	283	java/lang/Exception
  }
  
  /* Error */
  public static java.util.List a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 140	com/dataline/util/file/MediaStoreUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: invokeinterface 146 1 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifle +153 -> 172
    //   22: new 148	java/util/ArrayList
    //   25: dup
    //   26: iload_2
    //   27: invokespecial 151	java/util/ArrayList:<init>	(I)V
    //   30: astore_1
    //   31: aload_0
    //   32: ldc 48
    //   34: invokeinterface 154 2 0
    //   39: istore_2
    //   40: aload_0
    //   41: invokeinterface 158 1 0
    //   46: ifeq +64 -> 110
    //   49: aload_0
    //   50: iload_2
    //   51: invokeinterface 162 2 0
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull -18 -> 40
    //   61: aload_3
    //   62: invokestatic 167	com/dataline/util/file/ImageInfo:a	(Ljava/lang/String;)Lcom/dataline/util/file/ImageInfo;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull -27 -> 40
    //   70: aload_1
    //   71: aload_3
    //   72: invokeinterface 173 2 0
    //   77: pop
    //   78: goto -38 -> 40
    //   81: astore_3
    //   82: aload_1
    //   83: astore 4
    //   85: aload_0
    //   86: astore_1
    //   87: aload 4
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   94: aload_0
    //   95: astore_3
    //   96: aload_1
    //   97: ifnull +11 -> 108
    //   100: aload_1
    //   101: invokeinterface 176 1 0
    //   106: aload_0
    //   107: astore_3
    //   108: aload_3
    //   109: areturn
    //   110: aload_1
    //   111: astore_3
    //   112: aload_0
    //   113: ifnull -5 -> 108
    //   116: aload_0
    //   117: invokeinterface 176 1 0
    //   122: aload_1
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull +9 -> 137
    //   131: aload_0
    //   132: invokeinterface 176 1 0
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: goto -13 -> 127
    //   143: astore_3
    //   144: aload_1
    //   145: astore_0
    //   146: aload_3
    //   147: astore_1
    //   148: goto -21 -> 127
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 4
    //   156: astore_1
    //   157: goto -67 -> 90
    //   160: astore_3
    //   161: aconst_null
    //   162: astore 4
    //   164: aload_0
    //   165: astore_1
    //   166: aload 4
    //   168: astore_0
    //   169: goto -79 -> 90
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -64 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramContext	Context
    //   0	177	1	paramString	String
    //   0	177	2	paramInt	int
    //   56	16	3	localObject1	Object
    //   81	10	3	localException1	java.lang.Exception
    //   95	17	3	localObject2	Object
    //   143	4	3	localObject3	Object
    //   151	1	3	localException2	java.lang.Exception
    //   160	1	3	localException3	java.lang.Exception
    //   1	166	4	str	String
    // Exception table:
    //   from	to	target	type
    //   31	40	81	java/lang/Exception
    //   40	57	81	java/lang/Exception
    //   61	66	81	java/lang/Exception
    //   70	78	81	java/lang/Exception
    //   3	11	124	finally
    //   11	18	139	finally
    //   22	31	139	finally
    //   31	40	139	finally
    //   40	57	139	finally
    //   61	66	139	finally
    //   70	78	139	finally
    //   90	94	143	finally
    //   3	11	151	java/lang/Exception
    //   11	18	160	java/lang/Exception
    //   22	31	160	java/lang/Exception
  }
  
  public static void a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        ExifInterface localExifInterface = new ExifInterface(paramString);
        switch (paramInt)
        {
        case 90: 
          paramString = Integer.toString(1);
          localExifInterface.setAttribute("Orientation", paramString);
          localExifInterface.saveAttributes();
          return;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = Integer.toString(6);
      continue;
      paramString = Integer.toString(3);
      continue;
      paramString = Integer.toString(8);
    }
  }
  
  private static Cursor b(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  @TargetApi(8)
  public static Bitmap b(String paramString, int paramInt1, int paramInt2)
  {
    int j = 1;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    int i = ((BitmapFactory.Options)localObject).outWidth / paramInt1;
    k /= paramInt2;
    if (i < k)
    {
      if (i > 0) {
        break label123;
      }
      i = j;
    }
    label123:
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      try
      {
        localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        return ThumbnailUtils.extractThumbnail((Bitmap)localObject, paramInt1, paramInt2, 2);
      }
      catch (Throwable localThrowable)
      {
        QLog.d("wifiphoto", 2, "getImageThumbnailForSize error imagePath is " + paramString);
        return null;
      }
      i = k;
      break;
    }
  }
  
  /* Error */
  public static java.util.List b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 221	com/dataline/util/file/MediaStoreUtil:b	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: invokeinterface 146 1 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifle +153 -> 172
    //   22: new 148	java/util/ArrayList
    //   25: dup
    //   26: iload_2
    //   27: invokespecial 151	java/util/ArrayList:<init>	(I)V
    //   30: astore_1
    //   31: aload_0
    //   32: ldc 48
    //   34: invokeinterface 154 2 0
    //   39: istore_2
    //   40: aload_0
    //   41: invokeinterface 158 1 0
    //   46: ifeq +64 -> 110
    //   49: aload_0
    //   50: iload_2
    //   51: invokeinterface 162 2 0
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull -18 -> 40
    //   61: aload_3
    //   62: invokestatic 167	com/dataline/util/file/ImageInfo:a	(Ljava/lang/String;)Lcom/dataline/util/file/ImageInfo;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull -27 -> 40
    //   70: aload_1
    //   71: aload_3
    //   72: invokeinterface 173 2 0
    //   77: pop
    //   78: goto -38 -> 40
    //   81: astore_3
    //   82: aload_1
    //   83: astore 4
    //   85: aload_0
    //   86: astore_1
    //   87: aload 4
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   94: aload_0
    //   95: astore_3
    //   96: aload_1
    //   97: ifnull +11 -> 108
    //   100: aload_1
    //   101: invokeinterface 176 1 0
    //   106: aload_0
    //   107: astore_3
    //   108: aload_3
    //   109: areturn
    //   110: aload_1
    //   111: astore_3
    //   112: aload_0
    //   113: ifnull -5 -> 108
    //   116: aload_0
    //   117: invokeinterface 176 1 0
    //   122: aload_1
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull +9 -> 137
    //   131: aload_0
    //   132: invokeinterface 176 1 0
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: goto -13 -> 127
    //   143: astore_3
    //   144: aload_1
    //   145: astore_0
    //   146: aload_3
    //   147: astore_1
    //   148: goto -21 -> 127
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 4
    //   156: astore_1
    //   157: goto -67 -> 90
    //   160: astore_3
    //   161: aconst_null
    //   162: astore 4
    //   164: aload_0
    //   165: astore_1
    //   166: aload 4
    //   168: astore_0
    //   169: goto -79 -> 90
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -64 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramContext	Context
    //   0	177	1	paramString	String
    //   0	177	2	paramInt	int
    //   56	16	3	localObject1	Object
    //   81	10	3	localException1	java.lang.Exception
    //   95	17	3	localObject2	Object
    //   143	4	3	localObject3	Object
    //   151	1	3	localException2	java.lang.Exception
    //   160	1	3	localException3	java.lang.Exception
    //   1	166	4	str	String
    // Exception table:
    //   from	to	target	type
    //   31	40	81	java/lang/Exception
    //   40	57	81	java/lang/Exception
    //   61	66	81	java/lang/Exception
    //   70	78	81	java/lang/Exception
    //   3	11	124	finally
    //   11	18	139	finally
    //   22	31	139	finally
    //   31	40	139	finally
    //   40	57	139	finally
    //   61	66	139	finally
    //   70	78	139	finally
    //   90	94	143	finally
    //   3	11	151	java/lang/Exception
    //   11	18	160	java/lang/Exception
    //   22	31	160	java/lang/Exception
  }
  
  @TargetApi(8)
  public static Bitmap c(String paramString, int paramInt1, int paramInt2)
  {
    return ThumbnailUtils.createVideoThumbnail(paramString, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.dataline.util.file.MediaStoreUtil
 * JD-Core Version:    0.7.0.1
 */