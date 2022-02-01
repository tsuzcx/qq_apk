package com.tencent.token;

import java.util.List;

public class aq
{
  private ba a;
  private bh b;
  private bg c;
  private List d;
  
  public ba a()
  {
    return this.a;
  }
  
  public void a(ba paramba)
  {
    this.a = paramba;
  }
  
  public void a(bg parambg)
  {
    this.c = parambg;
  }
  
  public void a(bh parambh)
  {
    this.b = parambh;
  }
  
  public void a(List paramList)
  {
    this.d = paramList;
  }
  
  public bh b()
  {
    return this.b;
  }
  
  public bg c()
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
 * Qualified Name:     com.tencent.token.aq
 * JD-Core Version:    0.7.0.1
 */