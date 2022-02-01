package com.tencent.token;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class lc
  extends kz
{
  public lc(String paramString, Map paramMap, kz.a parama, boolean paramBoolean, lh paramlh)
  {
    this.q = paramlh;
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
      } while (!((kz.a)paramMap.next()).equals(parama));
      int i = 1;
      if (i == 0) {
        paramString.a.add(parama);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lc
 * JD-Core Version:    0.7.0.1
 */