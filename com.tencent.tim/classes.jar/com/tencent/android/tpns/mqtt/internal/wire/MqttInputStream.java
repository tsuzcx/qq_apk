package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.ClientState;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;

public class MqttInputStream
  extends InputStream
{
  private static final String CLASS_NAME = "MqttInputStream";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "MqttInputStream");
  private ByteArrayOutputStream bais;
  private ClientState clientState = null;
  private DataInputStream in;
  private byte[] packet;
  private long packetLen;
  private long remLen;
  
  public MqttInputStream(ClientState paramClientState, InputStream paramInputStream)
  {
    this.clientState = paramClientState;
    this.in = new DataInputStream(paramInputStream);
    this.bais = new ByteArrayOutputStream();
    this.remLen = -1L;
  }
  
  private void readFully()
    throws IOException
  {
    int j = this.bais.size();
    int k = (int)this.packetLen;
    int m = (int)(this.remLen - this.packetLen);
    if (m < 0) {
      throw new IndexOutOfBoundsException();
    }
    int n;
    for (int i = 0; i < m; i = n + i) {
      try
      {
        n = this.in.read(this.packet, j + k + i, m - i);
        this.clientState.notifyReceivedBytes(n);
        if (n < 0) {
          throw new EOFException();
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        this.packetLen += i;
        throw localSocketTimeoutException;
      }
    }
  }
  
  public int available()
    throws IOException
  {
    return this.in.available();
  }
  
  public void close()
    throws IOException
  {
    this.in.close();
  }
  
  public int read()
    throws IOException
  {
    return this.in.read();
  }
  
  public MqttWireMessage readMqttWireMessage()
    throws IOException, MqttException
  {
    TBaseLogger.d("MqttInputStream", "action - readMqttWireMessage");
    Object localObject2 = null;
    Object localObject4 = null;
    Object localObject1 = localObject4;
    try
    {
      if (this.remLen < 0L)
      {
        localObject1 = localObject4;
        this.bais.reset();
        localObject1 = localObject4;
        int i = this.in.readByte();
        localObject1 = localObject4;
        this.clientState.notifyReceivedBytes(1);
        int j = (byte)(i >>> 4 & 0xF);
        if ((j < 1) || (j > 14))
        {
          localObject1 = localObject4;
          throw ExceptionHelper.createMqttException(32108);
        }
        localObject1 = localObject4;
        this.remLen = MqttWireMessage.readMBI(this.in).getValue();
        localObject1 = localObject4;
        this.bais.write(i);
        localObject1 = localObject4;
        this.bais.write(MqttWireMessage.encodeMBI(this.remLen));
        localObject1 = localObject4;
        this.packet = new byte[(int)(this.bais.size() + this.remLen)];
        localObject1 = localObject4;
        this.packetLen = 0L;
      }
      localObject1 = localObject4;
      if (this.remLen >= 0L)
      {
        localObject1 = localObject4;
        readFully();
        localObject1 = localObject4;
        this.remLen = -1L;
        localObject1 = localObject4;
        localObject2 = this.bais.toByteArray();
        localObject1 = localObject4;
        System.arraycopy(localObject2, 0, this.packet, 0, localObject2.length);
        localObject1 = localObject4;
        localObject2 = MqttWireMessage.createWireMessage(this.packet);
        localObject1 = localObject2;
        log.fine("MqttInputStream", "readMqttWireMessage", "501", new Object[] { localObject2 });
        return localObject2;
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      Object localObject3 = localObject1;
      return localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttInputStream
 * JD-Core Version:    0.7.0.1
 */