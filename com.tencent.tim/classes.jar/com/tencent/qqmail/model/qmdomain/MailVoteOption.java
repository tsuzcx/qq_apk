package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

public class MailVoteOption
  extends QMDomain
{
  private static final long serialVersionUID = 5736072660418648386L;
  private int count;
  private String name;
  private String percent;
  private String voteId;
  private ArrayList<Object> voter;
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPercent()
  {
    return this.percent;
  }
  
  public String getVoteId()
  {
    return this.voteId;
  }
  
  public ArrayList<Object> getVoter()
  {
    return this.voter;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    try
    {
      String str = (String)paramJSONObject.get("id");
      if (str != null) {
        setVoteId(str);
      }
      str = (String)paramJSONObject.get("name");
      if (str != null) {
        setName(str);
      }
      str = (String)paramJSONObject.get("percent");
      if (str != null) {
        setPercent(str);
      }
      if (paramJSONObject.get("cnt") != null) {
        setCount(Integer.parseInt((String)paramJSONObject.get("cnt")));
      }
      if (paramJSONObject.getJSONArray("voter") != null) {
        setVoter(new ArrayList(paramJSONObject.getJSONArray("voter")));
      }
      return false;
    }
    catch (Exception paramJSONObject) {}
    return false;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPercent(String paramString)
  {
    this.percent = paramString;
  }
  
  public void setVoteId(String paramString)
  {
    this.voteId = paramString;
  }
  
  public void setVoter(ArrayList<Object> paramArrayList)
  {
    this.voter = paramArrayList;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailVoteOption\",");
    if (getVoteId() != null) {
      localStringBuffer.append("\"id\":\"" + getVoteId() + "\",");
    }
    Object localObject1;
    if (getName() != null)
    {
      localObject1 = getName().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"name\":\"" + ((String)localObject1).replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getPercent() != null) {
      localStringBuffer.append("\"percent\":\"" + getPercent() + "\",");
    }
    localStringBuffer.append("\"cnt\":\"" + getCount() + "\",");
    if ((this.voter != null) && (this.voter.size() > 0))
    {
      localStringBuffer.append("\"voter\":[");
      localObject1 = this.voter.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuffer.append("\"" + localObject2.toString() + "\",");
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      localStringBuffer.append("],");
    }
    int i = localStringBuffer.length() - 1;
    if (localStringBuffer.charAt(i) == ',') {
      localStringBuffer.deleteCharAt(i);
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailVoteOption
 * JD-Core Version:    0.7.0.1
 */