package com.tencent.biz.game;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class SensorAPIJavaScript$QQSensorEventListener
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public SensorAPIJavaScript$QQSensorEventListener(SensorAPIJavaScript paramSensorAPIJavaScript, byte paramByte, String paramString)
  {
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (this.jdField_a_of_type_Byte)
    {
    default: 
      return;
    case 0: 
      f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(f1), String.valueOf(f2), String.valueOf(f3) });
      return;
    case 1: 
      f1 = paramSensorEvent.values[0];
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(f1) });
      return;
    }
    float f1 = paramSensorEvent.values[0];
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(f1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.QQSensorEventListener
 * JD-Core Version:    0.7.0.1
 */