package com.tencent.token;

import android.os.Build.VERSION;
import com.tmsdk.common.util.TmsLog;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class ua
  extends tj
{
  private aas d;
  private byte[] e;
  
  public final String a()
  {
    this.d = aaw.a();
    String str = aaw.a(this.d, sz.b);
    if ((this.d != null) && (str != null) && (str.length() != 0))
    {
      Object localObject = new StringBuilder("?mobile_type=");
      ((StringBuilder)localObject).append(ww.b());
      ((StringBuilder)localObject).append("&client_type=");
      ((StringBuilder)localObject).append(ww.c());
      ((StringBuilder)localObject).append("&client_ver=");
      ((StringBuilder)localObject).append(ww.d());
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
      ((StringBuilder)localObject).append(ww.e());
      ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_exchange_key_v3");
      ((StringBuilder)localObject).append(str);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder("exchange key len=");
      ((StringBuilder)localObject).append(str.length());
      ((StringBuilder)localObject).append(str);
      xa.b(((StringBuilder)localObject).toString());
      TmsLog.i("mod_seed", "exchange key url: ".concat(String.valueOf(str)));
      return str;
    }
    this.a.a(10025, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    sm.b();
    sz.a();
    sz.a(paramJSONObject);
    int i = paramJSONObject.getInt("err");
    TmsLog.i("mod_seed", "exchangekey parseJon, errcode: ".concat(String.valueOf(i)));
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    String str = paramJSONObject.getString("sess_id");
    i = paramJSONObject.getInt("valid_time");
    long l1 = System.currentTimeMillis() / 1000L;
    paramJSONObject = new aas("1BB4632707784BB8836F564E3B48C20091D222C43ECD05CB17F8C29BDE18FEF1BEE828F9A5F18F80D50414B50315C5DBC2378410CCDD3565F1C7662F427A4801046CE59B4B1F214E65AB4F8B751622B2F7129989F740BC2BB4EF61230D6B77689CD8C7B59D238037194A6A810260E8AAE01A7F36693B21C68402B126F8A79248", 16);
    this.e = aaw.a(this.d, paramJSONObject, sz.b);
    rz.a();
    long l2 = i;
    paramJSONObject = this.e;
    switch (ww.a())
    {
    default: 
      sz.d = str;
      break;
    case 3: 
      sz.f = str;
      break;
    case 2: 
      sz.e = str;
      break;
    case 1: 
      sz.d = str;
      break;
    case 0: 
      sz.c = str;
    }
    sz.a().h = l2;
    sz.a().g = l1;
    sz.a().a = paramJSONObject;
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ua
 * JD-Core Version:    0.7.0.1
 */