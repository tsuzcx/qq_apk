package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.Utils;
import java.io.UnsupportedEncodingException;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,senderuin,msgData,istroop,shmsgseq")
public class SubAccountMessage
  extends Entity
{
  public int extInt;
  public int extLong;
  public String extStr;
  public int extraflag;
  public String frienduin;
  public boolean isValid = true;
  public boolean isread;
  public int issend;
  public int istroop;
  public int longMsgCount;
  public int longMsgId;
  public int longMsgIndex;
  @notColumn
  public String msg;
  public byte[] msgData;
  public long msgUid;
  public long msgseq;
  public int msgtype;
  public String selfuin;
  public String sendername;
  public String senderuin;
  public long shmsgseq;
  public long time;
  public long uniseq;
  public int unreadNum = 0;
  public long vipBubbleID;
  
  public static SubAccountMessage find(EntityManager paramEntityManager, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEntityManager != null)
    {
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = (SubAccountMessage)paramEntityManager.a(SubAccountMessage.class, "senderuin=?", new String[] { paramString });
      }
    }
    return localObject1;
  }
  
  public String getTableName()
  {
    return super.getTableName();
  }
  
  public void init(SubAccountMessage paramSubAccountMessage)
  {
    this.selfuin = paramSubAccountMessage.selfuin;
    this.frienduin = paramSubAccountMessage.frienduin;
    this.senderuin = paramSubAccountMessage.senderuin;
    this.sendername = paramSubAccountMessage.sendername;
    this.msg = paramSubAccountMessage.msg;
    if (paramSubAccountMessage.time <= 0L) {}
    for (long l = (int)MessageCache.a();; l = paramSubAccountMessage.time)
    {
      this.time = l;
      this.msgtype = paramSubAccountMessage.msgtype;
      this.isread = paramSubAccountMessage.isread;
      this.isValid = paramSubAccountMessage.isValid;
      return;
    }
  }
  
  protected void postRead()
  {
    try
    {
      this.msg = new String(this.msgData, "UTF-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  protected void prewrite()
  {
    if (this.msg != null) {}
    try
    {
      this.msgData = this.msg.getBytes("UTF-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubAccountMessage");
    localStringBuilder.append(",selfUin:").append(this.selfuin).append(",friendUin:").append(this.frienduin).append(",senderUin:").append(this.senderuin).append(",senderName:").append(this.sendername).append(",time:").append(this.time).append(",isRead:").append(this.isread).append(",msgType:").append(this.msgtype).append(",msg:").append(Utils.a(this.msg));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.SubAccountMessage
 * JD-Core Version:    0.7.0.1
 */