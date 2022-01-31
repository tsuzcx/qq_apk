package com.tencent.token.global.taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class KeyValueProfile
  extends JceStruct
{
  static byte[] cache_byt = (byte[])new byte[1];
  public boolean bl = false;
  public byte[] byt = null;
  public int i = 0;
  public int keyid = 0;
  public long lng = 0L;
  public short sht = 0;
  public String str = "";
  public long updateTime = 0L;
  public int valueType = 0;
  
  static
  {
    ((byte[])cache_byt)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new KeyValueProfile();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.valueType = paramJceInputStream.read(this.valueType, 0, false);
    this.keyid = paramJceInputStream.read(this.keyid, 1, false);
    this.i = paramJceInputStream.read(this.i, 2, false);
    this.lng = paramJceInputStream.read(this.lng, 3, false);
    this.str = paramJceInputStream.readString(4, false);
    this.byt = ((byte[])paramJceInputStream.read(cache_byt, 5, false));
    this.bl = paramJceInputStream.read(this.bl, 6, false);
    this.sht = paramJceInputStream.read(this.sht, 7, false);
    this.updateTime = paramJceInputStream.read(this.updateTime, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.valueType != 0) {
      paramJceOutputStream.write(this.valueType, 0);
    }
    if (this.keyid != 0) {
      paramJceOutputStream.write(this.keyid, 1);
    }
    if (this.i != 0) {
      paramJceOutputStream.write(this.i, 2);
    }
    if (this.lng != 0L) {
      paramJceOutputStream.write(this.lng, 3);
    }
    if (this.str != null) {
      paramJceOutputStream.write(this.str, 4);
    }
    if (this.byt != null) {
      paramJceOutputStream.write(this.byt, 5);
    }
    paramJceOutputStream.write(this.bl, 6);
    if (this.sht != 0) {
      paramJceOutputStream.write(this.sht, 7);
    }
    if (this.updateTime != 0L) {
      paramJceOutputStream.write(this.updateTime, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.KeyValueProfile
 * JD-Core Version:    0.7.0.1
 */