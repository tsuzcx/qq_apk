import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public class aqlm
{
  private boolean Ih;
  private aqlm.a a;
  public SensorEventListener c;
  private SensorManager c;
  private Context context;
  private float fk;
  private Handler handler = new aqlo(this, Looper.getMainLooper());
  public boolean hasSensor;
  private Sensor m;
  
  public aqlm(Context paramContext, aqlm.a parama)
  {
    this.jdField_c_of_type_AndroidHardwareSensorEventListener = new aqln(this);
    this.a = parama;
    this.context = paramContext;
  }
  
  public void open()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSSensor", 2, "LSSensor open=====");
    }
    this.Ih = false;
    this.jdField_c_of_type_AndroidHardwareSensorManager = ((SensorManager)this.context.getSystemService("sensor"));
    this.m = this.jdField_c_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    if (this.m != null)
    {
      this.hasSensor = true;
      this.fk = this.m.getMaximumRange();
      if (this.fk > 10.0F) {
        this.fk = 10.0F;
      }
      this.jdField_c_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_c_of_type_AndroidHardwareSensorEventListener, this.m, 2);
      return;
    }
    this.hasSensor = false;
    this.a.xP(this.Ih);
  }
  
  public void shutdown()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSSensor", 2, "LSSensor shutdown=====");
    }
    if (this.jdField_c_of_type_AndroidHardwareSensorManager != null)
    {
      this.jdField_c_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_c_of_type_AndroidHardwareSensorEventListener);
      this.jdField_c_of_type_AndroidHardwareSensorManager = null;
    }
    try
    {
      this.a = null;
      this.m = null;
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void xP(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqlm
 * JD-Core Version:    0.7.0.1
 */