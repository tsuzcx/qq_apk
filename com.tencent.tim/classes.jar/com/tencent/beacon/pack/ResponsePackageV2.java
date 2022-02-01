package com.tencent.beacon.pack;

import com.tencent.beacon.base.util.c;

public final class ResponsePackageV2
  extends AbstractResponseCommon
  implements Cloneable
{
  public String msg = "";
  public int result = 0;
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      c.a(localCloneNotSupportedException);
    }
    return null;
  }
  
  public void readFrom(a parama)
  {
    this.result = parama.a(this.result, 0, true);
    this.srcGatewayIp = parama.a(1, true);
    this.serverTime = parama.a(this.serverTime, 2, true);
    this.msg = parama.a(3, true);
  }
  
  public void writeTo(b paramb)
  {
    paramb.a(this.result, 0);
    paramb.a(this.srcGatewayIp, 1);
    paramb.a(this.serverTime, 2);
    paramb.a(this.msg, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.pack.ResponsePackageV2
 * JD-Core Version:    0.7.0.1
 */