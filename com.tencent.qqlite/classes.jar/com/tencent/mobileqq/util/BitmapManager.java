package com.tencent.mobileqq.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.util.Pair;
import erj;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BitmapManager
{
  public static final String a = "BitmapManager";
  private static ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private static Map jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int i = 1;
    if ((j > paramInt2) || (k > paramInt1))
    {
      if (k > j) {
        i = Math.round(j / paramInt2);
      }
    }
    else {
      return i;
    }
    return Math.round(k / paramInt1);
  }
  
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    a();
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      localBitmapDecodeResult.a = BitmapFactory.decodeResource(paramResources, paramInt, (BitmapFactory.Options)localObject);
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramResources = String.valueOf(localBitmapDecodeResult.a.hashCode());
        localObject = new erj(paramResources, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramResources, localObject);
      }
      return localBitmapDecodeResult.a;
    }
    catch (OutOfMemoryError paramResources)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 1;
      }
    }
    catch (Throwable paramResources)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 3;
      }
    }
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt2, paramInt3);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    if (paramResources != null)
    {
      localObject = String.valueOf(paramResources.hashCode());
      erj localerj = new erj((String)localObject, paramResources, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localerj);
    }
    return paramResources;
  }
  
  public static Bitmap a(InputStream paramInputStream)
  {
    a();
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      localBitmapDecodeResult.a = BitmapFactory.decodeStream(paramInputStream, null, (BitmapFactory.Options)localObject);
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramInputStream = String.valueOf(localBitmapDecodeResult.a.hashCode());
        localObject = new erj(paramInputStream, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramInputStream, localObject);
      }
      return localBitmapDecodeResult.a;
    }
    catch (OutOfMemoryError paramInputStream)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 1;
      }
    }
    catch (Throwable paramInputStream)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 3;
      }
    }
  }
  
  public static Bitmap a(InputStream paramInputStream, Rect paramRect, int paramInt1, int paramInt2)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramInputStream = BitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
    if (paramInputStream != null)
    {
      paramRect = String.valueOf(paramInputStream.hashCode());
      localObject = new erj(paramRect, paramInputStream, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(paramRect, localObject);
    }
    return paramInputStream;
  }
  
  public static Bitmap a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (paramString != null)
    {
      localObject = String.valueOf(paramString.hashCode());
      erj localerj = new erj((String)localObject, paramString, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localerj);
    }
    return paramString;
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    a(paramString, paramOptions, localBitmapDecodeResult);
    return localBitmapDecodeResult.a;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a();
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      localBitmapDecodeResult.a = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, (BitmapFactory.Options)localObject);
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramArrayOfByte = String.valueOf(localBitmapDecodeResult.a.hashCode());
        localObject = new erj(paramArrayOfByte, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramArrayOfByte, localObject);
      }
      return localBitmapDecodeResult.a;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 1;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 3;
      }
    }
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt3, paramInt4);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, (BitmapFactory.Options)localObject);
    if (paramArrayOfByte != null)
    {
      localObject = String.valueOf(paramArrayOfByte.hashCode());
      erj localerj = new erj((String)localObject, paramArrayOfByte, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localerj);
    }
    return paramArrayOfByte;
  }
  
  public static String a()
  {
    a();
    long l = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.format("heap used=%s\n", new Object[] { Long.valueOf(l) }));
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    l = 0L;
    if (localIterator.hasNext())
    {
      Object localObject = (Reference)((Map.Entry)localIterator.next()).getValue();
      if (localObject == null) {
        break label201;
      }
      localObject = (Bitmap)((Reference)localObject).get();
      if (localObject == null) {
        break label201;
      }
      int i = ((Bitmap)localObject).getRowBytes();
      l += ((Bitmap)localObject).getHeight() * i;
    }
    label201:
    for (;;)
    {
      break;
      localStringBuffer.append("usedSize " + l / 1024L + "\n");
      localStringBuffer.append("images:" + jdField_a_of_type_JavaUtilMap);
      return localStringBuffer.toString();
    }
  }
  
  public static ArrayList a()
  {
    a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = (Reference)localEntry.getValue();
      if (localObject != null)
      {
        localObject = (Bitmap)((Reference)localObject).get();
        if (localObject != null)
        {
          int i = ((Bitmap)localObject).getRowBytes();
          long l = ((Bitmap)localObject).getHeight() * i;
          localArrayList.add(Pair.create(localEntry.getKey(), Long.valueOf(l)));
        }
      }
    }
    return localArrayList;
  }
  
  private static void a()
  {
    for (;;)
    {
      erj localerj = (erj)jdField_a_of_type_JavaLangRefReferenceQueue.poll();
      if (localerj == null) {
        break;
      }
      jdField_a_of_type_JavaUtilMap.remove(erj.a(localerj));
    }
  }
  
  /* Error */
  public static void a(String paramString, BitmapFactory.Options paramOptions, BitmapManager.BitmapDecodeResult paramBitmapDecodeResult)
  {
    // Byte code:
    //   0: invokestatic 55	com/tencent/mobileqq/util/BitmapManager:a	()V
    //   3: aconst_null
    //   4: astore 4
    //   6: new 262	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 265	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: aload 6
    //   18: ifnull +11 -> 29
    //   21: aload 6
    //   23: invokevirtual 268	java/io/File:exists	()Z
    //   26: ifne +21 -> 47
    //   29: aload_2
    //   30: iconst_2
    //   31: putfield 80	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   34: iconst_0
    //   35: ifeq +11 -> 46
    //   38: new 270	java/lang/NullPointerException
    //   41: dup
    //   42: invokespecial 271	java/lang/NullPointerException:<init>	()V
    //   45: athrow
    //   46: return
    //   47: new 273	java/io/FileInputStream
    //   50: dup
    //   51: aload 6
    //   53: invokespecial 276	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore 5
    //   58: aload 5
    //   60: astore 4
    //   62: aload 6
    //   64: invokevirtual 279	java/io/File:length	()J
    //   67: l2i
    //   68: istore_3
    //   69: aload 5
    //   71: astore 4
    //   73: iload_3
    //   74: newarray byte
    //   76: astore 6
    //   78: aload 5
    //   80: astore 4
    //   82: iload_3
    //   83: aload 5
    //   85: aload 6
    //   87: invokevirtual 283	java/io/FileInputStream:read	([B)I
    //   90: if_icmpeq +25 -> 115
    //   93: aload 5
    //   95: astore 4
    //   97: aload_2
    //   98: iconst_3
    //   99: putfield 80	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   102: aload 5
    //   104: ifnull -58 -> 46
    //   107: aload 5
    //   109: invokevirtual 286	java/io/FileInputStream:close	()V
    //   112: return
    //   113: astore_0
    //   114: return
    //   115: aload 5
    //   117: astore 4
    //   119: aload_2
    //   120: aload 6
    //   122: iconst_0
    //   123: aload 6
    //   125: arraylength
    //   126: aload_1
    //   127: invokestatic 133	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   130: putfield 77	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   133: aload 5
    //   135: ifnull +8 -> 143
    //   138: aload 5
    //   140: invokevirtual 286	java/io/FileInputStream:close	()V
    //   143: aload_2
    //   144: getfield 77	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   147: ifnull -101 -> 46
    //   150: aload_2
    //   151: iconst_0
    //   152: putfield 80	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   155: new 92	erj
    //   158: dup
    //   159: aload_0
    //   160: aload_2
    //   161: getfield 77	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   164: getstatic 30	com/tencent/mobileqq/util/BitmapManager:jdField_a_of_type_JavaLangRefReferenceQueue	Ljava/lang/ref/ReferenceQueue;
    //   167: invokespecial 95	erj:<init>	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   170: astore_1
    //   171: getstatic 25	com/tencent/mobileqq/util/BitmapManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   174: aload_0
    //   175: aload_1
    //   176: invokeinterface 101 3 0
    //   181: pop
    //   182: return
    //   183: astore_1
    //   184: aconst_null
    //   185: astore 5
    //   187: aload 5
    //   189: astore 4
    //   191: aload_2
    //   192: iconst_2
    //   193: putfield 80	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   196: aload 5
    //   198: ifnull -55 -> 143
    //   201: aload 5
    //   203: invokevirtual 286	java/io/FileInputStream:close	()V
    //   206: goto -63 -> 143
    //   209: astore_1
    //   210: goto -67 -> 143
    //   213: astore_1
    //   214: aconst_null
    //   215: astore 5
    //   217: aload 5
    //   219: astore 4
    //   221: aload_2
    //   222: iconst_1
    //   223: putfield 80	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   226: aload 5
    //   228: ifnull -85 -> 143
    //   231: aload 5
    //   233: invokevirtual 286	java/io/FileInputStream:close	()V
    //   236: goto -93 -> 143
    //   239: astore_1
    //   240: goto -97 -> 143
    //   243: astore_1
    //   244: aconst_null
    //   245: astore 5
    //   247: aload 5
    //   249: astore 4
    //   251: aload_2
    //   252: iconst_3
    //   253: putfield 80	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   256: aload 5
    //   258: ifnull -115 -> 143
    //   261: aload 5
    //   263: invokevirtual 286	java/io/FileInputStream:close	()V
    //   266: goto -123 -> 143
    //   269: astore_1
    //   270: goto -127 -> 143
    //   273: astore_0
    //   274: aload 4
    //   276: ifnull +8 -> 284
    //   279: aload 4
    //   281: invokevirtual 286	java/io/FileInputStream:close	()V
    //   284: aload_0
    //   285: athrow
    //   286: astore_0
    //   287: return
    //   288: astore_1
    //   289: goto -146 -> 143
    //   292: astore_1
    //   293: goto -9 -> 284
    //   296: astore_0
    //   297: goto -23 -> 274
    //   300: astore_1
    //   301: goto -54 -> 247
    //   304: astore_1
    //   305: goto -88 -> 217
    //   308: astore_1
    //   309: goto -122 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramString	String
    //   0	312	1	paramOptions	BitmapFactory.Options
    //   0	312	2	paramBitmapDecodeResult	BitmapManager.BitmapDecodeResult
    //   68	23	3	i	int
    //   4	276	4	localObject1	Object
    //   56	206	5	localFileInputStream	java.io.FileInputStream
    //   14	110	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   107	112	113	java/io/IOException
    //   6	16	183	java/io/FileNotFoundException
    //   21	29	183	java/io/FileNotFoundException
    //   29	34	183	java/io/FileNotFoundException
    //   47	58	183	java/io/FileNotFoundException
    //   201	206	209	java/io/IOException
    //   6	16	213	java/lang/OutOfMemoryError
    //   21	29	213	java/lang/OutOfMemoryError
    //   29	34	213	java/lang/OutOfMemoryError
    //   47	58	213	java/lang/OutOfMemoryError
    //   231	236	239	java/io/IOException
    //   6	16	243	java/lang/Throwable
    //   21	29	243	java/lang/Throwable
    //   29	34	243	java/lang/Throwable
    //   47	58	243	java/lang/Throwable
    //   261	266	269	java/io/IOException
    //   6	16	273	finally
    //   21	29	273	finally
    //   29	34	273	finally
    //   47	58	273	finally
    //   38	46	286	java/io/IOException
    //   138	143	288	java/io/IOException
    //   279	284	292	java/io/IOException
    //   62	69	296	finally
    //   73	78	296	finally
    //   82	93	296	finally
    //   97	102	296	finally
    //   119	133	296	finally
    //   191	196	296	finally
    //   221	226	296	finally
    //   251	256	296	finally
    //   62	69	300	java/lang/Throwable
    //   73	78	300	java/lang/Throwable
    //   82	93	300	java/lang/Throwable
    //   97	102	300	java/lang/Throwable
    //   119	133	300	java/lang/Throwable
    //   62	69	304	java/lang/OutOfMemoryError
    //   73	78	304	java/lang/OutOfMemoryError
    //   82	93	304	java/lang/OutOfMemoryError
    //   97	102	304	java/lang/OutOfMemoryError
    //   119	133	304	java/lang/OutOfMemoryError
    //   62	69	308	java/io/FileNotFoundException
    //   73	78	308	java/io/FileNotFoundException
    //   82	93	308	java/io/FileNotFoundException
    //   97	102	308	java/io/FileNotFoundException
    //   119	133	308	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.BitmapManager
 * JD-Core Version:    0.7.0.1
 */