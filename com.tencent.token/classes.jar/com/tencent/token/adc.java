package com.tencent.token;

import com.tencent.turingfd.sdk.qps.Andromeda;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class adc
  extends aep
{
  public static final Writer a = new a();
  public static final agx b = new agx("closed");
  public final List<ahu> c = new ArrayList();
  public String d;
  public ahu e = agv.a;
  
  public adc()
  {
    super(a);
  }
  
  private void a(ahu paramahu)
  {
    if (this.d != null)
    {
      if ((!(paramahu instanceof agv)) || (this.p))
      {
        Object localObject2 = (agw)f();
        localObject1 = this.d;
        localObject2 = ((agw)localObject2).a;
        if (localObject1 != null) {
          ((Andromeda)localObject2).a(localObject1, true).g = paramahu;
        }
      }
      else
      {
        this.d = null;
        return;
      }
      throw new NullPointerException("key == null");
    }
    if (this.c.isEmpty())
    {
      this.e = paramahu;
      return;
    }
    Object localObject1 = f();
    if ((localObject1 instanceof ahb))
    {
      ((ahb)localObject1).a.add(paramahu);
      return;
    }
    throw new IllegalStateException();
  }
  
  private ahu f()
  {
    List localList = this.c;
    return (ahu)localList.get(localList.size() - 1);
  }
  
  public final aep a()
  {
    ahb localahb = new ahb();
    a(localahb);
    this.c.add(localahb);
    return this;
  }
  
  public final aep a(long paramLong)
  {
    a(new agx(Long.valueOf(paramLong)));
    return this;
  }
  
  public final aep a(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      a(agv.a);
      return this;
    }
    a(new agx(paramBoolean));
    return this;
  }
  
  public final aep a(Number paramNumber)
  {
    if (paramNumber == null)
    {
      a(agv.a);
      return this;
    }
    if (!this.m)
    {
      double d1 = paramNumber.doubleValue();
      if ((Double.isNaN(d1)) || (Double.isInfinite(d1))) {
        throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(paramNumber)));
      }
    }
    a(new agx(paramNumber));
    return this;
  }
  
  public final aep a(String paramString)
  {
    if ((!this.c.isEmpty()) && (this.d == null))
    {
      if ((f() instanceof agw))
      {
        this.d = paramString;
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public final aep a(boolean paramBoolean)
  {
    a(new agx(Boolean.valueOf(paramBoolean)));
    return this;
  }
  
  public final aep b()
  {
    if ((!this.c.isEmpty()) && (this.d == null))
    {
      if ((f() instanceof ahb))
      {
        List localList = this.c;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public final aep b(String paramString)
  {
    if (paramString == null)
    {
      a(agv.a);
      return this;
    }
    a(new agx(paramString));
    return this;
  }
  
  public final aep c()
  {
    agw localagw = new agw();
    a(localagw);
    this.c.add(localagw);
    return this;
  }
  
  public final void close()
  {
    if (this.c.isEmpty())
    {
      this.c.add(b);
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public final aep d()
  {
    if ((!this.c.isEmpty()) && (this.d == null))
    {
      if ((f() instanceof agw))
      {
        List localList = this.c;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public final aep e()
  {
    a(agv.a);
    return this;
  }
  
  public final void flush() {}
  
  public final class a
    extends Writer
  {
    public final void close()
    {
      throw new AssertionError();
    }
    
    public final void flush()
    {
      throw new AssertionError();
    }
    
    public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      throw new AssertionError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adc
 * JD-Core Version:    0.7.0.1
 */