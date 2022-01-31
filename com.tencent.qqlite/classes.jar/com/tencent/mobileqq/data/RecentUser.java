package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class RecentUser
  extends BaseRecentUser
{
  public static final String TABLE_NAME = "recent";
  public String displayName;
  @notColumn
  public int jumpTabMode;
  @defaultzero
  public long lastmsgdrafttime;
  public long lastmsgtime;
  @notColumn
  public Object msg;
  public byte[] msgData;
  public int msgType;
  @defaultzero
  public long showUpTime;
  public String troopUin;
  public int type;
  public String uin;
  
  public void cleanMsgAndMsgData(int paramInt)
  {
    if (this.msgType == paramInt)
    {
      this.msg = null;
      this.msgData = null;
      this.msgType = 0;
    }
  }
  
  public void doParse()
  {
    this.msg = RecentUserMsgFactory.a(this.msgType, this.msgData);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof RecentUser)))
    {
      paramObject = (RecentUser)paramObject;
      if (this.uin == null) {
        if ((paramObject.uin != null) || (this.type != paramObject.type)) {}
      }
      while ((this.uin.equals(paramObject.uin)) && (this.type == paramObject.type))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  public String getTableName()
  {
    return "recent";
  }
  
  protected void prewrite()
  {
    this.msgData = RecentUserMsgFactory.a(this.msgType, this.msg);
    super.prewrite();
  }
  
  public void setMsgAndType(Object paramObject, int paramInt)
  {
    if (paramInt >= this.msgType)
    {
      this.msg = paramObject;
      this.msgType = paramInt;
      reParse();
    }
  }
  
  public boolean shouldShowInRecentList()
  {
    return (this.msgType == 4) || (this.msgType == 3) || (this.msgType == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecentUser
 * JD-Core Version:    0.7.0.1
 */