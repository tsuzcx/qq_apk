package com.tencent.token;

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

public final class aju
{
  public static final aju a = new aju(new LinkedHashSet(new a().a), null);
  final Set<b> b;
  @Nullable
  final amq c;
  
  aju(Set<b> paramSet, @Nullable amq paramamq)
  {
    this.b = paramSet;
    this.c = paramamq;
  }
  
  private static amy a(X509Certificate paramX509Certificate)
  {
    return amy.a(paramX509Certificate.getPublicKey().getEncoded()).d();
  }
  
  public static String a(Certificate paramCertificate)
  {
    if ((paramCertificate instanceof X509Certificate))
    {
      StringBuilder localStringBuilder = new StringBuilder("sha256/");
      localStringBuilder.append(a((X509Certificate)paramCertificate).b());
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
  }
  
  public final void a(String paramString, List<Certificate> paramList)
  {
    Object localObject3 = Collections.emptyList();
    Object localObject2 = this.b.iterator();
    int k;
    Object localObject4;
    for (;;)
    {
      boolean bool1 = ((Iterator)localObject2).hasNext();
      k = 0;
      boolean bool2 = false;
      if (!bool1) {
        break;
      }
      localObject4 = (b)((Iterator)localObject2).next();
      if (((b)localObject4).a.startsWith("*."))
      {
        i = paramString.indexOf('.');
        bool1 = bool2;
        if (paramString.length() - i - 1 == ((b)localObject4).b.length())
        {
          bool1 = bool2;
          if (paramString.regionMatches(false, i + 1, ((b)localObject4).b, 0, ((b)localObject4).b.length())) {
            bool1 = true;
          }
        }
      }
      else
      {
        bool1 = paramString.equals(((b)localObject4).b);
      }
      if (bool1)
      {
        localObject1 = localObject3;
        if (((List)localObject3).isEmpty()) {
          localObject1 = new ArrayList();
        }
        ((List)localObject1).add(localObject4);
        localObject3 = localObject1;
      }
    }
    if (((List)localObject3).isEmpty()) {
      return;
    }
    Object localObject1 = this.c;
    if (localObject1 != null) {
      localObject4 = ((amq)localObject1).a(paramList, paramString);
    } else {
      localObject4 = paramList;
    }
    int m = ((List)localObject4).size();
    int i = 0;
    while (i < m)
    {
      X509Certificate localX509Certificate = (X509Certificate)((List)localObject4).get(i);
      int n = ((List)localObject3).size();
      localObject1 = null;
      paramList = (List<Certificate>)localObject1;
      j = 0;
      while (j < n)
      {
        b localb = (b)((List)localObject3).get(j);
        if (localb.c.equals("sha256/"))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a(localX509Certificate);
          }
          localObject1 = localObject2;
          if (!localb.d.equals(localObject2)) {}
        }
        else
        {
          if (!localb.c.equals("sha1/")) {
            break label399;
          }
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = amy.a(localX509Certificate.getPublicKey().getEncoded()).c();
          }
          paramList = (List<Certificate>)localObject2;
          if (localb.d.equals(localObject2)) {
            return;
          }
        }
        j += 1;
        continue;
        label399:
        paramString = new StringBuilder("unsupported hashAlgorithm: ");
        paramString.append(localb.c);
        throw new AssertionError(paramString.toString());
      }
      i += 1;
    }
    paramList = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
    int j = ((List)localObject4).size();
    i = 0;
    while (i < j)
    {
      localObject1 = (X509Certificate)((List)localObject4).get(i);
      paramList.append("\n    ");
      paramList.append(a((Certificate)localObject1));
      paramList.append(": ");
      paramList.append(((X509Certificate)localObject1).getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ");
    paramList.append(paramString);
    paramList.append(":");
    j = ((List)localObject3).size();
    i = k;
    while (i < j)
    {
      paramString = (b)((List)localObject3).get(i);
      paramList.append("\n    ");
      paramList.append(paramString);
      i += 1;
    }
    throw new SSLPeerUnverifiedException(paramList.toString());
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof aju))
    {
      amq localamq = this.c;
      paramObject = (aju)paramObject;
      if ((akt.a(localamq, paramObject.c)) && (this.b.equals(paramObject.b))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    amq localamq = this.c;
    int i;
    if (localamq != null) {
      i = localamq.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.b.hashCode();
  }
  
  public static final class a
  {
    final List<aju.b> a = new ArrayList();
  }
  
  static final class b
  {
    final String a;
    final String b;
    final String c;
    final amy d;
    
    public final boolean equals(Object paramObject)
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
    
    public final int hashCode()
    {
      return ((this.a.hashCode() + 527) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(this.d.b());
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aju
 * JD-Core Version:    0.7.0.1
 */