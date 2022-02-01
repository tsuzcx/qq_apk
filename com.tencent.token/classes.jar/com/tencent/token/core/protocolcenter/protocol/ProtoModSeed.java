package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cq;
import com.tencent.token.dn;
import com.tencent.token.ec;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.global.k;
import com.tencent.token.utils.b;
import com.tencent.token.utils.l;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoModSeed
  extends d
{
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ec.a("mod_seed_err_111", i);
      if (paramBoolean)
      {
        cq.a().t();
        Handler localHandler = new Handler(Looper.getMainLooper());
        localHandler.post(new Runnable()
        {
          public void run()
          {
            Toast.makeText(RqdApplication.l(), "令牌校验失败，请重新打开应用", 0).show();
          }
        });
        localHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            System.exit(0);
          }
        }, 2000L);
      }
      return;
    }
  }
  
  public static boolean e()
  {
    boolean bool = false;
    if (ec.b("mod_seed_err_111", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  protected String a()
  {
    String str1 = bz.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject1 = "";
    Object localObject2 = cb.c();
    ((cb)localObject2).m();
    String str2 = ((cb)localObject2).o();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = ca.a + 1;
      ca.a = i;
      this.c = i;
      localJSONObject.put("seq_id", this.c);
      localJSONObject.put("tkn_code", str2);
      localJSONObject.put("tkn_seq", String.valueOf(((cb)localObject2).k()));
      localJSONObject.put("turingd_ticket_id", k.c());
      TmsLog.i("mod_seed", "seed mod seq_id: " + this.c + " token_code: " + str2 + " tkn_seq:" + String.valueOf(((cb)localObject2).k()) + " ticket_id:" + k.c() + " seed hex:" + l.a(((cb)localObject2).f()) + " seed base64:" + b.a(((cb)localObject2).f()));
      localObject2 = l.b(localJSONObject.toString().getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localObject1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject1;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_mod_seed" + (String)localObject1;
    TmsLog.i("mod_seed", "seed mod url: " + (String)localObject1);
    return localObject1;
  }
  
  protected void a(dn paramdn) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      TmsLog.i("mod_seed", "@mod_seed failed, errcode: " + i);
      if ((i == 122) || (i == 205)) {
        a(true);
      }
      return;
    }
    TmsLog.i("mod_seed", "@mod_seed  start parse json.");
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      long l1 = paramJSONObject.getLong("seed_expire_time");
      cb.c().c(l1);
      TmsLog.i("mod_seed", "@mod_seed seed recv, String: " + l.a(paramJSONObject.getString("seed").getBytes()));
      byte[] arrayOfByte = l.d(paramJSONObject.getString("seed"));
      if (arrayOfByte != null)
      {
        TmsLog.i("mod_seed", "@mod_seed seed recv, hex: " + l.a(arrayOfByte));
        cb.c().e();
        cb.c().a(arrayOfByte);
        cb.c().i();
      }
      for (;;)
      {
        long l2 = paramJSONObject.getLong("server_time");
        cb.c().b(l2);
        TmsLog.i("mod_seed", "@mod_seed recv data, servertime: " + l2 + " seedExpireTime: " + l1);
        cb.c().u();
        a(false);
        this.a.c();
        return;
        TmsLog.i("mod_seed", "@mod_seed seed recv null");
      }
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoModSeed
 * JD-Core Version:    0.7.0.1
 */