package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.JLAppealInfo;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dm
  extends bm
{
  public ArrayList c = new ArrayList();
  private long d;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    str = "?uin=" + this.d + "&aq_base_sid=" + str;
    return b.c() + "/cn/mbtoken3/mbtoken3_query_jl_appeal_list" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.uinhash")).longValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = paramJSONObject.getJSONArray("appeal_list");
    i = 0;
    while (i < paramJSONObject.length())
    {
      JLAppealInfo localJLAppealInfo = new JLAppealInfo(paramJSONObject.getJSONObject(i));
      this.c.add(localJLAppealInfo);
      i += 1;
    }
    this.a.a = 0;
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.c;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dm
 * JD-Core Version:    0.7.0.1
 */