package com.tencent.token;

import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class avq
{
  public final Map<String, List<aqc>> a;
  final Map<String, Object> b;
  public final Map<String, apy> c;
  public final Map<Integer, aqh> d;
  public final List<aqc> e;
  public final avw f;
  public final Rect g;
  public final long h;
  public final float i;
  private final Map<Long, aqc> j;
  private final long k;
  private final float l;
  
  public final long a()
  {
    return ((float)(this.k - this.h) / this.l * 1000.0F);
  }
  
  public final aqc a(long paramLong)
  {
    return (aqc)this.j.get(Long.valueOf(paramLong));
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
      localStringBuilder.append(((aqc)localIterator.next()).a("\t"));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.avq
 * JD-Core Version:    0.7.0.1
 */