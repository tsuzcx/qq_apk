package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

public final class CertificatePinner
{
  public static final CertificatePinner DEFAULT = new Builder().build();
  private final Map<String, Set<ByteString>> hostnameToPins;
  
  private CertificatePinner(Builder paramBuilder)
  {
    this.hostnameToPins = Util.immutableMap(paramBuilder.hostnameToPins);
  }
  
  public static String pin(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha1/" + sha1((X509Certificate)paramCertificate).base64();
  }
  
  private static ByteString sha1(X509Certificate paramX509Certificate)
  {
    return Util.sha1(ByteString.of(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  public void check(String paramString, List<Certificate> paramList)
    throws SSLPeerUnverifiedException
  {
    int j = 0;
    Set localSet = findMatchingPins(paramString);
    if (localSet == null) {
      return;
    }
    int k = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label62;
      }
      if (localSet.contains(sha1((X509Certificate)paramList.get(i)))) {
        break;
      }
      i += 1;
    }
    label62:
    StringBuilder localStringBuilder = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
    k = paramList.size();
    i = j;
    while (i < k)
    {
      X509Certificate localX509Certificate = (X509Certificate)paramList.get(i);
      localStringBuilder.append("\n    ").append(pin(localX509Certificate)).append(": ").append(localX509Certificate.getSubjectDN().getName());
      i += 1;
    }
    localStringBuilder.append("\n  Pinned certificates for ").append(paramString).append(":");
    paramString = localSet.iterator();
    while (paramString.hasNext())
    {
      paramList = (ByteString)paramString.next();
      localStringBuilder.append("\n    sha1/").append(paramList.base64());
    }
    throw new SSLPeerUnverifiedException(localStringBuilder.toString());
  }
  
  public void check(String paramString, Certificate... paramVarArgs)
    throws SSLPeerUnverifiedException
  {
    check(paramString, Arrays.asList(paramVarArgs));
  }
  
  Set<ByteString> findMatchingPins(String paramString)
  {
    Set localSet = (Set)this.hostnameToPins.get(paramString);
    int i = paramString.indexOf('.');
    if (i != paramString.lastIndexOf('.')) {}
    for (paramString = (Set)this.hostnameToPins.get("*." + paramString.substring(i + 1));; paramString = null)
    {
      Object localObject;
      if ((localSet == null) && (paramString == null)) {
        localObject = null;
      }
      do
      {
        return localObject;
        if ((localSet != null) && (paramString != null))
        {
          localObject = new LinkedHashSet();
          ((Set)localObject).addAll(localSet);
          ((Set)localObject).addAll(paramString);
          return localObject;
        }
        localObject = localSet;
      } while (localSet != null);
      return paramString;
    }
  }
  
  public static final class Builder
  {
    private final Map<String, Set<ByteString>> hostnameToPins = new LinkedHashMap();
    
    public Builder add(String paramString, String... paramVarArgs)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("hostname == null");
      }
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      paramString = (Set)this.hostnameToPins.put(paramString, Collections.unmodifiableSet(localLinkedHashSet));
      if (paramString != null) {
        localLinkedHashSet.addAll(paramString);
      }
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramString = paramVarArgs[i];
        if (!paramString.startsWith("sha1/")) {
          throw new IllegalArgumentException("pins must start with 'sha1/': " + paramString);
        }
        ByteString localByteString = ByteString.decodeBase64(paramString.substring("sha1/".length()));
        if (localByteString == null) {
          throw new IllegalArgumentException("pins must be base64: " + paramString);
        }
        localLinkedHashSet.add(localByteString);
        i += 1;
      }
      return this;
    }
    
    public CertificatePinner build()
    {
      return new CertificatePinner(this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.CertificatePinner
 * JD-Core Version:    0.7.0.1
 */