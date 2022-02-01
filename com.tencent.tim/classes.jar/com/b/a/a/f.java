package com.b.a.a;

import com.a.b;
import com.a.c;
import com.a.d;
import com.a.g;
import com.a.i;
import com.a.k;
import com.a.l;
import com.b.a.a;
import com.b.a.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class f
{
  public abstract e a(m<?> paramm, Map<String, String> paramMap)
    throws IOException, a;
  
  public k b(m<?> paramm, Map<String, String> paramMap)
    throws IOException, a
  {
    paramm = a(paramm, paramMap);
    paramMap = new d(new com.a.e(new l("HTTP", 1, 1), paramm.a(), ""));
    Object localObject1 = new ArrayList();
    Object localObject2 = paramm.b().entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      Iterator localIterator = ((List)localEntry.getValue()).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((List)localObject1).add(new b((String)localEntry.getKey(), str));
      }
    }
    paramMap.a((g[])((List)localObject1).toArray(new g[((List)localObject1).size()]));
    localObject1 = paramm.d();
    if (localObject1 != null)
    {
      localObject2 = new c();
      ((c)localObject2).a((InputStream)localObject1);
      ((c)localObject2).a(paramm.c());
      paramMap.a((i)localObject2);
    }
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */