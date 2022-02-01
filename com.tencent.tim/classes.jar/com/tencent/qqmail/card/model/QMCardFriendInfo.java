package com.tencent.qqmail.card.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.UMA.FriendInfo;
import java.io.Serializable;

public class QMCardFriendInfo
  implements Serializable
{
  private String birthday;
  private String email;
  private String icon;
  private String id;
  private boolean isChinese;
  private boolean isSend;
  private String nickName;
  private long toDayTo;
  private long uin;
  
  public QMCardFriendInfo()
  {
    this.isSend = false;
  }
  
  public QMCardFriendInfo(QMCardFriendInfo paramQMCardFriendInfo)
  {
    this.id = paramQMCardFriendInfo.id;
    this.uin = paramQMCardFriendInfo.uin;
    this.email = paramQMCardFriendInfo.email;
    this.nickName = paramQMCardFriendInfo.nickName;
    this.birthday = paramQMCardFriendInfo.birthday;
    this.isChinese = paramQMCardFriendInfo.isChinese;
    this.toDayTo = paramQMCardFriendInfo.toDayTo;
    this.icon = paramQMCardFriendInfo.icon;
    this.isSend = paramQMCardFriendInfo.isSend;
  }
  
  public static QMCardFriendInfo parseFrom(FriendInfo paramFriendInfo, QMCardFriendInfo paramQMCardFriendInfo)
  {
    String str;
    if (paramQMCardFriendInfo != null)
    {
      paramQMCardFriendInfo = new QMCardFriendInfo(paramQMCardFriendInfo);
      paramQMCardFriendInfo.id = paramFriendInfo.subid.toString();
      paramQMCardFriendInfo.uin = paramFriendInfo.uin;
      if (paramFriendInfo.email == null) {
        break label141;
      }
      str = paramFriendInfo.email.toString();
      label47:
      paramQMCardFriendInfo.email = str;
      if (paramFriendInfo.nickname == null) {
        break label147;
      }
      str = paramFriendInfo.nickname.toString();
      label67:
      paramQMCardFriendInfo.nickName = str;
      if (paramFriendInfo.birthday == null) {
        break label153;
      }
      str = paramFriendInfo.birthday.toString();
      label87:
      paramQMCardFriendInfo.birthday = str;
      paramQMCardFriendInfo.isChinese = paramFriendInfo.ischinese;
      paramQMCardFriendInfo.toDayTo = paramFriendInfo.todayto;
      if (paramFriendInfo.photourl == null) {
        break label159;
      }
    }
    label141:
    label147:
    label153:
    label159:
    for (paramFriendInfo = paramFriendInfo.photourl.toString();; paramFriendInfo = "")
    {
      paramQMCardFriendInfo.icon = paramFriendInfo;
      return paramQMCardFriendInfo;
      paramQMCardFriendInfo = new QMCardFriendInfo();
      break;
      str = "";
      break label47;
      str = "";
      break label67;
      str = "";
      break label87;
    }
  }
  
  public String getBirthday()
  {
    return this.birthday;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getNickName()
  {
    return this.nickName;
  }
  
  public long getToDayTo()
  {
    return this.toDayTo;
  }
  
  public long getUin()
  {
    return this.uin;
  }
  
  public boolean isChinese()
  {
    return this.isChinese;
  }
  
  public boolean isSend()
  {
    return this.isSend;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.getString("id");
    String str = paramJSONObject.getString("email");
    if (str != null) {
      this.email = str;
    }
    str = paramJSONObject.getString("nickName");
    if (str != null) {
      this.nickName = str;
    }
    str = paramJSONObject.getString("birthday");
    if (str != null) {
      this.birthday = str;
    }
    str = paramJSONObject.getString("icon");
    if (str != null) {
      this.icon = str;
    }
    this.uin = paramJSONObject.getIntValue("uin");
    this.isChinese = paramJSONObject.getBooleanValue("isChinese");
    this.toDayTo = paramJSONObject.getLongValue("toDayTo");
    this.isSend = paramJSONObject.getBooleanValue("isSend");
    return true;
  }
  
  public void setBirthday(String paramString)
  {
    this.birthday = paramString;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setIsChinese(boolean paramBoolean)
  {
    this.isChinese = paramBoolean;
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.isSend = paramBoolean;
  }
  
  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }
  
  public void setToDayTo(long paramLong)
  {
    this.toDayTo = paramLong;
  }
  
  public void setUin(long paramLong)
  {
    this.uin = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"QMCardFriendInfo\",");
    if (this.email != null) {
      localStringBuilder.append("\"email\":\"").append(this.email).append("\",");
    }
    if (this.nickName != null) {
      localStringBuilder.append("\"nickName\":\"").append(this.nickName).append("\",");
    }
    if (this.birthday != null) {
      localStringBuilder.append("\"birthday\":\"").append(this.birthday).append("\",");
    }
    if (this.icon != null) {
      localStringBuilder.append("\"icon\":\"").append(this.icon).append("\",");
    }
    localStringBuilder.append("\"uin\":").append(this.uin).append(",");
    localStringBuilder.append("\"isChinese\":").append(this.isChinese).append(",");
    localStringBuilder.append("\"toDayTo\":").append(this.toDayTo).append(",");
    localStringBuilder.append("\"isSend\":").append(this.isSend).append(",");
    localStringBuilder.append("\"id\":\"").append(this.id).append("\"}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.model.QMCardFriendInfo
 * JD-Core Version:    0.7.0.1
 */