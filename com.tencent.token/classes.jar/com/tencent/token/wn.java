package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONObject;

public final class wn
  extends ud
{
  public static void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject;
    StringBuilder localStringBuilder;
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((xt)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      TmsLog.i("mod_seed", "@mod_seed failed, errcode: ".concat(String.valueOf(i)));
      if ((i == 122) || (i == 205)) {
        a(true);
      }
      return;
    }
    TmsLog.i("mod_seed", "@mod_seed  start parse json.");
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      long l1 = paramJSONObject.getLong("seed_expire_time");
      sv.b();
      localObject = new StringBuilder("@mod_seed seed recv, String: ");
      ((StringBuilder)localObject).append(aay.a(paramJSONObject.getString("seed").getBytes()));
      TmsLog.i("mod_seed", ((StringBuilder)localObject).toString());
      localObject = aay.e(paramJSONObject.getString("seed"));
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder("@mod_seed seed recv, hex: ");
        localStringBuilder.append(aay.a((byte[])localObject));
        TmsLog.i("mod_seed", localStringBuilder.toString());
        sv.b();
        sv.b();
        sv.a((byte[])localObject);
        sv.b();
      }
      else
      {
        TmsLog.i("mod_seed", "@mod_seed seed recv null");
      }
      long l2 = paramJSONObject.getLong("server_time");
      sv.b();
      sv.a(l2);
      paramJSONObject = new StringBuilder("@mod_seed recv data, servertime: ");
      paramJSONObject.append(l2);
      paramJSONObject.append(" seedExpireTime: ");
      paramJSONObject.append(l1);
      TmsLog.i("mod_seed", paramJSONObject.toString());
      sv.b();
      a(false);
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wn
 * JD-Core Version:    0.7.0.1
 */