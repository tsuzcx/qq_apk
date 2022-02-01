import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.av.mediacodec.NativeCodec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
public class ioc
{
  public static String AVC_CODEC_MIME;
  public static int DEC_CODEC;
  public static int ENC_CODEC = 1;
  public static String ForceIFrame;
  public static String OM;
  public static int TIMEOUT_US = 33000;
  protected static boolean Tu;
  public static boolean Tv;
  public static int aqO;
  protected static boolean gfLoaded;
  protected static Method k;
  protected static Method l;
  protected static Method m;
  protected static Method n;
  final String TAG;
  public boolean Tw;
  protected ByteBuffer[] inputBuffers;
  protected int mCodecType = DEC_CODEC;
  protected MediaFormat mFormat;
  protected MediaCodec mMediaCodec;
  protected MediaFormat mOutputFormat;
  protected ByteBuffer[] outputBuffers;
  
  static
  {
    AVC_CODEC_MIME = "video/avc";
    OM = "video/hevc";
    ForceIFrame = "request-sync";
    Tu = true;
  }
  
  @Deprecated
  public ioc()
  {
    this("unknown");
  }
  
  public ioc(String paramString)
  {
    this.TAG = (paramString + "_AndroidCodec");
    jr(this.TAG);
    if ((Build.VERSION.SDK_INT >= 19) && (n == null)) {}
    try
    {
      n = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException paramString)
    {
      n = null;
    }
  }
  
