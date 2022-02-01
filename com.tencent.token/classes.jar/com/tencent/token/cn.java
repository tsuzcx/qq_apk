package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class cn
  extends co
{
  static cn a;
  private final String e = "/cn/mbtoken3/mbtoken3_scan_qrcode_v2";
  private String f;
  private int g;
  private int h;
  
  private cn()
  {
    super(2);
  }
  
  public static cn a()
  {
    if (a == null) {
      a = new cn();
    }
    return a;
  }
  
  public e a(String paramString)
  {
    this.b.clear();
    this.f = "";
    this.g = 0;
    e locale = new e();
    cr localcr = cr.a();
    if ((localcr != null) && (localcr.e() != null))
    {
      long l = localcr.f();
      if (l == 0L)
      {
        locale.b(10029);
        return locale;
      }
      if (localcr.e().mIsBinded) {
        l = localcr.e().mUin;
      }
      ez localez = new ez();
      Object localObject1 = null;
      int i;
      try
      {
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", l);
        i = cb.a + 1;
        cb.a = i;
        this.h = i;
        ((JSONObject)localObject2).put("seq_id", this.h);
        ((JSONObject)localObject2).put("op_time", cc.c().s() / 1000L);
        if (paramString != null) {
          ((JSONObject)localObject2).put("url_data", paramString);
        }
        localObject2 = ((JSONObject)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("plain:");
        localStringBuilder.append((String)localObject2);
        g.a(localStringBuilder.toString());
        localObject2 = l.b(((String)localObject2).getBytes());
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("JSONException:");
        localStringBuilder.append(localJSONException.getMessage());
        g.c(localStringBuilder.toString());
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("?aq_base_sid=");
      ((StringBuilder)localObject3).append(localcr.g());
      ((StringBuilder)localObject3).append("&data=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(c.e());
      ((StringBuilder)localObject3).append("/cn/mbtoken3/mbtoken3_scan_qrcode_v2");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
      localObject3 = localez.a((String)localObject1);
      if (localObject3 == null)
      {
        locale.a(localez.a());
        paramString = new StringBuilder();
        paramString.append("client request url: ");
        paramString.append((String)localObject1);
        paramString.append(" failed, reason: ");
        paramString.append(locale.a);
        paramString.append(":");
        paramString.append(locale.b);
        g.c(paramString.toString());
        return locale;
      }
      try
      {
        localObject1 = new JSONObject(new String((byte[])localObject3));
        i = ((JSONObject)localObject1).getInt("err");
        if (i != 0)
        {
          paramString = ((JSONObject)localObject1).getString("info");
          locale.a(i, paramString, paramString);
          return locale;
        }
        localObject1 = l.c(((JSONObject)localObject1).getString("data"));
        if (localObject1 != null)
        {
          localObject1 = new JSONObject(new String((byte[])localObject1));
          i = ((JSONObject)localObject1).getInt("seq_id");
          if (i != this.h)
          {
            locale.b(10030);
            paramString = new StringBuilder();
            paramString.append("parseJSON error seq is wrong seq=");
            paramString.append(i);
            paramString.append(",right = ");
            paramString.append(cb.a().b());
            g.c(paramString.toString());
            return locale;
          }
          this.g = ((JSONObject)localObject1).getInt("type");
          if (1 == this.g)
          {
            paramString = ((JSONObject)localObject1).getJSONObject("msg");
            localObject1 = new a();
            if (!((a)localObject1).a(paramString)) {
              g.c("object item parse failed ");
            } else {
              this.b.add(localObject1);
            }
          }
          else if (2 == this.g)
          {
            this.f = ((JSONObject)localObject1).getString("text");
          }
          else
          {
            this.f = paramString;
          }
          cr.a().m();
          locale.c();
          return locale;
        }
        paramString = new StringBuilder();
        paramString.append("parseJSON error decodeData=");
        paramString.append(localObject1);
        g.c(paramString.toString());
        locale.a(10022, RqdApplication.l().getString(2131493067));
        return locale;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unknown err: ");
        ((StringBuilder)localObject1).append(paramString.toString());
        g.c(((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("JSONException:");
        ((StringBuilder)localObject1).append(paramString.toString());
        locale.a(10021, ((StringBuilder)localObject1).toString());
        return locale;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parse json failed: ");
        ((StringBuilder)localObject1).append(paramString.toString());
        g.c(((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("JSONException:");
        ((StringBuilder)localObject1).append(paramString.toString());
        locale.a(10020, ((StringBuilder)localObject1).toString());
        return locale;
      }
    }
    locale.b(110);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cn
 * JD-Core Version:    0.7.0.1
 */