package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tmsdk.common.util.TmsLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class tr
  implements aat
{
  protected xh a = new xh();
  protected abc b;
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
    xj.c(localStringBuilder.toString());
  }
  
  public abd a(Serializable paramSerializable)
  {
    return null;
  }
  
  public Serializable a(abd paramabd)
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
  
  protected abstract void a(abc paramabc);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public abc b(abc paramabc)
  {
    return paramabc;
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder("------------------------------\nhandler:");
    localStringBuilder.append(this.b.d);
    xj.b(localStringBuilder.toString());
  }
  
  public final xh c(abc paramabc)
  {
    this.b = paramabc;
    a(paramabc);
    String str = a();
    if (str == null)
    {
      d();
      return this.a;
    }
    ajn localajn = new ajn();
    Object localObject = new StringBuilder("cmd:");
    ((StringBuilder)localObject).append(paramabc.a);
    xj.c(((StringBuilder)localObject).toString());
    localObject = new StringBuilder("@");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" start req--> [url]");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" [seqid]");
    ((StringBuilder)localObject).append(si.b);
    TmsLog.i("ProtocolBase", ((StringBuilder)localObject).toString());
    int i = paramabc.m;
    StringBuilder localStringBuilder = null;
    if (i == 0)
    {
      paramabc = localajn.a(str);
    }
    else
    {
      if (paramabc.m == 1)
      {
        if (paramabc.n != null)
        {
          localObject = paramabc;
          if (paramabc.k) {
            localObject = b(paramabc);
          }
          paramabc = localajn.a(str, ((abc)localObject).n);
          break label288;
        }
      }
      else if (paramabc.m == 2)
      {
        if ((paramabc.o != null) && (!TextUtils.isEmpty(paramabc.p)))
        {
          paramabc = localajn.a(str, paramabc.o, paramabc.n, paramabc.p);
          break label288;
        }
      }
      else if ((paramabc.m == 3) && (paramabc.q != null) && (!TextUtils.isEmpty(paramabc.p)))
      {
        paramabc = localajn.a(str, paramabc.q, paramabc.n, paramabc.p);
        break label288;
      }
      paramabc = null;
    }
    label288:
    if (paramabc == null)
    {
      this.a.a(localajn.a);
      d();
      paramabc = new StringBuilder("@");
      paramabc.append(hashCode());
      paramabc.append(" recv response, ret: ");
      paramabc.append(this.a.a);
      TmsLog.i("ProtocolBase", paramabc.toString());
      return this.a;
    }
    try
    {
      if (this.b.a.equals("token.getstartupimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramabc);
        xj.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("startup_img", aap.a(paramabc));
        paramabc = (abc)localObject;
        localObject = localStringBuilder;
      }
      else if (this.b.a.equals("token.getcommonimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramabc);
        xj.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("img", aap.a(paramabc));
        paramabc = (abc)localObject;
        localObject = localStringBuilder;
      }
      else
      {
        localObject = new String(paramabc);
        paramabc = new StringBuilder();
        paramabc.append(this);
        paramabc.append("--responseString--");
        paramabc.append((String)localObject);
        xj.a(paramabc.toString());
        paramabc = new JSONObject((String)localObject);
      }
      a(paramabc);
      if (!this.a.b())
      {
        if (localObject != null)
        {
          paramabc = new StringBuilder();
          paramabc.append(this);
          paramabc.append("\nR E S P O N S E: \n");
          paramabc.append((String)localObject);
          xj.c(paramabc.toString());
        }
        d();
      }
      else
      {
        if (localObject != null)
        {
          paramabc = new StringBuilder();
          paramabc.append(this);
          paramabc.append("\nR E S P O N S E: \n");
          paramabc.append((String)localObject);
          xj.a(paramabc.toString());
        }
        b();
      }
    }
    catch (Exception paramabc)
    {
      paramabc.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nE X C E P T I O N: \n");
      ((StringBuilder)localObject).append(paramabc.toString());
      xj.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramabc.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder("Exception:");
      localStringBuilder.append(paramabc.toString());
      ((xh)localObject).a(10000, localStringBuilder.toString(), xf.g().getString(2131493106));
      d();
    }
    catch (JSONException paramabc)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nPARSE JSON FAILED: \n");
      ((StringBuilder)localObject).append(paramabc.toString());
      xj.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramabc.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder("JSONException:");
      localStringBuilder.append(paramabc.toString());
      ((xh)localObject).a(10020, localStringBuilder.toString(), xf.g().getString(2131493106));
      d();
    }
    paramabc = new StringBuilder("@");
    paramabc.append(hashCode());
    paramabc.append(" recv response, ret: ");
    paramabc.append(this.a.a);
    TmsLog.i("ProtocolBase", paramabc.toString());
    return this.a;
  }
  
  public String c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tr
 * JD-Core Version:    0.7.0.1
 */