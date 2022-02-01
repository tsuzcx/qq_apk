package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.ck;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cs;
import com.tencent.token.dp;
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
  
  public static void a(dp paramdp, int paramInt1, int paramInt2, int paramInt3)
  {
    paramdp.c.put("param.config.width", Integer.valueOf(paramInt1));
    paramdp.c.put("param.config.height", Integer.valueOf(paramInt2));
    paramdp.c.put("param.config.dpi", Integer.valueOf(paramInt3));
  }
  
  protected String a()
  {
    String str = cb.a().b();
    Object localObject1 = null;
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      int i = cc.a + 1;
      cc.a = i;
      this.h = i;
      ((JSONObject)localObject2).put("seq_id", this.h);
      ((JSONObject)localObject2).put("op_time", cd.c().s() / 1000L);
      ((JSONObject)localObject2).put("mobile_brand", Build.BRAND);
      ((JSONObject)localObject2).put("mobile_model", Build.MODEL);
      ((JSONObject)localObject2).put("mobile_sys_version", Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("screen_width", this.d);
      ((JSONObject)localObject2).put("screen_height", this.e);
      ((JSONObject)localObject2).put("screen_dpi", this.f);
      localObject2 = ((JSONObject)localObject2).toString();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("plain:");
      localStringBuilder2.append((String)localObject2);
      g.a(localStringBuilder2.toString());
      localObject2 = l.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("JSONException:");
      localStringBuilder2.append(localJSONException.getMessage());
      g.c(localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("?aq_base_sid=");
    localStringBuilder1.append(str);
    localStringBuilder1.append("&data=");
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(c.e());
    localStringBuilder1.append("/cn/mbtoken3/mbtoken3_get_config_v2");
    localStringBuilder1.append((String)localObject1);
    return localStringBuilder1.toString();
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((Integer)paramdp.c.get("param.config.width")).intValue();
    this.e = ((Integer)paramdp.c.get("param.config.height")).intValue();
    this.f = ((Integer)paramdp.c.get("param.config.dpi")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseJSON  decodeData=");
      localStringBuilder.append(paramJSONObject.toString());
      g.a(localStringBuilder.toString());
      i = paramJSONObject.getInt("seq_id");
      if (i != this.h)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(cc.a().b());
        g.c(paramJSONObject.toString());
        return;
      }
      this.g = new ConfigResult(paramJSONObject);
      this.a.c();
      m.c(this.g);
      m.b(this.g);
      if (TextUtils.isEmpty(this.g.schemaKey)) {
        break label382;
      }
    }
    try
    {
      paramJSONObject = new String(l.c(this.g.schemaKey));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("schemaKey=");
      localStringBuilder.append(this.g.schemaKey);
      localStringBuilder.append(" save as=");
      localStringBuilder.append(paramJSONObject);
      g.b(localStringBuilder.toString());
      m.a(paramJSONObject, this.g.schemaTimeout);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label279:
      break label279;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("decode schemakey failed! schemaKey=");
    paramJSONObject.append(this.g.schemaKey);
    paramJSONObject.append(" key=");
    paramJSONObject.append(ck.a(cs.a().c()));
    g.b(paramJSONObject.toString());
    return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.n().getString(2131493068));
    label382:
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