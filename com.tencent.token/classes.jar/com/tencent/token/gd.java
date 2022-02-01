package com.tencent.token;

import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class gd
  extends gf
{
  private final gh a;
  
  public gd(gh paramgh)
  {
    this.a = paramgh;
  }
  
  private boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    if (!paramX509Certificate1.getIssuerDN().equals(paramX509Certificate2.getSubjectDN())) {
      return false;
    }
    try
    {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      return true;
    }
    catch (GeneralSecurityException paramX509Certificate1) {}
    return false;
  }
  
  public List<Certificate> a(List<Certificate> paramList, String paramString)
  {
    ArrayDeque localArrayDeque = new ArrayDeque(paramList);
    paramList = new ArrayList();
    paramList.add(localArrayDeque.removeFirst());
    int i = 0;
    int j = 0;
    while (i < 9)
    {
      paramString = (X509Certificate)paramList.get(paramList.size() - 1);
      Object localObject = this.a.a(paramString);
      if (localObject != null)
      {
        if ((paramList.size() > 1) || (!paramString.equals(localObject))) {
          paramList.add(localObject);
        }
        if (a((X509Certificate)localObject, (X509Certificate)localObject)) {
          return paramList;
        }
        j = 1;
      }
      else
      {
        localObject = localArrayDeque.iterator();
        X509Certificate localX509Certificate;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localX509Certificate = (X509Certificate)((Iterator)localObject).next();
        } while (!a(paramString, localX509Certificate));
        ((Iterator)localObject).remove();
        paramList.add(localX509Certificate);
      }
      i += 1;
      continue;
      if (j != 0) {
        return paramList;
      }
      paramList = new StringBuilder();
      paramList.append("Failed to find a trusted cert that signed ");
      paramList.append(paramString);
      throw new SSLPeerUnverifiedException(paramList.toString());
    }
    paramString = new StringBuilder();
    paramString.append("Certificate chain too long: ");
    paramString.append(paramList);
    throw new SSLPeerUnverifiedException(paramString.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    return ((paramObject instanceof gd)) && (((gd)paramObject).a.equals(this.a));
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gd
 * JD-Core Version:    0.7.0.1
 */