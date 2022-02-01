package com.tencent.qqmail.namelist.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.QMDomain;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

public class NameListContact
  extends QMDomain
{
  private int accountId;
  private String email;
  private long id;
  private boolean isQQ;
  private int type;
  
  public static long generateId(int paramInt, String paramString)
  {
    return QMMath.hashLong(String.valueOf(paramInt) + "^" + paramString);
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public boolean isQQ()
  {
    return this.isQQ;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    if (paramJSONObject == null) {
      return false;
    }
    paramJSONObject = (String)paramJSONObject.get("item");
    boolean bool1 = bool2;
    if (paramJSONObject != null) {
      if (!StringExtention.isNullOrEmpty(getEmail()))
      {
        bool1 = bool2;
        if (getEmail().equals(paramJSONObject)) {}
      }
      else
      {
        bool1 = true;
        setEmail(paramJSONObject);
      }
    }
    return bool1;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setIsQQ(boolean paramBoolean)
  {
    this.isQQ = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static enum NameListContactType
  {
    BLACK,  WHITE;
    
    private NameListContactType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.model.NameListContact
 * JD-Core Version:    0.7.0.1
 */