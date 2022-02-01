package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vf
  extends ud
{
  private String d;
  private byte[] e;
  private int f;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((String)paramabm.c.get("param.uin.wtlogin"));
    this.e = ((byte[])paramabm.c.get("param.wtlogin.a2"));
    this.f = ((Integer)paramabm.c.get("param.wtlogin.type")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    long l1;
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (this.c != i)
      {
        this.a.a(10030, null, null);
        return;
      }
      l1 = Long.parseLong(paramJSONObject.getString("uin"));
      paramJSONObject = paramJSONObject.getString("uin_mask");
    }
    try
    {
      long l2 = Long.parseLong(this.d);
      QQUser localQQUser = tt.a().d(l2);
      if (localQQUser != null)
      {
        localQQUser.mUin = l1;
        localQQUser.mUinMask = paramJSONObject;
      }
      this.b.c.put("param.uinhash", Long.valueOf(l1));
      this.b.c.put("param.wtlogin.a2", this.e);
      tt.a().e(l2);
      this.a.a = 0;
      return;
    }
    catch (Exception paramJSONObject)
    {
      label185:
      break label185;
    }
    this.a.a(10000, null, null);
    return;
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vf
 * JD-Core Version:    0.7.0.1
 */