package com.tencent.token;

public final class ano
{
  final float a;
  final float b;
  
  public ano()
  {
    this(1.0F, 1.0F);
  }
  
  public ano(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("x");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ano
 * JD-Core Version:    0.7.0.1
 */