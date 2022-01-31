package com.tencent.feedback.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class c
  extends a
{
  protected HashMap<String, byte[]> d = null;
  private HashMap<String, Object> e = new HashMap();
  private h f = new h();
  
  public <T> void a(String paramString, T paramT)
  {
    if (this.d != null)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("put key can not is null");
      }
      if (paramT == null) {
        throw new IllegalArgumentException("put value can not is null");
      }
      if ((paramT instanceof Set)) {
        throw new IllegalArgumentException("can not support Set");
      }
      i locali = new i();
      locali.a(this.b);
      locali.a(paramT, 0);
      paramT = k.a(locali.a());
      this.d.put(paramString, paramT);
      return;
    }
    super.a(paramString, paramT);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      super.a(paramArrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      this.f.a(paramArrayOfByte);
      this.f.a(this.b);
      paramArrayOfByte = new HashMap(1);
      paramArrayOfByte.put("", new byte[0]);
      this.d = this.f.a(paramArrayOfByte, 0, false);
    }
  }
  
  public byte[] a()
  {
    if (this.d != null)
    {
      i locali = new i(0);
      locali.a(this.b);
      locali.a(this.d, 0);
      return k.a(locali.a());
    }
    return super.a();
  }
  
  public final <T> T b(String paramString, T paramT)
    throws b
  {
    Object localObject = null;
    if (this.d != null) {
      if (this.d.containsKey(paramString)) {}
    }
    while (!this.a.containsKey(paramString)) {
      for (;;)
      {
        return localObject;
        if (this.e.containsKey(paramString)) {
          return this.e.get(paramString);
        }
        localObject = (byte[])this.d.get(paramString);
        try
        {
          this.f.a((byte[])localObject);
          this.f.a(this.b);
          paramT = this.f.a(paramT, 0, true);
          localObject = paramT;
          if (paramT != null)
          {
            this.e.put(paramString, paramT);
            return paramT;
          }
        }
        catch (Exception paramString)
        {
          throw new b(paramString);
        }
      }
    }
    if (this.e.containsKey(paramString)) {
      return this.e.get(paramString);
    }
    localObject = ((HashMap)this.a.get(paramString)).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (Map.Entry)((Iterator)localObject).next();
      ((Map.Entry)localObject).getKey();
    }
    for (localObject = (byte[])((Map.Entry)localObject).getValue();; localObject = new byte[0]) {
      try
      {
        this.f.a((byte[])localObject);
        this.f.a(this.b);
        paramT = this.f.a(paramT, 0, true);
        this.e.put(paramString, paramT);
        return paramT;
      }
      catch (Exception paramString)
      {
        throw new b(paramString);
      }
    }
  }
  
  public void e()
  {
    this.d = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.c
 * JD-Core Version:    0.7.0.1
 */