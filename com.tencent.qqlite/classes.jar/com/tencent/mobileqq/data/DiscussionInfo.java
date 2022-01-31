package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class DiscussionInfo
  extends Entity
{
  public long DiscussionFlag = 536870912L;
  public long createTime;
  public String discussionName;
  public String faceUinSet;
  public long groupCode;
  public long groupUin;
  public boolean hasCollect = false;
  public long infoSeq;
  public int mComparePartInt;
  public String mCompareSpell;
  public String ownerUin;
  public long timeSec;
  @unique
  public String uin;
  
  public static boolean isValidDisUin(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l >= 1000000L) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    this.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
    this.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
    this.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
    this.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
    this.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
    this.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
    this.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
    this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
    this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
    this.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
    this.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("hasCollect")) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hasCollect = bool;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.DiscussionInfo
 * JD-Core Version:    0.7.0.1
 */