package com.tencent.token.global;

import java.util.Comparator;

public class g
  implements Comparator
{
  public int a(m paramm1, m paramm2)
  {
    if (paramm2.c().equals("#")) {
      return -1;
    }
    if (paramm1.c().equals("#")) {
      return 1;
    }
    return paramm1.c().compareTo(paramm2.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.g
 * JD-Core Version:    0.7.0.1
 */