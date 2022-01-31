package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.dg;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetConfig
  extends e
{
  private int d;
  private int e;
  private int f;
  private ConfigResult g;
  private int h;
  
  public static void a(ev paramev, int paramInt1, int paramInt2, int paramInt3)
  {
    paramev.c.put("param.config.width", Integer.valueOf(paramInt1));
    paramev.c.put("param.config.height", Integer.valueOf(paramInt2));
    paramev.c.put("param.config.dpi", Integer.valueOf(paramInt3));
  }
  
  protected String a()
  {
    Object localObject1 = null;
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      int i = cw.a + 1;
      cw.a = i;
      this.h = i;
      ((JSONObject)localObject2).put("seq_id", this.h);
      ((JSONObject)localObject2).put("op_time", cx.c().s() / 1000L);
      ((JSONObject)localObject2).put("mobile_brand", Build.BRAND);
      ((JSONObject)localObject2).put("mobile_model", Build.MODEL);
      ((JSONObject)localObject2).put("mobile_sys_version", Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("screen_width", this.d);
      ((JSONObject)localObject2).put("screen_height", this.e);
      ((JSONObject)localObject2).put("screen_dpi", this.f);
      localObject2 = ((JSONObject)localObject2).toString();
      h.a("plain:" + (String)localObject2);
      localObject2 = w.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_config_v2" + (String)localObject1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Integer)paramev.c.get("param.config.width")).intValue();
    this.e = ((Integer)paramev.c.get("param.config.height")).intValue();
    this.f = ((Integer)paramev.c.get("param.config.dpi")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0) {
      a(i, paramJSONObject.getString("info"));
    }
    do
    {
      return;
      paramJSONObject = w.c(paramJSONObject.getString("data"));
      if (paramJSONObject == null) {
        break;
      }
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      h.a("parseJSON  decodeData=" + paramJSONObject.toString());
      i = paramJSONObject.getInt("seq_id");
      if (i != this.h)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + cw.a().b());
        return;
      }
      this.g = new ConfigResult(paramJSONObject);
      this.a.c();
      x.c(this.g);
      x.b(this.g);
    } while (TextUtils.isEmpty(this.g.schemaKey));
    try
    {
      paramJSONObject = new String(w.c(this.g.schemaKey));
      h.b("schemaKey=" + this.g.schemaKey + " save as=" + paramJSONObject);
      x.a(paramJSONObject, this.g.schemaTimeout);
      return;
    }
    catch (Exception paramJSONObject)
    {
      h.b("decode schemakey failed! schemaKey=" + this.g.schemaKey + " key=" + dg.a(do.a().c()));
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.g;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetConfig
 * JD-Core Version:    0.7.0.1
 */