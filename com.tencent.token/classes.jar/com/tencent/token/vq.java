package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONObject;

public final class vq
  extends tj
{
  sb d;
  sz e;
  
  public final String a()
  {
    this.d.d();
    String str = this.d.f();
    sz.a(this.d.a.d(), str);
    rz.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq) {}
  
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
      ((wy)localObject1).a(i, localStringBuilder.toString(), paramJSONObject);
      TmsLog.i("mod_seed", "@getuin failed, errcode: ".concat(String.valueOf(i)));
      if ((i == 122) || (i == 205)) {
        vt.a(true);
      }
      sz.a().h();
      return;
    }
    paramJSONObject = aac.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localObject1 = new StringBuilder("parseJSON =");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      xa.c(((StringBuilder)localObject1).toString());
      try
      {
        long l = paramJSONObject.getLong("seed_expire_time");
        sb.b();
        sb.b(l);
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
          localObject2 = aac.e((String)localObject2);
          if (localObject2 != null)
          {
            sb.b().c();
            sb.b().a((byte[])localObject2);
            sb.b().j();
            sb.b().a.a();
            vt.a(false);
            ru.a.a().b();
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
    xa.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vq
 * JD-Core Version:    0.7.0.1
 */