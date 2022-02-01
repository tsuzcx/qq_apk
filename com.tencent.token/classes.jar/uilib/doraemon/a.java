package uilib.doraemon;

import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import taiji.aq;
import taiji.ay;
import taiji.cs;

public class a
{
  private final Map<String, List<cs>> a;
  private final Map<String, b> b;
  private final Map<String, aq> c;
  private final Map<Integer, ay> d;
  private final Map<Long, cs> e;
  private final List<cs> f;
  private final h g;
  private final Rect h;
  private final long i;
  private final long j;
  private final float k;
  private final float l;
  
  public List<cs> a(String paramString)
  {
    return (List)this.a.get(paramString);
  }
  
  public cs a(long paramLong)
  {
    return (cs)this.e.get(Long.valueOf(paramLong));
  }
  
  public h a()
  {
    return this.g;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g.a(paramBoolean);
  }
  
  public Rect b()
  {
    return this.h;
  }
  
  public long c()
  {
    return ((float)(this.j - this.i) / this.k * 1000.0F);
  }
  
  public long d()
  {
    return this.i;
  }
  
  public List<cs> e()
  {
    return this.f;
  }
  
  public Map<Integer, ay> f()
  {
    return this.d;
  }
  
  public Map<String, aq> g()
  {
    return this.c;
  }
  
  public Map<String, b> h()
  {
    return this.b;
  }
  
  public float i()
  {
    return (float)c() * this.k / 1000.0F;
  }
  
  public float j()
  {
    return this.l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DoraemonComposition:\n");
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((cs)localIterator.next()).a("\t"));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.a
 * JD-Core Version:    0.7.0.1
 */