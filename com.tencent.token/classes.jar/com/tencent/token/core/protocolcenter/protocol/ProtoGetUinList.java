package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cq;
import com.tencent.token.dn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONObject;

public class ProtoGetUinList
  extends d
{
  cb d = cb.c();
  cq e = cq.a();
  
  protected String a()
  {
    this.d.m();
    String str1 = this.d.o();
    str1 = this.e.a(this.d.k(), str1);
    String str2 = bz.a().b();
    if (str2 == null)
    {
      this.a.b(104);
      return null;
    }
    str1 = "?aq_base_sid=" + str2 + "&data=" + str1;
    str1 = c.e() + "/cn/mbtoken3/mbtoken3_get_uin_list_v2" + str1;
    Log.i("login_test", "ProtoGetUinList");
    return str1;
  }
  
  protected void a(dn paramdn) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      TmsLog.i("mod_seed", "@getuin failed, errcode: " + i);
      if ((i == 122) || (i == 205)) {
        ProtoModSeed.a(true);
      }
      cq.a().n();
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      g.c("parseJSON =" + paramJSONObject.toString());
      try
      {
        long l = paramJSONObject.getLong("seed_expire_time");
        cb.c().c(l);
        TmsLog.i("mod_seed", "@getuin seed_expire_time:" + l);
        try
        {
          Object localObject = paramJSONObject.getString("seed");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = l.d((String)localObject);
            if (localObject != null)
            {
              cb.c().e();
              cb.c().a((byte[])localObject);
              cb.c().v();
              cb.c().i();
              ProtoModSeed.a(false);
            }
            TmsLog.i("mod_seed", "decode seed & compute seed @getuin sucess.");
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            TmsLog.e("mod_seed", "decode seed & compute seed @getuin failed: ", localException2);
            localException2.printStackTrace();
          }
          this.a.a(paramJSONObject);
          return;
        }
        paramJSONObject = this.e.a(paramJSONObject.getJSONArray("uinlist"));
        if (paramJSONObject.b())
        {
          this.e.k = true;
          if (this.e.m != 0L)
          {
            this.e.b(this.e.m);
            this.e.m = 0L;
          }
          this.a.c();
          return;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetUinList
 * JD-Core Version:    0.7.0.1
 */