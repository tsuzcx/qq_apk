package com.tencent.component.network.module.a;

import android.content.Context;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.utils.NetworkUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  private final Map<String, com.tencent.component.network.module.a.a.a<b>> a = new HashMap();
  private final Map<String, b> b = new HashMap();
  
  public static a c()
  {
    return a.a;
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!NetworkUtils.isMobileConnected(paramContext)) {
      return;
    }
    b localb = new b();
    localb.a = paramBoolean1;
    localb.b = paramBoolean2;
    label314:
    label319:
    label324:
    label327:
    for (;;)
    {
      Object localObject;
      synchronized (this.a)
      {
        localObject = NetworkManager.getApnValue();
        paramContext = (com.tencent.component.network.module.a.a.a)this.a.get(localObject);
        if (paramContext != null) {
          break label327;
        }
        paramContext = new com.tencent.component.network.module.a.a.a(3);
        this.a.put(localObject, paramContext);
        paramContext.add(0, localb);
        if (paramContext == null) {}
      }
      for (;;)
      {
        int k;
        int i;
        int j;
        synchronized (this.b)
        {
          localb = (b)this.b.get(localObject);
          if (localb != null) {
            break label324;
          }
          localb = new b();
          this.b.put(localObject, localb);
          paramContext = paramContext.iterator();
          k = 0;
          i = 0;
          j = 0;
          if (!paramContext.hasNext())
          {
            if (k > 0)
            {
              if (j / k <= 0.5F) {
                break label314;
              }
              paramBoolean1 = true;
              localb.a = paramBoolean1;
              if (i / k <= 0.5F) {
                break label319;
              }
              paramBoolean1 = true;
              localb.b = paramBoolean1;
            }
            return;
            paramContext = finally;
            throw paramContext;
          }
        }
        localObject = (b)paramContext.next();
        if (localObject != null)
        {
          int n = k + 1;
          int m = j;
          if (((b)localObject).a) {
            m = j + 1;
          }
          paramBoolean1 = ((b)localObject).b;
          k = n;
          j = m;
          if (paramBoolean1)
          {
            i += 1;
            k = n;
            j = m;
            continue;
            paramBoolean1 = false;
            continue;
            paramBoolean1 = false;
          }
        }
      }
    }
  }
  
  public final boolean a()
  {
    String str = NetworkManager.getApnValue();
    synchronized (this.b)
    {
      b localb2 = (b)this.b.get(str);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        this.b.put(str, localb1);
      }
      return localb1.a;
    }
  }
  
  public final boolean b()
  {
    String str = NetworkManager.getApnValue();
    synchronized (this.b)
    {
      b localb2 = (b)this.b.get(str);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        this.b.put(str, localb1);
      }
      return localb1.b;
    }
  }
  
  static final class a
  {
    static final a a = new a((byte)0);
  }
  
  static final class b
  {
    public boolean a = false;
    public boolean b = false;
    
    public b()
    {
      if (NetworkManager.isWap())
      {
        this.a = true;
        this.b = true;
        return;
      }
      this.a = false;
      this.b = false;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof b))) {
          return false;
        }
        paramObject = (b)paramObject;
      } while ((this.a == paramObject.a) && (this.b) && (paramObject.b));
      return false;
    }
    
    public final int hashCode()
    {
      int j = 1;
      int i;
      if (this.a)
      {
        i = 1;
        if (!this.b) {
          break label34;
        }
      }
      for (;;)
      {
        return (i + 527) * 31 + j;
        i = 0;
        break;
        label34:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.a.a
 * JD-Core Version:    0.7.0.1
 */