package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class ux
  extends tk
{
  private int d;
  private int e;
  private int f;
  private ConfigResult g;
  private int h;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((Integer)paramaar.c.get("param.config.width")).intValue();
    this.e = ((Integer)paramaar.c.get("param.config.height")).intValue();
    this.f = ((Integer)paramaar.c.get("param.config.dpi")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    StringBuilder localStringBuilder;
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localStringBuilder = new StringBuilder("parseJSON  decodeData=");
      localStringBuilder.append(paramJSONObject.toString());
      xb.a(localStringBuilder.toString());
      i = paramJSONObject.getInt("seq_id");
      if (i != this.h)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        sb.a();
        paramJSONObject.append(sb.b());
        xb.c(paramJSONObject.toString());
        return;
      }
      this.g = new ConfigResult(paramJSONObject);
      this.a.a = 0;
      aae.c(this.g);
      aae.b(this.g);
      if (TextUtils.isEmpty(this.g.schemaKey)) {}
    }
    try
    {
      paramJSONObject = new String(aad.d(this.g.schemaKey));
      localStringBuilder = new StringBuilder("schemaKey=");
      localStringBuilder.append(this.g.schemaKey);
      localStringBuilder.append(" save as=");
      localStringBuilder.append(paramJSONObject);
      xb.b(localStringBuilder.toString());
      aae.a(paramJSONObject, this.g.schemaTimeout);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label268:
      break label268;
    }
    paramJSONObject = new StringBuilder("decode schemakey failed! schemaKey=");
    paramJSONObject.append(this.g.schemaKey);
    paramJSONObject.append(" key=");
    paramJSONObject.append(ss.a(ta.a().a));
    xb.b(paramJSONObject.toString());
    return;
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final void b()
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
 * Qualified Name:     com.tencent.token.ux
 * JD-Core Version:    0.7.0.1
 */