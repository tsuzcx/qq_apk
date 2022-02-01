package com.tencent.token.core.protocolcenter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.cb;
import com.tencent.token.df;
import com.tencent.token.do;
import com.tencent.token.dp;
import com.tencent.token.ez;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.m;
import com.tmsdk.common.util.TmsLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d
  implements df
{
  protected e a = new e();
  protected do b;
  protected int c;
  
  public dp a(Serializable paramSerializable)
  {
    return null;
  }
  
  public Serializable a(dp paramdp)
  {
    return null;
  }
  
  protected abstract String a();
  
  protected void a(int paramInt, String paramString)
  {
    if (paramString != null) {
      this.a.a(paramInt, paramString, paramString);
    }
    for (;;)
    {
      c();
      return;
      this.a.b(paramInt);
    }
  }
  
  protected abstract void a(do paramdo);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public do b(do paramdo)
  {
    return paramdo;
  }
  
  protected void b()
  {
    g.b("------------------------------\nhandler:" + this.b.d);
  }
  
  public e c(do paramdo)
  {
    Object localObject2 = null;
    this.b = paramdo;
    a(paramdo);
    String str = a();
    if (str == null)
    {
      c();
      return this.a;
    }
    Object localObject3 = new ez();
    g.c("cmd:" + paramdo.a);
    TmsLog.i("ProtocolBase", "@" + hashCode() + " start req--> [url]" + str + " [seqid]" + cb.a);
    if (paramdo.m == 0) {
      paramdo = ((ez)localObject3).a(str);
    }
    for (;;)
    {
      Object localObject1;
      if (paramdo == null)
      {
        this.a.a(((ez)localObject3).a());
        c();
        TmsLog.i("ProtocolBase", "@" + hashCode() + " recv response, ret: " + this.a.a);
        return this.a;
        if (paramdo.m == 1)
        {
          if (paramdo.n != null)
          {
            localObject1 = paramdo;
            if (paramdo.k) {
              localObject1 = b(paramdo);
            }
            paramdo = ((ez)localObject3).a(str, ((do)localObject1).n);
          }
        }
        else if (paramdo.m == 2)
        {
          if ((paramdo.o != null) && (!TextUtils.isEmpty(paramdo.p))) {
            paramdo = ((ez)localObject3).a(str, paramdo.o, paramdo.n, paramdo.p);
          }
        }
        else if ((paramdo.m == 3) && (paramdo.q != null) && (!TextUtils.isEmpty(paramdo.p))) {
          paramdo = ((ez)localObject3).a(str, paramdo.q, paramdo.n, paramdo.p);
        }
      }
      else
      {
        for (;;)
        {
          try
          {
            if (!this.b.a.equals("token.getstartupimg")) {
              continue;
            }
            g.a(this + "device config" + paramdo);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("startup_img", m.a(paramdo));
            localObject1 = localObject2;
            paramdo = (do)localObject3;
          }
          catch (JSONException paramdo)
          {
            g.c(this + "\nPARSE JSON FAILED: \n" + paramdo.toString());
            TmsLog.e("mod_seed", "cmd " + this.b.a + " has exception: " + paramdo.toString());
            this.a.a(10020, "JSONException:" + paramdo.toString(), c.g().getString(2131230963));
            c();
            continue;
            localObject1 = new String(paramdo);
            g.a(this + "--responseString--" + (String)localObject1);
            paramdo = new JSONObject((String)localObject1);
            continue;
          }
          catch (Exception paramdo)
          {
            paramdo.printStackTrace();
            g.c(this + "\nE X C E P T I O N: \n" + paramdo.toString());
            TmsLog.e("mod_seed", "cmd " + this.b.a + " has exception: " + paramdo.toString());
            this.a.a(10000, "Exception:" + paramdo.toString(), c.g().getString(2131230963));
            c();
            continue;
            if (localObject1 == null) {
              continue;
            }
            g.a(this + "\nR E S P O N S E: \n" + (String)localObject1);
            b();
            continue;
          }
          a(paramdo);
          if (this.a.b()) {
            continue;
          }
          if (localObject1 != null) {
            g.c(this + "\nR E S P O N S E: \n" + (String)localObject1);
          }
          c();
          TmsLog.i("ProtocolBase", "@" + hashCode() + " recv response, ret: " + this.a.a);
          return this.a;
          if (!this.b.a.equals("token.getcommonimg")) {
            continue;
          }
          g.a(this + "device config" + paramdo);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("img", m.a(paramdo));
          paramdo = (do)localObject1;
          localObject1 = localObject2;
        }
      }
      paramdo = null;
    }
  }
  
  protected void c()
  {
    g.c("------------------------------\nhandler:" + this.b.d + "    \nError=" + this.a.a + "    \nstrdebug:" + this.a.b + "    \nstruser:" + this.a.c);
  }
  
  public dp d(do paramdo)
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.d
 * JD-Core Version:    0.7.0.1
 */