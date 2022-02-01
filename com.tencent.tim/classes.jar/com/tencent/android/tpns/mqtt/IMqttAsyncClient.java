package com.tencent.android.tpns.mqtt;

public abstract interface IMqttAsyncClient
{
  public abstract void close()
    throws MqttException;
  
  public abstract IMqttToken connect()
    throws MqttException, MqttSecurityException;
  
  public abstract IMqttToken connect(MqttConnectOptions paramMqttConnectOptions)
    throws MqttException, MqttSecurityException;
  
  public abstract IMqttToken connect(MqttConnectOptions paramMqttConnectOptions, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttSecurityException;
  
  public abstract IMqttToken connect(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttSecurityException;
  
  public abstract IMqttToken disconnect()
    throws MqttException;
  
  public abstract IMqttToken disconnect(long paramLong)
    throws MqttException;
  
  public abstract IMqttToken disconnect(long paramLong, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract IMqttToken disconnect(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract void disconnectForcibly()
    throws MqttException;
  
  public abstract void disconnectForcibly(long paramLong)
    throws MqttException;
  
  public abstract void disconnectForcibly(long paramLong1, long paramLong2)
    throws MqttException;
  
  public abstract String getClientId();
  
  public abstract IMqttDeliveryToken[] getPendingDeliveryTokens();
  
  public abstract String getServerURI();
  
  public abstract boolean isConnected();
  
  public abstract void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException;
  
  public abstract IMqttDeliveryToken publish(String paramString, MqttMessage paramMqttMessage)
    throws MqttException, MqttPersistenceException;
  
  public abstract IMqttDeliveryToken publish(String paramString, MqttMessage paramMqttMessage, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttPersistenceException;
  
  public abstract IMqttDeliveryToken publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws MqttException, MqttPersistenceException;
  
  public abstract IMqttDeliveryToken publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttPersistenceException;
  
  public abstract void setCallback(MqttCallback paramMqttCallback);
  
  public abstract void setManualAcks(boolean paramBoolean);
  
  public abstract IMqttToken subscribe(String paramString, int paramInt)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String paramString, int paramInt, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String paramString, int paramInt, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String paramString, int paramInt, Object paramObject, IMqttActionListener paramIMqttActionListener, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject, IMqttActionListener paramIMqttActionListener, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken unsubscribe(String paramString)
    throws MqttException;
  
  public abstract IMqttToken unsubscribe(String paramString, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract IMqttToken unsubscribe(String[] paramArrayOfString)
    throws MqttException;
  
  public abstract IMqttToken unsubscribe(String[] paramArrayOfString, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.IMqttAsyncClient
 * JD-Core Version:    0.7.0.1
 */