package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cj;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetConfig
  extends d
{
  private int d;
  private int e;
  private int f;
  private ConfigResult g;
  private int h;
  
  public static void a(do paramdo, int paramInt1, int paramInt2, int paramInt3)
  {
    paramdo.c.put("param.config.width", Integer.valueOf(paramInt1));
    paramdo.c.put("param.config.height", Integer.valueOf(paramInt2));
    paramdo.c.put("param.config.dpi", Integer.valueOf(paramInt3));
  }
  
  protected String a()
  {
    Object localObject1 = null;
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      int i = cb.a + 1;
      cb.a = i;
      this.h = i;
      ((JSONObject)localObject2).put("seq_id", this.h);
      ((JSONObject)localObject2).put("op_time", cc.c().s() / 1000L);
      ((JSONObject)localObject2).put("mobile_brand", Build.BRAND);
      ((JSONObject)localObject2).put("mobile_model", Build.MODEL);
      ((JSONObject)localObject2).put("mobile_sys_version", Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("screen_width", this.d);
      ((JSONObject)localObject2).put("screen_height", this.e);
      ((JSONObject)localObject2).put("screen_dpi", this.f);
      localObject2 = ((JSONObject)localObject2).toString();
      g.a("plain:" + (String)localObject2);
      localObject2 = l.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        g.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_config_v2" + (String)localObject1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Integer)paramdo.c.get("param.config.width")).intValue();
    this.e = ((Integer)paramdo.c.get("param.config.height")).intValue();
    this.f = ((Integer)paramdo.c.get("param.config.dpi")).intValue();
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
      paramJSONObject = l.c(paramJSONObject.getString("data"));
      if (paramJSONObject == null) {
        break;
      }
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      g.a("parseJSON  decodeData=" + paramJSONObject.toString());
      i = paramJSONObject.getInt("seq_id");
      if (i != this.h)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + cb.a().b());
        return;
      }
      this.g = new ConfigResult(paramJSONObject);
      this.a.c();
      m.c(this.g);
      m.b(this.g);
    } while (TextUtils.isEmpty(this.g.schemaKey));
    try
    {
      paramJSONObject = new String(l.c(this.g.schemaKey));
      g.b("schemaKey=" + this.g.schemaKey + " save as=" + paramJSONObject);
      m.a(paramJSONObject, this.g.schemaTimeout);
      return;
    }
    catch (Exception paramJSONObject)
    {
      g.b("decode schemakey failed! schemaKey=" + this.g.schemaKey + " key=" + cj.a(cr.a().c()));
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
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