package com.b.a;

public class q
{
  private int a = 2500;
  private int b;
  private final int c = 1;
  private final float d = 1.0F;
  
  public q()
  {
    this(2500, 1, 1.0F);
  }
  
  public q(int paramInt1, int paramInt2, float paramFloat) {}
  
  public int a()
  {
    return this.a;
  }
  
  public void a(t paramt)
    throws t
  {
    this.b += 1;
    this.a = ((int)(this.a + this.a * this.d));
    if (!c()) {
      throw paramt;
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  protected boolean c()
  {
    return this.b <= this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.b.a.q
 * JD-Core Version:    0.7.0.1
 */