package com.dataline.mpfile;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.UnsupportedEncodingException;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,msgid")
public class MpfileTaskRecord
  extends MessageRecord
  implements Cloneable
{
  public long currentSize;
  public String fileId;
  public String fileName;
  public String filePath;
  public String fileTempPath;
  public String fileTime;
  public long sessionId;
  public long totalSize;
  
  public MpfileTaskRecord()
  {
    this.selfuin = String.valueOf(AppConstants.T);
    this.frienduin = this.selfuin;
    this.senderuin = this.selfuin;
    this.istroop = 6000;
    this.versionCode = 1;
  }
  
  public static byte[] longToByte(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = Long.valueOf(0xFF & paramLong).byteValue();
      paramLong >>= 8;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] packMsgData(MpfileTaskRecord paramMpfileTaskRecord, int paramInt)
  {
    if (paramMpfileTaskRecord.msg != null) {}
    try
    {
      paramMpfileTaskRecord.msgData = paramMpfileTaskRecord.msg.getBytes("UTF-8");
      return null;
    }
    catch (UnsupportedEncodingException paramMpfileTaskRecord)
    {
      for (;;)
      {
        paramMpfileTaskRecord.printStackTrace();
      }
    }
  }
  
  public static String tableName()
  {
    return "mr_dataline_mpfile";
  }
  
  public static void unpackMsgData(MpfileTaskRecord paramMpfileTaskRecord, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramMpfileTaskRecord.msg = new String(paramArrayOfByte, "UTF-8");
      return;
    }
    catch (UnsupportedEncodingException paramMpfileTaskRecord)
    {
      paramMpfileTaskRecord.printStackTrace();
    }
  }
  
  public MpfileTaskRecord clone()
  {
    try
    {
      MpfileTaskRecord localMpfileTaskRecord = (MpfileTaskRecord)super.clone();
      return localMpfileTaskRecord;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void doPrewrite()
  {
    prewrite();
  }
  
  protected Class getClassForTable()
  {
    return MpfileTaskRecord.class;
  }
  
  public String getTableName()
  {
    return "mr_dataline_mpfile";
  }
  
  protected void postRead() {}
  
  protected void prewrite() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.mpfile.MpfileTaskRecord
 * JD-Core Version:    0.7.0.1
 */