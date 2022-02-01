package com.tencent.token;

import android.text.TextUtils;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import javax.crypto.Cipher;

public final class aqc
{
  volatile long a;
  private final String b = "RsaKeyCertifier";
  private aqg c;
  private Object d = new Object();
  private aqd e;
  
  public aqc(aqg arg1)
  {
    this.c = ???;
    this.e = new aqd();
    synchronized (this.d)
    {
      b(this.c.a.c());
      a(this.c.a.d());
      this.a = 0L;
      ??? = new StringBuilder("load() mEncodeKey: ");
      ???.append(c());
      ???.append(" mSessionId: ");
      ???.append(a());
      ??? = new StringBuilder("[ocean]info: Refh: sessionId|");
      ???.append(a());
      ???.append("|encodeKey|");
      ???.append(c());
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.d)
    {
      this.e.a = paramString;
      return;
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.d)
    {
      this.e.b = paramString;
      return;
    }
  }
  
  private static byte[] c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = arl.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB");
      localObject = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject));
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, (Key)localObject);
      paramString = localCipher.doFinal(paramString.getBytes());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  final String a()
  {
    synchronized (this.d)
    {
      if (this.e.a == null) {
        return "";
      }
      String str = this.e.a;
      return str;
    }
  }
  
  public final boolean a(AtomicReference paramAtomicReference)
  {
    if (paramAtomicReference != null)
    {
      ??? = new aqd();
      ((aqd)???).a = a();
      ((aqd)???).b = c();
      paramAtomicReference.set(???);
    }
    paramAtomicReference = new Random();
    ??? = new StringBuffer();
    int i = 0;
    while (i < 16)
    {
      ((StringBuffer)???).append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(paramAtomicReference.nextInt(62)));
      i += 1;
    }
    b(((StringBuffer)???).toString());
    paramAtomicReference = new ae();
    ??? = c(c());
    if (??? != null)
    {
      paramAtomicReference.a = ((byte[])???);
      new StringBuilder("updataRsaKey() reqRSA.enc: ").append(apa.a(paramAtomicReference.a));
      ??? = new ai();
      ((ai)???).b = this.c.b.a();
      ((ai)???).a = 152;
      ((ai)???).d = apt.a(paramAtomicReference);
      paramAtomicReference = new ArrayList();
      paramAtomicReference.add(???);
      ??? = new AtomicReference();
      if (this.c.a(true, false, false, null, paramAtomicReference, (AtomicReference)???) != 0) {
        return false;
      }
      paramAtomicReference = (ArrayList)((AtomicReference)???).get();
      if (paramAtomicReference == null) {
        return false;
      }
      if (paramAtomicReference.size() <= 0) {
        return false;
      }
      paramAtomicReference = (al)paramAtomicReference.get(0);
      if (paramAtomicReference == null) {
        return false;
      }
      ??? = new StringBuilder("updataRsaKey() rs.seqNo: ");
      ((StringBuilder)???).append(paramAtomicReference.b);
      ((StringBuilder)???).append(" rs.cmd: ");
      ((StringBuilder)???).append(paramAtomicReference.a);
      ((StringBuilder)???).append(" rs.retCode: ");
      ((StringBuilder)???).append(paramAtomicReference.d);
      ((StringBuilder)???).append(" rs.dataRetCode: ");
      ((StringBuilder)???).append(paramAtomicReference.e);
      if (1 == paramAtomicReference.d) {
        return false;
      }
      if (paramAtomicReference.e != 0)
      {
        new StringBuilder("updataRsaKey() rs.dataRetCode: ").append(paramAtomicReference.e);
        return false;
      }
      ??? = paramAtomicReference.f;
      if (??? == null) {
        return false;
      }
      new StringBuilder("updataRsaKey() rs.data.length: ").append(paramAtomicReference.f.length);
      paramAtomicReference = new af();
    }
    try
    {
      ??? = apt.b((byte[])???);
      if (??? == null) {
        paramAtomicReference = null;
      } else {
        paramAtomicReference = apz.a((byte[])???, paramAtomicReference);
      }
      if (paramAtomicReference == null) {
        return false;
      }
      paramAtomicReference = (af)paramAtomicReference;
      if ((!TextUtils.isEmpty(c())) && (!TextUtils.isEmpty(paramAtomicReference.a))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return false;
      }
      ??? = new StringBuilder("[ocean]info: Chgd befor: sessionId|");
      ((StringBuilder)???).append(a());
      ((StringBuilder)???).append("|encodeKey|");
      ((StringBuilder)???).append(c());
      synchronized (this.d)
      {
        String str = c();
        if (!TextUtils.isEmpty(str))
        {
          b(str);
          this.c.a.a(c());
        }
        str = paramAtomicReference.a;
        if (!TextUtils.isEmpty(str))
        {
          a(str);
          this.c.a.b(a());
        }
        ??? = new StringBuilder("updataRsaKey() mEncodeKey: ");
        ((StringBuilder)???).append(c());
        ((StringBuilder)???).append(" mSessionId: ");
        ((StringBuilder)???).append(paramAtomicReference.a);
        ??? = new StringBuilder("[ocean]info: Chgd after: sessionId|");
        ((StringBuilder)???).append(paramAtomicReference.a);
        ((StringBuilder)???).append("|encodeKey|");
        ((StringBuilder)???).append(c());
        return true;
      }
      throw new RuntimeException("dyKey is null");
    }
    catch (Exception paramAtomicReference) {}
    return false;
  }
  
  public final aqd b()
  {
    aqd localaqd = new aqd();
    localaqd.a = this.e.a;
    localaqd.b = this.e.b;
    return localaqd;
  }
  
  final String c()
  {
    synchronized (this.d)
    {
      if (this.e.b == null) {
        return "";
      }
      String str = this.e.b;
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqc
 * JD-Core Version:    0.7.0.1
 */