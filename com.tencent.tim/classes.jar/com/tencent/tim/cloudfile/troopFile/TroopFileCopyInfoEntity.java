package com.tencent.tim.cloudfile.troopFile;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.PrimaryKeyJoinColumn;
import com.tencent.mobileqq.persistence.unique;

@PrimaryKeyJoinColumn(name="strFileID")
public class TroopFileCopyInfoEntity
  extends Entity
{
  public String cloudId;
  public long insertTime;
  public long lastRetryTime;
  public int mStatus;
  public long nFileSize;
  public int srcBizId;
  @unique
  public String strFileID;
  public String strFileName;
  public long troopUin;
  public long uploadTime;
  public long uploadUin;
  
  public boolean entityByCursor(Cursor paramCursor)
  {
    this.strFileName = paramCursor.getString(paramCursor.getColumnIndex("strFileName"));
    this.srcBizId = paramCursor.getInt(paramCursor.getColumnIndex("srcBizId"));
    this.troopUin = paramCursor.getLong(paramCursor.getColumnIndex("troopUin"));
    this.uploadUin = paramCursor.getLong(paramCursor.getColumnIndex("uploadUin"));
    this.uploadTime = paramCursor.getLong(paramCursor.getColumnIndex("uploadTime"));
    this.strFileID = paramCursor.getString(paramCursor.getColumnIndex("strFileID"));
    this.mStatus = paramCursor.getInt(paramCursor.getColumnIndex("mStatus"));
    this.nFileSize = paramCursor.getLong(paramCursor.getColumnIndex("nFileSize"));
    this.lastRetryTime = paramCursor.getLong(paramCursor.getColumnIndex("lastRetryTime"));
    this.cloudId = paramCursor.getString(paramCursor.getColumnIndex("cloudId"));
    this.insertTime = paramCursor.getLong(paramCursor.getColumnIndex("insertTime"));
    return super.entityByCursor(paramCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.troopFile.TroopFileCopyInfoEntity
 * JD-Core Version:    0.7.0.1
 */