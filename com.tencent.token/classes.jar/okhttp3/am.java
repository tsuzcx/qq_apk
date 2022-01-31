package okhttp3;

import com.tencent.token.gn;
import com.tencent.token.gz;
import com.tencent.token.il;
import com.tencent.token.im;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class am
{
  int A = 0;
  v a = new v();
  @Nullable
  Proxy b;
  List c = ak.a;
  List d = ak.b;
  final List e = new ArrayList();
  final List f = new ArrayList();
  ab g = y.a(y.a);
  ProxySelector h = ProxySelector.getDefault();
  t i = t.a;
  @Nullable
  d j;
  @Nullable
  gz k;
  SocketFactory l = SocketFactory.getDefault();
  @Nullable
  SSLSocketFactory m;
  @Nullable
  il n;
  HostnameVerifier o = im.a;
  i p = i.a;
  b q = b.a;
  b r = b.a;
  o s = new o();
  w t = w.a;
  boolean u = true;
  boolean v = true;
  boolean w = true;
  int x = 10000;
  int y = 10000;
  int z = 10000;
  
  public ak a()
  {
    return new ak(this);
  }
  
  public am a(long paramLong, TimeUnit paramTimeUnit)
  {
    this.x = gn.a("timeout", paramLong, paramTimeUnit);
    return this;
  }
  
  public am b(long paramLong, TimeUnit paramTimeUnit)
  {
    this.y = gn.a("timeout", paramLong, paramTimeUnit);
    return this;
  }
  
  public am c(long paramLong, TimeUnit paramTimeUnit)
  {
    this.z = gn.a("timeout", paramLong, paramTimeUnit);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.am
 * JD-Core Version:    0.7.0.1
 */