package com.tencent.token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum aiu
{
  final String f;
  
  private aiu(String paramString)
  {
    this.f = paramString;
  }
  
  public static aiu a(String paramString)
  {
    int i = paramString.hashCode();
    if (i != 79201641)
    {
      if (i != 79923350)
      {
        switch (i)
        {
        default: 
          break;
        case -503070501: 
          if (!paramString.equals("TLSv1.3")) {
            break;
          }
          i = 0;
          break;
        case -503070502: 
          if (!paramString.equals("TLSv1.2")) {
            break;
          }
          i = 1;
          break;
        case -503070503: 
          if (!paramString.equals("TLSv1.1")) {
            break;
          }
          i = 2;
          break;
        }
      }
      else if (paramString.equals("TLSv1"))
      {
        i = 3;
        break label119;
      }
    }
    else if (paramString.equals("SSLv3"))
    {
      i = 4;
      break label119;
    }
    i = -1;
    switch (i)
    {
    default: 
      throw new IllegalArgumentException("Unexpected TLS version: ".concat(String.valueOf(paramString)));
    case 4: 
      return e;
    case 3: 
      return d;
    case 2: 
      return c;
    case 1: 
      label119:
      return b;
    }
    return a;
  }
  
  static List<aiu> a(String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramVarArgs[i]));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aiu
 * JD-Core Version:    0.7.0.1
 */