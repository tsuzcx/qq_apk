package com.tencent.mobileqq.highway.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HttpFmtServerListRes
  extends JceStruct
{
  static BigDataChannel cache_bigDataChannel;
  public BigDataChannel bigDataChannel = null;
  public int iResult = 0;
  public int iSecInterval = 86400;
  public int iTime = 0;
  public long uClientIp = 0L;
  public int usClientPort = 0;
  
  public HttpFmtServerListRes() {}
  
  public HttpFmtServerListRes(int paramInt1, BigDataChannel paramBigDataChannel, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    this.iResult = paramInt1;
    this.bigDataChannel = paramBigDataChannel;
    this.iTime = paramInt2;
    this.iSecInterval = paramInt3;
    this.uClientIp = paramLong;
    this.usClientPort = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResult = paramJceInputStream.read(this.iResult, 0, true);
    if (cache_bigDataChannel == null) {
      cache_bigDataChannel = new BigDataChannel();
    }
    this.bigDataChannel = ((BigDataChannel)paramJceInputStream.read(cache_bigDataChannel, 1, true));
    this.iTime = paramJceInputStream.read(this.iTime, 2, true);
    this.iSecInterval = paramJceInputStream.read(this.iSecInterval, 3, true);
    this.uClientIp = paramJceInputStream.read(this.uClientIp, 4, false);
    this.usClientPort = paramJceInputStream.read(this.usClientPort, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 0);
    paramJceOutputStream.write(this.bigDataChannel, 1);
    paramJceOutputStream.write(this.iTime, 2);
    paramJceOutputStream.write(this.iSecInterval, 3);
    paramJceOutputStream.write(this.uClientIp, 4);
    paramJceOutputStream.write(this.usClientPort, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.HttpFmtServerListRes
 * JD-Core Version:    0.7.0.1
 */