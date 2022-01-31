package com.qq.jce.wup;

import com.qq.taf.RequestPacket;
import java.util.HashMap;
import java.util.Map;

public class TafUniPacket
  extends UniPacket
{
  private static final long serialVersionUID = 1L;
  
  public TafUniPacket()
  {
    this._package.iVersion = 2;
    this._package.cPacketType = 0;
    this._package.iMessageType = 0;
    this._package.iTimeout = 0;
    this._package.sBuffer = new byte[0];
    this._package.context = new HashMap();
    this._package.status = new HashMap();
  }
  
  public byte[] getTafBuffer()
  {
    return this._package.sBuffer;
  }
  
  public Map<String, String> getTafContext()
  {
    return this._package.context;
  }
  
  public int getTafMessageType()
  {
    return this._package.iMessageType;
  }
  
  public byte getTafPacketType()
  {
    return this._package.cPacketType;
  }
  
  public int getTafResultCode()
  {
    String str = (String)this._package.status.get("STATUS_RESULT_CODE");
    if (str != null) {
      return Integer.parseInt(str);
    }
    return 0;
  }
  
  public String getTafResultDesc()
  {
    String str = (String)this._package.status.get("STATUS_RESULT_DESC");
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public Map<String, String> getTafStatus()
  {
    return this._package.status;
  }
  
  public int getTafTimeout()
  {
    return this._package.iTimeout;
  }
  
  public short getTafVersion()
  {
    return this._package.iVersion;
  }
  
  public void setTafBuffer(byte[] paramArrayOfByte)
  {
    this._package.sBuffer = paramArrayOfByte;
  }
  
  public void setTafContext(Map<String, String> paramMap)
  {
    this._package.context = paramMap;
  }
  
  public void setTafMessageType(int paramInt)
  {
    this._package.iMessageType = paramInt;
  }
  
  public void setTafPacketType(byte paramByte)
  {
    this._package.cPacketType = paramByte;
  }
  
  public void setTafStatus(Map<String, String> paramMap)
  {
    this._package.status = paramMap;
  }
  
  public void setTafTimeout(int paramInt)
  {
    this._package.iTimeout = paramInt;
  }
  
  public void setTafVersion(short paramShort)
  {
    this._package.iVersion = paramShort;
    if (paramShort == 3) {
      useVersion3();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.qq.jce.wup.TafUniPacket
 * JD-Core Version:    0.7.0.1
 */