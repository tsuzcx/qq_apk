package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.JLZone;
import com.tencent.token.core.bean.JLZone.JLZoneServer;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dq
  extends bm
{
  private ArrayList c = new ArrayList();
  
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
    str = "?aq_base_sid=" + str;
    return b.c() + "/cn/mbtoken3/mbtoken3_query_jl_zone_list" + str;
  }
  
  protected final void a(fs paramfs) {}
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = paramJSONObject.getJSONArray("zone_list");
    i = 0;
    while (i < paramJSONObject.length())
    {
      int k = paramJSONObject.getJSONObject(i).getInt("area_id");
      String str1 = paramJSONObject.getJSONObject(i).getString("area_name");
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray = paramJSONObject.getJSONObject(i).getJSONArray("world_list");
      JLZone localJLZone = new JLZone();
      int j = 0;
      while (j < localJSONArray.length())
      {
        int m = localJSONArray.getJSONObject(j).getInt("world_id");
        String str2 = localJSONArray.getJSONObject(j).getString("world_name");
        localJLZone.getClass();
        localArrayList.add(new JLZone.JLZoneServer(localJLZone, str2, m));
        j += 1;
      }
      localJLZone.name = str1;
      localJLZone.id = k;
      localJLZone.serverList = localArrayList;
      this.c.add(localJLZone);
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
 * Qualified Name:     com.tencent.token.dq
 * JD-Core Version:    0.7.0.1
 */