package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tmsdk.common.util.TmsLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class tj
  implements aah
{
  protected wy a = new wy();
  protected aaq b;
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
    xa.c(localStringBuilder.toString());
  }
  
  public aar a(Serializable paramSerializable)
  {
    return null;
  }
  
  public Serializable a(aar paramaar)
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
  
  protected abstract void a(aaq paramaaq);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public aaq b(aaq paramaaq)
  {
    return paramaaq;
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder("------------------------------\nhandler:");
    localStringBuilder.append(this.b.d);
    xa.b(localStringBuilder.toString());
  }
  
  public final wy c(aaq paramaaq)
  {
    this.b = paramaaq;
    a(paramaaq);
    String str = a();
    if (str == null)
    {
      d();
      return this.a;
    }
    ahq localahq = new ahq();
    Object localObject = new StringBuilder("cmd:");
    ((StringBuilder)localObject).append(paramaaq.a);
    xa.c(((StringBuilder)localObject).toString());
    localObject = new StringBuilder("@");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" start req--> [url]");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" [seqid]");
    ((StringBuilder)localObject).append(sa.b);
    TmsLog.i("ProtocolBase", ((StringBuilder)localObject).toString());
    int i = paramaaq.m;
    StringBuilder localStringBuilder = null;
    if (i == 0)
    {
      paramaaq = localahq.a(str);
    }
    else
    {
      if (paramaaq.m == 1)
      {
        if (paramaaq.n != null)
        {
          localObject = paramaaq;
          if (paramaaq.k) {
            localObject = b(paramaaq);
          }
          paramaaq = localahq.a(str, ((aaq)localObject).n);
          break label288;
        }
      }
      else if (paramaaq.m == 2)
      {
        if ((paramaaq.o != null) && (!TextUtils.isEmpty(paramaaq.p)))
        {
          paramaaq = localahq.a(str, paramaaq.o, paramaaq.n, paramaaq.p);
          break label288;
        }
      }
      else if ((paramaaq.m == 3) && (paramaaq.q != null) && (!TextUtils.isEmpty(paramaaq.p)))
      {
        paramaaq = localahq.a(str, paramaaq.q, paramaaq.n, paramaaq.p);
        break label288;
      }
      paramaaq = null;
    }
    label288:
    if (paramaaq == null)
    {
      this.a.a(localahq.a);
      d();
      paramaaq = new StringBuilder("@");
      paramaaq.append(hashCode());
      paramaaq.append(" recv response, ret: ");
      paramaaq.append(this.a.a);
      TmsLog.i("ProtocolBase", paramaaq.toString());
      return this.a;
    }
    try
    {
      if (this.b.a.equals("token.getstartupimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramaaq);
        xa.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("startup_img", aad.a(paramaaq));
        paramaaq = (aaq)localObject;
        localObject = localStringBuilder;
      }
      else if (this.b.a.equals("token.getcommonimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramaaq);
        xa.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("img", aad.a(paramaaq));
        paramaaq = (aaq)localObject;
        localObject = localStringBuilder;
      }
      else
      {
        localObject = new String(paramaaq);
        paramaaq = new StringBuilder();
        paramaaq.append(this);
        paramaaq.append("--responseString--");
        paramaaq.append((String)localObject);
        xa.a(paramaaq.toString());
        paramaaq = new JSONObject((String)localObject);
      }
      a(paramaaq);
      if (!this.a.b())
      {
        if (localObject != null)
        {
          paramaaq = new StringBuilder();
          paramaaq.append(this);
          paramaaq.append("\nR E S P O N S E: \n");
          paramaaq.append((String)localObject);
          xa.c(paramaaq.toString());
        }
        d();
      }
      else
      {
        if (localObject != null)
        {
          paramaaq = new StringBuilder();
          paramaaq.append(this);
          paramaaq.append("\nR E S P O N S E: \n");
          paramaaq.append((String)localObject);
          xa.a(paramaaq.toString());
        }
        b();
      }
    }
    catch (Exception paramaaq)
    {
      paramaaq.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nE X C E P T I O N: \n");
      ((StringBuilder)localObject).append(paramaaq.toString());
      xa.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramaaq.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder("Exception:");
      localStringBuilder.append(paramaaq.toString());
      ((wy)localObject).a(10000, localStringBuilder.toString(), ww.g().getString(2131493106));
      d();
    }
    catch (JSONException paramaaq)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nPARSE JSON FAILED: \n");
      ((StringBuilder)localObject).append(paramaaq.toString());
      xa.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramaaq.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder("JSONException:");
      localStringBuilder.append(paramaaq.toString());
      ((wy)localObject).a(10020, localStringBuilder.toString(), ww.g().getString(2131493106));
      d();
    }
    paramaaq = new StringBuilder("@");
    paramaaq.append(hashCode());
    paramaaq.append(" recv response, ret: ");
    paramaaq.append(this.a.a);
    TmsLog.i("ProtocolBase", paramaaq.toString());
    return this.a;
  }
  
  public String c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tj
 * JD-Core Version:    0.7.0.1
 */