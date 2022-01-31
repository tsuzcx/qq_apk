package com.tencent.component.network.module.cache;

import com.tencent.component.network.module.cache.a.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

final class b
  implements e.a
{
  public final Collection<com.tencent.component.network.module.cache.a.b> a()
  {
    synchronized ()
    {
      if (a.b().size() <= 0)
      {
        localObject1 = null;
        return localObject1;
      }
      Object localObject1 = new ArrayList(a.b().values());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.cache.b
 * JD-Core Version:    0.7.0.1
 */