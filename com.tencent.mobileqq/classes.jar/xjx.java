import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class xjx
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public xjx(xjw paramxjw, byte paramByte, String paramString)
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
        SensorManager localSensorManager = this.jdField_a_of_type_Xjw.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        xjw.a(this.jdField_a_of_type_Xjw)[0] = arrayOfFloat[1];
        xjw.a(this.jdField_a_of_type_Xjw)[1] = arrayOfFloat[2];
        xjw.a(this.jdField_a_of_type_Xjw)[2] = arrayOfFloat[3];
        xjw.a(this.jdField_a_of_type_Xjw)[3] = arrayOfFloat[0];
      }
    } while ((!xjw.a()) || (!xjw.b()));
    this.jdField_a_of_type_Xjw.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(xjw.a(this.jdField_a_of_type_Xjw)[0]), String.valueOf(xjw.a(this.jdField_a_of_type_Xjw)[1]), String.valueOf(xjw.a(this.jdField_a_of_type_Xjw)[2]), String.valueOf(xjw.a(this.jdField_a_of_type_Xjw)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xjx
 * JD-Core Version:    0.7.0.1
 */