package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tmsdk.common.util.TmsLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ud
  implements abd
{
  protected xt a = new xt();
  protected abm b;
  protected int c;
  
  private void d()
  {
    StringBuilder localStringBuilder = new StringBuilder("------------------------------\nhandler:");
    localStringBuilder.append(this.b.d);
    localStringBuilder.append("    \nError=");
    localStringBuilder.append(this.a.a);
    localStringBuilder.append("    \nstrdebug:");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("    \nstruser:");
    localStringBuilder.append(this.a.c);
    xv.c(localStringBuilder.toString());
  }
  
  public abn a(Serializable paramSerializable)
  {
    return null;
  }
  
  public Serializable a(abn paramabn)
  {
    return null;
  }
  
  protected abstract String a();
  
  protected final void a(int paramInt, String paramString)
  {
    if (paramString != null) {
      this.a.a(paramInt, paramString, paramString);
    } else {
      this.a.a(paramInt, null, null);
    }
    d();
  }
  
  protected abstract void a(abm paramabm);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public abm b(abm paramabm)
  {
    return paramabm;
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder("------------------------------\nhandler:");
    localStringBuilder.append(this.b.d);
    xv.b(localStringBuilder.toString());
  }
  
  public final xt c(abm paramabm)
  {
    this.b = paramabm;
    a(paramabm);
    String str = a();
    if (str == null)
    {
      d();
      return this.a;
    }
    akl localakl = new akl();
    Object localObject = new StringBuilder("cmd:");
    ((StringBuilder)localObject).append(paramabm.a);
    xv.c(((StringBuilder)localObject).toString());
    localObject = new StringBuilder("@");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" start req--> [url]");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" [seqid]");
    ((StringBuilder)localObject).append(su.b);
    TmsLog.i("ProtocolBase", ((StringBuilder)localObject).toString());
    int i = paramabm.m;
    StringBuilder localStringBuilder = null;
    if (i == 0)
    {
      paramabm = localakl.a(str);
    }
    else
    {
      if (paramabm.m == 1)
      {
        if (paramabm.n != null)
        {
          localObject = paramabm;
          if (paramabm.k) {
            localObject = b(paramabm);
          }
          paramabm = localakl.a(str, ((abm)localObject).n);
          break label288;
        }
      }
      else if (paramabm.m == 2)
      {
        if ((paramabm.o != null) && (!TextUtils.isEmpty(paramabm.p)))
        {
          paramabm = localakl.a(str, paramabm.o, paramabm.n, paramabm.p);
          break label288;
        }
      }
      else if ((paramabm.m == 3) && (paramabm.q != null) && (!TextUtils.isEmpty(paramabm.p)))
      {
        paramabm = localakl.a(str, paramabm.q, paramabm.n, paramabm.p);
        break label288;
      }
      paramabm = null;
    }
    label288:
    if (paramabm == null)
    {
      this.a.a(localakl.a);
      d();
      paramabm = new StringBuilder("@");
      paramabm.append(hashCode());
      paramabm.append(" recv response, ret: ");
      paramabm.append(this.a.a);
      TmsLog.i("ProtocolBase", paramabm.toString());
      return this.a;
    }
    try
    {
      if (this.b.a.equals("token.getstartupimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramabm);
        xv.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("startup_img", aaz.a(paramabm));
        paramabm = (abm)localObject;
        localObject = localStringBuilder;
      }
      else if (this.b.a.equals("token.getcommonimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramabm);
        xv.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("img", aaz.a(paramabm));
        paramabm = (abm)localObject;
        localObject = localStringBuilder;
      }
      else
      {
        localObject = new String(paramabm);
        paramabm = new StringBuilder();
        paramabm.append(this);
        paramabm.append("--responseString--");
        paramabm.append((String)localObject);
        xv.a(paramabm.toString());
        paramabm = new JSONObject((String)localObject);
      }
      a(paramabm);
      if (!this.a.b())
      {
        if (localObject != null)
        {
          paramabm = new StringBuilder();
          paramabm.append(this);
          paramabm.append("\nR E S P O N S E: \n");
          paramabm.append((String)localObject);
          xv.c(paramabm.toString());
        }
        d();
      }
      else
      {
        if (localObject != null)
        {
          paramabm = new StringBuilder();
          paramabm.append(this);
          paramabm.append("\nR E S P O N S E: \n");
          paramabm.append((String)localObject);
          xv.a(paramabm.toString());
        }
        b();
      }
    }
    catch (Exception paramabm)
    {
      paramabm.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nE X C E P T I O N: \n");
      ((StringBuilder)localObject).append(paramabm.toString());
      xv.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramabm.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder("Exception:");
      localStringBuilder.append(paramabm.toString());
      ((xt)localObject).a(10000, localStringBuilder.toString(), xr.g().getString(2131493108));
      d();
    }
    catch (JSONException paramabm)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nPARSE JSON FAILED: \n");
      ((StringBuilder)localObject).append(paramabm.toString());
      xv.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramabm.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder("JSONException:");
      localStringBuilder.append(paramabm.toString());
      ((xt)localObject).a(10020, localStringBuilder.toString(), xr.g().getString(2131493108));
      d();
    }
    paramabm = new StringBuilder("@");
    paramabm.append(hashCode());
    paramabm.append(" recv response, ret: ");
    paramabm.append(this.a.a);
    TmsLog.i("ProtocolBase", paramabm.toString());
    return this.a;
  }
  
  public String c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ud
 * JD-Core Version:    0.7.0.1
 */