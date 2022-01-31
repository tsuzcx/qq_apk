package com.tencent.mobileqq.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import exu;
import exv;

public class QQLSSensor
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  public SensorEventListener a;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new exv(this, Looper.getMainLooper());
  private QQLSSensor.ProximitySensorChangeListener jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor$ProximitySensorChangeListener;
  public boolean a;
  private boolean b;
  
  public QQLSSensor(Context paramContext, QQLSSensor.ProximitySensorChangeListener paramProximitySensorChangeListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = new exu(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor$ProximitySensorChangeListener = paramProximitySensorChangeListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.b = false;
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    if (this.jdField_a_of_type_AndroidHardwareSensor != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidHardwareSensor.getMaximumRange();
      if (this.jdField_a_of_type_Float > 10.0F) {
        this.jdField_a_of_type_Float = 10.0F;
      }
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor, 2);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor$ProximitySensorChangeListener.a(this.b);
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor$ProximitySensorChangeListener = null;
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
    }
    this.jdField_a_of_type_AndroidHardwareSensor = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQLSSensor
 * JD-Core Version:    0.7.0.1
 */