package com.tencent.token.global;

import java.util.Comparator;

public class f
  implements Comparator<j>
{
  public int a(j paramj1, j paramj2)
  {
    if (paramj2.c().equals("#")) {
      return -1;
    }
    if (paramj1.c().equals("#")) {
      return 1;
    }
    return paramj1.c().compareTo(paramj2.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.f
 * JD-Core Version:    0.7.0.1
 */