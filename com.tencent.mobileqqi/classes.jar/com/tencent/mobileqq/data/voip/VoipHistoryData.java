package com.tencent.mobileqq.data.voip;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

public class VoipHistoryData
  extends Entity
  implements Serializable
{
  public static final int STATUS_IN_ANSWERED = 0;
  public static final int STATUS_IN_UNANSWERED = 1;
  public static final int STATUS_OUT_ANSWERED = 2;
  public static final int STATUS_OUT_UNANSWERED = 3;
  public String contactLookupId = null;
  public String countryCode = "";
  public long endTime = 0L;
  public String nickName = "";
  public String phoneNumberWithoutCountry = "";
  public long startTime = 0L;
  public byte status = -1;
  public String strContactName = "";
  public byte type = 0;
  public String uin = "";
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
    this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    this.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("direction")));
    this.type = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("type")));
    this.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
    this.phoneNumberWithoutCountry = paramCursor.getString(paramCursor.getColumnIndex("phoneNumberWithoutCountry"));
    this.countryCode = paramCursor.getString(paramCursor.getColumnIndex("countryCode"));
    this.startTime = paramCursor.getLong(paramCursor.getColumnIndex("startTime"));
    this.endTime = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
    this.contactLookupId = paramCursor.getString(paramCursor.getColumnIndex("contactLookupId"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.voip.VoipHistoryData
 * JD-Core Version:    0.7.0.1
 */