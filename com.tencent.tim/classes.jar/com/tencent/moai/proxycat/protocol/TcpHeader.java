package com.tencent.moai.proxycat.protocol;

import com.tencent.moai.proxycat.util.ByteUtils;

public class TcpHeader
  extends IPHeader
{
  private static final byte FLAG_ACK = 16;
  private static final byte FLAG_FIN = 1;
  private static final byte FLAG_PSH = 8;
  private static final byte FLAG_RST = 4;
  private static final byte FLAG_SYN = 2;
  
  public TcpHeader(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public boolean ack()
  {
    return (this.packet[(offset() + 13)] & 0x10) == 16;
  }
  
  public boolean fin()
  {
    return (this.packet[(offset() + 13)] & 0x1) == 1;
  }
  
  public int getDestinationPort()
  {
    return ByteUtils.readShort(this.packet, offset() + 2);
  }
  
  public int getSourcePort()
  {
    return ByteUtils.readShort(this.packet, offset());
  }
  
  public int getTcpHeaderChecksum()
  {
    return ByteUtils.readShort(this.packet, offset() + 16);
  }
  
  public int offset()
  {
    return super.offset() + ipHeaderLength();
  }
  
  public boolean psh()
  {
    return (this.packet[(offset() + 13)] & 0x8) == 8;
  }
  
  public void recomputeChecksum()
  {
    super.recomputeChecksum();
    setTcpHeaderChecksum(0);
    setTcpHeaderChecksum(checksum(0L + (getSourceIp() & 0xFFFF) + (getSourceIp() >> 16 & 0xFFFF) + (getDestinationIp() & 0xFFFF) + (getDestinationIp() >> 16 & 0xFFFF) + 6L + ipDataLength(), ipDataOffset(), ipDataLength()));
  }
  
  public boolean rst()
  {
    return (this.packet[(offset() + 13)] & 0x4) == 4;
  }
  
  public void setDestinationPort(int paramInt)
  {
    ByteUtils.writeShort(this.packet, offset() + 2, paramInt);
  }
  
  public void setSourcePort(int paramInt)
  {
    ByteUtils.writeShort(this.packet, offset(), paramInt);
  }
  
  public void setTcpHeaderChecksum(int paramInt)
  {
    ByteUtils.writeShort(this.packet, offset() + 16, paramInt);
  }
  
  public boolean syn()
  {
    return (this.packet[(offset() + 13)] & 0x2) == 2;
  }
  
  public int tcpDataLength()
  {
    return totalLength() - tcpDataOffset();
  }
  
  public int tcpDataOffset()
  {
    return offset() + tcpHeaderLength();
  }
  
  public int tcpHeaderLength()
  {
    return (this.packet[(offset() + 12)] >> 4 & 0xF) * 4;
  }
  
  public String toString()
  {
    Object localObject2 = "";
    if (ack()) {
      localObject2 = "" + " ACK";
    }
    Object localObject1 = localObject2;
    if (psh()) {
      localObject1 = (String)localObject2 + " PSH";
    }
    localObject2 = localObject1;
    if (rst()) {
      localObject2 = (String)localObject1 + " RST";
    }
    localObject1 = localObject2;
    if (syn()) {
      localObject1 = (String)localObject2 + " SYN";
    }
    localObject2 = localObject1;
    if (fin()) {
      localObject2 = (String)localObject1 + " FIN";
    }
    return String.format("TCP[srcIp:%s, srcPort:%s, dstPort:%s, dstPort:%s, offset:%s, flag:%s, dataLen:%s]", new Object[] { getSourceIpAddress(), Integer.valueOf(getSourcePort()), getDestinationIpAddress(), Integer.valueOf(getDestinationPort()), Integer.valueOf(tcpDataOffset()), localObject2, Integer.valueOf(tcpDataLength()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.protocol.TcpHeader
 * JD-Core Version:    0.7.0.1
 */