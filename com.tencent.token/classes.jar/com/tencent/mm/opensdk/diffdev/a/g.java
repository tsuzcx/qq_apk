package com.tencent.mm.opensdk.diffdev.a;

public enum g
{
  private int code;
  
  private g(int paramInt)
  {
    this.code = paramInt;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("UUIDStatusCode:");
    localStringBuilder.append(this.code);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.g
 * JD-Core Version:    0.7.0.1
 */