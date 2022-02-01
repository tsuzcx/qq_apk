package com.tencent.moai.proxycat.protocol;

import com.tencent.moai.proxycat.util.ByteUtils;

public class UdpHeader
  extends IPHeader
{
  public UdpHeader(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public int getDestinationPort()
  {
    return ByteUtils.readShort(this.packet, offset() + 2);
  }
  
  public int getSourcePort()
  {
    return ByteUtils.readShort(this.packet, offset());
  }
  
  public int getUdpHeaderChecksum()
  {
    return ByteUtils.readShort(this.packet, offset() + 6);
  }
  
  public int offset()
  {
    return super.offset() + ipHeaderLength();
  }
  
  public void recomputeChecksum()
  {
    super.recomputeChecksum();
    setUdpHeaderChecksum(0);
    setUdpHeaderChecksum(checksum(0L + (getSourceIp() & 0xFFFF) + (getSourceIp() >> 16 & 0xFFFF) + (getDestinationIp() & 0xFFFF) + (getDestinationIp() >> 16 & 0xFFFF) + 17L + ipDataLength(), ipDataOffset(), ipDataLength()));
  }
  
  public void setDestinationPort(int paramInt)
  {
    ByteUtils.writeShort(this.packet, offset() + 2, paramInt);
  }
  
  public void setSourcePort(int paramInt)
  {
    ByteUtils.writeShort(this.packet, offset(), paramInt);
  }
  
  public void setUdpHeaderChecksum(int paramInt)
  {
    ByteUtils.writeShort(this.packet, offset() + 6, paramInt);
  }
  
  public String toString()
  {
    return String.format("UDP[srcIp: %s, srcPort:%s, dstPort:%s, detPort:%s, dataLength:%s]", new Object[] { getSourceIpAddress(), Integer.valueOf(getSourcePort()), getDestinationIpAddress(), Integer.valueOf(getDestinationPort()), Integer.valueOf(udpDataLength()) });
  }
  
  public int udpDataLength()
  {
    return totalLength() - udpDataOffset();
  }
  
  public int udpDataOffset()
  {
    return offset() + udpHeaderLength();
  }
  
  public int udpHeaderLength()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.protocol.UdpHeader
 * JD-Core Version:    0.7.0.1
 */