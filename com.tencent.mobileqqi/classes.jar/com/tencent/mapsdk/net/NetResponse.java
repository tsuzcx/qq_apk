package com.tencent.mapsdk.net;

public class NetResponse
{
  public String charset = "GBK";
  public byte[] data;
  
  public String toString()
  {
    try
    {
      String str = new String(this.data, this.charset);
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.net.NetResponse
 * JD-Core Version:    0.7.0.1
 */