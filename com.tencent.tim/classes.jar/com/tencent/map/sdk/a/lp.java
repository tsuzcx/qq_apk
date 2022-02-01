package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class lp
  implements ky
{
  private static AtomicInteger b = new AtomicInteger(1);
  public pn a;
  private Map<String, lo> c;
  
  public final void a(String paramString)
  {
    paramString = (lo)this.c.get(paramString);
    if ((paramString != null) && (paramString.a != null))
    {
      Iterator localIterator = paramString.a.iterator();
      while (localIterator.hasNext())
      {
        Marker localMarker = (Marker)localIterator.next();
        if (localMarker != null) {
          localMarker.remove();
        }
      }
      paramString.a.clear();
    }
    this.a.s();
  }
  
  public final void a(String paramString, Marker paramMarker)
  {
    paramString = (lo)this.c.get(paramString);
    if (paramString != null) {
      paramString.a(paramMarker);
    }
    this.a.s();
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = (lo)this.c.get(paramString1);
    if ((paramString1 != null) && (paramString1.b != null))
    {
      paramString2 = paramString1.b.b(paramString2);
      if (paramString2 != null) {
        paramString1.a(paramString2);
      }
    }
    this.a.s();
  }
  
  public final void a(String paramString, List<Marker> paramList)
  {
    paramString = (lo)this.c.get(paramString);
    if ((paramString != null) && (paramString.a != null) && (paramList != null)) {
      paramString.a.addAll(paramList);
    }
    this.a.s();
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    paramString = (lo)this.c.get(paramString);
    if ((paramString != null) && (paramString.b != null)) {
      paramString.b.b = paramBoolean;
    }
    this.a.s();
  }
  
  public final boolean a(String paramString1, String paramString2, MarkerOptions paramMarkerOptions)
  {
    boolean bool2 = false;
    paramString1 = (lo)this.c.get(paramString1);
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!nl.a(paramString2))
      {
        if (paramMarkerOptions != null) {
          break label54;
        }
        bool1 = bool2;
      }
    }
    label54:
    do
    {
      this.a.s();
      return bool1;
      bool1 = bool2;
    } while (paramString1.a == null);
    paramString1 = paramString1.a.iterator();
    while (paramString1.hasNext())
    {
      Marker localMarker = (Marker)paramString1.next();
      if ((localMarker != null) && (localMarker.getId().equals(paramString2))) {
        localMarker.setMarkerOptions(paramMarkerOptions);
      }
    }
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
  
  public final List<Marker> b(String paramString)
  {
    paramString = (lo)this.c.get(paramString);
    if (paramString != null)
    {
      if (paramString.a != null) {
        return paramString.a;
      }
      return null;
    }
    return null;
  }
  
  public final boolean b(String paramString, Marker paramMarker)
  {
    boolean bool = true;
    paramString = (lo)this.c.get(paramString);
    if (paramString != null) {
      if (paramMarker != null) {}
    }
    for (;;)
    {
      this.a.s();
      return bool;
      if (paramString.a != null)
      {
        Iterator localIterator = paramString.a.iterator();
        while (localIterator.hasNext())
        {
          Marker localMarker = (Marker)localIterator.next();
          if ((localMarker != null) && (localMarker == paramMarker))
          {
            paramString.a.remove(paramMarker);
            paramMarker.remove();
          }
        }
      }
      for (bool = true;; bool = false) {
        break;
      }
      bool = false;
    }
  }
  
  public final boolean b(String paramString1, String paramString2)
  {
    paramString1 = (lo)this.c.get(paramString1);
    boolean bool;
    if (paramString1 != null) {
      if (nl.a(paramString2)) {
        bool = true;
      }
    }
    for (;;)
    {
      this.a.s();
      return bool;
      int i;
      if (paramString1.a != null)
      {
        int j = paramString1.a.size();
        i = 0;
        label58:
        if (i >= j) {
          break label146;
        }
        if ((paramString1.a.get(i) == null) || (!((Marker)paramString1.a.get(i)).getId().equals(paramString2))) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          ((Marker)paramString1.a.remove(i)).remove();
          bool = true;
          break;
          i += 1;
          break label58;
        }
        bool = false;
        break;
        bool = false;
        break;
        label146:
        i = -1;
      }
      bool = false;
    }
  }
  
  public final Marker c(String paramString1, String paramString2)
  {
    paramString1 = (lo)this.c.get(paramString1);
    int i;
    if (paramString1 != null) {
      if ((!nl.a(paramString2)) && (paramString1.a != null))
      {
        int j = paramString1.a.size();
        i = 0;
        if (i >= j) {
          break label119;
        }
        if ((paramString1.a.get(i) == null) || (!((Marker)paramString1.a.get(i)).getId().equals(paramString2))) {}
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        return (Marker)paramString1.a.get(i);
        i += 1;
        break;
      }
      return null;
      return null;
      return null;
      label119:
      i = -1;
    }
  }
  
  public final List<String> c(String paramString)
  {
    Object localObject = (lo)this.c.get(paramString);
    if (localObject != null)
    {
      if (((lo)localObject).a != null)
      {
        paramString = new ArrayList(((lo)localObject).a.size());
        localObject = ((lo)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Marker localMarker = (Marker)((Iterator)localObject).next();
          if (localMarker != null) {
            paramString.add(localMarker.getId());
          }
        }
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public final boolean c(String paramString, Marker paramMarker)
  {
    paramString = (lo)this.c.get(paramString);
    if (paramString != null)
    {
      if ((paramMarker != null) && (paramString.a != null)) {
        return paramString.a.contains(paramMarker);
      }
      return false;
    }
    return false;
  }
  
  public final void d(String paramString)
  {
    this.c.get(paramString);
    this.a.s();
  }
  
  public final boolean d(String paramString, Marker paramMarker)
  {
    paramString = (lo)this.c.get(paramString);
    boolean bool;
    if (paramString != null) {
      if ((paramMarker != null) && (paramString.a != null))
      {
        paramString = paramString.a.iterator();
        while (paramString.hasNext())
        {
          Marker localMarker = (Marker)paramString.next();
          if ((localMarker != null) && (localMarker == paramMarker)) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      this.a.s();
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final boolean d(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    paramString1 = (lo)this.c.get(paramString1);
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!nl.a(paramString2))
      {
        bool1 = bool2;
        if (paramString1.a != null)
        {
          paramString1 = paramString1.a.iterator();
          Marker localMarker;
          do
          {
            if (!paramString1.hasNext()) {
              break;
            }
            localMarker = (Marker)paramString1.next();
          } while ((localMarker == null) || (!localMarker.getId().equals(paramString2)));
        }
      }
    }
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public final boolean e(String paramString1, String paramString2)
  {
    paramString1 = (lo)this.c.get(paramString1);
    boolean bool;
    if (paramString1 != null) {
      if ((!nl.a(paramString2)) && (paramString1.a != null))
      {
        paramString1 = paramString1.a.iterator();
        while (paramString1.hasNext())
        {
          Marker localMarker = (Marker)paramString1.next();
          if ((localMarker != null) && (localMarker.getId().equals(paramString2))) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      this.a.s();
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.lp
 * JD-Core Version:    0.7.0.1
 */