package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class ConversationInfo
  extends Entity
{
  private static final String tableName = "conversation_info";
  public long lastread;
  public int type;
  public String uin;
  public int unreadCount;
  
  public ConversationInfo() {}
  
  public ConversationInfo(String paramString, int paramInt)
  {
    this.uin = paramString;
    this.type = paramInt;
  }
  
  public ConversationInfo(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    this.uin = paramString;
    this.type = paramInt1;
    this.lastread = paramLong;
    this.unreadCount = paramInt2;
  }
  
  public static String getConversationInfoTableName()
  {
    return "conversation_info";
  }
  
  public String getTableName()
  {
    return getConversationInfoTableName();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--ConversationInfo--");
    localStringBuilder.append(",uin:").append(this.uin).append(",type:").append(this.type).append(",lastread:").append(this.lastread).append(",unreadCount:").append(this.unreadCount);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ConversationInfo
 * JD-Core Version:    0.7.0.1
 */