package com.tencent.token;

import android.text.TextUtils;
import com.tencent.turingfd.sdk.base.instanceof;
import com.tencent.turingfd.sdk.base.synchronized;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class abp
{
  public String a = "";
  public String b = "";
  public long c = 0L;
  public long d = 0L;
  public String e = new String(aey.b());
  
  public final acb a()
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
        Object localObject3 = aeg.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB");
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
    localObject1 = new acb.a(152, 10152, 0);
    ((acb.a)localObject1).d = localinstanceof;
    ((acb.a)localObject1).f = new synchronized();
    return ((acb.a)localObject1).a();
  }
  
  public final void a(synchronized paramsynchronized)
  {
    this.c = System.currentTimeMillis();
    this.d = (paramsynchronized.ob * 1000 / 10);
    this.a = paramsynchronized.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abp
 * JD-Core Version:    0.7.0.1
 */