package com.tencent.turingfd.sdk.base;

import android.text.TextUtils;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class d
{
  public String a = "";
  public String b = "";
  public long c = 0L;
  public long d = 0L;
  public String e = new String(cm.b());
  
  public o a()
  {
    Object localObject1 = new SecureRandom();
    Object localObject2 = new StringBuilder();
    int i = 0;
    while (i < 16)
    {
      ((StringBuilder)localObject2).append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(((SecureRandom)localObject1).nextInt(62)));
      i += 1;
    }
    this.b = ((StringBuilder)localObject2).toString();
    localObject2 = this.b;
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    localObject1 = null;
    if (!bool) {
      try
      {
        Object localObject3 = bu.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB", 0);
        localObject3 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject3));
        Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(1, (Key)localObject3);
        localObject2 = localCipher.doFinal(((String)localObject2).getBytes());
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    instanceof localinstanceof = new instanceof();
    localinstanceof.mb = ((byte[])localObject1);
    localObject1 = new o.b(152, 10152, 0);
    ((o.b)localObject1).d = localinstanceof;
    ((o.b)localObject1).f = new synchronized();
    return ((o.b)localObject1).a();
  }
  
  public void a(synchronized paramsynchronized)
  {
    this.c = System.currentTimeMillis();
    this.d = (paramsynchronized.ob * 1000 / 10);
    this.a = paramsynchronized.A;
  }
  
  public boolean b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    if (l2 == 0L) {
      return true;
    }
    return Math.abs(l1 - l2) >= this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.d
 * JD-Core Version:    0.7.0.1
 */