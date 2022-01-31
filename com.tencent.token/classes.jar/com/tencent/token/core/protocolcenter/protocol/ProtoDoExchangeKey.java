package com.tencent.token.core.protocolcenter.protocol;

import android.os.Build.VERSION;
import com.tencent.token.core.bean.j;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.ex;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ProtoDoExchangeKey
  extends e
{
  private ex d;
  private byte[] e;
  private cx f = cx.c();
  
  protected String a()
  {
    this.d = com.tencent.token.utils.encrypt.b.a();
    String str1 = com.tencent.token.utils.encrypt.b.a(this.d, 2L, do.b);
    if ((this.d == null) || (str1 == null) || (str1.length() == 0))
    {
      this.a.b(10025);
      return null;
    }
    String str2 = "?mobile_type=" + c.b() + "&client_type=" + c.c() + "&client_ver=" + c.d() + "&local_id=0&tkn_seq=" + String.valueOf(this.f.k());
    str1 = str2 + "&pub_key=" + str1;
    str1 = str1 + "&sys_ver=" + URLEncoder.encode(Build.VERSION.RELEASE);
    str1 = c.e() + "/cn/mbtoken3/mbtoken3_exchange_key_v3" + str1;
    h.b("exchange key len=" + str1.length() + str1);
    return str1;
  }
  
  protected void a(ev paramev) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    j.b();
    do.a().a(paramJSONObject);
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    String str = paramJSONObject.getString("sess_id");
    i = paramJSONObject.getInt("valid_time");
    long l = System.currentTimeMillis() / 1000L;
    paramJSONObject = new ex("1BB4632707784BB8836F564E3B48C20091D222C43ECD05CB17F8C29BDE18FEF1BEE828F9A5F18F80D50414B50315C5DBC2378410CCDD3565F1C7662F427A4801046CE59B4B1F214E65AB4F8B751622B2F7129989F740BC2BB4EF61230D6B77689CD8C7B59D238037194A6A810260E8AAE01A7F36693B21C68402B126F8A79248", 16);
    this.e = com.tencent.token.utils.encrypt.b.a(this.d, paramJSONObject, do.b);
    cv.a().a(str, i, l, this.e);
    com.tencent.token.core.protocolcenter.b.a("mbtoken3_session_info").c(new ev("mbtoken3_exchange_key_v3", 1, null, -1));
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoExchangeKey
 * JD-Core Version:    0.7.0.1
 */