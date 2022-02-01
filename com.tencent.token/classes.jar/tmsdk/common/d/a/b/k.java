package tmsdk.common.d.a.b;

import a.e.c;
import android.content.Context;
import android.text.TextUtils;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import javax.crypto.Cipher;
import tmsdk.common.c.a.d;
import tmsdk.common.c.a.e;

public class k
{
  private final String a = "RsaKeyCertifier";
  private o b;
  private Object c = new Object();
  private l d;
  private volatile long e;
  
  public k(Context paramContext, o paramo)
  {
    this.b = paramo;
    this.d = new l();
    e();
  }
  
  private String a(int paramInt)
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(localRandom.nextInt(62)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.c)
    {
      this.d.a = paramString;
      return;
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.c)
    {
      this.d.b = paramString;
      return;
    }
  }
  
  private String c()
  {
    synchronized (this.c)
    {
      if (this.d.a == null) {
        return "";
      }
      String str = this.d.a;
      return str;
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(paramString);
    this.b.a().a(d());
  }
  
  private String d()
  {
    synchronized (this.c)
    {
      if (this.d.b == null) {
        return "";
      }
      String str = this.d.b;
      return str;
    }
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString);
    this.b.a().b(c());
  }
  
  private void e()
  {
    synchronized (this.c)
    {
      b(this.b.a().d());
      a(this.b.a().e());
      this.e = this.b.a().q();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("load() mEncodeKey: ");
      ((StringBuilder)???).append(d());
      ((StringBuilder)???).append(" mSessionId: ");
      ((StringBuilder)???).append(c());
      ((StringBuilder)???).toString();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[ocean]info: Refh: sessionId|");
      ((StringBuilder)???).append(c());
      ((StringBuilder)???).append("|encodeKey|");
      ((StringBuilder)???).append(d());
      ((StringBuilder)???).toString();
      return;
    }
  }
  
  private byte[] e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = tmsdk.common.e.a.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB", 0);
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
  
  private void f()
  {
    b(a(16));
  }
  
  public l a()
  {
    l locall = new l();
    locall.a = this.d.a;
    locall.b = this.d.b;
    return locall;
  }
  
  public boolean a(AtomicReference paramAtomicReference)
  {
    if (paramAtomicReference != null)
    {
      ??? = new l();
      ((l)???).a = c();
      ((l)???).b = d();
      paramAtomicReference.set(???);
    }
    f();
    paramAtomicReference = new a.d.a();
    ??? = e(d());
    int i;
    if (??? != null)
    {
      paramAtomicReference.a = ((byte[])???);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("updataRsaKey() reqRSA.enc: ");
      ((StringBuilder)???).append(d.a(paramAtomicReference.a));
      ((StringBuilder)???).toString();
      ??? = new c();
      ((c)???).b = this.b.c().a();
      ((c)???).a = 152;
      ((c)???).d = b.a(paramAtomicReference);
      paramAtomicReference = new ArrayList();
      paramAtomicReference.add(???);
      ??? = new AtomicReference();
      i = this.b.a(true, false, false, null, paramAtomicReference, (AtomicReference)???);
      if (i != 0)
      {
        paramAtomicReference = new StringBuilder();
        paramAtomicReference.append("updataRsaKey() ESharkCode.ERR_NONE != retCode, retCode: ");
        paramAtomicReference.append(i);
        paramAtomicReference.toString();
        return false;
      }
      paramAtomicReference = (ArrayList)((AtomicReference)???).get();
      if (paramAtomicReference == null) {
        return false;
      }
      if (paramAtomicReference.size() <= 0) {
        return false;
      }
      paramAtomicReference = (a.e.f)paramAtomicReference.get(0);
      if (paramAtomicReference == null) {
        return false;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("updataRsaKey() rs.seqNo: ");
      ((StringBuilder)???).append(paramAtomicReference.b);
      ((StringBuilder)???).append(" rs.cmd: ");
      ((StringBuilder)???).append(paramAtomicReference.a);
      ((StringBuilder)???).append(" rs.retCode: ");
      ((StringBuilder)???).append(paramAtomicReference.d);
      ((StringBuilder)???).append(" rs.dataRetCode: ");
      ((StringBuilder)???).append(paramAtomicReference.e);
      ((StringBuilder)???).toString();
      if (1 == paramAtomicReference.d) {
        return false;
      }
      if (paramAtomicReference.e != 0)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("updataRsaKey() rs.dataRetCode: ");
        ((StringBuilder)???).append(paramAtomicReference.e);
        ((StringBuilder)???).toString();
        return false;
      }
      ??? = paramAtomicReference.f;
      if (??? == null) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updataRsaKey() rs.data.length: ");
      localStringBuilder.append(paramAtomicReference.f.length);
      localStringBuilder.toString();
      paramAtomicReference = new a.d.b();
    }
    try
    {
      paramAtomicReference = b.a((byte[])???, paramAtomicReference);
      if (paramAtomicReference == null) {
        return false;
      }
      paramAtomicReference = (a.d.b)paramAtomicReference;
      if ((!TextUtils.isEmpty(d())) && (!TextUtils.isEmpty(paramAtomicReference.a))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return false;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[ocean]info: Chgd befor: sessionId|");
      ((StringBuilder)???).append(c());
      ((StringBuilder)???).append("|encodeKey|");
      ((StringBuilder)???).append(d());
      ((StringBuilder)???).toString();
      synchronized (this.c)
      {
        c(d());
        d(paramAtomicReference.a);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("updataRsaKey() mEncodeKey: ");
        ((StringBuilder)???).append(d());
        ((StringBuilder)???).append(" mSessionId: ");
        ((StringBuilder)???).append(paramAtomicReference.a);
        ((StringBuilder)???).toString();
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[ocean]info: Chgd after: sessionId|");
        ((StringBuilder)???).append(paramAtomicReference.a);
        ((StringBuilder)???).append("|encodeKey|");
        ((StringBuilder)???).append(d());
        ((StringBuilder)???).toString();
        return true;
      }
      throw new RuntimeException("dyKey is null");
    }
    catch (Exception paramAtomicReference) {}
    return false;
  }
  
  public int b()
  {
    int i;
    if ((!TextUtils.isEmpty(d())) && (!TextUtils.isEmpty(c()))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return 0;
    }
    long l = System.currentTimeMillis();
    if (!e.b(l, this.e, 10)) {
      return -700;
    }
    this.e = l;
    this.b.a();
    l = this.e;
    boolean bool = a(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkRsaKey() 首次交换密钥是否成功：");
    localStringBuilder.append(bool);
    localStringBuilder.toString();
    if (!bool) {
      return -100;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.k
 * JD-Core Version:    0.7.0.1
 */