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
    } else {
      this.a.b(paramInt);
    }
    c();
  }
  
  protected abstract void a(do paramdo);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public do b(do paramdo)
  {
    return paramdo;
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------------------------------\nhandler:");
    localStringBuilder.append(this.b.d);
    g.b(localStringBuilder.toString());
  }
  
  public e c(do paramdo)
  {
    this.b = paramdo;
    a(paramdo);
    String str = a();
    if (str == null)
    {
      c();
      return this.a;
    }
    ez localez = new ez();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cmd:");
    ((StringBuilder)localObject).append(paramdo.a);
    g.c(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" start req--> [url]");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" [seqid]");
    ((StringBuilder)localObject).append(cb.a);
    TmsLog.i("ProtocolBase", ((StringBuilder)localObject).toString());
    int i = paramdo.m;
    StringBuilder localStringBuilder = null;
    if (i == 0)
    {
      paramdo = localez.a(str);
    }
    else
    {
      if (paramdo.m == 1)
      {
        if (paramdo.n != null)
        {
          localObject = paramdo;
          if (paramdo.k) {
            localObject = b(paramdo);
          }
          paramdo = localez.a(str, ((do)localObject).n);
          break label298;
        }
      }
      else if (paramdo.m == 2)
      {
        if ((paramdo.o != null) && (!TextUtils.isEmpty(paramdo.p)))
        {
          paramdo = localez.a(str, paramdo.o, paramdo.n, paramdo.p);
          break label298;
        }
      }
      else if ((paramdo.m == 3) && (paramdo.q != null) && (!TextUtils.isEmpty(paramdo.p)))
      {
        paramdo = localez.a(str, paramdo.q, paramdo.n, paramdo.p);
        break label298;
      }
      paramdo = null;
    }
    label298:
    if (paramdo == null)
    {
      this.a.a(localez.a());
      c();
      paramdo = new StringBuilder();
      paramdo.append("@");
      paramdo.append(hashCode());
      paramdo.append(" recv response, ret: ");
      paramdo.append(this.a.a);
      TmsLog.i("ProtocolBase", paramdo.toString());
      return this.a;
    }
    try
    {
      if (this.b.a.equals("token.getstartupimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramdo);
        g.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("startup_img", m.a(paramdo));
        paramdo = (do)localObject;
        localObject = localStringBuilder;
      }
      else if (this.b.a.equals("token.getcommonimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramdo);
        g.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("img", m.a(paramdo));
        paramdo = (do)localObject;
        localObject = localStringBuilder;
      }
      else
      {
        localObject = new String(paramdo);
        paramdo = new StringBuilder();
        paramdo.append(this);
        paramdo.append("--responseString--");
        paramdo.append((String)localObject);
        g.a(paramdo.toString());
        paramdo = new JSONObject((String)localObject);
      }
      a(paramdo);
      if (!this.a.b())
      {
        if (localObject != null)
        {
          paramdo = new StringBuilder();
          paramdo.append(this);
          paramdo.append("\nR E S P O N S E: \n");
          paramdo.append((String)localObject);
          g.c(paramdo.toString());
        }
        c();
      }
      else
      {
        if (localObject != null)
        {
          paramdo = new StringBuilder();
          paramdo.append(this);
          paramdo.append("\nR E S P O N S E: \n");
          paramdo.append((String)localObject);
          g.a(paramdo.toString());
        }
        b();
      }
    }
    catch (Exception paramdo)
    {
      paramdo.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nE X C E P T I O N: \n");
      ((StringBuilder)localObject).append(paramdo.toString());
      g.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramdo.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception:");
      localStringBuilder.append(paramdo.toString());
      ((e)localObject).a(10000, localStringBuilder.toString(), c.g().getString(2131493105));
      c();
    }
    catch (JSONException paramdo)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nPARSE JSON FAILED: \n");
      ((StringBuilder)localObject).append(paramdo.toString());
      g.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramdo.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSONException:");
      localStringBuilder.append(paramdo.toString());
      ((e)localObject).a(10020, localStringBuilder.toString(), c.g().getString(2131493105));
      c();
    }
    paramdo = new StringBuilder();
    paramdo.append("@");
    paramdo.append(hashCode());
    paramdo.append(" recv response, ret: ");
    paramdo.append(this.a.a);
    TmsLog.i("ProtocolBase", paramdo.toString());
    return this.a;
  }
  
  protected void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------------------------------\nhandler:");
    localStringBuilder.append(this.b.d);
    localStringBuilder.append("    \nError=");
    localStringBuilder.append(this.a.a);
    localStringBuilder.append("    \nstrdebug:");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("    \nstruser:");
    localStringBuilder.append(this.a.c);
    g.c(localStringBuilder.toString());
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