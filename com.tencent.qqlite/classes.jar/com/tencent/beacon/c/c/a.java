package com.tencent.beacon.c.c;

import com.tencent.beacon.e.b;
import com.tencent.beacon.e.c;

public final class a
  extends c
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  
  public final void a(com.tencent.beacon.e.a parama)
  {
    this.a = parama.b(0, false);
    this.b = parama.b(1, false);
    this.c = parama.b(2, false);
    this.d = parama.b(3, false);
    this.e = parama.b(4, false);
  }
  
  public final void a(b paramb)
  {
    if (this.a != null) {
      paramb.a(this.a, 0);
    }
    if (this.b != null) {
      paramb.a(this.b, 1);
    }
    if (this.c != null) {
      paramb.a(this.c, 2);
    }
    if (this.d != null) {
      paramb.a(this.d, 3);
    }
    if (this.e != null) {
      paramb.a(this.e, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.c.c.a
 * JD-Core Version:    0.7.0.1
 */