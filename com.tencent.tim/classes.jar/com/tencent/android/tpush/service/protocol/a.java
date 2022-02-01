package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
  extends d
{
  public long a = 0L;
  public String b = "";
  public int c = 0;
  public long d = 0L;
  public String e = "";
  public ArrayList<q> f = null;
  
  public MessageType a()
  {
    return MessageType.ACCOUNT;
  }
  
  public JSONObject a(Context paramContext)
  {
    paramContext = new JSONObject();
    paramContext.put("accessId", this.a);
    paramContext.put("accessKey", this.b);
    paramContext.put("operateType", this.c);
    paramContext.put("timestamp", this.d);
    paramContext.put("sdkVersion", this.e);
    if (this.f != null)
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject = ((q)localIterator.next()).a();
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
      }
      paramContext.put("typeAccounts", localJSONArray);
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.a
 * JD-Core Version:    0.7.0.1
 */