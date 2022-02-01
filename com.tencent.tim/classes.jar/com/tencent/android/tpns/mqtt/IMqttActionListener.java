package com.tencent.android.tpns.mqtt;

public abstract interface IMqttActionListener
{
  public abstract void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable);
  
  public abstract void onSuccess(IMqttToken paramIMqttToken);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.IMqttActionListener
 * JD-Core Version:    0.7.0.1
 */