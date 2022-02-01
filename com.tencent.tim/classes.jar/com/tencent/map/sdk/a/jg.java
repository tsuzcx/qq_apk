package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class jg
{
  public long a = 0L;
  public long b = 0L;
  public d c = new d();
  public f d;
  
  protected static jg a(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    if (paramJSONObject == null) {
      return null;
    }
    jg localjg = new jg();
    localjg.a = paramJSONObject.optLong("create");
    localjg.b = paramJSONObject.optLong("destroy");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("mapLoad");
    Object localObject1;
    if (localJSONObject1 == null)
    {
      localObject1 = null;
      localjg.c = ((d)localObject1);
      localObject1 = paramJSONObject.optJSONObject("oversea");
      if (localObject1 != null) {
        break label330;
      }
      paramJSONObject = localObject2;
    }
    for (;;)
    {
      localjg.d = paramJSONObject;
      return localjg;
      d locald = new d();
      locald.a = localJSONObject1.optBoolean("loadSuccess");
      locald.b = localJSONObject1.optLong("loadSuccessTime");
      locald.c = localJSONObject1.optLong("firstLoadTime");
      Object localObject3 = localJSONObject1.optJSONObject("configUpdate");
      int i;
      label185:
      JSONObject localJSONObject2;
      if (localObject3 == null)
      {
        localObject1 = null;
        locald.d = ((b)localObject1);
        localObject3 = localJSONObject1.optJSONArray("tileErrors");
        if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
          break label309;
        }
        locald.e = new CopyOnWriteArraySet();
        i = 0;
        if (i >= ((JSONArray)localObject3).length()) {
          break label309;
        }
        localJSONObject2 = ((JSONArray)localObject3).optJSONObject(i);
        if (localJSONObject2 != null) {
          break label265;
        }
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 != null) {
          locald.e.add(localObject1);
        }
        i += 1;
        break label185;
        localObject1 = new b();
        ((b)localObject1).a = ((JSONObject)localObject3).optBoolean("success");
        ((b)localObject1).b = ((JSONObject)localObject3).optLong("loadBeginTime");
        break;
        label265:
        localObject1 = new g();
        ((g)localObject1).a = localJSONObject2.optLong("time");
        ((g)localObject1).b = localJSONObject2.optString("tid");
        ((g)localObject1).c = localJSONObject2.optInt("netError");
      }
      label309:
      locald.f = a.a(localJSONObject1.optJSONObject("configError"));
      localObject1 = locald;
      break;
      label330:
      paramJSONObject = new f();
      paramJSONObject.a = ((JSONObject)localObject1).optInt("wtc");
    }
  }
  
  protected final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("create", this.a);
      localJSONObject.put("destroy", this.b);
      if (this.c != null) {
        localJSONObject.put("mapLoad", this.c.a());
      }
      if (this.d != null) {
        localJSONObject.put("oversea", this.d.a());
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public final void a(long paramLong, String paramString)
  {
    if (this.c.f == null) {
      this.c.f = new a();
    }
    if (this.c.f.b == null) {
      this.c.f.b = new CopyOnWriteArraySet();
    }
    if (this.c.f.b.size() > 9) {
      return;
    }
    e locale = new e();
    locale.b = (paramLong - this.a);
    locale.a = paramString;
    this.c.f.b.add(locale);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c.a = paramBoolean;
  }
  
  public final void a(boolean paramBoolean, long paramLong)
  {
    b localb = new b((byte)0);
    localb.a = paramBoolean;
    if (paramLong - this.a > 0L) {
      localb.b = (paramLong - this.a);
    }
    this.c.d = localb;
  }
  
  public static final class a
  {
    public Set<jg.c> a;
    Set<jg.e> b;
    
    static a a(JSONObject paramJSONObject)
    {
      int j = 0;
      if (paramJSONObject == null) {
        return null;
      }
      a locala = new a();
      Object localObject2 = paramJSONObject.optJSONArray("faileUpdates");
      int i;
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        locala.a = new CopyOnWriteArraySet();
        i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
          if (localJSONObject == null) {
            localObject1 = null;
          }
          for (;;)
          {
            if (localObject1 != null) {
              locala.a.add(localObject1);
            }
            i += 1;
            break;
            localObject1 = new jg.c();
            ((jg.c)localObject1).a = localJSONObject.optString("name");
            ((jg.c)localObject1).b = localJSONObject.optLong("time");
            ((jg.c)localObject1).c = localJSONObject.optString("expectMd5");
            ((jg.c)localObject1).d = localJSONObject.optString("actualMd5");
            ((jg.c)localObject1).e = localJSONObject.optInt("localVer");
            ((jg.c)localObject1).f = localJSONObject.optInt("netError");
          }
        }
      }
      Object localObject1 = paramJSONObject.optJSONArray("missFiles");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        locala.b = new CopyOnWriteArraySet();
        i = j;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject2 == null) {
            paramJSONObject = null;
          }
          for (;;)
          {
            if (paramJSONObject != null) {
              locala.b.add(paramJSONObject);
            }
            i += 1;
            break;
            paramJSONObject = new jg.e();
            paramJSONObject.a = ((JSONObject)localObject2).optString("name");
            paramJSONObject.b = ((JSONObject)localObject2).optLong("time");
          }
        }
      }
      return locala;
    }
    
    final JSONObject a()
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray;
      Iterator localIterator;
      JSONObject localJSONObject2;
      if ((this.a != null) && (!this.a.isEmpty()))
      {
        localJSONArray = new JSONArray();
        localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          localJSONObject2 = ((jg.c)localIterator.next()).a();
          if (localJSONObject2 != null) {
            localJSONArray.put(localJSONObject2);
          }
        }
        if (localJSONArray.length() <= 0) {}
      }
      try
      {
        localJSONObject1.put("faileUpdates", localJSONArray);
        if ((this.b != null) && (this.b.size() > 0))
        {
          localJSONArray = new JSONArray();
          localIterator = this.b.iterator();
          while (localIterator.hasNext())
          {
            localJSONObject2 = ((jg.e)localIterator.next()).a();
            if (localJSONObject2 != null) {
              localJSONArray.put(localJSONObject2);
            }
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
        if (localJSONException1.length() > 0) {}
        try
        {
          localJSONObject1.put("missFiles", localJSONException1);
          return localJSONObject1;
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
      return localJSONObject1;
    }
  }
  
  static final class b
  {
    boolean a = false;
    long b = 0L;
    
    final JSONObject a()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("success", this.a);
        localJSONObject.put("loadBeginTime", this.b);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return null;
    }
  }
  
  public static final class c
  {
    public String a;
    public long b;
    public String c;
    public String d;
    public int e;
    public int f;
    
    final JSONObject a()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("name", this.a);
        localJSONObject.put("time", this.b);
        localJSONObject.put("expectMd5", this.c);
        localJSONObject.put("actualMd5", this.d);
        localJSONObject.put("localVer", this.e);
        localJSONObject.put("netError", this.f);
        return localJSONObject;
      }
      catch (JSONException localJSONException) {}
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      return nl.a(this.a, paramObject.a);
    }
    
    public final int hashCode()
    {
      if (this.a == null) {
        return super.hashCode();
      }
      return this.a.hashCode();
    }
  }
  
  public static final class d
  {
    boolean a = false;
    public long b = 0L;
    public long c = 0L;
    jg.b d;
    public Set<jg.g> e;
    public jg.a f;
    
    final JSONObject a()
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray;
      try
      {
        localJSONObject1.put("loadSuccess", this.a);
        localJSONObject1.put("loadSuccessTime", this.b);
        localJSONObject1.put("firstLoadTime", this.c);
        if (this.d != null) {
          localJSONObject1.put("configUpdate", this.d.a());
        }
        if ((this.e == null) || (this.e.size() <= 0)) {
          break label159;
        }
        localJSONArray = new JSONArray();
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          JSONObject localJSONObject2 = ((jg.g)localIterator.next()).a();
          if (localJSONObject2 != null) {
            localJSONArray.put(localJSONObject2);
          }
        }
        if (localJSONArray.length() <= 0) {
          break label159;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return null;
      }
      localJSONException.put("tileErrors", localJSONArray);
      label159:
      if (this.f != null) {
        localJSONException.put("configError", this.f.a());
      }
      return localJSONException;
    }
  }
  
  public static final class e
  {
    String a;
    long b;
    
    final JSONObject a()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("name", this.a);
        localJSONObject.put("time", this.b);
        return localJSONObject;
      }
      catch (JSONException localJSONException) {}
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
      return nl.a(this.a, paramObject.a);
    }
    
    public final int hashCode()
    {
      if (this.a == null) {
        return super.hashCode();
      }
      return this.a.hashCode();
    }
  }
  
  public static final class f
  {
    public int a;
    
    final JSONObject a()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject().put("wtc", this.a);
        return localJSONObject;
      }
      catch (JSONException localJSONException) {}
      return null;
    }
  }
  
  public static final class g
  {
    public long a;
    public String b;
    public int c;
    
    final JSONObject a()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("time", this.a);
        localJSONObject.put("tid", this.b);
        localJSONObject.put("netError", this.c);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof g)) {
        return false;
      }
      paramObject = (g)paramObject;
      return nl.a(this.b, paramObject.b);
    }
    
    public final int hashCode()
    {
      if (this.b == null) {
        return super.hashCode();
      }
      return this.b.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jg
 * JD-Core Version:    0.7.0.1
 */