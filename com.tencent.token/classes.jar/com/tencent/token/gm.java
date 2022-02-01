package com.tencent.token;

public class gm
{
  private float a;
  private int b;
  
  public void a(float paramFloat)
  {
    this.a += paramFloat;
    this.b += 1;
    if (this.b == 2147483647)
    {
      this.a /= 2.0F;
      this.b /= 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gm
 * JD-Core Version:    0.7.0.1
 */