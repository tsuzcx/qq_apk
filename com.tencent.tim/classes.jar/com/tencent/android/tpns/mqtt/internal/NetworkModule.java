package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface NetworkModule
{
  public abstract InputStream getInputStream()
    throws IOException;
  
  public abstract OutputStream getOutputStream()
    throws IOException;
  
  public abstract String getServerURI();
  
  public abstract void start()
    throws IOException, MqttException;
  
  public abstract void stop()
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.NetworkModule
 * JD-Core Version:    0.7.0.1
 */