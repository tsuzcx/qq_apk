package com.tencent.token;

import android.os.Build.VERSION;
import com.tmsdk.common.util.TmsLog;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class uu
  extends ud
{
  private abo d;
  private byte[] e;
  
  public final String a()
  {
    this.d = abs.a();
    String str = abs.a(this.d, tt.b);
    if ((this.d != null) && (str != null) && (str.length() != 0))
    {
      Object localObject = new StringBuilder("?mobile_type=");
      ((StringBuilder)localObject).append(xr.b());
      ((StringBuilder)localObject).append("&client_type=");
      ((StringBuilder)localObject).append(xr.c());
      ((StringBuilder)localObject).append("&client_ver=");
      ((StringBuilder)localObject).append(xr.d());
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
      ((StringBuilder)localObject).append(xr.e());
      ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_exchange_key_v3");
      ((StringBuilder)localObject).append(str);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder("exchange key len=");
      ((StringBuilder)localObject).append(str.length());
      ((StringBuilder)localObject).append(str);
      xv.b(((StringBuilder)localObject).toString());
      TmsLog.i("mod_seed", "exchange key url: ".concat(String.valueOf(str)));
      return str;
    }
    this.a.a(10025, null, null);
    return null;
  }
  
  public final void a(abm paramabm) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    tg.b();
    tt.a();
    tt.a(paramJSONObject);
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
    paramJSONObject = new abo("1BB4632707784BB8836F564E3B48C20091D222C43ECD05CB17F8C29BDE18FEF1BEE828F9A5F18F80D50414B50315C5DBC2378410CCDD3565F1C7662F427A4801046CE59B4B1F214E65AB4F8B751622B2F7129989F740BC2BB4EF61230D6B77689CD8C7B59D238037194A6A810260E8AAE01A7F36693B21C68402B126F8A79248", 16);
    this.e = abs.a(this.d, paramJSONObject, tt.b);
    st.a();
    long l2 = i;
    paramJSONObject = this.e;
    switch (xr.a())
    {
    default: 
      tt.d = str;
      break;
    case 3: 
      tt.f = str;
      break;
    case 2: 
      tt.e = str;
      break;
    case 1: 
      tt.d = str;
      break;
    case 0: 
      tt.c = str;
    }
    tt.a().h = l2;
    tt.a().g = l1;
    tt.a().a = paramJSONObject;
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uu
 * JD-Core Version:    0.7.0.1
 */