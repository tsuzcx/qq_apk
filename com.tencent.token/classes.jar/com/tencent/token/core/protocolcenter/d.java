package com.tencent.token.core.protocolcenter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.cc;
import com.tencent.token.dg;
import com.tencent.token.dp;
import com.tencent.token.dq;
import com.tencent.token.fc;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.m;
import com.tmsdk.common.util.TmsLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d
  implements dg
{
  protected e a = new e();
  protected dp b;
  protected int c;
  
  public dq a(Serializable paramSerializable)
  {
    return null;
  }
  
  public Serializable a(dq paramdq)
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
  
  protected abstract void a(dp paramdp);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public dp b(dp paramdp)
  {
    return paramdp;
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------------------------------\nhandler:");
    localStringBuilder.append(this.b.d);
    g.b(localStringBuilder.toString());
  }
  
  public e c(dp paramdp)
  {
    this.b = paramdp;
    a(paramdp);
    String str = a();
    if (str == null)
    {
      c();
      return this.a;
    }
    fc localfc = new fc();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cmd:");
    ((StringBuilder)localObject).append(paramdp.a);
    g.c(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" start req--> [url]");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" [seqid]");
    ((StringBuilder)localObject).append(cc.a);
    TmsLog.i("ProtocolBase", ((StringBuilder)localObject).toString());
    int i = paramdp.m;
    StringBuilder localStringBuilder = null;
    if (i == 0)
    {
      paramdp = localfc.a(str);
    }
    else
    {
      if (paramdp.m == 1)
      {
        if (paramdp.n != null)
        {
          localObject = paramdp;
          if (paramdp.k) {
            localObject = b(paramdp);
          }
          paramdp = localfc.a(str, ((dp)localObject).n);
          break label298;
        }
      }
      else if (paramdp.m == 2)
      {
        if ((paramdp.o != null) && (!TextUtils.isEmpty(paramdp.p)))
        {
          paramdp = localfc.a(str, paramdp.o, paramdp.n, paramdp.p);
          break label298;
        }
      }
      else if ((paramdp.m == 3) && (paramdp.q != null) && (!TextUtils.isEmpty(paramdp.p)))
      {
        paramdp = localfc.a(str, paramdp.q, paramdp.n, paramdp.p);
        break label298;
      }
      paramdp = null;
    }
    label298:
    if (paramdp == null)
    {
      this.a.a(localfc.a());
      c();
      paramdp = new StringBuilder();
      paramdp.append("@");
      paramdp.append(hashCode());
      paramdp.append(" recv response, ret: ");
      paramdp.append(this.a.a);
      TmsLog.i("ProtocolBase", paramdp.toString());
      return this.a;
    }
    try
    {
      if (this.b.a.equals("token.getstartupimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramdp);
        g.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("startup_img", m.a(paramdp));
        paramdp = (dp)localObject;
        localObject = localStringBuilder;
      }
      else if (this.b.a.equals("token.getcommonimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramdp);
        g.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("img", m.a(paramdp));
        paramdp = (dp)localObject;
        localObject = localStringBuilder;
      }
      else
      {
        localObject = new String(paramdp);
        paramdp = new StringBuilder();
        paramdp.append(this);
        paramdp.append("--responseString--");
        paramdp.append((String)localObject);
        g.a(paramdp.toString());
        paramdp = new JSONObject((String)localObject);
      }
      a(paramdp);
      if (!this.a.b())
      {
        if (localObject != null)
        {
          paramdp = new StringBuilder();
          paramdp.append(this);
          paramdp.append("\nR E S P O N S E: \n");
          paramdp.append((String)localObject);
          g.c(paramdp.toString());
        }
        c();
      }
      else
      {
        if (localObject != null)
        {
          paramdp = new StringBuilder();
          paramdp.append(this);
          paramdp.append("\nR E S P O N S E: \n");
          paramdp.append((String)localObject);
          g.a(paramdp.toString());
        }
        b();
      }
    }
    catch (Exception paramdp)
    {
      paramdp.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nE X C E P T I O N: \n");
      ((StringBuilder)localObject).append(paramdp.toString());
      g.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramdp.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception:");
      localStringBuilder.append(paramdp.toString());
      ((e)localObject).a(10000, localStringBuilder.toString(), c.g().getString(2131493106));
      c();
    }
    catch (JSONException paramdp)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nPARSE JSON FAILED: \n");
      ((StringBuilder)localObject).append(paramdp.toString());
      g.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramdp.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSONException:");
      localStringBuilder.append(paramdp.toString());
      ((e)localObject).a(10020, localStringBuilder.toString(), c.g().getString(2131493106));
      c();
    }
    paramdp = new StringBuilder();
    paramdp.append("@");
    paramdp.append(hashCode());
    paramdp.append(" recv response, ret: ");
    paramdp.append(this.a.a);
    TmsLog.i("ProtocolBase", paramdp.toString());
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
  
  public dq d(dp paramdp)
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