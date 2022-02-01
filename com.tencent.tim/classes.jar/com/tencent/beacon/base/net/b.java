package com.tencent.beacon.base.net;

import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.e;

class b
  implements Callback<BResponse>
{
  b(c paramc, e parame, Callback paramCallback) {}
  
  public void a(BResponse paramBResponse)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder = localStringBuilder.append("httpRequest: ").append(this.a.h());
      com.tencent.beacon.base.util.c.a("[BeaconNet]", " request success!", new Object[0]);
      this.b.onResponse(paramBResponse);
      c.a(this.c);
      return;
    }
    catch (Exception paramBResponse)
    {
      onFailure(new d(this.a.h(), "453", 200, paramBResponse.getMessage(), paramBResponse));
    }
  }
  
  public void onFailure(d paramd)
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "httpRequest: " + paramd.toString(), new Object[0]);
    this.c.a(paramd);
    this.b.onFailure(paramd);
    c.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.b
 * JD-Core Version:    0.7.0.1
 */