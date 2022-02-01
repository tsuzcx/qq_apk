package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.model.Attach;
import java.util.ArrayList;
import java.util.Iterator;

public class QMNoteAttachList
  extends QMDomain
{
  public ArrayList<Attach> attachListInfo = new ArrayList();
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONArray("attList");
    if (paramJSONObject != null)
    {
      this.attachListInfo.clear();
      paramJSONObject = paramJSONObject.iterator();
      while (paramJSONObject.hasNext())
      {
        Object localObject = paramJSONObject.next();
        Attach localAttach = new Attach(false);
        localAttach.parseWithDictionary((JSONObject)localObject);
        this.attachListInfo.add(localAttach);
      }
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"QMNoteAttachList\"");
    if ((this.attachListInfo != null) && (this.attachListInfo.size() > 0))
    {
      localStringBuffer.append(",\"attList\":[");
      int j = this.attachListInfo.size();
      int i = 0;
      while (i < j)
      {
        Attach localAttach = (Attach)this.attachListInfo.get(i);
        if (localAttach != null)
        {
          if (i > 0) {
            localStringBuffer.append(',');
          }
          localStringBuffer.append(localAttach.toString());
        }
        i += 1;
      }
      localStringBuffer.append("]");
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMNoteAttachList
 * JD-Core Version:    0.7.0.1
 */