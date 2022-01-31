package okhttp3.internal.http2;

import com.tencent.token.gl;
import com.tencent.token.gn;
import com.tencent.token.hd;
import com.tencent.token.hg;
import com.tencent.token.hj;
import com.tencent.token.hk;
import com.tencent.token.hm;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.af;
import okhttp3.ai;
import okhttp3.ak;
import okhttp3.ap;
import okhttp3.at;
import okhttp3.au;
import okhttp3.av;
import okhttp3.y;
import okio.ByteString;
import okio.o;
import okio.x;

public final class f
  implements hd
{
  private static final ByteString b = ByteString.a("connection");
  private static final ByteString c = ByteString.a("host");
  private static final ByteString d = ByteString.a("keep-alive");
  private static final ByteString e = ByteString.a("proxy-connection");
  private static final ByteString f = ByteString.a("transfer-encoding");
  private static final ByteString g = ByteString.a("te");
  private static final ByteString h = ByteString.a("encoding");
  private static final ByteString i = ByteString.a("upgrade");
  private static final List j = gn.a(new ByteString[] { b, c, d, e, g, f, h, i, a.c, a.d, a.e, a.f });
  private static final List k = gn.a(new ByteString[] { b, c, d, e, g, f, h, i });
  final okhttp3.internal.connection.g a;
  private final ai l;
  private final h m;
  private z n;
  private final Protocol o;
  
  public f(ak paramak, ai paramai, okhttp3.internal.connection.g paramg, h paramh)
  {
    this.l = paramai;
    this.a = paramg;
    this.m = paramh;
    if (paramak.u().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {}
    for (paramak = Protocol.H2_PRIOR_KNOWLEDGE;; paramak = Protocol.HTTP_2)
    {
      this.o = paramak;
      return;
    }
  }
  
  public static au a(List paramList, Protocol paramProtocol)
  {
    ae localae = new ae();
    int i2 = paramList.size();
    int i1 = 0;
    hm localhm = null;
    if (i1 < i2)
    {
      Object localObject = (a)paramList.get(i1);
      if (localObject == null)
      {
        if ((localhm == null) || (localhm.b != 100)) {
          break label161;
        }
        localae = new ae();
        localhm = null;
      }
      label161:
      for (;;)
      {
        i1 += 1;
        break;
        ByteString localByteString = ((a)localObject).g;
        localObject = ((a)localObject).h.a();
        if (localByteString.equals(a.b)) {
          localhm = hm.a("HTTP/1.1 " + (String)localObject);
        } else if (!k.contains(localByteString)) {
          gl.a.a(localae, localByteString.a(), (String)localObject);
        }
      }
    }
    if (localhm == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    return new au().a(paramProtocol).a(localhm.b).a(localhm.c).a(localae.a());
  }
  
  public static List b(ap paramap)
  {
    ad localad = paramap.c();
    ArrayList localArrayList = new ArrayList(localad.a() + 4);
    localArrayList.add(new a(a.c, paramap.b()));
    localArrayList.add(new a(a.d, hk.a(paramap.a())));
    String str = paramap.a("Host");
    if (str != null) {
      localArrayList.add(new a(a.f, str));
    }
    localArrayList.add(new a(a.e, paramap.a().b()));
    int i1 = 0;
    int i2 = localad.a();
    while (i1 < i2)
    {
      paramap = ByteString.a(localad.a(i1).toLowerCase(Locale.US));
      if (!j.contains(paramap)) {
        localArrayList.add(new a(paramap, localad.b(i1)));
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public au a(boolean paramBoolean)
  {
    au localau2 = a(this.n.d(), this.o);
    au localau1 = localau2;
    if (paramBoolean)
    {
      localau1 = localau2;
      if (gl.a.a(localau2) == 100) {
        localau1 = null;
      }
    }
    return localau1;
  }
  
  public av a(at paramat)
  {
    this.a.c.f(this.a.b);
    return new hj(paramat.a("Content-Type"), hg.a(paramat), o.a(new g(this, this.n.g())));
  }
  
  public x a(ap paramap, long paramLong)
  {
    return this.n.h();
  }
  
  public void a()
  {
    this.m.b();
  }
  
  public void a(ap paramap)
  {
    if (this.n != null) {
      return;
    }
    if (paramap.d() != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramap = b(paramap);
      this.n = this.m.a(paramap, bool);
      this.n.e().a(this.l.c(), TimeUnit.MILLISECONDS);
      this.n.f().a(this.l.d(), TimeUnit.MILLISECONDS);
      return;
    }
  }
  
  public void b()
  {
    this.n.h().close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.f
 * JD-Core Version:    0.7.0.1
 */