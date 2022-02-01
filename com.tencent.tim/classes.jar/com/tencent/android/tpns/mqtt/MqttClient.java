package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence;
import com.tencent.android.tpns.mqtt.util.Debug;
import java.util.concurrent.ScheduledExecutorService;

public class MqttClient
  implements IMqttClient
{
  protected MqttAsyncClient aClient = null;
  protected long timeToWait = -1L;
  
  public MqttClient(String paramString1, String paramString2)
    throws MqttException
  {
    this(paramString1, paramString2, new MqttDefaultFilePersistence());
  }
  
  public MqttClient(String paramString1, String paramString2, MqttClientPersistence paramMqttClientPersistence)
    throws MqttException
  {
    this.aClient = new MqttAsyncClient(paramString1, paramString2, paramMqttClientPersistence);
  }
  
  public MqttClient(String paramString1, String paramString2, MqttClientPersistence paramMqttClientPersistence, ScheduledExecutorService paramScheduledExecutorService)
    throws MqttException
  {
    this.aClient = new MqttAsyncClient(paramString1, paramString2, paramMqttClientPersistence, new ScheduledExecutorPingSender(paramScheduledExecutorService), paramScheduledExecutorService);
  }
  
  public static String generateClientId()
  {
    return MqttAsyncClient.generateClientId();
  }
  
  public void close()
    throws MqttException
  {
    this.aClient.close(false);
  }
  
  public void close(boolean paramBoolean)
    throws MqttException
  {
    this.aClient.close(paramBoolean);
  }
  
  public void connect()
    throws MqttSecurityException, MqttException
  {
    connect(new MqttConnectOptions());
  }
  
  public void connect(MqttConnectOptions paramMqttConnectOptions)
    throws MqttSecurityException, MqttException
  {
    this.aClient.connect(paramMqttConnectOptions, null, null).waitForCompletion(getTimeToWait());
  }
  
  public IMqttToken connectWithResult(MqttConnectOptions paramMqttConnectOptions)
    throws MqttSecurityException, MqttException
  {
    paramMqttConnectOptions = this.aClient.connect(paramMqttConnectOptions, null, null);
    paramMqttConnectOptions.waitForCompletion(getTimeToWait());
    return paramMqttConnectOptions;
  }
  
  public void disconnect()
    throws MqttException
  {
    this.aClient.disconnect().waitForCompletion();
  }
  
  public void disconnect(long paramLong)
    throws MqttException
  {
    this.aClient.disconnect(paramLong, null, null).waitForCompletion();
  }
  
  public void disconnectForcibly()
    throws MqttException
  {
    this.aClient.disconnectForcibly();
  }
  
  public void disconnectForcibly(long paramLong)
    throws MqttException
  {
    this.aClient.disconnectForcibly(paramLong);
  }
  
  public void disconnectForcibly(long paramLong1, long paramLong2)
    throws MqttException
  {
    this.aClient.disconnectForcibly(paramLong1, paramLong2);
  }
  
  public void disconnectForcibly(long paramLong1, long paramLong2, boolean paramBoolean)
    throws MqttException
  {
    this.aClient.disconnectForcibly(paramLong1, paramLong2, paramBoolean);
  }
  
  public String getClientId()
  {
    return this.aClient.getClientId();
  }
  
  public String getCurrentServerURI()
  {
    return this.aClient.getCurrentServerURI();
  }
  
  public Debug getDebug()
  {
    return this.aClient.getDebug();
  }
  
  public IMqttDeliveryToken[] getPendingDeliveryTokens()
  {
    return this.aClient.getPendingDeliveryTokens();
  }
  
  public String getServerURI()
  {
    return this.aClient.getServerURI();
  }
  
  public long getTimeToWait()
  {
    return this.timeToWait;
  }
  
  public MqttTopic getTopic(String paramString)
  {
    return this.aClient.getTopic(paramString);
  }
  
  public boolean isConnected()
  {
    return this.aClient.isConnected();
  }
  
  public void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException
  {
    this.aClient.messageArrivedComplete(paramInt1, paramInt2);
  }
  
  public void publish(String paramString, MqttMessage paramMqttMessage)
    throws MqttException, MqttPersistenceException
  {
    this.aClient.publish(paramString, paramMqttMessage, null, null).waitForCompletion(getTimeToWait());
  }
  
  public void publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws MqttException, MqttPersistenceException
  {
    paramArrayOfByte = new MqttMessage(paramArrayOfByte);
    paramArrayOfByte.setQos(paramInt);
    paramArrayOfByte.setRetained(paramBoolean);
    publish(paramString, paramArrayOfByte);
  }
  
  public void reconnect()
    throws MqttException
  {
    this.aClient.reconnect();
  }
  
  public void setCallback(MqttCallback paramMqttCallback)
  {
    this.aClient.setCallback(paramMqttCallback);
  }
  
  public void setManualAcks(boolean paramBoolean)
  {
    this.aClient.setManualAcks(paramBoolean);
  }
  
  public void setTimeToWait(long paramLong)
    throws IllegalArgumentException
  {
    if (paramLong < -1L) {
      throw new IllegalArgumentException();
    }
    this.timeToWait = paramLong;
  }
  
  public void subscribe(String paramString)
    throws MqttException
  {
    subscribe(new String[] { paramString }, new int[] { 1 });
  }
  
  public void subscribe(String paramString, int paramInt)
    throws MqttException
  {
    subscribe(new String[] { paramString }, new int[] { paramInt });
  }
  
  public void subscribe(String paramString, int paramInt, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException
  {
    subscribe(new String[] { paramString }, new int[] { paramInt }, new IMqttMessageListener[] { paramIMqttMessageListener });
  }
  
  public void subscribe(String paramString, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException
  {
    subscribe(new String[] { paramString }, new int[] { 1 }, new IMqttMessageListener[] { paramIMqttMessageListener });
  }
  
  public void subscribe(String[] paramArrayOfString)
    throws MqttException
  {
    int[] arrayOfInt = new int[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 1;
      i += 1;
    }
    subscribe(paramArrayOfString, arrayOfInt);
  }
  
  public void subscribe(String[] paramArrayOfString, int[] paramArrayOfInt)
    throws MqttException
  {
    paramArrayOfString = this.aClient.subscribe(paramArrayOfString, paramArrayOfInt, null, null);
    paramArrayOfString.waitForCompletion(getTimeToWait());
    paramArrayOfString = paramArrayOfString.getGrantedQos();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramArrayOfInt[i] = paramArrayOfString[i];
      i += 1;
    }
    if ((paramArrayOfString.length == 1) && (paramArrayOfInt[0] == 128)) {
      throw new MqttException(128);
    }
  }
  
  public void subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException
  {
    subscribe(paramArrayOfString, paramArrayOfInt);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      this.aClient.comms.setMessageListener(paramArrayOfString[i], paramArrayOfIMqttMessageListener[i]);
      i += 1;
    }
  }
  
  public void subscribe(String[] paramArrayOfString, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException
  {
    int[] arrayOfInt = new int[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 1;
      i += 1;
    }
    subscribe(paramArrayOfString, arrayOfInt, paramArrayOfIMqttMessageListener);
  }
  
  public IMqttToken subscribeWithResponse(String paramString)
    throws MqttException
  {
    return subscribeWithResponse(new String[] { paramString }, new int[] { 1 });
  }
  
  public IMqttToken subscribeWithResponse(String paramString, int paramInt)
    throws MqttException
  {
    return subscribeWithResponse(new String[] { paramString }, new int[] { paramInt });
  }
  
  public IMqttToken subscribeWithResponse(String paramString, int paramInt, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException
  {
    return subscribeWithResponse(new String[] { paramString }, new int[] { paramInt }, new IMqttMessageListener[] { paramIMqttMessageListener });
  }
  
  public IMqttToken subscribeWithResponse(String paramString, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException
  {
    return subscribeWithResponse(new String[] { paramString }, new int[] { 1 }, new IMqttMessageListener[] { paramIMqttMessageListener });
  }
  
  public IMqttToken subscribeWithResponse(String[] paramArrayOfString)
    throws MqttException
  {
    int[] arrayOfInt = new int[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 1;
      i += 1;
    }
    return subscribeWithResponse(paramArrayOfString, arrayOfInt);
  }
  
  public IMqttToken subscribeWithResponse(String[] paramArrayOfString, int[] paramArrayOfInt)
    throws MqttException
  {
    paramArrayOfString = this.aClient.subscribe(paramArrayOfString, paramArrayOfInt, null, null);
    paramArrayOfString.waitForCompletion(getTimeToWait());
    return paramArrayOfString;
  }
  
  public IMqttToken subscribeWithResponse(String[] paramArrayOfString, int[] paramArrayOfInt, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException
  {
    paramArrayOfInt = subscribeWithResponse(paramArrayOfString, paramArrayOfInt);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      this.aClient.comms.setMessageListener(paramArrayOfString[i], paramArrayOfIMqttMessageListener[i]);
      i += 1;
    }
    return paramArrayOfInt;
  }
  
  public IMqttToken subscribeWithResponse(String[] paramArrayOfString, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException
  {
    int[] arrayOfInt = new int[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 1;
      i += 1;
    }
    return subscribeWithResponse(paramArrayOfString, arrayOfInt, paramArrayOfIMqttMessageListener);
  }
  
  public void unsubscribe(String paramString)
    throws MqttException
  {
    unsubscribe(new String[] { paramString });
  }
  
  public void unsubscribe(String[] paramArrayOfString)
    throws MqttException
  {
    this.aClient.unsubscribe(paramArrayOfString, null, null).waitForCompletion(getTimeToWait());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttClient
 * JD-Core Version:    0.7.0.1
 */