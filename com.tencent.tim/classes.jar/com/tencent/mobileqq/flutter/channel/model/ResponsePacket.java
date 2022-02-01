package com.tencent.mobileqq.flutter.channel.model;

import ahge;
import java.util.Map;

public class ResponsePacket
{
  public byte[] body;
  public Integer errCode;
  public Boolean isSuc;
  public RequestPacket request;
  
  public static ResponsePacket fromMap(Map paramMap)
  {
    return (ResponsePacket)ahge.a(paramMap, ResponsePacket.class);
  }
  
  public static Map toMap(ResponsePacket paramResponsePacket)
  {
    return ahge.a(paramResponsePacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.model.ResponsePacket
 * JD-Core Version:    0.7.0.1
 */