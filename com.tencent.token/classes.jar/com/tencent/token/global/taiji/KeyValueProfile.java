package com.tencent.token.global.taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class KeyValueProfile
  extends JceStruct
{
  static byte[] cache_byt;
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
    byte[] arrayOfByte = (byte[])new byte[1];
    cache_byt = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final JceStruct newInit()
  {
    return new KeyValueProfile();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
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
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    int j = this.valueType;
    if (j != 0) {
      paramJceOutputStream.write(j, 0);
    }
    j = this.keyid;
    if (j != 0) {
      paramJceOutputStream.write(j, 1);
    }
    j = this.i;
    if (j != 0) {
      paramJceOutputStream.write(j, 2);
    }
    long l = this.lng;
    if (l != 0L) {
      paramJceOutputStream.write(l, 3);
    }
    Object localObject = this.str;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.byt;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 5);
    }
    paramJceOutputStream.write(this.bl, 6);
    short s = this.sht;
    if (s != 0) {
      paramJceOutputStream.write(s, 7);
    }
    l = this.updateTime;
    if (l != 0L) {
      paramJceOutputStream.write(l, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.KeyValueProfile
 * JD-Core Version:    0.7.0.1
 */