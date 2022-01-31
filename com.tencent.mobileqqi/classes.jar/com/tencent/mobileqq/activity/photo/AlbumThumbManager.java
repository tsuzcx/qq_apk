package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import com.qzone.utils.BytesBufferPool;
import com.qzone.utils.BytesBufferPool.BytesBuffer;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.mobileqq.util.BitmapPool;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.cache.common.BlobCache;
import common.qzone.component.cache.common.BlobCache.LookupRequest;
import common.qzone.component.util.SecurityUtil;
import eqt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;

public class AlbumThumbManager
{
  private static final int jdField_a_of_type_Int = 16;
  private static final BytesBufferPool jdField_a_of_type_ComQzoneUtilsBytesBufferPool = new BytesBufferPool(4, 204800);
  private static AlbumThumbManager jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
  private static eqt jdField_a_of_type_Eqt;
  private static ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private static final int b = 100;
  private static final int c = 4;
  private static final int d = 102400;
  private static final int e = 204800;
  private static final int f = 1048576;
  private static final int g = 2500;
  private static final int h = 52428800;
  private static final int i = 1;
  Context jdField_a_of_type_AndroidContentContext;
  BlobCache jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  
  private AlbumThumbManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a(paramContext);
  }
  
  public static AlbumThumbManager a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager != null) {
      return jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager != null)
      {
        paramContext = jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
        return paramContext;
      }
    }
    finally {}
    paramContext = new AlbumThumbManager(paramContext);
    jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager = paramContext;
    return paramContext;
  }
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 67	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   21: getstatic 74	com/tencent/mobileqq/app/AppConstants:an	Ljava/lang/String;
    //   24: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 80
    //   29: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 82
    //   34: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: new 88	java/io/File
    //   44: dup
    //   45: new 67	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   52: getstatic 74	com/tencent/mobileqq/app/AppConstants:an	Ljava/lang/String;
    //   55: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 80
    //   60: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 95	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_2
    //   78: invokevirtual 98	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aload_0
    //   83: new 100	common/qzone/component/cache/common/BlobCache
    //   86: dup
    //   87: aload_1
    //   88: sipush 2500
    //   91: ldc 25
    //   93: iconst_0
    //   94: iconst_1
    //   95: invokespecial 103	common/qzone/component/cache/common/BlobCache:<init>	(Ljava/lang/String;IIZI)V
    //   98: putfield 65	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   101: goto -90 -> 11
    //   104: astore_1
    //   105: ldc 105
    //   107: iconst_2
    //   108: ldc 107
    //   110: aload_1
    //   111: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: goto -103 -> 11
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	AlbumThumbManager
    //   0	122	1	paramContext	Context
    //   69	9	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   41	82	104	java/lang/Exception
    //   82	101	104	java/lang/Exception
    //   2	7	117	finally
    //   14	41	117	finally
    //   41	82	117	finally
    //   82	101	117	finally
    //   105	114	117	finally
  }
  
  private boolean a(byte[] paramArrayOfByte, long paramLong, BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    if (paramArrayOfByte == null) {}
    BlobCache.LookupRequest localLookupRequest;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache != null) {
          break;
        }
        a(this.jdField_a_of_type_AndroidContentContext);
      } while (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache == null);
      try
      {
        localLookupRequest = new BlobCache.LookupRequest();
        localLookupRequest.jdField_a_of_type_Long = paramLong;
        localLookupRequest.jdField_a_of_type_ArrayOfByte = paramBytesBuffer.data;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (!this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(localLookupRequest)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!a(paramArrayOfByte, localLookupRequest.jdField_a_of_type_ArrayOfByte));
    paramBytesBuffer.data = localLookupRequest.jdField_a_of_type_ArrayOfByte;
    paramBytesBuffer.offset = paramArrayOfByte.length;
    paramBytesBuffer.length = (localLookupRequest.jdField_a_of_type_Int - paramBytesBuffer.offset);
    return true;
  }
  
  private boolean a(byte[] paramArrayOfByte, long paramLong, eqt parameqt)
  {
    if (paramArrayOfByte == null) {}
    BlobCache.LookupRequest localLookupRequest;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache != null) {
          break;
        }
        a(this.jdField_a_of_type_AndroidContentContext);
      } while (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache == null);
      try
      {
        localLookupRequest = new BlobCache.LookupRequest();
        localLookupRequest.jdField_a_of_type_Long = paramLong;
        localLookupRequest.jdField_a_of_type_ArrayOfByte = parameqt.jdField_a_of_type_ArrayOfByte;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (!this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(localLookupRequest)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!a(paramArrayOfByte, localLookupRequest.jdField_a_of_type_ArrayOfByte, localLookupRequest.jdField_a_of_type_Int - 16, 16));
    parameqt.jdField_a_of_type_ArrayOfByte = localLookupRequest.jdField_a_of_type_ArrayOfByte;
    parameqt.jdField_a_of_type_Int = 0;
    parameqt.b = (localLookupRequest.jdField_a_of_type_Int - 16);
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = paramArrayOfByte1.length;
    if (paramArrayOfByte2.length < k) {
      return false;
    }
    int j = 0;
    for (;;)
    {
      if (j >= k) {
        break label34;
      }
      if (paramArrayOfByte1[j] != paramArrayOfByte2[j]) {
        break;
      }
      j += 1;
    }
    label34:
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte1.length < paramInt2) {}
    while (paramArrayOfByte2.length < paramInt1 + paramInt2) {
      return false;
    }
    int j = 0;
    for (;;)
    {
      if (j >= paramInt2) {
        break label47;
      }
      if (paramArrayOfByte1[j] != paramArrayOfByte2[(paramInt1 + j)]) {
        break;
      }
      j += 1;
    }
    label47:
    return true;
  }
  
  private static byte[] a(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(65536);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  /* Error */
  public Bitmap a(URL paramURL, BitmapDecoder paramBitmapDecoder)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 184	java/net/URL:toString	()Ljava/lang/String;
    //   4: invokestatic 189	common/qzone/component/util/SecurityUtil:a	(Ljava/lang/String;)[B
    //   7: astore 7
    //   9: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComQzoneUtilsBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   12: invokevirtual 193	com/qzone/utils/BytesBufferPool:get	()Lcom/qzone/utils/BytesBufferPool$BytesBuffer;
    //   15: astore 6
    //   17: aload 7
    //   19: invokestatic 196	common/qzone/component/util/SecurityUtil:a	([B)J
    //   22: lstore_3
    //   23: aload_0
    //   24: aload 7
    //   26: lload_3
    //   27: aload 6
    //   29: invokespecial 198	com/tencent/mobileqq/activity/photo/AlbumThumbManager:a	([BJLcom/qzone/utils/BytesBufferPool$BytesBuffer;)Z
    //   32: istore 5
    //   34: ldc 105
    //   36: iconst_2
    //   37: new 67	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   44: ldc 200
    //   46: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 203	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   53: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: iload 5
    //   64: ifne +121 -> 185
    //   67: aload_2
    //   68: aload_1
    //   69: invokeinterface 211 2 0
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +139 -> 215
    //   79: aload_1
    //   80: bipush 100
    //   82: invokestatic 213	com/tencent/mobileqq/activity/photo/AlbumThumbManager:a	(Landroid/graphics/Bitmap;I)[B
    //   85: astore 8
    //   87: aload 7
    //   89: arraylength
    //   90: aload 8
    //   92: arraylength
    //   93: iadd
    //   94: invokestatic 219	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   97: astore_2
    //   98: aload_2
    //   99: aload 7
    //   101: invokevirtual 223	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   104: pop
    //   105: aload_2
    //   106: aload 8
    //   108: invokevirtual 223	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   111: pop
    //   112: aload_0
    //   113: getfield 46	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   116: astore 7
    //   118: aload 7
    //   120: monitorenter
    //   121: aload_0
    //   122: getfield 65	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   125: lload_3
    //   126: aload_2
    //   127: invokevirtual 226	java/nio/ByteBuffer:array	()[B
    //   130: invokevirtual 229	common/qzone/component/cache/common/BlobCache:a	(J[B)V
    //   133: aload 7
    //   135: monitorexit
    //   136: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComQzoneUtilsBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   139: aload 6
    //   141: invokevirtual 233	com/qzone/utils/BytesBufferPool:recycle	(Lcom/qzone/utils/BytesBufferPool$BytesBuffer;)V
    //   144: aload_1
    //   145: areturn
    //   146: astore_2
    //   147: ldc 105
    //   149: iconst_2
    //   150: ldc 235
    //   152: aload_2
    //   153: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   156: goto -23 -> 133
    //   159: astore_1
    //   160: aload 7
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    //   165: astore_1
    //   166: ldc 105
    //   168: iconst_2
    //   169: ldc 237
    //   171: aload_1
    //   172: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   175: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComQzoneUtilsBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   178: aload 6
    //   180: invokevirtual 233	com/qzone/utils/BytesBufferPool:recycle	(Lcom/qzone/utils/BytesBufferPool$BytesBuffer;)V
    //   183: aconst_null
    //   184: areturn
    //   185: aload 6
    //   187: getfield 127	com/qzone/utils/BytesBufferPool$BytesBuffer:data	[B
    //   190: aload 6
    //   192: getfield 140	com/qzone/utils/BytesBufferPool$BytesBuffer:offset	I
    //   195: aload 6
    //   197: getfield 145	com/qzone/utils/BytesBufferPool$BytesBuffer:length	I
    //   200: aconst_null
    //   201: invokestatic 243	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   204: astore_1
    //   205: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComQzoneUtilsBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   208: aload 6
    //   210: invokevirtual 233	com/qzone/utils/BytesBufferPool:recycle	(Lcom/qzone/utils/BytesBufferPool$BytesBuffer;)V
    //   213: aload_1
    //   214: areturn
    //   215: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComQzoneUtilsBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   218: aload 6
    //   220: invokevirtual 233	com/qzone/utils/BytesBufferPool:recycle	(Lcom/qzone/utils/BytesBufferPool$BytesBuffer;)V
    //   223: goto -40 -> 183
    //   226: astore_1
    //   227: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComQzoneUtilsBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   230: aload 6
    //   232: invokevirtual 233	com/qzone/utils/BytesBufferPool:recycle	(Lcom/qzone/utils/BytesBufferPool$BytesBuffer;)V
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	AlbumThumbManager
    //   0	237	1	paramURL	URL
    //   0	237	2	paramBitmapDecoder	BitmapDecoder
    //   22	104	3	l	long
    //   32	31	5	bool	boolean
    //   15	216	6	localBytesBuffer	BytesBufferPool.BytesBuffer
    //   85	22	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   121	133	146	java/io/IOException
    //   121	133	159	finally
    //   133	136	159	finally
    //   147	156	159	finally
    //   160	163	159	finally
    //   23	62	165	java/lang/Throwable
    //   67	75	165	java/lang/Throwable
    //   79	121	165	java/lang/Throwable
    //   163	165	165	java/lang/Throwable
    //   185	205	165	java/lang/Throwable
    //   23	62	226	finally
    //   67	75	226	finally
    //   79	121	226	finally
    //   163	165	226	finally
    //   166	175	226	finally
    //   185	205	226	finally
  }
  
  public Bitmap a(URL arg1, BitmapDecoder paramBitmapDecoder, BitmapPool paramBitmapPool)
  {
    try
    {
      if (jdField_a_of_type_Eqt == null)
      {
        jdField_a_of_type_Eqt = new eqt(102400, null);
        jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.wrap(jdField_a_of_type_Eqt.jdField_a_of_type_ArrayOfByte);
      }
      jdField_a_of_type_JavaNioByteBuffer.clear();
      paramBitmapPool = SecurityUtil.a(???.toString());
      if (paramBitmapPool.length < 16) {
        paramBitmapPool = a(paramBitmapPool, 16);
      }
      for (;;)
      {
        long l = SecurityUtil.a(paramBitmapPool);
        for (;;)
        {
          try
          {
            if (a(paramBitmapPool, l, jdField_a_of_type_Eqt)) {
              continue;
            }
            paramBitmapDecoder = paramBitmapDecoder.a(???);
            if (paramBitmapDecoder == null) {
              continue;
            }
            ??? = paramBitmapDecoder;
            if (paramBitmapDecoder.getConfig() == Bitmap.Config.RGB_565)
            {
              ??? = paramBitmapDecoder;
              if (jdField_a_of_type_JavaNioByteBuffer.remaining() >= paramBitmapDecoder.getHeight() * paramBitmapDecoder.getRowBytes() + 16 + 8)
              {
                paramBitmapDecoder.copyPixelsToBuffer(jdField_a_of_type_JavaNioByteBuffer);
                jdField_a_of_type_JavaNioByteBuffer.putInt(paramBitmapDecoder.getWidth());
                jdField_a_of_type_JavaNioByteBuffer.putInt(paramBitmapDecoder.getHeight());
                jdField_a_of_type_JavaNioByteBuffer.put(paramBitmapPool, 0, 16);
              }
            }
          }
          catch (Throwable ???)
          {
            QLog.e("AlbumThumbManager", 2, "decode thumb", ???);
            ??? = null;
            continue;
            jdField_a_of_type_JavaNioByteBuffer.clear();
            jdField_a_of_type_JavaNioByteBuffer.put(jdField_a_of_type_Eqt.jdField_a_of_type_ArrayOfByte, 0, jdField_a_of_type_Eqt.b);
            int j = jdField_a_of_type_JavaNioByteBuffer.getInt(jdField_a_of_type_Eqt.b - 8);
            int k = jdField_a_of_type_JavaNioByteBuffer.getInt(jdField_a_of_type_Eqt.b - 4);
            if ((j <= 500) || (k <= 500)) {
              continue;
            }
            QLog.e("AlbumThumbManager", 2, "thumb bitmap is dirty:" + ???.toString());
            ??? = null;
            continue;
            ??? = Bitmap.createBitmap(j, k, Bitmap.Config.RGB_565);
            jdField_a_of_type_JavaNioByteBuffer.limit(jdField_a_of_type_Eqt.b - 8);
            jdField_a_of_type_JavaNioByteBuffer.position(0);
            ???.copyPixelsFromBuffer(jdField_a_of_type_JavaNioByteBuffer);
            continue;
          }
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            try
            {
              j = paramBitmapDecoder.getRowBytes();
              k = paramBitmapDecoder.getHeight();
              this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(l, jdField_a_of_type_JavaNioByteBuffer.array(), j * k + 24);
              ??? = paramBitmapDecoder;
              return ???;
            }
            catch (IOException paramBitmapPool)
            {
              QLog.e("AlbumThumbManager", 2, "decode thumb ioexception", paramBitmapPool);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      jdField_a_of_type_ComQzoneUtilsBytesBufferPool.clear();
      jdField_a_of_type_Eqt = null;
      jdField_a_of_type_JavaNioByteBuffer = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = 0;
    while (paramInt < paramArrayOfByte.length)
    {
      arrayOfByte[paramInt] = paramArrayOfByte[paramInt];
      paramInt += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumThumbManager
 * JD-Core Version:    0.7.0.1
 */