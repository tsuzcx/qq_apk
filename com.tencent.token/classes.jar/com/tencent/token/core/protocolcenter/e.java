package com.tencent.token.core.protocolcenter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.em;
import com.tencent.token.ev;
import com.tencent.token.ew;
import com.tencent.token.gk;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.x;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e
  implements em
{
  protected f a = new f();
  protected ev b;
  protected int c;
  
  public ew a(Serializable paramSerializable)
  {
    return null;
  }
  
  public Serializable a(ew paramew)
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
  
  protected abstract void a(ev paramev);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public ev b(ev paramev)
  {
    return paramev;
  }
  
  protected void b()
  {
    h.b("------------------------------\nhandler:" + this.b.d);
  }
  
  public f c(ev paramev)
  {
    Object localObject2 = null;
    this.b = paramev;
    a(paramev);
    String str = a();
    if (str == null)
    {
      c();
      return this.a;
    }
    Object localObject3 = new gk();
    h.c("cmd:" + paramev.a);
    if (paramev.m == 0) {
      paramev = ((gk)localObject3).a(str);
    }
    for (;;)
    {
      Object localObject1;
      if (paramev == null)
      {
        this.a.a(((gk)localObject3).a());
        c();
        return this.a;
        if (paramev.m == 1)
        {
          if (paramev.n != null)
          {
            localObject1 = paramev;
            if (paramev.k) {
              localObject1 = b(paramev);
            }
            paramev = ((gk)localObject3).a(str, ((ev)localObject1).n);
          }
        }
        else if (paramev.m == 2)
        {
          if ((paramev.o != null) && (!TextUtils.isEmpty(paramev.p))) {
            paramev = ((gk)localObject3).a(str, paramev.o, paramev.n, paramev.p);
          }
        }
        else if ((paramev.m == 3) && (paramev.q != null) && (!TextUtils.isEmpty(paramev.p))) {
          paramev = ((gk)localObject3).a(str, paramev.q, paramev.n, paramev.p);
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
            h.a(this + "device config" + paramev);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("startup_img", x.a(paramev));
            localObject1 = localObject2;
            paramev = (ev)localObject3;
          }
          catch (JSONException paramev)
          {
            h.c(this + "\nPARSE JSON FAILED: \n" + paramev.toString());
            this.a.a(10020, "JSONException:" + paramev.toString(), c.g().getString(2131230963));
            c();
            continue;
            localObject1 = new String(paramev);
            h.a(this + "--responseString--" + (String)localObject1);
            paramev = new JSONObject((String)localObject1);
            continue;
          }
          catch (Exception paramev)
          {
            paramev.printStackTrace();
            h.c(this + "\nE X C E P T I O N: \n" + paramev.toString());
            this.a.a(10000, "Exception:" + paramev.toString(), c.g().getString(2131230963));
            c();
            continue;
            if (localObject1 == null) {
              continue;
            }
            h.a(this + "\nR E S P O N S E: \n" + (String)localObject1);
            b();
            continue;
          }
          a(paramev);
          if (this.a.b()) {
            continue;
          }
          if (localObject1 != null) {
            h.c(this + "\nR E S P O N S E: \n" + (String)localObject1);
          }
          c();
          return this.a;
          if (!this.b.a.equals("token.getcommonimg")) {
            continue;
          }
          h.a(this + "device config" + paramev);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("img", x.a(paramev));
          paramev = (ev)localObject1;
          localObject1 = localObject2;
        }
      }
      paramev = null;
    }
  }
  
  protected void c()
  {
    h.c("------------------------------\nhandler:" + this.b.d + "    \nError=" + this.a.a + "    \nstrdebug:" + this.a.b + "    \nstruser:" + this.a.c);
  }
  
  public ew d(ev paramev)
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.e
 * JD-Core Version:    0.7.0.1
 */