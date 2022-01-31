package com.tencent.mobileqq.highway.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NetSegConf
  extends JceStruct
{
  public long uint32_curconnnum = 0L;
  public long uint32_net_type = 0L;
  public long uint32_segnum = 0L;
  public long uint32_segsize = 0L;
  
  public NetSegConf() {}
  
  public NetSegConf(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.uint32_net_type = paramLong1;
    this.uint32_segsize = paramLong2;
    this.uint32_segnum = paramLong3;
    this.uint32_curconnnum = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uint32_net_type = paramJceInputStream.read(this.uint32_net_type, 0, false);
    this.uint32_segsize = paramJceInputStream.read(this.uint32_segsize, 1, false);
    this.uint32_segnum = paramJceInputStream.read(this.uint32_segnum, 2, false);
    this.uint32_curconnnum = paramJceInputStream.read(this.uint32_curconnnum, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uint32_net_type, 0);
    paramJceOutputStream.write(this.uint32_segsize, 1);
    paramJceOutputStream.write(this.uint32_segnum, 2);
    paramJceOutputStream.write(this.uint32_curconnnum, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.NetSegConf
 * JD-Core Version:    0.7.0.1
 */