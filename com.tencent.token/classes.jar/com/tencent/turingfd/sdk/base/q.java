package com.tencent.turingfd.sdk.base;

import android.text.TextUtils;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class q
{
  public String a = "";
  public String b = "";
  public long c;
  public String d = new String(ed.c());
  
  public ac a()
  {
    Object localObject1 = null;
    Object localObject2 = new SecureRandom();
    Object localObject3 = new StringBuilder();
    int i = 0;
    while (i < 16)
    {
      ((StringBuilder)localObject3).append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(((SecureRandom)localObject2).nextInt(62)));
      i += 1;
    }
    this.b = ((StringBuilder)localObject3).toString();
    localObject2 = this.b;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      localObject2 = new Betelnut();
      ((Betelnut)localObject2).xb = ((byte[])localObject1);
      localObject1 = new ad(152, 10152, 0);
      ((ad)localObject1).d = ((float)localObject2);
      ((ad)localObject1).f = new Bilberry();
      return ((ad)localObject1).a();
      try
      {
        localObject3 = cn.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB", 0);
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
  }
  
  public void a(Bilberry paramBilberry)
  {
    this.c = (paramBilberry.zb * 1000 + System.currentTimeMillis());
    this.a = paramBilberry.D;
  }
  
  public boolean b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    if (l2 == 0L) {}
    while (l1 > l2) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.q
 * JD-Core Version:    0.7.0.1
 */