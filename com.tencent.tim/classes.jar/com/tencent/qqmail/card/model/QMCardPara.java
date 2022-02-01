package com.tencent.qqmail.card.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.UMA.CardPara;
import java.io.Serializable;

public class QMCardPara
  implements Serializable
{
  private String cardId;
  private String defaultValue;
  private String domId;
  private String key;
  private int limitCount;
  private String name;
  private int type;
  private String value;
  
  public QMCardPara() {}
  
  public QMCardPara(QMCardPara paramQMCardPara)
  {
    this.cardId = paramQMCardPara.cardId;
    this.key = paramQMCardPara.key;
    this.name = paramQMCardPara.name;
    this.value = paramQMCardPara.value;
    this.defaultValue = paramQMCardPara.defaultValue;
    this.domId = paramQMCardPara.domId;
    this.type = paramQMCardPara.type;
    this.limitCount = paramQMCardPara.limitCount;
  }
  
  public static QMCardPara parseFrom(String paramString, CardPara paramCardPara, QMCardPara paramQMCardPara)
  {
    if ((paramQMCardPara != null) && (!paramString.equals(paramQMCardPara.cardId))) {
      throw new IllegalArgumentException("parseFrom: " + paramString + ", " + paramQMCardPara.cardId);
    }
    if (paramQMCardPara != null) {}
    for (paramQMCardPara = new QMCardPara(paramQMCardPara);; paramQMCardPara = new QMCardPara())
    {
      paramQMCardPara.cardId = paramString;
      if (paramCardPara.key != null) {
        paramQMCardPara.key = paramCardPara.key.toString();
      }
      if (paramCardPara.name != null) {
        paramQMCardPara.name = paramCardPara.name.toString();
      }
      if (paramCardPara.value != null) {
        paramQMCardPara.value = paramCardPara.value.toString();
      }
      if (paramCardPara.default_value != null) {
        paramQMCardPara.defaultValue = paramCardPara.default_value.toString();
      }
      if (paramCardPara.domid != null) {
        paramQMCardPara.domId = paramCardPara.domid.toString();
      }
      if (paramCardPara.type != 0) {
        paramQMCardPara.type = paramCardPara.type;
      }
      if (paramCardPara.limit_count != 0) {
        paramQMCardPara.limitCount = paramCardPara.limit_count;
      }
      return paramQMCardPara;
    }
  }
  
  public static CardPara parseTo(QMCardPara paramQMCardPara, String paramString)
  {
    CardPara localCardPara = new CardPara();
    if ((paramQMCardPara != null) || (paramQMCardPara.getKey() != null)) {
      localCardPara.key = ByteString.copyFromUtf8(paramQMCardPara.getKey());
    }
    if (paramQMCardPara.getName() != null) {
      localCardPara.name = ByteString.copyFromUtf8(paramQMCardPara.getName());
    }
    if (paramString != null) {
      localCardPara.value = ByteString.copyFromUtf8(paramString);
    }
    for (;;)
    {
      if (paramQMCardPara.getDefaultValue() != null) {
        localCardPara.default_value = ByteString.copyFromUtf8(paramQMCardPara.getDefaultValue());
      }
      localCardPara.limit_count = paramQMCardPara.getLimitCount();
      if (paramQMCardPara.getDomId() != null) {
        localCardPara.domid = ByteString.copyFromUtf8(paramQMCardPara.getDomId());
      }
      localCardPara.type = paramQMCardPara.type;
      return localCardPara;
      if (paramQMCardPara.getValue() != null) {
        localCardPara.value = ByteString.copyFromUtf8(paramQMCardPara.getValue());
      }
    }
  }
  
  public String getCardId()
  {
    return this.cardId;
  }
  
  public String getDefaultValue()
  {
    return this.defaultValue;
  }
  
  public String getDomId()
  {
    return this.domId;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public int getLimitCount()
  {
    return this.limitCount;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    this.cardId = paramJSONObject.getString("cardId");
    String str = paramJSONObject.getString("key");
    if (str != null) {
      this.key = str;
    }
    str = paramJSONObject.getString("name");
    if (str != null) {
      this.name = str;
    }
    str = paramJSONObject.getString("value");
    if (str != null) {
      this.value = str;
    }
    str = paramJSONObject.getString("defaultValue");
    if (str != null) {
      this.defaultValue = str;
    }
    str = paramJSONObject.getString("domId");
    if (str != null) {
      this.domId = str;
    }
    this.type = paramJSONObject.getIntValue("type");
    this.limitCount = paramJSONObject.getIntValue("limitCount");
    return true;
  }
  
  public void setCardId(String paramString)
  {
    this.cardId = paramString;
  }
  
  public void setDefaultValue(String paramString)
  {
    this.defaultValue = paramString;
  }
  
  public void setDomId(String paramString)
  {
    this.domId = paramString;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setLimitCount(int paramInt)
  {
    this.limitCount = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
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
    localStringBuilder.append("\"class\":\"QMCardPara\",");
    if (this.key != null) {
      localStringBuilder.append("\"key\":\"").append(this.key).append("\",");
    }
    if (this.name != null) {
      localStringBuilder.append("\"name\":\"").append(this.name).append("\",");
    }
    if (this.value != null) {
      localStringBuilder.append("\"value\":\"").append(this.value).append("\",");
    }
    if (this.defaultValue != null) {
      localStringBuilder.append("\"defaultValue\":\"").append(this.defaultValue).append("\",");
    }
    if (this.domId != null) {
      localStringBuilder.append("\"domId\":\"").append(this.domId).append("\",");
    }
    localStringBuilder.append("\"type\":").append(this.type).append(",");
    localStringBuilder.append("\"limitCount\":").append(this.limitCount).append(",");
    localStringBuilder.append("\"cardId\":\"").append(this.cardId).append("\"}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.model.QMCardPara
 * JD-Core Version:    0.7.0.1
 */