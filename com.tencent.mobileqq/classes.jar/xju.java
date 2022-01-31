import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class xju
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public xju(xjt paramxjt, byte paramByte, String paramString)
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
        SensorManager localSensorManager = this.jdField_a_of_type_Xjt.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        xjt.a(this.jdField_a_of_type_Xjt)[0] = arrayOfFloat[1];
        xjt.a(this.jdField_a_of_type_Xjt)[1] = arrayOfFloat[2];
        xjt.a(this.jdField_a_of_type_Xjt)[2] = arrayOfFloat[3];
        xjt.a(this.jdField_a_of_type_Xjt)[3] = arrayOfFloat[0];
      }
    } while ((!xjt.a()) || (!xjt.b()));
    this.jdField_a_of_type_Xjt.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(xjt.a(this.jdField_a_of_type_Xjt)[0]), String.valueOf(xjt.a(this.jdField_a_of_type_Xjt)[1]), String.valueOf(xjt.a(this.jdField_a_of_type_Xjt)[2]), String.valueOf(xjt.a(this.jdField_a_of_type_Xjt)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xju
 * JD-Core Version:    0.7.0.1
 */