package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONObject;

public final class wk
  extends ud
{
  tt d;
  
  public final String a()
  {
    tt.n();
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm) {}
  
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
      ((xt)localObject1).a(i, localStringBuilder.toString(), paramJSONObject);
      TmsLog.i("mod_seed", "@getuin failed, errcode: ".concat(String.valueOf(i)));
      if ((i == 122) || (i == 205)) {
        wn.a(true);
      }
      tt.a().h();
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localObject1 = new StringBuilder("parseJSON =");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      xv.c(((StringBuilder)localObject1).toString());
      try
      {
        long l = paramJSONObject.getLong("seed_expire_time");
        sv.b();
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
          localObject2 = aay.e((String)localObject2);
          if (localObject2 != null)
          {
            sv.b();
            sv.b();
            sv.a((byte[])localObject2);
            sv.b();
            sv.b();
            wn.a(false);
            sp.a.a().b();
          }
          TmsLog.i("mod_seed", "decode seed & compute seed @getuin sucess.");
        }
      }
      catch (Exception localException2)
      {
        TmsLog.e("mod_seed", "decode seed & compute seed @getuin failed: ", localException2);
        localException2.printStackTrace();
      }
      paramJSONObject = this.d.a(paramJSONObject.getJSONArray("uinlist"));
      if (paramJSONObject.b())
      {
        paramJSONObject = this.d;
        paramJSONObject.j = true;
        if (paramJSONObject.o != 0L)
        {
          paramJSONObject = this.d;
          paramJSONObject.b(paramJSONObject.o);
          this.d.o = 0L;
        }
        this.a.a = 0;
        return;
      }
      this.a.a(paramJSONObject);
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wk
 * JD-Core Version:    0.7.0.1
 */