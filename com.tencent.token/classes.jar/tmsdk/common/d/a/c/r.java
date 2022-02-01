package tmsdk.common.d.a.c;

import java.util.ArrayList;

public class r
  implements e
{
  private ArrayList a = new ArrayList();
  private int b = 0;
  private boolean c = false;
  
  public r()
  {
    this.c = false;
    this.a.add(new i("mazu.3g.qq.com", 443, 100));
    this.a.add(new i("mazu.3g.qq.com", 14000, 100));
    this.a.add(new i("mazu.3g.qq.com", 8080, 100));
    this.b = d();
  }
  
  public r(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (paramBoolean)
    {
      this.a.add(new i("mazutest.3g.qq.com", 8080, 100));
    }
    else
    {
      this.a.add(new i("mazu.3g.qq.com", 14000, 100));
      this.a.add(new i("mazu.3g.qq.com", 443, 100));
      this.a.add(new i("mazu.3g.qq.com", 8080, 100));
    }
    this.b = d();
  }
  
  private int d()
  {
    return 0;
  }
  
  private int e()
  {
    return (this.b + 1) % this.a.size();
  }
  
  public i a()
  {
    int i = this.b;
    if ((i >= 0) && (i < this.a.size()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ip ");
      localStringBuilder.append(((i)this.a.get(this.b)).b());
      localStringBuilder.append(" port : ");
      localStringBuilder.append(((i)this.a.get(this.b)).a());
      localStringBuilder.toString();
      return (i)this.a.get(this.b);
    }
    return (i)this.a.get(0);
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (this.c)
    {
      this.a.add(new i("mazutest.3g.qq.com", paramInt, 100));
      return;
    }
    this.a.add(new i("mazu.3g.qq.com", paramInt, 100));
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public void c()
  {
    this.b = e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.r
 * JD-Core Version:    0.7.0.1
 */