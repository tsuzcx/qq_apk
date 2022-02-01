package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.c;
import java.util.Date;

public class j
  implements a<byte[]>
{
  private final JceRequestEntity a;
  private long b;
  
  public j(JceRequestEntity paramJceRequestEntity)
  {
    this.a = paramJceRequestEntity;
  }
  
  public void a(Callback<byte[]> paramCallback)
  {
    com.tencent.beacon.a.b.a.a().a(new g(this, paramCallback));
  }
  
  public void a(Callback<byte[]> paramCallback, com.tencent.beacon.a.b.a parama)
  {
    parama.a(new h(this, paramCallback));
  }
  
  public void b(Callback<byte[]> paramCallback)
  {
    this.b = new Date().getTime();
    c.c().a(this.a, new i(this, paramCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.call.j
 * JD-Core Version:    0.7.0.1
 */