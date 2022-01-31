package com.tencent.upload.network.base;

public class TcpConnection
  extends Connection
{
  public TcpConnection(IConnectionCallback paramIConnectionCallback)
  {
    super(paramIConnectionCallback);
  }
  
  public int getProtocolCategory()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.network.base.TcpConnection
 * JD-Core Version:    0.7.0.1
 */