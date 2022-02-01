package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QmfClientIpInfo
  extends JceStruct
{
  static byte[] cache_ClientIpv6;
  public int ClientIpv4;
  public byte[] ClientIpv6;
  public short ClientPort;
  public byte IpType;
  
  public QmfClientIpInfo() {}
  
  public QmfClientIpInfo(byte paramByte, short paramShort, int paramInt, byte[] paramArrayOfByte)
  {
    this.IpType = paramByte;
    this.ClientPort = paramShort;
    this.ClientIpv4 = paramInt;
    this.ClientIpv6 = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.IpType = paramJceInputStream.read(this.IpType, 0, true);
    this.ClientPort = paramJceInputStream.read(this.ClientPort, 1, true);
    this.ClientIpv4 = paramJceInputStream.read(this.ClientIpv4, 2, true);
    if (cache_ClientIpv6 == null)
    {
      cache_ClientIpv6 = (byte[])new byte[1];
      ((byte[])cache_ClientIpv6)[0] = 0;
    }
    this.ClientIpv6 = ((byte[])paramJceInputStream.read(cache_ClientIpv6, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.IpType, 0);
    paramJceOutputStream.write(this.ClientPort, 1);
    paramJceOutputStream.write(this.ClientIpv4, 2);
    if (this.ClientIpv6 != null) {
      paramJceOutputStream.write(this.ClientIpv6, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QMF_PROTOCAL.QmfClientIpInfo
 * JD-Core Version:    0.7.0.1
 */