package com.tencent.token;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class lw
  extends lt
{
  public lw(String paramString, Map paramMap, lt.a parama, boolean paramBoolean, mb parammb)
  {
    this.q = parammb;
    this.a = paramString;
    this.d = paramMap;
    this.g = paramBoolean;
    if (parama != null)
    {
      paramString = this.c;
      int j = 0;
      paramMap = paramString.a.iterator();
      do
      {
        i = j;
        if (!paramMap.hasNext()) {
          break;
        }
      } while (!((lt.a)paramMap.next()).equals(parama));
      int i = 1;
      if (i == 0) {
        paramString.a.add(parama);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lw
 * JD-Core Version:    0.7.0.1
 */