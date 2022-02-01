package okhttp3;

import com.tencent.token.ff;
import com.tencent.token.gi;
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
  private final gi c;
  
  g(Set<b> paramSet, @Nullable gi paramgi)
  {
    this.b = paramSet;
    this.c = paramgi;
  }
  
  public static String a(Certificate paramCertificate)
  {
    if ((paramCertificate instanceof X509Certificate))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sha256/");
      localStringBuilder.append(b((X509Certificate)paramCertificate).b());
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
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
  
  g a(@Nullable gi paramgi)
  {
    if (ff.a(this.c, paramgi)) {
      return this;
    }
    return new g(this.b, paramgi);
  }
  
  public void a(String paramString, List<Certificate> paramList)
  {
    List localList = a(paramString);
    if (localList.isEmpty()) {
      return;
    }
    Object localObject1 = this.c;
    Object localObject3 = paramList;
    if (localObject1 != null) {
      localObject3 = ((gi)localObject1).a(paramList, paramString);
    }
    int m = ((List)localObject3).size();
    int k = 0;
    int i = 0;
    while (i < m)
    {
      X509Certificate localX509Certificate = (X509Certificate)((List)localObject3).get(i);
      int n = localList.size();
      localObject1 = null;
      paramList = (List<Certificate>)localObject1;
      j = 0;
      while (j < n)
      {
        b localb = (b)localList.get(j);
        Object localObject2;
        if (localb.c.equals("sha256/"))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = b(localX509Certificate);
          }
          localObject1 = localObject2;
          if (!localb.d.equals(localObject2)) {}
        }
        else
        {
          if (!localb.c.equals("sha1/")) {
            break label213;
          }
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = a(localX509Certificate);
          }
          paramList = (List<Certificate>)localObject2;
          if (localb.d.equals(localObject2)) {
            return;
          }
        }
        j += 1;
        continue;
        label213:
        paramString = new StringBuilder();
        paramString.append("unsupported hashAlgorithm: ");
        paramString.append(localb.c);
        throw new AssertionError(paramString.toString());
      }
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("Certificate pinning failure!");
    paramList.append("\n  Peer certificate chain:");
    int j = ((List)localObject3).size();
    i = 0;
    while (i < j)
    {
      localObject1 = (X509Certificate)((List)localObject3).get(i);
      paramList.append("\n    ");
      paramList.append(a((Certificate)localObject1));
      paramList.append(": ");
      paramList.append(((X509Certificate)localObject1).getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ");
    paramList.append(paramString);
    paramList.append(":");
    j = localList.size();
    i = k;
    while (i < j)
    {
      paramString = (b)localList.get(i);
      paramList.append("\n    ");
      paramList.append(paramString);
      i += 1;
    }
    throw new SSLPeerUnverifiedException(paramList.toString());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof g))
    {
      gi localgi = this.c;
      paramObject = (g)paramObject;
      if ((ff.a(localgi, paramObject.c)) && (this.b.equals(paramObject.b))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    gi localgi = this.c;
    int i;
    if (localgi != null) {
      i = localgi.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.b.hashCode();
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
      if (this.a.startsWith("*."))
      {
        int i = paramString.indexOf('.');
        if (paramString.length() - i - 1 == this.b.length())
        {
          String str = this.b;
          if (paramString.regionMatches(false, i + 1, str, 0, str.length())) {
            return true;
          }
        }
        return false;
      }
      return paramString.equals(this.b);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof b))
      {
        String str = this.a;
        paramObject = (b)paramObject;
        if ((str.equals(paramObject.a)) && (this.c.equals(paramObject.c)) && (this.d.equals(paramObject.d))) {
          return true;
        }
      }
      return false;
    }
    
    public int hashCode()
    {
      return ((527 + this.a.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(this.d.b());
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.g
 * JD-Core Version:    0.7.0.1
 */