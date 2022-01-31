package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoWtLogin
  extends e
{
  private String d;
  private byte[] e;
  private int f;
  
  public static void a(ev paramev, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramev.c.put("param.uin.wtlogin", paramString);
    paramev.c.put("param.wtlogin.a2", paramArrayOfByte);
    paramev.c.put("param.wtlogin.type", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cw.a + 1;
    cw.a = i;
    this.c = i;
    String str2 = w.a(new Object[] { "uin", this.d, "wtlogin_sig", w.a(this.e), "wtlogin_type", Integer.valueOf(this.f), "seq_id", Integer.valueOf(this.c), "op_time", Integer.valueOf((int)(cx.c().s() / 1000L)) });
    if (str2 == null)
    {
      this.a.b(10000);
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_vfy_wtlogin_encrypt" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((String)paramev.c.get("param.uin.wtlogin"));
    this.e = ((byte[])paramev.c.get("param.wtlogin.a2"));
    this.f = ((Integer)paramev.c.get("param.wtlogin.type")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
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
        QQUser localQQUser = do.a().d(l2);
        if (localQQUser != null)
        {
          localQQUser.mUin = l1;
          localQQUser.mUinMask = paramJSONObject;
        }
        this.b.c.put("param.uinhash", Long.valueOf(l1));
        this.b.c.put("param.wtlogin.a2", this.e);
        do.a().e(l2);
        this.a.c();
        return;
      }
      catch (Exception paramJSONObject)
      {
        this.a.b(10000);
        return;
      }
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoWtLogin
 * JD-Core Version:    0.7.0.1
 */