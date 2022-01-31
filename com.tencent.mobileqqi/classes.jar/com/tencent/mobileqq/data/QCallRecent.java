package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.utils.MsgUtils;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class QCallRecent
  extends Entity
{
  public static final int DISCUSS_STATE_CALL = 4;
  public static final int DISCUSS_STATE_CALLED = 3;
  public static final int DISCUSS_STATE_DOING = 1;
  public static final int DISCUSS_STATE_MISS = 2;
  public static final String TABLE_NAME = "recent_call";
  public String displayName;
  public int isVideo = 0;
  public String lastCallMsg;
  public long lastCallTime;
  public long memberCount = 0L;
  public int missedCallCount = 0;
  public int sendFlag;
  public int state = 0;
  public long time;
  public String troopUin;
  public int type = 0;
  public String uin;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (paramObject != null)
    {
      bool1 = bool3;
      if ((paramObject instanceof QCallRecent))
      {
        paramObject = (QCallRecent)paramObject;
        if (this.uin != null) {
          break label61;
        }
        if ((paramObject.uin != null) || (this.type != paramObject.type)) {
          break label56;
        }
        bool1 = bool2;
      }
    }
    label56:
    label61:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
          if ((this.uin.equals(paramObject.uin)) && (this.type == paramObject.type)) {
            break;
          }
          bool1 = bool3;
        } while (!this.uin.equals(paramObject.uin));
        bool1 = bool3;
      } while (!MsgProxyUtils.a(this.type));
      bool1 = bool3;
    } while (!MsgProxyUtils.a(paramObject.type));
    return true;
  }
  
  public int getState(QQAppInterface paramQQAppInterface)
  {
    return this.state;
  }
  
  @Deprecated
  public String getTableName()
  {
    return "recent_call";
  }
  
  public boolean isMissedCall()
  {
    return this.missedCallCount > 0;
  }
  
  public boolean isSend()
  {
    return MsgUtils.a(this.sendFlag);
  }
  
  public boolean isVideo()
  {
    return this.isVideo == 1;
  }
  
  public String toString()
  {
    return "RecentCall(" + "uin:" + this.uin + ",type:" + this.type + ",troopUin" + this.troopUin + ",sendFlag:" + this.sendFlag + ",missedCallCount:" + this.missedCallCount + ",isVideo:" + this.isVideo + ",displayName:" + this.displayName + ",lastCallTime:" + this.lastCallTime + ",lastCallMsg:" + this.lastCallMsg + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QCallRecent
 * JD-Core Version:    0.7.0.1
 */