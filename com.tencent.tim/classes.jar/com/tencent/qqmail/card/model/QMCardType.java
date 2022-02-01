package com.tencent.qqmail.card.model;

import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.UMA.CardType;

public class QMCardType
{
  private String avatar;
  private String emptyTip;
  private boolean isDefault;
  private long maxId;
  private double priority;
  private String syncKey;
  private int typeId;
  private String typeName;
  
  public static QMCardType parserFrom(CardType paramCardType, QMCardType paramQMCardType)
  {
    QMCardType localQMCardType = new QMCardType();
    localQMCardType.typeId = paramCardType.type;
    localQMCardType.typeName = paramCardType.name.toString();
    String str;
    if (paramCardType.avatar == null)
    {
      str = null;
      localQMCardType.avatar = str;
      localQMCardType.priority = paramCardType.priority;
      if (paramQMCardType != null)
      {
        localQMCardType.syncKey = paramQMCardType.syncKey;
        localQMCardType.maxId = paramQMCardType.maxId;
      }
      localQMCardType.isDefault = paramCardType.isdefault;
      if (paramCardType.emptyTip != null) {
        break label105;
      }
    }
    label105:
    for (paramCardType = "";; paramCardType = paramCardType.emptyTip.toString())
    {
      localQMCardType.emptyTip = paramCardType;
      return localQMCardType;
      str = paramCardType.avatar.toString();
      break;
    }
  }
  
  public boolean equals(QMCardType paramQMCardType)
  {
    return (this.typeId == paramQMCardType.typeId) && (this.typeName.equals(paramQMCardType.typeName)) && (this.avatar.equals(paramQMCardType.avatar)) && (Math.abs(this.priority - paramQMCardType.priority) < 1.0E-006D);
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public String getEmptyTip()
  {
    return this.emptyTip;
  }
  
  public long getMaxId()
  {
    return this.maxId;
  }
  
  public double getPriority()
  {
    return this.priority;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public int getTypeId()
  {
    return this.typeId;
  }
  
  public String getTypeName()
  {
    return this.typeName;
  }
  
  public boolean isDefault()
  {
    return this.isDefault;
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setEmptyTip(String paramString)
  {
    this.emptyTip = paramString;
  }
  
  public void setIsDefault(boolean paramBoolean)
  {
    this.isDefault = paramBoolean;
  }
  
  public void setMaxId(long paramLong)
  {
    this.maxId = paramLong;
  }
  
  public void setPriority(double paramDouble)
  {
    this.priority = paramDouble;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
  
  public void setTypeId(int paramInt)
  {
    this.typeId = paramInt;
  }
  
  public void setTypeName(String paramString)
  {
    this.typeName = paramString;
  }
  
  public String toString()
  {
    return "QMCardType:{typeId=" + this.typeId + ",typeName=" + this.typeName + ",avatar=" + this.avatar + ",priority=" + this.priority + ",syncKey=" + this.syncKey + ",maxId=" + this.maxId + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.model.QMCardType
 * JD-Core Version:    0.7.0.1
 */