package okhttp3;

import com.tencent.token.gr;
import com.tencent.token.ha;
import com.tencent.token.hb;
import com.tencent.token.hi;
import com.tencent.token.hl;
import com.tencent.token.ih;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.connection.a;

final class an
  implements g
{
  final ak a;
  final hl b;
  final ap c;
  final boolean d;
  private y e;
  private boolean f;
  
  private an(ak paramak, ap paramap, boolean paramBoolean)
  {
    this.a = paramak;
    this.c = paramap;
    this.d = paramBoolean;
    this.b = new hl(paramak, paramBoolean);
  }
  
  static an a(ak paramak, ap paramap, boolean paramBoolean)
  {
    paramap = new an(paramak, paramap, paramBoolean);
    paramap.e = paramak.y().a(paramap);
    return paramap;
  }
  
  private void f()
  {
    Object localObject = ih.c().a("response.body().close()");
    this.b.a(localObject);
  }
  
  public void a(h paramh)
  {
    try
    {
      if (this.f) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.f = true;
    f();
    this.e.a(this);
    this.a.t().a(new ao(this, paramh));
  }
  
  public boolean a()
  {
    return this.b.a();
  }
  
  public an b()
  {
    return a(this.a, this.c, this.d);
  }
  
  String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (a())
    {
      str = "canceled ";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.d) {
        break label61;
      }
    }
    label61:
    for (String str = "web socket";; str = "call")
    {
      return str + " to " + d();
      str = "";
      break;
    }
  }
  
  String d()
  {
    return this.c.a().m();
  }
  
  at e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a.w());
    localArrayList.add(this.b);
    localArrayList.add(new ha(this.a.g()));
    localArrayList.add(new gr(this.a.h()));
    localArrayList.add(new a(this.a));
    if (!this.d) {
      localArrayList.addAll(this.a.x());
    }
    localArrayList.add(new hb(this.d));
    return new hi(localArrayList, null, null, null, 0, this.c, this, this.e, this.a.a(), this.a.b(), this.a.c()).a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.an
 * JD-Core Version:    0.7.0.1
 */