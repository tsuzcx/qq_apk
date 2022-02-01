package com.tencent.mobileqq.data;

import aalj;
import aalm;
import aaln;
import android.database.Cursor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.forceColumn;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class RecentUser
  extends BaseRecentUser
{
  public static final long FLAG_HOTCHAT = 1L;
  public static final long FLAG_PA_AD = 16L;
  public static final String TABLE_NAME = "recent";
  private static final String TAG = "RecentUser";
  public String displayName;
  @notColumn
  public Object extraInfo;
  @defaultValue(defaultInteger=0)
  public int isHiddenChat;
  @notColumn
  public int jumpTabMode;
  @defaultzero
  public long lFlag;
  @defaultzero
  public long lastmsgdrafttime;
  public long lastmsgtime;
  @notColumn
  public Object msg;
  public byte[] msgData;
  public int msgType;
  @defaultzero
  public long opTime;
  public byte[] parceledRecentBaseData;
  @defaultzero
  public long showUpTime;
  public String troopUin;
  @forceColumn
  private int type;
  public String uin;
  
  @Deprecated
  public RecentUser() {}
  
  public RecentUser(String paramString, int paramInt)
  {
    this.uin = paramString;
    this.type = paramInt;
  }
  
  public void cleanMsgAndMsgData(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUser", 2, "cleanMsgAndMsgData " + this.uin + " " + this.uin + " this.msgType " + this.msgType + " msgType " + paramInt);
    }
    if (this.msgType == paramInt)
    {
      this.msg = null;
      this.msgData = null;
      this.msgType = 0;
    }
  }
  
  public void doParse()
  {
    this.msg = aaln.a(this.msgType, this.msgData);
  }
  
  public boolean entityByCursor(Cursor paramCursor)
  {
    if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mIsParsed"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsParsed = bool;
      this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      this.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      this.displayName = paramCursor.getString(paramCursor.getColumnIndex("displayName"));
      this.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      this.lastmsgtime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgtime"));
      this.lastmsgdrafttime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgdrafttime"));
      this.msgType = paramCursor.getInt(paramCursor.getColumnIndex("msgType"));
      this.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
      this.showUpTime = paramCursor.getLong(paramCursor.getColumnIndex("showUpTime"));
      this.lFlag = paramCursor.getLong(paramCursor.getColumnIndex("lFlag"));
      this.opTime = paramCursor.getLong(paramCursor.getColumnIndex("opTime"));
      this.isHiddenChat = paramCursor.getInt(paramCursor.getColumnIndex("isHiddenChat"));
      this.parceledRecentBaseData = paramCursor.getBlob(paramCursor.getColumnIndex("parceledRecentBaseData"));
      return true;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof RecentUser)))
    {
      paramObject = (RecentUser)paramObject;
      if (this.uin == null) {
        if ((paramObject.uin != null) || (getType() != paramObject.getType())) {}
      }
      while ((this.uin.equals(paramObject.uin)) && (getType() == paramObject.getType()))
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
  
  public int getType()
  {
    return this.type;
  }
  
  public void prewrite()
  {
    this.msgData = aaln.a(this.msgType, this.msg);
    super.prewrite();
  }
  
  public void setMsgAndType(Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUser", 2, "setMsgAndType " + this.uin + " " + this.uin + " this.msgType " + this.msgType + " msgType " + paramInt);
    }
    if (paramInt >= this.msgType)
    {
      this.msg = paramObject;
      this.msgType = paramInt;
      reParse();
    }
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public boolean shouldShowInRecentList(QQAppInterface paramQQAppInterface)
  {
    if (this.msgType == 1) {
      return true;
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = ((aalm)paramQQAppInterface.getManager(366)).a(this.msgType);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.WG();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecentUser
 * JD-Core Version:    0.7.0.1
 */