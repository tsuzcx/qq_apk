package com.tencent.token;

import java.util.List;

public class ap
{
  private az a;
  private bg b;
  private bf c;
  private List d;
  
  public az a()
  {
    return this.a;
  }
  
  public void a(az paramaz)
  {
    this.a = paramaz;
  }
  
  public void a(bf parambf)
  {
    this.c = parambf;
  }
  
  public void a(bg parambg)
  {
    this.b = parambg;
  }
  
  public void a(List paramList)
  {
    this.d = paramList;
  }
  
  public bg b()
  {
    return this.b;
  }
  
  public bf c()
  {
    return this.c;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder("accessInfo:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", sdkCfgInfo:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", sdkAccessInfo:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public List e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ap
 * JD-Core Version:    0.7.0.1
 */