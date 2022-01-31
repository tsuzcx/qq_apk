package com.tencent.qphone.base.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import java.util.HashMap;

public class ToServiceMsg
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ToServiceMsg.1();
  private static final String tag = "ToServiceMsg";
  private static final String version = "version";
  public IBaseActionListener actionListener;
  private int appId;
  private int appSeq = -1;
  private HashMap attributes = new HashMap();
  public Bundle extraData = new Bundle();
  private MsfCommand msfCommand = MsfCommand.unknown;
  private boolean needResp = true;
  private long sendTimeout = -1L;
  private String serviceCmd;
  private String serviceName;
  private int ssoSeq = -1;
  private long timeout = -1L;
  private byte toVersion = 1;
  private String uin;
  private byte uinType = 0;
  private byte[] wupBuffer = new byte[0];
  
  public ToServiceMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public ToServiceMsg(String paramString1, String paramString2, String paramString3)
  {
    this.serviceName = paramString1;
    this.uin = paramString2;
    this.serviceCmd = paramString3;
    this.extraData.putByte("version", this.toVersion);
  }
  
  /* Error */
  private void readFromParcel(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 108	android/os/Parcel:readInt	()I
    //   5: putfield 110	com/tencent/qphone/base/remote/ToServiceMsg:appId	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 108	android/os/Parcel:readInt	()I
    //   13: putfield 59	com/tencent/qphone/base/remote/ToServiceMsg:appSeq	I
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 114	android/os/Parcel:readString	()Ljava/lang/String;
    //   21: putfield 92	com/tencent/qphone/base/remote/ToServiceMsg:serviceName	Ljava/lang/String;
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 114	android/os/Parcel:readString	()Ljava/lang/String;
    //   29: putfield 94	com/tencent/qphone/base/remote/ToServiceMsg:uin	Ljava/lang/String;
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 118	android/os/Parcel:readByte	()B
    //   37: putfield 86	com/tencent/qphone/base/remote/ToServiceMsg:uinType	B
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 114	android/os/Parcel:readString	()Ljava/lang/String;
    //   45: putfield 96	com/tencent/qphone/base/remote/ToServiceMsg:serviceCmd	Ljava/lang/String;
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 122	android/os/Parcel:readLong	()J
    //   53: putfield 57	com/tencent/qphone/base/remote/ToServiceMsg:timeout	J
    //   56: aload_0
    //   57: getfield 75	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   60: invokevirtual 125	android/os/Bundle:clear	()V
    //   63: aload_0
    //   64: getfield 75	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   67: aload_1
    //   68: invokestatic 131	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   71: invokevirtual 135	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   74: invokevirtual 139	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   77: invokevirtual 143	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 147	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   85: invokestatic 153	com/tencent/qphone/base/remote/IBaseActionListener$Stub:asInterface	(Landroid/os/IBinder;)Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   88: putfield 155	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 75	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   96: ldc 14
    //   98: invokevirtual 159	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   101: putfield 77	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   104: aload_0
    //   105: getfield 77	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   108: ifle +82 -> 190
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual 163	android/os/Parcel:readSerializable	()Ljava/io/Serializable;
    //   116: checkcast 79	com/tencent/mobileqq/msf/sdk/MsfCommand
    //   119: putfield 84	com/tencent/qphone/base/remote/ToServiceMsg:msfCommand	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   122: aload_0
    //   123: aload_1
    //   124: invokevirtual 122	android/os/Parcel:readLong	()J
    //   127: putfield 55	com/tencent/qphone/base/remote/ToServiceMsg:sendTimeout	J
    //   130: aload_1
    //   131: invokevirtual 118	android/os/Parcel:readByte	()B
    //   134: ifne +57 -> 191
    //   137: iconst_0
    //   138: istore_2
    //   139: aload_0
    //   140: iload_2
    //   141: putfield 63	com/tencent/qphone/base/remote/ToServiceMsg:needResp	Z
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 108	android/os/Parcel:readInt	()I
    //   149: newarray byte
    //   151: putfield 61	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   154: aload_1
    //   155: aload_0
    //   156: getfield 61	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   159: invokevirtual 167	android/os/Parcel:readByteArray	([B)V
    //   162: aload_0
    //   163: aload_1
    //   164: invokevirtual 108	android/os/Parcel:readInt	()I
    //   167: putfield 65	com/tencent/qphone/base/remote/ToServiceMsg:ssoSeq	I
    //   170: aload_0
    //   171: getfield 70	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   174: invokevirtual 168	java/util/HashMap:clear	()V
    //   177: aload_1
    //   178: aload_0
    //   179: getfield 70	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   182: ldc 2
    //   184: invokevirtual 173	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   187: invokevirtual 177	android/os/Parcel:readMap	(Ljava/util/Map;Ljava/lang/ClassLoader;)V
    //   190: return
    //   191: iconst_1
    //   192: istore_2
    //   193: goto -54 -> 139
    //   196: astore_1
    //   197: ldc 12
    //   199: ldc 179
    //   201: aload_1
    //   202: invokestatic 185	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   205: pop
    //   206: aload_1
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	ToServiceMsg
    //   0	208	1	paramParcel	Parcel
    //   138	55	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	137	196	java/lang/RuntimeException
    //   139	190	196	java/lang/RuntimeException
  }
  
  public Object addAttribute(String paramString, Object paramObject)
  {
    return this.attributes.put(paramString, paramObject);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IBaseActionListener getActionListener()
  {
    return this.actionListener;
  }
  
  public int getAppId()
  {
    return this.appId;
  }
  
  public int getAppSeq()
  {
    return this.appSeq;
  }
  
  public Object getAttribute(String paramString)
  {
    return this.attributes.get(paramString);
  }
  
  public Object getAttribute(String paramString, Object paramObject)
  {
    if (!this.attributes.containsKey(paramString)) {
      return paramObject;
    }
    return this.attributes.get(paramString);
  }
  
  public HashMap getAttributes()
  {
    return this.attributes;
  }
  
  public String getDestServiceId()
  {
    return this.serviceName;
  }
  
  public MsfCommand getMsfCommand()
  {
    return this.msfCommand;
  }
  
  public int getRequestSsoSeq()
  {
    return this.ssoSeq;
  }
  
  public String getServiceCmd()
  {
    return this.serviceCmd;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public long getTimeout()
  {
    return this.timeout;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public byte[] getWupBuffer()
  {
    return this.wupBuffer;
  }
  
  public boolean isFastResendEnabled()
  {
    return ((Boolean)getAttribute("fastresend", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean isNeedCallback()
  {
    return this.needResp;
  }
  
  public boolean isNeedRemindSlowNetwork()
  {
    return ((Boolean)getAttribute("remind_slown_network", Boolean.valueOf(false))).booleanValue();
  }
  
  public void putWupBuffer(byte[] paramArrayOfByte)
  {
    this.wupBuffer = paramArrayOfByte;
  }
  
  public void setAppId(int paramInt)
  {
    this.appId = paramInt;
  }
  
  public void setAppSeq(int paramInt)
  {
    this.appSeq = paramInt;
  }
  
  public void setAttributes(HashMap paramHashMap)
  {
    this.attributes = paramHashMap;
  }
  
  public void setEnableFastResend(boolean paramBoolean)
  {
    addAttribute("fastresend", Boolean.valueOf(paramBoolean));
  }
  
  public void setMsfCommand(MsfCommand paramMsfCommand)
  {
    this.msfCommand = paramMsfCommand;
  }
  
  public void setNeedCallback(boolean paramBoolean)
  {
    this.needResp = paramBoolean;
  }
  
  public void setNeedRemindSlowNetwork(boolean paramBoolean)
  {
    addAttribute("remind_slown_network", Boolean.valueOf(paramBoolean));
  }
  
  public void setRequestSsoSeq(int paramInt)
  {
    this.ssoSeq = paramInt;
  }
  
  public void setServiceCmd(String paramString)
  {
    this.serviceCmd = paramString;
  }
  
  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public void setTimeout(long paramLong)
  {
    this.timeout = paramLong;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public String toString()
  {
    return "ToServiceMsg msName:" + this.msfCommand + " ssoSeq:" + getRequestSsoSeq() + " appId:" + this.appId + " appSeq:" + this.appSeq + " sName:" + this.serviceName + " uin:" + this.uin + " sCmd:" + this.serviceCmd + " t:" + this.timeout + " needResp:" + this.needResp;
  }
  
  /* Error */
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 110	com/tencent/qphone/base/remote/ToServiceMsg:appId	I
    //   5: invokevirtual 305	android/os/Parcel:writeInt	(I)V
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 59	com/tencent/qphone/base/remote/ToServiceMsg:appSeq	I
    //   13: invokevirtual 305	android/os/Parcel:writeInt	(I)V
    //   16: aload_1
    //   17: aload_0
    //   18: getfield 92	com/tencent/qphone/base/remote/ToServiceMsg:serviceName	Ljava/lang/String;
    //   21: invokevirtual 308	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   24: aload_1
    //   25: aload_0
    //   26: getfield 94	com/tencent/qphone/base/remote/ToServiceMsg:uin	Ljava/lang/String;
    //   29: invokevirtual 308	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 86	com/tencent/qphone/base/remote/ToServiceMsg:uinType	B
    //   37: invokevirtual 312	android/os/Parcel:writeByte	(B)V
    //   40: aload_1
    //   41: aload_0
    //   42: getfield 96	com/tencent/qphone/base/remote/ToServiceMsg:serviceCmd	Ljava/lang/String;
    //   45: invokevirtual 308	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 57	com/tencent/qphone/base/remote/ToServiceMsg:timeout	J
    //   53: invokevirtual 315	android/os/Parcel:writeLong	(J)V
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 75	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   61: invokevirtual 318	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   64: aload_1
    //   65: aload_0
    //   66: getfield 155	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   69: invokevirtual 322	android/os/Parcel:writeStrongInterface	(Landroid/os/IInterface;)V
    //   72: aload_0
    //   73: getfield 77	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   76: ifle +66 -> 142
    //   79: aload_1
    //   80: aload_0
    //   81: getfield 84	com/tencent/qphone/base/remote/ToServiceMsg:msfCommand	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   84: invokevirtual 326	android/os/Parcel:writeSerializable	(Ljava/io/Serializable;)V
    //   87: aload_1
    //   88: aload_0
    //   89: getfield 55	com/tencent/qphone/base/remote/ToServiceMsg:sendTimeout	J
    //   92: invokevirtual 315	android/os/Parcel:writeLong	(J)V
    //   95: aload_0
    //   96: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:needResp	Z
    //   99: ifeq +44 -> 143
    //   102: iconst_1
    //   103: istore_3
    //   104: aload_1
    //   105: iload_3
    //   106: invokevirtual 312	android/os/Parcel:writeByte	(B)V
    //   109: aload_1
    //   110: aload_0
    //   111: getfield 61	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   114: arraylength
    //   115: invokevirtual 305	android/os/Parcel:writeInt	(I)V
    //   118: aload_1
    //   119: aload_0
    //   120: getfield 61	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   123: invokevirtual 329	android/os/Parcel:writeByteArray	([B)V
    //   126: aload_1
    //   127: aload_0
    //   128: getfield 65	com/tencent/qphone/base/remote/ToServiceMsg:ssoSeq	I
    //   131: invokevirtual 305	android/os/Parcel:writeInt	(I)V
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 70	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   139: invokevirtual 333	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   142: return
    //   143: iconst_0
    //   144: istore_3
    //   145: goto -41 -> 104
    //   148: astore_1
    //   149: ldc 12
    //   151: ldc_w 335
    //   154: aload_1
    //   155: invokestatic 185	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   158: pop
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	ToServiceMsg
    //   0	161	1	paramParcel	Parcel
    //   0	161	2	paramInt	int
    //   103	42	3	b	byte
    // Exception table:
    //   from	to	target	type
    //   0	102	148	java/lang/RuntimeException
    //   104	142	148	java/lang/RuntimeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.ToServiceMsg
 * JD-Core Version:    0.7.0.1
 */