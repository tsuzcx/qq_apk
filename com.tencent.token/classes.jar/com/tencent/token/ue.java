package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class ue
  extends tr
{
  private static final abe d = new abe("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private abe e;
  private sj f;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    TmsLog.i("mod_seed", "active token parseJon, errcode: ".concat(String.valueOf(i)));
    Object localObject;
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((xh)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (this.c != i)
      {
        this.a.a(10030, null, null);
        return;
      }
      localObject = paramJSONObject.getString("svc_pub_key");
      if (((String)localObject).length() > 0)
      {
        try
        {
          sj.b(paramJSONObject.getLong("seed_expire_time"));
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        this.f.c();
        localObject = new abe((String)localObject, 16);
        localObject = abi.b(this.e, (abe)localObject, d);
        if (localObject == null)
        {
          this.a.a(10026, null, null);
          return;
        }
        this.f.a((abe)localObject);
        this.f.e();
        this.f.j();
        sj.a(paramJSONObject.getLong("server_time"));
        sc.a.a().b();
        this.a.a = 0;
        return;
      }
      throw new JSONException("");
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ue
 * JD-Core Version:    0.7.0.1
 */