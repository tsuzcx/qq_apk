package com.tencent.token.core.protocolcenter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.de;
import com.tencent.token.dn;
import com.tencent.token.do;
import com.tencent.token.ey;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.m;
import com.tmsdk.common.util.TmsLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d
  implements de
{
  protected e a = new e();
  protected dn b;
  protected int c;
  
  public do a(Serializable paramSerializable)
  {
    return null;
  }
  
  public Serializable a(do paramdo)
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
  
  protected abstract void a(dn paramdn);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public dn b(dn paramdn)
  {
    return paramdn;
  }
  
  protected void b()
  {
    g.b("------------------------------\nhandler:" + this.b.d);
  }
  
  public e c(dn paramdn)
  {
    Object localObject2 = null;
    this.b = paramdn;
    a(paramdn);
    String str = a();
    if (str == null)
    {
      c();
      return this.a;
    }
    Object localObject3 = new ey();
    g.c("cmd:" + paramdn.a);
    if (paramdn.m == 0) {
      paramdn = ((ey)localObject3).a(str);
    }
    for (;;)
    {
      Object localObject1;
      if (paramdn == null)
      {
        this.a.a(((ey)localObject3).a());
        c();
        return this.a;
        if (paramdn.m == 1)
        {
          if (paramdn.n != null)
          {
            localObject1 = paramdn;
            if (paramdn.k) {
              localObject1 = b(paramdn);
            }
            paramdn = ((ey)localObject3).a(str, ((dn)localObject1).n);
          }
        }
        else if (paramdn.m == 2)
        {
          if ((paramdn.o != null) && (!TextUtils.isEmpty(paramdn.p))) {
            paramdn = ((ey)localObject3).a(str, paramdn.o, paramdn.n, paramdn.p);
          }
        }
        else if ((paramdn.m == 3) && (paramdn.q != null) && (!TextUtils.isEmpty(paramdn.p))) {
          paramdn = ((ey)localObject3).a(str, paramdn.q, paramdn.n, paramdn.p);
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
            g.a(this + "device config" + paramdn);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("startup_img", m.a(paramdn));
            localObject1 = localObject2;
            paramdn = (dn)localObject3;
          }
          catch (JSONException paramdn)
          {
            g.c(this + "\nPARSE JSON FAILED: \n" + paramdn.toString());
            TmsLog.e("mod_seed", "cmd " + this.b.a + " has exception: " + paramdn.toString());
            this.a.a(10020, "JSONException:" + paramdn.toString(), c.g().getString(2131230963));
            c();
            continue;
            localObject1 = new String(paramdn);
            g.a(this + "--responseString--" + (String)localObject1);
            paramdn = new JSONObject((String)localObject1);
            continue;
          }
          catch (Exception paramdn)
          {
            paramdn.printStackTrace();
            g.c(this + "\nE X C E P T I O N: \n" + paramdn.toString());
            TmsLog.e("mod_seed", "cmd " + this.b.a + " has exception: " + paramdn.toString());
            this.a.a(10000, "Exception:" + paramdn.toString(), c.g().getString(2131230963));
            c();
            continue;
            if (localObject1 == null) {
              continue;
            }
            g.a(this + "\nR E S P O N S E: \n" + (String)localObject1);
            b();
            continue;
          }
          a(paramdn);
          if (this.a.b()) {
            continue;
          }
          if (localObject1 != null) {
            g.c(this + "\nR E S P O N S E: \n" + (String)localObject1);
          }
          c();
          return this.a;
          if (!this.b.a.equals("token.getcommonimg")) {
            continue;
          }
          g.a(this + "device config" + paramdn);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("img", m.a(paramdn));
          paramdn = (dn)localObject1;
          localObject1 = localObject2;
        }
      }
      paramdn = null;
    }
  }
  
  protected void c()
  {
    g.c("------------------------------\nhandler:" + this.b.d + "    \nError=" + this.a.a + "    \nstrdebug:" + this.a.b + "    \nstruser:" + this.a.c);
  }
  
  public do d(dn paramdn)
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