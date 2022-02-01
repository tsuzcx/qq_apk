package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;
import java.util.Date;

public class MailVoteInformation
  extends QMDomain
{
  private static final long serialVersionUID = 4710405918889592874L;
  private String body;
  private Date date;
  private MailContact from;
  private String subject;
  private String topicId;
  
  public String getBody()
  {
    return this.body;
  }
  
  public Date getDate()
  {
    return this.date;
  }
  
  public MailContact getFrom()
  {
    return this.from;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public String getTopicId()
  {
    return this.topicId;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = (String)paramJSONObject.get("body");
      if (localObject != null) {
        setBody((String)localObject);
      }
      localObject = (String)paramJSONObject.get("subj");
      if (localObject != null) {
        setSubject((String)localObject);
      }
      localObject = paramJSONObject.getJSONObject("from");
      if (localObject != null)
      {
        setFrom(null);
        setFrom(new MailContact());
        getFrom().parseWithDictionary((JSONObject)localObject);
      }
      localObject = (String)paramJSONObject.get("topicid");
      if (localObject != null) {
        setTopicId((String)localObject);
      }
      paramJSONObject = new Date(paramJSONObject.getLong("date").longValue() * 1000L);
      if (paramJSONObject != null) {
        setDate(paramJSONObject);
      }
      return false;
    }
    catch (Exception paramJSONObject) {}
    return false;
  }
  
  public void setBody(String paramString)
  {
    this.body = paramString;
  }
  
  public void setDate(Date paramDate)
  {
    this.date = paramDate;
  }
  
  public void setFrom(MailContact paramMailContact)
  {
    this.from = paramMailContact;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public void setTopicId(String paramString)
  {
    this.topicId = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailVoteInformation\",");
    if (getDate() != null) {
      localStringBuffer.append("\"date\":" + getDate().getTime() / 1000L + ",");
    }
    String str;
    if (getSubject() != null)
    {
      str = getSubject().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"subj\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getBody() != null)
    {
      str = getBody().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"body\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getTopicId() != null) {
      localStringBuffer.append("\"topicid\":\"" + getTopicId() + "\",");
    }
    if (getFrom() != null) {
      localStringBuffer.append("\"from\":" + getFrom().toString());
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
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailVoteInformation
 * JD-Core Version:    0.7.0.1
 */