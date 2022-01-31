package com.tencent.component.network.module.a;

import java.util.Comparator;

public final class b
{
  private static final Comparator<b> d = new c();
  private int a;
  private int b = 0;
  private final com.tencent.component.network.module.a.a.b<b> c = new com.tencent.component.network.module.a.a.b(d);
  
  public static b a()
  {
    return a.a;
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 < 51200L) {
      return;
    }
    b localb1 = new b();
    localb1.a = paramLong1;
    if (paramLong2 < paramLong3)
    {
      paramLong1 = paramLong2;
      localb1.b = paramLong1;
      if (paramLong2 <= paramLong3) {
        break label184;
      }
      label46:
      localb1.c = paramLong2;
    }
    for (;;)
    {
      synchronized (this.c)
      {
        this.c.add(localb1);
        this.a += 1;
        i = this.b;
        this.b = (i + 1);
        if (i >= 2) {
          break label190;
        }
        i = 0;
        if (i != 0)
        {
          i = this.c.size();
          if (i >= 5) {
            break label247;
          }
          if (i > 0)
          {
            localb1 = (b)this.c.get(i - 1);
            paramLong1 = localb1.b;
            paramLong1 = localb1.c;
            i -= 1;
            break label239;
          }
        }
        return;
      }
      paramLong1 = paramLong3;
      break;
      label184:
      paramLong2 = paramLong3;
      break label46;
      label190:
      this.b = 0;
      int i = 1;
      continue;
      label239:
      do
      {
        b localb2 = (b)this.c.get(i);
        paramLong1 = localb2.a;
        paramLong1 = localb2.b;
        paramLong1 = localb2.c;
        i -= 1;
      } while (i >= 0);
      continue;
      label247:
      i = 5;
    }
  }
  
  static final class a
  {
    static final b a = new b((byte)0);
  }
  
  static final class b
  {
    long a;
    long b;
    long c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.a.b
 * JD-Core Version:    0.7.0.1
 */