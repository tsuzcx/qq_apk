package com.tencent.mobileqq.utils.fts;

import com.tencent.mobileqq.data.FTSMessageDelete;
import com.tencent.mobileqq.data.FTSMessageSync;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.data.fts.FTSMessageForDel;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class FTSMessageCodec
{
  public static FTSMessageDelete a(FTSMessage paramFTSMessage)
  {
    if (paramFTSMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "codecFTSMessage ftsMessage is null");
      }
      return null;
    }
    FTSMessageDelete localFTSMessageDelete = new FTSMessageDelete();
    localFTSMessageDelete.mOpt = paramFTSMessage.mOpt;
    localFTSMessageDelete.mType = paramFTSMessage.mType;
    localFTSMessageDelete.mContent = paramFTSMessage.mContent;
    localFTSMessageDelete.mOId = paramFTSMessage.mOId;
    localFTSMessageDelete.uin = paramFTSMessage.uin;
    localFTSMessageDelete.istroop = paramFTSMessage.istroop;
    localFTSMessageDelete.senderuin = paramFTSMessage.senderuin;
    localFTSMessageDelete.msgtype = paramFTSMessage.msgtype;
    try
    {
      if (paramFTSMessage.msgExts != null) {
        localFTSMessageDelete.msgExts = ((MsgExts)paramFTSMessage.msgExts.clone());
      } else {
        localFTSMessageDelete.msgExts = null;
      }
    }
    catch (Exception paramFTSMessage)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "codecFTSMessage, ", paramFTSMessage);
      }
      localFTSMessageDelete.msgExts = null;
    }
    return localFTSMessageDelete;
  }
  
  public static FTSMessageSync a(FTSMessage paramFTSMessage)
  {
    if (paramFTSMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "codecFTSMessage ftsMessage is null");
      }
      return null;
    }
    FTSMessageSync localFTSMessageSync = new FTSMessageSync();
    localFTSMessageSync.mOpt = paramFTSMessage.mOpt;
    localFTSMessageSync.mType = paramFTSMessage.mType;
    localFTSMessageSync.mContent = paramFTSMessage.mContent;
    localFTSMessageSync.mOId = paramFTSMessage.mOId;
    localFTSMessageSync.uin = paramFTSMessage.uin;
    localFTSMessageSync.istroop = paramFTSMessage.istroop;
    localFTSMessageSync.senderuin = paramFTSMessage.senderuin;
    localFTSMessageSync.msgtype = paramFTSMessage.msgtype;
    try
    {
      if (paramFTSMessage.msgExts != null) {
        localFTSMessageSync.msgExts = ((MsgExts)paramFTSMessage.msgExts.clone());
      } else {
        localFTSMessageSync.msgExts = null;
      }
    }
    catch (Exception paramFTSMessage)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "codecFTSMessage, ", paramFTSMessage);
      }
      localFTSMessageSync.msgExts = null;
    }
    return localFTSMessageSync;
  }
  
  public static FTSMessage a(FTSMessageSync paramFTSMessageSync)
  {
    if (paramFTSMessageSync == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "decodecFTSMessage ftsMessageSync is null");
      }
      return null;
    }
    FTSMessage localFTSMessage = new FTSMessage();
    localFTSMessage.mOpt = paramFTSMessageSync.mOpt;
    localFTSMessage.mType = paramFTSMessageSync.mType;
    localFTSMessage.mContent = paramFTSMessageSync.mContent;
    localFTSMessage.mOId = paramFTSMessageSync.mOId;
    localFTSMessage.uin = paramFTSMessageSync.uin;
    localFTSMessage.istroop = paramFTSMessageSync.istroop;
    localFTSMessage.senderuin = paramFTSMessageSync.senderuin;
    localFTSMessage.msgtype = paramFTSMessageSync.msgtype;
    try
    {
      if (paramFTSMessageSync.msgExts != null) {
        localFTSMessage.msgExts = ((MsgExts)paramFTSMessageSync.msgExts.clone());
      } else {
        localFTSMessage.msgExts = null;
      }
    }
    catch (Exception paramFTSMessageSync)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "decodecFTSMessage, ", paramFTSMessageSync);
      }
      localFTSMessage.msgExts = null;
    }
    return localFTSMessage;
  }
  
  private static FTSMessage a(MessageRecord paramMessageRecord)
  {
    FTSMessage localFTSMessage = new FTSMessage();
    localFTSMessage.mType = 1;
    localFTSMessage.mContent = paramMessageRecord.getContentForSearch();
    localFTSMessage.mOId = paramMessageRecord.getId();
    localFTSMessage.uin = Long.parseLong(paramMessageRecord.frienduin);
    localFTSMessage.istroop = paramMessageRecord.istroop;
    localFTSMessage.senderuin = paramMessageRecord.senderuin;
    localFTSMessage.msgtype = paramMessageRecord.msgtype;
    return localFTSMessage;
  }
  
  public static FTSMessageForDel a(FTSMessageSync paramFTSMessageSync)
  {
    if (paramFTSMessageSync == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "decodecFTSMessage ftsMessageSync is null");
      }
      return null;
    }
    FTSMessageForDel localFTSMessageForDel = new FTSMessageForDel();
    localFTSMessageForDel.mOpt = paramFTSMessageSync.mOpt;
    localFTSMessageForDel.mType = paramFTSMessageSync.mType;
    localFTSMessageForDel.mContent = paramFTSMessageSync.mContent;
    localFTSMessageForDel.mOId = paramFTSMessageSync.mOId;
    localFTSMessageForDel.uin = paramFTSMessageSync.uin;
    localFTSMessageForDel.istroop = paramFTSMessageSync.istroop;
    localFTSMessageForDel.senderuin = paramFTSMessageSync.senderuin;
    localFTSMessageForDel.msgtype = paramFTSMessageSync.msgtype;
    try
    {
      if (paramFTSMessageSync.msgExts != null) {
        localFTSMessageForDel.msgExts = ((MsgExts)paramFTSMessageSync.msgExts.clone());
      } else {
        localFTSMessageForDel.msgExts = null;
      }
    }
    catch (Exception paramFTSMessageSync)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "decodecFTSMessage, ", paramFTSMessageSync);
      }
      localFTSMessageForDel.msgExts = null;
    }
    return localFTSMessageForDel;
  }
  
  public static Object a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    do
    {
      return null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        paramArrayOfByte = null;
        return paramArrayOfByte;
        try
        {
          if (paramArrayOfByte.length == 16) {
            paramArrayOfByte = new TextMsgExts(bytesToLong(copyOfRange(paramArrayOfByte, 0, 8)), bytesToLong(copyOfRange(paramArrayOfByte, 8, 16)));
          }
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.utils", 2, "unserialize: failure", paramArrayOfByte);
    return null;
  }
  
  public static byte[] a(Object paramObject, int paramInt)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        paramObject = null;
        return paramObject;
        try
        {
          if ((paramObject instanceof TextMsgExts))
          {
            byte[] arrayOfByte = new byte[16];
            paramObject = (TextMsgExts)paramObject;
            System.arraycopy(longToBytes(paramObject.time), 0, arrayOfByte, 0, 8);
            System.arraycopy(longToBytes(paramObject.shmsgseq), 0, arrayOfByte, 8, 8);
            paramObject = arrayOfByte;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.utils", 2, "unserialize: failure", paramObject);
    return null;
  }
  
  public static FTSMessage b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "encodeMessageRecord message is null");
      }
    }
    FTSMessage localFTSMessage;
    do
    {
      return null;
      localFTSMessage = a(paramMessageRecord);
      if (localFTSMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.utils", 2, "encodeMessageRecord message is null");
    return null;
    switch (paramMessageRecord.msgtype)
    {
    }
    for (;;)
    {
      return localFTSMessage;
      TextMsgExts localTextMsgExts = new TextMsgExts();
      localTextMsgExts.time = paramMessageRecord.time;
      localTextMsgExts.shmsgseq = paramMessageRecord.shmsgseq;
      localFTSMessage.msgExts = localTextMsgExts;
    }
  }
  
  public static long bytesToLong(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.flip();
    return localByteBuffer.getLong();
  }
  
  public static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfByte.length;
    if ((paramInt1 < 0) || (paramInt1 > i)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static byte[] longToBytes(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.putLong(paramLong);
    return localByteBuffer.array();
  }
  
  public static class MsgExts
    implements Serializable, Cloneable
  {
    protected Object clone()
      throws CloneNotSupportedException
    {
      return super.clone();
    }
  }
  
  public static class TextMsgExts
    extends FTSMessageCodec.MsgExts
    implements Cloneable
  {
    public long shmsgseq;
    public long time;
    
    public TextMsgExts() {}
    
    public TextMsgExts(long paramLong1, long paramLong2)
    {
      this.time = paramLong1;
      this.shmsgseq = paramLong2;
    }
    
    protected Object clone()
      throws CloneNotSupportedException
    {
      return super.clone();
    }
    
    public String toString()
    {
      return "TextMsgExts{time=" + this.time + ", shmsgseq=" + this.shmsgseq + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.fts.FTSMessageCodec
 * JD-Core Version:    0.7.0.1
 */