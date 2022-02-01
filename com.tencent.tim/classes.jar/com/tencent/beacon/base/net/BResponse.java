package com.tencent.beacon.base.net;

import java.util.List;
import java.util.Map;

public class BResponse
{
  public byte[] body;
  public int code;
  public Map<String, List<String>> headers;
  public String msg;
  
  public BResponse(Map<String, List<String>> paramMap, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.headers = paramMap;
    this.code = paramInt;
    this.msg = paramString;
    this.body = paramArrayOfByte;
  }
  
  public String toString()
  {
    return "BResponse{code=" + this.code + ", msg='" + this.msg + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.BResponse
 * JD-Core Version:    0.7.0.1
 */