import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class xax
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public xax(xaw paramxaw, byte paramByte, String paramString)
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
        SensorManager localSensorManager = this.jdField_a_of_type_Xaw.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        xaw.a(this.jdField_a_of_type_Xaw)[0] = arrayOfFloat[1];
        xaw.a(this.jdField_a_of_type_Xaw)[1] = arrayOfFloat[2];
        xaw.a(this.jdField_a_of_type_Xaw)[2] = arrayOfFloat[3];
        xaw.a(this.jdField_a_of_type_Xaw)[3] = arrayOfFloat[0];
      }
    } while ((!xaw.a()) || (!xaw.b()));
    this.jdField_a_of_type_Xaw.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(xaw.a(this.jdField_a_of_type_Xaw)[0]), String.valueOf(xaw.a(this.jdField_a_of_type_Xaw)[1]), String.valueOf(xaw.a(this.jdField_a_of_type_Xaw)[2]), String.valueOf(xaw.a(this.jdField_a_of_type_Xaw)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xax
 * JD-Core Version:    0.7.0.1
 */