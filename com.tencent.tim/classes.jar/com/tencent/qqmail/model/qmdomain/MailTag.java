package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;

public class MailTag
  extends QMDomain
{
  private static final long serialVersionUID = 8674861112017991932L;
  private String color;
  private String name;
  private String tagId;
  
  public MailTag() {}
  
  public MailTag(String paramString1, String paramString2, String paramString3)
  {
    setTagId(paramString1);
    setName(paramString2);
    setColor(paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (!(paramObject instanceof MailTag))) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          paramObject = (MailTag)paramObject;
          bool1 = bool2;
        } while (this == paramObject);
        if ((this.name != null) && (!this.name.equals(paramObject.name))) {
          return false;
        }
        if ((this.color != null) && (!this.color.equals(paramObject.color))) {
          return false;
        }
        bool1 = bool2;
      } while (this.tagId == null);
      bool1 = bool2;
    } while (this.tagId.equals(paramObject.tagId));
    return false;
  }
  
  public String getColor()
  {
    return this.color;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getTagId()
  {
    return this.tagId;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool4 = false;
    bool3 = false;
    boolean bool2 = bool4;
    try
    {
      String str = (String)paramJSONObject.get("id");
      boolean bool1 = bool3;
      if (str != null)
      {
        bool2 = bool4;
        if (getTagId() != null)
        {
          bool2 = bool4;
          if (!getTagId().equals(""))
          {
            bool2 = bool4;
            bool4 = getTagId().equals(str);
            bool1 = bool3;
            if (bool4) {
              break label83;
            }
          }
        }
      }
      label83:
      return bool3;
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        setTagId(str);
        bool1 = true;
        bool2 = bool1;
        str = (String)paramJSONObject.get("name");
        bool3 = bool1;
        if (str != null)
        {
          bool2 = bool1;
          if (getName() != null)
          {
            bool2 = bool1;
            if (!getName().equals(""))
            {
              bool2 = bool1;
              bool4 = getName().equals(str);
              bool3 = bool1;
              if (bool4) {
                break label157;
              }
            }
          }
          setName(str);
          bool3 = true;
        }
        label157:
        bool2 = bool3;
        paramJSONObject = (String)paramJSONObject.get("color");
        if (paramJSONObject == null) {
          break label228;
        }
        bool2 = bool3;
        if (getColor() != null)
        {
          bool2 = bool3;
          if (!getColor().equals(""))
          {
            bool2 = bool3;
            bool1 = getColor().equals(paramJSONObject);
            if (bool1) {
              break label228;
            }
          }
        }
        setColor(paramJSONObject);
        return true;
      }
      catch (Exception paramJSONObject)
      {
        return true;
      }
      paramJSONObject = paramJSONObject;
      return bool2;
    }
  }
  
  public void setColor(String paramString)
  {
    this.color = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setTagId(String paramString)
  {
    this.tagId = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailTag\",");
    if (getTagId() != null) {
      localStringBuffer.append("\"id\":\"" + getTagId() + "\",");
    }
    if (getName() != null)
    {
      String str = getName().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"name\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getColor() != null) {
      localStringBuffer.append("\"color\":\"" + getColor() + "\"");
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
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailTag
 * JD-Core Version:    0.7.0.1
 */