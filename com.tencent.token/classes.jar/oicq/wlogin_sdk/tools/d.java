package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.report.event.c;
import oicq.wlogin_sdk.request.u;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private u a;
  
  public static d a()
  {
    return b.a;
  }
  
  private void f()
  {
    try
    {
      if (this.a == null)
      {
        util.LOGI("[pubkey]checkLocalPubKey g is null", "");
        return;
      }
      Object localObject = e();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        util.LOGI("[pubkey]checkLocalPubKey local empty", "");
        g();
        return;
      }
      c localc = a((String)localObject);
      if (localc == null)
      {
        c.a(new b("wtlogin_rotate_pub_key_error", "json_error", (String)localObject));
        util.LOGI("[pubkey]checkLocalPubKey value is null", "");
        g();
        return;
      }
      long l = d();
      if (localc.a * 1000 + l < System.currentTimeMillis())
      {
        localObject = new StringBuilder("[pubkey]checkLocalPubKey lastTime:");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" span:");
        ((StringBuilder)localObject).append(localc.a);
        util.LOGI(((StringBuilder)localObject).toString(), "");
        g();
        return;
      }
      util.LOGI("[pubkey]checkLocalPubKey span valid", "");
      if (!a(localc.b, localc.c, localc.d))
      {
        c.a(new b("wtlogin_rotate_pub_key_error", "key_error", ""));
        util.LOGI("[pubkey]checkLocalPubKey wrong sign", "");
        g();
        return;
      }
      util.LOGI("[pubkey]checkLocalPubKey sign valid", "");
      return;
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "checkLocalPubKey");
    }
  }
  
  private void g()
  {
    try
    {
      if (this.a == null)
      {
        util.LOGI("[pubkey]fetchPubKey g null", "");
        return;
      }
      Object localObject1;
      if (this.a.f == 0L) {
        localObject1 = "10000";
      } else {
        localObject1 = String.valueOf(this.a.f);
      }
      util.LOGI("[pubkey]fetchPubKey uin:".concat(String.valueOf(localObject1)), "");
      try
      {
        localObject1 = (HttpURLConnection)new URL(String.format("https://keyrotate.qq.com/rotate_key?cipher_suite_ver=%s&uin=%s", new Object[] { "305", localObject1 })).openConnection();
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        ((HttpURLConnection)localObject1).setConnectTimeout(this.a.l);
        ((HttpURLConnection)localObject1).setDoOutput(true);
        ((HttpURLConnection)localObject1).setDoInput(true);
        int i = ((HttpURLConnection)localObject1).getResponseCode();
        localObject2 = "[pubkey]response code=".concat(String.valueOf(i));
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.a.f);
        util.LOGI((String)localObject2, ((StringBuilder)localObject3).toString());
        if (200 == i)
        {
          localObject1 = ((HttpURLConnection)localObject1).getInputStream();
          localObject2 = new ByteArrayOutputStream();
          localObject3 = new byte[1024];
          for (;;)
          {
            i = ((InputStream)localObject1).read((byte[])localObject3);
            if (i == -1) {
              break;
            }
            ((ByteArrayOutputStream)localObject2).write((byte[])localObject3, 0, i);
          }
          ((ByteArrayOutputStream)localObject2).close();
          ((InputStream)localObject1).close();
          localObject1 = new String(((ByteArrayOutputStream)localObject2).toByteArray());
          util.LOGI("[pubkey]json:".concat(String.valueOf(localObject1)), "");
          localObject2 = a((String)localObject1);
          if (a(((c)localObject2).b, ((c)localObject2).c, ((c)localObject2).d))
          {
            b((String)localObject1);
            a(System.currentTimeMillis());
            return;
          }
          util.LOGI("[pubkey]fetchPubKey not valid", "");
        }
        return;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder("[pubkey]connect exception");
        ((StringBuilder)localObject2).append(localException.toString());
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        return;
      }
      catch (ConnectException localConnectException)
      {
        Object localObject2 = new StringBuilder("[pubkey]connect exception");
        ((StringBuilder)localObject2).append(localConnectException.toString());
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "fetchPubKey");
    }
  }
  
  public c a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        util.LOGI("[pubkey]parseJsonResult empty json", "");
        return null;
      }
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("QuerySpan", 0);
        paramString = paramString.optJSONObject("PubKeyMeta");
        if (paramString != null) {
          return new c(i, paramString.optInt("KeyVer", 0), paramString.optString("PubKey"), paramString.optString("PubKeySign"));
        }
        util.LOGI("[pubkey]parseJsonResult empty keyMetaObj", "");
        return null;
      }
      catch (JSONException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder("[pubkey]parseJsonResult exception");
        localStringBuilder.append(paramString.toString());
        util.LOGI(localStringBuilder.toString(), "");
        return null;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      util.printThrowable(paramString, "parseJsonResult");
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      Object localObject = u.u;
      if (localObject != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).edit();
        ((SharedPreferences.Editor)localObject).putLong("pubKeyTime", paramLong);
        ((SharedPreferences.Editor)localObject).commit();
        util.LOGI("[pubkey]saveReqTimeToSp time:".concat(String.valueOf(paramLong)), "");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "saveReqTimeToSp");
    }
  }
  
  public void a(u paramu)
  {
    this.a = paramu;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("305");
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append(paramString1);
      paramString1 = ((StringBuilder)localObject).toString();
      try
      {
        localObject = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuJTW4abQJXeVdAODw1CamZH4QJZChyT08ribet1Gp0wpSabIgyKFZAOxeArcCbknKyBrRY3FFI9HgY1AyItH8DOUe6ajDEb6c+vrgjgeCiOiCVyum4lI5Fmp38iHKH14xap6xGaXcBccdOZNzGT82sPDM2Oc6QYSZpfs8EO7TYT7KSB2gaHz99RQ4A/Lel1Vw0krk+DescN6TgRCaXjSGn268jD7lOO23x5JS1mavsUJtOZpXkK9GqCGSTCTbCwZhI33CpwdQ2EHLhiP5RaXZCio6lksu+d8sKTWU1eEiEb3cQ7nuZXLYH7leeYFoPtbFV4RicIWp0/YG+RP7rLPCwIDAQAB", 0)));
        Signature localSignature = Signature.getInstance("SHA256WithRSA");
        localSignature.initVerify((PublicKey)localObject);
        localSignature.update(paramString1.getBytes());
        boolean bool = localSignature.verify(Base64.decode(paramString2, 0));
        util.LOGI("[pubkey]checkPubKeyValid result:".concat(String.valueOf(bool)), "");
        return bool;
      }
      catch (SignatureException paramString1)
      {
        paramString2 = new StringBuilder("[pubkey]checkPubKeyValid ");
        paramString2.append(paramString1.toString());
        util.LOGI(paramString2.toString(), "");
        return false;
      }
      catch (InvalidKeyException paramString1)
      {
        paramString2 = new StringBuilder("[pubkey]checkPubKeyValid ");
        paramString2.append(paramString1.toString());
        util.LOGI(paramString2.toString(), "");
        return false;
      }
      catch (InvalidKeySpecException paramString1)
      {
        paramString2 = new StringBuilder("[pubkey]checkPubKeyValid ");
        paramString2.append(paramString1.toString());
        util.LOGI(paramString2.toString(), "");
        return false;
      }
      catch (NoSuchAlgorithmException paramString1)
      {
        paramString2 = new StringBuilder("[pubkey]checkPubKeyValid ");
        paramString2.append(paramString1.toString());
        util.LOGI(paramString2.toString(), "");
        return false;
      }
      return false;
    }
    catch (Throwable paramString1)
    {
      util.printThrowable(paramString1, "checkPubKeyValid");
    }
  }
  
  public void b()
  {
    new Thread(new a(), "PubKeyRotater").start();
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = u.u;
        if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
        {
          localObject = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).edit();
          ((SharedPreferences.Editor)localObject).putString("pubKey", paramString);
          ((SharedPreferences.Editor)localObject).commit();
          localObject = new StringBuilder("[pubkey]savePubKeyToFile json:");
          if (paramString != null)
          {
            i = paramString.length();
            ((StringBuilder)localObject).append(i);
            util.LOGI(((StringBuilder)localObject).toString(), "");
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramString)
      {
        util.printThrowable(paramString, "savePubKeyToFile");
        return;
      }
      int i = 0;
    }
  }
  
  public Pair<String, Integer> c()
  {
    try
    {
      Object localObject = e();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        util.LOGI("[pubkey]syncGetPubKey json is empty");
        return null;
      }
      localObject = a((String)localObject);
      if (localObject == null)
      {
        util.LOGI("[pubkey]syncGetPubKey value is null");
        return null;
      }
      if (!a(((c)localObject).b, ((c)localObject).c, ((c)localObject).d))
      {
        util.LOGI("[pubkey]syncGetPubKey key sign not right");
        return null;
      }
      localObject = new Pair(((c)localObject).c, Integer.valueOf(((c)localObject).b));
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "syncGetPubKey");
    }
    return null;
  }
  
  public long d()
  {
    for (;;)
    {
      try
      {
        Context localContext = u.u;
        if (localContext != null)
        {
          l = localContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 4).getLong("pubKeyTime", 0L);
          util.LOGI("[pubkey]getReqTimeFromSp ".concat(String.valueOf(l)), "");
          return l;
        }
      }
      catch (Throwable localThrowable)
      {
        util.printThrowable(localThrowable, "getReqTimeFromSp");
        return 0L;
      }
      long l = 0L;
    }
  }
  
  public String e()
  {
    for (;;)
    {
      try
      {
        Object localObject = u.u;
        String str = "";
        if (localObject != null) {
          str = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).getString("pubKey", "");
        }
        localObject = new StringBuilder("[pubkey]getPubKeyFromFile ");
        if (str != null)
        {
          i = str.length();
          ((StringBuilder)localObject).append(i);
          util.LOGI(((StringBuilder)localObject).toString(), "");
          return str;
        }
      }
      catch (Throwable localThrowable)
      {
        util.printThrowable(localThrowable, "savePubKeyToFile");
        return "";
      }
      int i = 0;
    }
  }
  
  public static final class a
    implements Runnable
  {
    public final void run()
    {
      util.LOGI("[pubkey]start check local pub key", "");
      d.a(d.a());
    }
  }
  
  static final class b
  {
    public static final d a = new d(null);
  }
  
  public static class c
  {
    public int a;
    public int b;
    public String c;
    public String d;
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString1;
      this.d = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.d
 * JD-Core Version:    0.7.0.1
 */