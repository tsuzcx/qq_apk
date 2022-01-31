package com.tencent.component.network.utils.a.b;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

abstract class g<T, C, E extends e<T, C>>
{
  private final T a;
  private final Set<E> b;
  private final LinkedList<E> c;
  private final LinkedList<f<E>> d;
  
  g(T paramT)
  {
    this.a = paramT;
    this.b = new HashSet();
    this.c = new LinkedList();
    this.d = new LinkedList();
  }
  
  public final int a()
  {
    return this.c.size() + this.b.size();
  }
  
  protected abstract E a(C paramC);
  
  public final void a(E paramE, boolean paramBoolean)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    if (!this.b.remove(paramE)) {
      throw new IllegalStateException("Entry " + paramE + " has not been leased from this pool");
    }
    if (paramBoolean) {
      this.c.addFirst(paramE);
    }
  }
  
  public final void a(f<E> paramf)
  {
    if (paramf == null) {
      return;
    }
    this.d.add(paramf);
  }
  
  public final boolean a(E paramE)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    return (this.c.remove(paramE)) || (this.b.remove(paramE));
  }
  
  public final E b()
  {
    if (!this.c.isEmpty()) {
      return (e)this.c.getLast();
    }
    return null;
  }
  
  public final E b(Object paramObject)
  {
    Object localObject;
    if (!this.c.isEmpty())
    {
      if (paramObject != null)
      {
        localObject = this.c.iterator();
        if (((Iterator)localObject).hasNext()) {
          break label50;
        }
      }
      paramObject = this.c.iterator();
    }
    label50:
    do
    {
      if (!paramObject.hasNext())
      {
        return null;
        e locale = (e)((Iterator)localObject).next();
        if (!paramObject.equals(locale.h())) {
          break;
        }
        ((Iterator)localObject).remove();
        this.b.add(locale);
        return locale;
      }
      localObject = (e)paramObject.next();
    } while (((e)localObject).h() != null);
    paramObject.remove();
    this.b.add(localObject);
    return localObject;
  }
  
  public final void b(f<E> paramf)
  {
    if (paramf == null) {
      return;
    }
    this.d.remove(paramf);
  }
  
  public final E c(C paramC)
  {
    paramC = a(paramC);
    this.b.add(paramC);
    return paramC;
  }
  
  public final f<E> c()
  {
    return (f)this.d.poll();
  }
  
  public final void d()
  {
    Iterator localIterator = this.d.iterator();
    if (!localIterator.hasNext())
    {
      this.d.clear();
      localIterator = this.c.iterator();
      label32:
      if (localIterator.hasNext()) {
        break label94;
      }
      this.c.clear();
      localIterator = this.b.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.b.clear();
        return;
        ((f)localIterator.next()).cancel(true);
        break;
        label94:
        ((e)localIterator.next()).e();
        break label32;
      }
      ((e)localIterator.next()).e();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][leased: ");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.c.size());
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.d.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.b.g
 * JD-Core Version:    0.7.0.1
 */