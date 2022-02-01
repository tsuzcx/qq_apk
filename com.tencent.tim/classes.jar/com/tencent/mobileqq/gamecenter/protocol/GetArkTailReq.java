package com.tencent.mobileqq.gamecenter.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetArkTailReq
  extends JceStruct
{
  public String appid = "";
  public String qq_version = "";
  public int scene_id;
  public int tt;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.readString(0, false);
    this.tt = paramJceInputStream.read(this.tt, 1, false);
    this.qq_version = paramJceInputStream.readString(2, false);
    this.scene_id = paramJceInputStream.read(this.scene_id, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 0);
    }
    paramJceOutputStream.write(this.tt, 1);
    if (this.qq_version != null) {
      paramJceOutputStream.write(this.qq_version, 2);
    }
    paramJceOutputStream.write(this.scene_id, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocol.GetArkTailReq
 * JD-Core Version:    0.7.0.1
 */