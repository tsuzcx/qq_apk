package com.huawei.hms.api;

import java.util.List;

public class ProtocolNegotiate
{
  private static ProtocolNegotiate a = new ProtocolNegotiate();
  private int b = 1;
  
  public static ProtocolNegotiate getInstance()
  {
    return a;
  }
  
  public int getVersion()
  {
    return this.b;
  }
  
  public int negotiate(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.b = 1;
      return this.b;
    }
    if (!paramList.contains(Integer.valueOf(2))) {}
    for (this.b = ((Integer)paramList.get(paramList.size() - 1)).intValue();; this.b = 2) {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.api.ProtocolNegotiate
 * JD-Core Version:    0.7.0.1
 */