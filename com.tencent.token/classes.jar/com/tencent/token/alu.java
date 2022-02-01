package com.tencent.token;

public enum alu
{
  public final int l;
  
  private alu(int paramInt)
  {
    this.l = paramInt;
  }
  
  public static alu a(int paramInt)
  {
    alu[] arrayOfalu = values();
    int i1 = arrayOfalu.length;
    int n = 0;
    while (n < i1)
    {
      alu localalu = arrayOfalu[n];
      if (localalu.l == paramInt) {
        return localalu;
      }
      n += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alu
 * JD-Core Version:    0.7.0.1
 */