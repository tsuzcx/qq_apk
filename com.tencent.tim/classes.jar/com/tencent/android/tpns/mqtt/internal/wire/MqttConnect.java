package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MqttConnect
  extends MqttWireMessage
{
  public static final String KEY = "Con";
  private int MqttVersion;
  private boolean cleanSession;
  private String clientId;
  private int keepAliveInterval;
  private char[] password;
  private String userName;
  private String willDestination;
  private MqttMessage willMessage;
  
  public MqttConnect(byte paramByte, byte[] paramArrayOfByte)
    throws IOException, MqttException
  {
    super((byte)1);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    decodeUTF8(paramArrayOfByte);
    paramArrayOfByte.readByte();
    paramArrayOfByte.readByte();
    this.keepAliveInterval = paramArrayOfByte.readUnsignedShort();
    this.clientId = decodeUTF8(paramArrayOfByte);
    paramArrayOfByte.close();
  }
  
  public MqttConnect(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, String paramString2, char[] paramArrayOfChar, MqttMessage paramMqttMessage, String paramString3)
  {
    super((byte)1);
    this.clientId = paramString1;
    this.cleanSession = paramBoolean;
    this.keepAliveInterval = paramInt2;
    this.userName = paramString2;
    this.password = paramArrayOfChar;
    this.willMessage = paramMqttMessage;
    this.willDestination = paramString3;
    this.MqttVersion = paramInt1;
  }
  
  public String getKey()
  {
    return "Con";
  }
  
  protected byte getMessageInfo()
  {
    return 0;
  }
  
  public byte[] getPayload()
    throws MqttException
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      encodeUTF8(localDataOutputStream, this.clientId);
      if (this.willMessage != null)
      {
        encodeUTF8(localDataOutputStream, this.willDestination);
        localDataOutputStream.writeShort(this.willMessage.getPayload().length);
        localDataOutputStream.write(this.willMessage.getPayload());
      }
      if (this.userName != null)
      {
        encodeUTF8(localDataOutputStream, this.userName);
        if (this.password != null) {
          encodeUTF8(localDataOutputStream, new String(this.password));
        }
      }
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new MqttException(localIOException);
    }
  }
  
  /* Error */
  protected byte[] getVariableHeader()
    throws MqttException
  {
    // Byte code:
    //   0: new 81	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 83	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 85	java/io/DataOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 88	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 4
    //   18: aload_0
    //   19: getfield 74	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:MqttVersion	I
    //   22: iconst_3
    //   23: if_icmpne +131 -> 154
    //   26: aload_0
    //   27: aload 4
    //   29: ldc 120
    //   31: invokevirtual 92	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:encodeUTF8	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   34: aload 4
    //   36: aload_0
    //   37: getfield 74	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:MqttVersion	I
    //   40: invokevirtual 122	java/io/DataOutputStream:write	(I)V
    //   43: iconst_0
    //   44: istore_2
    //   45: aload_0
    //   46: getfield 64	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:cleanSession	Z
    //   49: ifeq +6 -> 55
    //   52: iconst_2
    //   53: i2b
    //   54: istore_2
    //   55: iload_2
    //   56: istore_1
    //   57: aload_0
    //   58: getfield 70	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:willMessage	Lcom/tencent/android/tpns/mqtt/MqttMessage;
    //   61: ifnull +37 -> 98
    //   64: iload_2
    //   65: iconst_4
    //   66: ior
    //   67: i2b
    //   68: aload_0
    //   69: getfield 70	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:willMessage	Lcom/tencent/android/tpns/mqtt/MqttMessage;
    //   72: invokevirtual 125	com/tencent/android/tpns/mqtt/MqttMessage:getQos	()I
    //   75: iconst_3
    //   76: ishl
    //   77: ior
    //   78: i2b
    //   79: istore_2
    //   80: iload_2
    //   81: istore_1
    //   82: aload_0
    //   83: getfield 70	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:willMessage	Lcom/tencent/android/tpns/mqtt/MqttMessage;
    //   86: invokevirtual 129	com/tencent/android/tpns/mqtt/MqttMessage:isRetained	()Z
    //   89: ifeq +9 -> 98
    //   92: iload_2
    //   93: bipush 32
    //   95: ior
    //   96: i2b
    //   97: istore_1
    //   98: iload_1
    //   99: istore_2
    //   100: aload_0
    //   101: getfield 66	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:userName	Ljava/lang/String;
    //   104: ifnull +25 -> 129
    //   107: iload_1
    //   108: sipush 128
    //   111: ior
    //   112: i2b
    //   113: istore_1
    //   114: iload_1
    //   115: istore_2
    //   116: aload_0
    //   117: getfield 68	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:password	[C
    //   120: ifnull +9 -> 129
    //   123: iload_1
    //   124: bipush 64
    //   126: ior
    //   127: i2b
    //   128: istore_2
    //   129: aload 4
    //   131: iload_2
    //   132: invokevirtual 122	java/io/DataOutputStream:write	(I)V
    //   135: aload 4
    //   137: aload_0
    //   138: getfield 53	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:keepAliveInterval	I
    //   141: invokevirtual 100	java/io/DataOutputStream:writeShort	(I)V
    //   144: aload 4
    //   146: invokevirtual 111	java/io/DataOutputStream:flush	()V
    //   149: aload_3
    //   150: invokevirtual 114	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   153: areturn
    //   154: aload_0
    //   155: getfield 74	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:MqttVersion	I
    //   158: iconst_4
    //   159: if_icmpne -125 -> 34
    //   162: aload_0
    //   163: aload 4
    //   165: ldc 131
    //   167: invokevirtual 92	com/tencent/android/tpns/mqtt/internal/wire/MqttConnect:encodeUTF8	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   170: goto -136 -> 34
    //   173: astore_3
    //   174: new 26	com/tencent/android/tpns/mqtt/MqttException
    //   177: dup
    //   178: aload_3
    //   179: invokespecial 117	com/tencent/android/tpns/mqtt/MqttException:<init>	(Ljava/lang/Throwable;)V
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	MqttConnect
    //   56	71	1	i	int
    //   44	88	2	j	int
    //   7	143	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   173	6	3	localIOException	IOException
    //   16	148	4	localDataOutputStream	DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	34	173	java/io/IOException
    //   34	43	173	java/io/IOException
    //   45	52	173	java/io/IOException
    //   57	80	173	java/io/IOException
    //   82	92	173	java/io/IOException
    //   100	107	173	java/io/IOException
    //   116	123	173	java/io/IOException
    //   129	154	173	java/io/IOException
    //   154	170	173	java/io/IOException
  }
  
  public boolean isCleanSession()
  {
    return this.cleanSession;
  }
  
  public boolean isMessageIdRequired()
  {
    return false;
  }
  
  public String toString()
  {
    String str = super.toString();
    return str + " clientId " + this.clientId + " keepAliveInterval " + this.keepAliveInterval;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttConnect
 * JD-Core Version:    0.7.0.1
 */