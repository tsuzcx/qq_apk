package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.NetException;
import com.tencent.beacon.base.net.d;

class b
  implements Callback<BResponse>
{
  b(c paramc, Callback paramCallback) {}
  
  public void a(BResponse paramBResponse)
    throws NetException
  {
    Callback localCallback = this.a;
    if (localCallback != null) {
      localCallback.onResponse(paramBResponse);
    }
  }
  
  public void onFailure(d paramd)
  {
    Callback localCallback = this.a;
    if (localCallback != null) {
      localCallback.onFailure(paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.call.b
 * JD-Core Version:    0.7.0.1
 */