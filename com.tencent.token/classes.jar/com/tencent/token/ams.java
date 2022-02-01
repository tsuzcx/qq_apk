package com.tencent.token;

public enum ams
{
  public final int l;
  
  private ams(int paramInt)
  {
    this.l = paramInt;
  }
  
  public static ams a(int paramInt)
  {
    ams[] arrayOfams = values();
    int i1 = arrayOfams.length;
    int n = 0;
    while (n < i1)
    {
      ams localams = arrayOfams[n];
      if (localams.l == paramInt) {
        return localams;
      }
      n += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ams
 * JD-Core Version:    0.7.0.1
 */