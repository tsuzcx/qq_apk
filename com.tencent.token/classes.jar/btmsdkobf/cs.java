package btmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.jx;
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
  private b im;
  
  public cs(Context paramContext, cy paramcy)
  {
    this.hF = paramcy;
    this.im = new b();
    C();
  }
  
  private void C()
  {
    Object localObject2 = this.hF.bL().aA();
    if (localObject2 != null) {
      synchronized (this.V)
      {
        this.im.is = ((b)localObject2).is;
        this.im.ir = ((b)localObject2).ir;
        localObject2 = new StringBuilder("[rsa_key]load(), mEncodeKey: ");
        ((StringBuilder)localObject2).append(this.im.is);
        ((StringBuilder)localObject2).append(" mSessionId: ");
        ((StringBuilder)localObject2).append(this.im.ir);
        eh.f("RsaKeyCertifier", ((StringBuilder)localObject2).toString());
        return;
      }
    }
    eh.g("RsaKeyCertifier", "[rsa_key]load(), no record!");
  }
  
  static void a(Context paramContext, int paramInt, b paramb)
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
      eh.a("RsaKeyCertifier", "[rsa_key]sendBroadcast(): ".concat(String.valueOf(paramContext)), paramContext);
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      synchronized (this.V)
      {
        this.im.is = paramString1;
        this.im.ir = paramString2;
        this.hF.bL().b(this.im);
        return;
      }
    }
    ??? = new StringBuilder("[rsa_key] saveRsaKey(), argument is null! encodeKey: ");
    ((StringBuilder)???).append(paramString1);
    ((StringBuilder)???).append(" sessionId: ");
    ((StringBuilder)???).append(paramString2);
    eh.h("RsaKeyCertifier", ((StringBuilder)???).toString());
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
      eh.a("RsaKeyCertifier", "[rsa_key]requestSendProcessUpdateRsaKey(): ".concat(String.valueOf(paramContext)), paramContext);
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
  
  public void a(final a parama)
  {
    eh.e("RsaKeyCertifier", "[rsa_key]updateRsaKey()");
    final int i = cu.bu().bm();
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
    localObject = new StringBuilder("[rsa_key]updateRsaKey() reqRSA.enc: ");
    ((StringBuilder)localObject).append(ConvertUtil.bytesToHexString(localal.bP));
    eh.f("RsaKeyCertifier", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    final as localas = new as();
    localas.dc = i;
    localas.bM = 152;
    localas.di |= 0x2;
    localas.data = cd.a(null, localal, localas.bM, localas);
    ((ArrayList)localObject).add(localas);
    cv.by().a(localas.dc, -1L, null);
    this.hF.a((ArrayList)localObject, new jx(str)
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
      {
        Object localObject = new StringBuilder("[rsa_key]updateRsaKey(), isTcpChannel: ");
        ((StringBuilder)localObject).append(paramAnonymousBoolean);
        ((StringBuilder)localObject).append(", seqNo ");
        ((StringBuilder)localObject).append(localas.dc);
        ((StringBuilder)localObject).append(", retCode: ");
        ((StringBuilder)localObject).append(paramAnonymousInt1);
        eh.f("RsaKeyCertifier", ((StringBuilder)localObject).toString());
        if (paramAnonymousInt1 != 0)
        {
          eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), retCode: ".concat(String.valueOf(paramAnonymousInt1)));
          parama.a(i, 152, paramAnonymousInt1);
          return;
        }
        if (paramAnonymousArrayList == null)
        {
          eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), null == serverSashimis");
          parama.a(i, 152, -21250000);
          return;
        }
        if (paramAnonymousArrayList.size() <= 0)
        {
          eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), serverSashimis.size() <= 0");
          parama.a(i, 152, -21250000);
          return;
        }
        paramAnonymousArrayList = (ba)paramAnonymousArrayList.get(0);
        if (paramAnonymousArrayList == null)
        {
          eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), serverSashimi is null");
          parama.a(i, 152, -21250000);
          return;
        }
        if (paramAnonymousArrayList.df != 0)
        {
          localObject = new StringBuilder("[rsa_key]updateRsaKey(), mazu error: ");
          ((StringBuilder)localObject).append(paramAnonymousArrayList.df);
          eh.h("RsaKeyCertifier", ((StringBuilder)localObject).toString());
          parama.a(i, 152, paramAnonymousArrayList.df);
          return;
        }
        if (paramAnonymousArrayList.dg != 0)
        {
          localObject = new StringBuilder("[rsa_key]updateRsaKey(), rs.dataRetCode: ");
          ((StringBuilder)localObject).append(paramAnonymousArrayList.dg);
          eh.h("RsaKeyCertifier", ((StringBuilder)localObject).toString());
          parama.a(i, 152, -21300000);
          return;
        }
        if (paramAnonymousArrayList.data == null)
        {
          eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), null == rs.data");
          parama.a(i, 152, -21000005);
          return;
        }
        localObject = new am();
        try
        {
          paramAnonymousArrayList = cd.a(null, this.e.getBytes(), paramAnonymousArrayList.data, (JceStruct)localObject, false, paramAnonymousArrayList.di);
          if (paramAnonymousArrayList == null)
          {
            eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), decode jce failed: null == js");
            parama.a(i, 152, -21000400);
            return;
          }
          paramAnonymousArrayList = (am)paramAnonymousArrayList;
          if (TextUtils.isEmpty(paramAnonymousArrayList.sessionId))
          {
            eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), ret.sessionId is null");
            parama.a(i, 152, -21280000);
            return;
          }
          cs.a(cs.this, this.e, paramAnonymousArrayList.sessionId);
          localObject = new StringBuilder("[rsa_key]updateRsaKey(), encodeKey: ");
          ((StringBuilder)localObject).append(this.e);
          ((StringBuilder)localObject).append(" sessionId: ");
          ((StringBuilder)localObject).append(paramAnonymousArrayList.sessionId);
          eh.f("RsaKeyCertifier", ((StringBuilder)localObject).toString());
          parama.a(i, 152, 0);
          return;
        }
        catch (Exception paramAnonymousArrayList)
        {
          eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), decode jce exception: ".concat(String.valueOf(paramAnonymousArrayList)));
          parama.a(i, 152, -21000400);
        }
      }
    });
  }
  
  public b ai()
  {
    b localb = new b();
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
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static class b
  {
    public volatile String ir = "";
    public volatile String is = "";
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSessionId: ");
      localStringBuilder.append(this.ir);
      localStringBuilder.append(" mEncodeKey: ");
      localStringBuilder.append(this.is);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cs
 * JD-Core Version:    0.7.0.1
 */