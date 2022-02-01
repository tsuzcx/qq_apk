package com.tencent.token;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ahg
  implements ahk, Cloneable
{
  public static final ahg a = new ahg();
  public List<aha> b = Collections.emptyList();
  public List<aha> c = Collections.emptyList();
  
  public static boolean a(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }
  
  public final <T> ahh<T> a(final ahx paramahx, final aek<T> paramaek)
  {
    boolean bool2 = a(paramaek.a);
    int i = 0;
    final boolean bool1;
    if ((!bool2) && (!a(true))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if ((bool2) || (a(false))) {
      i = 1;
    }
    if ((!bool1) && (i == 0)) {
      return null;
    }
    return new a(bool1, paramahx, paramaek);
  }
  
  public final boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = this.b;
    } else {
      localObject = this.c;
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((aha)((Iterator)localObject).next()).b()) {
        return true;
      }
    }
    return false;
  }
  
  public final Object clone()
  {
    try
    {
      ahg localahg = (ahg)super.clone();
      return localahg;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final class a
    extends ahh<T>
  {
    public ahh<T> a;
    
    public a(boolean paramBoolean, ahx paramahx, aek paramaek) {}
    
    public final void a(aep paramaep, T paramT)
    {
      if (bool1)
      {
        paramaep.e();
        return;
      }
      ahh localahh2 = this.a;
      ahh localahh1 = localahh2;
      if (localahh2 == null)
      {
        localahh1 = paramahx.a(ahg.this, paramaek);
        this.a = localahh1;
      }
      localahh1.a(paramaep, paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahg
 * JD-Core Version:    0.7.0.1
 */