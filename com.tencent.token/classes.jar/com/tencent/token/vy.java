package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONObject;

public final class vy
  extends tr
{
  sj d;
  th e;
  
  public final String a()
  {
    this.d.d();
    String str = this.d.f();
    th.a(this.d.a.d(), str);
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject1;
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject1 = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((xh)localObject1).a(i, localStringBuilder.toString(), paramJSONObject);
      TmsLog.i("mod_seed", "@getuin failed, errcode: ".concat(String.valueOf(i)));
      if ((i == 122) || (i == 205)) {
        wb.a(true);
      }
      th.a().h();
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localObject1 = new StringBuilder("parseJSON =");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      xj.c(((StringBuilder)localObject1).toString());
      try
      {
        long l = paramJSONObject.getLong("seed_expire_time");
        sj.b();
        sj.b(l);
        TmsLog.i("mod_seed", "@getuin seed_expire_time:".concat(String.valueOf(l)));
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
          localObject2 = aao.e((String)localObject2);
          if (localObject2 != null)
          {
            sj.b().c();
            sj.b().a((byte[])localObject2);
            sj.b().j();
            sj.b().a.a();
            wb.a(false);
            sc.a.a().b();
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
        paramJSONObject.j = true;
        if (paramJSONObject.o != 0L)
        {
          paramJSONObject = this.e;
          paramJSONObject.b(paramJSONObject.o);
          this.e.o = 0L;
        }
        this.a.a = 0;
        return;
      }
      this.a.a(paramJSONObject);
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vy
 * JD-Core Version:    0.7.0.1
 */