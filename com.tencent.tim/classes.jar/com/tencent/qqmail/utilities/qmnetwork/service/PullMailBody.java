package com.tencent.qqmail.utilities.qmnetwork.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.IJsonInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class PullMailBody
  extends BaseResponse
  implements IJsonInterface
{
  public long firstsvrtime = 0L;
  public ArrayList<PushMailBody> mailList;
  public int totalunread = 0;
  public int unread = 0;
  
  public JSONObject fromJson(String paramString)
  {
    paramString = super.fromJson(paramString);
    if (paramString != null)
    {
      if (paramString.containsKey("totalunread")) {
        this.totalunread = paramString.getIntValue("totalunread");
      }
      if (paramString.containsKey("unread")) {
        this.unread = paramString.getIntValue("unread");
      }
      if (paramString.containsKey("firstsvrtime")) {
        this.firstsvrtime = paramString.getLong("firstsvrtime").longValue();
      }
      if (paramString.containsKey("mails"))
      {
        this.mailList = new ArrayList();
        Object localObject1 = paramString.getJSONArray("mails");
        if (localObject1 != null)
        {
          localObject1 = ((JSONArray)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            if ((localObject2 instanceof JSONObject))
            {
              PushMailBody localPushMailBody = new PushMailBody();
              localPushMailBody.fromObject((JSONObject)localObject2);
              this.mailList.add(localPushMailBody);
            }
          }
        }
      }
    }
    return paramString;
  }
  
  public String toJson()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PullMailBody
 * JD-Core Version:    0.7.0.1
 */