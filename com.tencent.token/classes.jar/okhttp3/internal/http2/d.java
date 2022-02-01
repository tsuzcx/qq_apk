package okhttp3.internal.http2;

import com.tencent.token.fd;
import com.tencent.token.ff;
import com.tencent.token.fo;
import com.tencent.token.fq;
import com.tencent.token.ft;
import com.tencent.token.fu;
import com.tencent.token.fw;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.aa;
import okhttp3.internal.connection.f;
import okhttp3.r.a;
import okhttp3.s;
import okhttp3.t.a;
import okhttp3.v;
import okhttp3.x;
import okhttp3.z;
import okhttp3.z.a;
import okio.ByteString;
import okio.c;
import okio.k;
import okio.q;

public final class d
  implements fo
{
  private static final ByteString b = ByteString.a("connection");
  private static final ByteString c = ByteString.a("host");
  private static final ByteString d = ByteString.a("keep-alive");
  private static final ByteString e = ByteString.a("proxy-connection");
  private static final ByteString f = ByteString.a("transfer-encoding");
  private static final ByteString g = ByteString.a("te");
  private static final ByteString h = ByteString.a("encoding");
  private static final ByteString i = ByteString.a("upgrade");
  private static final List<ByteString> j = ff.a(new ByteString[] { b, c, d, e, g, f, h, i, a.c, a.d, a.e, a.f });
  private static final List<ByteString> k = ff.a(new ByteString[] { b, c, d, e, g, f, h, i });
  final f a;
  private final t.a l;
  private final e m;
  private g n;
  private final Protocol o;
  
  public d(v paramv, t.a parama, f paramf, e parame)
  {
    this.l = parama;
    this.a = paramf;
    this.m = parame;
    if (paramv.u().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
      paramv = Protocol.H2_PRIOR_KNOWLEDGE;
    } else {
      paramv = Protocol.HTTP_2;
    }
    this.o = paramv;
  }
  
  public static z.a a(List<a> paramList, Protocol paramProtocol)
  {
    Object localObject2 = new r.a();
    int i2 = paramList.size();
    int i1 = 0;
    Object localObject3 = null;
    while (i1 < i2)
    {
      Object localObject1 = (a)paramList.get(i1);
      Object localObject4;
      if (localObject1 == null)
      {
        localObject1 = localObject3;
        localObject4 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          localObject4 = localObject2;
          if (localObject3.b == 100)
          {
            localObject4 = new r.a();
            localObject1 = null;
          }
        }
      }
      else
      {
        ByteString localByteString = ((a)localObject1).g;
        String str = ((a)localObject1).h.a();
        if (localByteString.equals(a.b))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("HTTP/1.1 ");
          ((StringBuilder)localObject1).append(str);
          localObject1 = fw.a(((StringBuilder)localObject1).toString());
          localObject4 = localObject2;
        }
        else
        {
          localObject1 = localObject3;
          localObject4 = localObject2;
          if (!k.contains(localByteString))
          {
            fd.a.a((r.a)localObject2, localByteString.a(), str);
            localObject4 = localObject2;
            localObject1 = localObject3;
          }
        }
      }
      i1 += 1;
      localObject3 = localObject1;
      localObject2 = localObject4;
    }
    if (localObject3 != null) {
      return new z.a().a(paramProtocol).a(localObject3.b).a(localObject3.c).a(((r.a)localObject2).a());
    }
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public static List<a> b(x paramx)
  {
    okhttp3.r localr = paramx.c();
    ArrayList localArrayList = new ArrayList(localr.a() + 4);
    localArrayList.add(new a(a.c, paramx.b()));
    localArrayList.add(new a(a.d, fu.a(paramx.a())));
    String str = paramx.a("Host");
    if (str != null) {
      localArrayList.add(new a(a.f, str));
    }
    localArrayList.add(new a(a.e, paramx.a().b()));
    int i1 = 0;
    int i2 = localr.a();
    while (i1 < i2)
    {
      paramx = ByteString.a(localr.a(i1).toLowerCase(Locale.US));
      if (!j.contains(paramx)) {
        localArrayList.add(new a(paramx, localr.b(i1)));
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public aa a(z paramz)
  {
    this.a.c.f(this.a.b);
    return new ft(paramz.a("Content-Type"), fq.a(paramz), k.a(new a(this.n.g())));
  }
  
  public z.a a(boolean paramBoolean)
  {
    z.a locala = a(this.n.d(), this.o);
    if ((paramBoolean) && (fd.a.a(locala) == 100)) {
      return null;
    }
    return locala;
  }
  
  public okio.p a(x paramx, long paramLong)
  {
    return this.n.h();
  }
  
  public void a()
  {
    this.m.b();
  }
  
  public void a(x paramx)
  {
    if (this.n != null) {
      return;
    }
    boolean bool;
    if (paramx.d() != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramx = b(paramx);
    this.n = this.m.a(paramx, bool);
    this.n.e().a(this.l.c(), TimeUnit.MILLISECONDS);
    this.n.f().a(this.l.d(), TimeUnit.MILLISECONDS);
  }
  
  public void b()
  {
    this.n.h().close();
  }
  
  class a
    extends okio.g
  {
    boolean a = false;
    long b = 0L;
    
    a(q paramq)
    {
      super();
    }
    
    private void a(IOException paramIOException)
    {
      if (this.a) {
        return;
      }
      this.a = true;
      d.this.a.a(false, d.this, this.b, paramIOException);
    }
    
    public long a(c paramc, long paramLong)
    {
      try
      {
        paramLong = b().a(paramc, paramLong);
        if (paramLong > 0L) {
          this.b += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramc)
      {
        a(paramc);
        throw paramc;
      }
    }
    
    public void close()
    {
      super.close();
      a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.d
 * JD-Core Version:    0.7.0.1
 */