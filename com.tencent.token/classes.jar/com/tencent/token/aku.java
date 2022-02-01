package com.tencent.token;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class aku
  implements HostnameVerifier
{
  public static final aku a = new aku();
  
  public static List<String> a(X509Certificate paramX509Certificate)
  {
    List localList = a(paramX509Certificate, 7);
    paramX509Certificate = a(paramX509Certificate, 2);
    ArrayList localArrayList = new ArrayList(localList.size() + paramX509Certificate.size());
    localArrayList.addAll(localList);
    localArrayList.addAll(paramX509Certificate);
    return localArrayList;
  }
  
  private static List<String> a(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null) {
        return Collections.emptyList();
      }
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        Object localObject = (List)paramX509Certificate.next();
        if ((localObject != null) && (((List)localObject).size() >= 2))
        {
          Integer localInteger = (Integer)((List)localObject).get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            localObject = (String)((List)localObject).get(1);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      return localArrayList;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      label115:
      break label115;
    }
    return Collections.emptyList();
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (!paramString1.startsWith(".")))
    {
      if (paramString1.endsWith("..")) {
        return false;
      }
      if ((paramString2 != null) && (paramString2.length() != 0) && (!paramString2.startsWith(".")))
      {
        if (paramString2.endsWith("..")) {
          return false;
        }
        Object localObject = paramString1;
        if (!paramString1.endsWith("."))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append('.');
          localObject = ((StringBuilder)localObject).toString();
        }
        paramString1 = paramString2;
        if (!paramString2.endsWith("."))
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append('.');
          paramString1 = paramString1.toString();
        }
        paramString1 = paramString1.toLowerCase(Locale.US);
        if (!paramString1.contains("*")) {
          return ((String)localObject).equals(paramString1);
        }
        if (paramString1.startsWith("*."))
        {
          if (paramString1.indexOf('*', 1) != -1) {
            return false;
          }
          if (((String)localObject).length() < paramString1.length()) {
            return false;
          }
          if ("*.".equals(paramString1)) {
            return false;
          }
          paramString1 = paramString1.substring(1);
          if (!((String)localObject).endsWith(paramString1)) {
            return false;
          }
          int i = ((String)localObject).length() - paramString1.length();
          return (i <= 0) || (((String)localObject).lastIndexOf('.', i - 1) == -1);
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  public static boolean a(String paramString, X509Certificate paramX509Certificate)
  {
    if (aiw.c(paramString)) {
      return b(paramString, paramX509Certificate);
    }
    return c(paramString, paramX509Certificate);
  }
  
  private static boolean b(String paramString, X509Certificate paramX509Certificate)
  {
    paramX509Certificate = a(paramX509Certificate, 7);
    int j = paramX509Certificate.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equalsIgnoreCase((String)paramX509Certificate.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean c(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = paramString.toLowerCase(Locale.US);
    paramX509Certificate = a(paramX509Certificate, 2).iterator();
    while (paramX509Certificate.hasNext()) {
      if (a(paramString, (String)paramX509Certificate.next())) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = a(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aku
 * JD-Core Version:    0.7.0.1
 */