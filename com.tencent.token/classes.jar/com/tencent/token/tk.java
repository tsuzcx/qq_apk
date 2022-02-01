package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tmsdk.common.util.TmsLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class tk
  implements aai
{
  protected wz a = new wz();
  protected aar b;
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
    xb.c(localStringBuilder.toString());
  }
  
  public aas a(Serializable paramSerializable)
  {
    return null;
  }
  
  public Serializable a(aas paramaas)
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
  
  protected abstract void a(aar paramaar);
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public aar b(aar paramaar)
  {
    return paramaar;
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder("------------------------------\nhandler:");
    localStringBuilder.append(this.b.d);
    xb.b(localStringBuilder.toString());
  }
  
  public final wz c(aar paramaar)
  {
    this.b = paramaar;
    a(paramaar);
    String str = a();
    if (str == null)
    {
      d();
      return this.a;
    }
    ahr localahr = new ahr();
    Object localObject = new StringBuilder("cmd:");
    ((StringBuilder)localObject).append(paramaar.a);
    xb.c(((StringBuilder)localObject).toString());
    localObject = new StringBuilder("@");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" start req--> [url]");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" [seqid]");
    ((StringBuilder)localObject).append(sb.b);
    TmsLog.i("ProtocolBase", ((StringBuilder)localObject).toString());
    int i = paramaar.m;
    StringBuilder localStringBuilder = null;
    if (i == 0)
    {
      paramaar = localahr.a(str);
    }
    else
    {
      if (paramaar.m == 1)
      {
        if (paramaar.n != null)
        {
          localObject = paramaar;
          if (paramaar.k) {
            localObject = b(paramaar);
          }
          paramaar = localahr.a(str, ((aar)localObject).n);
          break label288;
        }
      }
      else if (paramaar.m == 2)
      {
        if ((paramaar.o != null) && (!TextUtils.isEmpty(paramaar.p)))
        {
          paramaar = localahr.a(str, paramaar.o, paramaar.n, paramaar.p);
          break label288;
        }
      }
      else if ((paramaar.m == 3) && (paramaar.q != null) && (!TextUtils.isEmpty(paramaar.p)))
      {
        paramaar = localahr.a(str, paramaar.q, paramaar.n, paramaar.p);
        break label288;
      }
      paramaar = null;
    }
    label288:
    if (paramaar == null)
    {
      this.a.a(localahr.a);
      d();
      paramaar = new StringBuilder("@");
      paramaar.append(hashCode());
      paramaar.append(" recv response, ret: ");
      paramaar.append(this.a.a);
      TmsLog.i("ProtocolBase", paramaar.toString());
      return this.a;
    }
    try
    {
      if (this.b.a.equals("token.getstartupimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramaar);
        xb.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("startup_img", aae.a(paramaar));
        paramaar = (aar)localObject;
        localObject = localStringBuilder;
      }
      else if (this.b.a.equals("token.getcommonimg"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("device config");
        ((StringBuilder)localObject).append(paramaar);
        xb.a(((StringBuilder)localObject).toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("img", aae.a(paramaar));
        paramaar = (aar)localObject;
        localObject = localStringBuilder;
      }
      else
      {
        localObject = new String(paramaar);
        paramaar = new StringBuilder();
        paramaar.append(this);
        paramaar.append("--responseString--");
        paramaar.append((String)localObject);
        xb.a(paramaar.toString());
        paramaar = new JSONObject((String)localObject);
      }
      a(paramaar);
      if (!this.a.b())
      {
        if (localObject != null)
        {
          paramaar = new StringBuilder();
          paramaar.append(this);
          paramaar.append("\nR E S P O N S E: \n");
          paramaar.append((String)localObject);
          xb.c(paramaar.toString());
        }
        d();
      }
      else
      {
        if (localObject != null)
        {
          paramaar = new StringBuilder();
          paramaar.append(this);
          paramaar.append("\nR E S P O N S E: \n");
          paramaar.append((String)localObject);
          xb.a(paramaar.toString());
        }
        b();
      }
    }
    catch (Exception paramaar)
    {
      paramaar.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nE X C E P T I O N: \n");
      ((StringBuilder)localObject).append(paramaar.toString());
      xb.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramaar.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder("Exception:");
      localStringBuilder.append(paramaar.toString());
      ((wz)localObject).a(10000, localStringBuilder.toString(), wx.g().getString(2131493106));
      d();
    }
    catch (JSONException paramaar)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("\nPARSE JSON FAILED: \n");
      ((StringBuilder)localObject).append(paramaar.toString());
      xb.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("cmd ");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" has exception: ");
      ((StringBuilder)localObject).append(paramaar.toString());
      TmsLog.e("mod_seed", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder("JSONException:");
      localStringBuilder.append(paramaar.toString());
      ((wz)localObject).a(10020, localStringBuilder.toString(), wx.g().getString(2131493106));
      d();
    }
    paramaar = new StringBuilder("@");
    paramaar.append(hashCode());
    paramaar.append(" recv response, ret: ");
    paramaar.append(this.a.a);
    TmsLog.i("ProtocolBase", paramaar.toString());
    return this.a;
  }
  
  public String c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tk
 * JD-Core Version:    0.7.0.1
 */