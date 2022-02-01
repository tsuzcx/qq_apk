package com.tencent.moai.proxycat.protocol;

import com.tencent.moai.proxycat.util.ByteUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPHeader
{
  public static final byte PROTOCOL_TCP = 6;
  public static final byte PROTOCOL_UDP = 17;
  protected final byte[] packet;
  
  public IPHeader(byte[] paramArrayOfByte)
  {
    this.packet = paramArrayOfByte;
  }
  
  public short checksum(long paramLong, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      paramLong += (this.packet[(paramInt1 + i)] << 8 & 0xFF00);
      i += 2;
    }
    i = 1;
    long l;
    for (;;)
    {
      l = paramLong;
      if (i >= paramInt2) {
        break;
      }
      l = this.packet[(paramInt1 + i)] & 0xFF;
      i += 2;
      paramLong = l + paramLong;
    }
    while (l >> 16 > 0L) {
      l = (l & 0xFFFF) + (l >> 16);
    }
    return (short)(int)(65535L - l);
  }
  
  public int getDestinationIp()
  {
    return ByteUtils.readInt(this.packet, 16);
  }
  
  public InetAddress getDestinationIpAddress()
  {
    try
    {
      InetAddress localInetAddress = InetAddress.getByAddress(new byte[] { this.packet[16], this.packet[17], this.packet[18], this.packet[19] });
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException) {}
    return null;
  }
  
  public int getIpHeaderChecksum()
  {
    return ByteUtils.readShort(this.packet, 10);
  }
  
  public int getSourceIp()
  {
    return ByteUtils.readInt(this.packet, 12);
  }
  
  public InetAddress getSourceIpAddress()
  {
    try
    {
      InetAddress localInetAddress = InetAddress.getByAddress(new byte[] { this.packet[12], this.packet[13], this.packet[14], this.packet[15] });
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException) {}
    return null;
  }
  
  public int ipDataLength()
  {
    return totalLength() - ipDataOffset();
  }
  
  public int ipDataOffset()
  {
    return ipHeaderLength();
  }
  
  public int ipHeaderLength()
  {
    return (this.packet[0] & 0xF) * 4;
  }
  
  public int offset()
  {
    return 0;
  }
  
  public byte protocol()
  {
    return this.packet[9];
  }
  
  public void recomputeChecksum()
  {
    setIpHeaderChecksum(0);
    setIpHeaderChecksum(checksum(0L, 0, ipHeaderLength()));
  }
  
  public void setDestinationIp(int paramInt)
  {
    ByteUtils.writeInt(this.packet, 16, paramInt);
  }
  
  public void setDestinationIp(InetAddress paramInetAddress)
  {
    System.arraycopy(paramInetAddress.getAddress(), 0, this.packet, 16, 4);
  }
  
  public void setIpHeaderChecksum(int paramInt)
  {
    ByteUtils.writeShort(this.packet, 10, paramInt);
  }
  
  public void setSourceIp(int paramInt)
  {
    ByteUtils.writeInt(this.packet, 12, paramInt);
  }
  
  public void setSourceIp(InetAddress paramInetAddress)
  {
    System.arraycopy(paramInetAddress.getAddress(), 0, this.packet, 12, 4);
  }
  
  public String toString()
  {
    return String.format("IP[headerLen:%s, totalLen:%s,  protocol:%s, srcIp:%s, dstIp:%s]", new Object[] { Integer.valueOf(ipHeaderLength()), Integer.valueOf(totalLength()), Byte.valueOf(protocol()), ByteUtils.toString(getSourceIp()), ByteUtils.toString(getDestinationIp()) });
  }
  
  public int totalLength()
  {
    return ByteUtils.readShort(this.packet, 2);
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.packet, 0, totalLength());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.protocol.IPHeader
 * JD-Core Version:    0.7.0.1
 */