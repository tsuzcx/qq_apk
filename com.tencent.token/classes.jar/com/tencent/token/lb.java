package com.tencent.token;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class lb
  extends ky
{
  public lb(String paramString, Map paramMap, ky.a parama, boolean paramBoolean, lg paramlg)
  {
    this.q = paramlg;
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
      } while (!((ky.a)paramMap.next()).equals(parama));
      int i = 1;
      if (i == 0) {
        paramString.a.add(parama);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lb
 * JD-Core Version:    0.7.0.1
 */