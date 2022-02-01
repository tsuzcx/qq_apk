import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class anig
  extends ioc
{
  public static String TAG = "ShortVideoCodec";
  public static int dGN = -1;
  
  public static int az(Context paramContext)
  {
    if (dGN >= 0) {
      return dGN;
    }
    dGN = 0;
    if (paramContext == null) {
      return dGN;
    }
    VcControllerImpl.loadLibrary(paramContext);
    if (Build.VERSION.SDK_INT < 16) {
      return dGN;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      aoG();
      if (!Tu)
      {
        dGN = 0;
        return dGN;
      }
    }
    if (DeviceCheck.isAVCDecWhitelistDevices())
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "checkSupportMediaCodecFeature device is in white list.");
      }
      if (DeviceCheck.isAVCDecSupportColorformats()) {
        dGN = 1;
      }
      if (!isAVCEncWhitelistDevices()) {
        break label146;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "checkSupportMediaCodecFeature device is in white list.");
      }
      if (DeviceCheck.isAVCEncSupportColorformats()) {
        dGN += 2;
      }
    }
    for (;;)
    {
      return dGN;
      if (!DeviceCheck.isAVCDecSupportColorformats()) {
        break;
      }
      dGN = 1;
      break;
      label146:
      if (DeviceCheck.isAVCEncSupportColorformats()) {
        dGN += 2;
      }
    }
  }
  
  public static boolean isAVCEncWhitelistDevices()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return false;
      if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI 3")) && (Build.PRODUCT.equalsIgnoreCase("pisces"))) {
        return DeviceCheck.isAVCEncSupportColorformats();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
        return DeviceCheck.isAVCEncSupportColorformats();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
        return DeviceCheck.isAVCEncSupportColorformats();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("MX4"))) {
        return DeviceCheck.isAVCEncSupportColorformats();
      }
    } while ((!Build.MANUFACTURER.equalsIgnoreCase("Meizu")) || (!Build.MODEL.equalsIgnoreCase("MX4 Pro")));
    return DeviceCheck.isAVCEncSupportColorformats();
  }
  
  @SuppressLint({"NewApi"})
  public static List<MediaCodecInfo> j(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder()) {}
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
  
  public ioc.a b()
  {
    label512:
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localObject1 = this.mMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        localObject1 = new ioc.a(this);
        i = this.mMediaCodec.dequeueOutputBuffer(((ioc.a)localObject1).info, TIMEOUT_US);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            break label512;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dequeueOutputBuffer ok,index = " + i + ",BufferInfo[flags = " + ((ioc.a)localObject1).info.flags + ",offset=" + ((ioc.a)localObject1).info.offset + ",size= " + ((ioc.a)localObject1).info.size + ",TimeUs=" + ((ioc.a)localObject1).info.presentationTimeUs + "]");
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label406;
          }
          ((ioc.a)localObject1).buffer = this.outputBuffers[i];
          ((ioc.a)localObject1).index = i;
          ((ioc.a)localObject1).format = this.mOutputFormat;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          ((ioc.a)localObject1).index = -3;
        }
      }
      finally {}
      ((ioc.a)localObject1).index = -2;
      this.mOutputFormat = this.mMediaCodec.getOutputFormat();
      if (this.mOutputFormat != null)
      {
        ((ioc.a)localObject1).format = this.mOutputFormat;
        if (this.mCodecType == DEC_CODEC)
        {
          if (this.mOutputFormat.containsKey("color-format"))
          {
            i = this.mOutputFormat.getInteger("color-format");
            if (QLog.isColorLevel()) {
              QLog.e(TAG, 2, "New color format " + i + "[0x" + Integer.toHexString(i) + "]");
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e(TAG, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
          break label512;
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "dequeueOutputBuffer timed out!");
          }
          localObject2.index = -1;
          continue;
          label406:
          localObject2.index = i;
          try
          {
            localObject2.buffer = ((ByteBuffer)l.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
            localObject2.format = ((MediaFormat)m.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
            localObject2.success = false;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
            localObject2.success = false;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            localInvocationTargetException.printStackTrace();
            localObject2.success = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anig
 * JD-Core Version:    0.7.0.1
 */