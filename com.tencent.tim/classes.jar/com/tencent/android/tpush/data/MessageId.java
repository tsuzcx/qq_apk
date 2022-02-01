package com.tencent.android.tpush.data;

import java.io.Serializable;

public class MessageId
  implements Serializable
{
  public static final short FLAG_ACK = 1;
  public static final short FLAG_UNACK = 0;
  private static final long serialVersionUID = 8708157897391765794L;
  public long accessId;
  public byte apn;
  public long busiMsgId = 0L;
  public long channelId = -1L;
  public String date = "";
  public String groupId = "";
  public long host;
  public long id;
  public short isAck;
  public byte isp;
  public long msgType = -1L;
  public long multiPkg = 0L;
  public String nGroupId = "";
  public byte pact;
  public String pkgName;
  public int port;
  public int pushChannel;
  public long pushTime;
  public long receivedTime;
  public int revokeId = 0;
  public long serverTime;
  public String serviceHost;
  public String statTag = "";
  public long timestamp = 0L;
  public long ttl;
  
  public boolean isMsgAcked()
  {
    return this.isAck == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MessageId [id=").append(this.id).append(", isAck=").append(this.isAck).append(", isp=").append(this.isp).append(", apn=").append(this.apn).append(", accessId=").append(this.accessId).append(", receivedTime=").append(this.receivedTime).append(", pact=").append(this.pact).append(", host=").append(this.host).append(", port=").append(this.port).append(", serviceHost=").append(this.serviceHost).append(", pkgName=").append(this.pkgName).append(", busiMsgId=").append(this.busiMsgId).append(", timestamp=").append(this.timestamp).append(", msgType=").append(this.msgType).append(", multiPkg=").append(this.multiPkg).append(", date=").append(this.date).append(", serverTime=").append(this.serverTime).append(", ttl=").append(this.ttl).append("]").append(", revokeId=").append(this.revokeId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.data.MessageId
 * JD-Core Version:    0.7.0.1
 */