package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoWtLogin
  extends d
{
  private String d;
  private byte[] e;
  private int f;
  
  public static void a(do paramdo, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramdo.c.put("param.uin.wtlogin", paramString);
    paramdo.c.put("param.wtlogin.a2", paramArrayOfByte);
    paramdo.c.put("param.wtlogin.type", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cb.a + 1;
    cb.a = i;
    this.c = i;
    String str2 = l.a(new Object[] { "uin", this.d, "wtlogin_sig", l.a(this.e), "wtlogin_type", Integer.valueOf(this.f), "seq_id", Integer.valueOf(this.c), "op_time", Integer.valueOf((int)(cc.c().s() / 1000L)) });
    if (str2 == null)
    {
      this.a.b(10000);
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_vfy_wtlogin_encrypt" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((String)paramdo.c.get("param.uin.wtlogin"));
    this.e = ((byte[])paramdo.c.get("param.wtlogin.a2"));
    this.f = ((Integer)paramdo.c.get("param.wtlogin.type")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
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
      long l1 = Long.parseLong(paramJSONObject.getString("uin"));
      paramJSONObject = paramJSONObject.getString("uin_mask");
      try
      {
        long l2 = Long.parseLong(this.d);
        QQUser localQQUser = cr.a().d(l2);
        if (localQQUser != null)
        {
          localQQUser.mUin = l1;
          localQQUser.mUinMask = paramJSONObject;
        }
        this.b.c.put("param.uinhash", Long.valueOf(l1));
        this.b.c.put("param.wtlogin.a2", this.e);
        cr.a().e(l2);
        this.a.c();
        return;
      }
      catch (Exception paramJSONObject)
      {
        this.a.b(10000);
        return;
      }
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoWtLogin
 * JD-Core Version:    0.7.0.1
 */