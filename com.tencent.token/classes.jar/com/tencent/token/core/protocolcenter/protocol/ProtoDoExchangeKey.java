package com.tencent.token.core.protocolcenter.protocol;

import android.os.Build.VERSION;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.bean.h;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.do;
import com.tencent.token.dq;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.encrypt.b;
import com.tmsdk.common.util.TmsLog;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ProtoDoExchangeKey
  extends d
{
  private dq d;
  private byte[] e;
  private cc f = cc.c();
  
  protected String a()
  {
    this.d = b.a();
    String str = b.a(this.d, 2L, cr.b);
    if ((this.d != null) && (str != null) && (str.length() != 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("?mobile_type=");
      ((StringBuilder)localObject).append(c.b());
      ((StringBuilder)localObject).append("&client_type=");
      ((StringBuilder)localObject).append(c.c());
      ((StringBuilder)localObject).append("&client_ver=");
      ((StringBuilder)localObject).append(c.d());
      ((StringBuilder)localObject).append("&local_id=0");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&pub_key=");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("&sys_ver=");
      ((StringBuilder)localObject).append(URLEncoder.encode(Build.VERSION.RELEASE));
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("&product_id=115");
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("&turingd_channel=105678");
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c.e());
      ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_exchange_key_v3");
      ((StringBuilder)localObject).append(str);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exchange key len=");
      ((StringBuilder)localObject).append(str.length());
      ((StringBuilder)localObject).append(str);
      g.b(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exchange key url: ");
      ((StringBuilder)localObject).append(str);
      TmsLog.i("mod_seed", ((StringBuilder)localObject).toString());
      return str;
    }
    this.a.b(10025);
    return null;
  }
  
  protected void a(do paramdo) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    h.b();
    cr.a().a(paramJSONObject);
    int i = paramJSONObject.getInt("err");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exchangekey parseJon, errcode: ");
    ((StringBuilder)localObject).append(i);
    TmsLog.i("mod_seed", ((StringBuilder)localObject).toString());
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    localObject = paramJSONObject.getString("sess_id");
    i = paramJSONObject.getInt("valid_time");
    long l = System.currentTimeMillis() / 1000L;
    paramJSONObject = new dq("1BB4632707784BB8836F564E3B48C20091D222C43ECD05CB17F8C29BDE18FEF1BEE828F9A5F18F80D50414B50315C5DBC2378410CCDD3565F1C7662F427A4801046CE59B4B1F214E65AB4F8B751622B2F7129989F740BC2BB4EF61230D6B77689CD8C7B59D238037194A6A810260E8AAE01A7F36693B21C68402B126F8A79248", 16);
    this.e = b.a(this.d, paramJSONObject, cr.b);
    ca.a().a((String)localObject, i, l, this.e);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoExchangeKey
 * JD-Core Version:    0.7.0.1
 */