package com.tencent.token;

public final class avc
{
  private float a;
  private int b;
  
  public final void a(float paramFloat)
  {
    this.a += paramFloat;
    this.b += 1;
    int i = this.b;
    if (i == 2147483647)
    {
      this.a /= 2.0F;
      this.b = (i / 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.avc
 * JD-Core Version:    0.7.0.1
 */