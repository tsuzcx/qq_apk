package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.QMMath;

public class ContactGroup
  extends QMDomain
  implements Cloneable, Comparable<ContactGroup>
{
  public static final int GGID_DOMAIN = 2;
  public static final int GGID_QQFRIEND = 1;
  private int accountId;
  private int count;
  private int ggid;
  private int gid;
  private int id;
  private String name;
  private int sequence;
  
  public static int generateId(int paramInt1, int paramInt2, int paramInt3)
  {
    return QMMath.hashInt(paramInt1 + "_" + paramInt2 + "_" + paramInt3);
  }
  
  public ContactGroup clone()
  {
    ContactGroup localContactGroup = new ContactGroup();
    localContactGroup.setId(this.id);
    localContactGroup.setGid(this.gid);
    localContactGroup.setGgid(this.ggid);
    localContactGroup.setAccountId(this.accountId);
    localContactGroup.setCount(this.count);
    localContactGroup.setName(this.name);
    localContactGroup.setSequence(this.sequence);
    return localContactGroup;
  }
  
  public int compareTo(ContactGroup paramContactGroup)
  {
    if (getSequence() < paramContactGroup.getSequence()) {
      return -1;
    }
    if (paramContactGroup.getSequence() == getSequence()) {
      return 0;
    }
    return 1;
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public int getGgid()
  {
    return this.ggid;
  }
  
  public int getGid()
  {
    return this.gid;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getSequence()
  {
    return this.sequence;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    String str = (String)paramJSONObject.get("groupid");
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!str.equals(String.valueOf(getGid())))
      {
        setGid(Integer.parseInt(str));
        bool1 = true;
      }
    }
    str = (String)paramJSONObject.get("grpcnt");
    bool2 = bool1;
    if (str != null)
    {
      bool2 = bool1;
      if (!str.equals(String.valueOf(getCount())))
      {
        setCount(Integer.parseInt(str));
        bool2 = true;
      }
    }
    str = (String)paramJSONObject.get("grpname");
    bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!str.equals(getName()))
      {
        setName(str);
        bool1 = true;
      }
    }
    paramJSONObject = (String)paramJSONObject.get("sequence");
    bool2 = bool1;
    if (paramJSONObject != null)
    {
      bool2 = bool1;
      if (!paramJSONObject.equals(String.valueOf(getSequence())))
      {
        setSequence(Integer.parseInt(paramJSONObject));
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setGgid(int paramInt)
  {
    this.ggid = paramInt;
  }
  
  public void setGid(int paramInt)
  {
    this.gid = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSequence(int paramInt)
  {
    this.sequence = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"ContactGroup\",");
    localStringBuilder.append("\"id\":").append(this.id).append(",");
    localStringBuilder.append("\"gid\":").append(this.gid).append(",");
    localStringBuilder.append("\"ggid\":").append(this.ggid).append(",");
    localStringBuilder.append("\"accountId\":").append(this.accountId).append(",");
    localStringBuilder.append("\"count\":").append(this.count).append(",");
    localStringBuilder.append("\"sequence\":").append(this.sequence).append(",");
    if (this.name != null) {
      localStringBuilder.append("\"name\":").append(this.name);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.ContactGroup
 * JD-Core Version:    0.7.0.1
 */