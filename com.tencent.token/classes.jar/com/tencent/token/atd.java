package com.tencent.token;

import java.util.ArrayList;

public final class atd
  implements ast
{
  public ArrayList a = new ArrayList();
  int b = 0;
  private boolean c = false;
  
  public atd()
  {
    this.c = false;
    this.a.add(new asv("mazu.3g.qq.com", 443, 100));
    this.a.add(new asv("mazu.3g.qq.com", 14000, 100));
    this.a.add(new asv("mazu.3g.qq.com", 8080, 100));
    this.b = 0;
  }
  
  public atd(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (paramBoolean)
    {
      this.a.add(new asv("mazutest.3g.qq.com", 8080, 100));
    }
    else
    {
      this.a.add(new asv("mazu.3g.qq.com", 14000, 100));
      this.a.add(new asv("mazu.3g.qq.com", 443, 100));
      this.a.add(new asv("mazu.3g.qq.com", 8080, 100));
    }
    this.b = 0;
  }
  
  public final asv a()
  {
    int i = this.b;
    if ((i >= 0) && (i < this.a.size()))
    {
      StringBuilder localStringBuilder = new StringBuilder("ip ");
      localStringBuilder.append(((asv)this.a.get(this.b)).b);
      localStringBuilder.append(" port : ");
      localStringBuilder.append(((asv)this.a.get(this.b)).a);
      return (asv)this.a.get(this.b);
    }
    return (asv)this.a.get(0);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (this.c)
    {
      this.a.add(new asv("mazutest.3g.qq.com", paramInt, 100));
      return;
    }
    this.a.add(new asv("mazu.3g.qq.com", paramInt, 100));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.atd
 * JD-Core Version:    0.7.0.1
 */