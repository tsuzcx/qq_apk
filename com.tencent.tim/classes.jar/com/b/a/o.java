package com.b.a;

public final class o<T>
{
  public final T a;
  public final b.a b;
  public final t c;
  public boolean d = false;
  
  private o(t paramt)
  {
    this.a = null;
    this.b = null;
    this.c = paramt;
  }
  
  private o(T paramT, b.a parama)
  {
    this.a = paramT;
    this.b = parama;
    this.c = null;
  }
  
  public static <T> o<T> a(t paramt)
  {
    return new o(paramt);
  }
  
  public static <T> o<T> a(T paramT, b.a parama)
  {
    return new o(paramT, parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(t paramt);
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.b.a.o
 * JD-Core Version:    0.7.0.1
 */