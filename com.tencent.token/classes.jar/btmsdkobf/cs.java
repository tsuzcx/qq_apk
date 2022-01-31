package btmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tmsdk.base.utils.ConvertUtil;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;

public class cs
{
  private Object V = new Object();
  private cy hF;
  private cs.b im;
  
  public cs(Context paramContext, cy paramcy)
  {
    this.hF = paramcy;
    this.im = new cs.b();
    C();
  }
  
  private void C()
  {
    cs.b localb = this.hF.bL().aA();
    if (localb != null) {
      synchronized (this.V)
      {
        this.im.is = localb.is;
        this.im.ir = localb.ir;
        eh.f("RsaKeyCertifier", "[rsa_key]load(), mEncodeKey: " + this.im.is + " mSessionId: " + this.im.ir);
        return;
      }
    }
    eh.g("RsaKeyCertifier", "[rsa_key]load(), no record!");
  }
  
  static void a(Context paramContext, int paramInt, cs.b paramb)
  {
    try
    {
      Intent localIntent = new Intent(String.format("action.rsa.got:%s", new Object[] { paramContext.getPackageName() }));
      localIntent.setPackage(paramContext.getPackageName());
      localIntent.putExtra("k.rc", paramInt);
      if ((paramInt == 0) && (paramb != null))
      {
        localIntent.putExtra("k.r.k", paramb.is);
        localIntent.putExtra("k.r.s", paramb.ir);
      }
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      eh.a("RsaKeyCertifier", "[rsa_key]sendBroadcast(): " + paramContext, paramContext);
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      eh.h("RsaKeyCertifier", "[rsa_key] saveRsaKey(), argument is null! encodeKey: " + paramString1 + " sessionId: " + paramString2);
      return;
    }
    synchronized (this.V)
    {
      this.im.is = paramString1;
      this.im.ir = paramString2;
      this.hF.bL().b(this.im);
      return;
    }
  }
  
  static void g(Context paramContext)
  {
    try
    {
      eh.f("RsaKeyCertifier", "[rsa_key]requestSendProcessUpdateRsaKey()");
      Intent localIntent = new Intent(String.format("action.up.rsa:%s", new Object[] { paramContext.getPackageName() }));
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      eh.a("RsaKeyCertifier", "[rsa_key]requestSendProcessUpdateRsaKey(): " + paramContext, paramContext);
    }
  }
  
  private String v(int paramInt)
  {
    SecureRandom localSecureRandom = new SecureRandom();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(localSecureRandom.nextInt(62)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private byte[] x(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = dw.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB", 0);
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
  
  public void a(cs.a parama)
  {
    eh.e("RsaKeyCertifier", "[rsa_key]updateRsaKey()");
    int i = cu.bu().bm();
    String str = v(16);
    Object localObject = x(str);
    if (localObject == null)
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), gen dynamic key failed");
      parama.a(i, 152, -20001000);
      return;
    }
    al localal = new al();
    localal.bP = ((byte[])localObject);
    eh.f("RsaKeyCertifier", "[rsa_key]updateRsaKey() reqRSA.enc: " + ConvertUtil.bytesToHexString(localal.bP));
    localObject = new ArrayList();
    as localas = new as();
    localas.dc = i;
    localas.bM = 152;
    localas.di |= 0x2;
    localas.data = cd.a(null, localal, localas.bM, localas);
    ((ArrayList)localObject).add(localas);
    cv.by().a(localas.dc, -1L, null);
    this.hF.a((ArrayList)localObject, new fu(this, str, localas, parama, i));
  }
  
  public cs.b ai()
  {
    cs.b localb = new cs.b();
    synchronized (this.V)
    {
      localb.ir = this.im.ir;
      localb.is = this.im.is;
      return localb;
    }
  }
  
  public void refresh()
  {
    eh.f("RsaKeyCertifier", "refresh()");
    C();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cs
 * JD-Core Version:    0.7.0.1
 */