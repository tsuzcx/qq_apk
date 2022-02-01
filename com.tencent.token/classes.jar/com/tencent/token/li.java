package com.tencent.token;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class li
  extends lf
{
  public li(String paramString, Map paramMap, lf.a parama, boolean paramBoolean, ln paramln)
  {
    this.q = paramln;
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
      } while (!((lf.a)paramMap.next()).equals(parama));
      int i = 1;
      if (i == 0) {
        paramString.a.add(parama);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.li
 * JD-Core Version:    0.7.0.1
 */