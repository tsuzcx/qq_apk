import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.3;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.1;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.2;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.3;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.4;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.5;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.6;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class adno
{
  private static double jdField_a_of_type_Double = 6378245.0D;
  private static double cl = 3.141592653589793D;
  private static double cm = 0.006693421622965943D;
  private long Vd = 0L;
  private long Ve = 0L;
  private long Vf = 0L;
  private long Vg = 0L;
  private long Vh = 0L;
  private adno.a jdField_a_of_type_Adno$a;
  private adno.c jdField_a_of_type_Adno$c;
  private adno.d jdField_a_of_type_Adno$d;
  private adno.e jdField_a_of_type_Adno$e;
  private adno.g jdField_a_of_type_Adno$g;
  private adno.h jdField_a_of_type_Adno$h;
  private SensorEventListener b;
  private SosoInterface.a c;
  private float[] ca = new float[3];
  private double cn = 0.0D;
  private double co = 0.0D;
  private Sensor j;
  private Sensor k;
  private float mAlpha;
  private String mAppName;
  private float[] mGravity = new float[3];
  private String mLastNetType;
  private float vh;
  private float vi;
  
  public adno(String paramString)
  {
    this.mAppName = paramString;
    this.b = new adno.b();
    this.c = new adnp(this, 3, true, true, 0L, true, true, "ArkAppEventObserverManager");
  }
  
  private void a(SensorEvent paramSensorEvent)
  {
    long l = System.currentTimeMillis();
    ArkAppCenter.a().post(this.mAppName, new ArkAppEventObserverManager.2(this, paramSensorEvent, l));
  }
  
  private static double b(double paramDouble1, double paramDouble2)
  {
    return -100.0D + 2.0D * paramDouble1 + 3.0D * paramDouble2 + 0.2D * paramDouble2 * paramDouble2 + 0.1D * paramDouble1 * paramDouble2 + 0.2D * Math.sqrt(Math.abs(paramDouble1)) + (20.0D * Math.sin(6.0D * paramDouble1 * cl) + 20.0D * Math.sin(2.0D * paramDouble1 * cl)) * 2.0D / 3.0D + (20.0D * Math.sin(cl * paramDouble2) + 40.0D * Math.sin(paramDouble2 / 3.0D * cl)) * 2.0D / 3.0D + (160.0D * Math.sin(paramDouble2 / 12.0D * cl) + 320.0D * Math.sin(cl * paramDouble2 / 30.0D)) * 2.0D / 3.0D;
  }
  
  private void b(SensorEvent paramSensorEvent)
  {
    long l = System.currentTimeMillis();
    ArkAppCenter.a().post(this.mAppName, new ArkAppEventObserverManager.3(this, l, paramSensorEvent));
  }
  
  private static boolean b(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 < 72.004000000000005D) || (paramDouble1 > 137.8347D)) {}
    while ((paramDouble2 < 0.8293D) || (paramDouble2 > 55.827100000000002D)) {
      return true;
    }
    return false;
  }
  
  public static double[] b(double paramDouble1, double paramDouble2)
  {
    if (b(paramDouble1, paramDouble2)) {
      return new double[] { paramDouble1, paramDouble2 };
    }
    double d3 = b(paramDouble1 - 105.0D, paramDouble2 - 35.0D);
    double d1 = c(paramDouble1 - 105.0D, paramDouble2 - 35.0D);
    double d2 = paramDouble2 / 180.0D * cl;
    double d4 = Math.sin(d2);
    double d5 = 1.0D - d4 * (cm * d4);
    d4 = Math.sqrt(d5);
    d3 = d3 * 180.0D / (jdField_a_of_type_Double * (1.0D - cm) / (d5 * d4) * cl);
    d4 = jdField_a_of_type_Double / d4;
    return new double[] { 2.0D * paramDouble1 - (d1 * 180.0D / (Math.cos(d2) * d4 * cl) + paramDouble1), 2.0D * paramDouble2 - (paramDouble2 + d3) };
  }
  
  private static double c(double paramDouble1, double paramDouble2)
  {
    return 300.0D + paramDouble1 + 2.0D * paramDouble2 + 0.1D * paramDouble1 * paramDouble1 + 0.1D * paramDouble1 * paramDouble2 + 0.1D * Math.sqrt(Math.abs(paramDouble1)) + (20.0D * Math.sin(6.0D * paramDouble1 * cl) + 20.0D * Math.sin(2.0D * paramDouble1 * cl)) * 2.0D / 3.0D + (20.0D * Math.sin(cl * paramDouble1) + 40.0D * Math.sin(paramDouble1 / 3.0D * cl)) * 2.0D / 3.0D + (150.0D * Math.sin(paramDouble1 / 12.0D * cl) + 300.0D * Math.sin(paramDouble1 / 30.0D * cl)) * 2.0D / 3.0D;
  }
  
  public void Destruct()
  {
    GC("Motion");
    GC("Orientation");
    GC("Position");
    GC("ConnectionTypeChange");
  }
  
  public void GC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "detachEvent eventName=" + paramString);
    }
    if ("Motion".equals(paramString))
    {
      if (this.j != null)
      {
        ((SensorManager)BaseApplicationImpl.getApplication().getSystemService("sensor")).unregisterListener(this.b, this.j);
        this.j = null;
      }
      if ((this.Vd != 0L) && (this.jdField_a_of_type_Adno$e != null)) {
        this.jdField_a_of_type_Adno$e.iT(this.Vd);
      }
      this.jdField_a_of_type_Adno$e = null;
      this.Vd = 0L;
    }
    do
    {
      return;
      if ("Orientation".equals(paramString))
      {
        if (this.k != null)
        {
          ((SensorManager)BaseApplicationImpl.getApplication().getSystemService("sensor")).unregisterListener(this.b, this.k);
          this.k = null;
        }
        if ((this.Ve != 0L) && (this.jdField_a_of_type_Adno$g != null)) {
          this.jdField_a_of_type_Adno$g.iT(this.Ve);
        }
        this.jdField_a_of_type_Adno$g = null;
        this.Ve = 0L;
        return;
      }
      if ("Position".equals(paramString))
      {
        SosoInterface.c(this.c);
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "detachEvent PositionCallback mPositionCallback=" + this.jdField_a_of_type_Adno$h + ", mPositionCallbackId=" + this.Vf);
        }
        if ((this.Vf != 0L) && (this.jdField_a_of_type_Adno$h != null)) {
          this.jdField_a_of_type_Adno$h.iT(this.Vf);
        }
        this.jdField_a_of_type_Adno$h = null;
        this.Vf = 0L;
        this.cn = 0.0D;
        this.co = 0.0D;
        return;
      }
    } while (!"ConnectionTypeChange".equals(paramString));
    if (this.jdField_a_of_type_Adno$a != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Adno$a);
      this.jdField_a_of_type_Adno$a = null;
    }
    if ((this.Vg != 0L) && (this.jdField_a_of_type_Adno$c != null)) {
      this.jdField_a_of_type_Adno$c.iT(this.Vg);
    }
    this.jdField_a_of_type_Adno$c = null;
    this.Vg = 0L;
    this.mLastNetType = null;
  }
  
  public void a(adno.f paramf, long paramLong)
  {
    if ((paramf instanceof adno.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "attachEvent MotionCallback");
      }
      if ((this.Vd != 0L) && (this.jdField_a_of_type_Adno$e != null)) {
        this.jdField_a_of_type_Adno$e.iT(this.Vd);
      }
      this.jdField_a_of_type_Adno$e = ((adno.e)paramf);
      this.Vd = paramLong;
      if (this.j == null)
      {
        paramf = (SensorManager)BaseApplicationImpl.getApplication().getSystemService("sensor");
        this.j = paramf.getDefaultSensor(1);
        if (this.j == null) {
          break label115;
        }
        paramf.registerListener(this.b, this.j, 1);
      }
    }
    label115:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ArkAppEventObserverManager", 2, "mMotionSensor is NULL");
          }
          this.jdField_a_of_type_Adno$e.a(false, 0.0F, 0.0F, 0.0F);
          return;
          if (!(paramf instanceof adno.g)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ArkAppEventObserverManager", 2, "attachEvent OrientationCallback");
          }
          if ((this.Ve != 0L) && (this.jdField_a_of_type_Adno$g != null)) {
            this.jdField_a_of_type_Adno$g.iT(this.Ve);
          }
          this.jdField_a_of_type_Adno$g = ((adno.g)paramf);
          this.Ve = paramLong;
        } while (this.k != null);
        paramf = (SensorManager)BaseApplicationImpl.getApplication().getSystemService("sensor");
        this.k = paramf.getDefaultSensor(3);
        paramf.registerListener(this.b, this.k, 1);
        return;
        if ((paramf instanceof adno.h))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkAppEventObserverManager", 2, "attachEvent PositionCallback callback=" + paramf + ", cbId=" + paramLong + ", mPositionCallback=" + this.jdField_a_of_type_Adno$h + ", mPositionCallbackId=" + this.Vf);
          }
          if ((this.Vf != 0L) && (this.jdField_a_of_type_Adno$h != null)) {
            this.jdField_a_of_type_Adno$h.iT(this.Vf);
          }
          this.jdField_a_of_type_Adno$h = ((adno.h)paramf);
          this.Vf = paramLong;
          SosoInterface.a(this.c);
          return;
        }
        if (!(paramf instanceof adno.c)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "attachEvent ConnectionCallback");
        }
        if ((this.Vg != 0L) && (this.jdField_a_of_type_Adno$c != null)) {
          this.jdField_a_of_type_Adno$c.iT(this.Vg);
        }
        this.jdField_a_of_type_Adno$c = ((adno.c)paramf);
        this.Vg = paramLong;
      } while (this.jdField_a_of_type_Adno$a != null);
      this.jdField_a_of_type_Adno$a = new adno.a();
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_Adno$a);
      return;
    } while (!(paramf instanceof adno.d));
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "attachEvent GetCurrentPositionCallback");
    }
    if ((this.Vh != 0L) && (this.jdField_a_of_type_Adno$d != null)) {
      this.jdField_a_of_type_Adno$d.iT(this.Vh);
    }
    this.jdField_a_of_type_Adno$d = ((adno.d)paramf);
    this.Vh = paramLong;
    SosoInterface.a(this.c);
  }
  
  public class a
    implements INetInfoHandler
  {
    a() {}
    
    public void onNetMobile2None()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2None mLastNetType=" + adno.b(adno.this));
      }
      ArkAppCenter.a().post(adno.a(adno.this), new ArkAppEventObserverManager.ArkConnectionHandler.6(this));
    }
    
    public void onNetMobile2Wifi(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2Wifi mLastNetType=" + adno.b(adno.this));
      }
      ArkAppCenter.a().post(adno.a(adno.this), new ArkAppEventObserverManager.ArkConnectionHandler.5(this));
    }
    
    public void onNetNone2Mobile(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Mobile mLastNetType=" + adno.b(adno.this));
      }
      ArkAppCenter.a().post(adno.a(adno.this), new ArkAppEventObserverManager.ArkConnectionHandler.4(this));
    }
    
    public void onNetNone2Wifi(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Wifi mLastNetType=" + adno.b(adno.this));
      }
      ArkAppCenter.a().post(adno.a(adno.this), new ArkAppEventObserverManager.ArkConnectionHandler.3(this));
    }
    
    public void onNetWifi2Mobile(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2Mobile mLastNetType=" + adno.b(adno.this));
      }
      ArkAppCenter.a().post(adno.a(adno.this), new ArkAppEventObserverManager.ArkConnectionHandler.2(this));
    }
    
    public void onNetWifi2None()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2None mLastNetType=" + adno.b(adno.this));
      }
      ArkAppCenter.a().post(adno.a(adno.this), new ArkAppEventObserverManager.ArkConnectionHandler.1(this));
    }
  }
  
  class b
    implements SensorEventListener
  {
    b() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (paramSensorEvent.sensor.getType() == 1) {
        adno.a(adno.this, paramSensorEvent);
      }
      while (paramSensorEvent.sensor.getType() != 3) {
        return;
      }
      adno.b(adno.this, paramSensorEvent);
    }
  }
  
  public static abstract interface c
    extends adno.f
  {
    public abstract void az(boolean paramBoolean, String paramString);
  }
  
  public static abstract interface d
    extends adno.f
  {
    public abstract void b(boolean paramBoolean, double paramDouble1, double paramDouble2);
  }
  
  public static abstract interface e
    extends adno.f
  {
    public abstract void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public static abstract interface f
  {
    public abstract void iT(long paramLong);
  }
  
  public static abstract interface g
    extends adno.f
  {
    public abstract void b(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public static abstract interface h
    extends adno.f
  {
    public abstract void b(boolean paramBoolean, double paramDouble1, double paramDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adno
 * JD-Core Version:    0.7.0.1
 */