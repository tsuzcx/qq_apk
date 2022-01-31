package com.tencent.token;

import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class ej
  extends bm
{
  public String c;
  public long d;
  public int e;
  
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
    if (this.e == 0) {}
    for (String str2 = s.a(new Object[] { "pwd", this.c, "op_time", Long.valueOf(ag.c().r() / 1000L) }); str2 == null; str2 = s.a(new Object[] { "pwd", this.c, "op_time", Long.valueOf(ag.c().r() / 1000L), "scene_id", Integer.valueOf(this.e) }))
    {
      this.a.a(10000, "encrypt qqtoken code failed", null);
      return null;
    }
    str1 = "?uin=" + this.d + "&sess_id=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_modify_pwd" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.c = ((String)paramfs.c.get("param.qqpwd"));
    this.e = ((Integer)paramfs.c.get("param.scene.id")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ej
 * JD-Core Version:    0.7.0.1
 */