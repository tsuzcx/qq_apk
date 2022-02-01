package com.tencent.android.tpns.mqtt;

public class MqttPersistenceException
  extends MqttException
{
  public static final short REASON_CODE_PERSISTENCE_IN_USE = 32200;
  private static final long serialVersionUID = 300L;
  
  public MqttPersistenceException()
  {
    super(0);
  }
  
  public MqttPersistenceException(int paramInt)
  {
    super(paramInt);
  }
  
  public MqttPersistenceException(int paramInt, Throwable paramThrowable)
  {
    super(paramInt, paramThrowable);
  }
  
  public MqttPersistenceException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttPersistenceException
 * JD-Core Version:    0.7.0.1
 */