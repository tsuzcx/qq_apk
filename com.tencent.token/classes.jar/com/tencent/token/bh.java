package com.tencent.token;

import java.util.HashMap;
import java.util.Map;

public final class bh
{
  private String a;
  private Map b;
  
  public bh(String paramString)
  {
    this.a = paramString;
    this.b = new HashMap();
  }
  
  public final bi a(String paramString)
  {
    return (bi)this.b.get(paramString);
  }
  
  public final Map a()
  {
    return this.b;
  }
  
  public final void a(bi parambi)
  {
    this.b.put(bi.a(parambi), parambi);
  }
  
  public final String b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bh
 * JD-Core Version:    0.7.0.1
 */