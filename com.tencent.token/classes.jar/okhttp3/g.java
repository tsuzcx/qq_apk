package okhttp3;

import com.tencent.token.fc;
import com.tencent.token.gg;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.List<Ljava.security.cert.Certificate;>;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

public final class g
{
  public static final g a = new a().a();
  private final Set<b> b;
  @Nullable
  private final gg c;
  
  g(Set<b> paramSet, @Nullable gg paramgg)
  {
    this.b = paramSet;
    this.c = paramgg;
  }
  
  public static String a(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha256/" + b((X509Certificate)paramCertificate).b();
  }
  
  static ByteString a(X509Certificate paramX509Certificate)
  {
    return ByteString.a(paramX509Certificate.getPublicKey().getEncoded()).c();
  }
  
  static ByteString b(X509Certificate paramX509Certificate)
  {
    return ByteString.a(paramX509Certificate.getPublicKey().getEncoded()).d();
  }
  
  List<b> a(String paramString)
  {
    Object localObject1 = Collections.emptyList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramString))
      {
        Object localObject2 = localObject1;
        if (((List)localObject1).isEmpty()) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).add(localb);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  g a(@Nullable gg paramgg)
  {
    if (fc.a(this.c, paramgg)) {
      return this;
    }
    return new g(this.b, paramgg);
  }
  
  public void a(String paramString, List<Certificate> paramList)
  {
    List localList = a(paramString);
    if (localList.isEmpty()) {
      return;
    }
    Object localObject3 = paramList;
    if (this.c != null) {
      localObject3 = this.c.a(paramList, paramString);
    }
    int k = ((List)localObject3).size();
    int i = 0;
    Object localObject1;
    for (;;)
    {
      if (i >= k) {
        break label244;
      }
      X509Certificate localX509Certificate = (X509Certificate)((List)localObject3).get(i);
      int m = localList.size();
      j = 0;
      paramList = null;
      localObject1 = null;
      if (j < m)
      {
        b localb = (b)localList.get(j);
        Object localObject2;
        if (localb.c.equals("sha256/"))
        {
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = b(localX509Certificate);
          }
          if (localb.d.equals(localObject2)) {
            break;
          }
          paramList = (List<Certificate>)localObject2;
        }
        do
        {
          j += 1;
          break;
          if (!localb.c.equals("sha1/")) {
            break label206;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a(localX509Certificate);
          }
          localObject1 = localObject2;
        } while (!localb.d.equals(localObject2));
        return;
        label206:
        throw new AssertionError("unsupported hashAlgorithm: " + localb.c);
      }
      i += 1;
    }
    label244:
    paramList = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
    int j = ((List)localObject3).size();
    i = 0;
    while (i < j)
    {
      localObject1 = (X509Certificate)((List)localObject3).get(i);
      paramList.append("\n    ").append(a((Certificate)localObject1)).append(": ").append(((X509Certificate)localObject1).getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ").append(paramString).append(":");
    j = localList.size();
    i = 0;
    while (i < j)
    {
      paramString = (b)localList.get(i);
      paramList.append("\n    ").append(paramString);
      i += 1;
    }
    throw new SSLPeerUnverifiedException(paramList.toString());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof g)) && (fc.a(this.c, ((g)paramObject).c)) && (this.b.equals(((g)paramObject).b))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    if (this.c != null) {}
    for (int i = this.c.hashCode();; i = 0) {
      return i * 31 + this.b.hashCode();
    }
  }
  
  public static final class a
  {
    private final List<g.b> a = new ArrayList();
    
    public g a()
    {
      return new g(new LinkedHashSet(this.a), null);
    }
  }
  
  static final class b
  {
    final String a;
    final String b;
    final String c;
    final ByteString d;
    
    boolean a(String paramString)
    {
      boolean bool2 = false;
      if (this.a.startsWith("*."))
      {
        int i = paramString.indexOf('.');
        boolean bool1 = bool2;
        if (paramString.length() - i - 1 == this.b.length())
        {
          bool1 = bool2;
          if (paramString.regionMatches(false, i + 1, this.b, 0, this.b.length())) {
            bool1 = true;
          }
        }
        return bool1;
      }
      return paramString.equals(this.b);
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof b)) && (this.a.equals(((b)paramObject).a)) && (this.c.equals(((b)paramObject).c)) && (this.d.equals(((b)paramObject).d));
    }
    
    public int hashCode()
    {
      return ((this.a.hashCode() + 527) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
    
    public String toString()
    {
      return this.c + this.d.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.g
 * JD-Core Version:    0.7.0.1
 */