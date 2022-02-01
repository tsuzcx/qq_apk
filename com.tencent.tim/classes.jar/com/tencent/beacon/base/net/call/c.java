package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.BResponse;

public class c
  implements a<BResponse>
{
  private e a;
  
  public c(e parame)
  {
    this.a = parame;
  }
  
  public void a(Callback<BResponse> paramCallback)
  {
    com.tencent.beacon.base.net.c.c().a(this.a, new b(this, paramCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.call.c
 * JD-Core Version:    0.7.0.1
 */