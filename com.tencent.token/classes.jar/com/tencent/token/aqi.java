package com.tencent.token;

public final class aqi
{
  final float a;
  final float b;
  
  public aqi()
  {
    this(1.0F, 1.0F);
  }
  
  public aqi(float paramFloat1, float paramFloat2)
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
 * Qualified Name:     com.tencent.token.aqi
 * JD-Core Version:    0.7.0.1
 */