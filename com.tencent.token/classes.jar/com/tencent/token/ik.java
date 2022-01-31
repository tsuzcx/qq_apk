package com.tencent.token;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class ik
  implements in
{
  private final Map a = new LinkedHashMap();
  
  public ik(X509Certificate... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      X509Certificate localX509Certificate = paramVarArgs[i];
      X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
      Set localSet = (Set)this.a.get(localX500Principal);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new LinkedHashSet(1);
        this.a.put(localX500Principal, localObject);
      }
      ((Set)localObject).add(localX509Certificate);
      i += 1;
    }
  }
  
  public X509Certificate a(X509Certificate paramX509Certificate)
  {
    Object localObject = paramX509Certificate.getIssuerX500Principal();
    localObject = (Set)this.a.get(localObject);
    if (localObject == null) {
      return null;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      X509Certificate localX509Certificate = (X509Certificate)((Iterator)localObject).next();
      PublicKey localPublicKey = localX509Certificate.getPublicKey();
      try
      {
        paramX509Certificate.verify(localPublicKey);
        return localX509Certificate;
      }
      catch (Exception localException) {}
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    while (((paramObject instanceof ik)) && (((ik)paramObject).a.equals(this.a))) {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ik
 * JD-Core Version:    0.7.0.1
 */