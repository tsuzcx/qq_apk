package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.ClientState;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MqttOutputStream
  extends OutputStream
{
  private static final String CLASS_NAME = "MqttOutputStream";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "MqttOutputStream");
  private ClientState clientState = null;
  private BufferedOutputStream out;
  
  public MqttOutputStream(ClientState paramClientState, OutputStream paramOutputStream)
  {
    this.clientState = paramClientState;
    this.out = new BufferedOutputStream(paramOutputStream);
  }
  
  public void close()
    throws IOException
  {
    this.out.close();
  }
  
  public void flush()
    throws IOException
  {
    this.out.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.out.write(paramInt);
  }
  
  public void write(MqttWireMessage paramMqttWireMessage)
    throws IOException, MqttException
  {
    byte[] arrayOfByte1 = paramMqttWireMessage.getHeader();
    byte[] arrayOfByte2 = paramMqttWireMessage.getPayload();
    this.out.write(arrayOfByte1, 0, arrayOfByte1.length);
    this.clientState.notifySentBytes(arrayOfByte1.length);
    int i = 0;
    while (i < arrayOfByte2.length)
    {
      int j = Math.min(1024, arrayOfByte2.length - i);
      this.out.write(arrayOfByte2, i, j);
      i += 1024;
      this.clientState.notifySentBytes(j);
    }
    log.fine("MqttOutputStream", "write", "529", new Object[] { paramMqttWireMessage });
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.out.write(paramArrayOfByte);
    this.clientState.notifySentBytes(paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.clientState.notifySentBytes(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttOutputStream
 * JD-Core Version:    0.7.0.1
 */