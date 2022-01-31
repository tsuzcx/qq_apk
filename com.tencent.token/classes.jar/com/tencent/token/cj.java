package com.tencent.token;

import android.os.Build.VERSION;
import com.tencent.token.core.bean.h;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.net.URLEncoder;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public final class cj
  extends bm
{
  private fu c;
  private byte[] d;
  private ag e = ag.c();
  
  protected final String a()
  {
    this.c = com.tencent.token.utils.encrypt.b.a();
    String str1 = com.tencent.token.utils.encrypt.b.a(this.c, ax.b);
    if ((this.c == null) || (str1 == null) || (str1.length() == 0))
    {
      this.a.a(10025, null, null);
      return null;
    }
    String str2 = "?mobile_type=" + 4 + "&client_type=" + 2 + "&client_ver=" + com.tencent.token.global.b.b() + "&local_id=0" + "&tkn_seq=" + String.valueOf(this.e.k());
    str1 = str2 + "&pub_key=" + str1;
    str1 = str1 + "&sys_ver=" + URLEncoder.encode(Build.VERSION.RELEASE);
    str1 = com.tencent.token.global.b.c() + "/cn/mbtoken3/mbtoken3_exchange_key_v3" + str1;
    e.b("exchange key len=" + str1.length() + str1);
    return str1;
  }
  
  protected final void a(fs paramfs) {}
  
  protected final void a(JSONObject paramJSONObject)
  {
    h.b();
    ax.a();
    ax.a(paramJSONObject);
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      this.a.a = 0;
      return;
    }
    String str = paramJSONObject.getString("sess_id");
    i = paramJSONObject.getInt("valid_time");
    long l1 = System.currentTimeMillis() / 1000L;
    paramJSONObject = new fu("1BB4632707784BB8836F564E3B48C20091D222C43ECD05CB17F8C29BDE18FEF1BEE828F9A5F18F80D50414B50315C5DBC2378410CCDD3565F1C7662F427A4801046CE59B4B1F214E65AB4F8B751622B2F7129989F740BC2BB4EF61230D6B77689CD8C7B59D238037194A6A810260E8AAE01A7F36693B21C68402B126F8A79248", 16);
    paramJSONObject = com.tencent.token.utils.encrypt.b.a(this.c, paramJSONObject, ax.b);
    label96:
    long l2;
    if (paramJSONObject == null)
    {
      paramJSONObject = null;
      this.d = paramJSONObject;
      ae.a();
      l2 = i;
      paramJSONObject = this.d;
      switch (com.tencent.token.global.b.a())
      {
      default: 
        ax.e = str;
      }
    }
    for (;;)
    {
      ax.c = str;
      ax.a().i = l2;
      ax.a().h = l1;
      ax.a().a = paramJSONObject;
      bi.a("mbtoken3_session_info").c(new fs("mbtoken3_exchange_key_v3", 1, null, -1));
      this.a.a = 0;
      break;
      paramJSONObject = MD5.toMD5Byte(ap.a(paramJSONObject.a()));
      break label96;
      ax.d = str;
      continue;
      ax.e = str;
      continue;
      ax.f = str;
      continue;
      ax.g = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cj
 * JD-Core Version:    0.7.0.1
 */