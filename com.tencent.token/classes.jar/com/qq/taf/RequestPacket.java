package com.qq.taf;

import com.qq.jce.wup.WupHexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class RequestPacket
  extends JceStruct
{
  static Map<String, String> cache_context;
  static byte[] cache_sBuffer;
  public byte cPacketType = 0;
  public Map<String, String> context;
  public int iMessageType = 0;
  public int iRequestId = 0;
  public int iTimeout = 0;
  public short iVersion = 0;
  public byte[] sBuffer;
  public String sFuncName = null;
  public String sServantName = null;
  public Map<String, String> status;
  
  public RequestPacket() {}
  
  public RequestPacket(short paramShort, byte paramByte, int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt3, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    this.iVersion = paramShort;
    this.cPacketType = paramByte;
    this.iMessageType = paramInt1;
    this.iRequestId = paramInt2;
    this.sServantName = paramString1;
    this.sFuncName = paramString2;
    this.sBuffer = paramArrayOfByte;
    this.iTimeout = paramInt3;
    this.context = paramMap1;
    this.status = paramMap2;
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (RequestPacket)paramObject;
    return (JceUtil.equals(1, paramObject.iVersion)) && (JceUtil.equals(1, paramObject.cPacketType)) && (JceUtil.equals(1, paramObject.iMessageType)) && (JceUtil.equals(1, paramObject.iRequestId)) && (JceUtil.equals(Integer.valueOf(1), paramObject.sServantName)) && (JceUtil.equals(Integer.valueOf(1), paramObject.sFuncName)) && (JceUtil.equals(Integer.valueOf(1), paramObject.sBuffer)) && (JceUtil.equals(1, paramObject.iTimeout)) && (JceUtil.equals(Integer.valueOf(1), paramObject.context)) && (JceUtil.equals(Integer.valueOf(1), paramObject.status));
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    try
    {
      this.iVersion = paramJceInputStream.read(this.iVersion, 1, true);
      this.cPacketType = paramJceInputStream.read(this.cPacketType, 2, true);
      this.iMessageType = paramJceInputStream.read(this.iMessageType, 3, true);
      this.iRequestId = paramJceInputStream.read(this.iRequestId, 4, true);
      this.sServantName = paramJceInputStream.readString(5, true);
      this.sFuncName = paramJceInputStream.readString(6, true);
      if (cache_sBuffer == null) {
        cache_sBuffer = new byte[] { 0 };
      }
      this.sBuffer = ((byte[])paramJceInputStream.read(cache_sBuffer, 7, true));
      this.iTimeout = paramJceInputStream.read(this.iTimeout, 8, true);
      if (cache_context == null)
      {
        localObject = new HashMap();
        cache_context = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.context = ((Map)paramJceInputStream.read(cache_context, 9, true));
      if (cache_context == null)
      {
        localObject = new HashMap();
        cache_context = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.status = ((Map)paramJceInputStream.read(cache_context, 10, true));
      return;
    }
    catch (Exception paramJceInputStream)
    {
      paramJceInputStream.printStackTrace();
      Object localObject = System.out;
      StringBuilder localStringBuilder = new StringBuilder("RequestPacket decode error ");
      localStringBuilder.append(WupHexUtil.bytes2HexStr(this.sBuffer));
      ((PrintStream)localObject).println(localStringBuilder.toString());
      throw new RuntimeException(paramJceInputStream);
    }
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iVersion, 1);
    paramJceOutputStream.write(this.cPacketType, 2);
    paramJceOutputStream.write(this.iMessageType, 3);
    paramJceOutputStream.write(this.iRequestId, 4);
    paramJceOutputStream.write(this.sServantName, 5);
    paramJceOutputStream.write(this.sFuncName, 6);
    paramJceOutputStream.write(this.sBuffer, 7);
    paramJceOutputStream.write(this.iTimeout, 8);
    paramJceOutputStream.write(this.context, 9);
    paramJceOutputStream.write(this.status, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.taf.RequestPacket
 * JD-Core Version:    0.7.0.1
 */