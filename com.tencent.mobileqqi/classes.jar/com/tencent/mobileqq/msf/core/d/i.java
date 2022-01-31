package com.tencent.mobileqq.msf.core.d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class i
  extends JceStruct
{
  static Map e;
  public String a = "";
  public long b = 0L;
  public Map c = null;
  public boolean d = true;
  
  public i() {}
  
  public i(String paramString, long paramLong, Map paramMap, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramMap;
    this.d = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    if (e == null)
    {
      e = new HashMap();
      e.put("", "");
    }
    this.c = ((Map)paramJceInputStream.read(e, 3, true));
    this.d = paramJceInputStream.read(this.d, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.i
 * JD-Core Version:    0.7.0.1
 */