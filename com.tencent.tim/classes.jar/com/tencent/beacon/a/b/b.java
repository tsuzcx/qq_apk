package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.util.c;

class b
  implements Callback<BResponse>
{
  b(d paramd) {}
  
  public void a(BResponse paramBResponse)
  {
    c.a("AttaReport", "net ret: " + paramBResponse.toString(), new Object[0]);
  }
  
  public void onFailure(com.tencent.beacon.base.net.d paramd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.b.b
 * JD-Core Version:    0.7.0.1
 */