package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class uq
  extends ud
{
  private static final abo d = new abo("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private abo e;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm) {}
  
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
      ((xt)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
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
          paramJSONObject.getLong("seed_expire_time");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        localObject = new abo((String)localObject, 16);
        if (abs.b(this.e, (abo)localObject, d) == null)
        {
          this.a.a(10026, null, null);
          return;
        }
        sv.a(paramJSONObject.getLong("server_time"));
        sp.a.a().b();
        this.a.a = 0;
        return;
      }
      throw new JSONException("");
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uq
 * JD-Core Version:    0.7.0.1
 */