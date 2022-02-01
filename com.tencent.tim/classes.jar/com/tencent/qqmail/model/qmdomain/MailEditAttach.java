package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.utilities.common.CommUtils;

public class MailEditAttach
  extends Attach
{
  private String icon;
  private String key;
  private String name;
  private String size;
  private String type;
  private String url;
  
  public MailEditAttach() {}
  
  public MailEditAttach(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSize()
  {
    return this.size;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = bool4;
    try
    {
      super.parseWithDictionary(paramJSONObject);
      bool1 = bool4;
      String str = paramJSONObject.getString("name");
      if (str != null)
      {
        bool1 = bool4;
        if (CommUtils.isNullorBlankorNotEquals(getName(), str))
        {
          bool1 = bool4;
          setName(str);
        }
      }
      bool1 = bool4;
      str = paramJSONObject.getString("type");
      if (str != null)
      {
        bool1 = bool4;
        if (CommUtils.isNullorBlankorNotEquals(getType(), str))
        {
          bool1 = bool4;
          setType(str);
        }
      }
      bool1 = bool4;
      str = paramJSONObject.getString("icon");
      if (str != null)
      {
        bool1 = bool4;
        if (CommUtils.isNullorBlankorNotEquals(getIcon(), str))
        {
          bool1 = bool4;
          setIcon(str);
        }
      }
      bool1 = bool4;
      str = paramJSONObject.getString("url");
      if (str != null)
      {
        bool1 = bool4;
        if (CommUtils.isNullorBlankorNotEquals(getUrl(), str))
        {
          bool1 = bool4;
          setUrl(str);
        }
      }
      bool1 = bool4;
      str = paramJSONObject.getString("key");
      boolean bool2 = bool3;
      if (str != null)
      {
        bool2 = bool3;
        bool1 = bool4;
        if (CommUtils.isNullorBlankorNotEquals(getKey(), str))
        {
          bool1 = true;
          bool2 = true;
          setKey(str);
        }
      }
      bool1 = bool2;
      paramJSONObject = paramJSONObject.getString("size");
      if (paramJSONObject != null)
      {
        bool1 = bool2;
        if (CommUtils.isNullorBlankorNotEquals(getSize(), paramJSONObject))
        {
          bool1 = bool2;
          setSize(paramJSONObject);
        }
      }
      return bool2;
    }
    catch (Exception paramJSONObject) {}
    return bool1;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSize(String paramString)
  {
    this.size = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailEditAttach\",");
    String str;
    if (getPreview().getDownloadUrl() != null)
    {
      str = getPreview().getDownloadUrl().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"download\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getName() != null)
    {
      str = getName().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"name\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getType() != null) {
      localStringBuffer.append("\"type\":\"" + getType() + "\",");
    }
    if (getIcon() != null) {
      localStringBuffer.append("\"icon\":\"" + getIcon() + "\",");
    }
    if (getUrl() != null) {
      localStringBuffer.append("\"url\":\"" + getUrl() + "\",");
    }
    if (getKey() != null) {
      localStringBuffer.append("\"key\":\"" + getKey() + "\",");
    }
    if (getSize() != null) {
      localStringBuffer.append("\"size\":\"" + getSize() + "\",");
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
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailEditAttach
 * JD-Core Version:    0.7.0.1
 */