import android.content.Context;
import android.opengl.Matrix;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.c;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;

public class addz
{
  public static boolean bMk = true;
  public static final float[] bQ = new float[16];
  private addz.a jdField_a_of_type_Addz$a;
  private adus jdField_a_of_type_Adus;
  private aduv b = new adea(this);
  private float[] bA = new float[16];
  private boolean bMj;
  private float[] bR;
  private float[] bS = new float[4];
  private Context mContext;
  private ReentrantLock mLock = new ReentrantLock();
  
  static
  {
    Matrix.setIdentityM(bQ, 0);
  }
  
  public static boolean adJ()
  {
    boolean bool2 = false;
    String str = DeviceProfileManager.b().jf(DeviceProfileManager.DpcNames.ARCfg.name());
    boolean bool1;
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "";
      int i = DeviceProfileManager.a(str, arrayOfString, new DeviceProfileManager.c());
      if (i >= 1) {
        if (Integer.valueOf(arrayOfString[0]).intValue() == 1)
        {
          bool1 = true;
          QLog.i("AREngine_SensorTrackManager", 1, "arCfg = " + str + ", size = " + i + ", params[0] = " + arrayOfString[0] + ", isUseGameRotationVector = " + bool1);
        }
      }
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!adK()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private static boolean adK()
  {
    return (Build.MODEL.equalsIgnoreCase("HRY-AL00T")) || (Build.MODEL.equalsIgnoreCase("SM-G955F")) || (Build.MODEL.equalsIgnoreCase("AQM-AL00")) || (Build.MODEL.equalsIgnoreCase("MI CC9 Pro"));
  }
  
  public void FZ(boolean paramBoolean)
  {
    if (this.bMj != paramBoolean)
    {
      this.bMj = paramBoolean;
      QLog.d("SensorTrackManager", 2, "enableSensor enabled: " + paramBoolean);
    }
  }
  
  public void a(Context paramContext, addz.a parama)
  {
    long l = System.currentTimeMillis();
    this.mContext = paramContext;
    this.jdField_a_of_type_Addz$a = parama;
    cQM();
    bMk = this.jdField_a_of_type_Adus.afD();
    adix.a().iL(System.currentTimeMillis() - l);
  }
  
  public void cQM()
  {
    if (this.jdField_a_of_type_Adus == null) {
      if (!adJ()) {
        break label57;
      }
    }
    label57:
    for (this.jdField_a_of_type_Adus = new adus(this.mContext, 5);; this.jdField_a_of_type_Adus = new adus(this.mContext, 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorTrackManager", 2, "startupSensor");
      }
      this.jdField_a_of_type_Adus.a(this.b, 1);
      return;
    }
  }
  
  public void start()
  {
    FZ(true);
  }
  
  public void stop()
  {
    FZ(false);
  }
  
  public void stopSensor()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SensorTrackManager", 2, "stopSensor");
    }
    if (this.jdField_a_of_type_Adus != null)
    {
      this.jdField_a_of_type_Adus.stop();
      this.jdField_a_of_type_Adus = null;
    }
  }
  
  public void uninit()
  {
    stopSensor();
    this.mContext = null;
    this.bMj = false;
    this.bR = null;
  }
  
  public static abstract interface a
  {
    public abstract void b(float[] paramArrayOfFloat);
    
    public abstract void g(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addz
 * JD-Core Version:    0.7.0.1
 */