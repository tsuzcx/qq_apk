package com.tencent.component.network.module.common.a;

import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class e
{
  private static e b = null;
  private a<String, b> a = new a();
  
  public static e a()
  {
    try
    {
      if (b == null) {
        b = new e();
      }
      e locale = b;
      return locale;
    }
    finally {}
  }
  
  public final void a(String paramString)
  {
    Const.c("dnstest", "$$$addCache[" + paramString + "]");
    b localb = new b((byte)0);
    if (NetworkManager.isMobile()) {
      NetworkManager.getApnValue();
    }
    for (;;)
    {
      if (this.a.containsKey(paramString)) {
        this.a.remove(paramString);
      }
      this.a.put(paramString, localb);
      return;
      NetworkManager.getBSSID();
    }
  }
  
  final class a<K, V>
    extends LinkedHashMap<K, V>
  {
    private int a = 5;
    private Object b = new Object();
    
    public a()
    {
      super(0.75F, true);
    }
    
    public final void clear()
    {
      synchronized (this.b)
      {
        super.clear();
        return;
      }
    }
    
    public final boolean containsKey(Object paramObject)
    {
      synchronized (this.b)
      {
        boolean bool = super.containsKey(paramObject);
        return bool;
      }
    }
    
    public final V get(Object paramObject)
    {
      synchronized (this.b)
      {
        paramObject = super.get(paramObject);
        return paramObject;
      }
    }
    
    public final V put(K paramK, V paramV)
    {
      synchronized (this.b)
      {
        paramK = super.put(paramK, paramV);
        return paramK;
      }
    }
    
    public final void putAll(Map<? extends K, ? extends V> paramMap)
    {
      synchronized (this.b)
      {
        super.putAll(paramMap);
        return;
      }
    }
    
    public final V remove(Object paramObject)
    {
      synchronized (this.b)
      {
        paramObject = super.remove(paramObject);
        return paramObject;
      }
    }
    
    protected final boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
    {
      return size() > this.a;
    }
    
    public final int size()
    {
      synchronized (this.b)
      {
        int i = super.size();
        return i;
      }
    }
  }
  
  final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.e
 * JD-Core Version:    0.7.0.1
 */