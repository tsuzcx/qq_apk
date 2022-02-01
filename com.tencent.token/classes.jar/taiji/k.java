package taiji;

import java.util.ArrayList;
import java.util.List;

public class k
  implements br, l.a
{
  private String a;
  private final List<l.a> b = new ArrayList();
  private final cn.b c;
  private final l<?, Float> d;
  private final l<?, Float> e;
  private final l<?, Float> f;
  
  public k(ar paramar, cn paramcn)
  {
    this.a = paramcn.a();
    this.c = paramcn.b();
    this.d = paramcn.d().a();
    this.e = paramcn.c().a();
    this.f = paramcn.e().a();
    paramar.a(this.d);
    paramar.a(this.e);
    paramar.a(this.f);
    this.d.a(this);
    this.e.a(this);
    this.f.a(this);
  }
  
  public cn.b a()
  {
    return this.c;
  }
  
  public void a(List<br> paramList1, List<br> paramList2) {}
  
  void a(l.a parama)
  {
    this.b.add(parama);
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
      ((l.a)this.b.get(i)).c();
      i += 1;
    }
  }
  
  public l<?, Float> d()
  {
    return this.d;
  }
  
  public l<?, Float> e()
  {
    return this.e;
  }
  
  public l<?, Float> f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.k
 * JD-Core Version:    0.7.0.1
 */