  public static ArrayList<ioc.b> a(String paramString, Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      jr(paramString);
      if (!Tu)
      {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不是API21");
        return null;
      }
    }
    if (!new File(paramContext.getApplicationInfo().nativeLibraryDir + "/libhwcodec.so").exists())
    {
      QLog.w(paramString, 1, "checkSupportHWCodecAbility,  libhwcodec不存在");
      return null;
    }
    Object localObject2;
    if (!gfLoaded)
    {
      loadCodecLibrarys();
      if (gfLoaded)
      {
        localObject1 = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
        localObject1 = (String)localObject1 + "MODEL=" + Build.MODEL.toLowerCase() + ";";
        localObject1 = (String)localObject1 + "SDK=" + Build.VERSION.SDK_INT + ";";
        localObject1 = (String)localObject1 + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
        localObject2 = (String)localObject1 + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
        localObject1 = paramContext.getApplicationInfo();
        localObject2 = (String)localObject2 + "DATADIR=" + ((ApplicationInfo)localObject1).dataDir + ";";
        if (Build.VERSION.SDK_INT < 9) {
          break label358;
        }
      }
    }
    label358:
    for (Object localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).nativeLibraryDir + ";";; localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).dataDir + "/lib;")
    {
      NativeCodec.set_device_infos((String)localObject1);
      if (gfLoaded) {
        break;
      }
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, lib失败");
      return null;
    }
    localObject1 = new ArrayList();
    if (AudioHelper.aCz()) {
      QLog.e(paramString, 1, "checkSupportHWCodecAbility start");
    }
    if (DeviceCheck.isAVCDecWhitelistDevices()) {
      if (DeviceCheck.isAVCDecSupportColorformats())
      {
        ((ArrayList)localObject1).add(new ioc.b(1, true));
        if (AudioHelper.aCz()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 支持H264解码");
        }
        if (!DeviceCheck.isAVCEncWhitelistDevices()) {
          break label749;
        }
        if (!DeviceCheck.isAVCEncSupportColorformats()) {
          break label738;
        }
        ((ArrayList)localObject1).add(new ioc.b(2, true));
        if (AudioHelper.aCz()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 支持H264编码");
        }
      }
    }
    for (;;)
    {
      Tv = p((ArrayList)localObject1);
      return localObject1;
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 不支持H264解码");
      break;
      localObject2 = new ioe(ijc.a(paramContext));
      ioc.b localb = ((ioe)localObject2).c();
      if ((localb != null) && (localb.Tx)) {
        if (DeviceCheck.isAVCDecSupportColorformats())
        {
          ((ArrayList)localObject1).add(localb);
          if (AudioHelper.aCz()) {
            QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H264解码. maxW = " + localb.aqP + ", maxH = " + localb.aqQ);
          }
        }
      }
      for (;;)
      {
        localObject2 = ((ioe)localObject2).a();
        if ((localObject2 == null) || (!((ioc.b)localObject2).Tx)) {
          break label721;
        }
        if (!DeviceCheck.uz()) {
          break label710;
        }
        ((ArrayList)localObject1).add(localObject2);
        if (!AudioHelper.aCz()) {
          break;
        }
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H265解码. maxW = " + ((ioc.b)localObject2).aqP + ", maxH = " + ((ioc.b)localObject2).aqQ);
        break;
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H264解码");
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H264解码配置");
        }
      }
      label710:
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H265解码");
      break;
      label721:
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H265解码配置");
      break;
      label738:
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 不支持H264编码");
      continue;
      label749:
      paramContext = new ioe(ijc.a(paramContext));
      localObject2 = paramContext.d();
      if ((localObject2 != null) && (((ioc.b)localObject2).Tx)) {
        if (DeviceCheck.isAVCEncSupportColorformats())
        {
          ((ArrayList)localObject1).add(localObject2);
          if (AudioHelper.aCz()) {
            QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H264编码. maxW = " + ((ioc.b)localObject2).aqP + ", maxH = " + ((ioc.b)localObject2).aqQ);
          }
        }
      }
      for (;;)
      {
        paramContext = paramContext.b();
        if ((paramContext == null) || (!paramContext.Tx)) {
          break label953;
        }
        if (!DeviceCheck.uA()) {
          break label942;
        }
        ((ArrayList)localObject1).add(paramContext);
        if (!AudioHelper.aCz()) {
          break;
        }
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H265编码. maxW = " + paramContext.aqP + ", maxH = " + paramContext.aqQ);
        break;
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H264编码");
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H264编码配置");
        }
      }
      label942:
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H265编码");
      continue;
      label953:
      if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H265编码配置");
      }
    }
  }
  
  protected static void aoG()
  {
    jr("unknown");
  }
  
  public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    Object localObject = null;
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception localException)
    {
      do
      {
        paramMediaCodecInfo = localObject;
      } while (!QLog.isDevelopLevel());
      QLog.w("AndroidCodec", 1, "getCodecCapabilities, Exception, mime[" + paramString + "]", localException);
    }
    return null;
  }
  
  public static MediaCodecInfo getCodecInfo(String paramString)
  {
    try
    {
      int j = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        boolean bool = localMediaCodecInfo.getName().equalsIgnoreCase(paramString);
        if (bool) {
          return localMediaCodecInfo;
        }
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString) {}
  }
  
  @SuppressLint({"NewApi"})
  public static List<MediaCodecInfo> getDecoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        int i1 = MediaCodecList.getCodecCount();
        i = 0;
        if (i < i1)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((!localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int j = 0;
            if (j < arrayOfString.length)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString) {}
      i += 1;
    }
  }
  
  public static List<MediaCodecInfo> getEndoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        int i1 = MediaCodecList.getCodecCount();
        i = 0;
        if (i < i1)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int j = 0;
            if (j < arrayOfString.length)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString) {}
      i += 1;
    }
  }
  
  protected static void jr(String paramString)
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
    }
    catch (Exception localException)
    {
      for (;;)
      {
        k = null;
        l = null;
        m = null;
        Tu = false;
      }
    }
    if ((QLog.isDevelopLevel()) || (!Tu)) {
      QLog.w(paramString, 1, "invoke21Apis, fInvokeAPILevel21[" + Tu + "]");
    }
  }
  
  public static int lm()
  {
    return aqO;
  }
  
  public static void loadCodecLibrarys()
  {
    if (!gfLoaded) {}
    try
    {
      SoLoadUtil.loadNativeLibrary(BaseApplicationImpl.getContext(), "c++_shared", 0, false);
      System.loadLibrary("hwcodec");
      int i = NativeCodec.getVersion();
      QLog.w("AndroidCodec", 1, "loadCodecLibrarys suc, ver[" + i + "]");
      gfLoaded = true;
      if (!gfLoaded) {
        QLog.w("AndroidCodec", 1, "loadCodecLibrarys fail");
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        gfLoaded = false;
      }
    }
  }
  
  private static boolean p(ArrayList<ioc.b> paramArrayList)
  {
    boolean bool2 = false;
    int i2;
    int i1;
    int j;
    int i;
    int i6;
    int i5;
    int i4;
    int i3;
    ioc.b localb;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      i2 = 0;
      i1 = 0;
      j = 0;
      i = 0;
      i6 = i2;
      i5 = i1;
      i4 = j;
      i3 = i;
      if (!paramArrayList.hasNext()) {
        break label327;
      }
      localb = (ioc.b)paramArrayList.next();
      if ((localb.amp == 1) && (localb.Tx) && (localb.aqP >= 1920) && (localb.aqQ >= 1080))
      {
        i3 = i2;
        j = i1;
        i1 = 1;
        i2 = i;
        i = i3;
      }
    }
    for (;;)
    {
      i3 = i2;
      i4 = i1;
      i2 = i;
      i1 = j;
      j = i4;
      i = i3;
      break;
      if ((localb.amp == 2) && (localb.Tx) && (localb.aqP >= 1920) && (localb.aqQ >= 1080))
      {
        i = i2;
        i2 = j;
        i3 = 1;
        j = i1;
        i1 = i2;
        i2 = i3;
      }
      else if ((localb.amp == 4) && (localb.Tx) && (localb.aqP >= 1920) && (localb.aqQ >= 1080))
      {
        i4 = 1;
        i2 = j;
        i3 = i;
        i = i4;
        j = i1;
        i1 = i2;
        i2 = i3;
      }
      else if ((localb.amp == 8) && (localb.Tx) && (localb.aqP >= 1920) && (localb.aqQ >= 1080))
      {
        i3 = i2;
        i1 = j;
        j = 1;
        i2 = i;
        i = i3;
        continue;
        i6 = 0;
        i5 = 0;
        i4 = 0;
        i3 = 0;
        label327:
        boolean bool1;
        if ((i3 == 0) || (i4 == 0))
        {
          bool1 = bool2;
          if (i5 != 0)
          {
            bool1 = bool2;
            if (i6 == 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
        QLog.i("AndroidCodec", 1, "isSupportHwCodec1080P = " + bool1);
        return bool1;
      }
      else
      {
        i3 = j;
        i4 = i;
        i = i2;
        j = i1;
        i1 = i3;
        i2 = i4;
      }
    }
  }
  
  /* Error */
  public ioc.a a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 6	ioc$a
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 486	ioc$a:<init>	(Lioc;)V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   22: getstatic 66	ioc:TIMEOUT_US	I
    //   25: i2l
    //   26: invokevirtual 490	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   29: istore_1
    //   30: iload_1
    //   31: iflt -24 -> 7
    //   34: getstatic 106	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 20
    //   39: if_icmpgt +29 -> 68
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_2
    //   45: iload_1
    //   46: putfield 493	ioc$a:index	I
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 495	ioc:inputBuffers	[Ljava/nio/ByteBuffer;
    //   54: iload_1
    //   55: aaload
    //   56: putfield 499	ioc$a:buffer	Ljava/nio/ByteBuffer;
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: areturn
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    //   68: aload_0
    //   69: monitorenter
    //   70: aload_2
    //   71: iload_1
    //   72: putfield 493	ioc$a:index	I
    //   75: aload_2
    //   76: getstatic 392	ioc:k	Ljava/lang/reflect/Method;
    //   79: aload_0
    //   80: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: iload_1
    //   90: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: invokevirtual 509	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 511	java/nio/ByteBuffer
    //   100: putfield 499	ioc$a:buffer	Ljava/nio/ByteBuffer;
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: areturn
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 512	java/lang/IllegalAccessException:printStackTrace	()V
    //   112: aload_2
    //   113: iconst_0
    //   114: putfield 515	ioc$a:success	Z
    //   117: goto -14 -> 103
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual 516	java/lang/IllegalArgumentException:printStackTrace	()V
    //   130: aload_2
    //   131: iconst_0
    //   132: putfield 515	ioc$a:success	Z
    //   135: goto -32 -> 103
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 517	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   143: aload_2
    //   144: iconst_0
    //   145: putfield 515	ioc$a:success	Z
    //   148: goto -45 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	ioc
    //   29	61	1	i	int
    //   17	45	2	locala1	ioc.a
    //   63	50	2	locala2	ioc.a
    //   120	24	2	localObject	Object
    //   107	2	3	localIllegalAccessException	IllegalAccessException
    //   125	2	3	localIllegalArgumentException	IllegalArgumentException
    //   138	2	3	localInvocationTargetException	InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   44	61	63	finally
    //   64	66	63	finally
    //   75	103	107	java/lang/IllegalAccessException
    //   70	75	120	finally
    //   75	103	120	finally
    //   103	105	120	finally
    //   108	117	120	finally
    //   121	123	120	finally
    //   126	135	120	finally
    //   139	148	120	finally
    //   75	103	125	java/lang/IllegalArgumentException
    //   75	103	138	java/lang/reflect/InvocationTargetException
  }
  
  public ioc.a a(long paramLong)
  {
    Object localObject5 = null;
    ioc.a locala;
    long l1;
    label100:
    Object localObject3;
    do
    {
      try
      {
        Object localObject1;
        if (this.mMediaCodec == null)
        {
          localObject1 = localObject5;
          if (AudioHelper.aCz())
          {
            QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer mMediaCodec is null");
            localObject1 = localObject5;
          }
        }
        for (;;)
        {
          return localObject1;
          if (this.mCodecType == DEC_CODEC) {
            break;
          }
          localObject1 = localObject5;
          if (AudioHelper.aCz())
          {
            QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer mCodecType isn't Decoder");
            localObject1 = localObject5;
          }
        }
        locala = new ioc.a();
      }
      finally {}
      l1 = 0L;
      localObject3 = localObject5;
    } while (l1 >= paramLong);
    long l2 = System.nanoTime();
    int i = this.mMediaCodec.dequeueOutputBuffer(locala.info, 3000L);
    l2 = l1 + (System.nanoTime() - l2);
    switch (i)
    {
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          localObject3 = localObject5;
          if (i < 0) {
            break;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label418;
          }
          locala.buffer = this.outputBuffers[i];
          locala.index = i;
          locala.format = this.mOutputFormat;
          localObject3 = locala;
          break;
          if (NativeCodec.canLog()) {
            QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          locala.index = -3;
          l1 = l2;
          break label100;
          locala.index = -2;
          this.mOutputFormat = this.mMediaCodec.getOutputFormat();
          localObject3 = this.mOutputFormat;
          l1 = l2;
          if (localObject3 == null) {
            break label100;
          }
          try
          {
            i = this.mOutputFormat.getInteger("color-format");
            aqO = i;
            l1 = l2;
            if (!NativeCodec.canLog()) {
              break label100;
            }
            QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer New color format " + i + "[0x" + Integer.toHexString(i) + "]");
            l1 = l2;
          }
          catch (Exception localException)
          {
            l1 = l2;
          }
        }
        if (!AudioHelper.aCz()) {
          break label100;
        }
        QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer Exception,INFO_OUTPUT_FORMAT_CHANGED");
        l1 = l2;
        break label100;
        locala.index = -1;
        Object localObject4 = locala;
        break;
        label418:
        locala.index = i;
        try
        {
          locala.buffer = ((ByteBuffer)l.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
          locala.format = ((MediaFormat)m.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
          localObject4 = locala;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
            locala.success = false;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
            locala.success = false;
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          for (;;)
          {
            localInvocationTargetException.printStackTrace();
            locala.success = false;
          }
        }
      }
    }
  }
  
  boolean a(MediaCodec paramMediaCodec, iod paramiod)
  {
    if ((paramiod != null) && (DeviceCheck.isSupportAsyncAPI()))
    {
      DexClassLoader localDexClassLoader = jjj.a();
      Object localObject = jjj.a(localDexClassLoader, "com.tencent.av.mediacodec.MediaCodecWrapper");
      if (localObject != null) {
        try
        {
          Object[] arrayOfObject = new Object[1];
          boolean bool = jjj.a(localDexClassLoader, localObject, "setCallback", new Class[] { MediaCodec.class, iod.class }, new Object[] { paramMediaCodec, paramiod }, arrayOfObject);
          return bool;
        }
        catch (Exception paramMediaCodec)
        {
          if (AudioHelper.aCz()) {
            QLog.w(this.TAG, 1, "setMediaCodecCallback, Exception", paramMediaCodec);
          }
        }
      }
    }
    return false;
  }
  
  /* Error */
  public boolean a(MediaFormat paramMediaFormat, int paramInt, iod paramiod)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: aload_1
    //   5: putfield 599	ioc:mFormat	Landroid/media/MediaFormat;
    //   8: iload_2
    //   9: getstatic 81	ioc:DEC_CODEC	I
    //   12: if_icmpne +88 -> 100
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 599	ioc:mFormat	Landroid/media/MediaFormat;
    //   20: ldc_w 601
    //   23: invokevirtual 605	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 609	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   29: putfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   32: aload_0
    //   33: iload_2
    //   34: putfield 83	ioc:mCodecType	I
    //   37: aload_0
    //   38: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   41: ifnull +39 -> 80
    //   44: iload_2
    //   45: getstatic 49	ioc:ENC_CODEC	I
    //   48: if_icmpne +86 -> 134
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_0
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   59: aload_3
    //   60: invokevirtual 611	ioc:a	(Landroid/media/MediaCodec;Liod;)Z
    //   63: putfield 613	ioc:Tw	Z
    //   66: aload_0
    //   67: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   70: aload_0
    //   71: getfield 599	ioc:mFormat	Landroid/media/MediaFormat;
    //   74: aconst_null
    //   75: aconst_null
    //   76: iload_2
    //   77: invokevirtual 617	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   80: aload_0
    //   81: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   84: ifnull +6 -> 90
    //   87: iconst_1
    //   88: istore 4
    //   90: iload 4
    //   92: ireturn
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 618	java/lang/Exception:printStackTrace	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_0
    //   101: aload_0
    //   102: getfield 599	ioc:mFormat	Landroid/media/MediaFormat;
    //   105: ldc_w 601
    //   108: invokevirtual 605	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: invokestatic 621	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   114: putfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   117: goto -85 -> 32
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 618	java/lang/Exception:printStackTrace	()V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 618	java/lang/Exception:printStackTrace	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: iconst_0
    //   135: istore_2
    //   136: goto -83 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	ioc
    //   0	139	1	paramMediaFormat	MediaFormat
    //   0	139	2	paramInt	int
    //   0	139	3	paramiod	iod
    //   1	90	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   15	32	93	java/lang/Exception
    //   100	117	120	java/lang/Exception
    //   37	51	127	java/lang/Exception
    //   53	80	127	java/lang/Exception
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString, Surface paramSurface, iod paramiod)
  {
    this.mFormat = paramMediaFormat;
    for (;;)
    {
      try
      {
        this.mMediaCodec = MediaCodec.createByCodecName(paramString);
        paramMediaFormat = getCodecInfo(paramString);
        if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
        {
          this.mCodecType = ENC_CODEC;
          i = 1;
          return false;
        }
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.mMediaCodec != null)
          {
            this.Tw = a(this.mMediaCodec, paramiod);
            this.mMediaCodec.configure(this.mFormat, paramSurface, null, i);
          }
          if (this.mMediaCodec == null) {
            break label98;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
      label98:
      int i = 0;
    }
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString, iod paramiod)
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
          if (this.mMediaCodec != null)
          {
            this.Tw = a(this.mMediaCodec, paramiod);
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
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
  }
  
  public ioc.a b()
  {
    Object localObject4 = null;
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.mMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = localObject4;
          return localObject1;
        }
        ioc.a locala = new ioc.a();
        i = this.mMediaCodec.dequeueOutputBuffer(locala.info, TIMEOUT_US);
        switch (i)
        {
        case -3: 
          if (NativeCodec.canLog()) {
            QLog.w(this.TAG, 1, "dequeueOutputBuffer, outIndex[" + i + "]");
          }
          localObject1 = localObject4;
          if (i < 0) {
            continue;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label464;
          }
          locala.buffer = this.outputBuffers[i];
          locala.index = i;
          locala.format = this.mOutputFormat;
          localObject1 = locala;
          continue;
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          locala.index = -3;
          localObject1 = localObject4;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_BUFFERS_CHANGED");
          localObject1 = localObject4;
          break;
        case -2: 
          locala.index = -2;
        }
      }
      finally {}
      this.mOutputFormat = this.mMediaCodec.getOutputFormat();
      Object localObject3;
      if (this.mOutputFormat != null)
      {
        i = this.mCodecType;
        int j = DEC_CODEC;
        if (i == j)
        {
          try
          {
            i = this.mOutputFormat.getInteger("color-format");
            localObject3 = localObject4;
            if (!NativeCodec.canLog()) {
              continue;
            }
            QLog.w(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, colorformat[" + i + "|0x" + Integer.toHexString(i).toUpperCase() + "]");
            localObject3 = localObject4;
          }
          catch (Exception localException)
          {
            localObject3 = localObject4;
          }
          if (AudioHelper.aCz())
          {
            QLog.e(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, Exception", localException);
            localObject3 = localObject4;
          }
        }
        else
        {
          localObject3 = localObject4;
          if (AudioHelper.aCz())
          {
            QLog.w(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, CodecType[" + this.mCodecType + "]");
            localObject3 = localObject4;
          }
        }
      }
      else
      {
        localObject3 = localObject4;
        if (QLog.isDevelopLevel())
        {
          QLog.e(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, null");
          localObject3 = localObject4;
          continue;
          if (NativeCodec.canLog()) {
            QLog.e(this.TAG, 1, "dequeueOutputBuffer, INFO_TRY_AGAIN_LATER");
          }
          localException.index = -1;
          localObject3 = localException;
          continue;
          label464:
          localException.index = i;
          try
          {
            localException.buffer = ((ByteBuffer)l.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
            localException.format = ((MediaFormat)m.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
            localObject3 = localException;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            for (;;)
            {
              localIllegalAccessException.printStackTrace();
              localException.success = false;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              localIllegalArgumentException.printStackTrace();
              localException.success = false;
            }
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            for (;;)
            {
              localInvocationTargetException.printStackTrace();
              localException.success = false;
            }
          }
        }
      }
    }
  }
  
  public ByteBuffer getInputBuffer(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)k.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (AudioHelper.aCz()) {
        QLog.e(this.TAG, 1, "invoke getInputBuffer exception", localException);
      }
    }
    return null;
  }
  
  public ByteBuffer getOutputBuffer(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)l.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (AudioHelper.aCz()) {
        QLog.e(this.TAG, 1, "invoke getOutputBuffer exception", localException);
      }
    }
    return null;
  }
  
  public MediaFormat getOutputFormat(int paramInt)
  {
    try
    {
      MediaFormat localMediaFormat = (MediaFormat)m.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      if (AudioHelper.aCz()) {
        QLog.e(this.TAG, 1, "invoke getOutputFormat exception", localException);
      }
    }
    return null;
  }
  
  /* Error */
  public void queueInputBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   20: iload_1
    //   21: iconst_0
    //   22: iload_2
    //   23: lload_3
    //   24: iload 5
    //   26: invokevirtual 662	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   29: goto -16 -> 13
    //   32: astore 6
    //   34: invokestatic 214	com/tencent/mobileqq/utils/AudioHelper:aCz	()Z
    //   37: ifeq -24 -> 13
    //   40: aload_0
    //   41: getfield 98	ioc:TAG	Ljava/lang/String;
    //   44: iconst_1
    //   45: new 85	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 664
    //   55: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_1
    //   59: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 666
    //   65: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc_w 668
    //   75: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: lload_3
    //   79: invokevirtual 671	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc_w 673
    //   85: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload 5
    //   90: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: ldc_w 337
    //   96: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aload 6
    //   104: invokestatic 340	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: goto -94 -> 13
    //   110: astore 6
    //   112: aload_0
    //   113: monitorexit
    //   114: aload 6
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ioc
    //   0	117	1	paramInt1	int
    //   0	117	2	paramInt2	int
    //   0	117	3	paramLong	long
    //   0	117	5	paramInt3	int
    //   6	3	6	localMediaCodec	MediaCodec
    //   32	71	6	localException	Exception
    //   110	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	32	java/lang/Exception
    //   2	8	110	finally
    //   16	29	110	finally
    //   34	107	110	finally
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
  
  /* Error */
  public void releaseOutputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 483	ioc:mMediaCodec	Landroid/media/MediaCodec;
    //   18: iload_1
    //   19: iconst_0
    //   20: invokevirtual 680	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	ioc
    //   0	31	1	paramInt	int
    //   6	2	2	localMediaCodec	MediaCodec
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public void setParameters(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      for (;;)
      {
        return;
        if ((this.mMediaCodec != null) && (n != null)) {
          try
          {
            n.invoke(this.mMediaCodec, new Object[] { paramBundle });
            return;
          }
          catch (IllegalArgumentException paramBundle)
          {
            if (QLog.isDevelopLevel())
            {
              QLog.w(this.TAG, 1, "setParameters, IllegalArgumentException", paramBundle);
              return;
            }
          }
          catch (IllegalAccessException paramBundle)
          {
            if (QLog.isDevelopLevel())
            {
              QLog.w(this.TAG, 1, "setParameters, IllegalAccessException", paramBundle);
              return;
            }
          }
          catch (InvocationTargetException paramBundle) {}
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.w(this.TAG, 1, "setParameters, InvocationTargetException", paramBundle);
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
    catch (Exception localException) {}
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
  
  public static class b
  {
    public boolean Tx;
    public int amp = 8;
    public int aqP = 1280;
    public int aqQ = 720;
    
    public b() {}
    
    public b(int paramInt, boolean paramBoolean)
    {
      this.amp = paramInt;
      this.Tx = paramBoolean;
    }
  }
  
  public static class c
  {
    public ByteBuffer buffer;
    public int index;
    public boolean processing;
    
    public c(ByteBuffer paramByteBuffer, int paramInt)
    {
      this.buffer = paramByteBuffer;
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioc
 * JD-Core Version:    0.7.0.1
 */