package com.tencent.token;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class df
  extends bm
{
  private int c;
  private int d;
  private int e;
  private ConfigResult f;
  private int g;
  
  protected final String a()
  {
    Object localObject1 = null;
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      int i = af.a + 1;
      af.a = i;
      this.g = i;
      ((JSONObject)localObject2).put("seq_id", this.g);
      ((JSONObject)localObject2).put("op_time", ag.c().r() / 1000L);
      ((JSONObject)localObject2).put("mobile_brand", Build.BRAND);
      ((JSONObject)localObject2).put("mobile_model", Build.MODEL);
      ((JSONObject)localObject2).put("mobile_sys_version", Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("screen_width", this.c);
      ((JSONObject)localObject2).put("screen_height", this.d);
      ((JSONObject)localObject2).put("screen_dpi", this.e);
      localObject2 = ((JSONObject)localObject2).toString();
      e.a("plain:" + (String)localObject2);
      localObject2 = s.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        e.c("JSONException:" + localJSONException.getMessage());
      }
    }
    str = "?aq_base_sid=" + str + "&data=" + localObject1;
    return b.c() + "/cn/mbtoken3/mbtoken3_get_config_v2" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Integer)paramfs.c.get("param.config.width")).intValue();
    this.d = ((Integer)paramfs.c.get("param.config.height")).intValue();
    this.e = ((Integer)paramfs.c.get("param.config.dpi")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0) {
      a(i, paramJSONObject.getString("info"));
    }
    do
    {
      return;
      paramJSONObject = s.d(paramJSONObject.getString("data"));
      if (paramJSONObject == null) {
        break;
      }
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.a("parseJSON  decodeData=" + paramJSONObject.toString());
      i = paramJSONObject.getInt("seq_id");
      if (i != this.g)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder().append("parseJSON error seq is wrong seq=").append(i).append(",right = ");
        af.a();
        e.c(af.b());
        return;
      }
      this.f = new ConfigResult(paramJSONObject);
      this.a.a = 0;
      t.c(this.f);
    } while (TextUtils.isEmpty(this.f.schemaKey));
    try
    {
      paramJSONObject = new String(s.d(this.f.schemaKey));
      e.b("schemaKey=" + this.f.schemaKey + " save as=" + paramJSONObject);
      t.a(paramJSONObject, this.f.schemaTimeout);
      return;
    }
    catch (Exception paramJSONObject)
    {
      e.b("decode schemakey failed! schemaKey=" + this.f.schemaKey + " key=" + ap.a(ax.a().c()));
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.f;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.df
 * JD-Core Version:    0.7.0.1
 */