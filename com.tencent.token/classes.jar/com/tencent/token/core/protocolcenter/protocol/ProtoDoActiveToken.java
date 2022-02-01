package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.dr;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.global.k;
import com.tencent.token.utils.encrypt.b;
import com.tencent.token.utils.l;
import com.tmsdk.base.utils.NetworkUtil;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoDoActiveToken
  extends d
{
  private static final dr e = new dr("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private final long d = 2L;
  private dr f = new dr("-1");
  private cd g = cd.c();
  
  static String e()
  {
    int i = 4;
    for (;;)
    {
      String str = k.d();
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      if ((!k.c()) && (TextUtils.isEmpty(btmsdkobf.bw.ah().aj())) && (NetworkUtil.isNetworkConnected())) {
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (i <= 0)
      {
        TmsLog.i("mod_seed", "turing fail");
        return "";
      }
      i -= 1;
    }
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    this.f = b.a();
    Object localObject = b.a(this.f, 2L, e);
    if ((this.f != null) && (localObject != null) && (((String)localObject).length() != 0))
    {
      int i = cc.a + 1;
      cc.a = i;
      this.c = i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("client_pub_key=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", length=");
      localStringBuilder.append(((String)localObject).length());
      g.a(localStringBuilder.toString());
      localObject = l.a(new Object[] { "imei", cd.b(), "clt_pub_key", localObject, "seq_id", Integer.valueOf(this.c), "op_time", Integer.valueOf((int)(cd.c().s() / 1000L)), "turingd_ticket_id", e() });
      if (localObject == null)
      {
        this.a.a(10000, "encrypt imei failed");
        return null;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("?aq_base_sid=");
      localStringBuilder.append(str);
      localStringBuilder.append("&data=");
      localStringBuilder.append((String)localObject);
      str = localStringBuilder.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c.e());
      ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_activate_token_encrypt");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    this.a.b(10025);
    return null;
  }
  
  protected void a(dp paramdp) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("active token parseJon, errcode: ");
    ((StringBuilder)localObject).append(i);
    TmsLog.i("mod_seed", ((StringBuilder)localObject).toString());
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((e)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (this.c != i)
      {
        this.a.b(10030);
        return;
      }
      localObject = paramJSONObject.getString("svc_pub_key");
      if (((String)localObject).length() > 0)
      {
        try
        {
          l = paramJSONObject.getLong("seed_expire_time");
          this.g.c(l);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        this.g.e();
        localObject = new dr((String)localObject, 16);
        localObject = b.b(this.f, (dr)localObject, e);
        if (localObject == null)
        {
          this.a.b(10026);
          return;
        }
        this.g.a((dr)localObject);
        this.g.n();
        this.g.v();
        long l = paramJSONObject.getLong("server_time");
        this.g.b(l);
        com.tencent.token.bw.a().a(null);
        this.a.c();
        return;
      }
      throw new JSONException("");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoActiveToken
 * JD-Core Version:    0.7.0.1
 */