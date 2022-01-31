package wf7;

import android.content.Context;
import android.text.TextUtils;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Random;
import javax.crypto.Cipher;

public class ej
{
  private final String TAG = "RsaKeyCertifier";
  private Object hx = new Object();
  private em lT;
  private dx mv;
  
  public ej(Context paramContext, em paramem)
  {
    this.lT = paramem;
    this.mv = new dx();
    cN();
  }
  
  private String ah(int paramInt)
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
  
  private void cN()
  {
    dx localdx = this.lT.cT().bY();
    if (localdx != null) {
      synchronized (this.hx)
      {
        this.mv.lv = localdx.lv;
        this.mv.lu = localdx.lu;
        return;
      }
    }
  }
  
  private void g(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    synchronized (this.hx)
    {
      this.mv.lv = paramString1;
      this.mv.lu = paramString2;
      this.lT.cT().a(this.mv);
      return;
    }
  }
  
  private byte[] z(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = de.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB", 0);
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
  
  public void a(ej.a parama)
  {
    int i = ew.dg().di();
    String str = ah(16);
    Object localObject = z(str);
    if (localObject == null)
    {
      parama.a(i, 152, -20001000);
      return;
    }
    r localr = new r();
    localr.bP = ((byte[])localObject);
    localObject = new ArrayList();
    x localx = new x();
    localx.bZ = i;
    localx.bH = 152;
    localx.cf |= 0x2;
    localx.data = ee.a(null, localr, localx.bH, localx);
    ((ArrayList)localObject).add(localx);
    el.cP().a(localx.bZ, -1L, null);
    this.lT.a((ArrayList)localObject, new ej.1(this, str, localx, parama, i));
  }
  
  public dx cO()
  {
    dx localdx = new dx();
    synchronized (this.hx)
    {
      localdx.lu = this.mv.lu;
      localdx.lv = this.mv.lv;
      return localdx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.ej
 * JD-Core Version:    0.7.0.1
 */