package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SuppressLint({"SimpleDateFormat"})
final class SQLiteConnection$Operation
{
  private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  public ArrayList mBindArgs;
  public int mCookie;
  public long mEndTime;
  public Exception mException;
  public boolean mFinished;
  public String mKind;
  public String mSql;
  public long mStartTime;
  public int mTid;
  public int mType;
  
  private String getFormattedStartTime()
  {
    return sDateFormat.format(new Date(this.mStartTime));
  }
  
  private String getStatus()
  {
    if (!this.mFinished) {
      return "running";
    }
    if (this.mException != null) {
      return "failed";
    }
    return "succeeded";
  }
  
  public void describe(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    paramStringBuilder.append(this.mKind);
    int i;
    label143:
    Object localObject;
    if (this.mFinished)
    {
      paramStringBuilder.append(" took ").append(this.mEndTime - this.mStartTime).append("ms");
      paramStringBuilder.append(" - ").append(getStatus());
      if (this.mSql != null) {
        paramStringBuilder.append(", sql=\"").append(SQLiteConnection.access$1500(this.mSql)).append("\"");
      }
      if (this.mTid > 0) {
        paramStringBuilder.append(", tid=").append(this.mTid);
      }
      if ((!paramBoolean) || (this.mBindArgs == null) || (this.mBindArgs.size() == 0)) {
        break label281;
      }
      paramStringBuilder.append(", bindArgs=[");
      int j = this.mBindArgs.size();
      i = 0;
      if (i >= j) {
        break label274;
      }
      localObject = this.mBindArgs.get(i);
      if (i != 0) {
        paramStringBuilder.append(", ");
      }
      if (localObject != null) {
        break label215;
      }
      paramStringBuilder.append("null");
    }
    for (;;)
    {
      i += 1;
      break label143;
      paramStringBuilder.append(" started ").append(System.currentTimeMillis() - this.mStartTime).append("ms ago");
      break;
      label215:
      if ((localObject instanceof byte[])) {
        paramStringBuilder.append("<byte[]>");
      } else if ((localObject instanceof String)) {
        paramStringBuilder.append("\"").append((String)localObject).append("\"");
      } else {
        paramStringBuilder.append(localObject);
      }
    }
    label274:
    paramStringBuilder.append("]");
    label281:
    if ((this.mException != null) && (this.mException.getMessage() != null)) {
      paramStringBuilder.append(", exception=\"").append(this.mException.getMessage()).append("\"");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection.Operation
 * JD-Core Version:    0.7.0.1
 */