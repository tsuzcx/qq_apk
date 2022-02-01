package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.widget.Toast;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.ed;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.global.k;
import com.tencent.token.utils.b;
import com.tencent.token.utils.l;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoModSeed
  extends d
{
  public static void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean e()
  {
    boolean bool = false;
    if (ed.b("mod_seed_err_111", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject1 = "";
    Object localObject2 = cc.c();
    ((cc)localObject2).m();
    String str2 = ((cc)localObject2).o();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = cb.a + 1;
      cb.a = i;
      this.c = i;
      localJSONObject.put("seq_id", this.c);
      localJSONObject.put("tkn_code", str2);
      localJSONObject.put("tkn_seq", String.valueOf(((cc)localObject2).k()));
      localJSONObject.put("turingd_ticket_id", k.c());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("seed mod seq_id: ");
      localStringBuilder2.append(this.c);
      localStringBuilder2.append(" token_code: ");
      localStringBuilder2.append(str2);
      localStringBuilder2.append(" tkn_seq:");
      localStringBuilder2.append(String.valueOf(((cc)localObject2).k()));
      localStringBuilder2.append(" ticket_id:");
      localStringBuilder2.append(k.c());
      localStringBuilder2.append(" seed hex:");
      localStringBuilder2.append(l.a(((cc)localObject2).f()));
      localStringBuilder2.append(" seed base64:");
      localStringBuilder2.append(b.a(((cc)localObject2).f()));
      TmsLog.i("mod_seed", localStringBuilder2.toString());
      localObject2 = l.b(localJSONObject.toString().getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("?aq_base_sid=");
    localStringBuilder1.append(str1);
    localStringBuilder1.append("&data=");
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(c.e());
    localStringBuilder1.append("/cn/mbtoken3/mbtoken3_mod_seed");
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("seed mod url: ");
    localStringBuilder1.append((String)localObject1);
    TmsLog.i("mod_seed", localStringBuilder1.toString());
    return localObject1;
  }
  
  protected void a(do paramdo) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject;
    StringBuilder localStringBuilder;
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((e)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("@mod_seed failed, errcode: ");
      paramJSONObject.append(i);
      TmsLog.i("mod_seed", paramJSONObject.toString());
      if ((i == 122) || (i == 205)) {
        a(true);
      }
    }
    else
    {
      TmsLog.i("mod_seed", "@mod_seed  start parse json.");
      paramJSONObject = l.c(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        long l1 = paramJSONObject.getLong("seed_expire_time");
        cc.c().c(l1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("@mod_seed seed recv, String: ");
        ((StringBuilder)localObject).append(l.a(paramJSONObject.getString("seed").getBytes()));
        TmsLog.i("mod_seed", ((StringBuilder)localObject).toString());
        localObject = l.d(paramJSONObject.getString("seed"));
        if (localObject != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("@mod_seed seed recv, hex: ");
          localStringBuilder.append(l.a((byte[])localObject));
          TmsLog.i("mod_seed", localStringBuilder.toString());
          cc.c().e();
          cc.c().a((byte[])localObject);
          cc.c().i();
        }
        else
        {
          TmsLog.i("mod_seed", "@mod_seed seed recv null");
        }
        long l2 = paramJSONObject.getLong("server_time");
        cc.c().b(l2);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("@mod_seed recv data, servertime: ");
        paramJSONObject.append(l2);
        paramJSONObject.append(" seedExpireTime: ");
        paramJSONObject.append(l1);
        TmsLog.i("mod_seed", paramJSONObject.toString());
        cc.c().u();
        a(false);
        this.a.c();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseJSON error decodeData=");
      ((StringBuilder)localObject).append(paramJSONObject);
      g.c(((StringBuilder)localObject).toString());
      a(10022, RqdApplication.l().getString(2131493067));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoModSeed
 * JD-Core Version:    0.7.0.1
 */