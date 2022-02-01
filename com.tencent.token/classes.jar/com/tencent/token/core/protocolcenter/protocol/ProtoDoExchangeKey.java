package com.tencent.token.core.protocolcenter.protocol;

import android.os.Build.VERSION;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.bean.h;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cq;
import com.tencent.token.dn;
import com.tencent.token.dp;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tmsdk.common.util.TmsLog;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ProtoDoExchangeKey
  extends d
{
  private dp d;
  private byte[] e;
  private cb f = cb.c();
  
  protected String a()
  {
    this.d = com.tencent.token.utils.encrypt.b.a();
    String str1 = com.tencent.token.utils.encrypt.b.a(this.d, 2L, cq.b);
    if ((this.d == null) || (str1 == null) || (str1.length() == 0))
    {
      this.a.b(10025);
      return null;
    }
    String str2 = "?mobile_type=" + c.b() + "&client_type=" + c.c() + "&client_ver=" + c.d() + "&local_id=0";
    str1 = str2 + "&pub_key=" + str1;
    str1 = str1 + "&sys_ver=" + URLEncoder.encode(Build.VERSION.RELEASE);
    str1 = str1 + "&product_id=115";
    str1 = str1 + "&turingd_channel=105678";
    str1 = c.e() + "/cn/mbtoken3/mbtoken3_exchange_key_v3" + str1;
    g.b("exchange key len=" + str1.length() + str1);
    TmsLog.i("mod_seed", "exchange key url: " + str1);
    return str1;
  }
  
  protected void a(dn paramdn) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    h.b();
    cq.a().a(paramJSONObject);
    int i = paramJSONObject.getInt("err");
    TmsLog.i("mod_seed", "exchangekey parseJon, errcode: " + i);
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    String str = paramJSONObject.getString("sess_id");
    i = paramJSONObject.getInt("valid_time");
    long l = System.currentTimeMillis() / 1000L;
    paramJSONObject = new dp("1BB4632707784BB8836F564E3B48C20091D222C43ECD05CB17F8C29BDE18FEF1BEE828F9A5F18F80D50414B50315C5DBC2378410CCDD3565F1C7662F427A4801046CE59B4B1F214E65AB4F8B751622B2F7129989F740BC2BB4EF61230D6B77689CD8C7B59D238037194A6A810260E8AAE01A7F36693B21C68402B126F8A79248", 16);
    this.e = com.tencent.token.utils.encrypt.b.a(this.d, paramJSONObject, cq.b);
    bz.a().a(str, i, l, this.e);
    com.tencent.token.core.protocolcenter.b.a("mbtoken3_session_info").c(new dn("mbtoken3_exchange_key_v3", 1, null, -1));
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoExchangeKey
 * JD-Core Version:    0.7.0.1
 */