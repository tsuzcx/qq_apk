package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.token.bw;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cs;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONObject;

public class ProtoGetUinList
  extends d
{
  cd d = cd.c();
  cs e = cs.a();
  
  protected String a()
  {
    this.d.m();
    String str = this.d.o();
    str = this.e.a(this.d.k(), str);
    Object localObject = cb.a().b();
    if (localObject == null)
    {
      this.a.b(104);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&data=");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_get_uin_list_v2");
    ((StringBuilder)localObject).append(str);
    str = ((StringBuilder)localObject).toString();
    Log.i("login_test", "ProtoGetUinList");
    return str;
  }
  
  protected void a(dp paramdp) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject1;
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject1 = this.a;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("server errcode=");
      localStringBuilder2.append(i);
      localStringBuilder2.append(":");
      localStringBuilder2.append(paramJSONObject);
      ((e)localObject1).a(i, localStringBuilder2.toString(), paramJSONObject);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("@getuin failed, errcode: ");
      paramJSONObject.append(i);
      TmsLog.i("mod_seed", paramJSONObject.toString());
      if ((i == 122) || (i == 205)) {
        ProtoModSeed.a(true);
      }
      cs.a().n();
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseJSON =");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      g.c(((StringBuilder)localObject1).toString());
      try
      {
        long l = paramJSONObject.getLong("seed_expire_time");
        cd.c().c(l);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("@getuin seed_expire_time:");
        ((StringBuilder)localObject1).append(l);
        TmsLog.i("mod_seed", ((StringBuilder)localObject1).toString());
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      try
      {
        Object localObject2 = paramJSONObject.getString("seed");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = l.d((String)localObject2);
          if (localObject2 != null)
          {
            cd.c().e();
            cd.c().a((byte[])localObject2);
            cd.c().v();
            cd.c().i();
            ProtoModSeed.a(false);
            bw.a().a(null);
          }
          TmsLog.i("mod_seed", "decode seed & compute seed @getuin sucess.");
        }
      }
      catch (Exception localException2)
      {
        TmsLog.e("mod_seed", "decode seed & compute seed @getuin failed: ", localException2);
        localException2.printStackTrace();
      }
      paramJSONObject = this.e.a(paramJSONObject.getJSONArray("uinlist"));
      if (paramJSONObject.b())
      {
        paramJSONObject = this.e;
        paramJSONObject.k = true;
        if (paramJSONObject.m != 0L)
        {
          paramJSONObject = this.e;
          paramJSONObject.b(paramJSONObject.m);
          this.e.m = 0L;
        }
        this.a.c();
        return;
      }
      this.a.a(paramJSONObject);
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("parseJSON error decodeData=");
    localStringBuilder1.append(paramJSONObject);
    g.c(localStringBuilder1.toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetUinList
 * JD-Core Version:    0.7.0.1
 */