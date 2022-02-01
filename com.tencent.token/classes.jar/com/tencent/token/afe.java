package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.qps.Grape;

public final class afe
{
  public int a;
  public long b;
  public Context c;
  public int d;
  public Grape e;
  public afa f;
  
  public afe(a parama)
  {
    this.a = parama.a;
    this.b = (parama.b * afg.a);
    this.c = parama.c;
    this.f = parama.d;
    this.d = parama.e;
    this.e = parama.f;
  }
  
  public static final class a
  {
    public int a = 0;
    public long b = 6L;
    public Context c;
    public afa d;
    public int e = 0;
    public Grape f = new Grape();
    
    public a(Context paramContext, int paramInt)
    {
      if (paramInt >= 0)
      {
        this.c = paramContext.getApplicationContext();
        this.a = paramInt;
        return;
      }
      throw new IllegalArgumentException("scenes invalid: ".concat(String.valueOf(paramInt)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afe
 * JD-Core Version:    0.7.0.1
 */