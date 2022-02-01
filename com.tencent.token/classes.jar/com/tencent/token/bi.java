package com.tencent.token;

import android.os.Handler;

public final class bi
{
  public final az a;
  private final Handler b;
  private a c;
  
  public bi(ay paramay)
  {
    this.a = new az(paramay);
    this.b = new Handler();
  }
  
  public final void a(av.a parama)
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
    final av.a a;
    private final az b;
    private boolean c = false;
    
    a(az paramaz, av.a parama)
    {
      this.b = paramaz;
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
 * Qualified Name:     com.tencent.token.bi
 * JD-Core Version:    0.7.0.1
 */