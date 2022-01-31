import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class zdc
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public zdc(zdb paramzdb, byte paramByte, String paramString)
  {
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (this.jdField_a_of_type_Byte)
    {
    }
    do
    {
      return;
      float[] arrayOfFloat = new float[4];
      if (Build.VERSION.SDK_INT >= 9)
      {
        SensorManager localSensorManager = this.jdField_a_of_type_Zdb.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        zdb.a(this.jdField_a_of_type_Zdb)[0] = arrayOfFloat[1];
        zdb.a(this.jdField_a_of_type_Zdb)[1] = arrayOfFloat[2];
        zdb.a(this.jdField_a_of_type_Zdb)[2] = arrayOfFloat[3];
        zdb.a(this.jdField_a_of_type_Zdb)[3] = arrayOfFloat[0];
      }
    } while ((!zdb.a()) || (!zdb.b()));
    this.jdField_a_of_type_Zdb.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(zdb.a(this.jdField_a_of_type_Zdb)[0]), String.valueOf(zdb.a(this.jdField_a_of_type_Zdb)[1]), String.valueOf(zdb.a(this.jdField_a_of_type_Zdb)[2]), String.valueOf(zdb.a(this.jdField_a_of_type_Zdb)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zdc
 * JD-Core Version:    0.7.0.1
 */