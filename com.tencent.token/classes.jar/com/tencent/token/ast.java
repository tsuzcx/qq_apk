package com.tencent.token;

import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ast
{
  public final Map<String, List<ani>> a;
  final Map<String, Object> b;
  public final Map<String, ane> c;
  public final Map<Integer, ann> d;
  public final List<ani> e;
  public final asz f;
  public final Rect g;
  public final long h;
  public final float i;
  private final Map<Long, ani> j;
  private final long k;
  private final float l;
  
  public final long a()
  {
    return ((float)(this.k - this.h) / this.l * 1000.0F);
  }
  
  public final ani a(long paramLong)
  {
    return (ani)this.j.get(Long.valueOf(paramLong));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f.a = paramBoolean;
  }
  
  public final float b()
  {
    return (float)a() * this.l / 1000.0F;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DoraemonComposition:\n");
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((ani)localIterator.next()).a("\t"));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ast
 * JD-Core Version:    0.7.0.1
 */