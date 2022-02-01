package com.tencent.beacon.pack;

import java.util.HashMap;
import java.util.Map;

public final class SocketResponsePackage
  extends AbstractJceStruct
{
  static byte[] cache_body;
  static Map<String, String> cache_header = new HashMap();
  public byte[] body = null;
  public Map<String, String> header = null;
  public String msg = "";
  public int statusCode = 0;
  
  static
  {
    cache_header.put("", "");
    cache_body = new byte[1];
    cache_body[0] = 0;
  }
  
  public SocketResponsePackage() {}
  
  public SocketResponsePackage(int paramInt, Map<String, String> paramMap, byte[] paramArrayOfByte, String paramString)
  {
    this.statusCode = paramInt;
    this.header = paramMap;
    this.body = paramArrayOfByte;
    this.msg = paramString;
  }
  
  public void readFrom(a parama)
  {
    this.statusCode = parama.a(this.statusCode, 0, true);
    this.header = ((Map)parama.a(cache_header, 1, true));
    this.body = parama.a(cache_body, 2, true);
    this.msg = parama.a(3, false);
  }
  
  public void writeTo(b paramb)
  {
    paramb.a(this.statusCode, 0);
    paramb.a(this.header, 1);
    paramb.a(this.body, 2);
    String str = this.msg;
    if (str != null) {
      paramb.a(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.pack.SocketResponsePackage
 * JD-Core Version:    0.7.0.1
 */