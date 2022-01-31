package taiji;

import java.util.ArrayList;
import java.util.List;

public class m
  implements cx, o
{
  private String a;
  private final List b = new ArrayList();
  private final cn.b c;
  private final n d;
  private final n e;
  private final n f;
  
  public m(bd parambd, cn paramcn)
  {
    this.a = paramcn.a();
    this.c = paramcn.b();
    this.d = paramcn.d().a();
    this.e = paramcn.c().a();
    this.f = paramcn.e().a();
    parambd.a(this.d);
    parambd.a(this.e);
    parambd.a(this.f);
    this.d.a(this);
    this.e.a(this);
    this.f.a(this);
  }
  
  public cn.b a()
  {
    return this.c;
  }
  
  public void a(List paramList1, List paramList2) {}
  
  void a(o paramo)
  {
    this.b.add(paramo);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.b.size())
    {
      ((o)this.b.get(i)).c();
      i += 1;
    }
  }
  
  public n d()
  {
    return this.d;
  }
  
  public n e()
  {
    return this.e;
  }
  
  public n f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.m
 * JD-Core Version:    0.7.0.1
 */