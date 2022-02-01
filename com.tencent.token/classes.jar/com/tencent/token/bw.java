package com.tencent.token;

import android.os.Handler;

public final class bw
{
  public final bn a;
  private final Handler b;
  private a c;
  
  public bw(bm parambm)
  {
    this.a = new bn(parambm);
    this.b = new Handler();
  }
  
  public final void a(bj.a parama)
  {
    a locala = this.c;
    if (locala != null) {
      locala.run();
    }
    this.c = new a(this.a, parama);
    this.b.postAtFrontOfQueue(this.c);
  }
  
  static final class a
    implements Runnable
  {
    final bj.a a;
    private final bn b;
    private boolean c = false;
    
    a(bn parambn, bj.a parama)
    {
      this.b = parambn;
      this.a = parama;
    }
    
    public final void run()
    {
      if (!this.c)
      {
        this.b.a(this.a);
        this.c = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bw
 * JD-Core Version:    0.7.0.1
 */