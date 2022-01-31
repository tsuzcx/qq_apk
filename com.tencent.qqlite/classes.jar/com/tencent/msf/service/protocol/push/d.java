package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends JceStruct
{
  static Map f;
  public long a = 0L;
  public long b = 0L;
  public byte c = 0;
  public Map d = null;
  public String e = "";
  
  public d() {}
  
  public d(long paramLong1, long paramLong2, byte paramByte, Map paramMap, String paramString)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramByte;
    this.d = paramMap;
    this.e = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    if (f == null)
    {
      f = new HashMap();
      f.put(Long.valueOf(0L), "");
    }
    this.d = ((Map)paramJceInputStream.read(f, 3, false));
    this.e = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.d
 * JD-Core Version:    0.7.0.1
 */