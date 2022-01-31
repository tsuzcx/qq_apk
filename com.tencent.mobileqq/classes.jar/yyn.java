import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class yyn
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public yyn(yym paramyym, byte paramByte, String paramString)
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
        SensorManager localSensorManager = this.jdField_a_of_type_Yym.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        yym.a(this.jdField_a_of_type_Yym)[0] = arrayOfFloat[1];
        yym.a(this.jdField_a_of_type_Yym)[1] = arrayOfFloat[2];
        yym.a(this.jdField_a_of_type_Yym)[2] = arrayOfFloat[3];
        yym.a(this.jdField_a_of_type_Yym)[3] = arrayOfFloat[0];
      }
    } while ((!yym.a()) || (!yym.b()));
    this.jdField_a_of_type_Yym.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(yym.a(this.jdField_a_of_type_Yym)[0]), String.valueOf(yym.a(this.jdField_a_of_type_Yym)[1]), String.valueOf(yym.a(this.jdField_a_of_type_Yym)[2]), String.valueOf(yym.a(this.jdField_a_of_type_Yym)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyn
 * JD-Core Version:    0.7.0.1
 */