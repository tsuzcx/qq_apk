package com.tencent.token;

import java.util.ArrayList;

public final class arg
  implements aqw
{
  public ArrayList a = new ArrayList();
  int b = 0;
  private boolean c = false;
  
  public arg()
  {
    this.c = false;
    this.a.add(new aqy("mazu.3g.qq.com", 443, 100));
    this.a.add(new aqy("mazu.3g.qq.com", 14000, 100));
    this.a.add(new aqy("mazu.3g.qq.com", 8080, 100));
    this.b = 0;
  }
  
  public arg(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (paramBoolean)
    {
      this.a.add(new aqy("mazutest.3g.qq.com", 8080, 100));
    }
    else
    {
      this.a.add(new aqy("mazu.3g.qq.com", 14000, 100));
      this.a.add(new aqy("mazu.3g.qq.com", 443, 100));
      this.a.add(new aqy("mazu.3g.qq.com", 8080, 100));
    }
    this.b = 0;
  }
  
  public final aqy a()
  {
    int i = this.b;
    if ((i >= 0) && (i < this.a.size()))
    {
      StringBuilder localStringBuilder = new StringBuilder("ip ");
      localStringBuilder.append(((aqy)this.a.get(this.b)).b);
      localStringBuilder.append(" port : ");
      localStringBuilder.append(((aqy)this.a.get(this.b)).a);
      return (aqy)this.a.get(this.b);
    }
    return (aqy)this.a.get(0);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (this.c)
    {
      this.a.add(new aqy("mazutest.3g.qq.com", paramInt, 100));
      return;
    }
    this.a.add(new aqy("mazu.3g.qq.com", paramInt, 100));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.arg
 * JD-Core Version:    0.7.0.1
 */