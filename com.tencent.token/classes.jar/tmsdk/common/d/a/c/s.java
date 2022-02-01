package tmsdk.common.d.a.c;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import tmsdk.common.c.a.f;
import tmsdk.common.d.a.b.h;

public class s
{
  public static String a = "TmsTcpNetwork";
  d b = null;
  private o c = new o();
  private Context d = null;
  private r e = null;
  private long f = 180000L;
  private boolean g = false;
  private b h = null;
  
  public s(Context paramContext)
  {
    this.d = paramContext;
  }
  
  private int b(JceStruct paramJceStruct)
  {
    paramJceStruct = h.a(paramJceStruct);
    return this.c.a(paramJceStruct);
  }
  
  public int a(JceStruct paramJceStruct)
  {
    return a(paramJceStruct, 3);
  }
  
  public int a(JceStruct paramJceStruct, int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    paramInt = 0;
    int j = 0;
    while (paramInt < i)
    {
      j = b(paramJceStruct);
      if (j == 0) {
        return 0;
      }
      paramInt += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.e.b();
  }
  
  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void a(long paramLong)
  {
    if (this.f == paramLong) {
      return;
    }
    b localb = this.h;
    if (localb != null) {
      localb.a(paramLong);
    }
  }
  
  public void a(t paramt)
  {
    this.c.a(paramt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = new r(paramBoolean);
  }
  
  public void a(boolean paramBoolean, d paramd)
  {
    this.g = paramBoolean;
    this.b = paramd;
    if (this.g)
    {
      this.h = new b(this.d, paramd);
      this.h.a(this.f);
      this.h.b();
      return;
    }
    paramd = this.h;
    if (paramd != null) {
      paramd.d();
    }
    this.h = null;
  }
  
  public void b()
  {
    this.c.b();
    if (e())
    {
      b localb = this.h;
      if (localb != null) {
        localb.d();
      }
    }
  }
  
  public boolean c()
  {
    String str = a;
    if (f.a())
    {
      str = a;
      return false;
    }
    return this.c.a(this.d, this.e);
  }
  
  public boolean d()
  {
    if (f.a())
    {
      String str = a;
      return false;
    }
    b();
    this.e.c();
    boolean bool = this.c.a(this.e);
    a(this.g, this.b);
    return bool;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.c.c();
  }
  
  public void g()
  {
    if (!e()) {
      return;
    }
    this.h.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.s
 * JD-Core Version:    0.7.0.1
 */