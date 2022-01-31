package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class cu
  extends bm
{
  private String c;
  private byte[] d;
  private int e;
  
  public static void a(fs paramfs, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramfs.c.put("param.uin.wtlogin", paramString);
    paramfs.c.put("param.wtlogin.a2", paramArrayOfByte);
    paramfs.c.put("param.wtlogin.type", Integer.valueOf(paramInt));
  }
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    String str2 = s.b(("{\"uin\":\"" + this.c + "\", \"wtlogin_sig\":\"" + s.a(this.d) + "\"" + ",\"wtlogin_type\":" + this.e + "}").getBytes());
    if (str2 == null)
    {
      this.a.a(10000, null, null);
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_vfy_wtlogin" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((String)paramfs.c.get("param.uin.wtlogin"));
    this.d = ((byte[])paramfs.c.get("param.wtlogin.a2"));
    this.e = ((Integer)paramfs.c.get("param.wtlogin.type")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    long l1 = Long.parseLong(paramJSONObject.getString("uin"));
    paramJSONObject = paramJSONObject.getString("uin_mask");
    try
    {
      long l2 = Long.parseLong(this.c);
      QQUser localQQUser = ax.a().d(l2);
      if (localQQUser != null)
      {
        localQQUser.mUin = l1;
        localQQUser.mUinMask = paramJSONObject;
      }
      this.b.c.put("param.uinhash", Long.valueOf(l1));
      this.b.c.put("param.wtlogin.a2", this.d);
      ax.a().e(l2);
      this.a.a = 0;
      return;
    }
    catch (Exception paramJSONObject)
    {
      this.a.a(10000, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cu
 * JD-Core Version:    0.7.0.1
 */