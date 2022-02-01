package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

public class cx
  extends bt
{
  static cx a;
  int b;
  private final String c = "/cn/mbtoken3/mbtoken3_query_for_2nd_verify_v2";
  private final String d = "/cn/mbtoken3/mbtoken3_perform_2nd_verify_encrypt";
  private int e;
  private String f;
  private String g;
  private String h;
  private String i;
  private int j;
  
  public static cx a()
  {
    if (a == null) {
      a = new cx();
    }
    return a;
  }
  
  private void f()
  {
    this.e = 0;
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = 0;
  }
  
  public e a(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public e a(String paramString, int paramInt)
  {
    e locale = new e();
    Object localObject1 = cs.a();
    if ((localObject1 != null) && (((cs)localObject1).e() != null))
    {
      int k = (int)(cd.c().s() / 1000L);
      int m = cc.a + 1;
      cc.a = m;
      this.b = m;
      Object localObject2 = a(cs.a().c(), new String[] { "input_data", paramString, "op_time", String.valueOf(k), "seq_id", String.valueOf(this.b), "uin", String.valueOf(((cs)localObject1).e().mUin), "verify_type", Integer.toString(this.j), "action_type", Integer.toString(paramInt) });
      if (localObject2 == null)
      {
        locale.a(10000, "encrypt imei failed");
        return locale;
      }
      paramString = new fc();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("?aq_base_sid=");
      localStringBuilder.append(((cs)localObject1).g());
      localStringBuilder.append("&data=");
      localStringBuilder.append((String)localObject2);
      localObject1 = localStringBuilder.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(c.e());
      ((StringBuilder)localObject2).append("/cn/mbtoken3/mbtoken3_perform_2nd_verify_encrypt");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = paramString.a((String)localObject1);
      if (localObject2 == null)
      {
        locale.a(paramString.a());
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
        paramString = new JSONObject(new String((byte[])localObject2));
        paramInt = paramString.getInt("err");
        if (paramInt != 0)
        {
          paramString = paramString.getString("info");
          locale.a(paramInt, paramString, paramString);
          return locale;
        }
        paramInt = new JSONObject(new String(l.c(paramString.getString("data")))).getInt("seq_id");
        if (this.b != paramInt)
        {
          locale.b(10030);
          paramString = new StringBuilder();
          paramString.append("parseJSON error seq is wrong seq=");
          paramString.append(paramInt);
          paramString.append(",right = ");
          paramString.append(this.b);
          g.c(paramString.toString());
          return locale;
        }
        cs.a().m();
        locale.c();
        return locale;
      }
      catch (Exception paramString)
      {
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
  
  public void a(final int paramInt, final Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    new UserTask()
    {
      public e a(String... paramAnonymousVarArgs)
      {
        return cx.this.a(paramInt);
      }
      
      public void a(e paramAnonymouse)
      {
        Message localMessage = new Message();
        localMessage.arg1 = paramInt;
        if ((paramAnonymouse.b()) && (1 == cx.a(cx.this))) {
          localMessage.what = 1011;
        } else {
          localMessage.what = 1010;
        }
        paramAnonymouse = paramHandler;
        if (paramAnonymouse != null) {
          paramAnonymouse.sendMessage(localMessage);
        }
      }
    }.c(new String[] { "" });
  }
  
  public String b()
  {
    return this.g;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public String e()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cx
 * JD-Core Version:    0.7.0.1
 */