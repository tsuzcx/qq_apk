package com.tencent.tim.cloudfile.recent;

import atlb;
import atmp;
import atmp.c;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecentWebNativeStorageManager$3
  implements Runnable
{
  public void run()
  {
    label387:
    label408:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        Object localObject1 = new JSONArray();
        JSONArray localJSONArray = new JSONArray();
        switch (this.val$fileType)
        {
        case 1: 
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("key", "last_browse_ts");
          ((JSONObject)localObject2).put("type", 1);
          localJSONArray.put(localObject2);
          localJSONObject.put("_conditions", localObject1);
          localJSONObject.put("_limitCount", this.val$limit);
          localJSONObject.put("_offsetCount", this.equ);
          localJSONObject.put("_orders", localJSONArray);
          if (QLog.isColorLevel())
          {
            localObject1 = atmp.access$200();
            localObject2 = new StringBuilder().append("fetch_recent_file fileType =").append(this.val$fileType).append("      list.size = ");
            if (0 == 0) {
              break label408;
            }
            throw new NullPointerException();
            QLog.i((String)localObject1, 2, "null");
          }
          localObject1 = new ArrayList();
          if (0 == 0) {
            break label387;
          }
          throw new NullPointerException();
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.i(atmp.access$200(), 1, "fetch_recent_file Exception e = " + localJSONException.toString());
        return;
      }
      localJSONException.put(atmp.a(this.this$0, atlb.eqm));
      continue;
      localJSONException.put(atmp.a(this.this$0, atlb.eqm + 1));
      continue;
      localJSONException.put(atmp.a(this.this$0, atlb.eqm + 2));
      continue;
      localJSONException.put(atmp.a(this.this$0, atlb.eqm + 4));
      continue;
      localJSONException.put(atmp.a(this.this$0, atlb.eqm + 16));
      localJSONException.put(atmp.a(this.this$0, atlb.eqm + 4));
      localJSONException.put(atmp.a(this.this$0, atlb.eqm + 32));
      continue;
      if (this.a != null)
      {
        this.a.nN(localJSONException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.recent.RecentWebNativeStorageManager.3
 * JD-Core Version:    0.7.0.1
 */