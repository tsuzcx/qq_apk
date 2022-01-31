package com.tencent.msf.service.protocol.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class f
  extends JceStruct
{
  static b h;
  static ArrayList i;
  static ArrayList j;
  static byte[] k;
  public b a = null;
  public ArrayList b = null;
  public ArrayList c = null;
  public String d = "";
  public String e = "";
  public byte f = 0;
  public byte[] g = null;
  
  public f() {}
  
  public f(b paramb, ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString1, String paramString2, byte paramByte, byte[] paramArrayOfByte)
  {
    this.a = paramb;
    this.b = paramArrayList1;
    this.c = paramArrayList2;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramByte;
    this.g = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (h == null) {
      h = new b();
    }
    this.a = ((b)paramJceInputStream.read(h, 0, true));
    if (i == null)
    {
      i = new ArrayList();
      i.add(Long.valueOf(0L));
    }
    this.b = ((ArrayList)paramJceInputStream.read(i, 1, true));
    if (j == null)
    {
      j = new ArrayList();
      a locala = new a();
      j.add(locala);
    }
    this.c = ((ArrayList)paramJceInputStream.read(j, 2, true));
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    if (k == null)
    {
      k = (byte[])new byte[1];
      ((byte[])k)[0] = 0;
    }
    this.g = ((byte[])paramJceInputStream.read(k, 6, false));
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
    paramJceOutputStream.write(this.f, 5);
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.f.f
 * JD-Core Version:    0.7.0.1
 */