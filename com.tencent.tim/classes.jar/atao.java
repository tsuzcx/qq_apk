import android.hardware.SensorEventListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.BeautyResource;
import com.tencent.mobileqq.shortvideo.resource.GestureGameResource;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.LowLightResource;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.DpcSwitcher;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.Reporter;
import java.util.HashMap;

public class atao
{
  public static boolean dgW;
  private static volatile boolean isInited;
  
  /* Error */
  public static void init()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 50	atao:isInited	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 56	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   18: ldc 58
    //   20: invokestatic 64	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: new 15	atao$d
    //   26: dup
    //   27: invokespecial 67	atao$d:<init>	()V
    //   30: new 36	atao$k
    //   33: dup
    //   34: invokespecial 68	atao$k:<init>	()V
    //   37: new 24	atao$g
    //   40: dup
    //   41: invokespecial 69	atao$g:<init>	()V
    //   44: new 33	atao$j
    //   47: dup
    //   48: invokespecial 70	atao$j:<init>	()V
    //   51: invokevirtual 73	com/tencent/sveffects/SdkContext:init	(Ljava/lang/String;Landroid/app/Application;Lcom/tencent/sveffects/DpcSwitcher;Lcom/tencent/mobileqq/shortvideo/resource/Resources;Lcom/tencent/sveffects/Logger;Lcom/tencent/sveffects/Reporter;)V
    //   54: iconst_1
    //   55: putstatic 50	atao:isInited	Z
    //   58: goto -47 -> 11
    //   61: astore_1
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   61	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	61	finally
    //   15	58	61	finally
  }
  
  public static class a
    implements AVFilterResource
  {
    public String getFilterResPath()
    {
      if (atao.dgW) {
        return aywt.bej;
      }
      return alwh.bej;
    }
  }
  
  public static class b
    implements ArtFilterResource
  {
    public String getCommonPrefix()
    {
      return aasr.bek;
    }
    
    public String getFilterResPath()
    {
      if (atao.dgW) {
        return aywt.bej;
      }
      return alwh.bej;
    }
    
    public String getModelPath()
    {
      return "";
    }
    
    public String getReshapePath()
    {
      return "";
    }
    
    public String getSoPathDir()
    {
      return ankq.aN(BaseApplicationImpl.getContext());
    }
  }
  
  public static class c
    implements BeautyResource
  {
    public String getBeautyFilePath()
    {
      return alwh.bYW;
    }
  }
  
  public static class d
    implements DpcSwitcher
  {
    public float getBeatyRate()
    {
      return anki.getBeatyRate();
    }
    
    public boolean isBeautySwitchOpen()
    {
      return anki.isBeautySwitchOpen();
    }
    
    public boolean isDeNoiseSwitchOpen()
    {
      return anki.isDeNoiseSwitchOpen();
    }
    
    public boolean isPortraitSwitchOpen()
    {
      return ankq.isSupportPortarit();
    }
    
    public boolean isSvafSwitchOpen()
    {
      return anki.isSvafSwitchOpen();
    }
  }
  
  public static class e
    implements GestureGameResource
  {
    public String getGameModelPath()
    {
      return anhx.getGameModelPath();
    }
    
    public boolean isGestureGameEnable()
    {
      return anhs.a().isGestureEnable();
    }
  }
  
  public static class f
    implements GestureResource
  {
    public static boolean cFf;
    public static String cdv = "5";
    public static String cdw = "200";
    public static String cdx = "20";
    
    public String getGestureGapFrame()
    {
      return cdv;
    }
    
    public String getGestureGapTime()
    {
      return cdw;
    }
    
    public boolean getGestureShouldUpload()
    {
      return cFf;
    }
    
    public String getGestureThreadColdTime()
    {
      return cdx;
    }
    
    public String getModelPath()
    {
      return anhx.getModelPath();
    }
    
    public String getSoPathDir()
    {
      return anhx.getSoDir();
    }
    
    public boolean isGestureEnable()
    {
      return anhs.a().isGestureEnable();
    }
  }
  
  public static class g
    implements Logger
  {
    public void d(String paramString1, String paramString2)
    {
      QLog.d(paramString1, 2, paramString2);
    }
    
    public void e(String paramString1, String paramString2)
    {
      QLog.e(paramString1, 2, paramString2);
    }
    
    public void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      QLog.e(paramString1, 2, paramString2, paramThrowable);
    }
    
    public void e(String paramString, Throwable paramThrowable)
    {
      QLog.e(paramString, 2, paramThrowable, new Object[0]);
    }
    
    public void i(String paramString1, String paramString2)
    {
      QLog.i(paramString1, 2, paramString2);
    }
    
    public boolean isEnable()
    {
      return QLog.isColorLevel();
    }
    
    public void w(String paramString1, String paramString2)
    {
      QLog.w(paramString1, 2, paramString2);
    }
  }
  
  public static class h
    implements LowLightResource
  {
    public String getLowLightDir()
    {
      return acbn.SDCARD_PATH;
    }
  }
  
  public static class i
    implements PtuFilterResource
  {
    public boolean checkPendantVersionOK()
    {
      return ankq.awy();
    }
    
    public String getPortraitPathDir()
    {
      return getSoPathDir();
    }
    
    public String getSoPathDir()
    {
      return ankq.aL(BaseApplicationImpl.getContext());
    }
  }
  
  public static class j
    implements Reporter
  {
    public void reportToBeacon(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, paramString, paramBoolean, paramLong1, paramLong2, paramHashMap, "");
    }
    
    public void reportToCompass(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
    {
      anot.a(null, paramString1, paramString2, "", paramString3, paramString4, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
    }
  }
  
  public static class k
    implements Resources
  {
    public SpecialAVFilterResource getAVFilterResource()
    {
      return new atao.m();
    }
    
    public ArtFilterResource getArtFilterResource()
    {
      return new atao.b();
    }
    
    public AVFilterResource getAvFilterResource()
    {
      return new atao.a();
    }
    
    public BeautyResource getBeautyResource()
    {
      return new atao.c();
    }
    
    public GestureResource getGestureResource()
    {
      return new atao.f();
    }
    
    public LowLightResource getLowLightResource()
    {
      return new atao.h();
    }
    
    public PtuFilterResource getPtuFilterResource()
    {
      return new atao.i();
    }
    
    public SensorResource getSensorResource()
    {
      return new atao.l();
    }
    
    public GestureGameResource geteGestureGameResource()
    {
      return new atao.e();
    }
  }
  
  public static class l
    implements SensorResource
  {
    public boolean checkSensorEnable()
    {
      return ikg.a().tC();
    }
    
    public boolean getCameraIsFront()
    {
      return ikg.a().tD();
    }
    
    public int getRotation()
    {
      return 0;
    }
    
    public void registerListener(SensorEventListener paramSensorEventListener)
    {
      ikg.a().registerListener(paramSensorEventListener);
    }
    
    public void setCameraChangedListener(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
    {
      ikg.a().a(paramCameraChangedCallBack);
    }
    
    public void unregisterListener(SensorEventListener paramSensorEventListener)
    {
      ikg.a().unregisterListener(paramSensorEventListener);
    }
  }
  
  public static class m
    implements SpecialAVFilterResource
  {
    public static final String cGy = acbn.SDCARD_ROOT + "/tencent/qq/music/";
    
    public String getMusicResPath()
    {
      return cGy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atao
 * JD-Core Version:    0.7.0.1
 */