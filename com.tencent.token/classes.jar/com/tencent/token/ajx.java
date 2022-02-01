package com.tencent.token;

public enum ajx
{
  public final int l;
  
  private ajx(int paramInt)
  {
    this.l = paramInt;
  }
  
  public static ajx a(int paramInt)
  {
    ajx[] arrayOfajx = values();
    int i1 = arrayOfajx.length;
    int n = 0;
    while (n < i1)
    {
      ajx localajx = arrayOfajx[n];
      if (localajx.l == paramInt) {
        return localajx;
      }
      n += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajx
 * JD-Core Version:    0.7.0.1
 */