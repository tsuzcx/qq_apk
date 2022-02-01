import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class azat
{
  public static String AVC_CODEC_MIME = "video/avc";
  public static int DEC_CODEC;
  public static int ENC_CODEC = 1;
  public static String ForceIFrame = "request-sync";
  public static String TAG = "AndroidCodec";
  protected static boolean Tu = true;
  protected static Method k;
  protected static Method l;
  protected static Method m;
  protected static Method n;
  protected ByteBuffer[] inputBuffers;
  protected int mCodecType = DEC_CODEC;
  protected MediaFormat mFormat;
  protected MediaCodec mMediaCodec;
  protected MediaFormat mOutputFormat;
  protected ByteBuffer[] outputBuffers;
  
  public azat()
  {
    aoG();
    if ((Build.VERSION.SDK_INT >= 19) && (n == null)) {}
    try
    {
      n = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      n = null;
    }
  }
  
  public static List<MediaCodecInfo> aN(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < i1)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localMediaCodecInfo.getName().contains(".sw.")) || (localMediaCodecInfo.getName().contains(".SW.")) || (localMediaCodecInfo.getName().contains("google")) || (localMediaCodecInfo.getName().contains("Google")) || (localMediaCodecInfo.getName().contains("GOOGLE")))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected static void aoG()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (k == null) {
        k = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (l == null) {
        l = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (m == null) {
        m = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      }
      return;
    }
    catch (Exception localException)
    {
      k = null;
      l = null;
      m = null;
      Tu = false;
    }
  }
  
  public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception paramMediaCodecInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "getCodecCapabilities erro", paramMediaCodecInfo);
      }
    }
    return null;
  }
  
  public static MediaCodecInfo getCodecInfo(String paramString)
  {
    int j = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < j)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.getName().equalsIgnoreCase(paramString)) {
        return localMediaCodecInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public static List<MediaCodecInfo> i(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < i1)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE"))))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public MediaCodec a()
  {
    return this.mMediaCodec;
  }
  
  /* Error */
  public azat.a a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 185	azat:mMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 6	azat$a
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 195	azat$a:<init>	(Lazat;)V
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 185	azat:mMediaCodec	Landroid/media/MediaCodec;
    //   23: lload_1
    //   24: invokevirtual 199	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   27: istore_3
    //   28: iload_3
    //   29: iflt +139 -> 168
    //   32: getstatic 69	android/os/Build$VERSION:SDK_INT	I
    //   35: bipush 20
    //   37: if_icmpgt +34 -> 71
    //   40: aload_0
    //   41: monitorenter
    //   42: aload 4
    //   44: iload_3
    //   45: putfield 202	azat$a:index	I
    //   48: aload 4
    //   50: aload_0
    //   51: getfield 204	azat:inputBuffers	[Ljava/nio/ByteBuffer;
    //   54: iload_3
    //   55: aaload
    //   56: putfield 208	azat$a:buffer	Ljava/nio/ByteBuffer;
    //   59: aload_0
    //   60: monitorexit
    //   61: aload 4
    //   63: areturn
    //   64: astore 4
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 4
    //   70: athrow
    //   71: aload_0
    //   72: monitorenter
    //   73: aload 4
    //   75: iload_3
    //   76: putfield 202	azat$a:index	I
    //   79: aload 4
    //   81: getstatic 144	azat:k	Ljava/lang/reflect/Method;
    //   84: aload_0
    //   85: getfield 185	azat:mMediaCodec	Landroid/media/MediaCodec;
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: iload_3
    //   95: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokevirtual 218	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 220	java/nio/ByteBuffer
    //   105: putfield 208	azat$a:buffer	Ljava/nio/ByteBuffer;
    //   108: aload_0
    //   109: monitorexit
    //   110: aload 4
    //   112: areturn
    //   113: astore 5
    //   115: aload 5
    //   117: invokevirtual 223	java/lang/IllegalAccessException:printStackTrace	()V
    //   120: aload 4
    //   122: iconst_0
    //   123: putfield 226	azat$a:success	Z
    //   126: goto -18 -> 108
    //   129: astore 4
    //   131: aload_0
    //   132: monitorexit
    //   133: aload 4
    //   135: athrow
    //   136: astore 5
    //   138: aload 5
    //   140: invokevirtual 227	java/lang/IllegalArgumentException:printStackTrace	()V
    //   143: aload 4
    //   145: iconst_0
    //   146: putfield 226	azat$a:success	Z
    //   149: goto -41 -> 108
    //   152: astore 5
    //   154: aload 5
    //   156: invokevirtual 228	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   159: aload 4
    //   161: iconst_0
    //   162: putfield 226	azat$a:success	Z
    //   165: goto -57 -> 108
    //   168: aload 4
    //   170: iload_3
    //   171: putfield 202	azat$a:index	I
    //   174: aload 4
    //   176: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	azat
    //   0	177	1	paramLong	long
    //   27	144	3	i	int
    //   17	45	4	locala1	azat.a
    //   64	57	4	locala2	azat.a
    //   129	46	4	locala3	azat.a
    //   113	3	5	localIllegalAccessException	IllegalAccessException
    //   136	3	5	localIllegalArgumentException	IllegalArgumentException
    //   152	3	5	localInvocationTargetException	InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   42	61	64	finally
    //   66	68	64	finally
    //   79	108	113	java/lang/IllegalAccessException
    //   73	79	129	finally
    //   79	108	129	finally
    //   108	110	129	finally
    //   115	126	129	finally
    //   131	133	129	finally
    //   138	149	129	finally
    //   154	165	129	finally
    //   79	108	136	java/lang/IllegalArgumentException
    //   79	108	152	java/lang/reflect/InvocationTargetException
  }
  
  public void a(azat.a parama)
  {
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.releaseOutputBuffer(parama.index, false);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "releaseOutputBuffer index = " + parama.index);
        }
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void a(azat.a parama, int paramInt1, long paramLong, int paramInt2)
  {
    try
    {
      if (this.mMediaCodec != null) {
        this.mMediaCodec.queueInputBuffer(parama.index, 0, paramInt1, paramLong, paramInt2);
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString)
  {
    this.mFormat = paramMediaFormat;
    paramMediaFormat = getCodecInfo(paramString);
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder())) {
      this.mCodecType = ENC_CODEC;
    }
    for (int i = 1;; i = 0) {
      try
      {
        this.mMediaCodec = MediaCodec.createByCodecName(paramString);
        return false;
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.mMediaCodec != null) {
            this.mMediaCodec.configure(this.mFormat, null, null, i);
          }
          if (this.mMediaCodec == null) {
            continue;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          this.mMediaCodec.release();
          this.mMediaCodec = null;
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
  }
  
  public azat.a b(long paramLong)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject5;
      int i;
      try
      {
        localObject5 = this.mMediaCodec;
        if (localObject5 == null) {
          return localObject1;
        }
        localObject5 = new azat.a();
        i = this.mMediaCodec.dequeueOutputBuffer(((azat.a)localObject5).info, paramLong);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dequeueOutputBuffer ok,index = " + i + ",BufferInfo[flags = " + ((azat.a)localObject5).info.flags + ",offset=" + ((azat.a)localObject5).info.offset + ",size= " + ((azat.a)localObject5).info.size + ",TimeUs=" + ((azat.a)localObject5).info.presentationTimeUs + "]");
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label444;
          }
          ((azat.a)localObject5).buffer = this.outputBuffers[i];
          ((azat.a)localObject5).index = i;
          ((azat.a)localObject5).format = this.mOutputFormat;
          localObject1 = localObject5;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          ((azat.a)localObject5).index = -3;
        }
      }
      finally {}
      ((azat.a)localObject5).index = -2;
      this.mOutputFormat = this.mMediaCodec.getOutputFormat();
      if (this.mOutputFormat != null)
      {
        i = this.mCodecType;
        int j = DEC_CODEC;
        if (i == j)
        {
          try
          {
            i = this.mOutputFormat.getInteger("color-format");
            if (!QLog.isColorLevel()) {
              break label566;
            }
            QLog.e(TAG, 2, "New color format " + i + "[0x" + Integer.toHexString(i) + "]");
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label566;
            }
          }
          QLog.e(TAG, 2, "Exception,INFO_OUTPUT_FORMAT_CHANGED");
        }
        else if (QLog.isColorLevel())
        {
          QLog.e(TAG, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
          break label566;
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "dequeueOutputBuffer timed out!");
          }
          ((azat.a)localObject5).index = -1;
          Object localObject3 = localObject5;
          continue;
          label444:
          ((azat.a)localObject5).index = i;
          try
          {
            ((azat.a)localObject5).buffer = ((ByteBuffer)l.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
            ((azat.a)localObject5).format = ((MediaFormat)m.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
            localObject3 = localObject5;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            for (;;)
            {
              localIllegalAccessException.printStackTrace();
              ((azat.a)localObject5).success = false;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              localIllegalArgumentException.printStackTrace();
              ((azat.a)localObject5).success = false;
            }
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            for (;;)
            {
              localInvocationTargetException.printStackTrace();
              ((azat.a)localObject5).success = false;
            }
          }
          continue;
        }
      }
      label566:
      Object localObject4 = localObject5;
    }
  }
  
  public void release()
  {
    try
    {
      this.inputBuffers = null;
      this.outputBuffers = null;
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean start()
  {
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.inputBuffers = this.mMediaCodec.getInputBuffers();
            this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          }
          finally {}
        }
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void stop()
  {
    if (this.mMediaCodec != null) {
      this.mMediaCodec.stop();
    }
  }
  
  public class a
  {
    public ByteBuffer buffer;
    public MediaFormat format;
    public int index;
    public MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
    public boolean success = true;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azat
 * JD-Core Version:    0.7.0.1
 */