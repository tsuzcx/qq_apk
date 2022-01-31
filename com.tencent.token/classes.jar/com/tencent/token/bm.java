package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.t;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bm
  implements fj
{
  protected d a = new d((byte)0);
  protected fs b;
  
  private void e()
  {
    e.c("------------------------------\nhandler:" + this.b.d + "    \nError=" + this.a.a + "    \nstrdebug:" + this.a.b + "    \nstruser:" + this.a.c);
  }
  
  public ft a(Serializable paramSerializable)
  {
    return null;
  }
  
  public Serializable a(ft paramft)
  {
    return null;
  }
  
  protected abstract String a();
  
  protected final void a(int paramInt, String paramString)
  {
    if (paramString != null) {
      this.a.a(paramInt, paramString, paramString);
    }
    for (;;)
    {
      e();
      return;
      this.a.a(paramInt, null, null);
    }
  }
  
  protected abstract void a(fs paramfs);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public fs b(fs paramfs)
  {
    return paramfs;
  }
  
  protected void b()
  {
    e.b("------------------------------\nhandler:" + this.b.d);
  }
  
  public ft c()
  {
    return null;
  }
  
  public final d c(fs paramfs)
  {
    Object localObject2 = null;
    int i = 1;
    this.b = paramfs;
    a(paramfs);
    String str = a();
    if (str == null)
    {
      e();
      return this.a;
    }
    Object localObject3 = new gv();
    e.c("cmd:" + paramfs.a);
    if (paramfs.m == 0) {
      paramfs = ((gv)localObject3).a(str);
    }
    for (;;)
    {
      Object localObject1;
      if (paramfs == null)
      {
        paramfs = this.a;
        localObject1 = ((gv)localObject3).a();
        paramfs.a(((d)localObject1).a, ((d)localObject1).b, ((d)localObject1).c);
        e();
        return this.a;
        if (paramfs.m == 1)
        {
          if (paramfs.n != null)
          {
            localObject1 = paramfs;
            if (paramfs.k) {
              localObject1 = b(paramfs);
            }
            paramfs = ((gv)localObject3).a(str, ((fs)localObject1).n);
          }
        }
        else if (paramfs.m == 2)
        {
          if ((paramfs.o != null) && (!TextUtils.isEmpty(paramfs.p))) {
            paramfs = ((gv)localObject3).a(str, paramfs.o, paramfs.n, paramfs.p);
          }
        }
        else if ((paramfs.m == 3) && (paramfs.q != null) && (!TextUtils.isEmpty(paramfs.p))) {
          paramfs = ((gv)localObject3).a(str, paramfs.q, paramfs.n, paramfs.p);
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
            e.a(this + "device config" + paramfs);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("startup_img", t.a(paramfs));
            localObject1 = localObject2;
            paramfs = (fs)localObject3;
          }
          catch (JSONException paramfs)
          {
            e.c(this + "\nPARSE JSON FAILED: \n" + paramfs.toString());
            this.a.a(10020, "JSONException:" + paramfs.toString(), b.e().getString(2131361951));
            e();
            continue;
            localObject1 = new String(paramfs);
            paramfs = new JSONObject((String)localObject1);
            continue;
          }
          catch (Exception paramfs)
          {
            paramfs.printStackTrace();
            e.c(this + "\nE X C E P T I O N: \n" + paramfs.toString());
            this.a.a(10000, "Exception:" + paramfs.toString(), b.e().getString(2131361951));
            e();
            continue;
            i = 0;
            continue;
            if (localObject1 == null) {
              continue;
            }
            e.a(this + "\nR E S P O N S E: \n" + (String)localObject1);
            b();
            continue;
          }
          a(paramfs);
          if (this.a.a != 0) {
            continue;
          }
          if (i != 0) {
            continue;
          }
          if (localObject1 != null) {
            e.c(this + "\nR E S P O N S E: \n" + (String)localObject1);
          }
          e();
          return this.a;
          if (!this.b.a.equals("token.getcommonimg")) {
            continue;
          }
          e.a(this + "device config" + paramfs);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("img", t.a(paramfs));
          paramfs = (fs)localObject1;
          localObject1 = localObject2;
        }
      }
      paramfs = null;
    }
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bm
 * JD-Core Version:    0.7.0.1
 */