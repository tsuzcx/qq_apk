package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cs;
import com.tencent.token.dg;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetGameLockStatus
  extends d
{
  private long d;
  private int e;
  private cs f = cs.a();
  
  public static void a(do paramdo, long paramLong)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    String str = ca.a().b();
    Object localObject1 = null;
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      int i = cb.a + 1;
      cb.a = i;
      this.e = i;
      ((JSONObject)localObject2).put("seq_id", this.e);
      ((JSONObject)localObject2).put("op_time", cc.c().s() / 1000L);
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
    localStringBuilder1.append("/cn/mbtoken3/mbtoken3_get_game_lock_status_v2");
    localStringBuilder1.append((String)localObject1);
    return localStringBuilder1.toString();
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, null);
      return;
    }
    Object localObject = l.c(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      i = ((JSONObject)localObject).getInt("seq_id");
      if (i != this.e)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(cb.a().b());
        g.c(paramJSONObject.toString());
        return;
      }
      long l = ((JSONObject)localObject).getLong("uin");
      if (l != this.d)
      {
        paramJSONObject = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uin not match=");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(this.d);
        paramJSONObject.a(10000, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = ((JSONObject)localObject).getJSONArray("result");
      if (!this.f.b((JSONArray)localObject))
      {
        paramJSONObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("update conf list failed:");
        localStringBuilder.append(((JSONArray)localObject).toString());
        paramJSONObject.a(10000, localStringBuilder.toString());
        return;
      }
      this.f.c.a(new String(paramJSONObject.toString()));
      this.f.c.e = true;
      this.f.c.f = false;
      this.a.c();
      return;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("parseJSON error decodeData=");
    paramJSONObject.append(localObject);
    g.c(paramJSONObject.toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetGameLockStatus
 * JD-Core Version:    0.7.0.1
 */