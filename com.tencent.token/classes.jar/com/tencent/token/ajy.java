package com.tencent.token;

public enum ajy
{
  public final int l;
  
  private ajy(int paramInt)
  {
    this.l = paramInt;
  }
  
  public static ajy a(int paramInt)
  {
    ajy[] arrayOfajy = values();
    int i1 = arrayOfajy.length;
    int n = 0;
    while (n < i1)
    {
      ajy localajy = arrayOfajy[n];
      if (localajy.l == paramInt) {
        return localajy;
      }
      n += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajy
 * JD-Core Version:    0.7.0.1
 */