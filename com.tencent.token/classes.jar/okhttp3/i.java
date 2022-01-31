package okhttp3;

import com.tencent.token.gn;
import com.tencent.token.il;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

public final class i
{
  public static final i a = new j().a();
  private final Set b;
  @Nullable
  private final il c;
  
  i(Set paramSet, @Nullable il paramil)
  {
    this.b = paramSet;
    this.c = paramil;
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
  
  List a(String paramString)
  {
    Object localObject1 = Collections.emptyList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.a(paramString))
      {
        Object localObject2 = localObject1;
        if (((List)localObject1).isEmpty()) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).add(localk);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  i a(@Nullable il paramil)
  {
    if (gn.a(this.c, paramil)) {
      return this;
    }
    return new i(this.b, paramil);
  }
  
  public void a(String paramString, List paramList)
  {
    List localList2 = a(paramString);
    if (localList2.isEmpty()) {
      return;
    }
    List localList1 = paramList;
    if (this.c != null) {
      localList1 = this.c.a(paramList, paramString);
    }
    int k = localList1.size();
    int i = 0;
    Object localObject1;
    for (;;)
    {
      if (i >= k) {
        break label244;
      }
      X509Certificate localX509Certificate = (X509Certificate)localList1.get(i);
      int m = localList2.size();
      j = 0;
      paramList = null;
      localObject1 = null;
      if (j < m)
      {
        k localk = (k)localList2.get(j);
        Object localObject2;
        if (localk.c.equals("sha256/"))
        {
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = b(localX509Certificate);
          }
          if (localk.d.equals(localObject2)) {
            break;
          }
          paramList = (List)localObject2;
        }
        do
        {
          j += 1;
          break;
          if (!localk.c.equals("sha1/")) {
            break label206;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a(localX509Certificate);
          }
          localObject1 = localObject2;
        } while (!localk.d.equals(localObject2));
        return;
        label206:
        throw new AssertionError("unsupported hashAlgorithm: " + localk.c);
      }
      i += 1;
    }
    label244:
    paramList = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
    int j = localList1.size();
    i = 0;
    while (i < j)
    {
      localObject1 = (X509Certificate)localList1.get(i);
      paramList.append("\n    ").append(a((Certificate)localObject1)).append(": ").append(((X509Certificate)localObject1).getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ").append(paramString).append(":");
    j = localList2.size();
    i = 0;
    while (i < j)
    {
      paramString = (k)localList2.get(i);
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
    if (((paramObject instanceof i)) && (gn.a(this.c, ((i)paramObject).c)) && (this.b.equals(((i)paramObject).b))) {}
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.i
 * JD-Core Version:    0.7.0.1
 */