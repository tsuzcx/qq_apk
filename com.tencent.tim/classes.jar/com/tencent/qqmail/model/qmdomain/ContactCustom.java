package com.tencent.qqmail.model.qmdomain;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.QMMath;

public class ContactCustom
  implements Comparable<ContactCustom>
{
  public static final String ADDRESS_KEY = QMApplicationContext.sharedInstance().getString(2131692009);
  public static final String BIRTHDAY_KEY = QMApplicationContext.sharedInstance().getString(2131692011);
  public static final String ORG_KEY = QMApplicationContext.sharedInstance().getString(2131692064);
  public static final String QQ_KEY = QMApplicationContext.sharedInstance().getString(2131692067);
  public static final String TEL_KEY = QMApplicationContext.sharedInstance().getString(2131692086);
  public static final int TYPE_ADDRESS = 2;
  public static final int TYPE_BIRTHDAY = 3;
  public static final int TYPE_CUSTOM = 0;
  public static final int TYPE_IMS = 5;
  public static final int TYPE_ORG = 4;
  public static final int TYPE_TEL = 1;
  public static final String WECHAT_KEY = QMApplicationContext.sharedInstance().getString(2131692089);
  private String key;
  private int type;
  private String value;
  
  public ContactCustom clone()
  {
    ContactCustom localContactCustom = new ContactCustom();
    localContactCustom.setType(this.type);
    localContactCustom.setKey(this.key);
    localContactCustom.setValue(this.value);
    return localContactCustom;
  }
  
  public int compareTo(ContactCustom paramContactCustom)
  {
    if (paramContactCustom == null) {}
    do
    {
      do
      {
        do
        {
          return 1;
          if (this.type == paramContactCustom.type) {
            break;
          }
        } while (this.type > paramContactCustom.type);
        return -1;
      } while (paramContactCustom.getKey() == null);
      if (getKey() == null) {
        return -1;
      }
      int i = getKey().compareTo(paramContactCustom.getKey());
      if (i != 0) {
        return i;
      }
    } while (paramContactCustom.value == null);
    if (this.value == null) {
      return -1;
    }
    return this.value.compareTo(paramContactCustom.value);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (getClass() != paramObject.getClass());
    paramObject = (ContactCustom)paramObject;
    if ((this.type == paramObject.type) && (getKey() != null) && (paramObject.getKey() != null) && (getKey().equals(paramObject.getKey())) && (this.value != null) && (paramObject.value != null) && (this.value.equals(paramObject.value))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String getKey()
  {
    switch (getType())
    {
    default: 
      return this.key;
    case 0: 
    case 5: 
      return this.key;
    case 2: 
      return ADDRESS_KEY;
    case 3: 
      return BIRTHDAY_KEY;
    case 1: 
      return TEL_KEY;
    }
    return ORG_KEY;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.type);
    localStringBuilder.append("^");
    if (getKey() != null)
    {
      localStringBuilder.append(getKey());
      localStringBuilder.append("^");
    }
    if (this.value != null)
    {
      localStringBuilder.append(this.value);
      localStringBuilder.append("^");
    }
    return QMMath.hashInt(localStringBuilder.toString());
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"ContactCustom\",");
    localStringBuilder.append("\"key\":").append(this.key).append(",");
    localStringBuilder.append("\"value\":").append(this.value);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.ContactCustom
 * JD-Core Version:    0.7.0.1
 */